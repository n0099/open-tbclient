package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.RegistData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends com.baidu.tbadk.a {
    private static int c = LocationClientOption.MIN_SCAN_SPAN;
    private static int d = 27;
    private static int e = 29;
    private static int f = 28;
    private static int g = 6;
    private NavigationBar M;
    private View h = null;
    private TextView i = null;
    private Button j = null;
    private ImageView k = null;
    private ImageView l = null;
    private Button m = null;
    private RadioGroup n = null;
    private RadioButton o = null;
    private RadioButton p = null;
    private RadioButton q = null;
    private TextView r = null;
    private TextView s = null;
    private EditText t = null;
    private EditText u = null;
    private EditText v = null;
    private EditText w = null;
    private RelativeLayout x = null;
    private LinearLayout y = null;
    private LinearLayout z = null;
    private LinearLayout A = null;
    private LinearLayout B = null;
    private LinearLayout C = null;
    private ProgressBar D = null;
    private ProgressBar E = null;
    private ImageView F = null;
    private int G = 0;
    private int H = 0;
    private boolean I = false;
    private boolean J = true;
    private int K = -1;
    private String L = null;
    RelativeLayout a = null;
    TextView b = null;
    private ae N = null;
    private af O = null;
    private com.baidu.tbadk.core.data.h P = null;
    private final View.OnClickListener Q = new z(this);
    private final TextWatcher R = new aa(this);
    private final View.OnFocusChangeListener S = new ab(this);
    private final RadioGroup.OnCheckedChangeListener T = new ac(this);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.aj.class, Register2Activity.class);
    }

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, Register2Activity.class), 12007);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.account_register2_activity);
        this.a = (RelativeLayout) findViewById(com.baidu.tieba.a.h.container);
        this.M = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.h = this.M.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.Q);
        this.M.a(getString(com.baidu.tieba.a.k.account_regedit_baidu));
        this.i = this.M.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.a.k.account_login), this.Q);
        this.b = (TextView) findViewById(com.baidu.tieba.a.h.reg_text);
        this.r = (TextView) findViewById(com.baidu.tieba.a.h.reg_info);
        this.x = (RelativeLayout) findViewById(com.baidu.tieba.a.h.register);
        this.x.setEnabled(false);
        this.j = (Button) findViewById(com.baidu.tieba.a.h.show);
        this.u = (EditText) findViewById(com.baidu.tieba.a.h.edit_psw);
        this.t = (EditText) findViewById(com.baidu.tieba.a.h.edit_user_name);
        this.k = (ImageView) findViewById(com.baidu.tieba.a.h.del_user_name);
        this.k.setOnClickListener(this.Q);
        this.l = (ImageView) findViewById(com.baidu.tieba.a.h.del_phone);
        this.l.setOnClickListener(this.Q);
        this.t.setOnFocusChangeListener(this.S);
        this.v = (EditText) findViewById(com.baidu.tieba.a.h.edit_phone);
        this.v.setOnFocusChangeListener(this.S);
        this.j.setOnClickListener(this.Q);
        this.t.addTextChangedListener(this.R);
        this.u.addTextChangedListener(this.R);
        this.v.addTextChangedListener(this.R);
        this.D = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress_reg);
        this.E = (ProgressBar) findViewById(com.baidu.tieba.a.h.image_progress);
        this.o = (RadioButton) findViewById(com.baidu.tieba.a.h.choose_name1);
        this.p = (RadioButton) findViewById(com.baidu.tieba.a.h.choose_name2);
        this.q = (RadioButton) findViewById(com.baidu.tieba.a.h.choose_name3);
        this.n = (RadioGroup) findViewById(com.baidu.tieba.a.h.name_group);
        this.n.setOnCheckedChangeListener(this.T);
        this.x.setOnClickListener(this.Q);
        this.y = (LinearLayout) findViewById(com.baidu.tieba.a.h.user_name_bg);
        this.G = this.y.getPaddingLeft();
        this.H = this.y.getPaddingRight();
        this.z = (LinearLayout) findViewById(com.baidu.tieba.a.h.recommend_bg);
        this.A = (LinearLayout) findViewById(com.baidu.tieba.a.h.input_psw_bg);
        this.B = (LinearLayout) findViewById(com.baidu.tieba.a.h.input_phone_bg);
        this.C = (LinearLayout) findViewById(com.baidu.tieba.a.h.input_vcode_bg);
        this.s = (TextView) findViewById(com.baidu.tieba.a.h.text_error);
        this.F = (ImageView) findViewById(com.baidu.tieba.a.h.image_vcode);
        this.m = (Button) findViewById(com.baidu.tieba.a.h.change_vcode);
        this.F.setOnClickListener(this.Q);
        this.m.setOnClickListener(this.Q);
        this.w = (EditText) findViewById(com.baidu.tieba.a.h.edit_vcode);
        this.w.addTextChangedListener(this.R);
        f();
        ShowSoftKeyPadDelay(this.t, 150);
        new ax("reg").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int selectionStart = this.u.getSelectionStart();
        if (!this.J) {
            this.j.setText(getString(com.baidu.tieba.a.k.hide));
            this.u.setTransformationMethod(new SingleLineTransformationMethod());
            this.u.setSelection(selectionStart);
            this.J = true;
            return;
        }
        this.j.setText(getString(com.baidu.tieba.a.k.show));
        this.u.setTransformationMethod(new PasswordTransformationMethod());
        this.u.setSelection(selectionStart);
        this.J = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.O != null) {
            this.O.cancel();
        }
        if (this.N != null) {
            this.N.cancel();
        }
        com.baidu.adp.lib.util.f.a("Register2Activity", "onDestroy", "onDestroy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        String string;
        super.onChangeSkinType(i);
        this.M.b(i);
        ba.a(this.b, i);
        ba.c(this.a, i);
        int length = getString(com.baidu.tieba.a.k.reg_info).length();
        String str = String.valueOf(string) + getString(com.baidu.tieba.a.k.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ad(this, this), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.skin_1_common_color)), 0, length, 33);
        }
        this.r.setMovementMethod(LinkMovementMethod.getInstance());
        this.r.setText(spannableString);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.s.setText(this.L);
        if (this.L != null) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(4);
        }
        if (this.mSkinType == 1) {
            if (this.K == d) {
                this.y.setBackgroundResource(com.baidu.tieba.a.g.login_input_topwrong_1);
            } else if (this.K == e) {
                this.A.setBackgroundResource(com.baidu.tieba.a.g.login_input_middlewrong_1);
            } else if (this.K == f) {
                if (this.I) {
                    this.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_middlewrong_1);
                } else {
                    this.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_underwrong_1);
                }
            } else if (this.K == g) {
                this.C.setBackgroundResource(com.baidu.tieba.a.g.login_input_underwrong_1);
            } else {
                this.y.setBackgroundResource(com.baidu.tieba.a.g.login_input_top_1);
                this.A.setBackgroundResource(com.baidu.tieba.a.g.login_input_middle_1);
                if (this.I) {
                    this.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_middle_1);
                } else {
                    this.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_under_1);
                }
                this.C.setBackgroundResource(com.baidu.tieba.a.g.login_input_under_1);
            }
        } else if (this.K == d) {
            this.y.setBackgroundResource(com.baidu.tieba.a.g.login_input_topwrong);
        } else if (this.K == e) {
            this.A.setBackgroundResource(com.baidu.tieba.a.g.login_input_middlewrong);
        } else if (this.K == f) {
            if (this.I) {
                this.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_middlewrong);
            } else {
                this.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_underwrong);
            }
        } else if (this.K == g) {
            this.C.setBackgroundResource(com.baidu.tieba.a.g.login_input_underwrong);
        } else {
            this.y.setBackgroundResource(com.baidu.tieba.a.g.login_input_top);
            this.A.setBackgroundResource(com.baidu.tieba.a.g.login_input_middle);
            if (this.I) {
                this.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_middle);
            } else {
                this.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_under);
            }
            this.C.setBackgroundResource(com.baidu.tieba.a.g.login_input_under);
        }
        this.y.setPadding(this.G, 0, this.H, 0);
        this.z.setPadding(this.G, 0, this.H, 0);
        this.A.setPadding(this.G, 0, this.H, 0);
        this.B.setPadding(this.G, 0, this.H, 0);
        this.C.setPadding(this.G, 0, this.H, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Register2Activity register2Activity, boolean z) {
        register2Activity.I = z;
        if (register2Activity.I) {
            register2Activity.C.setVisibility(0);
            if (register2Activity.w.length() <= 0) {
                register2Activity.x.setEnabled(false);
            }
            if (register2Activity.K != f) {
                register2Activity.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_middle);
            }
            if (register2Activity.N != null) {
                register2Activity.N.cancel();
            }
            if (register2Activity.P != null) {
                register2Activity.N = new ae(register2Activity, register2Activity.P.b().getVcode_pic_url());
                register2Activity.N.setPriority(3);
                register2Activity.N.execute(new String[0]);
            }
        } else {
            register2Activity.C.setVisibility(8);
            register2Activity.w.setText((CharSequence) null);
            if (register2Activity.K != f) {
                register2Activity.B.setBackgroundResource(com.baidu.tieba.a.g.login_input_under);
            }
        }
        register2Activity.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.t.setEnabled(z);
        this.t.setFocusable(z);
        this.t.setFocusableInTouchMode(z);
        this.w.setEnabled(z);
        this.w.setFocusable(z);
        this.w.setFocusableInTouchMode(z);
        this.u.setEnabled(z);
        this.u.setFocusable(z);
        this.u.setFocusableInTouchMode(z);
        this.j.setEnabled(z);
        this.v.setEnabled(z);
        this.v.setFocusable(z);
        this.v.setFocusableInTouchMode(z);
        this.l.setEnabled(z);
        this.o.setEnabled(z);
        this.p.setEnabled(z);
        this.q.setEnabled(z);
        this.F.setEnabled(z);
        this.m.setEnabled(z);
        this.r.setEnabled(z);
        if (z) {
            this.t.setTextColor(getResources().getColor(com.baidu.tieba.a.e.reg_font_color));
            this.w.setTextColor(getResources().getColor(com.baidu.tieba.a.e.reg_font_color));
            this.u.setTextColor(getResources().getColor(com.baidu.tieba.a.e.reg_font_color));
            this.v.setTextColor(getResources().getColor(com.baidu.tieba.a.e.reg_font_color));
            this.o.setTextColor(getResources().getColor(com.baidu.tieba.a.e.reg_font_color));
            this.p.setTextColor(getResources().getColor(com.baidu.tieba.a.e.reg_font_color));
            this.q.setTextColor(getResources().getColor(com.baidu.tieba.a.e.reg_font_color));
            return;
        }
        this.t.setTextColor(getResources().getColor(com.baidu.tieba.a.e.text_hint_color));
        this.w.setTextColor(getResources().getColor(com.baidu.tieba.a.e.text_hint_color));
        this.u.setTextColor(getResources().getColor(com.baidu.tieba.a.e.text_hint_color));
        this.v.setTextColor(getResources().getColor(com.baidu.tieba.a.e.text_hint_color));
        this.o.setTextColor(getResources().getColor(com.baidu.tieba.a.e.text_hint_color));
        this.p.setTextColor(getResources().getColor(com.baidu.tieba.a.e.text_hint_color));
        this.q.setTextColor(getResources().getColor(com.baidu.tieba.a.e.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ RegistData w(Register2Activity register2Activity) {
        RegistData registData = new RegistData();
        registData.setName(register2Activity.t.getText().toString());
        registData.setPsw(register2Activity.u.getText().toString());
        registData.setPhone(register2Activity.v.getText().toString());
        if (register2Activity.I) {
            registData.setVcode(register2Activity.w.getText().toString());
        }
        if (register2Activity.P != null) {
            registData.setVcodeMd5(register2Activity.P.b().getVcode_md5());
            registData.setSmsCodeTime(register2Activity.P.d());
        }
        return registData;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == c && i2 == -1) {
            com.baidu.adp.lib.util.f.a("Register2Activity", "onActivityResult", "onActivityResult");
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Register2Activity register2Activity, ArrayList arrayList) {
        int size;
        register2Activity.z.setVisibility(8);
        register2Activity.n.clearCheck();
        register2Activity.o.setVisibility(8);
        register2Activity.p.setVisibility(8);
        register2Activity.q.setVisibility(8);
        if (arrayList == null || (size = arrayList.size()) <= 0) {
            return;
        }
        register2Activity.z.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            register2Activity.o.setText((CharSequence) arrayList.get(0));
            register2Activity.o.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            register2Activity.p.setText((CharSequence) arrayList.get(1));
            register2Activity.p.setVisibility(0);
        }
        if (size <= 2 || arrayList.get(2) == null) {
            return;
        }
        register2Activity.q.setText((CharSequence) arrayList.get(2));
        register2Activity.q.setVisibility(0);
    }
}
