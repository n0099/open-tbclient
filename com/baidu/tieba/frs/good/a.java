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
    private FrameLayout dPx;
    private final int ds16;
    private final int ds28;
    private final int ds32;
    private ad eTS;
    private PbListView fTv;
    private FrsGoodFragment iJn;
    private TabLayout iJo;
    private TabLayout iJp;
    private b iJq;
    public String iJs;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView irE = null;
    private BannerView iJr = null;
    private boolean iJt = false;
    private boolean iJu = false;
    private int iJv = 0;
    private View.OnClickListener iyd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iJn != null) {
                a.this.iJn.onScrollToBottom();
            }
        }
    };
    private BannerView.a iJw = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void btn() {
            a.this.cxY();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bto() {
            a.this.cya();
        }
    };
    private CustomMessageListener iJx = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.JZ(str);
                a.this.JY(str);
                a.this.iJq.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.iJn = null;
        this.iJn = frsGoodFragment;
        l(view, z);
        this.ds16 = l.getDimens(this.iJn.getPageContext().getPageActivity(), R.dimen.tbds16);
        this.ds32 = l.getDimens(this.iJn.getPageContext().getPageActivity(), R.dimen.tbds32);
        this.ds28 = l.getDimens(this.iJn.getPageContext().getPageActivity(), R.dimen.tbds28);
    }

    private void l(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cy(view);
        this.irE = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.irE.setLayoutManager(new LinearLayoutManager(this.irE.getContext()));
        this.irE.setFadingEdgeLength(0);
        this.irE.setOverScrollMode(2);
        this.irE.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        this.fTv = new PbListView(this.iJn.getPageContext().getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.iJn.getActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.irE.setOnSrollToBottomListener(this.iJn);
        this.dPx = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.iJq = new b(this.iJn, this.irE);
        kG(false);
        this.iJn.registerListener(this.iJx);
    }

    private void b(ad adVar) {
        if (this.iJr == null) {
            this.iJr = new BannerView(this.iJn.getPageContext().getPageActivity());
            this.iJr.setLayoutParams(new AbsListView.LayoutParams(-1, this.iJn.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.iJr.setVisibility(8);
            this.iJr.setBannerViewClickListener(this.iJw);
            this.iJr.setBannerData(adVar);
            this.iJr.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.iJr.btl() && !a.this.iJt && a.this.irE != null) {
                        a.this.iJt = true;
                        a.this.irE.addHeaderView(a.this.iJr, 1);
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
    public void cxY() {
        if (this.eTS != null) {
            String value = this.eTS.getValue();
            if (this.eTS.bgt() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.iJn.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.eTS.bgt() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.iJn.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.iJn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eTS.bgt() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ezT != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ezT) {
                        case FRS:
                            this.iJn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iJn.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.iJn.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.iJn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bmY().b(this.iJn.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iJn.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.eTS.bgt() == 4) {
                this.iJn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.iJn.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.iJq != null) {
            this.iJq.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.irE.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.iJq.a(abVar);
    }

    public void onDestroy() {
        this.iJq.onDestory();
        this.irE.setOnSrollToBottomListener(null);
        a(this.iJo);
        a(this.iJp);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void kG(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 301;
            vVar.fzJ = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cvq() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fzJ = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bPU() {
        this.irE.setVisibility(0);
    }

    public void ctP() {
        if (this.iJq != null) {
            this.iJq.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<aj> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.iJn.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (aj ajVar : good_classify) {
                if (ajVar != null && ajVar.bgw() > 0 && !TextUtils.isEmpty(ajVar.bgv()) && !TextUtils.isEmpty(ajVar.bgv().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = ajVar.bgw();
                    dVar2.name = ajVar.bgv();
                    tabData.add(dVar2);
                }
            }
            if (y.getCount(tabData) > 1) {
                cyc();
                this.iJu = true;
                a(tabData, this.iJo);
                a(tabData, this.iJp);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.iJn.getContext());
                    c cVar = new c();
                    cVar.pP(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.ds16, this.ds32, this.ds16, this.ds32);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(at.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.iJv) {
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
        this.iJq.b(arrayList, frsViewData);
        this.iJu = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.irE;
    }

    public void cxZ() {
        this.iJq.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.irE.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.iJt && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.eTS = forumData.getFrsBannerData();
            b(this.eTS);
            this.iJr.reset();
            this.irE.removeHeaderView(this.iJr);
            if (this.eTS.getType() == 1 && !TextUtils.isEmpty(this.eTS.bgu())) {
                this.iJr.setData(this.iJn.getPageContext(), this.eTS.bgu());
                if (this.eTS.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.iJn.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cya() {
        if (this.iJr != null) {
            this.iJt = false;
            this.irE.removeHeaderView(this.iJr);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iJq != null) {
            this.iJq.cwx();
            this.iJq.notifyDataSetChanged();
            this.iJq.onChangeSkinType(i);
        }
        this.iJn.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iJn.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.iJr != null) {
            this.iJr.btm();
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(i);
        }
        b(this.iJo);
        b(this.iJp);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fzJ = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void bKf() {
        v vVar = new v();
        vVar.tabId = 301;
        vVar.fzJ = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public b cyb() {
        return this.iJq;
    }

    public RelativeLayout cew() {
        return this.mContainer;
    }

    public void pp(boolean z) {
        com.baidu.tieba.frs.ad adVar = new com.baidu.tieba.frs.ad();
        adVar.tabId = 301;
        adVar.eGO = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    public void cue() {
        if (m.byc().byd()) {
            int lastVisiblePosition = this.irE.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.irE.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isB != null) {
                        h perfLog = uVar.isB.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fgL = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.isB.getLocationOnScreen(iArr);
                            if (iArr[1] > l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.isB.startLogPerf();
                    }
                    if (uVar.isA != null && (uVar.isA instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.isA;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fgL = true;
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
    public void SI() {
        this.irE.setNextPage(this.fTv);
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.setOnClickListener(null);
        this.fTv.startLoadData();
    }

    public void cuf() {
        this.irE.setNextPage(this.fTv);
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.setOnClickListener(this.iyd);
        this.fTv.endLoadData();
        this.fTv.setText(this.iJn.getResources().getString(R.string.list_click_load_more));
    }

    public void SJ() {
        this.irE.setNextPage(this.fTv);
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.setOnClickListener(null);
        this.fTv.endLoadData();
        this.fTv.setText(this.iJn.getResources().getString(R.string.list_has_no_more));
    }

    public void bKU() {
        this.irE.setNextPage(null);
    }

    public void pq(boolean z) {
        this.dPx.setVisibility(z ? 0 : 8);
        pI(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.iyS.iNm = intValue;
                if (!this.iJu) {
                    this.iJv = intValue;
                    a(intValue, this.iJp, false);
                    this.iJn.zo(this.iJv);
                    com.baidu.tieba.card.s.ciJ().nX(false);
                    com.baidu.tieba.s.c.dDn().b(this.iJn.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bKf();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.iJu && (tab.getTag() instanceof Integer)) {
                this.iJv = ((Integer) tab.getTag()).intValue();
                this.iJn.zo(this.iJv);
            }
            setTabColorSelected(tab);
        }
    }

    private void cyc() {
        if (this.iJo == null) {
            this.iJo = (TabLayout) LayoutInflater.from(this.iJn.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.iJo.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.iJn.getContext(), R.dimen.tbds126)));
            this.iJo.setOnTabSelectedListener(this);
            b(this.iJo);
            this.irE.addHeaderView(this.iJo);
        }
    }

    private void cy(View view) {
        this.iJp = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.iJp.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.iJo, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bKf();
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

    private void pI(boolean z) {
        if (z) {
            this.iJp.setVisibility(8);
        } else if (this.iJp.getTabCount() > 1) {
            this.iJp.setVisibility(0);
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
                            cVar.pP(R.color.cp_cont_c);
                        } else if (at.isEmpty(this.iJs)) {
                            cVar.pP(R.color.cp_cont_b);
                        } else {
                            cVar.pQ(com.baidu.tieba.lego.card.d.b.fv(this.iJs));
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
                this.iJs = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (at.isEmpty(this.iJs)) {
                cVar.pP(R.color.cp_cont_b);
            } else {
                cVar.pQ(com.baidu.tieba.lego.card.d.b.fv(this.iJs));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).pP(R.color.cp_cont_c);
        }
    }

    public void FS() {
        if (cyb() != null) {
            List<q> dataList = cyb().getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.epi != 0 && bvVar.eji != null) {
                            int[] imageWidthAndHeight = bvVar.eji.getImageWidthAndHeight();
                            bvVar.epi = imageWidthAndHeight[0];
                            bvVar.epj = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cyb().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void JY(String str) {
        if (this.iJn.cxV() != null) {
            this.iJn.cxV().Ka(str);
        }
    }

    public void JZ(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.iJq.getDataList())) {
            Iterator<q> it = this.iJq.cyj().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bDk() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bDk()).ekv)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
