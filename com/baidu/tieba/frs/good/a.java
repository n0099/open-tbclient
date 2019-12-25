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
import com.baidu.tieba.r.c;
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
/* loaded from: classes6.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout csh;
    private y dmI;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private PbListView egU;
    private BdSwipeRefreshLayout eiv;
    private FrsGoodFragment gAh;
    private TabLayout gAi;
    private TabLayout gAj;
    private b gAk;
    public String gAm;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gkZ = null;
    private h mPullView = null;
    private BannerView gAl = null;
    private boolean gAn = false;
    private boolean gAo = false;
    private int mCurrentTab = 0;
    private BannerView.a gAp = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aJK() {
            a.this.bGb();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aJL() {
            a.this.bGd();
        }
    };
    private CustomMessageListener gAq = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Bb(str);
                a.this.Ba(str);
                a.this.gAk.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.gAh = null;
        this.gAh = frsGoodFragment;
        j(view, z);
        this.ds16 = l.getDimens(this.gAh.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.gAh.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.gAh.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bP(view);
        this.gkZ = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gkZ.setLayoutManager(new LinearLayoutManager(this.gkZ.getContext()));
        this.mPullView = new h(this.gAh.getPageContext());
        this.gkZ.setFadingEdgeLength(0);
        this.gkZ.setOverScrollMode(2);
        this.gkZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.egU = new PbListView(this.gAh.getPageContext().getPageActivity());
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setHeight(l.getDimens(this.gAh.getActivity(), R.dimen.tbds182));
        this.egU.setLineGone();
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gkZ.setOnSrollToBottomListener(this.gAh);
        if (this.eiv == null) {
            this.eiv = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.eiv.setProgressView(this.mPullView);
            am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
        }
        this.csh = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gAk = new b(this.gAh, this.gkZ);
        hi(false);
        this.gAh.registerListener(this.gAq);
    }

    private void b(y yVar) {
        if (this.gAl == null) {
            this.gAl = new BannerView(this.gAh.getPageContext().getPageActivity());
            this.gAl.setLayoutParams(new AbsListView.LayoutParams(-1, this.gAh.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gAl.setVisibility(8);
            this.gAl.setBannerViewClickListener(this.gAp);
            this.gAl.setBannerData(yVar);
            this.gAl.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.gAl.aJI() && !a.this.gAn && a.this.gkZ != null) {
                        a.this.gAn = true;
                        a.this.gkZ.addHeaderView(a.this.gAl, 1);
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
    public void bGb() {
        if (this.dmI != null) {
            String value = this.dmI.getValue();
            if (this.dmI.axY() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gAh.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dmI.axY() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gAh.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gAh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dmI.axY() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.cWt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.cWt) {
                        case FRS:
                            this.gAh.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gAh.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gAh.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gAh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aEa().b(this.gAh.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gAh.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dmI.axY() == 4) {
                this.gAh.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gAh.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.gkZ.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gAk.a(sVar);
    }

    public void onDestroy() {
        this.gAk.onDestory();
        this.gkZ.setOnSrollToBottomListener(null);
        a(this.gAi);
        a(this.gAj);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void hi(boolean z) {
        if (!z) {
            this.eiv.setRefreshing(false);
        }
    }

    public void bdR() {
        this.gkZ.setVisibility(0);
    }

    public void bCm() {
        if (this.gAk != null) {
            this.gAk.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.gAh.gAa) {
            ArrayList<ad> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.gAh.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ad adVar : good_classify) {
                if (adVar != null && adVar.ayb() > 0 && !TextUtils.isEmpty(adVar.aya()) && !TextUtils.isEmpty(adVar.aya().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = adVar.ayb();
                    dVar2.name = adVar.aya();
                    tabData.add(dVar2);
                }
            }
            if (v.getCount(tabData) > 1) {
                bGf();
                this.gAo = true;
                a(tabData, this.gAi);
                a(tabData, this.gAj);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.gAh.getContext());
                    com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                    dVar.ld(R.color.cp_cont_c);
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
        this.gAk.b(arrayList, frsViewData);
        this.gAo = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.gkZ;
    }

    public void bGc() {
        this.gAk.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gkZ.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gAn && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dmI = forumData.getFrsBannerData();
            b(this.dmI);
            this.gAl.reset();
            this.gkZ.removeHeaderView(this.gAl);
            if (this.dmI.getType() == 1 && !TextUtils.isEmpty(this.dmI.axZ())) {
                this.gAl.setData(this.gAh.getPageContext(), this.dmI.axZ());
                if (this.dmI.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gAh.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bGd() {
        if (this.gAl != null) {
            this.gAn = false;
            this.gkZ.removeHeaderView(this.gAl);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAk != null) {
            this.gAk.bEz();
            this.gAk.notifyDataSetChanged();
            this.gAk.onChangeSkinType(i);
        }
        this.gAh.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gAh.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gAl != null) {
            this.gAl.aJJ();
        }
        if (this.egU != null) {
            this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
            this.egU.changeSkin(i);
        }
        am.setBackgroundColor(this.eiv, R.color.cp_bg_line_d);
        b(this.gAi);
        b(this.gAj);
    }

    public void startPullRefresh() {
        this.eiv.setRefreshing(true);
    }

    public b bGe() {
        return this.gAk;
    }

    public RelativeLayout bpX() {
        return this.mContainer;
    }

    public View bDz() {
        return this.eiv;
    }

    public void bCA() {
        if (com.baidu.tbadk.n.m.aOA().aOB()) {
            int lastVisiblePosition = this.gkZ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gkZ.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.glX != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.glX.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dzk = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.glX.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.glX.startLogPerf();
                    }
                    if (pVar.glW != null && (pVar.glW instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.glW;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dzk = true;
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
    public void baF() {
        this.gkZ.setNextPage(this.egU);
        this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.egU.startLoadData();
    }

    public void baG() {
        this.gkZ.setNextPage(this.egU);
        this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.egU.endLoadData();
        this.egU.setText(this.gAh.getResources().getString(R.string.list_has_no_more));
    }

    public void baH() {
        this.gkZ.setNextPage(null);
    }

    public void lr(boolean z) {
        this.csh.setVisibility(z ? 0 : 8);
        lI(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.gre.gEa = intValue;
                if (!this.gAo) {
                    this.mCurrentTab = intValue;
                    a(intValue, this.gAj, false);
                    this.gAh.ty(this.mCurrentTab);
                    r.bsy().kc(false);
                    c.cHo().b(this.gAh.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.eiv != null && this.eiv.isRefreshing()) {
            this.eiv.interruptRefresh();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.gAo && (tab.getTag() instanceof Integer)) {
                this.mCurrentTab = ((Integer) tab.getTag()).intValue();
                this.gAh.ty(this.mCurrentTab);
            }
            a(tab);
        }
    }

    private void bGf() {
        if (this.gAi == null) {
            this.gAi = (TabLayout) LayoutInflater.from(this.gAh.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.gAi.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.gAh.getContext(), R.dimen.tbds126)));
            this.gAi.setOnTabSelectedListener(this);
            b(this.gAi);
            this.gkZ.addHeaderView(this.gAi);
        }
    }

    private void bP(View view) {
        this.gAj = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.gAj.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.gAi, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.eiv != null && a.this.eiv.isRefreshing()) {
                    a.this.eiv.interruptRefresh();
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

    private void lI(boolean z) {
        if (z) {
            this.gAj.setVisibility(8);
        } else if (this.gAj.getTabCount() > 1) {
            this.gAj.setVisibility(0);
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
                            dVar.ld(R.color.cp_cont_c);
                        } else if (aq.isEmpty(this.gAm)) {
                            dVar.ld(R.color.cp_cont_b);
                        } else {
                            dVar.le(com.baidu.tieba.lego.card.d.a.cy(this.gAm));
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
                this.gAm = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (aq.isEmpty(this.gAm)) {
                dVar.ld(R.color.cp_cont_b);
            } else {
                dVar.le(com.baidu.tieba.lego.card.d.a.cy(this.gAm));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).ld(R.color.cp_cont_c);
        }
    }

    public void qZ() {
        if (bGe() != null) {
            List<m> dataList = bGe().getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cMS != 0 && biVar.cMR != null) {
                            int[] imageWidthAndHeight = biVar.cMR.getImageWidthAndHeight();
                            biVar.cMS = imageWidthAndHeight[0];
                            biVar.cMT = imageWidthAndHeight[1];
                        }
                    }
                }
                e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bGe().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Ba(String str) {
        if (this.gAh.bFY() != null) {
            this.gAh.bFY().Bc(str);
        }
    }

    public void Bb(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gAk.getDataList())) {
            Iterator<m> it = this.gAk.bGk().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aSJ() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aSJ()).cIG)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
