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
import com.baidu.tieba.d;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.view.CustomScrollView;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener abe;
    private NoNetworkView bvz;
    private ForumDetailActivity eqQ;
    private LinearLayout eqT;
    private CustomScrollView eqU;
    private ItemHeaderView eqV;
    private ItemInfoView eqW;
    private ItemMsgManage eqX;
    private ItemEmotionView eqY;
    private ItemHotThreadView eqZ;
    private ItemFootNavView era;
    private com.baidu.tbadk.core.dialog.a erb;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eqQ = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eqT = (LinearLayout) this.eqQ.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.eqQ.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eqT.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eqQ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eqQ.getPageContext().getString(d.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bvz = (NoNetworkView) this.eqQ.findViewById(d.g.no_network_view);
        this.eqU = (CustomScrollView) this.eqQ.findViewById(d.g.scoll_view);
        this.eqU.setOnTouchListener(new View$OnTouchListenerC0173a());
        this.eqV = (ItemHeaderView) this.eqQ.findViewById(d.g.item_header);
        this.eqW = (ItemInfoView) this.eqQ.findViewById(d.g.item_info);
        this.eqX = (ItemMsgManage) this.eqQ.findViewById(d.g.item_msg_manage);
        this.eqY = (ItemEmotionView) this.eqQ.findViewById(d.g.item_emotion_manage);
        this.eqZ = (ItemHotThreadView) this.eqQ.findViewById(d.g.item_hot_thread);
        this.era = (ItemFootNavView) this.eqQ.findViewById(d.g.item_foot_nav);
        this.era.setClickable(true);
        this.mRootView = this.eqQ.findViewById(d.g.root_rl);
        aKg();
        this.eqX.setMsgOnClickListener(this.eqQ);
        this.eqY.setEmotionOnClickListener(this.eqQ);
        this.eqX.setSwitchChangeListener(this.eqQ);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eqV.setData(recommendForumInfo);
        this.eqW.setData(recommendForumInfo);
        this.eqX.setData(recommendForumInfo, z, managerApplyInfo);
        this.era.setData(recommendForumInfo, this.eqQ);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eqY.setEmotionData(forumEmotionData);
    }

    public void R(List<SimpleThreadInfo> list) {
        this.eqZ.setData(list);
    }

    public void azi() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aKg() {
        this.mProgressBar = new ProgressBar(this.eqQ.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eqQ.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eqQ.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eqQ.getLayoutMode().setNightMode(i == 1);
        this.eqQ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bvz.onChangeSkinType(getPageContext(), i);
        this.eqV.a(this.eqQ, i);
        this.eqW.a(this.eqQ, i);
        this.eqX.a(this.eqQ, i);
        this.eqZ.a(this.eqQ, i);
        this.era.a(this.eqQ, i);
    }

    public void onResume() {
        this.era.e(this.eqQ);
    }

    public void aKh() {
        if (this.erb == null) {
            this.erb = new com.baidu.tbadk.core.dialog.a(this.eqQ.getPageContext().getPageActivity());
            this.erb.cf(d.j.officical_bar_info_clean_alert);
            this.erb.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.erb.dismiss();
                    a.this.eqQ.clearHistory();
                }
            });
            this.erb.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.erb.dismiss();
                }
            });
        }
        this.erb.b(getPageContext()).xf();
    }

    public NoNetworkView aKi() {
        return this.bvz;
    }

    public void b(View.OnClickListener onClickListener) {
        this.abe = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eqX.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eqX.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void it(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eqQ.getPageContext().getPageActivity(), this.eqT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.du(i), null);
            this.mNoDataView.setOnClickListener(this.abe);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.du(i));
        this.mNoDataView.onChangeSkinType(this.eqQ.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0173a implements View.OnTouchListener {
        private View$OnTouchListenerC0173a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.era.hv(false);
                    break;
                case 1:
                    a.this.era.hv(true);
                    break;
                case 2:
                    a.this.era.hv(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.era.hu(z);
        this.eqX.setShowState(recommendForumInfo, z);
    }
}
