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
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.p;
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
    private FrameLayout cww;
    private y dru;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private PbListView elw;
    private BdSwipeRefreshLayout enH;
    private FrsGoodFragment gFE;
    private TabLayout gFF;
    private TabLayout gFG;
    private b gFH;
    public String gFJ;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gqy = null;
    private h mPullView = null;
    private BannerView gFI = null;
    private boolean gFK = false;
    private boolean gFL = false;
    private int mCurrentTab = 0;
    private BannerView.a gFM = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMD() {
            a.this.bIH();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aME() {
            a.this.bIJ();
        }
    };
    private CustomMessageListener gFN = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.BC(str);
                a.this.BB(str);
                a.this.gFH.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.gFE = null;
        this.gFE = frsGoodFragment;
        j(view, z);
        this.ds16 = l.getDimens(this.gFE.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.gFE.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.gFE.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bU(view);
        this.gqy = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gqy.setLayoutManager(new LinearLayoutManager(this.gqy.getContext()));
        this.mPullView = new h(this.gFE.getPageContext());
        this.gqy.setFadingEdgeLength(0);
        this.gqy.setOverScrollMode(2);
        this.gqy.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.elw = new PbListView(this.gFE.getPageContext().getPageActivity());
        this.elw.createView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setHeight(l.getDimens(this.gFE.getActivity(), R.dimen.tbds182));
        this.elw.setLineGone();
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gqy.setOnSrollToBottomListener(this.gFE);
        if (this.enH == null) {
            this.enH = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.enH.setProgressView(this.mPullView);
            am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
        }
        this.cww = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gFH = new b(this.gFE, this.gqy);
        hu(false);
        this.gFE.registerListener(this.gFN);
    }

    private void b(y yVar) {
        if (this.gFI == null) {
            this.gFI = new BannerView(this.gFE.getPageContext().getPageActivity());
            this.gFI.setLayoutParams(new AbsListView.LayoutParams(-1, this.gFE.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gFI.setVisibility(8);
            this.gFI.setBannerViewClickListener(this.gFM);
            this.gFI.setBannerData(yVar);
            this.gFI.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.gFI.aMB() && !a.this.gFK && a.this.gqy != null) {
                        a.this.gFK = true;
                        a.this.gqy.addHeaderView(a.this.gFI, 1);
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
    public void bIH() {
        if (this.dru != null) {
            String value = this.dru.getValue();
            if (this.dru.aAH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gFE.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dru.aAH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gFE.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gFE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dru.aAH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daI != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daI) {
                        case FRS:
                            this.gFE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gFE.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gFE.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gFE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aGG().b(this.gFE.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gFE.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dru.aAH() == 4) {
                this.gFE.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gFE.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.gqy.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gFH.a(sVar);
    }

    public void onDestroy() {
        this.gFH.onDestory();
        this.gqy.setOnSrollToBottomListener(null);
        a(this.gFF);
        a(this.gFG);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void hu(boolean z) {
        if (!z) {
            this.enH.setRefreshing(false);
        }
    }

    public void bgz() {
        this.gqy.setVisibility(0);
    }

    public void bEU() {
        if (this.gFH != null) {
            this.gFH.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ad> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.gFE.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ad adVar : good_classify) {
                if (adVar != null && adVar.aAK() > 0 && !TextUtils.isEmpty(adVar.aAJ()) && !TextUtils.isEmpty(adVar.aAJ().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = adVar.aAK();
                    dVar2.name = adVar.aAJ();
                    tabData.add(dVar2);
                }
            }
            if (v.getCount(tabData) > 1) {
                bIL();
                this.gFL = true;
                a(tabData, this.gFF);
                a(tabData, this.gFG);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.gFE.getContext());
                    com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                    dVar.lu(R.color.cp_cont_c);
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
            n nVar = new n();
            arrayList = new ArrayList<>();
            arrayList.add(nVar);
        }
        this.gFH.b(arrayList, frsViewData);
        this.gFL = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.gqy;
    }

    public void bII() {
        this.gFH.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gqy.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gFK && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dru = forumData.getFrsBannerData();
            b(this.dru);
            this.gFI.reset();
            this.gqy.removeHeaderView(this.gFI);
            if (this.dru.getType() == 1 && !TextUtils.isEmpty(this.dru.aAI())) {
                this.gFI.setData(this.gFE.getPageContext(), this.dru.aAI());
                if (this.dru.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gFE.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bIJ() {
        if (this.gFI != null) {
            this.gFK = false;
            this.gqy.removeHeaderView(this.gFI);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gFH != null) {
            this.gFH.bHg();
            this.gFH.notifyDataSetChanged();
            this.gFH.onChangeSkinType(i);
        }
        this.gFE.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gFE.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gFI != null) {
            this.gFI.aMC();
        }
        if (this.elw != null) {
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.changeSkin(i);
        }
        am.setBackgroundColor(this.enH, R.color.cp_bg_line_d);
        b(this.gFF);
        b(this.gFG);
    }

    public void startPullRefresh() {
        this.enH.setRefreshing(true);
    }

    public b bIK() {
        return this.gFH;
    }

    public RelativeLayout bsF() {
        return this.mContainer;
    }

    public View bGg() {
        return this.enH;
    }

    public void bFi() {
        if (com.baidu.tbadk.n.m.aRm().aRn()) {
            int lastVisiblePosition = this.gqy.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gqy.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.grw != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.grw.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.grw.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.grw.startLogPerf();
                    }
                    if (pVar.grv != null && (pVar.grv instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.grv;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDI = true;
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
    public void bds() {
        this.gqy.setNextPage(this.elw);
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.startLoadData();
    }

    public void bdt() {
        this.gqy.setNextPage(this.elw);
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.endLoadData();
        this.elw.setText(this.gFE.getResources().getString(R.string.list_has_no_more));
    }

    public void bdu() {
        this.gqy.setNextPage(null);
    }

    public void lF(boolean z) {
        this.cww.setVisibility(z ? 0 : 8);
        lW(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.gwC.gJC = intValue;
                if (!this.gFL) {
                    this.mCurrentTab = intValue;
                    a(intValue, this.gFG, false);
                    this.gFE.tJ(this.mCurrentTab);
                    r.bvh().kp(false);
                    c.cKb().b(this.gFE.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.enH != null && this.enH.isRefreshing()) {
            this.enH.interruptRefresh();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.gFL && (tab.getTag() instanceof Integer)) {
                this.mCurrentTab = ((Integer) tab.getTag()).intValue();
                this.gFE.tJ(this.mCurrentTab);
            }
            a(tab);
        }
    }

    private void bIL() {
        if (this.gFF == null) {
            this.gFF = (TabLayout) LayoutInflater.from(this.gFE.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.gFF.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.gFE.getContext(), R.dimen.tbds126)));
            this.gFF.setOnTabSelectedListener(this);
            b(this.gFF);
            this.gqy.addHeaderView(this.gFF);
        }
    }

    private void bU(View view) {
        this.gFG = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.gFG.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.gFF, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.enH != null && a.this.enH.isRefreshing()) {
                    a.this.enH.interruptRefresh();
                }
                a.this.b(tab);
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
                                a(tabAt);
                            }
                        } else if (!z) {
                            b(tabAt);
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void lW(boolean z) {
        if (z) {
            this.gFG.setVisibility(8);
        } else if (this.gFG.getTabCount() > 1) {
            this.gFG.setVisibility(0);
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
                            dVar.lu(R.color.cp_cont_c);
                        } else if (aq.isEmpty(this.gFJ)) {
                            dVar.lu(R.color.cp_cont_b);
                        } else {
                            dVar.lv(com.baidu.tieba.lego.card.d.a.cG(this.gFJ));
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
                this.gFJ = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (aq.isEmpty(this.gFJ)) {
                dVar.lu(R.color.cp_cont_b);
            } else {
                dVar.lv(com.baidu.tieba.lego.card.d.a.cG(this.gFJ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).lu(R.color.cp_cont_c);
        }
    }

    public void sm() {
        if (bIK() != null) {
            List<m> dataList = bIK().getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cRh != 0 && biVar.cRg != null) {
                            int[] imageWidthAndHeight = biVar.cRg.getImageWidthAndHeight();
                            biVar.cRh = imageWidthAndHeight[0];
                            biVar.cRi = imageWidthAndHeight[1];
                        }
                    }
                }
                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bIK().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void BB(String str) {
        if (this.gFE.bIE() != null) {
            this.gFE.bIE().BD(str);
        }
    }

    public void BC(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gFH.getDataList())) {
            Iterator<m> it = this.gFH.bIR().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aVx() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVx()).cMX)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
