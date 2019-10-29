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
    private FrameLayout bHI;
    private x czT;
    private final int ds13;
    private final int ds212;
    private final int ds31;
    private final int ds32;
    private final int ds34;
    private final int ds74;
    private PbListView dwJ;
    private BdSwipeRefreshLayout dyk;
    private FrsGoodFragment fMJ;
    private TabLayout fMK;
    private TabLayout fML;
    private b fMM;
    public String fMO;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView fxt = null;
    private i mPullView = null;
    private BannerView fMN = null;
    private boolean fMP = false;
    private boolean fMQ = false;
    private int fMR = 0;
    private int fMS = R.color.cp_link_tip_a;
    private BannerView.a fMT = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void asn() {
            a.this.boG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aso() {
            a.this.boI();
        }
    };
    private CustomMessageListener fMU = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.wm(str);
                a.this.wl(str);
                a.this.fMM.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.fMJ = null;
        this.fMJ = frsGoodFragment;
        j(view, z);
        this.ds13 = l.getDimens(this.fMJ.getPageContext().getPageActivity(), R.dimen.tbds13);
        this.ds32 = l.getDimens(this.fMJ.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds212 = l.getDimens(this.fMJ.getPageContext().getPageActivity(), R.dimen.tbds212);
        this.ds74 = l.getDimens(this.fMJ.getPageContext().getPageActivity(), R.dimen.tbds74);
        this.ds34 = l.getDimens(this.fMJ.getPageContext().getPageActivity(), R.dimen.tbds34);
        this.ds31 = l.getDimens(this.fMJ.getPageContext().getPageActivity(), R.dimen.tbds31);
    }

    private void j(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bU(view);
        this.fxt = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fxt.setLayoutManager(new LinearLayoutManager(this.fxt.getContext()));
        this.mPullView = new i(this.fMJ.getPageContext());
        this.fxt.setFadingEdgeLength(0);
        this.fxt.setOverScrollMode(2);
        this.fxt.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.dwJ = new PbListView(this.fMJ.getPageContext().getPageActivity());
        this.dwJ.createView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setHeight(l.getDimens(this.fMJ.getActivity(), R.dimen.tbds182));
        this.dwJ.setLineGone();
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fxt.setOnSrollToBottomListener(this.fMJ);
        if (this.dyk == null) {
            this.dyk = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dyk.setProgressView(this.mPullView);
            am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
        }
        this.bHI = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fMM = new b(this.fMJ, this.fxt);
        fU(false);
        this.fMJ.registerListener(this.fMU);
    }

    private void b(x xVar) {
        if (this.fMN == null) {
            this.fMN = new BannerView(this.fMJ.getPageContext().getPageActivity());
            this.fMN.setLayoutParams(new AbsListView.LayoutParams(-1, this.fMJ.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fMN.setVisibility(8);
            this.fMN.setBannerViewClickListener(this.fMT);
            this.fMN.setBannerData(xVar);
            this.fMN.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.fMN.asl() && !a.this.fMP && a.this.fxt != null) {
                        a.this.fMP = true;
                        a.this.fxt.addHeaderView(a.this.fMN, 1);
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
    public void boG() {
        if (this.czT != null) {
            String value = this.czT.getValue();
            if (this.czT.ahg() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.fMJ.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.czT.ahg() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fMJ.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fMJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.czT.ahg() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ckz != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ckz) {
                        case FRS:
                            this.fMJ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fMJ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fMJ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fMJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.amQ().b(this.fMJ.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.fMJ.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.czT.ahg() == 4) {
                this.fMJ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.fMJ.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.fxt.setOnScrollListener(onScrollListener);
    }

    public void a(s sVar) {
        this.fMM.a(sVar);
    }

    public void onDestroy() {
        this.fMM.onDestory();
        this.fxt.setOnSrollToBottomListener(null);
        a(this.fMK);
        a(this.fML);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void fU(boolean z) {
        if (!z) {
            this.dyk.setRefreshing(false);
        }
    }

    public void aMq() {
        this.fxt.setVisibility(0);
    }

    public void bkS() {
        if (this.fMM != null) {
            this.fMM.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.fMJ.fMC) {
            ArrayList<ac> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.fMJ.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ac acVar : good_classify) {
                if (acVar != null && acVar.ahj() > 0 && !TextUtils.isEmpty(acVar.ahi()) && !TextUtils.isEmpty(acVar.ahi().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = acVar.ahj();
                    dVar2.name = acVar.ahi();
                    tabData.add(dVar2);
                }
            }
            if (v.getCount(tabData) > 1) {
                boK();
                this.fMQ = true;
                a(tabData, this.fMK);
                a(tabData, this.fML);
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
                    TextView textView = new TextView(this.fMJ.getContext());
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
                if (tabData.get(i2).tabId == this.fMR) {
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
        this.fMM.b(arrayList, frsViewData);
        this.fMQ = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.fxt;
    }

    public void boH() {
        this.fMM.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fxt.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fMP && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.czT = forumData.getFrsBannerData();
            b(this.czT);
            this.fMN.reset();
            this.fxt.removeHeaderView(this.fMN);
            if (this.czT.getType() == 1 && !TextUtils.isEmpty(this.czT.ahh())) {
                this.fMN.setData(this.fMJ.getPageContext(), this.czT.ahh());
                if (this.czT.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.fMJ.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void boI() {
        if (this.fMN != null) {
            this.fMP = false;
            this.fxt.removeHeaderView(this.fMN);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fMM != null) {
            this.fMM.bnd();
            this.fMM.notifyDataSetChanged();
            this.fMM.onChangeSkinType(i);
        }
        this.fMJ.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fMJ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fMN != null) {
            this.fMN.asm();
        }
        if (this.dwJ != null) {
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dwJ.changeSkin(i);
        }
        am.setBackgroundColor(this.dyk, R.color.cp_bg_line_d);
        b(this.fMK);
        b(this.fML);
    }

    public void startPullRefresh() {
        this.dyk.setRefreshing(true);
    }

    public b boJ() {
        return this.fMM;
    }

    public RelativeLayout aYd() {
        return this.mContainer;
    }

    public View bme() {
        return this.dyk;
    }

    public void blg() {
        if (com.baidu.tbadk.p.m.awN().awO()) {
            int lastVisiblePosition = this.fxt.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fxt.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fyr != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.fyr.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.cLY = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fyr.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fyr.startLogPerf();
                    }
                    if (oVar.fyq != null && (oVar.fyq instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fyq;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.cLY = true;
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
    public void aKi() {
        this.fxt.setNextPage(this.dwJ);
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.startLoadData();
    }

    public void aKj() {
        this.fxt.setNextPage(this.dwJ);
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.endLoadData();
        this.dwJ.setText(this.fMJ.getResources().getString(R.string.list_has_no_more));
    }

    public void aKk() {
        this.fxt.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bHI.setVisibility(z ? 0 : 8);
        kw(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.fDZ.fQF = intValue;
                if (!this.fMQ) {
                    this.fMR = intValue;
                    a(intValue, this.fML, false);
                    this.fMJ.rt(this.fMR);
                    t.baw().iK(false);
                    c.cnk().b(this.fMJ.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dyk != null && this.dyk.isRefreshing()) {
            this.dyk.interruptRefresh();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.fMQ && (tab.getTag() instanceof Integer)) {
                this.fMR = ((Integer) tab.getTag()).intValue();
                this.fMJ.rt(this.fMR);
            }
            a(tab);
        }
    }

    private void boK() {
        if (this.fMK == null) {
            this.fMK = (TabLayout) LayoutInflater.from(this.fMJ.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.fMK.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.fMJ.getContext(), R.dimen.tbds126)));
            this.fMK.setOnTabSelectedListener(this);
            b(this.fMK);
            this.fxt.addHeaderView(this.fMK);
        }
    }

    private void bU(View view) {
        this.fML = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.fML.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.fMK, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.dyk != null && a.this.dyk.isRefreshing()) {
                    a.this.dyk.interruptRefresh();
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
            this.fML.setVisibility(8);
        } else if (this.fML.getTabCount() > 1) {
            this.fML.setVisibility(0);
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
                    this.fMO = themeElement.font_color;
                }
            }
        }
    }

    private void a(TextView textView, int i, int i2, boolean z) {
        GradientDrawable o;
        if (textView != null) {
            int dimens = l.getDimens(this.fMJ.getPageContext().getPageActivity(), R.dimen.tbds1);
            int dimens2 = l.getDimens(this.fMJ.getPageContext().getPageActivity(), R.dimen.tbds80);
            if (z && !aq.isEmpty(this.fMO)) {
                o = am.b(dimens2, i, this.fMO, dimens);
                textView.setTextColor(Color.parseColor("#" + this.fMO));
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
            a(textView, R.color.cp_bg_line_e, this.fMS, true);
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
        if (boJ() != null) {
            List<m> dataList = boJ().getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bg) {
                        bg bgVar = (bg) mVar;
                        if (bgVar.cbr != 0 && bgVar.cbq != null) {
                            int[] imageWidthAndHeight = bgVar.cbq.getImageWidthAndHeight();
                            bgVar.cbr = imageWidthAndHeight[0];
                            bgVar.cbs = imageWidthAndHeight[1];
                        }
                    }
                }
                e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.boJ().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void wl(String str) {
        if (this.fMJ.boD() != null) {
            this.fMJ.boD().wn(str);
        }
    }

    public void wm(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.fMM.getDataList())) {
            Iterator<m> it = this.fMM.boP().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAX() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAX()).bXk)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
