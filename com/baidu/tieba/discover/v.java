package com.baidu.tieba.discover;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f {
    private View Jt;
    private BaseActivity Or;
    private BdListView aoo;
    private NavigationBar aop;
    private t aoq;
    private View mRoot;

    public v(BaseActivity baseActivity) {
        super(baseActivity);
        this.Or = baseActivity;
        nu();
    }

    private void nu() {
        this.mRoot = View.inflate(this.Or, com.baidu.tieba.w.discover_square_activity, null);
        this.Or.setContentView(this.mRoot);
        this.aop = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.discoversquare_navigation_bar);
        this.aop.setTitleText(y.square);
        this.Jt = (View) this.aop.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.Jt.setOnClickListener(new w(this));
        this.aoo = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.discover_squar_list);
        this.aoq = new t(this.Or);
        this.aoo.setAdapter((ListAdapter) this.aoq);
        this.aoo.setOnItemClickListener(this.Or);
    }

    public void onChangeSkinType(int i) {
        this.Or.getLayoutMode().L(i == 1);
        this.Or.getLayoutMode().h(this.mRoot);
        this.aop.onChangeSkinType(i);
        this.aoq.onChangeSkinType(i);
    }
}
