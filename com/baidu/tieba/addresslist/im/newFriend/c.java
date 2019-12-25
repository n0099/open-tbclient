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
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity dXt;
    private BdListView dXu;
    private a dXv;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.dXt = newFriendsActivity;
        this.mRoot = this.dXt.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.dXt.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dXt.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.dXt).findViewById(R.id.new_friend_search);
        SvgManager.aDW().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.dXu = (BdListView) this.dXt.findViewById(R.id.new_friend_listview);
        this.dXv = new a(this.dXt);
        this.dXu.setAdapter((ListAdapter) this.dXv);
        this.dXu.setOnItemClickListener(this.dXt);
        this.dXu.setOnItemLongClickListener(this.dXt);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.dXu.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.dXt.getActivity(), this.dXu, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.dXt.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.dXt.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.dXu.startPullRefresh();
    }

    public void completePullRefresh() {
        this.dXu.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.dXv.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.dXt.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.dXt.getPageContext(), i);
        SvgManager.aDW().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.dXu.setEmptyView(this.mNoDataView);
        this.dXv.setData(list);
        this.dXv.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.dXv.a(aVar);
        this.dXv.notifyDataSetChanged();
    }

    public void ba(List<com.baidu.tieba.im.data.a> list) {
        this.dXv.ba(list);
        this.dXv.notifyDataSetChanged();
    }

    public a aWh() {
        return this.dXv;
    }
}
