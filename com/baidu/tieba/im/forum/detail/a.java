package com.baidu.tieba.im.forum.detail;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener abB;
    private NoNetworkView buT;
    private ForumDetailActivity emX;
    private LinearLayout ena;
    private CustomScrollView enb;
    private ItemHeaderView enc;
    private ItemInfoView ene;
    private ItemMsgManage enf;
    private ItemEmotionView eng;
    private ItemHotThreadView enh;
    private ItemFootNavView eni;
    private com.baidu.tbadk.core.dialog.a enj;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.emX = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.ena = (LinearLayout) this.emX.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.emX.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ena.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.emX.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.emX.getPageContext().getString(d.k.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.buT = (NoNetworkView) this.emX.findViewById(d.g.no_network_view);
        this.enb = (CustomScrollView) this.emX.findViewById(d.g.scoll_view);
        this.enb.setOnTouchListener(new View$OnTouchListenerC0174a());
        this.enc = (ItemHeaderView) this.emX.findViewById(d.g.item_header);
        this.ene = (ItemInfoView) this.emX.findViewById(d.g.item_info);
        this.enf = (ItemMsgManage) this.emX.findViewById(d.g.item_msg_manage);
        this.eng = (ItemEmotionView) this.emX.findViewById(d.g.item_emotion_manage);
        this.enh = (ItemHotThreadView) this.emX.findViewById(d.g.item_hot_thread);
        this.eni = (ItemFootNavView) this.emX.findViewById(d.g.item_foot_nav);
        this.eni.setClickable(true);
        this.mRootView = this.emX.findViewById(d.g.root_rl);
        aJf();
        this.enf.setMsgOnClickListener(this.emX);
        this.eng.setEmotionOnClickListener(this.emX);
        this.enf.setSwitchChangeListener(this.emX);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.enc.setData(recommendForumInfo);
        this.ene.setData(recommendForumInfo);
        this.enf.setData(recommendForumInfo, z, managerApplyInfo);
        this.eni.setData(recommendForumInfo, this.emX);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eng.setEmotionData(forumEmotionData);
    }

    public void S(List<SimpleThreadInfo> list) {
        this.enh.setData(list);
    }

    public void ayD() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aJf() {
        this.mProgressBar = new ProgressBar(this.emX.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.emX.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.emX.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.emX.getLayoutMode().setNightMode(i == 1);
        this.emX.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.buT.onChangeSkinType(getPageContext(), i);
        this.enc.a(this.emX, i);
        this.ene.a(this.emX, i);
        this.enf.a(this.emX, i);
        this.enh.a(this.emX, i);
        this.eni.a(this.emX, i);
    }

    public void onResume() {
        this.eni.e(this.emX);
    }

    public void aJg() {
        if (this.enj == null) {
            this.enj = new com.baidu.tbadk.core.dialog.a(this.emX.getPageContext().getPageActivity());
            this.enj.cd(d.k.officical_bar_info_clean_alert);
            this.enj.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.enj.dismiss();
                    a.this.emX.clearHistory();
                }
            });
            this.enj.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.enj.dismiss();
                }
            });
        }
        this.enj.b(getPageContext()).xn();
    }

    public NoNetworkView aJh() {
        return this.buT;
    }

    public void b(View.OnClickListener onClickListener) {
        this.abB = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.enf.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.enf.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void il(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.emX.getPageContext().getPageActivity(), this.ena, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.ds(i), null);
            this.mNoDataView.setOnClickListener(this.abB);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(i));
        this.mNoDataView.onChangeSkinType(this.emX.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0174a implements View.OnTouchListener {
        private View$OnTouchListenerC0174a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.eni.hs(false);
                    break;
                case 1:
                    a.this.eni.hs(true);
                    break;
                case 2:
                    a.this.eni.hs(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eni.hr(z);
        this.enf.setShowState(recommendForumInfo, z);
    }
}
