package com.baidu.tieba.frs.good;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.k.r;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.s;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class c implements TabLayout.OnTabSelectedListener {
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private PbListView bYR;
    private v bjE;
    private BdSwipeRefreshLayout dCJ;
    private b dOd;
    private FrameLayout dOu;
    private TabLayout dOv;
    private a dOw;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bPO = null;
    private BdTypeRecyclerView dCH = null;
    private k mPullView = null;
    private BannerView dOx = null;
    private boolean dOy = false;
    private boolean dOz = false;
    private int dOA = 0;
    private BannerView.a dOB = new BannerView.a() { // from class: com.baidu.tieba.frs.good.c.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Iu() {
            c.this.axK();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Iv() {
            c.this.axM();
        }
    };

    public c(b bVar, View view, boolean z) {
        this.dOd = null;
        this.dOd = bVar;
        q(view, z);
        this.ds10 = l.s(this.dOd.getContext(), d.e.tbds10);
        this.ds32 = l.s(this.dOd.getContext(), d.e.tbds32);
        this.ds210 = l.s(this.dOd.getContext(), d.e.tbds210);
        this.ds82 = l.s(this.dOd.getContext(), d.e.tbds82);
        this.ds34 = l.s(this.dOd.getContext(), d.e.tbds34);
    }

    private void q(View view, boolean z) {
        this.bPO = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        this.dOv = (TabLayout) view.findViewById(d.g.frs_good_tabview);
        this.dOv.setOnTabSelectedListener(this);
        this.dCH = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.dCH.setLayoutManager(new LinearLayoutManager(this.dCH.getContext()));
        this.mPullView = new k(this.dOd.getPageContext());
        this.dCH.setFadingEdgeLength(0);
        this.dCH.setOverScrollMode(2);
        this.dCH.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.c.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(d.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(d.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.bYR = new PbListView(this.dOd.getPageContext().getPageActivity());
        this.bYR.su();
        this.bYR.gu(d.C0107d.cp_bg_line_e);
        this.bYR.setHeight(l.s(this.dOd.getActivity(), d.e.tbds182));
        this.bYR.DH();
        this.bYR.setTextSize(d.e.tbfontsize33);
        this.bYR.setTextColor(aj.getColor(d.C0107d.cp_cont_j));
        this.bYR.gt(d.C0107d.cp_cont_e);
        this.dCH.setOnSrollToBottomListener(this.dOd);
        if (this.dCJ == null) {
            this.dCJ = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.dCJ.setProgressView(this.mPullView);
            aj.t(this.dCJ, d.C0107d.cp_bg_line_c);
        }
        this.dOu = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.dOw = new a(this.dOd, this.dCH);
        cL(false);
    }

    private void b(v vVar) {
        if (this.dOx == null) {
            this.dOx = new BannerView(this.dOd.getPageContext().getPageActivity());
            this.dOx.setLayoutParams(new AbsListView.LayoutParams(-1, this.dOd.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dOx.setVisibility(8);
            this.dOx.setBannerViewClickListener(this.dOB);
            this.dOx.setBannerData(vVar);
            this.dOx.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.c.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void q(String str, boolean z) {
                    if (z && c.this.dOx.Is() && !c.this.dOy && c.this.dCH != null) {
                        c.this.dOy = true;
                        c.this.dCH.addHeaderView(c.this.dOx, 1);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void axK() {
        if (this.bjE != null) {
            String value = this.bjE.getValue();
            if (this.bjE.xu() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.dOd.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.bjE.xu() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dOd.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dOd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bjE.xu() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aWm != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aWm) {
                        case FRS:
                            this.dOd.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dOd.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dOd.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dOd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                av.CZ().c(this.dOd.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dOd.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bjE.xu() == 4) {
                this.dOd.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dOd.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dCH.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(o oVar) {
        this.dOw.setOnAdapterItemClickListener(oVar);
    }

    public void onDestroy() {
        this.dOw.onDestory();
        this.dCH.setOnSrollToBottomListener(null);
        this.dOv.removeAllTabs();
    }

    public void cL(boolean z) {
        if (!z) {
            this.dCJ.setRefreshing(false);
        }
    }

    public void WN() {
        this.dCH.setVisibility(0);
    }

    public void auH() {
        if (this.dOw != null) {
            this.dOw.notifyDataSetChanged();
        }
    }

    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.aYE() != null && lVar.aYE().getGood_classify() != null) {
            ArrayList<aa> good_classify = lVar.aYE().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.b bVar = new com.baidu.tieba.frs.tab.b();
            bVar.tabId = 0;
            bVar.name = this.dOd.getPageContext().getResources().getString(d.j.all);
            tabData.add(bVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.xy() > 0 && !TextUtils.isEmpty(aaVar.xx()) && !TextUtils.isEmpty(aaVar.xx().trim())) {
                    com.baidu.tieba.frs.tab.b bVar2 = new com.baidu.tieba.frs.tab.b();
                    bVar2.tabId = aaVar.xy();
                    bVar2.name = aaVar.xx();
                    tabData.add(bVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.D(tabData) <= 1) {
                this.dOv.setVisibility(8);
                return;
            }
            this.dOv.setVisibility(0);
            this.dOz = true;
            int min = Math.min(tabData.size(), 9);
            if (this.dOv.getTabCount() > min) {
                int tabCount = this.dOv.getTabCount() - min;
                for (int i = 0; i < tabCount; i++) {
                    this.dOv.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) this.dOv.getChildAt(0);
            if (linearLayout != null) {
                for (int i2 = 0; i2 < min; i2++) {
                    TabLayout.Tab tabAt = this.dOv.getTabAt(i2);
                    if (tabAt == null) {
                        tabAt = this.dOv.newTab();
                        this.dOv.addTab(tabAt, false);
                        if (linearLayout.getChildAt(i2) != null) {
                            linearLayout.getChildAt(i2).setPadding(0, 0, 0, 0);
                        }
                    }
                    TabLayout.Tab tab = tabAt;
                    if (!(tab.getCustomView() instanceof TextView)) {
                        TextView textView = new TextView(this.dOd.getContext());
                        textView.setSingleLine();
                        aj.s(textView, d.f.bg_item_good_tab_border);
                        textView.setGravity(17);
                        textView.setTextSize(0, this.ds34);
                        textView.setTextColor(aj.getColor(d.C0107d.cp_cont_j));
                        tab.setCustomView(textView);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                        layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                        textView.setLayoutParams(layoutParams);
                    }
                    ((TextView) tab.getCustomView()).setText(am.f(tabData.get(i2).name, 10, "..."));
                    tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                    if (tabData.get(i2).tabId == this.dOA) {
                        tab.select();
                    }
                }
                linearLayout.setPadding(this.ds34, 0, this.ds34, 0);
            }
        }
    }

    public void a(ArrayList<i> arrayList, int i, com.baidu.tieba.tbadkCore.l lVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dOw.b(arrayList, lVar);
        this.dOz = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dCH;
    }

    public void axL() {
        this.dOw.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dCH.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dOy && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bjE = forumData.getFrsBannerData();
            b(this.bjE);
            this.dOx.reset();
            this.dCH.removeHeaderView(this.dOx);
            if (this.bjE.getType() == 1 && !TextUtils.isEmpty(this.bjE.xv())) {
                this.dOx.c(this.dOd.getPageContext(), this.bjE.xv());
                if (this.bjE.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dOd.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void axM() {
        if (this.dOx != null) {
            this.dOy = false;
            this.dCH.removeHeaderView(this.dOx);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
        if (this.dOw != null) {
            this.dOw.awk();
            this.dOw.notifyDataSetChanged();
            this.dOw.onChangeSkinType(i);
        }
        this.dOd.getBaseFragmentActivity().getLayoutMode().aM(i == 1);
        this.dOd.getBaseFragmentActivity().getLayoutMode().aM(this.bPO);
        if (this.dOx != null) {
            this.dOx.It();
        }
        if (this.bYR != null) {
            this.bYR.setTextColor(aj.getColor(d.C0107d.cp_cont_j));
            this.bYR.gv(i);
        }
        aj.t(this.dCJ, d.C0107d.cp_bg_line_c);
        aj.t(this.dCH, d.C0107d.cp_bg_line_e);
        if (this.dOv != null) {
            aj.t(this.dOv, d.C0107d.cp_bg_line_e);
            for (int i2 = 0; i2 < this.dOv.getTabCount(); i2++) {
                TabLayout.Tab tabAt = this.dOv.getTabAt(i2);
                if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                    TextView textView = (TextView) tabAt.getCustomView();
                    if (tabAt.isSelected()) {
                        textView.setTextColor(aj.getColor(d.C0107d.cp_cont_b));
                    } else {
                        textView.setTextColor(aj.getColor(d.C0107d.cp_cont_j));
                    }
                    aj.s(textView, d.f.bg_item_good_tab_border);
                }
            }
        }
    }

    public void startPullRefresh() {
        this.dCJ.setRefreshing(true);
    }

    public a axN() {
        return this.dOw;
    }

    public RelativeLayout axO() {
        return this.bPO;
    }

    public View axP() {
        return this.dCJ;
    }

    public void auR() {
        if (r.NO().NP()) {
            int lastVisiblePosition = this.dCH.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dCH.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof com.baidu.tieba.frs.o)) {
                    com.baidu.tieba.frs.o oVar = (com.baidu.tieba.frs.o) childAt.getTag();
                    if (oVar.dDq != null) {
                        com.baidu.tbadk.k.l perfLog = oVar.dDq.getPerfLog();
                        perfLog.im(1000);
                        perfLog.byn = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dDq.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dDq.startLogPerf();
                    }
                    if (oVar.dDp != null && (oVar.dDp instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dDp;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.im(1000);
                                perfLog2.byn = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > l.aq(TbadkCoreApplication.getInst().getContext())) {
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
    public void auS() {
        this.dCH.setNextPage(this.bYR);
        this.bYR.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bYR.DK();
    }

    public void auT() {
        this.dCH.setNextPage(this.bYR);
        this.bYR.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bYR.DL();
        this.bYR.setText(this.dOd.getResources().getString(d.j.list_no_more));
    }

    public void alP() {
        this.dCH.setNextPage(null);
    }

    public void gb(boolean z) {
        this.dOu.setVisibility(z ? 0 : 8);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.c.dQJ.dQB = intValue;
                if (!this.dOz) {
                    this.dOA = intValue;
                    this.dOd.nD(this.dOA);
                    s.akF().eF(false);
                }
            }
            if (tab.getCustomView() != null) {
                ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0107d.cp_cont_b));
            }
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dCJ != null && this.dCJ.isRefreshing()) {
            this.dCJ.sW();
        }
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0107d.cp_cont_j));
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dOz && (tab.getTag() instanceof Integer)) {
                this.dOA = ((Integer) tab.getTag()).intValue();
                this.dOd.nD(this.dOA);
            }
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0107d.cp_cont_b));
        }
    }
}
