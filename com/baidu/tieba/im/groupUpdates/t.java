package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public final class t extends com.baidu.adp.a.f {
    private View a;
    private View c;
    private UpdatesActivity d;
    private BdListView e;
    private h f;
    private ProgressBar g;
    private Button h;
    private Button i;
    private Button j;
    private NavigationBar k;
    private View l;
    private View m;

    public t(UpdatesActivity updatesActivity) {
        super(updatesActivity);
        this.d = updatesActivity;
        this.a = View.inflate(this.d, com.baidu.tieba.im.i.updates_activity, null);
        this.d.setContentView(this.a);
        this.k = (NavigationBar) this.d.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.c = this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k.a(this.d.getString(com.baidu.tieba.im.j.updates_activity_title));
        this.l = this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.im.i.updates_activity_nav_left, (View.OnClickListener) null);
        this.m = this.k.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.im.i.updates_activity_nav_right, (View.OnClickListener) null);
        this.j = (Button) this.l.findViewById(com.baidu.tieba.im.h.btn_delete);
        this.j.setOnClickListener(this.d);
        this.c.setOnClickListener(this.d);
        this.e = (BdListView) this.a.findViewById(com.baidu.tieba.im.h.updates_list);
        this.g = (ProgressBar) this.a.findViewById(com.baidu.tieba.im.h.pro_load);
        this.h = (Button) this.m.findViewById(com.baidu.tieba.im.h.btn_edit);
        this.h.setOnClickListener(this.d);
        this.i = (Button) this.m.findViewById(com.baidu.tieba.im.h.btn_cancel);
        this.i.setOnClickListener(this.d);
        a(0);
        a(false);
        this.f = new h(this.d);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnScrollListener(this.d);
    }

    @Override // com.baidu.adp.a.f
    public final void c() {
        super.c();
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
        this.d = null;
    }

    public final void a() {
        this.h.setVisibility(8);
        this.c.setVisibility(8);
        this.i.setVisibility(0);
        this.l.setVisibility(0);
        e();
    }

    public final void d() {
        this.h.setVisibility(0);
        this.c.setVisibility(0);
        this.i.setVisibility(8);
        this.l.setVisibility(8);
        a(0);
        e();
    }

    public final void e() {
        if (this.f != null) {
            this.f.notifyDataSetChanged();
        }
    }

    public final void a(List<UpdatesItemData> list) {
        if (this.f != null) {
            this.f.a(list);
        }
    }

    public final void a(int i) {
        this.j.setText(String.format(this.d.getString(com.baidu.tieba.im.j.del_count), Integer.valueOf(i)));
        if (i == 0) {
            this.j.setEnabled(false);
        } else {
            this.j.setEnabled(true);
        }
    }

    public final void a(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
    }

    public final void b(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a(this.a);
        this.k.b(i);
    }

    public final View f() {
        return this.c;
    }

    public final BdListView g() {
        return this.e;
    }

    public final Button h() {
        return this.h;
    }

    public final Button i() {
        return this.i;
    }

    public final Button j() {
        return this.j;
    }
}
