package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.e {
    private MembersActivity a;
    private ad b;
    private ViewGroup c;
    private TextView d;
    private NavigationBar e;
    private BdListView f;
    private InitGuideView g;
    private ViewGroup h;
    private ViewGroup i;
    private ViewGroup j;
    private Button k;
    private Button l;
    private TextView m;
    private ProgressBar n;

    public ah(MembersActivity membersActivity) {
        super(membersActivity);
        this.a = membersActivity;
        membersActivity.setContentView(com.baidu.tieba.s.im_members_activity);
        a(membersActivity);
        b(membersActivity);
        c(membersActivity);
    }

    private void a(MembersActivity membersActivity) {
        this.c = (ViewGroup) this.a.findViewById(com.baidu.tieba.r.rootView);
        this.e = (NavigationBar) this.a.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.e.a(this.a.getString(com.baidu.tieba.u.members_title));
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ai(this));
        this.d = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(com.baidu.tieba.u.members_order));
        this.d.setOnClickListener(membersActivity);
    }

    private void b(MembersActivity membersActivity) {
        this.f = (BdListView) membersActivity.findViewById(com.baidu.tieba.r.members_list);
        this.g = (InitGuideView) membersActivity.findViewById(com.baidu.tieba.r.members_guide);
        this.b = new ad(this.a);
        this.f.setAdapter((ListAdapter) this.b);
    }

    private void c(MembersActivity membersActivity) {
        this.h = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.r.bottom_manager);
        this.i = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.r.bottom_edit);
        this.j = (ViewGroup) membersActivity.findViewById(com.baidu.tieba.r.bottom_send_edit);
        this.k = (Button) membersActivity.findViewById(com.baidu.tieba.r.edit_cancel);
        this.l = (Button) membersActivity.findViewById(com.baidu.tieba.r.edit_num);
        this.m = (TextView) membersActivity.findViewById(com.baidu.tieba.r.members_edit);
        this.n = (ProgressBar) membersActivity.findViewById(com.baidu.tieba.r.progress_loading);
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
            this.m.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(com.baidu.tieba.q.icon_brief_edit_1), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.m.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(com.baidu.tieba.q.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public Button b() {
        return this.k;
    }

    public Button c() {
        return this.l;
    }

    public void b(int i) {
        this.l.setText(this.a.getString(com.baidu.tieba.u.members_delete_num, new Object[]{Integer.valueOf(i)}));
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
        this.f.c();
    }

    public InitGuideView e() {
        return this.g;
    }

    public ad f() {
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
        this.d.setText(this.a.getResources().getStringArray(com.baidu.tieba.m.members_order_by_short)[i]);
    }

    public BdListView i() {
        return this.f;
    }
}
