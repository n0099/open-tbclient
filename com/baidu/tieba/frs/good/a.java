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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
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
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout boy;
    private x clZ;
    private PbListView dnN;
    private BdSwipeRefreshLayout dpp;
    private final int ds13;
    private final int ds212;
    private final int ds31;
    private final int ds32;
    private final int ds34;
    private final int ds74;
    private FrsGoodFragment fLB;
    private TabLayout fLC;
    private TabLayout fLD;
    private b fLE;
    public String fLG;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout cWk = null;
    private BdTypeRecyclerView fws = null;
    private i mPullView = null;
    private BannerView fLF = null;
    private boolean fLH = false;
    private boolean fLI = false;
    private int fLJ = 0;
    private int fLK = R.color.cp_link_tip_a;
    private BannerView.a fLL = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqh() {
            a.this.bqR();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqi() {
            a.this.bqT();
        }
    };
    private CustomMessageListener fLM = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.xv(str);
                a.this.xu(str);
                a.this.fLE.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.fLB = null;
        this.fLB = frsGoodFragment;
        l(view, z);
        this.ds13 = l.g(this.fLB.getPageContext().getPageActivity(), R.dimen.tbds13);
        this.ds32 = l.g(this.fLB.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds212 = l.g(this.fLB.getPageContext().getPageActivity(), R.dimen.tbds212);
        this.ds74 = l.g(this.fLB.getPageContext().getPageActivity(), R.dimen.tbds74);
        this.ds34 = l.g(this.fLB.getPageContext().getPageActivity(), R.dimen.tbds34);
        this.ds31 = l.g(this.fLB.getPageContext().getPageActivity(), R.dimen.tbds31);
    }

    private void l(View view, boolean z) {
        this.cWk = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bX(view);
        this.fws = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fws.setLayoutManager(new LinearLayoutManager(this.fws.getContext()));
        this.mPullView = new i(this.fLB.getPageContext());
        this.fws.setFadingEdgeLength(0);
        this.fws.setOverScrollMode(2);
        this.fws.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.dnN = new PbListView(this.fLB.getPageContext().getPageActivity());
        this.dnN.nZ();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.setHeight(l.g(this.fLB.getActivity(), R.dimen.tbds182));
        this.dnN.akC();
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.iT(R.color.cp_cont_e);
        this.fws.setOnSrollToBottomListener(this.fLB);
        if (this.dpp == null) {
            this.dpp = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dpp.setProgressView(this.mPullView);
            am.l(this.dpp, R.color.cp_bg_line_e);
        }
        this.boy = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fLE = new b(this.fLB, this.fws);
        gc(false);
        this.fLB.registerListener(this.fLM);
    }

    private void b(x xVar) {
        if (this.fLF == null) {
            this.fLF = new BannerView(this.fLB.getPageContext().getPageActivity());
            this.fLF.setLayoutParams(new AbsListView.LayoutParams(-1, this.fLB.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fLF.setVisibility(8);
            this.fLF.setBannerViewClickListener(this.fLL);
            this.fLF.setBannerData(xVar);
            this.fLF.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void P(String str, boolean z) {
                    if (z && a.this.fLF.aqf() && !a.this.fLH && a.this.fws != null) {
                        a.this.fLH = true;
                        a.this.fws.addHeaderView(a.this.fLF, 1);
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
    public void bqR() {
        if (this.clZ != null) {
            String value = this.clZ.getValue();
            if (this.clZ.acW() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fLB.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.clZ.acW() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fLB.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fLB.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.clZ.acW() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bUB != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bUB) {
                        case FRS:
                            this.fLB.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fLB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fLB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fLB.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bb.ajE().c(this.fLB.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fLB.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.clZ.acW() == 4) {
                this.fLB.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fLB.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.fws.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fLE.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fLE.onDestory();
        this.fws.setOnSrollToBottomListener(null);
        a(this.fLC);
        a(this.fLD);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void gc(boolean z) {
        if (!z) {
            this.dpp.setRefreshing(false);
        }
    }

    public void aVR() {
        this.fws.setVisibility(0);
    }

    public void bnc() {
        if (this.fLE != null) {
            this.fLE.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.fLB.fLu) {
            ArrayList<ac> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.fLB.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ac acVar : good_classify) {
                if (acVar != null && acVar.acZ() > 0 && !TextUtils.isEmpty(acVar.acY()) && !TextUtils.isEmpty(acVar.acY().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = acVar.acZ();
                    dVar2.name = acVar.acY();
                    tabData.add(dVar2);
                }
            }
            if (v.Z(tabData) > 1) {
                bqV();
                this.fLI = true;
                a(tabData, this.fLC);
                a(tabData, this.fLD);
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
                    TextView textView = new TextView(this.fLB.getContext());
                    textView.setSingleLine();
                    am.k(textView, R.drawable.btn_white_corners_selector);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(am.getColor(R.color.cp_cont_c));
                    a(textView, R.color.cp_bg_line_d, R.color.cp_bg_line_b, true);
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds212, this.ds74);
                    layoutParams.setMargins(this.ds13, this.ds32, this.ds13, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(aq.k(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.fLJ) {
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
        this.fLE.b(arrayList, frsViewData);
        this.fLI = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.fws;
    }

    public void bqS() {
        this.fLE.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fws.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fLH && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.clZ = forumData.getFrsBannerData();
            b(this.clZ);
            this.fLF.reset();
            this.fws.removeHeaderView(this.fLF);
            if (this.clZ.getType() == 1 && !TextUtils.isEmpty(this.clZ.acX())) {
                this.fLF.setData(this.fLB.getPageContext(), this.clZ.acX());
                if (this.clZ.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fLB.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void bqT() {
        if (this.fLF != null) {
            this.fLH = false;
            this.fws.removeHeaderView(this.fLF);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.fLE != null) {
            this.fLE.bpn();
            this.fLE.notifyDataSetChanged();
            this.fLE.onChangeSkinType(i);
        }
        this.fLB.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fLB.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cWk);
        if (this.fLF != null) {
            this.fLF.aqg();
        }
        if (this.dnN != null) {
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnN.iV(i);
        }
        am.l(this.dpp, R.color.cp_bg_line_e);
        b(this.fLC);
        b(this.fLD);
    }

    public void startPullRefresh() {
        this.dpp.setRefreshing(true);
    }

    public b bqU() {
        return this.fLE;
    }

    public RelativeLayout aXA() {
        return this.cWk;
    }

    public View bop() {
        return this.dpp;
    }

    public void bnq() {
        if (com.baidu.tbadk.p.m.avv().avw()) {
            int lastVisiblePosition = this.fws.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fws.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.eem != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.eem.getPerfLog();
                        perfLog.kR(1000);
                        perfLog.czT = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.eem.getLocationOnScreen(iArr);
                            if (iArr[1] > l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.eem.startLogPerf();
                    }
                    if (oVar.fxq != null && (oVar.fxq instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fxq;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kR(1000);
                                perfLog2.czT = true;
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
    public void aKk() {
        this.fws.setNextPage(this.dnN);
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnN.akF();
    }

    public void aKl() {
        this.fws.setNextPage(this.dnN);
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnN.akG();
        this.dnN.setText(this.fLB.getResources().getString(R.string.list_has_no_more));
    }

    public void aKm() {
        this.fws.setNextPage(null);
    }

    public void kp(boolean z) {
        this.boy.setVisibility(z ? 0 : 8);
        kG(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.fCV.fPv = intValue;
                if (!this.fLI) {
                    this.fLJ = intValue;
                    a(intValue, this.fLD, false);
                    this.fLB.sw(this.fLJ);
                    t.aZP().iE(false);
                    c.coG().b(this.fLB.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dpp != null && this.dpp.isRefreshing()) {
            this.dpp.oU();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.fLI && (tab.getTag() instanceof Integer)) {
                this.fLJ = ((Integer) tab.getTag()).intValue();
                this.fLB.sw(this.fLJ);
            }
            a(tab);
        }
    }

    private void bqV() {
        if (this.fLC == null) {
            this.fLC = (TabLayout) LayoutInflater.from(this.fLB.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.fLC.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(this.fLB.getContext(), R.dimen.tbds126)));
            this.fLC.setOnTabSelectedListener(this);
            b(this.fLC);
            this.fws.addHeaderView(this.fLC);
        }
    }

    private void bX(View view) {
        this.fLD = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.fLD.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.fLC, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.dpp != null && a.this.dpp.isRefreshing()) {
                    a.this.dpp.oU();
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

    private void kG(boolean z) {
        if (z) {
            this.fLD.setVisibility(8);
        } else if (this.fLD.getTabCount() > 1) {
            this.fLD.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            am.l(tabLayout, R.color.cp_bg_line_d);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                    TextView textView = (TextView) tabAt.getCustomView();
                    if (tabAt.isSelected()) {
                        textView.setTextColor(am.getColor(R.color.cp_cont_b));
                    } else {
                        textView.setTextColor(am.getColor(R.color.cp_cont_c));
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
                if (!aq.isEmpty(themeElement.font_color)) {
                    this.fLG = themeElement.font_color;
                }
            }
        }
    }

    private void a(TextView textView, int i, int i2, boolean z) {
        GradientDrawable k;
        if (textView != null) {
            int g = l.g(this.fLB.getPageContext().getPageActivity(), R.dimen.tbds1);
            int g2 = l.g(this.fLB.getPageContext().getPageActivity(), R.dimen.tbds10);
            if (z && !aq.isEmpty(this.fLG)) {
                k = am.b(g2, i, this.fLG, g);
                textView.setTextColor(Color.parseColor("#" + this.fLG));
            } else {
                k = am.k(g2, i, i2, g);
                textView.setTextColor(am.getColor(R.color.cp_cont_c));
            }
            if (k != null) {
                textView.setBackgroundDrawable(k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        TextView textView;
        if (tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, R.color.cp_bg_line_d, this.fLK, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        TextView textView;
        if (tab != null && tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, R.color.cp_bg_line_d, R.color.cp_bg_line_b, false);
        }
    }

    public void bny() {
        if (bqU() != null) {
            List<m> dataList = bqU().getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bg) {
                        bg bgVar = (bg) mVar;
                        if (bgVar.bJl != 0 && bgVar.threadData != null) {
                            int[] agr = bgVar.threadData.agr();
                            bgVar.bJl = agr[0];
                            bgVar.bJm = agr[1];
                        }
                    }
                }
                e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bqU().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void xu(String str) {
        if (this.fLB.bqO() != null) {
            this.fLB.bqO().xw(str);
        }
    }

    public void xv(String str) {
        if (!StringUtils.isNull(str) && !v.aa(this.fLE.getDataList())) {
            Iterator<m> it = this.fLE.bra().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAz() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAz()).bEU)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
