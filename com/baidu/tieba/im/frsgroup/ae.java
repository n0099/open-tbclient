package com.baidu.tieba.im.frsgroup;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private MembersActivity f1556a;
    private aa c;
    private ImageView d;
    private Button e;
    private BdListView f;
    private InitGuideView g;
    private ViewGroup h;
    private ViewGroup i;
    private ViewGroup j;
    private Button k;
    private Button l;
    private ProgressBar m;

    public ae(MembersActivity membersActivity) {
        super(membersActivity);
        this.f1556a = membersActivity;
        membersActivity.setContentView(R.layout.im_members_activity);
        a(membersActivity);
        b(membersActivity);
        c(membersActivity);
    }

    private void a(MembersActivity membersActivity) {
        this.d = (ImageView) membersActivity.findViewById(R.id.title_back);
        this.e = (Button) membersActivity.findViewById(R.id.btn_order);
        this.d.setOnClickListener(membersActivity);
        this.e.setOnClickListener(membersActivity);
    }

    private void b(MembersActivity membersActivity) {
        this.f = (BdListView) membersActivity.findViewById(R.id.members_list);
        this.g = (InitGuideView) membersActivity.findViewById(R.id.members_guide);
        this.c = new aa(this.f1556a);
        this.f.setAdapter((ListAdapter) this.c);
    }

    private void c(MembersActivity membersActivity) {
        this.h = (ViewGroup) membersActivity.findViewById(R.id.bottom_manager);
        this.i = (ViewGroup) membersActivity.findViewById(R.id.bottom_edit);
        this.j = (ViewGroup) membersActivity.findViewById(R.id.bottom_send_edit);
        this.k = (Button) membersActivity.findViewById(R.id.edit_cancel);
        this.l = (Button) membersActivity.findViewById(R.id.edit_num);
        this.m = (ProgressBar) membersActivity.findViewById(R.id.progress_loading);
        a(0);
    }

    public void a(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
    }

    public ViewGroup a() {
        return this.i;
    }

    public Button e() {
        return this.k;
    }

    public Button f() {
        return this.l;
    }

    public void a(int i) {
        this.l.setText(this.f1556a.getString(R.string.members_delete_num, new Object[]{Integer.valueOf(i)}));
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

    public aa i() {
        return this.c;
    }

    public void j() {
        this.c.notifyDataSetChanged();
    }

    public ImageView k() {
        return this.d;
    }

    public Button l() {
        return this.e;
    }

    public void d(boolean z) {
        this.e.setEnabled(z);
    }

    public void b(int i) {
        this.e.setText(this.f1556a.getResources().getStringArray(R.array.members_order_by_short)[i]);
    }

    public BdListView m() {
        return this.f;
    }
}
