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
    private LinearLayout bBk;
    private PbListView bOy;
    private BdTypeRecyclerView bRk;
    private ImageView cgK;
    private ObservedChangeLinearLayout dKl;
    private NoNetworkView dop;
    private View eix;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a ejI;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a ejJ;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean ejK = true;
    private BdListView.e eiF = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.aab();
        }
    };
    private NoNetworkView.a cZk = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                VideoTopicFragment.this.gh(true);
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
        aIh();
        aIg();
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
        this.ejI.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.ejJ = new b(getPageContext(), this, getArguments());
        aIf();
    }

    private void aIf() {
        aIj();
        showLoadingView(this.bBk, true);
        gh(false);
        aIk();
        this.ejK = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(boolean z) {
        if (checkNetwork() && this.ejJ != null) {
            this.bRk.setSelection(0);
            this.ejJ.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        hideLoadingView(this.bBk);
        aIj();
        showNetRefreshView(this.bBk, string, true);
    }

    private void aV(View view) {
        this.eix = view.findViewById(e.g.statebar_view);
        if (this.eix.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eix.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.eix.setLayoutParams(layoutParams);
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
        this.dKl = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QP = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.cgK = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
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
        this.bBk = (LinearLayout) view.findViewById(e.g.content_container);
        this.bRk = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bRk.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRk.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bRk.setScrollable(this);
        this.bRk.setFadingEdgeLength(0);
        this.bRk.setOverScrollMode(2);
        this.bRk.setOnSrollToBottomListener(this.eiF);
        this.bRk.setRecyclerListener(new a());
        this.ejI = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bRk);
    }

    private void aIg() {
        this.dop = new NoNetworkView(getActivity());
        this.dop.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.dop.a(this.cZk);
        this.dKl.addView(this.dop);
        checkNetwork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNetwork() {
        if (j.kK()) {
            this.dop.setVisibility(8);
            return true;
        }
        this.dop.setVisibility(0);
        return false;
    }

    private void aIh() {
        this.bOy = new PbListView(getActivity());
        this.bOy.getView();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bOy.EZ();
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOy.ew(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        if (checkNetwork() && this.ejJ != null) {
            aIk();
            this.bRk.stopScroll();
            this.ejJ.aIG();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        aaj();
        if (d(aVar) && this.ejI != null) {
            this.ejI.setForumId(getForumId());
            this.ejI.setData(arrayList);
            this.ejI.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bBk);
            aIi();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.hhQ) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aIj();
        showNetRefreshView(this.bBk, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.ll()) {
            hideNetRefreshView(this.bBk);
            showLoadingView(this.bBk, true);
            gh(false);
        }
    }

    private void aIi() {
        this.bRk.setVisibility(0);
    }

    private void aIj() {
        this.bRk.setVisibility(8);
    }

    private void aaj() {
        hideLoadingView(this.bBk);
        aIi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            gh(true);
        }
    }

    private void aIk() {
        if (this.ejJ == null || !l.ll()) {
            abb();
        } else if (this.ejJ.hasMore()) {
            if (this.bRk.getCount() > 3) {
                aaZ();
            } else {
                aBT();
            }
        } else if (this.bRk.getCount() == 0 && !this.ejK) {
            abb();
        } else {
            aba();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ejI != null) {
            this.ejI.onDestory();
        }
        if (this.bRk != null) {
            this.bRk.setOnSrollToBottomListener(null);
            this.bRk.setScrollable(null);
        }
        if (this.ejJ != null) {
            this.ejJ.onDestroy();
        }
    }

    public void aaZ() {
        this.bRk.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.setOnClickListener(null);
        this.bOy.Fc();
    }

    public void aba() {
        this.bRk.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.setOnClickListener(null);
        this.bOy.Fd();
        this.bOy.setText(getResources().getString(e.j.list_has_no_more));
    }

    public void aBT() {
        this.bRk.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.aab();
            }
        });
        this.bOy.Fd();
        this.bOy.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void abb() {
        this.bRk.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dP(e.f.s_navbar_bg));
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
                al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                ap.DQ().c(this.cgK, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
            }
            if (this.dop != null) {
                this.dop.onChangeSkinType(getPageContext(), i);
            }
            if (this.eix != null) {
                this.eix.setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
            }
            if (this.dop != null) {
                this.dop.onChangeSkinType(getPageContext(), i);
            }
            if (this.bOy != null) {
                this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bOy.ey(i);
            }
            al.j(this.QP, e.d.cp_bg_line_d);
            al.j(this.bRk, e.d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.ejJ != null ? this.ejJ.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.ejJ != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.ejJ.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
