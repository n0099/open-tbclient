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
/* loaded from: classes10.dex */
public class a extends c<ForumDetailActivity> {
    public static final int htd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    private View.OnClickListener cGJ;
    private NoNetworkView egT;
    private ForumDetailActivity hsR;
    private LinearLayout hsU;
    private CustomScrollView hsV;
    private ItemHeaderView hsW;
    private ItemInfoView hsX;
    private ItemMsgManage hsY;
    private ItemEmotionView hsZ;
    private ItemHotThreadView hta;
    private ItemFootNavView htb;
    private com.baidu.tbadk.core.dialog.a htc;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.hsR = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.hsU = (LinearLayout) this.hsR.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.hsR.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.hsU.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.hsR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hsR.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.egT = (NoNetworkView) this.hsR.findViewById(R.id.no_network_view);
        this.hsV = (CustomScrollView) this.hsR.findViewById(R.id.scoll_view);
        this.hsV.setOnTouchListener(new View$OnTouchListenerC0517a());
        this.hsW = (ItemHeaderView) this.hsR.findViewById(R.id.item_header);
        this.hsX = (ItemInfoView) this.hsR.findViewById(R.id.item_info);
        this.hsY = (ItemMsgManage) this.hsR.findViewById(R.id.item_msg_manage);
        this.hsZ = (ItemEmotionView) this.hsR.findViewById(R.id.item_emotion_manage);
        this.hta = (ItemHotThreadView) this.hsR.findViewById(R.id.item_hot_thread);
        this.htb = (ItemFootNavView) this.hsR.findViewById(R.id.item_foot_nav);
        this.htb.setClickable(true);
        this.mRootView = this.hsR.findViewById(R.id.root_rl);
        this.hsY.setMsgOnClickListener(this.hsR);
        this.hsZ.setEmotionOnClickListener(this.hsR);
        this.hsY.setSwitchChangeListener(this.hsR);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.hsW.setData(recommendForumInfo);
        this.hsX.setData(recommendForumInfo);
        this.hsY.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.htb.setData(recommendForumInfo, this.hsR);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.hsZ.setEmotionData(forumEmotionData);
    }

    public void aU(List<SimpleThreadInfo> list) {
        this.hta.setData(list);
    }

    public void hideLoading() {
        this.hsR.hideLoadingView(this.mRootView);
    }

    public void showLoading() {
        this.hsR.showLoadingView(this.mRootView);
    }

    public void onChangeSkinType(int i) {
        this.hsR.getLayoutMode().setNightMode(i == 1);
        this.hsR.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.egT.onChangeSkinType(getPageContext(), i);
        this.hsW.a(this.hsR, i);
        this.hsX.a(this.hsR, i);
        this.hsY.a(this.hsR, i);
        this.hta.a(this.hsR, i);
        this.htb.a(this.hsR, i);
    }

    public void onResume() {
        this.htb.e(this.hsR);
    }

    public void bSg() {
        if (this.htc == null) {
            this.htc = new com.baidu.tbadk.core.dialog.a(this.hsR.getPageContext().getPageActivity());
            this.htc.jF(R.string.officical_bar_info_clean_alert);
            this.htc.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.htc.dismiss();
                    a.this.hsR.clearHistory();
                }
            });
            this.htc.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.htc.dismiss();
                }
            });
        }
        this.htc.b(getPageContext()).aBW();
    }

    public NoNetworkView bSh() {
        return this.egT;
    }

    public void g(View.OnClickListener onClickListener) {
        this.cGJ = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.hsY.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.hsY.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void wd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hsR.getPageContext().getPageActivity(), this.hsU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, htd), NoDataViewFactory.d.cr(null, this.hsR.getResources().getString(i)), null);
            this.mNoDataView.setOnClickListener(this.cGJ);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, this.hsR.getResources().getString(i)));
        this.mNoDataView.onChangeSkinType(this.hsR.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class View$OnTouchListenerC0517a implements View.OnTouchListener {
        private View$OnTouchListenerC0517a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.htb.nj(false);
                    break;
                case 1:
                    a.this.htb.nj(true);
                    break;
                case 2:
                    a.this.htb.nj(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.htb.ni(z);
        this.hsY.setShowState(recommendForumInfo, z);
    }
}
