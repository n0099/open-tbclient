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
    public static final int ikn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dkx;
    private NoNetworkView ePq;
    private ForumDetailActivity ikb;
    private LinearLayout ike;
    private CustomScrollView ikf;
    private ItemHeaderView ikg;
    private ItemInfoView ikh;
    private ItemMsgManage iki;
    private ItemEmotionView ikj;
    private ItemHotThreadView ikk;
    private ItemFootNavView ikl;
    private com.baidu.tbadk.core.dialog.a ikm;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.ikb = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.ike = (LinearLayout) this.ikb.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.ikb.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ike.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.ikb.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ikb.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.ePq = (NoNetworkView) this.ikb.findViewById(R.id.no_network_view);
        this.ikf = (CustomScrollView) this.ikb.findViewById(R.id.scoll_view);
        this.ikf.setOnTouchListener(new View$OnTouchListenerC0588a());
        this.ikg = (ItemHeaderView) this.ikb.findViewById(R.id.item_header);
        this.ikh = (ItemInfoView) this.ikb.findViewById(R.id.item_info);
        this.iki = (ItemMsgManage) this.ikb.findViewById(R.id.item_msg_manage);
        this.ikj = (ItemEmotionView) this.ikb.findViewById(R.id.item_emotion_manage);
        this.ikk = (ItemHotThreadView) this.ikb.findViewById(R.id.item_hot_thread);
        this.ikl = (ItemFootNavView) this.ikb.findViewById(R.id.item_foot_nav);
        this.ikl.setClickable(true);
        this.mRootView = this.ikb.findViewById(R.id.root_rl);
        this.iki.setMsgOnClickListener(this.ikb);
        this.ikj.setEmotionOnClickListener(this.ikb);
        this.iki.setSwitchChangeListener(this.ikb);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.ikg.setData(recommendForumInfo);
        this.ikh.setData(recommendForumInfo);
        this.iki.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.ikl.setData(recommendForumInfo, this.ikb);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.ikj.setEmotionData(forumEmotionData);
    }

    public void bd(List<SimpleThreadInfo> list) {
        this.ikk.setData(list);
    }

    public void ash() {
        this.ikb.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.ikb.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.ikb.getLayoutMode().setNightMode(i == 1);
        this.ikb.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ePq.onChangeSkinType(getPageContext(), i);
        this.ikg.a(this.ikb, i);
        this.ikh.a(this.ikb, i);
        this.iki.a(this.ikb, i);
        this.ikk.a(this.ikb, i);
        this.ikl.a(this.ikb, i);
    }

    public void onResume() {
        this.ikl.e(this.ikb);
    }

    public void cfK() {
        if (this.ikm == null) {
            this.ikm = new com.baidu.tbadk.core.dialog.a(this.ikb.getPageContext().getPageActivity());
            this.ikm.kd(R.string.officical_bar_info_clean_alert);
            this.ikm.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ikm.dismiss();
                    a.this.ikb.clearHistory();
                }
            });
            this.ikm.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ikm.dismiss();
                }
            });
        }
        this.ikm.b(getPageContext()).aMS();
    }

    public NoNetworkView cfL() {
        return this.ePq;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkx = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.iki.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.iki.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void wU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ikb.getPageContext().getPageActivity(), this.ike, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, ikn), NoDataViewFactory.d.cK(null, this.ikb.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dkx);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, this.ikb.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.ikb.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class View$OnTouchListenerC0588a implements View.OnTouchListener {
        private View$OnTouchListenerC0588a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.ikl.oH(false);
                    break;
                case 1:
                    a.this.ikl.oH(true);
                    break;
                case 2:
                    a.this.ikl.oH(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ikl.oG(z);
        this.iki.setShowState(recommendForumInfo, z);
    }
}
