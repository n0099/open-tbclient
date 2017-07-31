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
    private q aMR;
    private boolean cJi;
    private View.OnTouchListener cQa;
    private final o cSH;
    private ScrollFragmentTabHost cSR;
    private final long cSZ;
    private final b cTa;
    private DataRes.Builder cTc;
    private ar cTf;
    private final com.baidu.tieba.homepage.personalize.model.a cTg;
    private int cTk;
    private int cTm;
    private Runnable cTx;
    private com.baidu.tieba.tbadkCore.data.e ciT;
    private l ckL;
    private com.baidu.tieba.e.a cym;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a cTb = null;
    private final List<com.baidu.adp.widget.ListView.f> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cPY = false;
    private long cTd = 0;
    private int cTe = 1;
    private int cQc = 0;
    private TextView acG = null;
    private int cmj = 2000;
    private com.baidu.tbadk.l.f cTh = null;
    private boolean ckE = false;
    private int cke = 0;
    private int bcZ = 0;
    private boolean mIsBackground = false;
    private boolean cTi = true;
    private boolean cTj = false;
    private boolean cTl = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.11
        private int cQd = -1;
        private int cQe = 0;
        private boolean cQf = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.cTh == null) {
                e.this.cTh = new com.baidu.tbadk.l.f();
                e.this.cTh.fi(1005);
                e.this.cTh.pageType = 1;
            }
            if (e.this.aMR != null && !e.this.mIsBackground) {
                e.this.aMR.onScrollStateChanged(absListView, i);
            }
            e.this.cTh.Gg();
            if (i == 0) {
                u.WB().cA(true);
                if (this.cQf) {
                    e.this.aoA();
                }
                this.cQf = false;
                if (e.this.ckL != null && e.this.cTi) {
                    e.this.ckL.a(e.this.cke, e.this.bcZ, e.this.ckE, 1);
                }
            } else if (i == 1 && e.this.cTf != null) {
                e.this.cTf.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cQe > i) {
                this.cQf = true;
            }
            if (e.this.aMR != null && !e.this.mIsBackground) {
                e.this.aMR.a(absListView, this.cQe, i, i2, i3);
            }
            this.cQe = i;
            int i4 = (i + i2) - 1;
            if (!this.cQf && this.cQd != i4) {
                this.cQd = i4;
                e.this.kF(this.cQd);
            }
            if (this.cQf && this.cQd != i) {
                this.cQd = i;
                e.this.kF(this.cQd);
            }
            e.this.cTw = i;
            e.this.cke = i;
            e.this.bcZ = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aMS = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cQa != null) {
                e.this.cQa.onTouch(view, motionEvent);
            }
            if (e.this.cym != null) {
                e.this.cym.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0079a bWf = new a.InterfaceC0079a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.e.a.InterfaceC0079a
        public void ah(int i, int i2) {
            e.this.ckE = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0079a
        public void ai(int i, int i2) {
            e.this.ckE = false;
        }
    };
    private View.OnClickListener cTn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.cTf != null) {
                e.this.cTf.hideTip();
            }
            if (e.this.cTe == 1 && e.this.mListView != null) {
                e.this.mListView.setSelection(0);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cTo = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fG(true);
        }
    };
    private final CustomMessageListener cTp = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.aoB();
        }
    };
    private final CustomMessageListener cTq = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fG(false);
        }
    };
    private final CustomMessageListener cTr = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mListView != null) {
                e.this.ckL.apY();
                e.this.cTi = false;
                e.this.mListView.completePullRefreshPostDelayed(2000L);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cTs = new CustomMessageListener(CmdConfigCustom.CMD_GUIDE_SET_CACHE) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mDataList.size() > 0) {
                if (e.this.mDataList.get(0) instanceof h) {
                    h hVar = (h) e.this.mDataList.get(0);
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    if (hVar.cUM != null) {
                        for (g gVar : hVar.cUM) {
                            if (gVar != null) {
                                TagStruct.Builder builder = new TagStruct.Builder();
                                builder.tag_name = gVar.Vl;
                                builder.selected = Integer.valueOf(gVar.isSelect ? 1 : 0);
                                linkedList.add(builder.build(false));
                            }
                        }
                    }
                    if (hVar.cUN != null) {
                        for (g gVar2 : hVar.cUN) {
                            if (gVar2 != null) {
                                TagStruct.Builder builder2 = new TagStruct.Builder();
                                builder2.tag_name = gVar2.Vl;
                                builder2.selected = Integer.valueOf(gVar2.isSelect ? 1 : 0);
                                linkedList2.add(builder2.build(false));
                            }
                        }
                    }
                    if (e.this.cTc != null) {
                        AgeSexModule.Builder builder3 = new AgeSexModule.Builder();
                        builder3.sex_tag = linkedList;
                        builder3.age_tag = linkedList2;
                        e.this.cTc.age_sex = builder3.build(false);
                    }
                } else if (e.this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f) {
                    com.baidu.tieba.homepage.personalize.data.f fVar = (com.baidu.tieba.homepage.personalize.data.f) e.this.mDataList.get(0);
                    if (fVar.cUJ != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (g gVar3 : fVar.cUJ) {
                            if (gVar3 != null) {
                                TagStruct.Builder builder4 = new TagStruct.Builder();
                                builder4.tag_name = gVar3.Vl;
                                builder4.selected = Integer.valueOf(gVar3.isSelect ? 1 : 0);
                                linkedList3.add(builder4.build(false));
                            }
                        }
                        e.this.cTc.interestion = linkedList3;
                    }
                }
                e.this.anY();
            }
        }
    };
    private CustomMessageListener cTt = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.tieba.homepage.b.a.a> list;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && e.this.cTc != null && (list = (List) customResponsedMessage.getData()) != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.homepage.b.a.a aVar : list) {
                    if (aVar != null && aVar.cVm != -1 && aVar.cVm != -2 && !StringUtils.isNull(aVar.cVl)) {
                        SimpleForum.Builder builder = new SimpleForum.Builder();
                        builder.name = aVar.cVl;
                        builder.level_id = Integer.valueOf(aVar.level);
                        arrayList.add(builder.build(true));
                    }
                }
                e.this.cTc.like_forums = arrayList;
                e.this.anY();
            }
        }
    };
    private CustomMessageListener aoP = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bl blVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl) && e.this.cTc != null && com.baidu.tbadk.core.util.u.u(e.this.cTc.thread_list) != 0 && (blVar = (bl) customResponsedMessage.getData()) != null && blVar.rv() != null && blVar.getId() != null && com.baidu.tbadk.core.util.u.u(e.this.cTc.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.cTc.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.cTc.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.d(blVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) blVar.rv().getNum());
                            builder.zan = builder2.build(true);
                            e.this.cTc.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener cTu = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.8
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
                        if ((originData.get(i2) instanceof bl) && (blVar = (bl) originData.get(i2)) != null && blVar.rX() != null && ids.contains(Long.valueOf(blVar.rX().live_id))) {
                            e.this.mDataList.remove(blVar);
                        }
                        i = i2 + 1;
                    }
                    if (e.this.cSH != null) {
                        e.this.cSH.bo(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener aqg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.cTc != null && !com.baidu.tbadk.core.util.u.v(e.this.cTc.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.cTc.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.cTc.thread_list.get(i);
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
                            e.this.cTc.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String cTv = "lastReadReadPositionKey";
    private int cTw = 0;
    private d cTy = new d() { // from class: com.baidu.tieba.homepage.personalize.e.12
        @Override // com.baidu.tieba.homepage.personalize.d
        public void kw(final int i) {
            if (e.this.cTx == null) {
                e.this.cTx = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.12.1
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
            e.this.mListView.removeCallbacks(e.this.cTx);
            e.this.mListView.post(e.this.cTx);
        }
    };
    private CustomMessageListener cvf = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && e.this.cTc != null && com.baidu.tbadk.core.util.u.u(e.this.cTc.thread_list) != 0 && com.baidu.tbadk.core.util.u.u(e.this.mDataList) != 0) {
                String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                if (!StringUtils.isNull(optString)) {
                    if (e.this.mListView != null && e.this.mListView.getAdapter() != null) {
                        View childAt = e.this.mListView.getChildAt(e.this.a(optString, e.this.mListView));
                        if (childAt != null) {
                            e.this.an(childAt);
                        } else if (e.this.cSH != null) {
                            e.this.cSH.bo(new ArrayList(e.this.mDataList));
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
                            if (cVar.MF() != null && cVar.MF().getTid() != null && cVar.MF().getTid().equals(optString)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.bx(e.this.mDataList);
                                break;
                            }
                        }
                    }
                    if (e.this.cTc != null && e.this.cTc.thread_list != null) {
                        long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < e.this.cTc.thread_list.size()) {
                                ThreadInfo threadInfo = e.this.cTc.thread_list.get(i2);
                                if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                                    e.this.cTc.thread_list.remove(i2);
                                    e.this.anY();
                                    com.baidu.tieba.homepage.personalize.c.d.a(threadInfo.tid.longValue(), i2, e.this.cTc.thread_list, e.this.mDataList);
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
    private CustomMessageListener cvg = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.cTc != null && com.baidu.tbadk.core.util.u.u(e.this.cTc.thread_list) != 0 && com.baidu.tbadk.core.util.u.u(e.this.mDataList) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.ln(str);
                if (e.this.cSH != null) {
                    e.this.cSH.bo(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ax(int i, int i2);

        void k(List<com.baidu.tieba.homepage.b.a.a> list, boolean z);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cSR = scrollFragmentTabHost;
        if (this.cSR != null) {
            this.cSR.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void kE(int i) {
                    if (i != com.baidu.tieba.homepage.framework.indicator.a.cRS && e.this.cTf != null) {
                        e.this.cTf.hideTip();
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
        if (this.ckL != null) {
            this.ckL.hu(!z);
            if (z) {
                this.ckL.apY();
            } else if (this.cTi) {
                this.ckL.a(this.cke, this.bcZ, this.ckE, true);
            }
        }
    }

    public e(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, o oVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMS);
        this.cym = new com.baidu.tieba.e.a();
        this.cym.a(this.bWf);
        this.cSH = oVar;
        this.cTg = new com.baidu.tieba.homepage.personalize.model.a();
        this.cSZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cTf = new ar();
        aoC();
        this.ckL = new l(this.mPageContext, this.mListView);
        this.cTa = new b(this.mDataList, this.cSH);
    }

    private boolean aot() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aov(), true);
    }

    private void aou() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aov(), false);
    }

    private String aov() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.cTm = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMR = rVar.Hp();
            this.cQa = rVar.Hq();
        }
    }

    public void showFloatingView() {
        if (this.aMR != null) {
            this.aMR.cg(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aod().kv(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aod().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cTl = true;
        if (this.mDataList.size() == 0 && !this.cPY && !aot()) {
            anX();
        } else {
            anV();
        }
    }

    public void ay(int i, int i2) {
        bl blVar;
        if (!com.baidu.tbadk.core.util.u.v(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bl.Ze.getId() && (blVar = (bl) this.mDataList.get(i)) != null && blVar.rX() != null) {
                    arrayList.add(Long.valueOf(blVar.rX().live_id));
                    arrayList2.add(blVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.u.v(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aow() {
        if (this.ckL != null && !this.mIsBackground && this.cTi) {
            this.ckL.a(this.cke, this.bcZ, this.ckE, true);
        }
        if (this.cTj) {
            if (this.cJi) {
                if (fF(false)) {
                    az(3, this.cQc);
                } else if (this.cTk > 0) {
                    az(2, this.cQc);
                }
            } else if (!this.cJi && this.cQc == 0) {
                az(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cTj = false;
            this.cJi = false;
            this.cTk = 0;
            if (this.cTl) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.cTl = false;
        }
    }

    public void MS() {
        if (!xc() && this.cTb != null) {
            aoy();
            this.mPn++;
            setIsLoading(true);
            this.cTb.v(this.mPn, (this.cTc == null || this.cTc.thread_list == null) ? 0 : this.cTc.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cTc == null || this.cTc.thread_list == null) ? 0 : this.cTc.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.cTj = false;
            if (this.mDataList.size() > 0) {
                if (this.cTb != null) {
                    this.cTb.onError(1, str);
                    return;
                }
                return;
            } else if (this.cTb != null) {
                this.cTb.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aou();
        if (this.cTb != null) {
            this.cTb.onSuccess();
        }
        this.cTj = true;
        this.cJi = z;
        this.cTk = size;
        anY();
    }

    public void fC(boolean z) {
        if (z) {
            this.cSH.notifyDataSetChanged();
        }
        if (!aox()) {
            aoA();
        }
    }

    public void onDestroy() {
        if (this.ckL != null) {
            this.ckL.destroy();
        }
        if (this.cTh != null) {
            this.cTh.onDestroy();
        }
        if (this.cTf != null) {
            this.cTf.onDestroy();
        }
        if (this.cTa != null) {
            this.cTa.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.cTx);
        }
    }

    public void onPause() {
        kG(this.cTw);
        gd(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        gd(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void gd(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$11
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aox() {
        if (fF(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("close_new_user_guide_tip", false)) {
                fG(true);
            }
            aoB();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void anV() {
        if (this.cTb != null) {
            this.cTb.ax((this.cTc == null || this.cTc.thread_list == null || aoz()) ? 0 : this.cTc.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cPY = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aoz()) {
                if (this.cTb != null) {
                    this.cTb.onSuccess();
                }
                aoA();
                return;
            }
            anV();
            return;
        }
        anV();
    }

    private void bv(List<com.baidu.adp.widget.ListView.f> list) {
        if (!com.baidu.tbadk.core.util.u.v(list)) {
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) fVar;
                    if (dVar.WL() != null) {
                        dVar.WL().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.WL().advertAppContext.Um = "NEWINDEX";
                        dVar.WL().advertAppContext.pn = 1;
                        dVar.WL().advertAppContext.extensionInfo = dVar.WL().extensionInfo;
                        dVar.WL().advertAppContext.Ur = false;
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
        this.cTd = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aoz()) {
            this.cTc = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cTg.a(z, this.cTc, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.f> list2 = a2.aTT;
            this.cQc = a2.cUP;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            if (z2) {
                bv(list);
            }
            a(z2 ? 0 : 1, list, size);
            if (this.cTl) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.cTc == null) {
            this.cTc = builder;
            this.cTa.bt(this.cTc.thread_list);
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            if (!com.baidu.tbadk.core.util.u.v(dataRes.like_forums)) {
                if (z) {
                    this.cTc.like_forums = dataRes.like_forums;
                }
                for (SimpleForum simpleForum : dataRes.like_forums) {
                    if (simpleForum != null && !StringUtils.isNull(simpleForum.name)) {
                        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
                        aVar.cVl = simpleForum.name;
                        aVar.cVm = simpleForum.id.longValue();
                        aVar.level = simpleForum.level_id.intValue();
                        aVar.isSelected = false;
                        arrayList.add(aVar);
                    }
                }
            }
            if (this.cTb != null) {
                this.cTb.k(b(arrayList, com.baidu.tbadk.util.c.GZ()), z3);
            }
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.cSH.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.cSH.bo(linkedList);
            z4 = true;
            if (this.ckL != null && this.cTi) {
                this.ckL.a(this.cke, this.bcZ, this.ckE, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aod().d(System.currentTimeMillis() - currentTimeMillis, 1);
        long kv = com.baidu.tieba.homepage.framework.a.aod().kv(1);
        if (kv > 0) {
            com.baidu.tieba.homepage.framework.a.aod().e(System.currentTimeMillis() - kv, 1);
            com.baidu.tieba.homepage.framework.a.aod().f(0L, 1);
            return z4;
        }
        return z4;
    }

    private void aoy() {
        if (com.baidu.tbadk.core.util.u.u(this.mDataList) >= this.cTg.aoK() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.cTg.a(true, this.cTc, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.f> list = a2 != null ? a2.aTT : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.cSH.bo(new LinkedList(this.mDataList));
            }
        }
    }

    private List<com.baidu.tieba.homepage.b.a.a> b(List<com.baidu.tieba.homepage.b.a.a> list, String[] strArr) {
        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
        aVar.cVl = "推荐";
        aVar.cVm = -1L;
        aVar.isSelected = false;
        com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
        aVar2.cVl = "发现";
        aVar2.cVm = -2L;
        aVar2.isSelected = false;
        if (strArr == null || strArr.length == 0) {
            list.add(0, aVar);
            list.add(1, aVar2);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (com.baidu.tieba.homepage.b.a.a aVar3 : list) {
                if (aVar3 != null && aVar3.cVl != null && aVar3.cVl.equals(str)) {
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

    private void anX() {
        com.baidu.tbadk.util.u.a(new t<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: aoE */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> L = com.baidu.tbadk.core.c.a.tn().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
    public void anY() {
        if (this.cTc != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cTc.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln(String str) {
        if (!TextUtils.isEmpty(str) && this.cTc != null && this.cTc.banner_list != null && this.cTc.banner_list.app != null && this.cTc.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.cTc.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.cTc.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            DataRes.Builder builder2 = new DataRes.Builder(this.cTc.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.cTa.bu(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.tn().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).k("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aoz() {
        return fF(true);
    }

    private boolean fF(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cSZ;
    }

    public void a(a aVar) {
        this.cTb = aVar;
    }

    private boolean xc() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoA() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.cTd != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cTd) {
                az(1, 0);
            }
        }
    }

    private void az(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.cSR != null) {
            this.cTf.agm();
        }
        if (this.cSR != null && this.cSR.getCurrentItem() != com.baidu.tieba.homepage.framework.indicator.a.cRS) {
            this.cTf.hideTip();
            return;
        }
        this.cTe = i;
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
            if (this.acG == null) {
                this.acG = new TextView(this.mPageContext.getPageActivity());
                this.acG.setGravity(17);
                this.acG.setOnClickListener(this.cTn);
            }
            this.cTf.agm();
            FrameLayout frameLayout = this.cSR.getFrameLayout();
            if (frameLayout != null && this.acG.getParent() == null) {
                if (i == 1) {
                    if (i.hr()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds40);
                        this.acG.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.acG.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        ai.j(this.acG, d.g.bg_home_float);
                        ai.i(this.acG, d.e.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.cTm;
                    } else {
                        return;
                    }
                } else {
                    this.acG.setPadding(0, 0, 0, 0);
                    this.acG.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize24));
                    ai.j(this.acG, d.e.common_color_10260);
                    ai.i(this.acG, d.e.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.cTm;
                }
                this.acG.setText(str);
                if (i == 1) {
                    this.cmj = 4000;
                } else {
                    this.cmj = 2000;
                }
                this.cTf.a(this.acG, frameLayout, layoutParams, this.cmj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("close_new_user_guide_tip", true);
        if (this.cTc != null && this.cTc.age_sex != null) {
            this.cTc.age_sex = null;
            if (z) {
                anY();
            }
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof h)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cSH.bo(new ArrayList(this.mDataList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoB() {
        if (this.cTc != null && this.cTc.interestion != null) {
            this.cTc.interestion = null;
            anY();
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cSH.bo(new ArrayList(this.mDataList));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aoP != null) {
                this.aoP.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.aoP);
            }
            if (this.cTo != null) {
                this.cTo.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cTo);
            }
            if (this.cTp != null) {
                this.cTp.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cTp);
            }
            if (this.cTq != null) {
                this.cTq.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cTq);
            }
            if (this.cTr != null) {
                this.cTr.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cTr);
            }
            this.cTs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTs);
            this.aqg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aqg);
            this.cTu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTu);
            this.cvf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cvf);
            this.cvg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cvg);
            this.cTt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTt);
            if (this.ckL != null) {
                this.ckL.setUniqueId(bdUniqueId);
            }
            this.cTa.i(bdUniqueId);
        }
    }

    public void aoC() {
        this.ciT = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.ciT.brZ();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.f> list, int i2) {
        int i3;
        int i4;
        if (this.ciT != null) {
            if (i == 0) {
                this.ciT.brZ();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gho;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.ciT.bw(i3, i7 + 1);
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
        if ((this.ciT != null ? this.ciT.tf(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.ciT.tg(i);
        }
    }

    public l afz() {
        return this.ckL;
    }

    public void fH(boolean z) {
        this.cTi = z;
    }

    public void kG(final int i) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.tn().M(e.this.cTv, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(e.this.cTv, Integer.toString(i), 43200000L);
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
            /* renamed from: aoF */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.tn().M(e.this.cTv, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    return M.get(e.this.cTv);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: lo */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.kw(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void aoD() {
        a(this.cTy);
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
                if (cVar.MF() != null && cVar.MF().getTid().equals(str)) {
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
                if (e.this.cSH != null) {
                    e.this.cSH.bo(new ArrayList(e.this.mDataList));
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).WL();
                } else {
                    if (next instanceof ah) {
                        ah ahVar = (ah) next;
                        if (ahVar.ql() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ahVar.ql()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.UH)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
