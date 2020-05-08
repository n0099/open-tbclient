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
    private FrameLayout cVI;
    private y dRI;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private PbListView ePr;
    private FrsGoodFragment hqa;
    private TabLayout hqb;
    private TabLayout hqc;
    private b hqd;
    public String hqf;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView haA = null;
    private BannerView hqe = null;
    private boolean hqg = false;
    private boolean hqh = false;
    private int hqi = 0;
    private BannerView.a hqj = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVc() {
            a.this.bTo();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVd() {
            a.this.bTq();
        }
    };
    private CustomMessageListener hqk = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Dp(str);
                a.this.Do(str);
                a.this.hqd.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.hqa = null;
        this.hqa = frsGoodFragment;
        j(view, z);
        this.ds16 = l.getDimens(this.hqa.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.hqa.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.hqa.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cc(view);
        this.haA = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.haA.setLayoutManager(new LinearLayoutManager(this.haA.getContext()));
        this.haA.setFadingEdgeLength(0);
        this.haA.setOverScrollMode(2);
        this.haA.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.ePr = new PbListView(this.hqa.getPageContext().getPageActivity());
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.hqa.getActivity(), R.dimen.tbds182));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.haA.setOnSrollToBottomListener(this.hqa);
        this.cVI = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.hqd = new b(this.hqa, this.haA);
        it(false);
        this.hqa.registerListener(this.hqk);
    }

    private void b(y yVar) {
        if (this.hqe == null) {
            this.hqe = new BannerView(this.hqa.getPageContext().getPageActivity());
            this.hqe.setLayoutParams(new AbsListView.LayoutParams(-1, this.hqa.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hqe.setVisibility(8);
            this.hqe.setBannerViewClickListener(this.hqj);
            this.hqe.setBannerData(yVar);
            this.hqe.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.hqe.aVa() && !a.this.hqg && a.this.haA != null) {
                        a.this.hqg = true;
                        a.this.haA.addHeaderView(a.this.hqe, 1);
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
    public void bTo() {
        if (this.dRI != null) {
            String value = this.dRI.getValue();
            if (this.dRI.aIV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.hqa.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.dRI.aIV() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.hqa.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.hqa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dRI.aIV() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dAn != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dAn) {
                        case FRS:
                            this.hqa.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hqa.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.hqa.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.hqa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aOV().b(this.hqa.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hqa.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.dRI.aIV() == 4) {
                this.hqa.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hqa.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.haA.setOnScrollListener(onScrollListener);
    }

    public void a(v vVar) {
        this.hqd.a(vVar);
    }

    public void onDestroy() {
        this.hqd.onDestory();
        this.haA.setOnSrollToBottomListener(null);
        a(this.hqb);
        a(this.hqc);
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
            sVar.etP = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bQR() {
        s sVar = new s();
        sVar.tabId = 301;
        sVar.etP = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bpT() {
        this.haA.setVisibility(0);
    }

    public void bPC() {
        if (this.hqd != null) {
            this.hqd.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ad> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.hqa.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ad adVar : good_classify) {
                if (adVar != null && adVar.aIY() > 0 && !TextUtils.isEmpty(adVar.aIX()) && !TextUtils.isEmpty(adVar.aIX().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = adVar.aIY();
                    dVar2.name = adVar.aIX();
                    tabData.add(dVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.getCount(tabData) > 1) {
                bTs();
                this.hqh = true;
                a(tabData, this.hqb);
                a(tabData, this.hqc);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.hqa.getContext());
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
                if (tabData.get(i2).tabId == this.hqi) {
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
        this.hqd.b(arrayList, frsViewData);
        this.hqh = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.haA;
    }

    public void bTp() {
        this.hqd.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.haA.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hqg && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.dRI = forumData.getFrsBannerData();
            b(this.dRI);
            this.hqe.reset();
            this.haA.removeHeaderView(this.hqe);
            if (this.dRI.getType() == 1 && !TextUtils.isEmpty(this.dRI.aIW())) {
                this.hqe.setData(this.hqa.getPageContext(), this.dRI.aIW());
                if (this.dRI.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hqa.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void bTq() {
        if (this.hqe != null) {
            this.hqg = false;
            this.haA.removeHeaderView(this.hqe);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hqd != null) {
            this.hqd.bRU();
            this.hqd.notifyDataSetChanged();
            this.hqd.onChangeSkinType(i);
        }
        this.hqa.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hqa.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hqe != null) {
            this.hqe.aVb();
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.changeSkin(i);
        }
        b(this.hqb);
        b(this.hqc);
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 301;
        sVar.etP = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void blx() {
        s sVar = new s();
        sVar.tabId = 301;
        sVar.etP = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public b bTr() {
        return this.hqd;
    }

    public RelativeLayout bCr() {
        return this.mContainer;
    }

    public void mN(boolean z) {
        com.baidu.tieba.frs.y yVar = new com.baidu.tieba.frs.y();
        yVar.tabId = 301;
        yVar.dGR = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    public void bPR() {
        if (com.baidu.tbadk.n.m.aZy().aZz()) {
            int lastVisiblePosition = this.haA.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.haA.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hby != null) {
                        h perfLog = rVar.hby.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.edI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hby.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hby.startLogPerf();
                    }
                    if (rVar.hbx != null && (rVar.hbx instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hbx;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.edI = true;
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
    public void bmm() {
        this.haA.setNextPage(this.ePr);
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.startLoadData();
    }

    public void bmn() {
        this.haA.setNextPage(this.ePr);
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.endLoadData();
        this.ePr.setText(this.hqa.getResources().getString(R.string.list_has_no_more));
    }

    public void bmo() {
        this.haA.setNextPage(null);
    }

    public void mO(boolean z) {
        this.cVI.setVisibility(z ? 0 : 8);
        nf(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.hgM.hue = intValue;
                if (!this.hqh) {
                    this.hqi = intValue;
                    a(intValue, this.hqc, false);
                    this.hqa.um(this.hqi);
                    com.baidu.tieba.card.r.bEW().lx(false);
                    c.cVo().b(this.hqa.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        blx();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.hqh && (tab.getTag() instanceof Integer)) {
                this.hqi = ((Integer) tab.getTag()).intValue();
                this.hqa.um(this.hqi);
            }
            setTabColorSelected(tab);
        }
    }

    private void bTs() {
        if (this.hqb == null) {
            this.hqb = (TabLayout) LayoutInflater.from(this.hqa.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.hqb.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.hqa.getContext(), R.dimen.tbds126)));
            this.hqb.setOnTabSelectedListener(this);
            b(this.hqb);
            this.haA.addHeaderView(this.hqb);
        }
    }

    private void cc(View view) {
        this.hqc = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.hqc.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.hqb, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.blx();
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
            this.hqc.setVisibility(8);
        } else if (this.hqc.getTabCount() > 1) {
            this.hqc.setVisibility(0);
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
                        } else if (aq.isEmpty(this.hqf)) {
                            dVar.lI(R.color.cp_cont_b);
                        } else {
                            dVar.lJ(com.baidu.tieba.lego.card.d.a.dA(this.hqf));
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
                this.hqf = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (aq.isEmpty(this.hqf)) {
                dVar.lI(R.color.cp_cont_b);
            } else {
                dVar.lJ(com.baidu.tieba.lego.card.d.a.dA(this.hqf));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).lI(R.color.cp_cont_c);
        }
    }

    public void wJ() {
        if (bTr() != null) {
            List<m> dataList = bTr().getDataList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.dqF != 0 && biVar.dqE != null) {
                            int[] imageWidthAndHeight = biVar.dqE.getImageWidthAndHeight();
                            biVar.dqF = imageWidthAndHeight[0];
                            biVar.dqG = imageWidthAndHeight[1];
                        }
                    }
                }
                e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bTr().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Do(String str) {
        if (this.hqa.bTl() != null) {
            this.hqa.bTl().Dq(str);
        }
    }

    public void Dp(String str) {
        if (!StringUtils.isNull(str) && !com.baidu.tbadk.core.util.v.isEmpty(this.hqd.getDataList())) {
            Iterator<m> it = this.hqd.bTy().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bdJ() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bdJ()).dms)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
