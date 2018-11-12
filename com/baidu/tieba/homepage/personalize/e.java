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
    private View.OnTouchListener aRR;
    private t bfl;
    private com.baidu.tieba.tbadkCore.data.e dBA;
    private m dDJ;
    private final BdTypeRecyclerView dFK;
    private com.baidu.tieba.f.a dWO;
    private boolean ehP;
    private final BigdaySwipeRefreshLayout enH;
    private ScrollFragmentTabHost enn;
    private final l enz;
    private Runnable eoA;
    private final long eod;
    private final b eoe;
    private DataRes.Builder eoh;
    private as eol;
    private final com.baidu.tieba.homepage.personalize.model.a eom;
    private int eoq;
    private g eos;
    private int mHeaderHeight;
    private final TbPageContext<?> mPageContext;
    private a eog = null;
    private final List<h> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean ejA = false;
    private long eoi = 0;
    private int eoj = 1;
    private int eok = 0;
    private TextView atD = null;
    private int dFv = 2000;
    private com.baidu.tbadk.l.c eon = null;
    private boolean dDB = false;
    private int dCW = 0;
    private int bJl = 0;
    private boolean mIsBackground = false;
    private boolean eoo = true;
    private boolean eop = false;
    private boolean eor = false;
    private boolean eot = true;
    private FloatInfo eou = null;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int eoG = -1;
        private int ejF = 0;
        private boolean eoH = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.eon == null) {
                e.this.eon = new com.baidu.tbadk.l.c();
                e.this.eon.fU(1005);
                e.this.eon.pageType = 1;
            }
            if (e.this.bfl != null && !e.this.mIsBackground) {
                e.this.bfl.g(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.dFK);
                e.this.eon.NX();
                v.anQ().dP(true);
                if (this.eoH) {
                    e.this.aJs();
                }
                this.eoH = false;
                if (e.this.dDJ != null && e.this.eoo) {
                    e.this.dDJ.a(e.this.dCW, e.this.bJl, e.this.dDB, 1);
                    return;
                }
                return;
            }
            e.this.eon.NW();
            if (i == 1 && e.this.eol != null) {
                e.this.eol.hideTip();
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
            if (this.ejF > i) {
                this.eoH = true;
            }
            if (e.this.bfl != null && !e.this.mIsBackground) {
                e.this.bfl.onScroll(this.ejF, i);
            }
            this.ejF = i;
            int i3 = (i + i2) - 1;
            if (!this.eoH && this.eoG != i3) {
                this.eoG = i3;
                e.this.ol(this.eoG);
            }
            if (this.eoH && this.eoG != i) {
                this.eoG = i;
                e.this.ol(this.eoG);
            }
            e.this.eoz = i;
            e.this.dCW = i;
            e.this.bJl = (i + i2) - 1;
        }
    };
    private View.OnTouchListener bfm = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.aRR != null) {
                e.this.aRR.onTouch(view, motionEvent);
            }
            if (e.this.dWO != null) {
                e.this.dWO.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0204a crS = new a.InterfaceC0204a() { // from class: com.baidu.tieba.homepage.personalize.e.15
        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void ap(int i, int i2) {
            e.this.dDB = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void aq(int i, int i2) {
            e.this.dDB = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0204a
        public void ar(int i, int i2) {
        }
    };
    private View.OnClickListener eov = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.eol != null) {
                e.this.eol.hideTip();
            }
            if (e.this.eoj == 1 && e.this.dFK != null) {
                e.this.dFK.setSelection(0);
                e.this.enH.setRefreshing(true);
            }
        }
    };
    private final CustomMessageListener eow = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.dFK != null) {
                e.this.dDJ.aKF();
                e.this.eoo = false;
                e.this.enH.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener dRZ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bb bbVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && e.this.eoh != null && com.baidu.tbadk.core.util.v.H(e.this.eoh.thread_list) != 0 && (bbVar = (bb) customResponsedMessage.getData()) != null && bbVar.yp() != null && bbVar.getId() != null && com.baidu.tbadk.core.util.v.H(e.this.eoh.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.eoh.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.eoh.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.d(bbVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bbVar.yp().getNum());
                            builder.zan = builder2.build(true);
                            e.this.eoh.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener eox = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.3
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
                        if ((originData.get(i2) instanceof bb) && (bbVar = (bb) originData.get(i2)) != null && bbVar.yW() != null && ids.contains(Long.valueOf(bbVar.yW().live_id))) {
                            e.this.mDataList.remove(bbVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.enz != null) {
                        e.this.enz.ak(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.eoh != null && !com.baidu.tbadk.core.util.v.I(e.this.eoh.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.eoh.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.eoh.thread_list.get(i);
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
                            e.this.eoh.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String eoy = "lastReadReadPositionKey";
    private int eoz = 0;
    private d eoB = new d() { // from class: com.baidu.tieba.homepage.personalize.e.6
        @Override // com.baidu.tieba.homepage.personalize.d
        public void nZ(final int i) {
            if (e.this.eoA == null) {
                e.this.eoA = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.dFK.getHandler() != null) {
                            e.this.dFK.requestFocusFromTouch();
                            if (i <= e.this.dFK.getCount() - 1) {
                                e.this.dFK.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.dFK.removeCallbacks(e.this.eoA);
            e.this.dFK.post(e.this.eoA);
        }
    };
    private CustomMessageListener eoC = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.eos != null) {
                e.this.mDataList.remove(e.this.eos);
                e.this.enz.ak(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener dTZ = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dUa = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener dUb = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.eoh != null && com.baidu.tbadk.core.util.v.H(e.this.eoh.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.oK(str);
                if (e.this.enz != null) {
                    e.this.enz.ak(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void H(int i, int i2, int i3);

        void ba(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void hN(boolean z) {
        this.eot = z;
        if (this.eol != null && !z) {
            this.eol.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.enn = scrollFragmentTabHost;
        if (this.enn != null) {
            this.enn.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void ok(int i) {
                    if (e.this.enn.oj(i) != 1 && e.this.eol != null) {
                        e.this.eol.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void gC(boolean z) {
        this.mIsBackground = z;
        if (this.dDJ != null) {
            this.dDJ.jw(!z);
            if (z) {
                this.dDJ.aKF();
            } else if (this.eoo) {
                this.dDJ.b(this.dCW, this.bJl, this.dDB, true);
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, l lVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.mPageContext = tbPageContext;
        this.enH = bigdaySwipeRefreshLayout;
        this.dFK = bdTypeRecyclerView;
        this.dFK.setOnTouchListener(this.bfm);
        this.dWO = new com.baidu.tieba.f.a();
        this.dWO.a(this.crS);
        this.enz = lVar;
        this.eom = new com.baidu.tieba.homepage.personalize.model.a();
        this.eod = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.eol = new as();
        aJt();
        this.dDJ = new m(this.mPageContext, this.dFK);
        this.eoe = new b(this.mDataList, this.enz);
    }

    private boolean aJl() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aJn(), true);
    }

    private void aJm() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aJn(), false);
    }

    private String aJn() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + BaseRequestAction.SPLITE + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (uVar != null) {
            this.bfl = uVar.OX();
            this.aRR = uVar.OY();
        }
    }

    public void showFloatingView() {
        if (this.bfl != null) {
            this.bfl.cR(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.aIK().k(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.eor = true;
        if (this.mDataList.size() == 0 && !aJl()) {
            if (!this.ejA) {
                wQ();
                return;
            }
            return;
        }
        wP();
    }

    public void bb(int i, int i2) {
        bb bbVar;
        if (!com.baidu.tbadk.core.util.v.I(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bb.apK.getId() && (bbVar = (bb) this.mDataList.get(i)) != null && bbVar.yW() != null) {
                    arrayList.add(Long.valueOf(bbVar.yW().live_id));
                    arrayList2.add(bbVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.I(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aJo() {
        if (this.dDJ != null && !this.mIsBackground && this.eoo) {
            this.dDJ.b(this.dCW, this.bJl, this.dDB, true);
        }
        if (this.eop) {
            if (this.ehP) {
                if (hO(false)) {
                    bc(3, this.eok);
                } else if (this.eoq > 0) {
                    bc(2, this.eok);
                }
            } else if (!this.ehP && this.eok == 0) {
                bc(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.eop = false;
            this.ehP = false;
            this.eoq = 0;
            if (this.eor) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.eor = false;
        }
    }

    public void YV() {
        if (Ee()) {
            com.baidu.tieba.homepage.framework.a.aIK().k(0L, 1);
        } else if (this.eog != null) {
            aJq();
            this.mPn++;
            setIsLoading(true);
            this.eog.H(this.mPn, (this.eoh == null || this.eoh.thread_list == null) ? 0 : this.eoh.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.eoh == null || this.eoh.thread_list == null) ? 0 : this.eoh.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.eop = false;
            if (this.mDataList.size() > 0) {
                if (this.eog != null) {
                    this.eog.onError(1, str);
                }
            } else if (this.eog != null) {
                this.eog.onError(2, str);
            }
        } else {
            aJm();
            if (this.eog != null) {
                this.eog.onSuccess();
            }
            this.eop = true;
            this.ehP = z;
            this.eoq = size;
            atG();
        }
        setIsLoading(false);
        if (this.enH != null) {
            this.enH.setRefreshing(false);
        }
    }

    public void hH(boolean z) {
        if (z) {
            this.enz.notifyDataSetChanged();
        }
        if (!aJp()) {
            aJs();
        }
    }

    public void onDestroy() {
        if (this.dDJ != null) {
            this.dDJ.destroy();
        }
        if (this.eol != null) {
            this.eol.onDestroy();
        }
        if (this.eoe != null) {
            this.eoe.onDestroy();
        }
        if (this.dFK != null) {
            this.dFK.removeCallbacks(this.eoA);
        }
    }

    public void onPause() {
        c.d(this.dFK);
        om(this.eoz);
        if (this.eon != null) {
            this.eon.NY();
        }
    }

    public boolean aJp() {
        if (hO(false)) {
            if (this.dFK != null) {
                this.dFK.setSelection(0);
                this.enH.setRefreshing(true);
                return true;
            }
            return true;
        }
        return false;
    }

    private void wP() {
        if (this.eog != null) {
            this.eog.ba((this.eoh == null || this.eoh.thread_list == null || aJr()) ? 0 : this.eoh.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.ejA = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aJr()) {
                if (this.eog != null) {
                    this.eog.onSuccess();
                }
                aJs();
                return;
            }
            wP();
            return;
        }
        wP();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void l(List<h> list, int i) {
        AdvertAppInfo aoi;
        AdvertAppInfo aoi2;
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            Set<h> uk = com.baidu.tieba.recapp.report.a.uk("NEWINDEX");
            HashSet hashSet = uk == null ? new HashSet() : uk;
            HashSet hashSet2 = new HashSet();
            for (h hVar : list) {
                if (hVar != null) {
                    for (h hVar2 : hashSet) {
                        if ((hVar instanceof com.baidu.tieba.card.data.d) && (aoi2 = ((com.baidu.tieba.card.data.d) hVar).aoi()) != null && hVar2 != null && (hVar2 instanceof AdvertAppInfo) && hVar2.hashCode() == aoi2.hashCode()) {
                            aoi2.advertAppContext = ((AdvertAppInfo) hVar2).advertAppContext;
                        }
                    }
                    if (hVar != null && (hVar instanceof com.baidu.tieba.card.data.d) && (aoi = ((com.baidu.tieba.card.data.d) hVar).aoi()) != null && aoi.advertAppContext == null) {
                        aoi.advertAppContext = new com.baidu.tbadk.core.data.b();
                        aoi.advertAppContext.page = "NEWINDEX";
                        aoi.advertAppContext.pn = this.mPn;
                        aoi.advertAppContext.extensionInfo = aoi.extensionInfo;
                        aoi.advertAppContext.RT = false;
                        hashSet2.add(aoi);
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
        this.eoi = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aJr()) {
            this.eoh = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.eom.a(z, this.eoh, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<h> list2 = a2.bsm;
            this.eok = a2.eqd;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            l(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.eor) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.eoh == null) {
            this.eoh = builder;
            this.eoe.cg(this.eoh.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.eos = new g();
                    this.eos.a(dataRes.live_answer);
                    this.eoh.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.eos = null;
                    this.eoh.live_answer = null;
                }
                this.eou = dataRes.float_info;
                this.eoh.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.eos != null && !ao.ac(j)) {
                this.mDataList.add(0, this.eos);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.enz.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.enz.ak(linkedList);
            z4 = true;
            if (this.dDJ != null && this.eoo) {
                this.dDJ.b(this.dCW, this.bJl, this.dDB, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aIK().i(System.currentTimeMillis() - currentTimeMillis, 1);
        long nY = com.baidu.tieba.homepage.framework.a.aIK().nY(1);
        if (nY > 0) {
            com.baidu.tieba.homepage.framework.a.aIK().j(System.currentTimeMillis() - nY, 1);
            com.baidu.tieba.homepage.framework.a.aIK().k(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.c.d(dataRes.anti.block_pop_info);
        }
        com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
        asVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, asVar));
        return z4;
    }

    private void aJq() {
        if (com.baidu.tbadk.core.util.v.H(this.mDataList) >= this.eom.aJH() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.eom.a(true, this.eoh, (DataRes.Builder) null, 1);
            List<h> list = a2 != null ? a2.bsm : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.enz.ak(new LinkedList(this.mDataList));
            }
        }
    }

    private void wQ() {
        this.ejA = true;
        x.a(new w<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: aJx */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> aj = com.baidu.tbadk.core.c.a.Ax().aj("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (aj == null) {
                    return null;
                }
                byte[] bArr = aj.get("0");
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

    private void atG() {
        if (this.eoh != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eoh.build(true));
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
    public void oK(String str) {
        if (!TextUtils.isEmpty(str) && this.eoh != null && this.eoh.banner_list != null && this.eoh.banner_list.app != null && this.eoh.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.eoh.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.eoh.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.eoh.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.eoh.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.20
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.eoe.ch(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.Ax().aj("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aJr() {
        return hO(true);
    }

    private boolean hO(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.eod;
    }

    public void a(a aVar) {
        this.eog = aVar;
    }

    private boolean Ee() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJs() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.eoi != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.eoi) {
                bc(1, 0);
            }
        }
    }

    public void aJi() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.Fd() && !StringUtils.isNull(activityPrizeData.Fl())) {
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
                    bc(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bc(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.enn != null) {
            this.eol.aAV();
        }
        if (this.enn != null && this.enn.getCurrentTabType() != 1) {
            this.eol.hideTip();
        } else if (!this.eot) {
            this.eol.hideTip();
        } else {
            this.eoj = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().Fl();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.atD == null) {
                    this.atD = new TextView(this.mPageContext.getPageActivity());
                    this.atD.setGravity(17);
                    this.atD.setOnClickListener(this.eov);
                }
                this.eol.aAV();
                FrameLayout frameLayout = this.enn.getFrameLayout();
                if (frameLayout != null && this.atD.getParent() == null) {
                    if (i == 1) {
                        if (j.kV()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds40);
                            this.atD.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.atD.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            al.i(this.atD, e.f.bg_home_float);
                            al.h(this.atD, e.d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.mHeaderHeight;
                        } else {
                            return;
                        }
                    } else {
                        this.atD.setPadding(0, 0, 0, 0);
                        this.atD.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.fontsize24));
                        al.i(this.atD, e.d.common_color_10260);
                        al.h(this.atD, e.d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0200e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.mHeaderHeight;
                    }
                    this.atD.setText(str);
                    if (i == 1) {
                        this.dFv = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
                    } else if (i == 4) {
                        this.dFv = 3000;
                    } else {
                        this.dFv = 2000;
                    }
                    this.eol.a(this.atD, frameLayout, layoutParams, this.dFv);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Long l) {
        if (this.eoh != null && this.eoh.thread_list != null) {
            List<ThreadInfo> list = this.eoh.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    atG();
                    a(false, true, false, this.eoh.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dRZ != null) {
                this.dRZ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dRZ);
            }
            if (this.eow != null) {
                this.eow.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.eow);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.eox.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eox);
            this.dTZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dTZ);
            this.dUa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dUa);
            this.dUb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dUb);
            if (this.dDJ != null) {
                this.dDJ.setUniqueId(bdUniqueId);
            }
            this.eoe.h(bdUniqueId);
            this.eoC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eoC);
        }
    }

    public void aJt() {
        this.dBA = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dBA.bAY();
    }

    public void a(int i, List<h> list, int i2) {
        int i3;
        int i4;
        if (this.dBA != null) {
            if (i == 0) {
                this.dBA.bAY();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.hdT;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dBA.bS(i3, i7 + 1);
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

    public void ol(int i) {
        if ((this.dBA != null ? this.dBA.uW(i) : -1) >= 0 && this.dFK != null && this.dFK.getData() != null && this.dFK.getData().size() > i) {
            this.dBA.uX(i);
        }
    }

    public m azN() {
        return this.dDJ;
    }

    public void hP(boolean z) {
        this.eoo = z;
    }

    public void om(final int i) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> ak = com.baidu.tbadk.core.c.a.Ax().ak(e.this.eoy, TbadkCoreApplication.getCurrentAccount());
                if (ak != null) {
                    ak.a(e.this.eoy, Integer.toString(i), 43200000L);
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
            /* renamed from: aJw */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> ak = com.baidu.tbadk.core.c.a.Ax().ak(e.this.eoy, TbadkCoreApplication.getCurrentAccount());
                if (ak != null) {
                    return ak.get(e.this.eoy);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: oL */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.nZ(com.baidu.adp.lib.g.b.l(str, 0));
                }
            }
        });
    }

    public void aJk() {
        c.e(this.dFK);
    }

    public void aJu() {
        a(this.eoB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        int b;
        String str;
        int i = 0;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eoh != null && com.baidu.tbadk.core.util.v.H(this.eoh.thread_list) != 0 && com.baidu.tbadk.core.util.v.H(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.dFK != null && !TextUtils.isEmpty(optString2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.dFK.getCount()) {
                            str = optString;
                            break;
                        }
                        h item = this.dFK.getItem(i2);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.YL() != null && jVar.YL().yW() != null && optString2.equals(String.valueOf(jVar.YL().yW().live_id))) {
                                str = jVar.YL().getTid();
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
                    if (cVar.YL() != null && cVar.YL().getTid() != null && cVar.YL().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.cj(this.mDataList);
                        break;
                    }
                }
            }
            if (this.eoh != null && this.eoh.thread_list != null) {
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                while (true) {
                    if (i < this.eoh.thread_list.size()) {
                        ThreadInfo threadInfo = this.eoh.thread_list.get(i);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != d) {
                            i++;
                        } else {
                            this.eoh.thread_list.remove(i);
                            atG();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i, this.eoh.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.dFK != null && (b = b(optString, this.dFK)) != -1) {
                    this.dFK.removeItem(b);
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
                    if (cVar.YL() != null && cVar.YL().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).aoi();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.xu() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.xu()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.alP)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aJv() {
        return this.eou;
    }
}
