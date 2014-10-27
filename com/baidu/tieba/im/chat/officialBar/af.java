package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private BaseActivity On;
    private ad aRp;
    private View aRq;
    private BdListView aof;
    private NavigationBar aog;
    private View mRoot;

    public af(BaseActivity baseActivity) {
        super(baseActivity);
        this.On = baseActivity;
        nu();
    }

    private void nu() {
        this.mRoot = View.inflate(this.On, com.baidu.tieba.w.official_bar_history_activity, null);
        this.On.setContentView(this.mRoot);
        this.aog = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aog.setTitleText(com.baidu.tieba.y.officical_bar_info_history);
        this.aog.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aof = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.bar_history_list);
        this.aRp = new ad(this.On);
        this.aof.setAdapter((ListAdapter) this.aRp);
        this.aRq = View.inflate(this.On, com.baidu.tieba.w.official_bar_history_item_occupy, null);
        this.aof.addHeaderView(this.aRq);
        this.aof.addFooterView(this.aRq);
    }

    public void setData(List<az> list) {
        this.aRp.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.On.getLayoutMode().L(i == 1);
        this.On.getLayoutMode().h(this.mRoot);
        this.aog.onChangeSkinType(i);
    }

    public void b(com.baidu.adp.widget.ListView.aa aaVar) {
        this.aof.setOnSrollToBottomListener(aaVar);
    }

    public boolean Kr() {
        return this.aRp.getCount() != 0 && this.aof.getLastVisiblePosition() < this.aRp.getCount() + (-1);
    }
}
