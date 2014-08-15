package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private MembersActivity a;
    private ab b;
    private ViewGroup c;
    private TextView d;
    private NavigationBar e;
    private BdListView f;
    private InitGuideView g;
    private ViewGroup h;
    private ViewGroup i;
    private ViewGroup j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ProgressBar n;

    public af(MembersActivity membersActivity) {
        super(membersActivity);
        this.a = membersActivity;
        membersActivity.setContentView(com.baidu.tieba.v.im_members_activity);
        a(membersActivity);
        b(membersActivity);
        c(membersActivity);
    }

    private void a(MembersActivity membersActivity) {
        this.c = (ViewGroup) this.a.findViewById(com.baidu.tieba.u.rootView);
        this.e = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.e.a(this.a.getString(com.baidu.tieba.x.members_title));
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ag(this));
        this.d = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(com.baidu.tieba.x.members_order));
        this.d.setOnClickListener(membersActivity);
    }

    private void b(MembersActivity membersActivity) {
        this.f = (BdListView) membersActivity.findViewById(com.baidu.tieba.u.members_list);
        this.g = (InitGuideView) membersActivity.findViewById(com.baidu.tieba.u.members_guide);
        this.b = new ab(this.a);
        this.f.setAdapter((ListAdapter) this.b);
    }

    private void c(MembersActivity membersActivity) {
        this.h = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.u.bottom_manager);
        this.i = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.u.bottom_edit);
        this.j = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.u.bottom_send_edit);
        this.k = (TextView) membersActivity.findViewById(com.baidu.tieba.u.edit_cancel);
        this.l = (TextView) membersActivity.findViewById(com.baidu.tieba.u.edit_num);
        this.m = (TextView) membersActivity.findViewById(com.baidu.tieba.u.members_edit);
        this.n = (ProgressBar) membersActivity.findViewById(com.baidu.tieba.u.progress_loading);
        b(0);
    }

    public void a(boolean z) {
        this.n.setVisibility(z ? 0 : 8);
    }

    public ViewGroup a() {
        return this.i;
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
        this.e.c(i);
        if (i == 1) {
            this.m.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(com.baidu.tieba.t.icon_brief_edit_1), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.m.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(com.baidu.tieba.t.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public TextView b() {
        return this.k;
    }

    public TextView c() {
        return this.l;
    }

    public void b(int i) {
        this.l.setText(this.a.getString(com.baidu.tieba.x.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void b(boolean z) {
        if (z) {
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            this.j.setVisibility(8);
            return;
        }
        this.h.setVisibility(8);
    }

    public void c(boolean z) {
        if (z) {
            this.i.setVisibility(8);
            this.j.setVisibility(0);
            return;
        }
        this.i.setVisibility(0);
        this.j.setVisibility(8);
    }

    public void d() {
        this.f.d();
    }

    public InitGuideView e() {
        return this.g;
    }

    public ab f() {
        return this.b;
    }

    public void g() {
        this.b.notifyDataSetChanged();
    }

    public TextView h() {
        return this.d;
    }

    public void d(boolean z) {
        this.d.setEnabled(z);
    }

    public void c(int i) {
        this.d.setText(this.a.getResources().getStringArray(com.baidu.tieba.p.members_order_by_short)[i]);
    }

    public BdListView i() {
        return this.f;
    }
}
