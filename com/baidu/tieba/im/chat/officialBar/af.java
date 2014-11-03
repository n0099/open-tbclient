package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private BaseActivity Or;
    private ad aRD;
    private View aRE;
    private BdListView aoo;
    private NavigationBar aop;
    private View mRoot;

    public af(BaseActivity baseActivity) {
        super(baseActivity);
        this.Or = baseActivity;
        nu();
    }

    private void nu() {
        this.mRoot = View.inflate(this.Or, com.baidu.tieba.w.official_bar_history_activity, null);
        this.Or.setContentView(this.mRoot);
        this.aop = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aop.setTitleText(com.baidu.tieba.y.officical_bar_info_history);
        this.aop.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoo = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.bar_history_list);
        this.aRD = new ad(this.Or);
        this.aoo.setAdapter((ListAdapter) this.aRD);
        this.aRE = View.inflate(this.Or, com.baidu.tieba.w.official_bar_history_item_occupy, null);
        this.aoo.addHeaderView(this.aRE);
        this.aoo.addFooterView(this.aRE);
    }

    public void setData(List<az> list) {
        this.aRD.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.Or.getLayoutMode().L(i == 1);
        this.Or.getLayoutMode().h(this.mRoot);
        this.aop.onChangeSkinType(i);
    }

    public void b(com.baidu.adp.widget.ListView.aa aaVar) {
        this.aoo.setOnSrollToBottomListener(aaVar);
    }

    public boolean Kv() {
        return this.aRD.getCount() != 0 && this.aoo.getLastVisiblePosition() < this.aRD.getCount() + (-1);
    }
}
