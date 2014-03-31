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
public final class m extends com.baidu.tbadk.core.d implements AdapterView.OnItemClickListener {
    private View a;
    private BdListView b;
    private NavigationBar c;
    private View d;
    private LinearLayout e;
    private j f;
    private AlbumActivity g;
    private e h;
    private p i;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = (AlbumActivity) getActivity();
        this.i = this.g.f();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(com.baidu.tieba.a.i.album_list_view, (ViewGroup) null);
        this.b = (BdListView) this.a.findViewById(com.baidu.tieba.a.h.album_list);
        this.c = (NavigationBar) this.a.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.d = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.g);
        this.c.a(this.g.getString(com.baidu.tieba.a.k.album));
        this.e = (LinearLayout) this.a.findViewById(com.baidu.tieba.a.h.lay_no_data);
        this.f = new j(this.g);
        this.b.setAdapter((ListAdapter) this.f);
        this.b.setOnScrollListener(this.f);
        this.b.setOnItemClickListener(this);
        return this.a;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        this.b.setVisibility(0);
        this.e.setVisibility(8);
        if (this.h == null) {
            this.h = new e(this.g);
        }
        this.h.a(new n(this));
    }

    public final void a(List<a> list) {
        if (this.f != null) {
            this.f.a(list);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    public final View a() {
        return this.d;
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a item;
        super.onItemClick(adapterView, view, i, j);
        if (this.f != null && (item = this.f.getItem(i)) != null && this.i != null && this.g != null) {
            this.i.b(item.a());
            this.i.a(item.a());
            this.g.e(1);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.g.b().a(i == 1);
        this.g.b().a(this.a);
        this.c.b(i);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.a();
        }
    }
}
