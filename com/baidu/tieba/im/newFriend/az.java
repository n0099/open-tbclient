package com.baidu.tieba.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.g<NewFriendsActivity> {
    private NewFriendsActivity blD;
    private BdListView blE;
    private ah blF;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private com.baidu.tbadk.core.view.ak mPullView;
    private View mRoot;

    public az(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.blD = newFriendsActivity;
        this.mRoot = this.blD.findViewById(com.baidu.tieba.w.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.blD.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.blD.getPageContext().getString(com.baidu.tieba.z.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.add_new_friend_text, this.blD);
        this.blE = (BdListView) this.blD.findViewById(com.baidu.tieba.w.new_friend_listview);
        this.blF = new ah(this.blD);
        this.blE.setAdapter((ListAdapter) this.blF);
        this.blE.setOnItemClickListener(this.blD);
        this.blE.setOnItemLongClickListener(this.blD);
        this.mPullView = new com.baidu.tbadk.core.view.ak(newFriendsActivity.getPageContext());
        this.blE.setPullRefresh(this.mPullView);
        this.mNoDataView = NoDataViewFactory.a(this.blD.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.no_new_friend_hint), null);
    }

    public void jJ() {
        this.blE.jJ();
    }

    public void jI() {
        this.blE.jI();
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void a(aj ajVar) {
        this.blF.a(ajVar);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        cVar.ab(i == 1);
        this.mNavigationBar.onChangeSkinType(this.blD.getPageContext(), i);
        this.mPullView.cs(i);
        cVar.h(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.blD.getPageContext(), i);
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.blE.setEmptyView(this.mNoDataView);
        this.blF.setData(list);
        this.blF.notifyDataSetChanged();
    }

    public void d(com.baidu.tieba.im.data.b bVar) {
        this.blF.d(bVar);
        this.blF.notifyDataSetChanged();
    }

    public void aB(List<com.baidu.tieba.im.data.b> list) {
        this.blF.aB(list);
        this.blF.notifyDataSetChanged();
    }

    public ah Se() {
        return this.blF;
    }
}
