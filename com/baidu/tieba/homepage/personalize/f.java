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
    private r bBk;
    private View.OnTouchListener bna;
    private com.baidu.tieba.tbadkCore.data.e dBe;
    private m dCX;
    private com.baidu.tieba.e.a dRU;
    private boolean dZF;
    private ScrollFragmentTabHost edW;
    private int edZ;
    private final long eeB;
    private final c eeC;
    private DataRes.Builder eeE;
    private au eeI;
    private final com.baidu.tieba.homepage.personalize.model.a eeJ;
    private int eeN;
    private com.baidu.tieba.homepage.personalize.data.g eeP;
    private Runnable eeX;
    private final l eej;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.e<?> mPageContext;
    private a eeD = null;
    private final List<i> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean ebq = false;
    private long eeF = 0;
    private int eeG = 1;
    private int eeH = 0;
    private TextView aQH = null;
    private int dEm = 2000;
    private com.baidu.tbadk.k.f eeK = null;
    private boolean dCP = false;
    private int dCq = 0;
    private int bXr = 0;
    private boolean mIsBackground = false;
    private boolean eeL = true;
    private boolean eeM = false;
    private boolean eeO = false;
    private boolean eeQ = true;
    private FloatInfo eeR = null;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.homepage.personalize.f.12
        private int ebv = -1;
        private int ebw = 0;
        private boolean ebx = false;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.eeK == null) {
                f.this.eeK = new com.baidu.tbadk.k.f();
                f.this.eeK.im(1005);
                f.this.eeK.pageType = 1;
            }
            if (f.this.bBk != null && !f.this.mIsBackground) {
                f.this.bBk.onScrollStateChanged(absListView, i);
            }
            f.this.eeK.Nv();
            if (i == 0) {
                s.akF().de(true);
                if (this.ebx) {
                    f.this.aBv();
                }
                this.ebx = false;
                if (f.this.dCX != null && f.this.eeL) {
                    f.this.dCX.a(f.this.dCq, f.this.bXr, f.this.dCP, 1);
                }
            } else if (i == 1 && f.this.eeI != null) {
                f.this.eeI.hideTip();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.ebw > i) {
                this.ebx = true;
            }
            if (f.this.bBk != null && !f.this.mIsBackground) {
                f.this.bBk.a(absListView, this.ebw, i, i2, i3);
            }
            this.ebw = i;
            int i4 = (i + i2) - 1;
            if (!this.ebx && this.ebv != i4) {
                this.ebv = i4;
                f.this.oL(this.ebv);
            }
            if (this.ebx && this.ebv != i) {
                this.ebv = i;
                f.this.oL(this.ebv);
            }
            f.this.eeW = i;
            f.this.dCq = i;
            f.this.bXr = (i + i2) - 1;
        }
    };
    private View.OnTouchListener bBl = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.personalize.f.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.bna != null) {
                f.this.bna.onTouch(view, motionEvent);
            }
            if (f.this.dRU != null) {
                f.this.dRU.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0108a ckM = new a.InterfaceC0108a() { // from class: com.baidu.tieba.homepage.personalize.f.17
        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void aY(int i, int i2) {
            f.this.dCP = true;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void aZ(int i, int i2) {
            f.this.dCP = false;
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void ba(int i, int i2) {
        }
    };
    private View.OnClickListener eeS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.f.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.eeI != null) {
                f.this.eeI.hideTip();
            }
            if (f.this.eeG == 1 && f.this.mListView != null) {
                f.this.mListView.setSelection(0);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private final CustomMessageListener eeT = new CustomMessageListener(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.mListView != null) {
                f.this.dCX.aCB();
                f.this.eeL = false;
                f.this.mListView.completePullRefreshPostDelayed(2000L);
                f.this.mListView.startPullRefresh();
            }
        }
    };
    private CustomMessageListener bbX = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tieba.homepage.personalize.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bd bdVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && f.this.eeE != null && v.D(f.this.eeE.thread_list) != 0 && (bdVar = (bd) customResponsedMessage.getData()) != null && bdVar.yH() != null && bdVar.getId() != null && v.D(f.this.eeE.thread_list) != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < f.this.eeE.thread_list.size()) {
                        ThreadInfo threadInfo = f.this.eeE.thread_list.get(i2);
                        if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bdVar.getId(), -1L)) {
                            i = i2 + 1;
                        } else {
                            ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                            Zan.Builder builder2 = new Zan.Builder(builder.zan);
                            builder2.num = Integer.valueOf((int) bdVar.yH().getNum());
                            builder.zan = builder2.build(true);
                            f.this.eeE.thread_list.set(i2, builder.build(true));
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private CustomMessageListener eeU = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED) { // from class: com.baidu.tieba.homepage.personalize.f.4
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
                        if ((originData.get(i2) instanceof bd) && (bdVar = (bd) originData.get(i2)) != null && bdVar.zl() != null && ids.contains(Long.valueOf(bdVar.zl().live_id))) {
                            f.this.mDataList.remove(bdVar);
                        }
                        i = i2 + 1;
                    }
                    if (f.this.eej != null) {
                        f.this.eej.am(new ArrayList(f.this.mDataList));
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
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && f.this.eeE != null && !v.E(f.this.eeE.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    for (int i = 0; i < f.this.eeE.thread_list.size(); i++) {
                        ThreadInfo threadInfo = f.this.eeE.thread_list.get(i);
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
                            f.this.eeE.thread_list.set(i, builder.build(true));
                            return;
                        }
                    }
                }
            }
        }
    };
    private String eeV = "lastReadReadPositionKey";
    private int eeW = 0;
    private e eeY = new e() { // from class: com.baidu.tieba.homepage.personalize.f.7
        @Override // com.baidu.tieba.homepage.personalize.e
        public void oy(final int i) {
            if (f.this.eeX == null) {
                f.this.eeX = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.f.7.1
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
            f.this.mListView.removeCallbacks(f.this.eeX);
            f.this.mListView.post(f.this.eeX);
        }
    };
    private CustomMessageListener dPZ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dQa = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.homepage.personalize.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener dQb = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.homepage.personalize.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && f.this.eeE != null && v.D(f.this.eeE.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                f.this.e(str, f.this.mDataList);
                f.this.mn(str);
                if (f.this.eej != null) {
                    f.this.eej.am(new ArrayList(f.this.mDataList));
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

    public void gB(boolean z) {
        this.eeQ = z;
        if (this.eeI != null && !z) {
            this.eeI.hideTip();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.edW = scrollFragmentTabHost;
        if (this.edW != null) {
            this.edW.setOnTabSelectedListener(new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.personalize.f.1
                @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
                public void oJ(int i) {
                    if (f.this.edW.oI(i) != 1 && f.this.eeI != null) {
                        f.this.eeI.hideTip();
                    }
                }
            });
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void fH(boolean z) {
        this.mIsBackground = z;
        if (this.dCX != null) {
            this.dCX.il(!z);
            if (z) {
                this.dCX.aCB();
            } else if (this.eeL) {
                this.dCX.c(this.dCq, this.bXr, this.dCP, true);
            }
        }
    }

    public f(com.baidu.adp.base.e<?> eVar, BdTypeListView bdTypeListView, l lVar) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.bBl);
        this.dRU = new com.baidu.tieba.e.a();
        this.dRU.a(this.ckM);
        this.eej = lVar;
        this.eeJ = new com.baidu.tieba.homepage.personalize.model.a();
        this.eeB = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.eeI = new au();
        aBw();
        this.dCX = new m(this.mPageContext, this.mListView);
        this.eeC = new c(this.mDataList, this.eej);
    }

    private boolean aBo() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aBq(), true);
    }

    private void aBp() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aBq(), false);
    }

    private String aBq() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.edZ = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bBk = sVar.OE();
            this.bna = sVar.OF();
        }
    }

    public void showFloatingView() {
        if (this.bBk != null) {
            this.bBk.cB(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aAU().ox(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aAU().h(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.eeO = true;
        if (this.mDataList.size() == 0 && !this.ebq && !aBo()) {
            aAO();
        } else {
            aAM();
        }
    }

    public void bP(int i, int i2) {
        bd bdVar;
        if (!v.E(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bd.aNc.getId() && (bdVar = (bd) this.mDataList.get(i)) != null && bdVar.zl() != null) {
                    arrayList.add(Long.valueOf(bdVar.zl().live_id));
                    arrayList2.add(bdVar);
                }
                i++;
            }
            if (!v.E(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void aBr() {
        if (this.dCX != null && !this.mIsBackground && this.eeL) {
            this.dCX.c(this.dCq, this.bXr, this.dCP, true);
        }
        if (this.eeM) {
            if (this.dZF) {
                if (gC(false)) {
                    bQ(3, this.eeH);
                } else if (this.eeN > 0) {
                    bQ(2, this.eeH);
                }
            } else if (!this.dZF && this.eeH == 0) {
                bQ(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.eeM = false;
            this.dZF = false;
            this.eeN = 0;
            if (this.eeO) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
            this.eeO = false;
        }
    }

    public void VV() {
        if (!DP() && this.eeD != null) {
            aBt();
            this.mPn++;
            setIsLoading(true);
            this.eeD.N(this.mPn, (this.eeE == null || this.eeE.thread_list == null) ? 0 : this.eeE.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.eeE == null || this.eeE.thread_list == null) ? 0 : this.eeE.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.eeM = false;
            if (this.mDataList.size() > 0) {
                if (this.eeD != null) {
                    this.eeD.onError(1, str);
                    return;
                }
                return;
            } else if (this.eeD != null) {
                this.eeD.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aBp();
        if (this.eeD != null) {
            this.eeD.onSuccess();
        }
        this.eeM = true;
        this.dZF = z;
        this.eeN = size;
        aAP();
    }

    public void gw(boolean z) {
        if (z) {
            this.eej.notifyDataSetChanged();
        }
        if (!aBs()) {
            aBv();
        }
    }

    public void onDestroy() {
        if (this.dCX != null) {
            this.dCX.destroy();
        }
        if (this.eeK != null) {
            this.eeK.onDestroy();
        }
        if (this.eeI != null) {
            this.eeI.onDestroy();
        }
        if (this.eeC != null) {
            this.eeC.onDestroy();
        }
        if (this.mListView != null) {
            this.mListView.removeCallbacks(this.eeX);
        }
    }

    public void onPause() {
        oM(this.eeW);
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

    public boolean aBs() {
        if (gC(false)) {
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
            }
            return true;
        }
        return false;
    }

    private void aAM() {
        if (this.eeD != null) {
            this.eeD.bO((this.eeE == null || this.eeE.thread_list == null || aBu()) ? 0 : this.eeE.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.ebq = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aBu()) {
                if (this.eeD != null) {
                    this.eeD.onSuccess();
                }
                aBv();
                return;
            }
            aAM();
            return;
        }
        aAM();
    }

    private void bK(List<i> list) {
        if (!v.E(list)) {
            for (i iVar : list) {
                if (iVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) iVar;
                    if (dVar.akT() != null) {
                        dVar.akT().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.akT().advertAppContext.aIM = "NEWINDEX";
                        dVar.akT().advertAppContext.pn = 1;
                        dVar.akT().advertAppContext.extensionInfo = dVar.akT().extensionInfo;
                        dVar.akT().advertAppContext.aIR = false;
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
        this.eeF = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aBu()) {
            this.eeE = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.c a2 = this.eeJ.a(z, this.eeE, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<i> list2 = a2.bLE;
            this.eeH = a2.egc;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            bK(list);
            a(z2 ? 0 : 1, list, size);
            if (this.eeO) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
            }
        }
        if (this.eeE == null) {
            this.eeE = builder;
            this.eeC.bI(this.eeE.thread_list);
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            if (z2) {
                if (dataRes.live_answer != null) {
                    this.eeP = new com.baidu.tieba.homepage.personalize.data.g();
                    this.eeP.a(dataRes.live_answer);
                    this.eeE.live_answer = dataRes.live_answer;
                } else if (z) {
                    this.eeP = null;
                    this.eeE.live_answer = null;
                }
                this.eeR = dataRes.float_info;
                this.eeE.float_info = dataRes.float_info;
            }
            if (this.eeP != null) {
                this.mDataList.add(0, this.eeP);
            }
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.eej.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.eej.am(linkedList);
            z4 = true;
            if (this.dCX != null && this.eeL) {
                this.dCX.c(this.dCq, this.bXr, this.dCP, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aAU().f(System.currentTimeMillis() - currentTimeMillis, 1);
        long ox = com.baidu.tieba.homepage.framework.a.aAU().ox(1);
        if (ox > 0) {
            com.baidu.tieba.homepage.framework.a.aAU().g(System.currentTimeMillis() - ox, 1);
            com.baidu.tieba.homepage.framework.a.aAU().h(0L, 1);
        }
        if (dataRes != null && dataRes.anti != null && dataRes.anti.block_pop_info != null) {
            com.baidu.tieba.p.a.d(dataRes.anti.block_pop_info);
            return z4;
        }
        return z4;
    }

    private void aBt() {
        if (v.D(this.mDataList) >= this.eeJ.aBF() - 40) {
            com.baidu.tieba.homepage.personalize.model.c a2 = this.eeJ.a(true, this.eeE, (DataRes.Builder) null, 1);
            List<i> list = a2 != null ? a2.bLE : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.eej.am(new LinkedList(this.mDataList));
            }
        }
    }

    private void aAO() {
        com.baidu.tbadk.util.v.a(new u<DataRes>() { // from class: com.baidu.tieba.homepage.personalize.f.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aBA */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> L = com.baidu.tbadk.core.c.a.Aw().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
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

    private void aAP() {
        if (this.eeE != null) {
            DataRes.Builder builder = new DataRes.Builder(this.eeE.build(true));
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
    public void mn(String str) {
        if (!TextUtils.isEmpty(str) && this.eeE != null && this.eeE.banner_list != null && this.eeE.banner_list.app != null && this.eeE.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.eeE.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.eeE.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            this.eeE.banner_list = builder.build(false);
            DataRes.Builder builder2 = new DataRes.Builder(this.eeE.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(final DataRes.Builder builder) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                f.this.eeC.bJ(builder2.thread_list);
                try {
                    com.baidu.tbadk.core.c.a.Aw().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).e("0", builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    private boolean aBu() {
        return gC(true);
    }

    private boolean gC(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.eeB;
    }

    public void a(a aVar) {
        this.eeD = aVar;
    }

    private boolean DP() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBv() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.eeF != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.eeF) {
                bQ(1, 0);
            }
        }
    }

    public void aBk() {
        boolean z = true;
        com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
        if (activityPrizeData.EL() && !StringUtils.isNull(activityPrizeData.ET())) {
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
        if (this.edW != null) {
            this.eeI.avt();
        }
        if (this.edW != null && this.edW.getCurrentTabType() != 1) {
            this.eeI.hideTip();
        } else if (!this.eeQ) {
            this.eeI.hideTip();
        } else {
            this.eeG = i;
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
                str = TbadkCoreApplication.getInst().getActivityPrizeData().ET();
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.aQH == null) {
                    this.aQH = new TextView(this.mPageContext.getPageActivity());
                    this.aQH.setGravity(17);
                    this.aQH.setOnClickListener(this.eeS);
                }
                this.eeI.avt();
                FrameLayout frameLayout = this.edW.getFrameLayout();
                if (frameLayout != null && this.aQH.getParent() == null) {
                    if (i == 1) {
                        if (j.oI()) {
                            int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds20);
                            int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds40);
                            this.aQH.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                            this.aQH.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize28));
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                            aj.s(this.aQH, d.f.bg_home_float);
                            aj.r(this.aQH, d.C0107d.cp_link_tip_a);
                            layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 49;
                            layoutParams.topMargin = this.edZ;
                        } else {
                            return;
                        }
                    } else {
                        this.aQH.setPadding(0, 0, 0, 0);
                        this.aQH.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(d.e.fontsize24));
                        aj.s(this.aQH, d.C0107d.common_color_10260);
                        aj.r(this.aQH, d.C0107d.cp_cont_g);
                        layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds56));
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.edZ;
                    }
                    this.aQH.setText(str);
                    if (i == 1) {
                        this.dEm = 4000;
                    } else if (i == 4) {
                        this.dEm = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        this.dEm = 2000;
                    }
                    this.eeI.a(this.aQH, frameLayout, layoutParams, this.dEm);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Long l) {
        if (this.eeE != null && this.eeE.thread_list != null) {
            List<ThreadInfo> list = this.eeE.thread_list;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ThreadInfo threadInfo = list.get(i);
                if (threadInfo.tid.equals(l) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    builder.top_agree_post = null;
                    list.set(i, builder.build(true));
                    aAP();
                    a(false, true, false, this.eeE.build(true));
                    return;
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bbX != null) {
                this.bbX.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.bbX);
            }
            if (this.eeT != null) {
                this.eeT.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.eeT);
            }
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
            this.eeU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eeU);
            this.dPZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dPZ);
            this.dQa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dQa);
            this.dQb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dQb);
            if (this.dCX != null) {
                this.dCX.setUniqueId(bdUniqueId);
            }
            this.eeC.h(bdUniqueId);
        }
    }

    public void aBw() {
        this.dBe = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.dBe.bvi();
    }

    public void a(int i, List<i> list, int i2) {
        int i3;
        int i4;
        if (this.dBe != null) {
            if (i == 0) {
                this.dBe.bvi();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.gXH;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.dBe.cL(i3, i7 + 1);
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
        if ((this.dBe != null ? this.dBe.vI(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.dBe.vJ(i);
        }
    }

    public m auz() {
        return this.dCX;
    }

    public void gD(boolean z) {
        this.eeL = z;
    }

    public void oM(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.personalize.f.6
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.Aw().M(f.this.eeV, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(f.this.eeV, Integer.toString(i), 43200000L);
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
            /* renamed from: aBz */
            public String doInBackground() {
                com.baidu.adp.lib.cache.l<String> M = com.baidu.tbadk.core.c.a.Aw().M(f.this.eeV, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    return M.get(f.this.eeV);
                }
                return null;
            }
        }, new h<String>() { // from class: com.baidu.tieba.homepage.personalize.f.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: mo */
            public void onReturnDataInUI(String str) {
                if (eVar != null) {
                    eVar.oy(com.baidu.adp.lib.g.b.h(str, 0));
                }
            }
        });
    }

    public void aBx() {
        a(this.eeY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.eeE != null && v.D(this.eeE.thread_list) != 0 && v.D(this.mDataList) != 0) {
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
                            if (kVar.VK() != null && kVar.VK().zl() != null && optString2.equals(String.valueOf(kVar.VK().zl().live_id))) {
                                str = kVar.VK().getTid();
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
                    } else if (this.eej != null) {
                        this.eej.am(new ArrayList(this.mDataList));
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
                    if (cVar.VK() != null && cVar.VK().getTid() != null && cVar.VK().getTid().equals(optString)) {
                        it.remove();
                        com.baidu.tieba.homepage.personalize.model.b.bM(this.mDataList);
                        break;
                    }
                }
            }
            if (this.eeE != null && this.eeE.thread_list != null) {
                long c = com.baidu.adp.lib.g.b.c(optString, 0L);
                for (int i2 = 0; i2 < this.eeE.thread_list.size(); i2++) {
                    ThreadInfo threadInfo = this.eeE.thread_list.get(i2);
                    if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                        this.eeE.thread_list.remove(i2);
                        aAP();
                        com.baidu.tieba.homepage.personalize.b.d.a(threadInfo.tid.longValue(), i2, this.eeE.thread_list, this.mDataList);
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
                    if (cVar.VK() != null && cVar.VK().getTid().equals(str)) {
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
                if (f.this.eej != null) {
                    f.this.eej.am(new ArrayList(f.this.mDataList));
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).akT();
                } else {
                    if (next instanceof ab) {
                        ab abVar = (ab) next;
                        if (abVar.xA() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) abVar.xA()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.aJj)) {
                    it.remove();
                    advertAppInfo = null;
                }
                advertAppInfo2 = advertAppInfo;
            }
        }
    }

    public FloatInfo aBy() {
        return this.eeR;
    }
}
