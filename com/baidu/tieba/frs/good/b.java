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
/* loaded from: classes2.dex */
public class b implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private v aKf;
    private PbListView bBr;
    private BdSwipeRefreshLayout bEe;
    private FrsGoodFragment dIM;
    private TabLayout dJa;
    private TabLayout dJb;
    private a dJc;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private FrameLayout dwQ;
    private RelativeLayout bsh = null;
    private BdTypeRecyclerView dtY = null;
    private k mPullView = null;
    private BannerView dJd = null;
    private boolean dJe = false;
    private boolean dJf = false;
    private int dJg = 0;
    private BannerView.a dJh = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void GX() {
            b.this.aBg();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void GY() {
            b.this.aBi();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.dIM = null;
        this.dIM = frsGoodFragment;
        j(view, z);
        this.ds10 = l.h(this.dIM.getPageContext().getPageActivity(), e.C0141e.tbds10);
        this.ds32 = l.h(this.dIM.getPageContext().getPageActivity(), e.C0141e.tbds32);
        this.ds210 = l.h(this.dIM.getPageContext().getPageActivity(), e.C0141e.tbds210);
        this.ds82 = l.h(this.dIM.getPageContext().getPageActivity(), e.C0141e.tbds82);
        this.ds34 = l.h(this.dIM.getPageContext().getPageActivity(), e.C0141e.tbds34);
    }

    private void j(View view, boolean z) {
        this.bsh = (RelativeLayout) view.findViewById(e.g.frs_good_container);
        aP(view);
        this.dtY = (BdTypeRecyclerView) view.findViewById(e.g.frs_good_lv_thread);
        this.dtY.setLayoutManager(new LinearLayoutManager(this.dtY.getContext()));
        this.mPullView = new k(this.dIM.getPageContext());
        this.dtY.setFadingEdgeLength(0);
        this.dtY.setOverScrollMode(2);
        this.dtY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
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
        this.bBr = new PbListView(this.dIM.getPageContext().getPageActivity());
        this.bBr.ov();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.setHeight(l.h(this.dIM.getActivity(), e.C0141e.tbds182));
        this.bBr.BF();
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bBr.dK(e.d.cp_cont_e);
        this.dtY.setOnSrollToBottomListener(this.dIM);
        if (this.bEe == null) {
            this.bEe = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_pull_refresh_layout);
            this.bEe.setProgressView(this.mPullView);
            al.j(this.bEe, e.d.cp_bg_line_e);
        }
        this.dwQ = (FrameLayout) view.findViewById(e.g.frs_list_content);
        this.dJc = new a(this.dIM, this.dtY);
        cH(false);
    }

    private void b(v vVar) {
        if (this.dJd == null) {
            this.dJd = new BannerView(this.dIM.getPageContext().getPageActivity());
            this.dJd.setLayoutParams(new AbsListView.LayoutParams(-1, this.dIM.getResources().getDimensionPixelSize(e.C0141e.ds100)));
            this.dJd.setVisibility(8);
            this.dJd.setBannerViewClickListener(this.dJh);
            this.dJd.setBannerData(vVar);
            this.dJd.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void k(String str, boolean z) {
                    if (z && b.this.dJd.GV() && !b.this.dJe && b.this.dtY != null) {
                        b.this.dJe = true;
                        b.this.dtY.addHeaderView(b.this.dJd, 1);
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
    public void aBg() {
        if (this.aKf != null) {
            String value = this.aKf.getValue();
            if (this.aKf.uX() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dIM.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aKf.uX() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dIM.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dIM.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aKf.uX() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.auf != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.auf) {
                        case FRS:
                            this.dIM.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dIM.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dIM.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dIM.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ay.AN().c(this.dIM.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dIM.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aKf.uX() == 4) {
                this.dIM.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dIM.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dtY.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dJc.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dJc.onDestory();
        this.dtY.setOnSrollToBottomListener(null);
        a(this.dJa);
        a(this.dJb);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void cH(boolean z) {
        if (!z) {
            this.bEe.setRefreshing(false);
        }
    }

    public void aiB() {
        this.dtY.setVisibility(0);
    }

    public void axc() {
        if (this.dJc != null) {
            this.dJc.notifyDataSetChanged();
        }
    }

    public void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bbH() != null && lVar.bbH().getGood_classify() != null && !this.dIM.dIV) {
            ArrayList<aa> good_classify = lVar.bbH().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.dIM.getPageContext().getResources().getString(e.j.all);
            tabData.add(dVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.vb() > 0 && !TextUtils.isEmpty(aaVar.va()) && !TextUtils.isEmpty(aaVar.va().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = aaVar.vb();
                    dVar2.name = aaVar.va();
                    tabData.add(dVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.y(tabData) > 1) {
                aBk();
                this.dJf = true;
                a(tabData, this.dJa);
                a(tabData, this.dJb);
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
                    TextView textView = new TextView(this.dIM.getContext());
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
                if (tabData.get(i2).tabId == this.dJg) {
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
        this.dJc.b(arrayList, lVar);
        this.dJf = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dtY;
    }

    public void aBh() {
        this.dJc.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dtY.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dJe && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aKf = forumData.getFrsBannerData();
            b(this.aKf);
            this.dJd.reset();
            this.dtY.removeHeaderView(this.dJd);
            if (this.aKf.getType() == 1 && !TextUtils.isEmpty(this.aKf.uY())) {
                this.dJd.setData(this.dIM.getPageContext(), this.aKf.uY());
                if (this.aKf.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dIM.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void aBi() {
        if (this.dJd != null) {
            this.dJe = false;
            this.dtY.removeHeaderView(this.dJd);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.dJc != null) {
            this.dJc.azn();
            this.dJc.notifyDataSetChanged();
            this.dJc.onChangeSkinType(i);
        }
        this.dIM.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dIM.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bsh);
        if (this.dJd != null) {
            this.dJd.GW();
        }
        if (this.bBr != null) {
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bBr.dM(i);
        }
        al.j(this.bEe, e.d.cp_bg_line_e);
        b(this.dJa);
        b(this.dJb);
    }

    public void startPullRefresh() {
        this.bEe.setRefreshing(true);
    }

    public a aBj() {
        return this.dJc;
    }

    public RelativeLayout axn() {
        return this.bsh;
    }

    public View aym() {
        return this.bEe;
    }

    public void axp() {
        if (com.baidu.tbadk.l.m.LZ().Ma()) {
            int lastVisiblePosition = this.dtY.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dtY.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.duU != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.duU.getPerfLog();
                        perfLog.fx(1000);
                        perfLog.aWZ = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.duU.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.duU.startLogPerf();
                    }
                    if (oVar.duT != null && (oVar.duT instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.duT;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fx(1000);
                                perfLog2.aWZ = true;
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
    public void Wb() {
        this.dtY.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.BI();
    }

    public void Wc() {
        this.dtY.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.BJ();
        this.bBr.setText(this.dIM.getResources().getString(e.j.list_has_no_more));
    }

    public void Wd() {
        this.dtY.setNextPage(null);
    }

    public void go(boolean z) {
        this.dwQ.setVisibility(z ? 0 : 8);
        gG(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.dAB.dLL = intValue;
                if (!this.dJf) {
                    this.dJg = intValue;
                    a(intValue, this.dJb, false);
                    this.dIM.lQ(this.dJg);
                    com.baidu.tieba.card.v.akM().eP(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bEe != null && this.bEe.isRefreshing()) {
            this.bEe.pc();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dJf && (tab.getTag() instanceof Integer)) {
                this.dJg = ((Integer) tab.getTag()).intValue();
                this.dIM.lQ(this.dJg);
            }
            a(tab);
        }
    }

    private void aBk() {
        if (this.dJa == null) {
            this.dJa = (TabLayout) LayoutInflater.from(this.dIM.getContext()).inflate(e.h.frs_good_second_layout, (ViewGroup) null);
            this.dJa.setLayoutParams(new RecyclerView.LayoutParams(-1, l.h(this.dIM.getContext(), e.C0141e.tbds146)));
            this.dJa.setOnTabSelectedListener(this);
            b(this.dJa);
            this.dtY.addHeaderView(this.dJa);
        }
    }

    private void aP(View view) {
        this.dJb = (TabLayout) view.findViewById(e.g.frs_good_fake_tabview);
        this.dJb.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dJa, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bEe != null && b.this.bEe.isRefreshing()) {
                    b.this.bEe.pc();
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

    private void gG(boolean z) {
        if (z) {
            this.dJb.setVisibility(8);
        } else if (this.dJb.getTabCount() > 1) {
            this.dJb.setVisibility(0);
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
