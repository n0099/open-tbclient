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
    private LinearLayout bCa;
    private PbListView bPm;
    private BdTypeRecyclerView bRY;
    private ImageView chC;
    private ObservedChangeLinearLayout dNI;
    private NoNetworkView drO;
    private View elT;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a enf;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a eng;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean enh = true;
    private BdListView.e emb = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.aaA();
        }
    };
    private NoNetworkView.a dcP = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
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
        this.enf.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.eng = new b(getPageContext(), this, getArguments());
        aJs();
    }

    private void aJs() {
        aJw();
        showLoadingView(this.bCa, true);
        gm(false);
        aJx();
        this.enh = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(boolean z) {
        if (checkNetwork() && this.eng != null) {
            this.bRY.setSelection(0);
            this.eng.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        hideLoadingView(this.bCa);
        aJw();
        showNetRefreshView(this.bCa, string, true);
    }

    private void aY(View view) {
        this.elT = view.findViewById(e.g.statebar_view);
        if (this.elT.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.elT.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.elT.setLayoutParams(layoutParams);
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
        this.dNI = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QZ = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.chC = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
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
        this.bCa = (LinearLayout) view.findViewById(e.g.content_container);
        this.bRY = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bRY.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRY.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bRY.setScrollable(this);
        this.bRY.setFadingEdgeLength(0);
        this.bRY.setOverScrollMode(2);
        this.bRY.setOnSrollToBottomListener(this.emb);
        this.bRY.setRecyclerListener(new a());
        this.enf = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bRY);
    }

    private void aJt() {
        this.drO = new NoNetworkView(getActivity());
        this.drO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.drO.a(this.dcP);
        this.dNI.addView(this.drO);
        checkNetwork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNetwork() {
        if (j.kK()) {
            this.drO.setVisibility(8);
            return true;
        }
        this.drO.setVisibility(0);
        return false;
    }

    private void aJu() {
        this.bPm = new PbListView(getActivity());
        this.bPm.getView();
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bPm.Fm();
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPm.ew(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (checkNetwork() && this.eng != null) {
            aJx();
            this.bRY.stopScroll();
            this.eng.aJT();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        aaI();
        if (d(aVar) && this.enf != null) {
            this.enf.setForumId(getForumId());
            this.enf.setData(arrayList);
            this.enf.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bCa);
            aJv();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.hmg) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aJw();
        showNetRefreshView(this.bCa, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.ll()) {
            hideNetRefreshView(this.bCa);
            showLoadingView(this.bCa, true);
            gm(false);
        }
    }

    private void aJv() {
        this.bRY.setVisibility(0);
    }

    private void aJw() {
        this.bRY.setVisibility(8);
    }

    private void aaI() {
        hideLoadingView(this.bCa);
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
        if (this.eng == null || !l.ll()) {
            abA();
        } else if (this.eng.hasMore()) {
            if (this.bRY.getCount() > 3) {
                aby();
            } else {
                aDf();
            }
        } else if (this.bRY.getCount() == 0 && !this.enh) {
            abA();
        } else {
            abz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.enf != null) {
            this.enf.onDestory();
        }
        if (this.bRY != null) {
            this.bRY.setOnSrollToBottomListener(null);
            this.bRY.setScrollable(null);
        }
        if (this.eng != null) {
            this.eng.onDestroy();
        }
    }

    public void aby() {
        this.bRY.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.setOnClickListener(null);
        this.bPm.Fp();
    }

    public void abz() {
        this.bRY.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.setOnClickListener(null);
        this.bPm.Fq();
        this.bPm.setText(getResources().getString(e.j.list_has_no_more));
    }

    public void aDf() {
        this.bRY.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.aaA();
            }
        });
        this.bPm.Fq();
        this.bPm.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void abA() {
        this.bRY.setNextPage(null);
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
                ap.Ed().c(this.chC, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
            }
            if (this.drO != null) {
                this.drO.onChangeSkinType(getPageContext(), i);
            }
            if (this.elT != null) {
                this.elT.setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
            }
            if (this.drO != null) {
                this.drO.onChangeSkinType(getPageContext(), i);
            }
            if (this.bPm != null) {
                this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bPm.ey(i);
            }
            al.j(this.QZ, e.d.cp_bg_line_d);
            al.j(this.bRY, e.d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.eng != null ? this.eng.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eng != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.eng.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
