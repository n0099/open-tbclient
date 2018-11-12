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
    private v aPx;
    private PbListView bKJ;
    private BdSwipeRefreshLayout bNu;
    private FrsGoodFragment dRN;
    private TabLayout dSd;
    private TabLayout dSe;
    private a dSf;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private FrameLayout mListContainer;
    private RelativeLayout bwZ = null;
    private BdTypeRecyclerView dDq = null;
    private k mPullView = null;
    private BannerView dSg = null;
    private boolean dSh = false;
    private boolean dSi = false;
    private int dSj = 0;
    private BannerView.a dSk = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jk() {
            b.this.aDU();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jl() {
            b.this.aDW();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.dRN = null;
        this.dRN = frsGoodFragment;
        i(view, z);
        this.ds10 = l.h(this.dRN.getPageContext().getPageActivity(), e.C0200e.tbds10);
        this.ds32 = l.h(this.dRN.getPageContext().getPageActivity(), e.C0200e.tbds32);
        this.ds210 = l.h(this.dRN.getPageContext().getPageActivity(), e.C0200e.tbds210);
        this.ds82 = l.h(this.dRN.getPageContext().getPageActivity(), e.C0200e.tbds82);
        this.ds34 = l.h(this.dRN.getPageContext().getPageActivity(), e.C0200e.tbds34);
    }

    private void i(View view, boolean z) {
        this.bwZ = (RelativeLayout) view.findViewById(e.g.frs_good_container);
        aR(view);
        this.dDq = (BdTypeRecyclerView) view.findViewById(e.g.frs_good_lv_thread);
        this.dDq.setLayoutManager(new LinearLayoutManager(this.dDq.getContext()));
        this.mPullView = new k(this.dRN.getPageContext());
        this.dDq.setFadingEdgeLength(0);
        this.dDq.setOverScrollMode(2);
        this.dDq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
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
        this.bKJ = new PbListView(this.dRN.getPageContext().getPageActivity());
        this.bKJ.oE();
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.setHeight(l.h(this.dRN.getActivity(), e.C0200e.tbds182));
        this.bKJ.DV();
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bKJ.ei(e.d.cp_cont_e);
        this.dDq.setOnSrollToBottomListener(this.dRN);
        if (this.bNu == null) {
            this.bNu = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_pull_refresh_layout);
            this.bNu.setProgressView(this.mPullView);
            al.j(this.bNu, e.d.cp_bg_line_e);
        }
        this.mListContainer = (FrameLayout) view.findViewById(e.g.frs_list_content);
        this.dSf = new a(this.dRN, this.dDq);
        dh(false);
    }

    private void b(v vVar) {
        if (this.dSg == null) {
            this.dSg = new BannerView(this.dRN.getPageContext().getPageActivity());
            this.dSg.setLayoutParams(new AbsListView.LayoutParams(-1, this.dRN.getResources().getDimensionPixelSize(e.C0200e.ds100)));
            this.dSg.setVisibility(8);
            this.dSg.setBannerViewClickListener(this.dSk);
            this.dSg.setBannerData(vVar);
            this.dSg.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void r(String str, boolean z) {
                    if (z && b.this.dSg.Ji() && !b.this.dSh && b.this.dDq != null) {
                        b.this.dSh = true;
                        b.this.dDq.addHeaderView(b.this.dSg, 1);
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
    public void aDU() {
        if (this.aPx != null) {
            String value = this.aPx.getValue();
            if (this.aPx.xo() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dRN.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aPx.xo() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dRN.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dRN.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aPx.xo() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.azF != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.azF) {
                        case FRS:
                            this.dRN.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dRN.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dRN.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dRN.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ay.Db().c(this.dRN.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dRN.getPageContext().getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aPx.xo() == 4) {
                this.dRN.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dRN.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dDq.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dSf.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dSf.onDestory();
        this.dDq.setOnSrollToBottomListener(null);
        a(this.dSd);
        a(this.dSe);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void dh(boolean z) {
        if (!z) {
            this.bNu.setRefreshing(false);
        }
    }

    public void alG() {
        this.dDq.setVisibility(0);
    }

    public void azV() {
        if (this.dSf != null) {
            this.dSf.notifyDataSetChanged();
        }
    }

    public void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.ber() != null && lVar.ber().getGood_classify() != null && !this.dRN.dRX) {
            ArrayList<aa> good_classify = lVar.ber().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.dRN.getPageContext().getResources().getString(e.j.all);
            tabData.add(dVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.xs() > 0 && !TextUtils.isEmpty(aaVar.xr()) && !TextUtils.isEmpty(aaVar.xr().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = aaVar.xs();
                    dVar2.name = aaVar.xr();
                    tabData.add(dVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.H(tabData) > 1) {
                aDY();
                this.dSi = true;
                a(tabData, this.dSd);
                a(tabData, this.dSe);
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
                    TextView textView = new TextView(this.dRN.getContext());
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
                if (tabData.get(i2).tabId == this.dSj) {
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
        this.dSf.b(arrayList, lVar);
        this.dSi = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dDq;
    }

    public void aDV() {
        this.dSf.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dDq.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dSh && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aPx = forumData.getFrsBannerData();
            b(this.aPx);
            this.dSg.reset();
            this.dDq.removeHeaderView(this.dSg);
            if (this.aPx.getType() == 1 && !TextUtils.isEmpty(this.aPx.xp())) {
                this.dSg.setData(this.dRN.getPageContext(), this.aPx.xp());
                if (this.aPx.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dRN.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void aDW() {
        if (this.dSg != null) {
            this.dSh = false;
            this.dDq.removeHeaderView(this.dSg);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.dSf != null) {
            this.dSf.aCb();
            this.dSf.notifyDataSetChanged();
            this.dSf.onChangeSkinType(i);
        }
        this.dRN.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dRN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bwZ);
        if (this.dSg != null) {
            this.dSg.Jj();
        }
        if (this.bKJ != null) {
            this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bKJ.ek(i);
        }
        al.j(this.bNu, e.d.cp_bg_line_e);
        b(this.dSd);
        b(this.dSe);
    }

    public void startPullRefresh() {
        this.bNu.setRefreshing(true);
    }

    public a aDX() {
        return this.dSf;
    }

    public RelativeLayout aAg() {
        return this.bwZ;
    }

    public View aBf() {
        return this.bNu;
    }

    public void aAi() {
        if (com.baidu.tbadk.l.m.Og().Oh()) {
            int lastVisiblePosition = this.dDq.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dDq.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dEl != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dEl.getPerfLog();
                        perfLog.fU(1000);
                        perfLog.bcm = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dEl.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dEl.startLogPerf();
                    }
                    if (oVar.dEk != null && (oVar.dEk instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dEk;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fU(1000);
                                perfLog2.bcm = true;
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
    public void ZT() {
        this.dDq.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.DY();
    }

    public void ZU() {
        this.dDq.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.DZ();
        this.bKJ.setText(this.dRN.getResources().getString(e.j.list_has_no_more));
    }

    public void ZV() {
        this.dDq.setNextPage(null);
    }

    public void gQ(boolean z) {
        this.mListContainer.setVisibility(z ? 0 : 8);
        hi(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.dJF.dUN = intValue;
                if (!this.dSi) {
                    this.dSj = intValue;
                    a(intValue, this.dSe, false);
                    this.dRN.mG(this.dSj);
                    com.baidu.tieba.card.v.anQ().fs(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bNu != null && this.bNu.isRefreshing()) {
            this.bNu.pi();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dSi && (tab.getTag() instanceof Integer)) {
                this.dSj = ((Integer) tab.getTag()).intValue();
                this.dRN.mG(this.dSj);
            }
            a(tab);
        }
    }

    private void aDY() {
        if (this.dSd == null) {
            this.dSd = (TabLayout) LayoutInflater.from(this.dRN.getContext()).inflate(e.h.frs_good_second_layout, (ViewGroup) null);
            this.dSd.setLayoutParams(new RecyclerView.LayoutParams(-1, l.h(this.dRN.getContext(), e.C0200e.tbds146)));
            this.dSd.setOnTabSelectedListener(this);
            b(this.dSd);
            this.dDq.addHeaderView(this.dSd);
        }
    }

    private void aR(View view) {
        this.dSe = (TabLayout) view.findViewById(e.g.frs_good_fake_tabview);
        this.dSe.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dSd, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bNu != null && b.this.bNu.isRefreshing()) {
                    b.this.bNu.pi();
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

    private void hi(boolean z) {
        if (z) {
            this.dSe.setVisibility(8);
        } else if (this.dSe.getTabCount() > 1) {
            this.dSe.setVisibility(0);
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
