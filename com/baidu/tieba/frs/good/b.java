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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.e.c;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class b implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private v aGS;
    private PbListView bvA;
    private BdSwipeRefreshLayout byn;
    private FrsGoodFragment dBZ;
    private TabLayout dCn;
    private TabLayout dCo;
    private a dCp;
    private FrameLayout dqE;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bmp = null;
    private BdTypeRecyclerView dod = null;
    private h mPullView = null;
    private BannerView dCq = null;
    private boolean dCr = false;
    private boolean dCs = false;
    private int dCt = 0;
    private BannerView.a dCu = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FH() {
            b.this.aza();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FI() {
            b.this.azc();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.dBZ = null;
        this.dBZ = frsGoodFragment;
        j(view, z);
        this.ds10 = l.f(this.dBZ.getPageContext().getPageActivity(), d.e.tbds10);
        this.ds32 = l.f(this.dBZ.getPageContext().getPageActivity(), d.e.tbds32);
        this.ds210 = l.f(this.dBZ.getPageContext().getPageActivity(), d.e.tbds210);
        this.ds82 = l.f(this.dBZ.getPageContext().getPageActivity(), d.e.tbds82);
        this.ds34 = l.f(this.dBZ.getPageContext().getPageActivity(), d.e.tbds34);
    }

    private void j(View view, boolean z) {
        this.bmp = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        aB(view);
        this.dod = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.dod.setLayoutManager(new LinearLayoutManager(this.dod.getContext()));
        this.mPullView = new h(this.dBZ.getPageContext());
        this.dod.setFadingEdgeLength(0);
        this.dod.setOverScrollMode(2);
        this.dod.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
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
        this.bvA = new PbListView(this.dBZ.getPageContext().getPageActivity());
        this.bvA.np();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.setHeight(l.f(this.dBZ.getActivity(), d.e.tbds182));
        this.bvA.Au();
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
        this.bvA.dA(d.C0140d.cp_cont_e);
        this.dod.setOnSrollToBottomListener(this.dBZ);
        if (this.byn == null) {
            this.byn = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.byn.setProgressView(this.mPullView);
            am.j(this.byn, d.C0140d.cp_bg_line_e);
        }
        this.dqE = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.dCp = new a(this.dBZ, this.dod);
        cp(false);
    }

    private void b(v vVar) {
        if (this.dCq == null) {
            this.dCq = new BannerView(this.dBZ.getPageContext().getPageActivity());
            this.dCq.setLayoutParams(new AbsListView.LayoutParams(-1, this.dBZ.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dCq.setVisibility(8);
            this.dCq.setBannerViewClickListener(this.dCu);
            this.dCq.setBannerData(vVar);
            this.dCq.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void m(String str, boolean z) {
                    if (z && b.this.dCq.FF() && !b.this.dCr && b.this.dod != null) {
                        b.this.dCr = true;
                        b.this.dod.addHeaderView(b.this.dCq, 1);
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
    public void aza() {
        if (this.aGS != null) {
            String value = this.aGS.getValue();
            if (this.aGS.tV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dBZ.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aGS.tV() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dBZ.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dBZ.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aGS.tV() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.arG != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.arG) {
                        case FRS:
                            this.dBZ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dBZ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dBZ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dBZ.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ay.zK().c(this.dBZ.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dBZ.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aGS.tV() == 4) {
                this.dBZ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dBZ.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dod.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dCp.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dCp.onDestory();
        this.dod.setOnSrollToBottomListener(null);
        a(this.dCn);
        a(this.dCo);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void cp(boolean z) {
        if (!z) {
            this.byn.setRefreshing(false);
        }
    }

    public void agN() {
        this.dod.setVisibility(0);
    }

    public void avk() {
        if (this.dCp != null) {
            this.dCp.notifyDataSetChanged();
        }
    }

    public void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.aZl() != null && lVar.aZl().getGood_classify() != null && !this.dBZ.dCi) {
            ArrayList<aa> good_classify = lVar.aZl().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
            dVar.tabId = 0;
            dVar.name = this.dBZ.getPageContext().getResources().getString(d.j.all);
            tabData.add(dVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.tZ() > 0 && !TextUtils.isEmpty(aaVar.tY()) && !TextUtils.isEmpty(aaVar.tY().trim())) {
                    com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                    dVar2.tabId = aaVar.tZ();
                    dVar2.name = aaVar.tY();
                    tabData.add(dVar2);
                }
            }
            if (w.y(tabData) > 1) {
                aze();
                this.dCs = true;
                a(tabData, this.dCn);
                a(tabData, this.dCo);
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
                    TextView textView = new TextView(this.dBZ.getContext());
                    textView.setSingleLine();
                    am.i(textView, d.f.bg_item_good_tab_border);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(am.getColor(d.C0140d.cp_cont_j));
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                    layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(ap.f(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.dCt) {
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
        this.dCp.b(arrayList, lVar);
        this.dCs = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dod;
    }

    public void azb() {
        this.dCp.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dod.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dCr && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aGS = forumData.getFrsBannerData();
            b(this.aGS);
            this.dCq.reset();
            this.dod.removeHeaderView(this.dCq);
            if (this.aGS.getType() == 1 && !TextUtils.isEmpty(this.aGS.tW())) {
                this.dCq.setData(this.dBZ.getPageContext(), this.aGS.tW());
                if (this.aGS.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dBZ.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void azc() {
        if (this.dCq != null) {
            this.dCr = false;
            this.dod.removeHeaderView(this.dCq);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.dCp != null) {
            this.dCp.axa();
            this.dCp.notifyDataSetChanged();
            this.dCp.onChangeSkinType(i);
        }
        this.dBZ.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dBZ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bmp);
        if (this.dCq != null) {
            this.dCq.FG();
        }
        if (this.bvA != null) {
            this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
            this.bvA.dC(i);
        }
        am.j(this.byn, d.C0140d.cp_bg_line_e);
        b(this.dCn);
        b(this.dCo);
    }

    public void startPullRefresh() {
        this.byn.setRefreshing(true);
    }

    public a azd() {
        return this.dCp;
    }

    public RelativeLayout awc() {
        return this.bmp;
    }

    public View awd() {
        return this.byn;
    }

    public void avw() {
        if (com.baidu.tbadk.l.m.KF().KG()) {
            int lastVisiblePosition = this.dod.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dod.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.doZ != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.doZ.getPerfLog();
                        perfLog.fm(1000);
                        perfLog.aTK = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.doZ.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aj(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.doZ.startLogPerf();
                    }
                    if (oVar.doY != null && (oVar.doY instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.doY;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fm(1000);
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
    public void Ul() {
        this.dod.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.Ax();
    }

    public void Um() {
        this.dod.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.Ay();
        this.bvA.setText(this.dBZ.getResources().getString(d.j.list_has_no_more));
    }

    public void Un() {
        this.dod.setNextPage(null);
    }

    public void fR(boolean z) {
        this.dqE.setVisibility(z ? 0 : 8);
        gk(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.dtY.dEH = intValue;
                if (!this.dCs) {
                    this.dCt = intValue;
                    a(intValue, this.dCo, false);
                    this.dBZ.lo(this.dCt);
                    com.baidu.tieba.card.v.aiY().ey(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.byn != null && this.byn.isRefreshing()) {
            this.byn.nZ();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dCs && (tab.getTag() instanceof Integer)) {
                this.dCt = ((Integer) tab.getTag()).intValue();
                this.dBZ.lo(this.dCt);
            }
            a(tab);
        }
    }

    private void aze() {
        if (this.dCn == null) {
            this.dCn = (TabLayout) LayoutInflater.from(this.dBZ.getContext()).inflate(d.h.frs_good_second_layout, (ViewGroup) null);
            this.dCn.setLayoutParams(new RecyclerView.LayoutParams(-1, l.f(this.dBZ.getContext(), d.e.tbds146)));
            this.dCn.setOnTabSelectedListener(this);
            b(this.dCn);
            this.dod.addHeaderView(this.dCn);
        }
    }

    private void aB(View view) {
        this.dCo = (TabLayout) view.findViewById(d.g.frs_good_fake_tabview);
        this.dCo.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dCn, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.byn != null && b.this.byn.isRefreshing()) {
                    b.this.byn.nZ();
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
            this.dCo.setVisibility(8);
        } else if (this.dCo.getTabCount() > 1) {
            this.dCo.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            am.j(tabLayout, d.C0140d.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                        TextView textView = (TextView) tabAt.getCustomView();
                        if (tabAt.isSelected()) {
                            textView.setTextColor(am.getColor(d.C0140d.cp_cont_b));
                        } else {
                            textView.setTextColor(am.getColor(d.C0140d.cp_cont_j));
                        }
                        am.i(textView, d.f.bg_item_good_tab_border);
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
            ((TextView) tab.getCustomView()).setTextColor(am.getColor(d.C0140d.cp_cont_b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(am.getColor(d.C0140d.cp_cont_j));
        }
    }
}
