package com.baidu.tieba.im.frsgroup;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private MembersActivity f1634a;
    private w c;
    private Button d;
    private NavigationBar e;
    private BdListView f;
    private InitGuideView g;
    private ViewGroup h;
    private ViewGroup i;
    private ViewGroup j;
    private Button k;
    private Button l;
    private ProgressBar m;

    public aa(MembersActivity membersActivity) {
        super(membersActivity);
        this.f1634a = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        a(membersActivity);
        b(membersActivity);
        c(membersActivity);
    }

    private void a(MembersActivity membersActivity) {
        this.e = (NavigationBar) this.f1634a.findViewById(R.id.view_navigation_bar);
        this.e.a(this.f1634a.getString(R.string.members_title));
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ab(this));
        this.d = this.e.b(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f1634a.getString(R.string.members_order));
        this.d.setOnClickListener(membersActivity);
    }

    private void b(MembersActivity membersActivity) {
        this.f = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.g = (InitGuideView) membersActivity.findViewById(R.id.members_guide);
        this.c = new w(this.f1634a);
        this.f.setAdapter((ListAdapter) this.c);
    }

    private void c(MembersActivity membersActivity) {
        this.h = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.i = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.j = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.k = (Button) membersActivity.findViewById(R.id.edit_cancel);
        this.l = (Button) membersActivity.findViewById(R.id.edit_num);
        this.m = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        b(0);
    }

    public void a(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
    }

    public ViewGroup a() {
        return this.i;
    }

    public void a(int i) {
        this.e.c(0);
    }

    public Button e() {
        return this.k;
    }

    public Button f() {
        return this.l;
    }

    public void b(int i) {
        this.l.setText(this.f1634a.getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
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

    public void g() {
        this.f.a();
    }

    public InitGuideView h() {
        return this.g;
    }

    public w i() {
        return this.c;
    }

    public void j() {
        this.c.notifyDataSetChanged();
    }

    public Button k() {
        return this.d;
    }

    public void d(boolean z) {
        this.d.setEnabled(z);
    }

    public void c(int i) {
        this.d.setText(this.f1634a.getResources().getStringArray(R.array.members_order_by_short)[i]);
    }

    public BdListView l() {
        return this.f;
    }
}
