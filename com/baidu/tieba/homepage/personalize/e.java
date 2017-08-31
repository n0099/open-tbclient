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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.b.o;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.homepage.personalize.data.h;
import com.baidu.tieba.play.l;
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
import tbclient.SimpleForum;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes.dex */
public class e {
    private q aMz;
    private com.baidu.tieba.e.a cGC;
    private boolean cRw;
    private View.OnTouchListener cYu;
    private com.baidu.tieba.tbadkCore.data.e cpa;
    private l cqQ;
    private final long dbB;
    private final b dbC;
    private DataRes.Builder dbE;
    private ar dbH;
    private final com.baidu.tieba.homepage.personalize.model.a dbI;
    private int dbM;
    private int dbO;
    private Runnable dbZ;
    private final o dbj;
    private ScrollFragmentTabHost dbt;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a dbD = null;
    private final List<com.baidu.adp.widget.ListView.f> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cYs = false;
    private long dbF = 0;
    private int dbG = 1;
    private int cYw = 0;
    private TextView abP = null;
    private int csp = 2000;
    private com.baidu.tbadk.l.f dbJ = null;
    private boolean cqJ = false;
    private int cqk = 0;
    private int bcY = 0;
    private boolean mIsBackground = false;
    private boolean dbK = true;
    private boolean dbL = false;
    private boolean dbN = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.11
        private int cYy = -1;
        private int cYz = 0;
        private boolean cYA = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.dbJ == null) {
                e.this.dbJ = new com.baidu.tbadk.l.f();
                e.this.dbJ.fi(1005);
                e.this.dbJ.pageType = 1;
            }
            if (e.this.aMz != null && !e.this.mIsBackground) {
                e.this.aMz.onScrollStateChanged(absListView, i);
            }
            e.this.dbJ.Ge();
            if (i == 0) {
                u.XY().cC(true);
                if (this.cYA) {
                    e.this.aqL();
                }
                this.cYA = false;
                if (e.this.cqQ != null && e.this.dbK) {
                    e.this.cqQ.a(e.this.cqk, e.this.bcY, e.this.cqJ, 1);
                }
            } else if (i == 1 && e.this.dbH != null) {
                e.this.dbH.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cYz > i) {
                this.cYA = true;
            }
            if (e.this.aMz != null && !e.this.mIsBackground) {
                e.this.aMz.a(absListView, this.cYz, i, i2, i3);
            }
            this.cYz = i;
            int i4 = (i + i2) - 1;
            if (!this.cYA && this.cYy != i4) {
                this.cYy = i4;
                e.this.lh(this.cYy);
            }
            if (this.cYA && this.cYy != i) {
                this.cYy = i;
                e.this.lh(this.cYy);
            }
            e.this.dbY = i;
            e.this.cqk = i;
            e.this.bcY = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cYu != null) {
                e.this.cYu.onTouch(view, motionEvent);
            }
            if (e.this.cGC != null) {
                e.this.cGC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0082a bZO = new a.InterfaceC0082a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ag(int i, int i2) {
            e.this.cqJ = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0082a
        public void ah(int i, int i2) {
            e.this.cqJ = false;
        }
    };
    private View.OnClickListener dbP = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.dbH != null) {
                e.this.dbH.hideTip();
            }
            if (e.this.dbG == 1 && e.this.mListView != null) {
                e.this.mListView.setSelection(0);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener dbQ = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fR(true);
        }
    };
    private final CustomMessageListener dbR = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.aqM();
        }
    };
    private final CustomMessageListener dbS = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fR(false);
        }
    };
    private final CustomMessageListener dbT = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mListView != null) {
                e.this.cqQ.asj();
                e.this.dbK = false;
                e.this.mListView.completePullRefreshPostDelayed(2000L);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener dbU = new CustomMessageListener(CmdConfigCustom.CMD_GUIDE_SET_CACHE) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mDataList.size() > 0) {
                if (e.this.mDataList.get(0) instanceof h) {
                    h hVar = (h) e.this.mDataList.get(0);
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    if (hVar.ddp != null) {
                        for (g gVar : hVar.ddp) {
                            if (gVar != null) {
                                TagStruct.Builder builder = new TagStruct.Builder();
                                builder.tag_name = gVar.tagName;
                                builder.selected = Integer.valueOf(gVar.isSelect ? 1 : 0);
                                linkedList.add(builder.build(false));
                            }
                        }
                    }
                    if (hVar.ddq != null) {
                        for (g gVar2 : hVar.ddq) {
                            if (gVar2 != null) {
                                TagStruct.Builder builder2 = new TagStruct.Builder();
                                builder2.tag_name = gVar2.tagName;
                                builder2.selected = Integer.valueOf(gVar2.isSelect ? 1 : 0);
                                linkedList2.add(builder2.build(false));
                            }
                        }
                    }
                    if (e.this.dbE != null) {
                        AgeSexModule.Builder builder3 = new AgeSexModule.Builder();
                        builder3.sex_tag = linkedList;
                        builder3.age_tag = linkedList2;
                        e.this.dbE.age_sex = builder3.build(false);
                    }
                } else if (e.this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f) {
                    com.baidu.tieba.homepage.personalize.data.f fVar = (com.baidu.tieba.homepage.personalize.data.f) e.this.mDataList.get(0);
                    if (fVar.ddm != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (g gVar3 : fVar.ddm) {
                            if (gVar3 != null) {
                                TagStruct.Builder builder4 = new TagStruct.Builder();
                                builder4.tag_name = gVar3.tagName;
                                builder4.selected = Integer.valueOf(gVar3.isSelect ? 1 : 0);
                                linkedList3.add(builder4.build(false));
                            }
                        }
                        e.this.dbE.interestion = linkedList3;
                    }
                }
                e.this.aqh();
            }
        }
    };
    private CustomMessageListener dbV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.tieba.homepage.b.a.a> list;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && e.this.dbE != null && (list = (List) customResponsedMessage.getData()) != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.homepage.b.a.a aVar : list) {
                    if (aVar != null && aVar.ddS != -1 && aVar.ddS != -2 && !StringUtils.isNull(aVar.ddR)) {
                        SimpleForum.Builder builder = new SimpleForum.Builder();
                        builder.name = aVar.ddR;
                        builder.level_id = Integer.valueOf(aVar.level);
                        arrayList.add(builder.build(true));
                    }
                }
                e.this.dbE.like_forums = arrayList;
                e.this.aqh();
            }
        }
    };
    private CustomMessageListener aom = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && e.this.dbE != null && v.u(e.this.dbE.thread_list) != 0 && (bjVar = (bj) customResponsedMessage.getData()) != null && bjVar.rr() != null && bjVar.getId() != null && v.u(e.this.dbE.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.dbE.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.dbE.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bjVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bjVar.rr().getNum());
                            builder.zan = builder2.build(true);
                            e.this.dbE.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener dbW = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bj bjVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.v(e.this.mDataList) && !v.v(ids) && !v.v(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bj) && (bjVar = (bj) originData.get(i2)) != null && bjVar.rT() != null && ids.contains(Long.valueOf(bjVar.rT().live_id))) {
                            e.this.mDataList.remove(bjVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.dbj != null) {
                        e.this.dbj.bv(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener apM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.dbE != null && !v.v(e.this.dbE.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.dbE.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.dbE.thread_list.get(i);
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
                            e.this.dbE.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String dbX = "lastReadReadPositionKey";
    private int dbY = 0;
    private d dca = new d() { // from class: com.baidu.tieba.homepage.personalize.e.12
        @Override // com.baidu.tieba.homepage.personalize.d
        public void kU(final int i) {
            if (e.this.dbZ == null) {
                e.this.dbZ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.12.1
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
            e.this.mListView.removeCallbacks(e.this.dbZ);
            e.this.mListView.post(e.this.dbZ);
        }
    };
    private CustomMessageListener cDK = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && e.this.dbE != null && v.u(e.this.dbE.thread_list) != 0 && v.u(e.this.mDataList) != 0) {
                String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                if (!StringUtils.isNull(optString)) {
                    if (e.this.mListView != null && e.this.mListView.getAdapter() != null) {
                        View childAt = e.this.mListView.getChildAt(e.this.a(optString, e.this.mListView));
                        if (childAt != null) {
                            e.this.aw(childAt);
                        } else if (e.this.dbj != null) {
                            e.this.dbj.bv(new ArrayList(e.this.mDataList));
                        }
                    }
                    Iterator it = e.this.mDataList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) it.next();
                        if (fVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) fVar;
                            if (cVar.MR() != null && cVar.MR().getTid() != null && cVar.MR().getTid().equals(optString)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.bE(e.this.mDataList);
                                break;
                            }
                        }
                    }
                    if (e.this.dbE != null && e.this.dbE.thread_list != null) {
                        long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < e.this.dbE.thread_list.size()) {
                                ThreadInfo threadInfo = e.this.dbE.thread_list.get(i2);
                                if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                                    e.this.dbE.thread_list.remove(i2);
                                    e.this.aqh();
                                    com.baidu.tieba.homepage.personalize.c.d.a(threadInfo.tid.longValue(), i2, e.this.dbE.thread_list, e.this.mDataList);
                                    return;
                                }
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener cDL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.dbE != null && v.u(e.this.dbE.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.mDataList);
                e.this.lL(str);
                if (e.this.dbj != null) {
                    e.this.dbj.bv(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aE(int i, int i2);

        void l(List<com.baidu.tieba.homepage.b.a.a> list, boolean z);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dbt = scrollFragmentTabHost;
        if (this.dbt != null) {
            this.dbt.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void lg(int i) {
                    if (e.this.dbt.lf(i) != 1 && e.this.dbH != null) {
                        e.this.dbH.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eO(boolean z) {
        this.mIsBackground = z;
        if (this.cqQ != null) {
            this.cqQ.hF(!z);
            if (z) {
                this.cqQ.asj();
            } else if (this.dbK) {
                this.cqQ.a(this.cqk, this.bcY, this.cqJ, true);
            }
        }
    }

    public e(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, o oVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMA);
        this.cGC = new com.baidu.tieba.e.a();
        this.cGC.a(this.bZO);
        this.dbj = oVar;
        this.dbI = new com.baidu.tieba.homepage.personalize.model.a();
        this.dbB = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.dbH = new ar();
        aqN();
        this.cqQ = new l(this.mPageContext, this.mListView);
        this.dbC = new b(this.mDataList, this.dbj);
    }

    private boolean aqE() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aqG(), true);
    }

    private void aqF() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aqG(), false);
    }

    private String aqG() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.dbO = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMz = rVar.Ho();
            this.cYu = rVar.Hp();
        }
    }

    public void showFloatingView() {
        if (this.aMz != null) {
            this.aMz.cg(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aqm().kT(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aqm().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.dbN = true;
        if (this.mDataList.size() == 0 && !this.cYs && !aqE()) {
            aqg();
        } else {
            aqe();
        }
    }

    public void aF(int i, int i2) {
        bj bjVar;
        if (!v.v(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bj.Yl.getId() && (bjVar = (bj) this.mDataList.get(i)) != null && bjVar.rT() != null) {
                    arrayList.add(Long.valueOf(bjVar.rT().live_id));
                    arrayList2.add(bjVar);
                }
                i++;
            }
            if (!v.v(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aqH() {
        if (this.cqQ != null && !this.mIsBackground && this.dbK) {
            this.cqQ.a(this.cqk, this.bcY, this.cqJ, true);
        }
        if (this.dbL) {
            if (this.cRw) {
                if (fQ(false)) {
                    aG(3, this.cYw);
                } else if (this.dbM > 0) {
                    aG(2, this.cYw);
                }
            } else if (!this.cRw && this.cYw == 0) {
                aG(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dbL = false;
            this.cRw = false;
            this.dbM = 0;
            if (this.dbN) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.dbN = false;
        }
    }

    public void Nf() {
        if (!xa() && this.dbD != null) {
            aqJ();
            this.mPn++;
            setIsLoading(true);
            this.dbD.v(this.mPn, (this.dbE == null || this.dbE.thread_list == null) ? 0 : this.dbE.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.dbE == null || this.dbE.thread_list == null) ? 0 : this.dbE.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.dbL = false;
            if (this.mDataList.size() > 0) {
                if (this.dbD != null) {
                    this.dbD.onError(1, str);
                    return;
                }
                return;
            } else if (this.dbD != null) {
                this.dbD.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aqF();
        if (this.dbD != null) {
            this.dbD.onSuccess();
        }
        this.dbL = true;
        this.cRw = z;
        this.dbM = size;
        aqh();
    }

    public void fN(boolean z) {
        if (z) {
            this.dbj.notifyDataSetChanged();
        }
        if (!aqI()) {
            aqL();
        }
    }

    public void onDestroy() {
        if (this.cqQ != null) {
            this.cqQ.destroy();
        }
        if (this.dbJ != null) {
            this.dbJ.onDestroy();
        }
        if (this.dbH != null) {
            this.dbH.onDestroy();
        }
        if (this.dbC != null) {
            this.dbC.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.dbZ);
        }
    }

    public void onPause() {
        li(this.dbY);
        gg(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        gg(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void gg(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$11
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aqI() {
        if (fQ(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("close_new_user_guide_tip", false)) {
                fR(true);
            }
            aqM();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aqe() {
        if (this.dbD != null) {
            this.dbD.aE((this.dbE == null || this.dbE.thread_list == null || aqK()) ? 0 : this.dbE.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cYs = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aqK()) {
                if (this.dbD != null) {
                    this.dbD.onSuccess();
                }
                aqL();
                return;
            }
            aqe();
            return;
        }
        aqe();
    }

    private void bC(List<com.baidu.adp.widget.ListView.f> list) {
        if (!v.v(list)) {
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) fVar;
                    if (dVar.Yh() != null) {
                        dVar.Yh().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.Yh().advertAppContext.Tr = "NEWINDEX";
                        dVar.Yh().advertAppContext.pn = 1;
                        dVar.Yh().advertAppContext.extensionInfo = dVar.Yh().extensionInfo;
                        dVar.Yh().advertAppContext.Tw = false;
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
        this.dbF = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aqK()) {
            this.dbE = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.dbI.a(z, this.dbE, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.f> list2 = a2.aTF;
            this.cYw = a2.ddt;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bC(list);
            a(z2 ? 0 : 1, list, size);
            if (this.dbN) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.dbE == null) {
            this.dbE = builder;
            this.dbC.bA(this.dbE.thread_list);
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            if (!v.v(dataRes.like_forums)) {
                if (z) {
                    this.dbE.like_forums = dataRes.like_forums;
                }
                for (SimpleForum simpleForum : dataRes.like_forums) {
                    if (simpleForum != null && !StringUtils.isNull(simpleForum.name)) {
                        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
                        aVar.ddR = simpleForum.name;
                        aVar.ddS = simpleForum.id.longValue();
                        aVar.level = simpleForum.level_id.intValue();
                        aVar.isSelected = false;
                        arrayList.add(aVar);
                    }
                }
            }
            if (this.dbD != null) {
                this.dbD.l(b(arrayList, com.baidu.tbadk.util.c.GY()), z3);
            }
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.dbj.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dbj.bv(linkedList);
            z4 = true;
            if (this.cqQ != null && this.dbK) {
                this.cqQ.a(this.cqk, this.bcY, this.cqJ, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aqm().d(System.currentTimeMillis() - currentTimeMillis, 1);
        long kT = com.baidu.tieba.homepage.framework.a.aqm().kT(1);
        if (kT > 0) {
            com.baidu.tieba.homepage.framework.a.aqm().e(System.currentTimeMillis() - kT, 1);
            com.baidu.tieba.homepage.framework.a.aqm().f(0L, 1);
            return z4;
        }
        return z4;
    }

    private void aqJ() {
        if (v.u(this.mDataList) >= this.dbI.aqV() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.dbI.a(true, this.dbE, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.f> list = a2 != null ? a2.aTF : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.dbj.bv(new LinkedList(this.mDataList));
            }
        }
    }

    private List<com.baidu.tieba.homepage.b.a.a> b(List<com.baidu.tieba.homepage.b.a.a> list, String[] strArr) {
        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
        aVar.ddR = "推荐";
        aVar.ddS = -1L;
        aVar.isSelected = false;
        com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
        aVar2.ddR = "发现";
        aVar2.ddS = -2L;
        aVar2.isSelected = false;
        if (strArr == null || strArr.length == 0) {
            list.add(0, aVar);
            list.add(1, aVar2);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (com.baidu.tieba.homepage.b.a.a aVar3 : list) {
                if (aVar3 != null && aVar3.ddR != null && aVar3.ddR.equals(str)) {
                    arrayList.add(aVar3);
                }
            }
        }
        for (com.baidu.tieba.homepage.b.a.a aVar4 : list) {
            if (!arrayList.contains(aVar4)) {
                arrayList.add(aVar4);
            }
        }
        arrayList.add(0, aVar);
        arrayList.add(1, aVar2);
        return arrayList;
    }

    private void aqg() {
        com.baidu.tbadk.util.u.a(new t<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: aqP */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> N = com.baidu.tbadk.core.c.a.tk().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (N == null) {
                    return null;
                }
                byte[] bArr = N.get("0");
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
        }, new com.baidu.tbadk.util.h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                e.this.a(dataRes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqh() {
        if (this.dbE != null) {
            DataRes.Builder builder = new DataRes.Builder(this.dbE.build(true));
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
    public void lL(String str) {
        if (!TextUtils.isEmpty(str) && this.dbE != null && this.dbE.banner_list != null && this.dbE.banner_list.app != null && this.dbE.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.dbE.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.dbE.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.dbE.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.dbE.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.dbC.bB(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.tk().N("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aqK() {
        return fQ(true);
    }

    private boolean fQ(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.dbB;
    }

    public void a(a aVar) {
        this.dbD = aVar;
    }

    private boolean xa() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqL() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.dbF != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.dbF) {
                aG(1, 0);
            }
        }
    }

    private void aG(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.dbt != null) {
            this.dbH.ahZ();
        }
        if (this.dbt != null && this.dbt.getCurrentTabType() != 1) {
            this.dbH.hideTip();
            return;
        }
        this.dbG = i;
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
            if (this.abP == null) {
                this.abP = new TextView(this.mPageContext.getPageActivity());
                this.abP.setGravity(17);
                this.abP.setOnClickListener(this.dbP);
            }
            this.dbH.ahZ();
            FrameLayout frameLayout = this.dbt.getFrameLayout();
            if (frameLayout != null && this.abP.getParent() == null) {
                if (i == 1) {
                    if (i.hi()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds40);
                        this.abP.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.abP.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        aj.j(this.abP, d.g.bg_home_float);
                        aj.i(this.abP, d.e.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.dbO;
                    } else {
                        return;
                    }
                } else {
                    this.abP.setPadding(0, 0, 0, 0);
                    this.abP.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize24));
                    aj.j(this.abP, d.e.common_color_10260);
                    aj.i(this.abP, d.e.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.dbO;
                }
                this.abP.setText(str);
                if (i == 1) {
                    this.csp = 4000;
                } else {
                    this.csp = 2000;
                }
                this.dbH.a(this.abP, frameLayout, layoutParams, this.csp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("close_new_user_guide_tip", true);
        if (this.dbE != null && this.dbE.age_sex != null) {
            this.dbE.age_sex = null;
            if (z) {
                aqh();
            }
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof h)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.dbj.bv(new ArrayList(this.mDataList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqM() {
        if (this.dbE != null && this.dbE.interestion != null) {
            this.dbE.interestion = null;
            aqh();
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.dbj.bv(new ArrayList(this.mDataList));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aom != null) {
                this.aom.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.aom);
            }
            if (this.dbQ != null) {
                this.dbQ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dbQ);
            }
            if (this.dbR != null) {
                this.dbR.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dbR);
            }
            if (this.dbS != null) {
                this.dbS.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dbS);
            }
            if (this.dbT != null) {
                this.dbT.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.dbT);
            }
            this.dbU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dbU);
            this.apM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.apM);
            this.dbW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dbW);
            this.cDK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cDK);
            this.cDL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cDL);
            this.dbV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dbV);
            if (this.cqQ != null) {
                this.cqQ.setUniqueId(bdUniqueId);
            }
            this.dbC.i(bdUniqueId);
        }
    }

    public void aqN() {
        this.cpa = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.cpa.brP();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.f> list, int i2) {
        int i3;
        int i4;
        if (this.cpa != null) {
            if (i == 0) {
                this.cpa.brP();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.ghI;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.cpa.bG(i3, i7 + 1);
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

    public void lh(int i) {
        if ((this.cpa != null ? this.cpa.tr(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.cpa.ts(i);
        }
    }

    public l aho() {
        return this.cqQ;
    }

    public void fS(boolean z) {
        this.dbK = z;
    }

    public void li(final int i) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> O = com.baidu.tbadk.core.c.a.tk().O(e.this.dbX, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    O.a(e.this.dbX, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final d dVar) {
        com.baidu.tbadk.util.u.a(new t<String>() { // from class: com.baidu.tieba.homepage.personalize.e.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: aqQ */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> O = com.baidu.tbadk.core.c.a.tk().O(e.this.dbX, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    return O.get(e.this.dbX);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: lM */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.kU(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void aqO() {
        a(this.dca);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, BdTypeListView bdTypeListView) {
        int headerViewsCount = bdTypeListView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeListView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeListView.getAdapter().getCount(); i2++) {
            com.baidu.adp.widget.ListView.f item = bdTypeListView.getItem(i2);
            if (item instanceof com.baidu.tieba.card.data.c) {
                com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                if (cVar.MR() != null && cVar.MR().getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(final View view) {
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
                if (e.this.dbj != null) {
                    e.this.dbj.bv(new ArrayList(e.this.mDataList));
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).Yh();
                } else {
                    if (next instanceof ah) {
                        ah ahVar = (ah) next;
                        if (ahVar.qh() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ahVar.qh()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.TL)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
