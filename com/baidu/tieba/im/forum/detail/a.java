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
    public static final int hyH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener cKZ;
    private NoNetworkView eli;
    private ItemHeaderView hyA;
    private ItemInfoView hyB;
    private ItemMsgManage hyC;
    private ItemEmotionView hyD;
    private ItemHotThreadView hyE;
    private ItemFootNavView hyF;
    private com.baidu.tbadk.core.dialog.a hyG;
    private ForumDetailActivity hyv;
    private LinearLayout hyy;
    private CustomScrollView hyz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.hyv = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.hyy = (LinearLayout) this.hyv.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.hyv.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.hyy.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.hyv.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hyv.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eli = (NoNetworkView) this.hyv.findViewById(R.id.no_network_view);
        this.hyz = (CustomScrollView) this.hyv.findViewById(R.id.scoll_view);
        this.hyz.setOnTouchListener(new View$OnTouchListenerC0529a());
        this.hyA = (ItemHeaderView) this.hyv.findViewById(R.id.item_header);
        this.hyB = (ItemInfoView) this.hyv.findViewById(R.id.item_info);
        this.hyC = (ItemMsgManage) this.hyv.findViewById(R.id.item_msg_manage);
        this.hyD = (ItemEmotionView) this.hyv.findViewById(R.id.item_emotion_manage);
        this.hyE = (ItemHotThreadView) this.hyv.findViewById(R.id.item_hot_thread);
        this.hyF = (ItemFootNavView) this.hyv.findViewById(R.id.item_foot_nav);
        this.hyF.setClickable(true);
        this.mRootView = this.hyv.findViewById(R.id.root_rl);
        this.hyC.setMsgOnClickListener(this.hyv);
        this.hyD.setEmotionOnClickListener(this.hyv);
        this.hyC.setSwitchChangeListener(this.hyv);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.hyA.setData(recommendForumInfo);
        this.hyB.setData(recommendForumInfo);
        this.hyC.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.hyF.setData(recommendForumInfo, this.hyv);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.hyD.setEmotionData(forumEmotionData);
    }

    public void aT(List<SimpleThreadInfo> list) {
        this.hyE.setData(list);
    }

    public void hideLoading() {
        this.hyv.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.hyv.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.hyv.getLayoutMode().setNightMode(i == 1);
        this.hyv.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eli.onChangeSkinType(getPageContext(), i);
        this.hyA.a(this.hyv, i);
        this.hyB.a(this.hyv, i);
        this.hyC.a(this.hyv, i);
        this.hyE.a(this.hyv, i);
        this.hyF.a(this.hyv, i);
    }

    public void onResume() {
        this.hyF.e(this.hyv);
    }

    public void bUS() {
        if (this.hyG == null) {
            this.hyG = new com.baidu.tbadk.core.dialog.a(this.hyv.getPageContext().getPageActivity());
            this.hyG.jW(R.string.officical_bar_info_clean_alert);
            this.hyG.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hyG.dismiss();
                    a.this.hyv.clearHistory();
                }
            });
            this.hyG.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.hyG.dismiss();
                }
            });
        }
        this.hyG.b(getPageContext()).aEC();
    }

    public NoNetworkView bUT() {
        return this.eli;
    }

    public void f(View.OnClickListener onClickListener) {
        this.cKZ = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.hyC.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hyC.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hyv.getPageContext().getPageActivity(), this.hyy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, hyH), NoDataViewFactory.d.cA(null, this.hyv.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.cKZ);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, this.hyv.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.hyv.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.hyF.nx(false);
                    break;
                case 1:
                    a.this.hyF.nx(true);
                    break;
                case 2:
                    a.this.hyF.nx(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hyF.nw(z);
        this.hyC.setShowState(recommendForumInfo, z);
    }
}
