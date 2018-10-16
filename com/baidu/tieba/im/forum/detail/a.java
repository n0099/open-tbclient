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
import com.baidu.tieba.e;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener aiF;
    private NoNetworkView bJX;
    private ForumDetailActivity eFR;
    private LinearLayout eFU;
    private CustomScrollView eFV;
    private ItemHeaderView eFW;
    private ItemInfoView eFX;
    private ItemMsgManage eFY;
    private ItemEmotionView eFZ;
    private ItemHotThreadView eGa;
    private ItemFootNavView eGb;
    private com.baidu.tbadk.core.dialog.a eGc;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eFR = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eFU = (LinearLayout) this.eFR.findViewById(e.g.scoll_view_ll);
        TextView textView = new TextView(this.eFR.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eFU.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eFR.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eFR.getPageContext().getString(e.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bJX = (NoNetworkView) this.eFR.findViewById(e.g.no_network_view);
        this.eFV = (CustomScrollView) this.eFR.findViewById(e.g.scoll_view);
        this.eFV.setOnTouchListener(new View$OnTouchListenerC0209a());
        this.eFW = (ItemHeaderView) this.eFR.findViewById(e.g.item_header);
        this.eFX = (ItemInfoView) this.eFR.findViewById(e.g.item_info);
        this.eFY = (ItemMsgManage) this.eFR.findViewById(e.g.item_msg_manage);
        this.eFZ = (ItemEmotionView) this.eFR.findViewById(e.g.item_emotion_manage);
        this.eGa = (ItemHotThreadView) this.eFR.findViewById(e.g.item_hot_thread);
        this.eGb = (ItemFootNavView) this.eFR.findViewById(e.g.item_foot_nav);
        this.eGb.setClickable(true);
        this.mRootView = this.eFR.findViewById(e.g.root_rl);
        aPH();
        this.eFY.setMsgOnClickListener(this.eFR);
        this.eFZ.setEmotionOnClickListener(this.eFR);
        this.eFY.setSwitchChangeListener(this.eFR);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eFW.setData(recommendForumInfo);
        this.eFX.setData(recommendForumInfo);
        this.eFY.setData(recommendForumInfo, z, managerApplyInfo);
        this.eGb.setData(recommendForumInfo, this.eFR);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eFZ.setEmotionData(forumEmotionData);
    }

    public void ab(List<SimpleThreadInfo> list) {
        this.eGa.setData(list);
    }

    public void aEH() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aPH() {
        this.mProgressBar = new ProgressBar(this.eFR.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eFR.getPageContext().getResources().getDrawable(e.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eFR.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eFR.getLayoutMode().setNightMode(i == 1);
        this.eFR.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bJX.onChangeSkinType(getPageContext(), i);
        this.eFW.a(this.eFR, i);
        this.eFX.a(this.eFR, i);
        this.eFY.a(this.eFR, i);
        this.eGa.a(this.eFR, i);
        this.eGb.a(this.eFR, i);
    }

    public void onResume() {
        this.eGb.e(this.eFR);
    }

    public void aPI() {
        if (this.eGc == null) {
            this.eGc = new com.baidu.tbadk.core.dialog.a(this.eFR.getPageContext().getPageActivity());
            this.eGc.cz(e.j.officical_bar_info_clean_alert);
            this.eGc.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eGc.dismiss();
                    a.this.eFR.clearHistory();
                }
            });
            this.eGc.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eGc.dismiss();
                }
            });
        }
        this.eGc.b(getPageContext()).Au();
    }

    public NoNetworkView aPJ() {
        return this.bJX;
    }

    public void b(View.OnClickListener onClickListener) {
        this.aiF = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eFY.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eFY.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void jq(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eFR.getPageContext().getPageActivity(), this.eFU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.dO(i), null);
            this.mNoDataView.setOnClickListener(this.aiF);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(i));
        this.mNoDataView.onChangeSkinType(this.eFR.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0209a implements View.OnTouchListener {
        private View$OnTouchListenerC0209a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.eGb.il(false);
                    break;
                case 1:
                    a.this.eGb.il(true);
                    break;
                case 2:
                    a.this.eGb.il(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eGb.ik(z);
        this.eFY.setShowState(recommendForumInfo, z);
    }
}
