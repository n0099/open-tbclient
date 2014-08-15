package com.baidu.tieba.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.f {
    private BaseActivity a;
    private NavigationBar b;
    private BdListView c;
    private ad d;
    private com.baidu.tbadk.core.view.u e;
    private View f;

    public av(BaseActivity baseActivity) {
        super(baseActivity);
        this.a = baseActivity;
        this.b = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.b.a(this.a.getString(com.baidu.tieba.x.new_friends));
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.add_new_friend_text, this.a);
        this.c = (BdListView) this.a.findViewById(com.baidu.tieba.u.new_friend_listview);
        this.d = new ad(this.a);
        this.c.setAdapter((ListAdapter) this.d);
        this.c.setOnItemClickListener(this.a);
        this.c.setOnItemLongClickListener(this.a);
        this.e = new com.baidu.tbadk.core.view.u(baseActivity);
        this.c.setPullRefresh(this.e);
        this.f = this.a.findViewById(com.baidu.tieba.u.no_new_friend_msg_container);
    }

    public void a() {
        this.c.e();
    }

    public void b() {
        this.c.d();
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.e.a(dVar);
    }

    public void a(af afVar) {
        this.d.a(afVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.a(i == 1);
        this.b.c(i);
        this.e.a(i);
        cVar.a((View) this.c);
        cVar.a(this.f);
    }

    public void a(List<com.baidu.tieba.im.data.k> list) {
        this.c.setEmptyView(this.f);
        this.d.a(list);
        this.d.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.k kVar) {
        this.d.a(kVar);
        this.d.notifyDataSetChanged();
    }

    public void b(List<com.baidu.tieba.im.data.k> list) {
        this.d.b(list);
        this.d.notifyDataSetChanged();
    }

    public ad c() {
        return this.d;
    }
}
