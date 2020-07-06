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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.frs.u;
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
    private FrameLayout dlv;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private ab eoN;
    private PbListView fnt;
    private FrsGoodFragment hSO;
    private TabLayout hSP;
    private TabLayout hSQ;
    private b hSR;
    public String hST;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hCj = null;
    private BannerView hSS = null;
    private boolean hSU = false;
    private boolean hSV = false;
    private int hSW = 0;
    private BannerView.a hSX = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bdp() {
            a.this.cdh();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bdq() {
            a.this.cdj();
        }
    };
    private CustomMessageListener hSY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Fz(str);
                a.this.Fy(str);
                a.this.hSR.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.hSO = null;
        this.hSO = frsGoodFragment;
        m(view, z);
        this.ds16 = l.getDimens(this.hSO.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.hSO.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.hSO.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void m(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cd(view);
        this.hCj = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hCj.setLayoutManager(new LinearLayoutManager(this.hCj.getContext()));
        this.hCj.setFadingEdgeLength(0);
        this.hCj.setOverScrollMode(2);
        this.hCj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.fnt = new PbListView(this.hSO.getPageContext().getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.hSO.getActivity(), R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hCj.setOnSrollToBottomListener(this.hSO);
        this.dlv = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.hSR = new b(this.hSO, this.hCj);
        jc(false);
        this.hSO.registerListener(this.hSY);
    }

    private void b(ab abVar) {
        if (this.hSS == null) {
            this.hSS = new BannerView(this.hSO.getPageContext().getPageActivity());
            this.hSS.setLayoutParams(new AbsListView.LayoutParams(-1, this.hSO.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hSS.setVisibility(8);
            this.hSS.setBannerViewClickListener(this.hSX);
            this.hSS.setBannerData(abVar);
            this.hSS.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.hSS.bdn() && !a.this.hSU && a.this.hCj != null) {
                        a.this.hSU = true;
                        a.this.hCj.addHeaderView(a.this.hSS, 1);
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
    public void cdh() {
        if (this.eoN != null) {
            String value = this.eoN.getValue();
            if (this.eoN.aQB() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.hSO.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.eoN.aQB() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.hSO.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.hSO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eoN.aQB() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dVl != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dVl) {
                        case FRS:
                            this.hSO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hSO.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.hSO.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.hSO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bc.aWU().b(this.hSO.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hSO.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.eoN.aQB() == 4) {
                this.hSO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hSO.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.hSR != null) {
            this.hSR.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hCj.setOnScrollListener(onScrollListener);
    }

    public void a(z zVar) {
        this.hSR.a(zVar);
    }

    public void onDestroy() {
        this.hSR.onDestory();
        this.hCj.setOnSrollToBottomListener(null);
        a(this.hSP);
        a(this.hSQ);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void jc(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 301;
            uVar.eSL = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void caC() {
        u uVar = new u();
        uVar.tabId = 301;
        uVar.eSL = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void byK() {
        this.hCj.setVisibility(0);
    }

    public void bZk() {
        if (this.hSR != null) {
            this.hSR.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ah> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.hSO.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ah ahVar : good_classify) {
                if (ahVar != null && ahVar.aQE() > 0 && !TextUtils.isEmpty(ahVar.aQD()) && !TextUtils.isEmpty(ahVar.aQD().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = ahVar.aQE();
                    dVar2.name = ahVar.aQD();
                    tabData.add(dVar2);
                }
            }
            if (w.getCount(tabData) > 1) {
                cdl();
                this.hSV = true;
                a(tabData, this.hSP);
                a(tabData, this.hSQ);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.hSO.getContext());
                    com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                    dVar.mE(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(dVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(ar.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.hSW) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds28, 0, this.ds28, 0);
        }
    }

    public void a(ArrayList<q> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            r rVar = new r();
            arrayList = new ArrayList<>();
            arrayList.add(rVar);
        }
        this.hSR.b(arrayList, frsViewData);
        this.hSV = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.hCj;
    }

    public void cdi() {
        this.hSR.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hCj.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hSU && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.eoN = forumData.getFrsBannerData();
            b(this.eoN);
            this.hSS.reset();
            this.hCj.removeHeaderView(this.hSS);
            if (this.eoN.getType() == 1 && !TextUtils.isEmpty(this.eoN.aQC())) {
                this.hSS.setData(this.hSO.getPageContext(), this.eoN.aQC());
                if (this.eoN.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hSO.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cdj() {
        if (this.hSS != null) {
            this.hSU = false;
            this.hCj.removeHeaderView(this.hSS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hSR != null) {
            this.hSR.cbJ();
            this.hSR.notifyDataSetChanged();
            this.hSR.onChangeSkinType(i);
        }
        this.hSO.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hSO.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hSS != null) {
            this.hSS.bdo();
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(i);
        }
        b(this.hSP);
        b(this.hSQ);
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 301;
        uVar.eSL = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void btV() {
        u uVar = new u();
        uVar.tabId = 301;
        uVar.eSL = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public b cdk() {
        return this.hSR;
    }

    public RelativeLayout bLT() {
        return this.mContainer;
    }

    public void nt(boolean z) {
        com.baidu.tieba.frs.ab abVar = new com.baidu.tieba.frs.ab();
        abVar.tabId = 301;
        abVar.ecu = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, abVar));
    }

    public void bZz() {
        if (m.bhP().bhQ()) {
            int lastVisiblePosition = this.hCj.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hCj.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof t)) {
                    t tVar = (t) childAt.getTag();
                    if (tVar.hDg != null) {
                        h perfLog = tVar.hDg.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eAN = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            tVar.hDg.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        tVar.hDg.startLogPerf();
                    }
                    if (tVar.hDf != null && (tVar.hDf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = tVar.hDf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eAN = true;
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
    public void buJ() {
        this.hCj.setNextPage(this.fnt);
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.startLoadData();
    }

    public void buK() {
        this.hCj.setNextPage(this.fnt);
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.endLoadData();
        this.fnt.setText(this.hSO.getResources().getString(R.string.list_has_no_more));
    }

    public void buL() {
        this.hCj.setNextPage(null);
    }

    public void nu(boolean z) {
        this.dlv.setVisibility(z ? 0 : 8);
        nM(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.hIE.hWQ = intValue;
                if (!this.hSV) {
                    this.hSW = intValue;
                    a(intValue, this.hSQ, false);
                    this.hSO.vy(this.hSW);
                    s.bOB().mc(false);
                    c.dgY().b(this.hSO.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        btV();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.hSV && (tab.getTag() instanceof Integer)) {
                this.hSW = ((Integer) tab.getTag()).intValue();
                this.hSO.vy(this.hSW);
            }
            setTabColorSelected(tab);
        }
    }

    private void cdl() {
        if (this.hSP == null) {
            this.hSP = (TabLayout) LayoutInflater.from(this.hSO.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.hSP.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.hSO.getContext(), R.dimen.tbds126)));
            this.hSP.setOnTabSelectedListener(this);
            b(this.hSP);
            this.hCj.addHeaderView(this.hSP);
        }
    }

    private void cd(View view) {
        this.hSQ = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.hSQ.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.hSP, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.btV();
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

    private void nM(boolean z) {
        if (z) {
            this.hSQ.setVisibility(8);
        } else if (this.hSQ.getTabCount() > 1) {
            this.hSQ.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            an.setBackgroundColor(tabLayout, R.color.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                        if (!tabAt.isSelected()) {
                            dVar.mE(R.color.cp_cont_c);
                        } else if (ar.isEmpty(this.hST)) {
                            dVar.mE(R.color.cp_cont_b);
                        } else {
                            dVar.mF(com.baidu.tieba.lego.card.d.a.dV(this.hST));
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
            if (!ar.isEmpty(themeElement.font_color)) {
                this.hST = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (ar.isEmpty(this.hST)) {
                dVar.mE(R.color.cp_cont_b);
            } else {
                dVar.mF(com.baidu.tieba.lego.card.d.a.dV(this.hST));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).mE(R.color.cp_cont_c);
        }
    }

    public void yA() {
        if (cdk() != null) {
            List<q> dataList = cdk().getDataList();
            if (!w.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof bt) {
                        bt btVar = (bt) qVar;
                        if (btVar.dLj != 0 && btVar.dLi != null) {
                            int[] imageWidthAndHeight = btVar.dLi.getImageWidthAndHeight();
                            btVar.dLj = imageWidthAndHeight[0];
                            btVar.dLk = imageWidthAndHeight[1];
                        }
                    }
                }
                e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cdk().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Fy(String str) {
        if (this.hSO.cde() != null) {
            this.hSO.cde().FA(str);
        }
    }

    public void Fz(String str) {
        if (!StringUtils.isNull(str) && !w.isEmpty(this.hSR.getDataList())) {
            Iterator<q> it = this.hSR.cds().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bmw() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bmw()).dGL)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
