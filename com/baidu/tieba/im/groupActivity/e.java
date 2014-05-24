package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.c {
    private CreateGroupActivityActivity a;
    private View b;
    private NavigationBar c;
    private View d;
    private EditText e;
    private ImageButton f;
    private TextView g;
    private EditText h;
    private ImageButton i;
    private Button j;
    private Button k;
    private DatePickerDialog l;
    private TimePickerDialog m;
    private EditText n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;

    public e(CreateGroupActivityActivity createGroupActivityActivity) {
        super(createGroupActivityActivity);
        this.l = null;
        this.m = null;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = false;
        this.a = createGroupActivityActivity;
        createGroupActivityActivity.setContentView(w.create_group_activity_activity);
        h();
    }

    private void h() {
        this.b = this.a.findViewById(com.baidu.tieba.v.parent);
        this.c = (NavigationBar) this.a.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.c.a(y.group_activity_create);
        this.d = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setOnClickListener(this.a);
        this.g = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getResources().getString(y.group_activity_create_btntext));
        this.g.setOnClickListener(this.a);
        this.g.setEnabled(false);
        this.e = (EditText) this.a.findViewById(com.baidu.tieba.v.txt_group_activity_name);
        this.f = (ImageButton) this.a.findViewById(com.baidu.tieba.v.btn_del_name);
        this.h = (EditText) this.a.findViewById(com.baidu.tieba.v.txt_group_activity_place);
        this.i = (ImageButton) this.a.findViewById(com.baidu.tieba.v.btn_del_place);
        this.n = (EditText) this.a.findViewById(com.baidu.tieba.v.txt_group_activity_content);
        this.j = (Button) this.a.findViewById(com.baidu.tieba.v.btn_create_group_date);
        this.k = (Button) this.a.findViewById(com.baidu.tieba.v.btn_create_group_time);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.o = calendar.get(1);
        this.p = calendar.get(2);
        this.q = calendar.get(5);
        this.r = calendar.get(11);
        this.s = calendar.get(12);
        j();
        i();
        this.j.setOnClickListener(new f(this, calendar));
        this.k.setOnClickListener(new h(this));
        this.f.setOnClickListener(new j(this));
        this.i.setOnClickListener(new k(this));
        this.e.addTextChangedListener(new l(this));
        this.h.addTextChangedListener(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.r > 12) {
            this.k.setText(String.valueOf(this.a.getResources().getString(y.afternoon)) + " " + (this.r - 12) + ":" + (this.s < 10 ? "0" : "") + this.s);
        } else {
            this.k.setText(String.valueOf(this.a.getResources().getString(y.morning)) + " " + this.r + ":" + (this.s < 10 ? "0" : "") + this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.j.setText(this.o + "-" + (this.p + 1) + "-" + this.q + " " + be.a(this.o, this.p, this.q));
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
    }

    public View a() {
        return this.d;
    }

    public TextView b() {
        return this.g;
    }

    public String c() {
        return this.e.getText().toString();
    }

    public String d() {
        return this.h.getText().toString();
    }

    public String e() {
        return this.n.getText().toString();
    }

    public long f() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.o + "-" + (this.p + 1) + "-" + this.q + " " + this.r + ":" + this.s).getTime() / 1000;
        } catch (ParseException e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void a(String str) {
        this.e.setText(str);
    }

    public void b(String str) {
        this.n.setText(str);
    }

    public void c(String str) {
        this.h.setText(str);
    }

    public void a(long j) {
        Date date = new Date(1000 * j);
        this.o = date.getYear() + 1900;
        this.p = date.getMonth();
        this.q = date.getDate();
        this.r = date.getHours();
        this.s = date.getMinutes();
        j();
        i();
    }

    public void a(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.b);
        this.c.c(i);
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.g.setText(this.a.getString(y.done));
            this.c.a(y.group_activity_edit_title);
            if (groupActivityData != null) {
                b(groupActivityData.getgActivityContent());
                a(groupActivityData.getgActivityTitle());
                a(groupActivityData.getgActivityTime());
                c(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.g.setText(this.a.getString(y.group_activity_create_btntext));
        this.c.a(y.group_activity_create);
    }

    public boolean g() {
        return this.t;
    }
}
