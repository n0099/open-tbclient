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
public class aa extends com.baidu.adp.a.e {
    private MembersActivity a;
    private w c;
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

    public aa(MembersActivity membersActivity) {
        super(membersActivity);
        this.a = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        a(membersActivity);
        b(membersActivity);
        c(membersActivity);
    }

    private void a(MembersActivity membersActivity) {
        this.d = (ViewGroup) this.a.findViewById(R.id.rootView);
        this.f = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.f.a(this.a.getString(R.string.members_title));
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ab(this));
        this.e = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.members_order));
        this.e.setOnClickListener(membersActivity);
    }

    private void b(MembersActivity membersActivity) {
        this.g = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.h = (InitGuideView) membersActivity.findViewById(R.id.members_guide);
        this.c = new w(this.a);
        this.g.setAdapter((ListAdapter) this.c);
    }

    private void c(MembersActivity membersActivity) {
        this.i = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.j = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.k = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.l = (Button) membersActivity.findViewById(R.id.edit_cancel);
        this.m = (Button) membersActivity.findViewById(R.id.edit_num);
        this.n = (TextView) membersActivity.findViewById(R.id.members_edit);
        this.o = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        b(0);
    }

    public void a(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
    }

    public ViewGroup a() {
        return this.j;
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.d);
        this.f.c(i);
        if (i == 1) {
            this.n.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_edit_1), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.n.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_edit), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public Button e() {
        return this.l;
    }

    public Button f() {
        return this.m;
    }

    public void b(int i) {
        this.m.setText(this.a.getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
    }

    public void b(boolean z) {
        if (z) {
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.i.setVisibility(8);
    }

    public void c(boolean z) {
        if (z) {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(8);
    }

    public void g() {
        this.g.a();
    }

    public InitGuideView h() {
        return this.h;
    }

    public w i() {
        return this.c;
    }

    public void j() {
        this.c.notifyDataSetChanged();
    }

    public TextView k() {
        return this.e;
    }

    public void d(boolean z) {
        this.e.setEnabled(z);
    }

    public void c(int i) {
        this.e.setText(this.a.getResources().getStringArray(R.array.members_order_by_short)[i]);
    }

    public BdListView l() {
        return this.g;
    }
}
