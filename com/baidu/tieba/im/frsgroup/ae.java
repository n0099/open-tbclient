package com.baidu.tieba.im.frsgroup;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class ae extends com.baidu.adp.a.e {
    private MembersActivity a;
    private aa c;
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

    public ae(MembersActivity membersActivity) {
        super(membersActivity);
        this.a = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        this.d = (ViewGroup) this.a.findViewById(R.id.rootView);
        this.f = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.f.a(this.a.getString(R.string.members_title));
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.e = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.members_order));
        this.e.setOnClickListener(membersActivity);
        this.g = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.h = (InitGuideView) membersActivity.findViewById(R.id.members_guide);
        this.c = new aa(this.a);
        this.g.setAdapter((ListAdapter) this.c);
        this.i = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.j = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.k = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.l = (Button) membersActivity.findViewById(R.id.edit_cancel);
        this.m = (Button) membersActivity.findViewById(R.id.edit_num);
        this.n = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.o = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
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
            this.n.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_edit_1), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.n.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public final Button d() {
        return this.l;
    }

    public final Button e() {
        return this.m;
    }

    public final void b(int i) {
        this.m.setText(this.a.getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
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
        this.g.a();
    }

    public final InitGuideView g() {
        return this.h;
    }

    public final aa h() {
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
        this.e.setText(this.a.getResources().getStringArray(R.array.members_order_by_short)[i]);
    }

    public final BdListView k() {
        return this.g;
    }
}
