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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.v;
import com.baidu.tieba.f;
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
/* loaded from: classes2.dex */
public class d {
    private View.OnTouchListener aJj;
    private r aWE;
    private com.baidu.tieba.f.a dGF;
    private boolean dRj;
    private ScrollFragmentTabHost dWH;
    private int dWK;
    private final l dWU;
    private as dXD;
    private final com.baidu.tieba.homepage.personalize.model.a dXE;
    private int dXI;
    private g dXK;
    private Runnable dXS;
    private final BigdaySwipeRefreshLayout dXa;
    private final long dXw;
    private final b dXx;
    private DataRes.Builder dXz;
    private com.baidu.tieba.tbadkCore.data.e dmk;
    private m dou;
    private final BdTypeRecyclerView dqf;
    private final TbPageContext<?> mPageContext;
    private a dXy = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean dSV = false;
    private long dXA = 0;
    private int dXB = 1;
    private int dXC = 0;
    private TextView alt = null;
    private int dpQ = 2000;
    private com.baidu.tbadk.l.c dXF = null;
    private boolean dom = false;
    private int dnG = 0;
    private int buc = 0;
    private boolean mIsBackground = false;
    private boolean dXG = true;
    private boolean dXH = false;
    private boolean dXJ = false;
    private boolean dXL = true;
    private FloatInfo dXM = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.d.12
        private int dXY = -1;
        private int dTa = 0;
        private boolean dXZ = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.dXF == null) {
                d.this.dXF = new com.baidu.tbadk.l.c();
                d.this.dXF.fl(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
                d.this.dXF.pageType = 1;
            }
            if (d.this.aWE != null && !d.this.mIsBackground) {
                d.this.aWE.g(recyclerView, i);
            }
            if (i == 0) {
                d.this.dXF.KA();
                v.ajb().cL(true);
                if (this.dXZ) {
                    d.this.aEn();
                }
                this.dXZ = false;
                if (d.this.dou != null && d.this.dXG) {
                    d.this.dou.a(d.this.dnG, d.this.buc, d.this.dom, 1);
                    return;
                }
                return;
            }
            d.this.dXF.Kz();
            if (i == 1 && d.this.dXD != null) {
                d.this.dXD.hideTip();
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
            if (this.dTa > i) {
                this.dXZ = true;
            }
            if (d.this.aWE != null && !d.this.mIsBackground) {
                d.this.aWE.onScroll(this.dTa, i);
            }
            this.dTa = i;
            int i3 = (i + i2) - 1;
            if (!this.dXZ && this.dXY != i3) {
                this.dXY = i3;
                d.this.mR(this.dXY);
            }
            if (this.dXZ && this.dXY != i) {
                this.dXY = i;
                d.this.mR(this.dXY);
            }
            d.this.dXR = i;
            d.this.dnG = i;
            d.this.buc = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aWF = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.d.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.aJj != null) {
                d.this.aJj.onTouch(view, motionEvent);
            }
            if (d.this.dGF != null) {
                d.this.dGF.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0144a bKb = new a.InterfaceC0144a() { // from class: com.baidu.tieba.homepage.personalize.d.15
        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Y(int i, int i2) {
            d.this.dom = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void Z(int i, int i2) {
            d.this.dom = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0144a
        public void aa(int i, int i2) {
        }
    };
    private View.OnClickListener dXN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.dXD != null) {
                d.this.dXD.hideTip();
            }
            if (d.this.dXB == 1 && d.this.dqf != null) {
                d.this.dqf.setSelection(0);
                d.this.dXa.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener dXO = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.d.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.dqf != null) {
                d.this.dou.aFA();
                d.this.dXG = false;
                d.this.dXa.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener axF = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && d.this.dXz != null && w.y(d.this.dXz.thread_list) != 0 && (bbVar = (bb) customResponsedMessage.getData()) != null && bbVar.uW() != null && bbVar.getId() != null && w.y(d.this.dXz.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < d.this.dXz.thread_list.size()) {
                        ThreadInfo threadInfo = d.this.dXz.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bbVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bbVar.uW().getNum());
                            builder.zan = builder2.build(true);
                            d.this.dXz.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener dXP = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!w.z(d.this.mDataList) && !w.z(ids) && !w.z(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bb) && (bbVar = (bb) originData.get(i2)) != null && bbVar.vC() != null && ids.contains(Long.valueOf(bbVar.vC().live_id))) {
                            d.this.mDataList.remove(bbVar);
                        }
                        i = i2 + 1;
                    }
                    if (d.this.dWU != null) {
                        d.this.dWU.ai(new ArrayList(d.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && d.this.dXz != null && !w.z(d.this.dXz.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < d.this.dXz.thread_list.size(); i++) {
                        ThreadInfo threadInfo = d.this.dXz.thread_list.get(i);
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
                            d.this.dXz.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String dXQ = "lastReadReadPositionKey";
    private int dXR = 0;
    private c dXT = new c() { // from class: com.baidu.tieba.homepage.personalize.d.6
        @Override // com.baidu.tieba.homepage.personalize.c
        public void mF(final int i) {
            if (d.this.dXS == null) {
                d.this.dXS = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dqf.getHandler() != null) {
                            d.this.dqf.requestFocusFromTouch();
                            if (i <= d.this.dqf.getCount() - 1) {
                                d.this.dqf.setSelection(i);
                            }
                        }
                    }
                };
            }
            d.this.dqf.removeCallbacks(d.this.dXS);
            d.this.dqf.post(d.this.dXS);
        }
    };
    private CustomMessageListener dXU = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dXK != null) {
                d.this.mDataList.remove(d.this.dXK);
                d.this.dWU.ai(new ArrayList(d.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener dEg = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dEh = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dEi = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dXz != null && w.y(d.this.dXz.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                d.this.f(str, d.this.mDataList);
                d.this.nA(str);
                if (d.this.dWU != null) {
                    d.this.dWU.ai(new ArrayList(d.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void C(int i, int i2, int i3);

        void aR(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void gN(boolean z) {
        this.dXL = z;
        if (this.dXD != null && !z) {
            this.dXD.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dWH = scrollFragmentTabHost;
        if (this.dWH != null) {
            this.dWH.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void mQ(int i) {
                    if (d.this.dWH.mP(i) != 1 && d.this.dXD != null) {
                        d.this.dXD.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fJ(boolean z) {
        this.mIsBackground = z;
        if (this.dou != null) {
            this.dou.iw(!z);
            if (z) {
                this.dou.aFA();
            } else if (this.dXG) {
                this.dou.b(this.dnG, this.buc, this.dom, true);
            }
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, l lVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.mPageContext = tbPageContext;
        this.dXa = bigdaySwipeRefreshLayout;
        this.dqf = bdTypeRecyclerView;
        this.dqf.setOnTouchListener(this.aWF);
        this.dGF = new com.baidu.tieba.f.a();
        this.dGF.a(this.bKb);
        this.dWU = lVar;
        this.dXE = new com.baidu.tieba.homepage.personalize.model.a();
        this.dXw = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.dXD = new as();
        aEo();
        this.dou = new m(this.mPageContext, this.dqf);
        this.dXx = new b(this.mDataList, this.dWU);
    }

    private boolean aEg() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aEi(), true);
    }

    private void aEh() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aEi(), false);
    }

    private String aEi() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.dWK = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aWE = sVar.Ly();
            this.aJj = sVar.Lz();
        }
    }

    public void showFloatingView() {
        if (this.aWE != null) {
            this.aWE.cf(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.aDH().h(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.dXJ = true;
        if (this.mDataList.size() == 0 && !aEg()) {
            if (!this.dSV) {
                tw();
                return;
            }
            return;
        }
        tv();
    }

    public void aS(int i, int i2) {
        bb bbVar;
        if (!w.z(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bb.ahB.getId() && (bbVar = (bb) this.mDataList.get(i)) != null && bbVar.vC() != null) {
                    arrayList.add(Long.valueOf(bbVar.vC().live_id));
                    arrayList2.add(bbVar);
                }
                i++;
            }
            if (!w.z(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aEj() {
        if (this.dou != null && !this.mIsBackground && this.dXG) {
            this.dou.b(this.dnG, this.buc, this.dom, true);
        }
        if (this.dXH) {
            if (this.dRj) {
                if (gO(false)) {
                    aT(3, this.dXC);
                } else if (this.dXI > 0) {
                    aT(2, this.dXC);
                }
            } else if (!this.dRj && this.dXC == 0) {
                aT(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dXH = false;
            this.dRj = false;
            this.dXI = 0;
            if (this.dXJ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.dXJ = false;
        }
    }

    public void Tq() {
        if (AB()) {
            com.baidu.tieba.homepage.framework.a.aDH().h(0L, 1);
        } else if (this.dXy != null) {
            aEl();
            this.mPn++;
            setIsLoading(true);
            this.dXy.C(this.mPn, (this.dXz == null || this.dXz.thread_list == null) ? 0 : this.dXz.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dXz == null || this.dXz.thread_list == null) ? 0 : this.dXz.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.dXH = false;
            if (this.mDataList.size() > 0) {
                if (this.dXy != null) {
                    this.dXy.onError(1, str);
                }
            } else if (this.dXy != null) {
                this.dXy.onError(2, str);
            }
        } else {
            aEh();
            if (this.dXy != null) {
                this.dXy.onSuccess();
            }
            this.dXH = true;
            this.dRj = z;
            this.dXI = size;
            aoV();
        }
        setIsLoading(false);
        if (this.dXa != null) {
            this.dXa.setRefreshing(false);
        }
    }

    public void gH(boolean z) {
        if (z) {
            this.dWU.notifyDataSetChanged();
        }
        if (!aEk()) {
            aEn();
        }
    }

    public void onDestroy() {
        if (this.dou != null) {
            this.dou.destroy();
        }
        if (this.dXD != null) {
            this.dXD.onDestroy();
        }
        if (this.dXx != null) {
            this.dXx.onDestroy();
        }
        if (this.dqf != null) {
            this.dqf.removeCallbacks(this.dXS);
        }
    }

    public void onPause() {
        mS(this.dXR);
        if (this.dXF != null) {
            this.dXF.KB();
        }
    }

    public boolean aEk() {
        if (gO(false)) {
            if (this.dqf != null) {
                this.dqf.setSelection(0);
                this.dXa.setRefreshing(true);
                return true;
            }
            return true;
        }
        return false;
    }

    private void tv() {
        if (this.dXy != null) {
            this.dXy.aR((this.dXz == null || this.dXz.thread_list == null || aEm()) ? 0 : this.dXz.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dSV = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aEm()) {
                if (this.dXy != null) {
                    this.dXy.onSuccess();
                }
                aEn();
                return;
            }
            tv();
            return;
        }
        tv();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void k(List<h> list, int i) {
        AdvertAppInfo ajt;
        AdvertAppInfo ajt2;
        if (!w.z(list)) {
            Set<h> sX = com.baidu.tieba.recapp.report.a.sX("NEWINDEX");
            HashSet hashSet = sX == null ? new HashSet() : sX;
            HashSet hashSet2 = new HashSet();
            for (h hVar : list) {
                if (hVar != null) {
                    for (h hVar2 : hashSet) {
                        if ((hVar instanceof com.baidu.tieba.card.data.d) && (ajt2 = ((com.baidu.tieba.card.data.d) hVar).ajt()) != null && hVar2 != null && (hVar2 instanceof AdvertAppInfo) && hVar2.hashCode() == ajt2.hashCode()) {
                            ajt2.advertAppContext = ((AdvertAppInfo) hVar2).advertAppContext;
                        }
                    }
                    if (hVar != null && (hVar instanceof com.baidu.tieba.card.data.d) && (ajt = ((com.baidu.tieba.card.data.d) hVar).ajt()) != null && ajt.advertAppContext == null) {
                        ajt.advertAppContext = new com.baidu.tbadk.core.data.b();
                        ajt.advertAppContext.page = "NEWINDEX";
                        ajt.advertAppContext.pn = this.mPn;
                        ajt.advertAppContext.extensionInfo = ajt.extensionInfo;
                        ajt.advertAppContext.OY = false;
                        hashSet2.add(ajt);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<h> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.dXA = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aEm()) {
            this.dXz = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dXE.a(z, this.dXz, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.bhG;
            this.dXC = a2.dZt;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.dXJ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.dXz == null) {
            this.dXz = builder;
            this.dXx.bR(this.dXz.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.dXK = new g();
                    this.dXK.a(dataRes.live_answer);
                    this.dXz.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.dXK = null;
                    this.dXz.live_answer = null;
                }
                this.dXM = dataRes.float_info;
                this.dXz.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.dXK != null && !ap.U(j)) {
                this.mDataList.add(0, this.dXK);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.dWU.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dWU.ai(linkedList);
            z4 = true;
            if (this.dou != null && this.dXG) {
                this.dou.b(this.dnG, this.buc, this.dom, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aDH().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long mE = com.baidu.tieba.homepage.framework.a.aDH().mE(1);
        if (mE > 0) {
            com.baidu.tieba.homepage.framework.a.aDH().g(System.currentTimeMillis() - mE, 1);
            com.baidu.tieba.homepage.framework.a.aDH().h(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.c.d(dataRes.anti.block_pop_info);
        }
        com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
        asVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, asVar));
        return z4;
    }

    private void aEl() {
        if (w.y(this.mDataList) >= this.dXE.aEC() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.dXE.a(true, this.dXz, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.bhG : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.dWU.ai(new LinkedList(this.mDataList));
            }
        }
    }

    private void tw() {
        this.dSV = true;
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.d.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aEs */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> P = com.baidu.tbadk.core.c.a.xa().P("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (P == null) {
                    return null;
                }
                byte[] bArr = P.get("0");
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
        }, new com.baidu.tbadk.util.g<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.d.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                d.this.a(dataRes);
            }
        });
    }

    private void aoV() {
        if (this.dXz != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dXz.build(true));
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
    public void nA(String str) {
        if (!TextUtils.isEmpty(str) && this.dXz != null && this.dXz.banner_list != null && this.dXz.banner_list.app != null && this.dXz.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.dXz.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.dXz.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.dXz.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.dXz.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.20
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                d.this.dXx.bS(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.xa().P("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aEm() {
        return gO(true);
    }

    private boolean gO(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dXw;
    }

    public void a(a aVar) {
        this.dXy = aVar;
    }

    private boolean AB() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEn() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.dXA != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dXA) {
                aT(1, 0);
            }
        }
    }

    public void aEe() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.BA() && !StringUtils.isNull(activityPrizeData.BI())) {
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
                    aT(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void aT(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.dWH != null) {
            this.dXD.avR();
        }
        if (this.dWH != null && this.dWH.getCurrentTabType() != 1) {
            this.dXD.hideTip();
        } else if (!this.dXL) {
            this.dXD.hideTip();
        } else {
            this.dXB = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.getInst().getString(f.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(f.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(f.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(f.j.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().BI();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.alt == null) {
                    this.alt = new TextView(this.mPageContext.getPageActivity());
                    this.alt.setGravity(17);
                    this.alt.setOnClickListener(this.dXN);
                }
                this.dXD.avR();
                FrameLayout frameLayout = this.dWH.getFrameLayout();
                if (frameLayout != null && this.alt.getParent() == null) {
                    if (i == 1) {
                        if (j.jE()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds40);
                            this.alt.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.alt.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(f.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            am.i(this.alt, f.C0146f.bg_home_float);
                            am.h(this.alt, f.d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.dWK;
                        } else {
                            return;
                        }
                    } else {
                        this.alt.setPadding(0, 0, 0, 0);
                        this.alt.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(f.e.fontsize24));
                        am.i(this.alt, f.d.common_color_10260);
                        am.h(this.alt, f.d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), f.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.dWK;
                    }
                    this.alt.setText(str);
                    if (i == 1) {
                        this.dpQ = 4000;
                    } else if (i == 4) {
                        this.dpQ = 3000;
                    } else {
                        this.dpQ = 2000;
                    }
                    this.dXD.a(this.alt, frameLayout, layoutParams, this.dpQ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.dXz != null && this.dXz.thread_list != null) {
            List<ThreadInfo> list = this.dXz.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aoV();
                    a(false, true, false, this.dXz.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.axF != null) {
                this.axF.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.axF);
            }
            if (this.dXO != null) {
                this.dXO.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dXO);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.dXP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dXP);
            this.dEg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dEg);
            this.dEh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dEh);
            this.dEi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dEi);
            if (this.dou != null) {
                this.dou.setUniqueId(bdUniqueId);
            }
            this.dXx.h(bdUniqueId);
            this.dXU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dXU);
        }
    }

    public void aEo() {
        this.dmk = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dmk.bvH();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.dmk != null) {
            if (i == 0) {
                this.dmk.bvH();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gNw;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dmk.bJ(i3, i7 + 1);
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

    public void mR(int i) {
        if ((this.dmk != null ? this.dmk.tG(i) : -1) >= 0 && this.dqf != null && this.dqf.getData() != null && this.dqf.getData().size() > i) {
            this.dmk.tH(i);
        }
    }

    public m avb() {
        return this.dou;
    }

    public void gP(boolean z) {
        this.dXG = z;
    }

    public void mS(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.5
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> Q = com.baidu.tbadk.core.c.a.xa().Q(d.this.dXQ, TbadkCoreApplication.getCurrentAccount());
                if (Q != null) {
                    Q.a(d.this.dXQ, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final c cVar) {
        com.baidu.tbadk.util.v.a(new u<String>() { // from class: com.baidu.tieba.homepage.personalize.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aEr */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> Q = com.baidu.tbadk.core.c.a.xa().Q(d.this.dXQ, TbadkCoreApplication.getCurrentAccount());
                if (Q != null) {
                    return Q.get(d.this.dXQ);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.g<String>() { // from class: com.baidu.tieba.homepage.personalize.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: nB */
            public void onReturnDataInUI(String str) {
                if (cVar != null) {
                    cVar.mF(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void aEp() {
        a(this.dXT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        int b;
        String str;
        int i = 0;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dXz != null && w.y(this.dXz.thread_list) != 0 && w.y(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.dqf != null && !TextUtils.isEmpty(optString2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.dqf.getCount()) {
                            str = optString;
                            break;
                        }
                        h item = this.dqf.getItem(i2);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.Tg() != null && jVar.Tg().vC() != null && optString2.equals(String.valueOf(jVar.Tg().vC().live_id))) {
                                str = jVar.Tg().getTid();
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
                    if (cVar.Tg() != null && cVar.Tg().getTid() != null && cVar.Tg().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bU(this.mDataList);
                        break;
                    }
                }
            }
            if (this.dXz != null && this.dXz.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                while (true) {
                    if (i < this.dXz.thread_list.size()) {
                        ThreadInfo threadInfo = this.dXz.thread_list.get(i);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                            i++;
                        } else {
                            this.dXz.thread_list.remove(i);
                            aoV();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i, this.dXz.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.dqf != null && (b = b(optString, this.dqf)) != -1) {
                    this.dqf.removeItem(b);
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
                    if (cVar.Tg() != null && cVar.Tg().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).ajt();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.ua() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.ua()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.adE)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aEq() {
        return this.dXM;
    }
}
