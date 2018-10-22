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
    private ForumDetailActivity eFS;
    private LinearLayout eFV;
    private CustomScrollView eFW;
    private ItemHeaderView eFX;
    private ItemInfoView eFY;
    private ItemMsgManage eFZ;
    private ItemEmotionView eGa;
    private ItemHotThreadView eGb;
    private ItemFootNavView eGc;
    private com.baidu.tbadk.core.dialog.a eGd;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eFS = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eFV = (LinearLayout) this.eFS.findViewById(e.g.scoll_view_ll);
        TextView textView = new TextView(this.eFS.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eFV.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eFS.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eFS.getPageContext().getString(e.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bJX = (NoNetworkView) this.eFS.findViewById(e.g.no_network_view);
        this.eFW = (CustomScrollView) this.eFS.findViewById(e.g.scoll_view);
        this.eFW.setOnTouchListener(new View$OnTouchListenerC0209a());
        this.eFX = (ItemHeaderView) this.eFS.findViewById(e.g.item_header);
        this.eFY = (ItemInfoView) this.eFS.findViewById(e.g.item_info);
        this.eFZ = (ItemMsgManage) this.eFS.findViewById(e.g.item_msg_manage);
        this.eGa = (ItemEmotionView) this.eFS.findViewById(e.g.item_emotion_manage);
        this.eGb = (ItemHotThreadView) this.eFS.findViewById(e.g.item_hot_thread);
        this.eGc = (ItemFootNavView) this.eFS.findViewById(e.g.item_foot_nav);
        this.eGc.setClickable(true);
        this.mRootView = this.eFS.findViewById(e.g.root_rl);
        aPH();
        this.eFZ.setMsgOnClickListener(this.eFS);
        this.eGa.setEmotionOnClickListener(this.eFS);
        this.eFZ.setSwitchChangeListener(this.eFS);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eFX.setData(recommendForumInfo);
        this.eFY.setData(recommendForumInfo);
        this.eFZ.setData(recommendForumInfo, z, managerApplyInfo);
        this.eGc.setData(recommendForumInfo, this.eFS);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eGa.setEmotionData(forumEmotionData);
    }

    public void ab(List<SimpleThreadInfo> list) {
        this.eGb.setData(list);
    }

    public void aEH() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aPH() {
        this.mProgressBar = new ProgressBar(this.eFS.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eFS.getPageContext().getResources().getDrawable(e.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eFS.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eFS.getLayoutMode().setNightMode(i == 1);
        this.eFS.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bJX.onChangeSkinType(getPageContext(), i);
        this.eFX.a(this.eFS, i);
        this.eFY.a(this.eFS, i);
        this.eFZ.a(this.eFS, i);
        this.eGb.a(this.eFS, i);
        this.eGc.a(this.eFS, i);
    }

    public void onResume() {
        this.eGc.e(this.eFS);
    }

    public void aPI() {
        if (this.eGd == null) {
            this.eGd = new com.baidu.tbadk.core.dialog.a(this.eFS.getPageContext().getPageActivity());
            this.eGd.cz(e.j.officical_bar_info_clean_alert);
            this.eGd.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eGd.dismiss();
                    a.this.eFS.clearHistory();
                }
            });
            this.eGd.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eGd.dismiss();
                }
            });
        }
        this.eGd.b(getPageContext()).Au();
    }

    public NoNetworkView aPJ() {
        return this.bJX;
    }

    public void b(View.OnClickListener onClickListener) {
        this.aiF = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eFZ.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eFZ.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void jq(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eFS.getPageContext().getPageActivity(), this.eFV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.dO(i), null);
            this.mNoDataView.setOnClickListener(this.aiF);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(i));
        this.mNoDataView.onChangeSkinType(this.eFS.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.eGc.il(false);
                    break;
                case 1:
                    a.this.eGc.il(true);
                    break;
                case 2:
                    a.this.eGc.il(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eGc.ik(z);
        this.eFZ.setShowState(recommendForumInfo, z);
    }
}
