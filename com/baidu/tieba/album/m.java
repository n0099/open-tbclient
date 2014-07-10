package com.baidu.tieba.album;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.core.d implements AdapterView.OnItemClickListener {
    private View b;
    private BdListView c;
    private NavigationBar d;
    private View e;
    private LinearLayout f;
    private j g;
    private AlbumActivity h;
    private e i;
    private p j;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = (AlbumActivity) getActivity();
        this.j = this.h.h();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(com.baidu.tieba.w.album_list_view, (ViewGroup) null);
        this.c = (BdListView) this.b.findViewById(com.baidu.tieba.v.album_list);
        this.d = (NavigationBar) this.b.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.h);
        this.d.a(this.h.getString(com.baidu.tieba.y.album));
        this.f = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.lay_no_data);
        this.g = new j(this.h);
        this.c.setAdapter((ListAdapter) this.g);
        this.c.setOnScrollListener(this.g);
        this.c.setOnItemClickListener(this);
        return this.b;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        g();
    }

    public void a(List<a> list) {
        if (this.g != null) {
            this.g.a(list);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private void f() {
        if (this.i == null) {
            this.i = new e(this.h);
        }
        this.i.a(new n(this));
    }

    public View a() {
        return this.e;
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a item;
        super.onItemClick(adapterView, view, i, j);
        if (this.g != null && (item = this.g.getItem(i)) != null && this.j != null && this.h != null) {
            this.j.b(item.a());
            this.j.a(item.a());
            this.h.d(1);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.h.c().a(i == 1);
        this.h.c().a(this.b);
        this.d.c(i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.i != null) {
            this.i.a();
        }
    }

    private void g() {
        this.c.setVisibility(0);
        this.f.setVisibility(8);
        f();
    }
}
