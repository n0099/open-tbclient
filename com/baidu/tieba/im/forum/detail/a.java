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
    private View.OnClickListener Tt;
    private NoNetworkView bla;
    private ForumDetailActivity dWN;
    private LinearLayout dWQ;
    private CustomScrollView dWR;
    private ItemHeaderView dWS;
    private ItemInfoView dWT;
    private ItemMsgManage dWU;
    private ItemEmotionView dWV;
    private ItemHotThreadView dWW;
    private ItemFootNavView dWX;
    private com.baidu.tbadk.core.dialog.a dWY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.dWN = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.dWQ = (LinearLayout) this.dWN.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.dWN.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.dWQ.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.dWN.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dWN.getPageContext().getString(d.k.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bla = (NoNetworkView) this.dWN.findViewById(d.g.no_network_view);
        this.dWR = (CustomScrollView) this.dWN.findViewById(d.g.scoll_view);
        this.dWR.setOnTouchListener(new View$OnTouchListenerC0156a());
        this.dWS = (ItemHeaderView) this.dWN.findViewById(d.g.item_header);
        this.dWT = (ItemInfoView) this.dWN.findViewById(d.g.item_info);
        this.dWU = (ItemMsgManage) this.dWN.findViewById(d.g.item_msg_manage);
        this.dWV = (ItemEmotionView) this.dWN.findViewById(d.g.item_emotion_manage);
        this.dWW = (ItemHotThreadView) this.dWN.findViewById(d.g.item_hot_thread);
        this.dWX = (ItemFootNavView) this.dWN.findViewById(d.g.item_foot_nav);
        this.dWX.setClickable(true);
        this.mRootView = this.dWN.findViewById(d.g.root_rl);
        aDF();
        this.dWU.setMsgOnClickListener(this.dWN);
        this.dWV.setEmotionOnClickListener(this.dWN);
        this.dWU.setSwitchChangeListener(this.dWN);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.dWS.setData(recommendForumInfo);
        this.dWT.setData(recommendForumInfo);
        this.dWU.setData(recommendForumInfo, z, managerApplyInfo);
        this.dWX.setData(recommendForumInfo, this.dWN);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.dWV.setEmotionData(forumEmotionData);
    }

    public void O(List<SimpleThreadInfo> list) {
        this.dWW.setData(list);
    }

    public void atM() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aDF() {
        this.mProgressBar = new ProgressBar(this.dWN.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.dWN.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.dWN.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.dWN.getLayoutMode().setNightMode(i == 1);
        this.dWN.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bla.onChangeSkinType(getPageContext(), i);
        this.dWS.a(this.dWN, i);
        this.dWT.a(this.dWN, i);
        this.dWU.a(this.dWN, i);
        this.dWW.a(this.dWN, i);
        this.dWX.a(this.dWN, i);
    }

    public void onResume() {
        this.dWX.e(this.dWN);
    }

    public void aDG() {
        if (this.dWY == null) {
            this.dWY = new com.baidu.tbadk.core.dialog.a(this.dWN.getPageContext().getPageActivity());
            this.dWY.ca(d.k.officical_bar_info_clean_alert);
            this.dWY.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.dWY.dismiss();
                    a.this.dWN.clearHistory();
                }
            });
            this.dWY.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.dWY.dismiss();
                }
            });
        }
        this.dWY.b(getPageContext()).tD();
    }

    public NoNetworkView aDH() {
        return this.bla;
    }

    public void b(View.OnClickListener onClickListener) {
        this.Tt = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.dWU.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.dWU.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ik(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dWN.getPageContext().getPageActivity(), this.dWQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.dp(i), null);
            this.mNoDataView.setOnClickListener(this.Tt);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(i));
        this.mNoDataView.onChangeSkinType(this.dWN.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.dWX.hb(false);
                    break;
                case 1:
                    a.this.dWX.hb(true);
                    break;
                case 2:
                    a.this.dWX.hb(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.dWX.ha(z);
        this.dWU.setShowState(recommendForumInfo, z);
    }
}
