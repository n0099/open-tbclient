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
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
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
    private FrameLayout esi;
    private ae fyw;
    private PbListView gCf;
    private final int jCD;
    private FrsGoodFragment jCu;
    private TabLayout jCv;
    private TabLayout jCw;
    private b jCx;
    public String jCz;
    private ThemeColorInfo mThemeColorInfo;
    private RelativeLayout mContainer = null;
    private BdTypeRecyclerView jhR = null;
    private BannerView jCy = null;
    private boolean jCA = false;
    private boolean jCB = false;
    private int jCC = 0;
    private View.OnClickListener jou = new View.OnClickListener() { // from class: com.baidu.tieba.frs.good.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jCu != null) {
                a.this.jCu.onScrollToBottom();
            }
        }
    };
    private BannerView.a jCE = new BannerView.a() { // from class: com.baidu.tieba.frs.good.a.4
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bCQ() {
            a.this.cLz();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bCR() {
            a.this.cLB();
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.good.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                a.this.Lw(str);
                a.this.Lv(str);
                a.this.jCx.refreshData();
            }
        }
    };

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.jCu = null;
        this.jCu = frsGoodFragment;
        m(view, z);
        this.jCD = l.getDimens(this.jCu.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.M_W_X006 = l.getDimens(this.jCu.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    private void m(View view, boolean z) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        dc(view);
        this.jhR = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.jhR.setLayoutManager(new LinearLayoutManager(this.jhR.getContext()));
        this.jhR.setFadingEdgeLength(0);
        this.jhR.setOverScrollMode(2);
        this.jhR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.a.2
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
        this.jhR.setPadding(dimenPixelSize, this.jhR.getPaddingTop(), dimenPixelSize, this.jhR.getPaddingBottom());
        this.gCf = new PbListView(this.jCu.getPageContext().getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.jCu.getActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jhR.setOnSrollToBottomListener(this.jCu);
        this.esi = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.jCx = new b(this.jCu, this.jhR);
        lU(false);
        this.jCu.registerListener(this.jom);
    }

    private void b(ae aeVar) {
        if (this.jCy == null) {
            this.jCy = new BannerView(this.jCu.getPageContext().getPageActivity());
            this.jCy.setLayoutParams(new AbsListView.LayoutParams(-1, this.jCu.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.jCy.setVisibility(8);
            this.jCy.setBannerViewClickListener(this.jCE);
            this.jCy.setBannerData(aeVar);
            this.jCy.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.good.a.3
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z && a.this.jCy.bCO() && !a.this.jCA && a.this.jhR != null) {
                        a.this.jCA = true;
                        a.this.jhR.addHeaderView(a.this.jCy, 1);
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
    public void cLz() {
        if (this.fyw != null) {
            String value = this.fyw.getValue();
            if (this.fyw.bpB() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.jCu.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.fyw.bpB() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.jCu.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.jCu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fyw.bpB() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.fdR != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.fdR) {
                        case FRS:
                            this.jCu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jCu.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.jCu.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.jCu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                be.bwv().b(this.jCu.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jCu.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            } else if (this.fyw.bpB() == 4) {
                this.jCu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.jCu.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void refreshView() {
        if (this.jCx != null) {
            this.jCx.notifyDataSetChanged();
        }
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jhR.setOnScrollListener(onScrollListener);
    }

    public void a(w wVar) {
        this.jCx.a(wVar);
    }

    public void onDestroy() {
        this.jCx.onDestory();
        this.jhR.setOnSrollToBottomListener(null);
        a(this.jCv);
        a(this.jCw);
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
            tVar.geO = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cHO() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.geO = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void caZ() {
        this.jhR.setVisibility(0);
    }

    public void cGn() {
        if (this.jCx != null) {
            this.jCx.notifyDataSetChanged();
        }
    }

    public void c(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null && frsViewData.getForum().getGood_classify() != null) {
            ArrayList<ak> good_classify = frsViewData.getForum().getGood_classify();
            TabData tabData = new TabData();
            d dVar = new d();
            dVar.tabId = 0;
            dVar.name = this.jCu.getPageContext().getResources().getString(R.string.all);
            tabData.add(dVar);
            for (ak akVar : good_classify) {
                if (akVar != null && akVar.bpE() > 0 && !TextUtils.isEmpty(akVar.bpD()) && !TextUtils.isEmpty(akVar.bpD().trim())) {
                    d dVar2 = new d();
                    dVar2.tabId = akVar.bpE();
                    dVar2.name = akVar.bpD();
                    tabData.add(dVar2);
                }
            }
            if (x.getCount(tabData) > 1) {
                cLD();
                this.jCB = true;
                a(tabData, this.jCv);
                a(tabData, this.jCw);
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
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.jCu.getContext());
                    c cVar = new c();
                    cVar.ru(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.jCD);
                    layoutParams.setMargins(this.M_W_X006 / 2, 0, this.M_W_X006 / 2, 0);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(at.cutForumNameWithSuffix(tabData.get(i2).name, 10, StringHelper.STRING_MORE));
                tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                if (tabData.get(i2).tabId == this.jCC) {
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
        this.jCx.b(arrayList, frsViewData);
        this.jCB = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.jhR;
    }

    public void cLA() {
        this.jCx.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.jhR.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.jCA && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.fyw = forumData.getFrsBannerData();
            b(this.fyw);
            this.jCy.reset();
            this.jhR.removeHeaderView(this.jCy);
            if (this.fyw.getType() == 1 && !TextUtils.isEmpty(this.fyw.bpC())) {
                this.jCy.setData(this.jCu.getPageContext(), this.fyw.bpC());
                if (this.fyw.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.jCu.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                }
            }
        }
    }

    public void cLB() {
        if (this.jCy != null) {
            this.jCA = false;
            this.jhR.removeHeaderView(this.jCy);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCx != null) {
            this.jCx.cJc();
            this.jCx.notifyDataSetChanged();
            this.jCx.onChangeSkinType(i);
        }
        if (this.jCu != null && this.jCu.getBaseFragmentActivity() == null && this.jCu.getBaseFragmentActivity().getLayoutMode() != null) {
            this.jCu.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.jCu.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        }
        if (this.jCy != null) {
            this.jCy.bCP();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        b(this.jCv);
        b(this.jCw);
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.geO = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void bUP() {
        t tVar = new t();
        tVar.tabId = 301;
        tVar.geO = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public b cLC() {
        return this.jCx;
    }

    public RelativeLayout cqh() {
        return this.mContainer;
    }

    public void qO(boolean z) {
        z zVar = new z();
        zVar.tabId = 301;
        zVar.fln = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zh() {
        this.jhR.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setOnClickListener(null);
        this.gCf.startLoadData();
    }

    public void cGC() {
        this.jhR.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setOnClickListener(this.jou);
        this.gCf.endLoadData();
        this.gCf.setText(this.jCu.getResources().getString(R.string.list_click_load_more));
    }

    public void Zi() {
        this.jhR.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setOnClickListener(null);
        this.gCf.endLoadData();
        this.gCf.setText(this.jCu.getResources().getString(R.string.list_has_no_more));
    }

    public void bVG() {
        this.jhR.setNextPage(null);
    }

    public void qP(boolean z) {
        this.esi.setVisibility(z ? 0 : 8);
        rl(z);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.b.d.jpq.jGq = intValue;
                if (!this.jCB) {
                    this.jCC = intValue;
                    a(intValue, this.jCw, false);
                    this.jCu.Bs(this.jCC);
                    com.baidu.tieba.card.s.cvb().pv(false);
                    com.baidu.tieba.s.c.dNY().b(this.jCu.getUniqueId(), false);
                }
            }
            setTabColorSelected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        bUP();
        setTabColorUnSelected(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.jCB && (tab.getTag() instanceof Integer)) {
                this.jCC = ((Integer) tab.getTag()).intValue();
                this.jCu.Bs(this.jCC);
            }
            setTabColorSelected(tab);
        }
    }

    private void cLD() {
        if (this.jCv == null) {
            this.jCv = (TabLayout) LayoutInflater.from(this.jCu.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.jCv.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
            this.jCv.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(this.jCu.getContext(), R.dimen.tbds126)));
            this.jCv.setOnTabSelectedListener(this);
            b(this.jCv);
            this.jhR.addHeaderView(this.jCv);
        }
    }

    private void dc(View view) {
        this.jCw = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.jCw.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.M_W_X006 / 2), 0);
        this.jCw.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.tieba.frs.good.a.5
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    if (tab.getTag() instanceof Integer) {
                        a.this.a(((Integer) tab.getTag()).intValue(), a.this.jCv, true);
                    }
                    a.this.setTabColorSelected(tab);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                a.this.bUP();
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

    private void rl(boolean z) {
        if (z) {
            this.jCw.setVisibility(8);
        } else if (this.jCw.getTabCount() > 1) {
            this.jCw.setVisibility(0);
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
                            cVar.ru(R.color.CAM_X0108);
                        } else if (at.isEmpty(this.jCz)) {
                            cVar.ru(R.color.CAM_X0105);
                        } else {
                            cVar.rv(com.baidu.tieba.lego.card.c.b.sF(this.jCz));
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
                this.jCz = themeElement.font_color;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            c cVar = (c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (at.isEmpty(this.jCz)) {
                cVar.ru(R.color.CAM_X0105);
            } else {
                cVar.rv(com.baidu.tieba.lego.card.c.b.sF(this.jCz));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).ru(R.color.CAM_X0108);
        }
    }

    public void Hp() {
        if (cLC() != null) {
            List<n> dataList = cLC().getDataList();
            if (!x.isEmpty(dataList)) {
                for (n nVar : dataList) {
                    if (nVar instanceof by) {
                        by byVar = (by) nVar;
                        if (byVar.eSI != 0 && byVar.eMv != null) {
                            int[] imageWidthAndHeight = byVar.eMv.getImageWidthAndHeight();
                            byVar.eSI = imageWidthAndHeight[0];
                            byVar.eSJ = imageWidthAndHeight[1];
                        }
                    }
                }
                e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.good.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.cLC().notifyDataSetChanged();
                    }
                }, 500L);
            }
        }
    }

    public void Lv(String str) {
        if (this.jCu.cLw() != null) {
            this.jCu.cLw().Lx(str);
        }
    }

    public void Lw(String str) {
        if (!StringUtils.isNull(str) && !x.isEmpty(this.jCx.getDataList())) {
            Iterator<n> it = this.jCx.cLK().iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                    if ((aVar.bMO() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bMO()).eNT)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
