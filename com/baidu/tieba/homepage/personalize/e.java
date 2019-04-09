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
    private int aIW;
    private View.OnTouchListener cfu;
    private w ctJ;
    private com.baidu.tieba.tbadkCore.data.f eYB;
    private boolean fEs;
    private ScrollFragmentTabHost fJW;
    private final long fKS;
    private final b fKT;
    private DataRes.Builder fKV;
    private aq fKY;
    private final com.baidu.tieba.homepage.personalize.model.a fKZ;
    private final v fKi;
    private final BigdaySwipeRefreshLayout fKq;
    private int fLd;
    private g fLf;
    private BdUniqueId fLi;
    private SmartBubbleAnimatedView fLj;
    private int fLk;
    private Runnable fLq;
    private m faX;
    private final BdTypeRecyclerView fdo;
    private com.baidu.tieba.f.a fvC;
    private final TbPageContext<?> mPageContext;
    private a fKU = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean fGe = false;
    private int fKW = 2;
    private int fKX = 0;
    private TextView bFL = null;
    private int fcZ = 2000;
    private com.baidu.tbadk.o.c fLa = null;
    private boolean faQ = false;
    private int fak = 0;
    private int cZV = 0;
    private boolean mIsBackground = false;
    private boolean fLb = true;
    private boolean fLc = false;
    private boolean fLe = false;
    private boolean fLg = true;
    private FloatInfo fLh = null;
    private a.C0039a eYU = new a.C0039a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int fLx = -1;
        private int fGj = 0;
        private boolean fLy = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.fLa == null) {
                e.this.fLa = new com.baidu.tbadk.o.c();
                e.this.fLa.jW(1005);
                e.this.fLa.pageType = 1;
            }
            if (e.this.ctJ != null && !e.this.mIsBackground) {
                e.this.ctJ.h(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.fdo);
                e.this.fLa.aoX();
                t.aQD().go(true);
                com.baidu.tieba.a.d.awh().bA("page_recommend", "show_");
                com.baidu.tieba.q.c.cdp().b(e.this.fLi, false);
                this.fLy = false;
                if (e.this.faX != null && e.this.fLb) {
                    e.this.faX.a(e.this.fak, e.this.cZV, e.this.faQ, 1);
                    return;
                }
                return;
            }
            e.this.fLa.aoW();
            if (i == 1 && e.this.fKY != null) {
                e.this.fKY.hideTip();
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
            if (this.fGj > i) {
                this.fLy = true;
            }
            if (e.this.ctJ != null && !e.this.mIsBackground) {
                e.this.ctJ.onScroll(this.fGj, i);
            }
            this.fGj = i;
            int i3 = (i + i2) - 1;
            if (!this.fLy && this.fLx != i3) {
                this.fLx = i3;
                e.this.sy(this.fLx);
            }
            if (this.fLy && this.fLx != i) {
                this.fLx = i;
                e.this.sy(this.fLx);
            }
            e.this.fLp = i;
            e.this.fak = i;
            e.this.cZV = (i + i2) - 1;
            z bmE = e.this.bmE();
            if (bmE != null && bmE.rx() != null) {
                bmE.rx().b(e.this.eYU);
            }
        }
    };
    private View.OnTouchListener ccX = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cfu != null) {
                e.this.cfu.onTouch(view, motionEvent);
            }
            if (e.this.fvC != null) {
                e.this.fvC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0284a dLK = new a.InterfaceC0284a() { // from class: com.baidu.tieba.homepage.personalize.e.18
        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
            e.this.faQ = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aS(int i, int i2) {
            e.this.faQ = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aT(int i, int i2) {
        }
    };
    private View.OnClickListener fLl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.fKY != null) {
                e.this.fKY.hideTip();
            }
        }
    };
    private final CustomMessageListener fLm = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.fdo != null) {
                e.this.faX.bol();
                e.this.fLb = false;
                e.this.fKq.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener fpn = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg) && e.this.fKV != null && com.baidu.tbadk.core.util.v.S(e.this.fKV.thread_list) != 0 && (bgVar = (bg) customResponsedMessage.getData()) != null && bgVar.YA() != null && bgVar.getId() != null && com.baidu.tbadk.core.util.v.S(e.this.fKV.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.fKV.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.fKV.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.d(bgVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bgVar.YA().getNum());
                            builder.zan = builder2.build(true);
                            e.this.fKV.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener fLn = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.5
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
                        if ((originData.get(i2) instanceof bg) && (bgVar = (bg) originData.get(i2)) != null && bgVar.Zh() != null && ids.contains(Long.valueOf(bgVar.Zh().live_id))) {
                            e.this.mDataList.remove(bgVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.fKi != null) {
                        e.this.fKi.ay(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.fKV != null && !com.baidu.tbadk.core.util.v.T(e.this.fKV.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.fKV.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.fKV.thread_list.get(i);
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
                            e.this.fKV.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String fLo = "lastReadReadPositionKey";
    private int fLp = 0;
    private d fLr = new d() { // from class: com.baidu.tieba.homepage.personalize.e.8
        @Override // com.baidu.tieba.homepage.personalize.d
        public void sm(final int i) {
            if (e.this.fLq == null) {
                e.this.fLq = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fdo.getHandler() != null) {
                            e.this.fdo.requestFocusFromTouch();
                            if (i <= e.this.fdo.getCount() - 1) {
                                e.this.fdo.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.fdo.removeCallbacks(e.this.fLq);
            e.this.fdo.post(e.this.fLq);
        }
    };
    private CustomMessageListener fLs = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.fLf != null) {
                e.this.mDataList.remove(e.this.fLf);
                e.this.fKi.ay(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener frt = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fru = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener frv = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.fKV != null && com.baidu.tbadk.core.util.v.S(e.this.fKV.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.i(str, e.this.mDataList);
                e.this.wh(str);
                if (e.this.fKi != null) {
                    e.this.fKi.ay(new ArrayList(e.this.mDataList));
                }
            }
        }
    };
    private CustomMessageListener fae = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bmE;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bmE = e.this.bmE()) != null && bmE.rx() != null) {
                    bmE.rx().b(new a.C0039a(3));
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void K(int i, int i2, int i3);

        void bmr();

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3, int i4);
    }

    public void km(boolean z) {
        this.fLg = z;
        if (this.fKY != null && !z) {
            this.fKY.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fJW = scrollFragmentTabHost;
        if (this.fJW != null) {
            this.fJW.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void sx(int i) {
                    if (e.this.fJW.sw(i) != 1 && e.this.fKY != null) {
                        e.this.fKY.hideTip();
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
        if (this.faX != null) {
            this.faX.md(!z);
            z bmE = bmE();
            if (bmE != null && bmE.rx() != null) {
                z2 = bmE.rx().b(new a.C0039a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.faX.bol();
                } else if (this.fLb) {
                    this.faX.c(this.fak, this.cZV, this.faQ, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, v vVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.fLk = 0;
        this.mPageContext = tbPageContext;
        this.fLk = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_personalized_refresh_type", 0);
        this.fKq = bigdaySwipeRefreshLayout;
        this.fdo = bdTypeRecyclerView;
        this.fdo.setOnTouchListener(this.ccX);
        this.fvC = new com.baidu.tieba.f.a();
        this.fvC.a(this.dLK);
        this.fKi = vVar;
        this.fKZ = new com.baidu.tieba.homepage.personalize.model.a();
        this.fKS = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.fKY = new aq();
        bmB();
        this.faX = new m(this.mPageContext, this.fdo);
        this.faX.xk(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fKT = new b(this.mDataList, this.fKi);
        this.fLj = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.fLj.setLayoutParams(new FrameLayout.LayoutParams(-1, l.h(tbPageContext.getContext(), d.e.tbds83)));
        bms();
    }

    private void bms() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.21
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                z bmE = e.this.bmE();
                return (bmE == null || bmE.rx() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bmE.rx().b(new a.C0039a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bmt() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(bmv(), true);
    }

    private void bmu() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(bmv(), false);
    }

    private String bmv() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.aIW = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.ctJ = xVar.aqi();
            this.cfu = xVar.aqj();
        }
    }

    public void showFloatingView() {
        if (this.ctJ != null) {
            this.ctJ.fl(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.blN().p(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.fLe = true;
        if (this.mDataList.size() == 0 && !bmt()) {
            if (!this.fGe) {
                WL();
                return;
            }
            return;
        }
        WK();
    }

    public void bv(int i, int i2) {
        bg bgVar;
        if (!com.baidu.tbadk.core.util.v.T(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bg.bBi.getId() && (bgVar = (bg) this.mDataList.get(i)) != null && bgVar.Zh() != null) {
                    arrayList.add(Long.valueOf(bgVar.Zh().live_id));
                    arrayList2.add(bgVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.T(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bmw() {
        if (this.faX != null && !this.mIsBackground && this.fLb) {
            this.faX.c(this.fak, this.cZV, this.faQ, true);
        }
        if (this.fLc) {
            if (this.fKq != null && !this.fKq.aeM()) {
                if (this.fEs) {
                    com.baidu.tieba.q.c.cdp().b(this.fLi, false);
                    if (ko(false)) {
                        bw(3, this.fKX);
                    } else if (this.fLd > 0) {
                        bw(2, this.fKX);
                    }
                } else if (!this.fEs && this.fKX == 0) {
                    bw(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.fLc = false;
            this.fEs = false;
            this.fLd = 0;
            if (this.fLe) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.fLe = false;
        }
    }

    public void aAZ() {
        if (qz()) {
            com.baidu.tieba.homepage.framework.a.blN().p(0L, 1);
        } else if (this.fKU != null) {
            bmy();
            this.mPn++;
            setIsLoading(true);
            this.fKU.v(this.mPn, (this.fKV == null || this.fKV.thread_list == null) ? 0 : this.fKV.thread_list.size(), kn(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.fKV == null || this.fKV.thread_list == null) ? 0 : this.fKV.thread_list.size();
        if (!z && i == 0 && dataRes != null && com.baidu.tbadk.core.util.v.T(dataRes.thread_list)) {
            if (this.fKU != null) {
                this.fKU.bmr();
            }
            setIsLoading(false);
            if (this.fKq != null) {
                this.fKq.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.fLc = false;
            if (this.mDataList.size() > 0) {
                if (this.fKU != null) {
                    this.fKU.onError(1, str);
                }
            } else if (this.fKU != null) {
                this.fKU.onError(2, str);
            }
        } else {
            bmu();
            if (this.fKU != null) {
                this.fKU.onSuccess();
            }
            this.fLc = true;
            this.fEs = z;
            this.fLd = size;
            aWM();
        }
        setIsLoading(false);
        if (this.fKq != null) {
            h.e bmx = bmx();
            if (this.fKq.aeM() && bmx != null) {
                this.fKq.b(bmx);
            } else {
                this.fKq.setRefreshing(false);
            }
        }
    }

    private h.e bmx() {
        int i;
        String afT;
        if (this.fLc && this.fKq != null && this.fKq.aeM()) {
            int i2 = this.fKX;
            if (this.fEs) {
                com.baidu.tieba.q.c.cdp().b(this.fLi, false);
                if (ko(false)) {
                    i = 3;
                } else {
                    i = this.fLd > 0 ? 2 : 0;
                }
            } else if (this.fEs || this.fKX != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.fJW != null) {
                this.fKY.bex();
            }
            if (this.fJW != null && this.fJW.getCurrentTabType() != 1) {
                this.fKY.hideTip();
                return null;
            } else if (!this.fLg) {
                this.fKY.hideTip();
                return null;
            } else {
                this.fKW = i;
                if (i == 2) {
                    if (i2 > 0) {
                        afT = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        afT = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                    }
                } else if (i == 3) {
                    afT = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_cache_invalid);
                } else {
                    afT = i == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().afT() : null;
                }
                if (TextUtils.isEmpty(afT) || !j.kY()) {
                    return null;
                }
                if (i == 4) {
                    this.fcZ = 1000;
                } else {
                    this.fcZ = 0;
                }
                return new h.e(afT, this.fcZ);
            }
        }
        return null;
    }

    public void kg(boolean z) {
        if (z) {
            this.fKi.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.faX != null) {
            this.faX.destroy();
        }
        if (this.fKY != null) {
            this.fKY.onDestroy();
        }
        if (this.fKT != null) {
            this.fKT.onDestroy();
        }
        if (this.fdo != null) {
            this.fdo.removeCallbacks(this.fLq);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
    }

    public void onPause() {
        c.d(this.fdo);
        sz(this.fLp);
        if (this.fLa != null) {
            this.fLa.aoY();
        }
    }

    private void WK() {
        if (this.fKU != null) {
            this.fKU.K((this.fKV == null || this.fKV.thread_list == null || bmA()) ? 0 : this.fKV.thread_list.size(), kn(true), 0);
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.bww) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        } else {
            for (int size = this.mDataList.size() - 1; size >= 0; size--) {
                com.baidu.adp.widget.ListView.m mVar2 = this.mDataList.get(size);
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.bww) {
                    return (this.mDataList.size() - size) - 1;
                }
            }
        }
        return this.mDataList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.fGe = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bmA()) {
                if (this.fKU != null) {
                    this.fKU.onSuccess();
                    return;
                }
                return;
            }
            WK();
            return;
        }
        WK();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void k(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo aQU;
        AdvertAppInfo aQU2;
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            Set<com.baidu.adp.widget.ListView.m> BH = com.baidu.tieba.recapp.report.a.BH("NEWINDEX");
            HashSet hashSet = BH == null ? new HashSet() : BH;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (aQU2 = ((com.baidu.tieba.card.data.d) mVar).aQU()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == aQU2.hashCode()) {
                            aQU2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (aQU = ((com.baidu.tieba.card.data.d) mVar).aQU()) != null && aQU.advertAppContext == null) {
                        aQU.advertAppContext = new com.baidu.tbadk.core.data.c();
                        aQU.advertAppContext.page = "NEWINDEX";
                        aQU.advertAppContext.pn = this.mPn;
                        aQU.advertAppContext.extensionInfo = aQU.extensionInfo;
                        aQU.advertAppContext.Tl = false;
                        hashSet2.add(aQU);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.d("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.cdp().b(this.fLi, com.baidu.tieba.q.a.b("a002", "common_fill", true, hashSet2.size()));
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
        if (this.fLk == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bmA())) {
                bmz();
                this.fKV = null;
            }
        } else if (z2 && bmA()) {
            this.fKV = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.fKZ.a(z, this.fKV, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.cHM;
            this.fKX = a2.fNn;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.fLe) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.fKV == null) {
            this.fKV = builder;
            this.fKT.cv(this.fKV.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.fLf = new g();
                    this.fLf.a(dataRes.live_answer);
                    this.fKV.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.fLf = null;
                    this.fKV.live_answer = null;
                }
                this.fLh = dataRes.float_info;
                this.fKV.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_maintab_banner_close_time", 0L);
            if (this.fLf != null && !ap.aM(j)) {
                this.mDataList.add(0, this.fLf);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.fKi.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.fKi.ay(linkedList);
            z4 = true;
            if (this.faX != null && this.fLb) {
                this.faX.c(this.fak, this.cZV, this.faQ, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.blN().n(System.currentTimeMillis() - currentTimeMillis, 1);
        long sl = com.baidu.tieba.homepage.framework.a.blN().sl(1);
        if (sl > 0) {
            com.baidu.tieba.homepage.framework.a.blN().o(System.currentTimeMillis() - sl, 1);
            com.baidu.tieba.homepage.framework.a.blN().p(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.c.d(dataRes.anti.block_pop_info);
        }
        av avVar = new av();
        avVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, avVar));
        return z4;
    }

    private void bmy() {
        if (com.baidu.tbadk.core.util.v.S(this.mDataList) >= this.fKZ.bmU() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.fKZ.a(true, this.fKV, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.cHM : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.fKi.ay(new LinkedList(this.mDataList));
            }
        }
    }

    private void WL() {
        this.fGe = true;
        aa.a(new com.baidu.tbadk.util.z<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bmG */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bu = com.baidu.tbadk.core.c.a.aaT().bu("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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

    private void aWM() {
        if (this.fKV != null) {
            DataRes.Builder builder = new DataRes.Builder(this.fKV.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bmz() {
        if (this.fKV != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.fKV.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.fKT.cw(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.aaT().bu("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
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
    public void wh(String str) {
        if (!TextUtils.isEmpty(str) && this.fKV != null && this.fKV.banner_list != null && this.fKV.banner_list.app != null && this.fKV.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.fKV.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.fKV.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.fKV.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.fKV.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.fKT.cw(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.aaT().bu("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bmA() {
        return ko(true);
    }

    private boolean ko(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.fKS;
    }

    public void a(a aVar) {
        this.fKU = aVar;
    }

    private boolean qz() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bmo() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.afM() && !StringUtils.isNull(activityPrizeData.afT())) {
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
        if (this.fJW != null) {
            this.fKY.bex();
        }
        if (this.fJW != null && this.fJW.getCurrentTabType() != 1) {
            this.fKY.hideTip();
        } else if (!this.fLg) {
            this.fKY.hideTip();
        } else {
            this.fKW = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().afT();
            }
            if (!TextUtils.isEmpty(str) && j.kY()) {
                if (i == 4) {
                    this.fcZ = 3000;
                } else {
                    this.fcZ = 2000;
                }
                this.fLj.bRX = str;
                this.fLj.fcR = this.fcZ;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.aIW;
                FrameLayout frameLayout = this.fJW.getFrameLayout();
                frameLayout.removeView(this.fLj);
                frameLayout.addView(this.fLj, layoutParams);
                this.fLj.bev();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Long l) {
        if (this.fKV != null && this.fKV.thread_list != null) {
            List<ThreadInfo> list = this.fKV.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aWM();
                    a(false, true, false, this.fKV.build(true));
                    return;
                }
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fLi = bdUniqueId;
            if (this.fpn != null) {
                this.fpn.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fpn);
            }
            if (this.fLm != null) {
                this.fLm.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fLm);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.fLn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fLn);
            this.frt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.frt);
            this.fru.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fru);
            this.frv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.frv);
            if (this.faX != null) {
                this.faX.setUniqueId(bdUniqueId);
            }
            this.fKT.i(bdUniqueId);
            this.fLs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fLs);
            this.fae.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fae);
        }
    }

    public void bmB() {
        this.eYB = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.eYB.cdQ();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.eYB != null) {
            if (i == 0) {
                this.eYB.cdQ();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.iFn;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.eYB.cn(i3, i7 + 1);
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

    public void sy(int i) {
        if ((this.eYB != null ? this.eYB.zn(i) : -1) >= 0 && this.fdo != null && this.fdo.getData() != null && this.fdo.getData().size() > i) {
            this.eYB.zo(i);
        }
    }

    public m bdm() {
        return this.faX;
    }

    public void kp(boolean z) {
        this.fLb = z;
    }

    public void sz(final int i) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> bv = com.baidu.tbadk.core.c.a.aaT().bv(e.this.fLo, TbadkCoreApplication.getCurrentAccount());
                if (bv != null) {
                    bv.a(e.this.fLo, Integer.toString(i), 43200000L);
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
            /* renamed from: bmF */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> bv = com.baidu.tbadk.core.c.a.aaT().bv(e.this.fLo, TbadkCoreApplication.getCurrentAccount());
                if (bv != null) {
                    return bv.get(e.this.fLo);
                }
                return null;
            }
        }, new k<String>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: wi */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.sm(com.baidu.adp.lib.g.b.l(str, 0));
                }
            }
        });
    }

    public void bmq() {
        c.e(this.fdo);
    }

    public void bmC() {
        a(this.fLr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.fKV != null && com.baidu.tbadk.core.util.v.S(this.fKV.thread_list) != 0 && com.baidu.tbadk.core.util.v.S(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.fdo != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.fdo.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.fdo.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.WO() != null && jVar.WO().Zh() != null && optString2.equals(String.valueOf(jVar.WO().Zh().live_id))) {
                                str = jVar.WO().getTid();
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
                    if (cVar.WO() != null && cVar.WO().getTid() != null) {
                        if (cVar.WO().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cy(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.fKV != null && this.fKV.thread_list != null) {
                long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.fKV.thread_list.size()) {
                        ThreadInfo threadInfo = this.fKV.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != d) {
                            i2++;
                        } else {
                            this.fKV.thread_list.remove(i2);
                            aWM();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.fKV.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.fdo != null) {
                    List<Integer> b = b(optString, this.fdo);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.fdo.s(intValue, intValue2);
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
                    if (cVar.WO() != null && cVar.WO().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).aQU();
                } else {
                    if (next instanceof ad) {
                        ad adVar = (ad) next;
                        if (adVar.Xr() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.Xr()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.bwH)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fLj != null) {
            this.fLj.onChangeSkinType(i);
        }
    }

    public FloatInfo bmD() {
        return this.fLh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z bmE() {
        if (this.faX == null || this.faX.bTj() == null || !(this.faX.bTj().getTag() instanceof z)) {
            return null;
        }
        return (z) this.faX.bTj().getTag();
    }
}
