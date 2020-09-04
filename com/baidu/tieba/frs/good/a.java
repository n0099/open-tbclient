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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.v;
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
/* loaded from: classes16.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout dBv;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private ad eFE;
    private PbListView fEa;
    private FrsGoodFragment ind;
    private TabLayout ine;
    private TabLayout inf;
    private b ing;
    public String ini;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hVD = null;
    private BannerView inh = null;
    private boolean inj = false;
    private boolean ink = false;
    private int inl = 0;
    private View.OnClickListener icc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ind != null) {
                a.this.ind.onScrollToBottom();
            }
        }
    };
    private BannerView.a inm = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpJ() {
            a.this.crm();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpK() {
            a.this.cro();
        }
    };
    private CustomMessageListener inn = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.IO(str);
                a.this.IN(str);
                a.this.ing.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.ind = null;
        this.ind = frsGoodFragment;
        l(view, z);
        this.ds16 = l.getDimens(this.ind.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.ind.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.ind.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void l(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cl(view);
        this.hVD = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hVD.setLayoutManager(new LinearLayoutManager(this.hVD.getContext()));
        this.hVD.setFadingEdgeLength(0);
        this.hVD.setOverScrollMode(2);
        this.hVD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        this.fEa = new PbListView(this.ind.getPageContext().getPageActivity());
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.ind.getActivity(), R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hVD.setOnSrollToBottomListener(this.ind);
        this.dBv = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.ing = new b(this.ind, this.hVD);
        kh(false);
        this.ind.registerListener(this.inn);
    }

    private void b(ad adVar) {
        if (this.inh == null) {
            this.inh = new BannerView(this.ind.getPageContext().getPageActivity());
            this.inh.setLayoutParams(new AbsListView.LayoutParams(-1, this.ind.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.inh.setVisibility(8);
            this.inh.setBannerViewClickListener(this.inm);
            this.inh.setBannerData(adVar);
            this.inh.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.inh.bpH() && !a.this.inj && a.this.hVD != null) {
                        a.this.inj = true;
                        a.this.hVD.addHeaderView(a.this.inh, 1);
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
    public void crm() {
        if (this.eFE != null) {
            String value = this.eFE.getValue();
            if (this.eFE.bcQ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.ind.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.eFE.bcQ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.ind.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.ind.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eFE.bcQ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.elt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.elt) {
                        case FRS:
                            this.ind.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ind.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.ind.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.ind.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bju().b(this.ind.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.ind.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.eFE.bcQ() == 4) {
                this.ind.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ind.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.ing != null) {
            this.ing.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hVD.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.ing.a(abVar);
    }

    public void onDestroy() {
        this.ing.onDestory();
        this.hVD.setOnSrollToBottomListener(null);
        a(this.ine);
        a(this.inf);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void kh(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 301;
            vVar.fkC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void coF() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fkC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bLt() {
        this.hVD.setVisibility(0);
    }

    public void cnf() {
        if (this.ing != null) {
            this.ing.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<aj> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.ind.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (aj ajVar : good_classify) {
                if (ajVar != null && ajVar.bcT() > 0 && !TextUtils.isEmpty(ajVar.bcS()) && !TextUtils.isEmpty(ajVar.bcS().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = ajVar.bcT();
                    dVar2.name = ajVar.bcS();
                    tabData.add(dVar2);
                }
            }
            if (y.getCount(tabData) > 1) {
                crq();
                this.ink = true;
                a(tabData, this.ine);
                a(tabData, this.inf);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.ind.getContext());
                    c cVar = new c();
                    cVar.pd(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(at.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.inl) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds28, 0, this.ds28, 0);
        }
    }

    public void a(ArrayList<q> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            s sVar = new s();
            arrayList = new ArrayList<>();
            arrayList.add(sVar);
        }
        this.ing.b(arrayList, frsViewData);
        this.ink = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.hVD;
    }

    public void crn() {
        this.ing.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hVD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.inj && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.eFE = forumData.getFrsBannerData();
            b(this.eFE);
            this.inh.reset();
            this.hVD.removeHeaderView(this.inh);
            if (this.eFE.getType() == 1 && !TextUtils.isEmpty(this.eFE.bcR())) {
                this.inh.setData(this.ind.getPageContext(), this.eFE.bcR());
                if (this.eFE.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.ind.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cro() {
        if (this.inh != null) {
            this.inj = false;
            this.hVD.removeHeaderView(this.inh);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ing != null) {
            this.ing.cpN();
            this.ing.notifyDataSetChanged();
            this.ing.onChangeSkinType(i);
        }
        this.ind.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ind.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.inh != null) {
            this.inh.bpI();
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.changeSkin(i);
        }
        b(this.ine);
        b(this.inf);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fkC = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bGe() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fkC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public b crp() {
        return this.ing;
    }

    public RelativeLayout bZc() {
        return this.mContainer;
    }

    public void oE(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 301;
        adVar.esz = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void cnu() {
        if (m.buo().bup()) {
            int lastVisiblePosition = this.hVD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hVD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.hWA != null) {
                        h perfLog = uVar.hWA.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eRM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.hWA.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.hWA.startLogPerf();
                    }
                    if (uVar.hWz != null && (uVar.hWz instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.hWz;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eRM = true;
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
    public void bGS() {
        this.hVD.setNextPage(this.fEa);
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.setOnClickListener(null);
        this.fEa.startLoadData();
    }

    public void cnv() {
        this.hVD.setNextPage(this.fEa);
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.setOnClickListener(this.icc);
        this.fEa.endLoadData();
        this.fEa.setText(this.ind.getResources().getString(R.string.list_click_load_more));
    }

    public void bGT() {
        this.hVD.setNextPage(this.fEa);
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.setOnClickListener(null);
        this.fEa.endLoadData();
        this.fEa.setText(this.ind.getResources().getString(R.string.list_has_no_more));
    }

    public void bGU() {
        this.hVD.setNextPage(null);
    }

    public void oF(boolean z) {
        this.dBv.setVisibility(z ? 0 : 8);
        oX(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.icR.ird = intValue;
                if (!this.ink) {
                    this.inl = intValue;
                    a(intValue, this.inf, false);
                    this.ind.yj(this.inl);
                    com.baidu.tieba.card.s.cbY().nm(false);
                    com.baidu.tieba.s.c.dvJ().b(this.ind.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bGe();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.ink && (tab.getTag() instanceof Integer)) {
                this.inl = ((Integer) tab.getTag()).intValue();
                this.ind.yj(this.inl);
            }
            setTabColorSelected(tab);
        }
    }

    private void crq() {
        if (this.ine == null) {
            this.ine = (TabLayout) LayoutInflater.from(this.ind.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.ine.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.ind.getContext(), R.dimen.tbds126)));
            this.ine.setOnTabSelectedListener(this);
            b(this.ine);
            this.hVD.addHeaderView(this.ine);
        }
    }

    private void cl(View view) {
        this.inf = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.inf.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.ine, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bGe();
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

    private void oX(boolean z) {
        if (z) {
            this.inf.setVisibility(8);
        } else if (this.inf.getTabCount() > 1) {
            this.inf.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            ap.setBackgroundColor(tabLayout, R.color.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        c cVar = (c) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                        if (!tabAt.isSelected()) {
                            cVar.pd(R.color.cp_cont_c);
                        } else if (at.isEmpty(this.ini)) {
                            cVar.pd(R.color.cp_cont_b);
                        } else {
                            cVar.pe(com.baidu.tieba.lego.card.d.b.fo(this.ini));
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
            if (!at.isEmpty(themeElement.font_color)) {
                this.ini = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (at.isEmpty(this.ini)) {
                cVar.pd(R.color.cp_cont_b);
            } else {
                cVar.pe(com.baidu.tieba.lego.card.d.b.fo(this.ini));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).pd(R.color.cp_cont_c);
        }
    }

    public void EF() {
        if (crp() != null) {
            List<q> dataList = crp().getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.eaT != 0 && bvVar.dUW != null) {
                            int[] imageWidthAndHeight = bvVar.dUW.getImageWidthAndHeight();
                            bvVar.eaT = imageWidthAndHeight[0];
                            bvVar.eaU = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.crp().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void IN(String str) {
        if (this.ind.crj() != null) {
            this.ind.crj().IP(str);
        }
    }

    public void IO(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.ing.getDataList())) {
            Iterator<q> it = this.ing.crx().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bzp() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bzp()).dWj)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
