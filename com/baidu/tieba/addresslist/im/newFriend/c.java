package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity eBX;
    private BdListView eBY;
    private a eBZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.eBX = newFriendsActivity;
        this.mRoot = this.eBX.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.eBX.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eBX.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.eBX).findViewById(R.id.new_friend_search);
        SvgManager.aOU().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.eBY = (BdListView) this.eBX.findViewById(R.id.new_friend_listview);
        this.eBZ = new a(this.eBX);
        this.eBY.setAdapter((ListAdapter) this.eBZ);
        this.eBY.setOnItemClickListener(this.eBX);
        this.eBY.setOnItemLongClickListener(this.eBX);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.eBY.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.eBX.getActivity(), this.eBY, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.eBX.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.eBX.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.eBY.startPullRefresh();
    }

    public void completePullRefresh() {
        this.eBY.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.eBZ.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.eBX.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.eBX.getPageContext(), i);
        SvgManager.aOU().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.eBY.setEmptyView(this.mNoDataView);
        this.eBZ.setData(list);
        this.eBZ.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.eBZ.a(aVar);
        this.eBZ.notifyDataSetChanged();
    }

    public void bj(List<com.baidu.tieba.im.data.a> list) {
        this.eBZ.bj(list);
        this.eBZ.notifyDataSetChanged();
    }

    public a bhb() {
        return this.eBZ;
    }
}
