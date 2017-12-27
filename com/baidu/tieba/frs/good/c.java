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
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.core.view.j;
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
    private PbListView bYK;
    private v bju;
    private b dJB;
    private FrameLayout dJS;
    private TabLayout dJT;
    private a dJU;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private BdSwipeRefreshLayout dyi;
    private RelativeLayout bPH = null;
    private BdTypeRecyclerView dyg = null;
    private j mPullView = null;
    private BannerView dJV = null;
    private boolean dJW = false;
    private boolean dJX = false;
    private int dJY = 0;
    private BannerView.a dJZ = new BannerView.a() { // from class: com.baidu.tieba.frs.good.c.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void IB() {
            c.this.awH();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void IC() {
            c.this.awJ();
        }
    };

    public c(b bVar, View view, boolean z) {
        this.dJB = null;
        this.dJB = bVar;
        q(view, z);
        this.ds10 = l.s(this.dJB.getContext(), d.e.tbds10);
        this.ds32 = l.s(this.dJB.getContext(), d.e.tbds32);
        this.ds210 = l.s(this.dJB.getContext(), d.e.tbds210);
        this.ds82 = l.s(this.dJB.getContext(), d.e.tbds82);
        this.ds34 = l.s(this.dJB.getContext(), d.e.tbds34);
    }

    private void q(View view, boolean z) {
        this.bPH = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        this.dJT = (TabLayout) view.findViewById(d.g.frs_good_tabview);
        this.dJT.setOnTabSelectedListener(this);
        this.dyg = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.dyg.setLayoutManager(new LinearLayoutManager(this.dyg.getContext()));
        this.mPullView = new j(this.dJB.getPageContext());
        this.dyg.setFadingEdgeLength(0);
        this.dyg.setOverScrollMode(2);
        this.dyg.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.c.1
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
        this.bYK = new PbListView(this.dJB.getPageContext().getPageActivity());
        this.bYK.su();
        this.bYK.gx(d.C0108d.cp_bg_line_e);
        this.bYK.setHeight(l.s(this.dJB.getActivity(), d.e.tbds182));
        this.bYK.DQ();
        this.bYK.setTextSize(d.e.tbfontsize33);
        this.bYK.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
        this.bYK.gw(d.C0108d.cp_cont_e);
        this.dyg.setOnSrollToBottomListener(this.dJB);
        if (this.dyi == null) {
            this.dyi = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.dyi.setProgressView(this.mPullView);
            aj.t(this.dyi, d.C0108d.cp_bg_line_c);
        }
        this.dJS = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.dJU = new a(this.dJB, this.dyg);
        cN(false);
    }

    private void b(v vVar) {
        if (this.dJV == null) {
            this.dJV = new BannerView(this.dJB.getPageContext().getPageActivity());
            this.dJV.setLayoutParams(new AbsListView.LayoutParams(-1, this.dJB.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dJV.setVisibility(8);
            this.dJV.setBannerViewClickListener(this.dJZ);
            this.dJV.setBannerData(vVar);
            this.dJV.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.c.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void q(String str, boolean z) {
                    if (z && c.this.dJV.Iz() && !c.this.dJW && c.this.dyg != null) {
                        c.this.dJW = true;
                        c.this.dyg.addHeaderView(c.this.dJV, 1);
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
    public void awH() {
        if (this.bju != null) {
            String value = this.bju.getValue();
            if (this.bju.xv() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.dJB.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.bju.xv() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dJB.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dJB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bju.xv() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aWn != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aWn) {
                        case FRS:
                            this.dJB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dJB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dJB.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dJB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                av.Di().c(this.dJB.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dJB.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bju.xv() == 4) {
                this.dJB.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dJB.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(i.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dyg.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(o oVar) {
        this.dJU.setOnAdapterItemClickListener(oVar);
    }

    public void onDestroy() {
        this.dJU.onDestory();
        this.dyg.setOnSrollToBottomListener(null);
        this.dJT.removeAllTabs();
    }

    public void cN(boolean z) {
        if (!z) {
            this.dyi.setRefreshing(false);
        }
    }

    public void WZ() {
        this.dyg.setVisibility(0);
    }

    public void atE() {
        if (this.dJU != null) {
            this.dJU.notifyDataSetChanged();
        }
    }

    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.aYy() != null && lVar.aYy().getGood_classify() != null) {
            ArrayList<aa> good_classify = lVar.aYy().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.b bVar = new com.baidu.tieba.frs.tab.b();
            bVar.tabId = 0;
            bVar.name = this.dJB.getPageContext().getResources().getString(d.j.all);
            tabData.add(bVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.xz() > 0 && !TextUtils.isEmpty(aaVar.xy()) && !TextUtils.isEmpty(aaVar.xy().trim())) {
                    com.baidu.tieba.frs.tab.b bVar2 = new com.baidu.tieba.frs.tab.b();
                    bVar2.tabId = aaVar.xz();
                    bVar2.name = aaVar.xy();
                    tabData.add(bVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.F(tabData) <= 1) {
                this.dJT.setVisibility(8);
                return;
            }
            this.dJT.setVisibility(0);
            this.dJX = true;
            int min = Math.min(tabData.size(), 9);
            if (this.dJT.getTabCount() > min) {
                int tabCount = this.dJT.getTabCount() - min;
                for (int i = 0; i < tabCount; i++) {
                    this.dJT.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) this.dJT.getChildAt(0);
            if (linearLayout != null) {
                for (int i2 = 0; i2 < min; i2++) {
                    TabLayout.Tab tabAt = this.dJT.getTabAt(i2);
                    if (tabAt == null) {
                        tabAt = this.dJT.newTab();
                        this.dJT.addTab(tabAt, false);
                        if (linearLayout.getChildAt(i2) != null) {
                            linearLayout.getChildAt(i2).setPadding(0, 0, 0, 0);
                        }
                    }
                    TabLayout.Tab tab = tabAt;
                    if (!(tab.getCustomView() instanceof TextView)) {
                        TextView textView = new TextView(this.dJB.getContext());
                        textView.setSingleLine();
                        aj.s(textView, d.f.bg_item_good_tab_border);
                        textView.setGravity(17);
                        textView.setTextSize(0, this.ds34);
                        textView.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
                        tab.setCustomView(textView);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ds210, this.ds82);
                        layoutParams.setMargins(this.ds10, this.ds32, this.ds10, this.ds32);
                        textView.setLayoutParams(layoutParams);
                    }
                    ((TextView) tab.getCustomView()).setText(am.f(tabData.get(i2).name, 10, "..."));
                    tab.setTag(Integer.valueOf(tabData.get(i2).tabId));
                    if (tabData.get(i2).tabId == this.dJY) {
                        tab.select();
                    }
                }
                linearLayout.setPadding(this.ds34, 0, this.ds34, 0);
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, int i, com.baidu.tieba.tbadkCore.l lVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dJU.b(arrayList, lVar);
        this.dJX = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dyg;
    }

    public void awI() {
        this.dJU.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dyg.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dJW && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bju = forumData.getFrsBannerData();
            b(this.bju);
            this.dJV.reset();
            this.dyg.removeHeaderView(this.dJV);
            if (this.bju.getType() == 1 && !TextUtils.isEmpty(this.bju.xw())) {
                this.dJV.c(this.dJB.getPageContext(), this.bju.xw());
                if (this.bju.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dJB.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void awJ() {
        if (this.dJV != null) {
            this.dJW = false;
            this.dyg.removeHeaderView(this.dJV);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.gy(i);
        }
        if (this.dJU != null) {
            this.dJU.avh();
            this.dJU.notifyDataSetChanged();
            this.dJU.onChangeSkinType(i);
        }
        this.dJB.getBaseFragmentActivity().getLayoutMode().aM(i == 1);
        this.dJB.getBaseFragmentActivity().getLayoutMode().aM(this.bPH);
        if (this.dJV != null) {
            this.dJV.IA();
        }
        if (this.bYK != null) {
            this.bYK.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
            this.bYK.gy(i);
        }
        aj.t(this.dyi, d.C0108d.cp_bg_line_c);
        aj.t(this.dyg, d.C0108d.cp_bg_line_e);
        if (this.dJT != null) {
            aj.t(this.dJT, d.C0108d.cp_bg_line_e);
            for (int i2 = 0; i2 < this.dJT.getTabCount(); i2++) {
                TabLayout.Tab tabAt = this.dJT.getTabAt(i2);
                if (tabAt != null && (tabAt.getCustomView() instanceof TextView)) {
                    TextView textView = (TextView) tabAt.getCustomView();
                    if (tabAt.isSelected()) {
                        textView.setTextColor(aj.getColor(d.C0108d.cp_cont_b));
                    } else {
                        textView.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
                    }
                    aj.s(textView, d.f.bg_item_good_tab_border);
                }
            }
        }
    }

    public void startPullRefresh() {
        this.dyi.setRefreshing(true);
    }

    public a awK() {
        return this.dJU;
    }

    public RelativeLayout awL() {
        return this.bPH;
    }

    public View awM() {
        return this.dyi;
    }

    public void atO() {
        if (r.Oa().Ob()) {
            int lastVisiblePosition = this.dyg.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dyg.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof com.baidu.tieba.frs.o)) {
                    com.baidu.tieba.frs.o oVar = (com.baidu.tieba.frs.o) childAt.getTag();
                    if (oVar.dyP != null) {
                        com.baidu.tbadk.k.l perfLog = oVar.dyP.getPerfLog();
                        perfLog.iq(1000);
                        perfLog.bye = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dyP.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dyP.startLogPerf();
                    }
                    if (oVar.dyO != null && (oVar.dyO instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dyO;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.iq(1000);
                                perfLog2.bye = true;
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
    public void atP() {
        this.dyg.setNextPage(this.bYK);
        this.bYK.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bYK.DT();
    }

    public void atQ() {
        this.dyg.setNextPage(this.bYK);
        this.bYK.gz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bYK.DU();
        this.bYK.setText(this.dJB.getResources().getString(d.j.list_no_more));
    }

    public void akM() {
        this.dyg.setNextPage(null);
    }

    public void fX(boolean z) {
        this.dJS.setVisibility(z ? 0 : 8);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.c.dMh.dLZ = intValue;
                if (!this.dJX) {
                    this.dJY = intValue;
                    this.dJB.nA(this.dJY);
                    s.ajC().eB(false);
                }
            }
            if (tab.getCustomView() != null) {
                ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0108d.cp_cont_b));
            }
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dyi != null && this.dyi.isRefreshing()) {
            this.dyi.sW();
        }
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0108d.cp_cont_j));
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dJX && (tab.getTag() instanceof Integer)) {
                this.dJY = ((Integer) tab.getTag()).intValue();
                this.dJB.nA(this.dJY);
            }
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0108d.cp_cont_b));
        }
    }
}
