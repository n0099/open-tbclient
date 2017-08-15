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
    private q aMS;
    private com.baidu.tieba.e.a cAk;
    private boolean cLf;
    private View.OnTouchListener cRZ;
    private final o cUG;
    private ScrollFragmentTabHost cUQ;
    private final long cUY;
    private final b cUZ;
    private DataRes.Builder cVb;
    private ar cVe;
    private final com.baidu.tieba.homepage.personalize.model.a cVf;
    private int cVj;
    private int cVl;
    private Runnable cVw;
    private com.baidu.tieba.tbadkCore.data.e cjG;
    private l clw;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a cVa = null;
    private final List<com.baidu.adp.widget.ListView.f> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cRX = false;
    private long cVc = 0;
    private int cVd = 1;
    private int cSb = 0;
    private TextView acI = null;
    private int cmU = 2000;
    private com.baidu.tbadk.l.f cVg = null;
    private boolean clp = false;
    private int ckQ = 0;
    private int bda = 0;
    private boolean mIsBackground = false;
    private boolean cVh = true;
    private boolean cVi = false;
    private boolean cVk = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.e.11
        private int cSc = -1;
        private int cSd = 0;
        private boolean cSe = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.cVg == null) {
                e.this.cVg = new com.baidu.tbadk.l.f();
                e.this.cVg.fi(1005);
                e.this.cVg.pageType = 1;
            }
            if (e.this.aMS != null && !e.this.mIsBackground) {
                e.this.aMS.onScrollStateChanged(absListView, i);
            }
            e.this.cVg.Gg();
            if (i == 0) {
                u.WX().cA(true);
                if (this.cSe) {
                    e.this.aph();
                }
                this.cSe = false;
                if (e.this.clw != null && e.this.cVh) {
                    e.this.clw.a(e.this.ckQ, e.this.bda, e.this.clp, 1);
                }
            } else if (i == 1 && e.this.cVe != null) {
                e.this.cVe.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.cSd > i) {
                this.cSe = true;
            }
            if (e.this.aMS != null && !e.this.mIsBackground) {
                e.this.aMS.a(absListView, this.cSd, i, i2, i3);
            }
            this.cSd = i;
            int i4 = (i + i2) - 1;
            if (!this.cSe && this.cSc != i4) {
                this.cSc = i4;
                e.this.kP(this.cSc);
            }
            if (this.cSe && this.cSc != i) {
                this.cSc = i;
                e.this.kP(this.cSc);
            }
            e.this.cVv = i;
            e.this.ckQ = i;
            e.this.bda = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aMT = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.e.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (e.this.cRZ != null) {
                e.this.cRZ.onTouch(view, motionEvent);
            }
            if (e.this.cAk != null) {
                e.this.cAk.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0080a bWR = new a.InterfaceC0080a() { // from class: com.baidu.tieba.homepage.personalize.e.20
        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ah(int i, int i2) {
            e.this.clp = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0080a
        public void ai(int i, int i2) {
            e.this.clp = false;
        }
    };
    private View.OnClickListener cVm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.e.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.cVe != null) {
                e.this.cVe.hideTip();
            }
            if (e.this.cVd == 1 && e.this.mListView != null) {
                e.this.mListView.setSelection(0);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cVn = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fJ(true);
        }
    };
    private final CustomMessageListener cVo = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE) { // from class: com.baidu.tieba.homepage.personalize.e.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.api();
        }
    };
    private final CustomMessageListener cVp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.homepage.personalize.e.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.fJ(false);
        }
    };
    private final CustomMessageListener cVq = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.e.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mListView != null) {
                e.this.clw.aqF();
                e.this.cVh = false;
                e.this.mListView.completePullRefreshPostDelayed(2000L);
                e.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener cVr = new CustomMessageListener(CmdConfigCustom.CMD_GUIDE_SET_CACHE) { // from class: com.baidu.tieba.homepage.personalize.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.mDataList.size() > 0) {
                if (e.this.mDataList.get(0) instanceof h) {
                    h hVar = (h) e.this.mDataList.get(0);
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    if (hVar.cWL != null) {
                        for (g gVar : hVar.cWL) {
                            if (gVar != null) {
                                TagStruct.Builder builder = new TagStruct.Builder();
                                builder.tag_name = gVar.Vn;
                                builder.selected = Integer.valueOf(gVar.isSelect ? 1 : 0);
                                linkedList.add(builder.build(false));
                            }
                        }
                    }
                    if (hVar.cWM != null) {
                        for (g gVar2 : hVar.cWM) {
                            if (gVar2 != null) {
                                TagStruct.Builder builder2 = new TagStruct.Builder();
                                builder2.tag_name = gVar2.Vn;
                                builder2.selected = Integer.valueOf(gVar2.isSelect ? 1 : 0);
                                linkedList2.add(builder2.build(false));
                            }
                        }
                    }
                    if (e.this.cVb != null) {
                        AgeSexModule.Builder builder3 = new AgeSexModule.Builder();
                        builder3.sex_tag = linkedList;
                        builder3.age_tag = linkedList2;
                        e.this.cVb.age_sex = builder3.build(false);
                    }
                } else if (e.this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f) {
                    com.baidu.tieba.homepage.personalize.data.f fVar = (com.baidu.tieba.homepage.personalize.data.f) e.this.mDataList.get(0);
                    if (fVar.cWI != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (g gVar3 : fVar.cWI) {
                            if (gVar3 != null) {
                                TagStruct.Builder builder4 = new TagStruct.Builder();
                                builder4.tag_name = gVar3.Vn;
                                builder4.selected = Integer.valueOf(gVar3.isSelect ? 1 : 0);
                                linkedList3.add(builder4.build(false));
                            }
                        }
                        e.this.cVb.interestion = linkedList3;
                    }
                }
                e.this.aoF();
            }
        }
    };
    private CustomMessageListener cVs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND) { // from class: com.baidu.tieba.homepage.personalize.e.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<com.baidu.tieba.homepage.b.a.a> list;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && e.this.cVb != null && (list = (List) customResponsedMessage.getData()) != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tieba.homepage.b.a.a aVar : list) {
                    if (aVar != null && aVar.cXl != -1 && aVar.cXl != -2 && !StringUtils.isNull(aVar.cXk)) {
                        SimpleForum.Builder builder = new SimpleForum.Builder();
                        builder.name = aVar.cXk;
                        builder.level_id = Integer.valueOf(aVar.level);
                        arrayList.add(builder.build(true));
                    }
                }
                e.this.cVb.like_forums = arrayList;
                e.this.aoF();
            }
        }
    };
    private CustomMessageListener aoQ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.e.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bl blVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl) && e.this.cVb != null && com.baidu.tbadk.core.util.u.u(e.this.cVb.thread_list) != 0 && (blVar = (bl) customResponsedMessage.getData()) != null && blVar.rv() != null && blVar.getId() != null && com.baidu.tbadk.core.util.u.u(e.this.cVb.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < e.this.cVb.thread_list.size()) {
                        ThreadInfo threadInfo = e.this.cVb.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.d(blVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) blVar.rv().getNum());
                            builder.zan = builder2.build(true);
                            e.this.cVb.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener cVt = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.e.8
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
                    if (e.this.cUG != null) {
                        e.this.cUG.br(new ArrayList(e.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener aqh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.e.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && e.this.cVb != null && !com.baidu.tbadk.core.util.u.v(e.this.cVb.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < e.this.cVb.thread_list.size(); i++) {
                        ThreadInfo threadInfo = e.this.cVb.thread_list.get(i);
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
                            e.this.cVb.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String cVu = "lastReadReadPositionKey";
    private int cVv = 0;
    private d cVx = new d() { // from class: com.baidu.tieba.homepage.personalize.e.12
        @Override // com.baidu.tieba.homepage.personalize.d
        public void kG(final int i) {
            if (e.this.cVw == null) {
                e.this.cVw = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.e.12.1
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
            e.this.mListView.removeCallbacks(e.this.cVw);
            e.this.mListView.post(e.this.cVw);
        }
    };
    private CustomMessageListener cxi = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.e.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && e.this.cVb != null && com.baidu.tbadk.core.util.u.u(e.this.cVb.thread_list) != 0 && com.baidu.tbadk.core.util.u.u(e.this.mDataList) != 0) {
                String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                if (!StringUtils.isNull(optString)) {
                    if (e.this.mListView != null && e.this.mListView.getAdapter() != null) {
                        View childAt = e.this.mListView.getChildAt(e.this.a(optString, e.this.mListView));
                        if (childAt != null) {
                            e.this.ap(childAt);
                        } else if (e.this.cUG != null) {
                            e.this.cUG.br(new ArrayList(e.this.mDataList));
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
                                com.baidu.tieba.homepage.personalize.model.b.bA(e.this.mDataList);
                                break;
                            }
                        }
                    }
                    if (e.this.cVb != null && e.this.cVb.thread_list != null) {
                        long d = com.baidu.adp.lib.g.b.d(optString, 0L);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < e.this.cVb.thread_list.size()) {
                                ThreadInfo threadInfo = e.this.cVb.thread_list.get(i2);
                                if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                                    e.this.cVb.thread_list.remove(i2);
                                    e.this.aoF();
                                    com.baidu.tieba.homepage.personalize.c.d.a(threadInfo.tid.longValue(), i2, e.this.cVb.thread_list, e.this.mDataList);
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
    private CustomMessageListener cxj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.e.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.cVb != null && com.baidu.tbadk.core.util.u.u(e.this.cVb.thread_list) != 0 && com.baidu.tbadk.core.util.u.u(e.this.mDataList) != 0) {
                String str = (String) customResponsedMessage.getData();
                e.this.h(str, e.this.mDataList);
                e.this.lr(str);
                if (e.this.cUG != null) {
                    e.this.cUG.br(new ArrayList(e.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aF(int i, int i2);

        void l(List<com.baidu.tieba.homepage.b.a.a> list, boolean z);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cUQ = scrollFragmentTabHost;
        if (this.cUQ != null) {
            this.cUQ.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.e.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void kO(int i) {
                    if (i != com.baidu.tieba.homepage.framework.indicator.a.cTR && e.this.cVe != null) {
                        e.this.cVe.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eL(boolean z) {
        this.mIsBackground = z;
        if (this.clw != null) {
            this.clw.hx(!z);
            if (z) {
                this.clw.aqF();
            } else if (this.cVh) {
                this.clw.a(this.ckQ, this.bda, this.clp, true);
            }
        }
    }

    public e(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, o oVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aMT);
        this.cAk = new com.baidu.tieba.e.a();
        this.cAk.a(this.bWR);
        this.cUG = oVar;
        this.cVf = new com.baidu.tieba.homepage.personalize.model.a();
        this.cUY = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cVe = new ar();
        apj();
        this.clw = new l(this.mPageContext, this.mListView);
        this.cUZ = new b(this.mDataList, this.cUG);
    }

    private boolean apa() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(apc(), true);
    }

    private void apb() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(apc(), false);
    }

    private String apc() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.cVl = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMS = rVar.Hp();
            this.cRZ = rVar.Hq();
        }
    }

    public void showFloatingView() {
        if (this.aMS != null) {
            this.aMS.cg(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aoK().kF(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aoK().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cVk = true;
        if (this.mDataList.size() == 0 && !this.cRX && !apa()) {
            aoE();
        } else {
            aoC();
        }
    }

    public void aG(int i, int i2) {
        bl blVar;
        if (!com.baidu.tbadk.core.util.u.v(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bl.Zg.getId() && (blVar = (bl) this.mDataList.get(i)) != null && blVar.rX() != null) {
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

    public void apd() {
        if (this.clw != null && !this.mIsBackground && this.cVh) {
            this.clw.a(this.ckQ, this.bda, this.clp, true);
        }
        if (this.cVi) {
            if (this.cLf) {
                if (fI(false)) {
                    aH(3, this.cSb);
                } else if (this.cVj > 0) {
                    aH(2, this.cSb);
                }
            } else if (!this.cLf && this.cSb == 0) {
                aH(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cVi = false;
            this.cLf = false;
            this.cVj = 0;
            if (this.cVk) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.cVk = false;
        }
    }

    public void MS() {
        if (!xc() && this.cVa != null) {
            apf();
            this.mPn++;
            setIsLoading(true);
            this.cVa.v(this.mPn, (this.cVb == null || this.cVb.thread_list == null) ? 0 : this.cVb.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cVb == null || this.cVb.thread_list == null) ? 0 : this.cVb.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.cVi = false;
            if (this.mDataList.size() > 0) {
                if (this.cVa != null) {
                    this.cVa.onError(1, str);
                    return;
                }
                return;
            } else if (this.cVa != null) {
                this.cVa.onError(2, str);
                return;
            } else {
                return;
            }
        }
        apb();
        if (this.cVa != null) {
            this.cVa.onSuccess();
        }
        this.cVi = true;
        this.cLf = z;
        this.cVj = size;
        aoF();
    }

    public void fF(boolean z) {
        if (z) {
            this.cUG.notifyDataSetChanged();
        }
        if (!ape()) {
            aph();
        }
    }

    public void onDestroy() {
        if (this.clw != null) {
            this.clw.destroy();
        }
        if (this.cVg != null) {
            this.cVg.onDestroy();
        }
        if (this.cVe != null) {
            this.cVe.onDestroy();
        }
        if (this.cUZ != null) {
            this.cUZ.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.cVw);
        }
    }

    public void onPause() {
        kQ(this.cVv);
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

    public boolean ape() {
        if (fI(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("close_new_user_guide_tip", false)) {
                fJ(true);
            }
            api();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aoC() {
        if (this.cVa != null) {
            this.cVa.aF((this.cVb == null || this.cVb.thread_list == null || apg()) ? 0 : this.cVb.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cRX = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !apg()) {
                if (this.cVa != null) {
                    this.cVa.onSuccess();
                }
                aph();
                return;
            }
            aoC();
            return;
        }
        aoC();
    }

    private void by(List<com.baidu.adp.widget.ListView.f> list) {
        if (!com.baidu.tbadk.core.util.u.v(list)) {
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) fVar;
                    if (dVar.Xh() != null) {
                        dVar.Xh().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.Xh().advertAppContext.Uo = "NEWINDEX";
                        dVar.Xh().advertAppContext.pn = 1;
                        dVar.Xh().advertAppContext.extensionInfo = dVar.Xh().extensionInfo;
                        dVar.Xh().advertAppContext.Ut = false;
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
        this.cVc = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && apg()) {
            this.cVb = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.cVf.a(z, this.cVb, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.f> list2 = a2.aTU;
            this.cSb = a2.cWO;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            if (z2) {
                by(list);
            }
            a(z2 ? 0 : 1, list, size);
            if (this.cVk) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.cVb == null) {
            this.cVb = builder;
            this.cUZ.bw(this.cVb.thread_list);
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            if (!com.baidu.tbadk.core.util.u.v(dataRes.like_forums)) {
                if (z) {
                    this.cVb.like_forums = dataRes.like_forums;
                }
                for (SimpleForum simpleForum : dataRes.like_forums) {
                    if (simpleForum != null && !StringUtils.isNull(simpleForum.name)) {
                        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
                        aVar.cXk = simpleForum.name;
                        aVar.cXl = simpleForum.id.longValue();
                        aVar.level = simpleForum.level_id.intValue();
                        aVar.isSelected = false;
                        arrayList.add(aVar);
                    }
                }
            }
            if (this.cVa != null) {
                this.cVa.l(b(arrayList, com.baidu.tbadk.util.c.GZ()), z3);
            }
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.cUG.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.cUG.br(linkedList);
            z4 = true;
            if (this.clw != null && this.cVh) {
                this.clw.a(this.ckQ, this.bda, this.clp, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aoK().d(System.currentTimeMillis() - currentTimeMillis, 1);
        long kF = com.baidu.tieba.homepage.framework.a.aoK().kF(1);
        if (kF > 0) {
            com.baidu.tieba.homepage.framework.a.aoK().e(System.currentTimeMillis() - kF, 1);
            com.baidu.tieba.homepage.framework.a.aoK().f(0L, 1);
            return z4;
        }
        return z4;
    }

    private void apf() {
        if (com.baidu.tbadk.core.util.u.u(this.mDataList) >= this.cVf.apr() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.cVf.a(true, this.cVb, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.f> list = a2 != null ? a2.aTU : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.cUG.br(new LinkedList(this.mDataList));
            }
        }
    }

    private List<com.baidu.tieba.homepage.b.a.a> b(List<com.baidu.tieba.homepage.b.a.a> list, String[] strArr) {
        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
        aVar.cXk = "推荐";
        aVar.cXl = -1L;
        aVar.isSelected = false;
        com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
        aVar2.cXk = "发现";
        aVar2.cXl = -2L;
        aVar2.isSelected = false;
        if (strArr == null || strArr.length == 0) {
            list.add(0, aVar);
            list.add(1, aVar2);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (com.baidu.tieba.homepage.b.a.a aVar3 : list) {
                if (aVar3 != null && aVar3.cXk != null && aVar3.cXk.equals(str)) {
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

    private void aoE() {
        com.baidu.tbadk.util.u.a(new t<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.t
            /* renamed from: apl */
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
    public void aoF() {
        if (this.cVb != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cVb.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(String str) {
        if (!TextUtils.isEmpty(str) && this.cVb != null && this.cVb.banner_list != null && this.cVb.banner_list.app != null && this.cVb.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.cVb.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.cVb.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            DataRes.Builder builder2 = new DataRes.Builder(this.cVb.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.5
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                e.this.cUZ.bx(builder2.thread_list);
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

    private boolean apg() {
        return fI(true);
    }

    private boolean fI(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cUY;
    }

    public void a(a aVar) {
        this.cVa = aVar;
    }

    private boolean xc() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aph() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.cVc != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cVc) {
                aH(1, 0);
            }
        }
    }

    private void aH(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.cUQ != null) {
            this.cVe.agH();
        }
        if (this.cUQ != null && this.cUQ.getCurrentItem() != com.baidu.tieba.homepage.framework.indicator.a.cTR) {
            this.cVe.hideTip();
            return;
        }
        this.cVd = i;
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
            if (this.acI == null) {
                this.acI = new TextView(this.mPageContext.getPageActivity());
                this.acI.setGravity(17);
                this.acI.setOnClickListener(this.cVm);
            }
            this.cVe.agH();
            FrameLayout frameLayout = this.cUQ.getFrameLayout();
            if (frameLayout != null && this.acI.getParent() == null) {
                if (i == 1) {
                    if (i.hr()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.f.ds40);
                        this.acI.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.acI.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        ai.j(this.acI, d.g.bg_home_float);
                        ai.i(this.acI, d.e.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.cVl;
                    } else {
                        return;
                    }
                } else {
                    this.acI.setPadding(0, 0, 0, 0);
                    this.acI.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.f.fontsize24));
                    ai.j(this.acI, d.e.common_color_10260);
                    ai.i(this.acI, d.e.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, k.g(TbadkCoreApplication.getInst(), d.f.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.cVl;
                }
                this.acI.setText(str);
                if (i == 1) {
                    this.cmU = 4000;
                } else {
                    this.cmU = 2000;
                }
                this.cVe.a(this.acI, frameLayout, layoutParams, this.cmU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fJ(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("close_new_user_guide_tip", true);
        if (this.cVb != null && this.cVb.age_sex != null) {
            this.cVb.age_sex = null;
            if (z) {
                aoF();
            }
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof h)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cUG.br(new ArrayList(this.mDataList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void api() {
        if (this.cVb != null && this.cVb.interestion != null) {
            this.cVb.interestion = null;
            aoF();
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cUG.br(new ArrayList(this.mDataList));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aoQ != null) {
                this.aoQ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.aoQ);
            }
            if (this.cVn != null) {
                this.cVn.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cVn);
            }
            if (this.cVo != null) {
                this.cVo.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cVo);
            }
            if (this.cVp != null) {
                this.cVp.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cVp);
            }
            if (this.cVq != null) {
                this.cVq.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cVq);
            }
            this.cVr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cVr);
            this.aqh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aqh);
            this.cVt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cVt);
            this.cxi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cxi);
            this.cxj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cxj);
            this.cVs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cVs);
            if (this.clw != null) {
                this.clw.setUniqueId(bdUniqueId);
            }
            this.cUZ.i(bdUniqueId);
        }
    }

    public void apj() {
        this.cjG = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.cjG.bsH();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.f> list, int i2) {
        int i3;
        int i4;
        if (this.cjG != null) {
            if (i == 0) {
                this.cjG.bsH();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gjh;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.cjG.bE(i3, i7 + 1);
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

    public void kP(int i) {
        if ((this.cjG != null ? this.cjG.tp(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.cjG.tq(i);
        }
    }

    public l afW() {
        return this.clw;
    }

    public void fK(boolean z) {
        this.cVh = z;
    }

    public void kQ(final int i) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.personalize.e.10
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.tn().M(e.this.cVu, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(e.this.cVu, Integer.toString(i), 43200000L);
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
            /* renamed from: apm */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.tn().M(e.this.cVu, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    return M.get(e.this.cVu);
                }
                return null;
            }
        }, new com.baidu.tbadk.util.h<String>() { // from class: com.baidu.tieba.homepage.personalize.e.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: ls */
            public void onReturnDataInUI(String str) {
                if (dVar != null) {
                    dVar.kG(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void apk() {
        a(this.cVx);
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
    public void ap(final View view) {
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
                if (e.this.cUG != null) {
                    e.this.cUG.br(new ArrayList(e.this.mDataList));
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).Xh();
                } else {
                    if (next instanceof ah) {
                        ah ahVar = (ah) next;
                        if (ahVar.ql() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ahVar.ql()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.UJ)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
