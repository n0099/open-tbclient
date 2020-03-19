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
/* loaded from: classes9.dex */
public class c {
    private y dHr;
    private View.OnTouchListener dus;
    private com.baidu.tieba.f.a gNH;
    private final com.baidu.tieba.homepage.concern.c.a gYA;
    private int gYB;
    private BigdaySwipeRefreshLayout gYp;
    private DataRes.Builder gYw;
    private final com.baidu.tieba.homepage.concern.a gYz;
    private final BdTypeRecyclerView gtH;
    private boolean hasMore;
    private String pageTag;
    private a gYu = null;
    private final LinkedList<m> gYv = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean gYx = false;
    private boolean gYy = false;
    private boolean mIsBackground = false;
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.dow == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEL();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.gYv.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && au.a(((com.baidu.tieba.card.data.c) next).aAj(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.gYv.size() < 9) {
                            c.this.aAa();
                            return;
                        }
                        c.this.setList(c.this.gYv);
                        c.this.gYz.notifyDataSetChanged();
                        if (c.this.gYu != null) {
                            c.this.gYu.S(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int gYF = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.dHr != null && !c.this.mIsBackground) {
                c.this.dHr.l(recyclerView, i);
            }
            if (i == 0) {
                r.bvm().bbW();
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
            if (c.this.dHr != null && !c.this.mIsBackground) {
                c.this.dHr.onScroll(this.gYF, i);
            }
            this.gYF = i;
        }
    };
    private View.OnTouchListener dsa = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.dus != null) {
                c.this.dus.onTouch(view, motionEvent);
            }
            if (c.this.gNH != null) {
                c.this.gNH.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener gYC = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gIK = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gYD = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bNA();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void Cd(String str);

        void S(boolean z, boolean z2);

        void bNw();

        void bNx();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lz(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gtH = bdTypeRecyclerView;
        this.gtH.setOnTouchListener(this.dsa);
        this.gNH = new com.baidu.tieba.f.a();
        this.gYA = new com.baidu.tieba.homepage.concern.c.a();
        this.gYz = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gYp = bigdaySwipeRefreshLayout;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.gYC.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gYC);
        this.gIK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gIK);
        this.gYD.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gYD);
        this.dat.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dat);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dHr = zVar.aSt();
            this.dus = zVar.aSu();
        }
    }

    public void update() {
        if (this.gYv.size() == 0 && !this.gYx) {
            aAb();
        } else {
            aAa();
        }
    }

    public void bNy() {
        aAa();
    }

    public void bck() {
        if (!isLoading() && this.hasMore && this.gYu != null) {
            setIsLoading(true);
            this.gYu.Cd(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.getCount(this.gYv) == 0 && this.gYu != null) {
                this.gYu.bNx();
                if (this.gYp != null) {
                    this.gYp.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.gYv.size() > 0) {
                if (this.gYu != null) {
                    this.gYu.onError(1, str);
                }
            } else if (this.gYu != null) {
                this.gYu.onError(2, str);
            }
        } else {
            if (this.gYu != null) {
                this.gYu.S(z, false);
            }
            byP();
        }
        if (this.gYp != null) {
            this.gYp.setRefreshing(false);
        }
    }

    public void mD(boolean z) {
        if (z) {
            this.gYz.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAa() {
        if (this.gYu != null) {
            this.gYu.bNw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.gYx = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.gYu != null) {
                    this.gYu.S(false, true);
                    return;
                }
                return;
            }
            aAa();
            return;
        }
        aAa();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.gYw == null) {
            this.gYw = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gYA.a(z, this.gYw, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.dTH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<m> list) {
        this.gYz.ac(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        m mVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.gYB = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        this.gYy = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.gYB) {
                if (v.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gYy = true;
                } else if (v.getCount(a2) == 1 && (v.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gYy = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips) && 2 == this.gYB) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.gZC = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.gZD = true;
            } else {
                cVar.gZE = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.isEmpty(linkedList)) {
            if (this.gYv.isEmpty()) {
                return false;
            }
            Iterator<m> it = this.gYv.iterator();
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
                this.gYv.remove(mVar);
            }
            this.gYz.ac(this.gYv);
            return false;
        }
        this.gYv.clear();
        this.gYv.addAll(linkedList);
        if (z2) {
            this.gYw.page_tag = dataRes.page_tag;
            this.gYw.has_more = dataRes.has_more;
            this.gYw.user_list = dataRes.user_list;
            this.gYw.user_tips_type = dataRes.user_tips_type;
            this.gYw.user_tips = dataRes.user_tips;
            this.gYw.last_tips = dataRes.last_tips;
        }
        this.gYw.banner_user_story = dataRes.banner_user_story;
        this.gYw.banner_follow_live = dataRes.banner_follow_live;
        this.gYw.top_tips = dataRes.top_tips;
        this.gYw.top_user_info = dataRes.top_user_info;
        if (this.gYB == 2 || this.gYB == 3) {
            this.gYw.user_tips_type = dataRes.user_tips_type;
            this.gYw.user_tips = dataRes.user_tips;
        }
        this.gYz.ac(this.gYv);
        return true;
    }

    private void aAb() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bNB */
            public DataRes doInBackground() {
                l<byte[]> cp = com.baidu.tbadk.core.c.a.aEF().cp("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (cp == null) {
                    return null;
                }
                byte[] bArr = cp.get("0");
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

    private void byP() {
        if (this.gYw != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gYw.build(true));
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
                    com.baidu.tbadk.core.c.a.aEF().cp("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.gYu = aVar;
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

    public boolean bNz() {
        return this.gYy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gYw != null && v.getCount(this.gYw.thread_info) != 0 && v.getCount(this.gYv) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<m> it = this.gYv.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.aAj() != null && cVar.aAj().getTid() != null) {
                            if (cVar.aAj().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.gYz != null) {
                                    this.gYz.ac(this.gYv);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.gYw.thread_info.size(); i++) {
                    ConcernData concernData = this.gYw.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.gYw.thread_info.remove(i);
                        byP();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNA() {
        if (this.gYw != null && v.getCount(this.gYw.thread_info) != 0 && v.getCount(this.gYv) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.gYv.size()) {
                    break;
                } else if (!(this.gYv.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.gYv.remove(i);
                    if (this.gYz != null) {
                        this.gYz.ac(this.gYv);
                    }
                }
            }
            for (int i2 = 0; i2 < this.gYw.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.gYw.thread_info.get(i2))) {
                    this.gYw.thread_info.remove(i2);
                    byP();
                    return;
                }
            }
        }
    }
}
