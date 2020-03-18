package com.baidu.tieba.frs.good;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout cwH;
    private y drH;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private PbListView elM;
    private BdSwipeRefreshLayout enY;
    private FrsGoodFragment gGC;
    private TabLayout gGD;
    private TabLayout gGE;
    private b gGF;
    public String gGH;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gri = null;
    private h mPullView = null;
    private BannerView gGG = null;
    private boolean gGI = false;
    private boolean gGJ = false;
    private int mCurrentTab = 0;
    private BannerView.a gGK = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMH() {
            a.this.bIT();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMI() {
            a.this.bIV();
        }
    };
    private CustomMessageListener gGL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.BB(str);
                a.this.BA(str);
                a.this.gGF.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.gGC = null;
        this.gGC = frsGoodFragment;
        j(view, z);
        this.ds16 = l.getDimens(this.gGC.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.gGC.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.gGC.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bU(view);
        this.gri = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gri.setLayoutManager(new LinearLayoutManager(this.gri.getContext()));
        this.mPullView = new h(this.gGC.getPageContext());
        this.gri.setFadingEdgeLength(0);
        this.gri.setOverScrollMode(2);
        this.gri.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.elM = new PbListView(this.gGC.getPageContext().getPageActivity());
        this.elM.createView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setHeight(l.getDimens(this.gGC.getActivity(), R.dimen.tbds182));
        this.elM.setLineGone();
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gri.setOnSrollToBottomListener(this.gGC);
        if (this.enY == null) {
            this.enY = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.enY.setProgressView(this.mPullView);
            am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
        }
        this.cwH = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gGF = new b(this.gGC, this.gri);
        hv(false);
        this.gGC.registerListener(this.gGL);
    }

    private void b(y yVar) {
        if (this.gGG == null) {
            this.gGG = new BannerView(this.gGC.getPageContext().getPageActivity());
            this.gGG.setLayoutParams(new AbsListView.LayoutParams(-1, this.gGC.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gGG.setVisibility(8);
            this.gGG.setBannerViewClickListener(this.gGK);
            this.gGG.setBannerData(yVar);
            this.gGG.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.gGG.aMF() && !a.this.gGI && a.this.gri != null) {
                        a.this.gGI = true;
                        a.this.gri.addHeaderView(a.this.gGG, 1);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void bIT() {
        if (this.drH != null) {
            String value = this.drH.getValue();
            if (this.drH.aAK() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gGC.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.drH.aAK() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gGC.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gGC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.drH.aAK() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daV != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daV) {
                        case FRS:
                            this.gGC.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gGC.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gGC.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gGC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aGK().b(this.gGC.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gGC.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.drH.aAK() == 4) {
                this.gGC.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gGC.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.gri.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gGF.a(sVar);
    }

    public void onDestroy() {
        this.gGF.onDestory();
        this.gri.setOnSrollToBottomListener(null);
        a(this.gGD);
        a(this.gGE);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void hv(boolean z) {
        if (!z) {
            this.enY.setRefreshing(false);
        }
    }

    public void bGr() {
        if (this.enY != null) {
            this.enY.interruptRefresh();
        }
    }

    public void bgE() {
        this.gri.setVisibility(0);
    }

    public void bFe() {
        if (this.gGF != null) {
            this.gGF.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ad> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.gGC.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ad adVar : good_classify) {
                if (adVar != null && adVar.aAN() > 0 && !TextUtils.isEmpty(adVar.aAM()) && !TextUtils.isEmpty(adVar.aAM().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = adVar.aAN();
                    dVar2.name = adVar.aAM();
                    tabData.add(dVar2);
                }
            }
            if (v.getCount(tabData) > 1) {
                bIX();
                this.gGJ = true;
                a(tabData, this.gGD);
                a(tabData, this.gGE);
            }
        }
    }

    private void a(TabData tabData, TabLayout tabLayout) {
        int min = Math.min(tabData.size(), 9);
        if (tabLayout.getTabCount() > min) {
            int tabCount = tabLayout.getTabCount() - min;
            for (int i = 0; i < tabCount; i++) {
                tabLayout.removeTabAt(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        if (linearLayout != null) {
            for (int i2 = 0; i2 < min; i2++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    if (linearLayout.getChildAt(i2) != null) {
                        linearLayout.getChildAt(i2).setPadding(0, 0, 0, 0);
                    }
                }
                TabLayout.Tab tab = tabAt;
                if (!(tab.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.gGC.getContext());
                    com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                    dVar.lw(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(dVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(aq.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.mCurrentTab) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds28, 0, this.ds28, 0);
        }
    }

    public void a(ArrayList<m> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            o oVar = new o();
            arrayList = new ArrayList<>();
            arrayList.add(oVar);
        }
        this.gGF.b(arrayList, frsViewData);
        this.gGJ = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.gri;
    }

    public void bIU() {
        this.gGF.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gri.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gGI && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.drH = forumData.getFrsBannerData();
            b(this.drH);
            this.gGG.reset();
            this.gri.removeHeaderView(this.gGG);
            if (this.drH.getType() == 1 && !TextUtils.isEmpty(this.drH.aAL())) {
                this.gGG.setData(this.gGC.getPageContext(), this.drH.aAL());
                if (this.drH.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gGC.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bIV() {
        if (this.gGG != null) {
            this.gGI = false;
            this.gri.removeHeaderView(this.gGG);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gGF != null) {
            this.gGF.bHv();
            this.gGF.notifyDataSetChanged();
            this.gGF.onChangeSkinType(i);
        }
        this.gGC.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gGC.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gGG != null) {
            this.gGG.aMG();
        }
        if (this.elM != null) {
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.changeSkin(i);
        }
        am.setBackgroundColor(this.enY, R.color.cp_bg_line_d);
        b(this.gGD);
        b(this.gGE);
    }

    public void startPullRefresh() {
        this.enY.setRefreshing(true);
    }

    public b bIW() {
        return this.gGF;
    }

    public RelativeLayout bsL() {
        return this.mContainer;
    }

    public View bGs() {
        return this.enY;
    }

    public void bFs() {
        if (com.baidu.tbadk.n.m.aRq().aRr()) {
            int lastVisiblePosition = this.gri.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gri.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof q)) {
                    q qVar = (q) childAt.getTag();
                    if (qVar.gsg != null) {
                        com.baidu.tbadk.n.h perfLog = qVar.gsg.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDW = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            qVar.gsg.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        qVar.gsg.startLogPerf();
                    }
                    if (qVar.gsf != null && (qVar.gsf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = qVar.gsf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDW = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdx() {
        this.gri.setNextPage(this.elM);
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.startLoadData();
    }

    public void bdy() {
        this.gri.setNextPage(this.elM);
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.endLoadData();
        this.elM.setText(this.gGC.getResources().getString(R.string.list_has_no_more));
    }

    public void bdz() {
        this.gri.setNextPage(null);
    }

    public void lK(boolean z) {
        this.cwH.setVisibility(z ? 0 : 8);
        mb(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.gxl.gKH = intValue;
                if (!this.gGJ) {
                    this.mCurrentTab = intValue;
                    a(intValue, this.gGE, false);
                    this.gGC.tO(this.mCurrentTab);
                    r.bvm().ku(false);
                    c.cKv().b(this.gGC.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.enY != null && this.enY.isRefreshing()) {
            this.enY.interruptRefresh();
        }
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.gGJ && (tab.getTag() instanceof Integer)) {
                this.mCurrentTab = ((Integer) tab.getTag()).intValue();
                this.gGC.tO(this.mCurrentTab);
            }
            setTabColorSelected(tab);
        }
    }

    private void bIX() {
        if (this.gGD == null) {
            this.gGD = (TabLayout) LayoutInflater.from(this.gGC.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.gGD.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.gGC.getContext(), R.dimen.tbds126)));
            this.gGD.setOnTabSelectedListener(this);
            b(this.gGD);
            this.gri.addHeaderView(this.gGD);
        }
    }

    private void bU(View view) {
        this.gGE = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.gGE.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.gGD, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.enY != null && a.this.enY.isRefreshing()) {
                    a.this.enY.interruptRefresh();
                }
                a.this.setTabColorUnSelected(tab);
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, TabLayout tabLayout, boolean z) {
        if (tabLayout != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                    if (tabAt != null && (tabAt.getTag() instanceof Integer)) {
                        if (((Integer) tabAt.getTag()).intValue() == i) {
                            if (z) {
                                tabAt.select();
                            } else {
                                tabLayout.setScrollPosition(i3, 0.0f, true);
                                setTabColorSelected(tabAt);
                            }
                        } else if (!z) {
                            setTabColorUnSelected(tabAt);
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void mb(boolean z) {
        if (z) {
            this.gGE.setVisibility(8);
        } else if (this.gGE.getTabCount() > 1) {
            this.gGE.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            am.setBackgroundColor(tabLayout, R.color.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                        if (!tabAt.isSelected()) {
                            dVar.lw(R.color.cp_cont_c);
                        } else if (aq.isEmpty(this.gGH)) {
                            dVar.lw(R.color.cp_cont_b);
                        } else {
                            dVar.lx(com.baidu.tieba.lego.card.d.a.cF(this.gGH));
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(ThemeColorInfo themeColorInfo) {
        ThemeElement themeElement;
        if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            this.mThemeColorInfo = themeColorInfo;
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = this.mThemeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = this.mThemeColorInfo.night;
            } else {
                themeElement = this.mThemeColorInfo.day;
            }
            if (!aq.isEmpty(themeElement.font_color)) {
                this.gGH = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (aq.isEmpty(this.gGH)) {
                dVar.lw(R.color.cp_cont_b);
            } else {
                dVar.lx(com.baidu.tieba.lego.card.d.a.cF(this.gGH));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).lw(R.color.cp_cont_c);
        }
    }

    public void sr() {
        if (bIW() != null) {
            List<m> dataList = bIW().getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cRu != 0 && biVar.cRt != null) {
                            int[] imageWidthAndHeight = biVar.cRt.getImageWidthAndHeight();
                            biVar.cRu = imageWidthAndHeight[0];
                            biVar.cRv = imageWidthAndHeight[1];
                        }
                    }
                }
                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bIW().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void BA(String str) {
        if (this.gGC.bIQ() != null) {
            this.gGC.bIQ().BC(str);
        }
    }

    public void BB(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gGF.getDataList())) {
            Iterator<m> it = this.gGF.bJd().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aVB() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVB()).cNk)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
