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
    private View.OnClickListener anw;
    private NoNetworkView bPl;
    private ForumDetailActivity eRE;
    private LinearLayout eRH;
    private CustomScrollView eRI;
    private ItemHeaderView eRJ;
    private ItemInfoView eRK;
    private ItemMsgManage eRL;
    private ItemEmotionView eRM;
    private ItemHotThreadView eRN;
    private ItemFootNavView eRO;
    private com.baidu.tbadk.core.dialog.a eRP;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eRE = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eRH = (LinearLayout) this.eRE.findViewById(e.g.scoll_view_ll);
        TextView textView = new TextView(this.eRE.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eRH.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eRE.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eRE.getPageContext().getString(e.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bPl = (NoNetworkView) this.eRE.findViewById(e.g.no_network_view);
        this.eRI = (CustomScrollView) this.eRE.findViewById(e.g.scoll_view);
        this.eRI.setOnTouchListener(new View$OnTouchListenerC0246a());
        this.eRJ = (ItemHeaderView) this.eRE.findViewById(e.g.item_header);
        this.eRK = (ItemInfoView) this.eRE.findViewById(e.g.item_info);
        this.eRL = (ItemMsgManage) this.eRE.findViewById(e.g.item_msg_manage);
        this.eRM = (ItemEmotionView) this.eRE.findViewById(e.g.item_emotion_manage);
        this.eRN = (ItemHotThreadView) this.eRE.findViewById(e.g.item_hot_thread);
        this.eRO = (ItemFootNavView) this.eRE.findViewById(e.g.item_foot_nav);
        this.eRO.setClickable(true);
        this.mRootView = this.eRE.findViewById(e.g.root_rl);
        aSj();
        this.eRL.setMsgOnClickListener(this.eRE);
        this.eRM.setEmotionOnClickListener(this.eRE);
        this.eRL.setSwitchChangeListener(this.eRE);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eRJ.setData(recommendForumInfo);
        this.eRK.setData(recommendForumInfo);
        this.eRL.setData(recommendForumInfo, z, managerApplyInfo);
        this.eRO.setData(recommendForumInfo, this.eRE);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eRM.setEmotionData(forumEmotionData);
    }

    public void ab(List<SimpleThreadInfo> list) {
        this.eRN.setData(list);
    }

    public void aHb() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aSj() {
        this.mProgressBar = new ProgressBar(this.eRE.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eRE.getPageContext().getResources().getDrawable(e.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eRE.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eRE.getLayoutMode().setNightMode(i == 1);
        this.eRE.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bPl.onChangeSkinType(getPageContext(), i);
        this.eRJ.a(this.eRE, i);
        this.eRK.a(this.eRE, i);
        this.eRL.a(this.eRE, i);
        this.eRN.a(this.eRE, i);
        this.eRO.a(this.eRE, i);
    }

    public void onResume() {
        this.eRO.e(this.eRE);
    }

    public void aSk() {
        if (this.eRP == null) {
            this.eRP = new com.baidu.tbadk.core.dialog.a(this.eRE.getPageContext().getPageActivity());
            this.eRP.db(e.j.officical_bar_info_clean_alert);
            this.eRP.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eRP.dismiss();
                    a.this.eRE.clearHistory();
                }
            });
            this.eRP.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eRP.dismiss();
                }
            });
        }
        this.eRP.b(getPageContext()).BS();
    }

    public NoNetworkView aSl() {
        return this.bPl;
    }

    public void c(View.OnClickListener onClickListener) {
        this.anw = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eRL.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eRL.setShowState(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void kf(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eRE.getPageContext().getPageActivity(), this.eRH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.eq(i), null);
            this.mNoDataView.setOnClickListener(this.anw);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.onChangeSkinType(this.eRE.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.eRO.iA(false);
                    break;
                case 1:
                    a.this.eRO.iA(true);
                    break;
                case 2:
                    a.this.eRO.iA(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eRO.iz(z);
        this.eRL.setShowState(recommendForumInfo, z);
    }
}
