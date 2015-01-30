package com.baidu.tieba.im.chat.officialBar;

import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.g<OfficialBarTipActivity> {
    private OfficialBarTipListAdapter aUU;
    private OfficialBarTipActivity aUV;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private ViewGroup mRootView;

    public ao(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        officialBarTipActivity.setContentView(com.baidu.tieba.x.officialbar_msg_activity);
        this.aUV = officialBarTipActivity;
        d(officialBarTipActivity);
        e(officialBarTipActivity);
    }

    private void d(OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(officialBarTipActivity.getPageContext().getString(com.baidu.tieba.z.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ap(this, officialBarTipActivity));
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(com.baidu.tieba.w.root_view);
    }

    public void onChangeSkinType(int i) {
        this.aUV.getLayoutMode().ab(i == 1);
        this.aUV.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.aUV.getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aUV.getPageContext(), i);
        }
    }

    private void e(OfficialBarTipActivity officialBarTipActivity) {
        this.mBdListView = (BdListView) officialBarTipActivity.findViewById(com.baidu.tieba.w.msg_list);
        this.aUU = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.mBdListView.setAdapter((ListAdapter) this.aUU);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.official_message_activity_no_data), null);
    }

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    public OfficialBarTipListAdapter Lf() {
        return this.aUU;
    }
}
