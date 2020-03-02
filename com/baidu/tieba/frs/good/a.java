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
    private FrameLayout cwv;
    private y drg;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private PbListView elj;
    private BdSwipeRefreshLayout ent;
    private FrsGoodFragment gFs;
    private TabLayout gFt;
    private TabLayout gFu;
    private b gFv;
    public String gFx;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView gql = null;
    private h mPullView = null;
    private BannerView gFw = null;
    private boolean gFy = false;
    private boolean gFz = false;
    private int mCurrentTab = 0;
    private BannerView.a gFA = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMC() {
            a.this.bIG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMD() {
            a.this.bII();
        }
    };
    private CustomMessageListener gFB = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.BB(str);
                a.this.BA(str);
                a.this.gFv.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.gFs = null;
        this.gFs = frsGoodFragment;
        j(view, z);
        this.ds16 = l.getDimens(this.gFs.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.gFs.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.gFs.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bU(view);
        this.gql = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.gql.setLayoutManager(new LinearLayoutManager(this.gql.getContext()));
        this.mPullView = new h(this.gFs.getPageContext());
        this.gql.setFadingEdgeLength(0);
        this.gql.setOverScrollMode(2);
        this.gql.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.elj = new PbListView(this.gFs.getPageContext().getPageActivity());
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setHeight(l.getDimens(this.gFs.getActivity(), R.dimen.tbds182));
        this.elj.setLineGone();
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gql.setOnSrollToBottomListener(this.gFs);
        if (this.ent == null) {
            this.ent = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.ent.setProgressView(this.mPullView);
            am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
        }
        this.cwv = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gFv = new b(this.gFs, this.gql);
        hu(false);
        this.gFs.registerListener(this.gFB);
    }

    private void b(y yVar) {
        if (this.gFw == null) {
            this.gFw = new BannerView(this.gFs.getPageContext().getPageActivity());
            this.gFw.setLayoutParams(new AbsListView.LayoutParams(-1, this.gFs.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gFw.setVisibility(8);
            this.gFw.setBannerViewClickListener(this.gFA);
            this.gFw.setBannerData(yVar);
            this.gFw.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.gFw.aMA() && !a.this.gFy && a.this.gql != null) {
                        a.this.gFy = true;
                        a.this.gql.addHeaderView(a.this.gFw, 1);
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
    public void bIG() {
        if (this.drg != null) {
            String value = this.drg.getValue();
            if (this.drg.aAH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gFs.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.drg.aAH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gFs.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gFs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.drg.aAH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daH != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daH) {
                        case FRS:
                            this.gFs.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gFs.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gFs.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gFs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aGG().b(this.gFs.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gFs.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.drg.aAH() == 4) {
                this.gFs.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gFs.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.gql.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gFv.a(sVar);
    }

    public void onDestroy() {
        this.gFv.onDestory();
        this.gql.setOnSrollToBottomListener(null);
        a(this.gFt);
        a(this.gFu);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void hu(boolean z) {
        if (!z) {
            this.ent.setRefreshing(false);
        }
    }

    public void bgy() {
        this.gql.setVisibility(0);
    }

    public void bET() {
        if (this.gFv != null) {
            this.gFv.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ad> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.gFs.getPageContext().getResources().getString(R.string.all);
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
                bIK();
                this.gFz = true;
                a(tabData, this.gFt);
                a(tabData, this.gFu);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.gFs.getContext());
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
        this.gFv.b(arrayList, frsViewData);
        this.gFz = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.gql;
    }

    public void bIH() {
        this.gFv.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.gql.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gFy && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.drg = forumData.getFrsBannerData();
            b(this.drg);
            this.gFw.reset();
            this.gql.removeHeaderView(this.gFw);
            if (this.drg.getType() == 1 && !TextUtils.isEmpty(this.drg.aAI())) {
                this.gFw.setData(this.gFs.getPageContext(), this.drg.aAI());
                if (this.drg.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gFs.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bII() {
        if (this.gFw != null) {
            this.gFy = false;
            this.gql.removeHeaderView(this.gFw);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gFv != null) {
            this.gFv.bHf();
            this.gFv.notifyDataSetChanged();
            this.gFv.onChangeSkinType(i);
        }
        this.gFs.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gFs.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gFw != null) {
            this.gFw.aMB();
        }
        if (this.elj != null) {
            this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elj.changeSkin(i);
        }
        am.setBackgroundColor(this.ent, R.color.cp_bg_line_d);
        b(this.gFt);
        b(this.gFu);
    }

    public void startPullRefresh() {
        this.ent.setRefreshing(true);
    }

    public b bIJ() {
        return this.gFv;
    }

    public RelativeLayout bsE() {
        return this.mContainer;
    }

    public View bGf() {
        return this.ent;
    }

    public void bFh() {
        if (com.baidu.tbadk.n.m.aRl().aRm()) {
            int lastVisiblePosition = this.gql.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gql.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.grj != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.grj.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDv = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.grj.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.grj.startLogPerf();
                    }
                    if (pVar.gri != null && (pVar.gri instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.gri;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDv = true;
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
    public void bdr() {
        this.gql.setNextPage(this.elj);
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.startLoadData();
    }

    public void bds() {
        this.gql.setNextPage(this.elj);
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.endLoadData();
        this.elj.setText(this.gFs.getResources().getString(R.string.list_has_no_more));
    }

    public void bdt() {
        this.gql.setNextPage(null);
    }

    public void lF(boolean z) {
        this.cwv.setVisibility(z ? 0 : 8);
        lW(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.gwq.gJq = intValue;
                if (!this.gFz) {
                    this.mCurrentTab = intValue;
                    a(intValue, this.gFu, false);
                    this.gFs.tJ(this.mCurrentTab);
                    r.bvg().kp(false);
                    c.cKa().b(this.gFs.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.ent != null && this.ent.isRefreshing()) {
            this.ent.interruptRefresh();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.gFz && (tab.getTag() instanceof Integer)) {
                this.mCurrentTab = ((Integer) tab.getTag()).intValue();
                this.gFs.tJ(this.mCurrentTab);
            }
            a(tab);
        }
    }

    private void bIK() {
        if (this.gFt == null) {
            this.gFt = (TabLayout) LayoutInflater.from(this.gFs.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.gFt.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.gFs.getContext(), R.dimen.tbds126)));
            this.gFt.setOnTabSelectedListener(this);
            b(this.gFt);
            this.gql.addHeaderView(this.gFt);
        }
    }

    private void bU(View view) {
        this.gFu = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.gFu.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.gFt, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.ent != null && a.this.ent.isRefreshing()) {
                    a.this.ent.interruptRefresh();
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
            this.gFu.setVisibility(8);
        } else if (this.gFu.getTabCount() > 1) {
            this.gFu.setVisibility(0);
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
                        } else if (aq.isEmpty(this.gFx)) {
                            dVar.lu(R.color.cp_cont_b);
                        } else {
                            dVar.lv(com.baidu.tieba.lego.card.d.a.cG(this.gFx));
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
                this.gFx = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (aq.isEmpty(this.gFx)) {
                dVar.lu(R.color.cp_cont_b);
            } else {
                dVar.lv(com.baidu.tieba.lego.card.d.a.cG(this.gFx));
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
        if (bIJ() != null) {
            List<m> dataList = bIJ().getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cRg != 0 && biVar.cRf != null) {
                            int[] imageWidthAndHeight = biVar.cRf.getImageWidthAndHeight();
                            biVar.cRg = imageWidthAndHeight[0];
                            biVar.cRh = imageWidthAndHeight[1];
                        }
                    }
                }
                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bIJ().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void BA(String str) {
        if (this.gFs.bID() != null) {
            this.gFs.bID().BC(str);
        }
    }

    public void BB(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gFv.getDataList())) {
            Iterator<m> it = this.gFv.bIQ().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aVw() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVw()).cMW)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
