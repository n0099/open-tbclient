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
/* loaded from: classes21.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout dDw;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private ad eHL;
    private PbListView fHm;
    private FrsGoodFragment iuu;
    private TabLayout iuv;
    private TabLayout iuw;
    private b iux;
    public String iuz;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView icD = null;
    private BannerView iuy = null;
    private boolean iuA = false;
    private boolean iuB = false;
    private int iuC = 0;
    private View.OnClickListener ijg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iuu != null) {
                a.this.iuu.onScrollToBottom();
            }
        }
    };
    private BannerView.a iuD = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bqD() {
            a.this.cuB();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bqE() {
            a.this.cuD();
        }
    };
    private CustomMessageListener iuE = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Jm(str);
                a.this.Jl(str);
                a.this.iux.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.iuu = null;
        this.iuu = frsGoodFragment;
        l(view, z);
        this.ds16 = l.getDimens(this.iuu.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.iuu.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.iuu.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void l(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cu(view);
        this.icD = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.icD.setLayoutManager(new LinearLayoutManager(this.icD.getContext()));
        this.icD.setFadingEdgeLength(0);
        this.icD.setOverScrollMode(2);
        this.icD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        this.fHm = new PbListView(this.iuu.getPageContext().getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.iuu.getActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.icD.setOnSrollToBottomListener(this.iuu);
        this.dDw = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.iux = new b(this.iuu, this.icD);
        ki(false);
        this.iuu.registerListener(this.iuE);
    }

    private void b(ad adVar) {
        if (this.iuy == null) {
            this.iuy = new BannerView(this.iuu.getPageContext().getPageActivity());
            this.iuy.setLayoutParams(new AbsListView.LayoutParams(-1, this.iuu.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.iuy.setVisibility(8);
            this.iuy.setBannerViewClickListener(this.iuD);
            this.iuy.setBannerData(adVar);
            this.iuy.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.iuy.bqB() && !a.this.iuA && a.this.icD != null) {
                        a.this.iuA = true;
                        a.this.icD.addHeaderView(a.this.iuy, 1);
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
    public void cuB() {
        if (this.eHL != null) {
            String value = this.eHL.getValue();
            if (this.eHL.bdK() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.iuu.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.eHL.bdK() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.iuu.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.iuu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eHL.bdK() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.enL != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.enL) {
                        case FRS:
                            this.iuu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iuu.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.iuu.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.iuu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bkp().b(this.iuu.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iuu.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.eHL.bdK() == 4) {
                this.iuu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iuu.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.iux != null) {
            this.iux.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.icD.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.iux.a(abVar);
    }

    public void onDestroy() {
        this.iux.onDestory();
        this.icD.setOnSrollToBottomListener(null);
        a(this.iuv);
        a(this.iuw);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void ki(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 301;
            vVar.fnv = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void crS() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fnv = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bMD() {
        this.icD.setVisibility(0);
    }

    public void cqr() {
        if (this.iux != null) {
            this.iux.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<aj> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.iuu.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (aj ajVar : good_classify) {
                if (ajVar != null && ajVar.bdN() > 0 && !TextUtils.isEmpty(ajVar.bdM()) && !TextUtils.isEmpty(ajVar.bdM().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = ajVar.bdN();
                    dVar2.name = ajVar.bdM();
                    tabData.add(dVar2);
                }
            }
            if (y.getCount(tabData) > 1) {
                cuF();
                this.iuB = true;
                a(tabData, this.iuv);
                a(tabData, this.iuw);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.iuu.getContext());
                    c cVar = new c();
                    cVar.pr(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(at.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.iuC) {
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
        this.iux.b(arrayList, frsViewData);
        this.iuB = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.icD;
    }

    public void cuC() {
        this.iux.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.icD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.iuA && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.eHL = forumData.getFrsBannerData();
            b(this.eHL);
            this.iuy.reset();
            this.icD.removeHeaderView(this.iuy);
            if (this.eHL.getType() == 1 && !TextUtils.isEmpty(this.eHL.bdL())) {
                this.iuy.setData(this.iuu.getPageContext(), this.eHL.bdL());
                if (this.eHL.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iuu.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cuD() {
        if (this.iuy != null) {
            this.iuA = false;
            this.icD.removeHeaderView(this.iuy);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iux != null) {
            this.iux.cta();
            this.iux.notifyDataSetChanged();
            this.iux.onChangeSkinType(i);
        }
        this.iuu.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iuu.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.iuy != null) {
            this.iuy.bqC();
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
        b(this.iuv);
        b(this.iuw);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fnv = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bHu() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fnv = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public b cuE() {
        return this.iux;
    }

    public RelativeLayout caY() {
        return this.mContainer;
    }

    public void oK(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 301;
        adVar.euE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void cqG() {
        if (m.bvs().bvt()) {
            int lastVisiblePosition = this.icD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.icD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.idE != null) {
                        h perfLog = uVar.idE.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eUD = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.idE.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.idE.startLogPerf();
                    }
                    if (uVar.idD != null && (uVar.idD instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.idD;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eUD = true;
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
    public void bIi() {
        this.icD.setNextPage(this.fHm);
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.setOnClickListener(null);
        this.fHm.startLoadData();
    }

    public void cqH() {
        this.icD.setNextPage(this.fHm);
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.setOnClickListener(this.ijg);
        this.fHm.endLoadData();
        this.fHm.setText(this.iuu.getResources().getString(R.string.list_click_load_more));
    }

    public void bIj() {
        this.icD.setNextPage(this.fHm);
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.setOnClickListener(null);
        this.fHm.endLoadData();
        this.fHm.setText(this.iuu.getResources().getString(R.string.list_has_no_more));
    }

    public void bIk() {
        this.icD.setNextPage(null);
    }

    public void oL(boolean z) {
        this.dDw.setVisibility(z ? 0 : 8);
        pd(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.ijV.iyt = intValue;
                if (!this.iuB) {
                    this.iuC = intValue;
                    a(intValue, this.iuw, false);
                    this.iuu.yI(this.iuC);
                    com.baidu.tieba.card.s.cfn().ns(false);
                    com.baidu.tieba.s.c.dzC().b(this.iuu.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bHu();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.iuB && (tab.getTag() instanceof Integer)) {
                this.iuC = ((Integer) tab.getTag()).intValue();
                this.iuu.yI(this.iuC);
            }
            setTabColorSelected(tab);
        }
    }

    private void cuF() {
        if (this.iuv == null) {
            this.iuv = (TabLayout) LayoutInflater.from(this.iuu.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.iuv.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.iuu.getContext(), R.dimen.tbds126)));
            this.iuv.setOnTabSelectedListener(this);
            b(this.iuv);
            this.icD.addHeaderView(this.iuv);
        }
    }

    private void cu(View view) {
        this.iuw = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.iuw.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.iuv, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bHu();
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

    private void pd(boolean z) {
        if (z) {
            this.iuw.setVisibility(8);
        } else if (this.iuw.getTabCount() > 1) {
            this.iuw.setVisibility(0);
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
                            cVar.pr(R.color.cp_cont_c);
                        } else if (at.isEmpty(this.iuz)) {
                            cVar.pr(R.color.cp_cont_b);
                        } else {
                            cVar.ps(com.baidu.tieba.lego.card.d.b.fq(this.iuz));
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
                this.iuz = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (at.isEmpty(this.iuz)) {
                cVar.pr(R.color.cp_cont_b);
            } else {
                cVar.ps(com.baidu.tieba.lego.card.d.b.fq(this.iuz));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).pr(R.color.cp_cont_c);
        }
    }

    public void EW() {
        if (cuE() != null) {
            List<q> dataList = cuE().getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.edd != 0 && bvVar.dXg != null) {
                            int[] imageWidthAndHeight = bvVar.dXg.getImageWidthAndHeight();
                            bvVar.edd = imageWidthAndHeight[0];
                            bvVar.ede = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cuE().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Jl(String str) {
        if (this.iuu.cuy() != null) {
            this.iuu.cuy().Jn(str);
        }
    }

    public void Jm(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.iux.getDataList())) {
            Iterator<q> it = this.iux.cuM().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bAy() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bAy()).dYt)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
