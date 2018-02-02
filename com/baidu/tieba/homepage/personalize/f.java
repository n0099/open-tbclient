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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.i;
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
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.s;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.play.m;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
import tbclient.Personalized.FloatInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes2.dex */
public class f {
    private r bBs;
    private View.OnTouchListener bnj;
    private com.baidu.tieba.tbadkCore.data.e dBz;
    private m dDs;
    private com.baidu.tieba.e.a dSp;
    private boolean eaa;
    private final l eeE;
    private final long eeW;
    private final c eeX;
    private DataRes.Builder eeZ;
    private ScrollFragmentTabHost eer;
    private int eeu;
    private au efd;
    private final com.baidu.tieba.homepage.personalize.model.a efe;
    private int efi;
    private com.baidu.tieba.homepage.personalize.data.g efk;
    private Runnable efs;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a eeY = null;
    private final List<i> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean ebL = false;
    private long efa = 0;
    private int efb = 1;
    private int efc = 0;
    private TextView aQK = null;
    private int dEH = 2000;
    private com.baidu.tbadk.k.f eff = null;
    private boolean dDk = false;
    private int dCL = 0;
    private int bXz = 0;
    private boolean mIsBackground = false;
    private boolean efg = true;
    private boolean efh = false;
    private boolean efj = false;
    private boolean efl = true;
    private FloatInfo efm = null;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.f.12
        private int ebQ = -1;
        private int ebR = 0;
        private boolean ebS = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.eff == null) {
                f.this.eff = new com.baidu.tbadk.k.f();
                f.this.eff.im(1005);
                f.this.eff.pageType = 1;
            }
            if (f.this.bBs != null && !f.this.mIsBackground) {
                f.this.bBs.onScrollStateChanged(absListView, i);
            }
            f.this.eff.Nx();
            if (i == 0) {
                s.akK().dg(true);
                if (this.ebS) {
                    f.this.aBA();
                }
                this.ebS = false;
                if (f.this.dDs != null && f.this.efg) {
                    f.this.dDs.a(f.this.dCL, f.this.bXz, f.this.dDk, 1);
                }
            } else if (i == 1 && f.this.efd != null) {
                f.this.efd.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.ebR > i) {
                this.ebS = true;
            }
            if (f.this.bBs != null && !f.this.mIsBackground) {
                f.this.bBs.a(absListView, this.ebR, i, i2, i3);
            }
            this.ebR = i;
            int i4 = (i + i2) - 1;
            if (!this.ebS && this.ebQ != i4) {
                this.ebQ = i4;
                f.this.oL(this.ebQ);
            }
            if (this.ebS && this.ebQ != i) {
                this.ebQ = i;
                f.this.oL(this.ebQ);
            }
            f.this.efr = i;
            f.this.dCL = i;
            f.this.bXz = (i + i2) - 1;
        }
    };
    private View.OnTouchListener bBt = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.f.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.bnj != null) {
                f.this.bnj.onTouch(view, motionEvent);
            }
            if (f.this.dSp != null) {
                f.this.dSp.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0109a ckU = new a.InterfaceC0109a() { // from class: com.baidu.tieba.homepage.personalize.f.17
        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
            f.this.dDk = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
            f.this.dDk = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }
    };
    private View.OnClickListener efn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.f.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.efd != null) {
                f.this.efd.hideTip();
            }
            if (f.this.efb == 1 && f.this.mListView != null) {
                f.this.mListView.setSelection(0);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener efo = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.mListView != null) {
                f.this.dDs.aCG();
                f.this.efg = false;
                f.this.mListView.completePullRefreshPostDelayed(2000L);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private CustomMessageListener bcf = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && f.this.eeZ != null && v.D(f.this.eeZ.thread_list) != 0 && (bdVar = (bd) customResponsedMessage.getData()) != null && bdVar.yI() != null && bdVar.getId() != null && v.D(f.this.eeZ.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < f.this.eeZ.thread_list.size()) {
                        ThreadInfo threadInfo = f.this.eeZ.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bdVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bdVar.yI().getNum());
                            builder.zan = builder2.build(true);
                            f.this.eeZ.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener efp = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (!v.E(f.this.mDataList) && !v.E(ids) && !v.E(originData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= originData.size()) {
                            break;
                        }
                        if ((originData.get(i2) instanceof bd) && (bdVar = (bd) originData.get(i2)) != null && bdVar.zm() != null && ids.contains(Long.valueOf(bdVar.zm().live_id))) {
                            f.this.mDataList.remove(bdVar);
                        }
                        i = i2 + 1;
                    }
                    if (f.this.eeE != null) {
                        f.this.eeE.am(new ArrayList(f.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && f.this.eeZ != null && !v.E(f.this.eeZ.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < f.this.eeZ.thread_list.size(); i++) {
                        ThreadInfo threadInfo = f.this.eeZ.thread_list.get(i);
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
                            f.this.eeZ.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String efq = "lastReadReadPositionKey";
    private int efr = 0;
    private e eft = new e() { // from class: com.baidu.tieba.homepage.personalize.f.7
        @Override // com.baidu.tieba.homepage.personalize.e
        public void oy(final int i) {
            if (f.this.efs == null) {
                f.this.efs = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.f.7.1
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
            f.this.mListView.removeCallbacks(f.this.efs);
            f.this.mListView.post(f.this.efs);
        }
    };
    private CustomMessageListener dQu = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dQv = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dQw = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && f.this.eeZ != null && v.D(f.this.eeZ.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                f.this.e(str, f.this.mDataList);
                f.this.mv(str);
                if (f.this.eeE != null) {
                    f.this.eeE.am(new ArrayList(f.this.mDataList));
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void N(int i, int i2, int i3);

        void bO(int i, int i2);

        void onError(int i, String str);

        void onSuccess();
    }

    public void gE(boolean z) {
        this.efl = z;
        if (this.efd != null && !z) {
            this.efd.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eer = scrollFragmentTabHost;
        if (this.eer != null) {
            this.eer.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.f.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void oJ(int i) {
                    if (f.this.eer.oI(i) != 1 && f.this.efd != null) {
                        f.this.efd.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fK(boolean z) {
        this.mIsBackground = z;
        if (this.dDs != null) {
            this.dDs.io(!z);
            if (z) {
                this.dDs.aCG();
            } else if (this.efg) {
                this.dDs.c(this.dCL, this.bXz, this.dDk, true);
            }
        }
    }

    public f(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, l lVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.bBt);
        this.dSp = new com.baidu.tieba.e.a();
        this.dSp.a(this.ckU);
        this.eeE = lVar;
        this.efe = new com.baidu.tieba.homepage.personalize.model.a();
        this.eeW = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.efd = new au();
        aBB();
        this.dDs = new m(this.mPageContext, this.mListView);
        this.eeX = new c(this.mDataList, this.eeE);
    }

    private boolean aBt() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aBv(), true);
    }

    private void aBu() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aBv(), false);
    }

    private String aBv() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.eeu = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bBs = sVar.OG();
            this.bnj = sVar.OH();
        }
    }

    public void showFloatingView() {
        if (this.bBs != null) {
            this.bBs.cC(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aAZ().ox(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aAZ().h(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.efj = true;
        if (this.mDataList.size() == 0 && !this.ebL && !aBt()) {
            aAT();
        } else {
            aAR();
        }
    }

    public void bP(int i, int i2) {
        bd bdVar;
        if (!v.E(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bd.aNf.getId() && (bdVar = (bd) this.mDataList.get(i)) != null && bdVar.zm() != null) {
                    arrayList.add(Long.valueOf(bdVar.zm().live_id));
                    arrayList2.add(bdVar);
                }
                i++;
            }
            if (!v.E(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aBw() {
        if (this.dDs != null && !this.mIsBackground && this.efg) {
            this.dDs.c(this.dCL, this.bXz, this.dDk, true);
        }
        if (this.efh) {
            if (this.eaa) {
                if (gF(false)) {
                    bQ(3, this.efc);
                } else if (this.efi > 0) {
                    bQ(2, this.efc);
                }
            } else if (!this.eaa && this.efc == 0) {
                bQ(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.efh = false;
            this.eaa = false;
            this.efi = 0;
            if (this.efj) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.efj = false;
        }
    }

    public void VX() {
        if (!DR() && this.eeY != null) {
            aBy();
            this.mPn++;
            setIsLoading(true);
            this.eeY.N(this.mPn, (this.eeZ == null || this.eeZ.thread_list == null) ? 0 : this.eeZ.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.eeZ == null || this.eeZ.thread_list == null) ? 0 : this.eeZ.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.efh = false;
            if (this.mDataList.size() > 0) {
                if (this.eeY != null) {
                    this.eeY.onError(1, str);
                    return;
                }
                return;
            } else if (this.eeY != null) {
                this.eeY.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aBu();
        if (this.eeY != null) {
            this.eeY.onSuccess();
        }
        this.efh = true;
        this.eaa = z;
        this.efi = size;
        aAU();
    }

    public void gz(boolean z) {
        if (z) {
            this.eeE.notifyDataSetChanged();
        }
        if (!aBx()) {
            aBA();
        }
    }

    public void onDestroy() {
        if (this.dDs != null) {
            this.dDs.destroy();
        }
        if (this.eff != null) {
            this.eff.onDestroy();
        }
        if (this.efd != null) {
            this.efd.onDestroy();
        }
        if (this.eeX != null) {
            this.eeX.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.efs);
        }
    }

    public void onPause() {
        oM(this.efr);
        oK(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        oK(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void oK(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$7
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aBx() {
        if (gF(false)) {
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
            }
            return true;
        }
        return false;
    }

    private void aAR() {
        if (this.eeY != null) {
            this.eeY.bO((this.eeZ == null || this.eeZ.thread_list == null || aBz()) ? 0 : this.eeZ.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.ebL = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aBz()) {
                if (this.eeY != null) {
                    this.eeY.onSuccess();
                }
                aBA();
                return;
            }
            aAR();
            return;
        }
        aAR();
    }

    private void bK(List<i> list) {
        if (!v.E(list)) {
            for (i iVar : list) {
                if (iVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) iVar;
                    if (dVar.akY() != null) {
                        dVar.akY().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.akY().advertAppContext.aIP = "NEWINDEX";
                        dVar.akY().advertAppContext.pn = 1;
                        dVar.akY().advertAppContext.extensionInfo = dVar.akY().extensionInfo;
                        dVar.akY().advertAppContext.aIU = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<i> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.efa = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aBz()) {
            this.eeZ = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.efe.a(z, this.eeZ, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<i> list2 = a2.bLM;
            this.efc = a2.egx;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bK(list);
            a(z2 ? 0 : 1, list, size);
            if (this.efj) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.eeZ == null) {
            this.eeZ = builder;
            this.eeX.bI(this.eeZ.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.efk = new com.baidu.tieba.homepage.personalize.data.g();
                    this.efk.a(dataRes.live_answer);
                    this.eeZ.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.efk = null;
                    this.eeZ.live_answer = null;
                }
                this.efm = dataRes.float_info;
                this.eeZ.float_info = dataRes.float_info;
            }
            if (this.efk != null) {
                this.mDataList.add(0, this.efk);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.eeE.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.eeE.am(linkedList);
            z4 = true;
            if (this.dDs != null && this.efg) {
                this.dDs.c(this.dCL, this.bXz, this.dDk, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aAZ().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long ox = com.baidu.tieba.homepage.framework.a.aAZ().ox(1);
        if (ox > 0) {
            com.baidu.tieba.homepage.framework.a.aAZ().g(System.currentTimeMillis() - ox, 1);
            com.baidu.tieba.homepage.framework.a.aAZ().h(0L, 1);
        }
        if (dataRes != null && dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.p.a.d(dataRes.anti.block_pop_info);
            return z4;
        }
        return z4;
    }

    private void aBy() {
        if (v.D(this.mDataList) >= this.efe.aBK() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.efe.a(true, this.eeZ, (DataRes.Builder) null, 1);
            List<i> list = a2 != null ? a2.bLM : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.eeE.am(new LinkedList(this.mDataList));
            }
        }
    }

    private void aAT() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.f.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aBF */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> L = com.baidu.tbadk.core.c.a.Ax().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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
        }, new h<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.f.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: b */
            public void onReturnDataInUI(DataRes dataRes) {
                f.this.a(dataRes);
            }
        });
    }

    private void aAU() {
        if (this.eeZ != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eeZ.build(true));
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
                        int h = com.baidu.adp.lib.g.b.h(next.pos_name, -1);
                        if (h < 0) {
                            it.remove();
                        } else if (h < i + i2 + 1) {
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
    public void mv(String str) {
        if (!TextUtils.isEmpty(str) && this.eeZ != null && this.eeZ.banner_list != null && this.eeZ.banner_list.app != null && this.eeZ.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.eeZ.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.eeZ.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.eeZ.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.eeZ.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                f.this.eeX.bJ(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.Ax().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aBz() {
        return gF(true);
    }

    private boolean gF(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.eeW;
    }

    public void a(a aVar) {
        this.eeY = aVar;
    }

    private boolean DR() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBA() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.efa != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.efa) {
                bQ(1, 0);
            }
        }
    }

    public void aBp() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.EN() && !StringUtils.isNull(activityPrizeData.EV())) {
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
                    bQ(4, 0);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_feed_text_time", str);
                }
            }
        }
    }

    private void bQ(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.eer != null) {
            this.efd.avy();
        }
        if (this.eer != null && this.eer.getCurrentTabType() != 1) {
            this.efd.hideTip();
        } else if (!this.efl) {
            this.efd.hideTip();
        } else {
            this.efb = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().EV();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.aQK == null) {
                    this.aQK = new TextView(this.mPageContext.getPageActivity());
                    this.aQK.setGravity(17);
                    this.aQK.setOnClickListener(this.efn);
                }
                this.efd.avy();
                FrameLayout frameLayout = this.eer.getFrameLayout();
                if (frameLayout != null && this.aQK.getParent() == null) {
                    if (i == 1) {
                        if (j.oJ()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                            this.aQK.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.aQK.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            aj.s(this.aQK, d.f.bg_home_float);
                            aj.r(this.aQK, d.C0108d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.eeu;
                        } else {
                            return;
                        }
                    } else {
                        this.aQK.setPadding(0, 0, 0, 0);
                        this.aQK.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                        aj.s(this.aQK, d.C0108d.common_color_10260);
                        aj.r(this.aQK, d.C0108d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.eeu;
                    }
                    this.aQK.setText(str);
                    if (i == 1) {
                        this.dEH = 4000;
                    } else if (i == 4) {
                        this.dEH = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        this.dEH = 2000;
                    }
                    this.efd.a(this.aQK, frameLayout, layoutParams, this.dEH);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.eeZ != null && this.eeZ.thread_list != null) {
            List<ThreadInfo> list = this.eeZ.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aAU();
                    a(false, true, false, this.eeZ.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bcf != null) {
                this.bcf.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.bcf);
            }
            if (this.efo != null) {
                this.efo.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.efo);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.efp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.efp);
            this.dQu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dQu);
            this.dQv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dQv);
            this.dQw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dQw);
            if (this.dDs != null) {
                this.dDs.setUniqueId(bdUniqueId);
            }
            this.eeX.h(bdUniqueId);
        }
    }

    public void aBB() {
        this.dBz = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dBz.bvk();
    }

    public void a(int i, List<i> list, int i2) {
        int i3;
        int i4;
        if (this.dBz != null) {
            if (i == 0) {
                this.dBz.bvk();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gYb;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dBz.cL(i3, i7 + 1);
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

    public void oL(int i) {
        if ((this.dBz != null ? this.dBz.vI(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.dBz.vJ(i);
        }
    }

    public m auE() {
        return this.dDs;
    }

    public void gG(boolean z) {
        this.efg = z;
    }

    public void oM(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.Ax().M(f.this.efq, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(f.this.efq, Integer.toString(i), 43200000L);
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
            /* renamed from: aBE */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.Ax().M(f.this.efq, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    return M.get(f.this.efq);
                }
                return null;
            }
        }, new h<String>() { // from class: com.baidu.tieba.homepage.personalize.f.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: mw */
            public void onReturnDataInUI(String str) {
                if (eVar != null) {
                    eVar.oy(com.baidu.adp.lib.g.b.h(str, 0));
                }
            }
        });
    }

    public void aBC() {
        a(this.eft);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eeZ != null && v.D(this.eeZ.thread_list) != 0 && v.D(this.mDataList) != 0) {
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
                        i item = this.mListView.getItem(i);
                        if (item instanceof k) {
                            k kVar = (k) item;
                            if (kVar.VM() != null && kVar.VM().zm() != null && optString2.equals(String.valueOf(kVar.VM().zm().live_id))) {
                                str = kVar.VM().getTid();
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
                int a2 = a(optString, this.mListView);
                if (a2 != -1) {
                    View childAt = this.mListView.getChildAt(a(a2, this.mListView));
                    if (childAt != null) {
                        bV(childAt);
                    } else if (this.eeE != null) {
                        this.eeE.am(new ArrayList(this.mDataList));
                    }
                } else {
                    return;
                }
            }
            Iterator<i> it = this.mDataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                if (next instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) next;
                    if (cVar.VM() != null && cVar.VM().getTid() != null && cVar.VM().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bM(this.mDataList);
                        break;
                    }
                }
            }
            if (this.eeZ != null && this.eeZ.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.eeZ.thread_list.size(); i2++) {
                    ThreadInfo threadInfo = this.eeZ.thread_list.get(i2);
                    if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.eeZ.thread_list.remove(i2);
                        aAU();
                        com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.eeZ.thread_list, this.mDataList);
                        return;
                    }
                }
            }
        }
    }

    private int a(String str, BdTypeListView bdTypeListView) {
        int i = 0;
        int i2 = -1;
        while (true) {
            int i3 = i;
            if (i3 < bdTypeListView.getAdapter().getCount()) {
                i item = bdTypeListView.getItem(i3);
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.VM() != null && cVar.VM().getTid().equals(str)) {
                        i2 = i3;
                    }
                }
                i = i3 + 1;
            } else {
                return i2;
            }
        }
    }

    private int a(int i, BdTypeListView bdTypeListView) {
        return (bdTypeListView.getHeaderViewsCount() + i) - bdTypeListView.getFirstVisiblePosition();
    }

    private void bV(final View view) {
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
                if (f.this.eeE != null) {
                    f.this.eeE.am(new ArrayList(f.this.mDataList));
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, List<i> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<i> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                i next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).akY();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.xB() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.xB()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.aJm)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aBD() {
        return this.efm;
    }
}
