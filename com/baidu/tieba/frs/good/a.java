package com.baidu.tieba.frs.good;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.ca;
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
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.d;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes2.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private int M_W_X006;
    private FrameLayout epC;
    private af fwe;
    private PbListView gAw;
    private FrsGoodFragment jDI;
    private TabLayout jDJ;
    private TabLayout jDK;
    private b jDL;
    public String jDN;
    private final int jDQ;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView jjf = null;
    private BannerView jDM = null;
    private boolean isAddBanner = false;
    private boolean jDO = false;
    private int jDP = 0;
    private View.OnClickListener jpI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jDI != null) {
                a.this.jDI.onScrollToBottom();
            }
        }
    };
    private BannerView.a jDR = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzo() {
            a.this.cJb();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzp() {
            a.this.cJd();
        }
    };
    private CustomMessageListener jpA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.KY(str);
                a.this.KX(str);
                a.this.jDL.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.jDI = null;
        this.jDI = frsGoodFragment;
        m(view, z);
        this.jDQ = l.getDimens(this.jDI.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.M_W_X006 = l.getDimens(this.jDI.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    private void m(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        da(view);
        this.jjf = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.jjf.setLayoutManager(new LinearLayoutManager(this.jjf.getContext()));
        this.jjf.setFadingEdgeLength(0);
        this.jjf.setOverScrollMode(2);
        this.jjf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
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
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jjf.setPadding(dimenPixelSize, this.jjf.getPaddingTop(), dimenPixelSize, this.jjf.getPaddingBottom());
        this.gAw = new PbListView(this.jDI.getPageContext().getPageActivity());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setHeight(l.getDimens(this.jDI.getActivity(), R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jjf.setOnSrollToBottomListener(this.jDI);
        this.epC = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jDL = new b(this.jDI, this.jjf);
        lU(false);
        this.jDI.registerListener(this.jpA);
    }

    private void b(af afVar) {
        if (this.jDM == null) {
            this.jDM = new BannerView(this.jDI.getPageContext().getPageActivity());
            this.jDM.setLayoutParams(new AbsListView.LayoutParams(-1, this.jDI.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jDM.setVisibility(8);
            this.jDM.setBannerViewClickListener(this.jDR);
            this.jDM.setBannerData(afVar);
            this.jDM.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z && a.this.jDM.bzm() && !a.this.isAddBanner && a.this.jjf != null) {
                        a.this.isAddBanner = true;
                        a.this.jjf.addHeaderView(a.this.jDM, 1);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cJb() {
        if (this.fwe != null) {
            String value = this.fwe.getValue();
            if (this.fwe.blZ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jDI.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fwe.blZ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jDI.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jDI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fwe.blZ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.fbx != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.fbx) {
                        case FRS:
                            this.jDI.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jDI.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jDI.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jDI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bsV().b(this.jDI.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jDI.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fwe.blZ() == 4) {
                this.jDI.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jDI.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.jDL != null) {
            this.jDL.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jjf.setOnScrollListener(onScrollListener);
    }

    public void a(w wVar) {
        this.jDL.a(wVar);
    }

    public void onDestroy() {
        this.jDL.onDestory();
        this.jjf.setOnSrollToBottomListener(null);
        a(this.jDJ);
        a(this.jDK);
    }

    private void a(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void lU(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 301;
            tVar.gcC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cFp() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.gcC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bYo() {
        this.jjf.setVisibility(0);
    }

    public void cDO() {
        if (this.jDL != null) {
            this.jDL.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<al> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.jDI.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (al alVar : good_classify) {
                if (alVar != null && alVar.bmc() > 0 && !TextUtils.isEmpty(alVar.bmb()) && !TextUtils.isEmpty(alVar.bmb().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = alVar.bmc();
                    dVar2.name = alVar.bmb();
                    tabData.add(dVar2);
                }
            }
            if (y.getCount(tabData) > 1) {
                cJf();
                this.jDO = true;
                a(tabData, this.jDJ);
                a(tabData, this.jDK);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.jDI.getContext());
                    c cVar = new c();
                    cVar.pT(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.jDQ);
                    layoutParams.setMargins(this.M_W_X006 / 2, 0, this.M_W_X006 / 2, 0);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(au.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.jDP) {
                    tab.select();
                }
            }
        }
    }

    public void a(ArrayList<n> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            s sVar = new s();
            arrayList = new ArrayList<>();
            arrayList.add(sVar);
        }
        this.jDL.b(arrayList, frsViewData);
        this.jDO = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.jjf;
    }

    public void cJc() {
        this.jDL.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.jjf.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.isAddBanner && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fwe = forumData.getFrsBannerData();
            b(this.fwe);
            this.jDM.reset();
            this.jjf.removeHeaderView(this.jDM);
            if (this.fwe.getType() == 1 && !TextUtils.isEmpty(this.fwe.bma())) {
                this.jDM.setData(this.jDI.getPageContext(), this.fwe.bma());
                if (this.fwe.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jDI.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cJd() {
        if (this.jDM != null) {
            this.isAddBanner = false;
            this.jjf.removeHeaderView(this.jDM);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jDL != null) {
            this.jDL.cGE();
            this.jDL.notifyDataSetChanged();
            this.jDL.onChangeSkinType(i);
        }
        if (this.jDI != null && this.jDI.getBaseFragmentActivity() == null && this.jDI.getBaseFragmentActivity().getLayoutMode() != null) {
            this.jDI.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.jDI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        }
        if (this.jDM != null) {
            this.jDM.bzn();
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        b(this.jDJ);
        b(this.jDK);
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.gcC = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bRI() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.gcC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public b cJe() {
        return this.jDL;
    }

    public RelativeLayout cnu() {
        return this.mContainer;
    }

    public void qU(boolean z) {
        z zVar = new z();
        zVar.tabId = 301;
        zVar.fiV = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void WX() {
        this.jjf.setNextPage(this.gAw);
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.setOnClickListener(null);
        this.gAw.startLoadData();
    }

    public void cEd() {
        this.jjf.setNextPage(this.gAw);
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.setOnClickListener(this.jpI);
        this.gAw.endLoadData();
        this.gAw.setText(this.jDI.getResources().getString(R.string.list_click_load_more));
    }

    public void WY() {
        this.jjf.setNextPage(this.gAw);
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.setOnClickListener(null);
        this.gAw.endLoadData();
        this.gAw.setText(this.jDI.getResources().getString(R.string.list_has_no_more));
    }

    public void bSy() {
        this.jjf.setNextPage(null);
    }

    public void qV(boolean z) {
        this.epC.setVisibility(z ? 0 : 8);
        rr(z);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.b.d.jqE.jHC = intValue;
                if (!this.jDO) {
                    this.jDP = intValue;
                    a(intValue, this.jDK, false);
                    this.jDI.zW(this.jDP);
                    com.baidu.tieba.card.t.csB().pB(false);
                    com.baidu.tieba.s.c.dMz().b(this.jDI.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bRI();
        setTabColorUnSelected(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.jDO && (tab.getTag() instanceof Integer)) {
                this.jDP = ((Integer) tab.getTag()).intValue();
                this.jDI.zW(this.jDP);
            }
            setTabColorSelected(tab);
        }
    }

    private void cJf() {
        if (this.jDJ == null) {
            this.jDJ = (TabLayout) LayoutInflater.from(this.jDI.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.jDJ.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
            this.jDJ.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.jDI.getContext(), R.dimen.tbds126)));
            this.jDJ.setOnTabSelectedListener(this);
            b(this.jDJ);
            this.jjf.addHeaderView(this.jDJ);
        }
    }

    private void da(View view) {
        this.jDK = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.jDK.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
        this.jDK.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.jDJ, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bRI();
                a.this.setTabColorUnSelected(tab);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
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

    private void rr(boolean z) {
        if (z) {
            this.jDK.setVisibility(8);
        } else if (this.jDK.getTabCount() > 1) {
            this.jDK.setVisibility(0);
        }
    }

    private void b(TabLayout tabLayout) {
        if (tabLayout != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tabLayout.getTabCount()) {
                    TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                    if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                        c cVar = (c) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                        if (!tabAt.isSelected()) {
                            cVar.pT(R.color.CAM_X0108);
                        } else if (au.isEmpty(this.jDN)) {
                            cVar.pT(R.color.CAM_X0105);
                        } else {
                            cVar.pU(com.baidu.tieba.lego.card.c.b.rM(this.jDN));
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
                this.jDN = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (au.isEmpty(this.jDN)) {
                cVar.pT(R.color.CAM_X0105);
            } else {
                cVar.pU(com.baidu.tieba.lego.card.c.b.rM(this.jDN));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).pT(R.color.CAM_X0108);
        }
    }

    public void EK() {
        if (cJe() != null) {
            List<n> dataList = cJe().getDataList();
            if (!y.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof ca) {
                        ca caVar = (ca) nVar;
                        if (caVar.eQj != 0 && caVar.eJQ != null) {
                            int[] imageWidthAndHeight = caVar.eJQ.getImageWidthAndHeight();
                            caVar.eQj = imageWidthAndHeight[0];
                            caVar.eQk = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cJe().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void KX(String str) {
        if (this.jDI.cIY() != null) {
            this.jDI.cIY().KZ(str);
        }
    }

    public void KY(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jDL.getDataList())) {
            Iterator<n> it = this.jDL.cJm().iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bJv() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bJv()).eLt)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
