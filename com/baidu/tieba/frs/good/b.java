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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.k.p;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.e.c;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class b implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private w axE;
    private PbListView blb;
    private BdSwipeRefreshLayout bnR;
    private FrameLayout dcB;
    private FrsGoodFragment dlE;
    private TabLayout dlQ;
    private TabLayout dlR;
    private a dlS;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bbY = null;
    private BdTypeRecyclerView cYN = null;
    private f mPullView = null;
    private BannerView dlT = null;
    private boolean dlU = false;
    private boolean dlV = false;
    private int dlW = 0;
    private BannerView.a dlX = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void BS() {
            b.this.atE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void BT() {
            b.this.atG();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view2, boolean z) {
        this.dlE = null;
        this.dlE = frsGoodFragment;
        k(view2, z);
        this.ds10 = l.e(this.dlE.getPageContext().getPageActivity(), d.e.tbds10);
        this.ds32 = l.e(this.dlE.getPageContext().getPageActivity(), d.e.tbds32);
        this.ds210 = l.e(this.dlE.getPageContext().getPageActivity(), d.e.tbds210);
        this.ds82 = l.e(this.dlE.getPageContext().getPageActivity(), d.e.tbds82);
        this.ds34 = l.e(this.dlE.getPageContext().getPageActivity(), d.e.tbds34);
    }

    private void k(View view2, boolean z) {
        this.bbY = (RelativeLayout) view2.findViewById(d.g.frs_good_container);
        aw(view2);
        this.cYN = (BdTypeRecyclerView) view2.findViewById(d.g.frs_good_lv_thread);
        this.cYN.setLayoutManager(new LinearLayoutManager(this.cYN.getContext()));
        this.mPullView = new f(this.dlE.getPageContext());
        this.cYN.setFadingEdgeLength(0);
        this.cYN.setOverScrollMode(2);
        this.cYN.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view3 = viewHolder.itemView;
                if (view3 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view3.findViewById(d.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view3.findViewById(d.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view3 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view3).reset();
                    }
                }
            }
        });
        this.blb = new PbListView(this.dlE.getPageContext().getPageActivity());
        this.blb.kA();
        this.blb.du(d.C0126d.cp_bg_line_e);
        this.blb.setHeight(l.e(this.dlE.getActivity(), d.e.tbds182));
        this.blb.wO();
        this.blb.setTextSize(d.e.tbfontsize33);
        this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blb.dt(d.C0126d.cp_cont_e);
        this.cYN.setOnSrollToBottomListener(this.dlE);
        if (this.bnR == null) {
            this.bnR = (BdSwipeRefreshLayout) view2.findViewById(d.g.frs_pull_refresh_layout);
            this.bnR.setProgressView(this.mPullView);
            ak.j(this.bnR, d.C0126d.cp_bg_line_c);
        }
        this.dcB = (FrameLayout) view2.findViewById(d.g.frs_list_content);
        this.dlS = new a(this.dlE, this.cYN);
        ch(false);
    }

    private void b(w wVar) {
        if (this.dlT == null) {
            this.dlT = new BannerView(this.dlE.getPageContext().getPageActivity());
            this.dlT.setLayoutParams(new AbsListView.LayoutParams(-1, this.dlE.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dlT.setVisibility(8);
            this.dlT.setBannerViewClickListener(this.dlX);
            this.dlT.setBannerData(wVar);
            this.dlT.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void n(String str, boolean z) {
                    if (z && b.this.dlT.BQ() && !b.this.dlU && b.this.cYN != null) {
                        b.this.dlU = true;
                        b.this.cYN.addHeaderView(b.this.dlT, 1);
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
    public void atE() {
        if (this.axE != null) {
            String value = this.axE.getValue();
            if (this.axE.qH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dlE.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.axE.qH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dlE.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dlE.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.axE.qH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ajs != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ajs) {
                        case FRS:
                            this.dlE.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dlE.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dlE.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dlE.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ax.wg().c(this.dlE.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dlE.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.axE.qH() == 4) {
                this.dlE.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dlE.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.cYN.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dlS.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dlS.onDestory();
        this.cYN.setOnSrollToBottomListener(null);
        a(this.dlQ);
        a(this.dlR);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void ch(boolean z) {
        if (!z) {
            this.bnR.setRefreshing(false);
        }
    }

    public void showListView() {
        this.cYN.setVisibility(0);
    }

    public void aqk() {
        if (this.dlS != null) {
            this.dlS.notifyDataSetChanged();
        }
    }

    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.aVq() != null && lVar.aVq().getGood_classify() != null) {
            ArrayList<ab> good_classify = lVar.aVq().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
            dVar.tabId = 0;
            dVar.name = this.dlE.getPageContext().getResources().getString(d.k.all);
            tabData.add(dVar);
            for (ab abVar : good_classify) {
                if (abVar != null && abVar.qL() > 0 && !TextUtils.isEmpty(abVar.qK()) && !TextUtils.isEmpty(abVar.qK().trim())) {
                    com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                    dVar2.tabId = abVar.qL();
                    dVar2.name = abVar.qK();
                    tabData.add(dVar2);
                }
            }
            if (v.v(tabData) > 1) {
                atI();
                this.dlV = true;
                a(tabData, this.dlQ);
                a(tabData, this.dlR);
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
                    TextView textView = new TextView(this.dlE.getContext());
                    textView.setSingleLine();
                    ak.i(textView, d.f.bg_item_good_tab_border);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                    layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(an.f(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.dlW) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds34, 0, this.ds34, 0);
        }
    }

    public void a(ArrayList<h> arrayList, int i, com.baidu.tieba.tbadkCore.l lVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
        }
        this.dlS.b(arrayList, lVar);
        this.dlV = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.cYN;
    }

    public void atF() {
        this.dlS.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.cYN.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dlU && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.axE = forumData.getFrsBannerData();
            b(this.axE);
            this.dlT.reset();
            this.cYN.removeHeaderView(this.dlT);
            if (this.axE.getType() == 1 && !TextUtils.isEmpty(this.axE.qI())) {
                this.dlT.setData(this.dlE.getPageContext(), this.axE.qI());
                if (this.axE.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dlE.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void atG() {
        if (this.dlT != null) {
            this.dlU = false;
            this.cYN.removeHeaderView(this.dlT);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        if (this.dlS != null) {
            this.dlS.arN();
            this.dlS.notifyDataSetChanged();
            this.dlS.onChangeSkinType(i);
        }
        this.dlE.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dlE.getBaseFragmentActivity().getLayoutMode().u(this.bbY);
        if (this.dlT != null) {
            this.dlT.BR();
        }
        if (this.blb != null) {
            this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
            this.blb.dv(i);
        }
        ak.j(this.bnR, d.C0126d.cp_bg_line_c);
        ak.j(this.cYN, d.C0126d.cp_bg_line_e);
        b(this.dlQ);
        b(this.dlR);
    }

    public void startPullRefresh() {
        this.bnR.setRefreshing(true);
    }

    public a atH() {
        return this.dlS;
    }

    public RelativeLayout arm() {
        return this.bbY;
    }

    public View arn() {
        return this.bnR;
    }

    public void aqv() {
        if (p.Ha().Hb()) {
            int lastVisiblePosition = this.cYN.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cYN.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.cZB != null) {
                        com.baidu.tbadk.k.k perfLog = mVar.cZB.getPerfLog();
                        perfLog.fi(1000);
                        perfLog.aKM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.cZB.getLocationOnScreen(iArr);
                            if (iArr[1] > l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.cZB.startLogPerf();
                    }
                    if (mVar.cZA != null && (mVar.cZA instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.cZA;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fi(1000);
                                perfLog2.aKM = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > l.ah(TbadkCoreApplication.getInst().getContext())) {
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
    public void Qo() {
        this.cYN.setNextPage(this.blb);
        this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.blb.wR();
    }

    public void Qp() {
        this.cYN.setNextPage(this.blb);
        this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.blb.wS();
        this.blb.setText(this.dlE.getResources().getString(d.k.list_no_more));
    }

    public void Qq() {
        this.cYN.setNextPage(null);
    }

    public void fI(boolean z) {
        this.dcB.setVisibility(z ? 0 : 8);
        fR(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.dov.don = intValue;
                if (!this.dlV) {
                    this.dlW = intValue;
                    a(intValue, this.dlR, false);
                    this.dlE.kQ(this.dlW);
                    com.baidu.tieba.card.v.afy().et(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bnR != null && this.bnR.isRefreshing()) {
            this.bnR.li();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dlV && (tab.getTag() instanceof Integer)) {
                this.dlW = ((Integer) tab.getTag()).intValue();
                this.dlE.kQ(this.dlW);
            }
            a(tab);
        }
    }

    private void atI() {
        if (this.dlQ == null) {
            this.dlQ = (TabLayout) LayoutInflater.from(this.dlE.getContext()).inflate(d.i.frs_good_second_layout, (ViewGroup) null);
            this.dlQ.setLayoutParams(new RecyclerView.LayoutParams(-1, l.e(this.dlE.getContext(), d.e.tbds146)));
            this.dlQ.setOnTabSelectedListener(this);
            b(this.dlQ);
            this.cYN.addHeaderView(this.dlQ);
        }
    }

    private void aw(View view2) {
        this.dlR = (TabLayout) view2.findViewById(d.g.frs_good_fake_tabview);
        this.dlR.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dlQ, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bnR != null && b.this.bnR.isRefreshing()) {
                    b.this.bnR.li();
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

    private void fR(boolean z) {
        if (z) {
            this.dlR.setVisibility(8);
        } else if (this.dlR.getTabCount() > 1) {
            this.dlR.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            ak.j(tabLayout, d.C0126d.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                        TextView textView = (TextView) tabAt.getCustomView();
                        if (tabAt.isSelected()) {
                            textView.setTextColor(ak.getColor(d.C0126d.cp_cont_b));
                        } else {
                            textView.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
                        }
                        ak.i(textView, d.f.bg_item_good_tab_border);
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
            ((TextView) tab.getCustomView()).setTextColor(ak.getColor(d.C0126d.cp_cont_b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        }
    }
}
