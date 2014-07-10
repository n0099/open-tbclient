package com.baidu.tieba.discover;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f {
    private BaseActivity a;
    private View b;
    private BdListView c;
    private NavigationBar d;
    private View e;
    private q f;

    public s(BaseActivity baseActivity) {
        super(baseActivity);
        this.a = baseActivity;
        a();
    }

    private void a() {
        this.b = View.inflate(this.a, w.discover_square_activity, null);
        this.a.setContentView(this.b);
        this.d = (NavigationBar) this.b.findViewById(v.discoversquare_navigation_bar);
        this.d.a(y.square);
        this.e = (View) this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
        this.e.setOnClickListener(new t(this));
        this.c = (BdListView) this.b.findViewById(v.discover_squar_list);
        this.f = new q(this.a);
        this.c.setAdapter((ListAdapter) this.f);
        this.c.setOnItemClickListener(this.a);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.b);
        this.d.c(i);
        this.f.a(i);
    }
}
