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
    private NewFriendsActivity fUE;
    private BdListView fUF;
    private a fUG;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.fUE = newFriendsActivity;
        this.mRoot = this.fUE.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.fUE.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fUE.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.fUE).findViewById(R.id.new_friend_search);
        SvgManager.brn().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fUF = (BdListView) this.fUE.findViewById(R.id.new_friend_listview);
        this.fUG = new a(this.fUE);
        this.fUF.setAdapter((ListAdapter) this.fUG);
        this.fUF.setOnItemClickListener(this.fUE);
        this.fUF.setOnItemLongClickListener(this.fUE);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.fUF.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.fUE.getActivity(), this.fUF, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.fUE.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.fUE.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pQ(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.fUF.startPullRefresh();
    }

    public void completePullRefresh() {
        this.fUF.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.fUG.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.fUE.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.fUE.getPageContext(), i);
        SvgManager.brn().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.fUF.setEmptyView(this.mNoDataView);
        this.fUG.setData(list);
        this.fUG.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.fUG.a(aVar);
        this.fUG.notifyDataSetChanged();
    }

    public void bQ(List<com.baidu.tieba.im.data.a> list) {
        this.fUG.bQ(list);
        this.fUG.notifyDataSetChanged();
    }

    public a bKd() {
        return this.fUG;
    }
}
