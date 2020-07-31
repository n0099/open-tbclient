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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.s.c;
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
/* loaded from: classes16.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private FrameLayout drp;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private ac evc;
    private PbListView fsC;
    private FrsGoodFragment hYN;
    private TabLayout hYO;
    private TabLayout hYP;
    private b hYQ;
    public String hYS;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView hIh = null;
    private BannerView hYR = null;
    private boolean hYT = false;
    private boolean hYU = false;
    private int hYV = 0;
    private View.OnClickListener hNP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hYN != null) {
                a.this.hYN.onScrollToBottom();
            }
        }
    };
    private BannerView.a hYW = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bgW() {
            a.this.cgG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bgX() {
            a.this.cgI();
        }
    };
    private CustomMessageListener hYX = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Gl(str);
                a.this.Gk(str);
                a.this.hYQ.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.hYN = null;
        this.hYN = frsGoodFragment;
        m(view, z);
        this.ds16 = l.getDimens(this.hYN.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.hYN.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.hYN.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void m(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cj(view);
        this.hIh = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.hIh.setLayoutManager(new LinearLayoutManager(this.hIh.getContext()));
        this.hIh.setFadingEdgeLength(0);
        this.hIh.setOverScrollMode(2);
        this.hIh.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        this.fsC = new PbListView(this.hYN.getPageContext().getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.hYN.getActivity(), R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hIh.setOnSrollToBottomListener(this.hYN);
        this.drp = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.hYQ = new b(this.hYN, this.hIh);
        jH(false);
        this.hYN.registerListener(this.hYX);
    }

    private void b(ac acVar) {
        if (this.hYR == null) {
            this.hYR = new BannerView(this.hYN.getPageContext().getPageActivity());
            this.hYR.setLayoutParams(new AbsListView.LayoutParams(-1, this.hYN.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.hYR.setVisibility(8);
            this.hYR.setBannerViewClickListener(this.hYW);
            this.hYR.setBannerData(acVar);
            this.hYR.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.hYR.bgU() && !a.this.hYT && a.this.hIh != null) {
                        a.this.hYT = true;
                        a.this.hIh.addHeaderView(a.this.hYR, 1);
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
    public void cgG() {
        if (this.evc != null) {
            String value = this.evc.getValue();
            if (this.evc.aUx() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.hYN.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.evc.aUx() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.hYN.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.hYN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.evc.aUx() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ebG != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ebG) {
                        case FRS:
                            this.hYN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hYN.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.hYN.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.hYN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bd.baV().b(this.hYN.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hYN.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.evc.aUx() == 4) {
                this.hYN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.hYN.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.hYQ != null) {
            this.hYQ.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hIh.setOnScrollListener(onScrollListener);
    }

    public void a(z zVar) {
        this.hYQ.a(zVar);
    }

    public void onDestroy() {
        this.hYQ.onDestory();
        this.hIh.setOnSrollToBottomListener(null);
        a(this.hYO);
        a(this.hYP);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void jH(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 301;
            uVar.eZg = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void cea() {
        u uVar = new u();
        uVar.tabId = 301;
        uVar.eZg = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void bBY() {
        this.hIh.setVisibility(0);
    }

    public void ccH() {
        if (this.hYQ != null) {
            this.hYQ.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ai> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.hYN.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ai aiVar : good_classify) {
                if (aiVar != null && aiVar.aUA() > 0 && !TextUtils.isEmpty(aiVar.aUz()) && !TextUtils.isEmpty(aiVar.aUz().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = aiVar.aUA();
                    dVar2.name = aiVar.aUz();
                    tabData.add(dVar2);
                }
            }
            if (x.getCount(tabData) > 1) {
                cgK();
                this.hYU = true;
                a(tabData, this.hYO);
                a(tabData, this.hYP);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.hYN.getContext());
                    com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                    dVar.mX(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(dVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(as.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.hYV) {
                    tab.select();
                }
            }
            linearLayout.setPadding(this.ds28, 0, this.ds28, 0);
        }
    }

    public void a(ArrayList<q> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            r rVar = new r();
            arrayList = new ArrayList<>();
            arrayList.add(rVar);
        }
        this.hYQ.b(arrayList, frsViewData);
        this.hYU = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.hIh;
    }

    public void cgH() {
        this.hYQ.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.hIh.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.hYT && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.evc = forumData.getFrsBannerData();
            b(this.evc);
            this.hYR.reset();
            this.hIh.removeHeaderView(this.hYR);
            if (this.evc.getType() == 1 && !TextUtils.isEmpty(this.evc.aUy())) {
                this.hYR.setData(this.hYN.getPageContext(), this.evc.aUy());
                if (this.evc.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.hYN.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cgI() {
        if (this.hYR != null) {
            this.hYT = false;
            this.hIh.removeHeaderView(this.hYR);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.hYQ != null) {
            this.hYQ.cfh();
            this.hYQ.notifyDataSetChanged();
            this.hYQ.onChangeSkinType(i);
        }
        this.hYN.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hYN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.hYR != null) {
            this.hYR.bgV();
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        b(this.hYO);
        b(this.hYP);
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 301;
        uVar.eZg = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void bxe() {
        u uVar = new u();
        uVar.tabId = 301;
        uVar.eZg = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public b cgJ() {
        return this.hYQ;
    }

    public RelativeLayout bPb() {
        return this.mContainer;
    }

    public void nY(boolean z) {
        ab abVar = new ab();
        abVar.tabId = 301;
        abVar.eiE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, abVar));
    }

    public void ccW() {
        if (m.blA().blB()) {
            int lastVisiblePosition = this.hIh.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hIh.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof t)) {
                    t tVar = (t) childAt.getTag();
                    if (tVar.hJe != null) {
                        h perfLog = tVar.hJe.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eHc = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            tVar.hJe.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        tVar.hJe.startLogPerf();
                    }
                    if (tVar.hJd != null && (tVar.hJd instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = tVar.hJd;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eHc = true;
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
    public void bxS() {
        this.hIh.setNextPage(this.fsC);
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setOnClickListener(null);
        this.fsC.startLoadData();
    }

    public void ccX() {
        this.hIh.setNextPage(this.fsC);
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setOnClickListener(this.hNP);
        this.fsC.endLoadData();
        this.fsC.setText(this.hYN.getResources().getString(R.string.list_click_load_more));
    }

    public void bxT() {
        this.hIh.setNextPage(this.fsC);
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setOnClickListener(null);
        this.fsC.endLoadData();
        this.fsC.setText(this.hYN.getResources().getString(R.string.list_has_no_more));
    }

    public void bxU() {
        this.hIh.setNextPage(null);
    }

    public void nZ(boolean z) {
        this.drp.setVisibility(z ? 0 : 8);
        or(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.hOE.icO = intValue;
                if (!this.hYU) {
                    this.hYV = intValue;
                    a(intValue, this.hYP, false);
                    this.hYN.vQ(this.hYV);
                    s.bRL().mH(false);
                    c.dkh().b(this.hYN.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bxe();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.hYU && (tab.getTag() instanceof Integer)) {
                this.hYV = ((Integer) tab.getTag()).intValue();
                this.hYN.vQ(this.hYV);
            }
            setTabColorSelected(tab);
        }
    }

    private void cgK() {
        if (this.hYO == null) {
            this.hYO = (TabLayout) LayoutInflater.from(this.hYN.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.hYO.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.hYN.getContext(), R.dimen.tbds126)));
            this.hYO.setOnTabSelectedListener(this);
            b(this.hYO);
            this.hIh.addHeaderView(this.hYO);
        }
    }

    private void cj(View view) {
        this.hYP = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.hYP.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.hYO, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bxe();
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

    private void or(boolean z) {
        if (z) {
            this.hYP.setVisibility(8);
        } else if (this.hYP.getTabCount() > 1) {
            this.hYP.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            ao.setBackgroundColor(tabLayout, R.color.cp_bg_line_e);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                        if (!tabAt.isSelected()) {
                            dVar.mX(R.color.cp_cont_c);
                        } else if (as.isEmpty(this.hYS)) {
                            dVar.mX(R.color.cp_cont_b);
                        } else {
                            dVar.mY(com.baidu.tieba.lego.card.d.a.dU(this.hYS));
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
            if (!as.isEmpty(themeElement.font_color)) {
                this.hYS = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            com.baidu.tbadk.core.view.commonBtn.d dVar = (com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (as.isEmpty(this.hYS)) {
                dVar.mX(R.color.cp_cont_b);
            } else {
                dVar.mY(com.baidu.tieba.lego.card.d.a.dU(this.hYS));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((com.baidu.tbadk.core.view.commonBtn.d) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).mX(R.color.cp_cont_c);
        }
    }

    public void zc() {
        if (cgJ() != null) {
            List<q> dataList = cgJ().getDataList();
            if (!x.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof bu) {
                        bu buVar = (bu) qVar;
                        if (buVar.dRu != 0 && buVar.dLK != null) {
                            int[] imageWidthAndHeight = buVar.dLK.getImageWidthAndHeight();
                            buVar.dRu = imageWidthAndHeight[0];
                            buVar.dRv = imageWidthAndHeight[1];
                        }
                    }
                }
                e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cgJ().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Gk(String str) {
        if (this.hYN.cgD() != null) {
            this.hYN.cgD().Gm(str);
        }
    }

    public void Gl(String str) {
        if (!StringUtils.isNull(str) && !x.isEmpty(this.hYQ.getDataList())) {
            Iterator<q> it = this.hYQ.cgR().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bqq() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bqq()).dMW)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
