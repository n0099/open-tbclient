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
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.u;
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
    private int M_W_X006;
    private FrameLayout eje;
    private ae foN;
    private PbListView gre;
    private FrsGoodFragment jpV;
    private TabLayout jpW;
    private TabLayout jpX;
    private b jpY;
    public String jqa;
    private final int jqe;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView iVD = null;
    private BannerView jpZ = null;
    private boolean jqb = false;
    private boolean jqc = false;
    private int jqd = 0;
    private View.OnClickListener jcb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jpV != null) {
                a.this.jpV.onScrollToBottom();
            }
        }
    };
    private BannerView.a jqf = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bAv() {
            a.this.cIx();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bAw() {
            a.this.cIz();
        }
    };
    private CustomMessageListener jqg = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Lx(str);
                a.this.Lw(str);
                a.this.jpY.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.jpV = null;
        this.jpV = frsGoodFragment;
        n(view, z);
        this.jqe = l.getDimens(this.jpV.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.M_W_X006 = l.getDimens(this.jpV.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    private void n(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        cS(view);
        this.iVD = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.iVD.setLayoutManager(new LinearLayoutManager(this.iVD.getContext()));
        this.iVD.setFadingEdgeLength(0);
        this.iVD.setOverScrollMode(2);
        this.iVD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        if (!d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.iVD.setPadding(dimenPixelSize, this.iVD.getPaddingTop(), dimenPixelSize, this.iVD.getPaddingBottom());
        }
        this.gre = new PbListView(this.jpV.getPageContext().getPageActivity());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.transparent);
        this.gre.setHeight(l.getDimens(this.jpV.getActivity(), R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iVD.setOnSrollToBottomListener(this.jpV);
        this.eje = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jpY = new b(this.jpV, this.iVD);
        lx(false);
        this.jpV.registerListener(this.jqg);
    }

    private void b(ae aeVar) {
        if (this.jpZ == null) {
            this.jpZ = new BannerView(this.jpV.getPageContext().getPageActivity());
            this.jpZ.setLayoutParams(new AbsListView.LayoutParams(-1, this.jpV.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jpZ.setVisibility(8);
            this.jpZ.setBannerViewClickListener(this.jqf);
            this.jpZ.setBannerData(aeVar);
            this.jpZ.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z && a.this.jpZ.bAt() && !a.this.jqb && a.this.iVD != null) {
                        a.this.jqb = true;
                        a.this.iVD.addHeaderView(a.this.jpZ, 1);
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
    public void cIx() {
        if (this.foN != null) {
            String value = this.foN.getValue();
            if (this.foN.bnb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jpV.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.foN.bnb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jpV.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jpV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.foN.bnb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eUu != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eUu) {
                        case FRS:
                            this.jpV.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jpV.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jpV.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jpV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bua().b(this.jpV.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jpV.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.foN.bnb() == 4) {
                this.jpV.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jpV.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.jpY != null) {
            this.jpY.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iVD.setOnScrollListener(onScrollListener);
    }

    public void a(ab abVar) {
        this.jpY.a(abVar);
    }

    public void onDestroy() {
        this.jpY.onDestory();
        this.iVD.setOnSrollToBottomListener(null);
        a(this.jpW);
        a(this.jpX);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void lx(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 301;
            uVar.fVi = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void cER() {
        u uVar = new u();
        uVar.tabId = 301;
        uVar.fVi = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void bYs() {
        this.iVD.setVisibility(0);
    }

    public void cDr() {
        if (this.jpY != null) {
            this.jpY.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ak> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
            dVar.tabId = 0;
            dVar.name = this.jpV.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ak akVar : good_classify) {
                if (akVar != null && akVar.bne() > 0 && !TextUtils.isEmpty(akVar.bnd()) && !TextUtils.isEmpty(akVar.bnd().trim())) {
                    com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                    dVar2.tabId = akVar.bne();
                    dVar2.name = akVar.bnd();
                    tabData.add(dVar2);
                }
            }
            if (y.getCount(tabData) > 1) {
                cIB();
                this.jqc = true;
                a(tabData, this.jpW);
                a(tabData, this.jpX);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.jpV.getContext());
                    c cVar = new c();
                    cVar.rj(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.jqe);
                    layoutParams.setMargins(this.M_W_X006 / 2, 0, this.M_W_X006 / 2, 0);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(au.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.jqd) {
                    tab.select();
                }
            }
        }
    }

    public void a(ArrayList<q> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            s sVar = new s();
            arrayList = new ArrayList<>();
            arrayList.add(sVar);
        }
        this.jpY.b(arrayList, frsViewData);
        this.jqc = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.iVD;
    }

    public void cIy() {
        this.jpY.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.iVD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.jqb && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.foN = forumData.getFrsBannerData();
            b(this.foN);
            this.jpZ.reset();
            this.iVD.removeHeaderView(this.jpZ);
            if (this.foN.getType() == 1 && !TextUtils.isEmpty(this.foN.bnc())) {
                this.jpZ.setData(this.jpV.getPageContext(), this.foN.bnc());
                if (this.foN.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jpV.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cIz() {
        if (this.jpZ != null) {
            this.jqb = false;
            this.iVD.removeHeaderView(this.jpZ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jpY != null) {
            this.jpY.cGb();
            this.jpY.notifyDataSetChanged();
            this.jpY.onChangeSkinType(i);
        }
        this.jpV.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jpV.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.jpZ != null) {
            this.jpZ.bAu();
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.changeSkin(i);
        }
        b(this.jpW);
        b(this.jpX);
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 301;
        uVar.fVi = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void bSl() {
        u uVar = new u();
        uVar.tabId = 301;
        uVar.fVi = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public b cIA() {
        return this.jpY;
    }

    public RelativeLayout cnn() {
        return this.mContainer;
    }

    public void qq(boolean z) {
        ac acVar = new ac();
        acVar.tabId = 301;
        acVar.fbE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, acVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XZ() {
        this.iVD.setNextPage(this.gre);
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.setOnClickListener(null);
        this.gre.startLoadData();
    }

    public void cDG() {
        this.iVD.setNextPage(this.gre);
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.setOnClickListener(this.jcb);
        this.gre.endLoadData();
        this.gre.setText(this.jpV.getResources().getString(R.string.list_click_load_more));
    }

    public void Ya() {
        this.iVD.setNextPage(this.gre);
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.setOnClickListener(null);
        this.gre.endLoadData();
        this.gre.setText(this.jpV.getResources().getString(R.string.list_has_no_more));
    }

    public void bTa() {
        this.iVD.setNextPage(null);
    }

    public void qr(boolean z) {
        this.eje.setVisibility(z ? 0 : 8);
        qN(z);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.d.jcS.jtT = intValue;
                if (!this.jqc) {
                    this.jqd = intValue;
                    a(intValue, this.jpX, false);
                    this.jpV.Bg(this.jqd);
                    t.csg().oX(false);
                    com.baidu.tieba.t.c.dOe().b(this.jpV.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bSl();
        setTabColorUnSelected(tab);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.jqc && (tab.getTag() instanceof Integer)) {
                this.jqd = ((Integer) tab.getTag()).intValue();
                this.jpV.Bg(this.jqd);
            }
            setTabColorSelected(tab);
        }
    }

    private void cIB() {
        if (this.jpW == null) {
            this.jpW = (TabLayout) LayoutInflater.from(this.jpV.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            if (d.bkA()) {
                this.jpW.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) - (this.M_W_X006 / 2), 0);
            } else {
                this.jpW.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
            }
            this.jpW.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.jpV.getContext(), R.dimen.tbds126)));
            this.jpW.setOnTabSelectedListener(this);
            b(this.jpW);
            this.iVD.addHeaderView(this.jpW);
        }
    }

    private void cS(View view) {
        this.jpX = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        if (d.bkA()) {
            this.jpX.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) - (this.M_W_X006 / 2), 0);
        } else {
            this.jpX.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
        }
        this.jpX.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.jpW, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bSl();
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

    private void qN(boolean z) {
        if (z) {
            this.jpX.setVisibility(8);
        } else if (this.jpX.getTabCount() > 1) {
            this.jpX.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            if (d.bkA()) {
                ap.setBackgroundColor(tabLayout, R.color.CAM_X0205);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        c cVar = (c) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                        if (!tabAt.isSelected()) {
                            cVar.rj(R.color.CAM_X0108);
                        } else if (au.isEmpty(this.jqa)) {
                            cVar.rj(R.color.CAM_X0105);
                        } else {
                            cVar.rk(com.baidu.tieba.lego.card.d.b.sI(this.jqa));
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
            if (!au.isEmpty(themeElement.font_color)) {
                this.jqa = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (au.isEmpty(this.jqa)) {
                cVar.rj(R.color.CAM_X0105);
            } else {
                cVar.rk(com.baidu.tieba.lego.card.d.b.sI(this.jqa));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).rj(R.color.CAM_X0108);
        }
    }

    public void HO() {
        if (cIA() != null) {
            List<q> dataList = cIA().getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof bx) {
                        bx bxVar = (bx) qVar;
                        if (bxVar.eIP != 0 && bxVar.eCR != null) {
                            int[] imageWidthAndHeight = bxVar.eCR.getImageWidthAndHeight();
                            bxVar.eIP = imageWidthAndHeight[0];
                            bxVar.eIQ = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cIA().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Lw(String str) {
        if (this.jpV.cIu() != null) {
            this.jpV.cIu().Ly(str);
        }
    }

    public void Lx(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jpY.getDataList())) {
            Iterator<q> it = this.jpY.cII().iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bKv() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bKv()).eEd)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
