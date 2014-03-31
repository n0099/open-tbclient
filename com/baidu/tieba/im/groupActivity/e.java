package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.GroupActivityData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes.dex */
public final class e extends com.baidu.adp.a.f {
    private CreateGroupActivityActivity a;
    private View c;
    private NavigationBar d;
    private View e;
    private EditText f;
    private ImageButton g;
    private TextView h;
    private EditText i;
    private ImageButton j;
    private Button k;
    private Button l;
    private DatePickerDialog m;
    private TimePickerDialog n;
    private EditText o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;

    public e(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity);
        this.m = null;
        this.n = null;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.a = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(com.baidu.tieba.im.i.create_group_activity_activity);
        this.c = this.a.findViewById(com.baidu.tieba.im.h.parent);
        this.d = (NavigationBar) this.a.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.d.a(com.baidu.tieba.im.j.group_activity_create);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.setOnClickListener(this.a);
        this.h = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getResources().getString(com.baidu.tieba.im.j.group_activity_create_btntext));
        this.h.setOnClickListener(this.a);
        this.h.setEnabled(false);
        this.f = (EditText) this.a.findViewById(com.baidu.tieba.im.h.txt_group_activity_name);
        this.g = (ImageButton) this.a.findViewById(com.baidu.tieba.im.h.btn_del_name);
        this.i = (EditText) this.a.findViewById(com.baidu.tieba.im.h.txt_group_activity_place);
        this.j = (ImageButton) this.a.findViewById(com.baidu.tieba.im.h.btn_del_place);
        this.o = (EditText) this.a.findViewById(com.baidu.tieba.im.h.txt_group_activity_content);
        this.k = (Button) this.a.findViewById(com.baidu.tieba.im.h.btn_create_group_date);
        this.l = (Button) this.a.findViewById(com.baidu.tieba.im.h.btn_create_group_time);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.p = calendar.get(1);
        this.q = calendar.get(2);
        this.r = calendar.get(5);
        this.s = calendar.get(11);
        this.t = calendar.get(12);
        k();
        j();
        this.k.setOnClickListener(new f(this, calendar));
        this.l.setOnClickListener(new h(this));
        this.g.setOnClickListener(new j(this));
        this.j.setOnClickListener(new k(this));
        this.f.addTextChangedListener(new l(this));
        this.i.addTextChangedListener(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.s > 12) {
            this.l.setText(String.valueOf(this.a.getResources().getString(com.baidu.tieba.im.j.afternoon)) + " " + (this.s - 12) + ":" + (this.t < 10 ? "0" : "") + this.t);
        } else {
            this.l.setText(String.valueOf(this.a.getResources().getString(com.baidu.tieba.im.j.morning)) + " " + this.s + ":" + (this.t < 10 ? "0" : "") + this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.k.setText(this.p + "-" + (this.q + 1) + "-" + this.r + " " + bc.a(this.p, this.q, this.r));
    }

    @Override // com.baidu.adp.a.f
    public final void c() {
    }

    public final View a() {
        return this.e;
    }

    public final TextView d() {
        return this.h;
    }

    public final String e() {
        return this.f.getText().toString();
    }

    public final String f() {
        return this.i.getText().toString();
    }

    public final String g() {
        return this.o.getText().toString();
    }

    public final long h() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.p + "-" + (this.q + 1) + "-" + this.r + " " + this.s + ":" + this.t).getTime() / 1000;
        } catch (ParseException e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return 0L;
        }
    }

    public final void a(int i) {
        this.a.b().a(i == 1);
        this.a.b().a(this.c);
        this.d.b(i);
    }

    public final void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.h.setText(this.a.getString(com.baidu.tieba.im.j.done));
            this.d.a(com.baidu.tieba.im.j.group_activity_edit_title);
            if (groupActivityData != null) {
                this.o.setText(groupActivityData.getgActivityContent());
                this.f.setText(groupActivityData.getgActivityTitle());
                Date date = new Date(groupActivityData.getgActivityTime() * 1000);
                this.p = date.getYear() + 1900;
                this.q = date.getMonth();
                this.r = date.getDate();
                this.s = date.getHours();
                this.t = date.getMinutes();
                k();
                j();
                this.i.setText(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.h.setText(this.a.getString(com.baidu.tieba.im.j.group_activity_create_btntext));
        this.d.a(com.baidu.tieba.im.j.group_activity_create);
    }

    public final boolean i() {
        return this.u;
    }
}
