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
/* loaded from: classes2.dex */
public class VideoTopicFragment extends BaseFragment implements com.baidu.tieba.frs.worldcup.videotopic.activity.a {
    private AppBarLayout NY;
    private ImageView bNv;
    private LinearLayout bmy;
    private PbListView buU;
    private BdTypeRecyclerView bxH;
    private NoNetworkView cPM;
    private View dIC;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a dJN;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a dJO;
    private ObservedChangeLinearLayout dlH;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean dJP = true;
    private BdListView.e dIL = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.Tf();
        }
    };
    private NoNetworkView.a cAL = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aS(boolean z) {
            if (z) {
                VideoTopicFragment.this.fm(true);
            } else {
                VideoTopicFragment.this.aAL();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.video_topic_fragment, viewGroup, false);
        aC(inflate);
        an(inflate);
        aD(inflate);
        aAM();
        aAK();
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
        this.dJN.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.dJO = new b(getPageContext(), this, getArguments());
        aAJ();
    }

    private void aAJ() {
        aAO();
        showLoadingView(this.bmy, true);
        fm(false);
        aAP();
        this.dJP = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (aAL() && this.dJO != null) {
            this.bxH.setSelection(0);
            this.dJO.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
        hideLoadingView(this.bmy);
        aAO();
        showNetRefreshView(this.bmy, string, true);
    }

    private void aC(View view) {
        this.dIC = view.findViewById(d.g.statebar_view);
        if (this.dIC.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIC.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dIC.setLayoutParams(layoutParams);
        }
    }

    public String getTopic() {
        if (getArguments() != null) {
            String string = getArguments().getString(IntentConfig.TOPIC_NAME, getResources().getString(d.k.frs_video_topic));
            if (!ap.isEmpty(string)) {
                return string;
            }
        }
        return getResources().getString(d.k.frs_video_topic);
    }

    private void an(View view) {
        this.dlH = (ObservedChangeLinearLayout) view.findViewById(d.g.navigationbar_wrapper);
        this.NY = (AppBarLayout) view.findViewById(d.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.bNv = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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

    private void aD(View view) {
        this.bmy = (LinearLayout) view.findViewById(d.g.content_container);
        this.bxH = (BdTypeRecyclerView) view.findViewById(d.g.recycler_view);
        ((DefaultItemAnimator) this.bxH.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bxH.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bxH.setScrollable(this);
        this.bxH.setFadingEdgeLength(0);
        this.bxH.setOverScrollMode(2);
        this.bxH.setOnSrollToBottomListener(this.dIL);
        this.bxH.setRecyclerListener(new a());
        this.dJN = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bxH);
    }

    private void aAK() {
        this.cPM = new NoNetworkView(getActivity());
        this.cPM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cPM.a(this.cAL);
        this.dlH.addView(this.cPM);
        aAL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAL() {
        if (j.jr()) {
            this.cPM.setVisibility(8);
            return true;
        }
        this.cPM.setVisibility(0);
        return false;
    }

    private void aAM() {
        this.buU = new PbListView(getActivity());
        this.buU.getView();
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.setHeight(l.e(getActivity(), d.e.tbds182));
        this.buU.AE();
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
        this.buU.dx(d.C0142d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        if (aAL() && this.dJO != null) {
            aAP();
            this.bxH.stopScroll();
            this.dJO.aBl();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        Tn();
        if (d(aVar) && this.dJN != null) {
            this.dJN.setForumId(getForumId());
            this.dJN.setData(arrayList);
            this.dJN.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bmy);
            aAN();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gJF) {
                string = TbadkCoreApplication.getInst().getString(d.k.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aAO();
        showNetRefreshView(this.bmy, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.jU()) {
            hideNetRefreshView(this.bmy);
            showLoadingView(this.bmy, true);
            fm(false);
        }
    }

    private void aAN() {
        this.bxH.setVisibility(0);
    }

    private void aAO() {
        this.bxH.setVisibility(8);
    }

    private void Tn() {
        hideLoadingView(this.bmy);
        aAN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            fm(true);
        }
    }

    private void aAP() {
        if (this.dJO == null || !l.jU()) {
            Uf();
        } else if (this.dJO.hasMore()) {
            if (this.bxH.getCount() > 3) {
                Ud();
            } else {
                auT();
            }
        } else if (this.bxH.getCount() == 0 && !this.dJP) {
            Uf();
        } else {
            Ue();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dJN != null) {
            this.dJN.onDestory();
        }
        if (this.bxH != null) {
            this.bxH.setOnSrollToBottomListener(null);
            this.bxH.setScrollable(null);
        }
        if (this.dJO != null) {
            this.dJO.onDestroy();
        }
    }

    public void Ud() {
        this.bxH.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.setOnClickListener(null);
        this.buU.AH();
    }

    public void Ue() {
        this.bxH.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.setOnClickListener(null);
        this.buU.AI();
        this.buU.setText(getResources().getString(d.k.list_has_no_more));
    }

    public void auT() {
        this.bxH.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.Tf();
            }
        });
        this.buU.AI();
        this.buU.setText(getResources().getString(d.k.list_click_load_more));
    }

    public void Uf() {
        this.bxH.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(am.cS(d.f.s_navbar_bg));
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
                am.j(this.mNavigationBar.getBottomLine(), d.C0142d.cp_bg_line_b);
                aq.zE().c(this.bNv, d.f.icon_topbar_return_n_svg, d.C0142d.select_topbar_icon_color_tint);
            }
            if (this.cPM != null) {
                this.cPM.onChangeSkinType(getPageContext(), i);
            }
            if (this.dIC != null) {
                this.dIC.setBackgroundDrawable(new BitmapDrawable(am.cS(d.f.s_navbar_bg)).mutate());
            }
            if (this.cPM != null) {
                this.cPM.onChangeSkinType(getPageContext(), i);
            }
            if (this.buU != null) {
                this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
                this.buU.dz(i);
            }
            am.j(this.NY, d.C0142d.cp_bg_line_d);
            am.j(this.bxH, d.C0142d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.dJO != null ? this.dJO.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dJO != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.dJO.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
