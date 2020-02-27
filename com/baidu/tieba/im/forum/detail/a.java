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
    public static final int hyF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener cKY;
    private NoNetworkView elh;
    private ItemMsgManage hyA;
    private ItemEmotionView hyB;
    private ItemHotThreadView hyC;
    private ItemFootNavView hyD;
    private com.baidu.tbadk.core.dialog.a hyE;
    private ForumDetailActivity hyt;
    private LinearLayout hyw;
    private CustomScrollView hyx;
    private ItemHeaderView hyy;
    private ItemInfoView hyz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.hyt = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.hyw = (LinearLayout) this.hyt.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.hyt.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.hyw.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.hyt.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hyt.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.elh = (NoNetworkView) this.hyt.findViewById(R.id.no_network_view);
        this.hyx = (CustomScrollView) this.hyt.findViewById(R.id.scoll_view);
        this.hyx.setOnTouchListener(new View$OnTouchListenerC0529a());
        this.hyy = (ItemHeaderView) this.hyt.findViewById(R.id.item_header);
        this.hyz = (ItemInfoView) this.hyt.findViewById(R.id.item_info);
        this.hyA = (ItemMsgManage) this.hyt.findViewById(R.id.item_msg_manage);
        this.hyB = (ItemEmotionView) this.hyt.findViewById(R.id.item_emotion_manage);
        this.hyC = (ItemHotThreadView) this.hyt.findViewById(R.id.item_hot_thread);
        this.hyD = (ItemFootNavView) this.hyt.findViewById(R.id.item_foot_nav);
        this.hyD.setClickable(true);
        this.mRootView = this.hyt.findViewById(R.id.root_rl);
        this.hyA.setMsgOnClickListener(this.hyt);
        this.hyB.setEmotionOnClickListener(this.hyt);
        this.hyA.setSwitchChangeListener(this.hyt);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.hyy.setData(recommendForumInfo);
        this.hyz.setData(recommendForumInfo);
        this.hyA.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.hyD.setData(recommendForumInfo, this.hyt);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.hyB.setEmotionData(forumEmotionData);
    }

    public void aT(List<SimpleThreadInfo> list) {
        this.hyC.setData(list);
    }

    public void hideLoading() {
        this.hyt.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.hyt.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.hyt.getLayoutMode().setNightMode(i == 1);
        this.hyt.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.elh.onChangeSkinType(getPageContext(), i);
        this.hyy.a(this.hyt, i);
        this.hyz.a(this.hyt, i);
        this.hyA.a(this.hyt, i);
        this.hyC.a(this.hyt, i);
        this.hyD.a(this.hyt, i);
    }

    public void onResume() {
        this.hyD.e(this.hyt);
    }

    public void bUQ() {
        if (this.hyE == null) {
            this.hyE = new com.baidu.tbadk.core.dialog.a(this.hyt.getPageContext().getPageActivity());
            this.hyE.jW(R.string.officical_bar_info_clean_alert);
            this.hyE.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hyE.dismiss();
                    a.this.hyt.clearHistory();
                }
            });
            this.hyE.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hyE.dismiss();
                }
            });
        }
        this.hyE.b(getPageContext()).aEA();
    }

    public NoNetworkView bUR() {
        return this.elh;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKY = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.hyA.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hyA.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hyt.getPageContext().getPageActivity(), this.hyw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, hyF), NoDataViewFactory.d.cA(null, this.hyt.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.cKY);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, this.hyt.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.hyt.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class View$OnTouchListenerC0529a implements View.OnTouchListener {
        private View$OnTouchListenerC0529a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.hyD.nx(false);
                    break;
                case 1:
                    a.this.hyD.nx(true);
                    break;
                case 2:
                    a.this.hyD.nx(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hyD.nw(z);
        this.hyA.setShowState(recommendForumInfo, z);
    }
}
