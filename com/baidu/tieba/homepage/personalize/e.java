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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bh;
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
    private w cDr;
    private View.OnTouchListener coV;
    private com.baidu.tieba.f.a fSh;
    private com.baidu.tieba.tbadkCore.data.f fuk;
    private m fwJ;
    private final BdTypeRecyclerView fyY;
    private boolean gbf;
    private final BigdaySwipeRefreshLayout gcS;
    private final com.baidu.tieba.homepage.personalize.a.w giA;
    private ScrollFragmentTabHost gio;
    private Runnable gjB;
    private final long gje;
    private final b gjf;
    private DataRes.Builder gjh;
    private aq gjk;
    private final com.baidu.tieba.homepage.personalize.model.a gjl;
    private int gjo;
    private g gjq;
    private BdUniqueId gjt;
    private SmartBubbleAnimatedView gju;
    private int gjv;
    private final TbPageContext<?> mPageContext;
    private a gjg = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean gdb = false;
    private int gji = 2;
    private int gjj = 0;
    private TextView bOs = null;
    private int fyJ = 2000;
    private com.baidu.tbadk.p.c gjm = null;
    private boolean fwC = false;
    private int fvX = 0;
    private int dms = 0;
    private boolean mIsBackground = false;
    private boolean gij = true;
    private boolean gjn = false;
    private boolean gjp = false;
    private boolean gjr = true;
    private FloatInfo gjs = null;
    private a.C0038a fuD = new a.C0038a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int gjJ = -1;
        private int gdg = 0;
        private boolean gjK = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.gjm == null) {
                e.this.gjm = new com.baidu.tbadk.p.c();
                e.this.gjm.kR(1005);
                e.this.gjm.pageType = 1;
            }
            if (e.this.cDr != null && !e.this.mIsBackground) {
                e.this.cDr.i(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.fyY);
                e.this.gjm.avm();
                t.aZP().gS(true);
                com.baidu.tieba.a.d.aCH().bJ("page_recommend", "show_");
                com.baidu.tieba.q.c.coG().b(e.this.gjt, false);
                this.gjK = false;
                if (e.this.fwJ != null && e.this.gij) {
                    e.this.fwJ.a(e.this.fvX, e.this.dms, e.this.fwC, 1);
                    return;
                }
                return;
            }
            e.this.gjm.avl();
            if (i == 1) {
                if (e.this.gjk != null) {
                    e.this.gjk.hideTip();
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
            if (this.gdg > i) {
                this.gjK = true;
            }
            if (e.this.cDr != null && !e.this.mIsBackground) {
                e.this.cDr.onScroll(this.gdg, i);
            }
            this.gdg = i;
            int i3 = (i + i2) - 1;
            if (!this.gjK && this.gjJ != i3) {
                this.gjJ = i3;
                e.this.uf(this.gjJ);
            }
            if (this.gjK && this.gjJ != i) {
                this.gjJ = i;
                e.this.uf(this.gjJ);
            }
            e.this.gjA = i;
            e.this.fvX = i;
            e.this.dms = (i + i2) - 1;
            z bwA = e.this.bwA();
            if (bwA != null && bwA.qP() != null) {
                bwA.qP().b(e.this.fuD);
            }
        }
    };
    private View.OnTouchListener cmw = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.coV != null) {
                e.this.coV.onTouch(view, motionEvent);
            }
            if (e.this.fSh != null) {
                e.this.fSh.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0305a eaj = new a.InterfaceC0305a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            e.this.fwC = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            e.this.fwC = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void ba(int i, int i2) {
        }
    };
    private View.OnClickListener gjw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gjk != null) {
                e.this.gjk.hideTip();
            }
        }
    };
    private final CustomMessageListener gjx = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.fyY != null) {
                e.this.fwJ.bwz();
                e.this.gij = false;
                e.this.gcS.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener fLx = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && e.this.gjh != null && v.Z(e.this.gjh.thread_list) != 0 && (bhVar = (bh) customResponsedMessage.getData()) != null && bhVar.aek() != null && bhVar.getId() != null && v.Z(e.this.gjh.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.gjh.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.gjh.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bhVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bhVar.aek().getNum());
                            builder.zan = builder2.build(true);
                            e.this.gjh.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener gjy = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
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
                        if ((originData.get(i2) instanceof bh) && (bhVar = (bh) originData.get(i2)) != null && bhVar.aeR() != null && ids.contains(Long.valueOf(bhVar.aeR().live_id))) {
                            e.this.mDataList.remove(bhVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.giA != null) {
                        e.this.giA.aF(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.gjh != null && !v.aa(e.this.gjh.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.gjh.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.gjh.thread_list.get(i);
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
                            e.this.gjh.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String gjz = "lastReadReadPositionKey";
    private int gjA = 0;
    private d gjC = new d() { // from class: com.baidu.tieba.homepage.personalize.e.8
        @Override // com.baidu.tieba.homepage.personalize.d
        public void tN(final int i) {
            if (e.this.gjB == null) {
                e.this.gjB = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fyY.getHandler() != null) {
                            e.this.fyY.requestFocusFromTouch();
                            if (i <= e.this.fyY.getCount() - 1) {
                                e.this.fyY.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.fyY.removeCallbacks(e.this.gjB);
            e.this.fyY.post(e.this.gjB);
        }
    };
    private CustomMessageListener gjD = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gjq != null) {
                e.this.mDataList.remove(e.this.gjq);
                e.this.giA.aF(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener fND = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.fwJ != null && e.this.gij) {
                e.this.fwJ.c(e.this.fvX, e.this.dms, e.this.fwC, true);
            }
        }
    };
    private CustomMessageListener fNE = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fLM = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gjh != null && v.Z(e.this.gjh.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.yi(str);
                if (e.this.giA != null) {
                    e.this.giA.aF(new ArrayList(e.this.mDataList));
                }
                if (e.this.fwJ != null && e.this.gij) {
                    e.this.fwJ.c(e.this.fvX, e.this.dms, e.this.fwC, true);
                }
            }
        }
    };
    private CustomMessageListener fvQ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bwA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bwA = e.this.bwA()) != null && bwA.qP() != null) {
                    bwA.qP().b(new a.C0038a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a gjE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TOPIC_BLESS, 309085) { // from class: com.baidu.tieba.homepage.personalize.e.17
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).gnT) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fvR = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] agr;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.giA.getDataList();
            if (!v.aa(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bJl != 0 && kVar.threadData != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                agr = kVar.threadData.ags();
                            } else {
                                agr = kVar.threadData.agr();
                            }
                            kVar.bJl = agr[0];
                            kVar.bJm = agr[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.18.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.giA.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.gij) {
                        e.this.fwJ.c(e.this.fvX, e.this.dms, e.this.fwC, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void M(int i, int i2, int i3);

        void bwQ();

        void onError(int i, String str);

        void onSuccess();

        void w(int i, int i2, int i3, int i4);
    }

    public void lq(boolean z) {
        this.gjr = z;
        if (this.gjk != null && !z) {
            this.gjk.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gio = scrollFragmentTabHost;
        if (this.gio != null) {
            this.gio.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void tY(int i) {
                    if (e.this.gio.tX(i) != 1 && e.this.gjk != null) {
                        e.this.gjk.hideTip();
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
        if (this.gio != null) {
            this.gio.kc(z);
        }
        if (this.fwJ != null) {
            this.fwJ.nh(!z);
            z bwA = bwA();
            if (bwA != null && bwA.qP() != null) {
                z2 = bwA.qP().b(new a.C0038a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fwJ.bwz();
                } else if (this.gij) {
                    this.fwJ.c(this.fvX, this.dms, this.fwC, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, com.baidu.tieba.homepage.personalize.a.w wVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gjv = 0;
        this.mPageContext = tbPageContext;
        this.gjv = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_personalized_refresh_type", 0);
        this.gcS = bigdaySwipeRefreshLayout;
        this.fyY = bdTypeRecyclerView;
        this.fyY.setOnTouchListener(this.cmw);
        this.fSh = new com.baidu.tieba.f.a();
        this.fSh.a(this.eaj);
        this.giA = wVar;
        this.gjl = new com.baidu.tieba.homepage.personalize.model.a();
        this.gje = com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.gjk = new aq();
        bxa();
        this.fwJ = new m(this.mPageContext, this.fyY);
        this.fwJ.yY(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjf = new b(this.mDataList, this.giA);
        this.gju = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.gju.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        bwR();
        this.fvR.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fvR);
    }

    private void bwR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.23
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                z bwA = e.this.bwA();
                return (bwA == null || bwA.qP() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bwA.qP().b(new a.C0038a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bwS() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean(bwU(), true);
    }

    private void bwT() {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean(bwU(), false);
    }

    private String bwU() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (xVar != null) {
            this.cDr = xVar.awy();
            this.coV = xVar.awz();
        }
    }

    public void showFloatingView() {
        if (this.cDr != null) {
            this.cDr.fM(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bvC().n(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.gjp = true;
        if (this.mDataList.size() == 0 && !bwS()) {
            if (!this.gdb) {
                acq();
                return;
            }
            return;
        }
        acp();
    }

    public void bI(int i, int i2) {
        bh bhVar;
        if (!v.aa(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bh.bJD.getId() && (bhVar = (bh) this.mDataList.get(i)) != null && bhVar.aeR() != null) {
                    arrayList.add(Long.valueOf(bhVar.aeR().live_id));
                    arrayList2.add(bhVar);
                }
                i++;
            }
            if (!v.aa(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bwV() {
        if (this.fwJ != null && !this.mIsBackground && this.gij) {
            this.fwJ.c(this.fvX, this.dms, this.fwC, true);
        }
        if (this.gjn) {
            if (this.gcS != null && !this.gcS.akS()) {
                if (this.gbf) {
                    com.baidu.tieba.q.c.coG().b(this.gjt, false);
                    if (ls(false)) {
                        bJ(3, this.gjj);
                    } else if (this.gjo > 0) {
                        bJ(2, this.gjj);
                    }
                } else if (!this.gbf && this.gjj == 0) {
                    bJ(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.gjn = false;
            this.gbf = false;
            this.gjo = 0;
            if (this.gjp) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.gjp = false;
        }
    }

    public void aIS() {
        if (pP()) {
            com.baidu.tieba.homepage.framework.a.bvC().n(0L, 1);
        } else if (this.gjg != null) {
            bwX();
            this.mPn++;
            setIsLoading(true);
            this.gjg.w(this.mPn, (this.gjh == null || this.gjh.thread_list == null) ? 0 : this.gjh.thread_list.size(), lr(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.gjh == null || this.gjh.thread_list == null) ? 0 : this.gjh.thread_list.size();
        if (!z && i == 0 && dataRes != null && v.aa(dataRes.thread_list)) {
            if (this.gjg != null) {
                this.gjg.bwQ();
            }
            setIsLoading(false);
            if (this.gcS != null) {
                this.gcS.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.gjn = false;
            if (this.mDataList.size() > 0) {
                if (this.gjg != null) {
                    this.gjg.onError(1, str);
                }
            } else if (this.gjg != null) {
                this.gjg.onError(2, str);
            }
        } else {
            bwT();
            if (this.gjg != null) {
                this.gjg.onSuccess();
            }
            this.gjn = true;
            this.gbf = z;
            this.gjo = size;
            bgi();
        }
        setIsLoading(false);
        if (this.gcS != null) {
            h.e bwW = bwW();
            if (this.gcS.akS() && bwW != null) {
                this.gcS.c(bwW);
            } else {
                this.gcS.setRefreshing(false);
            }
        }
    }

    private h.e bwW() {
        int i;
        String alZ;
        if (this.gjn && this.gcS != null && this.gcS.akS()) {
            int i2 = this.gjj;
            if (this.gbf) {
                com.baidu.tieba.q.c.coG().b(this.gjt, false);
                if (ls(false)) {
                    i = 3;
                } else {
                    i = this.gjo > 0 ? 2 : 0;
                }
            } else if (this.gbf || this.gjj != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.gio != null) {
                this.gjk.bod();
            }
            if (this.gio != null && this.gio.getCurrentTabType() != 1) {
                this.gjk.hideTip();
                return null;
            } else if (!this.gjr) {
                this.gjk.hideTip();
                return null;
            } else {
                this.gji = i;
                if (i == 2) {
                    if (i2 > 0) {
                        alZ = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        alZ = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                    }
                } else if (i == 3) {
                    alZ = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
                } else {
                    alZ = i == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().alZ() : null;
                }
                if (TextUtils.isEmpty(alZ) || !j.kc()) {
                    return null;
                }
                if (i == 4) {
                    this.fyJ = 1000;
                } else {
                    this.fyJ = 0;
                }
                return new h.e(alZ, this.fyJ);
            }
        }
        return null;
    }

    public void lg(boolean z) {
        if (z) {
            this.giA.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fwJ != null) {
            this.fwJ.destroy();
        }
        if (this.gjk != null) {
            this.gjk.onDestroy();
        }
        if (this.gjf != null) {
            this.gjf.onDestroy();
        }
        if (this.fyY != null) {
            this.fyY.removeCallbacks(this.gjB);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.fvR);
    }

    public void onPause() {
        c.d(this.fyY);
        ug(this.gjA);
        if (this.gjm != null) {
            this.gjm.avn();
        }
    }

    private void acp() {
        if (this.gjg != null) {
            this.gjg.M((this.gjh == null || this.gjh.thread_list == null || bwZ()) ? 0 : this.gjh.thread_list.size(), lr(true), 0);
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.bEJ) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.bEJ) {
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
        this.gdb = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bwZ()) {
                if (this.gjg != null) {
                    this.gjg.onSuccess();
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
        AdvertAppInfo bah;
        AdvertAppInfo bah2;
        if (!v.aa(list)) {
            Set<com.baidu.adp.widget.ListView.m> DT = com.baidu.tieba.recapp.report.a.DT("NEWINDEX");
            HashSet hashSet = DT == null ? new HashSet() : DT;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (bah2 = ((com.baidu.tieba.card.data.d) mVar).bah()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == bah2.hashCode()) {
                            bah2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (bah = ((com.baidu.tieba.card.data.d) mVar).bah()) != null && bah.advertAppContext == null) {
                        bah.advertAppContext = new com.baidu.tbadk.core.data.c();
                        bah.advertAppContext.page = "NEWINDEX";
                        bah.advertAppContext.pn = this.mPn;
                        bah.advertAppContext.extensionInfo = bah.extensionInfo;
                        bah.advertAppContext.Rn = false;
                        hashSet2.add(bah);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.e("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.coG().b(this.gjt, com.baidu.tieba.q.a.b("a002", "common_fill", true, hashSet2.size()));
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
        if (this.gjv == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bwZ())) {
                bwY();
                this.gjh = null;
            }
        } else if (z2 && bwZ()) {
            this.gjh = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gjl.a(z, this.gjh, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.cRz;
            this.gjj = a2.glA;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.gjp) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.gjh == null) {
            this.gjh = builder;
            this.gjf.cE(this.gjh.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.gjq = new g();
                    this.gjq.a(dataRes.live_answer);
                    this.gjh.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.gjq = null;
                    this.gjh.live_answer = null;
                }
                this.gjs = dataRes.float_info;
                this.gjh.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("key_maintab_banner_close_time", 0L);
            if (this.gjq != null && !com.baidu.tbadk.core.util.aq.bc(j)) {
                this.mDataList.add(0, this.gjq);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.giA.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.giA.aF(linkedList);
            z4 = true;
            if (this.fwJ != null && this.gij) {
                this.fwJ.c(this.fvX, this.dms, this.fwC, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bvC().l(System.currentTimeMillis() - currentTimeMillis, 1);
        long tM = com.baidu.tieba.homepage.framework.a.bvC().tM(1);
        if (tM > 0) {
            com.baidu.tieba.homepage.framework.a.bvC().m(System.currentTimeMillis() - tM, 1);
            com.baidu.tieba.homepage.framework.a.bvC().n(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        aw awVar = new aw();
        awVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, awVar));
        return z4;
    }

    private void bwX() {
        if (v.Z(this.mDataList) >= this.gjl.bxs() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.gjl.a(true, this.gjh, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.cRz : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.giA.aF(new LinkedList(this.mDataList));
            }
        }
    }

    private void acq() {
        this.gdb = true;
        aa.a(new com.baidu.tbadk.util.z<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bxe */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bD = com.baidu.tbadk.core.d.a.agH().bD("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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

    private void bgi() {
        if (this.gjh != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gjh.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bwY() {
        if (this.gjh != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.gjh.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.z
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.gjf.cF(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.d.a.agH().bD("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
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
    public void yi(String str) {
        if (!TextUtils.isEmpty(str) && this.gjh != null && this.gjh.banner_list != null && this.gjh.banner_list.app != null && this.gjh.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.gjh.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.gjh.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.gjh.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.gjh.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.gjf.cF(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.d.a.agH().bD("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bwZ() {
        return ls(true);
    }

    private boolean ls(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.gje;
    }

    public void a(a aVar) {
        this.gjg = aVar;
    }

    private boolean pP() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bwN() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.alS() && !StringUtils.isNull(activityPrizeData.alZ())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("activity_prize_feed_text_time", "");
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
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bJ(int i, int i2) {
        if (this.gio != null) {
            this.gjk.bod();
        }
        if (this.gio != null && this.gio.getCurrentTabType() != 1) {
            this.gjk.hideTip();
        } else if (!this.gjr) {
            this.gjk.hideTip();
        } else {
            this.gji = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().alZ();
            }
            if (!TextUtils.isEmpty(str) && j.kc()) {
                if (i == 4) {
                    this.fyJ = 3000;
                } else {
                    this.fyJ = 2000;
                }
                this.gju.caY = str;
                this.gju.fyB = this.fyJ;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                FrameLayout frameLayout = this.gio.getFrameLayout();
                frameLayout.removeView(this.gju);
                frameLayout.addView(this.gju, layoutParams);
                this.gju.bob();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Long l) {
        if (this.gjh != null && this.gjh.thread_list != null) {
            List<ThreadInfo> list = this.gjh.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bgi();
                    a(false, true, false, this.gjh.build(true));
                    return;
                }
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gjt = bdUniqueId;
            if (this.fLx != null) {
                this.fLx.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fLx);
            }
            if (this.gjx != null) {
                this.gjx.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.gjx);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.gjy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gjy);
            this.fND.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fND);
            this.fNE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fNE);
            this.fLM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fLM);
            if (this.fwJ != null) {
                this.fwJ.setUniqueId(bdUniqueId);
            }
            this.gjf.j(bdUniqueId);
            this.gjD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gjD);
            this.fvQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fvQ);
            this.gjE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gjE);
        }
    }

    public void bxa() {
        this.fuk = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.fuk.cpm();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.fuk != null) {
            if (i == 0) {
                this.fuk.cpm();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.jfE;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.fuk.cz(i3, i7 + 1);
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

    public void uf(int i) {
        if ((this.fuk != null ? this.fuk.Bd(i) : -1) >= 0 && this.fyY != null && this.fyY.getData() != null && this.fyY.getData().size() > i) {
            this.fuk.Be(i);
        }
    }

    public m bmT() {
        return this.fwJ;
    }

    public void lm(boolean z) {
        this.gij = z;
    }

    public void ug(final int i) {
        aa.a(new com.baidu.tbadk.util.z<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.d.a.agH().bE(e.this.gjz, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(e.this.gjz, Integer.toString(i), 43200000L);
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
            /* renamed from: bxd */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.d.a.agH().bE(e.this.gjz, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    return bE.get(e.this.gjz);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.k<String>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: yj */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.tN(com.baidu.adp.lib.g.b.f(str, 0));
                }
            }
        });
    }

    public void bwO() {
        c.e(this.fyY);
    }

    public void bxb() {
        a(this.gjC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gjh != null && v.Z(this.gjh.thread_list) != 0 && v.Z(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.fyY != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.fyY.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.fyY.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.acy() != null && jVar.acy().aeR() != null && optString2.equals(String.valueOf(jVar.acy().aeR().live_id))) {
                                str = jVar.acy().getTid();
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
                    if (cVar.acy() != null && cVar.acy().getTid() != null) {
                        if (cVar.acy().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                            z2 = z;
                        } else if (z2) {
                            com.baidu.tieba.homepage.personalize.model.b.cH(this.mDataList);
                            break;
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (this.gjh != null && this.gjh.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.gjh.thread_list.size()) {
                        ThreadInfo threadInfo = this.gjh.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                            i2++;
                        } else {
                            this.gjh.thread_list.remove(i2);
                            bgi();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.gjh.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.fyY != null) {
                    List<Integer> b = b(optString, this.fyY);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.fyY.t(intValue, intValue2);
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
                    if (cVar.acy() != null && cVar.acy().getTid().equals(str)) {
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).bah();
                } else {
                    if (next instanceof ad) {
                        ad adVar = (ad) next;
                        if (adVar.adb() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.adb()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.bEU)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gju != null) {
            this.gju.onChangeSkinType(i);
        }
    }

    public FloatInfo bxc() {
        return this.gjs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z bwA() {
        if (this.fwJ == null || this.fwJ.cev() == null || !(this.fwJ.cev().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fwJ.cev().getTag();
    }
}
