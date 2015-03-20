package com.baidu.tieba.im.chat.officialBar;

import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.g<OfficialBarTipActivity> {
    private OfficialBarTipListAdapter aZH;
    private OfficialBarTipActivity aZI;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private ViewGroup mRootView;

    public ap(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        officialBarTipActivity.setContentView(com.baidu.tieba.w.officialbar_msg_activity);
        this.aZI = officialBarTipActivity;
        d(officialBarTipActivity);
        e(officialBarTipActivity);
    }

    private void d(OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(officialBarTipActivity.getPageContext().getString(com.baidu.tieba.y.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aq(this, officialBarTipActivity));
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(com.baidu.tieba.v.root_view);
    }

    public void onChangeSkinType(int i) {
        this.aZI.getLayoutMode().X(i == 1);
        this.aZI.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.aZI.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aZI.getPageContext(), i);
        }
    }

    private void e(OfficialBarTipActivity officialBarTipActivity) {
        this.mBdListView = (BdListView) officialBarTipActivity.findViewById(com.baidu.tieba.v.msg_list);
        this.aZH = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.mBdListView.setAdapter((ListAdapter) this.aZH);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.official_message_activity_no_data), null);
    }

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    public OfficialBarTipListAdapter Of() {
        return this.aZH;
    }
}
