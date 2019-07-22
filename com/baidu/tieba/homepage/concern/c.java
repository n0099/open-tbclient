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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.card.t;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class c {
    private w cDk;
    private View.OnTouchListener coO;
    private com.baidu.tieba.f.a fRt;
    private final BdTypeRecyclerView fyz;
    private BigdaySwipeRefreshLayout gcc;
    private com.baidu.tieba.homepage.concern.b.a gci;
    private com.baidu.tieba.homepage.concern.b.b gcj;
    private DataRes.Builder gck;
    private final com.baidu.tieba.homepage.concern.a gcm;
    private final com.baidu.tieba.homepage.concern.c.a gcn;
    private int gco;
    private boolean hasMore;
    private String pageTag;
    private a gch = null;
    private final List<m> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean gcl = false;
    private boolean mIsBackground = false;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.1
        private int gcq = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.cDk != null && !c.this.mIsBackground) {
                c.this.cDk.i(recyclerView, i);
            }
            if (i == 0) {
                t.aZN().aHX();
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
            if (c.this.cDk != null && !c.this.mIsBackground) {
                c.this.cDk.onScroll(this.gcq, i);
            }
            this.gcq = i;
        }
    };
    private View.OnTouchListener cmp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.coO != null) {
                c.this.coO.onTouch(view, motionEvent);
            }
            if (c.this.fRt != null) {
                c.this.fRt.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0299a eac = new a.InterfaceC0299a() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // com.baidu.tieba.f.a.InterfaceC0299a
        public void aY(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0299a
        public void aZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0299a
        public void ba(int i, int i2) {
        }
    };
    private CustomMessageListener gcp = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fMQ = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void O(boolean z, boolean z2);

        void buV();

        void buW();

        void onError(int i, String str);

        void xV(String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void kc(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.fyz = bdTypeRecyclerView;
        this.fyz.setOnTouchListener(this.cmp);
        this.fRt = new com.baidu.tieba.f.a();
        this.gcn = new com.baidu.tieba.homepage.concern.c.a();
        this.fRt.a(this.eac);
        this.gcm = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gcc = bigdaySwipeRefreshLayout;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.gcp.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gcp);
        this.fMQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fMQ);
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.cDk = xVar.aww();
            this.coO = xVar.awx();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.gcl) {
            acq();
        } else {
            acp();
        }
    }

    public void buX() {
        acp();
    }

    public void aIQ() {
        if (!pP() && this.hasMore && this.gch != null) {
            setIsLoading(true);
            this.gch.xV(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.Z(this.mDataList) == 0 && this.gch != null) {
                this.gch.buW();
                if (this.gcc != null) {
                    this.gcc.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.gch != null) {
                    this.gch.onError(1, str);
                }
            } else if (this.gch != null) {
                this.gch.onError(2, str);
            }
        } else {
            if (this.gch != null) {
                this.gch.O(z, false);
            }
            bgf();
        }
        if (this.gcc != null) {
            this.gcc.setRefreshing(false);
        }
    }

    public void lg(boolean z) {
        if (z) {
            this.gcm.notifyDataSetChanged();
        }
    }

    private void acp() {
        if (this.gch != null) {
            this.gch.buV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.gcl = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.gch != null) {
                    this.gch.O(false, true);
                    return;
                }
                return;
            }
            acp();
            return;
        }
        acp();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.gck == null) {
            this.gck = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gcn.a(z, this.gck, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.cRs;
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        this.mDataList.clear();
        if (z2) {
            this.gci = null;
            this.gcj = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_follow_live != null && dataRes.banner_follow_live._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
            bVar.a(dataRes.banner_follow_live);
            if (!v.aa(bVar.getList())) {
                this.mDataList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
            this.gco = builder.user_tips_type.intValue();
            aVar.gcU = builder.user_tips_type.intValue();
            aVar.bXm = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                aVar.gcV = true;
            } else {
                aVar.gcW = true;
            }
            this.mDataList.add(aVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.aa(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.gck.page_tag = dataRes.page_tag;
            this.gck.has_more = dataRes.has_more;
            this.gck.user_list = dataRes.user_list;
            this.gck.user_tips_type = dataRes.user_tips_type;
            this.gck.user_tips = dataRes.user_tips;
            this.gck.last_tips = dataRes.last_tips;
        }
        this.gck.banner_user_story = dataRes.banner_user_story;
        this.gck.banner_follow_live = dataRes.banner_follow_live;
        this.gck.top_tips = dataRes.top_tips;
        this.gck.top_user_info = dataRes.top_user_info;
        if (this.gco == 2 || this.gco == 3) {
            this.gck.user_tips_type = dataRes.user_tips_type;
            this.gck.user_tips = dataRes.user_tips;
        }
        this.gcm.aF(this.mDataList);
        return true;
    }

    private void acq() {
        aa.a(new z<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: buY */
            public DataRes doInBackground() {
                l<byte[]> bD = com.baidu.tbadk.core.d.a.agF().bD("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (bD == null) {
                    return null;
                }
                byte[] bArr = bD.get("0");
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
        }, new k<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                c.this.a(dataRes);
            }
        });
    }

    private void bgf() {
        if (this.gck != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gck.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            a(builder);
        }
    }

    private void a(final DataRes.Builder builder) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.concern.c.6
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.d.a.agF().bD("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.gch = aVar;
    }

    private boolean pP() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gck != null && v.Z(this.gck.thread_info) != 0 && v.Z(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                int i = 0;
                while (true) {
                    if (i >= this.mDataList.size()) {
                        break;
                    }
                    m mVar = this.mDataList.get(i);
                    if (mVar instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) mVar;
                        if (cVar.acx() != null && cVar.acx().getTid() != null && cVar.acx().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.gcm != null) {
                                this.gcm.aF(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.gck.thread_info.size(); i2++) {
                    ConcernData concernData = this.gck.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.gck.thread_info.remove(i2);
                        bgf();
                        return;
                    }
                }
            }
        }
    }
}
