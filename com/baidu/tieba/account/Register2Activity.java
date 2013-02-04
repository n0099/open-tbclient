package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends com.baidu.tieba.e {
    private static int b = LocationClientOption.MIN_SCAN_SPAN;
    private static int c = 27;
    private static int d = 29;
    private static int e = 28;
    private static int f = 6;
    private Button g = null;
    private Button h = null;
    private Button i = null;
    private ImageView j = null;
    private ImageView k = null;
    private Button l = null;
    private RadioGroup m = null;
    private RadioButton n = null;
    private RadioButton o = null;
    private RadioButton p = null;
    private TextView q = null;
    private TextView r = null;
    private EditText s = null;
    private EditText t = null;
    private EditText u = null;
    private EditText v = null;
    private RelativeLayout w = null;
    private LinearLayout x = null;
    private LinearLayout y = null;
    private LinearLayout z = null;
    private LinearLayout A = null;
    private LinearLayout B = null;
    private ProgressBar C = null;
    private ProgressBar D = null;
    private ImageView E = null;
    private int F = 0;
    private int G = 0;
    private boolean H = false;
    private boolean I = true;
    private int J = -1;
    private String K = null;
    private bb L = null;
    private bc M = null;
    private com.baidu.tieba.b.g N = null;
    private View.OnClickListener O = new aw(this);
    private TextWatcher P = new ax(this);
    private View.OnFocusChangeListener Q = new ay(this);
    private RadioGroup.OnCheckedChangeListener R = new az(this);

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, Register2Activity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList arrayList) {
        int size;
        g();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.y.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.n.setText((CharSequence) arrayList.get(0));
                this.n.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.o.setText((CharSequence) arrayList.get(1));
                this.o.setVisibility(0);
            }
            if (size <= 2 || arrayList.get(2) == null) {
                return;
            }
            this.p.setText((CharSequence) arrayList.get(2));
            this.p.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.H = z;
        if (this.H) {
            this.B.setVisibility(0);
            if (this.v.length() <= 0) {
                this.w.setEnabled(false);
            }
            if (this.J != e) {
                this.A.setBackgroundResource(R.drawable.login_input_middle);
            }
            if (this.L != null) {
                this.L.a();
            }
            if (this.N != null) {
                this.L = new bb(this, this.N.b().d());
                this.L.execute(new String[0]);
            }
        } else {
            this.B.setVisibility(8);
            this.v.setText((CharSequence) null);
            if (this.J != e) {
                this.A.setBackgroundResource(R.drawable.login_input_under);
            }
        }
        q();
    }

    private void b(boolean z) {
        this.s.setEnabled(z);
        this.s.setFocusable(z);
        this.s.setFocusableInTouchMode(z);
        this.v.setEnabled(z);
        this.v.setFocusable(z);
        this.v.setFocusableInTouchMode(z);
        this.t.setEnabled(z);
        this.t.setFocusable(z);
        this.t.setFocusableInTouchMode(z);
        this.i.setEnabled(z);
        this.u.setEnabled(z);
        this.u.setFocusable(z);
        this.u.setFocusableInTouchMode(z);
        this.k.setEnabled(z);
        this.n.setEnabled(z);
        this.o.setEnabled(z);
        this.p.setEnabled(z);
        this.E.setEnabled(z);
        this.l.setEnabled(z);
        this.q.setEnabled(z);
        if (z) {
            this.s.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.v.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.t.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.u.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.n.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.o.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.p.setTextColor(getResources().getColor(R.color.reg_font_color));
            return;
        }
        this.s.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.v.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.t.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.u.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.n.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.o.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.p.setTextColor(getResources().getColor(R.color.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        int selectionStart = this.t.getSelectionStart();
        if (this.I) {
            this.i.setText(getString(R.string.show));
            this.t.setTransformationMethod(new PasswordTransformationMethod());
            this.t.setSelection(selectionStart);
            this.I = false;
            return;
        }
        this.i.setText(getString(R.string.hide));
        this.t.setTransformationMethod(new SingleLineTransformationMethod());
        this.t.setSelection(selectionStart);
        this.I = true;
    }

    private void n() {
        t();
        this.w = (RelativeLayout) findViewById(R.id.register);
        this.w.setEnabled(false);
        this.g = (Button) findViewById(R.id.back);
        this.h = (Button) findViewById(R.id.login);
        this.i = (Button) findViewById(R.id.show);
        this.t = (EditText) findViewById(R.id.edit_psw);
        this.s = (EditText) findViewById(R.id.edit_user_name);
        this.j = (ImageView) findViewById(R.id.del_user_name);
        this.j.setOnClickListener(this.O);
        this.k = (ImageView) findViewById(R.id.del_phone);
        this.k.setOnClickListener(this.O);
        this.s.setOnFocusChangeListener(this.Q);
        this.u = (EditText) findViewById(R.id.edit_phone);
        this.u.setOnFocusChangeListener(this.Q);
        this.g.setOnClickListener(this.O);
        this.h.setOnClickListener(this.O);
        this.i.setOnClickListener(this.O);
        this.s.addTextChangedListener(this.P);
        this.t.addTextChangedListener(this.P);
        this.u.addTextChangedListener(this.P);
        this.C = (ProgressBar) findViewById(R.id.progress_reg);
        this.D = (ProgressBar) findViewById(R.id.image_progress);
        this.n = (RadioButton) findViewById(R.id.choose_name1);
        this.o = (RadioButton) findViewById(R.id.choose_name2);
        this.p = (RadioButton) findViewById(R.id.choose_name3);
        this.m = (RadioGroup) findViewById(R.id.name_group);
        this.m.setOnCheckedChangeListener(this.R);
        this.w.setOnClickListener(this.O);
        this.x = (LinearLayout) findViewById(R.id.user_name_bg);
        this.F = this.x.getPaddingLeft();
        this.G = this.x.getPaddingRight();
        this.y = (LinearLayout) findViewById(R.id.recommend_bg);
        this.z = (LinearLayout) findViewById(R.id.input_psw_bg);
        this.A = (LinearLayout) findViewById(R.id.input_phone_bg);
        this.B = (LinearLayout) findViewById(R.id.input_vcode_bg);
        this.r = (TextView) findViewById(R.id.text_error);
        this.E = (ImageView) findViewById(R.id.image_vcode);
        this.l = (Button) findViewById(R.id.change_vcode);
        this.E.setOnClickListener(this.O);
        this.l.setOnClickListener(this.O);
        this.v = (EditText) findViewById(R.id.edit_vcode);
        this.v.addTextChangedListener(this.P);
        m();
        q();
        a(this.s, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        b(false);
    }

    private void p() {
        this.x.setPadding(this.F, 0, this.G, 0);
        this.y.setPadding(this.F, 0, this.G, 0);
        this.z.setPadding(this.F, 0, this.G, 0);
        this.A.setPadding(this.F, 0, this.G, 0);
        this.B.setPadding(this.F, 0, this.G, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.r.setText(this.K);
        if (this.K != null) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(4);
        }
        if (this.J == c) {
            this.x.setBackgroundResource(R.drawable.login_input_topwrong);
        } else if (this.J == d) {
            this.z.setBackgroundResource(R.drawable.login_input_middlewrong);
        } else if (this.J == e) {
            if (this.H) {
                this.A.setBackgroundResource(R.drawable.login_input_middlewrong);
            } else {
                this.A.setBackgroundResource(R.drawable.login_input_underwrong);
            }
        } else if (this.J == f) {
            this.B.setBackgroundResource(R.drawable.login_input_underwrong);
        } else {
            this.x.setBackgroundResource(R.drawable.login_input_top);
            this.z.setBackgroundResource(R.drawable.login_input_middle);
            if (this.H) {
                this.A.setBackgroundResource(R.drawable.login_input_middle);
            } else {
                this.A.setBackgroundResource(R.drawable.login_input_under);
            }
            this.B.setBackgroundResource(R.drawable.login_input_under);
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.a.ao s() {
        com.baidu.tieba.a.ao aoVar = new com.baidu.tieba.a.ao();
        aoVar.a(this.s.getText().toString());
        aoVar.b(this.t.getText().toString());
        aoVar.c(this.u.getText().toString());
        if (this.H) {
            aoVar.d(this.v.getText().toString());
        }
        if (this.N != null) {
            aoVar.e(this.N.b().c());
            aoVar.a(this.N.d());
        }
        return aoVar;
    }

    private void t() {
        String string;
        int length = getString(R.string.reg_info).length();
        String str = String.valueOf(string) + getString(R.string.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ba(this, this), length, length2, 33);
        this.q = (TextView) findViewById(R.id.reg_info);
        this.q.setMovementMethod(LinkMovementMethod.getInstance());
        this.q.setText(spannableString);
    }

    public void g() {
        this.y.setVisibility(8);
        this.m.clearCheck();
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == b && i2 == -1) {
            com.baidu.tieba.c.ae.a("Register2Activity", "onActivityResult", "onActivityResult");
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_register2_activity);
        n();
        new ak("reg").start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.M != null) {
            this.M.a();
        }
        if (this.L != null) {
            this.L.a();
        }
        com.baidu.tieba.c.ae.a("Register2Activity", "onDestroy", "onDestroy");
    }
}
