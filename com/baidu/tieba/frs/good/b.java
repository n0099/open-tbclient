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
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.e.c;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class b implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private v aGR;
    private PbListView bvC;
    private BdSwipeRefreshLayout byp;
    private FrsGoodFragment dBW;
    private TabLayout dCk;
    private TabLayout dCl;
    private a dCm;
    private FrameLayout dqC;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bmt = null;
    private BdTypeRecyclerView doa = null;
    private h mPullView = null;
    private BannerView dCn = null;
    private boolean dCo = false;
    private boolean dCp = false;
    private int dCq = 0;
    private BannerView.a dCr = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FH() {
            b.this.ayY();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FI() {
            b.this.aza();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.dBW = null;
        this.dBW = frsGoodFragment;
        j(view, z);
        this.ds10 = l.f(this.dBW.getPageContext().getPageActivity(), f.e.tbds10);
        this.ds32 = l.f(this.dBW.getPageContext().getPageActivity(), f.e.tbds32);
        this.ds210 = l.f(this.dBW.getPageContext().getPageActivity(), f.e.tbds210);
        this.ds82 = l.f(this.dBW.getPageContext().getPageActivity(), f.e.tbds82);
        this.ds34 = l.f(this.dBW.getPageContext().getPageActivity(), f.e.tbds34);
    }

    private void j(View view, boolean z) {
        this.bmt = (RelativeLayout) view.findViewById(f.g.frs_good_container);
        aB(view);
        this.doa = (BdTypeRecyclerView) view.findViewById(f.g.frs_good_lv_thread);
        this.doa.setLayoutManager(new LinearLayoutManager(this.doa.getContext()));
        this.mPullView = new h(this.dBW.getPageContext());
        this.doa.setFadingEdgeLength(0);
        this.doa.setOverScrollMode(2);
        this.doa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(f.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(f.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.bvC = new PbListView(this.dBW.getPageContext().getPageActivity());
        this.bvC.np();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.setHeight(l.f(this.dBW.getActivity(), f.e.tbds182));
        this.bvC.As();
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
        this.bvC.dz(f.d.cp_cont_e);
        this.doa.setOnSrollToBottomListener(this.dBW);
        if (this.byp == null) {
            this.byp = (BdSwipeRefreshLayout) view.findViewById(f.g.frs_pull_refresh_layout);
            this.byp.setProgressView(this.mPullView);
            am.j(this.byp, f.d.cp_bg_line_e);
        }
        this.dqC = (FrameLayout) view.findViewById(f.g.frs_list_content);
        this.dCm = new a(this.dBW, this.doa);
        cq(false);
    }

    private void b(v vVar) {
        if (this.dCn == null) {
            this.dCn = new BannerView(this.dBW.getPageContext().getPageActivity());
            this.dCn.setLayoutParams(new AbsListView.LayoutParams(-1, this.dBW.getResources().getDimensionPixelSize(f.e.ds100)));
            this.dCn.setVisibility(8);
            this.dCn.setBannerViewClickListener(this.dCr);
            this.dCn.setBannerData(vVar);
            this.dCn.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void m(String str, boolean z) {
                    if (z && b.this.dCn.FF() && !b.this.dCo && b.this.doa != null) {
                        b.this.dCo = true;
                        b.this.doa.addHeaderView(b.this.dCn, 1);
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
    public void ayY() {
        if (this.aGR != null) {
            String value = this.aGR.getValue();
            if (this.aGR.tU() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dBW.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aGR.tU() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dBW.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dBW.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aGR.tU() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.arH != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.arH) {
                        case FRS:
                            this.dBW.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dBW.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dBW.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dBW.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                az.zI().c(this.dBW.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dBW.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aGR.tU() == 4) {
                this.dBW.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dBW.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.doa.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dCm.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dCm.onDestory();
        this.doa.setOnSrollToBottomListener(null);
        a(this.dCk);
        a(this.dCl);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void cq(boolean z) {
        if (!z) {
            this.byp.setRefreshing(false);
        }
    }

    public void agP() {
        this.doa.setVisibility(0);
    }

    public void avj() {
        if (this.dCm != null) {
            this.dCm.notifyDataSetChanged();
        }
    }

    public void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.aZg() != null && lVar.aZg().getGood_classify() != null && !this.dBW.dCf) {
            ArrayList<aa> good_classify = lVar.aZg().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.dBW.getPageContext().getResources().getString(f.j.all);
            tabData.add(dVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.tY() > 0 && !TextUtils.isEmpty(aaVar.tX()) && !TextUtils.isEmpty(aaVar.tX().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = aaVar.tY();
                    dVar2.name = aaVar.tX();
                    tabData.add(dVar2);
                }
            }
            if (w.y(tabData) > 1) {
                azc();
                this.dCp = true;
                a(tabData, this.dCk);
                a(tabData, this.dCl);
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
                    TextView textView = new TextView(this.dBW.getContext());
                    textView.setSingleLine();
                    am.i(textView, f.C0146f.bg_item_good_tab_border);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(am.getColor(f.d.cp_cont_j));
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                    layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(ap.e(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.dCq) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds34, 0, this.ds34, 0);
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, int i, com.baidu.tieba.tbadkCore.l lVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dCm.b(arrayList, lVar);
        this.dCp = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.doa;
    }

    public void ayZ() {
        this.dCm.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.doa.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dCo && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aGR = forumData.getFrsBannerData();
            b(this.aGR);
            this.dCn.reset();
            this.doa.removeHeaderView(this.dCn);
            if (this.aGR.getType() == 1 && !TextUtils.isEmpty(this.aGR.tV())) {
                this.dCn.setData(this.dBW.getPageContext(), this.aGR.tV());
                if (this.aGR.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dBW.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void aza() {
        if (this.dCn != null) {
            this.dCo = false;
            this.doa.removeHeaderView(this.dCn);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.dCm != null) {
            this.dCm.awZ();
            this.dCm.notifyDataSetChanged();
            this.dCm.onChangeSkinType(i);
        }
        this.dBW.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dBW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bmt);
        if (this.dCn != null) {
            this.dCn.FG();
        }
        if (this.bvC != null) {
            this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
            this.bvC.dB(i);
        }
        am.j(this.byp, f.d.cp_bg_line_e);
        b(this.dCk);
        b(this.dCl);
    }

    public void startPullRefresh() {
        this.byp.setRefreshing(true);
    }

    public a azb() {
        return this.dCm;
    }

    public RelativeLayout awb() {
        return this.bmt;
    }

    public View awc() {
        return this.byp;
    }

    public void avv() {
        if (com.baidu.tbadk.l.m.KJ().KK()) {
            int lastVisiblePosition = this.doa.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.doa.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.doX != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.doX.getPerfLog();
                        perfLog.fl(1000);
                        perfLog.aTK = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.doX.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aj(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.doX.startLogPerf();
                    }
                    if (oVar.doW != null && (oVar.doW instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.doW;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fl(1000);
                                perfLog2.aTK = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > l.aj(TbadkCoreApplication.getInst().getContext())) {
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
    public void Uo() {
        this.doa.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.Av();
    }

    public void Up() {
        this.doa.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.Aw();
        this.bvC.setText(this.dBW.getResources().getString(f.j.list_has_no_more));
    }

    public void Uq() {
        this.doa.setNextPage(null);
    }

    public void fR(boolean z) {
        this.dqC.setVisibility(z ? 0 : 8);
        gk(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.dtV.dEE = intValue;
                if (!this.dCp) {
                    this.dCq = intValue;
                    a(intValue, this.dCl, false);
                    this.dBW.lo(this.dCq);
                    com.baidu.tieba.card.v.ajb().ey(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.byp != null && this.byp.isRefreshing()) {
            this.byp.nW();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dCp && (tab.getTag() instanceof Integer)) {
                this.dCq = ((Integer) tab.getTag()).intValue();
                this.dBW.lo(this.dCq);
            }
            a(tab);
        }
    }

    private void azc() {
        if (this.dCk == null) {
            this.dCk = (TabLayout) LayoutInflater.from(this.dBW.getContext()).inflate(f.h.frs_good_second_layout, (ViewGroup) null);
            this.dCk.setLayoutParams(new RecyclerView.LayoutParams(-1, l.f(this.dBW.getContext(), f.e.tbds146)));
            this.dCk.setOnTabSelectedListener(this);
            b(this.dCk);
            this.doa.addHeaderView(this.dCk);
        }
    }

    private void aB(View view) {
        this.dCl = (TabLayout) view.findViewById(f.g.frs_good_fake_tabview);
        this.dCl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dCk, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.byp != null && b.this.byp.isRefreshing()) {
                    b.this.byp.nW();
                }
                b.this.b(tab);
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

    private void gk(boolean z) {
        if (z) {
            this.dCl.setVisibility(8);
        } else if (this.dCl.getTabCount() > 1) {
            this.dCl.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            am.j(tabLayout, f.d.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                        TextView textView = (TextView) tabAt.getCustomView();
                        if (tabAt.isSelected()) {
                            textView.setTextColor(am.getColor(f.d.cp_cont_b));
                        } else {
                            textView.setTextColor(am.getColor(f.d.cp_cont_j));
                        }
                        am.i(textView, f.C0146f.bg_item_good_tab_border);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(am.getColor(f.d.cp_cont_b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(am.getColor(f.d.cp_cont_j));
        }
    }
}
