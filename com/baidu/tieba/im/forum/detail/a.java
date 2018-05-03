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
    private View.OnClickListener Tt;
    private NoNetworkView bla;
    private ForumDetailActivity dWK;
    private LinearLayout dWN;
    private CustomScrollView dWO;
    private ItemHeaderView dWP;
    private ItemInfoView dWQ;
    private ItemMsgManage dWR;
    private ItemEmotionView dWS;
    private ItemHotThreadView dWT;
    private ItemFootNavView dWU;
    private com.baidu.tbadk.core.dialog.a dWV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.dWK = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.dWN = (LinearLayout) this.dWK.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.dWK.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.dWN.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.dWK.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dWK.getPageContext().getString(d.k.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bla = (NoNetworkView) this.dWK.findViewById(d.g.no_network_view);
        this.dWO = (CustomScrollView) this.dWK.findViewById(d.g.scoll_view);
        this.dWO.setOnTouchListener(new View$OnTouchListenerC0156a());
        this.dWP = (ItemHeaderView) this.dWK.findViewById(d.g.item_header);
        this.dWQ = (ItemInfoView) this.dWK.findViewById(d.g.item_info);
        this.dWR = (ItemMsgManage) this.dWK.findViewById(d.g.item_msg_manage);
        this.dWS = (ItemEmotionView) this.dWK.findViewById(d.g.item_emotion_manage);
        this.dWT = (ItemHotThreadView) this.dWK.findViewById(d.g.item_hot_thread);
        this.dWU = (ItemFootNavView) this.dWK.findViewById(d.g.item_foot_nav);
        this.dWU.setClickable(true);
        this.mRootView = this.dWK.findViewById(d.g.root_rl);
        aDF();
        this.dWR.setMsgOnClickListener(this.dWK);
        this.dWS.setEmotionOnClickListener(this.dWK);
        this.dWR.setSwitchChangeListener(this.dWK);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.dWP.setData(recommendForumInfo);
        this.dWQ.setData(recommendForumInfo);
        this.dWR.setData(recommendForumInfo, z, managerApplyInfo);
        this.dWU.setData(recommendForumInfo, this.dWK);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.dWS.setEmotionData(forumEmotionData);
    }

    public void O(List<SimpleThreadInfo> list) {
        this.dWT.setData(list);
    }

    public void atM() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aDF() {
        this.mProgressBar = new ProgressBar(this.dWK.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.dWK.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.dWK.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.dWK.getLayoutMode().setNightMode(i == 1);
        this.dWK.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bla.onChangeSkinType(getPageContext(), i);
        this.dWP.a(this.dWK, i);
        this.dWQ.a(this.dWK, i);
        this.dWR.a(this.dWK, i);
        this.dWT.a(this.dWK, i);
        this.dWU.a(this.dWK, i);
    }

    public void onResume() {
        this.dWU.e(this.dWK);
    }

    public void aDG() {
        if (this.dWV == null) {
            this.dWV = new com.baidu.tbadk.core.dialog.a(this.dWK.getPageContext().getPageActivity());
            this.dWV.bZ(d.k.officical_bar_info_clean_alert);
            this.dWV.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.dWV.dismiss();
                    a.this.dWK.clearHistory();
                }
            });
            this.dWV.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.dWV.dismiss();
                }
            });
        }
        this.dWV.b(getPageContext()).tD();
    }

    public NoNetworkView aDH() {
        return this.bla;
    }

    public void b(View.OnClickListener onClickListener) {
        this.Tt = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.dWR.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.dWR.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void ij(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dWK.getPageContext().getPageActivity(), this.dWN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.m16do(i), null);
            this.mNoDataView.setOnClickListener(this.Tt);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.m16do(i));
        this.mNoDataView.onChangeSkinType(this.dWK.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0156a implements View.OnTouchListener {
        private View$OnTouchListenerC0156a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.dWU.hb(false);
                    break;
                case 1:
                    a.this.dWU.hb(true);
                    break;
                case 2:
                    a.this.dWU.hb(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.dWU.ha(z);
        this.dWR.setShowState(recommendForumInfo, z);
    }
}
