package com.baidu.tieba.im.forum.detail;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes13.dex */
public class a extends c<ForumDetailActivity> {
    public static final int ikh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dkt;
    private NoNetworkView ePl;
    private ForumDetailActivity ijV;
    private LinearLayout ijY;
    private CustomScrollView ijZ;
    private ItemHeaderView ika;
    private ItemInfoView ikb;
    private ItemMsgManage ikc;
    private ItemEmotionView ikd;
    private ItemHotThreadView ike;
    private ItemFootNavView ikf;
    private com.baidu.tbadk.core.dialog.a ikg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.ijV = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.ijY = (LinearLayout) this.ijV.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.ijV.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ijY.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.ijV.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ijV.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.ePl = (NoNetworkView) this.ijV.findViewById(R.id.no_network_view);
        this.ijZ = (CustomScrollView) this.ijV.findViewById(R.id.scoll_view);
        this.ijZ.setOnTouchListener(new View$OnTouchListenerC0567a());
        this.ika = (ItemHeaderView) this.ijV.findViewById(R.id.item_header);
        this.ikb = (ItemInfoView) this.ijV.findViewById(R.id.item_info);
        this.ikc = (ItemMsgManage) this.ijV.findViewById(R.id.item_msg_manage);
        this.ikd = (ItemEmotionView) this.ijV.findViewById(R.id.item_emotion_manage);
        this.ike = (ItemHotThreadView) this.ijV.findViewById(R.id.item_hot_thread);
        this.ikf = (ItemFootNavView) this.ijV.findViewById(R.id.item_foot_nav);
        this.ikf.setClickable(true);
        this.mRootView = this.ijV.findViewById(R.id.root_rl);
        this.ikc.setMsgOnClickListener(this.ijV);
        this.ikd.setEmotionOnClickListener(this.ijV);
        this.ikc.setSwitchChangeListener(this.ijV);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.ika.setData(recommendForumInfo);
        this.ikb.setData(recommendForumInfo);
        this.ikc.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.ikf.setData(recommendForumInfo, this.ijV);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.ikd.setEmotionData(forumEmotionData);
    }

    public void bd(List<SimpleThreadInfo> list) {
        this.ike.setData(list);
    }

    public void asi() {
        this.ijV.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.ijV.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.ijV.getLayoutMode().setNightMode(i == 1);
        this.ijV.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ePl.onChangeSkinType(getPageContext(), i);
        this.ika.a(this.ijV, i);
        this.ikb.a(this.ijV, i);
        this.ikc.a(this.ijV, i);
        this.ike.a(this.ijV, i);
        this.ikf.a(this.ijV, i);
    }

    public void onResume() {
        this.ikf.e(this.ijV);
    }

    public void cfM() {
        if (this.ikg == null) {
            this.ikg = new com.baidu.tbadk.core.dialog.a(this.ijV.getPageContext().getPageActivity());
            this.ikg.kd(R.string.officical_bar_info_clean_alert);
            this.ikg.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ikg.dismiss();
                    a.this.ijV.clearHistory();
                }
            });
            this.ikg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ikg.dismiss();
                }
            });
        }
        this.ikg.b(getPageContext()).aMU();
    }

    public NoNetworkView cfN() {
        return this.ePl;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkt = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.ikc.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ikc.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void wU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ijV.getPageContext().getPageActivity(), this.ijY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, ikh), NoDataViewFactory.d.cK(null, this.ijV.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dkt);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, this.ijV.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.ijV.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class View$OnTouchListenerC0567a implements View.OnTouchListener {
        private View$OnTouchListenerC0567a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.ikf.oH(false);
                    break;
                case 1:
                    a.this.ikf.oH(true);
                    break;
                case 2:
                    a.this.ikf.oH(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ikf.oG(z);
        this.ikc.setShowState(recommendForumInfo, z);
    }
}
