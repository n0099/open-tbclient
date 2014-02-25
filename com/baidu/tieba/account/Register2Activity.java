package com.baidu.tieba.account;

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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends com.baidu.tieba.f {
    private static int c = LocationClientOption.MIN_SCAN_SPAN;
    private static int d = 27;
    private static int e = 29;
    private static int f = 28;
    private static int g = 6;
    private NavigationBar M;
    private ImageView h = null;
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
    private bl N = null;
    private bm O = null;
    private com.baidu.tieba.model.at P = null;
    private View.OnClickListener Q = new bg(this);
    private TextWatcher R = new bh(this);
    private View.OnFocusChangeListener S = new bi(this);
    private RadioGroup.OnCheckedChangeListener T = new bj(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_register2_activity);
        h();
        new ax("reg").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int selectionStart = this.u.getSelectionStart();
        if (!this.J) {
            this.j.setText(getString(R.string.hide));
            this.u.setTransformationMethod(new SingleLineTransformationMethod());
            this.u.setSelection(selectionStart);
            this.J = true;
            return;
        }
        this.j.setText(getString(R.string.show));
        this.u.setTransformationMethod(new PasswordTransformationMethod());
        this.u.setSelection(selectionStart);
        this.J = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
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

    private void h() {
        this.a = (RelativeLayout) findViewById(R.id.container);
        this.M = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.h = this.M.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.Q);
        this.M.a(getString(R.string.account_regedit_baidu));
        this.i = this.M.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.account_login), this.Q);
        this.b = (TextView) findViewById(R.id.reg_text);
        this.r = (TextView) findViewById(R.id.reg_info);
        this.x = (RelativeLayout) findViewById(R.id.register);
        this.x.setEnabled(false);
        this.j = (Button) findViewById(R.id.show);
        this.u = (EditText) findViewById(R.id.edit_psw);
        this.t = (EditText) findViewById(R.id.edit_user_name);
        this.k = (ImageView) findViewById(R.id.del_user_name);
        this.k.setOnClickListener(this.Q);
        this.l = (ImageView) findViewById(R.id.del_phone);
        this.l.setOnClickListener(this.Q);
        this.t.setOnFocusChangeListener(this.S);
        this.v = (EditText) findViewById(R.id.edit_phone);
        this.v.setOnFocusChangeListener(this.S);
        this.j.setOnClickListener(this.Q);
        this.t.addTextChangedListener(this.R);
        this.u.addTextChangedListener(this.R);
        this.v.addTextChangedListener(this.R);
        this.D = (ProgressBar) findViewById(R.id.progress_reg);
        this.E = (ProgressBar) findViewById(R.id.image_progress);
        this.o = (RadioButton) findViewById(R.id.choose_name1);
        this.p = (RadioButton) findViewById(R.id.choose_name2);
        this.q = (RadioButton) findViewById(R.id.choose_name3);
        this.n = (RadioGroup) findViewById(R.id.name_group);
        this.n.setOnCheckedChangeListener(this.T);
        this.x.setOnClickListener(this.Q);
        this.y = (LinearLayout) findViewById(R.id.user_name_bg);
        this.G = this.y.getPaddingLeft();
        this.H = this.y.getPaddingRight();
        this.z = (LinearLayout) findViewById(R.id.recommend_bg);
        this.A = (LinearLayout) findViewById(R.id.input_psw_bg);
        this.B = (LinearLayout) findViewById(R.id.input_phone_bg);
        this.C = (LinearLayout) findViewById(R.id.input_vcode_bg);
        this.s = (TextView) findViewById(R.id.text_error);
        this.F = (ImageView) findViewById(R.id.image_vcode);
        this.m = (Button) findViewById(R.id.change_vcode);
        this.F.setOnClickListener(this.Q);
        this.m.setOnClickListener(this.Q);
        this.w = (EditText) findViewById(R.id.edit_vcode);
        this.w.addTextChangedListener(this.R);
        g();
        ShowSoftKeyPadDelay(this.t, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.M.c(i);
        com.baidu.tieba.util.bq.a(this.b, i);
        com.baidu.tieba.util.bq.c(this.a, i);
        n();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        b(false);
    }

    private void j() {
        this.y.setPadding(this.G, 0, this.H, 0);
        this.z.setPadding(this.G, 0, this.H, 0);
        this.A.setPadding(this.G, 0, this.H, 0);
        this.B.setPadding(this.G, 0, this.H, 0);
        this.C.setPadding(this.G, 0, this.H, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.s.setText(this.L);
        if (this.L != null) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(4);
        }
        if (this.mSkinType == 1) {
            if (this.K == d) {
                this.y.setBackgroundResource(R.drawable.login_input_topwrong_1);
            } else if (this.K == e) {
                this.A.setBackgroundResource(R.drawable.login_input_middlewrong_1);
            } else if (this.K == f) {
                if (this.I) {
                    this.B.setBackgroundResource(R.drawable.login_input_middlewrong_1);
                } else {
                    this.B.setBackgroundResource(R.drawable.login_input_underwrong_1);
                }
            } else if (this.K == g) {
                this.C.setBackgroundResource(R.drawable.login_input_underwrong_1);
            } else {
                this.y.setBackgroundResource(R.drawable.login_input_top_1);
                this.A.setBackgroundResource(R.drawable.login_input_middle_1);
                if (this.I) {
                    this.B.setBackgroundResource(R.drawable.login_input_middle_1);
                } else {
                    this.B.setBackgroundResource(R.drawable.login_input_under_1);
                }
                this.C.setBackgroundResource(R.drawable.login_input_under_1);
            }
        } else if (this.K == d) {
            this.y.setBackgroundResource(R.drawable.login_input_topwrong);
        } else if (this.K == e) {
            this.A.setBackgroundResource(R.drawable.login_input_middlewrong);
        } else if (this.K == f) {
            if (this.I) {
                this.B.setBackgroundResource(R.drawable.login_input_middlewrong);
            } else {
                this.B.setBackgroundResource(R.drawable.login_input_underwrong);
            }
        } else if (this.K == g) {
            this.C.setBackgroundResource(R.drawable.login_input_underwrong);
        } else {
            this.y.setBackgroundResource(R.drawable.login_input_top);
            this.A.setBackgroundResource(R.drawable.login_input_middle);
            if (this.I) {
                this.B.setBackgroundResource(R.drawable.login_input_middle);
            } else {
                this.B.setBackgroundResource(R.drawable.login_input_under);
            }
            this.C.setBackgroundResource(R.drawable.login_input_under);
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.I = z;
        if (this.I) {
            this.C.setVisibility(0);
            if (this.w.length() <= 0) {
                this.x.setEnabled(false);
            }
            if (this.K != f) {
                this.B.setBackgroundResource(R.drawable.login_input_middle);
            }
            if (this.N != null) {
                this.N.cancel();
            }
            if (this.P != null) {
                this.N = new bl(this, this.P.b().getVcode_pic_url());
                this.N.setPriority(3);
                this.N.execute(new String[0]);
            }
        } else {
            this.C.setVisibility(8);
            this.w.setText((CharSequence) null);
            if (this.K != f) {
                this.B.setBackgroundResource(R.drawable.login_input_under);
            }
        }
        k();
    }

    private void b(boolean z) {
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
            this.t.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.w.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.u.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.v.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.o.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.p.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.q.setTextColor(getResources().getColor(R.color.reg_font_color));
            return;
        }
        this.t.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.w.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.u.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.v.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.o.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.p.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.q.setTextColor(getResources().getColor(R.color.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData m() {
        RegistData registData = new RegistData();
        registData.setName(this.t.getText().toString());
        registData.setPsw(this.u.getText().toString());
        registData.setPhone(this.v.getText().toString());
        if (this.I) {
            registData.setVcode(this.w.getText().toString());
        }
        if (this.P != null) {
            registData.setVcodeMd5(this.P.b().getVcode_md5());
            registData.setSmsCodeTime(this.P.d());
        }
        return registData;
    }

    private void n() {
        String string;
        int length = getString(R.string.reg_info).length();
        String str = String.valueOf(string) + getString(R.string.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new bk(this, this), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
        }
        this.r.setMovementMethod(LinkMovementMethod.getInstance());
        this.r.setText(spannableString);
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

    public void a() {
        this.z.setVisibility(8);
        this.n.clearCheck();
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<String> arrayList) {
        int size;
        a();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.z.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.o.setText(arrayList.get(0));
                this.o.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.p.setText(arrayList.get(1));
                this.p.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.q.setText(arrayList.get(2));
                this.q.setVisibility(0);
            }
        }
    }
}
