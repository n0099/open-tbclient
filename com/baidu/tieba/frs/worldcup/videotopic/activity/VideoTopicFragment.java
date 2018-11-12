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
    private AppBarLayout QP;
    private PbListView bKJ;
    private BdTypeRecyclerView bNt;
    private LinearLayout bxN;
    private ImageView ccT;
    private ObservedChangeLinearLayout dDM;
    private NoNetworkView dhH;
    private View ebU;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a edf;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a edg;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean edh = true;
    private BdListView.e ecc = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.YV();
        }
    };
    private NoNetworkView.a cSD = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bE(boolean z) {
            if (z) {
                VideoTopicFragment.this.gg(true);
            } else {
                VideoTopicFragment.this.checkNetwork();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.video_topic_fragment, viewGroup, false);
        aV(inflate);
        aG(inflate);
        aW(inflate);
        aGv();
        aGu();
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
        this.edf.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.edg = new b(getPageContext(), this, getArguments());
        aGt();
    }

    private void aGt() {
        aGx();
        showLoadingView(this.bxN, true);
        gg(false);
        aGy();
        this.edh = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(boolean z) {
        if (checkNetwork() && this.edg != null) {
            this.bNt.setSelection(0);
            this.edg.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        hideLoadingView(this.bxN);
        aGx();
        showNetRefreshView(this.bxN, string, true);
    }

    private void aV(View view) {
        this.ebU = view.findViewById(e.g.statebar_view);
        if (this.ebU.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ebU.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.ebU.setLayoutParams(layoutParams);
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

    private void aG(View view) {
        this.dDM = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QP = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.ccT = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
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

    private void aW(View view) {
        this.bxN = (LinearLayout) view.findViewById(e.g.content_container);
        this.bNt = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bNt.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bNt.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bNt.setScrollable(this);
        this.bNt.setFadingEdgeLength(0);
        this.bNt.setOverScrollMode(2);
        this.bNt.setOnSrollToBottomListener(this.ecc);
        this.bNt.setRecyclerListener(new a());
        this.edf = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bNt);
    }

    private void aGu() {
        this.dhH = new NoNetworkView(getActivity());
        this.dhH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.dhH.a(this.cSD);
        this.dDM.addView(this.dhH);
        checkNetwork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNetwork() {
        if (j.kK()) {
            this.dhH.setVisibility(8);
            return true;
        }
        this.dhH.setVisibility(0);
        return false;
    }

    private void aGv() {
        this.bKJ = new PbListView(getActivity());
        this.bKJ.getView();
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.setHeight(l.h(getActivity(), e.C0200e.tbds182));
        this.bKJ.DV();
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bKJ.ei(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YV() {
        if (checkNetwork() && this.edg != null) {
            aGy();
            this.bNt.stopScroll();
            this.edg.aGU();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        Zd();
        if (d(aVar) && this.edf != null) {
            this.edf.setForumId(getForumId());
            this.edf.setData(arrayList);
            this.edf.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bxN);
            aGw();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.haY) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aGx();
        showNetRefreshView(this.bxN, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.lm()) {
            hideNetRefreshView(this.bxN);
            showLoadingView(this.bxN, true);
            gg(false);
        }
    }

    private void aGw() {
        this.bNt.setVisibility(0);
    }

    private void aGx() {
        this.bNt.setVisibility(8);
    }

    private void Zd() {
        hideLoadingView(this.bxN);
        aGw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            gg(true);
        }
    }

    private void aGy() {
        if (this.edg == null || !l.lm()) {
            ZV();
        } else if (this.edg.hasMore()) {
            if (this.bNt.getCount() > 3) {
                ZT();
            } else {
                aAj();
            }
        } else if (this.bNt.getCount() == 0 && !this.edh) {
            ZV();
        } else {
            ZU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.edf != null) {
            this.edf.onDestory();
        }
        if (this.bNt != null) {
            this.bNt.setOnSrollToBottomListener(null);
            this.bNt.setScrollable(null);
        }
        if (this.edg != null) {
            this.edg.onDestroy();
        }
    }

    public void ZT() {
        this.bNt.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.setOnClickListener(null);
        this.bKJ.DY();
    }

    public void ZU() {
        this.bNt.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.setOnClickListener(null);
        this.bKJ.DZ();
        this.bKJ.setText(getResources().getString(e.j.list_has_no_more));
    }

    public void aAj() {
        this.bNt.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.YV();
            }
        });
        this.bKJ.DZ();
        this.bKJ.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void ZV() {
        this.bNt.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dB(e.f.s_navbar_bg));
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
                al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                ap.CM().c(this.ccT, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
            }
            if (this.dhH != null) {
                this.dhH.onChangeSkinType(getPageContext(), i);
            }
            if (this.ebU != null) {
                this.ebU.setBackgroundDrawable(new BitmapDrawable(al.dB(e.f.s_navbar_bg)).mutate());
            }
            if (this.dhH != null) {
                this.dhH.onChangeSkinType(getPageContext(), i);
            }
            if (this.bKJ != null) {
                this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bKJ.ek(i);
            }
            al.j(this.QP, e.d.cp_bg_line_d);
            al.j(this.bNt, e.d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.edg != null ? this.edg.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.edg != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.edg.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
