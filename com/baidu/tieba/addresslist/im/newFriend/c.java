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
    private NewFriendsActivity fqS;
    private BdListView fqT;
    private a fqU;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.fqS = newFriendsActivity;
        this.mRoot = this.fqS.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.fqS.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fqS.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.fqS).findViewById(R.id.new_friend_search);
        SvgManager.bjq().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fqT = (BdListView) this.fqS.findViewById(R.id.new_friend_listview);
        this.fqU = new a(this.fqS);
        this.fqT.setAdapter((ListAdapter) this.fqU);
        this.fqT.setOnItemClickListener(this.fqS);
        this.fqT.setOnItemLongClickListener(this.fqS);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.fqT.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.fqS.getActivity(), this.fqT, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.fqS.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.fqS.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oK(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.fqT.startPullRefresh();
    }

    public void completePullRefresh() {
        this.fqT.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.fqU.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.fqS.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.fqS.getPageContext(), i);
        SvgManager.bjq().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.fqT.setEmptyView(this.mNoDataView);
        this.fqU.setData(list);
        this.fqU.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.fqU.a(aVar);
        this.fqU.notifyDataSetChanged();
    }

    public void bs(List<com.baidu.tieba.im.data.a> list) {
        this.fqU.bs(list);
        this.fqU.notifyDataSetChanged();
    }

    public a bBM() {
        return this.fqU;
    }
}
