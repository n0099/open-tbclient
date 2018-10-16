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
    private v aOH;
    private PbListView bJY;
    private BdSwipeRefreshLayout bMJ;
    private FrameLayout dER;
    private FrsGoodFragment dQJ;
    private TabLayout dQX;
    private TabLayout dQY;
    private a dQZ;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bwo = null;
    private BdTypeRecyclerView dBZ = null;
    private k mPullView = null;
    private BannerView dRa = null;
    private boolean dRb = false;
    private boolean dRc = false;
    private int dRd = 0;
    private BannerView.a dRe = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void IY() {
            b.this.aEz();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void IZ() {
            b.this.aEB();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.dQJ = null;
        this.dQJ = frsGoodFragment;
        j(view, z);
        this.ds10 = l.h(this.dQJ.getPageContext().getPageActivity(), e.C0175e.tbds10);
        this.ds32 = l.h(this.dQJ.getPageContext().getPageActivity(), e.C0175e.tbds32);
        this.ds210 = l.h(this.dQJ.getPageContext().getPageActivity(), e.C0175e.tbds210);
        this.ds82 = l.h(this.dQJ.getPageContext().getPageActivity(), e.C0175e.tbds82);
        this.ds34 = l.h(this.dQJ.getPageContext().getPageActivity(), e.C0175e.tbds34);
    }

    private void j(View view, boolean z) {
        this.bwo = (RelativeLayout) view.findViewById(e.g.frs_good_container);
        aP(view);
        this.dBZ = (BdTypeRecyclerView) view.findViewById(e.g.frs_good_lv_thread);
        this.dBZ.setLayoutManager(new LinearLayoutManager(this.dBZ.getContext()));
        this.mPullView = new k(this.dQJ.getPageContext());
        this.dBZ.setFadingEdgeLength(0);
        this.dBZ.setOverScrollMode(2);
        this.dBZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
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
        this.bJY = new PbListView(this.dQJ.getPageContext().getPageActivity());
        this.bJY.oG();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.setHeight(l.h(this.dQJ.getActivity(), e.C0175e.tbds182));
        this.bJY.DL();
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.dU(e.d.cp_cont_e);
        this.dBZ.setOnSrollToBottomListener(this.dQJ);
        if (this.bMJ == null) {
            this.bMJ = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_pull_refresh_layout);
            this.bMJ.setProgressView(this.mPullView);
            al.j(this.bMJ, e.d.cp_bg_line_e);
        }
        this.dER = (FrameLayout) view.findViewById(e.g.frs_list_content);
        this.dQZ = new a(this.dQJ, this.dBZ);
        cQ(false);
    }

    private void b(v vVar) {
        if (this.dRa == null) {
            this.dRa = new BannerView(this.dQJ.getPageContext().getPageActivity());
            this.dRa.setLayoutParams(new AbsListView.LayoutParams(-1, this.dQJ.getResources().getDimensionPixelSize(e.C0175e.ds100)));
            this.dRa.setVisibility(8);
            this.dRa.setBannerViewClickListener(this.dRe);
            this.dRa.setBannerData(vVar);
            this.dRa.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void r(String str, boolean z) {
                    if (z && b.this.dRa.IW() && !b.this.dRb && b.this.dBZ != null) {
                        b.this.dRb = true;
                        b.this.dBZ.addHeaderView(b.this.dRa, 1);
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
    public void aEz() {
        if (this.aOH != null) {
            String value = this.aOH.getValue();
            if (this.aOH.xg() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dQJ.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aOH.xg() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dQJ.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dQJ.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aOH.xg() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ayQ != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ayQ) {
                        case FRS:
                            this.dQJ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dQJ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dQJ.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dQJ.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ay.CU().c(this.dQJ.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dQJ.getPageContext().getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aOH.xg() == 4) {
                this.dQJ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dQJ.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dBZ.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dQZ.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dQZ.onDestory();
        this.dBZ.setOnSrollToBottomListener(null);
        a(this.dQX);
        a(this.dQY);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void cQ(boolean z) {
        if (!z) {
            this.bMJ.setRefreshing(false);
        }
    }

    public void amg() {
        this.dBZ.setVisibility(0);
    }

    public void aAx() {
        if (this.dQZ != null) {
            this.dQZ.notifyDataSetChanged();
        }
    }

    public void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.beT() != null && lVar.beT().getGood_classify() != null && !this.dQJ.dQS) {
            ArrayList<aa> good_classify = lVar.beT().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.dQJ.getPageContext().getResources().getString(e.j.all);
            tabData.add(dVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.xk() > 0 && !TextUtils.isEmpty(aaVar.xj()) && !TextUtils.isEmpty(aaVar.xj().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = aaVar.xk();
                    dVar2.name = aaVar.xj();
                    tabData.add(dVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.I(tabData) > 1) {
                aED();
                this.dRc = true;
                a(tabData, this.dQX);
                a(tabData, this.dQY);
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
                    TextView textView = new TextView(this.dQJ.getContext());
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
                if (tabData.get(i2).tabId == this.dRd) {
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
        this.dQZ.b(arrayList, lVar);
        this.dRc = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dBZ;
    }

    public void aEA() {
        this.dQZ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dBZ.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dRb && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aOH = forumData.getFrsBannerData();
            b(this.aOH);
            this.dRa.reset();
            this.dBZ.removeHeaderView(this.dRa);
            if (this.aOH.getType() == 1 && !TextUtils.isEmpty(this.aOH.xh())) {
                this.dRa.setData(this.dQJ.getPageContext(), this.aOH.xh());
                if (this.aOH.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dQJ.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void aEB() {
        if (this.dRa != null) {
            this.dRb = false;
            this.dBZ.removeHeaderView(this.dRa);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.dQZ != null) {
            this.dQZ.aCG();
            this.dQZ.notifyDataSetChanged();
            this.dQZ.onChangeSkinType(i);
        }
        this.dQJ.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dQJ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bwo);
        if (this.dRa != null) {
            this.dRa.IX();
        }
        if (this.bJY != null) {
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bJY.dW(i);
        }
        al.j(this.bMJ, e.d.cp_bg_line_e);
        b(this.dQX);
        b(this.dQY);
    }

    public void startPullRefresh() {
        this.bMJ.setRefreshing(true);
    }

    public a aEC() {
        return this.dQZ;
    }

    public RelativeLayout aAI() {
        return this.bwo;
    }

    public View aBH() {
        return this.bMJ;
    }

    public void aAK() {
        if (com.baidu.tbadk.l.m.NX().NY()) {
            int lastVisiblePosition = this.dBZ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dBZ.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dCV != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dCV.getPerfLog();
                        perfLog.fG(1000);
                        perfLog.bbz = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dCV.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dCV.startLogPerf();
                    }
                    if (oVar.dCU != null && (oVar.dCU instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dCU;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fG(1000);
                                perfLog2.bbz = true;
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
    public void ZI() {
        this.dBZ.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.DO();
    }

    public void ZJ() {
        this.dBZ.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.DP();
        this.bJY.setText(this.dQJ.getResources().getString(e.j.list_has_no_more));
    }

    public void ZK() {
        this.dBZ.setNextPage(null);
    }

    public void gG(boolean z) {
        this.dER.setVisibility(z ? 0 : 8);
        gY(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.dIB.dTG = intValue;
                if (!this.dRc) {
                    this.dRd = intValue;
                    a(intValue, this.dQY, false);
                    this.dQJ.mo(this.dRd);
                    com.baidu.tieba.card.v.aoo().fh(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bMJ != null && this.bMJ.isRefreshing()) {
            this.bMJ.pk();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dRc && (tab.getTag() instanceof Integer)) {
                this.dRd = ((Integer) tab.getTag()).intValue();
                this.dQJ.mo(this.dRd);
            }
            a(tab);
        }
    }

    private void aED() {
        if (this.dQX == null) {
            this.dQX = (TabLayout) LayoutInflater.from(this.dQJ.getContext()).inflate(e.h.frs_good_second_layout, (ViewGroup) null);
            this.dQX.setLayoutParams(new RecyclerView.LayoutParams(-1, l.h(this.dQJ.getContext(), e.C0175e.tbds146)));
            this.dQX.setOnTabSelectedListener(this);
            b(this.dQX);
            this.dBZ.addHeaderView(this.dQX);
        }
    }

    private void aP(View view) {
        this.dQY = (TabLayout) view.findViewById(e.g.frs_good_fake_tabview);
        this.dQY.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dQX, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bMJ != null && b.this.bMJ.isRefreshing()) {
                    b.this.bMJ.pk();
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

    private void gY(boolean z) {
        if (z) {
            this.dQY.setVisibility(8);
        } else if (this.dQY.getTabCount() > 1) {
            this.dQY.setVisibility(0);
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
