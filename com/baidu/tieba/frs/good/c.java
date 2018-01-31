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
    private PbListView bYZ;
    private v bjM;
    private BdSwipeRefreshLayout dDe;
    private FrameLayout dOP;
    private TabLayout dOQ;
    private a dOR;
    private b dOy;
    private final int ds10;
    private final int ds210;
    private final int ds32;
    private final int ds34;
    private final int ds82;
    private RelativeLayout bPW = null;
    private BdTypeRecyclerView dDc = null;
    private k mPullView = null;
    private BannerView dOS = null;
    private boolean dOT = false;
    private boolean dOU = false;
    private int dOV = 0;
    private BannerView.a dOW = new BannerView.a() { // from class: com.baidu.tieba.frs.good.c.3
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Iw() {
            c.this.axP();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Ix() {
            c.this.axR();
        }
    };

    public c(b bVar, View view, boolean z) {
        this.dOy = null;
        this.dOy = bVar;
        q(view, z);
        this.ds10 = l.s(this.dOy.getContext(), d.e.tbds10);
        this.ds32 = l.s(this.dOy.getContext(), d.e.tbds32);
        this.ds210 = l.s(this.dOy.getContext(), d.e.tbds210);
        this.ds82 = l.s(this.dOy.getContext(), d.e.tbds82);
        this.ds34 = l.s(this.dOy.getContext(), d.e.tbds34);
    }

    private void q(View view, boolean z) {
        this.bPW = (RelativeLayout) view.findViewById(d.g.frs_good_container);
        this.dOQ = (TabLayout) view.findViewById(d.g.frs_good_tabview);
        this.dOQ.setOnTabSelectedListener(this);
        this.dDc = (BdTypeRecyclerView) view.findViewById(d.g.frs_good_lv_thread);
        this.dDc.setLayoutManager(new LinearLayoutManager(this.dDc.getContext()));
        this.mPullView = new k(this.dOy.getPageContext());
        this.dDc.setFadingEdgeLength(0);
        this.dDc.setOverScrollMode(2);
        this.dDc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.good.c.1
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
        this.bYZ = new PbListView(this.dOy.getPageContext().getPageActivity());
        this.bYZ.sv();
        this.bYZ.gu(d.C0108d.cp_bg_line_e);
        this.bYZ.setHeight(l.s(this.dOy.getActivity(), d.e.tbds182));
        this.bYZ.DJ();
        this.bYZ.setTextSize(d.e.tbfontsize33);
        this.bYZ.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
        this.bYZ.gt(d.C0108d.cp_cont_e);
        this.dDc.setOnSrollToBottomListener(this.dOy);
        if (this.dDe == null) {
            this.dDe = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_pull_refresh_layout);
            this.dDe.setProgressView(this.mPullView);
            aj.t(this.dDe, d.C0108d.cp_bg_line_c);
        }
        this.dOP = (FrameLayout) view.findViewById(d.g.frs_list_content);
        this.dOR = new a(this.dOy, this.dDc);
        cM(false);
    }

    private void b(v vVar) {
        if (this.dOS == null) {
            this.dOS = new BannerView(this.dOy.getPageContext().getPageActivity());
            this.dOS.setLayoutParams(new AbsListView.LayoutParams(-1, this.dOy.getResources().getDimensionPixelSize(d.e.ds100)));
            this.dOS.setVisibility(8);
            this.dOS.setBannerViewClickListener(this.dOW);
            this.dOS.setBannerData(vVar);
            this.dOS.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.good.c.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void q(String str, boolean z) {
                    if (z && c.this.dOS.Iu() && !c.this.dOT && c.this.dDc != null) {
                        c.this.dOT = true;
                        c.this.dDc.addHeaderView(c.this.dOS, 1);
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
    public void axP() {
        if (this.bjM != null) {
            String value = this.bjM.getValue();
            if (this.bjM.xv() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.dOy.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.bjM.xv() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.dOy.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            this.dOy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bjM.xv() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aWp != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aWp) {
                        case FRS:
                            this.dOy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dOy.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.dOy.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            this.dOy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            return;
                        default:
                            return;
                    }
                }
                av.Da().c(this.dOy.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dOy.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bjM.xv() == 4) {
                this.dOy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dOy.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dDc.setOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(o oVar) {
        this.dOR.setOnAdapterItemClickListener(oVar);
    }

    public void onDestroy() {
        this.dOR.onDestory();
        this.dDc.setOnSrollToBottomListener(null);
        this.dOQ.removeAllTabs();
    }

    public void cM(boolean z) {
        if (!z) {
            this.dDe.setRefreshing(false);
        }
    }

    public void WP() {
        this.dDc.setVisibility(0);
    }

    public void auM() {
        if (this.dOR != null) {
            this.dOR.notifyDataSetChanged();
        }
    }

    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.aYJ() != null && lVar.aYJ().getGood_classify() != null) {
            ArrayList<aa> good_classify = lVar.aYJ().getGood_classify();
            TabData tabData = new TabData();
            com.baidu.tieba.frs.tab.b bVar = new com.baidu.tieba.frs.tab.b();
            bVar.tabId = 0;
            bVar.name = this.dOy.getPageContext().getResources().getString(d.j.all);
            tabData.add(bVar);
            for (aa aaVar : good_classify) {
                if (aaVar != null && aaVar.xz() > 0 && !TextUtils.isEmpty(aaVar.xy()) && !TextUtils.isEmpty(aaVar.xy().trim())) {
                    com.baidu.tieba.frs.tab.b bVar2 = new com.baidu.tieba.frs.tab.b();
                    bVar2.tabId = aaVar.xz();
                    bVar2.name = aaVar.xy();
                    tabData.add(bVar2);
                }
            }
            if (com.baidu.tbadk.core.util.v.D(tabData) <= 1) {
                this.dOQ.setVisibility(8);
                return;
            }
            this.dOQ.setVisibility(0);
            this.dOU = true;
            int min = Math.min(tabData.size(), 9);
            if (this.dOQ.getTabCount() > min) {
                int tabCount = this.dOQ.getTabCount() - min;
                for (int i = 0; i < tabCount; i++) {
                    this.dOQ.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) this.dOQ.getChildAt(0);
            if (linearLayout != null) {
                for (int i2 = 0; i2 < min; i2++) {
                    TabLayout.Tab tabAt = this.dOQ.getTabAt(i2);
                    if (tabAt == null) {
                        tabAt = this.dOQ.newTab();
                        this.dOQ.addTab(tabAt, false);
                        if (linearLayout.getChildAt(i2) != null) {
                            linearLayout.getChildAt(i2).setPadding(0, 0, 0, 0);
                        }
                    }
                    TabLayout.Tab tab = tabAt;
                    if (!(tab.getCustomView() instanceof TextView)) {
                        TextView textView = new TextView(this.dOy.getContext());
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
                    if (tabData.get(i2).tabId == this.dOV) {
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
        this.dOR.b(arrayList, lVar);
        this.dOU = false;
    }

    public BdTypeRecyclerView getListView() {
        return this.dDc;
    }

    public void axQ() {
        this.dOR.notifyDataSetInvalidated();
    }

    public void setListViewSelection(int i) {
        this.dDc.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.dOT && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bjM = forumData.getFrsBannerData();
            b(this.bjM);
            this.dOS.reset();
            this.dDc.removeHeaderView(this.dOS);
            if (this.bjM.getType() == 1 && !TextUtils.isEmpty(this.bjM.xw())) {
                this.dOS.c(this.dOy.getPageContext(), this.bjM.xw());
                if (this.bjM.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.dOy.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void axR() {
        if (this.dOS != null) {
            this.dOT = false;
            this.dDc.removeHeaderView(this.dOS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
        if (this.dOR != null) {
            this.dOR.awp();
            this.dOR.notifyDataSetChanged();
            this.dOR.onChangeSkinType(i);
        }
        this.dOy.getBaseFragmentActivity().getLayoutMode().aN(i == 1);
        this.dOy.getBaseFragmentActivity().getLayoutMode().aM(this.bPW);
        if (this.dOS != null) {
            this.dOS.Iv();
        }
        if (this.bYZ != null) {
            this.bYZ.setTextColor(aj.getColor(d.C0108d.cp_cont_j));
            this.bYZ.gv(i);
        }
        aj.t(this.dDe, d.C0108d.cp_bg_line_c);
        aj.t(this.dDc, d.C0108d.cp_bg_line_e);
        if (this.dOQ != null) {
            aj.t(this.dOQ, d.C0108d.cp_bg_line_e);
            for (int i2 = 0; i2 < this.dOQ.getTabCount(); i2++) {
                TabLayout.Tab tabAt = this.dOQ.getTabAt(i2);
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
        this.dDe.setRefreshing(true);
    }

    public a axS() {
        return this.dOR;
    }

    public RelativeLayout axT() {
        return this.bPW;
    }

    public View axU() {
        return this.dDe;
    }

    public void auW() {
        if (r.NQ().NR()) {
            int lastVisiblePosition = this.dDc.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dDc.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof com.baidu.tieba.frs.o)) {
                    com.baidu.tieba.frs.o oVar = (com.baidu.tieba.frs.o) childAt.getTag();
                    if (oVar.dDL != null) {
                        com.baidu.tbadk.k.l perfLog = oVar.dDL.getPerfLog();
                        perfLog.im(1000);
                        perfLog.byw = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dDL.getLocationOnScreen(iArr);
                            if (iArr[1] > l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dDL.startLogPerf();
                    }
                    if (oVar.dDK != null && (oVar.dDK instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dDK;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.im(1000);
                                perfLog2.byw = true;
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
    public void auX() {
        this.dDc.setNextPage(this.bYZ);
        this.bYZ.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bYZ.DM();
    }

    public void auY() {
        this.dDc.setNextPage(this.bYZ);
        this.bYZ.gw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bYZ.DN();
        this.bYZ.setText(this.dOy.getResources().getString(d.j.list_no_more));
    }

    public void alU() {
        this.dDc.setNextPage(null);
    }

    public void gd(boolean z) {
        this.dOP.setVisibility(z ? 0 : 8);
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                com.baidu.tieba.frs.d.c.dRe.dQW = intValue;
                if (!this.dOU) {
                    this.dOV = intValue;
                    this.dOy.nD(this.dOV);
                    s.akK().eH(false);
                }
            }
            if (tab.getCustomView() != null) {
                ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0108d.cp_cont_b));
            }
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        if (this.dDe != null && this.dDe.isRefreshing()) {
            this.dDe.sX();
        }
        if (tab != null && tab.getCustomView() != null) {
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0108d.cp_cont_j));
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            if (!this.dOU && (tab.getTag() instanceof Integer)) {
                this.dOV = ((Integer) tab.getTag()).intValue();
                this.dOy.nD(this.dOV);
            }
            ((TextView) tab.getCustomView()).setTextColor(aj.getColor(d.C0108d.cp_cont_b));
        }
    }
}
