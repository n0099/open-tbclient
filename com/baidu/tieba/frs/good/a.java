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
import com.baidu.tieba.card.t;
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
/* loaded from: classes22.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout dXU;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private ad fco;
    private PbListView gdy;
    private FrsGoodFragment iVJ;
    private TabLayout iVK;
    private TabLayout iVL;
    private b iVM;
    public String iVO;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView iEa = null;
    private BannerView iVN = null;
    private boolean iVP = false;
    private boolean iVQ = false;
    private int iVR = 0;
    private View.OnClickListener iKz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iVJ != null) {
                a.this.iVJ.onScrollToBottom();
            }
        }
    };
    private BannerView.a iVS = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bvg() {
            a.this.cBf();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bvh() {
            a.this.cBh();
        }
    };
    private CustomMessageListener iVT = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Ky(str);
                a.this.Kx(str);
                a.this.iVM.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.iVJ = null;
        this.iVJ = frsGoodFragment;
        l(view, z);
        this.ds16 = l.getDimens(this.iVJ.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.iVJ.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.iVJ.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void l(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cC(view);
        this.iEa = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.iEa.setLayoutManager(new LinearLayoutManager(this.iEa.getContext()));
        this.iEa.setFadingEdgeLength(0);
        this.iEa.setOverScrollMode(2);
        this.iEa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        this.gdy = new PbListView(this.iVJ.getPageContext().getPageActivity());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.iVJ.getActivity(), R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iEa.setOnSrollToBottomListener(this.iVJ);
        this.dXU = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.iVM = new b(this.iVJ, this.iEa);
        kT(false);
        this.iVJ.registerListener(this.iVT);
    }

    private void b(ad adVar) {
        if (this.iVN == null) {
            this.iVN = new BannerView(this.iVJ.getPageContext().getPageActivity());
            this.iVN.setLayoutParams(new AbsListView.LayoutParams(-1, this.iVJ.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.iVN.setVisibility(8);
            this.iVN.setBannerViewClickListener(this.iVS);
            this.iVN.setBannerData(adVar);
            this.iVN.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.iVN.bve() && !a.this.iVP && a.this.iEa != null) {
                        a.this.iVP = true;
                        a.this.iEa.addHeaderView(a.this.iVN, 1);
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
    public void cBf() {
        if (this.fco != null) {
            String value = this.fco.getValue();
            if (this.fco.bim() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.iVJ.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fco.bim() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.iVJ.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.iVJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fco.bim() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eIp != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eIp) {
                        case FRS:
                            this.iVJ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iVJ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.iVJ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.iVJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.boR().b(this.iVJ.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iVJ.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fco.bim() == 4) {
                this.iVJ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iVJ.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.iVM != null) {
            this.iVM.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iEa.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.iVM.a(abVar);
    }

    public void onDestroy() {
        this.iVM.onDestory();
        this.iEa.setOnSrollToBottomListener(null);
        a(this.iVK);
        a(this.iVL);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void kT(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 301;
            vVar.fIe = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cyx() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fIe = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bSR() {
        this.iEa.setVisibility(0);
    }

    public void cwW() {
        if (this.iVM != null) {
            this.iVM.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<aj> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.iVJ.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (aj ajVar : good_classify) {
                if (ajVar != null && ajVar.bip() > 0 && !TextUtils.isEmpty(ajVar.bio()) && !TextUtils.isEmpty(ajVar.bio().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = ajVar.bip();
                    dVar2.name = ajVar.bio();
                    tabData.add(dVar2);
                }
            }
            if (y.getCount(tabData) > 1) {
                cBj();
                this.iVQ = true;
                a(tabData, this.iVK);
                a(tabData, this.iVL);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.iVJ.getContext());
                    c cVar = new c();
                    cVar.qa(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(at.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.iVR) {
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
        this.iVM.b(arrayList, frsViewData);
        this.iVQ = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.iEa;
    }

    public void cBg() {
        this.iVM.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.iEa.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.iVP && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fco = forumData.getFrsBannerData();
            b(this.fco);
            this.iVN.reset();
            this.iEa.removeHeaderView(this.iVN);
            if (this.fco.getType() == 1 && !TextUtils.isEmpty(this.fco.bin())) {
                this.iVN.setData(this.iVJ.getPageContext(), this.fco.bin());
                if (this.fco.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iVJ.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cBh() {
        if (this.iVN != null) {
            this.iVP = false;
            this.iEa.removeHeaderView(this.iVN);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iVM != null) {
            this.iVM.czE();
            this.iVM.notifyDataSetChanged();
            this.iVM.onChangeSkinType(i);
        }
        this.iVJ.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iVJ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.iVN != null) {
            this.iVN.bvf();
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
        b(this.iVK);
        b(this.iVL);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fIe = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bMH() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fIe = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public b cBi() {
        return this.iVM;
    }

    public RelativeLayout chy() {
        return this.mContainer;
    }

    public void pH(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 301;
        adVar.ePk = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void cxl() {
        if (m.bzV().bzW()) {
            int lastVisiblePosition = this.iEa.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iEa.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.iEX != null) {
                        h perfLog = uVar.iEX.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fpk = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.iEX.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.iEX.startLogPerf();
                    }
                    if (uVar.iEW != null && (uVar.iEW instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.iEW;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fpk = true;
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
    public void TI() {
        this.iEa.setNextPage(this.gdy);
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.setOnClickListener(null);
        this.gdy.startLoadData();
    }

    public void cxm() {
        this.iEa.setNextPage(this.gdy);
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.setOnClickListener(this.iKz);
        this.gdy.endLoadData();
        this.gdy.setText(this.iVJ.getResources().getString(R.string.list_click_load_more));
    }

    public void TJ() {
        this.iEa.setNextPage(this.gdy);
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.setOnClickListener(null);
        this.gdy.endLoadData();
        this.gdy.setText(this.iVJ.getResources().getString(R.string.list_has_no_more));
    }

    public void bNw() {
        this.iEa.setNextPage(null);
    }

    public void pI(boolean z) {
        this.dXU.setVisibility(z ? 0 : 8);
        qa(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.iLo.iZI = intValue;
                if (!this.iVQ) {
                    this.iVR = intValue;
                    a(intValue, this.iVL, false);
                    this.iVJ.zH(this.iVR);
                    t.clQ().op(false);
                    com.baidu.tieba.s.c.dGv().b(this.iVJ.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bMH();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.iVQ && (tab.getTag() instanceof Integer)) {
                this.iVR = ((Integer) tab.getTag()).intValue();
                this.iVJ.zH(this.iVR);
            }
            setTabColorSelected(tab);
        }
    }

    private void cBj() {
        if (this.iVK == null) {
            this.iVK = (TabLayout) LayoutInflater.from(this.iVJ.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.iVK.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.iVJ.getContext(), R.dimen.tbds126)));
            this.iVK.setOnTabSelectedListener(this);
            b(this.iVK);
            this.iEa.addHeaderView(this.iVK);
        }
    }

    private void cC(View view) {
        this.iVL = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.iVL.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.iVK, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bMH();
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

    private void qa(boolean z) {
        if (z) {
            this.iVL.setVisibility(8);
        } else if (this.iVL.getTabCount() > 1) {
            this.iVL.setVisibility(0);
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
                            cVar.qa(R.color.cp_cont_c);
                        } else if (at.isEmpty(this.iVO)) {
                            cVar.qa(R.color.cp_cont_b);
                        } else {
                            cVar.qb(com.baidu.tieba.lego.card.d.b.fv(this.iVO));
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
                this.iVO = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (at.isEmpty(this.iVO)) {
                cVar.qa(R.color.cp_cont_b);
            } else {
                cVar.qb(com.baidu.tieba.lego.card.d.b.fv(this.iVO));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).qa(R.color.cp_cont_c);
        }
    }

    public void Gh() {
        if (cBi() != null) {
            List<q> dataList = cBi().getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.exG != 0 && bvVar.erH != null) {
                            int[] imageWidthAndHeight = bvVar.erH.getImageWidthAndHeight();
                            bvVar.exG = imageWidthAndHeight[0];
                            bvVar.exH = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cBi().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Kx(String str) {
        if (this.iVJ.cBc() != null) {
            this.iVJ.cBc().Kz(str);
        }
    }

    public void Ky(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.iVM.getDataList())) {
            Iterator<q> it = this.iVM.cBq().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bFd() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bFd()).esU)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
