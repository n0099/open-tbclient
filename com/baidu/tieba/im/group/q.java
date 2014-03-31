package com.baidu.tieba.im.group;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public final class q {
    private com.baidu.tbadk.core.e a;
    private b b;
    private View c;
    private BdListView d;
    private l e;
    private com.baidu.tbadk.core.view.q f;
    private NoNetworkView g;

    public q(com.baidu.tbadk.core.e eVar, b bVar) {
        this.a = eVar;
        this.b = bVar;
        this.c = this.b.getView();
        this.f = new com.baidu.tbadk.core.view.q(this.a);
        this.d = (BdListView) this.c.findViewById(com.baidu.tieba.im.h.list_view);
        this.d.setPullRefresh(this.f);
        this.e = new l(bVar);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnScrollListener(this.e);
        this.g = (NoNetworkView) this.c.findViewById(com.baidu.tieba.im.h.view_no_network_group);
    }

    public final l a() {
        return this.e;
    }

    public final BdListView b() {
        return this.d;
    }

    public final void c() {
        this.d.b();
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.f.a(dVar);
    }

    public final void d() {
        this.d.c();
    }

    public final void a(int i) {
        this.a.b().a(i == 1);
        this.a.b().a(this.c);
        this.g.a(i);
        this.e.a();
        this.f.a(i);
    }

    public final void b(int i) {
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public final void a(String str, String str2) {
        if (this.e != null) {
            this.e.a(str2, str);
        }
    }
}
