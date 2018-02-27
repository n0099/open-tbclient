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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
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
    private View.OnClickListener aIa;
    private NoNetworkView caX;
    private ForumDetailActivity eBT;
    private LinearLayout eBW;
    private CustomScrollView eBX;
    private ItemHeaderView eBY;
    private ItemInfoView eBZ;
    private ItemMsgManage eCa;
    private ItemEmotionView eCb;
    private ItemHotThreadView eCc;
    private ItemFootNavView eCd;
    private com.baidu.tbadk.core.dialog.a eCe;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgressBar;
    private View mRootView;

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.eBT = forumDetailActivity;
        initUI();
    }

    private void initUI() {
        this.eBW = (LinearLayout) this.eBT.findViewById(d.g.scoll_view_ll);
        TextView textView = new TextView(this.eBT.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.eBW.addView(textView, 0);
        this.mNavigationBar = (NavigationBar) this.eBT.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eBT.getPageContext().getString(d.j.forum_detail_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.caX = (NoNetworkView) this.eBT.findViewById(d.g.no_network_view);
        this.eBX = (CustomScrollView) this.eBT.findViewById(d.g.scoll_view);
        this.eBX.setOnTouchListener(new View$OnTouchListenerC0173a());
        this.eBY = (ItemHeaderView) this.eBT.findViewById(d.g.item_header);
        this.eBZ = (ItemInfoView) this.eBT.findViewById(d.g.item_info);
        this.eCa = (ItemMsgManage) this.eBT.findViewById(d.g.item_msg_manage);
        this.eCb = (ItemEmotionView) this.eBT.findViewById(d.g.item_emotion_manage);
        this.eCc = (ItemHotThreadView) this.eBT.findViewById(d.g.item_hot_thread);
        this.eCd = (ItemFootNavView) this.eBT.findViewById(d.g.item_foot_nav);
        this.eCd.setClickable(true);
        this.mRootView = this.eBT.findViewById(d.g.root_rl);
        aIH();
        this.eCa.setMsgOnClickListener(this.eBT);
        this.eCb.setEmotionOnClickListener(this.eBT);
        this.eCa.setSwitchChangeListener(this.eBT);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        this.eBY.setData(recommendForumInfo);
        this.eBZ.setData(recommendForumInfo);
        this.eCa.b(recommendForumInfo, z, managerApplyInfo);
        this.eCd.a(recommendForumInfo, this.eBT);
    }

    public void a(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.eCb.setEmotionData(forumEmotionData);
    }

    public void X(List<SimpleThreadInfo> list) {
        this.eCc.setData(list);
    }

    public void aIG() {
        this.mProgressBar.setVisibility(8);
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    private ProgressBar aIH() {
        this.mProgressBar = new ProgressBar(this.eBT.getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminateDrawable(this.eBT.getPageContext().getResources().getDrawable(d.f.progressbar));
        this.mProgressBar.setVisibility(8);
        ((ViewGroup) this.eBT.findViewById(16908290)).addView(this.mProgressBar);
        return this.mProgressBar;
    }

    public void onChangeSkinType(int i) {
        this.eBT.getLayoutMode().aQ(i == 1);
        this.eBT.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.caX.onChangeSkinType(getPageContext(), i);
        this.eBY.a(this.eBT, i);
        this.eBZ.a(this.eBT, i);
        this.eCa.a(this.eBT, i);
        this.eCc.a(this.eBT, i);
        this.eCd.a(this.eBT, i);
    }

    public void onResume() {
        this.eCd.e(this.eBT);
    }

    public void aII() {
        if (this.eCe == null) {
            this.eCe = new com.baidu.tbadk.core.dialog.a(this.eBT.getPageContext().getPageActivity());
            this.eCe.fb(d.j.officical_bar_info_clean_alert);
            this.eCe.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eCe.dismiss();
                    a.this.eBT.clearHistory();
                }
            });
            this.eCe.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    a.this.eCe.dismiss();
                }
            });
        }
        this.eCe.b(getPageContext()).AU();
    }

    public NoNetworkView aIJ() {
        return this.caX;
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIa = onClickListener;
    }

    public void setSwitch(boolean z) {
        this.eCa.setSwitch(z);
    }

    public void a(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eCa.c(recommendForumInfo, z);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void lc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eBT.getPageContext().getPageActivity(), this.eBW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 100), NoDataViewFactory.d.gp(i), null);
            this.mNoDataView.setOnClickListener(this.aIa);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(i));
        this.mNoDataView.onChangeSkinType(this.eBT.getPageContext(), TbadkApplication.getInst().getSkinType());
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
                    a.this.eCd.hw(false);
                    break;
                case 1:
                    a.this.eCd.hw(true);
                    break;
                case 2:
                    a.this.eCd.hw(false);
                    break;
            }
            return false;
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        this.eCd.hv(z);
        this.eCa.c(recommendForumInfo, z);
    }
}
