package com.baidu.tieba.frs.good;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.q.c;
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
/* loaded from: classes4.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout bGR;
    private x czc;
    private final int ds13;
    private final int ds212;
    private final int ds31;
    private final int ds32;
    private final int ds34;
    private final int ds74;
    private PbListView dvS;
    private BdSwipeRefreshLayout dxt;
    private FrsGoodFragment fLS;
    private TabLayout fLT;
    private TabLayout fLU;
    private b fLV;
    public String fLX;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView fwC = null;
    private i mPullView = null;
    private BannerView fLW = null;
    private boolean fLY = false;
    private boolean fLZ = false;
    private int fMa = 0;
    private int fMb = R.color.cp_link_tip_a;
    private BannerView.a fMc = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void asl() {
            a.this.boE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void asm() {
            a.this.boG();
        }
    };
    private CustomMessageListener fMd = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.wm(str);
                a.this.wl(str);
                a.this.fLV.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.fLS = null;
        this.fLS = frsGoodFragment;
        j(view, z);
        this.ds13 = l.getDimens(this.fLS.getPageContext().getPageActivity(), R.dimen.tbds13);
        this.ds32 = l.getDimens(this.fLS.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds212 = l.getDimens(this.fLS.getPageContext().getPageActivity(), R.dimen.tbds212);
        this.ds74 = l.getDimens(this.fLS.getPageContext().getPageActivity(), R.dimen.tbds74);
        this.ds34 = l.getDimens(this.fLS.getPageContext().getPageActivity(), R.dimen.tbds34);
        this.ds31 = l.getDimens(this.fLS.getPageContext().getPageActivity(), R.dimen.tbds31);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bU(view);
        this.fwC = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fwC.setLayoutManager(new LinearLayoutManager(this.fwC.getContext()));
        this.mPullView = new i(this.fLS.getPageContext());
        this.fwC.setFadingEdgeLength(0);
        this.fwC.setOverScrollMode(2);
        this.fwC.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.dvS = new PbListView(this.fLS.getPageContext().getPageActivity());
        this.dvS.createView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setHeight(l.getDimens(this.fLS.getActivity(), R.dimen.tbds182));
        this.dvS.setLineGone();
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fwC.setOnSrollToBottomListener(this.fLS);
        if (this.dxt == null) {
            this.dxt = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dxt.setProgressView(this.mPullView);
            am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
        }
        this.bGR = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fLV = new b(this.fLS, this.fwC);
        fU(false);
        this.fLS.registerListener(this.fMd);
    }

    private void b(x xVar) {
        if (this.fLW == null) {
            this.fLW = new BannerView(this.fLS.getPageContext().getPageActivity());
            this.fLW.setLayoutParams(new AbsListView.LayoutParams(-1, this.fLS.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fLW.setVisibility(8);
            this.fLW.setBannerViewClickListener(this.fMc);
            this.fLW.setBannerData(xVar);
            this.fLW.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.fLW.asj() && !a.this.fLY && a.this.fwC != null) {
                        a.this.fLY = true;
                        a.this.fwC.addHeaderView(a.this.fLW, 1);
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
    public void boE() {
        if (this.czc != null) {
            String value = this.czc.getValue();
            if (this.czc.ahe() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.fLS.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.czc.ahe() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fLS.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fLS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.czc.ahe() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.cjI != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.cjI) {
                        case FRS:
                            this.fLS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fLS.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fLS.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fLS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.amO().b(this.fLS.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.fLS.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.czc.ahe() == 4) {
                this.fLS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fLS.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(h.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.fwC.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.fLV.a(sVar);
    }

    public void onDestroy() {
        this.fLV.onDestory();
        this.fwC.setOnSrollToBottomListener(null);
        a(this.fLT);
        a(this.fLU);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void fU(boolean z) {
        if (!z) {
            this.dxt.setRefreshing(false);
        }
    }

    public void aMo() {
        this.fwC.setVisibility(0);
    }

    public void bkQ() {
        if (this.fLV != null) {
            this.fLV.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.fLS.fLL) {
            ArrayList<ac> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.fLS.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ac acVar : good_classify) {
                if (acVar != null && acVar.ahh() > 0 && !TextUtils.isEmpty(acVar.ahg()) && !TextUtils.isEmpty(acVar.ahg().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = acVar.ahh();
                    dVar2.name = acVar.ahg();
                    tabData.add(dVar2);
                }
            }
            if (v.getCount(tabData) > 1) {
                boI();
                this.fLZ = true;
                a(tabData, this.fLT);
                a(tabData, this.fLU);
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
                if (!(tab.getCustomView() instanceof TextView)) {
                    TextView textView = new TextView(this.fLS.getContext());
                    textView.setSingleLine();
                    am.setBackgroundResource(textView, R.drawable.btn_white_corners_selector);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(am.getColor(R.color.cp_cont_c));
                    a(textView, R.color.cp_bg_line_e, R.color.cp_btn_b, true);
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds212, this.ds74);
                    layoutParams.setMargins(this.ds13, this.ds32, this.ds13, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(aq.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.fMa) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds31, 0, this.ds31, 0);
        }
    }

    public void a(ArrayList<m> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.fLV.b(arrayList, frsViewData);
        this.fLZ = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.fwC;
    }

    public void boF() {
        this.fLV.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fwC.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fLY && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.czc = forumData.getFrsBannerData();
            b(this.czc);
            this.fLW.reset();
            this.fwC.removeHeaderView(this.fLW);
            if (this.czc.getType() == 1 && !TextUtils.isEmpty(this.czc.ahf())) {
                this.fLW.setData(this.fLS.getPageContext(), this.czc.ahf());
                if (this.czc.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.fLS.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void boG() {
        if (this.fLW != null) {
            this.fLY = false;
            this.fwC.removeHeaderView(this.fLW);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fLV != null) {
            this.fLV.bnb();
            this.fLV.notifyDataSetChanged();
            this.fLV.onChangeSkinType(i);
        }
        this.fLS.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fLS.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fLW != null) {
            this.fLW.ask();
        }
        if (this.dvS != null) {
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.changeSkin(i);
        }
        am.setBackgroundColor(this.dxt, R.color.cp_bg_line_d);
        b(this.fLT);
        b(this.fLU);
    }

    public void startPullRefresh() {
        this.dxt.setRefreshing(true);
    }

    public b boH() {
        return this.fLV;
    }

    public RelativeLayout aYb() {
        return this.mContainer;
    }

    public View bmc() {
        return this.dxt;
    }

    public void ble() {
        if (com.baidu.tbadk.p.m.awL().awM()) {
            int lastVisiblePosition = this.fwC.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fwC.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fxA != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.fxA.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.cLh = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fxA.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fxA.startLogPerf();
                    }
                    if (oVar.fxz != null && (oVar.fxz instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fxz;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.cLh = true;
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
    public void aKg() {
        this.fwC.setNextPage(this.dvS);
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.startLoadData();
    }

    public void aKh() {
        this.fwC.setNextPage(this.dvS);
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.endLoadData();
        this.dvS.setText(this.fLS.getResources().getString(R.string.list_has_no_more));
    }

    public void aKi() {
        this.fwC.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bGR.setVisibility(z ? 0 : 8);
        kw(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.fDi.fPO = intValue;
                if (!this.fLZ) {
                    this.fMa = intValue;
                    a(intValue, this.fLU, false);
                    this.fLS.rs(this.fMa);
                    t.bau().iK(false);
                    c.cni().b(this.fLS.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dxt != null && this.dxt.isRefreshing()) {
            this.dxt.interruptRefresh();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.fLZ && (tab.getTag() instanceof Integer)) {
                this.fMa = ((Integer) tab.getTag()).intValue();
                this.fLS.rs(this.fMa);
            }
            a(tab);
        }
    }

    private void boI() {
        if (this.fLT == null) {
            this.fLT = (TabLayout) LayoutInflater.from(this.fLS.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.fLT.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.fLS.getContext(), R.dimen.tbds126)));
            this.fLT.setOnTabSelectedListener(this);
            b(this.fLT);
            this.fwC.addHeaderView(this.fLT);
        }
    }

    private void bU(View view) {
        this.fLU = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.fLU.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.fLT, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.dxt != null && a.this.dxt.isRefreshing()) {
                    a.this.dxt.interruptRefresh();
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

    private void kw(boolean z) {
        if (z) {
            this.fLU.setVisibility(8);
        } else if (this.fLU.getTabCount() > 1) {
            this.fLU.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            am.setBackgroundColor(tabLayout, R.color.cp_bg_line_e);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                    TextView textView = (TextView) tabAt.getCustomView();
                    if (tabAt.isSelected()) {
                        textView.setTextColor(am.getColor(R.color.cp_cont_b));
                    } else {
                        textView.setTextColor(am.getColor(R.color.cp_cont_c));
                    }
                    a(textView, R.color.cp_bg_line_e, R.color.cp_btn_b, false);
                }
            }
        }
    }

    public void a(ThemeColorInfo themeColorInfo) {
        ThemeElement themeElement;
        if (themeColorInfo != null) {
            this.mThemeColorInfo = themeColorInfo;
            if (this.mThemeColorInfo != null && this.mThemeColorInfo.day != null && this.mThemeColorInfo.night != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 1 || skinType == 4) {
                    themeElement = this.mThemeColorInfo.night;
                } else {
                    themeElement = this.mThemeColorInfo.day;
                }
                if (!aq.isEmpty(themeElement.font_color)) {
                    this.fLX = themeElement.font_color;
                }
            }
        }
    }

    private void a(TextView textView, int i, int i2, boolean z) {
        GradientDrawable o;
        if (textView != null) {
            int dimens = l.getDimens(this.fLS.getPageContext().getPageActivity(), R.dimen.tbds1);
            int dimens2 = l.getDimens(this.fLS.getPageContext().getPageActivity(), R.dimen.tbds80);
            if (z && !aq.isEmpty(this.fLX)) {
                o = am.b(dimens2, i, this.fLX, dimens);
                textView.setTextColor(Color.parseColor("#" + this.fLX));
            } else {
                o = am.o(dimens2, i, i2, dimens);
                textView.setTextColor(am.getColor(R.color.cp_cont_c));
            }
            if (o != null) {
                textView.setBackgroundDrawable(o);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        TextView textView;
        if (tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, R.color.cp_bg_line_e, this.fMb, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        TextView textView;
        if (tab != null && tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, R.color.cp_bg_line_e, R.color.cp_btn_b, false);
        }
    }

    public void pC() {
        if (boH() != null) {
            List<m> dataList = boH().getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bg) {
                        bg bgVar = (bg) mVar;
                        if (bgVar.caA != 0 && bgVar.caz != null) {
                            int[] imageWidthAndHeight = bgVar.caz.getImageWidthAndHeight();
                            bgVar.caA = imageWidthAndHeight[0];
                            bgVar.caB = imageWidthAndHeight[1];
                        }
                    }
                }
                e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.boH().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void wl(String str) {
        if (this.fLS.boB() != null) {
            this.fLS.boB().wn(str);
        }
    }

    public void wm(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.fLV.getDataList())) {
            Iterator<m> it = this.fLV.boN().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAV() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAV()).bWt)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
