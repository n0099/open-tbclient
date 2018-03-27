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
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class c implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private v blR;
    private PbListView cbb;
    private BdSwipeRefreshLayout cdS;
    private FrameLayout dRK;
    private TabLayout dRL;
    private TabLayout dRM;
    private a dRN;
    private b dRv;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bRU = null;
    private BdTypeRecyclerView dFS = null;
    private k mPullView = null;
    private BannerView dRO = null;
    private boolean dRP = false;
    private boolean dRQ = false;
    private int dRR = 0;
    private BannerView.a dRS = new BannerView.a() { // from class: com.baidu.tieba.frs.good.c.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jc() {
            c.this.ayP();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jd() {
            c.this.ayR();
        }
    };

    public c(b bVar, View view, boolean z) {
        this.dRv = null;
        this.dRv = bVar;
        q(view, z);
        this.ds10 = l.t(this.dRv.getContext(), d.e.tbds10);
        this.ds32 = l.t(this.dRv.getContext(), d.e.tbds32);
        this.ds210 = l.t(this.dRv.getContext(), d.e.tbds210);
        this.ds82 = l.t(this.dRv.getContext(), d.e.tbds82);
        this.ds34 = l.t(this.dRv.getContext(), d.e.tbds34);
    }

    private void q(View view, boolean z) {
        this.bRU = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        bR(view);
        this.dFS = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.dFS.setLayoutManager(new LinearLayoutManager(this.dFS.getContext()));
        this.mPullView = new k(this.dRv.getPageContext());
        this.dFS.setFadingEdgeLength(0);
        this.dFS.setOverScrollMode(2);
        this.dFS.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.c.1
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
        this.cbb = new PbListView(this.dRv.getPageContext().getPageActivity());
        this.cbb.st();
        this.cbb.gw(d.C0141d.cp_bg_line_e);
        this.cbb.setHeight(l.t(this.dRv.getActivity(), d.e.tbds182));
        this.cbb.Ed();
        this.cbb.setTextSize(d.e.tbfontsize33);
        this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
        this.cbb.gv(d.C0141d.cp_cont_e);
        this.dFS.setOnSrollToBottomListener(this.dRv);
        if (this.cdS == null) {
            this.cdS = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.cdS.setProgressView(this.mPullView);
            aj.t(this.cdS, d.C0141d.cp_bg_line_c);
        }
        this.dRK = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.dRN = new a(this.dRv, this.dFS);
        this.dRN.setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        cQ(false);
    }

    private void b(v vVar) {
        if (this.dRO == null) {
            this.dRO = new BannerView(this.dRv.getPageContext().getPageActivity());
            this.dRO.setLayoutParams(new AbsListView.LayoutParams(-1, this.dRv.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dRO.setVisibility(8);
            this.dRO.setBannerViewClickListener(this.dRS);
            this.dRO.setBannerData(vVar);
            this.dRO.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.c.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void p(String str, boolean z) {
                    if (z && c.this.dRO.Ja() && !c.this.dRP && c.this.dFS != null) {
                        c.this.dRP = true;
                        c.this.dFS.addHeaderView(c.this.dRO, 1);
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
    public void ayP() {
        if (this.blR != null) {
            String value = this.blR.getValue();
            if (this.blR.yb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.dRv.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.blR.yb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dRv.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dRv.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.blR.yb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aXO != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aXO) {
                        case FRS:
                            this.dRv.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dRv.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dRv.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dRv.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                aw.Du().c(this.dRv.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dRv.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.blR.yb() == 4) {
                this.dRv.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.dRv.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dFS.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(o oVar) {
        this.dRN.setOnAdapterItemClickListener(oVar);
    }

    public void onDestroy() {
        this.dRN.onDestory();
        this.dFS.setOnSrollToBottomListener(null);
        a(this.dRL);
        a(this.dRM);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void cQ(boolean z) {
        if (!z) {
            this.cdS.setRefreshing(false);
        }
    }

    public void aik() {
        this.dFS.setVisibility(0);
    }

    public void avO() {
        if (this.dRN != null) {
            this.dRN.notifyDataSetChanged();
        }
    }

    public void c(m mVar) {
        if (mVar != null && mVar.bas() != null && mVar.bas().getGood_classify() != null) {
            ArrayList<aa> good_classify = mVar.bas().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.b bVar = new com.baidu.tieba.frs.tab.b();
            bVar.tabId = 0;
            bVar.name = this.dRv.getPageContext().getResources().getString(d.j.all);
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
                ayV();
                this.dRQ = true;
                a(tabData, this.dRL);
                a(tabData, this.dRM);
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
                    TextView textView = new TextView(this.dRv.getContext());
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
                if (tabData.get(i2).tabId == this.dRR) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds34, 0, this.ds34, 0);
        }
    }

    public void a(ArrayList<i> arrayList, int i, m mVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar2);
        }
        this.dRN.b(arrayList, mVar);
        this.dRQ = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dFS;
    }

    public void ayQ() {
        this.dRN.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dFS.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dRP && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.blR = forumData.getFrsBannerData();
            b(this.blR);
            this.dRO.reset();
            this.dFS.removeHeaderView(this.dRO);
            if (this.blR.getType() == 1 && !TextUtils.isEmpty(this.blR.yc())) {
                this.dRO.b(this.dRv.getPageContext(), this.blR.yc());
                if (this.blR.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dRv.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void ayR() {
        if (this.dRO != null) {
            this.dRP = false;
            this.dFS.removeHeaderView(this.dRO);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.dRN != null) {
            this.dRN.axp();
            this.dRN.notifyDataSetChanged();
            this.dRN.onChangeSkinType(i);
        }
        this.dRv.getBaseFragmentActivity().getLayoutMode().aQ(i == 1);
        this.dRv.getBaseFragmentActivity().getLayoutMode().aM(this.bRU);
        if (this.dRO != null) {
            this.dRO.Jb();
        }
        if (this.cbb != null) {
            this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_j));
            this.cbb.gx(i);
        }
        aj.t(this.cdS, d.C0141d.cp_bg_line_c);
        aj.t(this.dFS, d.C0141d.cp_bg_line_e);
        b(this.dRL);
        b(this.dRM);
    }

    public void startPullRefresh() {
        this.cdS.setRefreshing(true);
    }

    public a ayS() {
        return this.dRN;
    }

    public RelativeLayout ayT() {
        return this.bRU;
    }

    public View ayU() {
        return this.cdS;
    }

    public void avZ() {
        if (p.Ow().Ox()) {
            int lastVisiblePosition = this.dFS.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dFS.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof com.baidu.tieba.frs.o)) {
                    com.baidu.tieba.frs.o oVar = (com.baidu.tieba.frs.o) childAt.getTag();
                    if (oVar.dGH != null) {
                        com.baidu.tbadk.k.k perfLog = oVar.dGH.getPerfLog();
                        perfLog.ij(1000);
                        perfLog.bAq = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dGH.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dGH.startLogPerf();
                    }
                    if (oVar.dGG != null && (oVar.dGG instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dGG;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.ij(1000);
                                perfLog2.bAq = true;
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
        this.dFS.setNextPage(this.cbb);
        this.cbb.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.cbb.Eg();
    }

    public void XP() {
        this.dFS.setNextPage(this.cbb);
        this.cbb.gy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.cbb.Eh();
        this.cbb.setText(this.dRv.getResources().getString(d.j.list_no_more));
    }

    public void XQ() {
        this.dFS.setNextPage(null);
    }

    public void gn(boolean z) {
        this.dRK.setVisibility(z ? 0 : 8);
        go(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.e.c.dUj.dUb = intValue;
                if (!this.dRQ) {
                    this.dRR = intValue;
                    a(intValue, this.dRM, false);
                    this.dRv.nC(this.dRR);
                    r.alt().eO(false);
                }
            }
            h(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.cdS != null && this.cdS.isRefreshing()) {
            this.cdS.sW();
        }
        i(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dRQ && (tab.getTag() instanceof Integer)) {
                this.dRR = ((Integer) tab.getTag()).intValue();
                this.dRv.nC(this.dRR);
            }
            h(tab);
        }
    }

    private void ayV() {
        if (this.dRL == null) {
            this.dRL = (TabLayout) LayoutInflater.from(this.dRv.getContext()).inflate(d.h.frs_good_second_layout, (ViewGroup) null);
            this.dRL.setLayoutParams(new RecyclerView.LayoutParams(-1, l.t(this.dRv.getContext(), d.e.tbds146)));
            this.dRL.setOnTabSelectedListener(this);
            b(this.dRL);
            this.dFS.addHeaderView(this.dRL);
        }
    }

    private void bR(View view) {
        this.dRM = (TabLayout) view.findViewById(d.g.frs_good_fake_tabview);
        this.dRM.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.c.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        c.this.a(((Integer) tab.getTag()).intValue(), c.this.dRL, true);
                    }
                    c.this.h(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (c.this.cdS != null && c.this.cdS.isRefreshing()) {
                    c.this.cdS.sW();
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

    private void go(boolean z) {
        if (z) {
            this.dRM.setVisibility(8);
        } else if (this.dRM.getTabCount() > 1) {
            this.dRM.setVisibility(0);
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
