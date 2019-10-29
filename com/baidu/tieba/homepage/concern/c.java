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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class c {
    private View.OnTouchListener cCE;
    private v cPo;
    private com.baidu.tieba.f.a fTs;
    private final BdTypeRecyclerView fzZ;
    private BigdaySwipeRefreshLayout geg;
    private com.baidu.tieba.homepage.concern.b.a gem;
    private com.baidu.tieba.homepage.concern.b.b gen;
    private DataRes.Builder gep;
    private final com.baidu.tieba.homepage.concern.a ger;
    private final com.baidu.tieba.homepage.concern.c.a ges;
    private int get;
    private boolean hasMore;
    private String pageTag;
    private a gel = null;
    private final List<m> mDataList = new LinkedList();
    private boolean mIsLoading = false;
    private boolean geq = false;
    private boolean mIsBackground = false;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.c.1
        private int gev = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (c.this.cPo != null && !c.this.mIsBackground) {
                c.this.cPo.g(recyclerView, i);
            }
            if (i == 0) {
                t.baw().aIL();
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
            if (c.this.cPo != null && !c.this.mIsBackground) {
                c.this.cPo.onScroll(this.gev, i);
            }
            this.gev = i;
        }
    };
    private View.OnTouchListener cAp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.concern.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.cCE != null) {
                c.this.cCE.onTouch(view, motionEvent);
            }
            if (c.this.fTs != null) {
                c.this.fTs.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0405a eYb = new a.InterfaceC0405a() { // from class: com.baidu.tieba.homepage.concern.c.3
        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void v(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void w(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void x(int i, int i2) {
        }
    };
    private CustomMessageListener geu = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.concern.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fOO = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.concern.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.h(customResponsedMessage);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void R(boolean z, boolean z2);

        void btb();

        void btc();

        void onError(int i, String str);

        void wO(String str);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void jT(boolean z) {
        this.mIsBackground = z;
    }

    public c(e<?> eVar, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.concern.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.fzZ = bdTypeRecyclerView;
        this.fzZ.setOnTouchListener(this.cAp);
        this.fTs = new com.baidu.tieba.f.a();
        this.ges = new com.baidu.tieba.homepage.concern.c.a();
        this.fTs.a(this.eYb);
        this.ger = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.geg = bigdaySwipeRefreshLayout;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.geu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.geu);
        this.fOO.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fOO);
    }

    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        if (wVar != null) {
            this.cPo = wVar.axN();
            this.cCE = wVar.axO();
        }
    }

    public void update() {
        if (this.mDataList.size() == 0 && !this.geq) {
            agA();
        } else {
            agz();
        }
    }

    public void btd() {
        agz();
    }

    public void aIW() {
        if (!isLoading() && this.hasMore && this.gel != null) {
            setIsLoading(true);
            this.gel.wO(this.pageTag);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (i != 0 || dataRes == null || !a(true, z, dataRes)) {
            if (i == 0 && com.baidu.tbadk.core.util.v.getCount(this.mDataList) == 0 && this.gel != null) {
                this.gel.btc();
                if (this.geg != null) {
                    this.geg.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.mDataList.size() > 0) {
                if (this.gel != null) {
                    this.gel.onError(1, str);
                }
            } else if (this.gel != null) {
                this.gel.onError(2, str);
            }
        } else {
            if (this.gel != null) {
                this.gel.R(z, false);
            }
            beH();
        }
        if (this.geg != null) {
            this.geg.setRefreshing(false);
        }
    }

    public void kX(boolean z) {
        if (z) {
            this.ger.notifyDataSetChanged();
        }
    }

    private void agz() {
        if (this.gel != null) {
            this.gel.btb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.geq = true;
        if (dataRes != null) {
            if (a(false, true, dataRes)) {
                if (this.gel != null) {
                    this.gel.R(false, true);
                    return;
                }
                return;
            }
            agz();
            return;
        }
        agz();
    }

    private List<m> a(boolean z, DataRes.Builder builder, boolean z2) {
        if (this.gep == null) {
            this.gep = new DataRes.Builder();
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        com.baidu.tieba.homepage.personalize.model.c a2 = this.ges.a(z, this.gep, builder, z2 ? 0 : 1);
        if (a2 == null) {
            return null;
        }
        return a2.dbM;
    }

    private boolean a(boolean z, boolean z2, DataRes dataRes) {
        m mVar;
        if (dataRes == null) {
            return false;
        }
        this.pageTag = dataRes.page_tag;
        LinkedList linkedList = new LinkedList();
        if (z2) {
            this.gem = null;
            this.gen = null;
        }
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        if (dataRes.banner_follow_live != null && dataRes.banner_follow_live._switch.intValue() == 1 && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
            bVar.a(dataRes.banner_follow_live);
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.getList())) {
                linkedList.add(bVar);
            }
        }
        if (dataRes.req_unix != null) {
            com.baidu.tbadk.core.sharedPref.b.alR().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), dataRes.req_unix.longValue());
        }
        List<m> a2 = a(z, builder, z2);
        if (a2 != null && TbadkCoreApplication.isLogin()) {
            linkedList.addAll(a2);
        }
        if (!aq.isEmpty(builder.user_tips)) {
            com.baidu.tieba.homepage.concern.b.a aVar = new com.baidu.tieba.homepage.concern.b.a();
            this.get = builder.user_tips_type.intValue();
            aVar.geZ = builder.user_tips_type.intValue();
            aVar.tipString = builder.user_tips;
            if (builder.user_tips_type.intValue() == 4) {
                aVar.gfa = true;
            } else {
                aVar.gfb = true;
            }
            linkedList.add(aVar);
        }
        this.hasMore = builder.has_more.intValue() == 1;
        if (com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            if (this.mDataList.isEmpty()) {
                return false;
            }
            Iterator<m> it = this.mDataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    mVar = null;
                    break;
                }
                mVar = it.next();
                if (mVar instanceof com.baidu.tbadk.data.b) {
                    break;
                }
            }
            if (mVar != null) {
                this.mDataList.remove(mVar);
            }
            this.ger.aY(this.mDataList);
            return false;
        }
        this.mDataList.clear();
        this.mDataList.addAll(linkedList);
        if (z2) {
            this.gep.page_tag = dataRes.page_tag;
            this.gep.has_more = dataRes.has_more;
            this.gep.user_list = dataRes.user_list;
            this.gep.user_tips_type = dataRes.user_tips_type;
            this.gep.user_tips = dataRes.user_tips;
            this.gep.last_tips = dataRes.last_tips;
        }
        this.gep.banner_user_story = dataRes.banner_user_story;
        this.gep.banner_follow_live = dataRes.banner_follow_live;
        this.gep.top_tips = dataRes.top_tips;
        this.gep.top_user_info = dataRes.top_user_info;
        if (this.get == 2 || this.get == 3) {
            this.gep.user_tips_type = dataRes.user_tips_type;
            this.gep.user_tips = dataRes.user_tips;
        }
        this.ger.aY(this.mDataList);
        return true;
    }

    private void agA() {
        z.a(new y<DataRes>() { // from class: com.baidu.tieba.homepage.concern.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: bte */
            public DataRes doInBackground() {
                l<byte[]> bJ = com.baidu.tbadk.core.d.a.akN().bJ("tb.concern_page", TbadkCoreApplication.getCurrentAccount());
                if (bJ == null) {
                    return null;
                }
                byte[] bArr = bJ.get("0");
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

    private void beH() {
        if (this.gep != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gep.build(true));
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
                    com.baidu.tbadk.core.d.a.akN().bJ("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void a(a aVar) {
        this.gel = aVar;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        ThreadInfo threadInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gep != null && com.baidu.tbadk.core.util.v.getCount(this.gep.thread_info) != 0 && com.baidu.tbadk.core.util.v.getCount(this.mDataList) != 0) {
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
                        if (cVar.agI() != null && cVar.agI().getTid() != null && cVar.agI().getTid().equals(optString)) {
                            this.mDataList.remove(i);
                            if (this.ger != null) {
                                this.ger.aY(this.mDataList);
                            }
                        }
                    }
                    i++;
                }
                long j = com.baidu.adp.lib.g.b.toLong(optString, 0L);
                for (int i2 = 0; i2 < this.gep.thread_info.size(); i2++) {
                    ConcernData concernData = this.gep.thread_info.get(i2);
                    if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.tid != null && threadInfo.tid.longValue() == j) {
                        this.gep.thread_info.remove(i2);
                        beH();
                        return;
                    }
                }
            }
        }
    }
}
