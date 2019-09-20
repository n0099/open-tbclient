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
    private NewFriendsActivity dbe;
    private BdListView dbf;
    private a dbg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.dbe = newFriendsActivity;
        this.mRoot = this.dbe.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.dbe.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dbe.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.dbe).findViewById(R.id.new_friend_search);
        SvgManager.ajv().a(this.mSearchButton, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.dbf = (BdListView) this.dbe.findViewById(R.id.new_friend_listview);
        this.dbg = new a(this.dbe);
        this.dbf.setAdapter((ListAdapter) this.dbg);
        this.dbf.setOnItemClickListener(this.dbe);
        this.dbf.setOnItemLongClickListener(this.dbe);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.dbf.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.dbe.getActivity(), this.dbf, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.dbe.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.dbe.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iQ(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.dbf.startPullRefresh();
    }

    public void completePullRefresh() {
        this.dbf.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.dbg.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.dbe.getPageContext(), i);
        this.mPullView.iY(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.dbe.getPageContext(), i);
        SvgManager.ajv().a(this.mSearchButton, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.dbf.setEmptyView(this.mNoDataView);
        this.dbg.setData(list);
        this.dbg.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.dbg.a(aVar);
        this.dbg.notifyDataSetChanged();
    }

    public void aB(List<com.baidu.tieba.im.data.a> list) {
        this.dbg.aB(list);
        this.dbg.notifyDataSetChanged();
    }

    public a aEg() {
        return this.dbg;
    }
}
