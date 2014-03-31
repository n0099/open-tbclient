package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public final class ai extends com.baidu.adp.a.f {
    private com.baidu.tbadk.a a;
    private View c;
    private BdListView d;
    private NavigationBar e;
    private ae f;
    private View g;

    public ai(com.baidu.tbadk.a aVar) {
        super(aVar);
        this.a = aVar;
        this.c = View.inflate(this.a, com.baidu.tieba.im.i.official_bar_history_activity, null);
        this.a.setContentView(this.c);
        this.e = (NavigationBar) this.c.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.e.a(com.baidu.tieba.im.j.officical_bar_info_history);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (BdListView) this.c.findViewById(com.baidu.tieba.im.h.bar_history_list);
        this.f = new ae(this.a);
        this.d.setAdapter((ListAdapter) this.f);
        this.g = View.inflate(this.a, com.baidu.tieba.im.i.official_bar_history_item_occupy, null);
        this.d.addHeaderView(this.g);
        this.d.addFooterView(this.g);
    }

    public final void a(List<bf> list) {
        this.f.a(list);
    }

    public final void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.c);
        this.e.b(i);
    }

    public final void a(com.baidu.adp.widget.ListView.t tVar) {
        this.d.setOnSrollToBottomListener(tVar);
    }

    public final boolean a() {
        return this.f.getCount() != 0 && this.d.getLastVisiblePosition() < this.f.getCount() + (-1);
    }
}
