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
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout boW;
    private x cmV;
    private PbListView dpz;
    private BdSwipeRefreshLayout dra;
    private final int ds13;
    private final int ds212;
    private final int ds31;
    private final int ds32;
    private final int ds34;
    private final int ds74;
    private FrsGoodFragment fNq;
    private TabLayout fNr;
    private TabLayout fNs;
    private b fNt;
    public String fNv;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout cXd = null;
    private BdTypeRecyclerView fyf = null;
    private i mPullView = null;
    private BannerView fNu = null;
    private boolean fNw = false;
    private boolean fNx = false;
    private int fNy = 0;
    private int fNz = R.color.cp_link_tip_a;
    private BannerView.a fNA = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqt() {
            a.this.brC();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqu() {
            a.this.brE();
        }
    };
    private CustomMessageListener fNB = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.xU(str);
                a.this.xT(str);
                a.this.fNt.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.fNq = null;
        this.fNq = frsGoodFragment;
        l(view, z);
        this.ds13 = l.g(this.fNq.getPageContext().getPageActivity(), R.dimen.tbds13);
        this.ds32 = l.g(this.fNq.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds212 = l.g(this.fNq.getPageContext().getPageActivity(), R.dimen.tbds212);
        this.ds74 = l.g(this.fNq.getPageContext().getPageActivity(), R.dimen.tbds74);
        this.ds34 = l.g(this.fNq.getPageContext().getPageActivity(), R.dimen.tbds34);
        this.ds31 = l.g(this.fNq.getPageContext().getPageActivity(), R.dimen.tbds31);
    }

    private void l(View view, boolean z) {
        this.cXd = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bX(view);
        this.fyf = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fyf.setLayoutManager(new LinearLayoutManager(this.fyf.getContext()));
        this.mPullView = new i(this.fNq.getPageContext());
        this.fyf.setFadingEdgeLength(0);
        this.fyf.setOverScrollMode(2);
        this.fyf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.dpz = new PbListView(this.fNq.getPageContext().getPageActivity());
        this.dpz.nZ();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.setHeight(l.g(this.fNq.getActivity(), R.dimen.tbds182));
        this.dpz.akO();
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.iW(R.color.cp_cont_e);
        this.fyf.setOnSrollToBottomListener(this.fNq);
        if (this.dra == null) {
            this.dra = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dra.setProgressView(this.mPullView);
            am.l(this.dra, R.color.cp_bg_line_e);
        }
        this.boW = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fNt = new b(this.fNq, this.fyf);
        gf(false);
        this.fNq.registerListener(this.fNB);
    }

    private void b(x xVar) {
        if (this.fNu == null) {
            this.fNu = new BannerView(this.fNq.getPageContext().getPageActivity());
            this.fNu.setLayoutParams(new AbsListView.LayoutParams(-1, this.fNq.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fNu.setVisibility(8);
            this.fNu.setBannerViewClickListener(this.fNA);
            this.fNu.setBannerData(xVar);
            this.fNu.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void P(String str, boolean z) {
                    if (z && a.this.fNu.aqr() && !a.this.fNw && a.this.fyf != null) {
                        a.this.fNw = true;
                        a.this.fyf.addHeaderView(a.this.fNu, 1);
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
    public void brC() {
        if (this.cmV != null) {
            String value = this.cmV.getValue();
            if (this.cmV.ada() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fNq.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.cmV.ada() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fNq.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fNq.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.cmV.ada() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bVe != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bVe) {
                        case FRS:
                            this.fNq.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fNq.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fNq.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fNq.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                ba.ajK().c(this.fNq.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fNq.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.cmV.ada() == 4) {
                this.fNq.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fNq.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.fyf.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fNt.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fNt.onDestory();
        this.fyf.setOnSrollToBottomListener(null);
        a(this.fNr);
        a(this.fNs);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void gf(boolean z) {
        if (!z) {
            this.dra.setRefreshing(false);
        }
    }

    public void aWv() {
        this.fyf.setVisibility(0);
    }

    public void bnN() {
        if (this.fNt != null) {
            this.fNt.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.fNq.fNj) {
            ArrayList<ac> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.fNq.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ac acVar : good_classify) {
                if (acVar != null && acVar.add() > 0 && !TextUtils.isEmpty(acVar.adc()) && !TextUtils.isEmpty(acVar.adc().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = acVar.add();
                    dVar2.name = acVar.adc();
                    tabData.add(dVar2);
                }
            }
            if (v.Z(tabData) > 1) {
                brG();
                this.fNx = true;
                a(tabData, this.fNr);
                a(tabData, this.fNs);
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
                    TextView textView = new TextView(this.fNq.getContext());
                    textView.setSingleLine();
                    am.k(textView, R.drawable.btn_white_corners_selector);
                    textView.setGravity(17);
                    textView.setTextSize(0, this.ds34);
                    textView.setTextColor(am.getColor(R.color.cp_cont_c));
                    a(textView, R.color.cp_bg_line_e, R.color.cp_btn_b, true);
                    tab.setCustomView(textView);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds212, this.ds74);
                    layoutParams.setMargins(this.ds13, this.ds32, this.ds13, this.ds32);
                    textView.setLayoutParams(layoutParams);
                }
                ((TextView) tab.getCustomView()).setText(aq.k(tabData.get(i2).name, 10, "..."));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.fNy) {
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
        this.fNt.b(arrayList, frsViewData);
        this.fNx = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.fyf;
    }

    public void brD() {
        this.fNt.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fyf.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fNw && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.cmV = forumData.getFrsBannerData();
            b(this.cmV);
            this.fNu.reset();
            this.fyf.removeHeaderView(this.fNu);
            if (this.cmV.getType() == 1 && !TextUtils.isEmpty(this.cmV.adb())) {
                this.fNu.setData(this.fNq.getPageContext(), this.cmV.adb());
                if (this.cmV.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fNq.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void brE() {
        if (this.fNu != null) {
            this.fNw = false;
            this.fyf.removeHeaderView(this.fNu);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        if (this.fNt != null) {
            this.fNt.bpY();
            this.fNt.notifyDataSetChanged();
            this.fNt.onChangeSkinType(i);
        }
        this.fNq.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fNq.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cXd);
        if (this.fNu != null) {
            this.fNu.aqs();
        }
        if (this.dpz != null) {
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dpz.iY(i);
        }
        am.l(this.dra, R.color.cp_bg_line_d);
        b(this.fNr);
        b(this.fNs);
    }

    public void startPullRefresh() {
        this.dra.setRefreshing(true);
    }

    public b brF() {
        return this.fNt;
    }

    public RelativeLayout aYe() {
        return this.cXd;
    }

    public View bpa() {
        return this.dra;
    }

    public void bob() {
        if (com.baidu.tbadk.p.m.avH().avI()) {
            int lastVisiblePosition = this.fyf.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fyf.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.efW != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.efW.getPerfLog();
                        perfLog.kU(1000);
                        perfLog.cAP = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.efW.getLocationOnScreen(iArr);
                            if (iArr[1] > l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.efW.startLogPerf();
                    }
                    if (oVar.fzd != null && (oVar.fzd instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fzd;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kU(1000);
                                perfLog2.cAP = true;
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
    public void aKO() {
        this.fyf.setNextPage(this.dpz);
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dpz.akR();
    }

    public void aKP() {
        this.fyf.setNextPage(this.dpz);
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dpz.akS();
        this.dpz.setText(this.fNq.getResources().getString(R.string.list_has_no_more));
    }

    public void aKQ() {
        this.fyf.setNextPage(null);
    }

    public void ks(boolean z) {
        this.boW.setVisibility(z ? 0 : 8);
        kJ(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.fEI.fRm = intValue;
                if (!this.fNx) {
                    this.fNy = intValue;
                    a(intValue, this.fNs, false);
                    this.fNq.sA(this.fNy);
                    t.bat().iH(false);
                    c.cpt().b(this.fNq.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dra != null && this.dra.isRefreshing()) {
            this.dra.oV();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.fNx && (tab.getTag() instanceof Integer)) {
                this.fNy = ((Integer) tab.getTag()).intValue();
                this.fNq.sA(this.fNy);
            }
            a(tab);
        }
    }

    private void brG() {
        if (this.fNr == null) {
            this.fNr = (TabLayout) LayoutInflater.from(this.fNq.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.fNr.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(this.fNq.getContext(), R.dimen.tbds126)));
            this.fNr.setOnTabSelectedListener(this);
            b(this.fNr);
            this.fyf.addHeaderView(this.fNr);
        }
    }

    private void bX(View view) {
        this.fNs = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.fNs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.fNr, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.dra != null && a.this.dra.isRefreshing()) {
                    a.this.dra.oV();
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

    private void kJ(boolean z) {
        if (z) {
            this.fNs.setVisibility(8);
        } else if (this.fNs.getTabCount() > 1) {
            this.fNs.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            am.l(tabLayout, R.color.cp_bg_line_e);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                    TextView textView = (TextView) tabAt.getCustomView();
                    if (tabAt.isSelected()) {
                        textView.setTextColor(am.getColor(R.color.cp_cont_b));
                    } else {
                        textView.setTextColor(am.getColor(R.color.cp_cont_c));
                    }
                    a(textView, R.color.cp_bg_line_e, R.color.cp_btn_b, false);
                }
            }
        }
    }

    public void a(ThemeColorInfo themeColorInfo) {
        ThemeElement themeElement;
        if (themeColorInfo != null) {
            this.mThemeColorInfo = themeColorInfo;
            if (this.mThemeColorInfo != null && this.mThemeColorInfo.day != null && this.mThemeColorInfo.night != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 1 || skinType == 4) {
                    themeElement = this.mThemeColorInfo.night;
                } else {
                    themeElement = this.mThemeColorInfo.day;
                }
                if (!aq.isEmpty(themeElement.font_color)) {
                    this.fNv = themeElement.font_color;
                }
            }
        }
    }

    private void a(TextView textView, int i, int i2, boolean z) {
        GradientDrawable n;
        if (textView != null) {
            int g = l.g(this.fNq.getPageContext().getPageActivity(), R.dimen.tbds1);
            int g2 = l.g(this.fNq.getPageContext().getPageActivity(), R.dimen.tbds80);
            if (z && !aq.isEmpty(this.fNv)) {
                n = am.b(g2, i, this.fNv, g);
                textView.setTextColor(Color.parseColor("#" + this.fNv));
            } else {
                n = am.n(g2, i, i2, g);
                textView.setTextColor(am.getColor(R.color.cp_cont_c));
            }
            if (n != null) {
                textView.setBackgroundDrawable(n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TabLayout.Tab tab) {
        TextView textView;
        if (tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, R.color.cp_bg_line_e, this.fNz, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        TextView textView;
        if (tab != null && tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, R.color.cp_bg_line_e, R.color.cp_btn_b, false);
        }
    }

    public void boj() {
        if (brF() != null) {
            List<m> dataList = brF().getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bg) {
                        bg bgVar = (bg) mVar;
                        if (bgVar.bJJ != 0 && bgVar.threadData != null) {
                            int[] agv = bgVar.threadData.agv();
                            bgVar.bJJ = agv[0];
                            bgVar.bJK = agv[1];
                        }
                    }
                }
                e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.brF().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void xT(String str) {
        if (this.fNq.brz() != null) {
            this.fNq.brz().xV(str);
        }
    }

    public void xU(String str) {
        if (!StringUtils.isNull(str) && !v.aa(this.fNt.getDataList())) {
            Iterator<m> it = this.fNt.brL().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAN() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAN()).bFs)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
