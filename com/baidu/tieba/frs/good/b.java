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
    private w axF;
    private PbListView blq;
    private BdSwipeRefreshLayout bog;
    private FrameLayout ddJ;
    private FrsGoodFragment dmL;
    private TabLayout dmX;
    private TabLayout dmY;
    private a dmZ;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bbZ = null;
    private BdTypeRecyclerView cZU = null;
    private f mPullView = null;
    private BannerView dna = null;
    private boolean dnb = false;
    private boolean dnc = false;
    private int dnd = 0;
    private BannerView.a dne = new BannerView.a() { // from class: com.baidu.tieba.frs.good.b.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void BQ() {
            b.this.atD();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void BR() {
            b.this.atF();
        }
    };

    public b(FrsGoodFragment frsGoodFragment, View view2, boolean z) {
        this.dmL = null;
        this.dmL = frsGoodFragment;
        k(view2, z);
        this.ds10 = l.e(this.dmL.getPageContext().getPageActivity(), d.e.tbds10);
        this.ds32 = l.e(this.dmL.getPageContext().getPageActivity(), d.e.tbds32);
        this.ds210 = l.e(this.dmL.getPageContext().getPageActivity(), d.e.tbds210);
        this.ds82 = l.e(this.dmL.getPageContext().getPageActivity(), d.e.tbds82);
        this.ds34 = l.e(this.dmL.getPageContext().getPageActivity(), d.e.tbds34);
    }

    private void k(View view2, boolean z) {
        this.bbZ = (RelativeLayout) view2.findViewById(d.g.frs_good_container);
        aw(view2);
        this.cZU = (BdTypeRecyclerView) view2.findViewById(d.g.frs_good_lv_thread);
        this.cZU.setLayoutManager(new LinearLayoutManager(this.cZU.getContext()));
        this.mPullView = new f(this.dmL.getPageContext());
        this.cZU.setFadingEdgeLength(0);
        this.cZU.setOverScrollMode(2);
        this.cZU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.b.1
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
        this.blq = new PbListView(this.dmL.getPageContext().getPageActivity());
        this.blq.kz();
        this.blq.dv(d.C0126d.cp_bg_line_e);
        this.blq.setHeight(l.e(this.dmL.getActivity(), d.e.tbds182));
        this.blq.wN();
        this.blq.setTextSize(d.e.tbfontsize33);
        this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blq.du(d.C0126d.cp_cont_e);
        this.cZU.setOnSrollToBottomListener(this.dmL);
        if (this.bog == null) {
            this.bog = (BdSwipeRefreshLayout) view2.findViewById(d.g.frs_pull_refresh_layout);
            this.bog.setProgressView(this.mPullView);
            ak.j(this.bog, d.C0126d.cp_bg_line_c);
        }
        this.ddJ = (FrameLayout) view2.findViewById(d.g.frs_list_content);
        this.dmZ = new a(this.dmL, this.cZU);
        ch(false);
    }

    private void b(w wVar) {
        if (this.dna == null) {
            this.dna = new BannerView(this.dmL.getPageContext().getPageActivity());
            this.dna.setLayoutParams(new AbsListView.LayoutParams(-1, this.dmL.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dna.setVisibility(8);
            this.dna.setBannerViewClickListener(this.dne);
            this.dna.setBannerData(wVar);
            this.dna.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.b.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void n(String str, boolean z) {
                    if (z && b.this.dna.BO() && !b.this.dnb && b.this.cZU != null) {
                        b.this.dnb = true;
                        b.this.cZU.addHeaderView(b.this.dna, 1);
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
    public void atD() {
        if (this.axF != null) {
            String value = this.axF.getValue();
            if (this.axF.qG() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dmL.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.axF.qG() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dmL.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dmL.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.axF.qG() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ajs != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ajs) {
                        case FRS:
                            this.dmL.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dmL.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dmL.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dmL.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ax.wf().c(this.dmL.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dmL.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.axF.qG() == 4) {
                this.dmL.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dmL.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.cZU.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dmZ.setOnAdapterItemClickListener(nVar);
    }

    public void onDestroy() {
        this.dmZ.onDestory();
        this.cZU.setOnSrollToBottomListener(null);
        a(this.dmX);
        a(this.dmY);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void ch(boolean z) {
        if (!z) {
            this.bog.setRefreshing(false);
        }
    }

    public void showListView() {
        this.cZU.setVisibility(0);
    }

    public void aqj() {
        if (this.dmZ != null) {
            this.dmZ.notifyDataSetChanged();
        }
    }

    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.aVq() != null && lVar.aVq().getGood_classify() != null) {
            ArrayList<ab> good_classify = lVar.aVq().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
            dVar.tabId = 0;
            dVar.name = this.dmL.getPageContext().getResources().getString(d.k.all);
            tabData.add(dVar);
            for (ab abVar : good_classify) {
                if (abVar != null && abVar.qK() > 0 && !TextUtils.isEmpty(abVar.qJ()) && !TextUtils.isEmpty(abVar.qJ().trim())) {
                    com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                    dVar2.tabId = abVar.qK();
                    dVar2.name = abVar.qJ();
                    tabData.add(dVar2);
                }
            }
            if (v.v(tabData) > 1) {
                atH();
                this.dnc = true;
                a(tabData, this.dmX);
                a(tabData, this.dmY);
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
                    TextView textView = new TextView(this.dmL.getContext());
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
                if (tabData.get(i2).tabId == this.dnd) {
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
        this.dmZ.b(arrayList, lVar);
        this.dnc = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.cZU;
    }

    public void atE() {
        this.dmZ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.cZU.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dnb && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.axF = forumData.getFrsBannerData();
            b(this.axF);
            this.dna.reset();
            this.cZU.removeHeaderView(this.dna);
            if (this.axF.getType() == 1 && !TextUtils.isEmpty(this.axF.qH())) {
                this.dna.setData(this.dmL.getPageContext(), this.axF.qH());
                if (this.axF.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dmL.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void atF() {
        if (this.dna != null) {
            this.dnb = false;
            this.cZU.removeHeaderView(this.dna);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.dmZ != null) {
            this.dmZ.arM();
            this.dmZ.notifyDataSetChanged();
            this.dmZ.onChangeSkinType(i);
        }
        this.dmL.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dmL.getBaseFragmentActivity().getLayoutMode().u(this.bbZ);
        if (this.dna != null) {
            this.dna.BP();
        }
        if (this.blq != null) {
            this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
            this.blq.dw(i);
        }
        ak.j(this.bog, d.C0126d.cp_bg_line_c);
        ak.j(this.cZU, d.C0126d.cp_bg_line_e);
        b(this.dmX);
        b(this.dmY);
    }

    public void startPullRefresh() {
        this.bog.setRefreshing(true);
    }

    public a atG() {
        return this.dmZ;
    }

    public RelativeLayout arl() {
        return this.bbZ;
    }

    public View arm() {
        return this.bog;
    }

    public void aqu() {
        if (p.GY().GZ()) {
            int lastVisiblePosition = this.cZU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cZU.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.daK != null) {
                        com.baidu.tbadk.k.k perfLog = mVar.daK.getPerfLog();
                        perfLog.fj(1000);
                        perfLog.aKN = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.daK.getLocationOnScreen(iArr);
                            if (iArr[1] > l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.daK.startLogPerf();
                    }
                    if (mVar.daJ != null && (mVar.daJ instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.daJ;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fj(1000);
                                perfLog2.aKN = true;
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
    public void Ql() {
        this.cZU.setNextPage(this.blq);
        this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.blq.wQ();
    }

    public void Qm() {
        this.cZU.setNextPage(this.blq);
        this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.blq.wR();
        this.blq.setText(this.dmL.getResources().getString(d.k.list_no_more));
    }

    public void Qn() {
        this.cZU.setNextPage(null);
    }

    public void fJ(boolean z) {
        this.ddJ.setVisibility(z ? 0 : 8);
        fS(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                c.dpD.dpv = intValue;
                if (!this.dnc) {
                    this.dnd = intValue;
                    a(intValue, this.dmY, false);
                    this.dmL.kP(this.dnd);
                    com.baidu.tieba.card.v.afy().eu(false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.bog != null && this.bog.isRefreshing()) {
            this.bog.lh();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dnc && (tab.getTag() instanceof Integer)) {
                this.dnd = ((Integer) tab.getTag()).intValue();
                this.dmL.kP(this.dnd);
            }
            a(tab);
        }
    }

    private void atH() {
        if (this.dmX == null) {
            this.dmX = (TabLayout) LayoutInflater.from(this.dmL.getContext()).inflate(d.i.frs_good_second_layout, (ViewGroup) null);
            this.dmX.setLayoutParams(new RecyclerView.LayoutParams(-1, l.e(this.dmL.getContext(), d.e.tbds146)));
            this.dmX.setOnTabSelectedListener(this);
            b(this.dmX);
            this.cZU.addHeaderView(this.dmX);
        }
    }

    private void aw(View view2) {
        this.dmY = (TabLayout) view2.findViewById(d.g.frs_good_fake_tabview);
        this.dmY.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.b.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        b.this.a(((Integer) tab.getTag()).intValue(), b.this.dmX, true);
                    }
                    b.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (b.this.bog != null && b.this.bog.isRefreshing()) {
                    b.this.bog.lh();
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

    private void fS(boolean z) {
        if (z) {
            this.dmY.setVisibility(8);
        } else if (this.dmY.getTabCount() > 1) {
            this.dmY.setVisibility(0);
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
