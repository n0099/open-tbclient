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
    private PbListView gAi;
    private final int jDC;
    private FrsGoodFragment jDu;
    private TabLayout jDv;
    private TabLayout jDw;
    private b jDx;
    public String jDz;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView jiR = null;
    private BannerView jDy = null;
    private boolean isAddBanner = false;
    private boolean jDA = false;
    private int jDB = 0;
    private View.OnClickListener jpu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jDu != null) {
                a.this.jDu.onScrollToBottom();
            }
        }
    };
    private BannerView.a jDD = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzo() {
            a.this.cIU();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzp() {
            a.this.cIW();
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.KX(str);
                a.this.KW(str);
                a.this.jDx.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.jDu = null;
        this.jDu = frsGoodFragment;
        m(view, z);
        this.jDC = l.getDimens(this.jDu.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.M_W_X006 = l.getDimens(this.jDu.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    private void m(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        da(view);
        this.jiR = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.jiR.setLayoutManager(new LinearLayoutManager(this.jiR.getContext()));
        this.jiR.setFadingEdgeLength(0);
        this.jiR.setOverScrollMode(2);
        this.jiR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        this.jiR.setPadding(dimenPixelSize, this.jiR.getPaddingTop(), dimenPixelSize, this.jiR.getPaddingBottom());
        this.gAi = new PbListView(this.jDu.getPageContext().getPageActivity());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.transparent);
        this.gAi.setHeight(l.getDimens(this.jDu.getActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jiR.setOnSrollToBottomListener(this.jDu);
        this.epC = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jDx = new b(this.jDu, this.jiR);
        lU(false);
        this.jDu.registerListener(this.jpm);
    }

    private void b(af afVar) {
        if (this.jDy == null) {
            this.jDy = new BannerView(this.jDu.getPageContext().getPageActivity());
            this.jDy.setLayoutParams(new AbsListView.LayoutParams(-1, this.jDu.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jDy.setVisibility(8);
            this.jDy.setBannerViewClickListener(this.jDD);
            this.jDy.setBannerData(afVar);
            this.jDy.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z && a.this.jDy.bzm() && !a.this.isAddBanner && a.this.jiR != null) {
                        a.this.isAddBanner = true;
                        a.this.jiR.addHeaderView(a.this.jDy, 1);
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
    public void cIU() {
        if (this.fwe != null) {
            String value = this.fwe.getValue();
            if (this.fwe.blZ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jDu.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fwe.blZ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jDu.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jDu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
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
                            this.jDu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jDu.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jDu.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jDu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bsV().b(this.jDu.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jDu.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fwe.blZ() == 4) {
                this.jDu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jDu.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.jDx != null) {
            this.jDx.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jiR.setOnScrollListener(onScrollListener);
    }

    public void a(w wVar) {
        this.jDx.a(wVar);
    }

    public void onDestroy() {
        this.jDx.onDestory();
        this.jiR.setOnSrollToBottomListener(null);
        a(this.jDv);
        a(this.jDw);
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
            tVar.gcx = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cFi() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.gcx = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bYh() {
        this.jiR.setVisibility(0);
    }

    public void cDH() {
        if (this.jDx != null) {
            this.jDx.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<al> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.jDu.getPageContext().getResources().getString(R.string.all);
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
                cIY();
                this.jDA = true;
                a(tabData, this.jDv);
                a(tabData, this.jDw);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.jDu.getContext());
                    c cVar = new c();
                    cVar.pT(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.jDC);
                    layoutParams.setMargins(this.M_W_X006 / 2, 0, this.M_W_X006 / 2, 0);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(au.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.jDB) {
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
        this.jDx.b(arrayList, frsViewData);
        this.jDA = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.jiR;
    }

    public void cIV() {
        this.jDx.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.jiR.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.isAddBanner && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fwe = forumData.getFrsBannerData();
            b(this.fwe);
            this.jDy.reset();
            this.jiR.removeHeaderView(this.jDy);
            if (this.fwe.getType() == 1 && !TextUtils.isEmpty(this.fwe.bma())) {
                this.jDy.setData(this.jDu.getPageContext(), this.fwe.bma());
                if (this.fwe.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jDu.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cIW() {
        if (this.jDy != null) {
            this.isAddBanner = false;
            this.jiR.removeHeaderView(this.jDy);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jDx != null) {
            this.jDx.cGx();
            this.jDx.notifyDataSetChanged();
            this.jDx.onChangeSkinType(i);
        }
        if (this.jDu != null && this.jDu.getBaseFragmentActivity() == null && this.jDu.getBaseFragmentActivity().getLayoutMode() != null) {
            this.jDu.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.jDu.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        }
        if (this.jDy != null) {
            this.jDy.bzn();
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(i);
        }
        b(this.jDv);
        b(this.jDw);
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.gcx = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bRB() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.gcx = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public b cIX() {
        return this.jDx;
    }

    public RelativeLayout cnn() {
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
        this.jiR.setNextPage(this.gAi);
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.setOnClickListener(null);
        this.gAi.startLoadData();
    }

    public void cDW() {
        this.jiR.setNextPage(this.gAi);
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.setOnClickListener(this.jpu);
        this.gAi.endLoadData();
        this.gAi.setText(this.jDu.getResources().getString(R.string.list_click_load_more));
    }

    public void WY() {
        this.jiR.setNextPage(this.gAi);
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.setOnClickListener(null);
        this.gAi.endLoadData();
        this.gAi.setText(this.jDu.getResources().getString(R.string.list_has_no_more));
    }

    public void bSr() {
        this.jiR.setNextPage(null);
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
                com.baidu.tieba.frs.b.d.jqq.jHo = intValue;
                if (!this.jDA) {
                    this.jDB = intValue;
                    a(intValue, this.jDw, false);
                    this.jDu.zW(this.jDB);
                    com.baidu.tieba.card.t.csu().pB(false);
                    com.baidu.tieba.s.c.dMr().b(this.jDu.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bRB();
        setTabColorUnSelected(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.jDA && (tab.getTag() instanceof Integer)) {
                this.jDB = ((Integer) tab.getTag()).intValue();
                this.jDu.zW(this.jDB);
            }
            setTabColorSelected(tab);
        }
    }

    private void cIY() {
        if (this.jDv == null) {
            this.jDv = (TabLayout) LayoutInflater.from(this.jDu.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.jDv.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
            this.jDv.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.jDu.getContext(), R.dimen.tbds126)));
            this.jDv.setOnTabSelectedListener(this);
            b(this.jDv);
            this.jiR.addHeaderView(this.jDv);
        }
    }

    private void da(View view) {
        this.jDw = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.jDw.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
        this.jDw.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.jDv, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bRB();
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
            this.jDw.setVisibility(8);
        } else if (this.jDw.getTabCount() > 1) {
            this.jDw.setVisibility(0);
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
                        } else if (au.isEmpty(this.jDz)) {
                            cVar.pT(R.color.CAM_X0105);
                        } else {
                            cVar.pU(com.baidu.tieba.lego.card.c.b.rM(this.jDz));
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
                this.jDz = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (au.isEmpty(this.jDz)) {
                cVar.pT(R.color.CAM_X0105);
            } else {
                cVar.pU(com.baidu.tieba.lego.card.c.b.rM(this.jDz));
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
        if (cIX() != null) {
            List<n> dataList = cIX().getDataList();
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
                        a.this.cIX().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void KW(String str) {
        if (this.jDu.cIR() != null) {
            this.jDu.cIR().KY(str);
        }
    }

    public void KX(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jDx.getDataList())) {
            Iterator<n> it = this.jDx.cJf().iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bJq() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bJq()).eLu)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
