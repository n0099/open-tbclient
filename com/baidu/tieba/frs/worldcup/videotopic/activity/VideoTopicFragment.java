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
    private LinearLayout bBn;
    private PbListView bOB;
    private BdTypeRecyclerView bRn;
    private ImageView cgR;
    private ObservedChangeLinearLayout dMZ;
    private NoNetworkView drf;
    private View eln;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a emy;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a emz;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean emA = true;
    private BdListView.e elv = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.aad();
        }
    };
    private NoNetworkView.a dcc = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                VideoTopicFragment.this.gj(true);
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
        aIW();
        aIV();
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
        this.emy.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.emz = new b(getPageContext(), this, getArguments());
        aIU();
    }

    private void aIU() {
        aIY();
        showLoadingView(this.bBn, true);
        gj(false);
        aIZ();
        this.emA = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(boolean z) {
        if (checkNetwork() && this.emz != null) {
            this.bRn.setSelection(0);
            this.emz.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        hideLoadingView(this.bBn);
        aIY();
        showNetRefreshView(this.bBn, string, true);
    }

    private void aY(View view) {
        this.eln = view.findViewById(e.g.statebar_view);
        if (this.eln.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eln.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.eln.setLayoutParams(layoutParams);
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
        this.dMZ = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QP = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.cgR = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
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
        this.bBn = (LinearLayout) view.findViewById(e.g.content_container);
        this.bRn = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bRn.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRn.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bRn.setScrollable(this);
        this.bRn.setFadingEdgeLength(0);
        this.bRn.setOverScrollMode(2);
        this.bRn.setOnSrollToBottomListener(this.elv);
        this.bRn.setRecyclerListener(new a());
        this.emy = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bRn);
    }

    private void aIV() {
        this.drf = new NoNetworkView(getActivity());
        this.drf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.drf.a(this.dcc);
        this.dMZ.addView(this.drf);
        checkNetwork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNetwork() {
        if (j.kK()) {
            this.drf.setVisibility(8);
            return true;
        }
        this.drf.setVisibility(0);
        return false;
    }

    private void aIW() {
        this.bOB = new PbListView(getActivity());
        this.bOB.getView();
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bOB.EZ();
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOB.ew(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aad() {
        if (checkNetwork() && this.emz != null) {
            aIZ();
            this.bRn.stopScroll();
            this.emz.aJv();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        aal();
        if (d(aVar) && this.emy != null) {
            this.emy.setForumId(getForumId());
            this.emy.setData(arrayList);
            this.emy.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bBn);
            aIX();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.hlc) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aIY();
        showNetRefreshView(this.bBn, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.ll()) {
            hideNetRefreshView(this.bBn);
            showLoadingView(this.bBn, true);
            gj(false);
        }
    }

    private void aIX() {
        this.bRn.setVisibility(0);
    }

    private void aIY() {
        this.bRn.setVisibility(8);
    }

    private void aal() {
        hideLoadingView(this.bBn);
        aIX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            gj(true);
        }
    }

    private void aIZ() {
        if (this.emz == null || !l.ll()) {
            abd();
        } else if (this.emz.hasMore()) {
            if (this.bRn.getCount() > 3) {
                abb();
            } else {
                aCI();
            }
        } else if (this.bRn.getCount() == 0 && !this.emA) {
            abd();
        } else {
            abc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.emy != null) {
            this.emy.onDestory();
        }
        if (this.bRn != null) {
            this.bRn.setOnSrollToBottomListener(null);
            this.bRn.setScrollable(null);
        }
        if (this.emz != null) {
            this.emz.onDestroy();
        }
    }

    public void abb() {
        this.bRn.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.setOnClickListener(null);
        this.bOB.Fc();
    }

    public void abc() {
        this.bRn.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.setOnClickListener(null);
        this.bOB.Fd();
        this.bOB.setText(getResources().getString(e.j.list_has_no_more));
    }

    public void aCI() {
        this.bRn.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.aad();
            }
        });
        this.bOB.Fd();
        this.bOB.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void abd() {
        this.bRn.setNextPage(null);
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
                ap.DQ().c(this.cgR, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
            }
            if (this.drf != null) {
                this.drf.onChangeSkinType(getPageContext(), i);
            }
            if (this.eln != null) {
                this.eln.setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
            }
            if (this.drf != null) {
                this.drf.onChangeSkinType(getPageContext(), i);
            }
            if (this.bOB != null) {
                this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bOB.ey(i);
            }
            al.j(this.QP, e.d.cp_bg_line_d);
            al.j(this.bRn, e.d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.emz != null ? this.emz.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.emz != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.emz.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
