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
    private w cBS;
    private View.OnTouchListener cnB;
    private com.baidu.tieba.f.a fMt;
    private boolean fVp;
    private final BigdaySwipeRefreshLayout fXc;
    private com.baidu.tieba.tbadkCore.data.f foL;
    private m frl;
    private final BdTypeRecyclerView ftC;
    private final long gbY;
    private final b gbZ;
    private ScrollFragmentTabHost gbf;
    private final com.baidu.tieba.homepage.personalize.a.w gbr;
    private DataRes.Builder gcb;
    private aq gce;
    private final com.baidu.tieba.homepage.personalize.model.a gcf;
    private int gcj;
    private g gcl;
    private BdUniqueId gco;
    private SmartBubbleAnimatedView gcp;
    private int gcq;
    private Runnable gcw;
    private final TbPageContext<?> mPageContext;
    private a gca = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean fXl = false;
    private int gcc = 2;
    private int gcd = 0;
    private TextView bNl = null;
    private int ftn = 2000;
    private com.baidu.tbadk.p.c gcg = null;
    private boolean fre = false;
    private int fqz = 0;
    private int dkC = 0;
    private boolean mIsBackground = false;
    private boolean gch = true;
    private boolean gci = false;
    private boolean gck = false;
    private boolean gcm = true;
    private FloatInfo gcn = null;
    private a.C0038a fpe = new a.C0038a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int gcE = -1;
        private int fXq = 0;
        private boolean gcF = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.gcg == null) {
                e.this.gcg = new com.baidu.tbadk.p.c();
                e.this.gcg.kK(1005);
                e.this.gcg.pageType = 1;
            }
            if (e.this.cBS != null && !e.this.mIsBackground) {
                e.this.cBS.i(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.ftC);
                e.this.gcg.aub();
                t.aXM().gM(true);
                com.baidu.tieba.a.d.aBn().bJ("page_recommend", "show_");
                com.baidu.tieba.q.c.clt().b(e.this.gco, false);
                this.gcF = false;
                if (e.this.frl != null && e.this.gch) {
                    e.this.frl.a(e.this.fqz, e.this.dkC, e.this.fre, 1);
                    return;
                }
                return;
            }
            e.this.gcg.aua();
            if (i == 1) {
                if (e.this.gce != null) {
                    e.this.gce.hideTip();
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
            if (this.fXq > i) {
                this.gcF = true;
            }
            if (e.this.cBS != null && !e.this.mIsBackground) {
                e.this.cBS.onScroll(this.fXq, i);
            }
            this.fXq = i;
            int i3 = (i + i2) - 1;
            if (!this.gcF && this.gcE != i3) {
                this.gcE = i3;
                e.this.tF(this.gcE);
            }
            if (this.gcF && this.gcE != i) {
                this.gcE = i;
                e.this.tF(this.gcE);
            }
            e.this.gcv = i;
            e.this.fqz = i;
            e.this.dkC = (i + i2) - 1;
            z bug = e.this.bug();
            if (bug != null && bug.qs() != null) {
                bug.qs().b(e.this.fpe);
            }
        }
    };
    private View.OnTouchListener clb = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cnB != null) {
                e.this.cnB.onTouch(view, motionEvent);
            }
            if (e.this.fMt != null) {
                e.this.fMt.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0302a dWj = new a.InterfaceC0302a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            e.this.fre = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            e.this.fre = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aV(int i, int i2) {
        }
    };
    private View.OnClickListener gcr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gce != null) {
                e.this.gce.hideTip();
            }
        }
    };
    private final CustomMessageListener gcs = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.ftC != null) {
                e.this.frl.bvO();
                e.this.gch = false;
                e.this.fXc.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener fFK = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bg bgVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bg) && e.this.gcb != null && v.Z(e.this.gcb.thread_list) != 0 && (bgVar = (bg) customResponsedMessage.getData()) != null && bgVar.adh() != null && bgVar.getId() != null && v.Z(e.this.gcb.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.gcb.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.gcb.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bgVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bgVar.adh().getNum());
                            builder.zan = builder2.build(true);
                            e.this.gcb.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener gct = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.5
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
                    if (e.this.gbr != null) {
                        e.this.gbr.aF(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.gcb != null && !v.aa(e.this.gcb.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.gcb.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.gcb.thread_list.get(i);
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
                            e.this.gcb.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String gcu = "lastReadReadPositionKey";
    private int gcv = 0;
    private d gcx = new d() { // from class: com.baidu.tieba.homepage.personalize.e.8
        @Override // com.baidu.tieba.homepage.personalize.d
        public void tt(final int i) {
            if (e.this.gcw == null) {
                e.this.gcw = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.ftC.getHandler() != null) {
                            e.this.ftC.requestFocusFromTouch();
                            if (i <= e.this.ftC.getCount() - 1) {
                                e.this.ftC.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.ftC.removeCallbacks(e.this.gcw);
            e.this.ftC.post(e.this.gcw);
        }
    };
    private CustomMessageListener gcy = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gcl != null) {
                e.this.mDataList.remove(e.this.gcl);
                e.this.gbr.aF(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.agM().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener fHN = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.frl != null && e.this.gch) {
                e.this.frl.c(e.this.fqz, e.this.dkC, e.this.fre, true);
            }
        }
    };
    private CustomMessageListener fHO = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fHP = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gcb != null && v.Z(e.this.gcb.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.xw(str);
                if (e.this.gbr != null) {
                    e.this.gbr.aF(new ArrayList(e.this.mDataList));
                }
                if (e.this.frl != null && e.this.gch) {
                    e.this.frl.c(e.this.fqz, e.this.dkC, e.this.fre, true);
                }
            }
        }
    };
    private CustomMessageListener fqs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bug;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bug = e.this.bug()) != null && bug.qs() != null) {
                    bug.qs().b(new a.C0038a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gcz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TOPIC_BLESS, 309085) { // from class: com.baidu.tieba.homepage.personalize.e.17
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).ggL) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.gbr.getDataList();
            if (!v.aa(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bIf != 0 && kVar.threadData != null) {
                            int[] afo = kVar.threadData.afo();
                            kVar.bIf = afo[0];
                            kVar.bIg = afo[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.18.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gbr.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.gch) {
                        e.this.frl.c(e.this.fqz, e.this.dkC, e.this.fre, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void L(int i, int i2, int i3);

        void btT();

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3, int i4);
    }

    public void lc(boolean z) {
        this.gcm = z;
        if (this.gce != null && !z) {
            this.gce.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gbf = scrollFragmentTabHost;
        if (this.gbf != null) {
            this.gbf.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void tE(int i) {
                    if (e.this.gbf.tD(i) != 1 && e.this.gce != null) {
                        e.this.gce.hideTip();
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
        if (this.frl != null) {
            this.frl.mS(!z);
            z bug = bug();
            if (bug != null && bug.qs() != null) {
                z2 = bug.qs().b(new a.C0038a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.frl.bvO();
                } else if (this.gch) {
                    this.frl.c(this.fqz, this.dkC, this.fre, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.personalize.a.w wVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gcq = 0;
        this.mPageContext = tbPageContext;
        this.gcq = com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_personalized_refresh_type", 0);
        this.fXc = bigdaySwipeRefreshLayout;
        this.ftC = bdTypeRecyclerView;
        this.ftC.setOnTouchListener(this.clb);
        this.fMt = new com.baidu.tieba.f.a();
        this.fMt.a(this.dWj);
        this.gbr = wVar;
        this.gcf = new com.baidu.tieba.homepage.personalize.model.a();
        this.gbY = com.baidu.tbadk.core.sharedPref.b.agM().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gce = new aq();
        bud();
        this.frl = new m(this.mPageContext, this.ftC);
        this.frl.yr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gbZ = new b(this.mDataList, this.gbr);
        this.gcp = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gcp.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        btU();
        this.fqt.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fqt);
    }

    private void btU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.23
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                z bug = e.this.bug();
                return (bug == null || bug.qs() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bug.qs().b(new a.C0038a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean btV() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(btX(), true);
    }

    private void btW() {
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean(btX(), false);
    }

    private String btX() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.cBS = xVar.avn();
            this.cnB = xVar.avo();
        }
    }

    public void showFloatingView() {
        if (this.cBS != null) {
            this.cBS.fI(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.btj().n(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.gck = true;
        if (this.mDataList.size() == 0 && !btV()) {
            if (!this.fXl) {
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
                if (this.mDataList.get(i).getType().getId() == bg.bIx.getId() && (bgVar = (bg) this.mDataList.get(i)) != null && bgVar.adO() != null) {
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

    public void btY() {
        if (this.frl != null && !this.mIsBackground && this.gch) {
            this.frl.c(this.fqz, this.dkC, this.fre, true);
        }
        if (this.gci) {
            if (this.fXc != null && !this.fXc.ajL()) {
                if (this.fVp) {
                    com.baidu.tieba.q.c.clt().b(this.gco, false);
                    if (le(false)) {
                        bD(3, this.gcd);
                    } else if (this.gcj > 0) {
                        bD(2, this.gcd);
                    }
                } else if (!this.fVp && this.gcd == 0) {
                    bD(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.agM().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.gci = false;
            this.fVp = false;
            this.gcj = 0;
            if (this.gck) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.gck = false;
        }
    }

    public void aHq() {
        if (pu()) {
            com.baidu.tieba.homepage.framework.a.btj().n(0L, 1);
        } else if (this.gca != null) {
            bua();
            this.mPn++;
            setIsLoading(true);
            this.gca.v(this.mPn, (this.gcb == null || this.gcb.thread_list == null) ? 0 : this.gcb.thread_list.size(), ld(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.gcb == null || this.gcb.thread_list == null) ? 0 : this.gcb.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.aa(dataRes.thread_list)) {
            if (this.gca != null) {
                this.gca.btT();
            }
            setIsLoading(false);
            if (this.fXc != null) {
                this.fXc.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.gci = false;
            if (this.mDataList.size() > 0) {
                if (this.gca != null) {
                    this.gca.onError(1, str);
                }
            } else if (this.gca != null) {
                this.gca.onError(2, str);
            }
        } else {
            btW();
            if (this.gca != null) {
                this.gca.onSuccess();
            }
            this.gci = true;
            this.fVp = z;
            this.gcj = size;
            bdZ();
        }
        setIsLoading(false);
        if (this.fXc != null) {
            h.e btZ = btZ();
            if (this.fXc.ajL() && btZ != null) {
                this.fXc.b(btZ);
            } else {
                this.fXc.setRefreshing(false);
            }
        }
    }

    private h.e btZ() {
        int i;
        String akS;
        if (this.gci && this.fXc != null && this.fXc.ajL()) {
            int i2 = this.gcd;
            if (this.fVp) {
                com.baidu.tieba.q.c.clt().b(this.gco, false);
                if (le(false)) {
                    i = 3;
                } else {
                    i = this.gcj > 0 ? 2 : 0;
                }
            } else if (this.fVp || this.gcd != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.gbf != null) {
                this.gce.blP();
            }
            if (this.gbf != null && this.gbf.getCurrentTabType() != 1) {
                this.gce.hideTip();
                return null;
            } else if (!this.gcm) {
                this.gce.hideTip();
                return null;
            } else {
                this.gcc = i;
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
                    this.ftn = 1000;
                } else {
                    this.ftn = 0;
                }
                return new h.e(akS, this.ftn);
            }
        }
        return null;
    }

    public void kV(boolean z) {
        if (z) {
            this.gbr.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.frl != null) {
            this.frl.destroy();
        }
        if (this.gce != null) {
            this.gce.onDestroy();
        }
        if (this.gbZ != null) {
            this.gbZ.onDestroy();
        }
        if (this.ftC != null) {
            this.ftC.removeCallbacks(this.gcw);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.fqt);
    }

    public void onPause() {
        c.d(this.ftC);
        tG(this.gcv);
        if (this.gcg != null) {
            this.gcg.auc();
        }
    }

    private void abq() {
        if (this.gca != null) {
            this.gca.L((this.gcb == null || this.gcb.thread_list == null || buc()) ? 0 : this.gcb.thread_list.size(), ld(true), 0);
        }
    }

    public int ld(boolean z) {
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.bDH) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.bDH) {
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
        this.fXl = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !buc()) {
                if (this.gca != null) {
                    this.gca.onSuccess();
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
        AdvertAppInfo aYd;
        AdvertAppInfo aYd2;
        if (!v.aa(list)) {
            Set<com.baidu.adp.widget.ListView.m> Dd = com.baidu.tieba.recapp.report.a.Dd("NEWINDEX");
            HashSet hashSet = Dd == null ? new HashSet() : Dd;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (aYd2 = ((com.baidu.tieba.card.data.d) mVar).aYd()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == aYd2.hashCode()) {
                            aYd2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (aYd = ((com.baidu.tieba.card.data.d) mVar).aYd()) != null && aYd.advertAppContext == null) {
                        aYd.advertAppContext = new com.baidu.tbadk.core.data.c();
                        aYd.advertAppContext.page = "NEWINDEX";
                        aYd.advertAppContext.pn = this.mPn;
                        aYd.advertAppContext.extensionInfo = aYd.extensionInfo;
                        aYd.advertAppContext.QW = false;
                        hashSet2.add(aYd);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.d("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.clt().b(this.gco, com.baidu.tieba.q.a.b("a002", "common_fill", true, hashSet2.size()));
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
        if (this.gcq == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || buc())) {
                bub();
                this.gcb = null;
            }
        } else if (z2 && buc()) {
            this.gcb = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gcf.a(z, this.gcb, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.cPV;
            this.gcd = a2.gew;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.gck) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.gcb == null) {
            this.gcb = builder;
            this.gbZ.cD(this.gcb.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.gcl = new g();
                    this.gcl.a(dataRes.live_answer);
                    this.gcb.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.gcl = null;
                    this.gcb.live_answer = null;
                }
                this.gcn = dataRes.float_info;
                this.gcb.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_maintab_banner_close_time", 0L);
            if (this.gcl != null && !ap.bb(j)) {
                this.mDataList.add(0, this.gcl);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.gbr.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.gbr.aF(linkedList);
            z4 = true;
            if (this.frl != null && this.gch) {
                this.frl.c(this.fqz, this.dkC, this.fre, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.btj().l(System.currentTimeMillis() - currentTimeMillis, 1);
        long ts = com.baidu.tieba.homepage.framework.a.btj().ts(1);
        if (ts > 0) {
            com.baidu.tieba.homepage.framework.a.btj().m(System.currentTimeMillis() - ts, 1);
            com.baidu.tieba.homepage.framework.a.btj().n(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        av avVar = new av();
        avVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, avVar));
        return z4;
    }

    private void bua() {
        if (v.Z(this.mDataList) >= this.gcf.buw() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.gcf.a(true, this.gcb, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.cPV : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.gbr.aF(new LinkedList(this.mDataList));
            }
        }
    }

    private void abr() {
        this.fXl = true;
        aa.a(new com.baidu.tbadk.util.z<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bui */
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

    private void bdZ() {
        if (this.gcb != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gcb.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bub() {
        if (this.gcb != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.gcb.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.gbZ.cE(builder2.thread_list);
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
    public void xw(String str) {
        if (!TextUtils.isEmpty(str) && this.gcb != null && this.gcb.banner_list != null && this.gcb.banner_list.app != null && this.gcb.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.gcb.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.gcb.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.gcb.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.gcb.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.gbZ.cE(builder2.thread_list);
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

    private boolean buc() {
        return le(true);
    }

    private boolean le(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.agM().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.gbY;
    }

    public void a(a aVar) {
        this.gca = aVar;
    }

    private boolean pu() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void btQ() {
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
        if (this.gbf != null) {
            this.gce.blP();
        }
        if (this.gbf != null && this.gbf.getCurrentTabType() != 1) {
            this.gce.hideTip();
        } else if (!this.gcm) {
            this.gce.hideTip();
        } else {
            this.gcc = i;
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
                    this.ftn = 3000;
                } else {
                    this.ftn = 2000;
                }
                this.gcp.bZO = str;
                this.gcp.ftf = this.ftn;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                FrameLayout frameLayout = this.gbf.getFrameLayout();
                frameLayout.removeView(this.gcp);
                frameLayout.addView(this.gcp, layoutParams);
                this.gcp.blN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Long l) {
        if (this.gcb != null && this.gcb.thread_list != null) {
            List<ThreadInfo> list = this.gcb.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bdZ();
                    a(false, true, false, this.gcb.build(true));
                    return;
                }
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gco = bdUniqueId;
            if (this.fFK != null) {
                this.fFK.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fFK);
            }
            if (this.gcs != null) {
                this.gcs.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gcs);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.gct.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gct);
            this.fHN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fHN);
            this.fHO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fHO);
            this.fHP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fHP);
            if (this.frl != null) {
                this.frl.setUniqueId(bdUniqueId);
            }
            this.gbZ.i(bdUniqueId);
            this.gcy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gcy);
            this.fqs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fqs);
            this.gcz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gcz);
        }
    }

    public void bud() {
        this.foL = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.foL.clV();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.foL != null) {
            if (i == 0) {
                this.foL.clV();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.iYa;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.foL.cu(i3, i7 + 1);
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
        if ((this.foL != null ? this.foL.Av(i) : -1) >= 0 && this.ftC != null && this.ftC.getData() != null && this.ftC.getData().size() > i) {
            this.foL.Aw(i);
        }
    }

    public m bkE() {
        return this.frl;
    }

    public void lf(boolean z) {
        this.gch = z;
    }

    public void tG(final int i) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.c.a.afD().bE(e.this.gcu, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(e.this.gcu, Integer.toString(i), 43200000L);
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
            /* renamed from: buh */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.c.a.afD().bE(e.this.gcu, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    return bE.get(e.this.gcu);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.k<String>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: xx */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.tt(com.baidu.adp.lib.g.b.f(str, 0));
                }
            }
        });
    }

    public void btR() {
        c.e(this.ftC);
    }

    public void bue() {
        a(this.gcx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gcb != null && v.Z(this.gcb.thread_list) != 0 && v.Z(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.ftC != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.ftC.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.ftC.getItem(i);
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
            if (this.gcb != null && this.gcb.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.gcb.thread_list.size()) {
                        ThreadInfo threadInfo = this.gcb.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                            i2++;
                        } else {
                            this.gcb.thread_list.remove(i2);
                            bdZ();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.gcb.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.ftC != null) {
                    List<Integer> b = b(optString, this.ftC);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.ftC.q(intValue, intValue2);
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).aYd();
                } else {
                    if (next instanceof ad) {
                        ad adVar = (ad) next;
                        if (adVar.abY() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.abY()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.bDS)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gcp != null) {
            this.gcp.onChangeSkinType(i);
        }
    }

    public FloatInfo buf() {
        return this.gcn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z bug() {
        if (this.frl == null || this.frl.cbk() == null || !(this.frl.cbk().getTag() instanceof z)) {
            return null;
        }
        return (z) this.frl.cbk().getTag();
    }
}
