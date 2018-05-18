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
    private View.OnClickListener Tp;
    private NoNetworkView blp;
    private ForumDetailActivity dXR;
    private LinearLayout dXU;
    private CustomScrollView dXV;
    private ItemHeaderView dXW;
    private ItemInfoView dXX;
    private ItemMsgManage dXY;
    private ItemEmotionView dXZ;
    private ItemHotThreadView dYa;
    private ItemFootNavView dYb;
    private com.baidu.tbadk.core.dialog.a dYc;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.dXR = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.dXU = (LinearLayout) this.dXR.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.dXR.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.dXU.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.dXR.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dXR.getPageContext().getString(d.k.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.blp = (NoNetworkView) this.dXR.findViewById(d.g.no_network_view);
        this.dXV = (CustomScrollView) this.dXR.findViewById(d.g.scoll_view);
        this.dXV.setOnTouchListener(new View$OnTouchListenerC0156a());
        this.dXW = (ItemHeaderView) this.dXR.findViewById(d.g.item_header);
        this.dXX = (ItemInfoView) this.dXR.findViewById(d.g.item_info);
        this.dXY = (ItemMsgManage) this.dXR.findViewById(d.g.item_msg_manage);
        this.dXZ = (ItemEmotionView) this.dXR.findViewById(d.g.item_emotion_manage);
        this.dYa = (ItemHotThreadView) this.dXR.findViewById(d.g.item_hot_thread);
        this.dYb = (ItemFootNavView) this.dXR.findViewById(d.g.item_foot_nav);
        this.dYb.setClickable(true);
        this.mRootView = this.dXR.findViewById(d.g.root_rl);
        aDD();
        this.dXY.setMsgOnClickListener(this.dXR);
        this.dXZ.setEmotionOnClickListener(this.dXR);
        this.dXY.setSwitchChangeListener(this.dXR);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.dXW.setData(recommendForumInfo);
        this.dXX.setData(recommendForumInfo);
        this.dXY.setData(recommendForumInfo, z, managerApplyInfo);
        this.dYb.setData(recommendForumInfo, this.dXR);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.dXZ.setEmotionData(forumEmotionData);
    }

    public void O(List<SimpleThreadInfo> list) {
        this.dYa.setData(list);
    }

    public void atL() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aDD() {
        this.mProgressBar = new ProgressBar(this.dXR.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.dXR.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.dXR.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.dXR.getLayoutMode().setNightMode(i == 1);
        this.dXR.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.blp.onChangeSkinType(getPageContext(), i);
        this.dXW.a(this.dXR, i);
        this.dXX.a(this.dXR, i);
        this.dXY.a(this.dXR, i);
        this.dYa.a(this.dXR, i);
        this.dYb.a(this.dXR, i);
    }

    public void onResume() {
        this.dYb.e(this.dXR);
    }

    public void aDE() {
        if (this.dYc == null) {
            this.dYc = new com.baidu.tbadk.core.dialog.a(this.dXR.getPageContext().getPageActivity());
            this.dYc.ca(d.k.officical_bar_info_clean_alert);
            this.dYc.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.dYc.dismiss();
                    a.this.dXR.clearHistory();
                }
            });
            this.dYc.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.dYc.dismiss();
                }
            });
        }
        this.dYc.b(getPageContext()).tC();
    }

    public NoNetworkView aDF() {
        return this.blp;
    }

    public void b(View.OnClickListener onClickListener) {
        this.Tp = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.dXY.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.dXY.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ii(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dXR.getPageContext().getPageActivity(), this.dXU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.dp(i), null);
            this.mNoDataView.setOnClickListener(this.Tp);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(i));
        this.mNoDataView.onChangeSkinType(this.dXR.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0156a implements View.OnTouchListener {
        private View$OnTouchListenerC0156a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.dYb.hc(false);
                    break;
                case 1:
                    a.this.dYb.hc(true);
                    break;
                case 2:
                    a.this.dYb.hc(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.dYb.hb(z);
        this.dXY.setShowState(recommendForumInfo, z);
    }
}
