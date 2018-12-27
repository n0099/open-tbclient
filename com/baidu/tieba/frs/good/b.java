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
    private v aSY;
    private PbListView bOB;
    private BdSwipeRefreshLayout bRo;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private FrsGoodFragment ebg;
    private TabLayout ebw;
    private TabLayout ebx;
    private a eby;
    private FrameLayout mListContainer;
    private RelativeLayout bAz = null;
    private BdTypeRecyclerView dMD = null;
    private k mPullView = null;
    private BannerView ebz = null;
    private boolean ebA = false;
    private boolean ebB = false;
    private int ebC = 0;
    private BannerView.a ebD = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Kp() {
            b.this.aGv();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Kq() {
            b.this.aGx();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.ebg = null;
        this.ebg = frsGoodFragment;
        i(view, z);
        this.ds10 = l.h(this.ebg.getPageContext().getPageActivity(), e.C0210e.tbds10);
        this.ds32 = l.h(this.ebg.getPageContext().getPageActivity(), e.C0210e.tbds32);
        this.ds210 = l.h(this.ebg.getPageContext().getPageActivity(), e.C0210e.tbds210);
        this.ds82 = l.h(this.ebg.getPageContext().getPageActivity(), e.C0210e.tbds82);
        this.ds34 = l.h(this.ebg.getPageContext().getPageActivity(), e.C0210e.tbds34);
    }

    private void i(View view, boolean z) {
        this.bAz = (RelativeLayout) view.findViewById(e.g.frs_good_container);
        aU(view);
        this.dMD = (BdTypeRecyclerView) view.findViewById(e.g.frs_good_lv_thread);
        this.dMD.setLayoutManager(new LinearLayoutManager(this.dMD.getContext()));
        this.mPullView = new k(this.ebg.getPageContext());
        this.dMD.setFadingEdgeLength(0);
        this.dMD.setOverScrollMode(2);
        this.dMD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
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
        this.bOB = new PbListView(this.ebg.getPageContext().getPageActivity());
        this.bOB.oD();
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.setHeight(l.h(this.ebg.getActivity(), e.C0210e.tbds182));
        this.bOB.EZ();
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOB.ew(e.d.cp_cont_e);
        this.dMD.setOnSrollToBottomListener(this.ebg);
        if (this.bRo == null) {
            this.bRo = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_pull_refresh_layout);
            this.bRo.setProgressView(this.mPullView);
            al.j(this.bRo, e.d.cp_bg_line_e);
        }
        this.mListContainer = (FrameLayout) view.findViewById(e.g.frs_list_content);
        this.eby = new a(this.ebg, this.dMD);
        di(false);
    }

    private void b(v vVar) {
        if (this.ebz == null) {
            this.ebz = new BannerView(this.ebg.getPageContext().getPageActivity());
            this.ebz.setLayoutParams(new AbsListView.LayoutParams(-1, this.ebg.getResources().getDimensionPixelSize(e.C0210e.ds100)));
            this.ebz.setVisibility(8);
            this.ebz.setBannerViewClickListener(this.ebD);
            this.ebz.setBannerData(vVar);
            this.ebz.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void s(String str, boolean z) {
                    if (z && b.this.ebz.Kn() && !b.this.ebA && b.this.dMD != null) {
                        b.this.ebA = true;
                        b.this.dMD.addHeaderView(b.this.ebz, 1);
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
    public void aGv() {
        if (this.aSY != null) {
            String value = this.aSY.getValue();
            if (this.aSY.yt() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.ebg.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aSY.yt() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.ebg.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.ebg.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aSY.yt() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aDg != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aDg) {
                        case FRS:
                            this.ebg.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.ebg.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.ebg.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.ebg.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ay.Ef().c(this.ebg.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.ebg.getPageContext().getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aSY.yt() == 4) {
                this.ebg.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.ebg.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.dMD.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.eby.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.eby.onDestory();
        this.dMD.setOnSrollToBottomListener(null);
        a(this.ebw);
        a(this.ebx);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void di(boolean z) {
        if (!z) {
            this.bRo.setRefreshing(false);
        }
    }

    public void anp() {
        this.dMD.setVisibility(0);
    }

    public void aCu() {
        if (this.eby != null) {
            this.eby.notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bgT() != null && lVar.bgT().getGood_classify() != null && !this.ebg.ebq) {
            ArrayList<aa> good_classify = lVar.bgT().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.ebg.getPageContext().getResources().getString(e.j.all);
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
                aGz();
                this.ebB = true;
                a(tabData, this.ebw);
                a(tabData, this.ebx);
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
                    TextView textView = new TextView(this.ebg.getContext());
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
                if (tabData.get(i2).tabId == this.ebC) {
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
        this.eby.b(arrayList, lVar);
        this.ebB = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dMD;
    }

    public void aGw() {
        this.eby.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dMD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.ebA && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aSY = forumData.getFrsBannerData();
            b(this.aSY);
            this.ebz.reset();
            this.dMD.removeHeaderView(this.ebz);
            if (this.aSY.getType() == 1 && !TextUtils.isEmpty(this.aSY.yu())) {
                this.ebz.setData(this.ebg.getPageContext(), this.aSY.yu());
                if (this.aSY.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.ebg.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void aGx() {
        if (this.ebz != null) {
            this.ebA = false;
            this.dMD.removeHeaderView(this.ebz);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.eby != null) {
            this.eby.aEC();
            this.eby.notifyDataSetChanged();
            this.eby.onChangeSkinType(i);
        }
        this.ebg.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ebg.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bAz);
        if (this.ebz != null) {
            this.ebz.Ko();
        }
        if (this.bOB != null) {
            this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bOB.ey(i);
        }
        al.j(this.bRo, e.d.cp_bg_line_e);
        b(this.ebw);
        b(this.ebx);
    }

    public void startPullRefresh() {
        this.bRo.setRefreshing(true);
    }

    public a aGy() {
        return this.eby;
    }

    public RelativeLayout aCF() {
        return this.bAz;
    }

    public View aDE() {
        return this.bRo;
    }

    public void aCH() {
        if (com.baidu.tbadk.l.m.Pl().Pm()) {
            int lastVisiblePosition = this.dMD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dMD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dNy != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dNy.getPerfLog();
                        perfLog.gj(1000);
                        perfLog.bfP = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dNy.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dNy.startLogPerf();
                    }
                    if (oVar.dNx != null && (oVar.dNx instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dNx;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.gj(1000);
                                perfLog2.bfP = true;
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
    public void abb() {
        this.dMD.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.Fc();
    }

    public void abc() {
        this.dMD.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.Fd();
        this.bOB.setText(this.ebg.getResources().getString(e.j.list_has_no_more));
    }

    public void abd() {
        this.dMD.setNextPage(null);
    }

    public void gU(boolean z) {
        this.mListContainer.setVisibility(z ? 0 : 8);
        hn(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.e.d.dSZ.eeh = intValue;
                if (!this.ebB) {
                    this.ebC = intValue;
                    a(intValue, this.ebx, false);
                    this.ebg.nj(this.ebC);
                    com.baidu.tieba.card.v.aqs().fv(false);
                    c.bBT().b(this.ebg.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bRo != null && this.bRo.isRefreshing()) {
            this.bRo.ph();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.ebB && (tab.getTag() instanceof Integer)) {
                this.ebC = ((Integer) tab.getTag()).intValue();
                this.ebg.nj(this.ebC);
            }
            a(tab);
        }
    }

    private void aGz() {
        if (this.ebw == null) {
            this.ebw = (TabLayout) LayoutInflater.from(this.ebg.getContext()).inflate(e.h.frs_good_second_layout, (ViewGroup) null);
            this.ebw.setLayoutParams(new RecyclerView.LayoutParams(-1, l.h(this.ebg.getContext(), e.C0210e.tbds146)));
            this.ebw.setOnTabSelectedListener(this);
            b(this.ebw);
            this.dMD.addHeaderView(this.ebw);
        }
    }

    private void aU(View view) {
        this.ebx = (TabLayout) view.findViewById(e.g.frs_good_fake_tabview);
        this.ebx.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.ebw, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bRo != null && b.this.bRo.isRefreshing()) {
                    b.this.bRo.ph();
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

    private void hn(boolean z) {
        if (z) {
            this.ebx.setVisibility(8);
        } else if (this.ebx.getTabCount() > 1) {
            this.ebx.setVisibility(0);
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
