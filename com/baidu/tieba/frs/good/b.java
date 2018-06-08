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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.e.c;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class b implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private w aGa;
    private PbListView btv;
    private BdSwipeRefreshLayout bwm;
    private FrameLayout dmX;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private FrsGoodFragment dwd;
    private TabLayout dwp;
    private TabLayout dwq;
    private a dwr;
    private RelativeLayout bkk = null;
    private BdTypeRecyclerView djk = null;
    private g mPullView = null;
    private BannerView dws = null;
    private boolean dwt = false;
    private boolean dwu = false;
    private int dwv = 0;
    private BannerView.a dww = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Ft() {
            b.this.axQ();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Fu() {
            b.this.axS();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.dwd = null;
        this.dwd = frsGoodFragment;
        k(view, z);
        this.ds10 = l.e(this.dwd.getPageContext().getPageActivity(), d.e.tbds10);
        this.ds32 = l.e(this.dwd.getPageContext().getPageActivity(), d.e.tbds32);
        this.ds210 = l.e(this.dwd.getPageContext().getPageActivity(), d.e.tbds210);
        this.ds82 = l.e(this.dwd.getPageContext().getPageActivity(), d.e.tbds82);
        this.ds34 = l.e(this.dwd.getPageContext().getPageActivity(), d.e.tbds34);
    }

    private void k(View view, boolean z) {
        this.bkk = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        aw(view);
        this.djk = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.djk.setLayoutManager(new LinearLayoutManager(this.djk.getContext()));
        this.mPullView = new g(this.dwd.getPageContext());
        this.djk.setFadingEdgeLength(0);
        this.djk.setOverScrollMode(2);
        this.djk.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
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
        this.btv = new PbListView(this.dwd.getPageContext().getPageActivity());
        this.btv.nn();
        this.btv.dx(d.C0141d.cp_bg_line_e);
        this.btv.setHeight(l.e(this.dwd.getActivity(), d.e.tbds182));
        this.btv.Ao();
        this.btv.setTextSize(d.e.tbfontsize33);
        this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_j));
        this.btv.dw(d.C0141d.cp_cont_e);
        this.djk.setOnSrollToBottomListener(this.dwd);
        if (this.bwm == null) {
            this.bwm = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.bwm.setProgressView(this.mPullView);
            al.j(this.bwm, d.C0141d.cp_bg_line_c);
        }
        this.dmX = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.dwr = new a(this.dwd, this.djk);
        cm(false);
    }

    private void b(w wVar) {
        if (this.dws == null) {
            this.dws = new BannerView(this.dwd.getPageContext().getPageActivity());
            this.dws.setLayoutParams(new AbsListView.LayoutParams(-1, this.dwd.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dws.setVisibility(8);
            this.dws.setBannerViewClickListener(this.dww);
            this.dws.setBannerData(wVar);
            this.dws.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void n(String str, boolean z) {
                    if (z && b.this.dws.Fr() && !b.this.dwt && b.this.djk != null) {
                        b.this.dwt = true;
                        b.this.djk.addHeaderView(b.this.dws, 1);
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
    public void axQ() {
        if (this.aGa != null) {
            String value = this.aGa.getValue();
            if (this.aGa.uc() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dwd.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aGa.uc() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dwd.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dwd.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aGa.uc() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.arA != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.arA) {
                        case FRS:
                            this.dwd.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dwd.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dwd.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dwd.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ay.zG().c(this.dwd.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dwd.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aGa.uc() == 4) {
                this.dwd.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dwd.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(f.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.djk.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dwr.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dwr.onDestory();
        this.djk.setOnSrollToBottomListener(null);
        a(this.dwp);
        a(this.dwq);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void cm(boolean z) {
        if (!z) {
            this.bwm.setRefreshing(false);
        }
    }

    public void showListView() {
        this.djk.setVisibility(0);
    }

    public void auo() {
        if (this.dwr != null) {
            this.dwr.notifyDataSetChanged();
        }
    }

    public void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bam() != null && lVar.bam().getGood_classify() != null) {
            ArrayList<ab> good_classify = lVar.bam().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
            dVar.tabId = 0;
            dVar.name = this.dwd.getPageContext().getResources().getString(d.k.all);
            tabData.add(dVar);
            for (ab abVar : good_classify) {
                if (abVar != null && abVar.ug() > 0 && !TextUtils.isEmpty(abVar.uf()) && !TextUtils.isEmpty(abVar.uf().trim())) {
                    com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                    dVar2.tabId = abVar.ug();
                    dVar2.name = abVar.uf();
                    tabData.add(dVar2);
                }
            }
            if (com.baidu.tbadk.core.util.w.y(tabData) > 1) {
                axU();
                this.dwu = true;
                a(tabData, this.dwp);
                a(tabData, this.dwq);
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
                    TextView textView = new TextView(this.dwd.getContext());
                    textView.setSingleLine();
                    al.i(textView, d.f.bg_item_good_tab_border);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(al.getColor(d.C0141d.cp_cont_j));
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                    layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(ao.f(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.dwv) {
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
        this.dwr.b(arrayList, lVar);
        this.dwu = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.djk;
    }

    public void axR() {
        this.dwr.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.djk.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dwt && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aGa = forumData.getFrsBannerData();
            b(this.aGa);
            this.dws.reset();
            this.djk.removeHeaderView(this.dws);
            if (this.aGa.getType() == 1 && !TextUtils.isEmpty(this.aGa.ud())) {
                this.dws.setData(this.dwd.getPageContext(), this.aGa.ud());
                if (this.aGa.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dwd.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void axS() {
        if (this.dws != null) {
            this.dwt = false;
            this.djk.removeHeaderView(this.dws);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.dwr != null) {
            this.dwr.avR();
            this.dwr.notifyDataSetChanged();
            this.dwr.onChangeSkinType(i);
        }
        this.dwd.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dwd.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bkk);
        if (this.dws != null) {
            this.dws.Fs();
        }
        if (this.btv != null) {
            this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_j));
            this.btv.dy(i);
        }
        al.j(this.bwm, d.C0141d.cp_bg_line_c);
        al.j(this.djk, d.C0141d.cp_bg_line_e);
        b(this.dwp);
        b(this.dwq);
    }

    public void startPullRefresh() {
        this.bwm.setRefreshing(true);
    }

    public a axT() {
        return this.dwr;
    }

    public RelativeLayout avq() {
        return this.bkk;
    }

    public View avr() {
        return this.bwm;
    }

    public void auz() {
        if (m.Ks().Kt()) {
            int lastVisiblePosition = this.djk.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.djk.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof com.baidu.tieba.frs.m)) {
                    com.baidu.tieba.frs.m mVar = (com.baidu.tieba.frs.m) childAt.getTag();
                    if (mVar.dka != null) {
                        com.baidu.tbadk.k.h perfLog = mVar.dka.getPerfLog();
                        perfLog.fk(1000);
                        perfLog.aSN = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.dka.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aj(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.dka.startLogPerf();
                    }
                    if (mVar.djZ != null && (mVar.djZ instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.djZ;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fk(1000);
                                perfLog2.aSN = true;
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
    public void TJ() {
        this.djk.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.Ar();
    }

    public void TK() {
        this.djk.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.As();
        this.btv.setText(this.dwd.getResources().getString(d.k.list_no_more));
    }

    public void TL() {
        this.djk.setNextPage(null);
    }

    public void fO(boolean z) {
        this.dmX.setVisibility(z ? 0 : 8);
        fY(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.dyP.dyH = intValue;
                if (!this.dwu) {
                    this.dwv = intValue;
                    a(intValue, this.dwq, false);
                    this.dwd.kW(this.dwv);
                    v.ajh().ey(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bwm != null && this.bwm.isRefreshing()) {
            this.bwm.nX();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dwu && (tab.getTag() instanceof Integer)) {
                this.dwv = ((Integer) tab.getTag()).intValue();
                this.dwd.kW(this.dwv);
            }
            a(tab);
        }
    }

    private void axU() {
        if (this.dwp == null) {
            this.dwp = (TabLayout) LayoutInflater.from(this.dwd.getContext()).inflate(d.i.frs_good_second_layout, (ViewGroup) null);
            this.dwp.setLayoutParams(new RecyclerView.LayoutParams(-1, l.e(this.dwd.getContext(), d.e.tbds146)));
            this.dwp.setOnTabSelectedListener(this);
            b(this.dwp);
            this.djk.addHeaderView(this.dwp);
        }
    }

    private void aw(View view) {
        this.dwq = (TabLayout) view.findViewById(d.g.frs_good_fake_tabview);
        this.dwq.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dwp, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bwm != null && b.this.bwm.isRefreshing()) {
                    b.this.bwm.nX();
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

    private void fY(boolean z) {
        if (z) {
            this.dwq.setVisibility(8);
        } else if (this.dwq.getTabCount() > 1) {
            this.dwq.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            al.j(tabLayout, d.C0141d.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                        TextView textView = (TextView) tabAt.getCustomView();
                        if (tabAt.isSelected()) {
                            textView.setTextColor(al.getColor(d.C0141d.cp_cont_b));
                        } else {
                            textView.setTextColor(al.getColor(d.C0141d.cp_cont_j));
                        }
                        al.i(textView, d.f.bg_item_good_tab_border);
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
            ((TextView) tab.getCustomView()).setTextColor(al.getColor(d.C0141d.cp_cont_b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(al.getColor(d.C0141d.cp_cont_j));
        }
    }
}
