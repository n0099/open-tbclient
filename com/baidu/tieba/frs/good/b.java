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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
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
    private w aGS;
    private PbListView buU;
    private BdSwipeRefreshLayout bxI;
    private FrameLayout dnL;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private TabLayout dzB;
    private TabLayout dzC;
    private a dzD;
    private FrsGoodFragment dzn;
    private RelativeLayout blJ = null;
    private BdTypeRecyclerView dll = null;
    private h mPullView = null;
    private BannerView dzE = null;
    private boolean dzF = false;
    private boolean dzG = false;
    private int dzH = 0;
    private BannerView.a dzI = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FL() {
            b.this.ayv();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FM() {
            b.this.ayx();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.dzn = null;
        this.dzn = frsGoodFragment;
        k(view, z);
        this.ds10 = l.e(this.dzn.getPageContext().getPageActivity(), d.e.tbds10);
        this.ds32 = l.e(this.dzn.getPageContext().getPageActivity(), d.e.tbds32);
        this.ds210 = l.e(this.dzn.getPageContext().getPageActivity(), d.e.tbds210);
        this.ds82 = l.e(this.dzn.getPageContext().getPageActivity(), d.e.tbds82);
        this.ds34 = l.e(this.dzn.getPageContext().getPageActivity(), d.e.tbds34);
    }

    private void k(View view, boolean z) {
        this.blJ = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        ay(view);
        this.dll = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.dll.setLayoutManager(new LinearLayoutManager(this.dll.getContext()));
        this.mPullView = new h(this.dzn.getPageContext());
        this.dll.setFadingEdgeLength(0);
        this.dll.setOverScrollMode(2);
        this.dll.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
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
        this.buU = new PbListView(this.dzn.getPageContext().getPageActivity());
        this.buU.nn();
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.setHeight(l.e(this.dzn.getActivity(), d.e.tbds182));
        this.buU.AE();
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
        this.buU.dx(d.C0142d.cp_cont_e);
        this.dll.setOnSrollToBottomListener(this.dzn);
        if (this.bxI == null) {
            this.bxI = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.bxI.setProgressView(this.mPullView);
            am.j(this.bxI, d.C0142d.cp_bg_line_e);
        }
        this.dnL = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.dzD = new a(this.dzn, this.dll);
        cp(false);
    }

    private void b(w wVar) {
        if (this.dzE == null) {
            this.dzE = new BannerView(this.dzn.getPageContext().getPageActivity());
            this.dzE.setLayoutParams(new AbsListView.LayoutParams(-1, this.dzn.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dzE.setVisibility(8);
            this.dzE.setBannerViewClickListener(this.dzI);
            this.dzE.setBannerData(wVar);
            this.dzE.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void n(String str, boolean z) {
                    if (z && b.this.dzE.FJ() && !b.this.dzF && b.this.dll != null) {
                        b.this.dzF = true;
                        b.this.dll.addHeaderView(b.this.dzE, 1);
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
    public void ayv() {
        if (this.aGS != null) {
            String value = this.aGS.getValue();
            if (this.aGS.ui() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dzn.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aGS.ui() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dzn.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dzn.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aGS.ui() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.asd != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.asd) {
                        case FRS:
                            this.dzn.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dzn.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dzn.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dzn.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                az.zV().c(this.dzn.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dzn.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aGS.ui() == 4) {
                this.dzn.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dzn.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dll.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dzD.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dzD.onDestory();
        this.dll.setOnSrollToBottomListener(null);
        a(this.dzB);
        a(this.dzC);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void cp(boolean z) {
        if (!z) {
            this.bxI.setRefreshing(false);
        }
    }

    public void showListView() {
        this.dll.setVisibility(0);
    }

    public void auG() {
        if (this.dzD != null) {
            this.dzD.notifyDataSetChanged();
        }
    }

    public void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.baT() != null && lVar.baT().getGood_classify() != null && !this.dzn.dzw) {
            ArrayList<ab> good_classify = lVar.baT().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
            dVar.tabId = 0;
            dVar.name = this.dzn.getPageContext().getResources().getString(d.k.all);
            tabData.add(dVar);
            for (ab abVar : good_classify) {
                if (abVar != null && abVar.um() > 0 && !TextUtils.isEmpty(abVar.ul()) && !TextUtils.isEmpty(abVar.ul().trim())) {
                    com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                    dVar2.tabId = abVar.um();
                    dVar2.name = abVar.ul();
                    tabData.add(dVar2);
                }
            }
            if (com.baidu.tbadk.core.util.w.z(tabData) > 1) {
                ayz();
                this.dzG = true;
                a(tabData, this.dzB);
                a(tabData, this.dzC);
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
                    TextView textView = new TextView(this.dzn.getContext());
                    textView.setSingleLine();
                    am.i(textView, d.f.bg_item_good_tab_border);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(am.getColor(d.C0142d.cp_cont_j));
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                    layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(ap.f(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.dzH) {
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
        this.dzD.b(arrayList, lVar);
        this.dzG = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dll;
    }

    public void ayw() {
        this.dzD.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dll.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dzF && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aGS = forumData.getFrsBannerData();
            b(this.aGS);
            this.dzE.reset();
            this.dll.removeHeaderView(this.dzE);
            if (this.aGS.getType() == 1 && !TextUtils.isEmpty(this.aGS.uj())) {
                this.dzE.setData(this.dzn.getPageContext(), this.aGS.uj());
                if (this.aGS.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dzn.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void ayx() {
        if (this.dzE != null) {
            this.dzF = false;
            this.dll.removeHeaderView(this.dzE);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.dzD != null) {
            this.dzD.awv();
            this.dzD.notifyDataSetChanged();
            this.dzD.onChangeSkinType(i);
        }
        this.dzn.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dzn.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.blJ);
        if (this.dzE != null) {
            this.dzE.FK();
        }
        if (this.buU != null) {
            this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
            this.buU.dz(i);
        }
        am.j(this.bxI, d.C0142d.cp_bg_line_e);
        b(this.dzB);
        b(this.dzC);
    }

    public void startPullRefresh() {
        this.bxI.setRefreshing(true);
    }

    public a ayy() {
        return this.dzD;
    }

    public RelativeLayout avx() {
        return this.blJ;
    }

    public View avy() {
        return this.bxI;
    }

    public void auS() {
        if (com.baidu.tbadk.k.m.KK().KL()) {
            int lastVisiblePosition = this.dll.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dll.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dmh != null) {
                        com.baidu.tbadk.k.h perfLog = oVar.dmh.getPerfLog();
                        perfLog.fl(1000);
                        perfLog.aTJ = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dmh.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aj(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dmh.startLogPerf();
                    }
                    if (oVar.dmg != null && (oVar.dmg instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dmg;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fl(1000);
                                perfLog2.aTJ = true;
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
    public void Ud() {
        this.dll.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.AH();
    }

    public void Ue() {
        this.dll.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.AI();
        this.buU.setText(this.dzn.getResources().getString(d.k.list_has_no_more));
    }

    public void Uf() {
        this.dll.setNextPage(null);
    }

    public void fP(boolean z) {
        this.dnL.setVisibility(z ? 0 : 8);
        gi(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.drl.dBV = intValue;
                if (!this.dzG) {
                    this.dzH = intValue;
                    a(intValue, this.dzC, false);
                    this.dzn.ld(this.dzH);
                    v.aiz().ex(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bxI != null && this.bxI.isRefreshing()) {
            this.bxI.nX();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dzG && (tab.getTag() instanceof Integer)) {
                this.dzH = ((Integer) tab.getTag()).intValue();
                this.dzn.ld(this.dzH);
            }
            a(tab);
        }
    }

    private void ayz() {
        if (this.dzB == null) {
            this.dzB = (TabLayout) LayoutInflater.from(this.dzn.getContext()).inflate(d.i.frs_good_second_layout, (ViewGroup) null);
            this.dzB.setLayoutParams(new RecyclerView.LayoutParams(-1, l.e(this.dzn.getContext(), d.e.tbds146)));
            this.dzB.setOnTabSelectedListener(this);
            b(this.dzB);
            this.dll.addHeaderView(this.dzB);
        }
    }

    private void ay(View view) {
        this.dzC = (TabLayout) view.findViewById(d.g.frs_good_fake_tabview);
        this.dzC.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dzB, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bxI != null && b.this.bxI.isRefreshing()) {
                    b.this.bxI.nX();
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

    private void gi(boolean z) {
        if (z) {
            this.dzC.setVisibility(8);
        } else if (this.dzC.getTabCount() > 1) {
            this.dzC.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            am.j(tabLayout, d.C0142d.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                        TextView textView = (TextView) tabAt.getCustomView();
                        if (tabAt.isSelected()) {
                            textView.setTextColor(am.getColor(d.C0142d.cp_cont_b));
                        } else {
                            textView.setTextColor(am.getColor(d.C0142d.cp_cont_j));
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
            ((TextView) tab.getCustomView()).setTextColor(am.getColor(d.C0142d.cp_cont_b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(am.getColor(d.C0142d.cp_cont_j));
        }
    }
}
