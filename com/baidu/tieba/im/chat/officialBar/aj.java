package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.f {
    private BaseActivity a;
    private View b;
    private BdListView c;
    private NavigationBar d;
    private ah e;
    private View f;

    public aj(BaseActivity baseActivity) {
        super(baseActivity);
        this.a = baseActivity;
        b();
    }

    private void b() {
        this.b = View.inflate(this.a, com.baidu.tieba.w.official_bar_history_activity, null);
        this.a.setContentView(this.b);
        this.d = (NavigationBar) this.b.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.d.a(com.baidu.tieba.y.officical_bar_info_history);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c = (BdListView) this.b.findViewById(com.baidu.tieba.v.bar_history_list);
        this.e = new ah(this.a);
        this.c.setAdapter((ListAdapter) this.e);
        this.f = View.inflate(this.a, com.baidu.tieba.w.official_bar_history_item_occupy, null);
        this.c.addHeaderView(this.f);
        this.c.addFooterView(this.f);
    }

    public void a(List<be> list) {
        this.e.a(list);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.b);
        this.d.c(i);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.c.setOnSrollToBottomListener(xVar);
    }

    public boolean a() {
        return this.e.getCount() != 0 && this.c.getLastVisiblePosition() < this.e.getCount() + (-1);
    }
}
