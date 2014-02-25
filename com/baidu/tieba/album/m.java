package com.baidu.tieba.album;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.j implements AdapterView.OnItemClickListener, t {
    private View b;
    private BdListView c;
    private NavigationBar d;
    private ImageView e;
    private RelativeLayout f;
    private j g;
    private AlbumActivity h;
    private e i;
    private p j;
    private boolean k;

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = (AlbumActivity) getActivity();
        this.j = this.h.f();
        q.a().a(this);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.album_list_view, (ViewGroup) null);
        this.c = (BdListView) this.b.findViewById(R.id.album_list);
        this.d = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.h);
        this.d.a(this.h.getString(R.string.album));
        this.f = (RelativeLayout) this.b.findViewById(R.id.lay_no_data);
        this.g = new j(this.h);
        this.c.setAdapter((ListAdapter) this.g);
        this.c.setOnScrollListener(this.g);
        this.c.setOnItemClickListener(this);
        return this.b;
    }

    public void a(List<a> list) {
        if (this.g != null) {
            this.g.a(list);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        d();
    }

    private void c() {
        if (this.i == null) {
            this.i = new e(this.h);
        }
        this.i.a(new n(this));
    }

    public ImageView a() {
        return this.e;
    }

    @Override // com.baidu.tieba.j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a item;
        super.onItemClick(adapterView, view, i, j);
        if (this.g != null && (item = this.g.getItem(i)) != null && this.j != null && this.h != null) {
            this.j.b(item.a());
            this.j.a(item.a());
            this.h.d(1);
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        this.h.a().a(i == 1);
        this.h.a().a(this.b);
        this.d.c(i);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.i != null) {
            this.i.a();
        }
        q.a().b(this);
    }

    @Override // com.baidu.tieba.album.t
    public void a(boolean z) {
        this.k = z;
        d();
    }

    private void d() {
        if (this.k) {
            this.c.setVisibility(8);
            this.f.setVisibility(0);
            return;
        }
        this.c.setVisibility(0);
        this.f.setVisibility(8);
        c();
    }
}
