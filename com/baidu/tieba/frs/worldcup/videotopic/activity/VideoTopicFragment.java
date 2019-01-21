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
    private AppBarLayout QZ;
    private LinearLayout bCb;
    private PbListView bPn;
    private BdTypeRecyclerView bRZ;
    private ImageView chD;
    private ObservedChangeLinearLayout dNJ;
    private NoNetworkView drP;
    private View elU;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a eng;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a enh;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean eni = true;
    private BdListView.e emc = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.aaA();
        }
    };
    private NoNetworkView.a dcQ = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (z) {
                VideoTopicFragment.this.gm(true);
            } else {
                VideoTopicFragment.this.checkNetwork();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.video_topic_fragment, viewGroup, false);
        aY(inflate);
        aJ(inflate);
        aZ(inflate);
        aJu();
        aJt();
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
        this.eng.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.enh = new b(getPageContext(), this, getArguments());
        aJs();
    }

    private void aJs() {
        aJw();
        showLoadingView(this.bCb, true);
        gm(false);
        aJx();
        this.eni = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(boolean z) {
        if (checkNetwork() && this.enh != null) {
            this.bRZ.setSelection(0);
            this.enh.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        hideLoadingView(this.bCb);
        aJw();
        showNetRefreshView(this.bCb, string, true);
    }

    private void aY(View view) {
        this.elU = view.findViewById(e.g.statebar_view);
        if (this.elU.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.elU.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.elU.setLayoutParams(layoutParams);
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

    private void aJ(View view) {
        this.dNJ = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QZ = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.chD = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
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

    private void aZ(View view) {
        this.bCb = (LinearLayout) view.findViewById(e.g.content_container);
        this.bRZ = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bRZ.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRZ.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bRZ.setScrollable(this);
        this.bRZ.setFadingEdgeLength(0);
        this.bRZ.setOverScrollMode(2);
        this.bRZ.setOnSrollToBottomListener(this.emc);
        this.bRZ.setRecyclerListener(new a());
        this.eng = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bRZ);
    }

    private void aJt() {
        this.drP = new NoNetworkView(getActivity());
        this.drP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.drP.a(this.dcQ);
        this.dNJ.addView(this.drP);
        checkNetwork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNetwork() {
        if (j.kK()) {
            this.drP.setVisibility(8);
            return true;
        }
        this.drP.setVisibility(0);
        return false;
    }

    private void aJu() {
        this.bPn = new PbListView(getActivity());
        this.bPn.getView();
        this.bPn.ex(e.d.cp_bg_line_e);
        this.bPn.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bPn.Fm();
        this.bPn.setTextSize(e.C0210e.tbfontsize33);
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPn.ew(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (checkNetwork() && this.enh != null) {
            aJx();
            this.bRZ.stopScroll();
            this.enh.aJT();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        aaI();
        if (d(aVar) && this.eng != null) {
            this.eng.setForumId(getForumId());
            this.eng.setData(arrayList);
            this.eng.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bCb);
            aJv();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.hmh) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aJw();
        showNetRefreshView(this.bCb, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.ll()) {
            hideNetRefreshView(this.bCb);
            showLoadingView(this.bCb, true);
            gm(false);
        }
    }

    private void aJv() {
        this.bRZ.setVisibility(0);
    }

    private void aJw() {
        this.bRZ.setVisibility(8);
    }

    private void aaI() {
        hideLoadingView(this.bCb);
        aJv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            gm(true);
        }
    }

    private void aJx() {
        if (this.enh == null || !l.ll()) {
            abA();
        } else if (this.enh.hasMore()) {
            if (this.bRZ.getCount() > 3) {
                aby();
            } else {
                aDf();
            }
        } else if (this.bRZ.getCount() == 0 && !this.eni) {
            abA();
        } else {
            abz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eng != null) {
            this.eng.onDestory();
        }
        if (this.bRZ != null) {
            this.bRZ.setOnSrollToBottomListener(null);
            this.bRZ.setScrollable(null);
        }
        if (this.enh != null) {
            this.enh.onDestroy();
        }
    }

    public void aby() {
        this.bRZ.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.setOnClickListener(null);
        this.bPn.Fp();
    }

    public void abz() {
        this.bRZ.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.setOnClickListener(null);
        this.bPn.Fq();
        this.bPn.setText(getResources().getString(e.j.list_has_no_more));
    }

    public void aDf() {
        this.bRZ.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.aaA();
            }
        });
        this.bPn.Fq();
        this.bPn.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void abA() {
        this.bRZ.setNextPage(null);
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
                ap.Ed().c(this.chD, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
            }
            if (this.drP != null) {
                this.drP.onChangeSkinType(getPageContext(), i);
            }
            if (this.elU != null) {
                this.elU.setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
            }
            if (this.drP != null) {
                this.drP.onChangeSkinType(getPageContext(), i);
            }
            if (this.bPn != null) {
                this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bPn.ey(i);
            }
            al.j(this.QZ, e.d.cp_bg_line_d);
            al.j(this.bRZ, e.d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.enh != null ? this.enh.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.enh != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.enh.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
