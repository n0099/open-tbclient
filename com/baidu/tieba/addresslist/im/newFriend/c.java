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
    private NewFriendsActivity fGt;
    private BdListView fGu;
    private a fGv;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.fGt = newFriendsActivity;
        this.mRoot = this.fGt.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.fGt.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fGt.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.fGt).findViewById(R.id.new_friend_search);
        SvgManager.bmU().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fGu = (BdListView) this.fGt.findViewById(R.id.new_friend_listview);
        this.fGv = new a(this.fGt);
        this.fGu.setAdapter((ListAdapter) this.fGv);
        this.fGu.setOnItemClickListener(this.fGt);
        this.fGu.setOnItemLongClickListener(this.fGt);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.fGu.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.fGt.getActivity(), this.fGu, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.fGt.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.fGt.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pv(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.fGu.startPullRefresh();
    }

    public void completePullRefresh() {
        this.fGu.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.fGv.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.fGt.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.fGt.getPageContext(), i);
        SvgManager.bmU().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.fGu.setEmptyView(this.mNoDataView);
        this.fGv.setData(list);
        this.fGv.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.fGv.a(aVar);
        this.fGv.notifyDataSetChanged();
    }

    public void bA(List<com.baidu.tieba.im.data.a> list) {
        this.fGv.bA(list);
        this.fGv.notifyDataSetChanged();
    }

    public a bFL() {
        return this.fGv;
    }
}
