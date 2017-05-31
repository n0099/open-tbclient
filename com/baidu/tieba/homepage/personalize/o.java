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
import com.baidu.tieba.frs.ci;
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
    private com.baidu.tbadk.util.s aJf;
    private com.baidu.tieba.tbadkCore.data.e bTW;
    private com.baidu.tieba.play.ac bVJ;
    private ScrollFragmentTabHost cAO;
    private final long cAW;
    private DataRes.Builder cAY;
    private final com.baidu.tieba.homepage.personalize.b.af cBd;
    private ci cBe;
    private final com.baidu.tieba.homepage.personalize.model.a cBf;
    private int cBj;
    private int cBl;
    private View.OnTouchListener cBm;
    private com.baidu.tieba.e.a chV;
    private boolean csP;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.g<?> mPageContext;
    private a cAX = null;
    private final List<com.baidu.adp.widget.ListView.v> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cAZ = false;
    private long cBa = 0;
    private int cBb = 1;
    private int cBc = 0;
    private TextView aaJ = null;
    private int bXc = 2000;
    private com.baidu.tbadk.j.m cBg = null;
    private boolean bVC = false;
    private int bVc = 0;
    private int bVd = 0;
    private boolean mIsBackground = false;
    private boolean cBh = true;
    private boolean cBi = false;
    private boolean cBk = false;
    private AbsListView.OnScrollListener mOnScrollListener = new p(this);
    private View.OnTouchListener aJg = new aa(this);
    private a.InterfaceC0059a bwT = new af(this);
    private View.OnClickListener cBn = new ag(this);
    private final CustomMessageListener cBo = new ah(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cBp = new ai(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cBq = new aj(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cBr = new ak(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cBs = new al(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener cBt = new q(this, CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND);
    private CustomMessageListener alT = new r(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener amV = new s(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String cBu = "lastReadReadPositionKey";
    private int cBv = 0;
    private n cBw = new t(this);
    private CustomMessageListener ceJ = new v(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);
    private CustomMessageListener ceK = new w(this, CmdConfigCustom.DELETE_AD_FROM_FEED);

    /* loaded from: classes.dex */
    public interface a {
        void ar(int i, int i2);

        void j(List<com.baidu.tieba.homepage.b.a.a> list, boolean z);

        void onError(int i, String str);

        void onSuccess();

        void v(int i, int i2, int i3);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cAO = scrollFragmentTabHost;
        if (this.cAO != null) {
            this.cAO.setOnTabSelectedListener(new x(this));
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void eg(boolean z) {
        this.mIsBackground = z;
        if (this.bVJ != null) {
            this.bVJ.gM(!z);
            if (z) {
                this.bVJ.akv();
            } else if (this.cBh) {
                this.bVJ.a(this.bVc, this.bVd, this.bVC, true);
            }
        }
    }

    public o(com.baidu.adp.base.g<?> gVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.personalize.b.af afVar) {
        this.mPageContext = gVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aJg);
        this.chV = new com.baidu.tieba.e.a();
        this.chV.a(this.bwT);
        this.cBd = afVar;
        this.cBf = new com.baidu.tieba.homepage.personalize.model.a();
        this.cAW = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cBe = new ci();
        aiY();
        this.bVJ = new com.baidu.tieba.play.ac(this.mPageContext, this.mListView);
    }

    private boolean aiM() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(aiO(), true);
    }

    private void aiN() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(aiO(), false);
    }

    private String aiO() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.cBl = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (tVar != null) {
            this.aJf = tVar.Gv();
            this.cBm = tVar.Gw();
        }
    }

    public void Ye() {
        if (this.aJf != null) {
            this.aJf.cb(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.aiq().kc(1) == -1) {
            com.baidu.tieba.homepage.framework.a.aiq().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cBk = true;
        if (this.mDataList.size() == 0 && !this.cAZ && !aiM()) {
            aiT();
        } else {
            aiR();
        }
    }

    public void aiP() {
        if (this.bVJ != null && !this.mIsBackground && this.cBh) {
            this.bVJ.a(this.bVc, this.bVd, this.bVC, true);
        }
        if (this.cBi) {
            if (this.csP) {
                if (fa(false)) {
                    as(3, this.cBc);
                } else if (this.cBj > 0) {
                    as(2, this.cBc);
                }
            } else if (!this.csP && this.cBc == 0) {
                as(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cBi = false;
            this.csP = false;
            this.cBj = 0;
            if (this.cBk) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.cBk = false;
        }
    }

    public void LS() {
        if (!wq() && this.cAX != null) {
            aiS();
            this.mPn++;
            setIsLoading(true);
            this.cAX.v(this.mPn, (this.cAY == null || this.cAY.thread_list == null) ? 0 : this.cAY.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cAY == null || this.cAY.thread_list == null) ? 0 : this.cAY.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.cBi = false;
            if (this.mDataList.size() > 0) {
                if (this.cAX != null) {
                    this.cAX.onError(1, str);
                    return;
                }
                return;
            } else if (this.cAX != null) {
                this.cAX.onError(2, str);
                return;
            } else {
                return;
            }
        }
        aiN();
        if (this.cAX != null) {
            this.cAX.onSuccess();
        }
        this.cBi = true;
        this.csP = z;
        this.cBj = size;
        aiU();
    }

    public void eZ(boolean z) {
        if (z) {
            this.cBd.notifyDataSetChanged();
        }
        if (!aiQ()) {
            aiW();
        }
    }

    public void onDestroy() {
        if (this.bVJ != null) {
            this.bVJ.destroy();
        }
        if (this.cBg != null) {
            this.cBg.onDestroy();
        }
        if (this.cBe != null) {
            this.cBe.onDestroy();
        }
    }

    public void onPause() {
        km(this.cBv);
        fW(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        fW(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void fW(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$17
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean aiQ() {
        if (fa(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("close_new_user_guide_tip", false)) {
                fb(true);
            }
            aiX();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aiR() {
        if (this.cAX != null) {
            this.cAX.ar((this.cAY == null || this.cAY.thread_list == null || aiV()) ? 0 : this.cAY.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cAZ = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !aiV()) {
                if (this.cAX != null) {
                    this.cAX.onSuccess();
                }
                aiW();
                return;
            }
            aiR();
            return;
        }
        aiR();
    }

    private void aU(List<com.baidu.adp.widget.ListView.v> list) {
        if (!com.baidu.tbadk.core.util.x.r(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) vVar;
                    if (dVar.UH() != null) {
                        dVar.UH().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.UH().advertAppContext.SE = "NEWINDEX";
                        dVar.UH().advertAppContext.pn = 1;
                        dVar.UH().advertAppContext.extensionInfo = dVar.UH().extensionInfo;
                        dVar.UH().advertAppContext.SJ = false;
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
        this.cBa = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && aiV()) {
            this.cAY = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.d a2 = this.cBf.a(z, this.cAY, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.v> list2 = a2.aQg;
            this.cBc = a2.cCV;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            if (z2) {
                aU(list);
            }
            a(z2 ? 0 : 1, list, size);
            if (this.cBk) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
        }
        if (this.cAY == null) {
            this.cAY = builder;
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            if (!com.baidu.tbadk.core.util.x.r(dataRes.like_forums)) {
                if (z) {
                    this.cAY.like_forums = dataRes.like_forums;
                }
                for (SimpleForum simpleForum : dataRes.like_forums) {
                    if (simpleForum != null && !StringUtils.isNull(simpleForum.name)) {
                        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
                        aVar.cDr = simpleForum.name;
                        aVar.cDs = simpleForum.id.longValue();
                        aVar.level = simpleForum.level_id.intValue();
                        aVar.isSelected = false;
                        arrayList.add(aVar);
                    }
                }
            }
            if (this.cAX != null) {
                this.cAX.j(b(arrayList, com.baidu.tbadk.util.c.Ge()), z3);
            }
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.cBd.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.cBd.aV(linkedList);
            z4 = true;
            if (this.bVJ != null && this.cBh) {
                this.bVJ.a(this.bVc, this.bVd, this.bVC, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.aiq().d(System.currentTimeMillis() - currentTimeMillis, 1);
        long kc = com.baidu.tieba.homepage.framework.a.aiq().kc(1);
        if (kc > 0) {
            com.baidu.tieba.homepage.framework.a.aiq().e(System.currentTimeMillis() - kc, 1);
            com.baidu.tieba.homepage.framework.a.aiq().f(0L, 1);
            return z4;
        }
        return z4;
    }

    private void aiS() {
        if (com.baidu.tbadk.core.util.x.q(this.mDataList) >= this.cBf.ajg() - 40) {
            com.baidu.tieba.homepage.personalize.model.d a2 = this.cBf.a(true, this.cAY, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.aQg : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.cBd.aV(new LinkedList(this.mDataList));
            }
        }
    }

    private List<com.baidu.tieba.homepage.b.a.a> b(List<com.baidu.tieba.homepage.b.a.a> list, String[] strArr) {
        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
        aVar.cDr = "推荐";
        aVar.cDs = -1L;
        aVar.isSelected = false;
        com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
        aVar2.cDr = "发现";
        aVar2.cDs = -2L;
        aVar2.isSelected = false;
        if (strArr == null || strArr.length == 0) {
            list.add(0, aVar);
            list.add(1, aVar2);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (com.baidu.tieba.homepage.b.a.a aVar3 : list) {
                if (aVar3 != null && aVar3.cDr != null && aVar3.cDr.equals(str)) {
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

    private void aiT() {
        com.baidu.tbadk.util.w.a(new y(this), new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiU() {
        if (this.cAY != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cAY.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW(String str) {
        if (!TextUtils.isEmpty(str) && this.cAY != null && this.cAY.banner_list != null && this.cAY.banner_list.app != null && this.cAY.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.cAY.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.cAY.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            DataRes.Builder builder2 = new DataRes.Builder(this.cAY.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(DataRes.Builder builder) {
        com.baidu.tbadk.util.w.a(new ab(this, builder), null);
    }

    private boolean aiV() {
        return fa(true);
    }

    private boolean fa(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cAW;
    }

    public void a(a aVar) {
        this.cAX = aVar;
    }

    private boolean wq() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiW() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.cBa != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cBa) {
                as(1, 0);
            }
        }
    }

    private void as(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.cAO != null) {
            this.cBe.abh();
        }
        if (this.cAO != null && this.cAO.getCurrentItem() > 0) {
            this.cBe.hideTip();
            return;
        }
        this.cBb = i;
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
            if (this.aaJ == null) {
                this.aaJ = new TextView(this.mPageContext.getPageActivity());
                this.aaJ.setGravity(17);
                this.aaJ.setOnClickListener(this.cBn);
            }
            this.cBe.abh();
            FrameLayout frameLayout = this.cAO.getFrameLayout();
            if (frameLayout != null && this.aaJ.getParent() == null) {
                if (i == 1) {
                    if (com.baidu.adp.lib.util.i.hk()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds40);
                        this.aaJ.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.aaJ.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        aq.j(this.aaJ, w.g.bg_home_float);
                        aq.i(this.aaJ, w.e.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.cBl;
                    } else {
                        return;
                    }
                } else {
                    this.aaJ.setPadding(0, 0, 0, 0);
                    this.aaJ.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize24));
                    aq.j(this.aaJ, w.e.common_color_10260);
                    aq.i(this.aaJ, w.e.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.cBl;
                }
                this.aaJ.setText(str);
                if (i == 1) {
                    this.bXc = 4000;
                } else {
                    this.bXc = 2000;
                }
                this.cBe.a(this.aaJ, frameLayout, layoutParams, this.bXc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("close_new_user_guide_tip", true);
        if (this.cAY != null && this.cAY.age_sex != null) {
            this.cAY.age_sex = null;
            if (z) {
                aiU();
            }
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cBd.aV(new ArrayList(this.mDataList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiX() {
        if (this.cAY != null && this.cAY.interestion != null) {
            this.cAY.interestion = null;
            aiU();
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cBd.aV(new ArrayList(this.mDataList));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.alT != null) {
                this.alT.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.alT);
            }
            if (this.cBo != null) {
                this.cBo.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cBo);
            }
            if (this.cBp != null) {
                this.cBp.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cBp);
            }
            if (this.cBq != null) {
                this.cBq.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cBq);
            }
            if (this.cBr != null) {
                this.cBr.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cBr);
            }
            this.cBs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cBs);
            this.amV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amV);
            this.ceJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ceJ);
            this.ceK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ceK);
            this.cBt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cBt);
            if (this.bVJ != null) {
                this.bVJ.setUniqueId(bdUniqueId);
            }
        }
    }

    public void aiY() {
        this.bTW = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.bTW.bhH();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.bTW != null) {
            if (i == 0) {
                this.bTW.bhH();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.fBC;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.bTW.bk(i3, i7 + 1);
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

    public void kl(int i) {
        if ((this.bTW != null ? this.bTW.sj(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.bTW.sk(i);
        }
    }

    public com.baidu.tieba.play.ac aaC() {
        return this.bVJ;
    }

    public void fc(boolean z) {
        this.cBh = z;
    }

    public void km(int i) {
        com.baidu.tbadk.util.w.a(new ac(this, i), null);
    }

    public void a(n nVar) {
        com.baidu.tbadk.util.w.a(new ad(this), new ae(this, nVar));
    }

    public void aiZ() {
        a(this.cBw);
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).UH();
                } else {
                    if (next instanceof com.baidu.tbadk.core.data.ah) {
                        com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) next;
                        if (ahVar.qb() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ahVar.qb()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.SY)) {
                    advertAppInfo2 = advertAppInfo;
                } else {
                    it.remove();
                    advertAppInfo2 = null;
                }
            }
        }
    }
}
