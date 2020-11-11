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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.v;
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
/* loaded from: classes22.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private FrameLayout edL;
    private ad fig;
    private PbListView gjo;
    private FrsGoodFragment jbG;
    private TabLayout jbH;
    private TabLayout jbI;
    private b jbJ;
    public String jbL;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView iJX = null;
    private BannerView jbK = null;
    private boolean jbM = false;
    private boolean jbN = false;
    private int jbO = 0;
    private View.OnClickListener iQw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jbG != null) {
                a.this.jbG.onScrollToBottom();
            }
        }
    };
    private BannerView.a jbP = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bxF() {
            a.this.cDG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bxG() {
            a.this.cDI();
        }
    };
    private CustomMessageListener jbQ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.KP(str);
                a.this.KO(str);
                a.this.jbJ.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.jbG = null;
        this.jbG = frsGoodFragment;
        m(view, z);
        this.ds16 = l.getDimens(this.jbG.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.jbG.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.jbG.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void m(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cH(view);
        this.iJX = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.iJX.setLayoutManager(new LinearLayoutManager(this.iJX.getContext()));
        this.iJX.setFadingEdgeLength(0);
        this.iJX.setOverScrollMode(2);
        this.iJX.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        this.gjo = new PbListView(this.jbG.getPageContext().getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.jbG.getActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iJX.setOnSrollToBottomListener(this.jbG);
        this.edL = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jbJ = new b(this.jbG, this.iJX);
        lc(false);
        this.jbG.registerListener(this.jbQ);
    }

    private void b(ad adVar) {
        if (this.jbK == null) {
            this.jbK = new BannerView(this.jbG.getPageContext().getPageActivity());
            this.jbK.setLayoutParams(new AbsListView.LayoutParams(-1, this.jbG.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jbK.setVisibility(8);
            this.jbK.setBannerViewClickListener(this.jbP);
            this.jbK.setBannerData(adVar);
            this.jbK.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.jbK.bxD() && !a.this.jbM && a.this.iJX != null) {
                        a.this.jbM = true;
                        a.this.iJX.addHeaderView(a.this.jbK, 1);
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
    public void cDG() {
        if (this.fig != null) {
            String value = this.fig.getValue();
            if (this.fig.bkM() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jbG.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fig.bkM() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jbG.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jbG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fig.bkM() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eOe != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eOe) {
                        case FRS:
                            this.jbG.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jbG.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jbG.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jbG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.brr().b(this.jbG.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jbG.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fig.bkM() == 4) {
                this.jbG.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jbG.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.jbJ != null) {
            this.jbJ.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iJX.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.jbJ.a(abVar);
    }

    public void onDestroy() {
        this.jbJ.onDestory();
        this.iJX.setOnSrollToBottomListener(null);
        a(this.jbH);
        a(this.jbI);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void lc(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 301;
            vVar.fNU = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cAY() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fNU = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bVq() {
        this.iJX.setVisibility(0);
    }

    public void czx() {
        if (this.jbJ != null) {
            this.jbJ.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<aj> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.jbG.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (aj ajVar : good_classify) {
                if (ajVar != null && ajVar.bkP() > 0 && !TextUtils.isEmpty(ajVar.bkO()) && !TextUtils.isEmpty(ajVar.bkO().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = ajVar.bkP();
                    dVar2.name = ajVar.bkO();
                    tabData.add(dVar2);
                }
            }
            if (y.getCount(tabData) > 1) {
                cDK();
                this.jbN = true;
                a(tabData, this.jbH);
                a(tabData, this.jbI);
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
                if (!(tab.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.jbG.getContext());
                    c cVar = new c();
                    cVar.qk(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(at.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.jbO) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds28, 0, this.ds28, 0);
        }
    }

    public void a(ArrayList<q> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            s sVar = new s();
            arrayList = new ArrayList<>();
            arrayList.add(sVar);
        }
        this.jbJ.b(arrayList, frsViewData);
        this.jbN = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.iJX;
    }

    public void cDH() {
        this.jbJ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.iJX.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.jbM && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fig = forumData.getFrsBannerData();
            b(this.fig);
            this.jbK.reset();
            this.iJX.removeHeaderView(this.jbK);
            if (this.fig.getType() == 1 && !TextUtils.isEmpty(this.fig.bkN())) {
                this.jbK.setData(this.jbG.getPageContext(), this.fig.bkN());
                if (this.fig.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jbG.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cDI() {
        if (this.jbK != null) {
            this.jbM = false;
            this.iJX.removeHeaderView(this.jbK);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jbJ != null) {
            this.jbJ.cCf();
            this.jbJ.notifyDataSetChanged();
            this.jbJ.onChangeSkinType(i);
        }
        this.jbG.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jbG.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jbK != null) {
            this.jbK.bxE();
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        b(this.jbH);
        b(this.jbI);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fNU = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bPh() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fNU = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public b cDJ() {
        return this.jbJ;
    }

    public RelativeLayout cka() {
        return this.mContainer;
    }

    public void pQ(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 301;
        adVar.eUZ = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void czM() {
        if (m.bCu().bCv()) {
            int lastVisiblePosition = this.iJX.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iJX.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.iKU != null) {
                        h perfLog = uVar.iKU.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fvf = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.iKU.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.iKU.startLogPerf();
                    }
                    if (uVar.iKT != null && (uVar.iKT instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.iKT;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fvf = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
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
    public void Wi() {
        this.iJX.setNextPage(this.gjo);
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.setOnClickListener(null);
        this.gjo.startLoadData();
    }

    public void czN() {
        this.iJX.setNextPage(this.gjo);
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.setOnClickListener(this.iQw);
        this.gjo.endLoadData();
        this.gjo.setText(this.jbG.getResources().getString(R.string.list_click_load_more));
    }

    public void Wj() {
        this.iJX.setNextPage(this.gjo);
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.setOnClickListener(null);
        this.gjo.endLoadData();
        this.gjo.setText(this.jbG.getResources().getString(R.string.list_has_no_more));
    }

    public void bPW() {
        this.iJX.setNextPage(null);
    }

    public void pR(boolean z) {
        this.edL.setVisibility(z ? 0 : 8);
        qj(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.iRl.jfF = intValue;
                if (!this.jbN) {
                    this.jbO = intValue;
                    a(intValue, this.jbI, false);
                    this.jbG.zU(this.jbO);
                    t.cor().oy(false);
                    com.baidu.tieba.s.c.dIX().b(this.jbG.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bPh();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.jbN && (tab.getTag() instanceof Integer)) {
                this.jbO = ((Integer) tab.getTag()).intValue();
                this.jbG.zU(this.jbO);
            }
            setTabColorSelected(tab);
        }
    }

    private void cDK() {
        if (this.jbH == null) {
            this.jbH = (TabLayout) LayoutInflater.from(this.jbG.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.jbH.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.jbG.getContext(), R.dimen.tbds126)));
            this.jbH.setOnTabSelectedListener(this);
            b(this.jbH);
            this.iJX.addHeaderView(this.jbH);
        }
    }

    private void cH(View view) {
        this.jbI = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.jbI.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.jbH, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bPh();
                a.this.setTabColorUnSelected(tab);
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
                                setTabColorSelected(tabAt);
                            }
                        } else if (!z) {
                            setTabColorUnSelected(tabAt);
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void qj(boolean z) {
        if (z) {
            this.jbI.setVisibility(8);
        } else if (this.jbI.getTabCount() > 1) {
            this.jbI.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            ap.setBackgroundColor(tabLayout, R.color.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        c cVar = (c) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                        if (!tabAt.isSelected()) {
                            cVar.qk(R.color.cp_cont_c);
                        } else if (at.isEmpty(this.jbL)) {
                            cVar.qk(R.color.cp_cont_b);
                        } else {
                            cVar.ql(com.baidu.tieba.lego.card.d.b.fv(this.jbL));
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(ThemeColorInfo themeColorInfo) {
        ThemeElement themeElement;
        if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            this.mThemeColorInfo = themeColorInfo;
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = this.mThemeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = this.mThemeColorInfo.night;
            } else {
                themeElement = this.mThemeColorInfo.day;
            }
            if (!at.isEmpty(themeElement.font_color)) {
                this.jbL = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (at.isEmpty(this.jbL)) {
                cVar.qk(R.color.cp_cont_b);
            } else {
                cVar.ql(com.baidu.tieba.lego.card.d.b.fv(this.jbL));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).qk(R.color.cp_cont_c);
        }
    }

    public void GI() {
        if (cDJ() != null) {
            List<q> dataList = cDJ().getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.eDx != 0 && bvVar.exA != null) {
                            int[] imageWidthAndHeight = bvVar.exA.getImageWidthAndHeight();
                            bvVar.eDx = imageWidthAndHeight[0];
                            bvVar.eDy = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cDJ().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void KO(String str) {
        if (this.jbG.cDD() != null) {
            this.jbG.cDD().KQ(str);
        }
    }

    public void KP(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jbJ.getDataList())) {
            Iterator<q> it = this.jbJ.cDR().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bHC() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bHC()).eyO)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
