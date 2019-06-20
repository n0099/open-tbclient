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
import com.baidu.tbadk.core.util.ap;
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
    private w cBT;
    private View.OnTouchListener cnC;
    private com.baidu.tieba.f.a fMw;
    private boolean fVs;
    private final BigdaySwipeRefreshLayout fXf;
    private com.baidu.tieba.tbadkCore.data.f foM;
    private m frm;
    private final BdTypeRecyclerView ftD;
    private ScrollFragmentTabHost gbi;
    private final com.baidu.tieba.homepage.personalize.a.w gbu;
    private final long gcb;
    private final b gcc;
    private DataRes.Builder gce;
    private aq gch;
    private final com.baidu.tieba.homepage.personalize.model.a gci;
    private int gcm;
    private g gco;
    private BdUniqueId gcr;
    private SmartBubbleAnimatedView gcs;
    private int gct;
    private Runnable gcz;
    private final TbPageContext<?> mPageContext;
    private a gcd = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean fXo = false;
    private int gcf = 2;
    private int gcg = 0;
    private TextView bNm = null;
    private int fto = 2000;
    private com.baidu.tbadk.p.c gcj = null;
    private boolean frf = false;
    private int fqA = 0;
    private int dkD = 0;
    private boolean mIsBackground = false;
    private boolean gck = true;
    private boolean gcl = false;
    private boolean gcn = false;
    private boolean gcp = true;
    private FloatInfo gcq = null;
    private a.C0038a fpf = new a.C0038a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int gcH = -1;
        private int fXt = 0;
        private boolean gcI = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.gcj == null) {
                e.this.gcj = new com.baidu.tbadk.p.c();
                e.this.gcj.kK(1005);
                e.this.gcj.pageType = 1;
            }
            if (e.this.cBT != null && !e.this.mIsBackground) {
                e.this.cBT.i(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.ftD);
                e.this.gcj.aub();
                t.aXP().gM(true);
                com.baidu.tieba.a.d.aBq().bJ("page_recommend", "show_");
                com.baidu.tieba.q.c.clw().b(e.this.gcr, false);
                this.gcI = false;
                if (e.this.frm != null && e.this.gck) {
                    e.this.frm.a(e.this.fqA, e.this.dkD, e.this.frf, 1);
                    return;
                }
                return;
            }
            e.this.gcj.aua();
            if (i == 1) {
                if (e.this.gch != null) {
                    e.this.gch.hideTip();
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
            if (this.fXt > i) {
                this.gcI = true;
            }
            if (e.this.cBT != null && !e.this.mIsBackground) {
                e.this.cBT.onScroll(this.fXt, i);
            }
            this.fXt = i;
            int i3 = (i + i2) - 1;
            if (!this.gcI && this.gcH != i3) {
                this.gcH = i3;
                e.this.tF(this.gcH);
            }
            if (this.gcI && this.gcH != i) {
                this.gcH = i;
                e.this.tF(this.gcH);
            }
            e.this.gcy = i;
            e.this.fqA = i;
            e.this.dkD = (i + i2) - 1;
            z buk = e.this.buk();
            if (buk != null && buk.qs() != null) {
                buk.qs().b(e.this.fpf);
            }
        }
    };
    private View.OnTouchListener clc = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cnC != null) {
                e.this.cnC.onTouch(view, motionEvent);
            }
            if (e.this.fMw != null) {
                e.this.fMw.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0302a dWk = new a.InterfaceC0302a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            e.this.frf = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            e.this.frf = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aV(int i, int i2) {
        }
    };
    private View.OnClickListener gcu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gch != null) {
                e.this.gch.hideTip();
            }
        }
    };
    private final CustomMessageListener gcv = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.ftD != null) {
                e.this.frm.bvS();
                e.this.gck = false;
                e.this.fXf.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener fFL = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg) && e.this.gce != null && v.Z(e.this.gce.thread_list) != 0 && (bgVar = (bg) customResponsedMessage.getData()) != null && bgVar.adh() != null && bgVar.getId() != null && v.Z(e.this.gce.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.gce.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.gce.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bgVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bgVar.adh().getNum());
                            builder.zan = builder2.build(true);
                            e.this.gce.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener gcw = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.5
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
                        if ((originData.get(i2) instanceof bg) && (bgVar = (bg) originData.get(i2)) != null && bgVar.adO() != null && ids.contains(Long.valueOf(bgVar.adO().live_id))) {
                            e.this.mDataList.remove(bgVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.gbu != null) {
                        e.this.gbu.aF(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.gce != null && !v.aa(e.this.gce.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.gce.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.gce.thread_list.get(i);
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
                            e.this.gce.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String gcx = "lastReadReadPositionKey";
    private int gcy = 0;
    private d gcA = new d() { // from class: com.baidu.tieba.homepage.personalize.e.8
        @Override // com.baidu.tieba.homepage.personalize.d
        public void tt(final int i) {
            if (e.this.gcz == null) {
                e.this.gcz = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.ftD.getHandler() != null) {
                            e.this.ftD.requestFocusFromTouch();
                            if (i <= e.this.ftD.getCount() - 1) {
                                e.this.ftD.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.ftD.removeCallbacks(e.this.gcz);
            e.this.ftD.post(e.this.gcz);
        }
    };
    private CustomMessageListener gcB = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gco != null) {
                e.this.mDataList.remove(e.this.gco);
                e.this.gbu.aF(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.agM().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener fHR = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.frm != null && e.this.gck) {
                e.this.frm.c(e.this.fqA, e.this.dkD, e.this.frf, true);
            }
        }
    };
    private CustomMessageListener fHS = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fGa = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gce != null && v.Z(e.this.gce.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.xy(str);
                if (e.this.gbu != null) {
                    e.this.gbu.aF(new ArrayList(e.this.mDataList));
                }
                if (e.this.frm != null && e.this.gck) {
                    e.this.frm.c(e.this.fqA, e.this.dkD, e.this.frf, true);
                }
            }
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z buk;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (buk = e.this.buk()) != null && buk.qs() != null) {
                    buk.qs().b(new a.C0038a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gcC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TOPIC_BLESS, 309085) { // from class: com.baidu.tieba.homepage.personalize.e.17
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).ggO) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fqu = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.gbu.getDataList();
            if (!v.aa(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bIg != 0 && kVar.threadData != null) {
                            int[] afo = kVar.threadData.afo();
                            kVar.bIg = afo[0];
                            kVar.bIh = afo[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.18.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gbu.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.gck) {
                        e.this.frm.c(e.this.fqA, e.this.dkD, e.this.frf, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void L(int i, int i2, int i3);

        void btX();

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3, int i4);
    }

    public void ld(boolean z) {
        this.gcp = z;
        if (this.gch != null && !z) {
            this.gch.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gbi = scrollFragmentTabHost;
        if (this.gbi != null) {
            this.gbi.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void tE(int i) {
                    if (e.this.gbi.tD(i) != 1 && e.this.gch != null) {
                        e.this.gch.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void jS(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.frm != null) {
            this.frm.mT(!z);
            z buk = buk();
            if (buk != null && buk.qs() != null) {
                z2 = buk.qs().b(new a.C0038a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.frm.bvS();
                } else if (this.gck) {
                    this.frm.c(this.fqA, this.dkD, this.frf, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.personalize.a.w wVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gct = 0;
        this.mPageContext = tbPageContext;
        this.gct = com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_personalized_refresh_type", 0);
        this.fXf = bigdaySwipeRefreshLayout;
        this.ftD = bdTypeRecyclerView;
        this.ftD.setOnTouchListener(this.clc);
        this.fMw = new com.baidu.tieba.f.a();
        this.fMw.a(this.dWk);
        this.gbu = wVar;
        this.gci = new com.baidu.tieba.homepage.personalize.model.a();
        this.gcb = com.baidu.tbadk.core.sharedPref.b.agM().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gch = new aq();
        buh();
        this.frm = new m(this.mPageContext, this.ftD);
        this.frm.yr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gcc = new b(this.mDataList, this.gbu);
        this.gcs = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gcs.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        btY();
        this.fqu.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fqu);
    }

    private void btY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.23
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                z buk = e.this.buk();
                return (buk == null || buk.qs() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(buk.qs().b(new a.C0038a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean btZ() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(bub(), true);
    }

    private void bua() {
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean(bub(), false);
    }

    private String bub() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.cBT = xVar.avn();
            this.cnC = xVar.avo();
        }
    }

    public void showFloatingView() {
        if (this.cBT != null) {
            this.cBT.fI(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.btn().n(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.gcn = true;
        if (this.mDataList.size() == 0 && !btZ()) {
            if (!this.fXo) {
                abr();
                return;
            }
            return;
        }
        abq();
    }

    public void bC(int i, int i2) {
        bg bgVar;
        if (!v.aa(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bg.bIy.getId() && (bgVar = (bg) this.mDataList.get(i)) != null && bgVar.adO() != null) {
                    arrayList.add(Long.valueOf(bgVar.adO().live_id));
                    arrayList2.add(bgVar);
                }
                i++;
            }
            if (!v.aa(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void buc() {
        if (this.frm != null && !this.mIsBackground && this.gck) {
            this.frm.c(this.fqA, this.dkD, this.frf, true);
        }
        if (this.gcl) {
            if (this.fXf != null && !this.fXf.ajL()) {
                if (this.fVs) {
                    com.baidu.tieba.q.c.clw().b(this.gcr, false);
                    if (lf(false)) {
                        bD(3, this.gcg);
                    } else if (this.gcm > 0) {
                        bD(2, this.gcg);
                    }
                } else if (!this.fVs && this.gcg == 0) {
                    bD(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.agM().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.gcl = false;
            this.fVs = false;
            this.gcm = 0;
            if (this.gcn) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.gcn = false;
        }
    }

    public void aHt() {
        if (pu()) {
            com.baidu.tieba.homepage.framework.a.btn().n(0L, 1);
        } else if (this.gcd != null) {
            bue();
            this.mPn++;
            setIsLoading(true);
            this.gcd.v(this.mPn, (this.gce == null || this.gce.thread_list == null) ? 0 : this.gce.thread_list.size(), le(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.gce == null || this.gce.thread_list == null) ? 0 : this.gce.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.aa(dataRes.thread_list)) {
            if (this.gcd != null) {
                this.gcd.btX();
            }
            setIsLoading(false);
            if (this.fXf != null) {
                this.fXf.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.gcl = false;
            if (this.mDataList.size() > 0) {
                if (this.gcd != null) {
                    this.gcd.onError(1, str);
                }
            } else if (this.gcd != null) {
                this.gcd.onError(2, str);
            }
        } else {
            bua();
            if (this.gcd != null) {
                this.gcd.onSuccess();
            }
            this.gcl = true;
            this.fVs = z;
            this.gcm = size;
            bec();
        }
        setIsLoading(false);
        if (this.fXf != null) {
            h.e bud = bud();
            if (this.fXf.ajL() && bud != null) {
                this.fXf.b(bud);
            } else {
                this.fXf.setRefreshing(false);
            }
        }
    }

    private h.e bud() {
        int i;
        String akS;
        if (this.gcl && this.fXf != null && this.fXf.ajL()) {
            int i2 = this.gcg;
            if (this.fVs) {
                com.baidu.tieba.q.c.clw().b(this.gcr, false);
                if (lf(false)) {
                    i = 3;
                } else {
                    i = this.gcm > 0 ? 2 : 0;
                }
            } else if (this.fVs || this.gcg != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.gbi != null) {
                this.gch.blS();
            }
            if (this.gbi != null && this.gbi.getCurrentTabType() != 1) {
                this.gch.hideTip();
                return null;
            } else if (!this.gcp) {
                this.gch.hideTip();
                return null;
            } else {
                this.gcf = i;
                if (i == 2) {
                    if (i2 > 0) {
                        akS = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        akS = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                    }
                } else if (i == 3) {
                    akS = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
                } else {
                    akS = i == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().akS() : null;
                }
                if (TextUtils.isEmpty(akS) || !j.jS()) {
                    return null;
                }
                if (i == 4) {
                    this.fto = 1000;
                } else {
                    this.fto = 0;
                }
                return new h.e(akS, this.fto);
            }
        }
        return null;
    }

    public void kW(boolean z) {
        if (z) {
            this.gbu.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.frm != null) {
            this.frm.destroy();
        }
        if (this.gch != null) {
            this.gch.onDestroy();
        }
        if (this.gcc != null) {
            this.gcc.onDestroy();
        }
        if (this.ftD != null) {
            this.ftD.removeCallbacks(this.gcz);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.fqu);
    }

    public void onPause() {
        c.d(this.ftD);
        tG(this.gcy);
        if (this.gcj != null) {
            this.gcj.auc();
        }
    }

    private void abq() {
        if (this.gcd != null) {
            this.gcd.L((this.gce == null || this.gce.thread_list == null || bug()) ? 0 : this.gce.thread_list.size(), le(true), 0);
        }
    }

    public int le(boolean z) {
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.bDI) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.bDI) {
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
        this.fXo = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bug()) {
                if (this.gcd != null) {
                    this.gcd.onSuccess();
                    return;
                }
                return;
            }
            abq();
            return;
        }
        abq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void k(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo aYg;
        AdvertAppInfo aYg2;
        if (!v.aa(list)) {
            Set<com.baidu.adp.widget.ListView.m> Df = com.baidu.tieba.recapp.report.a.Df("NEWINDEX");
            HashSet hashSet = Df == null ? new HashSet() : Df;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (aYg2 = ((com.baidu.tieba.card.data.d) mVar).aYg()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == aYg2.hashCode()) {
                            aYg2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (aYg = ((com.baidu.tieba.card.data.d) mVar).aYg()) != null && aYg.advertAppContext == null) {
                        aYg.advertAppContext = new com.baidu.tbadk.core.data.c();
                        aYg.advertAppContext.page = "NEWINDEX";
                        aYg.advertAppContext.pn = this.mPn;
                        aYg.advertAppContext.extensionInfo = aYg.extensionInfo;
                        aYg.advertAppContext.QV = false;
                        hashSet2.add(aYg);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.d("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.clw().b(this.gcr, com.baidu.tieba.q.a.b("a002", "common_fill", true, hashSet2.size()));
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
        if (this.gct == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bug())) {
                buf();
                this.gce = null;
            }
        } else if (z2 && bug()) {
            this.gce = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gci.a(z, this.gce, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.cPW;
            this.gcg = a2.gez;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.gcn) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.gce == null) {
            this.gce = builder;
            this.gcc.cD(this.gce.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.gco = new g();
                    this.gco.a(dataRes.live_answer);
                    this.gce.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.gco = null;
                    this.gce.live_answer = null;
                }
                this.gcq = dataRes.float_info;
                this.gce.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_maintab_banner_close_time", 0L);
            if (this.gco != null && !ap.bb(j)) {
                this.mDataList.add(0, this.gco);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.gbu.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.gbu.aF(linkedList);
            z4 = true;
            if (this.frm != null && this.gck) {
                this.frm.c(this.fqA, this.dkD, this.frf, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.btn().l(System.currentTimeMillis() - currentTimeMillis, 1);
        long ts = com.baidu.tieba.homepage.framework.a.btn().ts(1);
        if (ts > 0) {
            com.baidu.tieba.homepage.framework.a.btn().m(System.currentTimeMillis() - ts, 1);
            com.baidu.tieba.homepage.framework.a.btn().n(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        av avVar = new av();
        avVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, avVar));
        return z4;
    }

    private void bue() {
        if (v.Z(this.mDataList) >= this.gci.buA() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.gci.a(true, this.gce, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.cPW : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.gbu.aF(new LinkedList(this.mDataList));
            }
        }
    }

    private void abr() {
        this.fXo = true;
        aa.a(new com.baidu.tbadk.util.z<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bum */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bD = com.baidu.tbadk.core.c.a.afD().bD("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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

    private void bec() {
        if (this.gce != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gce.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void buf() {
        if (this.gce != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.gce.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.gcc.cE(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.c.a.afD().bD("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
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
    public void xy(String str) {
        if (!TextUtils.isEmpty(str) && this.gce != null && this.gce.banner_list != null && this.gce.banner_list.app != null && this.gce.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.gce.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.gce.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.gce.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.gce.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.gcc.cE(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.afD().bD("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bug() {
        return lf(true);
    }

    private boolean lf(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.agM().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.gcb;
    }

    public void a(a aVar) {
        this.gcd = aVar;
    }

    private boolean pu() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void btU() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.akL() && !StringUtils.isNull(activityPrizeData.akS())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("activity_prize_feed_text_time", "");
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
                    bD(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bD(int i, int i2) {
        if (this.gbi != null) {
            this.gch.blS();
        }
        if (this.gbi != null && this.gbi.getCurrentTabType() != 1) {
            this.gch.hideTip();
        } else if (!this.gcp) {
            this.gch.hideTip();
        } else {
            this.gcf = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().akS();
            }
            if (!TextUtils.isEmpty(str) && j.jS()) {
                if (i == 4) {
                    this.fto = 3000;
                } else {
                    this.fto = 2000;
                }
                this.gcs.bZP = str;
                this.gcs.ftg = this.fto;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                FrameLayout frameLayout = this.gbi.getFrameLayout();
                frameLayout.removeView(this.gcs);
                frameLayout.addView(this.gcs, layoutParams);
                this.gcs.blQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Long l) {
        if (this.gce != null && this.gce.thread_list != null) {
            List<ThreadInfo> list = this.gce.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bec();
                    a(false, true, false, this.gce.build(true));
                    return;
                }
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gcr = bdUniqueId;
            if (this.fFL != null) {
                this.fFL.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fFL);
            }
            if (this.gcv != null) {
                this.gcv.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gcv);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.gcw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gcw);
            this.fHR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fHR);
            this.fHS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fHS);
            this.fGa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fGa);
            if (this.frm != null) {
                this.frm.setUniqueId(bdUniqueId);
            }
            this.gcc.i(bdUniqueId);
            this.gcB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gcB);
            this.fqt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fqt);
            this.gcC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gcC);
        }
    }

    public void buh() {
        this.foM = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.foM.clY();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.foM != null) {
            if (i == 0) {
                this.foM.clY();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.iYg;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.foM.cu(i3, i7 + 1);
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

    public void tF(int i) {
        if ((this.foM != null ? this.foM.Av(i) : -1) >= 0 && this.ftD != null && this.ftD.getData() != null && this.ftD.getData().size() > i) {
            this.foM.Aw(i);
        }
    }

    public m bkH() {
        return this.frm;
    }

    public void lg(boolean z) {
        this.gck = z;
    }

    public void tG(final int i) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.c.a.afD().bE(e.this.gcx, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(e.this.gcx, Integer.toString(i), 43200000L);
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
            /* renamed from: bul */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.c.a.afD().bE(e.this.gcx, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    return bE.get(e.this.gcx);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.k<String>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: xz */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.tt(com.baidu.adp.lib.g.b.f(str, 0));
                }
            }
        });
    }

    public void btV() {
        c.e(this.ftD);
    }

    public void bui() {
        a(this.gcA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gce != null && v.Z(this.gce.thread_list) != 0 && v.Z(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.ftD != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.ftD.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.ftD.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.abv() != null && jVar.abv().adO() != null && optString2.equals(String.valueOf(jVar.abv().adO().live_id))) {
                                str = jVar.abv().getTid();
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
                    if (cVar.abv() != null && cVar.abv().getTid() != null) {
                        if (cVar.abv().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cG(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.gce != null && this.gce.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.gce.thread_list.size()) {
                        ThreadInfo threadInfo = this.gce.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                            i2++;
                        } else {
                            this.gce.thread_list.remove(i2);
                            bec();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.gce.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.ftD != null) {
                    List<Integer> b = b(optString, this.ftD);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.ftD.q(intValue, intValue2);
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
                    if (cVar.abv() != null && cVar.abv().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).aYg();
                } else {
                    if (next instanceof ad) {
                        ad adVar = (ad) next;
                        if (adVar.abY() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.abY()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.bDT)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gcs != null) {
            this.gcs.onChangeSkinType(i);
        }
    }

    public FloatInfo buj() {
        return this.gcq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z buk() {
        if (this.frm == null || this.frm.cbo() == null || !(this.frm.cbo().getTag() instanceof z)) {
            return null;
        }
        return (z) this.frm.cbo().getTag();
    }
}
