package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public final class ah extends com.baidu.adp.a.f {
    private MembersActivity a;
    private ad c;
    private ViewGroup d;
    private TextView e;
    private NavigationBar f;
    private BdListView g;
    private InitGuideView h;
    private ViewGroup i;
    private ViewGroup j;
    private ViewGroup k;
    private Button l;
    private Button m;
    private TextView n;
    private ProgressBar o;

    public ah(MembersActivity membersActivity) {
        super(membersActivity);
        this.a = membersActivity;
        membersActivity.setContentView(com.baidu.tieba.im.i.im_members_activity);
        this.d = (ViewGroup) this.a.findViewById(com.baidu.tieba.im.h.rootView);
        this.f = (NavigationBar) this.a.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.f.a(this.a.getString(com.baidu.tieba.im.j.members_title));
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ai(this));
        this.e = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(com.baidu.tieba.im.j.members_order));
        this.e.setOnClickListener(membersActivity);
        this.g = (BdListView) membersActivity.findViewById(com.baidu.tieba.im.h.members_list);
        this.h = (InitGuideView) membersActivity.findViewById(com.baidu.tieba.im.h.members_guide);
        this.c = new ad(this.a);
        this.g.setAdapter((ListAdapter) this.c);
        this.i = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.im.h.bottom_manager);
        this.j = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.im.h.bottom_edit);
        this.k = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.im.h.bottom_send_edit);
        this.l = (Button) membersActivity.findViewById(com.baidu.tieba.im.h.edit_cancel);
        this.m = (Button) membersActivity.findViewById(com.baidu.tieba.im.h.edit_num);
        this.n = (TextView) membersActivity.findViewById(com.baidu.tieba.im.h.members_edit);
        this.o = (ProgressBar) membersActivity.findViewById(com.baidu.tieba.im.h.progress_loading);
        b(0);
    }

    public final void a(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
    }

    public final ViewGroup a() {
        return this.j;
    }

    public final void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.d);
        this.f.b(i);
        if (i == 1) {
            this.n.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_edit_1), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.n.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public final Button d() {
        return this.l;
    }

    public final Button e() {
        return this.m;
    }

    public final void b(int i) {
        this.m.setText(this.a.getString(com.baidu.tieba.im.j.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public final void b(boolean z) {
        if (z) {
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.i.setVisibility(8);
    }

    public final void c(boolean z) {
        if (z) {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(8);
    }

    public final void f() {
        this.g.b();
    }

    public final InitGuideView g() {
        return this.h;
    }

    public final ad h() {
        return this.c;
    }

    public final void i() {
        this.c.notifyDataSetChanged();
    }

    public final TextView j() {
        return this.e;
    }

    public final void d(boolean z) {
        this.e.setEnabled(z);
    }

    public final void c(int i) {
        this.e.setText(this.a.getResources().getStringArray(com.baidu.tieba.im.d.members_order_by_short)[i]);
    }

    public final BdListView k() {
        return this.g;
    }
}
