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
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes2.dex */
public class d {
    private View.OnTouchListener aJf;
    private s aWC;
    private com.baidu.tieba.f.a dDX;
    private boolean dOB;
    private ScrollFragmentTabHost dST;
    private int dSW;
    private final long dTH;
    private final b dTI;
    private DataRes.Builder dTK;
    private as dTO;
    private final com.baidu.tieba.homepage.personalize.model.a dTP;
    private int dTT;
    private g dTV;
    private final l dTg;
    private final BigdaySwipeRefreshLayout dTm;
    private Runnable dUd;
    private com.baidu.tieba.tbadkCore.data.e djw;
    private m dlE;
    private final BdTypeRecyclerView dnn;
    private final TbPageContext<?> mPageContext;
    private a dTJ = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean dQn = false;
    private long dTL = 0;
    private int dTM = 1;
    private int dTN = 0;
    private TextView alU = null;
    private int dna = 2000;
    private com.baidu.tbadk.k.c dTQ = null;
    private boolean dlw = false;
    private int dkR = 0;
    private int btu = 0;
    private boolean mIsBackground = false;
    private boolean dTR = true;
    private boolean dTS = false;
    private boolean dTU = false;
    private boolean dTW = true;
    private FloatInfo dTX = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.d.12
        private int dUj = -1;
        private int dQs = 0;
        private boolean dUk = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.dTQ == null) {
                d.this.dTQ = new com.baidu.tbadk.k.c();
                d.this.dTQ.fl(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
                d.this.dTQ.pageType = 1;
            }
            if (d.this.aWC != null && !d.this.mIsBackground) {
                d.this.aWC.h(recyclerView, i);
            }
            if (i == 0) {
                d.this.dTQ.KB();
                v.aiz().cK(true);
                if (this.dUk) {
                    d.this.aDq();
                }
                this.dUk = false;
                if (d.this.dlE != null && d.this.dTR) {
                    d.this.dlE.a(d.this.dkR, d.this.btu, d.this.dlw, 1);
                    return;
                }
                return;
            }
            d.this.dTQ.KA();
            if (i == 1 && d.this.dTO != null) {
                d.this.dTO.hideTip();
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
            if (this.dQs > i) {
                this.dUk = true;
            }
            if (d.this.aWC != null && !d.this.mIsBackground) {
                d.this.aWC.onScroll(this.dQs, i);
            }
            this.dQs = i;
            int i3 = (i + i2) - 1;
            if (!this.dUk && this.dUj != i3) {
                this.dUj = i3;
                d.this.mD(this.dUj);
            }
            if (this.dUk && this.dUj != i) {
                this.dUj = i;
                d.this.mD(this.dUj);
            }
            d.this.dUc = i;
            d.this.dkR = i;
            d.this.btu = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aWD = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.d.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.aJf != null) {
                d.this.aJf.onTouch(view, motionEvent);
            }
            if (d.this.dDX != null) {
                d.this.dDX.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0147a bJo = new a.InterfaceC0147a() { // from class: com.baidu.tieba.homepage.personalize.d.15
        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void W(int i, int i2) {
            d.this.dlw = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void X(int i, int i2) {
            d.this.dlw = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void Y(int i, int i2) {
        }
    };
    private View.OnClickListener dTY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.dTO != null) {
                d.this.dTO.hideTip();
            }
            if (d.this.dTM == 1 && d.this.dnn != null) {
                d.this.dnn.setSelection(0);
                d.this.dTm.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener dTZ = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.d.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.dnn != null) {
                d.this.dlE.aED();
                d.this.dTR = false;
                d.this.dTm.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener ayc = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bc bcVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bc) && d.this.dTK != null && w.z(d.this.dTK.thread_list) != 0 && (bcVar = (bc) customResponsedMessage.getData()) != null && bcVar.vj() != null && bcVar.getId() != null && w.z(d.this.dTK.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < d.this.dTK.thread_list.size()) {
                        ThreadInfo threadInfo = d.this.dTK.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bcVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bcVar.vj().getNum());
                            builder.zan = builder2.build(true);
                            d.this.dTK.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener dUa = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bc bcVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!w.A(d.this.mDataList) && !w.A(ids) && !w.A(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bc) && (bcVar = (bc) originData.get(i2)) != null && bcVar.vO() != null && ids.contains(Long.valueOf(bcVar.vO().live_id))) {
                            d.this.mDataList.remove(bcVar);
                        }
                        i = i2 + 1;
                    }
                    if (d.this.dTg != null) {
                        d.this.dTg.aj(new ArrayList(d.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && d.this.dTK != null && !w.A(d.this.dTK.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < d.this.dTK.thread_list.size(); i++) {
                        ThreadInfo threadInfo = d.this.dTK.thread_list.get(i);
                        if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, -1L)) {
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
                            d.this.dTK.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String dUb = "lastReadReadPositionKey";
    private int dUc = 0;
    private c dUe = new c() { // from class: com.baidu.tieba.homepage.personalize.d.6
        @Override // com.baidu.tieba.homepage.personalize.c
        public void mr(final int i) {
            if (d.this.dUd == null) {
                d.this.dUd = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dnn.getHandler() != null) {
                            d.this.dnn.requestFocusFromTouch();
                            if (i <= d.this.dnn.getCount() - 1) {
                                d.this.dnn.setSelection(i);
                            }
                        }
                    }
                };
            }
            d.this.dnn.removeCallbacks(d.this.dUd);
            d.this.dnn.post(d.this.dUd);
        }
    };
    private CustomMessageListener dUf = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dTV != null) {
                d.this.mDataList.remove(d.this.dTV);
                d.this.dTg.aj(new ArrayList(d.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener dBx = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dBy = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dBz = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dTK != null && w.z(d.this.dTK.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                d.this.f(str, d.this.mDataList);
                d.this.nw(str);
                if (d.this.dTg != null) {
                    d.this.dTg.aj(new ArrayList(d.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void C(int i, int i2, int i3);

        void aO(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void gK(boolean z) {
        this.dTW = z;
        if (this.dTO != null && !z) {
            this.dTO.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dST = scrollFragmentTabHost;
        if (this.dST != null) {
            this.dST.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void mC(int i) {
                    if (d.this.dST.mB(i) != 1 && d.this.dTO != null) {
                        d.this.dTO.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fH(boolean z) {
        this.mIsBackground = z;
        if (this.dlE != null) {
            this.dlE.it(!z);
            if (z) {
                this.dlE.aED();
            } else if (this.dTR) {
                this.dlE.b(this.dkR, this.btu, this.dlw, true);
            }
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, l lVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.mPageContext = tbPageContext;
        this.dTm = bigdaySwipeRefreshLayout;
        this.dnn = bdTypeRecyclerView;
        this.dnn.setOnTouchListener(this.aWD);
        this.dDX = new com.baidu.tieba.f.a();
        this.dDX.a(this.bJo);
        this.dTg = lVar;
        this.dTP = new com.baidu.tieba.homepage.personalize.model.a();
        this.dTH = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.dTO = new as();
        aDr();
        this.dlE = new m(this.mPageContext, this.dnn);
        this.dTI = new b(this.mDataList, this.dTg);
    }

    private boolean aDj() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aDl(), true);
    }

    private void aDk() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aDl(), false);
    }

    private String aDl() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.dSW = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (tVar != null) {
            this.aWC = tVar.Lz();
            this.aJf = tVar.LA();
        }
    }

    public void showFloatingView() {
        if (this.aWC != null) {
            this.aWC.cg(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.aCO().h(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.dTU = true;
        if (this.mDataList.size() == 0 && !aDj()) {
            if (!this.dQn) {
                tL();
                return;
            }
            return;
        }
        tK();
    }

    public void aP(int i, int i2) {
        bc bcVar;
        if (!w.A(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bc.aif.getId() && (bcVar = (bc) this.mDataList.get(i)) != null && bcVar.vO() != null) {
                    arrayList.add(Long.valueOf(bcVar.vO().live_id));
                    arrayList2.add(bcVar);
                }
                i++;
            }
            if (!w.A(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aDm() {
        if (this.dlE != null && !this.mIsBackground && this.dTR) {
            this.dlE.b(this.dkR, this.btu, this.dlw, true);
        }
        if (this.dTS) {
            if (this.dOB) {
                if (gL(false)) {
                    aQ(3, this.dTN);
                } else if (this.dTT > 0) {
                    aQ(2, this.dTN);
                }
            } else if (!this.dOB && this.dTN == 0) {
                aQ(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dTS = false;
            this.dOB = false;
            this.dTT = 0;
            if (this.dTU) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.dTU = false;
        }
    }

    public void Tf() {
        if (AO()) {
            com.baidu.tieba.homepage.framework.a.aCO().h(0L, 1);
        } else if (this.dTJ != null) {
            aDo();
            this.mPn++;
            setIsLoading(true);
            this.dTJ.C(this.mPn, (this.dTK == null || this.dTK.thread_list == null) ? 0 : this.dTK.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dTK == null || this.dTK.thread_list == null) ? 0 : this.dTK.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.dTS = false;
            if (this.mDataList.size() > 0) {
                if (this.dTJ != null) {
                    this.dTJ.onError(1, str);
                }
            } else if (this.dTJ != null) {
                this.dTJ.onError(2, str);
            }
        } else {
            aDk();
            if (this.dTJ != null) {
                this.dTJ.onSuccess();
            }
            this.dTS = true;
            this.dOB = z;
            this.dTT = size;
            aov();
        }
        setIsLoading(false);
        if (this.dTm != null) {
            this.dTm.setRefreshing(false);
        }
    }

    public void gF(boolean z) {
        if (z) {
            this.dTg.notifyDataSetChanged();
        }
        if (!aDn()) {
            aDq();
        }
    }

    public void onDestroy() {
        if (this.dlE != null) {
            this.dlE.destroy();
        }
        if (this.dTO != null) {
            this.dTO.onDestroy();
        }
        if (this.dTI != null) {
            this.dTI.onDestroy();
        }
        if (this.dnn != null) {
            this.dnn.removeCallbacks(this.dUd);
        }
    }

    public void onPause() {
        mE(this.dUc);
        if (this.dTQ != null) {
            this.dTQ.KC();
        }
    }

    public boolean aDn() {
        if (gL(false)) {
            if (this.dnn != null) {
                this.dnn.setSelection(0);
                this.dTm.setRefreshing(true);
                return true;
            }
            return true;
        }
        return false;
    }

    private void tK() {
        if (this.dTJ != null) {
            this.dTJ.aO((this.dTK == null || this.dTK.thread_list == null || aDp()) ? 0 : this.dTK.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dQn = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aDp()) {
                if (this.dTJ != null) {
                    this.dTJ.onSuccess();
                }
                aDq();
                return;
            }
            tK();
            return;
        }
        tK();
    }

    private void bS(List<h> list) {
        if (!w.A(list)) {
            for (h hVar : list) {
                if (hVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) hVar;
                    if (dVar.aiR() != null) {
                        dVar.aiR().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.aiR().advertAppContext.adE = "NEWINDEX";
                        dVar.aiR().advertAppContext.pn = 1;
                        dVar.aiR().advertAppContext.extensionInfo = dVar.aiR().extensionInfo;
                        dVar.aiR().advertAppContext.Pb = false;
                    }
                }
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
        this.dTL = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aDp()) {
            this.dTK = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dTP.a(z, this.dTK, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.bha;
            this.dTN = a2.dVE;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bS(list);
            a(z2 ? 0 : 1, list, size);
            if (this.dTU) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.dTK == null) {
            this.dTK = builder;
            this.dTI.bQ(this.dTK.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.dTV = new g();
                    this.dTV.a(dataRes.live_answer);
                    this.dTK.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.dTV = null;
                    this.dTK.live_answer = null;
                }
                this.dTX = dataRes.float_info;
                this.dTK.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.dTV != null && !ap.S(j)) {
                this.mDataList.add(0, this.dTV);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.dTg.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dTg.aj(linkedList);
            z4 = true;
            if (this.dlE != null && this.dTR) {
                this.dlE.b(this.dkR, this.btu, this.dlw, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aCO().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long mq = com.baidu.tieba.homepage.framework.a.aCO().mq(1);
        if (mq > 0) {
            com.baidu.tieba.homepage.framework.a.aCO().g(System.currentTimeMillis() - mq, 1);
            com.baidu.tieba.homepage.framework.a.aCO().h(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.s.b.d(dataRes.anti.block_pop_info);
        }
        at atVar = new at();
        atVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, atVar));
        return z4;
    }

    private void aDo() {
        if (w.z(this.mDataList) >= this.dTP.aDF() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.dTP.a(true, this.dTK, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.bha : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.dTg.aj(new LinkedList(this.mDataList));
            }
        }
    }

    private void tL() {
        this.dQn = true;
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.d.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: aDv */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> Q = com.baidu.tbadk.core.c.a.xj().Q("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (Q == null) {
                    return null;
                }
                byte[] bArr = Q.get("0");
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
        }, new com.baidu.tbadk.util.h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.d.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                d.this.a(dataRes);
            }
        });
    }

    private void aov() {
        if (this.dTK != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dTK.build(true));
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
                        int g = com.baidu.adp.lib.g.b.g(next.pos_name, -1);
                        if (g < 0) {
                            it.remove();
                        } else if (g < i + i2 + 1) {
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
    public void nw(String str) {
        if (!TextUtils.isEmpty(str) && this.dTK != null && this.dTK.banner_list != null && this.dTK.banner_list.app != null && this.dTK.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.dTK.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.dTK.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.dTK.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.dTK.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.20
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                d.this.dTI.bR(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.xj().Q("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aDp() {
        return gL(true);
    }

    private boolean gL(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dTH;
    }

    public void a(a aVar) {
        this.dTJ = aVar;
    }

    private boolean AO() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDq() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.dTL != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dTL) {
                aQ(1, 0);
            }
        }
    }

    public void aDh() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.BL() && !StringUtils.isNull(activityPrizeData.BT())) {
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
                    aQ(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void aQ(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.dST != null) {
            this.dTO.avn();
        }
        if (this.dST != null && this.dST.getCurrentTabType() != 1) {
            this.dTO.hideTip();
        } else if (!this.dTW) {
            this.dTO.hideTip();
        } else {
            this.dTM = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(d.k.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().BT();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.alU == null) {
                    this.alU = new TextView(this.mPageContext.getPageActivity());
                    this.alU.setGravity(17);
                    this.alU.setOnClickListener(this.dTY);
                }
                this.dTO.avn();
                FrameLayout frameLayout = this.dST.getFrameLayout();
                if (frameLayout != null && this.alU.getParent() == null) {
                    if (i == 1) {
                        if (j.jD()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                            this.alU.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.alU.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            am.i(this.alU, d.f.bg_home_float);
                            am.h(this.alU, d.C0142d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.dSW;
                        } else {
                            return;
                        }
                    } else {
                        this.alU.setPadding(0, 0, 0, 0);
                        this.alU.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                        am.i(this.alU, d.C0142d.common_color_10260);
                        am.h(this.alU, d.C0142d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.dSW;
                    }
                    this.alU.setText(str);
                    if (i == 1) {
                        this.dna = 4000;
                    } else if (i == 4) {
                        this.dna = 3000;
                    } else {
                        this.dna = 2000;
                    }
                    this.dTO.a(this.alU, frameLayout, layoutParams, this.dna);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Long l) {
        if (this.dTK != null && this.dTK.thread_list != null) {
            List<ThreadInfo> list = this.dTK.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aov();
                    a(false, true, false, this.dTK.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ayc != null) {
                this.ayc.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ayc);
            }
            if (this.dTZ != null) {
                this.dTZ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dTZ);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.dUa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dUa);
            this.dBx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dBx);
            this.dBy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dBy);
            this.dBz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dBz);
            if (this.dlE != null) {
                this.dlE.setUniqueId(bdUniqueId);
            }
            this.dTI.h(bdUniqueId);
            this.dUf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dUf);
        }
    }

    public void aDr() {
        this.djw = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.djw.bxd();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.djw != null) {
            if (i == 0) {
                this.djw.bxd();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gMw;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.djw.bI(i3, i7 + 1);
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

    public void mD(int i) {
        if ((this.djw != null ? this.djw.tI(i) : -1) >= 0 && this.dnn != null && this.dnn.getData() != null && this.dnn.getData().size() > i) {
            this.djw.tJ(i);
        }
    }

    public m auy() {
        return this.dlE;
    }

    public void gM(boolean z) {
        this.dTR = z;
    }

    public void mE(final int i) {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.5
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> R = com.baidu.tbadk.core.c.a.xj().R(d.this.dUb, TbadkCoreApplication.getCurrentAccount());
                if (R != null) {
                    R.a(d.this.dUb, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final c cVar) {
        com.baidu.tbadk.util.w.a(new com.baidu.tbadk.util.v<String>() { // from class: com.baidu.tieba.homepage.personalize.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: aDu */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> R = com.baidu.tbadk.core.c.a.xj().R(d.this.dUb, TbadkCoreApplication.getCurrentAccount());
                if (R != null) {
                    return R.get(d.this.dUb);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: nx */
            public void onReturnDataInUI(String str) {
                if (cVar != null) {
                    cVar.mr(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void aDs() {
        a(this.dUe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        int b;
        String str;
        int i = 0;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dTK != null && w.z(this.dTK.thread_list) != 0 && w.z(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.dnn != null && !TextUtils.isEmpty(optString2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.dnn.getCount()) {
                            str = optString;
                            break;
                        }
                        h item = this.dnn.getItem(i2);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.SV() != null && jVar.SV().vO() != null && optString2.equals(String.valueOf(jVar.SV().vO().live_id))) {
                                str = jVar.SV().getTid();
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
                    if (cVar.SV() != null && cVar.SV().getTid() != null && cVar.SV().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bU(this.mDataList);
                        break;
                    }
                }
            }
            if (this.dTK != null && this.dTK.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                while (true) {
                    if (i < this.dTK.thread_list.size()) {
                        ThreadInfo threadInfo = this.dTK.thread_list.get(i);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                            i++;
                        } else {
                            this.dTK.thread_list.remove(i);
                            aov();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i, this.dTK.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.dnn != null && (b = b(optString, this.dnn)) != -1) {
                    this.dnn.removeItem(b);
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
                    if (cVar.SV() != null && cVar.SV().getTid().equals(str)) {
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
    public void f(String str, List<h> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<h> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).aiR();
                } else {
                    if (next instanceof ac) {
                        ac acVar = (ac) next;
                        if (acVar.uo() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) acVar.uo()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.aea)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aDt() {
        return this.dTX;
    }
}
