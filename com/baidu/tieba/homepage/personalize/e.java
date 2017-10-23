package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.p;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.o;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.homepage.personalize.data.h;
import com.baidu.tieba.play.m;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GodInfo;
import tbclient.Personalized.AgeSexModule;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes.dex */
public class e {
    private p aLL;
    private View.OnTouchListener axl;
    private com.baidu.tieba.e.a cIb;
    private boolean cTk;
    private DataRes.Builder cYB;
    private as cYE;
    private final com.baidu.tieba.homepage.personalize.model.a cYF;
    private ScrollFragmentTabHost cYH;
    private int cYK;
    private int cYM;
    private Runnable cYV;
    private final o cYj;
    private final long cYy;
    private final b cYz;
    private com.baidu.tieba.tbadkCore.data.e cqd;
    private m crT;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a cYA = null;
    private final List<com.baidu.adp.widget.ListView.f> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cVv = false;
    private long cYC = 0;
    private int cYD = 1;
    private int cVy = 0;
    private TextView abE = null;
    private int ctA = 2000;
    private com.baidu.tbadk.k.f cYG = null;
    private boolean crM = false;
    private int crn = 0;
    private int beu = 0;
    private boolean mIsBackground = false;
    private boolean cYI = true;
    private boolean cYJ = false;
    private boolean cYL = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.11
        private int cVB = -1;
        private int cVC = 0;
        private boolean cVD = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.cYG == null) {
                e.this.cYG = new com.baidu.tbadk.k.f();
                e.this.cYG.fs(1005);
                e.this.cYG.pageType = 1;
            }
            if (e.this.aLL != null && !e.this.mIsBackground) {
                e.this.aLL.onScrollStateChanged(absListView, i);
            }
            e.this.cYG.FD();
            if (i == 0) {
                u.XN().cA(true);
                if (this.cVD) {
                    e.this.apx();
                }
                this.cVD = false;
                if (e.this.crT != null && e.this.cYI) {
                    e.this.crT.a(e.this.crn, e.this.beu, e.this.crM, 1);
                }
            } else if (i == 1 && e.this.cYE != null) {
                e.this.cYE.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cVC > i) {
                this.cVD = true;
            }
            if (e.this.aLL != null && !e.this.mIsBackground) {
                e.this.aLL.a(absListView, this.cVC, i, i2, i3);
            }
            this.cVC = i;
            int i4 = (i + i2) - 1;
            if (!this.cVD && this.cVB != i4) {
                this.cVB = i4;
                e.this.ld(this.cVB);
            }
            if (this.cVD && this.cVB != i) {
                this.cVB = i;
                e.this.ld(this.cVB);
            }
            e.this.cYU = i;
            e.this.crn = i;
            e.this.beu = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aLM = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.axl != null) {
                e.this.axl.onTouch(view, motionEvent);
            }
            if (e.this.cIb != null) {
                e.this.cIb.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0081a cau = new a.InterfaceC0081a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ao(int i, int i2) {
            e.this.crM = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ap(int i, int i2) {
            e.this.crM = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void aq(int i, int i2) {
        }
    };
    private View.OnClickListener cYN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.cYE != null) {
                e.this.cYE.hideTip();
            }
            if (e.this.cYD == 1 && e.this.mListView != null) {
                e.this.mListView.setSelection(0);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cYO = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fD(true);
        }
    };
    private final CustomMessageListener cYP = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.apy();
        }
    };
    private final CustomMessageListener bop = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fD(false);
        }
    };
    private final CustomMessageListener cYQ = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mListView != null) {
                e.this.crT.aqY();
                e.this.cYI = false;
                e.this.mListView.completePullRefreshPostDelayed(2000L);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cYR = new CustomMessageListener(CmdConfigCustom.CMD_GUIDE_SET_CACHE) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mDataList.size() > 0) {
                if (e.this.mDataList.get(0) instanceof h) {
                    h hVar = (h) e.this.mDataList.get(0);
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    if (hVar.dal != null) {
                        for (g gVar : hVar.dal) {
                            if (gVar != null) {
                                TagStruct.Builder builder = new TagStruct.Builder();
                                builder.tag_name = gVar.tagName;
                                builder.selected = Integer.valueOf(gVar.isSelect ? 1 : 0);
                                linkedList.add(builder.build(false));
                            }
                        }
                    }
                    if (hVar.dam != null) {
                        for (g gVar2 : hVar.dam) {
                            if (gVar2 != null) {
                                TagStruct.Builder builder2 = new TagStruct.Builder();
                                builder2.tag_name = gVar2.tagName;
                                builder2.selected = Integer.valueOf(gVar2.isSelect ? 1 : 0);
                                linkedList2.add(builder2.build(false));
                            }
                        }
                    }
                    if (e.this.cYB != null) {
                        AgeSexModule.Builder builder3 = new AgeSexModule.Builder();
                        builder3.sex_tag = linkedList;
                        builder3.age_tag = linkedList2;
                        e.this.cYB.age_sex = builder3.build(false);
                    }
                } else if (e.this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f) {
                    com.baidu.tieba.homepage.personalize.data.f fVar = (com.baidu.tieba.homepage.personalize.data.f) e.this.mDataList.get(0);
                    if (fVar.dai != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (g gVar3 : fVar.dai) {
                            if (gVar3 != null) {
                                TagStruct.Builder builder4 = new TagStruct.Builder();
                                builder4.tag_name = gVar3.tagName;
                                builder4.selected = Integer.valueOf(gVar3.isSelect ? 1 : 0);
                                linkedList3.add(builder4.build(false));
                            }
                        }
                        e.this.cYB.interestion = linkedList3;
                    }
                }
                e.this.aoS();
            }
        }
    };
    private CustomMessageListener ann = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && e.this.cYB != null && v.t(e.this.cYB.thread_list) != 0 && (bhVar = (bh) customResponsedMessage.getData()) != null && bhVar.re() != null && bhVar.getId() != null && v.t(e.this.cYB.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.cYB.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.cYB.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bhVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bhVar.re().getNum());
                            builder.zan = builder2.build(true);
                            e.this.cYB.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener cYS = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bh bhVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.u(e.this.mDataList) && !v.u(ids) && !v.u(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bh) && (bhVar = (bh) originData.get(i2)) != null && bhVar.rG() != null && ids.contains(Long.valueOf(bhVar.rG().live_id))) {
                            e.this.mDataList.remove(bhVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.cYj != null) {
                        e.this.cYj.br(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener aoH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.cYB != null && !v.u(e.this.cYB.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.cYB.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.cYB.thread_list.get(i);
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
                            e.this.cYB.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String cYT = "lastReadReadPositionKey";
    private int cYU = 0;
    private d cYW = new d() { // from class: com.baidu.tieba.homepage.personalize.e.10
        @Override // com.baidu.tieba.homepage.personalize.d
        public void kR(final int i) {
            if (e.this.cYV == null) {
                e.this.cYV = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.mListView.getHandler() != null) {
                            e.this.mListView.requestFocusFromTouch();
                            if (i <= e.this.mListView.getCount() - 1) {
                                e.this.mListView.setSelection(i);
                            }
                        }
                    }
                };
            }
            e.this.mListView.removeCallbacks(e.this.cYV);
            e.this.mListView.post(e.this.cYV);
        }
    };
    private CustomMessageListener cFi = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFj = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFk = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.cYB != null && v.t(e.this.cYB.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.lq(str);
                if (e.this.cYj != null) {
                    e.this.cYj.br(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void A(int i, int i2, int i3);

        void aO(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cYH = scrollFragmentTabHost;
        if (this.cYH != null) {
            this.cYH.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void lc(int i) {
                    if (e.this.cYH.lb(i) != 1 && e.this.cYE != null) {
                        e.this.cYE.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eE(boolean z) {
        this.mIsBackground = z;
        if (this.crT != null) {
            this.crT.hs(!z);
            if (z) {
                this.crT.aqY();
            } else if (this.cYI) {
                this.crT.a(this.crn, this.beu, this.crM, true);
            }
        }
    }

    public e(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, o oVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aLM);
        this.cIb = new com.baidu.tieba.e.a();
        this.cIb.a(this.cau);
        this.cYj = oVar;
        this.cYF = new com.baidu.tieba.homepage.personalize.model.a();
        this.cYy = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cYE = new as();
        apz();
        this.crT = new m(this.mPageContext, this.mListView);
        this.cYz = new b(this.mDataList, this.cYj);
    }

    private boolean apq() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aps(), true);
    }

    private void apr() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aps(), false);
    }

    private String aps() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.cYM = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (qVar != null) {
            this.aLL = qVar.GM();
            this.axl = qVar.GN();
        }
    }

    public void showFloatingView() {
        if (this.aLL != null) {
            this.aLL.ce(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aoY().kQ(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aoY().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cYL = true;
        if (this.mDataList.size() == 0 && !this.cVv && !apq()) {
            aoR();
        } else {
            aoO();
        }
    }

    public void aP(int i, int i2) {
        bh bhVar;
        if (!v.u(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bh.Ya.getId() && (bhVar = (bh) this.mDataList.get(i)) != null && bhVar.rG() != null) {
                    arrayList.add(Long.valueOf(bhVar.rG().live_id));
                    arrayList2.add(bhVar);
                }
                i++;
            }
            if (!v.u(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void apt() {
        if (this.crT != null && !this.mIsBackground && this.cYI) {
            this.crT.a(this.crn, this.beu, this.crM, true);
        }
        if (this.cYJ) {
            if (this.cTk) {
                if (fC(false)) {
                    aQ(3, this.cVy);
                } else if (this.cYK > 0) {
                    aQ(2, this.cVy);
                }
            } else if (!this.cTk && this.cVy == 0) {
                aQ(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cYJ = false;
            this.cTk = false;
            this.cYK = 0;
            if (this.cYL) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.cYL = false;
        }
    }

    public void Ns() {
        if (!ws() && this.cYA != null) {
            apv();
            this.mPn++;
            setIsLoading(true);
            this.cYA.A(this.mPn, (this.cYB == null || this.cYB.thread_list == null) ? 0 : this.cYB.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cYB == null || this.cYB.thread_list == null) ? 0 : this.cYB.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.cYJ = false;
            if (this.mDataList.size() > 0) {
                if (this.cYA != null) {
                    this.cYA.onError(1, str);
                    return;
                }
                return;
            } else if (this.cYA != null) {
                this.cYA.onError(2, str);
                return;
            } else {
                return;
            }
        }
        apr();
        if (this.cYA != null) {
            this.cYA.onSuccess();
        }
        this.cYJ = true;
        this.cTk = z;
        this.cYK = size;
        aoS();
    }

    public void fz(boolean z) {
        if (z) {
            this.cYj.notifyDataSetChanged();
        }
        if (!apu()) {
            apx();
        }
    }

    public void onDestroy() {
        if (this.crT != null) {
            this.crT.destroy();
        }
        if (this.cYG != null) {
            this.cYG.onDestroy();
        }
        if (this.cYE != null) {
            this.cYE.onDestroy();
        }
        if (this.cYz != null) {
            this.cYz.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.cYV);
        }
    }

    public void onPause() {
        le(this.cYU);
        gt(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        gt(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void gt(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$11
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean apu() {
        if (fC(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("close_new_user_guide_tip", false)) {
                fD(true);
            }
            apy();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aoO() {
        if (this.cYA != null) {
            this.cYA.aO((this.cYB == null || this.cYB.thread_list == null || apw()) ? 0 : this.cYB.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cVv = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !apw()) {
                if (this.cYA != null) {
                    this.cYA.onSuccess();
                }
                apx();
                return;
            }
            aoO();
            return;
        }
        aoO();
    }

    private void bu(List<com.baidu.adp.widget.ListView.f> list) {
        if (!v.u(list)) {
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) fVar;
                    if (dVar.XW() != null) {
                        dVar.XW().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.XW().advertAppContext.Tt = "NEWINDEX";
                        dVar.XW().advertAppContext.pn = 1;
                        dVar.XW().advertAppContext.extensionInfo = dVar.XW().extensionInfo;
                        dVar.XW().advertAppContext.Ty = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.f> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.cYC = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && apw()) {
            this.cYB = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cYF.a(z, this.cYB, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.f> list2 = a2.aUo;
            this.cVy = a2.dap;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bu(list);
            a(z2 ? 0 : 1, list, size);
            if (this.cYL) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.cYB == null) {
            this.cYB = builder;
            this.cYz.bs(this.cYB.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.cYj.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.cYj.br(linkedList);
            z4 = true;
            if (this.crT != null && this.cYI) {
                this.crT.a(this.crn, this.beu, this.crM, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aoY().d(System.currentTimeMillis() - currentTimeMillis, 1);
        long kQ = com.baidu.tieba.homepage.framework.a.aoY().kQ(1);
        if (kQ > 0) {
            com.baidu.tieba.homepage.framework.a.aoY().e(System.currentTimeMillis() - kQ, 1);
            com.baidu.tieba.homepage.framework.a.aoY().f(0L, 1);
            return z4;
        }
        return z4;
    }

    private void apv() {
        if (v.t(this.mDataList) >= this.cYF.apH() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.cYF.a(true, this.cYB, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.f> list = a2 != null ? a2.aUo : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.cYj.br(new LinkedList(this.mDataList));
            }
        }
    }

    private void aoR() {
        t.a(new s<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: apB */
            public DataRes doInBackground() {
                l<byte[]> M = com.baidu.tbadk.core.c.a.sX().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (M == null) {
                    return null;
                }
                byte[] bArr = M.get("0");
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
        }, new com.baidu.tbadk.util.g<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoS() {
        if (this.cYB != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cYB.build(true));
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
    public void lq(String str) {
        if (!TextUtils.isEmpty(str) && this.cYB != null && this.cYB.banner_list != null && this.cYB.banner_list.app != null && this.cYB.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.cYB.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.cYB.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.cYB.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.cYB.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.cYz.bt(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.sX().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean apw() {
        return fC(true);
    }

    private boolean fC(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cYy;
    }

    public void a(a aVar) {
        this.cYA = aVar;
    }

    private boolean ws() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.cYC != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cYC) {
                aQ(1, 0);
            }
        }
    }

    private void aQ(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.cYH != null) {
            this.cYE.aii();
        }
        if (this.cYH != null && this.cYH.getCurrentTabType() != 1) {
            this.cYE.hideTip();
            return;
        }
        this.cYD = i;
        String str = null;
        if (i == 1) {
            str = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_guide);
        } else if (i == 2) {
            if (i2 > 0) {
                str = String.format(TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                str = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_nodata);
            }
        } else if (i == 3) {
            str = TbadkCoreApplication.getInst().getString(d.l.recommend_frs_refresh_cache_invalid);
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.abE == null) {
                this.abE = new TextView(this.mPageContext.getPageActivity());
                this.abE.setGravity(17);
                this.abE.setOnClickListener(this.cYN);
            }
            this.cYE.aii();
            FrameLayout frameLayout = this.cYH.getFrameLayout();
            if (frameLayout != null && this.abE.getParent() == null) {
                if (i == 1) {
                    if (j.hh()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds40);
                        this.abE.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.abE.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        aj.j(this.abE, d.g.bg_home_float);
                        aj.i(this.abE, d.e.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.cYM;
                    } else {
                        return;
                    }
                } else {
                    this.abE.setPadding(0, 0, 0, 0);
                    this.abE.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize24));
                    aj.j(this.abE, d.e.common_color_10260);
                    aj.i(this.abE, d.e.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.cYM;
                }
                this.abE.setText(str);
                if (i == 1) {
                    this.ctA = 4000;
                } else {
                    this.ctA = 2000;
                }
                this.cYE.a(this.abE, frameLayout, layoutParams, this.ctA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("close_new_user_guide_tip", true);
        if (this.cYB != null && this.cYB.age_sex != null) {
            this.cYB.age_sex = null;
            if (z) {
                aoS();
            }
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof h)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cYj.br(new ArrayList(this.mDataList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apy() {
        if (this.cYB != null && this.cYB.interestion != null) {
            this.cYB.interestion = null;
            aoS();
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cYj.br(new ArrayList(this.mDataList));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ann != null) {
                this.ann.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.ann);
            }
            if (this.cYO != null) {
                this.cYO.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cYO);
            }
            if (this.cYP != null) {
                this.cYP.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cYP);
            }
            if (this.bop != null) {
                this.bop.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.bop);
            }
            if (this.cYQ != null) {
                this.cYQ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cYQ);
            }
            this.cYR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cYR);
            this.aoH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoH);
            this.cYS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cYS);
            this.cFi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cFi);
            this.cFj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cFj);
            this.cFk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cFk);
            if (this.crT != null) {
                this.crT.setUniqueId(bdUniqueId);
            }
            this.cYz.h(bdUniqueId);
        }
    }

    public void apz() {
        this.cqd = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.cqd.bqQ();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.f> list, int i2) {
        int i3;
        int i4;
        if (this.cqd != null) {
            if (i == 0) {
                this.cqd.bqQ();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gfV;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.cqd.bS(i3, i7 + 1);
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

    public void ld(int i) {
        if ((this.cqd != null ? this.cqd.tx(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.cqd.ty(i);
        }
    }

    public m ahn() {
        return this.crT;
    }

    public void fE(boolean z) {
        this.cYI = z;
    }

    public void le(final int i) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.9
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.sX().N(e.this.cYT, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(e.this.cYT, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        t.a(new s<String>() { // from class: com.baidu.tieba.homepage.personalize.e.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.s
            /* renamed from: apC */
            public String doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.sX().N(e.this.cYT, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    return N.get(e.this.cYT);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.g<String>() { // from class: com.baidu.tieba.homepage.personalize.e.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: lr */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.kR(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void apA() {
        a(this.cYW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.cYB != null && v.t(this.cYB.thread_list) != 0 && v.t(this.mDataList) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString)) {
                if (this.mListView != null && this.mListView.getAdapter() != null) {
                    View childAt = this.mListView.getChildAt(a(optString, this.mListView));
                    if (childAt != null) {
                        ay(childAt);
                    } else if (this.cYj != null) {
                        this.cYj.br(new ArrayList(this.mDataList));
                    }
                }
                Iterator<com.baidu.adp.widget.ListView.f> it = this.mDataList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next instanceof com.baidu.tieba.card.data.c) {
                        com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                        if (cVar.Nd() != null && cVar.Nd().getTid() != null && cVar.Nd().getTid().equals(optString)) {
                            it.remove();
                            com.baidu.tieba.homepage.personalize.model.b.bw(this.mDataList);
                            break;
                        }
                    }
                }
                if (this.cYB != null && this.cYB.thread_list != null) {
                    long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.cYB.thread_list.size()) {
                            ThreadInfo threadInfo = this.cYB.thread_list.get(i2);
                            if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                                i = i2 + 1;
                            } else {
                                this.cYB.thread_list.remove(i2);
                                aoS();
                                com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.cYB.thread_list, this.mDataList);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private int a(String str, BdTypeListView bdTypeListView) {
        int headerViewsCount = bdTypeListView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeListView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeListView.getAdapter().getCount(); i2++) {
            com.baidu.adp.widget.ListView.f item = bdTypeListView.getItem(i2);
            if (item instanceof com.baidu.tieba.card.data.c) {
                com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                if (cVar.Nd() != null && cVar.Nd().getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private void ay(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.homepage.personalize.e.16
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                view.getLayoutParams().height = measuredHeight - ((int) (measuredHeight * f));
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.e.17
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                view.setVisibility(8);
                if (e.this.cYj != null) {
                    e.this.cYj.br(new ArrayList(e.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<com.baidu.adp.widget.ListView.f> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).XW();
                } else {
                    if (next instanceof af) {
                        af afVar = (af) next;
                        if (afVar.pU() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) afVar.pU()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.TO)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
