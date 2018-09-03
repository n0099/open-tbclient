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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.worldcup.videotopic.c.b;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class VideoTopicFragment extends BaseFragment implements com.baidu.tieba.frs.worldcup.videotopic.activity.a {
    private AppBarLayout NV;
    private ImageView bOp;
    private LinearLayout bnh;
    private PbListView bvC;
    private BdTypeRecyclerView byo;
    private NoNetworkView cSv;
    private View dLn;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a dMA;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a dMz;
    private ObservedChangeLinearLayout dox;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean dMB = true;
    private BdListView.e dLw = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.Tq();
        }
    };
    private NoNetworkView.a cDn = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aR(boolean z) {
            if (z) {
                VideoTopicFragment.this.fn(true);
            } else {
                VideoTopicFragment.this.aBr();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(f.h.video_topic_fragment, viewGroup, false);
        aF(inflate);
        aq(inflate);
        aG(inflate);
        aBs();
        aBq();
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
        this.dMz.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.dMA = new b(getPageContext(), this, getArguments());
        aBp();
    }

    private void aBp() {
        aBu();
        showLoadingView(this.bnh, true);
        fn(false);
        aBv();
        this.dMB = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        if (aBr() && this.dMA != null) {
            this.byo.setSelection(0);
            this.dMA.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(f.j.error_unkown_try_again);
        hideLoadingView(this.bnh);
        aBu();
        showNetRefreshView(this.bnh, string, true);
    }

    private void aF(View view) {
        this.dLn = view.findViewById(f.g.statebar_view);
        if (this.dLn.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLn.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dLn.setLayoutParams(layoutParams);
        }
    }

    public String getTopic() {
        if (getArguments() != null) {
            String string = getArguments().getString(IntentConfig.TOPIC_NAME, getResources().getString(f.j.frs_video_topic));
            if (!ap.isEmpty(string)) {
                return string;
            }
        }
        return getResources().getString(f.j.frs_video_topic);
    }

    private void aq(View view) {
        this.dox = (ObservedChangeLinearLayout) view.findViewById(f.g.navigationbar_wrapper);
        this.NV = (AppBarLayout) view.findViewById(f.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.bOp = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(f.g.widget_navi_back_button);
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
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(f.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(f.g.abstract_img_layout);
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
        this.bnh = (LinearLayout) view.findViewById(f.g.content_container);
        this.byo = (BdTypeRecyclerView) view.findViewById(f.g.recycler_view);
        ((DefaultItemAnimator) this.byo.getItemAnimator()).setSupportsChangeAnimations(false);
        this.byo.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.byo.setScrollable(this);
        this.byo.setFadingEdgeLength(0);
        this.byo.setOverScrollMode(2);
        this.byo.setOnSrollToBottomListener(this.dLw);
        this.byo.setRecyclerListener(new a());
        this.dMz = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.byo);
    }

    private void aBq() {
        this.cSv = new NoNetworkView(getActivity());
        this.cSv.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cSv.a(this.cDn);
        this.dox.addView(this.cSv);
        aBr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBr() {
        if (j.js()) {
            this.cSv.setVisibility(8);
            return true;
        }
        this.cSv.setVisibility(0);
        return false;
    }

    private void aBs() {
        this.bvC = new PbListView(getActivity());
        this.bvC.getView();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.setHeight(l.f(getActivity(), f.e.tbds182));
        this.bvC.As();
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
        this.bvC.dz(f.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tq() {
        if (aBr() && this.dMA != null) {
            aBv();
            this.byo.stopScroll();
            this.dMA.aBR();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        Ty();
        if (d(aVar) && this.dMz != null) {
            this.dMz.setForumId(getForumId());
            this.dMz.setData(arrayList);
            this.dMz.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bnh);
            aBt();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(f.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gKD) {
                string = TbadkCoreApplication.getInst().getString(f.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aBu();
        showNetRefreshView(this.bnh, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.jV()) {
            hideNetRefreshView(this.bnh);
            showLoadingView(this.bnh, true);
            fn(false);
        }
    }

    private void aBt() {
        this.byo.setVisibility(0);
    }

    private void aBu() {
        this.byo.setVisibility(8);
    }

    private void Ty() {
        hideLoadingView(this.bnh);
        aBt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            fn(true);
        }
    }

    private void aBv() {
        if (this.dMA == null || !l.jV()) {
            Uq();
        } else if (this.dMA.hasMore()) {
            if (this.byo.getCount() > 3) {
                Uo();
            } else {
                avw();
            }
        } else if (this.byo.getCount() == 0 && !this.dMB) {
            Uq();
        } else {
            Up();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dMz != null) {
            this.dMz.onDestory();
        }
        if (this.byo != null) {
            this.byo.setOnSrollToBottomListener(null);
            this.byo.setScrollable(null);
        }
        if (this.dMA != null) {
            this.dMA.onDestroy();
        }
    }

    public void Uo() {
        this.byo.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.setOnClickListener(null);
        this.bvC.Av();
    }

    public void Up() {
        this.byo.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.setOnClickListener(null);
        this.bvC.Aw();
        this.bvC.setText(getResources().getString(f.j.list_has_no_more));
    }

    public void avw() {
        this.byo.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.Tq();
            }
        });
        this.bvC.Aw();
        this.bvC.setText(getResources().getString(f.j.list_click_load_more));
    }

    public void Uq() {
        this.byo.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(am.cU(f.C0146f.s_navbar_bg));
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
                am.j(this.mNavigationBar.getBottomLine(), f.d.cp_bg_line_b);
                aq.zt().c(this.bOp, f.C0146f.icon_topbar_return_n_svg, f.d.select_topbar_icon_color_tint);
            }
            if (this.cSv != null) {
                this.cSv.onChangeSkinType(getPageContext(), i);
            }
            if (this.dLn != null) {
                this.dLn.setBackgroundDrawable(new BitmapDrawable(am.cU(f.C0146f.s_navbar_bg)).mutate());
            }
            if (this.cSv != null) {
                this.cSv.onChangeSkinType(getPageContext(), i);
            }
            if (this.bvC != null) {
                this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
                this.bvC.dB(i);
            }
            am.j(this.NV, f.d.cp_bg_line_d);
            am.j(this.byo, f.d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.dMA != null ? this.dMA.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dMA != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.dMA.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
