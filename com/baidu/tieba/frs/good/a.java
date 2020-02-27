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
    private FrameLayout cwu;
    private y drf;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private PbListView eli;
    private BdSwipeRefreshLayout ens;
    private FrsGoodFragment gFq;
    private TabLayout gFr;
    private TabLayout gFs;
    private b gFt;
    public String gFv;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gqj = null;
    private h mPullView = null;
    private BannerView gFu = null;
    private boolean gFw = false;
    private boolean gFx = false;
    private int mCurrentTab = 0;
    private BannerView.a gFy = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMA() {
            a.this.bIE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMB() {
            a.this.bIG();
        }
    };
    private CustomMessageListener gFz = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.BB(str);
                a.this.BA(str);
                a.this.gFt.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.gFq = null;
        this.gFq = frsGoodFragment;
        j(view, z);
        this.ds16 = l.getDimens(this.gFq.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.gFq.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.gFq.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bU(view);
        this.gqj = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gqj.setLayoutManager(new LinearLayoutManager(this.gqj.getContext()));
        this.mPullView = new h(this.gFq.getPageContext());
        this.gqj.setFadingEdgeLength(0);
        this.gqj.setOverScrollMode(2);
        this.gqj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.eli = new PbListView(this.gFq.getPageContext().getPageActivity());
        this.eli.createView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setHeight(l.getDimens(this.gFq.getActivity(), R.dimen.tbds182));
        this.eli.setLineGone();
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gqj.setOnSrollToBottomListener(this.gFq);
        if (this.ens == null) {
            this.ens = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.ens.setProgressView(this.mPullView);
            am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
        }
        this.cwu = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gFt = new b(this.gFq, this.gqj);
        hu(false);
        this.gFq.registerListener(this.gFz);
    }

    private void b(y yVar) {
        if (this.gFu == null) {
            this.gFu = new BannerView(this.gFq.getPageContext().getPageActivity());
            this.gFu.setLayoutParams(new AbsListView.LayoutParams(-1, this.gFq.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gFu.setVisibility(8);
            this.gFu.setBannerViewClickListener(this.gFy);
            this.gFu.setBannerData(yVar);
            this.gFu.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.gFu.aMy() && !a.this.gFw && a.this.gqj != null) {
                        a.this.gFw = true;
                        a.this.gqj.addHeaderView(a.this.gFu, 1);
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
    public void bIE() {
        if (this.drf != null) {
            String value = this.drf.getValue();
            if (this.drf.aAF() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gFq.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.drf.aAF() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gFq.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gFq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.drf.aAF() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daG != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daG) {
                        case FRS:
                            this.gFq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gFq.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gFq.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gFq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aGE().b(this.gFq.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gFq.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.drf.aAF() == 4) {
                this.gFq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gFq.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.gqj.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gFt.a(sVar);
    }

    public void onDestroy() {
        this.gFt.onDestory();
        this.gqj.setOnSrollToBottomListener(null);
        a(this.gFr);
        a(this.gFs);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void hu(boolean z) {
        if (!z) {
            this.ens.setRefreshing(false);
        }
    }

    public void bgw() {
        this.gqj.setVisibility(0);
    }

    public void bER() {
        if (this.gFt != null) {
            this.gFt.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ad> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.gFq.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ad adVar : good_classify) {
                if (adVar != null && adVar.aAI() > 0 && !TextUtils.isEmpty(adVar.aAH()) && !TextUtils.isEmpty(adVar.aAH().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = adVar.aAI();
                    dVar2.name = adVar.aAH();
                    tabData.add(dVar2);
                }
            }
            if (v.getCount(tabData) > 1) {
                bII();
                this.gFx = true;
                a(tabData, this.gFr);
                a(tabData, this.gFs);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.gFq.getContext());
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
        this.gFt.b(arrayList, frsViewData);
        this.gFx = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.gqj;
    }

    public void bIF() {
        this.gFt.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gqj.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gFw && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.drf = forumData.getFrsBannerData();
            b(this.drf);
            this.gFu.reset();
            this.gqj.removeHeaderView(this.gFu);
            if (this.drf.getType() == 1 && !TextUtils.isEmpty(this.drf.aAG())) {
                this.gFu.setData(this.gFq.getPageContext(), this.drf.aAG());
                if (this.drf.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gFq.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bIG() {
        if (this.gFu != null) {
            this.gFw = false;
            this.gqj.removeHeaderView(this.gFu);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gFt != null) {
            this.gFt.bHd();
            this.gFt.notifyDataSetChanged();
            this.gFt.onChangeSkinType(i);
        }
        this.gFq.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gFq.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gFu != null) {
            this.gFu.aMz();
        }
        if (this.eli != null) {
            this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
            this.eli.changeSkin(i);
        }
        am.setBackgroundColor(this.ens, R.color.cp_bg_line_d);
        b(this.gFr);
        b(this.gFs);
    }

    public void startPullRefresh() {
        this.ens.setRefreshing(true);
    }

    public b bIH() {
        return this.gFt;
    }

    public RelativeLayout bsC() {
        return this.mContainer;
    }

    public View bGd() {
        return this.ens;
    }

    public void bFf() {
        if (com.baidu.tbadk.n.m.aRj().aRk()) {
            int lastVisiblePosition = this.gqj.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gqj.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.grh != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.grh.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDu = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.grh.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.grh.startLogPerf();
                    }
                    if (pVar.grg != null && (pVar.grg instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.grg;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDu = true;
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
    public void bdp() {
        this.gqj.setNextPage(this.eli);
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.startLoadData();
    }

    public void bdq() {
        this.gqj.setNextPage(this.eli);
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.endLoadData();
        this.eli.setText(this.gFq.getResources().getString(R.string.list_has_no_more));
    }

    public void bdr() {
        this.gqj.setNextPage(null);
    }

    public void lF(boolean z) {
        this.cwu.setVisibility(z ? 0 : 8);
        lW(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.gwo.gJo = intValue;
                if (!this.gFx) {
                    this.mCurrentTab = intValue;
                    a(intValue, this.gFs, false);
                    this.gFq.tJ(this.mCurrentTab);
                    r.bve().kp(false);
                    c.cJY().b(this.gFq.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.ens != null && this.ens.isRefreshing()) {
            this.ens.interruptRefresh();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.gFx && (tab.getTag() instanceof Integer)) {
                this.mCurrentTab = ((Integer) tab.getTag()).intValue();
                this.gFq.tJ(this.mCurrentTab);
            }
            a(tab);
        }
    }

    private void bII() {
        if (this.gFr == null) {
            this.gFr = (TabLayout) LayoutInflater.from(this.gFq.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.gFr.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.gFq.getContext(), R.dimen.tbds126)));
            this.gFr.setOnTabSelectedListener(this);
            b(this.gFr);
            this.gqj.addHeaderView(this.gFr);
        }
    }

    private void bU(View view) {
        this.gFs = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.gFs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.gFr, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.ens != null && a.this.ens.isRefreshing()) {
                    a.this.ens.interruptRefresh();
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
            this.gFs.setVisibility(8);
        } else if (this.gFs.getTabCount() > 1) {
            this.gFs.setVisibility(0);
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
                        } else if (aq.isEmpty(this.gFv)) {
                            dVar.lu(R.color.cp_cont_b);
                        } else {
                            dVar.lv(com.baidu.tieba.lego.card.d.a.cG(this.gFv));
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
                this.gFv = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (aq.isEmpty(this.gFv)) {
                dVar.lu(R.color.cp_cont_b);
            } else {
                dVar.lv(com.baidu.tieba.lego.card.d.a.cG(this.gFv));
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
        if (bIH() != null) {
            List<m> dataList = bIH().getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cRf != 0 && biVar.cRe != null) {
                            int[] imageWidthAndHeight = biVar.cRe.getImageWidthAndHeight();
                            biVar.cRf = imageWidthAndHeight[0];
                            biVar.cRg = imageWidthAndHeight[1];
                        }
                    }
                }
                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bIH().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void BA(String str) {
        if (this.gFq.bIB() != null) {
            this.gFq.bIB().BC(str);
        }
    }

    public void BB(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gFt.getDataList())) {
            Iterator<m> it = this.gFt.bIO().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aVu() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVu()).cMV)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
