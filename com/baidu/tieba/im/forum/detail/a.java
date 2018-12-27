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
    private View.OnClickListener amU;
    private NoNetworkView bOA;
    private ForumDetailActivity eQR;
    private LinearLayout eQU;
    private CustomScrollView eQV;
    private ItemHeaderView eQW;
    private ItemInfoView eQX;
    private ItemMsgManage eQY;
    private ItemEmotionView eQZ;
    private ItemHotThreadView eRa;
    private ItemFootNavView eRb;
    private com.baidu.tbadk.core.dialog.a eRc;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eQR = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eQU = (LinearLayout) this.eQR.findViewById(e.g.scoll_view_ll);
        TextView textView = new TextView(this.eQR.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eQU.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eQR.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eQR.getPageContext().getString(e.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bOA = (NoNetworkView) this.eQR.findViewById(e.g.no_network_view);
        this.eQV = (CustomScrollView) this.eQR.findViewById(e.g.scoll_view);
        this.eQV.setOnTouchListener(new View$OnTouchListenerC0246a());
        this.eQW = (ItemHeaderView) this.eQR.findViewById(e.g.item_header);
        this.eQX = (ItemInfoView) this.eQR.findViewById(e.g.item_info);
        this.eQY = (ItemMsgManage) this.eQR.findViewById(e.g.item_msg_manage);
        this.eQZ = (ItemEmotionView) this.eQR.findViewById(e.g.item_emotion_manage);
        this.eRa = (ItemHotThreadView) this.eQR.findViewById(e.g.item_hot_thread);
        this.eRb = (ItemFootNavView) this.eQR.findViewById(e.g.item_foot_nav);
        this.eRb.setClickable(true);
        this.mRootView = this.eQR.findViewById(e.g.root_rl);
        aRJ();
        this.eQY.setMsgOnClickListener(this.eQR);
        this.eQZ.setEmotionOnClickListener(this.eQR);
        this.eQY.setSwitchChangeListener(this.eQR);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eQW.setData(recommendForumInfo);
        this.eQX.setData(recommendForumInfo);
        this.eQY.setData(recommendForumInfo, z, managerApplyInfo);
        this.eRb.setData(recommendForumInfo, this.eQR);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eQZ.setEmotionData(forumEmotionData);
    }

    public void aa(List<SimpleThreadInfo> list) {
        this.eRa.setData(list);
    }

    public void aGE() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aRJ() {
        this.mProgressBar = new ProgressBar(this.eQR.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eQR.getPageContext().getResources().getDrawable(e.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eQR.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eQR.getLayoutMode().setNightMode(i == 1);
        this.eQR.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bOA.onChangeSkinType(getPageContext(), i);
        this.eQW.a(this.eQR, i);
        this.eQX.a(this.eQR, i);
        this.eQY.a(this.eQR, i);
        this.eRa.a(this.eQR, i);
        this.eRb.a(this.eQR, i);
    }

    public void onResume() {
        this.eRb.e(this.eQR);
    }

    public void aRK() {
        if (this.eRc == null) {
            this.eRc = new com.baidu.tbadk.core.dialog.a(this.eQR.getPageContext().getPageActivity());
            this.eRc.db(e.j.officical_bar_info_clean_alert);
            this.eRc.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eRc.dismiss();
                    a.this.eQR.clearHistory();
                }
            });
            this.eRc.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eRc.dismiss();
                }
            });
        }
        this.eRc.b(getPageContext()).BF();
    }

    public NoNetworkView aRL() {
        return this.bOA;
    }

    public void c(View.OnClickListener onClickListener) {
        this.amU = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eQY.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eQY.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void kf(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eQR.getPageContext().getPageActivity(), this.eQU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.eq(i), null);
            this.mNoDataView.setOnClickListener(this.amU);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.onChangeSkinType(this.eQR.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0246a implements View.OnTouchListener {
        private View$OnTouchListenerC0246a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.eRb.iA(false);
                    break;
                case 1:
                    a.this.eRb.iA(true);
                    break;
                case 2:
                    a.this.eRb.iA(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eRb.iz(z);
        this.eQY.setShowState(recommendForumInfo, z);
    }
}
