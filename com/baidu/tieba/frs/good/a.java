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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.q.c;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout bhB;
    private x ccy;
    private PbListView dbr;
    private BdSwipeRefreshLayout dcE;
    private final int ds13;
    private final int ds212;
    private final int ds31;
    private final int ds32;
    private final int ds34;
    private final int ds74;
    private FrsGoodFragment fpH;
    private TabLayout fpI;
    private TabLayout fpJ;
    private b fpK;
    public String fpM;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout cMu = null;
    private BdTypeRecyclerView faU = null;
    private i mPullView = null;
    private BannerView fpL = null;
    private boolean fpN = false;
    private boolean fpO = false;
    private int fpP = 0;
    private int fpQ = d.C0236d.cp_link_tip_a;
    private BannerView.a fpR = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void akc() {
            a.this.bhj();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void akd() {
            a.this.bhl();
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.fpH = null;
        this.fpH = frsGoodFragment;
        l(view, z);
        this.ds13 = l.h(this.fpH.getPageContext().getPageActivity(), d.e.tbds13);
        this.ds32 = l.h(this.fpH.getPageContext().getPageActivity(), d.e.tbds32);
        this.ds212 = l.h(this.fpH.getPageContext().getPageActivity(), d.e.tbds212);
        this.ds74 = l.h(this.fpH.getPageContext().getPageActivity(), d.e.tbds74);
        this.ds34 = l.h(this.fpH.getPageContext().getPageActivity(), d.e.tbds34);
        this.ds31 = l.h(this.fpH.getPageContext().getPageActivity(), d.e.tbds31);
    }

    private void l(View view, boolean z) {
        this.cMu = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        bM(view);
        this.faU = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.faU.setLayoutManager(new LinearLayoutManager(this.faU.getContext()));
        this.mPullView = new i(this.fpH.getPageContext());
        this.faU.setFadingEdgeLength(0);
        this.faU.setOverScrollMode(2);
        this.faU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(d.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(d.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.dbr = new PbListView(this.fpH.getPageContext().getPageActivity());
        this.dbr.oM();
        this.dbr.ib(d.C0236d.cp_bg_line_e);
        this.dbr.setHeight(l.h(this.fpH.getActivity(), d.e.tbds182));
        this.dbr.aez();
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
        this.dbr.ia(d.C0236d.cp_cont_e);
        this.faU.setOnSrollToBottomListener(this.fpH);
        if (this.dcE == null) {
            this.dcE = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.dcE.setProgressView(this.mPullView);
            al.l(this.dcE, d.C0236d.cp_bg_line_e);
        }
        this.bhB = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.fpK = new b(this.fpH, this.faU);
        fB(false);
    }

    private void b(x xVar) {
        if (this.fpL == null) {
            this.fpL = new BannerView(this.fpH.getPageContext().getPageActivity());
            this.fpL.setLayoutParams(new AbsListView.LayoutParams(-1, this.fpH.getResources().getDimensionPixelSize(d.e.ds100)));
            this.fpL.setVisibility(8);
            this.fpL.setBannerViewClickListener(this.fpR);
            this.fpL.setBannerData(xVar);
            this.fpL.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void L(String str, boolean z) {
                    if (z && a.this.fpL.aka() && !a.this.fpN && a.this.faU != null) {
                        a.this.fpN = true;
                        a.this.faU.addHeaderView(a.this.fpL, 1);
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
    public void bhj() {
        if (this.ccy != null) {
            String value = this.ccy.getValue();
            if (this.ccy.Xo() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fpH.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.ccy.Xo() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fpH.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fpH.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ccy.Xo() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bLE != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bLE) {
                        case FRS:
                            this.fpH.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fpH.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fpH.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fpH.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.adD().c(this.fpH.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fpH.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.ccy.Xo() == 4) {
                this.fpH.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fpH.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.faU.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fpK.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fpK.onDestory();
        this.faU.setOnSrollToBottomListener(null);
        a(this.fpI);
        a(this.fpJ);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void fB(boolean z) {
        if (!z) {
            this.dcE.setRefreshing(false);
        }
    }

    public void aOB() {
        this.faU.setVisibility(0);
    }

    public void bdy() {
        if (this.fpK != null) {
            this.fpK.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.fpH.fpA) {
            ArrayList<ac> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
            dVar.tabId = 0;
            dVar.name = this.fpH.getPageContext().getResources().getString(d.j.all);
            tabData.add(dVar);
            for (ac acVar : good_classify) {
                if (acVar != null && acVar.Xs() > 0 && !TextUtils.isEmpty(acVar.Xr()) && !TextUtils.isEmpty(acVar.Xr().trim())) {
                    com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                    dVar2.tabId = acVar.Xs();
                    dVar2.name = acVar.Xr();
                    tabData.add(dVar2);
                }
            }
            if (v.S(tabData) > 1) {
                bhn();
                this.fpO = true;
                a(tabData, this.fpI);
                a(tabData, this.fpJ);
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
                    TextView textView = new TextView(this.fpH.getContext());
                    textView.setSingleLine();
                    al.k(textView, d.f.btn_white_corners_selector);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(al.getColor(d.C0236d.cp_cont_c));
                    a(textView, d.C0236d.cp_bg_line_d, d.C0236d.cp_bg_line_b, true);
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds212, this.ds74);
                    layoutParams.setMargins(this.ds13, this.ds32, this.ds13, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(ap.h(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.fpP) {
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
        this.fpK.b(arrayList, frsViewData);
        this.fpO = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.faU;
    }

    public void bhk() {
        this.fpK.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.faU.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fpN && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.ccy = forumData.getFrsBannerData();
            b(this.ccy);
            this.fpL.reset();
            this.faU.removeHeaderView(this.fpL);
            if (this.ccy.getType() == 1 && !TextUtils.isEmpty(this.ccy.Xp())) {
                this.fpL.setData(this.fpH.getPageContext(), this.ccy.Xp());
                if (this.ccy.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fpH.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void bhl() {
        if (this.fpL != null) {
            this.fpN = false;
            this.faU.removeHeaderView(this.fpL);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.fpK != null) {
            this.fpK.bfG();
            this.fpK.notifyDataSetChanged();
            this.fpK.onChangeSkinType(i);
        }
        this.fpH.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fpH.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cMu);
        if (this.fpL != null) {
            this.fpL.akb();
        }
        if (this.dbr != null) {
            this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
            this.dbr.ic(i);
        }
        al.l(this.dcE, d.C0236d.cp_bg_line_e);
        b(this.fpI);
        b(this.fpJ);
    }

    public void startPullRefresh() {
        this.dcE.setRefreshing(true);
    }

    public b bhm() {
        return this.fpK;
    }

    public RelativeLayout bdM() {
        return this.cMu;
    }

    public View beL() {
        return this.dcE;
    }

    public void bdO() {
        if (com.baidu.tbadk.o.m.apl().apm()) {
            int lastVisiblePosition = this.faU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.faU.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fbT != null) {
                        com.baidu.tbadk.o.h perfLog = oVar.fbT.getPerfLog();
                        perfLog.jX(1000);
                        perfLog.cqm = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fbT.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fbT.startLogPerf();
                    }
                    if (oVar.fbS != null && (oVar.fbS instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fbS;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.o.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.jX(1000);
                                perfLog2.cqm = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > l.aQ(TbadkCoreApplication.getInst().getContext())) {
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
    public void aCv() {
        this.faU.setNextPage(this.dbr);
        this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeC();
    }

    public void aCw() {
        this.faU.setNextPage(this.dbr);
        this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeD();
        this.dbr.setText(this.fpH.getResources().getString(d.j.list_has_no_more));
    }

    public void aCx() {
        this.faU.setNextPage(null);
    }

    public void jv(boolean z) {
        this.bhB.setVisibility(z ? 0 : 8);
        jK(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.fhf.ftf = intValue;
                if (!this.fpO) {
                    this.fpP = intValue;
                    a(intValue, this.fpJ, false);
                    this.fpH.qY(this.fpP);
                    t.aQG().hQ(false);
                    c.cdr().b(this.fpH.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dcE != null && this.dcE.isRefreshing()) {
            this.dcE.pE();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.fpO && (tab.getTag() instanceof Integer)) {
                this.fpP = ((Integer) tab.getTag()).intValue();
                this.fpH.qY(this.fpP);
            }
            a(tab);
        }
    }

    private void bhn() {
        if (this.fpI == null) {
            this.fpI = (TabLayout) LayoutInflater.from(this.fpH.getContext()).inflate(d.h.frs_good_second_layout, (ViewGroup) null);
            this.fpI.setLayoutParams(new RecyclerView.LayoutParams(-1, l.h(this.fpH.getContext(), d.e.tbds126)));
            this.fpI.setOnTabSelectedListener(this);
            b(this.fpI);
            this.faU.addHeaderView(this.fpI);
        }
    }

    private void bM(View view) {
        this.fpJ = (TabLayout) view.findViewById(d.g.frs_good_fake_tabview);
        this.fpJ.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.fpI, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.dcE != null && a.this.dcE.isRefreshing()) {
                    a.this.dcE.pE();
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

    private void jK(boolean z) {
        if (z) {
            this.fpJ.setVisibility(8);
        } else if (this.fpJ.getTabCount() > 1) {
            this.fpJ.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            al.l(tabLayout, d.C0236d.cp_bg_line_d);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                    TextView textView = (TextView) tabAt.getCustomView();
                    if (tabAt.isSelected()) {
                        textView.setTextColor(al.getColor(d.C0236d.cp_cont_b));
                    } else {
                        textView.setTextColor(al.getColor(d.C0236d.cp_cont_c));
                    }
                    a(textView, d.C0236d.cp_bg_line_d, d.C0236d.cp_bg_line_b, false);
                }
            }
        }
    }

    public void a(ThemeColorInfo themeColorInfo) {
        ThemeElement themeElement;
        if (themeColorInfo != null) {
            this.mThemeColorInfo = themeColorInfo;
            if (this.mThemeColorInfo != null && this.mThemeColorInfo.day != null && this.mThemeColorInfo.night != null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    themeElement = this.mThemeColorInfo.night;
                } else {
                    themeElement = this.mThemeColorInfo.day;
                }
                if (!ap.isEmpty(themeElement.font_color)) {
                    this.fpM = themeElement.font_color;
                }
            }
        }
    }

    private void a(TextView textView, int i, int i2, boolean z) {
        GradientDrawable j;
        if (textView != null) {
            int h = l.h(this.fpH.getPageContext().getPageActivity(), d.e.tbds1);
            int h2 = l.h(this.fpH.getPageContext().getPageActivity(), d.e.tbds10);
            if (z && !ap.isEmpty(this.fpM)) {
                j = al.b(h2, i, this.fpM, h);
                textView.setTextColor(Color.parseColor("#" + this.fpM));
            } else {
                j = al.j(h2, i, i2, h);
                textView.setTextColor(al.getColor(d.C0236d.cp_cont_c));
            }
            if (j != null) {
                textView.setBackgroundDrawable(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        TextView textView;
        if (tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, d.C0236d.cp_bg_line_d, this.fpQ, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        TextView textView;
        if (tab != null && tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, d.C0236d.cp_bg_line_d, d.C0236d.cp_bg_line_b, false);
        }
    }
}
