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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.cj;
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
public class x {
    private com.baidu.tbadk.util.t aKu;
    private boolean cAC;
    private ScrollFragmentTabHost cIJ;
    private final long cIS;
    private final e cIT;
    private DataRes.Builder cIV;
    private final com.baidu.tieba.homepage.personalize.b.af cIz;
    private cj cJa;
    private final com.baidu.tieba.homepage.personalize.model.a cJb;
    private int cJf;
    private int cJh;
    private View.OnTouchListener cJi;
    private com.baidu.tieba.tbadkCore.data.e ccf;
    private com.baidu.tieba.play.ac cdS;
    private com.baidu.tieba.e.a cpW;
    private final BdTypeListView mListView;
    private final com.baidu.adp.base.g<?> mPageContext;
    private a cIU = null;
    private final List<com.baidu.adp.widget.ListView.v> mDataList = new LinkedList();
    private int mPn = 1;
    private boolean mIsLoading = false;
    private boolean cIW = false;
    private long cIX = 0;
    private int cIY = 1;
    private int cIZ = 0;
    private TextView aaK = null;
    private int cfl = 2000;
    private com.baidu.tbadk.j.m cJc = null;
    private boolean cdL = false;
    private int cdm = 0;
    private int baJ = 0;
    private boolean mIsBackground = false;
    private boolean cJd = true;
    private boolean cJe = false;
    private boolean cJg = false;
    private AbsListView.OnScrollListener mOnScrollListener = new y(this);
    private View.OnTouchListener aKv = new aj(this);
    private a.InterfaceC0062a bQR = new ar(this);
    private View.OnClickListener cJj = new as(this);
    private final CustomMessageListener cJk = new at(this, CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE);
    private final CustomMessageListener cJl = new au(this, CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE);
    private final CustomMessageListener cJm = new av(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener cJn = new aw(this, CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED);
    private final CustomMessageListener cJo = new ax(this, CmdConfigCustom.CMD_GUIDE_SET_CACHE);
    private CustomMessageListener cJp = new z(this, CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND);
    private CustomMessageListener amL = new aa(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener cJq = new ab(this, CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED);
    private CustomMessageListener anV = new ac(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private String cJr = "lastReadReadPositionKey";
    private int cJs = 0;
    private w cJt = new ad(this);
    private CustomMessageListener cmX = new af(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);
    private CustomMessageListener cmY = new ag(this, CmdConfigCustom.DELETE_AD_FROM_FEED);

    /* loaded from: classes.dex */
    public interface a {
        void ax(int i, int i2);

        void k(List<com.baidu.tieba.homepage.b.a.a> list, boolean z);

        void onError(int i, String str);

        void onSuccess();

        void w(int i, int i2, int i3);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIJ = scrollFragmentTabHost;
        if (this.cIJ != null) {
            this.cIJ.setOnTabSelectedListener(new ah(this));
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ey(boolean z) {
        this.mIsBackground = z;
        if (this.cdS != null) {
            this.cdS.hg(!z);
            if (z) {
                this.cdS.aog();
            } else if (this.cJd) {
                this.cdS.a(this.cdm, this.baJ, this.cdL, true);
            }
        }
    }

    public x(com.baidu.adp.base.g<?> gVar, BdTypeListView bdTypeListView, com.baidu.tieba.homepage.personalize.b.af afVar) {
        this.mPageContext = gVar;
        this.mListView = bdTypeListView;
        this.mListView.setOnTouchListener(this.aKv);
        this.cpW = new com.baidu.tieba.e.a();
        this.cpW.a(this.bQR);
        this.cIz = afVar;
        this.cJb = new com.baidu.tieba.homepage.personalize.model.a();
        this.cIS = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_cache_time", 43200L) * 1000;
        bdTypeListView.setOnScrollListener(this.mOnScrollListener);
        this.cJa = new cj();
        amK();
        this.cdS = new com.baidu.tieba.play.ac(this.mPageContext, this.mListView);
        this.cIT = new e(this.mDataList, this.cIz);
    }

    private boolean amy() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(amA(), true);
    }

    private void amz() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(amA(), false);
    }

    private String amA() {
        return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
    }

    public void setHeaderViewHeight(int i) {
        this.cJh = i;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.u uVar) {
        if (uVar != null) {
            this.aKu = uVar.GS();
            this.cJi = uVar.GT();
        }
    }

    public void showFloatingView() {
        if (this.aKu != null) {
            this.aKu.cd(true);
        }
    }

    public void update() {
        if (com.baidu.tieba.homepage.framework.a.amb().kn(1) == -1) {
            com.baidu.tieba.homepage.framework.a.amb().f(System.currentTimeMillis(), 1);
        }
        this.mPn = 1;
        this.cJg = true;
        if (this.mDataList.size() == 0 && !this.cIW && !amy()) {
            amF();
        } else {
            amD();
        }
    }

    public void ay(int i, int i2) {
        bm bmVar;
        if (!com.baidu.tbadk.core.util.z.t(this.mDataList) && this.mDataList.size() > i) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i < this.mDataList.size() && i <= i2) {
                if (this.mDataList.get(i).getType().getId() == bm.Xs.getId() && (bmVar = (bm) this.mDataList.get(i)) != null && bmVar.rJ() != null) {
                    arrayList.add(Long.valueOf(bmVar.rJ().live_id));
                    arrayList2.add(bmVar);
                }
                i++;
            }
            if (!com.baidu.tbadk.core.util.z.t(arrayList)) {
                MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
            }
        }
    }

    public void amB() {
        if (this.cdS != null && !this.mIsBackground && this.cJd) {
            this.cdS.a(this.cdm, this.baJ, this.cdL, true);
        }
        if (this.cJe) {
            if (this.cAC) {
                if (fr(false)) {
                    az(3, this.cIZ);
                } else if (this.cJf > 0) {
                    az(2, this.cIZ);
                }
            } else if (!this.cAC && this.cIZ == 0) {
                az(2, 0);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_refresh_time", System.currentTimeMillis());
            this.cJe = false;
            this.cAC = false;
            this.cJf = 0;
            if (this.cJg) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
            this.cJg = false;
        }
    }

    public void MG() {
        if (!wI() && this.cIU != null) {
            amE();
            this.mPn++;
            setIsLoading(true);
            this.cIU.w(this.mPn, (this.cIV == null || this.cIV.thread_list == null) ? 0 : this.cIV.thread_list.size(), 0);
        }
    }

    public void a(boolean z, boolean z2, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        this.mListView.completePullRefreshPostDelayed(2000L);
        if (z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
        }
        int size = (this.cIV == null || this.cIV.thread_list == null) ? 0 : this.cIV.thread_list.size();
        if (i != 0 || dataRes == null || !a(true, z, z2, dataRes)) {
            this.cJe = false;
            if (this.mDataList.size() > 0) {
                if (this.cIU != null) {
                    this.cIU.onError(1, str);
                    return;
                }
                return;
            } else if (this.cIU != null) {
                this.cIU.onError(2, str);
                return;
            } else {
                return;
            }
        }
        amz();
        if (this.cIU != null) {
            this.cIU.onSuccess();
        }
        this.cJe = true;
        this.cAC = z;
        this.cJf = size;
        amG();
    }

    public void fq(boolean z) {
        if (z) {
            this.cIz.notifyDataSetChanged();
        }
        if (!amC()) {
            amI();
        }
    }

    public void onDestroy() {
        if (this.cdS != null) {
            this.cdS.destroy();
        }
        if (this.cJc != null) {
            this.cJc.onDestroy();
        }
        if (this.cJa != null) {
            this.cJa.onDestroy();
        }
        if (this.cIT != null) {
            this.cIT.onDestroy();
        }
    }

    public void onPause() {
        kx(this.cJs);
        fY(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL);
    }

    public void onResume() {
        fY(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL);
    }

    private void fY(final int i) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i);
        final BdUniqueId uniqueId = this.mPageContext.getUniqueId();
        customResponsedMessage.setOrginalMessage(new CustomMessage<Object>(i, uniqueId) { // from class: com.baidu.tieba.homepage.personalize.PersonalizedUpdateController$18
        });
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean amC() {
        if (fr(false)) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("close_new_user_guide_tip", false)) {
                fs(true);
            }
            amJ();
            if (this.mListView != null) {
                this.mListView.setSelection(0);
                this.mListView.startPullRefresh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void amD() {
        if (this.cIU != null) {
            this.cIU.ax((this.cIV == null || this.cIV.thread_list == null || amH()) ? 0 : this.cIV.thread_list.size(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.cIW = true;
        if (dataRes != null) {
            if (a(false, true, true, dataRes) && !amH()) {
                if (this.cIU != null) {
                    this.cIU.onSuccess();
                }
                amI();
                return;
            }
            amD();
            return;
        }
        amD();
    }

    private void bf(List<com.baidu.adp.widget.ListView.v> list) {
        if (!com.baidu.tbadk.core.util.z.t(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tieba.card.data.d) {
                    com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) vVar;
                    if (dVar.VY() != null) {
                        dVar.VY().advertAppContext = new com.baidu.tbadk.core.data.b();
                        dVar.VY().advertAppContext.Sz = "NEWINDEX";
                        dVar.VY().advertAppContext.pn = 1;
                        dVar.VY().advertAppContext.extensionInfo = dVar.VY().extensionInfo;
                        dVar.VY().advertAppContext.SE = false;
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
        this.cIX = dataRes.sug_seconds.intValue() * 1000;
        if (z2 && amH()) {
            this.cIV = null;
        }
        int size = z2 ? 0 : this.mDataList.size();
        DataRes.Builder builder = new DataRes.Builder(dataRes);
        this.mDataList.clear();
        com.baidu.tieba.homepage.personalize.model.d a2 = this.cJb.a(z, this.cIV, builder, z2 ? 0 : 1);
        if (a2 == null) {
            list = null;
        } else {
            List<com.baidu.adp.widget.ListView.v> list2 = a2.aRy;
            this.cIZ = a2.cKS;
            list = list2;
        }
        if (list != null) {
            this.mDataList.addAll(list);
            if (z2) {
                bf(list);
            }
            a(z2 ? 0 : 1, list, size);
            if (this.cJg) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEG_FEED_BACK_DISMISS_WINDOW));
            }
        }
        if (this.cIV == null) {
            this.cIV = builder;
            this.cIT.bd(this.cIV.thread_list);
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            if (!com.baidu.tbadk.core.util.z.t(dataRes.like_forums)) {
                if (z) {
                    this.cIV.like_forums = dataRes.like_forums;
                }
                for (SimpleForum simpleForum : dataRes.like_forums) {
                    if (simpleForum != null && !StringUtils.isNull(simpleForum.name)) {
                        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
                        aVar.cLo = simpleForum.name;
                        aVar.cLp = simpleForum.id.longValue();
                        aVar.level = simpleForum.level_id.intValue();
                        aVar.isSelected = false;
                        arrayList.add(aVar);
                    }
                }
            }
            if (this.cIU != null) {
                this.cIU.k(b(arrayList, com.baidu.tbadk.util.c.GB()), z3);
            }
        }
        if (this.mDataList.size() == 0) {
            z4 = false;
        } else {
            LinkedList linkedList = new LinkedList(this.mDataList);
            this.cIz.setFromCDN(dataRes.is_new_url.intValue() == 1);
            this.cIz.bg(linkedList);
            z4 = true;
            if (this.cdS != null && this.cJd) {
                this.cdS.a(this.cdm, this.baJ, this.cdL, true);
            }
        }
        com.baidu.tieba.homepage.framework.a.amb().d(System.currentTimeMillis() - currentTimeMillis, 1);
        long kn = com.baidu.tieba.homepage.framework.a.amb().kn(1);
        if (kn > 0) {
            com.baidu.tieba.homepage.framework.a.amb().e(System.currentTimeMillis() - kn, 1);
            com.baidu.tieba.homepage.framework.a.amb().f(0L, 1);
            return z4;
        }
        return z4;
    }

    private void amE() {
        if (com.baidu.tbadk.core.util.z.s(this.mDataList) >= this.cJb.amR() - 40) {
            com.baidu.tieba.homepage.personalize.model.d a2 = this.cJb.a(true, this.cIV, (DataRes.Builder) null, 1);
            List<com.baidu.adp.widget.ListView.v> list = a2 != null ? a2.aRy : null;
            if (list != null) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                this.cIz.bg(new LinkedList(this.mDataList));
            }
        }
    }

    private List<com.baidu.tieba.homepage.b.a.a> b(List<com.baidu.tieba.homepage.b.a.a> list, String[] strArr) {
        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
        aVar.cLo = "推荐";
        aVar.cLp = -1L;
        aVar.isSelected = false;
        com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
        aVar2.cLo = "发现";
        aVar2.cLp = -2L;
        aVar2.isSelected = false;
        if (strArr == null || strArr.length == 0) {
            list.add(0, aVar);
            list.add(1, aVar2);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (com.baidu.tieba.homepage.b.a.a aVar3 : list) {
                if (aVar3 != null && aVar3.cLo != null && aVar3.cLo.equals(str)) {
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

    private void amF() {
        com.baidu.tbadk.util.x.a(new ai(this), new ak(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amG() {
        if (this.cIV != null) {
            DataRes.Builder builder = new DataRes.Builder(this.cIV.build(true));
            if (builder.thread_list != null && builder.thread_list.size() > 30) {
                builder.thread_list = builder.thread_list.subList(0, 30);
            }
            a(builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU(String str) {
        if (!TextUtils.isEmpty(str) && this.cIV != null && this.cIV.banner_list != null && this.cIV.banner_list.app != null && this.cIV.banner_list.app.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : this.cIV.banner_list.app) {
                if (app != null && str.equals(app.id)) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder = new BannerList.Builder(this.cIV.banner_list);
            if (builder.app != null) {
                builder.app.removeAll(arrayList);
            }
            DataRes.Builder builder2 = new DataRes.Builder(this.cIV.build(true));
            builder2.banner_list = builder.build(true);
            a(builder2);
        }
    }

    private void a(DataRes.Builder builder) {
        com.baidu.tbadk.util.x.a(new al(this, builder), null);
    }

    private boolean amH() {
        return fr(true);
    }

    private boolean fr(boolean z) {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_refresh_time", 0L);
        return j == 0 ? z : Math.abs(System.currentTimeMillis() - j) > this.cIS;
    }

    public void a(a aVar) {
        this.cIU = aVar;
    }

    private boolean wI() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amI() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("recommend_frs_guide_time", 0L);
        if (this.cIX != 0) {
            if (j == 0 || Math.abs(System.currentTimeMillis() - j) > this.cIX) {
                az(1, 0);
            }
        }
    }

    private void az(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.cIJ != null) {
            this.cJa.aeY();
        }
        if (this.cIJ != null && this.cIJ.getCurrentItem() > 0) {
            this.cJa.hideTip();
            return;
        }
        this.cIY = i;
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
                this.aaK.setOnClickListener(this.cJj);
            }
            this.cJa.aeY();
            FrameLayout frameLayout = this.cIJ.getFrameLayout();
            if (frameLayout != null && this.aaK.getParent() == null) {
                if (i == 1) {
                    if (com.baidu.adp.lib.util.i.hj()) {
                        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds20);
                        int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(w.f.ds40);
                        this.aaK.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                        this.aaK.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize28));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("recommend_frs_guide_time", System.currentTimeMillis());
                        com.baidu.tbadk.core.util.as.j(this.aaK, w.g.bg_home_float);
                        com.baidu.tbadk.core.util.as.i(this.aaK, w.e.cp_link_tip_a);
                        layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 49;
                        layoutParams.topMargin = this.cJh;
                    } else {
                        return;
                    }
                } else {
                    this.aaK.setPadding(0, 0, 0, 0);
                    this.aaK.setTextSize(0, this.mPageContext.getResources().getDimensionPixelSize(w.f.fontsize24));
                    com.baidu.tbadk.core.util.as.j(this.aaK, w.e.common_color_10260);
                    com.baidu.tbadk.core.util.as.i(this.aaK, w.e.cp_cont_g);
                    layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds56));
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = this.cJh;
                }
                this.aaK.setText(str);
                if (i == 1) {
                    this.cfl = 4000;
                } else {
                    this.cfl = 2000;
                }
                this.cJa.a(this.aaK, frameLayout, layoutParams, this.cfl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("close_new_user_guide_tip", true);
        if (this.cIV != null && this.cIV.age_sex != null) {
            this.cIV.age_sex = null;
            if (z) {
                amG();
            }
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cIz.bg(new ArrayList(this.mDataList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amJ() {
        if (this.cIV != null && this.cIV.interestion != null) {
            this.cIV.interestion = null;
            amG();
        }
        if (this.mDataList != null && this.mDataList.size() > 0 && (this.mDataList.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f)) {
            this.mDataList.remove(0);
        }
        if (this.mDataList != null) {
            this.cIz.bg(new ArrayList(this.mDataList));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.amL != null) {
                this.amL.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.amL);
            }
            if (this.cJk != null) {
                this.cJk.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cJk);
            }
            if (this.cJl != null) {
                this.cJl.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cJl);
            }
            if (this.cJm != null) {
                this.cJm.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cJm);
            }
            if (this.cJn != null) {
                this.cJn.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.cJn);
            }
            this.cJo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cJo);
            this.anV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anV);
            this.cJq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cJq);
            this.cmX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cmX);
            this.cmY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cmY);
            this.cJp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cJp);
            if (this.cdS != null) {
                this.cdS.setUniqueId(bdUniqueId);
            }
            this.cIT.i(bdUniqueId);
        }
    }

    public void amK() {
        this.ccf = new com.baidu.tieba.tbadkCore.data.e("new_index", null);
        this.ccf.blV();
    }

    public void a(int i, List<com.baidu.adp.widget.ListView.v> list, int i2) {
        int i3;
        int i4;
        if (this.ccf != null) {
            if (i == 0) {
                this.ccf.blV();
            }
            if (list != null && !list.isEmpty()) {
                int[] iArr = com.baidu.tieba.tbadkCore.data.e.fLG;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i7 < list.size() && i6 < iArr.length && (i3 = iArr[i6]) >= 0) {
                    if (list.get(i7) instanceof com.baidu.tieba.card.data.c) {
                        i4 = i5 + 1;
                        if (i4 == i3 - 1) {
                            if (i2 < i7 + 1) {
                                this.ccf.bt(i3, i7 + 1);
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

    public void kw(int i) {
        if ((this.ccf != null ? this.ccf.sC(i) : -1) >= 0 && this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() > i) {
            this.ccf.sD(i);
        }
    }

    public com.baidu.tieba.play.ac aes() {
        return this.cdS;
    }

    public void ft(boolean z) {
        this.cJd = z;
    }

    public void kx(int i) {
        com.baidu.tbadk.util.x.a(new am(this, i), null);
    }

    public void a(w wVar) {
        com.baidu.tbadk.util.x.a(new an(this), new ao(this, wVar));
    }

    public void amL() {
        a(this.cJt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, BdTypeListView bdTypeListView) {
        int headerViewsCount = bdTypeListView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeListView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeListView.getAdapter().getCount(); i2++) {
            com.baidu.adp.widget.ListView.v item = bdTypeListView.getItem(i2);
            if (item instanceof com.baidu.tieba.card.data.c) {
                com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                if (cVar.Mv() != null && cVar.Mv().getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(View view) {
        ap apVar = new ap(this, view.getMeasuredHeight(), view);
        apVar.setAnimationListener(new aq(this, view));
        apVar.setDuration(300L);
        view.startAnimation(apVar);
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
                    advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) next).VY();
                } else {
                    if (next instanceof com.baidu.tbadk.core.data.ai) {
                        com.baidu.tbadk.core.data.ai aiVar = (com.baidu.tbadk.core.data.ai) next;
                        if (aiVar.pY() instanceof AdvertAppInfo.ILegoAdvert) {
                            advertAppInfo = ((AdvertAppInfo.ILegoAdvert) aiVar.pY()).getAdvertAppInfo();
                        }
                    }
                    advertAppInfo = advertAppInfo2;
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.ST)) {
                    advertAppInfo2 = advertAppInfo;
                } else {
                    it.remove();
                    advertAppInfo2 = null;
                }
            }
        }
    }
}
