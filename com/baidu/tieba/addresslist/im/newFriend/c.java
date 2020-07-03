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
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity faX;
    private BdListView faY;
    private a faZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.faX = newFriendsActivity;
        this.mRoot = this.faX.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.faX.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.faX.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.faX).findViewById(R.id.new_friend_search);
        SvgManager.aWQ().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.faY = (BdListView) this.faX.findViewById(R.id.new_friend_listview);
        this.faZ = new a(this.faX);
        this.faY.setAdapter((ListAdapter) this.faZ);
        this.faY.setOnItemClickListener(this.faX);
        this.faY.setOnItemLongClickListener(this.faX);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.faY.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.faX.getActivity(), this.faY, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.faX.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.faX.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mm(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.faY.startPullRefresh();
    }

    public void completePullRefresh() {
        this.faY.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.faZ.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.faX.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.faX.getPageContext(), i);
        SvgManager.aWQ().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.faY.setEmptyView(this.mNoDataView);
        this.faZ.setData(list);
        this.faZ.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.faZ.a(aVar);
        this.faZ.notifyDataSetChanged();
    }

    public void bo(List<com.baidu.tieba.im.data.a> list) {
        this.faZ.bo(list);
        this.faZ.notifyDataSetChanged();
    }

    public a bpM() {
        return this.faZ;
    }
}
