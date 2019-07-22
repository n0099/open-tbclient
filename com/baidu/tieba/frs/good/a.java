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
import com.baidu.tbadk.core.data.bf;
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
    private x clS;
    private PbListView dnG;
    private BdSwipeRefreshLayout dpi;
    private final int ds13;
    private final int ds212;
    private final int ds31;
    private final int ds32;
    private final int ds34;
    private final int ds74;
    private FrsGoodFragment fKN;
    private TabLayout fKO;
    private TabLayout fKP;
    private b fKQ;
    public String fKS;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout cWd = null;
    private BdTypeRecyclerView fvT = null;
    private i mPullView = null;
    private BannerView fKR = null;
    private boolean fKT = false;
    private boolean fKU = false;
    private int fKV = 0;
    private int fKW = R.color.cp_link_tip_a;
    private BannerView.a fKX = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqf() {
            a.this.bqE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqg() {
            a.this.bqG();
        }
    };
    private CustomMessageListener fKY = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.frs.good.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.xu(str);
                a.this.xt(str);
                a.this.fKQ.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.fKN = null;
        this.fKN = frsGoodFragment;
        l(view, z);
        this.ds13 = l.g(this.fKN.getPageContext().getPageActivity(), R.dimen.tbds13);
        this.ds32 = l.g(this.fKN.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds212 = l.g(this.fKN.getPageContext().getPageActivity(), R.dimen.tbds212);
        this.ds74 = l.g(this.fKN.getPageContext().getPageActivity(), R.dimen.tbds74);
        this.ds34 = l.g(this.fKN.getPageContext().getPageActivity(), R.dimen.tbds34);
        this.ds31 = l.g(this.fKN.getPageContext().getPageActivity(), R.dimen.tbds31);
    }

    private void l(View view, boolean z) {
        this.cWd = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        bW(view);
        this.fvT = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.fvT.setLayoutManager(new LinearLayoutManager(this.fvT.getContext()));
        this.mPullView = new i(this.fKN.getPageContext());
        this.fvT.setFadingEdgeLength(0);
        this.fvT.setOverScrollMode(2);
        this.fvT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.1
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
        this.dnG = new PbListView(this.fKN.getPageContext().getPageActivity());
        this.dnG.nZ();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.setHeight(l.g(this.fKN.getActivity(), R.dimen.tbds182));
        this.dnG.akA();
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnG.iT(R.color.cp_cont_e);
        this.fvT.setOnSrollToBottomListener(this.fKN);
        if (this.dpi == null) {
            this.dpi = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_pull_refresh_layout);
            this.dpi.setProgressView(this.mPullView);
            am.l(this.dpi, R.color.cp_bg_line_e);
        }
        this.boy = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.fKQ = new b(this.fKN, this.fvT);
        gc(false);
        this.fKN.registerListener(this.fKY);
    }

    private void b(x xVar) {
        if (this.fKR == null) {
            this.fKR = new BannerView(this.fKN.getPageContext().getPageActivity());
            this.fKR.setLayoutParams(new AbsListView.LayoutParams(-1, this.fKN.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.fKR.setVisibility(8);
            this.fKR.setBannerViewClickListener(this.fKX);
            this.fKR.setBannerData(xVar);
            this.fKR.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void P(String str, boolean z) {
                    if (z && a.this.fKR.aqd() && !a.this.fKT && a.this.fvT != null) {
                        a.this.fKT = true;
                        a.this.fvT.addHeaderView(a.this.fKR, 1);
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
    public void bqE() {
        if (this.clS != null) {
            String value = this.clS.getValue();
            if (this.clS.acV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.fKN.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.clS.acV() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.fKN.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.fKN.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.clS.acV() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bUv != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bUv) {
                        case FRS:
                            this.fKN.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fKN.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.fKN.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.fKN.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bb.ajC().c(this.fKN.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fKN.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.clS.acV() == 4) {
                this.fKN.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fKN.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
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
        this.fvT.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.fKQ.setOnAdapterItemClickListener(sVar);
    }

    public void onDestroy() {
        this.fKQ.onDestory();
        this.fvT.setOnSrollToBottomListener(null);
        a(this.fKO);
        a(this.fKP);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void gc(boolean z) {
        if (!z) {
            this.dpi.setRefreshing(false);
        }
    }

    public void aVP() {
        this.fvT.setVisibility(0);
    }

    public void bmS() {
        if (this.fKQ != null) {
            this.fKQ.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null && !this.fKN.fKG) {
            ArrayList<ac> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.fKN.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ac acVar : good_classify) {
                if (acVar != null && acVar.acY() > 0 && !TextUtils.isEmpty(acVar.acX()) && !TextUtils.isEmpty(acVar.acX().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = acVar.acY();
                    dVar2.name = acVar.acX();
                    tabData.add(dVar2);
                }
            }
            if (v.Z(tabData) > 1) {
                bqI();
                this.fKU = true;
                a(tabData, this.fKO);
                a(tabData, this.fKP);
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
                    TextView textView = new TextView(this.fKN.getContext());
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
                if (tabData.get(i2).tabId == this.fKV) {
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
        this.fKQ.b(arrayList, frsViewData);
        this.fKU = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.fvT;
    }

    public void bqF() {
        this.fKQ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.fvT.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.fKT && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.clS = forumData.getFrsBannerData();
            b(this.clS);
            this.fKR.reset();
            this.fvT.removeHeaderView(this.fKR);
            if (this.clS.getType() == 1 && !TextUtils.isEmpty(this.clS.acW())) {
                this.fKR.setData(this.fKN.getPageContext(), this.clS.acW());
                if (this.clS.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.fKN.getPageContext().getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void bqG() {
        if (this.fKR != null) {
            this.fKT = false;
            this.fvT.removeHeaderView(this.fKR);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.fKQ != null) {
            this.fKQ.bpa();
            this.fKQ.notifyDataSetChanged();
            this.fKQ.onChangeSkinType(i);
        }
        this.fKN.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fKN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cWd);
        if (this.fKR != null) {
            this.fKR.aqe();
        }
        if (this.dnG != null) {
            this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnG.iV(i);
        }
        am.l(this.dpi, R.color.cp_bg_line_e);
        b(this.fKO);
        b(this.fKP);
    }

    public void startPullRefresh() {
        this.dpi.setRefreshing(true);
    }

    public b bqH() {
        return this.fKQ;
    }

    public RelativeLayout aXy() {
        return this.cWd;
    }

    public View boe() {
        return this.dpi;
    }

    public void bng() {
        if (com.baidu.tbadk.p.m.avt().avu()) {
            int lastVisiblePosition = this.fvT.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fvT.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.eef != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.eef.getPerfLog();
                        perfLog.kQ(1000);
                        perfLog.czM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.eef.getLocationOnScreen(iArr);
                            if (iArr[1] > l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.eef.startLogPerf();
                    }
                    if (oVar.fwR != null && (oVar.fwR instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fwR;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kQ(1000);
                                perfLog2.czM = true;
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
    public void aKi() {
        this.fvT.setNextPage(this.dnG);
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnG.akD();
    }

    public void aKj() {
        this.fvT.setNextPage(this.dnG);
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnG.akE();
        this.dnG.setText(this.fKN.getResources().getString(R.string.list_has_no_more));
    }

    public void aKk() {
        this.fvT.setNextPage(null);
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
                com.baidu.tieba.frs.d.d.fCh.fOH = intValue;
                if (!this.fKU) {
                    this.fKV = intValue;
                    a(intValue, this.fKP, false);
                    this.fKN.su(this.fKV);
                    t.aZN().iE(false);
                    c.coo().b(this.fKN.getUniqueId(), false);
                }
            }
            a(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dpi != null && this.dpi.isRefreshing()) {
            this.dpi.oU();
        }
        b(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.fKU && (tab.getTag() instanceof Integer)) {
                this.fKV = ((Integer) tab.getTag()).intValue();
                this.fKN.su(this.fKV);
            }
            a(tab);
        }
    }

    private void bqI() {
        if (this.fKO == null) {
            this.fKO = (TabLayout) LayoutInflater.from(this.fKN.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.fKO.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(this.fKN.getContext(), R.dimen.tbds126)));
            this.fKO.setOnTabSelectedListener(this);
            b(this.fKO);
            this.fvT.addHeaderView(this.fKO);
        }
    }

    private void bW(View view) {
        this.fKP = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.fKP.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.4
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.fKO, true);
                    }
                    a.this.a(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                if (a.this.dpi != null && a.this.dpi.isRefreshing()) {
                    a.this.dpi.oU();
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
            this.fKP.setVisibility(8);
        } else if (this.fKP.getTabCount() > 1) {
            this.fKP.setVisibility(0);
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
                    this.fKS = themeElement.font_color;
                }
            }
        }
    }

    private void a(TextView textView, int i, int i2, boolean z) {
        GradientDrawable k;
        if (textView != null) {
            int g = l.g(this.fKN.getPageContext().getPageActivity(), R.dimen.tbds1);
            int g2 = l.g(this.fKN.getPageContext().getPageActivity(), R.dimen.tbds10);
            if (z && !aq.isEmpty(this.fKS)) {
                k = am.b(g2, i, this.fKS, g);
                textView.setTextColor(Color.parseColor("#" + this.fKS));
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
            a(textView, R.color.cp_bg_line_d, this.fKW, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TabLayout.Tab tab) {
        TextView textView;
        if (tab != null && tab.getCustomView() != null && (textView = (TextView) tab.getCustomView()) != null) {
            a(textView, R.color.cp_bg_line_d, R.color.cp_bg_line_b, false);
        }
    }

    public void bno() {
        if (bqH() != null) {
            List<m> dataList = bqH().getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof bf) {
                        bf bfVar = (bf) mVar;
                        if (bfVar.bJg != 0 && bfVar.threadData != null) {
                            int[] agq = bfVar.threadData.agq();
                            bfVar.bJg = agq[0];
                            bfVar.bJh = agq[1];
                        }
                    }
                }
                e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bqH().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void xt(String str) {
        if (this.fKN.bqB() != null) {
            this.fKN.bqB().xv(str);
        }
    }

    public void xu(String str) {
        if (!StringUtils.isNull(str) && !v.aa(this.fKQ.getDataList())) {
            Iterator<m> it = this.fKQ.bqN().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.aAx() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAx()).bET)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
