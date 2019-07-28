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
import com.baidu.adp.framework.message.ResponsedMessage;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.t;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.message.RequestBlessMessage;
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
    private w cDk;
    private View.OnTouchListener coO;
    private com.baidu.tieba.f.a fRt;
    private com.baidu.tieba.tbadkCore.data.f ftL;
    private m fwk;
    private final BdTypeRecyclerView fyz;
    private boolean gap;
    private final BigdaySwipeRefreshLayout gcc;
    private final com.baidu.tieba.homepage.personalize.a.w ghJ;
    private ScrollFragmentTabHost ghx;
    private g giA;
    private BdUniqueId giD;
    private SmartBubbleAnimatedView giE;
    private int giF;
    private Runnable giL;
    private final long gio;
    private final b gip;
    private DataRes.Builder gir;
    private aq giu;
    private final com.baidu.tieba.homepage.personalize.model.a giv;
    private int giy;
    private final TbPageContext<?> mPageContext;
    private a giq = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean gcl = false;
    private int gis = 2;
    private int git = 0;
    private TextView bOn = null;
    private int fyk = 2000;
    private com.baidu.tbadk.p.c giw = null;
    private boolean fwd = false;
    private int fvy = 0;
    private int dml = 0;
    private boolean mIsBackground = false;
    private boolean ghs = true;
    private boolean gix = false;
    private boolean giz = false;
    private boolean giB = true;
    private FloatInfo giC = null;
    private a.C0038a fue = new a.C0038a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int giT = -1;
        private int gcq = 0;
        private boolean giU = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.giw == null) {
                e.this.giw = new com.baidu.tbadk.p.c();
                e.this.giw.kQ(1005);
                e.this.giw.pageType = 1;
            }
            if (e.this.cDk != null && !e.this.mIsBackground) {
                e.this.cDk.i(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.fyz);
                e.this.giw.avk();
                t.aZN().gS(true);
                com.baidu.tieba.a.d.aCF().bJ("page_recommend", "show_");
                com.baidu.tieba.q.c.coo().b(e.this.giD, false);
                this.giU = false;
                if (e.this.fwk != null && e.this.ghs) {
                    e.this.fwk.a(e.this.fvy, e.this.dml, e.this.fwd, 1);
                    return;
                }
                return;
            }
            e.this.giw.avj();
            if (i == 1) {
                if (e.this.giu != null) {
                    e.this.giu.hideTip();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
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
            if (this.gcq > i) {
                this.giU = true;
            }
            if (e.this.cDk != null && !e.this.mIsBackground) {
                e.this.cDk.onScroll(this.gcq, i);
            }
            this.gcq = i;
            int i3 = (i + i2) - 1;
            if (!this.giU && this.giT != i3) {
                this.giT = i3;
                e.this.ud(this.giT);
            }
            if (this.giU && this.giT != i) {
                this.giT = i;
                e.this.ud(this.giT);
            }
            e.this.giK = i;
            e.this.fvy = i;
            e.this.dml = (i + i2) - 1;
            z bwm = e.this.bwm();
            if (bwm != null && bwm.qP() != null) {
                bwm.qP().b(e.this.fue);
            }
        }
    };
    private View.OnTouchListener cmp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.coO != null) {
                e.this.coO.onTouch(view, motionEvent);
            }
            if (e.this.fRt != null) {
                e.this.fRt.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0305a eac = new a.InterfaceC0305a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            e.this.fwd = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            e.this.fwd = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void ba(int i, int i2) {
        }
    };
    private View.OnClickListener giG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.giu != null) {
                e.this.giu.hideTip();
            }
        }
    };
    private final CustomMessageListener giH = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.fyz != null) {
                e.this.fwk.bwl();
                e.this.ghs = false;
                e.this.gcc.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener fKJ = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg) && e.this.gir != null && v.Z(e.this.gir.thread_list) != 0 && (bgVar = (bg) customResponsedMessage.getData()) != null && bgVar.aej() != null && bgVar.getId() != null && v.Z(e.this.gir.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.gir.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.gir.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bgVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bgVar.aej().getNum());
                            builder.zan = builder2.build(true);
                            e.this.gir.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener giI = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.aa(e.this.mDataList) && !v.aa(ids) && !v.aa(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bg) && (bgVar = (bg) originData.get(i2)) != null && bgVar.aeQ() != null && ids.contains(Long.valueOf(bgVar.aeQ().live_id))) {
                            e.this.mDataList.remove(bgVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.ghJ != null) {
                        e.this.ghJ.aF(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.gir != null && !v.aa(e.this.gir.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.gir.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.gir.thread_list.get(i);
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
                            e.this.gir.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String giJ = "lastReadReadPositionKey";
    private int giK = 0;
    private d giM = new d() { // from class: com.baidu.tieba.homepage.personalize.e.8
        @Override // com.baidu.tieba.homepage.personalize.d
        public void tL(final int i) {
            if (e.this.giL == null) {
                e.this.giL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fyz.getHandler() != null) {
                            e.this.fyz.requestFocusFromTouch();
                            if (i <= e.this.fyz.getCount() - 1) {
                                e.this.fyz.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.fyz.removeCallbacks(e.this.giL);
            e.this.fyz.post(e.this.giL);
        }
    };
    private CustomMessageListener giN = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.giA != null) {
                e.this.mDataList.remove(e.this.giA);
                e.this.ghJ.aF(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.ahO().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener fMP = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.fwk != null && e.this.ghs) {
                e.this.fwk.c(e.this.fvy, e.this.dml, e.this.fwd, true);
            }
        }
    };
    private CustomMessageListener fMQ = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fKY = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gir != null && v.Z(e.this.gir.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.yh(str);
                if (e.this.ghJ != null) {
                    e.this.ghJ.aF(new ArrayList(e.this.mDataList));
                }
                if (e.this.fwk != null && e.this.ghs) {
                    e.this.fwk.c(e.this.fvy, e.this.dml, e.this.fwd, true);
                }
            }
        }
    };
    private CustomMessageListener fvr = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bwm;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bwm = e.this.bwm()) != null && bwm.qP() != null) {
                    bwm.qP().b(new a.C0038a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a giO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TOPIC_BLESS, 309085) { // from class: com.baidu.tieba.homepage.personalize.e.17
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            com.baidu.tieba.homepage.topic.topictab.b.b bVar;
            if (responsedMessage != null) {
                if (responsedMessage instanceof BlessHttpResponseMessage) {
                    long j3 = ((BlessHttpResponseMessage) responsedMessage).userPkId;
                    j = ((BlessHttpResponseMessage) responsedMessage).pkID;
                    j2 = j3;
                } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                    long j4 = ((BlessSocketResponseMessage) responsedMessage).userPkId;
                    j = ((BlessSocketResponseMessage) responsedMessage).pkID;
                    j2 = j4;
                } else {
                    j = 0;
                    j2 = 0;
                }
                long longValue = (j == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) ? ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue() : j;
                if (longValue != 0) {
                    for (com.baidu.adp.widget.ListView.m mVar : e.this.mDataList) {
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).gnb) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.ghJ.getDataList();
            if (!v.aa(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bJg != 0 && kVar.threadData != null) {
                            int[] agq = kVar.threadData.agq();
                            kVar.bJg = agq[0];
                            kVar.bJh = agq[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.18.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.ghJ.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.ghs) {
                        e.this.fwk.c(e.this.fvy, e.this.dml, e.this.fwd, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void M(int i, int i2, int i3);

        void bwC();

        void onError(int i, String str);

        void onSuccess();

        void w(int i, int i2, int i3, int i4);
    }

    public void lq(boolean z) {
        this.giB = z;
        if (this.giu != null && !z) {
            this.giu.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ghx = scrollFragmentTabHost;
        if (this.ghx != null) {
            this.ghx.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void tW(int i) {
                    if (e.this.ghx.tV(i) != 1 && e.this.giu != null) {
                        e.this.giu.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void kc(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.fwk != null) {
            this.fwk.nh(!z);
            z bwm = bwm();
            if (bwm != null && bwm.qP() != null) {
                z2 = bwm.qP().b(new a.C0038a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fwk.bwl();
                } else if (this.ghs) {
                    this.fwk.c(this.fvy, this.dml, this.fwd, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.personalize.a.w wVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.giF = 0;
        this.mPageContext = tbPageContext;
        this.giF = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_personalized_refresh_type", 0);
        this.gcc = bigdaySwipeRefreshLayout;
        this.fyz = bdTypeRecyclerView;
        this.fyz.setOnTouchListener(this.cmp);
        this.fRt = new com.baidu.tieba.f.a();
        this.fRt.a(this.eac);
        this.ghJ = wVar;
        this.giv = new com.baidu.tieba.homepage.personalize.model.a();
        this.gio = com.baidu.tbadk.core.sharedPref.b.ahO().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.giu = new aq();
        bwM();
        this.fwk = new m(this.mPageContext, this.fyz);
        this.fwk.yW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gip = new b(this.mDataList, this.ghJ);
        this.giE = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.giE.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        bwD();
        this.fvs.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fvs);
    }

    private void bwD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.23
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                z bwm = e.this.bwm();
                return (bwm == null || bwm.qP() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bwm.qP().b(new a.C0038a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bwE() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean(bwG(), true);
    }

    private void bwF() {
        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean(bwG(), false);
    }

    private String bwG() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.cDk = xVar.aww();
            this.coO = xVar.awx();
        }
    }

    public void showFloatingView() {
        if (this.cDk != null) {
            this.cDk.fM(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bvp().n(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.giz = true;
        if (this.mDataList.size() == 0 && !bwE()) {
            if (!this.gcl) {
                acq();
                return;
            }
            return;
        }
        acp();
    }

    public void bI(int i, int i2) {
        bg bgVar;
        if (!v.aa(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bg.bJy.getId() && (bgVar = (bg) this.mDataList.get(i)) != null && bgVar.aeQ() != null) {
                    arrayList.add(Long.valueOf(bgVar.aeQ().live_id));
                    arrayList2.add(bgVar);
                }
                i++;
            }
            if (!v.aa(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bwH() {
        if (this.fwk != null && !this.mIsBackground && this.ghs) {
            this.fwk.c(this.fvy, this.dml, this.fwd, true);
        }
        if (this.gix) {
            if (this.gcc != null && !this.gcc.akQ()) {
                if (this.gap) {
                    com.baidu.tieba.q.c.coo().b(this.giD, false);
                    if (ls(false)) {
                        bJ(3, this.git);
                    } else if (this.giy > 0) {
                        bJ(2, this.git);
                    }
                } else if (!this.gap && this.git == 0) {
                    bJ(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.ahO().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.gix = false;
            this.gap = false;
            this.giy = 0;
            if (this.giz) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.giz = false;
        }
    }

    public void aIQ() {
        if (pP()) {
            com.baidu.tieba.homepage.framework.a.bvp().n(0L, 1);
        } else if (this.giq != null) {
            bwJ();
            this.mPn++;
            setIsLoading(true);
            this.giq.w(this.mPn, (this.gir == null || this.gir.thread_list == null) ? 0 : this.gir.thread_list.size(), lr(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.gir == null || this.gir.thread_list == null) ? 0 : this.gir.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.aa(dataRes.thread_list)) {
            if (this.giq != null) {
                this.giq.bwC();
            }
            setIsLoading(false);
            if (this.gcc != null) {
                this.gcc.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.gix = false;
            if (this.mDataList.size() > 0) {
                if (this.giq != null) {
                    this.giq.onError(1, str);
                }
            } else if (this.giq != null) {
                this.giq.onError(2, str);
            }
        } else {
            bwF();
            if (this.giq != null) {
                this.giq.onSuccess();
            }
            this.gix = true;
            this.gap = z;
            this.giy = size;
            bgf();
        }
        setIsLoading(false);
        if (this.gcc != null) {
            h.e bwI = bwI();
            if (this.gcc.akQ() && bwI != null) {
                this.gcc.c(bwI);
            } else {
                this.gcc.setRefreshing(false);
            }
        }
    }

    private h.e bwI() {
        int i;
        String alX;
        if (this.gix && this.gcc != null && this.gcc.akQ()) {
            int i2 = this.git;
            if (this.gap) {
                com.baidu.tieba.q.c.coo().b(this.giD, false);
                if (ls(false)) {
                    i = 3;
                } else {
                    i = this.giy > 0 ? 2 : 0;
                }
            } else if (this.gap || this.git != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.ghx != null) {
                this.giu.bnT();
            }
            if (this.ghx != null && this.ghx.getCurrentTabType() != 1) {
                this.giu.hideTip();
                return null;
            } else if (!this.giB) {
                this.giu.hideTip();
                return null;
            } else {
                this.gis = i;
                if (i == 2) {
                    if (i2 > 0) {
                        alX = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        alX = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                    }
                } else if (i == 3) {
                    alX = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
                } else {
                    alX = i == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().alX() : null;
                }
                if (TextUtils.isEmpty(alX) || !j.kc()) {
                    return null;
                }
                if (i == 4) {
                    this.fyk = 1000;
                } else {
                    this.fyk = 0;
                }
                return new h.e(alX, this.fyk);
            }
        }
        return null;
    }

    public void lg(boolean z) {
        if (z) {
            this.ghJ.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fwk != null) {
            this.fwk.destroy();
        }
        if (this.giu != null) {
            this.giu.onDestroy();
        }
        if (this.gip != null) {
            this.gip.onDestroy();
        }
        if (this.fyz != null) {
            this.fyz.removeCallbacks(this.giL);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.fvs);
    }

    public void onPause() {
        c.d(this.fyz);
        ue(this.giK);
        if (this.giw != null) {
            this.giw.avl();
        }
    }

    private void acp() {
        if (this.giq != null) {
            this.giq.M((this.gir == null || this.gir.thread_list == null || bwL()) ? 0 : this.gir.thread_list.size(), lr(true), 0);
        }
    }

    public int lr(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return 0;
        }
        if (z) {
            int i5 = 0;
            int i6 = -1;
            int i7 = 0;
            while (i5 < this.mDataList.size()) {
                com.baidu.adp.widget.ListView.m mVar = this.mDataList.get(i5);
                if (!(mVar instanceof com.baidu.tieba.card.data.c) || (i3 = ((com.baidu.tieba.card.data.c) mVar).position) == i6) {
                    i3 = i6;
                    i4 = i7;
                } else {
                    i4 = i7 + 1;
                }
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.bEI) {
                    i5++;
                    i7 = i4;
                    i6 = i3;
                } else {
                    return i4;
                }
            }
        } else {
            int size = this.mDataList.size() - 1;
            int i8 = 0;
            int i9 = -1;
            while (size >= 0) {
                com.baidu.adp.widget.ListView.m mVar2 = this.mDataList.get(size);
                if (!(mVar2 instanceof com.baidu.tieba.card.data.c) || (i = ((com.baidu.tieba.card.data.c) mVar2).position) == i9) {
                    i = i9;
                    i2 = i8;
                } else {
                    i2 = i8 + 1;
                }
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.bEI) {
                    return i2;
                }
                size--;
                i8 = i2;
                i9 = i;
            }
        }
        return this.mDataList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.gcl = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bwL()) {
                if (this.giq != null) {
                    this.giq.onSuccess();
                    return;
                }
                return;
            }
            acp();
            return;
        }
        acp();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void k(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo baf;
        AdvertAppInfo baf2;
        if (!v.aa(list)) {
            Set<com.baidu.adp.widget.ListView.m> DS = com.baidu.tieba.recapp.report.a.DS("NEWINDEX");
            HashSet hashSet = DS == null ? new HashSet() : DS;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (baf2 = ((com.baidu.tieba.card.data.d) mVar).baf()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == baf2.hashCode()) {
                            baf2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (baf = ((com.baidu.tieba.card.data.d) mVar).baf()) != null && baf.advertAppContext == null) {
                        baf.advertAppContext = new com.baidu.tbadk.core.data.c();
                        baf.advertAppContext.page = "NEWINDEX";
                        baf.advertAppContext.pn = this.mPn;
                        baf.advertAppContext.extensionInfo = baf.extensionInfo;
                        baf.advertAppContext.Rn = false;
                        hashSet2.add(baf);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.e("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.coo().b(this.giD, com.baidu.tieba.q.a.b("a002", "common_fill", true, hashSet2.size()));
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
        if (this.giF == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bwL())) {
                bwK();
                this.gir = null;
            }
        } else if (z2 && bwL()) {
            this.gir = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.giv.a(z, this.gir, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.cRs;
            this.git = a2.gkK;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.giz) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.gir == null) {
            this.gir = builder;
            this.gip.cF(this.gir.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.giA = new g();
                    this.giA.a(dataRes.live_answer);
                    this.gir.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.giA = null;
                    this.gir.live_answer = null;
                }
                this.giC = dataRes.float_info;
                this.gir.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_maintab_banner_close_time", 0L);
            if (this.giA != null && !com.baidu.tbadk.core.util.aq.bc(j)) {
                this.mDataList.add(0, this.giA);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.ghJ.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.ghJ.aF(linkedList);
            z4 = true;
            if (this.fwk != null && this.ghs) {
                this.fwk.c(this.fvy, this.dml, this.fwd, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bvp().l(System.currentTimeMillis() - currentTimeMillis, 1);
        long tK = com.baidu.tieba.homepage.framework.a.bvp().tK(1);
        if (tK > 0) {
            com.baidu.tieba.homepage.framework.a.bvp().m(System.currentTimeMillis() - tK, 1);
            com.baidu.tieba.homepage.framework.a.bvp().n(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        av avVar = new av();
        avVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, avVar));
        return z4;
    }

    private void bwJ() {
        if (v.Z(this.mDataList) >= this.giv.bxe() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.giv.a(true, this.gir, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.cRs : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.ghJ.aF(new LinkedList(this.mDataList));
            }
        }
    }

    private void acq() {
        this.gcl = true;
        aa.a(new com.baidu.tbadk.util.z<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bwQ */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bD = com.baidu.tbadk.core.d.a.agF().bD("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        }, new com.baidu.tbadk.util.k<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void bgf() {
        if (this.gir != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gir.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bwK() {
        if (this.gir != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.gir.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.gip.cG(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.d.a.agF().bD("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
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
                        int f = com.baidu.adp.lib.g.b.f(next.pos_name, -1);
                        if (f < 0) {
                            it.remove();
                        } else if (f < i + i2 + 1) {
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
    public void yh(String str) {
        if (!TextUtils.isEmpty(str) && this.gir != null && this.gir.banner_list != null && this.gir.banner_list.app != null && this.gir.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.gir.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.gir.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.gir.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.gir.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.gip.cG(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.d.a.agF().bD("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bwL() {
        return ls(true);
    }

    private boolean ls(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.ahO().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.gio;
    }

    public void a(a aVar) {
        this.giq = aVar;
    }

    private boolean pP() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bwz() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.alQ() && !StringUtils.isNull(activityPrizeData.alX())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("activity_prize_feed_text_time", "");
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
                    bJ(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.ahO().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bJ(int i, int i2) {
        if (this.ghx != null) {
            this.giu.bnT();
        }
        if (this.ghx != null && this.ghx.getCurrentTabType() != 1) {
            this.giu.hideTip();
        } else if (!this.giB) {
            this.giu.hideTip();
        } else {
            this.gis = i;
            String str = null;
            if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().alX();
            }
            if (!TextUtils.isEmpty(str) && j.kc()) {
                if (i == 4) {
                    this.fyk = 3000;
                } else {
                    this.fyk = 2000;
                }
                this.giE.caR = str;
                this.giE.fyc = this.fyk;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                FrameLayout frameLayout = this.ghx.getFrameLayout();
                frameLayout.removeView(this.giE);
                frameLayout.addView(this.giE, layoutParams);
                this.giE.bnR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Long l) {
        if (this.gir != null && this.gir.thread_list != null) {
            List<ThreadInfo> list = this.gir.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bgf();
                    a(false, true, false, this.gir.build(true));
                    return;
                }
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.giD = bdUniqueId;
            if (this.fKJ != null) {
                this.fKJ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fKJ);
            }
            if (this.giH != null) {
                this.giH.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.giH);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.giI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.giI);
            this.fMP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fMP);
            this.fMQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fMQ);
            this.fKY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fKY);
            if (this.fwk != null) {
                this.fwk.setUniqueId(bdUniqueId);
            }
            this.gip.j(bdUniqueId);
            this.giN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.giN);
            this.fvr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fvr);
            this.giO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.giO);
        }
    }

    public void bwM() {
        this.ftL = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.ftL.coQ();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.ftL != null) {
            if (i == 0) {
                this.ftL.coQ();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.jex;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.ftL.cz(i3, i7 + 1);
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

    public void ud(int i) {
        if ((this.ftL != null ? this.ftL.Bb(i) : -1) >= 0 && this.fyz != null && this.fyz.getData() != null && this.fyz.getData().size() > i) {
            this.ftL.Bc(i);
        }
    }

    public m bmJ() {
        return this.fwk;
    }

    public void lm(boolean z) {
        this.ghs = z;
    }

    public void ue(final int i) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.d.a.agF().bE(e.this.giJ, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(e.this.giJ, Integer.toString(i), 43200000L);
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
            /* renamed from: bwP */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.d.a.agF().bE(e.this.giJ, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    return bE.get(e.this.giJ);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.k<String>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: yi */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.tL(com.baidu.adp.lib.g.b.f(str, 0));
                }
            }
        });
    }

    public void bwA() {
        c.e(this.fyz);
    }

    public void bwN() {
        a(this.giM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gir != null && v.Z(this.gir.thread_list) != 0 && v.Z(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.fyz != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.fyz.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.fyz.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.acx() != null && jVar.acx().aeQ() != null && optString2.equals(String.valueOf(jVar.acx().aeQ().live_id))) {
                                str = jVar.acx().getTid();
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
                    if (cVar.acx() != null && cVar.acx().getTid() != null) {
                        if (cVar.acx().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cI(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.gir != null && this.gir.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.gir.thread_list.size()) {
                        ThreadInfo threadInfo = this.gir.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                            i2++;
                        } else {
                            this.gir.thread_list.remove(i2);
                            bgf();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.gir.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.fyz != null) {
                    List<Integer> b = b(optString, this.fyz);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.fyz.t(intValue, intValue2);
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
                    if (cVar.acx() != null && cVar.acx().getTid().equals(str)) {
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
    public void h(String str, List<com.baidu.adp.widget.ListView.m> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).baf();
                } else {
                    if (next instanceof ad) {
                        ad adVar = (ad) next;
                        if (adVar.ada() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.ada()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.bET)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.giE != null) {
            this.giE.onChangeSkinType(i);
        }
    }

    public FloatInfo bwO() {
        return this.giC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z bwm() {
        if (this.fwk == null || this.fwk.ced() == null || !(this.fwk.ced().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fwk.ced().getTag();
    }
}
