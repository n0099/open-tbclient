package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.e {
    private CreateGroupActivityActivity a;
    private View c;
    private NavigationBar d;
    private ImageView e;
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
        createGroupActivityActivity.setContentView(R.layout.create_group_activity_activity);
        k();
    }

    private void k() {
        this.c = this.a.findViewById(R.id.parent);
        this.d = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.d.a(R.string.group_activity_create);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.setOnClickListener(this.a);
        this.h = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getResources().getString(R.string.group_activity_create_btntext));
        this.h.setOnClickListener(this.a);
        this.h.setEnabled(false);
        this.f = (EditText) this.a.findViewById(R.id.txt_group_activity_name);
        this.g = (ImageButton) this.a.findViewById(R.id.btn_del_name);
        this.i = (EditText) this.a.findViewById(R.id.txt_group_activity_place);
        this.j = (ImageButton) this.a.findViewById(R.id.btn_del_place);
        this.o = (EditText) this.a.findViewById(R.id.txt_group_activity_content);
        this.k = (Button) this.a.findViewById(R.id.btn_create_group_date);
        this.l = (Button) this.a.findViewById(R.id.btn_create_group_time);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.p = calendar.get(1);
        this.q = calendar.get(2);
        this.r = calendar.get(5);
        this.s = calendar.get(11);
        this.t = calendar.get(12);
        m();
        l();
        this.k.setOnClickListener(new f(this, calendar));
        this.l.setOnClickListener(new h(this));
        this.g.setOnClickListener(new j(this));
        this.j.setOnClickListener(new k(this));
        this.f.addTextChangedListener(new l(this));
        this.i.addTextChangedListener(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.s > 12) {
            this.l.setText(String.valueOf(this.a.getResources().getString(R.string.afternoon)) + " " + (this.s - 12) + ":" + (this.t < 10 ? SocialConstants.FALSE : "") + this.t);
        } else {
            this.l.setText(String.valueOf(this.a.getResources().getString(R.string.morning)) + " " + this.s + ":" + (this.t < 10 ? SocialConstants.FALSE : "") + this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.k.setText(this.p + "-" + (this.q + 1) + "-" + this.r + " " + bs.a(this.p, this.q, this.r));
    }

    @Override // com.baidu.adp.a.e
    public void c() {
    }

    public ImageView a() {
        return this.e;
    }

    public TextView e() {
        return this.h;
    }

    public String f() {
        return this.f.getText().toString();
    }

    public String g() {
        return this.i.getText().toString();
    }

    public String h() {
        return this.o.getText().toString();
    }

    public long i() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this.p + "-" + (this.q + 1) + "-" + this.r + " " + this.s + ":" + this.t).getTime() / 1000;
        } catch (ParseException e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return 0L;
        }
    }

    public void a(String str) {
        this.f.setText(str);
    }

    public void b(String str) {
        this.o.setText(str);
    }

    public void c(String str) {
        this.i.setText(str);
    }

    public void a(long j) {
        Date date = new Date(1000 * j);
        this.p = date.getYear() + 1900;
        this.q = date.getMonth();
        this.r = date.getDate();
        this.s = date.getHours();
        this.t = date.getMinutes();
        m();
        l();
    }

    public void a(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.c);
        this.d.c(i);
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (z) {
            this.h.setText(this.a.getString(R.string.done));
            this.d.a(R.string.group_activity_edit_title);
            if (groupActivityData != null) {
                b(groupActivityData.getgActivityContent());
                a(groupActivityData.getgActivityTitle());
                a(groupActivityData.getgActivityTime());
                c(groupActivityData.getgActivityArea());
                return;
            }
            return;
        }
        this.h.setText(this.a.getString(R.string.group_activity_create_btntext));
        this.d.a(R.string.group_activity_create);
    }

    public boolean j() {
        return this.u;
    }
}
