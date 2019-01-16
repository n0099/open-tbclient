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
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.q.c;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class b implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private v aTG;
    private PbListView bPm;
    private BdSwipeRefreshLayout bRZ;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private FrsGoodFragment ebM;
    private TabLayout ecc;
    private TabLayout ecd;
    private a ece;
    private FrameLayout mListContainer;
    private RelativeLayout bBm = null;
    private BdTypeRecyclerView dNm = null;
    private k mPullView = null;
    private BannerView ecf = null;
    private boolean ecg = false;
    private boolean ech = false;
    private int eci = 0;
    private BannerView.a ecj = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void KE() {
            b.this.aGS();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void KF() {
            b.this.aGU();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.ebM = null;
        this.ebM = frsGoodFragment;
        i(view, z);
        this.ds10 = l.h(this.ebM.getPageContext().getPageActivity(), e.C0210e.tbds10);
        this.ds32 = l.h(this.ebM.getPageContext().getPageActivity(), e.C0210e.tbds32);
        this.ds210 = l.h(this.ebM.getPageContext().getPageActivity(), e.C0210e.tbds210);
        this.ds82 = l.h(this.ebM.getPageContext().getPageActivity(), e.C0210e.tbds82);
        this.ds34 = l.h(this.ebM.getPageContext().getPageActivity(), e.C0210e.tbds34);
    }

    private void i(View view, boolean z) {
        this.bBm = (RelativeLayout) view.findViewById(e.g.frs_good_container);
        aU(view);
        this.dNm = (BdTypeRecyclerView) view.findViewById(e.g.frs_good_lv_thread);
        this.dNm.setLayoutManager(new LinearLayoutManager(this.dNm.getContext()));
        this.mPullView = new k(this.ebM.getPageContext());
        this.dNm.setFadingEdgeLength(0);
        this.dNm.setOverScrollMode(2);
        this.dNm.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
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
        this.bPm = new PbListView(this.ebM.getPageContext().getPageActivity());
        this.bPm.oH();
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.setHeight(l.h(this.ebM.getActivity(), e.C0210e.tbds182));
        this.bPm.Fm();
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPm.ew(e.d.cp_cont_e);
        this.dNm.setOnSrollToBottomListener(this.ebM);
        if (this.bRZ == null) {
            this.bRZ = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_pull_refresh_layout);
            this.bRZ.setProgressView(this.mPullView);
            al.j(this.bRZ, e.d.cp_bg_line_e);
        }
        this.mListContainer = (FrameLayout) view.findViewById(e.g.frs_list_content);
        this.ece = new a(this.ebM, this.dNm);
        dl(false);
    }

    private void b(v vVar) {
        if (this.ecf == null) {
            this.ecf = new BannerView(this.ebM.getPageContext().getPageActivity());
            this.ecf.setLayoutParams(new AbsListView.LayoutParams(-1, this.ebM.getResources().getDimensionPixelSize(e.C0210e.ds100)));
            this.ecf.setVisibility(8);
            this.ecf.setBannerViewClickListener(this.ecj);
            this.ecf.setBannerData(vVar);
            this.ecf.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void s(String str, boolean z) {
                    if (z && b.this.ecf.KC() && !b.this.ecg && b.this.dNm != null) {
                        b.this.ecg = true;
                        b.this.dNm.addHeaderView(b.this.ecf, 1);
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
    public void aGS() {
        if (this.aTG != null) {
            String value = this.aTG.getValue();
            if (this.aTG.yG() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.ebM.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aTG.yG() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.ebM.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.ebM.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aTG.yG() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aDI != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aDI) {
                        case FRS:
                            this.ebM.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.ebM.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.ebM.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.ebM.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ay.Es().c(this.ebM.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.ebM.getPageContext().getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aTG.yG() == 4) {
                this.ebM.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.ebM.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(j.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dNm.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.ece.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.ece.onDestory();
        this.dNm.setOnSrollToBottomListener(null);
        a(this.ecc);
        a(this.ecd);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void dl(boolean z) {
        if (!z) {
            this.bRZ.setRefreshing(false);
        }
    }

    public void anM() {
        this.dNm.setVisibility(0);
    }

    public void aCR() {
        if (this.ece != null) {
            this.ece.notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bhx() != null && lVar.bhx().getGood_classify() != null && !this.ebM.ebW) {
            ArrayList<aa> good_classify = lVar.bhx().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.ebM.getPageContext().getResources().getString(e.j.all);
            tabData.add(dVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.yJ() > 0 && !TextUtils.isEmpty(aaVar.yI()) && !TextUtils.isEmpty(aaVar.yI().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = aaVar.yJ();
                    dVar2.name = aaVar.yI();
                    tabData.add(dVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.H(tabData) > 1) {
                aGW();
                this.ech = true;
                a(tabData, this.ecc);
                a(tabData, this.ecd);
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
                    TextView textView = new TextView(this.ebM.getContext());
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
                if (tabData.get(i2).tabId == this.eci) {
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
        this.ece.b(arrayList, lVar);
        this.ech = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dNm;
    }

    public void aGT() {
        this.ece.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dNm.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.ecg && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aTG = forumData.getFrsBannerData();
            b(this.aTG);
            this.ecf.reset();
            this.dNm.removeHeaderView(this.ecf);
            if (this.aTG.getType() == 1 && !TextUtils.isEmpty(this.aTG.yH())) {
                this.ecf.setData(this.ebM.getPageContext(), this.aTG.yH());
                if (this.aTG.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.ebM.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void aGU() {
        if (this.ecf != null) {
            this.ecg = false;
            this.dNm.removeHeaderView(this.ecf);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.ece != null) {
            this.ece.aEZ();
            this.ece.notifyDataSetChanged();
            this.ece.onChangeSkinType(i);
        }
        this.ebM.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ebM.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bBm);
        if (this.ecf != null) {
            this.ecf.KD();
        }
        if (this.bPm != null) {
            this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bPm.ey(i);
        }
        al.j(this.bRZ, e.d.cp_bg_line_e);
        b(this.ecc);
        b(this.ecd);
    }

    public void startPullRefresh() {
        this.bRZ.setRefreshing(true);
    }

    public a aGV() {
        return this.ece;
    }

    public RelativeLayout aDc() {
        return this.bBm;
    }

    public View aEb() {
        return this.bRZ;
    }

    public void aDe() {
        if (com.baidu.tbadk.l.m.PD().PE()) {
            int lastVisiblePosition = this.dNm.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dNm.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dOh != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dOh.getPerfLog();
                        perfLog.gj(1000);
                        perfLog.bgA = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dOh.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dOh.startLogPerf();
                    }
                    if (oVar.dOg != null && (oVar.dOg instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dOg;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.gj(1000);
                                perfLog2.bgA = true;
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
    public void aby() {
        this.dNm.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.Fp();
    }

    public void abz() {
        this.dNm.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.Fq();
        this.bPm.setText(this.ebM.getResources().getString(e.j.list_has_no_more));
    }

    public void abA() {
        this.dNm.setNextPage(null);
    }

    public void gX(boolean z) {
        this.mListContainer.setVisibility(z ? 0 : 8);
        hq(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.e.d.dTF.eeN = intValue;
                if (!this.ech) {
                    this.eci = intValue;
                    a(intValue, this.ecd, false);
                    this.ebM.nk(this.eci);
                    com.baidu.tieba.card.v.aqP().fy(false);
                    c.bCC().b(this.ebM.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bRZ != null && this.bRZ.isRefreshing()) {
            this.bRZ.pl();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.ech && (tab.getTag() instanceof Integer)) {
                this.eci = ((Integer) tab.getTag()).intValue();
                this.ebM.nk(this.eci);
            }
            a(tab);
        }
    }

    private void aGW() {
        if (this.ecc == null) {
            this.ecc = (TabLayout) LayoutInflater.from(this.ebM.getContext()).inflate(e.h.frs_good_second_layout, (ViewGroup) null);
            this.ecc.setLayoutParams(new RecyclerView.LayoutParams(-1, l.h(this.ebM.getContext(), e.C0210e.tbds146)));
            this.ecc.setOnTabSelectedListener(this);
            b(this.ecc);
            this.dNm.addHeaderView(this.ecc);
        }
    }

    private void aU(View view) {
        this.ecd = (TabLayout) view.findViewById(e.g.frs_good_fake_tabview);
        this.ecd.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.ecc, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bRZ != null && b.this.bRZ.isRefreshing()) {
                    b.this.bRZ.pl();
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

    private void hq(boolean z) {
        if (z) {
            this.ecd.setVisibility(8);
        } else if (this.ecd.getTabCount() > 1) {
            this.ecd.setVisibility(0);
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
