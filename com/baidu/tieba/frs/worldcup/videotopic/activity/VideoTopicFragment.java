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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.videotopic.b.b;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoTopicFragment extends BaseFragment implements a {
    private AppBarLayout NW;
    private ImageView bLm;
    private LinearLayout bkZ;
    private PbListView btv;
    private BdTypeRecyclerView bwl;
    private NoNetworkView cRO;
    private View dFi;
    private com.baidu.tieba.frs.worldcup.videotopic.a.a dGu;
    private com.baidu.tieba.frs.worldcup.videotopic.b.a dGv;
    private ObservedChangeLinearLayout djE;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private boolean dGw = true;
    private BdListView.e dFs = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            VideoTopicFragment.this.SJ();
        }
    };
    private NoNetworkView.a cCR = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                VideoTopicFragment.this.fm(true);
            } else {
                VideoTopicFragment.this.aAe();
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.video_topic_fragment, viewGroup, false);
        aA(inflate);
        al(inflate);
        aB(inflate);
        aAf();
        aAd();
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
        this.dGu.notifyDataSetChanged();
        super.onResume();
    }

    private void init() {
        this.dGv = new b(getPageContext(), this, getArguments());
        aAc();
    }

    private void aAc() {
        aAh();
        showLoadingView(this.bkZ, true);
        fm(false);
        aAi();
        this.dGw = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (aAe() && this.dGv != null) {
            this.bwl.setSelection(0);
            this.dGv.onRefresh();
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
        hideLoadingView(this.bkZ);
        aAh();
        showNetRefreshView(this.bkZ, string, true);
    }

    private void aA(View view) {
        this.dFi = view.findViewById(d.g.statebar_view);
        if (this.dFi.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dFi.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dFi.setLayoutParams(layoutParams);
        }
    }

    public String getTopic() {
        if (getArguments() != null) {
            String string = getArguments().getString(IntentConfig.TOPIC_NAME, getResources().getString(d.k.frs_video_topic));
            if (!ao.isEmpty(string)) {
                return string;
            }
        }
        return getResources().getString(d.k.frs_video_topic);
    }

    private void al(View view) {
        this.djE = (ObservedChangeLinearLayout) view.findViewById(d.g.navigationbar_wrapper);
        this.NW = (AppBarLayout) view.findViewById(d.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getTopic());
        }
        this.bLm = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
    }

    private void aB(View view) {
        this.bkZ = (LinearLayout) view.findViewById(d.g.content_container);
        this.bwl = (BdTypeRecyclerView) view.findViewById(d.g.recycler_view);
        ((DefaultItemAnimator) this.bwl.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bwl.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bwl.setScrollable(this);
        this.bwl.setFadingEdgeLength(0);
        this.bwl.setOverScrollMode(2);
        this.bwl.setOnSrollToBottomListener(this.dFs);
        this.bwl.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.3
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(d.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(d.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
            }
        });
        this.dGu = new com.baidu.tieba.frs.worldcup.videotopic.a.a(this, this.bwl);
    }

    private void aAd() {
        this.cRO = new NoNetworkView(getActivity());
        this.cRO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cRO.a(this.cCR);
        this.djE.addView(this.cRO);
        aAe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAe() {
        if (j.jr()) {
            this.cRO.setVisibility(8);
            return true;
        }
        this.cRO.setVisibility(0);
        return false;
    }

    private void aAf() {
        this.btv = new PbListView(getActivity());
        this.btv.getView();
        this.btv.dx(d.C0141d.cp_bg_line_e);
        this.btv.setHeight(l.e(getActivity(), d.e.tbds182));
        this.btv.Ao();
        this.btv.setTextSize(d.e.tbfontsize33);
        this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
        this.btv.dw(d.C0141d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ() {
        if (aAe() && this.dGv != null) {
            aAi();
            this.bwl.stopScroll();
            this.dGv.aAE();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.activity.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        SR();
        if (d(aVar) && this.dGu != null) {
            this.dGu.setForumId(getForumId());
            this.dGu.setData(arrayList);
            this.dGu.notifyDataSetChanged();
        }
    }

    private boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.bkZ);
            aAg();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gFM) {
                string = TbadkCoreApplication.getInst().getString(d.k.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aAh();
        showNetRefreshView(this.bkZ, string, true);
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (l.jU()) {
            hideNetRefreshView(this.bkZ);
            showLoadingView(this.bkZ, true);
            fm(false);
        }
    }

    private void aAg() {
        this.bwl.setVisibility(0);
    }

    private void aAh() {
        this.bwl.setVisibility(8);
    }

    private void SR() {
        hideLoadingView(this.bkZ);
        aAg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            fm(true);
        }
    }

    private void aAi() {
        if (this.dGv == null || !l.jU()) {
            TL();
        } else if (this.dGv.hasMore()) {
            if (this.bwl.getCount() > 3) {
                TJ();
            } else {
                auA();
            }
        } else if (this.bwl.getCount() == 0 && !this.dGw) {
            TL();
        } else {
            TK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dGu != null) {
            this.dGu.onDestory();
        }
        if (this.bwl != null) {
            this.bwl.setOnSrollToBottomListener(null);
            this.bwl.setScrollable(null);
        }
        if (this.dGv != null) {
            this.dGv.onDestroy();
        }
    }

    public void TJ() {
        this.bwl.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.setOnClickListener(null);
        this.btv.Ar();
    }

    public void TK() {
        this.bwl.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.setOnClickListener(null);
        this.btv.As();
        this.btv.setText(getResources().getString(d.k.list_has_no_more));
    }

    public void auA() {
        this.bwl.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTopicFragment.this.SJ();
            }
        });
        this.btv.As();
        this.btv.setText(getResources().getString(d.k.list_click_load_more));
    }

    public void TL() {
        this.bwl.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(al.cR(d.f.s_navbar_bg));
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
                al.j(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
                ap.zp().c(this.bLm, d.f.icon_topbar_return_n_svg, d.C0141d.select_topbar_icon_color_tint);
            }
            if (this.cRO != null) {
                this.cRO.onChangeSkinType(getPageContext(), i);
            }
            if (this.dFi != null) {
                this.dFi.setBackgroundDrawable(new BitmapDrawable(al.cR(d.f.s_navbar_bg)).mutate());
            }
            if (this.cRO != null) {
                this.cRO.onChangeSkinType(getPageContext(), i);
            }
            if (this.btv != null) {
                this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
                this.btv.dy(i);
            }
            al.j(this.NW, d.C0141d.cp_bg_line_d);
            al.j(this.bwl, d.C0141d.cp_bg_line_e);
        }
    }

    public String getForumId() {
        return this.dGv != null ? this.dGv.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a058";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        return super.getCurrentPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dGv != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.dGv.getForumId(), 0L));
        }
        return pageStayDurationItem;
    }
}
