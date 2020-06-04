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
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.frs.y;
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
    private FrameLayout dgJ;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private x egc;
    private PbListView fcj;
    private FrsGoodFragment hFB;
    private TabLayout hFC;
    private TabLayout hFD;
    private b hFE;
    public String hFG;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hpz = null;
    private BannerView hFF = null;
    private boolean hFH = false;
    private boolean hFI = false;
    private int hFJ = 0;
    private BannerView.a hFK = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bbn() {
            a.this.bZS();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bbo() {
            a.this.bZU();
        }
    };
    private CustomMessageListener hFL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.EY(str);
                a.this.EX(str);
                a.this.hFE.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.hFB = null;
        this.hFB = frsGoodFragment;
        m(view, z);
        this.ds16 = l.getDimens(this.hFB.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.hFB.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.hFB.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void m(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cc(view);
        this.hpz = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hpz.setLayoutManager(new LinearLayoutManager(this.hpz.getContext()));
        this.hpz.setFadingEdgeLength(0);
        this.hpz.setOverScrollMode(2);
        this.hpz.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.fcj = new PbListView(this.hFB.getPageContext().getPageActivity());
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.hFB.getActivity(), R.dimen.tbds182));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hpz.setOnSrollToBottomListener(this.hFB);
        this.dgJ = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.hFE = new b(this.hFB, this.hpz);
        iQ(false);
        this.hFB.registerListener(this.hFL);
    }

    private void b(x xVar) {
        if (this.hFF == null) {
            this.hFF = new BannerView(this.hFB.getPageContext().getPageActivity());
            this.hFF.setLayoutParams(new AbsListView.LayoutParams(-1, this.hFB.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hFF.setVisibility(8);
            this.hFF.setBannerViewClickListener(this.hFK);
            this.hFF.setBannerData(xVar);
            this.hFF.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.hFF.bbl() && !a.this.hFH && a.this.hpz != null) {
                        a.this.hFH = true;
                        a.this.hpz.addHeaderView(a.this.hFF, 1);
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
    public void bZS() {
        if (this.egc != null) {
            String value = this.egc.getValue();
            if (this.egc.aOQ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.hFB.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.egc.aOQ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.hFB.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.hFB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.egc.aOQ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dOt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dOt) {
                        case FRS:
                            this.hFB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hFB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.hFB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.hFB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aVa().b(this.hFB.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hFB.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.egc.aOQ() == 4) {
                this.hFB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hFB.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hpz.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.hFE.a(xVar);
    }

    public void onDestroy() {
        this.hFE.onDestory();
        this.hpz.setOnSrollToBottomListener(null);
        a(this.hFC);
        a(this.hFD);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void iQ(boolean z) {
        if (!z) {
            s sVar = new s();
            sVar.tabId = 301;
            sVar.eIz = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bXq() {
        s sVar = new s();
        sVar.tabId = 301;
        sVar.eIz = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bvO() {
        this.hpz.setVisibility(0);
    }

    public void bWb() {
        if (this.hFE != null) {
            this.hFE.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ac> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.hFB.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ac acVar : good_classify) {
                if (acVar != null && acVar.aOT() > 0 && !TextUtils.isEmpty(acVar.aOS()) && !TextUtils.isEmpty(acVar.aOS().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = acVar.aOT();
                    dVar2.name = acVar.aOS();
                    tabData.add(dVar2);
                }
            }
            if (v.getCount(tabData) > 1) {
                bZW();
                this.hFI = true;
                a(tabData, this.hFC);
                a(tabData, this.hFD);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.hFB.getContext());
                    com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                    dVar.mm(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(dVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(aq.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.hFJ) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds28, 0, this.ds28, 0);
        }
    }

    public void a(ArrayList<o> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            p pVar = new p();
            arrayList = new ArrayList<>();
            arrayList.add(pVar);
        }
        this.hFE.b(arrayList, frsViewData);
        this.hFI = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.hpz;
    }

    public void bZT() {
        this.hFE.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hpz.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hFH && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.egc = forumData.getFrsBannerData();
            b(this.egc);
            this.hFF.reset();
            this.hpz.removeHeaderView(this.hFF);
            if (this.egc.getType() == 1 && !TextUtils.isEmpty(this.egc.aOR())) {
                this.hFF.setData(this.hFB.getPageContext(), this.egc.aOR());
                if (this.egc.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hFB.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bZU() {
        if (this.hFF != null) {
            this.hFH = false;
            this.hpz.removeHeaderView(this.hFF);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hFE != null) {
            this.hFE.bYu();
            this.hFE.notifyDataSetChanged();
            this.hFE.onChangeSkinType(i);
        }
        this.hFB.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hFB.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hFF != null) {
            this.hFF.bbm();
        }
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.changeSkin(i);
        }
        b(this.hFC);
        b(this.hFD);
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 301;
        sVar.eIz = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bqX() {
        s sVar = new s();
        sVar.tabId = 301;
        sVar.eIz = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public b bZV() {
        return this.hFE;
    }

    public RelativeLayout bIN() {
        return this.mContainer;
    }

    public void ni(boolean z) {
        y yVar = new y();
        yVar.tabId = 301;
        yVar.dVd = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    public void bWq() {
        if (m.bfJ().bfK()) {
            int lastVisiblePosition = this.hpz.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hpz.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hqx != null) {
                        h perfLog = rVar.hqx.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.erV = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hqx.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hqx.startLogPerf();
                    }
                    if (rVar.hqw != null && (rVar.hqw instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hqw;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.erV = true;
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
    public void brM() {
        this.hpz.setNextPage(this.fcj);
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.startLoadData();
    }

    public void brN() {
        this.hpz.setNextPage(this.fcj);
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.endLoadData();
        this.fcj.setText(this.hFB.getResources().getString(R.string.list_has_no_more));
    }

    public void brO() {
        this.hpz.setNextPage(null);
    }

    public void nj(boolean z) {
        this.dgJ.setVisibility(z ? 0 : 8);
        nA(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.hvL.hJE = intValue;
                if (!this.hFI) {
                    this.hFJ = intValue;
                    a(intValue, this.hFD, false);
                    this.hFB.uT(this.hFJ);
                    com.baidu.tieba.card.s.bLs().lT(false);
                    c.dcI().b(this.hFB.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bqX();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.hFI && (tab.getTag() instanceof Integer)) {
                this.hFJ = ((Integer) tab.getTag()).intValue();
                this.hFB.uT(this.hFJ);
            }
            setTabColorSelected(tab);
        }
    }

    private void bZW() {
        if (this.hFC == null) {
            this.hFC = (TabLayout) LayoutInflater.from(this.hFB.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.hFC.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.hFB.getContext(), R.dimen.tbds126)));
            this.hFC.setOnTabSelectedListener(this);
            b(this.hFC);
            this.hpz.addHeaderView(this.hFC);
        }
    }

    private void cc(View view) {
        this.hFD = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.hFD.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.hFC, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bqX();
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

    private void nA(boolean z) {
        if (z) {
            this.hFD.setVisibility(8);
        } else if (this.hFD.getTabCount() > 1) {
            this.hFD.setVisibility(0);
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
                            dVar.mm(R.color.cp_cont_c);
                        } else if (aq.isEmpty(this.hFG)) {
                            dVar.mm(R.color.cp_cont_b);
                        } else {
                            dVar.mn(com.baidu.tieba.lego.card.d.a.dT(this.hFG));
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
                this.hFG = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (aq.isEmpty(this.hFG)) {
                dVar.mm(R.color.cp_cont_b);
            } else {
                dVar.mn(com.baidu.tieba.lego.card.d.a.dT(this.hFG));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).mm(R.color.cp_cont_c);
        }
    }

    public void ya() {
        if (bZV() != null) {
            List<o> dataList = bZV().getDataList();
            if (!v.isEmpty(dataList)) {
                for (o oVar : dataList) {
                    if (oVar instanceof bj) {
                        bj bjVar = (bj) oVar;
                        if (bjVar.dEB != 0 && bjVar.dEA != null) {
                            int[] imageWidthAndHeight = bjVar.dEA.getImageWidthAndHeight();
                            bjVar.dEB = imageWidthAndHeight[0];
                            bjVar.dEC = imageWidthAndHeight[1];
                        }
                    }
                }
                e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bZV().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void EX(String str) {
        if (this.hFB.bZP() != null) {
            this.hFB.bZP().EZ(str);
        }
    }

    public void EY(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.hFE.getDataList())) {
            Iterator<o> it = this.hFE.cad().iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bjW() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bjW()).dAu)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
