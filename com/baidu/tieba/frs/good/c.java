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
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.k.p;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.r;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class c implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private v bmb;
    private PbListView cbk;
    private BdSwipeRefreshLayout ceb;
    private b dRC;
    private FrameLayout dRR;
    private TabLayout dRS;
    private TabLayout dRT;
    private a dRU;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bSe = null;
    private BdTypeRecyclerView dGa = null;
    private k mPullView = null;
    private BannerView dRV = null;
    private boolean dRW = false;
    private boolean dRX = false;
    private int dRY = 0;
    private BannerView.a dRZ = new BannerView.a() { // from class: com.baidu.tieba.frs.good.c.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jc() {
            c.this.ayO();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jd() {
            c.this.ayQ();
        }
    };

    public c(b bVar, View view, boolean z) {
        this.dRC = null;
        this.dRC = bVar;
        q(view, z);
        this.ds10 = l.t(this.dRC.getContext(), d.e.tbds10);
        this.ds32 = l.t(this.dRC.getContext(), d.e.tbds32);
        this.ds210 = l.t(this.dRC.getContext(), d.e.tbds210);
        this.ds82 = l.t(this.dRC.getContext(), d.e.tbds82);
        this.ds34 = l.t(this.dRC.getContext(), d.e.tbds34);
    }

    private void q(View view, boolean z) {
        this.bSe = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        bR(view);
        this.dGa = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.dGa.setLayoutManager(new LinearLayoutManager(this.dGa.getContext()));
        this.mPullView = new k(this.dRC.getPageContext());
        this.dGa.setFadingEdgeLength(0);
        this.dGa.setOverScrollMode(2);
        this.dGa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.c.1
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
        this.cbk = new PbListView(this.dRC.getPageContext().getPageActivity());
        this.cbk.st();
        this.cbk.gw(d.C0140d.cp_bg_line_e);
        this.cbk.setHeight(l.t(this.dRC.getActivity(), d.e.tbds182));
        this.cbk.Ed();
        this.cbk.setTextSize(d.e.tbfontsize33);
        this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_j));
        this.cbk.gv(d.C0140d.cp_cont_e);
        this.dGa.setOnSrollToBottomListener(this.dRC);
        if (this.ceb == null) {
            this.ceb = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.ceb.setProgressView(this.mPullView);
            aj.t(this.ceb, d.C0140d.cp_bg_line_c);
        }
        this.dRR = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.dRU = new a(this.dRC, this.dGa);
        this.dRU.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        cQ(false);
    }

    private void b(v vVar) {
        if (this.dRV == null) {
            this.dRV = new BannerView(this.dRC.getPageContext().getPageActivity());
            this.dRV.setLayoutParams(new AbsListView.LayoutParams(-1, this.dRC.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dRV.setVisibility(8);
            this.dRV.setBannerViewClickListener(this.dRZ);
            this.dRV.setBannerData(vVar);
            this.dRV.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.c.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void q(String str, boolean z) {
                    if (z && c.this.dRV.Ja() && !c.this.dRW && c.this.dGa != null) {
                        c.this.dRW = true;
                        c.this.dGa.addHeaderView(c.this.dRV, 1);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void ayO() {
        if (this.bmb != null) {
            String value = this.bmb.getValue();
            if (this.bmb.yb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dRC.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.bmb.yb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dRC.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dRC.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bmb.yb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aXY != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aXY) {
                        case FRS:
                            this.dRC.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dRC.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dRC.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dRC.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                aw.Du().c(this.dRC.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dRC.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bmb.yb() == 4) {
                this.dRC.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dRC.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dGa.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(o oVar) {
        this.dRU.setOnAdapterItemClickListener(oVar);
    }

    public void onDestroy() {
        this.dRU.onDestory();
        this.dGa.setOnSrollToBottomListener(null);
        a(this.dRS);
        a(this.dRT);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void cQ(boolean z) {
        if (!z) {
            this.ceb.setRefreshing(false);
        }
    }

    public void aik() {
        this.dGa.setVisibility(0);
    }

    public void avN() {
        if (this.dRU != null) {
            this.dRU.notifyDataSetChanged();
        }
    }

    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bas() != null && lVar.bas().getGood_classify() != null) {
            ArrayList<aa> good_classify = lVar.bas().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.b bVar = new com.baidu.tieba.frs.tab.b();
            bVar.tabId = 0;
            bVar.name = this.dRC.getPageContext().getResources().getString(d.j.all);
            tabData.add(bVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.yf() > 0 && !TextUtils.isEmpty(aaVar.ye()) && !TextUtils.isEmpty(aaVar.ye().trim())) {
                    com.baidu.tieba.frs.tab.b bVar2 = new com.baidu.tieba.frs.tab.b();
                    bVar2.tabId = aaVar.yf();
                    bVar2.name = aaVar.ye();
                    tabData.add(bVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.D(tabData) > 1) {
                ayU();
                this.dRX = true;
                a(tabData, this.dRS);
                a(tabData, this.dRT);
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
                    TextView textView = new TextView(this.dRC.getContext());
                    textView.setSingleLine();
                    aj.s(textView, d.f.bg_item_good_tab_border);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(aj.getColor(d.C0140d.cp_cont_j));
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                    layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(am.f(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.dRY) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds34, 0, this.ds34, 0);
        }
    }

    public void a(ArrayList<i> arrayList, int i, com.baidu.tieba.tbadkCore.l lVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dRU.b(arrayList, lVar);
        this.dRX = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dGa;
    }

    public void ayP() {
        this.dRU.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dGa.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dRW && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bmb = forumData.getFrsBannerData();
            b(this.bmb);
            this.dRV.reset();
            this.dGa.removeHeaderView(this.dRV);
            if (this.bmb.getType() == 1 && !TextUtils.isEmpty(this.bmb.yc())) {
                this.dRV.b(this.dRC.getPageContext(), this.bmb.yc());
                if (this.bmb.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dRC.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void ayQ() {
        if (this.dRV != null) {
            this.dRW = false;
            this.dGa.removeHeaderView(this.dRV);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.dRU != null) {
            this.dRU.axo();
            this.dRU.notifyDataSetChanged();
            this.dRU.onChangeSkinType(i);
        }
        this.dRC.getBaseFragmentActivity().getLayoutMode().aQ(i == 1);
        this.dRC.getBaseFragmentActivity().getLayoutMode().aM(this.bSe);
        if (this.dRV != null) {
            this.dRV.Jb();
        }
        if (this.cbk != null) {
            this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_j));
            this.cbk.gx(i);
        }
        aj.t(this.ceb, d.C0140d.cp_bg_line_c);
        aj.t(this.dGa, d.C0140d.cp_bg_line_e);
        b(this.dRS);
        b(this.dRT);
    }

    public void startPullRefresh() {
        this.ceb.setRefreshing(true);
    }

    public a ayR() {
        return this.dRU;
    }

    public RelativeLayout ayS() {
        return this.bSe;
    }

    public View ayT() {
        return this.ceb;
    }

    public void avY() {
        if (p.Ow().Ox()) {
            int lastVisiblePosition = this.dGa.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dGa.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof com.baidu.tieba.frs.o)) {
                    com.baidu.tieba.frs.o oVar = (com.baidu.tieba.frs.o) childAt.getTag();
                    if (oVar.dGO != null) {
                        com.baidu.tbadk.k.k perfLog = oVar.dGO.getPerfLog();
                        perfLog.ij(1000);
                        perfLog.bAA = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dGO.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dGO.startLogPerf();
                    }
                    if (oVar.dGN != null && (oVar.dGN instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dGN;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.ij(1000);
                                perfLog2.bAA = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > l.aq(TbadkCoreApplication.getInst().getContext())) {
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
    public void XO() {
        this.dGa.setNextPage(this.cbk);
        this.cbk.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.cbk.Eg();
    }

    public void XP() {
        this.dGa.setNextPage(this.cbk);
        this.cbk.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.cbk.Eh();
        this.cbk.setText(this.dRC.getResources().getString(d.j.list_no_more));
    }

    public void XQ() {
        this.dGa.setNextPage(null);
    }

    public void gm(boolean z) {
        this.dRR.setVisibility(z ? 0 : 8);
        gn(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.e.c.dUq.dUi = intValue;
                if (!this.dRX) {
                    this.dRY = intValue;
                    a(intValue, this.dRT, false);
                    this.dRC.nC(this.dRY);
                    r.alt().eO(false);
                }
            }
            h(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.ceb != null && this.ceb.isRefreshing()) {
            this.ceb.sW();
        }
        i(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dRX && (tab.getTag() instanceof Integer)) {
                this.dRY = ((Integer) tab.getTag()).intValue();
                this.dRC.nC(this.dRY);
            }
            h(tab);
        }
    }

    private void ayU() {
        if (this.dRS == null) {
            this.dRS = (TabLayout) LayoutInflater.from(this.dRC.getContext()).inflate(d.h.frs_good_second_layout, (ViewGroup) null);
            this.dRS.setLayoutParams(new RecyclerView.LayoutParams(-1, l.t(this.dRC.getContext(), d.e.tbds146)));
            this.dRS.setOnTabSelectedListener(this);
            b(this.dRS);
            this.dGa.addHeaderView(this.dRS);
        }
    }

    private void bR(View view) {
        this.dRT = (TabLayout) view.findViewById(d.g.frs_good_fake_tabview);
        this.dRT.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.c.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        c.this.a(((Integer) tab.getTag()).intValue(), c.this.dRS, true);
                    }
                    c.this.h(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (c.this.ceb != null && c.this.ceb.isRefreshing()) {
                    c.this.ceb.sW();
                }
                c.this.i(tab);
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
                                h(tabAt);
                            }
                        } else if (!z) {
                            i(tabAt);
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void gn(boolean z) {
        if (z) {
            this.dRT.setVisibility(8);
        } else if (this.dRT.getTabCount() > 1) {
            this.dRT.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            aj.t(tabLayout, d.C0140d.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                        TextView textView = (TextView) tabAt.getCustomView();
                        if (tabAt.isSelected()) {
                            textView.setTextColor(aj.getColor(d.C0140d.cp_cont_b));
                        } else {
                            textView.setTextColor(aj.getColor(d.C0140d.cp_cont_j));
                        }
                        aj.s(textView, d.f.bg_item_good_tab_border);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0140d.cp_cont_b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0140d.cp_cont_j));
        }
    }
}
