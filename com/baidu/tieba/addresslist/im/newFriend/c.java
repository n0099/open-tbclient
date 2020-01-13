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
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity dXC;
    private BdListView dXD;
    private a dXE;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.dXC = newFriendsActivity;
        this.mRoot = this.dXC.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.dXC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dXC.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.dXC).findViewById(R.id.new_friend_search);
        SvgManager.aEp().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.dXD = (BdListView) this.dXC.findViewById(R.id.new_friend_listview);
        this.dXE = new a(this.dXC);
        this.dXD.setAdapter((ListAdapter) this.dXE);
        this.dXD.setOnItemClickListener(this.dXC);
        this.dXD.setOnItemLongClickListener(this.dXC);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.dXD.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.dXC.getActivity(), this.dXD, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.dXC.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.dXC.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.dXD.startPullRefresh();
    }

    public void completePullRefresh() {
        this.dXD.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.dXE.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.dXC.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.dXC.getPageContext(), i);
        SvgManager.aEp().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.dXD.setEmptyView(this.mNoDataView);
        this.dXE.setData(list);
        this.dXE.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.dXE.a(aVar);
        this.dXE.notifyDataSetChanged();
    }

    public void aZ(List<com.baidu.tieba.im.data.a> list) {
        this.dXE.aZ(list);
        this.dXE.notifyDataSetChanged();
    }

    public a aWB() {
        return this.dXE;
    }
}
