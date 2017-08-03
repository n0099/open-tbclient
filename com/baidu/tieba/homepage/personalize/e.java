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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
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
    private q aLC;
    private boolean cHN;
    private View.OnTouchListener cOH;
    private final long cRG;
    private final b cRH;
    private DataRes.Builder cRJ;
    private ar cRM;
    private final com.baidu.tieba.homepage.personalize.model.a cRN;
    private int cRR;
    private int cRT;
    private final o cRo;
    private ScrollFragmentTabHost cRy;
    private Runnable cSe;
    private com.baidu.tieba.tbadkCore.data.e chM;
    private l cjD;
    private com.baidu.tieba.e.a cwS;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a cRI = null;
    private final List<com.baidu.adp.widget.ListView.f> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cOF = false;
    private long cRK = 0;
    private int cRL = 1;
    private int cOJ = 0;
    private TextView abj = null;
    private int cla = 2000;
    private com.baidu.tbadk.l.f cRO = null;
    private boolean cjw = false;
    private int ciX = 0;
    private int bbP = 0;
    private boolean mIsBackground = false;
    private boolean cRP = true;
    private boolean cRQ = false;
    private boolean cRS = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.11
        private int cOK = -1;
        private int cOL = 0;
        private boolean cOM = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.cRO == null) {
                e.this.cRO = new com.baidu.tbadk.l.f();
                e.this.cRO.fg(1005);
                e.this.cRO.pageType = 1;
            }
            if (e.this.aLC != null && !e.this.mIsBackground) {
                e.this.aLC.onScrollStateChanged(absListView, i);
            }
            e.this.cRO.FY();
            if (i == 0) {
                u.Ww().cA(true);
                if (this.cOM) {
                    e.this.aoo();
                }
                this.cOM = false;
                if (e.this.cjD != null && e.this.cRP) {
                    e.this.cjD.a(e.this.ciX, e.this.bbP, e.this.cjw, 1);
                }
            } else if (i == 1 && e.this.cRM != null) {
                e.this.cRM.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cOL > i) {
                this.cOM = true;
            }
            if (e.this.aLC != null && !e.this.mIsBackground) {
                e.this.aLC.a(absListView, this.cOL, i, i2, i3);
            }
            this.cOL = i;
            int i4 = (i + i2) - 1;
            if (!this.cOM && this.cOK != i4) {
                this.cOK = i4;
                e.this.kF(this.cOK);
            }
            if (this.cOM && this.cOK != i) {
                this.cOK = i;
                e.this.kF(this.cOK);
            }
            e.this.cSd = i;
            e.this.ciX = i;
            e.this.bbP = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aLD = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cOH != null) {
                e.this.cOH.onTouch(view, motionEvent);
            }
            if (e.this.cwS != null) {
                e.this.cwS.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0080a bUZ = new a.InterfaceC0080a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ag(int i, int i2) {
            e.this.cjw = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            e.this.cjw = false;
        }
    };
    private View.OnClickListener cRU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.cRM != null) {
                e.this.cRM.hideTip();
            }
            if (e.this.cRL == 1 && e.this.mListView != null) {
                e.this.mListView.setSelection(0);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cRV = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fG(true);
        }
    };
    private final CustomMessageListener cRW = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.aop();
        }
    };
    private final CustomMessageListener cRX = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fG(false);
        }
    };
    private final CustomMessageListener cRY = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mListView != null) {
                e.this.cjD.apM();
                e.this.cRP = false;
                e.this.mListView.completePullRefreshPostDelayed(2000L);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cRZ = new CustomMessageListener(CmdConfigCustom.CMD_GUIDE_SET_CACHE) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mDataList.size() > 0) {
                if (e.this.mDataList.get(0) instanceof h) {
                    h hVar = (h) e.this.mDataList.get(0);
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    if (hVar.cTt != null) {
                        for (g gVar : hVar.cTt) {
                            if (gVar != null) {
                                TagStruct.Builder builder = new TagStruct.Builder();
                                builder.tag_name = gVar.TL;
                                builder.selected = Integer.valueOf(gVar.isSelect ? 1 : 0);
                                linkedList.add(builder.build(false));
                            }
                        }
                    }
                    if (hVar.cTu != null) {
                        for (g gVar2 : hVar.cTu) {
                            if (gVar2 != null) {
                                TagStruct.Builder builder2 = new TagStruct.Builder();
                                builder2.tag_name = gVar2.TL;
                                builder2.selected = Integer.valueOf(gVar2.isSelect ? 1 : 0);
                                linkedList2.add(builder2.build(false));
                            }
                        }
                    }
                    if (e.this.cRJ != null) {
                        AgeSexModule.Builder builder3 = new AgeSexModule.Builder();
                        builder3.sex_tag = linkedList;
                        builder3.age_tag = linkedList2;
                        e.this.cRJ.age_sex = builder3.build(false);
                    }
                } else if (e.this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f) {
                    com.baidu.tieba.homepage.personalize.data.f fVar = (com.baidu.tieba.homepage.personalize.data.f) e.this.mDataList.get(0);
                    if (fVar.cTq != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (g gVar3 : fVar.cTq) {
                            if (gVar3 != null) {
                                TagStruct.Builder builder4 = new TagStruct.Builder();
                                builder4.tag_name = gVar3.TL;
                                builder4.selected = Integer.valueOf(gVar3.isSelect ? 1 : 0);
                                linkedList3.add(builder4.build(false));
                            }
                        }
                        e.this.cRJ.interestion = linkedList3;
                    }
                }
                e.this.anM();
            }
        }
    };
    private CustomMessageListener cSa = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.tieba.homepage.b.a.a> list;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && e.this.cRJ != null && (list = (List) customResponsedMessage.getData()) != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.homepage.b.a.a aVar : list) {
                    if (aVar != null && aVar.cTT != -1 && aVar.cTT != -2 && !StringUtils.isNull(aVar.cTS)) {
                        SimpleForum.Builder builder = new SimpleForum.Builder();
                        builder.name = aVar.cTS;
                        builder.level_id = Integer.valueOf(aVar.level);
                        arrayList.add(builder.build(true));
                    }
                }
                e.this.cRJ.like_forums = arrayList;
                e.this.anM();
            }
        }
    };
    private CustomMessageListener anw = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bl blVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl) && e.this.cRJ != null && com.baidu.tbadk.core.util.u.u(e.this.cRJ.thread_list) != 0 && (blVar = (bl) customResponsedMessage.getData()) != null && blVar.rl() != null && blVar.getId() != null && com.baidu.tbadk.core.util.u.u(e.this.cRJ.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.cRJ.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.cRJ.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(blVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) blVar.rl().getNum());
                            builder.zan = builder2.build(true);
                            e.this.cRJ.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener cSb = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bl blVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!com.baidu.tbadk.core.util.u.v(e.this.mDataList) && !com.baidu.tbadk.core.util.u.v(ids) && !com.baidu.tbadk.core.util.u.v(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bl) && (blVar = (bl) originData.get(i2)) != null && blVar.rN() != null && ids.contains(Long.valueOf(blVar.rN().live_id))) {
                            e.this.mDataList.remove(blVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.cRo != null) {
                        e.this.cRo.bo(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener aoM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.cRJ != null && !com.baidu.tbadk.core.util.u.v(e.this.cRJ.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.cRJ.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.cRJ.thread_list.get(i);
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
                            e.this.cRJ.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String cSc = "lastReadReadPositionKey";
    private int cSd = 0;
    private d cSf = new d() { // from class: com.baidu.tieba.homepage.personalize.e.12
        @Override // com.baidu.tieba.homepage.personalize.d
        public void kw(final int i) {
            if (e.this.cSe == null) {
                e.this.cSe = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.12.1
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
            e.this.mListView.removeCallbacks(e.this.cSe);
            e.this.mListView.post(e.this.cSe);
        }
    };
    private CustomMessageListener ctN = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && e.this.cRJ != null && com.baidu.tbadk.core.util.u.u(e.this.cRJ.thread_list) != 0 && com.baidu.tbadk.core.util.u.u(e.this.mDataList) != 0) {
                String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                if (!StringUtils.isNull(optString)) {
                    if (e.this.mListView != null && e.this.mListView.getAdapter() != null) {
                        View childAt = e.this.mListView.getChildAt(e.this.a(optString, e.this.mListView));
                        if (childAt != null) {
                            e.this.an(childAt);
                        } else if (e.this.cRo != null) {
                            e.this.cRo.bo(new ArrayList(e.this.mDataList));
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
                            if (cVar.MA() != null && cVar.MA().getTid() != null && cVar.MA().getTid().equals(optString)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.bx(e.this.mDataList);
                                break;
                            }
                        }
                    }
                    if (e.this.cRJ != null && e.this.cRJ.thread_list != null) {
                        long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < e.this.cRJ.thread_list.size()) {
                                ThreadInfo threadInfo = e.this.cRJ.thread_list.get(i2);
                                if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                                    e.this.cRJ.thread_list.remove(i2);
                                    e.this.anM();
                                    com.baidu.tieba.homepage.personalize.c.d.a(threadInfo.tid.longValue(), i2, e.this.cRJ.thread_list, e.this.mDataList);
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
    private CustomMessageListener ctO = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.cRJ != null && com.baidu.tbadk.core.util.u.u(e.this.cRJ.thread_list) != 0 && com.baidu.tbadk.core.util.u.u(e.this.mDataList) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.lj(str);
                if (e.this.cRo != null) {
                    e.this.cRo.bo(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aw(int i, int i2);

        void k(List<com.baidu.tieba.homepage.b.a.a> list, boolean z);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cRy = scrollFragmentTabHost;
        if (this.cRy != null) {
            this.cRy.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void kE(int i) {
                    if (i != com.baidu.tieba.homepage.framework.indicator.a.cQz && e.this.cRM != null) {
                        e.this.cRM.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eJ(boolean z) {
        this.mIsBackground = z;
        if (this.cjD != null) {
            this.cjD.hu(!z);
            if (z) {
                this.cjD.apM();
            } else if (this.cRP) {
                this.cjD.a(this.ciX, this.bbP, this.cjw, true);
            }
        }
    }

    public e(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, o oVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aLD);
        this.cwS = new com.baidu.tieba.e.a();
        this.cwS.a(this.bUZ);
        this.cRo = oVar;
        this.cRN = new com.baidu.tieba.homepage.personalize.model.a();
        this.cRG = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cRM = new ar();
        aoq();
        this.cjD = new l(this.mPageContext, this.mListView);
        this.cRH = new b(this.mDataList, this.cRo);
    }

    private boolean aoh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aoj(), true);
    }

    private void aoi() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aoj(), false);
    }

    private String aoj() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.cRT = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aLC = rVar.Hh();
            this.cOH = rVar.Hi();
        }
    }

    public void showFloatingView() {
        if (this.aLC != null) {
            this.aLC.cg(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.anR().kv(1) == -1) {
            com.baidu.tieba.homepage.framework.a.anR().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cRS = true;
        if (this.mDataList.size() == 0 && !this.cOF && !aoh()) {
            anL();
        } else {
            anJ();
        }
    }

    public void ax(int i, int i2) {
        bl blVar;
        if (!com.baidu.tbadk.core.util.u.v(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bl.XI.getId() && (blVar = (bl) this.mDataList.get(i)) != null && blVar.rN() != null) {
                    arrayList.add(Long.valueOf(blVar.rN().live_id));
                    arrayList2.add(blVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.u.v(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aok() {
        if (this.cjD != null && !this.mIsBackground && this.cRP) {
            this.cjD.a(this.ciX, this.bbP, this.cjw, true);
        }
        if (this.cRQ) {
            if (this.cHN) {
                if (fF(false)) {
                    ay(3, this.cOJ);
                } else if (this.cRR > 0) {
                    ay(2, this.cOJ);
                }
            } else if (!this.cHN && this.cOJ == 0) {
                ay(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cRQ = false;
            this.cHN = false;
            this.cRR = 0;
            if (this.cRS) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.cRS = false;
        }
    }

    public void MN() {
        if (!wT() && this.cRI != null) {
            aom();
            this.mPn++;
            setIsLoading(true);
            this.cRI.v(this.mPn, (this.cRJ == null || this.cRJ.thread_list == null) ? 0 : this.cRJ.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cRJ == null || this.cRJ.thread_list == null) ? 0 : this.cRJ.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.cRQ = false;
            if (this.mDataList.size() > 0) {
                if (this.cRI != null) {
                    this.cRI.onError(1, str);
                    return;
                }
                return;
            } else if (this.cRI != null) {
                this.cRI.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aoi();
        if (this.cRI != null) {
            this.cRI.onSuccess();
        }
        this.cRQ = true;
        this.cHN = z;
        this.cRR = size;
        anM();
    }

    public void fC(boolean z) {
        if (z) {
            this.cRo.notifyDataSetChanged();
        }
        if (!aol()) {
            aoo();
        }
    }

    public void onDestroy() {
        if (this.cjD != null) {
            this.cjD.destroy();
        }
        if (this.cRO != null) {
            this.cRO.onDestroy();
        }
        if (this.cRM != null) {
            this.cRM.onDestroy();
        }
        if (this.cRH != null) {
            this.cRH.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.cSe);
        }
    }

    public void onPause() {
        kG(this.cSd);
        gb(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        gb(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void gb(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$11
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aol() {
        if (fF(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("close_new_user_guide_tip", false)) {
                fG(true);
            }
            aop();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void anJ() {
        if (this.cRI != null) {
            this.cRI.aw((this.cRJ == null || this.cRJ.thread_list == null || aon()) ? 0 : this.cRJ.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cOF = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aon()) {
                if (this.cRI != null) {
                    this.cRI.onSuccess();
                }
                aoo();
                return;
            }
            anJ();
            return;
        }
        anJ();
    }

    private void bv(List<com.baidu.adp.widget.ListView.f> list) {
        if (!com.baidu.tbadk.core.util.u.v(list)) {
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) fVar;
                    if (dVar.WG() != null) {
                        dVar.WG().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.WG().advertAppContext.SO = "NEWINDEX";
                        dVar.WG().advertAppContext.pn = 1;
                        dVar.WG().advertAppContext.extensionInfo = dVar.WG().extensionInfo;
                        dVar.WG().advertAppContext.ST = false;
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
        this.cRK = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aon()) {
            this.cRJ = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cRN.a(z, this.cRJ, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.f> list2 = a2.aSH;
            this.cOJ = a2.cTw;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            if (z2) {
                bv(list);
            }
            a(z2 ? 0 : 1, list, size);
            if (this.cRS) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.cRJ == null) {
            this.cRJ = builder;
            this.cRH.bt(this.cRJ.thread_list);
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            if (!com.baidu.tbadk.core.util.u.v(dataRes.like_forums)) {
                if (z) {
                    this.cRJ.like_forums = dataRes.like_forums;
                }
                for (SimpleForum simpleForum : dataRes.like_forums) {
                    if (simpleForum != null && !StringUtils.isNull(simpleForum.name)) {
                        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
                        aVar.cTS = simpleForum.name;
                        aVar.cTT = simpleForum.id.longValue();
                        aVar.level = simpleForum.level_id.intValue();
                        aVar.isSelected = false;
                        arrayList.add(aVar);
                    }
                }
            }
            if (this.cRI != null) {
                this.cRI.k(b(arrayList, com.baidu.tbadk.util.c.GR()), z3);
            }
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.cRo.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.cRo.bo(linkedList);
            z4 = true;
            if (this.cjD != null && this.cRP) {
                this.cjD.a(this.ciX, this.bbP, this.cjw, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.anR().d(System.currentTimeMillis() - currentTimeMillis, 1);
        long kv = com.baidu.tieba.homepage.framework.a.anR().kv(1);
        if (kv > 0) {
            com.baidu.tieba.homepage.framework.a.anR().e(System.currentTimeMillis() - kv, 1);
            com.baidu.tieba.homepage.framework.a.anR().f(0L, 1);
            return z4;
        }
        return z4;
    }

    private void aom() {
        if (com.baidu.tbadk.core.util.u.u(this.mDataList) >= this.cRN.aoy() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.cRN.a(true, this.cRJ, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.f> list = a2 != null ? a2.aSH : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.cRo.bo(new LinkedList(this.mDataList));
            }
        }
    }

    private List<com.baidu.tieba.homepage.b.a.a> b(List<com.baidu.tieba.homepage.b.a.a> list, String[] strArr) {
        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
        aVar.cTS = "推荐";
        aVar.cTT = -1L;
        aVar.isSelected = false;
        com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
        aVar2.cTS = "发现";
        aVar2.cTT = -2L;
        aVar2.isSelected = false;
        if (strArr == null || strArr.length == 0) {
            list.add(0, aVar);
            list.add(1, aVar2);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (com.baidu.tieba.homepage.b.a.a aVar3 : list) {
                if (aVar3 != null && aVar3.cTS != null && aVar3.cTS.equals(str)) {
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

    private void anL() {
        com.baidu.tbadk.util.u.a(new t<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: aos */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> L = com.baidu.tbadk.core.c.a.td().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (L == null) {
                    return null;
                }
                byte[] bArr = L.get("0");
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
    public void anM() {
        if (this.cRJ != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cRJ.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(String str) {
        if (!TextUtils.isEmpty(str) && this.cRJ != null && this.cRJ.banner_list != null && this.cRJ.banner_list.app != null && this.cRJ.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.cRJ.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.cRJ.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            DataRes.Builder builder2 = new DataRes.Builder(this.cRJ.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.cRH.bu(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.td().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).k("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aon() {
        return fF(true);
    }

    private boolean fF(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cRG;
    }

    public void a(a aVar) {
        this.cRI = aVar;
    }

    private boolean wT() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoo() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.cRK != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cRK) {
                ay(1, 0);
            }
        }
    }

    private void ay(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.cRy != null) {
            this.cRM.agf();
        }
        if (this.cRy != null && this.cRy.getCurrentItem() != com.baidu.tieba.homepage.framework.indicator.a.cQz) {
            this.cRM.hideTip();
            return;
        }
        this.cRL = i;
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
            if (this.abj == null) {
                this.abj = new TextView(this.mPageContext.getPageActivity());
                this.abj.setGravity(17);
                this.abj.setOnClickListener(this.cRU);
            }
            this.cRM.agf();
            FrameLayout frameLayout = this.cRy.getFrameLayout();
            if (frameLayout != null && this.abj.getParent() == null) {
                if (i == 1) {
                    if (i.hh()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds40);
                        this.abj.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.abj.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        ai.j(this.abj, d.g.bg_home_float);
                        ai.i(this.abj, d.e.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.cRT;
                    } else {
                        return;
                    }
                } else {
                    this.abj.setPadding(0, 0, 0, 0);
                    this.abj.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize24));
                    ai.j(this.abj, d.e.common_color_10260);
                    ai.i(this.abj, d.e.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.cRT;
                }
                this.abj.setText(str);
                if (i == 1) {
                    this.cla = 4000;
                } else {
                    this.cla = 2000;
                }
                this.cRM.a(this.abj, frameLayout, layoutParams, this.cla);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("close_new_user_guide_tip", true);
        if (this.cRJ != null && this.cRJ.age_sex != null) {
            this.cRJ.age_sex = null;
            if (z) {
                anM();
            }
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof h)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cRo.bo(new ArrayList(this.mDataList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aop() {
        if (this.cRJ != null && this.cRJ.interestion != null) {
            this.cRJ.interestion = null;
            anM();
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cRo.bo(new ArrayList(this.mDataList));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.anw != null) {
                this.anw.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.anw);
            }
            if (this.cRV != null) {
                this.cRV.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cRV);
            }
            if (this.cRW != null) {
                this.cRW.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cRW);
            }
            if (this.cRX != null) {
                this.cRX.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cRX);
            }
            if (this.cRY != null) {
                this.cRY.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cRY);
            }
            this.cRZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cRZ);
            this.aoM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoM);
            this.cSb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cSb);
            this.ctN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ctN);
            this.ctO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ctO);
            this.cSa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cSa);
            if (this.cjD != null) {
                this.cjD.setUniqueId(bdUniqueId);
            }
            this.cRH.i(bdUniqueId);
        }
    }

    public void aoq() {
        this.chM = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.chM.brS();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.f> list, int i2) {
        int i3;
        int i4;
        if (this.chM != null) {
            if (i == 0) {
                this.chM.brS();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.ggd;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.chM.bv(i3, i7 + 1);
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

    public void kF(int i) {
        if ((this.chM != null ? this.chM.tf(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.chM.tg(i);
        }
    }

    public l afu() {
        return this.cjD;
    }

    public void fH(boolean z) {
        this.cRP = z;
    }

    public void kG(final int i) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.td().M(e.this.cSc, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(e.this.cSc, Integer.toString(i), 43200000L);
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
            /* renamed from: aot */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.td().M(e.this.cSc, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    return M.get(e.this.cSc);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: lk */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.kw(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void aor() {
        a(this.cSf);
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
                if (cVar.MA() != null && cVar.MA().getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(final View view) {
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
                if (e.this.cRo != null) {
                    e.this.cRo.bo(new ArrayList(e.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<com.baidu.adp.widget.ListView.f> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).WG();
                } else {
                    if (next instanceof ah) {
                        ah ahVar = (ah) next;
                        if (ahVar.qb() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ahVar.qb()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.Ti)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
