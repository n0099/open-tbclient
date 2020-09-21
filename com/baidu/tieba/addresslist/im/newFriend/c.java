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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity fuk;
    private BdListView ful;
    private a fum;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.fuk = newFriendsActivity;
        this.mRoot = this.fuk.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.fuk.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fuk.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.fuk).findViewById(R.id.new_friend_search);
        SvgManager.bkl().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ful = (BdListView) this.fuk.findViewById(R.id.new_friend_listview);
        this.fum = new a(this.fuk);
        this.ful.setAdapter((ListAdapter) this.fum);
        this.ful.setOnItemClickListener(this.fuk);
        this.ful.setOnItemLongClickListener(this.fuk);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.ful.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.fuk.getActivity(), this.ful, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.fuk.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.fuk.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oW(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.ful.startPullRefresh();
    }

    public void completePullRefresh() {
        this.ful.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.fum.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.fuk.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.fuk.getPageContext(), i);
        SvgManager.bkl().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.ful.setEmptyView(this.mNoDataView);
        this.fum.setData(list);
        this.fum.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.fum.a(aVar);
        this.fum.notifyDataSetChanged();
    }

    public void bx(List<com.baidu.tieba.im.data.a> list) {
        this.fum.bx(list);
        this.fum.notifyDataSetChanged();
    }

    public a bCZ() {
        return this.fum;
    }
}
