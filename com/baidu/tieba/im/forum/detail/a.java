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
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener bCn;
    private NoNetworkView dnM;
    private ForumDetailActivity gFP;
    private LinearLayout gFS;
    private CustomScrollView gFT;
    private ItemHeaderView gFU;
    private ItemInfoView gFV;
    private ItemMsgManage gFW;
    private ItemEmotionView gFX;
    private ItemHotThreadView gFY;
    private ItemFootNavView gFZ;
    private com.baidu.tbadk.core.dialog.a gGa;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.gFP = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.gFS = (LinearLayout) this.gFP.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.gFP.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gFS.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.gFP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gFP.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dnM = (NoNetworkView) this.gFP.findViewById(R.id.no_network_view);
        this.gFT = (CustomScrollView) this.gFP.findViewById(R.id.scoll_view);
        this.gFT.setOnTouchListener(new View$OnTouchListenerC0336a());
        this.gFU = (ItemHeaderView) this.gFP.findViewById(R.id.item_header);
        this.gFV = (ItemInfoView) this.gFP.findViewById(R.id.item_info);
        this.gFW = (ItemMsgManage) this.gFP.findViewById(R.id.item_msg_manage);
        this.gFX = (ItemEmotionView) this.gFP.findViewById(R.id.item_emotion_manage);
        this.gFY = (ItemHotThreadView) this.gFP.findViewById(R.id.item_hot_thread);
        this.gFZ = (ItemFootNavView) this.gFP.findViewById(R.id.item_foot_nav);
        this.gFZ.setClickable(true);
        this.mRootView = this.gFP.findViewById(R.id.root_rl);
        bDw();
        this.gFW.setMsgOnClickListener(this.gFP);
        this.gFX.setEmotionOnClickListener(this.gFP);
        this.gFW.setSwitchChangeListener(this.gFP);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.gFU.setData(recommendForumInfo);
        this.gFV.setData(recommendForumInfo);
        this.gFW.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.gFZ.setData(recommendForumInfo, this.gFP);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.gFX.setEmotionData(forumEmotionData);
    }

    public void av(List<SimpleThreadInfo> list) {
        this.gFY.setData(list);
    }

    public void brb() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bDw() {
        this.mProgressBar = new ProgressBar(this.gFP.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.gFP.getPageContext().getResources().getDrawable(R.drawable.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.gFP.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.gFP.getLayoutMode().setNightMode(i == 1);
        this.gFP.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnM.onChangeSkinType(getPageContext(), i);
        this.gFU.a(this.gFP, i);
        this.gFV.a(this.gFP, i);
        this.gFW.a(this.gFP, i);
        this.gFY.a(this.gFP, i);
        this.gFZ.a(this.gFP, i);
    }

    public void onResume() {
        this.gFZ.e(this.gFP);
    }

    public void bDx() {
        if (this.gGa == null) {
            this.gGa = new com.baidu.tbadk.core.dialog.a(this.gFP.getPageContext().getPageActivity());
            this.gGa.hu(R.string.officical_bar_info_clean_alert);
            this.gGa.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gGa.dismiss();
                    a.this.gFP.bDo();
                }
            });
            this.gGa.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gGa.dismiss();
                }
            });
        }
        this.gGa.b(getPageContext()).agK();
    }

    public NoNetworkView bDy() {
        return this.dnM;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCn = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.gFW.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gFW.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void oX(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gFP.getPageContext().getPageActivity(), this.gFS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.iN(i), null);
            this.mNoDataView.setOnClickListener(this.bCn);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(i));
        this.mNoDataView.onChangeSkinType(this.gFP.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0336a implements View.OnTouchListener {
        private View$OnTouchListenerC0336a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.gFZ.me(false);
                    break;
                case 1:
                    a.this.gFZ.me(true);
                    break;
                case 2:
                    a.this.gFZ.me(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gFZ.md(z);
        this.gFW.setShowState(recommendForumInfo, z);
    }
}
