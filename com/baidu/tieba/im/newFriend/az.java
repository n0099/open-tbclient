package com.baidu.tieba.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.g<NewFriendsActivity> {
    private NewFriendsActivity bkg;
    private BdListView bkh;
    private ah bki;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private com.baidu.tbadk.core.view.ak mPullView;
    private View mRoot;

    public az(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bkg = newFriendsActivity;
        this.mRoot = this.bkg.findViewById(com.baidu.tieba.w.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bkg.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bkg.getPageContext().getString(com.baidu.tieba.z.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.add_new_friend_text, this.bkg);
        this.bkh = (BdListView) this.bkg.findViewById(com.baidu.tieba.w.new_friend_listview);
        this.bki = new ah(this.bkg);
        this.bkh.setAdapter((ListAdapter) this.bki);
        this.bkh.setOnItemClickListener(this.bkg);
        this.bkh.setOnItemLongClickListener(this.bkg);
        this.mPullView = new com.baidu.tbadk.core.view.ak(newFriendsActivity.getPageContext().getPageActivity());
        this.bkh.setPullRefresh(this.mPullView);
        this.mNoDataView = NoDataViewFactory.a(this.bkg.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.no_new_friend_hint), null);
    }

    public void jK() {
        this.bkh.jK();
    }

    public void jJ() {
        this.bkh.jJ();
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void a(aj ajVar) {
        this.bki.a(ajVar);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        cVar.ab(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bkg.getPageContext(), i);
        this.mPullView.cl(i);
        cVar.h(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.bkg.getPageContext(), i);
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.bkh.setEmptyView(this.mNoDataView);
        this.bki.setData(list);
        this.bki.notifyDataSetChanged();
    }

    public void d(com.baidu.tieba.im.data.b bVar) {
        this.bki.d(bVar);
        this.bki.notifyDataSetChanged();
    }

    public void ay(List<com.baidu.tieba.im.data.b> list) {
        this.bki.ay(list);
        this.bki.notifyDataSetChanged();
    }

    public ah RI() {
        return this.bki;
    }
}
