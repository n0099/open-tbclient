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
    private View.OnTouchListener aJm;
    private r aWE;
    private com.baidu.tieba.f.a dGJ;
    private boolean dRo;
    private ScrollFragmentTabHost dWK;
    private int dWN;
    private final l dWX;
    private final b dXA;
    private DataRes.Builder dXC;
    private as dXG;
    private final com.baidu.tieba.homepage.personalize.model.a dXH;
    private int dXL;
    private g dXN;
    private Runnable dXV;
    private final BigdaySwipeRefreshLayout dXd;
    private final long dXz;
    private com.baidu.tieba.tbadkCore.data.e dmm;
    private m dow;
    private final BdTypeRecyclerView dqh;
    private final TbPageContext<?> mPageContext;
    private a dXB = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean dTa = false;
    private long dXD = 0;
    private int dXE = 1;
    private int dXF = 0;
    private TextView alu = null;
    private int dpS = 2000;
    private com.baidu.tbadk.l.c dXI = null;
    private boolean doo = false;
    private int dnI = 0;
    private int bua = 0;
    private boolean mIsBackground = false;
    private boolean dXJ = true;
    private boolean dXK = false;
    private boolean dXM = false;
    private boolean dXO = true;
    private FloatInfo dXP = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.d.12
        private int dYb = -1;
        private int dTf = 0;
        private boolean dYc = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (d.this.dXI == null) {
                d.this.dXI = new com.baidu.tbadk.l.c();
                d.this.dXI.fm(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC);
                d.this.dXI.pageType = 1;
            }
            if (d.this.aWE != null && !d.this.mIsBackground) {
                d.this.aWE.g(recyclerView, i);
            }
            if (i == 0) {
                d.this.dXI.Kw();
                v.aiY().cK(true);
                if (this.dYc) {
                    d.this.aEq();
                }
                this.dYc = false;
                if (d.this.dow != null && d.this.dXJ) {
                    d.this.dow.a(d.this.dnI, d.this.bua, d.this.doo, 1);
                    return;
                }
                return;
            }
            d.this.dXI.Kv();
            if (i == 1 && d.this.dXG != null) {
                d.this.dXG.hideTip();
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
            if (this.dTf > i) {
                this.dYc = true;
            }
            if (d.this.aWE != null && !d.this.mIsBackground) {
                d.this.aWE.onScroll(this.dTf, i);
            }
            this.dTf = i;
            int i3 = (i + i2) - 1;
            if (!this.dYc && this.dYb != i3) {
                this.dYb = i3;
                d.this.mR(this.dYb);
            }
            if (this.dYc && this.dYb != i) {
                this.dYb = i;
                d.this.mR(this.dYb);
            }
            d.this.dXU = i;
            d.this.dnI = i;
            d.this.bua = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aWF = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.d.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.aJm != null) {
                d.this.aJm.onTouch(view, motionEvent);
            }
            if (d.this.dGJ != null) {
                d.this.dGJ.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0145a bKc = new a.InterfaceC0145a() { // from class: com.baidu.tieba.homepage.personalize.d.15
        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Y(int i, int i2) {
            d.this.doo = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void Z(int i, int i2) {
            d.this.doo = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0145a
        public void aa(int i, int i2) {
        }
    };
    private View.OnClickListener dXQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.d.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.dXG != null) {
                d.this.dXG.hideTip();
            }
            if (d.this.dXE == 1 && d.this.dqh != null) {
                d.this.dqh.setSelection(0);
                d.this.dXd.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener dXR = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.d.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.dqh != null) {
                d.this.dow.aFD();
                d.this.dXJ = false;
                d.this.dXd.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener axI = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && d.this.dXC != null && w.y(d.this.dXC.thread_list) != 0 && (bbVar = (bb) customResponsedMessage.getData()) != null && bbVar.uX() != null && bbVar.getId() != null && w.y(d.this.dXC.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < d.this.dXC.thread_list.size()) {
                        ThreadInfo threadInfo = d.this.dXC.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bbVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bbVar.uX().getNum());
                            builder.zan = builder2.build(true);
                            d.this.dXC.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener dXS = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.d.3
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
                        if ((originData.get(i2) instanceof bb) && (bbVar = (bb) originData.get(i2)) != null && bbVar.vD() != null && ids.contains(Long.valueOf(bbVar.vD().live_id))) {
                            d.this.mDataList.remove(bbVar);
                        }
                        i = i2 + 1;
                    }
                    if (d.this.dWX != null) {
                        d.this.dWX.ai(new ArrayList(d.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && d.this.dXC != null && !w.z(d.this.dXC.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < d.this.dXC.thread_list.size(); i++) {
                        ThreadInfo threadInfo = d.this.dXC.thread_list.get(i);
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
                            d.this.dXC.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String dXT = "lastReadReadPositionKey";
    private int dXU = 0;
    private c dXW = new c() { // from class: com.baidu.tieba.homepage.personalize.d.6
        @Override // com.baidu.tieba.homepage.personalize.c
        public void mF(final int i) {
            if (d.this.dXV == null) {
                d.this.dXV = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dqh.getHandler() != null) {
                            d.this.dqh.requestFocusFromTouch();
                            if (i <= d.this.dqh.getCount() - 1) {
                                d.this.dqh.setSelection(i);
                            }
                        }
                    }
                };
            }
            d.this.dqh.removeCallbacks(d.this.dXV);
            d.this.dqh.post(d.this.dXV);
        }
    };
    private CustomMessageListener dXX = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dXN != null) {
                d.this.mDataList.remove(d.this.dXN);
                d.this.dWX.ai(new ArrayList(d.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener dEj = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dEk = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dEl = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dXC != null && w.y(d.this.dXC.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                d.this.f(str, d.this.mDataList);
                d.this.ny(str);
                if (d.this.dWX != null) {
                    d.this.dWX.ai(new ArrayList(d.this.mDataList));
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
        this.dXO = z;
        if (this.dXG != null && !z) {
            this.dXG.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dWK = scrollFragmentTabHost;
        if (this.dWK != null) {
            this.dWK.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.d.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void mQ(int i) {
                    if (d.this.dWK.mP(i) != 1 && d.this.dXG != null) {
                        d.this.dXG.hideTip();
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
        if (this.dow != null) {
            this.dow.iw(!z);
            if (z) {
                this.dow.aFD();
            } else if (this.dXJ) {
                this.dow.b(this.dnI, this.bua, this.doo, true);
            }
        }
    }

    public d(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, l lVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.mPageContext = tbPageContext;
        this.dXd = bigdaySwipeRefreshLayout;
        this.dqh = bdTypeRecyclerView;
        this.dqh.setOnTouchListener(this.aWF);
        this.dGJ = new com.baidu.tieba.f.a();
        this.dGJ.a(this.bKc);
        this.dWX = lVar;
        this.dXH = new com.baidu.tieba.homepage.personalize.model.a();
        this.dXz = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.dXG = new as();
        aEr();
        this.dow = new m(this.mPageContext, this.dqh);
        this.dXA = new b(this.mDataList, this.dWX);
    }

    private boolean aEj() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aEl(), true);
    }

    private void aEk() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aEl(), false);
    }

    private String aEl() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.dWN = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aWE = sVar.Lu();
            this.aJm = sVar.Lv();
        }
    }

    public void showFloatingView() {
        if (this.aWE != null) {
            this.aWE.ce(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.aDK().h(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.dXM = true;
        if (this.mDataList.size() == 0 && !aEj()) {
            if (!this.dTa) {
                tx();
                return;
            }
            return;
        }
        tw();
    }

    public void aS(int i, int i2) {
        bb bbVar;
        if (!w.z(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bb.ahB.getId() && (bbVar = (bb) this.mDataList.get(i)) != null && bbVar.vD() != null) {
                    arrayList.add(Long.valueOf(bbVar.vD().live_id));
                    arrayList2.add(bbVar);
                }
                i++;
            }
            if (!w.z(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aEm() {
        if (this.dow != null && !this.mIsBackground && this.dXJ) {
            this.dow.b(this.dnI, this.bua, this.doo, true);
        }
        if (this.dXK) {
            if (this.dRo) {
                if (gO(false)) {
                    aT(3, this.dXF);
                } else if (this.dXL > 0) {
                    aT(2, this.dXF);
                }
            } else if (!this.dRo && this.dXF == 0) {
                aT(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dXK = false;
            this.dRo = false;
            this.dXL = 0;
            if (this.dXM) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.dXM = false;
        }
    }

    public void Tn() {
        if (AE()) {
            com.baidu.tieba.homepage.framework.a.aDK().h(0L, 1);
        } else if (this.dXB != null) {
            aEo();
            this.mPn++;
            setIsLoading(true);
            this.dXB.C(this.mPn, (this.dXC == null || this.dXC.thread_list == null) ? 0 : this.dXC.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dXC == null || this.dXC.thread_list == null) ? 0 : this.dXC.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.dXK = false;
            if (this.mDataList.size() > 0) {
                if (this.dXB != null) {
                    this.dXB.onError(1, str);
                }
            } else if (this.dXB != null) {
                this.dXB.onError(2, str);
            }
        } else {
            aEk();
            if (this.dXB != null) {
                this.dXB.onSuccess();
            }
            this.dXK = true;
            this.dRo = z;
            this.dXL = size;
            aoV();
        }
        setIsLoading(false);
        if (this.dXd != null) {
            this.dXd.setRefreshing(false);
        }
    }

    public void gH(boolean z) {
        if (z) {
            this.dWX.notifyDataSetChanged();
        }
        if (!aEn()) {
            aEq();
        }
    }

    public void onDestroy() {
        if (this.dow != null) {
            this.dow.destroy();
        }
        if (this.dXG != null) {
            this.dXG.onDestroy();
        }
        if (this.dXA != null) {
            this.dXA.onDestroy();
        }
        if (this.dqh != null) {
            this.dqh.removeCallbacks(this.dXV);
        }
    }

    public void onPause() {
        mS(this.dXU);
        if (this.dXI != null) {
            this.dXI.Kx();
        }
    }

    public boolean aEn() {
        if (gO(false)) {
            if (this.dqh != null) {
                this.dqh.setSelection(0);
                this.dXd.setRefreshing(true);
                return true;
            }
            return true;
        }
        return false;
    }

    private void tw() {
        if (this.dXB != null) {
            this.dXB.aR((this.dXC == null || this.dXC.thread_list == null || aEp()) ? 0 : this.dXC.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dTa = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aEp()) {
                if (this.dXB != null) {
                    this.dXB.onSuccess();
                }
                aEq();
                return;
            }
            tw();
            return;
        }
        tw();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void k(List<h> list, int i) {
        AdvertAppInfo ajq;
        AdvertAppInfo ajq2;
        if (!w.z(list)) {
            Set<h> sT = com.baidu.tieba.recapp.report.a.sT("NEWINDEX");
            HashSet hashSet = sT == null ? new HashSet() : sT;
            HashSet hashSet2 = new HashSet();
            for (h hVar : list) {
                if (hVar != null) {
                    for (h hVar2 : hashSet) {
                        if ((hVar instanceof com.baidu.tieba.card.data.d) && (ajq2 = ((com.baidu.tieba.card.data.d) hVar).ajq()) != null && hVar2 != null && (hVar2 instanceof AdvertAppInfo) && hVar2.hashCode() == ajq2.hashCode()) {
                            ajq2.advertAppContext = ((AdvertAppInfo) hVar2).advertAppContext;
                        }
                    }
                    if (hVar != null && (hVar instanceof com.baidu.tieba.card.data.d) && (ajq = ((com.baidu.tieba.card.data.d) hVar).ajq()) != null && ajq.advertAppContext == null) {
                        ajq.advertAppContext = new com.baidu.tbadk.core.data.b();
                        ajq.advertAppContext.adi = "NEWINDEX";
                        ajq.advertAppContext.pn = this.mPn;
                        ajq.advertAppContext.extensionInfo = ajq.extensionInfo;
                        ajq.advertAppContext.OY = false;
                        hashSet2.add(ajq);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.a("NEWINDEX", hashSet);
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<h> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.dXD = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aEp()) {
            this.dXC = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dXH.a(z, this.dXC, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.bhF;
            this.dXF = a2.dZw;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.dXM) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.dXC == null) {
            this.dXC = builder;
            this.dXA.bR(this.dXC.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.dXN = new g();
                    this.dXN.a(dataRes.live_answer);
                    this.dXC.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.dXN = null;
                    this.dXC.live_answer = null;
                }
                this.dXP = dataRes.float_info;
                this.dXC.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.dXN != null && !ap.U(j)) {
                this.mDataList.add(0, this.dXN);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.dWX.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dWX.ai(linkedList);
            z4 = true;
            if (this.dow != null && this.dXJ) {
                this.dow.b(this.dnI, this.bua, this.doo, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aDK().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long mE = com.baidu.tieba.homepage.framework.a.aDK().mE(1);
        if (mE > 0) {
            com.baidu.tieba.homepage.framework.a.aDK().g(System.currentTimeMillis() - mE, 1);
            com.baidu.tieba.homepage.framework.a.aDK().h(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.c.d(dataRes.anti.block_pop_info);
        }
        com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
        asVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, asVar));
        return z4;
    }

    private void aEo() {
        if (w.y(this.mDataList) >= this.dXH.aEF() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.dXH.a(true, this.dXC, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.bhF : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.dWX.ai(new LinkedList(this.mDataList));
            }
        }
    }

    private void tx() {
        this.dTa = true;
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.d.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aEv */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> P = com.baidu.tbadk.core.c.a.xb().P("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        if (this.dXC != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dXC.build(true));
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
    public void ny(String str) {
        if (!TextUtils.isEmpty(str) && this.dXC != null && this.dXC.banner_list != null && this.dXC.banner_list.app != null && this.dXC.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.dXC.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.dXC.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.dXC.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.dXC.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.20
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                d.this.dXA.bS(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.xb().P("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aEp() {
        return gO(true);
    }

    private boolean gO(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dXz;
    }

    public void a(a aVar) {
        this.dXB = aVar;
    }

    private boolean AE() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEq() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.dXD != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dXD) {
                aT(1, 0);
            }
        }
    }

    public void aEh() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.BD() && !StringUtils.isNull(activityPrizeData.BL())) {
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
        if (this.dWK != null) {
            this.dXG.avS();
        }
        if (this.dWK != null && this.dWK.getCurrentTabType() != 1) {
            this.dXG.hideTip();
        } else if (!this.dXO) {
            this.dXG.hideTip();
        } else {
            this.dXE = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().BL();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.alu == null) {
                    this.alu = new TextView(this.mPageContext.getPageActivity());
                    this.alu.setGravity(17);
                    this.alu.setOnClickListener(this.dXQ);
                }
                this.dXG.avS();
                FrameLayout frameLayout = this.dWK.getFrameLayout();
                if (frameLayout != null && this.alu.getParent() == null) {
                    if (i == 1) {
                        if (j.jE()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                            this.alu.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.alu.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            am.i(this.alu, d.f.bg_home_float);
                            am.h(this.alu, d.C0140d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.dWN;
                        } else {
                            return;
                        }
                    } else {
                        this.alu.setPadding(0, 0, 0, 0);
                        this.alu.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                        am.i(this.alu, d.C0140d.common_color_10260);
                        am.h(this.alu, d.C0140d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.dWN;
                    }
                    this.alu.setText(str);
                    if (i == 1) {
                        this.dpS = 4000;
                    } else if (i == 4) {
                        this.dpS = 3000;
                    } else {
                        this.dpS = 2000;
                    }
                    this.dXG.a(this.alu, frameLayout, layoutParams, this.dpS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.dXC != null && this.dXC.thread_list != null) {
            List<ThreadInfo> list = this.dXC.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aoV();
                    a(false, true, false, this.dXC.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.axI != null) {
                this.axI.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.axI);
            }
            if (this.dXR != null) {
                this.dXR.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dXR);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.dXS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dXS);
            this.dEj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dEj);
            this.dEk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dEk);
            this.dEl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dEl);
            if (this.dow != null) {
                this.dow.setUniqueId(bdUniqueId);
            }
            this.dXA.h(bdUniqueId);
            this.dXX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dXX);
        }
    }

    public void aEr() {
        this.dmm = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dmm.bvG();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.dmm != null) {
            if (i == 0) {
                this.dmm.bvG();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gNu;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dmm.bJ(i3, i7 + 1);
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
        if ((this.dmm != null ? this.dmm.tG(i) : -1) >= 0 && this.dqh != null && this.dqh.getData() != null && this.dqh.getData().size() > i) {
            this.dmm.tH(i);
        }
    }

    public m avc() {
        return this.dow;
    }

    public void gP(boolean z) {
        this.dXJ = z;
    }

    public void mS(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.d.5
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> Q = com.baidu.tbadk.core.c.a.xb().Q(d.this.dXT, TbadkCoreApplication.getCurrentAccount());
                if (Q != null) {
                    Q.a(d.this.dXT, Integer.toString(i), 43200000L);
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
            /* renamed from: aEu */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> Q = com.baidu.tbadk.core.c.a.xb().Q(d.this.dXT, TbadkCoreApplication.getCurrentAccount());
                if (Q != null) {
                    return Q.get(d.this.dXT);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.g<String>() { // from class: com.baidu.tieba.homepage.personalize.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: nz */
            public void onReturnDataInUI(String str) {
                if (cVar != null) {
                    cVar.mF(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void aEs() {
        a(this.dXW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        int b;
        String str;
        int i = 0;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.dXC != null && w.y(this.dXC.thread_list) != 0 && w.y(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.dqh != null && !TextUtils.isEmpty(optString2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.dqh.getCount()) {
                            str = optString;
                            break;
                        }
                        h item = this.dqh.getItem(i2);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.Td() != null && jVar.Td().vD() != null && optString2.equals(String.valueOf(jVar.Td().vD().live_id))) {
                                str = jVar.Td().getTid();
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
                    if (cVar.Td() != null && cVar.Td().getTid() != null && cVar.Td().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bU(this.mDataList);
                        break;
                    }
                }
            }
            if (this.dXC != null && this.dXC.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                while (true) {
                    if (i < this.dXC.thread_list.size()) {
                        ThreadInfo threadInfo = this.dXC.thread_list.get(i);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                            i++;
                        } else {
                            this.dXC.thread_list.remove(i);
                            aoV();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i, this.dXC.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.dqh != null && (b = b(optString, this.dqh)) != -1) {
                    this.dqh.removeItem(b);
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
                    if (cVar.Td() != null && cVar.Td().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).ajq();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.ub() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.ub()).getAdvertAppInfo();
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

    public FloatInfo aEt() {
        return this.dXP;
    }
}
