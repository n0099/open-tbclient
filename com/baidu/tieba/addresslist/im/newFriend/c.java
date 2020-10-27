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
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity fOO;
    private BdListView fOP;
    private a fOQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.fOO = newFriendsActivity;
        this.mRoot = this.fOO.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.fOO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fOO.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.fOO).findViewById(R.id.new_friend_search);
        SvgManager.boN().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fOP = (BdListView) this.fOO.findViewById(R.id.new_friend_listview);
        this.fOQ = new a(this.fOO);
        this.fOP.setAdapter((ListAdapter) this.fOQ);
        this.fOP.setOnItemClickListener(this.fOO);
        this.fOP.setOnItemLongClickListener(this.fOO);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.fOP.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.fOO.getActivity(), this.fOP, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.fOO.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.fOO.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pG(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.fOP.startPullRefresh();
    }

    public void completePullRefresh() {
        this.fOP.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.fOQ.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.fOO.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.fOO.getPageContext(), i);
        SvgManager.boN().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.fOP.setEmptyView(this.mNoDataView);
        this.fOQ.setData(list);
        this.fOQ.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.fOQ.a(aVar);
        this.fOQ.notifyDataSetChanged();
    }

    public void bJ(List<com.baidu.tieba.im.data.a> list) {
        this.fOQ.bJ(list);
        this.fOQ.notifyDataSetChanged();
    }

    public a bHE() {
        return this.fOQ;
    }
}
