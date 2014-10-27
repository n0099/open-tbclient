package com.baidu.tieba.discover;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f {
    private View Js;
    private BaseActivity On;
    private BdListView aof;
    private NavigationBar aog;
    private t aoh;
    private View mRoot;

    public v(BaseActivity baseActivity) {
        super(baseActivity);
        this.On = baseActivity;
        nu();
    }

    private void nu() {
        this.mRoot = View.inflate(this.On, com.baidu.tieba.w.discover_square_activity, null);
        this.On.setContentView(this.mRoot);
        this.aog = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.discoversquare_navigation_bar);
        this.aog.setTitleText(y.square);
        this.Js = (View) this.aog.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.Js.setOnClickListener(new w(this));
        this.aof = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.discover_squar_list);
        this.aoh = new t(this.On);
        this.aof.setAdapter((ListAdapter) this.aoh);
        this.aof.setOnItemClickListener(this.On);
    }

    public void onChangeSkinType(int i) {
        this.On.getLayoutMode().L(i == 1);
        this.On.getLayoutMode().h(this.mRoot);
        this.aog.onChangeSkinType(i);
        this.aoh.onChangeSkinType(i);
    }
}
