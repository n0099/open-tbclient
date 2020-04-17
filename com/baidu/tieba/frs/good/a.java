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
import com.baidu.adp.widget.ListView.v;
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
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
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
    private FrameLayout cVD;
    private y dRD;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private PbListView ePm;
    private FrsGoodFragment hpU;
    private TabLayout hpV;
    private TabLayout hpW;
    private b hpX;
    public String hpZ;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hau = null;
    private BannerView hpY = null;
    private boolean hqa = false;
    private boolean hqb = false;
    private int hqc = 0;
    private BannerView.a hqd = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVe() {
            a.this.bTq();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVf() {
            a.this.bTs();
        }
    };
    private CustomMessageListener hqe = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Dm(str);
                a.this.Dl(str);
                a.this.hpX.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.hpU = null;
        this.hpU = frsGoodFragment;
        j(view, z);
        this.ds16 = l.getDimens(this.hpU.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.hpU.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.hpU.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cc(view);
        this.hau = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hau.setLayoutManager(new LinearLayoutManager(this.hau.getContext()));
        this.hau.setFadingEdgeLength(0);
        this.hau.setOverScrollMode(2);
        this.hau.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.ePm = new PbListView(this.hpU.getPageContext().getPageActivity());
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.hpU.getActivity(), R.dimen.tbds182));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hau.setOnSrollToBottomListener(this.hpU);
        this.cVD = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.hpX = new b(this.hpU, this.hau);
        it(false);
        this.hpU.registerListener(this.hqe);
    }

    private void b(y yVar) {
        if (this.hpY == null) {
            this.hpY = new BannerView(this.hpU.getPageContext().getPageActivity());
            this.hpY.setLayoutParams(new AbsListView.LayoutParams(-1, this.hpU.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hpY.setVisibility(8);
            this.hpY.setBannerViewClickListener(this.hqd);
            this.hpY.setBannerData(yVar);
            this.hpY.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.hpY.aVc() && !a.this.hqa && a.this.hau != null) {
                        a.this.hqa = true;
                        a.this.hau.addHeaderView(a.this.hpY, 1);
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
    public void bTq() {
        if (this.dRD != null) {
            String value = this.dRD.getValue();
            if (this.dRD.aIX() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.hpU.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dRD.aIX() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.hpU.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.hpU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dRD.aIX() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dAj != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dAj) {
                        case FRS:
                            this.hpU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hpU.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.hpU.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.hpU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aOY().b(this.hpU.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hpU.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dRD.aIX() == 4) {
                this.hpU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hpU.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hau.setOnScrollListener(onScrollListener);
    }

    public void a(v vVar) {
        this.hpX.a(vVar);
    }

    public void onDestroy() {
        this.hpX.onDestory();
        this.hau.setOnSrollToBottomListener(null);
        a(this.hpV);
        a(this.hpW);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void it(boolean z) {
        if (!z) {
            s sVar = new s();
            sVar.tabId = 301;
            sVar.etK = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bQT() {
        s sVar = new s();
        sVar.tabId = 301;
        sVar.etK = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bpV() {
        this.hau.setVisibility(0);
    }

    public void bPE() {
        if (this.hpX != null) {
            this.hpX.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ad> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.hpU.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ad adVar : good_classify) {
                if (adVar != null && adVar.aJa() > 0 && !TextUtils.isEmpty(adVar.aIZ()) && !TextUtils.isEmpty(adVar.aIZ().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = adVar.aJa();
                    dVar2.name = adVar.aIZ();
                    tabData.add(dVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(tabData) > 1) {
                bTu();
                this.hqb = true;
                a(tabData, this.hpV);
                a(tabData, this.hpW);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.hpU.getContext());
                    com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                    dVar.lI(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(dVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(aq.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.hqc) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds28, 0, this.ds28, 0);
        }
    }

    public void a(ArrayList<m> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            p pVar = new p();
            arrayList = new ArrayList<>();
            arrayList.add(pVar);
        }
        this.hpX.b(arrayList, frsViewData);
        this.hqb = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.hau;
    }

    public void bTr() {
        this.hpX.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hau.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hqa && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dRD = forumData.getFrsBannerData();
            b(this.dRD);
            this.hpY.reset();
            this.hau.removeHeaderView(this.hpY);
            if (this.dRD.getType() == 1 && !TextUtils.isEmpty(this.dRD.aIY())) {
                this.hpY.setData(this.hpU.getPageContext(), this.dRD.aIY());
                if (this.dRD.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hpU.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bTs() {
        if (this.hpY != null) {
            this.hqa = false;
            this.hau.removeHeaderView(this.hpY);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hpX != null) {
            this.hpX.bRW();
            this.hpX.notifyDataSetChanged();
            this.hpX.onChangeSkinType(i);
        }
        this.hpU.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hpU.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hpY != null) {
            this.hpY.aVd();
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
        b(this.hpV);
        b(this.hpW);
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 301;
        sVar.etK = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void blz() {
        s sVar = new s();
        sVar.tabId = 301;
        sVar.etK = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public b bTt() {
        return this.hpX;
    }

    public RelativeLayout bCt() {
        return this.mContainer;
    }

    public void mN(boolean z) {
        com.baidu.tieba.frs.y yVar = new com.baidu.tieba.frs.y();
        yVar.tabId = 301;
        yVar.dGN = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    public void bPT() {
        if (com.baidu.tbadk.n.m.aZA().aZB()) {
            int lastVisiblePosition = this.hau.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hau.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hbs != null) {
                        h perfLog = rVar.hbs.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.edD = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hbs.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hbs.startLogPerf();
                    }
                    if (rVar.hbr != null && (rVar.hbr instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hbr;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.edD = true;
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
    public void bmo() {
        this.hau.setNextPage(this.ePm);
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.startLoadData();
    }

    public void bmp() {
        this.hau.setNextPage(this.ePm);
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.endLoadData();
        this.ePm.setText(this.hpU.getResources().getString(R.string.list_has_no_more));
    }

    public void bmq() {
        this.hau.setNextPage(null);
    }

    public void mO(boolean z) {
        this.cVD.setVisibility(z ? 0 : 8);
        nf(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.hgG.htY = intValue;
                if (!this.hqb) {
                    this.hqc = intValue;
                    a(intValue, this.hpW, false);
                    this.hpU.um(this.hqc);
                    com.baidu.tieba.card.r.bEY().lx(false);
                    c.cVr().b(this.hpU.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        blz();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.hqb && (tab.getTag() instanceof Integer)) {
                this.hqc = ((Integer) tab.getTag()).intValue();
                this.hpU.um(this.hqc);
            }
            setTabColorSelected(tab);
        }
    }

    private void bTu() {
        if (this.hpV == null) {
            this.hpV = (TabLayout) LayoutInflater.from(this.hpU.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.hpV.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.hpU.getContext(), R.dimen.tbds126)));
            this.hpV.setOnTabSelectedListener(this);
            b(this.hpV);
            this.hau.addHeaderView(this.hpV);
        }
    }

    private void cc(View view) {
        this.hpW = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.hpW.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.hpV, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.blz();
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

    private void nf(boolean z) {
        if (z) {
            this.hpW.setVisibility(8);
        } else if (this.hpW.getTabCount() > 1) {
            this.hpW.setVisibility(0);
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
                            dVar.lI(R.color.cp_cont_c);
                        } else if (aq.isEmpty(this.hpZ)) {
                            dVar.lI(R.color.cp_cont_b);
                        } else {
                            dVar.lJ(com.baidu.tieba.lego.card.d.a.dA(this.hpZ));
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
                this.hpZ = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (aq.isEmpty(this.hpZ)) {
                dVar.lI(R.color.cp_cont_b);
            } else {
                dVar.lJ(com.baidu.tieba.lego.card.d.a.dA(this.hpZ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).lI(R.color.cp_cont_c);
        }
    }

    public void wK() {
        if (bTt() != null) {
            List<m> dataList = bTt().getDataList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.dqB != 0 && biVar.dqA != null) {
                            int[] imageWidthAndHeight = biVar.dqA.getImageWidthAndHeight();
                            biVar.dqB = imageWidthAndHeight[0];
                            biVar.dqC = imageWidthAndHeight[1];
                        }
                    }
                }
                e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bTt().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Dl(String str) {
        if (this.hpU.bTn() != null) {
            this.hpU.bTn().Dn(str);
        }
    }

    public void Dm(String str) {
        if (!StringUtils.isNull(str) && !com.baidu.tbadk.core.util.v.isEmpty(this.hpX.getDataList())) {
            Iterator<m> it = this.hpX.bTA().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bdL() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bdL()).dmo)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
