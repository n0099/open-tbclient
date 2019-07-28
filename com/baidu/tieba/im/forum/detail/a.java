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
/* loaded from: classes3.dex */
public class a extends c<ForumDetailActivity> {
    private View.OnClickListener bCn;
    private NoNetworkView dnF;
    private ForumDetailActivity gEX;
    private LinearLayout gFa;
    private CustomScrollView gFb;
    private ItemHeaderView gFc;
    private ItemInfoView gFd;
    private ItemMsgManage gFe;
    private ItemEmotionView gFf;
    private ItemHotThreadView gFg;
    private ItemFootNavView gFh;
    private com.baidu.tbadk.core.dialog.a gFi;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.gEX = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.gFa = (LinearLayout) this.gEX.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.gEX.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.gFa.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.gEX.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gEX.getPageContext().getString(R.string.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dnF = (NoNetworkView) this.gEX.findViewById(R.id.no_network_view);
        this.gFb = (CustomScrollView) this.gEX.findViewById(R.id.scoll_view);
        this.gFb.setOnTouchListener(new View$OnTouchListenerC0336a());
        this.gFc = (ItemHeaderView) this.gEX.findViewById(R.id.item_header);
        this.gFd = (ItemInfoView) this.gEX.findViewById(R.id.item_info);
        this.gFe = (ItemMsgManage) this.gEX.findViewById(R.id.item_msg_manage);
        this.gFf = (ItemEmotionView) this.gEX.findViewById(R.id.item_emotion_manage);
        this.gFg = (ItemHotThreadView) this.gEX.findViewById(R.id.item_hot_thread);
        this.gFh = (ItemFootNavView) this.gEX.findViewById(R.id.item_foot_nav);
        this.gFh.setClickable(true);
        this.mRootView = this.gEX.findViewById(R.id.root_rl);
        bDi();
        this.gFe.setMsgOnClickListener(this.gEX);
        this.gFf.setEmotionOnClickListener(this.gEX);
        this.gFe.setSwitchChangeListener(this.gEX);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.gFc.setData(recommendForumInfo);
        this.gFd.setData(recommendForumInfo);
        this.gFe.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.gFh.setData(recommendForumInfo, this.gEX);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.gFf.setEmotionData(forumEmotionData);
    }

    public void av(List<SimpleThreadInfo> list) {
        this.gFg.setData(list);
    }

    public void bqO() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar bDi() {
        this.mProgressBar = new ProgressBar(this.gEX.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.gEX.getPageContext().getResources().getDrawable(R.drawable.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.gEX.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.gEX.getLayoutMode().setNightMode(i == 1);
        this.gEX.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnF.onChangeSkinType(getPageContext(), i);
        this.gFc.a(this.gEX, i);
        this.gFd.a(this.gEX, i);
        this.gFe.a(this.gEX, i);
        this.gFg.a(this.gEX, i);
        this.gFh.a(this.gEX, i);
    }

    public void onResume() {
        this.gFh.e(this.gEX);
    }

    public void bDj() {
        if (this.gFi == null) {
            this.gFi = new com.baidu.tbadk.core.dialog.a(this.gEX.getPageContext().getPageActivity());
            this.gFi.hu(R.string.officical_bar_info_clean_alert);
            this.gFi.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gFi.dismiss();
                    a.this.gEX.bDa();
                }
            });
            this.gFi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.gFi.dismiss();
                }
            });
        }
        this.gFi.b(getPageContext()).agI();
    }

    public NoNetworkView bDk() {
        return this.dnF;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCn = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.gFe.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gFe.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void oW(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gEX.getPageContext().getPageActivity(), this.gFa, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.iN(i), null);
            this.mNoDataView.setOnClickListener(this.bCn);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(i));
        this.mNoDataView.onChangeSkinType(this.gEX.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.im.forum.detail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0336a implements View.OnTouchListener {
        private View$OnTouchListenerC0336a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    a.this.gFh.me(false);
                    break;
                case 1:
                    a.this.gFh.me(true);
                    break;
                case 2:
                    a.this.gFh.me(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.gFh.md(z);
        this.gFe.setShowState(recommendForumInfo, z);
    }
}
