package com.baidu.tieba.homepage.concern;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class c {
    private y dCz;
    private View.OnTouchListener dpy;
    private com.baidu.tieba.f.a gHa;
    private DataRes.Builder gRG;
    private final com.baidu.tieba.homepage.concern.a gRJ;
    private final com.baidu.tieba.homepage.concern.c.a gRK;
    private int gRL;
    private BigdaySwipeRefreshLayout gRz;
    private final BdTypeRecyclerView gnE;
    private boolean hasMore;
    private String pageTag;
    private a gRE = null;
    private final LinkedList<m> gRF = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean gRH = false;
    private boolean gRI = false;
    private boolean mIsBackground = false;
    private CustomMessageListener cVS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.djy == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCb();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.gRF.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && au.a(((com.baidu.tieba.card.data.c) next).axx(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.gRF.size() < 9) {
                            c.this.axo();
                            return;
                        }
                        c.this.setList(c.this.gRF);
                        c.this.gRJ.notifyDataSetChanged();
                        if (c.this.gRE != null) {
                            c.this.gRE.Q(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int gRP = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.dCz != null && !c.this.mIsBackground) {
                c.this.dCz.l(recyclerView, i);
            }
            if (i == 0) {
                r.bsy().aZg();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4 = 0;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
            } else {
                i3 = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i4 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            onScroll(i3, (i4 - i3) + 1);
        }

        public void onScroll(int i, int i2) {
            if (c.this.dCz != null && !c.this.mIsBackground) {
                c.this.dCz.onScroll(this.gRP, i);
            }
            this.gRP = i;
        }
    };
    private View.OnTouchListener dne = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.dpy != null) {
                c.this.dpy.onTouch(view, motionEvent);
            }
            if (c.this.gHa != null) {
                c.this.gHa.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener gRM = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gCk = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gRN = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bKB();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void BC(String str);

        void Q(boolean z, boolean z2);

        void bKx();

        void bKy();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lf(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gnE = bdTypeRecyclerView;
        this.gnE.setOnTouchListener(this.dne);
        this.gHa = new com.baidu.tieba.f.a();
        this.gRK = new com.baidu.tieba.homepage.concern.c.a();
        this.gRJ = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gRz = bigdaySwipeRefreshLayout;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.gRM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gRM);
        this.gCk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gCk);
        this.gRN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gRN);
        this.cVS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cVS);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dCz = zVar.aPC();
            this.dpy = zVar.aPD();
        }
    }

    public void update() {
        if (this.gRF.size() == 0 && !this.gRH) {
            axp();
        } else {
            axo();
        }
    }

    public void bKz() {
        axo();
    }

    public void aZs() {
        if (!isLoading() && this.hasMore && this.gRE != null) {
            setIsLoading(true);
            this.gRE.BC(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.getCount(this.gRF) == 0 && this.gRE != null) {
                this.gRE.bKy();
                if (this.gRz != null) {
                    this.gRz.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.gRF.size() > 0) {
                if (this.gRE != null) {
                    this.gRE.onError(1, str);
                }
            } else if (this.gRE != null) {
                this.gRE.onError(2, str);
            }
        } else {
            if (this.gRE != null) {
                this.gRE.Q(z, false);
            }
            bvZ();
        }
        if (this.gRz != null) {
            this.gRz.setRefreshing(false);
        }
    }

    public void mk(boolean z) {
        if (z) {
            this.gRJ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axo() {
        if (this.gRE != null) {
            this.gRE.bKx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.gRH = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.gRE != null) {
                    this.gRE.Q(false, true);
                    return;
                }
                return;
            }
            axo();
            return;
        }
        axo();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.gRG == null) {
            this.gRG = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gRK.a(z, this.gRG, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.dOP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<m> list) {
        this.gRJ.ad(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        m mVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.gRL = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aCY().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        this.gRI = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.gRL) {
                if (v.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gRI = true;
                } else if (v.getCount(a2) == 1 && (v.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gRI = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips) && 2 == this.gRL) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.gSM = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.gSN = true;
            } else {
                cVar.gSO = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.isEmpty(linkedList)) {
            if (this.gRF.isEmpty()) {
                return false;
            }
            Iterator<m> it = this.gRF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    mVar = null;
                    break;
                }
                mVar = it.next();
                if (mVar instanceof com.baidu.tbadk.data.a) {
                    break;
                }
            }
            if (mVar != null) {
                this.gRF.remove(mVar);
            }
            this.gRJ.ad(this.gRF);
            return false;
        }
        this.gRF.clear();
        this.gRF.addAll(linkedList);
        if (z2) {
            this.gRG.page_tag = dataRes.page_tag;
            this.gRG.has_more = dataRes.has_more;
            this.gRG.user_list = dataRes.user_list;
            this.gRG.user_tips_type = dataRes.user_tips_type;
            this.gRG.user_tips = dataRes.user_tips;
            this.gRG.last_tips = dataRes.last_tips;
        }
        this.gRG.banner_user_story = dataRes.banner_user_story;
        this.gRG.banner_follow_live = dataRes.banner_follow_live;
        this.gRG.top_tips = dataRes.top_tips;
        this.gRG.top_user_info = dataRes.top_user_info;
        if (this.gRL == 2 || this.gRL == 3) {
            this.gRG.user_tips_type = dataRes.user_tips_type;
            this.gRG.user_tips = dataRes.user_tips;
        }
        this.gRJ.ad(this.gRF);
        return true;
    }

    private void axp() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bKC */
            public DataRes doInBackground() {
                l<byte[]> ch = com.baidu.tbadk.core.c.a.aBV().ch("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (ch == null) {
                    return null;
                }
                byte[] bArr = ch.get("0");
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                c.this.a(dataRes);
            }
        });
    }

    private void bvZ() {
        if (this.gRG != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gRG.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            a(builder);
        }
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.concern.c.6
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aBV().ch("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.gRE = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public boolean bKA() {
        return this.gRI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gRG != null && v.getCount(this.gRG.thread_info) != 0 && v.getCount(this.gRF) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<m> it = this.gRF.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.axx() != null && cVar.axx().getTid() != null) {
                            if (cVar.axx().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.gRJ != null) {
                                    this.gRJ.ad(this.gRF);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.gRG.thread_info.size(); i++) {
                    ConcernData concernData = this.gRG.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.gRG.thread_info.remove(i);
                        bvZ();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKB() {
        if (this.gRG != null && v.getCount(this.gRG.thread_info) != 0 && v.getCount(this.gRF) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.gRF.size()) {
                    break;
                } else if (!(this.gRF.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.gRF.remove(i);
                    if (this.gRJ != null) {
                        this.gRJ.ad(this.gRF);
                    }
                }
            }
            for (int i2 = 0; i2 < this.gRG.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.gRG.thread_info.get(i2))) {
                    this.gRG.thread_info.remove(i2);
                    bvZ();
                    return;
                }
            }
        }
    }
}
