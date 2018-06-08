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
    private View.OnClickListener aby;
    private NoNetworkView btu;
    private ForumDetailActivity eje;
    private LinearLayout ejh;
    private CustomScrollView eji;
    private ItemHeaderView ejj;
    private ItemInfoView ejk;
    private ItemMsgManage ejl;
    private ItemEmotionView ejm;
    private ItemHotThreadView ejn;
    private ItemFootNavView ejo;
    private com.baidu.tbadk.core.dialog.a ejp;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eje = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.ejh = (LinearLayout) this.eje.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.eje.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.ejh.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eje.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eje.getPageContext().getString(d.k.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.btu = (NoNetworkView) this.eje.findViewById(d.g.no_network_view);
        this.eji = (CustomScrollView) this.eje.findViewById(d.g.scoll_view);
        this.eji.setOnTouchListener(new View$OnTouchListenerC0172a());
        this.ejj = (ItemHeaderView) this.eje.findViewById(d.g.item_header);
        this.ejk = (ItemInfoView) this.eje.findViewById(d.g.item_info);
        this.ejl = (ItemMsgManage) this.eje.findViewById(d.g.item_msg_manage);
        this.ejm = (ItemEmotionView) this.eje.findViewById(d.g.item_emotion_manage);
        this.ejn = (ItemHotThreadView) this.eje.findViewById(d.g.item_hot_thread);
        this.ejo = (ItemFootNavView) this.eje.findViewById(d.g.item_foot_nav);
        this.ejo.setClickable(true);
        this.mRootView = this.eje.findViewById(d.g.root_rl);
        aIy();
        this.ejl.setMsgOnClickListener(this.eje);
        this.ejm.setEmotionOnClickListener(this.eje);
        this.ejl.setSwitchChangeListener(this.eje);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.ejj.setData(recommendForumInfo);
        this.ejk.setData(recommendForumInfo);
        this.ejl.setData(recommendForumInfo, z, managerApplyInfo);
        this.ejo.setData(recommendForumInfo, this.eje);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.ejm.setEmotionData(forumEmotionData);
    }

    public void R(List<SimpleThreadInfo> list) {
        this.ejn.setData(list);
    }

    public void axY() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aIy() {
        this.mProgressBar = new ProgressBar(this.eje.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eje.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eje.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eje.getLayoutMode().setNightMode(i == 1);
        this.eje.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.btu.onChangeSkinType(getPageContext(), i);
        this.ejj.a(this.eje, i);
        this.ejk.a(this.eje, i);
        this.ejl.a(this.eje, i);
        this.ejn.a(this.eje, i);
        this.ejo.a(this.eje, i);
    }

    public void onResume() {
        this.ejo.e(this.eje);
    }

    public void aIz() {
        if (this.ejp == null) {
            this.ejp = new com.baidu.tbadk.core.dialog.a(this.eje.getPageContext().getPageActivity());
            this.ejp.cc(d.k.officical_bar_info_clean_alert);
            this.ejp.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ejp.dismiss();
                    a.this.eje.clearHistory();
                }
            });
            this.ejp.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.ejp.dismiss();
                }
            });
        }
        this.ejp.b(getPageContext()).xa();
    }

    public NoNetworkView aIA() {
        return this.btu;
    }

    public void b(View.OnClickListener onClickListener) {
        this.aby = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.ejl.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ejl.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ij(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eje.getPageContext().getPageActivity(), this.ejh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.dr(i), null);
            this.mNoDataView.setOnClickListener(this.aby);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(i));
        this.mNoDataView.onChangeSkinType(this.eje.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0172a implements View.OnTouchListener {
        private View$OnTouchListenerC0172a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.ejo.hi(false);
                    break;
                case 1:
                    a.this.ejo.hi(true);
                    break;
                case 2:
                    a.this.ejo.hi(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.ejo.hh(z);
        this.ejl.setShowState(recommendForumInfo, z);
    }
}
