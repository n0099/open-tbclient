package com.baidu.tieba.frs.worldcup.videotopic.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.worldcup.videotopic.c.b;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class VideoTopicFragment extends BaseFragment implements com.baidu.tieba.frs.worldcup.videotopic.activity.a {
    private AppBarLayout QN;
    private PbListView bJY;
    private BdTypeRecyclerView bMI;
    private LinearLayout bxc;
    private ImageView ccE;
    private ObservedChangeLinearLayout dCv;
    private NoNetworkView dgC;
    private View eaA;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a ebL;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a ebM;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean ebN = true;
    private BdListView.e eaI = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.YL();
        }
    };
    private NoNetworkView.a cRx = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (z) {
                VideoTopicFragment.this.fW(true);
            } else {
                VideoTopicFragment.this.aGW();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.video_topic_fragment, viewGroup, false);
        aT(inflate);
        aE(inflate);
        aU(inflate);
        aGX();
        aGV();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        init();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.ebL.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.ebM = new b(getPageContext(), this, getArguments());
        aGU();
    }

    private void aGU() {
        aGZ();
        showLoadingView(this.bxc, true);
        fW(false);
        aHa();
        this.ebN = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(boolean z) {
        if (aGW() && this.ebM != null) {
            this.bMI.setSelection(0);
            this.ebM.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        hideLoadingView(this.bxc);
        aGZ();
        showNetRefreshView(this.bxc, string, true);
    }

    private void aT(View view) {
        this.eaA = view.findViewById(e.g.statebar_view);
        if (this.eaA.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eaA.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.eaA.setLayoutParams(layoutParams);
        }
    }

    public String getTopic() {
        if (getArguments() != null) {
            String string = getArguments().getString(IntentConfig.TOPIC_NAME, getResources().getString(e.j.frs_video_topic));
            if (!ao.isEmpty(string)) {
                return string;
            }
        }
        return getResources().getString(e.j.frs_video_topic);
    }

    private void aE(View view) {
        this.dCv = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QN = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.ccE = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements RecyclerView.RecyclerListener {
        private a() {
        }

        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(e.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(e.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        }
    }

    private void aU(View view) {
        this.bxc = (LinearLayout) view.findViewById(e.g.content_container);
        this.bMI = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bMI.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bMI.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bMI.setScrollable(this);
        this.bMI.setFadingEdgeLength(0);
        this.bMI.setOverScrollMode(2);
        this.bMI.setOnSrollToBottomListener(this.eaI);
        this.bMI.setRecyclerListener(new a());
        this.ebL = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bMI);
    }

    private void aGV() {
        this.dgC = new NoNetworkView(getActivity());
        this.dgC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.dgC.a(this.cRx);
        this.dCv.addView(this.dgC);
        aGW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGW() {
        if (j.kM()) {
            this.dgC.setVisibility(8);
            return true;
        }
        this.dgC.setVisibility(0);
        return false;
    }

    private void aGX() {
        this.bJY = new PbListView(getActivity());
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.setHeight(l.h(getActivity(), e.C0175e.tbds182));
        this.bJY.DL();
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bJY.dU(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YL() {
        if (aGW() && this.ebM != null) {
            aHa();
            this.bMI.stopScroll();
            this.ebM.aHw();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        YT();
        if (d(aVar) && this.ebL != null) {
            this.ebL.setForumId(getForumId());
            this.ebL.setData(arrayList);
            this.ebL.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bxc);
            aGY();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gZA) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aGZ();
        showNetRefreshView(this.bxc, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.lo()) {
            hideNetRefreshView(this.bxc);
            showLoadingView(this.bxc, true);
            fW(false);
        }
    }

    private void aGY() {
        this.bMI.setVisibility(0);
    }

    private void aGZ() {
        this.bMI.setVisibility(8);
    }

    private void YT() {
        hideLoadingView(this.bxc);
        aGY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            fW(true);
        }
    }

    private void aHa() {
        if (this.ebM == null || !l.lo()) {
            ZL();
        } else if (this.ebM.hasMore()) {
            if (this.bMI.getCount() > 3) {
                ZJ();
            } else {
                aAM();
            }
        } else if (this.bMI.getCount() == 0 && !this.ebN) {
            ZL();
        } else {
            ZK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ebL != null) {
            this.ebL.onDestory();
        }
        if (this.bMI != null) {
            this.bMI.setOnSrollToBottomListener(null);
            this.bMI.setScrollable(null);
        }
        if (this.ebM != null) {
            this.ebM.onDestroy();
        }
    }

    public void ZJ() {
        this.bMI.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.setOnClickListener(null);
        this.bJY.DO();
    }

    public void ZK() {
        this.bMI.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.setOnClickListener(null);
        this.bJY.DP();
        this.bJY.setText(getResources().getString(e.j.list_has_no_more));
    }

    public void aAM() {
        this.bMI.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.YL();
            }
        });
        this.bJY.DP();
        this.bJY.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void ZL() {
        this.bMI.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dn(e.f.s_navbar_bg));
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
                al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                ap.CF().c(this.ccE, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
            }
            if (this.dgC != null) {
                this.dgC.onChangeSkinType(getPageContext(), i);
            }
            if (this.eaA != null) {
                this.eaA.setBackgroundDrawable(new BitmapDrawable(al.dn(e.f.s_navbar_bg)).mutate());
            }
            if (this.dgC != null) {
                this.dgC.onChangeSkinType(getPageContext(), i);
            }
            if (this.bJY != null) {
                this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bJY.dW(i);
            }
            al.j(this.QN, e.d.cp_bg_line_d);
            al.j(this.bMI, e.d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.ebM != null ? this.ebM.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.ebM != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.ebM.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
