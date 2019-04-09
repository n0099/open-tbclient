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
    private FrameLayout bhG;
    private x ccB;
    private PbListView dbs;
    private BdSwipeRefreshLayout dcF;
    private final int ds13;
    private final int ds212;
    private final int ds31;
    private final int ds32;
    private final int ds34;
    private final int ds74;
    private FrsGoodFragment fpr;
    private TabLayout fpt;
    private TabLayout fpu;
    private b fpv;
    public String fpx;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout cMu = null;
    private BdTypeRecyclerView faG = null;
    private i mPullView = null;
    private BannerView fpw = null;
    private boolean fpy = false;
    private boolean fpz = false;
    private int fpA = 0;
    private int fpB = d.C0277d.cp_link_tip_a;
    private BannerView.a fpC = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void ajY() {
            a.this.bhg();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void ajZ() {
            a.this.bhi();
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.fpr = null;
        this.fpr = frsGoodFragment;
        l(view, z);
        this.ds13 = l.h(this.fpr.getPageContext().getPageActivity(), d.e.tbds13);
        this.ds32 = l.h(this.fpr.getPageContext().getPageActivity(), d.e.tbds32);
        this.ds212 = l.h(this.fpr.getPageContext().getPageActivity(), d.e.tbds212);
        this.ds74 = l.h(this.fpr.getPageContext().getPageActivity(), d.e.tbds74);
        this.ds34 = l.h(this.fpr.getPageContext().getPageActivity(), d.e.tbds34);
        this.ds31 = l.h(this.fpr.getPageContext().getPageActivity(), d.e.tbds31);
    }

    private void l(View view, boolean z) {
        this.cMu = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        bM(view);
        this.faG = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.faG.setLayoutManager(new LinearLayoutManager(this.faG.getContext()));
        this.mPullView = new i(this.fpr.getPageContext());
        this.faG.setFadingEdgeLength(0);
        this.faG.setOverScrollMode(2);
        this.faG.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.dbs = new PbListView(this.fpr.getPageContext().getPageActivity());
        this.dbs.oM();
        this.dbs.ia(d.C0277d.cp_bg_line_e);
        this.dbs.setHeight(l.h(this.fpr.getActivity(), d.e.tbds182));
        this.dbs.aew();
        this.dbs.setTextSize(d.e.tbfontsize33);
        this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbs.hZ(d.C0277d.cp_cont_e);
        this.faG.setOnSrollToBottomListener(this.fpr);
        if (this.dcF == null) {
            this.dcF = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.dcF.setProgressView(this.mPullView);
            al.l(this.dcF, d.C0277d.cp_bg_line_e);
        }
        this.bhG = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.fpv = new b(this.fpr, this.faG);
        fB(false);
    }

    private void b(x xVar) {
        if (this.fpw == null) {
            this.fpw = new BannerView(this.fpr.getPageContext().getPageActivity());
            this.fpw.setLayoutParams(new AbsListView.LayoutParams(-1, this.fpr.getResources().getDimensionPixelSize(d.e.ds100)));
            this.fpw.setVisibility(8);
            this.fpw.setBannerViewClickListener(this.fpC);
            this.fpw.setBannerData(xVar);
            this.fpw.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void L(String str, boolean z) {
                    if (z && a.this.fpw.ajW() && !a.this.fpy && a.this.faG != null) {
                        a.this.fpy = true;
                        a.this.faG.addHeaderView(a.this.fpw, 1);
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
    public void bhg() {
        if (this.ccB != null) {
            String value = this.ccB.getValue();
            if (this.ccB.Xl() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fpr.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.ccB.Xl() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fpr.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fpr.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ccB.Xl() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bLI != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bLI) {
                        case FRS:
                            this.fpr.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fpr.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fpr.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fpr.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.adA().c(this.fpr.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fpr.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.ccB.Xl() == 4) {
                this.fpr.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fpr.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.faG.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fpv.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fpv.onDestory();
        this.faG.setOnSrollToBottomListener(null);
        a(this.fpt);
        a(this.fpu);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void fB(boolean z) {
        if (!z) {
            this.dcF.setRefreshing(false);
        }
    }

    public void aOs() {
        this.faG.setVisibility(0);
    }

    public void bdv() {
        if (this.fpv != null) {
            this.fpv.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.fpr.fpk) {
            ArrayList<ac> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
            dVar.tabId = 0;
            dVar.name = this.fpr.getPageContext().getResources().getString(d.j.all);
            tabData.add(dVar);
            for (ac acVar : good_classify) {
                if (acVar != null && acVar.Xp() > 0 && !TextUtils.isEmpty(acVar.Xo()) && !TextUtils.isEmpty(acVar.Xo().trim())) {
                    com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                    dVar2.tabId = acVar.Xp();
                    dVar2.name = acVar.Xo();
                    tabData.add(dVar2);
                }
            }
            if (v.S(tabData) > 1) {
                bhk();
                this.fpz = true;
                a(tabData, this.fpt);
                a(tabData, this.fpu);
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
                    TextView textView = new TextView(this.fpr.getContext());
                    textView.setSingleLine();
                    al.k(textView, d.f.btn_white_corners_selector);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(al.getColor(d.C0277d.cp_cont_c));
                    a(textView, d.C0277d.cp_bg_line_d, d.C0277d.cp_bg_line_b, true);
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds212, this.ds74);
                    layoutParams.setMargins(this.ds13, this.ds32, this.ds13, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(ap.h(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.fpA) {
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
        this.fpv.b(arrayList, frsViewData);
        this.fpz = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.faG;
    }

    public void bhh() {
        this.fpv.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.faG.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fpy && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.ccB = forumData.getFrsBannerData();
            b(this.ccB);
            this.fpw.reset();
            this.faG.removeHeaderView(this.fpw);
            if (this.ccB.getType() == 1 && !TextUtils.isEmpty(this.ccB.Xm())) {
                this.fpw.setData(this.fpr.getPageContext(), this.ccB.Xm());
                if (this.ccB.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fpr.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void bhi() {
        if (this.fpw != null) {
            this.fpy = false;
            this.faG.removeHeaderView(this.fpw);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.fpv != null) {
            this.fpv.bfD();
            this.fpv.notifyDataSetChanged();
            this.fpv.onChangeSkinType(i);
        }
        this.fpr.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fpr.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cMu);
        if (this.fpw != null) {
            this.fpw.ajX();
        }
        if (this.dbs != null) {
            this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbs.ib(i);
        }
        al.l(this.dcF, d.C0277d.cp_bg_line_e);
        b(this.fpt);
        b(this.fpu);
    }

    public void startPullRefresh() {
        this.dcF.setRefreshing(true);
    }

    public b bhj() {
        return this.fpv;
    }

    public RelativeLayout bdJ() {
        return this.cMu;
    }

    public View beI() {
        return this.dcF;
    }

    public void bdL() {
        if (com.baidu.tbadk.o.m.apg().aph()) {
            int lastVisiblePosition = this.faG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.faG.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fbF != null) {
                        com.baidu.tbadk.o.h perfLog = oVar.fbF.getPerfLog();
                        perfLog.jW(1000);
                        perfLog.cqp = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fbF.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fbF.startLogPerf();
                    }
                    if (oVar.fbE != null && (oVar.fbE instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fbE;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.o.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.jW(1000);
                                perfLog2.cqp = true;
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
    public void aCr() {
        this.faG.setNextPage(this.dbs);
        this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbs.aez();
    }

    public void aCs() {
        this.faG.setNextPage(this.dbs);
        this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbs.aeA();
        this.dbs.setText(this.fpr.getResources().getString(d.j.list_has_no_more));
    }

    public void aCt() {
        this.faG.setNextPage(null);
    }

    public void jv(boolean z) {
        this.bhG.setVisibility(z ? 0 : 8);
        jK(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.fgQ.fsQ = intValue;
                if (!this.fpz) {
                    this.fpA = intValue;
                    a(intValue, this.fpu, false);
                    this.fpr.qU(this.fpA);
                    t.aQD().hQ(false);
                    c.cdp().b(this.fpr.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dcF != null && this.dcF.isRefreshing()) {
            this.dcF.pE();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.fpz && (tab.getTag() instanceof Integer)) {
                this.fpA = ((Integer) tab.getTag()).intValue();
                this.fpr.qU(this.fpA);
            }
            a(tab);
        }
    }

    private void bhk() {
        if (this.fpt == null) {
            this.fpt = (TabLayout) LayoutInflater.from(this.fpr.getContext()).inflate(d.h.frs_good_second_layout, (ViewGroup) null);
            this.fpt.setLayoutParams(new RecyclerView.LayoutParams(-1, l.h(this.fpr.getContext(), d.e.tbds126)));
            this.fpt.setOnTabSelectedListener(this);
            b(this.fpt);
            this.faG.addHeaderView(this.fpt);
        }
    }

    private void bM(View view) {
        this.fpu = (TabLayout) view.findViewById(d.g.frs_good_fake_tabview);
        this.fpu.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.fpt, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.dcF != null && a.this.dcF.isRefreshing()) {
                    a.this.dcF.pE();
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
            this.fpu.setVisibility(8);
        } else if (this.fpu.getTabCount() > 1) {
            this.fpu.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            al.l(tabLayout, d.C0277d.cp_bg_line_d);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                    TextView textView = (TextView) tabAt.getCustomView();
                    if (tabAt.isSelected()) {
                        textView.setTextColor(al.getColor(d.C0277d.cp_cont_b));
                    } else {
                        textView.setTextColor(al.getColor(d.C0277d.cp_cont_c));
                    }
                    a(textView, d.C0277d.cp_bg_line_d, d.C0277d.cp_bg_line_b, false);
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
                    this.fpx = themeElement.font_color;
                }
            }
        }
    }

    private void a(TextView textView, int i, int i2, boolean z) {
        GradientDrawable j;
        if (textView != null) {
            int h = l.h(this.fpr.getPageContext().getPageActivity(), d.e.tbds1);
            int h2 = l.h(this.fpr.getPageContext().getPageActivity(), d.e.tbds10);
            if (z && !ap.isEmpty(this.fpx)) {
                j = al.b(h2, i, this.fpx, h);
                textView.setTextColor(Color.parseColor("#" + this.fpx));
            } else {
                j = al.j(h2, i, i2, h);
                textView.setTextColor(al.getColor(d.C0277d.cp_cont_c));
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
            a(textView, d.C0277d.cp_bg_line_d, this.fpB, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        TextView textView;
        if (tab != null && tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, d.C0277d.cp_bg_line_d, d.C0277d.cp_bg_line_b, false);
        }
    }
}
