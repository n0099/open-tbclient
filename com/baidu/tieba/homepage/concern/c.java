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
    private y dGN;
    private View.OnTouchListener dtR;
    private com.baidu.tieba.f.a gMo;
    private BigdaySwipeRefreshLayout gWU;
    private DataRes.Builder gXb;
    private final com.baidu.tieba.homepage.concern.a gXe;
    private final com.baidu.tieba.homepage.concern.c.a gXf;
    private int gXg;
    private final BdTypeRecyclerView gsO;
    private boolean hasMore;
    private String pageTag;
    private a gWZ = null;
    private final LinkedList<m> gXa = new LinkedList<>();
    private boolean mIsLoading = false;
    private boolean gXc = false;
    private boolean gXd = false;
    private boolean mIsBackground = false;
    private CustomMessageListener dae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.dnT == null) {
                    if (!data.isSucc) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEF();
                    } else if (!data.isAttention) {
                        Iterator it = c.this.gXa.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof com.baidu.tieba.card.data.c) && au.a(((com.baidu.tieba.card.data.c) next).aAe(), data.toUid)) {
                                it.remove();
                            }
                        }
                        if (c.this.gXa.size() < 9) {
                            c.this.azV();
                            return;
                        }
                        c.this.setList(c.this.gXa);
                        c.this.gXe.notifyDataSetChanged();
                        if (c.this.gWZ != null) {
                            c.this.gWZ.S(false, false);
                        }
                    }
                }
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        private int gXk = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.dGN != null && !c.this.mIsBackground) {
                c.this.dGN.l(recyclerView, i);
            }
            if (i == 0) {
                r.bve().bbP();
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
            if (c.this.dGN != null && !c.this.mIsBackground) {
                c.this.dGN.onScroll(this.gXk, i);
            }
            this.gXk = i;
        }
    };
    private View.OnTouchListener drz = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.dtR != null) {
                c.this.dtR.onTouch(view, motionEvent);
            }
            if (c.this.gMo != null) {
                c.this.gMo.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private CustomMessageListener gXh = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gHy = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener gXi = new CustomMessageListener(2921425) { // from class: com.baidu.tieba.homepage.concern.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bNj();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void Cc(String str);

        void S(boolean z, boolean z2);

        void bNf();

        void bNg();

        void onError(int i, String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void lt(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gsO = bdTypeRecyclerView;
        this.gsO.setOnTouchListener(this.drz);
        this.gMo = new com.baidu.tieba.f.a();
        this.gXf = new com.baidu.tieba.homepage.concern.c.a();
        this.gXe = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gWU = bigdaySwipeRefreshLayout;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.gXh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gXh);
        this.gHy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gHy);
        this.gXi.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gXi);
        this.dae.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dae);
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (zVar != null) {
            this.dGN = zVar.aSm();
            this.dtR = zVar.aSn();
        }
    }

    public void update() {
        if (this.gXa.size() == 0 && !this.gXc) {
            azW();
        } else {
            azV();
        }
    }

    public void bNh() {
        azV();
    }

    public void bcd() {
        if (!isLoading() && this.hasMore && this.gWZ != null) {
            setIsLoading(true);
            this.gWZ.Cc(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.getCount(this.gXa) == 0 && this.gWZ != null) {
                this.gWZ.bNg();
                if (this.gWU != null) {
                    this.gWU.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.gXa.size() > 0) {
                if (this.gWZ != null) {
                    this.gWZ.onError(1, str);
                }
            } else if (this.gWZ != null) {
                this.gWZ.onError(2, str);
            }
        } else {
            if (this.gWZ != null) {
                this.gWZ.S(z, false);
            }
            byG();
        }
        if (this.gWU != null) {
            this.gWU.setRefreshing(false);
        }
    }

    public void mx(boolean z) {
        if (z) {
            this.gXe.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azV() {
        if (this.gWZ != null) {
            this.gWZ.bNf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.gXc = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.gWZ != null) {
                    this.gWZ.S(false, true);
                    return;
                }
                return;
            }
            azV();
            return;
        }
        azV();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.gXb == null) {
            this.gXb = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gXf.a(z, this.gXb, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.dTd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(List<m> list) {
        this.gXe.ac(list);
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        m mVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.gXg = builder.user_tips_type.intValue();
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.aFB().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        this.gXd = false;
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            if (3 == this.gXg) {
                if (v.isEmpty(a2)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gXd = true;
                } else if (v.getCount(a2) == 1 && (v.getItem(a2, 0) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    a2.add(new com.baidu.tieba.homepage.concern.b.a());
                    this.gXd = true;
                }
            }
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips) && 2 == this.gXg) {
            com.baidu.tieba.homepage.concern.b.c cVar = new com.baidu.tieba.homepage.concern.b.c();
            cVar.gYh = builder.user_tips_type.intValue();
            cVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                cVar.gYi = true;
            } else {
                cVar.gYj = true;
            }
            linkedList.add(cVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.isEmpty(linkedList)) {
            if (this.gXa.isEmpty()) {
                return false;
            }
            Iterator<m> it = this.gXa.iterator();
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
                this.gXa.remove(mVar);
            }
            this.gXe.ac(this.gXa);
            return false;
        }
        this.gXa.clear();
        this.gXa.addAll(linkedList);
        if (z2) {
            this.gXb.page_tag = dataRes.page_tag;
            this.gXb.has_more = dataRes.has_more;
            this.gXb.user_list = dataRes.user_list;
            this.gXb.user_tips_type = dataRes.user_tips_type;
            this.gXb.user_tips = dataRes.user_tips;
            this.gXb.last_tips = dataRes.last_tips;
        }
        this.gXb.banner_user_story = dataRes.banner_user_story;
        this.gXb.banner_follow_live = dataRes.banner_follow_live;
        this.gXb.top_tips = dataRes.top_tips;
        this.gXb.top_user_info = dataRes.top_user_info;
        if (this.gXg == 2 || this.gXg == 3) {
            this.gXb.user_tips_type = dataRes.user_tips_type;
            this.gXb.user_tips = dataRes.user_tips;
        }
        this.gXe.ac(this.gXa);
        return true;
    }

    private void azW() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bNk */
            public DataRes doInBackground() {
                l<byte[]> cq = com.baidu.tbadk.core.c.a.aEz().cq("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (cq == null) {
                    return null;
                }
                byte[] bArr = cq.get("0");
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

    private void byG() {
        if (this.gXb != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gXb.build(true));
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
                    com.baidu.tbadk.core.c.a.aEz().cq("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.gWZ = aVar;
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

    public boolean bNi() {
        return this.gXd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gXb != null && v.getCount(this.gXb.thread_info) != 0 && v.getCount(this.gXa) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                Iterator<m> it = this.gXa.iterator();
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.aAe() != null && cVar.aAe().getTid() != null) {
                            if (cVar.aAe().getTid().equals(optString)) {
                                z = true;
                                it.remove();
                            } else if (z) {
                                if (this.gXe != null) {
                                    this.gXe.ac(this.gXa);
                                }
                            }
                        }
                    }
                    z = z;
                }
                long j = com.baidu.adp.lib.f.b.toLong(optString, 0L);
                for (int i = 0; i < this.gXb.thread_info.size(); i++) {
                    ConcernData concernData = this.gXb.thread_info.get(i);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.gXb.thread_info.remove(i);
                        byG();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNj() {
        if (this.gXb != null && v.getCount(this.gXb.thread_info) != 0 && v.getCount(this.gXa) != 0) {
            int i = 0;
            while (true) {
                if (i >= this.gXa.size()) {
                    break;
                } else if (!(this.gXa.get(i) instanceof com.baidu.tieba.homepage.concern.b.b)) {
                    i++;
                } else {
                    this.gXa.remove(i);
                    if (this.gXe != null) {
                        this.gXe.ac(this.gXa);
                    }
                }
            }
            for (int i2 = 0; i2 < this.gXb.thread_info.size(); i2++) {
                if (com.baidu.tieba.homepage.concern.b.b.a(this.gXb.thread_info.get(i2))) {
                    this.gXb.thread_info.remove(i2);
                    byG();
                    return;
                }
            }
        }
    }
}
