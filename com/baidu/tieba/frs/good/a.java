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
    private FrameLayout erd;
    private af fxD;
    private PbListView gCf;
    private FrsGoodFragment jFr;
    private TabLayout jFs;
    private TabLayout jFt;
    private b jFu;
    public String jFw;
    private final int jFz;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView jkO = null;
    private BannerView jFv = null;
    private boolean isAddBanner = false;
    private boolean jFx = false;
    private int jFy = 0;
    private View.OnClickListener jrr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jFr != null) {
                a.this.jFr.onScrollToBottom();
            }
        }
    };
    private BannerView.a jFA = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzr() {
            a.this.cJh();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzs() {
            a.this.cJj();
        }
    };
    private CustomMessageListener jrj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Lh(str);
                a.this.Lg(str);
                a.this.jFu.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.jFr = null;
        this.jFr = frsGoodFragment;
        m(view, z);
        this.jFz = l.getDimens(this.jFr.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.M_W_X006 = l.getDimens(this.jFr.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    private void m(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        da(view);
        this.jkO = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.jkO.setLayoutManager(new LinearLayoutManager(this.jkO.getContext()));
        this.jkO.setFadingEdgeLength(0);
        this.jkO.setOverScrollMode(2);
        this.jkO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        this.jkO.setPadding(dimenPixelSize, this.jkO.getPaddingTop(), dimenPixelSize, this.jkO.getPaddingBottom());
        this.gCf = new PbListView(this.jFr.getPageContext().getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.jFr.getActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jkO.setOnSrollToBottomListener(this.jFr);
        this.erd = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jFu = new b(this.jFr, this.jkO);
        lU(false);
        this.jFr.registerListener(this.jrj);
    }

    private void b(af afVar) {
        if (this.jFv == null) {
            this.jFv = new BannerView(this.jFr.getPageContext().getPageActivity());
            this.jFv.setLayoutParams(new AbsListView.LayoutParams(-1, this.jFr.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jFv.setVisibility(8);
            this.jFv.setBannerViewClickListener(this.jFA);
            this.jFv.setBannerData(afVar);
            this.jFv.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z && a.this.jFv.bzp() && !a.this.isAddBanner && a.this.jkO != null) {
                        a.this.isAddBanner = true;
                        a.this.jkO.addHeaderView(a.this.jFv, 1);
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
    public void cJh() {
        if (this.fxD != null) {
            String value = this.fxD.getValue();
            if (this.fxD.bmb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jFr.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fxD.bmb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jFr.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jFr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fxD.bmb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.fcX != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.fcX) {
                        case FRS:
                            this.jFr.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jFr.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jFr.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jFr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                bf.bsY().b(this.jFr.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jFr.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fxD.bmb() == 4) {
                this.jFr.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jFr.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.jFu != null) {
            this.jFu.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jkO.setOnScrollListener(onScrollListener);
    }

    public void a(w wVar) {
        this.jFu.a(wVar);
    }

    public void onDestroy() {
        this.jFu.onDestory();
        this.jkO.setOnSrollToBottomListener(null);
        a(this.jFs);
        a(this.jFt);
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
            tVar.gec = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cFv() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.gec = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bYu() {
        this.jkO.setVisibility(0);
    }

    public void cDU() {
        if (this.jFu != null) {
            this.jFu.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<al> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.jFr.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (al alVar : good_classify) {
                if (alVar != null && alVar.bme() > 0 && !TextUtils.isEmpty(alVar.bmd()) && !TextUtils.isEmpty(alVar.bmd().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = alVar.bme();
                    dVar2.name = alVar.bmd();
                    tabData.add(dVar2);
                }
            }
            if (y.getCount(tabData) > 1) {
                cJl();
                this.jFx = true;
                a(tabData, this.jFs);
                a(tabData, this.jFt);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.jFr.getContext());
                    c cVar = new c();
                    cVar.pU(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.jFz);
                    layoutParams.setMargins(this.M_W_X006 / 2, 0, this.M_W_X006 / 2, 0);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(au.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.jFy) {
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
        this.jFu.b(arrayList, frsViewData);
        this.jFx = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.jkO;
    }

    public void cJi() {
        this.jFu.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.jkO.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.isAddBanner && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fxD = forumData.getFrsBannerData();
            b(this.fxD);
            this.jFv.reset();
            this.jkO.removeHeaderView(this.jFv);
            if (this.fxD.getType() == 1 && !TextUtils.isEmpty(this.fxD.bmc())) {
                this.jFv.setData(this.jFr.getPageContext(), this.fxD.bmc());
                if (this.fxD.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jFr.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cJj() {
        if (this.jFv != null) {
            this.isAddBanner = false;
            this.jkO.removeHeaderView(this.jFv);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jFu != null) {
            this.jFu.cGK();
            this.jFu.notifyDataSetChanged();
            this.jFu.onChangeSkinType(i);
        }
        if (this.jFr != null && this.jFr.getBaseFragmentActivity() == null && this.jFr.getBaseFragmentActivity().getLayoutMode() != null) {
            this.jFr.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.jFr.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        }
        if (this.jFv != null) {
            this.jFv.bzq();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        b(this.jFs);
        b(this.jFt);
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.gec = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bRO() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.gec = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public b cJk() {
        return this.jFu;
    }

    public RelativeLayout cnA() {
        return this.mContainer;
    }

    public void qU(boolean z) {
        z zVar = new z();
        zVar.tabId = 301;
        zVar.fku = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xa() {
        this.jkO.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setOnClickListener(null);
        this.gCf.startLoadData();
    }

    public void cEj() {
        this.jkO.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setOnClickListener(this.jrr);
        this.gCf.endLoadData();
        this.gCf.setText(this.jFr.getResources().getString(R.string.list_click_load_more));
    }

    public void Xb() {
        this.jkO.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setOnClickListener(null);
        this.gCf.endLoadData();
        this.gCf.setText(this.jFr.getResources().getString(R.string.list_has_no_more));
    }

    public void bSE() {
        this.jkO.setNextPage(null);
    }

    public void qV(boolean z) {
        this.erd.setVisibility(z ? 0 : 8);
        rr(z);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.b.d.jsn.jJl = intValue;
                if (!this.jFx) {
                    this.jFy = intValue;
                    a(intValue, this.jFt, false);
                    this.jFr.zX(this.jFy);
                    com.baidu.tieba.card.t.csH().pB(false);
                    com.baidu.tieba.s.c.dMH().b(this.jFr.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bRO();
        setTabColorUnSelected(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.jFx && (tab.getTag() instanceof Integer)) {
                this.jFy = ((Integer) tab.getTag()).intValue();
                this.jFr.zX(this.jFy);
            }
            setTabColorSelected(tab);
        }
    }

    private void cJl() {
        if (this.jFs == null) {
            this.jFs = (TabLayout) LayoutInflater.from(this.jFr.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.jFs.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
            this.jFs.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.jFr.getContext(), R.dimen.tbds126)));
            this.jFs.setOnTabSelectedListener(this);
            b(this.jFs);
            this.jkO.addHeaderView(this.jFs);
        }
    }

    private void da(View view) {
        this.jFt = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.jFt.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
        this.jFt.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.jFs, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bRO();
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
            this.jFt.setVisibility(8);
        } else if (this.jFt.getTabCount() > 1) {
            this.jFt.setVisibility(0);
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
                            cVar.pU(R.color.CAM_X0108);
                        } else if (au.isEmpty(this.jFw)) {
                            cVar.pU(R.color.CAM_X0105);
                        } else {
                            cVar.pV(com.baidu.tieba.lego.card.c.b.rT(this.jFw));
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
                this.jFw = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (au.isEmpty(this.jFw)) {
                cVar.pU(R.color.CAM_X0105);
            } else {
                cVar.pV(com.baidu.tieba.lego.card.c.b.rT(this.jFw));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).pU(R.color.CAM_X0108);
        }
    }

    public void EN() {
        if (cJk() != null) {
            List<n> dataList = cJk().getDataList();
            if (!y.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof ca) {
                        ca caVar = (ca) nVar;
                        if (caVar.eRK != 0 && caVar.eLr != null) {
                            int[] imageWidthAndHeight = caVar.eLr.getImageWidthAndHeight();
                            caVar.eRK = imageWidthAndHeight[0];
                            caVar.eRL = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cJk().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Lg(String str) {
        if (this.jFr.cJe() != null) {
            this.jFr.cJe().Li(str);
        }
    }

    public void Lh(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.jFu.getDataList())) {
            Iterator<n> it = this.jFu.cJs().iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bJz() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bJz()).eMU)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
