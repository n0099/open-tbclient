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
    private AppBarLayout Qy;
    private PbListView bBr;
    private BdTypeRecyclerView bEd;
    private ImageView bUe;
    private LinearLayout bsV;
    private NoNetworkView cYm;
    private View dSF;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a dTR;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a dTS;
    private ObservedChangeLinearLayout duu;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean dTT = true;
    private BdListView.e dSO = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.Vd();
        }
    };
    private NoNetworkView.a cJe = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bd(boolean z) {
            if (z) {
                VideoTopicFragment.this.fE(true);
            } else {
                VideoTopicFragment.this.aDE();
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
        aDF();
        aDD();
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
        this.dTR.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.dTS = new b(getPageContext(), this, getArguments());
        aDC();
    }

    private void aDC() {
        aDH();
        showLoadingView(this.bsV, true);
        fE(false);
        aDI();
        this.dTT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(boolean z) {
        if (aDE() && this.dTS != null) {
            this.bEd.setSelection(0);
            this.dTS.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        hideLoadingView(this.bsV);
        aDH();
        showNetRefreshView(this.bsV, string, true);
    }

    private void aT(View view) {
        this.dSF = view.findViewById(e.g.statebar_view);
        if (this.dSF.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dSF.setLayoutParams(layoutParams);
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
        this.duu = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.Qy = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.bUe = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
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
        this.bsV = (LinearLayout) view.findViewById(e.g.content_container);
        this.bEd = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bEd.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bEd.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bEd.setScrollable(this);
        this.bEd.setFadingEdgeLength(0);
        this.bEd.setOverScrollMode(2);
        this.bEd.setOnSrollToBottomListener(this.dSO);
        this.bEd.setRecyclerListener(new a());
        this.dTR = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bEd);
    }

    private void aDD() {
        this.cYm = new NoNetworkView(getActivity());
        this.cYm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cYm.a(this.cJe);
        this.duu.addView(this.cYm);
        aDE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDE() {
        if (j.ky()) {
            this.cYm.setVisibility(8);
            return true;
        }
        this.cYm.setVisibility(0);
        return false;
    }

    private void aDF() {
        this.bBr = new PbListView(getActivity());
        this.bBr.getView();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.setHeight(l.h(getActivity(), e.C0141e.tbds182));
        this.bBr.BF();
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bBr.dK(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        if (aDE() && this.dTS != null) {
            aDI();
            this.bEd.stopScroll();
            this.dTS.aEe();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        Vl();
        if (d(aVar) && this.dTR != null) {
            this.dTR.setForumId(getForumId());
            this.dTR.setData(arrayList);
            this.dTR.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bsV);
            aDG();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gSe) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aDH();
        showNetRefreshView(this.bsV, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.lb()) {
            hideNetRefreshView(this.bsV);
            showLoadingView(this.bsV, true);
            fE(false);
        }
    }

    private void aDG() {
        this.bEd.setVisibility(0);
    }

    private void aDH() {
        this.bEd.setVisibility(8);
    }

    private void Vl() {
        hideLoadingView(this.bsV);
        aDG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            fE(true);
        }
    }

    private void aDI() {
        if (this.dTS == null || !l.lb()) {
            Wd();
        } else if (this.dTS.hasMore()) {
            if (this.bEd.getCount() > 3) {
                Wb();
            } else {
                axq();
            }
        } else if (this.bEd.getCount() == 0 && !this.dTT) {
            Wd();
        } else {
            Wc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dTR != null) {
            this.dTR.onDestory();
        }
        if (this.bEd != null) {
            this.bEd.setOnSrollToBottomListener(null);
            this.bEd.setScrollable(null);
        }
        if (this.dTS != null) {
            this.dTS.onDestroy();
        }
    }

    public void Wb() {
        this.bEd.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.setOnClickListener(null);
        this.bBr.BI();
    }

    public void Wc() {
        this.bEd.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.setOnClickListener(null);
        this.bBr.BJ();
        this.bBr.setText(getResources().getString(e.j.list_has_no_more));
    }

    public void axq() {
        this.bEd.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.Vd();
            }
        });
        this.bBr.BJ();
        this.bBr.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void Wd() {
        this.bEd.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dd(e.f.s_navbar_bg));
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
                al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                ap.Ay().c(this.bUe, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
            }
            if (this.cYm != null) {
                this.cYm.onChangeSkinType(getPageContext(), i);
            }
            if (this.dSF != null) {
                this.dSF.setBackgroundDrawable(new BitmapDrawable(al.dd(e.f.s_navbar_bg)).mutate());
            }
            if (this.cYm != null) {
                this.cYm.onChangeSkinType(getPageContext(), i);
            }
            if (this.bBr != null) {
                this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bBr.dM(i);
            }
            al.j(this.Qy, e.d.cp_bg_line_d);
            al.j(this.bEd, e.d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.dTS != null ? this.dTS.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dTS != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.dTS.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
