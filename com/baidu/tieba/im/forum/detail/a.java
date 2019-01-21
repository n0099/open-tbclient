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
    private View.OnClickListener anx;
    private NoNetworkView bPm;
    private ForumDetailActivity eRF;
    private LinearLayout eRI;
    private CustomScrollView eRJ;
    private ItemHeaderView eRK;
    private ItemInfoView eRL;
    private ItemMsgManage eRM;
    private ItemEmotionView eRN;
    private ItemHotThreadView eRO;
    private ItemFootNavView eRP;
    private com.baidu.tbadk.core.dialog.a eRQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eRF = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eRI = (LinearLayout) this.eRF.findViewById(e.g.scoll_view_ll);
        TextView textView = new TextView(this.eRF.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eRI.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eRF.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eRF.getPageContext().getString(e.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bPm = (NoNetworkView) this.eRF.findViewById(e.g.no_network_view);
        this.eRJ = (CustomScrollView) this.eRF.findViewById(e.g.scoll_view);
        this.eRJ.setOnTouchListener(new View$OnTouchListenerC0246a());
        this.eRK = (ItemHeaderView) this.eRF.findViewById(e.g.item_header);
        this.eRL = (ItemInfoView) this.eRF.findViewById(e.g.item_info);
        this.eRM = (ItemMsgManage) this.eRF.findViewById(e.g.item_msg_manage);
        this.eRN = (ItemEmotionView) this.eRF.findViewById(e.g.item_emotion_manage);
        this.eRO = (ItemHotThreadView) this.eRF.findViewById(e.g.item_hot_thread);
        this.eRP = (ItemFootNavView) this.eRF.findViewById(e.g.item_foot_nav);
        this.eRP.setClickable(true);
        this.mRootView = this.eRF.findViewById(e.g.root_rl);
        aSj();
        this.eRM.setMsgOnClickListener(this.eRF);
        this.eRN.setEmotionOnClickListener(this.eRF);
        this.eRM.setSwitchChangeListener(this.eRF);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eRK.setData(recommendForumInfo);
        this.eRL.setData(recommendForumInfo);
        this.eRM.setData(recommendForumInfo, z, managerApplyInfo);
        this.eRP.setData(recommendForumInfo, this.eRF);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eRN.setEmotionData(forumEmotionData);
    }

    public void ab(List<SimpleThreadInfo> list) {
        this.eRO.setData(list);
    }

    public void aHb() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aSj() {
        this.mProgressBar = new ProgressBar(this.eRF.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eRF.getPageContext().getResources().getDrawable(e.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eRF.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eRF.getLayoutMode().setNightMode(i == 1);
        this.eRF.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bPm.onChangeSkinType(getPageContext(), i);
        this.eRK.a(this.eRF, i);
        this.eRL.a(this.eRF, i);
        this.eRM.a(this.eRF, i);
        this.eRO.a(this.eRF, i);
        this.eRP.a(this.eRF, i);
    }

    public void onResume() {
        this.eRP.e(this.eRF);
    }

    public void aSk() {
        if (this.eRQ == null) {
            this.eRQ = new com.baidu.tbadk.core.dialog.a(this.eRF.getPageContext().getPageActivity());
            this.eRQ.db(e.j.officical_bar_info_clean_alert);
            this.eRQ.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eRQ.dismiss();
                    a.this.eRF.clearHistory();
                }
            });
            this.eRQ.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eRQ.dismiss();
                }
            });
        }
        this.eRQ.b(getPageContext()).BS();
    }

    public NoNetworkView aSl() {
        return this.bPm;
    }

    public void c(View.OnClickListener onClickListener) {
        this.anx = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eRM.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eRM.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void kf(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eRF.getPageContext().getPageActivity(), this.eRI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.eq(i), null);
            this.mNoDataView.setOnClickListener(this.anx);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.onChangeSkinType(this.eRF.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.eRP.iA(false);
                    break;
                case 1:
                    a.this.eRP.iA(true);
                    break;
                case 2:
                    a.this.eRP.iA(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eRP.iz(z);
        this.eRM.setShowState(recommendForumInfo, z);
    }
}
