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
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
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
    private View.OnTouchListener aVZ;
    private u bjB;
    private com.baidu.tieba.tbadkCore.data.e dLw;
    private m dNF;
    private final BdTypeRecyclerView dPG;
    private com.baidu.tieba.f.a egP;
    private boolean esg;
    private ScrollFragmentTabHost exJ;
    private final l exV;
    private final long eyA;
    private final b eyB;
    private DataRes.Builder eyD;
    private as eyH;
    private final com.baidu.tieba.homepage.personalize.model.a eyI;
    private int eyM;
    private g eyO;
    private BdUniqueId eyR;
    private Runnable eyX;
    private final BigdaySwipeRefreshLayout eyd;
    private int mHeaderHeight;
    private final TbPageContext<?> mPageContext;
    private a eyC = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean etS = false;
    private long eyE = 0;
    private int eyF = 1;
    private int eyG = 0;
    private TextView axG = null;
    private int dPr = 2000;
    private com.baidu.tbadk.l.c eyJ = null;
    private boolean dNx = false;
    private int dMS = 0;
    private int bNP = 0;
    private boolean mIsBackground = false;
    private boolean eyK = true;
    private boolean eyL = false;
    private boolean eyN = false;
    private boolean eyP = true;
    private FloatInfo eyQ = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int ezd = -1;
        private int etX = 0;
        private boolean eze = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.eyJ == null) {
                e.this.eyJ = new com.baidu.tbadk.l.c();
                e.this.eyJ.gj(1005);
                e.this.eyJ.pageType = 1;
            }
            if (e.this.bjB != null && !e.this.mIsBackground) {
                e.this.bjB.g(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.dPG);
                e.this.eyJ.Pu();
                v.aqP().dT(true);
                com.baidu.tieba.q.c.bCC().b(e.this.eyR, false);
                if (this.eze) {
                    e.this.aMx();
                }
                this.eze = false;
                if (e.this.dNF != null && e.this.eyK) {
                    e.this.dNF.a(e.this.dMS, e.this.bNP, e.this.dNx, 1);
                    return;
                }
                return;
            }
            e.this.eyJ.Pt();
            if (i == 1 && e.this.eyH != null) {
                e.this.eyH.hideTip();
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
            if (this.etX > i) {
                this.eze = true;
            }
            if (e.this.bjB != null && !e.this.mIsBackground) {
                e.this.bjB.onScroll(this.etX, i);
            }
            this.etX = i;
            int i3 = (i + i2) - 1;
            if (!this.eze && this.ezd != i3) {
                this.ezd = i3;
                e.this.oT(this.ezd);
            }
            if (this.eze && this.ezd != i) {
                this.ezd = i;
                e.this.oT(this.ezd);
            }
            e.this.eyW = i;
            e.this.dMS = i;
            e.this.bNP = (i + i2) - 1;
        }
    };
    private View.OnTouchListener bjC = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.aVZ != null) {
                e.this.aVZ.onTouch(view, motionEvent);
            }
            if (e.this.egP != null) {
                e.this.egP.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0214a cxB = new a.InterfaceC0214a() { // from class: com.baidu.tieba.homepage.personalize.e.15
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            e.this.dNx = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            e.this.dNx = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }
    };
    private View.OnClickListener eyS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.eyH != null) {
                e.this.eyH.hideTip();
            }
            if (e.this.eyF == 1 && e.this.dPG != null) {
                e.this.dPG.setSelection(0);
                e.this.eyd.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener eyT = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.dPG != null) {
                e.this.dNF.aNK();
                e.this.eyK = false;
                e.this.eyd.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener ebY = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && e.this.eyD != null && com.baidu.tbadk.core.util.v.H(e.this.eyD.thread_list) != 0 && (bbVar = (bb) customResponsedMessage.getData()) != null && bbVar.zG() != null && bbVar.getId() != null && com.baidu.tbadk.core.util.v.H(e.this.eyD.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.eyD.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.eyD.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.d(bbVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bbVar.zG().getNum());
                            builder.zan = builder2.build(true);
                            e.this.eyD.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener eyU = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.3
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
                        if ((originData.get(i2) instanceof bb) && (bbVar = (bb) originData.get(i2)) != null && bbVar.An() != null && ids.contains(Long.valueOf(bbVar.An().live_id))) {
                            e.this.mDataList.remove(bbVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.exV != null) {
                        e.this.exV.al(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.eyD != null && !com.baidu.tbadk.core.util.v.I(e.this.eyD.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.eyD.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.eyD.thread_list.get(i);
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
                            e.this.eyD.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String eyV = "lastReadReadPositionKey";
    private int eyW = 0;
    private d eyY = new d() { // from class: com.baidu.tieba.homepage.personalize.e.6
        @Override // com.baidu.tieba.homepage.personalize.d
        public void oH(final int i) {
            if (e.this.eyX == null) {
                e.this.eyX = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dPG.getHandler() != null) {
                            e.this.dPG.requestFocusFromTouch();
                            if (i <= e.this.dPG.getCount() - 1) {
                                e.this.dPG.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.dPG.removeCallbacks(e.this.eyX);
            e.this.dPG.post(e.this.eyX);
        }
    };
    private CustomMessageListener eyZ = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.eyO != null) {
                e.this.mDataList.remove(e.this.eyO);
                e.this.exV.al(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener edZ = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener eea = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener eeb = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.eyD != null && com.baidu.tbadk.core.util.v.H(e.this.eyD.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.pF(str);
                if (e.this.exV != null) {
                    e.this.exV.al(new ArrayList(e.this.mDataList));
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
        this.eyP = z;
        if (this.eyH != null && !z) {
            this.eyH.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.exJ = scrollFragmentTabHost;
        if (this.exJ != null) {
            this.exJ.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void oS(int i) {
                    if (e.this.exJ.oR(i) != 1 && e.this.eyH != null) {
                        e.this.eyH.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void gJ(boolean z) {
        this.mIsBackground = z;
        if (this.dNF != null) {
            this.dNF.jC(!z);
            if (z) {
                this.dNF.aNK();
            } else if (this.eyK) {
                this.dNF.b(this.dMS, this.bNP, this.dNx, true);
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, l lVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.mPageContext = tbPageContext;
        this.eyd = bigdaySwipeRefreshLayout;
        this.dPG = bdTypeRecyclerView;
        this.dPG.setOnTouchListener(this.bjC);
        this.egP = new com.baidu.tieba.f.a();
        this.egP.a(this.cxB);
        this.exV = lVar;
        this.eyI = new com.baidu.tieba.homepage.personalize.model.a();
        this.eyA = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.eyH = new as();
        aMy();
        this.dNF = new m(this.mPageContext, this.dPG);
        this.eyB = new b(this.mDataList, this.exV);
    }

    private boolean aMq() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aMs(), true);
    }

    private void aMr() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aMs(), false);
    }

    private String aMs() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + BaseRequestAction.SPLITE + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.v vVar) {
        if (vVar != null) {
            this.bjB = vVar.QA();
            this.aVZ = vVar.QB();
        }
    }

    public void showFloatingView() {
        if (this.bjB != null) {
            this.bjB.cV(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.aLO().k(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.eyN = true;
        if (this.mDataList.size() == 0 && !aMq()) {
            if (!this.etS) {
                yh();
                return;
            }
            return;
        }
        yg();
    }

    public void ba(int i, int i2) {
        bb bbVar;
        if (!com.baidu.tbadk.core.util.v.I(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bb.atM.getId() && (bbVar = (bb) this.mDataList.get(i)) != null && bbVar.An() != null) {
                    arrayList.add(Long.valueOf(bbVar.An().live_id));
                    arrayList2.add(bbVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.I(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aMt() {
        if (this.dNF != null && !this.mIsBackground && this.eyK) {
            this.dNF.b(this.dMS, this.bNP, this.dNx, true);
        }
        if (this.eyL) {
            if (this.esg) {
                com.baidu.tieba.q.c.bCC().b(this.eyR, false);
                if (hU(false)) {
                    bb(3, this.eyG);
                } else if (this.eyM > 0) {
                    bb(2, this.eyG);
                }
            } else if (!this.esg && this.eyG == 0) {
                bb(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.eyL = false;
            this.esg = false;
            this.eyM = 0;
            if (this.eyN) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.eyN = false;
        }
    }

    public void aaA() {
        if (Fv()) {
            com.baidu.tieba.homepage.framework.a.aLO().k(0L, 1);
        } else if (this.eyC != null) {
            aMv();
            this.mPn++;
            setIsLoading(true);
            this.eyC.s(this.mPn, (this.eyD == null || this.eyD.thread_list == null) ? 0 : this.eyD.thread_list.size(), hT(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.eyD == null || this.eyD.thread_list == null) ? 0 : this.eyD.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.eyL = false;
            if (this.mDataList.size() > 0) {
                if (this.eyC != null) {
                    this.eyC.onError(1, str);
                }
            } else if (this.eyC != null) {
                this.eyC.onError(2, str);
            }
        } else {
            aMr();
            if (this.eyC != null) {
                this.eyC.onSuccess();
            }
            this.eyL = true;
            this.esg = z;
            this.eyM = size;
            awE();
        }
        setIsLoading(false);
        if (this.eyd != null) {
            this.eyd.setRefreshing(false);
        }
    }

    public void hM(boolean z) {
        if (z) {
            this.exV.notifyDataSetChanged();
        }
        if (!aMu()) {
            aMx();
        }
    }

    public void onDestroy() {
        if (this.dNF != null) {
            this.dNF.destroy();
        }
        if (this.eyH != null) {
            this.eyH.onDestroy();
        }
        if (this.eyB != null) {
            this.eyB.onDestroy();
        }
        if (this.dPG != null) {
            this.dPG.removeCallbacks(this.eyX);
        }
    }

    public void onPause() {
        c.d(this.dPG);
        oU(this.eyW);
        if (this.eyJ != null) {
            this.eyJ.Pv();
        }
    }

    public boolean aMu() {
        if (hU(false)) {
            if (this.dPG != null) {
                this.dPG.setSelection(0);
                this.eyd.setRefreshing(true);
                return true;
            }
            return true;
        }
        return false;
    }

    private void yg() {
        if (this.eyC != null) {
            this.eyC.H((this.eyD == null || this.eyD.thread_list == null || aMw()) ? 0 : this.eyD.thread_list.size(), hT(true), 0);
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
                if (!(hVar instanceof com.baidu.tieba.homepage.personalize.data.a) || hVar.getType() == AdvertAppInfo.apH) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        } else {
            for (int size = this.mDataList.size() - 1; size >= 0; size--) {
                h hVar2 = this.mDataList.get(size);
                if ((hVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && hVar2.getType() != AdvertAppInfo.apH) {
                    return (this.mDataList.size() - size) - 1;
                }
            }
        }
        return this.mDataList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.etS = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aMw()) {
                if (this.eyC != null) {
                    this.eyC.onSuccess();
                }
                aMx();
                return;
            }
            yg();
            return;
        }
        yg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void l(List<h> list, int i) {
        AdvertAppInfo arh;
        AdvertAppInfo arh2;
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            Set<h> ve = com.baidu.tieba.recapp.report.a.ve("NEWINDEX");
            HashSet hashSet = ve == null ? new HashSet() : ve;
            HashSet hashSet2 = new HashSet();
            for (h hVar : list) {
                if (hVar != null) {
                    for (h hVar2 : hashSet) {
                        if ((hVar instanceof com.baidu.tieba.card.data.d) && (arh2 = ((com.baidu.tieba.card.data.d) hVar).arh()) != null && hVar2 != null && (hVar2 instanceof AdvertAppInfo) && hVar2.hashCode() == arh2.hashCode()) {
                            arh2.advertAppContext = ((AdvertAppInfo) hVar2).advertAppContext;
                        }
                    }
                    if (hVar != null && (hVar instanceof com.baidu.tieba.card.data.d) && (arh = ((com.baidu.tieba.card.data.d) hVar).arh()) != null && arh.advertAppContext == null) {
                        arh.advertAppContext = new com.baidu.tbadk.core.data.b();
                        arh.advertAppContext.page = "NEWINDEX";
                        arh.advertAppContext.pn = this.mPn;
                        arh.advertAppContext.extensionInfo = arh.extensionInfo;
                        arh.advertAppContext.Sc = false;
                        hashSet2.add(arh);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.b("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.bCC().b(this.eyR, com.baidu.tieba.q.a.b("a002", "common_fill", true, hashSet2.size()));
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
        this.eyE = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aMw()) {
            this.eyD = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.eyI.a(z, this.eyD, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.bwC;
            this.eyG = a2.eAA;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            l(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.eyN) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.eyD == null) {
            this.eyD = builder;
            this.eyB.cm(this.eyD.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.eyO = new g();
                    this.eyO.a(dataRes.live_answer);
                    this.eyD.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.eyO = null;
                    this.eyD.live_answer = null;
                }
                this.eyQ = dataRes.float_info;
                this.eyD.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.eyO != null && !ao.ak(j)) {
                this.mDataList.add(0, this.eyO);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.exV.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.exV.al(linkedList);
            z4 = true;
            if (this.dNF != null && this.eyK) {
                this.dNF.b(this.dMS, this.bNP, this.dNx, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aLO().i(System.currentTimeMillis() - currentTimeMillis, 1);
        long oG = com.baidu.tieba.homepage.framework.a.aLO().oG(1);
        if (oG > 0) {
            com.baidu.tieba.homepage.framework.a.aLO().j(System.currentTimeMillis() - oG, 1);
            com.baidu.tieba.homepage.framework.a.aLO().k(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.c.d(dataRes.anti.block_pop_info);
        }
        com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
        asVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, asVar));
        return z4;
    }

    private void aMv() {
        if (com.baidu.tbadk.core.util.v.H(this.mDataList) >= this.eyI.aMM() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.eyI.a(true, this.eyD, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.bwC : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.exV.al(new LinkedList(this.mDataList));
            }
        }
    }

    private void yh() {
        this.etS = true;
        y.a(new x<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.x
            /* renamed from: aMC */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> an = com.baidu.tbadk.core.c.a.BO().an("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (an == null) {
                    return null;
                }
                byte[] bArr = an.get("0");
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

    private void awE() {
        if (this.eyD != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eyD.build(true));
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
    public void pF(String str) {
        if (!TextUtils.isEmpty(str) && this.eyD != null && this.eyD.banner_list != null && this.eyD.banner_list.app != null && this.eyD.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.eyD.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.eyD.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.eyD.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.eyD.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        y.a(new x<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.20
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.eyB.cn(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.BO().an("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aMw() {
        return hU(true);
    }

    private boolean hU(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.eyA;
    }

    public void a(a aVar) {
        this.eyC = aVar;
    }

    private boolean Fv() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMx() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.eyE != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.eyE) {
                bb(1, 0);
            }
        }
    }

    public void aMn() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.Gv() && !StringUtils.isNull(activityPrizeData.GD())) {
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
        if (this.exJ != null) {
            this.eyH.aDR();
        }
        if (this.exJ != null && this.exJ.getCurrentTabType() != 1) {
            this.eyH.hideTip();
        } else if (!this.eyP) {
            this.eyH.hideTip();
        } else {
            this.eyF = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().GD();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.axG == null) {
                    this.axG = new TextView(this.mPageContext.getPageActivity());
                    this.axG.setGravity(17);
                    this.axG.setOnClickListener(this.eyS);
                }
                this.eyH.aDR();
                FrameLayout frameLayout = this.exJ.getFrameLayout();
                if (frameLayout != null && this.axG.getParent() == null) {
                    if (i == 1) {
                        if (j.kV()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds40);
                            this.axG.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.axG.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            al.i(this.axG, e.f.bg_home_float);
                            al.h(this.axG, e.d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.mHeaderHeight;
                        } else {
                            return;
                        }
                    } else {
                        this.axG.setPadding(0, 0, 0, 0);
                        this.axG.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.fontsize24));
                        al.i(this.axG, e.d.common_color_10260);
                        al.h(this.axG, e.d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.mHeaderHeight;
                    }
                    this.axG.setText(str);
                    if (i == 1) {
                        this.dPr = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
                    } else if (i == 4) {
                        this.dPr = 3000;
                    } else {
                        this.dPr = 2000;
                    }
                    this.eyH.a(this.axG, frameLayout, layoutParams, this.dPr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Long l) {
        if (this.eyD != null && this.eyD.thread_list != null) {
            List<ThreadInfo> list = this.eyD.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    awE();
                    a(false, true, false, this.eyD.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eyR = bdUniqueId;
            if (this.ebY != null) {
                this.ebY.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ebY);
            }
            if (this.eyT != null) {
                this.eyT.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.eyT);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.eyU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eyU);
            this.edZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.edZ);
            this.eea.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eea);
            this.eeb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eeb);
            if (this.dNF != null) {
                this.dNF.setUniqueId(bdUniqueId);
            }
            this.eyB.h(bdUniqueId);
            this.eyZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eyZ);
        }
    }

    public void aMy() {
        this.dLw = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dLw.bEt();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.dLw != null) {
            if (i == 0) {
                this.dLw.bEt();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.hpd;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dLw.bR(i3, i7 + 1);
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

    public void oT(int i) {
        if ((this.dLw != null ? this.dLw.vI(i) : -1) >= 0 && this.dPG != null && this.dPG.getData() != null && this.dPG.getData().size() > i) {
            this.dLw.vJ(i);
        }
    }

    public m aCJ() {
        return this.dNF;
    }

    public void hV(boolean z) {
        this.eyK = z;
    }

    public void oU(final int i) {
        y.a(new x<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> ao = com.baidu.tbadk.core.c.a.BO().ao(e.this.eyV, TbadkCoreApplication.getCurrentAccount());
                if (ao != null) {
                    ao.a(e.this.eyV, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        y.a(new x<String>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.x
            /* renamed from: aMB */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> ao = com.baidu.tbadk.core.c.a.BO().ao(e.this.eyV, TbadkCoreApplication.getCurrentAccount());
                if (ao != null) {
                    return ao.get(e.this.eyV);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: pG */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.oH(com.baidu.adp.lib.g.b.l(str, 0));
                }
            }
        });
    }

    public void aMp() {
        c.e(this.dPG);
    }

    public void aMz() {
        a(this.eyY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        int b;
        String str;
        int i = 0;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eyD != null && com.baidu.tbadk.core.util.v.H(this.eyD.thread_list) != 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.dPG != null && !TextUtils.isEmpty(optString2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.dPG.getCount()) {
                            str = optString;
                            break;
                        }
                        h item = this.dPG.getItem(i2);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.aaq() != null && jVar.aaq().An() != null && optString2.equals(String.valueOf(jVar.aaq().An().live_id))) {
                                str = jVar.aaq().getTid();
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
                    if (cVar.aaq() != null && cVar.aaq().getTid() != null && cVar.aaq().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.cp(this.mDataList);
                        break;
                    }
                }
            }
            if (this.eyD != null && this.eyD.thread_list != null) {
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                while (true) {
                    if (i < this.eyD.thread_list.size()) {
                        ThreadInfo threadInfo = this.eyD.thread_list.get(i);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != d) {
                            i++;
                        } else {
                            this.eyD.thread_list.remove(i);
                            awE();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i, this.eyD.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.dPG != null && (b = b(optString, this.dPG)) != -1) {
                    this.dPG.removeItem(b);
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
                    if (cVar.aaq() != null && cVar.aaq().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).arh();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.yL() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.yL()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.apS)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aMA() {
        return this.eyQ;
    }
}
