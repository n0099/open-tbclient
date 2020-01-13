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
/* loaded from: classes7.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout css;
    private y dmW;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private PbListView ehe;
    private BdSwipeRefreshLayout ejj;
    private FrsGoodFragment gDr;
    private TabLayout gDs;
    private TabLayout gDt;
    private b gDu;
    public String gDw;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView goi = null;
    private h mPullView = null;
    private BannerView gDv = null;
    private boolean gDx = false;
    private boolean gDy = false;
    private int mCurrentTab = 0;
    private BannerView.a gDz = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aKe() {
            a.this.bHd();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aKf() {
            a.this.bHf();
        }
    };
    private CustomMessageListener gDA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Bl(str);
                a.this.Bk(str);
                a.this.gDu.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.gDr = null;
        this.gDr = frsGoodFragment;
        j(view, z);
        this.ds16 = l.getDimens(this.gDr.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.gDr.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.gDr.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bU(view);
        this.goi = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.goi.setLayoutManager(new LinearLayoutManager(this.goi.getContext()));
        this.mPullView = new h(this.gDr.getPageContext());
        this.goi.setFadingEdgeLength(0);
        this.goi.setOverScrollMode(2);
        this.goi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.ehe = new PbListView(this.gDr.getPageContext().getPageActivity());
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setHeight(l.getDimens(this.gDr.getActivity(), R.dimen.tbds182));
        this.ehe.setLineGone();
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.goi.setOnSrollToBottomListener(this.gDr);
        if (this.ejj == null) {
            this.ejj = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.ejj.setProgressView(this.mPullView);
            am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
        }
        this.css = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.gDu = new b(this.gDr, this.goi);
        hn(false);
        this.gDr.registerListener(this.gDA);
    }

    private void b(y yVar) {
        if (this.gDv == null) {
            this.gDv = new BannerView(this.gDr.getPageContext().getPageActivity());
            this.gDv.setLayoutParams(new AbsListView.LayoutParams(-1, this.gDr.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.gDv.setVisibility(8);
            this.gDv.setBannerViewClickListener(this.gDz);
            this.gDv.setBannerData(yVar);
            this.gDv.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.gDv.aKc() && !a.this.gDx && a.this.goi != null) {
                        a.this.gDx = true;
                        a.this.goi.addHeaderView(a.this.gDv, 1);
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
    public void bHd() {
        if (this.dmW != null) {
            String value = this.dmW.getValue();
            if (this.dmW.ayr() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.gDr.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dmW.ayr() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.gDr.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.gDr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dmW.ayr() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.cWD != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.cWD) {
                        case FRS:
                            this.gDr.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gDr.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.gDr.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.gDr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aEt().b(this.gDr.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gDr.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dmW.ayr() == 4) {
                this.gDr.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.gDr.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.goi.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.gDu.a(sVar);
    }

    public void onDestroy() {
        this.gDu.onDestory();
        this.goi.setOnSrollToBottomListener(null);
        a(this.gDs);
        a(this.gDt);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void hn(boolean z) {
        if (!z) {
            this.ejj.setRefreshing(false);
        }
    }

    public void bem() {
        this.goi.setVisibility(0);
    }

    public void bDo() {
        if (this.gDu != null) {
            this.gDu.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.gDr.gDk) {
            ArrayList<ad> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.gDr.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ad adVar : good_classify) {
                if (adVar != null && adVar.ayu() > 0 && !TextUtils.isEmpty(adVar.ayt()) && !TextUtils.isEmpty(adVar.ayt().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = adVar.ayu();
                    dVar2.name = adVar.ayt();
                    tabData.add(dVar2);
                }
            }
            if (v.getCount(tabData) > 1) {
                bHh();
                this.gDy = true;
                a(tabData, this.gDs);
                a(tabData, this.gDt);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.gDr.getContext());
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
        this.gDu.b(arrayList, frsViewData);
        this.gDy = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.goi;
    }

    public void bHe() {
        this.gDu.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.goi.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.gDx && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dmW = forumData.getFrsBannerData();
            b(this.dmW);
            this.gDv.reset();
            this.goi.removeHeaderView(this.gDv);
            if (this.dmW.getType() == 1 && !TextUtils.isEmpty(this.dmW.ays())) {
                this.gDv.setData(this.gDr.getPageContext(), this.dmW.ays());
                if (this.dmW.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.gDr.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bHf() {
        if (this.gDv != null) {
            this.gDx = false;
            this.goi.removeHeaderView(this.gDv);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gDu != null) {
            this.gDu.bFB();
            this.gDu.notifyDataSetChanged();
            this.gDu.onChangeSkinType(i);
        }
        this.gDr.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gDr.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gDv != null) {
            this.gDv.aKd();
        }
        if (this.ehe != null) {
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.changeSkin(i);
        }
        am.setBackgroundColor(this.ejj, R.color.cp_bg_line_d);
        b(this.gDs);
        b(this.gDt);
    }

    public void startPullRefresh() {
        this.ejj.setRefreshing(true);
    }

    public b bHg() {
        return this.gDu;
    }

    public RelativeLayout bqY() {
        return this.mContainer;
    }

    public View bEB() {
        return this.ejj;
    }

    public void bDC() {
        if (com.baidu.tbadk.n.m.aOT().aOU()) {
            int lastVisiblePosition = this.goi.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.goi.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.gpg != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.gpg.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dzs = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.gpg.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.gpg.startLogPerf();
                    }
                    if (pVar.gpf != null && (pVar.gpf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.gpf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dzs = true;
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
    public void bba() {
        this.goi.setNextPage(this.ehe);
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.startLoadData();
    }

    public void bbb() {
        this.goi.setNextPage(this.ehe);
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.endLoadData();
        this.ehe.setText(this.gDr.getResources().getString(R.string.list_has_no_more));
    }

    public void bbc() {
        this.goi.setNextPage(null);
    }

    public void lC(boolean z) {
        this.css.setVisibility(z ? 0 : 8);
        lT(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.gun.gHp = intValue;
                if (!this.gDy) {
                    this.mCurrentTab = intValue;
                    a(intValue, this.gDt, false);
                    this.gDr.tD(this.mCurrentTab);
                    r.btA().kn(false);
                    c.cIs().b(this.gDr.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.ejj != null && this.ejj.isRefreshing()) {
            this.ejj.interruptRefresh();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.gDy && (tab.getTag() instanceof Integer)) {
                this.mCurrentTab = ((Integer) tab.getTag()).intValue();
                this.gDr.tD(this.mCurrentTab);
            }
            a(tab);
        }
    }

    private void bHh() {
        if (this.gDs == null) {
            this.gDs = (TabLayout) LayoutInflater.from(this.gDr.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.gDs.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.gDr.getContext(), R.dimen.tbds126)));
            this.gDs.setOnTabSelectedListener(this);
            b(this.gDs);
            this.goi.addHeaderView(this.gDs);
        }
    }

    private void bU(View view) {
        this.gDt = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.gDt.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.gDs, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.ejj != null && a.this.ejj.isRefreshing()) {
                    a.this.ejj.interruptRefresh();
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

    private void lT(boolean z) {
        if (z) {
            this.gDt.setVisibility(8);
        } else if (this.gDt.getTabCount() > 1) {
            this.gDt.setVisibility(0);
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
                        } else if (aq.isEmpty(this.gDw)) {
                            dVar.ld(R.color.cp_cont_b);
                        } else {
                            dVar.le(com.baidu.tieba.lego.card.d.a.cy(this.gDw));
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
                this.gDw = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (aq.isEmpty(this.gDw)) {
                dVar.ld(R.color.cp_cont_b);
            } else {
                dVar.le(com.baidu.tieba.lego.card.d.a.cy(this.gDw));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).ld(R.color.cp_cont_c);
        }
    }

    public void rl() {
        if (bHg() != null) {
            List<m> dataList = bHg().getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cNc != 0 && biVar.cNb != null) {
                            int[] imageWidthAndHeight = biVar.cNb.getImageWidthAndHeight();
                            biVar.cNc = imageWidthAndHeight[0];
                            biVar.cNd = imageWidthAndHeight[1];
                        }
                    }
                }
                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bHg().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Bk(String str) {
        if (this.gDr.bHa() != null) {
            this.gDr.bHa().Bm(str);
        }
    }

    public void Bl(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.gDu.getDataList())) {
            Iterator<m> it = this.gDu.bHm().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aTd() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aTd()).cIS)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
