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
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
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
/* loaded from: classes6.dex */
public class b implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private v aSW;
    private PbListView bOy;
    private BdSwipeRefreshLayout bRl;
    private TabLayout dYF;
    private TabLayout dYG;
    private a dYH;
    private FrsGoodFragment dYp;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private FrameLayout mListContainer;
    private RelativeLayout bAw = null;
    private BdTypeRecyclerView dJP = null;
    private k mPullView = null;
    private BannerView dYI = null;
    private boolean dYJ = false;
    private boolean dYK = false;
    private int dYL = 0;
    private BannerView.a dYM = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Ko() {
            b.this.aFG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Kp() {
            b.this.aFI();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.dYp = null;
        this.dYp = frsGoodFragment;
        i(view, z);
        this.ds10 = l.h(this.dYp.getPageContext().getPageActivity(), e.C0210e.tbds10);
        this.ds32 = l.h(this.dYp.getPageContext().getPageActivity(), e.C0210e.tbds32);
        this.ds210 = l.h(this.dYp.getPageContext().getPageActivity(), e.C0210e.tbds210);
        this.ds82 = l.h(this.dYp.getPageContext().getPageActivity(), e.C0210e.tbds82);
        this.ds34 = l.h(this.dYp.getPageContext().getPageActivity(), e.C0210e.tbds34);
    }

    private void i(View view, boolean z) {
        this.bAw = (RelativeLayout) view.findViewById(e.g.frs_good_container);
        aR(view);
        this.dJP = (BdTypeRecyclerView) view.findViewById(e.g.frs_good_lv_thread);
        this.dJP.setLayoutManager(new LinearLayoutManager(this.dJP.getContext()));
        this.mPullView = new k(this.dYp.getPageContext());
        this.dJP.setFadingEdgeLength(0);
        this.dJP.setOverScrollMode(2);
        this.dJP.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(e.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(e.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.bOy = new PbListView(this.dYp.getPageContext().getPageActivity());
        this.bOy.oD();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.setHeight(l.h(this.dYp.getActivity(), e.C0210e.tbds182));
        this.bOy.EZ();
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOy.ew(e.d.cp_cont_e);
        this.dJP.setOnSrollToBottomListener(this.dYp);
        if (this.bRl == null) {
            this.bRl = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_pull_refresh_layout);
            this.bRl.setProgressView(this.mPullView);
            al.j(this.bRl, e.d.cp_bg_line_e);
        }
        this.mListContainer = (FrameLayout) view.findViewById(e.g.frs_list_content);
        this.dYH = new a(this.dYp, this.dJP);
        di(false);
    }

    private void b(v vVar) {
        if (this.dYI == null) {
            this.dYI = new BannerView(this.dYp.getPageContext().getPageActivity());
            this.dYI.setLayoutParams(new AbsListView.LayoutParams(-1, this.dYp.getResources().getDimensionPixelSize(e.C0210e.ds100)));
            this.dYI.setVisibility(8);
            this.dYI.setBannerViewClickListener(this.dYM);
            this.dYI.setBannerData(vVar);
            this.dYI.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void s(String str, boolean z) {
                    if (z && b.this.dYI.Km() && !b.this.dYJ && b.this.dJP != null) {
                        b.this.dYJ = true;
                        b.this.dJP.addHeaderView(b.this.dYI, 1);
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
    public void aFG() {
        if (this.aSW != null) {
            String value = this.aSW.getValue();
            if (this.aSW.yt() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dYp.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aSW.yt() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dYp.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dYp.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aSW.yt() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aDf != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aDf) {
                        case FRS:
                            this.dYp.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dYp.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dYp.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dYp.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ay.Ef().c(this.dYp.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dYp.getPageContext().getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aSW.yt() == 4) {
                this.dYp.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dYp.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dJP.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dYH.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dYH.onDestory();
        this.dJP.setOnSrollToBottomListener(null);
        a(this.dYF);
        a(this.dYG);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void di(boolean z) {
        if (!z) {
            this.bRl.setRefreshing(false);
        }
    }

    public void amN() {
        this.dJP.setVisibility(0);
    }

    public void aBF() {
        if (this.dYH != null) {
            this.dYH.notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bgh() != null && lVar.bgh().getGood_classify() != null && !this.dYp.dYz) {
            ArrayList<aa> good_classify = lVar.bgh().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.dYp.getPageContext().getResources().getString(e.j.all);
            tabData.add(dVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.yw() > 0 && !TextUtils.isEmpty(aaVar.yv()) && !TextUtils.isEmpty(aaVar.yv().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = aaVar.yw();
                    dVar2.name = aaVar.yv();
                    tabData.add(dVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.H(tabData) > 1) {
                aFK();
                this.dYK = true;
                a(tabData, this.dYF);
                a(tabData, this.dYG);
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
                    TextView textView = new TextView(this.dYp.getContext());
                    textView.setSingleLine();
                    al.i(textView, e.f.bg_item_good_tab_border);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(al.getColor(e.d.cp_cont_j));
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                    layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(ao.e(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.dYL) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds34, 0, this.ds34, 0);
        }
    }

    public void a(ArrayList<h> arrayList, int i, com.baidu.tieba.tbadkCore.l lVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dYH.b(arrayList, lVar);
        this.dYK = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dJP;
    }

    public void aFH() {
        this.dYH.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dJP.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dYJ && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aSW = forumData.getFrsBannerData();
            b(this.aSW);
            this.dYI.reset();
            this.dJP.removeHeaderView(this.dYI);
            if (this.aSW.getType() == 1 && !TextUtils.isEmpty(this.aSW.yu())) {
                this.dYI.setData(this.dYp.getPageContext(), this.aSW.yu());
                if (this.aSW.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dYp.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void aFI() {
        if (this.dYI != null) {
            this.dYJ = false;
            this.dJP.removeHeaderView(this.dYI);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dYH != null) {
            this.dYH.aDN();
            this.dYH.notifyDataSetChanged();
            this.dYH.onChangeSkinType(i);
        }
        this.dYp.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dYp.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bAw);
        if (this.dYI != null) {
            this.dYI.Kn();
        }
        if (this.bOy != null) {
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bOy.ey(i);
        }
        al.j(this.bRl, e.d.cp_bg_line_e);
        b(this.dYF);
        b(this.dYG);
    }

    public void startPullRefresh() {
        this.bRl.setRefreshing(true);
    }

    public a aFJ() {
        return this.dYH;
    }

    public RelativeLayout aBQ() {
        return this.bAw;
    }

    public View aCP() {
        return this.bRl;
    }

    public void aBS() {
        if (com.baidu.tbadk.l.m.Pk().Pl()) {
            int lastVisiblePosition = this.dJP.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dJP.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dKK != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dKK.getPerfLog();
                        perfLog.gi(1000);
                        perfLog.bfM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dKK.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dKK.startLogPerf();
                    }
                    if (oVar.dKJ != null && (oVar.dKJ instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dKJ;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.gi(1000);
                                perfLog2.bfM = true;
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
    public void aaZ() {
        this.dJP.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.Fc();
    }

    public void aba() {
        this.dJP.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.Fd();
        this.bOy.setText(this.dYp.getResources().getString(e.j.list_has_no_more));
    }

    public void abb() {
        this.dJP.setNextPage(null);
    }

    public void gR(boolean z) {
        this.mListContainer.setVisibility(z ? 0 : 8);
        hk(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.dQi.ebq = intValue;
                if (!this.dYK) {
                    this.dYL = intValue;
                    a(intValue, this.dYG, false);
                    this.dYp.mW(this.dYL);
                    com.baidu.tieba.card.v.apD().ft(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bRl != null && this.bRl.isRefreshing()) {
            this.bRl.ph();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dYK && (tab.getTag() instanceof Integer)) {
                this.dYL = ((Integer) tab.getTag()).intValue();
                this.dYp.mW(this.dYL);
            }
            a(tab);
        }
    }

    private void aFK() {
        if (this.dYF == null) {
            this.dYF = (TabLayout) LayoutInflater.from(this.dYp.getContext()).inflate(e.h.frs_good_second_layout, (ViewGroup) null);
            this.dYF.setLayoutParams(new RecyclerView.LayoutParams(-1, l.h(this.dYp.getContext(), e.C0210e.tbds146)));
            this.dYF.setOnTabSelectedListener(this);
            b(this.dYF);
            this.dJP.addHeaderView(this.dYF);
        }
    }

    private void aR(View view) {
        this.dYG = (TabLayout) view.findViewById(e.g.frs_good_fake_tabview);
        this.dYG.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dYF, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bRl != null && b.this.bRl.isRefreshing()) {
                    b.this.bRl.ph();
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

    private void hk(boolean z) {
        if (z) {
            this.dYG.setVisibility(8);
        } else if (this.dYG.getTabCount() > 1) {
            this.dYG.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            al.j(tabLayout, e.d.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                        TextView textView = (TextView) tabAt.getCustomView();
                        if (tabAt.isSelected()) {
                            textView.setTextColor(al.getColor(e.d.cp_cont_b));
                        } else {
                            textView.setTextColor(al.getColor(e.d.cp_cont_j));
                        }
                        al.i(textView, e.f.bg_item_good_tab_border);
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
            ((TextView) tab.getCustomView()).setTextColor(al.getColor(e.d.cp_cont_b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(al.getColor(e.d.cp_cont_j));
        }
    }
}
