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
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.y;
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
    private v cEi;
    private View.OnTouchListener cpQ;
    private final BdTypeRecyclerView fAL;
    private com.baidu.tieba.f.a fTY;
    private BigdaySwipeRefreshLayout geK;
    private com.baidu.tieba.homepage.concern.b.a geQ;
    private com.baidu.tieba.homepage.concern.b.b geR;
    private DataRes.Builder geS;
    private final com.baidu.tieba.homepage.concern.a geU;
    private final com.baidu.tieba.homepage.concern.c.a geV;
    private int geW;
    private boolean hasMore;
    private String pageTag;
    private a geP = null;
    private final List<m> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean geT = false;
    private boolean mIsBackground = false;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.1
        private int geY = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.cEi != null && !c.this.mIsBackground) {
                c.this.cEi.i(recyclerView, i);
            }
            if (i == 0) {
                t.bat().aID();
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
            if (c.this.cEi != null && !c.this.mIsBackground) {
                c.this.cEi.onScroll(this.geY, i);
            }
            this.geY = i;
        }
    };
    private View.OnTouchListener cnr = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.cpQ != null) {
                c.this.cpQ.onTouch(view, motionEvent);
            }
            if (c.this.fTY != null) {
                c.this.fTY.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0316a ebT = new a.InterfaceC0316a() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aY(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void ba(int i, int i2) {
        }
    };
    private CustomMessageListener geX = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fPu = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void O(boolean z, boolean z2);

        void bvW();

        void bvX();

        void onError(int i, String str);

        void yv(String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void kf(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.fAL = bdTypeRecyclerView;
        this.fAL.setOnTouchListener(this.cnr);
        this.fTY = new com.baidu.tieba.f.a();
        this.geV = new com.baidu.tieba.homepage.concern.c.a();
        this.fTY.a(this.ebT);
        this.geU = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.geK = bigdaySwipeRefreshLayout;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.geX.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.geX);
        this.fPu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fPu);
    }

    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        if (wVar != null) {
            this.cEi = wVar.awK();
            this.cpQ = wVar.awL();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.geT) {
            acu();
        } else {
            act();
        }
    }

    public void bvY() {
        act();
    }

    public void aJw() {
        if (!pQ() && this.hasMore && this.geP != null) {
            setIsLoading(true);
            this.geP.yv(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.v.Z(this.mDataList) == 0 && this.geP != null) {
                this.geP.bvX();
                if (this.geK != null) {
                    this.geK.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.geP != null) {
                    this.geP.onError(1, str);
                }
            } else if (this.geP != null) {
                this.geP.onError(2, str);
            }
        } else {
            if (this.geP != null) {
                this.geP.O(z, false);
            }
            bgO();
        }
        if (this.geK != null) {
            this.geK.setRefreshing(false);
        }
    }

    public void lj(boolean z) {
        if (z) {
            this.geU.notifyDataSetChanged();
        }
    }

    private void act() {
        if (this.geP != null) {
            this.geP.bvW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.geT = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.geP != null) {
                    this.geP.O(false, true);
                    return;
                }
                return;
            }
            act();
            return;
        }
        act();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.geS == null) {
            this.geS = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.geV.a(z, this.geS, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.cSs;
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        if (z2) {
            this.geQ = null;
            this.geR = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_follow_live != null && dataRes.banner_follow_live._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
            bVar.a(dataRes.banner_follow_live);
            if (!com.baidu.tbadk.core.util.v.aa(bVar.getList())) {
                linkedList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
            this.geW = builder.user_tips_type.intValue();
            aVar.gfC = builder.user_tips_type.intValue();
            aVar.bYl = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                aVar.gfD = true;
            } else {
                aVar.gfE = true;
            }
            linkedList.add(aVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.v.aa(linkedList)) {
            if (this.mDataList.isEmpty()) {
                return false;
            }
            m mVar = null;
            for (m mVar2 : this.mDataList) {
                if (!(mVar2 instanceof com.baidu.tbadk.data.b)) {
                    mVar2 = mVar;
                }
                mVar = mVar2;
            }
            if (mVar != null) {
                this.mDataList.remove(mVar);
                return false;
            }
            return false;
        }
        this.mDataList.clear();
        this.mDataList.addAll(linkedList);
        if (z2) {
            this.geS.page_tag = dataRes.page_tag;
            this.geS.has_more = dataRes.has_more;
            this.geS.user_list = dataRes.user_list;
            this.geS.user_tips_type = dataRes.user_tips_type;
            this.geS.user_tips = dataRes.user_tips;
            this.geS.last_tips = dataRes.last_tips;
        }
        this.geS.banner_user_story = dataRes.banner_user_story;
        this.geS.banner_follow_live = dataRes.banner_follow_live;
        this.geS.top_tips = dataRes.top_tips;
        this.geS.top_user_info = dataRes.top_user_info;
        if (this.geW == 2 || this.geW == 3) {
            this.geS.user_tips_type = dataRes.user_tips_type;
            this.geS.user_tips = dataRes.user_tips;
        }
        this.geU.aF(this.mDataList);
        return true;
    }

    private void acu() {
        z.a(new y<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: bvZ */
            public DataRes doInBackground() {
                l<byte[]> bD = com.baidu.tbadk.core.d.a.agL().bD("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
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
        }, new j<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                c.this.a(dataRes);
            }
        });
    }

    private void bgO() {
        if (this.geS != null) {
            DataRes.Builder builder = new DataRes.Builder(this.geS.build(true));
            if (builder.thread_info != null && builder.thread_info.size() > 30) {
                builder.thread_info = builder.thread_info.subList(0, 30);
            }
            a(builder);
        }
    }

    private void a(final DataRes.Builder builder) {
        z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.concern.c.6
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.d.a.agL().bD("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.geP = aVar;
    }

    private boolean pQ() {
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.geS != null && com.baidu.tbadk.core.util.v.Z(this.geS.thread_info) != 0 && com.baidu.tbadk.core.util.v.Z(this.mDataList) != 0) {
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
                        if (cVar.acC() != null && cVar.acC().getTid() != null && cVar.acC().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.geU != null) {
                                this.geU.aF(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long e = com.baidu.adp.lib.g.b.e(optString, 0L);
                for (int i2 = 0; i2 < this.geS.thread_info.size(); i2++) {
                    ConcernData concernData = this.geS.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == e) {
                        this.geS.thread_info.remove(i2);
                        bgO();
                        return;
                    }
                }
            }
        }
    }
}
