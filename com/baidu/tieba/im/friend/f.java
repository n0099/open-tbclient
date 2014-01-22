package com.baidu.tieba.im.friend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.an;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.e {
    private IMBlackListActivity a;
    private NoNetworkView c;
    private NavigationBar d;
    private View e;
    private ImageView f;
    private BdListView g;
    private c h;
    private TextView i;
    private ProgressBar j;
    private com.baidu.tbadk.imageManager.c k;

    public f(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity);
        this.k = new g(this);
        this.a = iMBlackListActivity;
        h();
    }

    public void a() {
        this.j.setVisibility(0);
    }

    public void e() {
        this.j.setVisibility(8);
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.h.a(aVar);
        if (this.h.getCount() <= 0) {
            this.g.setVisibility(8);
            this.i.setVisibility(0);
            return;
        }
        this.g.setVisibility(0);
        this.i.setVisibility(8);
        this.h.notifyDataSetChanged();
        f();
    }

    public void a(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.g.setVisibility(8);
            this.i.setVisibility(0);
            return;
        }
        this.g.setVisibility(0);
        this.i.setVisibility(8);
        this.h.a(arrayList);
        this.h.notifyDataSetChanged();
        f();
    }

    private void h() {
        this.a.setContentView(R.layout.im_black_list);
        this.e = this.a.findViewById(R.id.root_view);
        this.c = (NoNetworkView) this.e.findViewById(R.id.view_no_network);
        this.d = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.d.a(R.string.black_list_title);
        this.f = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g = (BdListView) this.e.findViewById(R.id.black_list);
        this.i = (TextView) this.e.findViewById(R.id.no_data_container);
        this.j = (ProgressBar) this.e.findViewById(R.id.progress);
        this.h = new c(this.a);
        this.g.setAdapter((ListAdapter) this.h);
        g();
        i();
    }

    private void i() {
        int al = TiebaApplication.h().al();
        this.a.getLayoutMode().a(al == 1);
        this.a.getLayoutMode().a(this.e);
        this.d.c(al);
    }

    public void f() {
        an.a(this.g, this.h.a(), null, this.k, null, 0, 1);
    }

    public void g() {
        this.g.setOnScrollListener(new h(this));
    }
}
