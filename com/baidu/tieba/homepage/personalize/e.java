package com.baidu.tieba.homepage.personalize;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.a.a;
import com.baidu.card.z;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.v;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.play.m;
import com.squareup.wire.Wire;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes4.dex */
public class e {
    private int aIR;
    private View.OnTouchListener cfr;
    private w ctJ;
    private com.baidu.tieba.tbadkCore.data.f eYP;
    private boolean fEF;
    private final BigdaySwipeRefreshLayout fKD;
    private ScrollFragmentTabHost fKj;
    private final v fKv;
    private Runnable fLD;
    private final long fLf;
    private final b fLg;
    private DataRes.Builder fLi;
    private aq fLl;
    private final com.baidu.tieba.homepage.personalize.model.a fLm;
    private int fLq;
    private g fLs;
    private BdUniqueId fLv;
    private SmartBubbleAnimatedView fLw;
    private int fLx;
    private m fbl;
    private final BdTypeRecyclerView fdC;
    private com.baidu.tieba.f.a fvR;
    private final TbPageContext<?> mPageContext;
    private a fLh = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean fGr = false;
    private int fLj = 2;
    private int fLk = 0;
    private TextView bFG = null;
    private int fdn = 2000;
    private com.baidu.tbadk.o.c fLn = null;
    private boolean fbe = false;
    private int fay = 0;
    private int cZV = 0;
    private boolean mIsBackground = false;
    private boolean fLo = true;
    private boolean fLp = false;
    private boolean fLr = false;
    private boolean fLt = true;
    private FloatInfo fLu = null;
    private a.C0037a eZi = new a.C0037a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int fLK = -1;
        private int fGw = 0;
        private boolean fLL = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.fLn == null) {
                e.this.fLn = new com.baidu.tbadk.o.c();
                e.this.fLn.jX(1005);
                e.this.fLn.pageType = 1;
            }
            if (e.this.ctJ != null && !e.this.mIsBackground) {
                e.this.ctJ.h(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.fdC);
                e.this.fLn.apb();
                t.aQF().go(true);
                com.baidu.tieba.a.d.awk().bA("page_recommend", "show_");
                com.baidu.tieba.q.c.cdq().b(e.this.fLv, false);
                this.fLL = false;
                if (e.this.fbl != null && e.this.fLo) {
                    e.this.fbl.a(e.this.fay, e.this.cZV, e.this.fbe, 1);
                    return;
                }
                return;
            }
            e.this.fLn.apa();
            if (i == 1 && e.this.fLl != null) {
                e.this.fLl.hideTip();
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
            if (this.fGw > i) {
                this.fLL = true;
            }
            if (e.this.ctJ != null && !e.this.mIsBackground) {
                e.this.ctJ.onScroll(this.fGw, i);
            }
            this.fGw = i;
            int i3 = (i + i2) - 1;
            if (!this.fLL && this.fLK != i3) {
                this.fLK = i3;
                e.this.sC(this.fLK);
            }
            if (this.fLL && this.fLK != i) {
                this.fLK = i;
                e.this.sC(this.fLK);
            }
            e.this.fLC = i;
            e.this.fay = i;
            e.this.cZV = (i + i2) - 1;
            z bmH = e.this.bmH();
            if (bmH != null && bmH.rx() != null) {
                bmH.rx().b(e.this.eZi);
            }
        }
    };
    private View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cfr != null) {
                e.this.cfr.onTouch(view, motionEvent);
            }
            if (e.this.fvR != null) {
                e.this.fvR.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0243a dMw = new a.InterfaceC0243a() { // from class: com.baidu.tieba.homepage.personalize.e.18
        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aR(int i, int i2) {
            e.this.fbe = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aS(int i, int i2) {
            e.this.fbe = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aT(int i, int i2) {
        }
    };
    private View.OnClickListener fLy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.fLl != null) {
                e.this.fLl.hideTip();
            }
        }
    };
    private final CustomMessageListener fLz = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.fdC != null) {
                e.this.fbl.boo();
                e.this.fLo = false;
                e.this.fKD.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener fpD = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg) && e.this.fLi != null && com.baidu.tbadk.core.util.v.S(e.this.fLi.thread_list) != 0 && (bgVar = (bg) customResponsedMessage.getData()) != null && bgVar.YD() != null && bgVar.getId() != null && com.baidu.tbadk.core.util.v.S(e.this.fLi.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.fLi.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.fLi.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.d(bgVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bgVar.YD().getNum());
                            builder.zan = builder2.build(true);
                            e.this.fLi.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener fLA = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.v.T(e.this.mDataList) && !com.baidu.tbadk.core.util.v.T(ids) && !com.baidu.tbadk.core.util.v.T(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bg) && (bgVar = (bg) originData.get(i2)) != null && bgVar.Zk() != null && ids.contains(Long.valueOf(bgVar.Zk().live_id))) {
                            e.this.mDataList.remove(bgVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.fKv != null) {
                        e.this.fKv.ay(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.fLi != null && !com.baidu.tbadk.core.util.v.T(e.this.fLi.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.fLi.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.fLi.thread_list.get(i);
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
                            e.this.fLi.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String fLB = "lastReadReadPositionKey";
    private int fLC = 0;
    private d fLE = new d() { // from class: com.baidu.tieba.homepage.personalize.e.8
        @Override // com.baidu.tieba.homepage.personalize.d
        public void sq(final int i) {
            if (e.this.fLD == null) {
                e.this.fLD = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fdC.getHandler() != null) {
                            e.this.fdC.requestFocusFromTouch();
                            if (i <= e.this.fdC.getCount() - 1) {
                                e.this.fdC.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.fdC.removeCallbacks(e.this.fLD);
            e.this.fdC.post(e.this.fLD);
        }
    };
    private CustomMessageListener fLF = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.fLs != null) {
                e.this.mDataList.remove(e.this.fLs);
                e.this.fKv.ay(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener frI = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener frJ = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener frK = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.fLi != null && com.baidu.tbadk.core.util.v.S(e.this.fLi.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.i(str, e.this.mDataList);
                e.this.wj(str);
                if (e.this.fKv != null) {
                    e.this.fKv.ay(new ArrayList(e.this.mDataList));
                }
            }
        }
    };
    private CustomMessageListener fas = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bmH;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bmH = e.this.bmH()) != null && bmH.rx() != null) {
                    bmH.rx().b(new a.C0037a(3));
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void K(int i, int i2, int i3);

        void bmu();

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3, int i4);
    }

    public void km(boolean z) {
        this.fLt = z;
        if (this.fLl != null && !z) {
            this.fLl.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fKj = scrollFragmentTabHost;
        if (this.fKj != null) {
            this.fKj.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void sB(int i) {
                    if (e.this.fKj.sA(i) != 1 && e.this.fLl != null) {
                        e.this.fLl.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ji(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.fbl != null) {
            this.fbl.md(!z);
            z bmH = bmH();
            if (bmH != null && bmH.rx() != null) {
                z2 = bmH.rx().b(new a.C0037a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fbl.boo();
                } else if (this.fLo) {
                    this.fbl.c(this.fay, this.cZV, this.fbe, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, v vVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.fLx = 0;
        this.mPageContext = tbPageContext;
        this.fLx = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_personalized_refresh_type", 0);
        this.fKD = bigdaySwipeRefreshLayout;
        this.fdC = bdTypeRecyclerView;
        this.fdC.setOnTouchListener(this.ccU);
        this.fvR = new com.baidu.tieba.f.a();
        this.fvR.a(this.dMw);
        this.fKv = vVar;
        this.fLm = new com.baidu.tieba.homepage.personalize.model.a();
        this.fLf = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.fLl = new aq();
        bmE();
        this.fbl = new m(this.mPageContext, this.fdC);
        this.fbl.xo(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fLg = new b(this.mDataList, this.fKv);
        this.fLw = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.fLw.setLayoutParams(new FrameLayout.LayoutParams(-1, l.h(tbPageContext.getContext(), d.e.tbds83)));
        bmv();
    }

    private void bmv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.21
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                z bmH = e.this.bmH();
                return (bmH == null || bmH.rx() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bmH.rx().b(new a.C0037a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bmw() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(bmy(), true);
    }

    private void bmx() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(bmy(), false);
    }

    private String bmy() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.aIR = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.ctJ = xVar.aql();
            this.cfr = xVar.aqm();
        }
    }

    public void showFloatingView() {
        if (this.ctJ != null) {
            this.ctJ.fl(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.blQ().p(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.fLr = true;
        if (this.mDataList.size() == 0 && !bmw()) {
            if (!this.fGr) {
                WO();
                return;
            }
            return;
        }
        WN();
    }

    public void bv(int i, int i2) {
        bg bgVar;
        if (!com.baidu.tbadk.core.util.v.T(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bg.bBc.getId() && (bgVar = (bg) this.mDataList.get(i)) != null && bgVar.Zk() != null) {
                    arrayList.add(Long.valueOf(bgVar.Zk().live_id));
                    arrayList2.add(bgVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.T(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bmz() {
        if (this.fbl != null && !this.mIsBackground && this.fLo) {
            this.fbl.c(this.fay, this.cZV, this.fbe, true);
        }
        if (this.fLp) {
            if (this.fKD != null && !this.fKD.aeP()) {
                if (this.fEF) {
                    com.baidu.tieba.q.c.cdq().b(this.fLv, false);
                    if (ko(false)) {
                        bw(3, this.fLk);
                    } else if (this.fLq > 0) {
                        bw(2, this.fLk);
                    }
                } else if (!this.fEF && this.fLk == 0) {
                    bw(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.fLp = false;
            this.fEF = false;
            this.fLq = 0;
            if (this.fLr) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.fLr = false;
        }
    }

    public void aBc() {
        if (qz()) {
            com.baidu.tieba.homepage.framework.a.blQ().p(0L, 1);
        } else if (this.fLh != null) {
            bmB();
            this.mPn++;
            setIsLoading(true);
            this.fLh.v(this.mPn, (this.fLi == null || this.fLi.thread_list == null) ? 0 : this.fLi.thread_list.size(), kn(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.fLi == null || this.fLi.thread_list == null) ? 0 : this.fLi.thread_list.size();
        if (!z && i == 0 && dataRes != null && com.baidu.tbadk.core.util.v.T(dataRes.thread_list)) {
            if (this.fLh != null) {
                this.fLh.bmu();
            }
            setIsLoading(false);
            if (this.fKD != null) {
                this.fKD.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.fLp = false;
            if (this.mDataList.size() > 0) {
                if (this.fLh != null) {
                    this.fLh.onError(1, str);
                }
            } else if (this.fLh != null) {
                this.fLh.onError(2, str);
            }
        } else {
            bmx();
            if (this.fLh != null) {
                this.fLh.onSuccess();
            }
            this.fLp = true;
            this.fEF = z;
            this.fLq = size;
            aWO();
        }
        setIsLoading(false);
        if (this.fKD != null) {
            h.e bmA = bmA();
            if (this.fKD.aeP() && bmA != null) {
                this.fKD.b(bmA);
            } else {
                this.fKD.setRefreshing(false);
            }
        }
    }

    private h.e bmA() {
        int i;
        String afW;
        if (this.fLp && this.fKD != null && this.fKD.aeP()) {
            int i2 = this.fLk;
            if (this.fEF) {
                com.baidu.tieba.q.c.cdq().b(this.fLv, false);
                if (ko(false)) {
                    i = 3;
                } else {
                    i = this.fLq > 0 ? 2 : 0;
                }
            } else if (this.fEF || this.fLk != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.fKj != null) {
                this.fLl.bez();
            }
            if (this.fKj != null && this.fKj.getCurrentTabType() != 1) {
                this.fLl.hideTip();
                return null;
            } else if (!this.fLt) {
                this.fLl.hideTip();
                return null;
            } else {
                this.fLj = i;
                if (i == 2) {
                    if (i2 > 0) {
                        afW = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        afW = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                    }
                } else if (i == 3) {
                    afW = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_cache_invalid);
                } else {
                    afW = i == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().afW() : null;
                }
                if (TextUtils.isEmpty(afW) || !j.kY()) {
                    return null;
                }
                if (i == 4) {
                    this.fdn = 1000;
                } else {
                    this.fdn = 0;
                }
                return new h.e(afW, this.fdn);
            }
        }
        return null;
    }

    public void kg(boolean z) {
        if (z) {
            this.fKv.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fbl != null) {
            this.fbl.destroy();
        }
        if (this.fLl != null) {
            this.fLl.onDestroy();
        }
        if (this.fLg != null) {
            this.fLg.onDestroy();
        }
        if (this.fdC != null) {
            this.fdC.removeCallbacks(this.fLD);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
    }

    public void onPause() {
        c.d(this.fdC);
        sD(this.fLC);
        if (this.fLn != null) {
            this.fLn.apc();
        }
    }

    private void WN() {
        if (this.fLh != null) {
            this.fLh.K((this.fLi == null || this.fLi.thread_list == null || bmD()) ? 0 : this.fLi.thread_list.size(), kn(true), 0);
        }
    }

    public int kn(boolean z) {
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
                com.baidu.adp.widget.ListView.m mVar = this.mDataList.get(i2);
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.bwq) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        } else {
            for (int size = this.mDataList.size() - 1; size >= 0; size--) {
                com.baidu.adp.widget.ListView.m mVar2 = this.mDataList.get(size);
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.bwq) {
                    return (this.mDataList.size() - size) - 1;
                }
            }
        }
        return this.mDataList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.fGr = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bmD()) {
                if (this.fLh != null) {
                    this.fLh.onSuccess();
                    return;
                }
                return;
            }
            WN();
            return;
        }
        WN();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void k(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo aQW;
        AdvertAppInfo aQW2;
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            Set<com.baidu.adp.widget.ListView.m> BJ = com.baidu.tieba.recapp.report.a.BJ("NEWINDEX");
            HashSet hashSet = BJ == null ? new HashSet() : BJ;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (aQW2 = ((com.baidu.tieba.card.data.d) mVar).aQW()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == aQW2.hashCode()) {
                            aQW2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (aQW = ((com.baidu.tieba.card.data.d) mVar).aQW()) != null && aQW.advertAppContext == null) {
                        aQW.advertAppContext = new com.baidu.tbadk.core.data.c();
                        aQW.advertAppContext.page = "NEWINDEX";
                        aQW.advertAppContext.pn = this.mPn;
                        aQW.advertAppContext.extensionInfo = aQW.extensionInfo;
                        aQW.advertAppContext.Tj = false;
                        hashSet2.add(aQW);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.d("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.cdq().b(this.fLv, com.baidu.tieba.q.a.b("a002", "common_fill", true, hashSet2.size()));
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.m> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.fLx == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bmD())) {
                bmC();
                this.fLi = null;
            }
        } else if (z2 && bmD()) {
            this.fLi = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.fLm.a(z, this.fLi, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.cHM;
            this.fLk = a2.fNA;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.fLr) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.fLi == null) {
            this.fLi = builder;
            this.fLg.cy(this.fLi.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.fLs = new g();
                    this.fLs.a(dataRes.live_answer);
                    this.fLi.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.fLs = null;
                    this.fLi.live_answer = null;
                }
                this.fLu = dataRes.float_info;
                this.fLi.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.fLs != null && !ap.aM(j)) {
                this.mDataList.add(0, this.fLs);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.fKv.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.fKv.ay(linkedList);
            z4 = true;
            if (this.fbl != null && this.fLo) {
                this.fbl.c(this.fay, this.cZV, this.fbe, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.blQ().n(System.currentTimeMillis() - currentTimeMillis, 1);
        long sp = com.baidu.tieba.homepage.framework.a.blQ().sp(1);
        if (sp > 0) {
            com.baidu.tieba.homepage.framework.a.blQ().o(System.currentTimeMillis() - sp, 1);
            com.baidu.tieba.homepage.framework.a.blQ().p(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.c.d(dataRes.anti.block_pop_info);
        }
        av avVar = new av();
        avVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, avVar));
        return z4;
    }

    private void bmB() {
        if (com.baidu.tbadk.core.util.v.S(this.mDataList) >= this.fLm.bmX() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.fLm.a(true, this.fLi, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.cHM : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.fKv.ay(new LinkedList(this.mDataList));
            }
        }
    }

    private void WO() {
        this.fGr = true;
        aa.a(new com.baidu.tbadk.util.z<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bmJ */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bu = com.baidu.tbadk.core.c.a.aaW().bu("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (bu == null) {
                    return null;
                }
                byte[] bArr = bu.get("0");
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
        }, new k<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void aWO() {
        if (this.fLi != null) {
            DataRes.Builder builder = new DataRes.Builder(this.fLi.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bmC() {
        if (this.fLi != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.fLi.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.fLg.cz(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aaW().bu("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                        return null;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return null;
                    }
                }
            }, null);
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
    public void wj(String str) {
        if (!TextUtils.isEmpty(str) && this.fLi != null && this.fLi.banner_list != null && this.fLi.banner_list.app != null && this.fLi.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.fLi.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.fLi.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.fLi.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.fLi.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.fLg.cz(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aaW().bu("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bmD() {
        return ko(true);
    }

    private boolean ko(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.fLf;
    }

    public void a(a aVar) {
        this.fLh = aVar;
    }

    private boolean qz() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bmr() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.afP() && !StringUtils.isNull(activityPrizeData.afW())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("activity_prize_feed_text_time", "");
                if (!StringUtils.isNull(string)) {
                    String[] split = string.split("@");
                    if (split != null && split.length == 2) {
                        String str2 = split[0];
                        String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        if (!StringUtils.isNull(str2) && split2.length != 0) {
                            if (str2.equals(currentDay)) {
                                List<String> asList = Arrays.asList(split2);
                                if (asList.contains(currentAccount)) {
                                    z = false;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(currentDay).append("@");
                                    for (String str3 : asList) {
                                        sb.append(str3).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                    bw(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bw(int i, int i2) {
        if (this.fKj != null) {
            this.fLl.bez();
        }
        if (this.fKj != null && this.fKj.getCurrentTabType() != 1) {
            this.fLl.hideTip();
        } else if (!this.fLt) {
            this.fLl.hideTip();
        } else {
            this.fLj = i;
            String str = null;
            if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().afW();
            }
            if (!TextUtils.isEmpty(str) && j.kY()) {
                if (i == 4) {
                    this.fdn = 3000;
                } else {
                    this.fdn = 2000;
                }
                this.fLw.bRT = str;
                this.fLw.fdf = this.fdn;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.aIR;
                FrameLayout frameLayout = this.fKj.getFrameLayout();
                frameLayout.removeView(this.fLw);
                frameLayout.addView(this.fLw, layoutParams);
                this.fLw.bex();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Long l) {
        if (this.fLi != null && this.fLi.thread_list != null) {
            List<ThreadInfo> list = this.fLi.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aWO();
                    a(false, true, false, this.fLi.build(true));
                    return;
                }
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fLv = bdUniqueId;
            if (this.fpD != null) {
                this.fpD.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fpD);
            }
            if (this.fLz != null) {
                this.fLz.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fLz);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.fLA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fLA);
            this.frI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.frI);
            this.frJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.frJ);
            this.frK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.frK);
            if (this.fbl != null) {
                this.fbl.setUniqueId(bdUniqueId);
            }
            this.fLg.i(bdUniqueId);
            this.fLF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fLF);
            this.fas.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fas);
        }
    }

    public void bmE() {
        this.eYP = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.eYP.cdR();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.eYP != null) {
            if (i == 0) {
                this.eYP.cdR();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.iFJ;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.eYP.cn(i3, i7 + 1);
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

    public void sC(int i) {
        if ((this.eYP != null ? this.eYP.zr(i) : -1) >= 0 && this.fdC != null && this.fdC.getData() != null && this.fdC.getData().size() > i) {
            this.eYP.zs(i);
        }
    }

    public m bdo() {
        return this.fbl;
    }

    public void kp(boolean z) {
        this.fLo = z;
    }

    public void sD(final int i) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> bv = com.baidu.tbadk.core.c.a.aaW().bv(e.this.fLB, TbadkCoreApplication.getCurrentAccount());
                if (bv != null) {
                    bv.a(e.this.fLB, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        aa.a(new com.baidu.tbadk.util.z<String>() { // from class: com.baidu.tieba.homepage.personalize.e.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bmI */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> bv = com.baidu.tbadk.core.c.a.aaW().bv(e.this.fLB, TbadkCoreApplication.getCurrentAccount());
                if (bv != null) {
                    return bv.get(e.this.fLB);
                }
                return null;
            }
        }, new k<String>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: wk */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.sq(com.baidu.adp.lib.g.b.l(str, 0));
                }
            }
        });
    }

    public void bmt() {
        c.e(this.fdC);
    }

    public void bmF() {
        a(this.fLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.fLi != null && com.baidu.tbadk.core.util.v.S(this.fLi.thread_list) != 0 && com.baidu.tbadk.core.util.v.S(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.fdC != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.fdC.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.fdC.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.WR() != null && jVar.WR().Zk() != null && optString2.equals(String.valueOf(jVar.WR().Zk().live_id))) {
                                str = jVar.WR().getTid();
                                break;
                            }
                        }
                        i++;
                    }
                    if (StringUtils.isNull(str)) {
                        return;
                    }
                    optString = str;
                } else {
                    return;
                }
            }
            Iterator<com.baidu.adp.widget.ListView.m> it = this.mDataList.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.WR() != null && cVar.WR().getTid() != null) {
                        if (cVar.WR().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cB(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.fLi != null && this.fLi.thread_list != null) {
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.fLi.thread_list.size()) {
                        ThreadInfo threadInfo = this.fLi.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != d) {
                            i2++;
                        } else {
                            this.fLi.thread_list.remove(i2);
                            aWO();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.fLi.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.fdC != null) {
                    List<Integer> b = b(optString, this.fdC);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.fdC.s(intValue, intValue2);
                    }
                }
            }
        }
    }

    private List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i4 < bdTypeRecyclerView.getCount()) {
                com.baidu.adp.widget.ListView.m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.WR() != null && cVar.WR().getTid().equals(str)) {
                        if (!z) {
                            i3 = i4;
                        }
                        z = true;
                        i2 = i4;
                    }
                }
                i = i4 + 1;
            } else {
                arrayList.add(Integer.valueOf(i3));
                arrayList.add(Integer.valueOf(i2));
                return arrayList;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, List<com.baidu.adp.widget.ListView.m> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).aQW();
                } else {
                    if (next instanceof ad) {
                        ad adVar = (ad) next;
                        if (adVar.Xu() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.Xu()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.bwB)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fLw != null) {
            this.fLw.onChangeSkinType(i);
        }
    }

    public FloatInfo bmG() {
        return this.fLu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z bmH() {
        if (this.fbl == null || this.fbl.bTk() == null || !(this.fbl.bTk().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fbl.bTk().getTag();
    }
}
