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
    public static final int izI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener dyx;
    private NoNetworkView fci;
    private CustomScrollView izA;
    private ItemHeaderView izB;
    private ItemInfoView izC;
    private ItemMsgManage izD;
    private ItemEmotionView izE;
    private ItemHotThreadView izF;
    private ItemFootNavView izG;
    private com.baidu.tbadk.core.dialog.a izH;
    private ForumDetailActivity izw;
    private LinearLayout izz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.izw = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.izz = (LinearLayout) this.izw.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.izw.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.izz.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.izw.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.izw.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fci = (NoNetworkView) this.izw.findViewById(R.id.no_network_view);
        this.izA = (CustomScrollView) this.izw.findViewById(R.id.scoll_view);
        this.izA.setOnTouchListener(new View$OnTouchListenerC0638a());
        this.izB = (ItemHeaderView) this.izw.findViewById(R.id.item_header);
        this.izC = (ItemInfoView) this.izw.findViewById(R.id.item_info);
        this.izD = (ItemMsgManage) this.izw.findViewById(R.id.item_msg_manage);
        this.izE = (ItemEmotionView) this.izw.findViewById(R.id.item_emotion_manage);
        this.izF = (ItemHotThreadView) this.izw.findViewById(R.id.item_hot_thread);
        this.izG = (ItemFootNavView) this.izw.findViewById(R.id.item_foot_nav);
        this.izG.setClickable(true);
        this.mRootView = this.izw.findViewById(R.id.root_rl);
        this.izD.setMsgOnClickListener(this.izw);
        this.izE.setEmotionOnClickListener(this.izw);
        this.izD.setSwitchChangeListener(this.izw);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.izB.setData(recommendForumInfo);
        this.izC.setData(recommendForumInfo);
        this.izD.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.izG.setData(recommendForumInfo, this.izw);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.izE.setEmotionData(forumEmotionData);
    }

    public void aY(List<SimpleThreadInfo> list) {
        this.izF.setData(list);
    }

    public void hideLoading() {
        this.izw.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.izw.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.izw.getLayoutMode().setNightMode(i == 1);
        this.izw.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fci.onChangeSkinType(getPageContext(), i);
        this.izB.a(this.izw, i);
        this.izC.a(this.izw, i);
        this.izD.a(this.izw, i);
        this.izF.a(this.izw, i);
        this.izG.a(this.izw, i);
    }

    public void onResume() {
        this.izG.e(this.izw);
    }

    public void cmr() {
        if (this.izH == null) {
            this.izH = new com.baidu.tbadk.core.dialog.a(this.izw.getPageContext().getPageActivity());
            this.izH.kF(R.string.officical_bar_info_clean_alert);
            this.izH.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.izH.dismiss();
                    a.this.izw.clearHistory();
                }
            });
            this.izH.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.izH.dismiss();
                }
            });
        }
        this.izH.b(getPageContext()).aST();
    }

    public NoNetworkView cms() {
        return this.fci;
    }

    public void f(View.OnClickListener onClickListener) {
        this.dyx = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.izD.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.izD.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void xC(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.izw.getPageContext().getPageActivity(), this.izz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, izI), NoDataViewFactory.d.dj(null, this.izw.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.dyx);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, this.izw.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.izw.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class View$OnTouchListenerC0638a implements View.OnTouchListener {
        private View$OnTouchListenerC0638a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.izG.pd(false);
                    break;
                case 1:
                    a.this.izG.pd(true);
                    break;
                case 2:
                    a.this.izG.pd(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.izG.pc(z);
        this.izD.setShowState(recommendForumInfo, z);
    }
}
