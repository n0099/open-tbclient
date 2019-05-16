package com.baidu.tieba.frs.good;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.q.c;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout bnL;
    private x ckF;
    private PbListView dlX;
    private BdSwipeRefreshLayout dnh;
    private final int ds13;
    private final int ds212;
    private final int ds31;
    private final int ds32;
    private final int ds34;
    private final int ds74;
    private FrsGoodFragment fFO;
    private TabLayout fFP;
    private TabLayout fFQ;
    private b fFR;
    public String fFT;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout cUF = null;
    private BdTypeRecyclerView fqU = null;
    private i mPullView = null;
    private BannerView fFS = null;
    private boolean fFU = false;
    private boolean fFV = false;
    private int fFW = 0;
    private int fFX = R.color.cp_link_tip_a;
    private BannerView.a fFY = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aoZ() {
            a.this.boz();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void apa() {
            a.this.boB();
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.fFO = null;
        this.fFO = frsGoodFragment;
        l(view, z);
        this.ds13 = l.g(this.fFO.getPageContext().getPageActivity(), R.dimen.tbds13);
        this.ds32 = l.g(this.fFO.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds212 = l.g(this.fFO.getPageContext().getPageActivity(), R.dimen.tbds212);
        this.ds74 = l.g(this.fFO.getPageContext().getPageActivity(), R.dimen.tbds74);
        this.ds34 = l.g(this.fFO.getPageContext().getPageActivity(), R.dimen.tbds34);
        this.ds31 = l.g(this.fFO.getPageContext().getPageActivity(), R.dimen.tbds31);
    }

    private void l(View view, boolean z) {
        this.cUF = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bU(view);
        this.fqU = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fqU.setLayoutManager(new LinearLayoutManager(this.fqU.getContext()));
        this.mPullView = new i(this.fFO.getPageContext());
        this.fqU.setFadingEdgeLength(0);
        this.fqU.setOverScrollMode(2);
        this.fqU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.dlX = new PbListView(this.fFO.getPageContext().getPageActivity());
        this.dlX.nG();
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.setHeight(l.g(this.fFO.getActivity(), R.dimen.tbds182));
        this.dlX.ajv();
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlX.iN(R.color.cp_cont_e);
        this.fqU.setOnSrollToBottomListener(this.fFO);
        if (this.dnh == null) {
            this.dnh = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dnh.setProgressView(this.mPullView);
            al.l(this.dnh, R.color.cp_bg_line_e);
        }
        this.bnL = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fFR = new b(this.fFO, this.fqU);
        fY(false);
    }

    private void b(x xVar) {
        if (this.fFS == null) {
            this.fFS = new BannerView(this.fFO.getPageContext().getPageActivity());
            this.fFS.setLayoutParams(new AbsListView.LayoutParams(-1, this.fFO.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fFS.setVisibility(8);
            this.fFS.setBannerViewClickListener(this.fFY);
            this.fFS.setBannerData(xVar);
            this.fFS.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void O(String str, boolean z) {
                    if (z && a.this.fFS.aoX() && !a.this.fFU && a.this.fqU != null) {
                        a.this.fFU = true;
                        a.this.fqU.addHeaderView(a.this.fFS, 1);
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
    public void boz() {
        if (this.ckF != null) {
            String value = this.ckF.getValue();
            if (this.ckF.abT() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fFO.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.ckF.abT() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fFO.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fFO.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ckF.abT() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bTt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bTt) {
                        case FRS:
                            this.fFO.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fFO.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fFO.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fFO.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.aiz().c(this.fFO.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fFO.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.ckF.abT() == 4) {
                this.fFO.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fFO.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(h.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.fqU.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fFR.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fFR.onDestory();
        this.fqU.setOnSrollToBottomListener(null);
        a(this.fFP);
        a(this.fFQ);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void fY(boolean z) {
        if (!z) {
            this.dnh.setRefreshing(false);
        }
    }

    public void aUE() {
        this.fqU.setVisibility(0);
    }

    public void bkN() {
        if (this.fFR != null) {
            this.fFR.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.fFO.fFH) {
            ArrayList<ac> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.fFO.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ac acVar : good_classify) {
                if (acVar != null && acVar.abW() > 0 && !TextUtils.isEmpty(acVar.abV()) && !TextUtils.isEmpty(acVar.abV().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = acVar.abW();
                    dVar2.name = acVar.abV();
                    tabData.add(dVar2);
                }
            }
            if (v.Z(tabData) > 1) {
                boD();
                this.fFV = true;
                a(tabData, this.fFP);
                a(tabData, this.fFQ);
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
                    TextView textView = new TextView(this.fFO.getContext());
                    textView.setSingleLine();
                    al.k(textView, R.drawable.btn_white_corners_selector);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(al.getColor(R.color.cp_cont_c));
                    a(textView, R.color.cp_bg_line_d, R.color.cp_bg_line_b, true);
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds212, this.ds74);
                    layoutParams.setMargins(this.ds13, this.ds32, this.ds13, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(ap.k(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.fFW) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds31, 0, this.ds31, 0);
        }
    }

    public void a(ArrayList<m> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.fFR.b(arrayList, frsViewData);
        this.fFV = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.fqU;
    }

    public void boA() {
        this.fFR.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fqU.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fFU && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.ckF = forumData.getFrsBannerData();
            b(this.ckF);
            this.fFS.reset();
            this.fqU.removeHeaderView(this.fFS);
            if (this.ckF.getType() == 1 && !TextUtils.isEmpty(this.ckF.abU())) {
                this.fFS.setData(this.fFO.getPageContext(), this.ckF.abU());
                if (this.ckF.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fFO.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void boB() {
        if (this.fFS != null) {
            this.fFU = false;
            this.fqU.removeHeaderView(this.fFS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.fFR != null) {
            this.fFR.bmW();
            this.fFR.notifyDataSetChanged();
            this.fFR.onChangeSkinType(i);
        }
        this.fFO.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fFO.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cUF);
        if (this.fFS != null) {
            this.fFS.aoY();
        }
        if (this.dlX != null) {
            this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
            this.dlX.iP(i);
        }
        al.l(this.dnh, R.color.cp_bg_line_e);
        b(this.fFP);
        b(this.fFQ);
    }

    public void startPullRefresh() {
        this.dnh.setRefreshing(true);
    }

    public b boC() {
        return this.fFR;
    }

    public RelativeLayout bla() {
        return this.cUF;
    }

    public View bma() {
        return this.dnh;
    }

    public void blc() {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            int lastVisiblePosition = this.fqU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fqU.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.frU != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.frU.getPerfLog();
                        perfLog.kK(1000);
                        perfLog.cyv = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.frU.getLocationOnScreen(iArr);
                            if (iArr[1] > l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.frU.startLogPerf();
                    }
                    if (oVar.frT != null && (oVar.frT instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.frT;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kK(1000);
                                perfLog2.cyv = true;
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
    public void aIE() {
        this.fqU.setNextPage(this.dlX);
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlX.ajy();
    }

    public void aIF() {
        this.fqU.setNextPage(this.dlX);
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlX.ajz();
        this.dlX.setText(this.fFO.getResources().getString(R.string.list_has_no_more));
    }

    public void aIG() {
        this.fqU.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bnL.setVisibility(z ? 0 : 8);
        kw(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.fxk.fJG = intValue;
                if (!this.fFV) {
                    this.fFW = intValue;
                    a(intValue, this.fFQ, false);
                    this.fFO.sc(this.fFW);
                    t.aXM().iv(false);
                    c.clt().b(this.fFO.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dnh != null && this.dnh.isRefreshing()) {
            this.dnh.oz();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.fFV && (tab.getTag() instanceof Integer)) {
                this.fFW = ((Integer) tab.getTag()).intValue();
                this.fFO.sc(this.fFW);
            }
            a(tab);
        }
    }

    private void boD() {
        if (this.fFP == null) {
            this.fFP = (TabLayout) LayoutInflater.from(this.fFO.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.fFP.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(this.fFO.getContext(), R.dimen.tbds126)));
            this.fFP.setOnTabSelectedListener(this);
            b(this.fFP);
            this.fqU.addHeaderView(this.fFP);
        }
    }

    private void bU(View view) {
        this.fFQ = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.fFQ.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.fFP, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.dnh != null && a.this.dnh.isRefreshing()) {
                    a.this.dnh.oz();
                }
                a.this.b(tab);
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

    private void kw(boolean z) {
        if (z) {
            this.fFQ.setVisibility(8);
        } else if (this.fFQ.getTabCount() > 1) {
            this.fFQ.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            al.l(tabLayout, R.color.cp_bg_line_d);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                    TextView textView = (TextView) tabAt.getCustomView();
                    if (tabAt.isSelected()) {
                        textView.setTextColor(al.getColor(R.color.cp_cont_b));
                    } else {
                        textView.setTextColor(al.getColor(R.color.cp_cont_c));
                    }
                    a(textView, R.color.cp_bg_line_d, R.color.cp_bg_line_b, false);
                }
            }
        }
    }

    public void a(ThemeColorInfo themeColorInfo) {
        ThemeElement themeElement;
        if (themeColorInfo != null) {
            this.mThemeColorInfo = themeColorInfo;
            if (this.mThemeColorInfo != null && this.mThemeColorInfo.day != null && this.mThemeColorInfo.night != null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    themeElement = this.mThemeColorInfo.night;
                } else {
                    themeElement = this.mThemeColorInfo.day;
                }
                if (!ap.isEmpty(themeElement.font_color)) {
                    this.fFT = themeElement.font_color;
                }
            }
        }
    }

    private void a(TextView textView, int i, int i2, boolean z) {
        GradientDrawable j;
        if (textView != null) {
            int g = l.g(this.fFO.getPageContext().getPageActivity(), R.dimen.tbds1);
            int g2 = l.g(this.fFO.getPageContext().getPageActivity(), R.dimen.tbds10);
            if (z && !ap.isEmpty(this.fFT)) {
                j = al.b(g2, i, this.fFT, g);
                textView.setTextColor(Color.parseColor("#" + this.fFT));
            } else {
                j = al.j(g2, i, i2, g);
                textView.setTextColor(al.getColor(R.color.cp_cont_c));
            }
            if (j != null) {
                textView.setBackgroundDrawable(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        TextView textView;
        if (tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, R.color.cp_bg_line_d, this.fFX, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        TextView textView;
        if (tab != null && tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, R.color.cp_bg_line_d, R.color.cp_bg_line_b, false);
        }
    }

    public void blk() {
        if (boC() != null) {
            List<m> dataList = boC().getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bf) {
                        bf bfVar = (bf) mVar;
                        if (bfVar.bIf != 0 && bfVar.threadData != null) {
                            int[] afo = bfVar.threadData.afo();
                            bfVar.bIf = afo[0];
                            bfVar.bIg = afo[1];
                        }
                    }
                }
                e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.boC().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }
}
