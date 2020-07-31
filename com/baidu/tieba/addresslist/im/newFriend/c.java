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
/* loaded from: classes15.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private BdListView ffA;
    private a ffB;
    private NewFriendsActivity ffz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.ffz = newFriendsActivity;
        this.mRoot = this.ffz.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.ffz.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ffz.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.ffz).findViewById(R.id.new_friend_search);
        SvgManager.baR().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ffA = (BdListView) this.ffz.findViewById(R.id.new_friend_listview);
        this.ffB = new a(this.ffz);
        this.ffA.setAdapter((ListAdapter) this.ffB);
        this.ffA.setOnItemClickListener(this.ffz);
        this.ffA.setOnItemLongClickListener(this.ffz);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.ffA.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.ffz.getActivity(), this.ffA, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.ffz.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.ffz.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mF(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.ffA.startPullRefresh();
    }

    public void completePullRefresh() {
        this.ffA.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.ffB.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.ffz.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.ffz.getPageContext(), i);
        SvgManager.baR().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.ffA.setEmptyView(this.mNoDataView);
        this.ffB.setData(list);
        this.ffB.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.ffB.a(aVar);
        this.ffB.notifyDataSetChanged();
    }

    public void bs(List<com.baidu.tieba.im.data.a> list) {
        this.ffB.bs(list);
        this.ffB.notifyDataSetChanged();
    }

    public a bsP() {
        return this.ffB;
    }
}
