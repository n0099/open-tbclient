package com.baidu.tieba.im.chat.officialBar;

import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.f {
    private OfficialBarTipListAdapter aRX;
    private OfficialBarTipActivity aRY;
    private com.baidu.tbadk.core.view.o ahO;
    private BdListView azz;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public au(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity);
        officialBarTipActivity.setContentView(com.baidu.tieba.w.officialbar_msg_activity);
        this.aRY = officialBarTipActivity;
        d(officialBarTipActivity);
        e(officialBarTipActivity);
    }

    private void d(OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(officialBarTipActivity.getString(com.baidu.tieba.y.official_message_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new av(this, officialBarTipActivity));
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(com.baidu.tieba.v.root_view);
    }

    public void onChangeSkinType(int i) {
        this.aRY.getLayoutMode().L(i == 1);
        this.aRY.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
    }

    private void e(OfficialBarTipActivity officialBarTipActivity) {
        this.azz = (BdListView) officialBarTipActivity.findViewById(com.baidu.tieba.v.msg_list);
        this.aRX = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.azz.setAdapter((ListAdapter) this.aRX);
        this.ahO = NoDataViewFactory.a(officialBarTipActivity, this.mRootView, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.official_message_activity_no_data), null);
    }

    public BdListView ER() {
        return this.azz;
    }

    public OfficialBarTipListAdapter Ky() {
        return this.aRX;
    }
}
