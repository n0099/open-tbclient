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
    private v blO;
    private PbListView caY;
    private BdSwipeRefreshLayout cdP;
    private FrameLayout dRF;
    private TabLayout dRG;
    private TabLayout dRH;
    private a dRI;
    private b dRq;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bRR = null;
    private BdTypeRecyclerView dFO = null;
    private k mPullView = null;
    private BannerView dRJ = null;
    private boolean dRK = false;
    private boolean dRL = false;
    private int dRM = 0;
    private BannerView.a dRN = new BannerView.a() { // from class: com.baidu.tieba.frs.good.c.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jb() {
            c.this.ayN();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jc() {
            c.this.ayP();
        }
    };

    public c(b bVar, View view, boolean z) {
        this.dRq = null;
        this.dRq = bVar;
        q(view, z);
        this.ds10 = l.t(this.dRq.getContext(), d.e.tbds10);
        this.ds32 = l.t(this.dRq.getContext(), d.e.tbds32);
        this.ds210 = l.t(this.dRq.getContext(), d.e.tbds210);
        this.ds82 = l.t(this.dRq.getContext(), d.e.tbds82);
        this.ds34 = l.t(this.dRq.getContext(), d.e.tbds34);
    }

    private void q(View view, boolean z) {
        this.bRR = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        bR(view);
        this.dFO = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.dFO.setLayoutManager(new LinearLayoutManager(this.dFO.getContext()));
        this.mPullView = new k(this.dRq.getPageContext());
        this.dFO.setFadingEdgeLength(0);
        this.dFO.setOverScrollMode(2);
        this.dFO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.c.1
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
        this.caY = new PbListView(this.dRq.getPageContext().getPageActivity());
        this.caY.st();
        this.caY.gw(d.C0141d.cp_bg_line_e);
        this.caY.setHeight(l.t(this.dRq.getActivity(), d.e.tbds182));
        this.caY.Ec();
        this.caY.setTextSize(d.e.tbfontsize33);
        this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
        this.caY.gv(d.C0141d.cp_cont_e);
        this.dFO.setOnSrollToBottomListener(this.dRq);
        if (this.cdP == null) {
            this.cdP = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.cdP.setProgressView(this.mPullView);
            aj.t(this.cdP, d.C0141d.cp_bg_line_c);
        }
        this.dRF = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.dRI = new a(this.dRq, this.dFO);
        this.dRI.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        cQ(false);
    }

    private void b(v vVar) {
        if (this.dRJ == null) {
            this.dRJ = new BannerView(this.dRq.getPageContext().getPageActivity());
            this.dRJ.setLayoutParams(new AbsListView.LayoutParams(-1, this.dRq.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dRJ.setVisibility(8);
            this.dRJ.setBannerViewClickListener(this.dRN);
            this.dRJ.setBannerData(vVar);
            this.dRJ.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.c.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void p(String str, boolean z) {
                    if (z && c.this.dRJ.IZ() && !c.this.dRK && c.this.dFO != null) {
                        c.this.dRK = true;
                        c.this.dFO.addHeaderView(c.this.dRJ, 1);
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
    public void ayN() {
        if (this.blO != null) {
            String value = this.blO.getValue();
            if (this.blO.yb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dRq.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.blO.yb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dRq.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dRq.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.blO.yb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aXM != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aXM) {
                        case FRS:
                            this.dRq.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dRq.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dRq.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dRq.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                aw.Dt().c(this.dRq.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dRq.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.blO.yb() == 4) {
                this.dRq.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dRq.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dFO.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(o oVar) {
        this.dRI.setOnAdapterItemClickListener(oVar);
    }

    public void onDestroy() {
        this.dRI.onDestory();
        this.dFO.setOnSrollToBottomListener(null);
        a(this.dRG);
        a(this.dRH);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void cQ(boolean z) {
        if (!z) {
            this.cdP.setRefreshing(false);
        }
    }

    public void aij() {
        this.dFO.setVisibility(0);
    }

    public void avM() {
        if (this.dRI != null) {
            this.dRI.notifyDataSetChanged();
        }
    }

    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bar() != null && lVar.bar().getGood_classify() != null) {
            ArrayList<aa> good_classify = lVar.bar().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.b bVar = new com.baidu.tieba.frs.tab.b();
            bVar.tabId = 0;
            bVar.name = this.dRq.getPageContext().getResources().getString(d.j.all);
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
                ayT();
                this.dRL = true;
                a(tabData, this.dRG);
                a(tabData, this.dRH);
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
                    TextView textView = new TextView(this.dRq.getContext());
                    textView.setSingleLine();
                    aj.s(textView, d.f.bg_item_good_tab_border);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                    layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(am.f(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.dRM) {
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
        this.dRI.b(arrayList, lVar);
        this.dRL = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dFO;
    }

    public void ayO() {
        this.dRI.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dFO.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dRK && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.blO = forumData.getFrsBannerData();
            b(this.blO);
            this.dRJ.reset();
            this.dFO.removeHeaderView(this.dRJ);
            if (this.blO.getType() == 1 && !TextUtils.isEmpty(this.blO.yc())) {
                this.dRJ.b(this.dRq.getPageContext(), this.blO.yc());
                if (this.blO.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dRq.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void ayP() {
        if (this.dRJ != null) {
            this.dRK = false;
            this.dFO.removeHeaderView(this.dRJ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.dRI != null) {
            this.dRI.axn();
            this.dRI.notifyDataSetChanged();
            this.dRI.onChangeSkinType(i);
        }
        this.dRq.getBaseFragmentActivity().getLayoutMode().aQ(i == 1);
        this.dRq.getBaseFragmentActivity().getLayoutMode().aM(this.bRR);
        if (this.dRJ != null) {
            this.dRJ.Ja();
        }
        if (this.caY != null) {
            this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
            this.caY.gx(i);
        }
        aj.t(this.cdP, d.C0141d.cp_bg_line_c);
        aj.t(this.dFO, d.C0141d.cp_bg_line_e);
        b(this.dRG);
        b(this.dRH);
    }

    public void startPullRefresh() {
        this.cdP.setRefreshing(true);
    }

    public a ayQ() {
        return this.dRI;
    }

    public RelativeLayout ayR() {
        return this.bRR;
    }

    public View ayS() {
        return this.cdP;
    }

    public void avX() {
        if (p.Ov().Ow()) {
            int lastVisiblePosition = this.dFO.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dFO.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof com.baidu.tieba.frs.o)) {
                    com.baidu.tieba.frs.o oVar = (com.baidu.tieba.frs.o) childAt.getTag();
                    if (oVar.dGC != null) {
                        com.baidu.tbadk.k.k perfLog = oVar.dGC.getPerfLog();
                        perfLog.ij(1000);
                        perfLog.bAn = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dGC.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dGC.startLogPerf();
                    }
                    if (oVar.dGB != null && (oVar.dGB instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dGB;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.ij(1000);
                                perfLog2.bAn = true;
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
    public void XN() {
        this.dFO.setNextPage(this.caY);
        this.caY.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.caY.Ef();
    }

    public void XO() {
        this.dFO.setNextPage(this.caY);
        this.caY.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.caY.Eg();
        this.caY.setText(this.dRq.getResources().getString(d.j.list_no_more));
    }

    public void XP() {
        this.dFO.setNextPage(null);
    }

    public void gm(boolean z) {
        this.dRF.setVisibility(z ? 0 : 8);
        gn(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.e.c.dUe.dTW = intValue;
                if (!this.dRL) {
                    this.dRM = intValue;
                    a(intValue, this.dRH, false);
                    this.dRq.nC(this.dRM);
                    r.als().eO(false);
                }
            }
            h(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.cdP != null && this.cdP.isRefreshing()) {
            this.cdP.sW();
        }
        i(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dRL && (tab.getTag() instanceof Integer)) {
                this.dRM = ((Integer) tab.getTag()).intValue();
                this.dRq.nC(this.dRM);
            }
            h(tab);
        }
    }

    private void ayT() {
        if (this.dRG == null) {
            this.dRG = (TabLayout) LayoutInflater.from(this.dRq.getContext()).inflate(d.h.frs_good_second_layout, (ViewGroup) null);
            this.dRG.setLayoutParams(new RecyclerView.LayoutParams(-1, l.t(this.dRq.getContext(), d.e.tbds146)));
            this.dRG.setOnTabSelectedListener(this);
            b(this.dRG);
            this.dFO.addHeaderView(this.dRG);
        }
    }

    private void bR(View view) {
        this.dRH = (TabLayout) view.findViewById(d.g.frs_good_fake_tabview);
        this.dRH.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.c.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        c.this.a(((Integer) tab.getTag()).intValue(), c.this.dRG, true);
                    }
                    c.this.h(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (c.this.cdP != null && c.this.cdP.isRefreshing()) {
                    c.this.cdP.sW();
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
            this.dRH.setVisibility(8);
        } else if (this.dRH.getTabCount() > 1) {
            this.dRH.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            aj.t(tabLayout, d.C0141d.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                        TextView textView = (TextView) tabAt.getCustomView();
                        if (tabAt.isSelected()) {
                            textView.setTextColor(aj.getColor(d.C0141d.cp_cont_b));
                        } else {
                            textView.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
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
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0141d.cp_cont_b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0141d.cp_cont_j));
        }
    }
}
