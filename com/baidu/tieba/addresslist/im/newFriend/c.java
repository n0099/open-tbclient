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
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity ebH;
    private BdListView ebI;
    private a ebJ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.ebH = newFriendsActivity;
        this.mRoot = this.ebH.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.ebH.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ebH.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.ebH).findViewById(R.id.new_friend_search);
        SvgManager.aGC().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ebI = (BdListView) this.ebH.findViewById(R.id.new_friend_listview);
        this.ebJ = new a(this.ebH);
        this.ebI.setAdapter((ListAdapter) this.ebJ);
        this.ebI.setOnItemClickListener(this.ebH);
        this.ebI.setOnItemLongClickListener(this.ebH);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.ebI.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.ebH.getActivity(), this.ebI, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.ebH.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.ebH.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.ebI.startPullRefresh();
    }

    public void completePullRefresh() {
        this.ebI.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.ebJ.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.ebH.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.ebH.getPageContext(), i);
        SvgManager.aGC().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.ebI.setEmptyView(this.mNoDataView);
        this.ebJ.setData(list);
        this.ebJ.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.ebJ.a(aVar);
        this.ebJ.notifyDataSetChanged();
    }

    public void aZ(List<com.baidu.tieba.im.data.a> list) {
        this.ebJ.aZ(list);
        this.ebJ.notifyDataSetChanged();
    }

    public a aYS() {
        return this.ebJ;
    }
}
