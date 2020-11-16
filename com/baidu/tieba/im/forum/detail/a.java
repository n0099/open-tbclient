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
/* loaded from: classes25.dex */
public class a extends c<ForumDetailActivity> {
    public static final int keL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener etG;
    private NoNetworkView giU;
    private LinearLayout keC;
    private CustomScrollView keD;
    private ItemHeaderView keE;
    private ItemInfoView keF;
    private ItemMsgManage keG;
    private ItemEmotionView keH;
    private ItemHotThreadView keI;
    private ItemFootNavView keJ;
    private com.baidu.tbadk.core.dialog.a keK;
    private ForumDetailActivity kez;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.kez = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.keC = (LinearLayout) this.kez.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.kez.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.keC.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.kez.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kez.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.giU = (NoNetworkView) this.kez.findViewById(R.id.no_network_view);
        this.keD = (CustomScrollView) this.kez.findViewById(R.id.scoll_view);
        this.keD.setOnTouchListener(new View$OnTouchListenerC0761a());
        this.keE = (ItemHeaderView) this.kez.findViewById(R.id.item_header);
        this.keF = (ItemInfoView) this.kez.findViewById(R.id.item_info);
        this.keG = (ItemMsgManage) this.kez.findViewById(R.id.item_msg_manage);
        this.keH = (ItemEmotionView) this.kez.findViewById(R.id.item_emotion_manage);
        this.keI = (ItemHotThreadView) this.kez.findViewById(R.id.item_hot_thread);
        this.keJ = (ItemFootNavView) this.kez.findViewById(R.id.item_foot_nav);
        this.keJ.setClickable(true);
        this.mRootView = this.kez.findViewById(R.id.root_rl);
        this.keG.setMsgOnClickListener(this.kez);
        this.keH.setEmotionOnClickListener(this.kez);
        this.keG.setSwitchChangeListener(this.kez);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.keE.setData(recommendForumInfo);
        this.keF.setData(recommendForumInfo);
        this.keG.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.keJ.setData(recommendForumInfo, this.kez);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.keH.setEmotionData(forumEmotionData);
    }

    public void bK(List<SimpleThreadInfo> list) {
        this.keI.setData(list);
    }

    public void hideLoading() {
        this.kez.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.kez.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.kez.getLayoutMode().setNightMode(i == 1);
        this.kez.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.giU.onChangeSkinType(getPageContext(), i);
        this.keE.a(this.kez, i);
        this.keF.a(this.kez, i);
        this.keG.a(this.kez, i);
        this.keI.a(this.kez, i);
        this.keJ.a(this.kez, i);
    }

    public void onResume() {
        this.keJ.e(this.kez);
    }

    public void cRA() {
        if (this.keK == null) {
            this.keK = new com.baidu.tbadk.core.dialog.a(this.kez.getPageContext().getPageActivity());
            this.keK.os(R.string.officical_bar_info_clean_alert);
            this.keK.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.keK.dismiss();
                    a.this.kez.clearHistory();
                }
            });
            this.keK.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.keK.dismiss();
                }
            });
        }
        this.keK.b(getPageContext()).bog();
    }

    public NoNetworkView cRB() {
        return this.giU;
    }

    public void g(View.OnClickListener onClickListener) {
        this.etG = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.keG.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.keG.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Do(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kez.getPageContext().getPageActivity(), this.keC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, keL), NoDataViewFactory.d.dS(null, this.kez.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.etG);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.kez.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.kez.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class View$OnTouchListenerC0761a implements View.OnTouchListener {
        private View$OnTouchListenerC0761a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.keJ.rU(false);
                    break;
                case 1:
                    a.this.keJ.rU(true);
                    break;
                case 2:
                    a.this.keJ.rU(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.keJ.rT(z);
        this.keG.setShowState(recommendForumInfo, z);
    }
}
