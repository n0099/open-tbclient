package com.baidu.tieba.homepage.personalize;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.play.m;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes6.dex */
public class e {
    private View.OnTouchListener aVr;
    private t biO;
    private com.baidu.tieba.tbadkCore.data.e dKN;
    private m dMW;
    private final BdTypeRecyclerView dOX;
    private com.baidu.tieba.f.a egj;
    private boolean erA;
    private ScrollFragmentTabHost ewY;
    private final long exP;
    private final b exQ;
    private DataRes.Builder exS;
    private as exW;
    private final com.baidu.tieba.homepage.personalize.model.a exX;
    private final l exk;
    private final BigdaySwipeRefreshLayout exs;
    private int eyb;
    private g eyd;
    private BdUniqueId eyg;
    private Runnable eyn;
    private int mHeaderHeight;
    private final TbPageContext<?> mPageContext;
    private a exR = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean etm = false;
    private long exT = 0;
    private int exU = 1;
    private int exV = 0;
    private TextView axe = null;
    private int dOI = 2000;
    private com.baidu.tbadk.l.c exY = null;
    private boolean dMO = false;
    private int dMj = 0;
    private int bNd = 0;
    private boolean mIsBackground = false;
    private boolean exZ = true;
    private boolean eya = false;
    private boolean eyc = false;
    private boolean eye = true;
    private FloatInfo eyf = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int eyt = -1;
        private int etr = 0;
        private boolean eyu = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.exY == null) {
                e.this.exY = new com.baidu.tbadk.l.c();
                e.this.exY.gj(1005);
                e.this.exY.pageType = 1;
            }
            if (e.this.biO != null && !e.this.mIsBackground) {
                e.this.biO.g(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.dOX);
                e.this.exY.Pc();
                v.aqs().dQ(true);
                com.baidu.tieba.q.c.bBT().b(e.this.eyg, false);
                if (this.eyu) {
                    e.this.aLX();
                }
                this.eyu = false;
                if (e.this.dMW != null && e.this.exZ) {
                    e.this.dMW.a(e.this.dMj, e.this.bNd, e.this.dMO, 1);
                    return;
                }
                return;
            }
            e.this.exY.Pb();
            if (i == 1 && e.this.exW != null) {
                e.this.exW.hideTip();
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
            if (this.etr > i) {
                this.eyu = true;
            }
            if (e.this.biO != null && !e.this.mIsBackground) {
                e.this.biO.onScroll(this.etr, i);
            }
            this.etr = i;
            int i3 = (i + i2) - 1;
            if (!this.eyu && this.eyt != i3) {
                this.eyt = i3;
                e.this.oS(this.eyt);
            }
            if (this.eyu && this.eyt != i) {
                this.eyt = i;
                e.this.oS(this.eyt);
            }
            e.this.eyl = i;
            e.this.dMj = i;
            e.this.bNd = (i + i2) - 1;
        }
    };
    private View.OnTouchListener biP = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.aVr != null) {
                e.this.aVr.onTouch(view, motionEvent);
            }
            if (e.this.egj != null) {
                e.this.egj.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0214a cwQ = new a.InterfaceC0214a() { // from class: com.baidu.tieba.homepage.personalize.e.15
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            e.this.dMO = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            e.this.dMO = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }
    };
    private View.OnClickListener eyh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.exW != null) {
                e.this.exW.hideTip();
            }
            if (e.this.exU == 1 && e.this.dOX != null) {
                e.this.dOX.setSelection(0);
                e.this.exs.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener eyi = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.dOX != null) {
                e.this.dMW.aNk();
                e.this.exZ = false;
                e.this.exs.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener ebs = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && e.this.exS != null && com.baidu.tbadk.core.util.v.H(e.this.exS.thread_list) != 0 && (bbVar = (bb) customResponsedMessage.getData()) != null && bbVar.zt() != null && bbVar.getId() != null && com.baidu.tbadk.core.util.v.H(e.this.exS.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.exS.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.exS.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.d(bbVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bbVar.zt().getNum());
                            builder.zan = builder2.build(true);
                            e.this.exS.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener eyj = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.v.I(e.this.mDataList) && !com.baidu.tbadk.core.util.v.I(ids) && !com.baidu.tbadk.core.util.v.I(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bb) && (bbVar = (bb) originData.get(i2)) != null && bbVar.Aa() != null && ids.contains(Long.valueOf(bbVar.Aa().live_id))) {
                            e.this.mDataList.remove(bbVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.exk != null) {
                        e.this.exk.ak(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.exS != null && !com.baidu.tbadk.core.util.v.I(e.this.exS.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.exS.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.exS.thread_list.get(i);
                        if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, -1L)) {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            User.Builder builder2 = new User.Builder(builder.author);
                            GodInfo.Builder builder3 = new GodInfo.Builder(builder2.god_data);
                            if (updateAttentionMessage.getData().isAttention) {
                                intValue = builder2.fans_num.intValue() + 1;
                                builder3.followed = 1;
                            } else {
                                intValue = builder2.fans_num.intValue() - 1;
                                builder3.followed = 0;
                            }
                            builder2.fans_num = Integer.valueOf(intValue);
                            builder2.god_data = builder3.build(true);
                            builder.author = builder2.build(true);
                            e.this.exS.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String eyk = "lastReadReadPositionKey";
    private int eyl = 0;
    private d eyo = new d() { // from class: com.baidu.tieba.homepage.personalize.e.6
        @Override // com.baidu.tieba.homepage.personalize.d
        public void oG(final int i) {
            if (e.this.eyn == null) {
                e.this.eyn = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dOX.getHandler() != null) {
                            e.this.dOX.requestFocusFromTouch();
                            if (i <= e.this.dOX.getCount() - 1) {
                                e.this.dOX.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.dOX.removeCallbacks(e.this.eyn);
            e.this.dOX.post(e.this.eyn);
        }
    };
    private CustomMessageListener eyp = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.eyd != null) {
                e.this.mDataList.remove(e.this.eyd);
                e.this.exk.ak(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener edt = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener edu = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener edv = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.exS != null && com.baidu.tbadk.core.util.v.H(e.this.exS.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.pp(str);
                if (e.this.exk != null) {
                    e.this.exk.ak(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void H(int i, int i2, int i3);

        void onError(int i, String str);

        void onSuccess();

        void s(int i, int i2, int i3, int i4);
    }

    public void hS(boolean z) {
        this.eye = z;
        if (this.exW != null && !z) {
            this.exW.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ewY = scrollFragmentTabHost;
        if (this.ewY != null) {
            this.ewY.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void oR(int i) {
                    if (e.this.ewY.oQ(i) != 1 && e.this.exW != null) {
                        e.this.exW.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void gG(boolean z) {
        this.mIsBackground = z;
        if (this.dMW != null) {
            this.dMW.jC(!z);
            if (z) {
                this.dMW.aNk();
            } else if (this.exZ) {
                this.dMW.b(this.dMj, this.bNd, this.dMO, true);
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, l lVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.mPageContext = tbPageContext;
        this.exs = bigdaySwipeRefreshLayout;
        this.dOX = bdTypeRecyclerView;
        this.dOX.setOnTouchListener(this.biP);
        this.egj = new com.baidu.tieba.f.a();
        this.egj.a(this.cwQ);
        this.exk = lVar;
        this.exX = new com.baidu.tieba.homepage.personalize.model.a();
        this.exP = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.exW = new as();
        aLY();
        this.dMW = new m(this.mPageContext, this.dOX);
        this.exQ = new b(this.mDataList, this.exk);
    }

    private boolean aLQ() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aLS(), true);
    }

    private void aLR() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aLS(), false);
    }

    private String aLS() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + BaseRequestAction.SPLITE + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (uVar != null) {
            this.biO = uVar.Qf();
            this.aVr = uVar.Qg();
        }
    }

    public void showFloatingView() {
        if (this.biO != null) {
            this.biO.cS(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.aLq().k(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.eyc = true;
        if (this.mDataList.size() == 0 && !aLQ()) {
            if (!this.etm) {
                xU();
                return;
            }
            return;
        }
        xT();
    }

    public void ba(int i, int i2) {
        bb bbVar;
        if (!com.baidu.tbadk.core.util.v.I(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bb.atk.getId() && (bbVar = (bb) this.mDataList.get(i)) != null && bbVar.Aa() != null) {
                    arrayList.add(Long.valueOf(bbVar.Aa().live_id));
                    arrayList2.add(bbVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.I(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aLT() {
        if (this.dMW != null && !this.mIsBackground && this.exZ) {
            this.dMW.b(this.dMj, this.bNd, this.dMO, true);
        }
        if (this.eya) {
            if (this.erA) {
                com.baidu.tieba.q.c.bBT().b(this.eyg, false);
                if (hU(false)) {
                    bb(3, this.exV);
                } else if (this.eyb > 0) {
                    bb(2, this.exV);
                }
            } else if (!this.erA && this.exV == 0) {
                bb(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.eya = false;
            this.erA = false;
            this.eyb = 0;
            if (this.eyc) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.eyc = false;
        }
    }

    public void aad() {
        if (Fi()) {
            com.baidu.tieba.homepage.framework.a.aLq().k(0L, 1);
        } else if (this.exR != null) {
            aLV();
            this.mPn++;
            setIsLoading(true);
            this.exR.s(this.mPn, (this.exS == null || this.exS.thread_list == null) ? 0 : this.exS.thread_list.size(), hT(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.exS == null || this.exS.thread_list == null) ? 0 : this.exS.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.eya = false;
            if (this.mDataList.size() > 0) {
                if (this.exR != null) {
                    this.exR.onError(1, str);
                }
            } else if (this.exR != null) {
                this.exR.onError(2, str);
            }
        } else {
            aLR();
            if (this.exR != null) {
                this.exR.onSuccess();
            }
            this.eya = true;
            this.erA = z;
            this.eyb = size;
            awh();
        }
        setIsLoading(false);
        if (this.exs != null) {
            this.exs.setRefreshing(false);
        }
    }

    public void hM(boolean z) {
        if (z) {
            this.exk.notifyDataSetChanged();
        }
        if (!aLU()) {
            aLX();
        }
    }

    public void onDestroy() {
        if (this.dMW != null) {
            this.dMW.destroy();
        }
        if (this.exW != null) {
            this.exW.onDestroy();
        }
        if (this.exQ != null) {
            this.exQ.onDestroy();
        }
        if (this.dOX != null) {
            this.dOX.removeCallbacks(this.eyn);
        }
    }

    public void onPause() {
        c.d(this.dOX);
        oT(this.eyl);
        if (this.exY != null) {
            this.exY.Pd();
        }
    }

    public boolean aLU() {
        if (hU(false)) {
            if (this.dOX != null) {
                this.dOX.setSelection(0);
                this.exs.setRefreshing(true);
                return true;
            }
            return true;
        }
        return false;
    }

    private void xT() {
        if (this.exR != null) {
            this.exR.H((this.exS == null || this.exS.thread_list == null || aLW()) ? 0 : this.exS.thread_list.size(), hT(true), 0);
        }
    }

    public int hT(boolean z) {
        int i = 0;
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return 0;
        }
        if (z) {
            while (true) {
                int i2 = i;
                if (i2 >= this.mDataList.size()) {
                    break;
                }
                h hVar = this.mDataList.get(i2);
                if (!(hVar instanceof com.baidu.tieba.homepage.personalize.data.a) || hVar.getType() == AdvertAppInfo.ape) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        } else {
            for (int size = this.mDataList.size() - 1; size >= 0; size--) {
                h hVar2 = this.mDataList.get(size);
                if ((hVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && hVar2.getType() != AdvertAppInfo.ape) {
                    return (this.mDataList.size() - size) - 1;
                }
            }
        }
        return this.mDataList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.etm = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aLW()) {
                if (this.exR != null) {
                    this.exR.onSuccess();
                }
                aLX();
                return;
            }
            xT();
            return;
        }
        xT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void l(List<h> list, int i) {
        AdvertAppInfo aqK;
        AdvertAppInfo aqK2;
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            Set<h> uO = com.baidu.tieba.recapp.report.a.uO("NEWINDEX");
            HashSet hashSet = uO == null ? new HashSet() : uO;
            HashSet hashSet2 = new HashSet();
            for (h hVar : list) {
                if (hVar != null) {
                    for (h hVar2 : hashSet) {
                        if ((hVar instanceof com.baidu.tieba.card.data.d) && (aqK2 = ((com.baidu.tieba.card.data.d) hVar).aqK()) != null && hVar2 != null && (hVar2 instanceof AdvertAppInfo) && hVar2.hashCode() == aqK2.hashCode()) {
                            aqK2.advertAppContext = ((AdvertAppInfo) hVar2).advertAppContext;
                        }
                    }
                    if (hVar != null && (hVar instanceof com.baidu.tieba.card.data.d) && (aqK = ((com.baidu.tieba.card.data.d) hVar).aqK()) != null && aqK.advertAppContext == null) {
                        aqK.advertAppContext = new com.baidu.tbadk.core.data.b();
                        aqK.advertAppContext.page = "NEWINDEX";
                        aqK.advertAppContext.pn = this.mPn;
                        aqK.advertAppContext.extensionInfo = aqK.extensionInfo;
                        aqK.advertAppContext.RT = false;
                        hashSet2.add(aqK);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.bBT().b(this.eyg, com.baidu.tieba.q.a.b("a002", "common_fill", true, hashSet2.size()));
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<h> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.exT = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aLW()) {
            this.exS = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.exX.a(z, this.exS, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.bvO;
            this.exV = a2.ezQ;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            l(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.eyc) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.exS == null) {
            this.exS = builder;
            this.exQ.cl(this.exS.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.eyd = new g();
                    this.eyd.a(dataRes.live_answer);
                    this.exS.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.eyd = null;
                    this.exS.live_answer = null;
                }
                this.eyf = dataRes.float_info;
                this.exS.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.eyd != null && !ao.ak(j)) {
                this.mDataList.add(0, this.eyd);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.exk.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.exk.ak(linkedList);
            z4 = true;
            if (this.dMW != null && this.exZ) {
                this.dMW.b(this.dMj, this.bNd, this.dMO, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aLq().i(System.currentTimeMillis() - currentTimeMillis, 1);
        long oF = com.baidu.tieba.homepage.framework.a.aLq().oF(1);
        if (oF > 0) {
            com.baidu.tieba.homepage.framework.a.aLq().j(System.currentTimeMillis() - oF, 1);
            com.baidu.tieba.homepage.framework.a.aLq().k(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.c.d(dataRes.anti.block_pop_info);
        }
        com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
        asVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, asVar));
        return z4;
    }

    private void aLV() {
        if (com.baidu.tbadk.core.util.v.H(this.mDataList) >= this.exX.aMm() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.exX.a(true, this.exS, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.bvO : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.exk.ak(new LinkedList(this.mDataList));
            }
        }
    }

    private void xU() {
        this.etm = true;
        x.a(new w<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aMc */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> am = com.baidu.tbadk.core.c.a.BB().am("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (am == null) {
                    return null;
                }
                byte[] bArr = am.get("0");
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
        }, new com.baidu.tbadk.util.h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void awh() {
        if (this.exS != null) {
            DataRes.Builder builder = new DataRes.Builder(this.exS.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void a(DataRes.Builder builder, int i) {
        if (builder != null && builder.banner_list != null && builder.banner_list.app != null) {
            BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
            if (builder2.app != null) {
                Iterator<App> it = builder2.app.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int l = com.baidu.adp.lib.g.b.l(next.pos_name, -1);
                        if (l < 0) {
                            it.remove();
                        } else if (l < i + i2 + 1) {
                            i2++;
                        } else {
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                    i2 = i2;
                }
                builder.banner_list = builder2.build(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pp(String str) {
        if (!TextUtils.isEmpty(str) && this.exS != null && this.exS.banner_list != null && this.exS.banner_list.app != null && this.exS.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.exS.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.exS.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.exS.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.exS.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.20
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.exQ.cm(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.BB().am("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aLW() {
        return hU(true);
    }

    private boolean hU(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.exP;
    }

    public void a(a aVar) {
        this.exR = aVar;
    }

    private boolean Fi() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLX() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.exT != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.exT) {
                bb(1, 0);
            }
        }
    }

    public void aLN() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.Gi() && !StringUtils.isNull(activityPrizeData.Gq())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("activity_prize_feed_text_time", "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split("@");
                    if (split != null && split.length == 2) {
                        String str2 = split[0];
                        String[] split2 = split[1].split(",");
                        if (!StringUtils.isNull(str2) && split2.length != 0) {
                            if (str2.equals(currentDay)) {
                                List<String> asList = Arrays.asList(split2);
                                if (asList.contains(currentAccount)) {
                                    z = false;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(currentDay).append("@");
                                    for (String str3 : asList) {
                                        sb.append(str3).append(",");
                                    }
                                    str = sb.append(currentAccount).toString();
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(currentDay).append("@");
                                sb2.append(currentAccount);
                                str = sb2.toString();
                            }
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(currentDay).append("@");
                            sb3.append(currentAccount);
                            str = sb3.toString();
                        }
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(currentDay).append("@");
                        sb4.append(currentAccount);
                        str = sb4.toString();
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(currentDay).append("@");
                    sb5.append(currentAccount);
                    str = sb5.toString();
                }
                if (z) {
                    bb(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bb(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.ewY != null) {
            this.exW.aDu();
        }
        if (this.ewY != null && this.ewY.getCurrentTabType() != 1) {
            this.exW.hideTip();
        } else if (!this.eye) {
            this.exW.hideTip();
        } else {
            this.exU = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(e.j.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().Gq();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.axe == null) {
                    this.axe = new TextView(this.mPageContext.getPageActivity());
                    this.axe.setGravity(17);
                    this.axe.setOnClickListener(this.eyh);
                }
                this.exW.aDu();
                FrameLayout frameLayout = this.ewY.getFrameLayout();
                if (frameLayout != null && this.axe.getParent() == null) {
                    if (i == 1) {
                        if (j.kV()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds40);
                            this.axe.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.axe.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            al.i(this.axe, e.f.bg_home_float);
                            al.h(this.axe, e.d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.mHeaderHeight;
                        } else {
                            return;
                        }
                    } else {
                        this.axe.setPadding(0, 0, 0, 0);
                        this.axe.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.fontsize24));
                        al.i(this.axe, e.d.common_color_10260);
                        al.h(this.axe, e.d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.mHeaderHeight;
                    }
                    this.axe.setText(str);
                    if (i == 1) {
                        this.dOI = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
                    } else if (i == 4) {
                        this.dOI = 3000;
                    } else {
                        this.dOI = 2000;
                    }
                    this.exW.a(this.axe, frameLayout, layoutParams, this.dOI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Long l) {
        if (this.exS != null && this.exS.thread_list != null) {
            List<ThreadInfo> list = this.exS.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    awh();
                    a(false, true, false, this.exS.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eyg = bdUniqueId;
            if (this.ebs != null) {
                this.ebs.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ebs);
            }
            if (this.eyi != null) {
                this.eyi.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.eyi);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.eyj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eyj);
            this.edt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.edt);
            this.edu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.edu);
            this.edv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.edv);
            if (this.dMW != null) {
                this.dMW.setUniqueId(bdUniqueId);
            }
            this.exQ.h(bdUniqueId);
            this.eyp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eyp);
        }
    }

    public void aLY() {
        this.dKN = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dKN.bDK();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.dKN != null) {
            if (i == 0) {
                this.dKN.bDK();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.hnY;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dKN.bR(i3, i7 + 1);
                            }
                            i6++;
                        }
                    } else {
                        i4 = i5;
                    }
                    i7++;
                    i6 = i6;
                    i5 = i4;
                }
            }
        }
    }

    public void oS(int i) {
        if ((this.dKN != null ? this.dKN.vF(i) : -1) >= 0 && this.dOX != null && this.dOX.getData() != null && this.dOX.getData().size() > i) {
            this.dKN.vG(i);
        }
    }

    public m aCm() {
        return this.dMW;
    }

    public void hV(boolean z) {
        this.exZ = z;
    }

    public void oT(final int i) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> an = com.baidu.tbadk.core.c.a.BB().an(e.this.eyk, TbadkCoreApplication.getCurrentAccount());
                if (an != null) {
                    an.a(e.this.eyk, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        x.a(new w<String>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aMb */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> an = com.baidu.tbadk.core.c.a.BB().an(e.this.eyk, TbadkCoreApplication.getCurrentAccount());
                if (an != null) {
                    return an.get(e.this.eyk);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: pq */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.oG(com.baidu.adp.lib.g.b.l(str, 0));
                }
            }
        });
    }

    public void aLP() {
        c.e(this.dOX);
    }

    public void aLZ() {
        a(this.eyo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        int b;
        String str;
        int i = 0;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.exS != null && com.baidu.tbadk.core.util.v.H(this.exS.thread_list) != 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.dOX != null && !TextUtils.isEmpty(optString2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.dOX.getCount()) {
                            str = optString;
                            break;
                        }
                        h item = this.dOX.getItem(i2);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.ZT() != null && jVar.ZT().Aa() != null && optString2.equals(String.valueOf(jVar.ZT().Aa().live_id))) {
                                str = jVar.ZT().getTid();
                                break;
                            }
                        }
                        i2++;
                    }
                    if (StringUtils.isNull(str)) {
                        return;
                    }
                    optString = str;
                } else {
                    return;
                }
            }
            Iterator<h> it = this.mDataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.ZT() != null && cVar.ZT().getTid() != null && cVar.ZT().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.co(this.mDataList);
                        break;
                    }
                }
            }
            if (this.exS != null && this.exS.thread_list != null) {
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                while (true) {
                    if (i < this.exS.thread_list.size()) {
                        ThreadInfo threadInfo = this.exS.thread_list.get(i);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != d) {
                            i++;
                        } else {
                            this.exS.thread_list.remove(i);
                            awh();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i, this.exS.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.dOX != null && (b = b(optString, this.dOX)) != -1) {
                    this.dOX.removeItem(b);
                }
            }
        }
    }

    private int b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        int i2 = -1;
        while (true) {
            int i3 = i;
            if (i3 < bdTypeRecyclerView.getCount()) {
                h item = bdTypeRecyclerView.getItem(i3);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.ZT() != null && cVar.ZT().getTid().equals(str)) {
                        i2 = i3;
                    }
                }
                i = i3 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<h> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<h> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).aqK();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.yy() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.yy()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.apq)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aMa() {
        return this.eyf;
    }
}
