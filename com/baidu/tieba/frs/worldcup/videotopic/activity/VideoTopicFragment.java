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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.videotopic.c.b;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class VideoTopicFragment extends BaseFragment implements com.baidu.tieba.frs.worldcup.videotopic.activity.a {
    private AppBarLayout NV;
    private ImageView bOq;
    private LinearLayout bne;
    private PbListView bvA;
    private BdTypeRecyclerView bym;
    private NoNetworkView cSy;
    private View dLr;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a dMD;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a dME;
    private ObservedChangeLinearLayout doz;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean dMF = true;
    private BdListView.e dLA = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.Tn();
        }
    };
    private NoNetworkView.a cDq = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                VideoTopicFragment.this.fn(true);
            } else {
                VideoTopicFragment.this.aBu();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.video_topic_fragment, viewGroup, false);
        aF(inflate);
        aq(inflate);
        aG(inflate);
        aBv();
        aBt();
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
        this.dMD.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.dME = new b(getPageContext(), this, getArguments());
        aBs();
    }

    private void aBs() {
        aBx();
        showLoadingView(this.bne, true);
        fn(false);
        aBy();
        this.dMF = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        if (aBu() && this.dME != null) {
            this.bym.setSelection(0);
            this.dME.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
        hideLoadingView(this.bne);
        aBx();
        showNetRefreshView(this.bne, string, true);
    }

    private void aF(View view) {
        this.dLr = view.findViewById(d.g.statebar_view);
        if (this.dLr.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLr.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dLr.setLayoutParams(layoutParams);
        }
    }

    public String getTopic() {
        if (getArguments() != null) {
            String string = getArguments().getString(IntentConfig.TOPIC_NAME, getResources().getString(d.j.frs_video_topic));
            if (!ap.isEmpty(string)) {
                return string;
            }
        }
        return getResources().getString(d.j.frs_video_topic);
    }

    private void aq(View view) {
        this.doz = (ObservedChangeLinearLayout) view.findViewById(d.g.navigationbar_wrapper);
        this.NV = (AppBarLayout) view.findViewById(d.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.bOq = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
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
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(d.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(d.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        }
    }

    private void aG(View view) {
        this.bne = (LinearLayout) view.findViewById(d.g.content_container);
        this.bym = (BdTypeRecyclerView) view.findViewById(d.g.recycler_view);
        ((DefaultItemAnimator) this.bym.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bym.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bym.setScrollable(this);
        this.bym.setFadingEdgeLength(0);
        this.bym.setOverScrollMode(2);
        this.bym.setOnSrollToBottomListener(this.dLA);
        this.bym.setRecyclerListener(new a());
        this.dMD = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bym);
    }

    private void aBt() {
        this.cSy = new NoNetworkView(getActivity());
        this.cSy.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cSy.a(this.cDq);
        this.doz.addView(this.cSy);
        aBu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBu() {
        if (j.js()) {
            this.cSy.setVisibility(8);
            return true;
        }
        this.cSy.setVisibility(0);
        return false;
    }

    private void aBv() {
        this.bvA = new PbListView(getActivity());
        this.bvA.getView();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.setHeight(l.f(getActivity(), d.e.tbds182));
        this.bvA.Au();
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
        this.bvA.dA(d.C0140d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tn() {
        if (aBu() && this.dME != null) {
            aBy();
            this.bym.stopScroll();
            this.dME.aBU();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        Tv();
        if (d(aVar) && this.dMD != null) {
            this.dMD.setForumId(getForumId());
            this.dMD.setData(arrayList);
            this.dMD.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bne);
            aBw();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gKB) {
                string = TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aBx();
        showNetRefreshView(this.bne, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.jV()) {
            hideNetRefreshView(this.bne);
            showLoadingView(this.bne, true);
            fn(false);
        }
    }

    private void aBw() {
        this.bym.setVisibility(0);
    }

    private void aBx() {
        this.bym.setVisibility(8);
    }

    private void Tv() {
        hideLoadingView(this.bne);
        aBw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            fn(true);
        }
    }

    private void aBy() {
        if (this.dME == null || !l.jV()) {
            Un();
        } else if (this.dME.hasMore()) {
            if (this.bym.getCount() > 3) {
                Ul();
            } else {
                avx();
            }
        } else if (this.bym.getCount() == 0 && !this.dMF) {
            Un();
        } else {
            Um();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dMD != null) {
            this.dMD.onDestory();
        }
        if (this.bym != null) {
            this.bym.setOnSrollToBottomListener(null);
            this.bym.setScrollable(null);
        }
        if (this.dME != null) {
            this.dME.onDestroy();
        }
    }

    public void Ul() {
        this.bym.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.setOnClickListener(null);
        this.bvA.Ax();
    }

    public void Um() {
        this.bym.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.setOnClickListener(null);
        this.bvA.Ay();
        this.bvA.setText(getResources().getString(d.j.list_has_no_more));
    }

    public void avx() {
        this.bym.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.Tn();
            }
        });
        this.bvA.Ay();
        this.bvA.setText(getResources().getString(d.j.list_click_load_more));
    }

    public void Un() {
        this.bym.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(am.cU(d.f.s_navbar_bg));
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
                am.j(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
                aq.zv().c(this.bOq, d.f.icon_topbar_return_n_svg, d.C0140d.select_topbar_icon_color_tint);
            }
            if (this.cSy != null) {
                this.cSy.onChangeSkinType(getPageContext(), i);
            }
            if (this.dLr != null) {
                this.dLr.setBackgroundDrawable(new BitmapDrawable(am.cU(d.f.s_navbar_bg)).mutate());
            }
            if (this.cSy != null) {
                this.cSy.onChangeSkinType(getPageContext(), i);
            }
            if (this.bvA != null) {
                this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
                this.bvA.dC(i);
            }
            am.j(this.NV, d.C0140d.cp_bg_line_d);
            am.j(this.bym, d.C0140d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.dME != null ? this.dME.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dME != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.dME.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
