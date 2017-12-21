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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.card.s;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.k;
import com.baidu.tieba.play.m;
import com.squareup.wire.Wire;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes.dex */
public class f {
    private r aNo;
    private View.OnTouchListener ayM;
    private com.baidu.tieba.tbadkCore.data.e cHi;
    private m cIZ;
    private com.baidu.tieba.e.a dbc;
    private boolean dml;
    private ScrollFragmentTabHost dqF;
    private int dqI;
    private final k dqS;
    private Runnable drD;
    private final long drj;
    private final c drk;
    private DataRes.Builder drm;
    private at drq;
    private final com.baidu.tieba.homepage.personalize.model.a drr;
    private int drv;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a drl = null;
    private final List<com.baidu.adp.widget.ListView.f> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean dnX = false;
    private long drn = 0;
    private int dro = 1;
    private int drp = 0;
    private TextView acv = null;
    private int cKG = 2000;
    private com.baidu.tbadk.k.f drs = null;
    private boolean cIR = false;
    private int cIt = 0;
    private int bjZ = 0;
    private boolean mIsBackground = false;
    private boolean drt = true;
    private boolean dru = false;
    private boolean drw = false;
    private boolean drx = true;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.f.12
        private int dod = -1;
        private int doe = 0;
        private boolean dof = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.drs == null) {
                f.this.drs = new com.baidu.tbadk.k.f();
                f.this.drs.fr(1005);
                f.this.drs.pageType = 1;
            }
            if (f.this.aNo != null && !f.this.mIsBackground) {
                f.this.aNo.onScrollStateChanged(absListView, i);
            }
            f.this.drs.Gi();
            if (i == 0) {
                s.abW().cC(true);
                if (this.dof) {
                    f.this.auo();
                }
                this.dof = false;
                if (f.this.cIZ != null && f.this.drt) {
                    f.this.cIZ.a(f.this.cIt, f.this.bjZ, f.this.cIR, 1);
                }
            } else if (i == 1 && f.this.drq != null) {
                f.this.drq.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.doe > i) {
                this.dof = true;
            }
            if (f.this.aNo != null && !f.this.mIsBackground) {
                f.this.aNo.a(absListView, this.doe, i, i2, i3);
            }
            this.doe = i;
            int i4 = (i + i2) - 1;
            if (!this.dof && this.dod != i4) {
                this.dod = i4;
                f.this.mb(this.dod);
            }
            if (this.dof && this.dod != i) {
                this.dod = i;
                f.this.mb(this.dod);
            }
            f.this.drC = i;
            f.this.cIt = i;
            f.this.bjZ = (i + i2) - 1;
        }
    };
    private View.OnTouchListener aNp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.f.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.ayM != null) {
                f.this.ayM.onTouch(view, motionEvent);
            }
            if (f.this.dbc != null) {
                f.this.dbc.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0096a bHQ = new a.InterfaceC0096a() { // from class: com.baidu.tieba.homepage.personalize.f.17
        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ag(int i, int i2) {
            f.this.cIR = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ah(int i, int i2) {
            f.this.cIR = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0096a
        public void ai(int i, int i2) {
        }
    };
    private View.OnClickListener dry = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.f.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.drq != null) {
                f.this.drq.hideTip();
            }
            if (f.this.dro == 1 && f.this.mListView != null) {
                f.this.mListView.setSelection(0);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener drz = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.mListView != null) {
                f.this.cIZ.avu();
                f.this.drt = false;
                f.this.mListView.completePullRefreshPostDelayed(2000L);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private CustomMessageListener anZ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && f.this.drm != null && v.v(f.this.drm.thread_list) != 0 && (bdVar = (bd) customResponsedMessage.getData()) != null && bdVar.rk() != null && bdVar.getId() != null && v.v(f.this.drm.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < f.this.drm.thread_list.size()) {
                        ThreadInfo threadInfo = f.this.drm.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bdVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bdVar.rk().getNum());
                            builder.zan = builder2.build(true);
                            f.this.drm.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener drA = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.w(f.this.mDataList) && !v.w(ids) && !v.w(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bd) && (bdVar = (bd) originData.get(i2)) != null && bdVar.rO() != null && ids.contains(Long.valueOf(bdVar.rO().live_id))) {
                            f.this.mDataList.remove(bdVar);
                        }
                        i = i2 + 1;
                    }
                    if (f.this.dqS != null) {
                        f.this.dqS.ae(new ArrayList(f.this.mDataList));
                    }
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int intValue;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && f.this.drm != null && !v.w(f.this.drm.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < f.this.drm.thread_list.size(); i++) {
                        ThreadInfo threadInfo = f.this.drm.thread_list.get(i);
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
                            f.this.drm.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String drB = "lastReadReadPositionKey";
    private int drC = 0;
    private e drE = new e() { // from class: com.baidu.tieba.homepage.personalize.f.7
        @Override // com.baidu.tieba.homepage.personalize.e
        public void lO(final int i) {
            if (f.this.drD == null) {
                f.this.drD = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.f.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.this.mListView.getHandler() != null) {
                            f.this.mListView.requestFocusFromTouch();
                            if (i <= f.this.mListView.getCount() - 1) {
                                f.this.mListView.setSelection(i);
                            }
                        }
                    }
                };
            }
            f.this.mListView.removeCallbacks(f.this.drD);
            f.this.mListView.post(f.this.drD);
        }
    };
    private CustomMessageListener cYu = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.e(customResponsedMessage);
        }
    };
    private CustomMessageListener cYv = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.e(customResponsedMessage);
        }
    };
    private CustomMessageListener cYw = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && f.this.drm != null && v.v(f.this.drm.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                f.this.e(str, f.this.mDataList);
                f.this.lZ(str);
                if (f.this.dqS != null) {
                    f.this.dqS.ae(new ArrayList(f.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void E(int i, int i2, int i3);

        void aQ(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void fZ(boolean z) {
        this.drx = z;
        if (this.drq != null && !z) {
            this.drq.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dqF = scrollFragmentTabHost;
        if (this.dqF != null) {
            this.dqF.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.f.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void lZ(int i) {
                    if (f.this.dqF.lY(i) != 1 && f.this.drq != null) {
                        f.this.drq.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eX(boolean z) {
        this.mIsBackground = z;
        if (this.cIZ != null) {
            this.cIZ.hJ(!z);
            if (z) {
                this.cIZ.avu();
            } else if (this.drt) {
                this.cIZ.a(this.cIt, this.bjZ, this.cIR, true);
            }
        }
    }

    public f(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, k kVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aNp);
        this.dbc = new com.baidu.tieba.e.a();
        this.dbc.a(this.bHQ);
        this.dqS = kVar;
        this.drr = new com.baidu.tieba.homepage.personalize.model.a();
        this.drj = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.drq = new at();
        aup();
        this.cIZ = new m(this.mPageContext, this.mListView);
        this.drk = new c(this.mDataList, this.dqS);
    }

    private boolean auh() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(auj(), true);
    }

    private void aui() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(auj(), false);
    }

    private String auj() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.dqI = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aNo = sVar.Hr();
            this.ayM = sVar.Hs();
        }
    }

    public void showFloatingView() {
        if (this.aNo != null) {
            this.aNo.ca(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.atP().lN(1) == -1) {
            com.baidu.tieba.homepage.framework.a.atP().h(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.drw = true;
        if (this.mDataList.size() == 0 && !this.dnX && !auh()) {
            atJ();
        } else {
            atG();
        }
    }

    public void aR(int i, int i2) {
        bd bdVar;
        if (!v.w(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bd.YH.getId() && (bdVar = (bd) this.mDataList.get(i)) != null && bdVar.rO() != null) {
                    arrayList.add(Long.valueOf(bdVar.rO().live_id));
                    arrayList2.add(bdVar);
                }
                i++;
            }
            if (!v.w(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void auk() {
        if (this.cIZ != null && !this.mIsBackground && this.drt) {
            this.cIZ.a(this.cIt, this.bjZ, this.cIR, true);
        }
        if (this.dru) {
            if (this.dml) {
                if (ga(false)) {
                    aS(3, this.drp);
                } else if (this.drv > 0) {
                    aS(2, this.drp);
                }
            } else if (!this.dml && this.drp == 0) {
                aS(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.dru = false;
            this.dml = false;
            this.drv = 0;
            if (this.drw) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.drw = false;
        }
    }

    public void OI() {
        if (!wA() && this.drl != null) {
            aum();
            this.mPn++;
            setIsLoading(true);
            this.drl.E(this.mPn, (this.drm == null || this.drm.thread_list == null) ? 0 : this.drm.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.drm == null || this.drm.thread_list == null) ? 0 : this.drm.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.dru = false;
            if (this.mDataList.size() > 0) {
                if (this.drl != null) {
                    this.drl.onError(1, str);
                    return;
                }
                return;
            } else if (this.drl != null) {
                this.drl.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aui();
        if (this.drl != null) {
            this.drl.onSuccess();
        }
        this.dru = true;
        this.dml = z;
        this.drv = size;
        atK();
    }

    public void fU(boolean z) {
        if (z) {
            this.dqS.notifyDataSetChanged();
        }
        if (!aul()) {
            auo();
        }
    }

    public void onDestroy() {
        if (this.cIZ != null) {
            this.cIZ.destroy();
        }
        if (this.drs != null) {
            this.drs.onDestroy();
        }
        if (this.drq != null) {
            this.drq.onDestroy();
        }
        if (this.drk != null) {
            this.drk.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.drD);
        }
    }

    public void onPause() {
        mc(this.drC);
        ma(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        ma(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void ma(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$7
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aul() {
        if (ga(false)) {
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
            }
            return true;
        }
        return false;
    }

    private void atG() {
        if (this.drl != null) {
            this.drl.aQ((this.drm == null || this.drm.thread_list == null || aun()) ? 0 : this.drm.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.dnX = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aun()) {
                if (this.drl != null) {
                    this.drl.onSuccess();
                }
                auo();
                return;
            }
            atG();
            return;
        }
        atG();
    }

    private void bG(List<com.baidu.adp.widget.ListView.f> list) {
        if (!v.w(list)) {
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) fVar;
                    if (dVar.ack() != null) {
                        dVar.ack().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.ack().advertAppContext.Uq = "NEWINDEX";
                        dVar.ack().advertAppContext.pn = 1;
                        dVar.ack().advertAppContext.extensionInfo = dVar.ack().extensionInfo;
                        dVar.ack().advertAppContext.Uv = false;
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
        this.drn = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aun()) {
            this.drm = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.drr.a(z, this.drm, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.f> list2 = a2.aXI;
            this.drp = a2.dsF;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bG(list);
            a(z2 ? 0 : 1, list, size);
            if (this.drw) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.drm == null) {
            this.drm = builder;
            this.drk.bE(this.drm.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.dqS.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.dqS.ae(linkedList);
            z4 = true;
            if (this.cIZ != null && this.drt) {
                this.cIZ.a(this.cIt, this.bjZ, this.cIR, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.atP().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long lN = com.baidu.tieba.homepage.framework.a.atP().lN(1);
        if (lN > 0) {
            com.baidu.tieba.homepage.framework.a.atP().g(System.currentTimeMillis() - lN, 1);
            com.baidu.tieba.homepage.framework.a.atP().h(0L, 1);
            return z4;
        }
        return z4;
    }

    private void aum() {
        if (v.v(this.mDataList) >= this.drr.auw() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.drr.a(true, this.drm, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.f> list = a2 != null ? a2.aXI : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.dqS.ae(new LinkedList(this.mDataList));
            }
        }
    }

    private void atJ() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.f.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aus */
            public DataRes doInBackground() {
                l<byte[]> M = com.baidu.tbadk.core.c.a.td().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        }, new h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.f.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                f.this.a(dataRes);
            }
        });
    }

    private void atK() {
        if (this.drm != null) {
            DataRes.Builder builder = new DataRes.Builder(this.drm.build(true));
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
    public void lZ(String str) {
        if (!TextUtils.isEmpty(str) && this.drm != null && this.drm.banner_list != null && this.drm.banner_list.app != null && this.drm.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.drm.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.drm.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.drm.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.drm.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                f.this.drk.bF(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.td().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aun() {
        return ga(true);
    }

    private boolean ga(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.drj;
    }

    public void a(a aVar) {
        this.drl = aVar;
    }

    private boolean wA() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auo() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.drn != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.drn) {
                aS(1, 0);
            }
        }
    }

    public void aug() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.xv() && !StringUtils.isNull(activityPrizeData.xD())) {
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = "";
            if (!StringUtils.isNull(currentAccount)) {
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("activity_prize_feed_text_time", "");
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
                    aS(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void aS(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.dqF != null) {
            this.drq.amJ();
        }
        if (this.dqF != null && this.dqF.getCurrentTabType() != 1) {
            this.drq.hideTip();
        } else if (!this.drx) {
            this.drq.hideTip();
        } else {
            this.dro = i;
            String str = null;
            if (i == 1) {
                str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_guide);
            } else if (i == 2) {
                if (i2 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_nodata);
                }
            } else if (i == 3) {
                str = TbadkCoreApplication.getInst().getString(d.j.recommend_frs_refresh_cache_invalid);
            } else if (i == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().xD();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.acv == null) {
                    this.acv = new TextView(this.mPageContext.getPageActivity());
                    this.acv.setGravity(17);
                    this.acv.setOnClickListener(this.dry);
                }
                this.drq.amJ();
                FrameLayout frameLayout = this.dqF.getFrameLayout();
                if (frameLayout != null && this.acv.getParent() == null) {
                    if (i == 1) {
                        if (j.hh()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                            this.acv.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.acv.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            aj.j(this.acv, d.f.bg_home_float);
                            aj.i(this.acv, d.C0095d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.dqI;
                        } else {
                            return;
                        }
                    } else {
                        this.acv.setPadding(0, 0, 0, 0);
                        this.acv.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                        aj.j(this.acv, d.C0095d.common_color_10260);
                        aj.i(this.acv, d.C0095d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.dqI;
                    }
                    this.acv.setText(str);
                    if (i == 1) {
                        this.cKG = 4000;
                    } else if (i == 4) {
                        this.cKG = 3000;
                    } else {
                        this.cKG = 2000;
                    }
                    this.drq.a(this.acv, frameLayout, layoutParams, this.cKG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.drm != null && this.drm.thread_list != null) {
            List<ThreadInfo> list = this.drm.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    atK();
                    a(false, true, false, this.drm.build(true));
                    return;
                }
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.anZ != null) {
                this.anZ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.anZ);
            }
            if (this.drz != null) {
                this.drz.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.drz);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.drA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.drA);
            this.cYu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cYu);
            this.cYv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cYv);
            this.cYw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cYw);
            if (this.cIZ != null) {
                this.cIZ.setUniqueId(bdUniqueId);
            }
            this.drk.h(bdUniqueId);
        }
    }

    public void aup() {
        this.cHi = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.cHi.bwx();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.f> list, int i2) {
        int i3;
        int i4;
        if (this.cHi != null) {
            if (i == 0) {
                this.cHi.bwx();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gBu;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.cHi.bV(i3, i7 + 1);
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

    public void mb(int i) {
        if ((this.cHi != null ? this.cHi.ut(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.cHi.uu(i);
        }
    }

    public m alM() {
        return this.cIZ;
    }

    public void gb(boolean z) {
        this.drt = z;
    }

    public void mc(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.td().N(f.this.drB, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(f.this.drB, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(final e eVar) {
        com.baidu.tbadk.util.v.a(new u<String>() { // from class: com.baidu.tieba.homepage.personalize.f.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aur */
            public String doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.td().N(f.this.drB, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    return N.get(f.this.drB);
                }
                return null;
            }
        }, new h<String>() { // from class: com.baidu.tieba.homepage.personalize.f.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: ma */
            public void onReturnDataInUI(String str) {
                if (eVar != null) {
                    eVar.lO(com.baidu.adp.lib.g.b.g(str, 0));
                }
            }
        });
    }

    public void auq() {
        a(this.drE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.drm != null && v.v(this.drm.thread_list) != 0 && v.v(this.mDataList) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.mListView != null && this.mListView.getAdapter() != null && !TextUtils.isEmpty(optString2)) {
                    int i = 0;
                    while (true) {
                        if (i >= this.mListView.getAdapter().getCount()) {
                            str = optString;
                            break;
                        }
                        com.baidu.adp.widget.ListView.f item = this.mListView.getItem(i);
                        if (item instanceof com.baidu.tieba.card.data.k) {
                            com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) item;
                            if (kVar.Ox() != null && kVar.Ox().rO() != null && optString2.equals(String.valueOf(kVar.Ox().rO().live_id))) {
                                str = kVar.Ox().getTid();
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
            if (this.mListView != null && this.mListView.getAdapter() != null) {
                View childAt = this.mListView.getChildAt(a(optString, this.mListView));
                if (childAt != null) {
                    aI(childAt);
                } else if (this.dqS != null) {
                    this.dqS.ae(new ArrayList(this.mDataList));
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
                    if (cVar.Ox() != null && cVar.Ox().getTid() != null && cVar.Ox().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bI(this.mDataList);
                        break;
                    }
                }
            }
            if (this.drm != null && this.drm.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.drm.thread_list.size(); i2++) {
                    ThreadInfo threadInfo = this.drm.thread_list.get(i2);
                    if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.drm.thread_list.remove(i2);
                        atK();
                        com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.drm.thread_list, this.mDataList);
                        return;
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
                if (cVar.Ox() != null && cVar.Ox().getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private void aI(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.homepage.personalize.f.13
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
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.f.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                view.setVisibility(8);
                if (f.this.dqS != null) {
                    f.this.dqS.ae(new ArrayList(f.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, List<com.baidu.adp.widget.ListView.f> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).ack();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.qa() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.qa()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.UN)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }
}
