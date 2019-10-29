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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity dkB;
    private BdListView dkC;
    private a dkD;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.dkB = newFriendsActivity;
        this.mRoot = this.dkB.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.dkB.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dkB.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.dkB).findViewById(R.id.new_friend_search);
        SvgManager.amN().a(this.mSearchButton, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.dkC = (BdListView) this.dkB.findViewById(R.id.new_friend_listview);
        this.dkD = new a(this.dkB);
        this.dkC.setAdapter((ListAdapter) this.dkD);
        this.dkC.setOnItemClickListener(this.dkB);
        this.dkC.setOnItemLongClickListener(this.dkB);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.dkC.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.dkB.getActivity(), this.dkC, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.dkB.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.dkB.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iL(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.dkC.startPullRefresh();
    }

    public void completePullRefresh() {
        this.dkC.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.dkD.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.dkB.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.dkB.getPageContext(), i);
        SvgManager.amN().a(this.mSearchButton, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.dkC.setEmptyView(this.mNoDataView);
        this.dkD.setData(list);
        this.dkD.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.dkD.a(aVar);
        this.dkD.notifyDataSetChanged();
    }

    public void aT(List<com.baidu.tieba.im.data.a> list) {
        this.dkD.aT(list);
        this.dkD.notifyDataSetChanged();
    }

    public a aEq() {
        return this.dkD;
    }
}
