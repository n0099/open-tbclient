package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.ch;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class o {
    private com.baidu.tbadk.util.s aJs;
    private com.baidu.tieba.play.ac aRC;
    private com.baidu.tieba.e.a aRD;
    private com.baidu.tieba.tbadkCore.data.e bOj;
    private boolean cmr;
    private final long cuE;
    private DataRes.Builder cuG;
    private final com.baidu.tieba.homepage.personalize.b.ad cuL;
    private ch cuM;
    private final com.baidu.tieba.homepage.personalize.model.a cuN;
    private int cuR;
    private int cuT;
    private View.OnTouchListener cuU;
    private ScrollFragmentTabHost cuw;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.g<?> mPageContext;
    private a cuF = null;
    private final List<com.baidu.adp.widget.ListView.v> aSY = new LinkedList();
    private int bxg = 1;
    private boolean mIsLoading = false;
    private boolean cuH = false;
    private long cuI = 0;
    private int cuJ = 1;
    private int cuK = 0;
    private TextView aaK = null;
    private int bRm = 2000;
    public com.baidu.tbadk.j.m cuO = null;
    private boolean aRE = false;
    private int aRG = 0;
    private int aRF = 0;
    private boolean mIsBackground = false;
    private boolean cuP = true;
    private boolean cuQ = false;
    private boolean cuS = false;
    private AbsListView.OnScrollListener mOnScrollListener = new p(this);
    private View.OnTouchListener aJt = new aa(this);
    private a.InterfaceC0059a aRJ = new af(this);
    private View.OnClickListener cuV = new ag(this);
    private final CustomMessageListener cuW = new ah(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cuX = new ai(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cuY = new aj(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cuZ = new ak(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cva = new al(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener cvb = new q(this, CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND);
    private CustomMessageListener amd = new r(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener amZ = new s(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String cvc = "lastReadReadPositionKey";
    private int cvd = 0;
    private n cve = new t(this);
    private CustomMessageListener bYx = new v(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);
    private CustomMessageListener bYy = new w(this, CmdConfigCustom.DELETE_AD_FROM_FEED);

    /* loaded from: classes.dex */
    public interface a {
        void ar(int i, int i2);

        void j(List<com.baidu.tieba.homepage.b.a.a> list, boolean z);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cuw = scrollFragmentTabHost;
        if (this.cuw != null) {
            this.cuw.setOnTabSelectedListener(new x(this));
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void dQ(boolean z) {
        this.mIsBackground = z;
        if (this.aRC != null) {
            this.aRC.gz(!z);
            if (z) {
                this.aRC.ajv();
            } else if (this.cuP) {
                this.aRC.a(this.aRG, this.aRF, this.aRE, true);
            }
        }
    }

    public o(com.baidu.adp.base.g<?> gVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.personalize.b.ad adVar) {
        this.mPageContext = gVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aJt);
        this.aRD = new com.baidu.tieba.e.a();
        this.aRD.a(this.aRJ);
        this.cuL = adVar;
        this.cuN = new com.baidu.tieba.homepage.personalize.model.a();
        this.cuE = com.baidu.tbadk.core.sharedPref.b.tX().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cuM = new ch();
        ahJ();
        this.aRC = new com.baidu.tieba.play.ac(this.mPageContext, this.mListView);
    }

    private boolean ahx() {
        return com.baidu.tbadk.core.sharedPref.b.tX().getBoolean(ahz(), true);
    }

    private void ahy() {
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean(ahz(), false);
    }

    private String ahz() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.cuT = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (tVar != null) {
            this.aJs = tVar.GB();
            this.cuU = tVar.GC();
        }
    }

    public void Xb() {
        if (this.aJs != null) {
            this.aJs.ce(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.ahb().jD(1) == -1) {
            com.baidu.tieba.homepage.framework.a.ahb().e(System.currentTimeMillis(), 1);
        }
        this.bxg = 1;
        this.cuS = true;
        if (this.aSY.size() == 0 && !this.cuH && !ahx()) {
            ahE();
        } else {
            ahC();
        }
    }

    public void ahA() {
        if (this.aRC != null && !this.mIsBackground && this.cuP) {
            this.aRC.a(this.aRG, this.aRF, this.aRE, true);
        }
        if (this.cuQ) {
            if (this.cmr) {
                if (eK(false)) {
                    as(3, this.cuK);
                } else if (this.cuR > 0) {
                    as(2, this.cuK);
                }
            } else if (!this.cmr && this.cuK == 0) {
                as(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.tX().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cuQ = false;
            this.cmr = false;
            this.cuR = 0;
            if (this.cuS) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.cuS = false;
        }
    }

    public void Zs() {
        if (!wu() && this.cuF != null) {
            ahD();
            this.bxg++;
            setIsLoading(true);
            this.cuF.v(this.bxg, (this.cuG == null || this.cuG.thread_list == null) ? 0 : this.cuG.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.tX().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cuG == null || this.cuG.thread_list == null) ? 0 : this.cuG.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.cuQ = false;
            if (this.aSY.size() > 0) {
                if (this.cuF != null) {
                    this.cuF.onError(1, str);
                    return;
                }
                return;
            } else if (this.cuF != null) {
                this.cuF.onError(2, str);
                return;
            } else {
                return;
            }
        }
        ahy();
        if (this.cuF != null) {
            this.cuF.onSuccess();
        }
        this.cuQ = true;
        this.cmr = z;
        this.cuR = size;
        ahF();
    }

    public void eJ(boolean z) {
        if (z) {
            this.cuL.notifyDataSetChanged();
        }
        if (!ahB()) {
            ahH();
        }
    }

    public void onDestroy() {
        if (this.aRC != null) {
            this.aRC.destroy();
        }
        if (this.cuO != null) {
            this.cuO.onDestroy();
        }
        if (this.cuM != null) {
            this.cuM.onDestroy();
        }
    }

    public void onPause() {
        jO(this.cvd);
        jM(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        jM(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void jM(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$17
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean ahB() {
        if (eK(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("close_new_user_guide_tip", false)) {
                eL(true);
            }
            ahI();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void ahC() {
        if (this.cuF != null) {
            this.cuF.ar((this.cuG == null || this.cuG.thread_list == null || ahG()) ? 0 : this.cuG.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cuH = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !ahG()) {
                if (this.cuF != null) {
                    this.cuF.onSuccess();
                }
                ahH();
                return;
            }
            ahC();
            return;
        }
        ahC();
    }

    private void aU(List<com.baidu.adp.widget.ListView.v> list) {
        if (!com.baidu.tbadk.core.util.x.r(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) vVar;
                    if (dVar.TD() != null) {
                        dVar.TD().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.TD().advertAppContext.SR = "NEWINDEX";
                        dVar.TD().advertAppContext.pn = 1;
                        dVar.TD().advertAppContext.extensionInfo = dVar.TD().extensionInfo;
                        dVar.TD().advertAppContext.SW = false;
                    }
                }
            }
        }
    }

    private boolean a(boolean z, boolean z2, boolean z3, DataRes dataRes) {
        List<com.baidu.adp.widget.ListView.v> list;
        boolean z4;
        if (dataRes == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.cuI = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && ahG()) {
            this.cuG = null;
        }
        int size = z2 ? 0 : this.aSY.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.aSY.clear();
        com.baidu.tieba.homepage.personalize.model.d a2 = this.cuN.a(z, this.cuG, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.v> list2 = a2.aQf;
            this.cuK = a2.cwD;
            list = list2;
        }
        if (list != null) {
            this.aSY.addAll(list);
            if (z2) {
                aU(list);
            }
            a(z2 ? 0 : 1, list, size);
            if (this.cuS) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
        }
        if (this.cuG == null) {
            this.cuG = builder;
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            if (!com.baidu.tbadk.core.util.x.r(dataRes.like_forums)) {
                if (z) {
                    this.cuG.like_forums = dataRes.like_forums;
                }
                for (SimpleForum simpleForum : dataRes.like_forums) {
                    if (simpleForum != null && !StringUtils.isNull(simpleForum.name)) {
                        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
                        aVar.cxa = simpleForum.name;
                        aVar.cxb = simpleForum.id.longValue();
                        aVar.level = simpleForum.level_id.intValue();
                        aVar.isSelected = false;
                        arrayList.add(aVar);
                    }
                }
            }
            if (this.cuF != null) {
                this.cuF.j(b(arrayList, com.baidu.tbadk.util.c.Gk()), z3);
            }
        }
        if (this.aSY.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.aSY);
            this.cuL.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.cuL.aV(linkedList);
            z4 = true;
            if (this.aRC != null && this.cuP) {
                this.aRC.a(this.aRG, this.aRF, this.aRE, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.ahb().c(System.currentTimeMillis() - currentTimeMillis, 1);
        long jD = com.baidu.tieba.homepage.framework.a.ahb().jD(1);
        if (jD > 0) {
            com.baidu.tieba.homepage.framework.a.ahb().d(System.currentTimeMillis() - jD, 1);
            com.baidu.tieba.homepage.framework.a.ahb().e(0L, 1);
            return z4;
        }
        return z4;
    }

    private void ahD() {
        if (com.baidu.tbadk.core.util.x.q(this.aSY) >= this.cuN.ahQ() - 40) {
            com.baidu.tieba.homepage.personalize.model.d a2 = this.cuN.a(true, this.cuG, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.aQf : null;
            if (list != null) {
                this.aSY.clear();
                this.aSY.addAll(list);
                this.cuL.aV(new LinkedList(this.aSY));
            }
        }
    }

    private List<com.baidu.tieba.homepage.b.a.a> b(List<com.baidu.tieba.homepage.b.a.a> list, String[] strArr) {
        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
        aVar.cxa = "推荐";
        aVar.cxb = -1L;
        aVar.isSelected = false;
        com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
        aVar2.cxa = "发现";
        aVar2.cxb = -2L;
        aVar2.isSelected = false;
        if (strArr == null || strArr.length == 0) {
            list.add(0, aVar);
            list.add(1, aVar2);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (com.baidu.tieba.homepage.b.a.a aVar3 : list) {
                if (aVar3 != null && aVar3.cxa != null && aVar3.cxa.equals(str)) {
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

    private void ahE() {
        com.baidu.tbadk.util.w.a(new y(this), new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahF() {
        if (this.cuG != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cuG.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM(String str) {
        if (!TextUtils.isEmpty(str) && this.cuG != null && this.cuG.banner_list != null && this.cuG.banner_list.app != null && this.cuG.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.cuG.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.cuG.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            DataRes.Builder builder2 = new DataRes.Builder(this.cuG.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(DataRes.Builder builder) {
        com.baidu.tbadk.util.w.a(new ab(this, builder), null);
    }

    private boolean ahG() {
        return eK(true);
    }

    private boolean eK(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.tX().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cuE;
    }

    public void a(a aVar) {
        this.cuF = aVar;
    }

    private boolean wu() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahH() {
        long j = com.baidu.tbadk.core.sharedPref.b.tX().getLong("recommend_frs_guide_time", 0L);
        if (this.cuI != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cuI) {
                as(1, 0);
            }
        }
    }

    private void as(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.cuw != null) {
            this.cuM.aaf();
        }
        if (this.cuw != null && this.cuw.getCurrentItem() > 0) {
            this.cuM.hideTip();
            return;
        }
        this.cuJ = i;
        String str = null;
        if (i == 1) {
            str = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_guide);
        } else if (i == 2) {
            if (i2 > 0) {
                str = String.format(TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                str = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_nodata);
            }
        } else if (i == 3) {
            str = TbadkCoreApplication.m9getInst().getString(w.l.recommend_frs_refresh_cache_invalid);
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.aaK == null) {
                this.aaK = new TextView(this.mPageContext.getPageActivity());
                this.aaK.setGravity(17);
                this.aaK.setOnClickListener(this.cuV);
            }
            this.cuM.aaf();
            FrameLayout frameLayout = this.cuw.getFrameLayout();
            if (frameLayout != null && this.aaK.getParent() == null) {
                if (i == 1) {
                    if (com.baidu.adp.lib.util.i.hk()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds40);
                        this.aaK.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.aaK.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.tX().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        aq.j(this.aaK, w.g.bg_home_float);
                        aq.i(this.aaK, w.e.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.cuT;
                    } else {
                        return;
                    }
                } else {
                    this.aaK.setPadding(0, 0, 0, 0);
                    this.aaK.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize24));
                    aq.j(this.aaK, w.e.common_color_10260);
                    aq.i(this.aaK, w.e.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.cuT;
                }
                this.aaK.setText(str);
                if (i == 1) {
                    this.bRm = 4000;
                } else {
                    this.bRm = 2000;
                }
                this.cuM.a(this.aaK, frameLayout, layoutParams, this.bRm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("close_new_user_guide_tip", true);
        if (this.cuG != null && this.cuG.age_sex != null) {
            this.cuG.age_sex = null;
            if (z) {
                ahF();
            }
        }
        if (this.aSY != null && this.aSY.size() > 0 && (this.aSY.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.aSY.remove(0);
        }
        if (this.aSY != null) {
            this.cuL.aV(new ArrayList(this.aSY));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahI() {
        if (this.cuG != null && this.cuG.interestion != null) {
            this.cuG.interestion = null;
            ahF();
        }
        if (this.aSY != null && this.aSY.size() > 0 && (this.aSY.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.aSY.remove(0);
        }
        if (this.aSY != null) {
            this.cuL.aV(new ArrayList(this.aSY));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.amd != null) {
                this.amd.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.amd);
            }
            if (this.cuW != null) {
                this.cuW.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cuW);
            }
            if (this.cuX != null) {
                this.cuX.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cuX);
            }
            if (this.cuY != null) {
                this.cuY.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cuY);
            }
            if (this.cuZ != null) {
                this.cuZ.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cuZ);
            }
            this.cva.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cva);
            this.amZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amZ);
            this.bYx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bYx);
            this.bYy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bYy);
            this.cvb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cvb);
            if (this.aRC != null) {
                this.aRC.setUniqueId(bdUniqueId);
            }
        }
    }

    public void ahJ() {
        this.bOj = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.bOj.bgk();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bOj != null) {
            if (i == 0) {
                this.bOj.bgk();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.ftL;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bOj.bk(i3, i7 + 1);
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

    public void jN(int i) {
        if ((this.bOj != null ? this.bOj.rN(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.bOj.rO(i);
        }
    }

    public com.baidu.tieba.play.ac Kq() {
        return this.aRC;
    }

    public void eM(boolean z) {
        this.cuP = z;
    }

    public void jO(int i) {
        com.baidu.tbadk.util.w.a(new ac(this, i), null);
    }

    public void a(n nVar) {
        com.baidu.tbadk.util.w.a(new ad(this), new ae(this, nVar));
    }

    public void ahK() {
        a(this.cve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<com.baidu.adp.widget.ListView.v> list) {
        AdvertAppInfo advertAppInfo;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.v> it = list.iterator();
            AdvertAppInfo advertAppInfo2 = null;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tieba.homepage.personalize.data.a) {
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).TD();
                } else {
                    if (next instanceof com.baidu.tbadk.core.data.ah) {
                        com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) next;
                        if (ahVar.qk() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ahVar.qk()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.Tl)) {
                    advertAppInfo2 = advertAppInfo;
                } else {
                    it.remove();
                    advertAppInfo2 = null;
                }
            }
        }
    }
}
