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
import com.baidu.tbadk.core.util.ap;
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
    private w cBT;
    private View.OnTouchListener cnC;
    private com.baidu.tieba.f.a fMw;
    private BigdaySwipeRefreshLayout fXf;
    private com.baidu.tieba.homepage.concern.b.a fXl;
    private com.baidu.tieba.homepage.concern.b.b fXm;
    private DataRes.Builder fXn;
    private final com.baidu.tieba.homepage.concern.a fXp;
    private final com.baidu.tieba.homepage.concern.c.a fXq;
    private int fXr;
    private final BdTypeRecyclerView ftD;
    private boolean hasMore;
    private String pageTag;
    private a fXk = null;
    private final List<m> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean fXo = false;
    private boolean mIsBackground = false;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.1
        private int fXt = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.cBT != null && !c.this.mIsBackground) {
                c.this.cBT.i(recyclerView, i);
            }
            if (i == 0) {
                t.aXP().aGA();
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
            if (c.this.cBT != null && !c.this.mIsBackground) {
                c.this.cBT.onScroll(this.fXt, i);
            }
            this.fXt = i;
        }
    };
    private View.OnTouchListener clc = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.cnC != null) {
                c.this.cnC.onTouch(view, motionEvent);
            }
            if (c.this.fMw != null) {
                c.this.fMw.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0302a dWk = new a.InterfaceC0302a() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aV(int i, int i2) {
        }
    };
    private CustomMessageListener fXs = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fHS = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void L(boolean z, boolean z2);

        void bsU();

        void onError(int i, String str);

        void onUpdate();

        void xq(String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void jS(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.ftD = bdTypeRecyclerView;
        this.ftD.setOnTouchListener(this.clc);
        this.fMw = new com.baidu.tieba.f.a();
        this.fXq = new com.baidu.tieba.homepage.concern.c.a();
        this.fMw.a(this.dWk);
        this.fXp = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.fXf = bigdaySwipeRefreshLayout;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fXs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fXs);
        this.fHS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fHS);
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.cBT = xVar.avn();
            this.cnC = xVar.avo();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.fXo) {
            abr();
        } else {
            abq();
        }
    }

    public void bsV() {
        abq();
    }

    public void aHt() {
        if (!pu() && this.hasMore && this.fXk != null) {
            setIsLoading(true);
            this.fXk.xq(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && v.Z(this.mDataList) == 0 && this.fXk != null) {
                this.fXk.bsU();
                if (this.fXf != null) {
                    this.fXf.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.fXk != null) {
                    this.fXk.onError(1, str);
                }
            } else if (this.fXk != null) {
                this.fXk.onError(2, str);
            }
        } else {
            if (this.fXk != null) {
                this.fXk.L(z, false);
            }
            bec();
        }
        if (this.fXf != null) {
            this.fXf.setRefreshing(false);
        }
    }

    public void kW(boolean z) {
        if (z) {
            this.fXp.notifyDataSetChanged();
        }
    }

    private void abq() {
        if (this.fXk != null) {
            this.fXk.onUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.fXo = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.fXk != null) {
                    this.fXk.L(false, true);
                    return;
                }
                return;
            }
            abq();
            return;
        }
        abq();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.fXn == null) {
            this.fXn = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.fXq.a(z, this.fXn, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.cPW;
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        this.mDataList.clear();
        if (z2) {
            this.fXl = null;
            this.fXm = null;
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
            com.baidu.tbadk.core.sharedPref.b.agM().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            this.mDataList.addAll(a2);
        }
        if (!ap.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
            this.fXr = builder.user_tips_type.intValue();
            aVar.fXX = builder.user_tips_type.intValue();
            aVar.bWk = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                aVar.fXY = true;
            } else {
                aVar.fXZ = true;
            }
            this.mDataList.add(aVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (v.aa(this.mDataList)) {
            return false;
        }
        if (z2) {
            this.fXn.page_tag = dataRes.page_tag;
            this.fXn.has_more = dataRes.has_more;
            this.fXn.user_list = dataRes.user_list;
            this.fXn.user_tips_type = dataRes.user_tips_type;
            this.fXn.user_tips = dataRes.user_tips;
            this.fXn.last_tips = dataRes.last_tips;
        }
        this.fXn.banner_user_story = dataRes.banner_user_story;
        this.fXn.banner_follow_live = dataRes.banner_follow_live;
        this.fXn.top_tips = dataRes.top_tips;
        this.fXn.top_user_info = dataRes.top_user_info;
        if (this.fXr == 2 || this.fXr == 3) {
            this.fXn.user_tips_type = dataRes.user_tips_type;
            this.fXn.user_tips = dataRes.user_tips;
        }
        this.fXp.aF(this.mDataList);
        return true;
    }

    private void abr() {
        aa.a(new z<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bsW */
            public DataRes doInBackground() {
                l<byte[]> bD = com.baidu.tbadk.core.c.a.afD().bD("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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

    private void bec() {
        if (this.fXn != null) {
            DataRes.Builder builder = new DataRes.Builder(this.fXn.build(true));
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
                    com.baidu.tbadk.core.c.a.afD().bD("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.fXk = aVar;
    }

    private boolean pu() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.fXn != null && v.Z(this.fXn.thread_info) != 0 && v.Z(this.mDataList) != 0) {
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
                        if (cVar.abv() != null && cVar.abv().getTid() != null && cVar.abv().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.fXp != null) {
                                this.fXp.aF(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.fXn.thread_info.size(); i2++) {
                    ConcernData concernData = this.fXn.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.fXn.thread_info.remove(i2);
                        bec();
                        return;
                    }
                }
            }
        }
    }
}
