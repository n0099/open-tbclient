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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.y;
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
import com.baidu.tieba.homepage.personalize.a.w;
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
    private v cEi;
    private View.OnTouchListener cpQ;
    private final BdTypeRecyclerView fAL;
    private com.baidu.tieba.f.a fTY;
    private com.baidu.tieba.tbadkCore.data.f fvX;
    private m fyw;
    private boolean gcW;
    private final BigdaySwipeRefreshLayout geK;
    private final long gkW;
    private final b gkX;
    private DataRes.Builder gkZ;
    private ScrollFragmentTabHost gkg;
    private final w gks;
    private aq glc;
    private final com.baidu.tieba.homepage.personalize.model.a gld;
    private int glg;
    private g gli;
    private BdUniqueId gll;
    private SmartBubbleAnimatedView glm;
    private int gln;
    private Runnable glt;
    private final TbPageContext<?> mPageContext;
    private a gkY = null;
    private final List<com.baidu.adp.widget.ListView.m> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean geT = false;
    private int gla = 2;
    private int glb = 0;
    private TextView bOT = null;
    private int fAw = 2000;
    private com.baidu.tbadk.p.c gle = null;
    private boolean fyp = false;
    private int fxK = 0;
    private int dof = 0;
    private boolean mIsBackground = false;
    private boolean gkb = true;
    private boolean glf = false;
    private boolean glh = false;
    private boolean glj = true;
    private FloatInfo glk = null;
    private a.C0038a fwq = new a.C0038a(2);
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.12
        private int glB = -1;
        private int geY = 0;
        private boolean glC = false;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (e.this.gle == null) {
                e.this.gle = new com.baidu.tbadk.p.c();
                e.this.gle.kU(1005);
                e.this.gle.pageType = 1;
            }
            if (e.this.cEi != null && !e.this.mIsBackground) {
                e.this.cEi.i(recyclerView, i);
            }
            if (i == 0) {
                c.d(e.this.fAL);
                e.this.gle.avy();
                t.bat().gV(true);
                com.baidu.tieba.a.d.aCV().bJ("page_recommend", "show_");
                com.baidu.tieba.q.c.cpt().b(e.this.gll, false);
                this.glC = false;
                if (e.this.fyw != null && e.this.gkb) {
                    e.this.fyw.a(e.this.fxK, e.this.dof, e.this.fyp, 1);
                    return;
                }
                return;
            }
            e.this.gle.avx();
            if (i == 1) {
                if (e.this.glc != null) {
                    e.this.glc.hideTip();
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
            if (this.geY > i) {
                this.glC = true;
            }
            if (e.this.cEi != null && !e.this.mIsBackground) {
                e.this.cEi.onScroll(this.geY, i);
            }
            this.geY = i;
            int i3 = (i + i2) - 1;
            if (!this.glC && this.glB != i3) {
                this.glB = i3;
                e.this.uj(this.glB);
            }
            if (this.glC && this.glB != i) {
                this.glB = i;
                e.this.uj(this.glB);
            }
            e.this.gls = i;
            e.this.fxK = i;
            e.this.dof = (i + i2) - 1;
            z bxo = e.this.bxo();
            if (bxo != null && bxo.qQ() != null) {
                bxo.qQ().b(e.this.fwq);
            }
        }
    };
    private View.OnTouchListener cnr = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cpQ != null) {
                e.this.cpQ.onTouch(view, motionEvent);
            }
            if (e.this.fTY != null) {
                e.this.fTY.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0316a ebT = new a.InterfaceC0316a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aY(int i, int i2) {
            e.this.fyp = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aZ(int i, int i2) {
            e.this.fyp = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void ba(int i, int i2) {
        }
    };
    private View.OnClickListener glo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.glc != null) {
                e.this.glc.hideTip();
            }
        }
    };
    private final CustomMessageListener glp = new CustomMessageListener(2001399) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.fAL != null) {
                e.this.fyw.bxn();
                e.this.gkb = false;
                e.this.geK.setRefreshing(true);
            }
        }
    };
    private CustomMessageListener fNm = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.homepage.personalize.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && e.this.gkZ != null && com.baidu.tbadk.core.util.v.Z(e.this.gkZ.thread_list) != 0 && (bhVar = (bh) customResponsedMessage.getData()) != null && bhVar.aeo() != null && bhVar.getId() != null && com.baidu.tbadk.core.util.v.Z(e.this.gkZ.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.gkZ.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.gkZ.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.e(bhVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bhVar.aeo().getNum());
                            builder.zan = builder2.build(true);
                            e.this.gkZ.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener glq = new CustomMessageListener(2921026) { // from class: com.baidu.tieba.homepage.personalize.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.v.aa(e.this.mDataList) && !com.baidu.tbadk.core.util.v.aa(ids) && !com.baidu.tbadk.core.util.v.aa(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bh) && (bhVar = (bh) originData.get(i2)) != null && bhVar.aeV() != null && ids.contains(Long.valueOf(bhVar.aeV().live_id))) {
                            e.this.mDataList.remove(bhVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.gks != null) {
                        e.this.gks.aF(new ArrayList(e.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.gkZ != null && !com.baidu.tbadk.core.util.v.aa(e.this.gkZ.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.gkZ.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.gkZ.thread_list.get(i);
                        if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.g.b.e(updateAttentionMessage.getData().toUid, -1L)) {
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
                            e.this.gkZ.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String glr = "lastReadReadPositionKey";
    private int gls = 0;
    private d glu = new d() { // from class: com.baidu.tieba.homepage.personalize.e.8
        @Override // com.baidu.tieba.homepage.personalize.d
        public void tR(final int i) {
            if (e.this.glt == null) {
                e.this.glt = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fAL.getHandler() != null) {
                            e.this.fAL.requestFocusFromTouch();
                            if (i <= e.this.fAL.getCount() - 1) {
                                e.this.fAL.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.fAL.removeCallbacks(e.this.glt);
            e.this.fAL.post(e.this.glt);
        }
    };
    private CustomMessageListener glv = new CustomMessageListener(2016569) { // from class: com.baidu.tieba.homepage.personalize.e.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gli != null) {
                e.this.mDataList.remove(e.this.gli);
                e.this.gks.aF(new ArrayList(e.this.mDataList));
                com.baidu.tbadk.core.sharedPref.b.ahU().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    };
    private CustomMessageListener fPt = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.homepage.personalize.e.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
            if (e.this.fyw != null && e.this.gkb) {
                e.this.fyw.c(e.this.fxK, e.this.dof, e.this.fyp, true);
            }
        }
    };
    private CustomMessageListener fPu = new CustomMessageListener(2016553) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.h(customResponsedMessage);
        }
    };
    private CustomMessageListener fNB = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.gkZ != null && com.baidu.tbadk.core.util.v.Z(e.this.gkZ.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.yH(str);
                if (e.this.gks != null) {
                    e.this.gks.aF(new ArrayList(e.this.mDataList));
                }
                if (e.this.fyw != null && e.this.gkb) {
                    e.this.fyw.c(e.this.fxK, e.this.dof, e.this.fyp, true);
                }
            }
        }
    };
    private CustomMessageListener fxD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.personalize.e.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bxo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bxo = e.this.bxo()) != null && bxo.qQ() != null) {
                    bxo.qQ().b(new a.C0038a(3));
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a glw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TOPIC_BLESS, 309085) { // from class: com.baidu.tieba.homepage.personalize.e.17
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
                        if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).gpK) != null && longValue == bVar.pkId) {
                            bVar.userPkId = j2;
                            return;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fxE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] agv;
            List<com.baidu.adp.widget.ListView.m> dataList = e.this.gks.getDataList();
            if (!com.baidu.tbadk.core.util.v.aa(dataList)) {
                for (com.baidu.adp.widget.ListView.m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bJJ != 0 && kVar.threadData != null) {
                            if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 4) != 0) {
                                agv = kVar.threadData.agw();
                            } else {
                                agv = kVar.threadData.agv();
                            }
                            kVar.bJJ = agv[0];
                            kVar.bJK = agv[1];
                        }
                    }
                }
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.18.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.gks.notifyDataSetChanged();
                    if (!e.this.mIsBackground && e.this.gkb) {
                        e.this.fyw.c(e.this.fxK, e.this.dof, e.this.fyp, true);
                    }
                }
            }, 500L);
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void N(int i, int i2, int i3);

        void bxE();

        void onError(int i, String str);

        void onSuccess();

        void z(int i, int i2, int i3, int i4);
    }

    public void lt(boolean z) {
        this.glj = z;
        if (this.glc != null && !z) {
            this.glc.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gkg = scrollFragmentTabHost;
        if (this.gkg != null) {
            this.gkg.setOnTabSelectedListener(new ScrollFragmentTabHost.b() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.b
                public void uc(int i) {
                    if (e.this.gkg.ub(i) != 1 && e.this.glc != null) {
                        e.this.glc.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void kf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gkg != null) {
            this.gkg.kf(z);
        }
        if (this.fyw != null) {
            this.fyw.nk(!z);
            z bxo = bxo();
            if (bxo != null && bxo.qQ() != null) {
                z2 = bxo.qQ().b(new a.C0038a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fyw.bxn();
                } else if (this.gkb) {
                    this.fyw.c(this.fxK, this.dof, this.fyp, true);
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, w wVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        this.gln = 0;
        this.mPageContext = tbPageContext;
        this.gln = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_personalized_refresh_type", 0);
        this.geK = bigdaySwipeRefreshLayout;
        this.fAL = bdTypeRecyclerView;
        this.fAL.setOnTouchListener(this.cnr);
        this.fTY = new com.baidu.tieba.f.a();
        this.fTY.a(this.ebT);
        this.gks = wVar;
        this.gld = new com.baidu.tieba.homepage.personalize.model.a();
        this.gkW = com.baidu.tbadk.core.sharedPref.b.ahU().getLong("recommend_frs_cache_time", 3600L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.mOnScrollListener);
        this.glc = new aq();
        bxO();
        this.fyw = new m(this.mPageContext, this.fAL);
        this.fyw.zb(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gkX = new b(this.mDataList, this.gks);
        this.glm = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.glm.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        bxF();
        this.fxE.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fxE);
    }

    private void bxF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.personalize.e.23
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                z bxo = e.this.bxo();
                return (bxo == null || bxo.qQ() == null) ? new CustomResponsedMessage<>(2016323, false) : new CustomResponsedMessage<>(2016323, Boolean.valueOf(bxo.qQ().b(new a.C0038a(6))));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private boolean bxG() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean(bxI(), true);
    }

    private void bxH() {
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean(bxI(), false);
    }

    private String bxI() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.w wVar) {
        if (wVar != null) {
            this.cEi = wVar.awK();
            this.cpQ = wVar.awL();
        }
    }

    public void showFloatingView() {
        if (this.cEi != null) {
            this.cEi.fP(true);
        }
    }

    public void update() {
        com.baidu.tieba.homepage.framework.a.bwq().n(System.currentTimeMillis(), 1);
        this.mPn = 1;
        this.glh = true;
        if (this.mDataList.size() == 0 && !bxG()) {
            if (!this.geT) {
                acu();
                return;
            }
            return;
        }
        act();
    }

    public void bI(int i, int i2) {
        bh bhVar;
        if (!com.baidu.tbadk.core.util.v.aa(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bh.bKb.getId() && (bhVar = (bh) this.mDataList.get(i)) != null && bhVar.aeV() != null) {
                    arrayList.add(Long.valueOf(bhVar.aeV().live_id));
                    arrayList2.add(bhVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.v.aa(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void bxJ() {
        if (this.fyw != null && !this.mIsBackground && this.gkb) {
            this.fyw.c(this.fxK, this.dof, this.fyp, true);
        }
        if (this.glf) {
            if (this.geK != null && !this.geK.ale()) {
                if (this.gcW) {
                    com.baidu.tieba.q.c.cpt().b(this.gll, false);
                    if (lv(false)) {
                        bJ(3, this.glb);
                    } else if (this.glg > 0) {
                        bJ(2, this.glb);
                    }
                } else if (!this.gcW && this.glb == 0) {
                    bJ(2, 0);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.ahU().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.glf = false;
            this.gcW = false;
            this.glg = 0;
            if (this.glh) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.glh = false;
        }
    }

    public void aJw() {
        if (pQ()) {
            com.baidu.tieba.homepage.framework.a.bwq().n(0L, 1);
        } else if (this.gkY != null) {
            bxL();
            this.mPn++;
            setIsLoading(true);
            this.gkY.z(this.mPn, (this.gkZ == null || this.gkZ.thread_list == null) ? 0 : this.gkZ.thread_list.size(), lu(false), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        int size = (this.gkZ == null || this.gkZ.thread_list == null) ? 0 : this.gkZ.thread_list.size();
        if (!z && i == 0 && dataRes != null && com.baidu.tbadk.core.util.v.aa(dataRes.thread_list)) {
            if (this.gkY != null) {
                this.gkY.bxE();
            }
            setIsLoading(false);
            if (this.geK != null) {
                this.geK.setRefreshing(false);
                return;
            }
            return;
        }
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.glf = false;
            if (this.mDataList.size() > 0) {
                if (this.gkY != null) {
                    this.gkY.onError(1, str);
                }
            } else if (this.gkY != null) {
                this.gkY.onError(2, str);
            }
        } else {
            bxH();
            if (this.gkY != null) {
                this.gkY.onSuccess();
            }
            this.glf = true;
            this.gcW = z;
            this.glg = size;
            bgO();
        }
        setIsLoading(false);
        if (this.geK != null) {
            h.e bxK = bxK();
            if (this.geK.ale() && bxK != null) {
                this.geK.c(bxK);
            } else {
                this.geK.setRefreshing(false);
            }
        }
    }

    private h.e bxK() {
        int i;
        String aml;
        if (this.glf && this.geK != null && this.geK.ale()) {
            int i2 = this.glb;
            if (this.gcW) {
                com.baidu.tieba.q.c.cpt().b(this.gll, false);
                if (lv(false)) {
                    i = 3;
                } else {
                    i = this.glg > 0 ? 2 : 0;
                }
            } else if (this.gcW || this.glb != 0) {
                return null;
            } else {
                i2 = 0;
                i = 2;
            }
            if (this.gkg != null) {
                this.glc.boO();
            }
            if (this.gkg != null && this.gkg.getCurrentTabType() != 1) {
                this.glc.hideTip();
                return null;
            } else if (!this.glj) {
                this.glc.hideTip();
                return null;
            } else {
                this.gla = i;
                if (i == 2) {
                    if (i2 > 0) {
                        aml = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        aml = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                    }
                } else if (i == 3) {
                    aml = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
                } else {
                    aml = i == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().aml() : null;
                }
                if (TextUtils.isEmpty(aml) || !j.kc()) {
                    return null;
                }
                if (i == 4) {
                    this.fAw = 1000;
                } else {
                    this.fAw = 0;
                }
                return new h.e(aml, this.fAw);
            }
        }
        return null;
    }

    public void lj(boolean z) {
        if (z) {
            this.gks.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fyw != null) {
            this.fyw.destroy();
        }
        if (this.glc != null) {
            this.glc.onDestroy();
        }
        if (this.gkX != null) {
            this.gkX.onDestroy();
        }
        if (this.fAL != null) {
            this.fAL.removeCallbacks(this.glt);
        }
        MessageManager.getInstance().unRegisterTask(2016323);
        MessageManager.getInstance().unRegisterListener(this.fxE);
    }

    public void onPause() {
        c.d(this.fAL);
        uk(this.gls);
        if (this.gle != null) {
            this.gle.avz();
        }
    }

    private void act() {
        if (this.gkY != null) {
            this.gkY.N((this.gkZ == null || this.gkZ.thread_list == null || bxN()) ? 0 : this.gkZ.thread_list.size(), lu(true), 0);
        }
    }

    public int lu(boolean z) {
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
                if (!(mVar instanceof com.baidu.tieba.homepage.personalize.data.a) || mVar.getType() == AdvertAppInfo.bFh) {
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
                if ((mVar2 instanceof com.baidu.tieba.homepage.personalize.data.a) && mVar2.getType() != AdvertAppInfo.bFh) {
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
        this.geT = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !bxN()) {
                if (this.gkY != null) {
                    this.gkY.onSuccess();
                    return;
                }
                return;
            }
            act();
            return;
        }
        act();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    private void k(List<com.baidu.adp.widget.ListView.m> list, int i) {
        AdvertAppInfo baL;
        AdvertAppInfo baL2;
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            Set<com.baidu.adp.widget.ListView.m> Et = com.baidu.tieba.recapp.report.a.Et("NEWINDEX");
            HashSet hashSet = Et == null ? new HashSet() : Et;
            HashSet hashSet2 = new HashSet();
            for (com.baidu.adp.widget.ListView.m mVar : list) {
                if (mVar != null) {
                    for (com.baidu.adp.widget.ListView.m mVar2 : hashSet) {
                        if ((mVar instanceof com.baidu.tieba.card.data.d) && (baL2 = ((com.baidu.tieba.card.data.d) mVar).baL()) != null && mVar2 != null && (mVar2 instanceof AdvertAppInfo) && mVar2.hashCode() == baL2.hashCode()) {
                            baL2.advertAppContext = ((AdvertAppInfo) mVar2).advertAppContext;
                        }
                    }
                    if (mVar != null && (mVar instanceof com.baidu.tieba.card.data.d) && (baL = ((com.baidu.tieba.card.data.d) mVar).baL()) != null && baL.advertAppContext == null) {
                        baL.advertAppContext = new com.baidu.tbadk.core.data.c();
                        baL.advertAppContext.page = "NEWINDEX";
                        baL.advertAppContext.pn = this.mPn;
                        baL.advertAppContext.extensionInfo = baL.extensionInfo;
                        baL.advertAppContext.Rm = false;
                        hashSet2.add(baL);
                    }
                }
            }
            hashSet.addAll(hashSet2);
            com.baidu.tieba.recapp.report.a.e("NEWINDEX", hashSet);
            if (hashSet2.size() > 0) {
                com.baidu.tieba.q.c.cpt().b(this.gll, com.baidu.tieba.q.a.b("a002", "common_fill", true, hashSet2.size()));
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
        if (this.gln == 1) {
            if (z2 && (dataRes.thread_list.size() >= 6 || bxN())) {
                bxM();
                this.gkZ = null;
            }
        } else if (z2 && bxN()) {
            this.gkZ = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.gld.a(z, this.gkZ, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.m> list2 = a2.cSs;
            this.glb = a2.gns;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            k(list, size);
            a(z2 ? 0 : 1, list, size);
            if (this.glh) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
        }
        if (this.gkZ == null) {
            this.gkZ = builder;
            this.gkX.cE(this.gkZ.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.gli = new g();
                    this.gli.a(dataRes.live_answer);
                    this.gkZ.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.gli = null;
                    this.gkZ.live_answer = null;
                }
                this.glk = dataRes.float_info;
                this.gkZ.float_info = dataRes.float_info;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_maintab_banner_close_time", 0L);
            if (this.gli != null && !com.baidu.tbadk.core.util.aq.bc(j)) {
                this.mDataList.add(0, this.gli);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.gks.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.gks.aF(linkedList);
            z4 = true;
            if (this.fyw != null && this.gkb) {
                this.fyw.c(this.fxK, this.dof, this.fyp, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.bwq().l(System.currentTimeMillis() - currentTimeMillis, 1);
        long tQ = com.baidu.tieba.homepage.framework.a.bwq().tQ(1);
        if (tQ > 0) {
            com.baidu.tieba.homepage.framework.a.bwq().m(System.currentTimeMillis() - tQ, 1);
            com.baidu.tieba.homepage.framework.a.bwq().n(0L, 1);
        }
        if (dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.ueg.d.d(dataRes.anti.block_pop_info);
        }
        aw awVar = new aw();
        awVar.a(dataRes.recom_post_topic);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, awVar));
        return z4;
    }

    private void bxL() {
        if (com.baidu.tbadk.core.util.v.Z(this.mDataList) >= this.gld.byg() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.gld.a(true, this.gkZ, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.m> list = a2 != null ? a2.cSs : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.gks.aF(new LinkedList(this.mDataList));
            }
        }
    }

    private void acu() {
        this.geT = true;
        com.baidu.tbadk.util.z.a(new y<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: bxS */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bD = com.baidu.tbadk.core.d.a.agL().bD("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        }, new com.baidu.tbadk.util.j<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    private void bgO() {
        if (this.gkZ != null) {
            DataRes.Builder builder = new DataRes.Builder(this.gkZ.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            a(builder);
        }
    }

    private void bxM() {
        if (this.gkZ != null) {
            final DataRes.Builder builder = new DataRes.Builder(this.gkZ.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 50) {
                builder.thread_list = builder.thread_list.subList(0, 50);
            }
            a(builder, builder.thread_list != null ? builder.thread_list.size() : 0);
            com.baidu.tbadk.util.z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.2
                @Override // com.baidu.tbadk.util.y
                public Object doInBackground() {
                    DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                    e.this.gkX.cF(builder2.thread_list);
                    try {
                        com.baidu.tbadk.core.d.a.agL().bD("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
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
    public void yH(String str) {
        if (!TextUtils.isEmpty(str) && this.gkZ != null && this.gkZ.banner_list != null && this.gkZ.banner_list.app != null && this.gkZ.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.gkZ.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.gkZ.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.gkZ.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.gkZ.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.gkX.cF(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.d.a.agL().bD("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).f("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean bxN() {
        return lv(true);
    }

    private boolean lv(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.ahU().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.gkW;
    }

    public void a(a aVar) {
        this.gkY = aVar;
    }

    private boolean pQ() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public void bxB() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.ame() && !StringUtils.isNull(activityPrizeData.aml())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("activity_prize_feed_text_time", "");
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
                    com.baidu.tbadk.core.sharedPref.b.ahU().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bJ(int i, int i2) {
        if (this.gkg != null) {
            this.glc.boO();
        }
        if (this.gkg != null && this.gkg.getCurrentTabType() != 1) {
            this.glc.hideTip();
        } else if (!this.glj) {
            this.glc.hideTip();
        } else {
            this.gla = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().aml();
            }
            if (!TextUtils.isEmpty(str) && j.kc()) {
                if (i == 4) {
                    this.fAw = 3000;
                } else {
                    this.fAw = 2000;
                }
                this.glm.cbR = str;
                this.glm.fAo = this.fAw;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                FrameLayout frameLayout = this.gkg.getFrameLayout();
                frameLayout.removeView(this.glm);
                frameLayout.addView(this.glm, layoutParams);
                this.glm.boM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Long l) {
        if (this.gkZ != null && this.gkZ.thread_list != null) {
            List<ThreadInfo> list = this.gkZ.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    bgO();
                    a(false, true, false, this.gkZ.build(true));
                    return;
                }
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gll = bdUniqueId;
            if (this.fNm != null) {
                this.fNm.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.fNm);
            }
            if (this.glp != null) {
                this.glp.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.glp);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.glq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.glq);
            this.fPt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fPt);
            this.fPu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fPu);
            this.fNB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fNB);
            if (this.fyw != null) {
                this.fyw.setUniqueId(bdUniqueId);
            }
            this.gkX.j(bdUniqueId);
            this.glv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.glv);
            this.fxD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fxD);
            this.glw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.glw);
        }
    }

    public void bxO() {
        this.fvX = new com.baidu.tieba.tbadkCore.data.f("new_index", null);
        this.fvX.cqa();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.m> list, int i2) {
        int i3;
        int i4;
        if (this.fvX != null) {
            if (i == 0) {
                this.fvX.cqa();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.f.jhZ;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.fvX.cy(i3, i7 + 1);
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

    public void uj(int i) {
        if ((this.fvX != null ? this.fvX.Bh(i) : -1) >= 0 && this.fAL != null && this.fAL.getData() != null && this.fAL.getData().size() > i) {
            this.fvX.Bi(i);
        }
    }

    public m bnE() {
        return this.fyw;
    }

    public void lp(boolean z) {
        this.gkb = z;
    }

    public void uk(final int i) {
        com.baidu.tbadk.util.z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.7
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.d.a.agL().bE(e.this.glr, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(e.this.glr, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        com.baidu.tbadk.util.z.a(new y<String>() { // from class: com.baidu.tieba.homepage.personalize.e.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: bxR */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> bE = com.baidu.tbadk.core.d.a.agL().bE(e.this.glr, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    return bE.get(e.this.glr);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.j<String>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: yI */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.tR(com.baidu.adp.lib.g.b.f(str, 0));
                }
            }
        });
    }

    public void bxC() {
        c.e(this.fAL);
    }

    public void bxP() {
        a(this.glu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.gkZ != null && com.baidu.tbadk.core.util.v.Z(this.gkZ.thread_list) != 0 && com.baidu.tbadk.core.util.v.Z(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.fAL != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.fAL.getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.m item = this.fAL.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.j) {
                            com.baidu.tieba.card.data.j jVar = (com.baidu.tieba.card.data.j) item;
                            if (jVar.acC() != null && jVar.acC().aeV() != null && optString2.equals(String.valueOf(jVar.acC().aeV().live_id))) {
                                str = jVar.acC().getTid();
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
                    if (cVar.acC() != null && cVar.acC().getTid() != null) {
                        if (cVar.acC().getTid().equals(optString)) {
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
            if (this.gkZ != null && this.gkZ.thread_list != null) {
                long e = com.baidu.adp.lib.g.b.e(optString, 0L);
                int i2 = 0;
                while (true) {
                    if (i2 < this.gkZ.thread_list.size()) {
                        ThreadInfo threadInfo = this.gkZ.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != e) {
                            i2++;
                        } else {
                            this.gkZ.thread_list.remove(i2);
                            bgO();
                            com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.gkZ.thread_list, this.mDataList);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.fAL != null) {
                    List<Integer> b = b(optString, this.fAL);
                    int intValue = b.get(0).intValue();
                    int intValue2 = b.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.fAL.t(intValue, intValue2);
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
                    if (cVar.acC() != null && cVar.acC().getTid().equals(str)) {
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
    public void g(String str, List<com.baidu.adp.widget.ListView.m> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).baL();
                } else {
                    if (next instanceof ad) {
                        ad adVar = (ad) next;
                        if (adVar.adf() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) adVar.adf()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.bFs)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.glm != null) {
            this.glm.onChangeSkinType(i);
        }
    }

    public FloatInfo bxQ() {
        return this.glk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z bxo() {
        if (this.fyw == null || this.fyw.cfk() == null || !(this.fyw.cfk().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fyw.cfk().getTag();
    }
}
