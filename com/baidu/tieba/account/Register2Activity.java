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
import com.baidu.tieba.data.RegistData;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends com.baidu.tieba.g {
    private static int e = LocationClientOption.MIN_SCAN_SPAN;
    private static int f = 27;
    private static int g = 29;
    private static int j = 28;
    private static int k = 6;
    private ImageView l = null;
    private Button m = null;
    private Button n = null;
    private ImageView o = null;
    private ImageView p = null;
    private Button q = null;
    private RadioGroup r = null;
    private RadioButton s = null;
    private RadioButton t = null;
    private RadioButton u = null;
    private TextView v = null;
    private TextView w = null;
    private EditText x = null;
    private EditText y = null;
    private EditText z = null;
    private EditText A = null;
    private RelativeLayout B = null;
    private LinearLayout C = null;
    private LinearLayout D = null;
    private LinearLayout E = null;
    private LinearLayout F = null;
    private LinearLayout G = null;
    private ProgressBar H = null;
    private ProgressBar I = null;
    private ImageView J = null;
    private int K = 0;
    private int L = 0;
    private boolean M = false;
    private boolean N = true;
    private int O = -1;
    private String P = null;

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f866a = null;
    LinearLayout b = null;
    TextView c = null;
    TextView d = null;
    private ax Q = null;
    private ay R = null;
    private com.baidu.tieba.model.as S = null;
    private View.OnClickListener T = new as(this);
    private TextWatcher U = new at(this);
    private View.OnFocusChangeListener V = new au(this);
    private RadioGroup.OnCheckedChangeListener W = new av(this);

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, Register2Activity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_register2_activity);
        o();
        new ag("reg").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        int selectionStart = this.y.getSelectionStart();
        if (!this.N) {
            this.n.setText(getString(R.string.hide));
            this.y.setTransformationMethod(new SingleLineTransformationMethod());
            this.y.setSelection(selectionStart);
            this.N = true;
            return;
        }
        this.n.setText(getString(R.string.show));
        this.y.setTransformationMethod(new PasswordTransformationMethod());
        this.y.setSelection(selectionStart);
        this.N = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.R != null) {
            this.R.cancel();
        }
        if (this.Q != null) {
            this.Q.cancel();
        }
        com.baidu.tieba.util.aq.a("Register2Activity", "onDestroy", "onDestroy");
    }

    private void o() {
        this.f866a = (RelativeLayout) findViewById(R.id.container);
        this.b = (LinearLayout) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.d = (TextView) findViewById(R.id.reg_text);
        this.v = (TextView) findViewById(R.id.reg_info);
        this.B = (RelativeLayout) findViewById(R.id.register);
        this.B.setEnabled(false);
        this.l = (ImageView) findViewById(R.id.back);
        this.m = (Button) findViewById(R.id.login);
        this.n = (Button) findViewById(R.id.show);
        this.y = (EditText) findViewById(R.id.edit_psw);
        this.x = (EditText) findViewById(R.id.edit_user_name);
        this.o = (ImageView) findViewById(R.id.del_user_name);
        this.o.setOnClickListener(this.T);
        this.p = (ImageView) findViewById(R.id.del_phone);
        this.p.setOnClickListener(this.T);
        this.x.setOnFocusChangeListener(this.V);
        this.z = (EditText) findViewById(R.id.edit_phone);
        this.z.setOnFocusChangeListener(this.V);
        this.l.setOnClickListener(this.T);
        this.m.setOnClickListener(this.T);
        this.n.setOnClickListener(this.T);
        this.x.addTextChangedListener(this.U);
        this.y.addTextChangedListener(this.U);
        this.z.addTextChangedListener(this.U);
        this.H = (ProgressBar) findViewById(R.id.progress_reg);
        this.I = (ProgressBar) findViewById(R.id.image_progress);
        this.s = (RadioButton) findViewById(R.id.choose_name1);
        this.t = (RadioButton) findViewById(R.id.choose_name2);
        this.u = (RadioButton) findViewById(R.id.choose_name3);
        this.r = (RadioGroup) findViewById(R.id.name_group);
        this.r.setOnCheckedChangeListener(this.W);
        this.B.setOnClickListener(this.T);
        this.C = (LinearLayout) findViewById(R.id.user_name_bg);
        this.K = this.C.getPaddingLeft();
        this.L = this.C.getPaddingRight();
        this.D = (LinearLayout) findViewById(R.id.recommend_bg);
        this.E = (LinearLayout) findViewById(R.id.input_psw_bg);
        this.F = (LinearLayout) findViewById(R.id.input_phone_bg);
        this.G = (LinearLayout) findViewById(R.id.input_vcode_bg);
        this.w = (TextView) findViewById(R.id.text_error);
        this.J = (ImageView) findViewById(R.id.image_vcode);
        this.q = (Button) findViewById(R.id.change_vcode);
        this.J.setOnClickListener(this.T);
        this.q.setOnClickListener(this.T);
        this.A = (EditText) findViewById(R.id.edit_vcode);
        this.A.addTextChangedListener(this.U);
        n();
        a(this.x, WebChromeClient.STRING_DLG_BTN_SET);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ao.f(this.c, i);
        com.baidu.tieba.util.ao.f((TextView) this.m, i);
        com.baidu.tieba.util.ao.a(this.d, i);
        com.baidu.tieba.util.ao.c(this.f866a, i);
        com.baidu.tieba.util.ao.d(this.b, i);
        com.baidu.tieba.util.ao.g((TextView) this.m, i);
        com.baidu.tieba.util.ao.a(this.l, i);
        u();
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        b(false);
    }

    private void q() {
        this.C.setPadding(this.K, 0, this.L, 0);
        this.D.setPadding(this.K, 0, this.L, 0);
        this.E.setPadding(this.K, 0, this.L, 0);
        this.F.setPadding(this.K, 0, this.L, 0);
        this.G.setPadding(this.K, 0, this.L, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.w.setText(this.P);
        if (this.P != null) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(4);
        }
        if (this.i == 1) {
            if (this.O == f) {
                this.C.setBackgroundResource(R.drawable.login_input_topwrong_1);
            } else if (this.O == g) {
                this.E.setBackgroundResource(R.drawable.login_input_middlewrong_1);
            } else if (this.O == j) {
                if (this.M) {
                    this.F.setBackgroundResource(R.drawable.login_input_middlewrong_1);
                } else {
                    this.F.setBackgroundResource(R.drawable.login_input_underwrong_1);
                }
            } else if (this.O == k) {
                this.G.setBackgroundResource(R.drawable.login_input_underwrong_1);
            } else {
                this.C.setBackgroundResource(R.drawable.login_input_top_1);
                this.E.setBackgroundResource(R.drawable.login_input_middle_1);
                if (this.M) {
                    this.F.setBackgroundResource(R.drawable.login_input_middle_1);
                } else {
                    this.F.setBackgroundResource(R.drawable.login_input_under_1);
                }
                this.G.setBackgroundResource(R.drawable.login_input_under_1);
            }
        } else if (this.O == f) {
            this.C.setBackgroundResource(R.drawable.login_input_topwrong);
        } else if (this.O == g) {
            this.E.setBackgroundResource(R.drawable.login_input_middlewrong);
        } else if (this.O == j) {
            if (this.M) {
                this.F.setBackgroundResource(R.drawable.login_input_middlewrong);
            } else {
                this.F.setBackgroundResource(R.drawable.login_input_underwrong);
            }
        } else if (this.O == k) {
            this.G.setBackgroundResource(R.drawable.login_input_underwrong);
        } else {
            this.C.setBackgroundResource(R.drawable.login_input_top);
            this.E.setBackgroundResource(R.drawable.login_input_middle);
            if (this.M) {
                this.F.setBackgroundResource(R.drawable.login_input_middle);
            } else {
                this.F.setBackgroundResource(R.drawable.login_input_under);
            }
            this.G.setBackgroundResource(R.drawable.login_input_under);
        }
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.M = z;
        if (this.M) {
            this.G.setVisibility(0);
            if (this.A.length() <= 0) {
                this.B.setEnabled(false);
            }
            if (this.O != j) {
                this.F.setBackgroundResource(R.drawable.login_input_middle);
            }
            if (this.Q != null) {
                this.Q.cancel();
            }
            if (this.S != null) {
                this.Q = new ax(this, this.S.b().getVcode_pic_url());
                this.Q.setPriority(3);
                this.Q.execute(new String[0]);
            }
        } else {
            this.G.setVisibility(8);
            this.A.setText((CharSequence) null);
            if (this.O != j) {
                this.F.setBackgroundResource(R.drawable.login_input_under);
            }
        }
        r();
    }

    private void b(boolean z) {
        this.x.setEnabled(z);
        this.x.setFocusable(z);
        this.x.setFocusableInTouchMode(z);
        this.A.setEnabled(z);
        this.A.setFocusable(z);
        this.A.setFocusableInTouchMode(z);
        this.y.setEnabled(z);
        this.y.setFocusable(z);
        this.y.setFocusableInTouchMode(z);
        this.n.setEnabled(z);
        this.z.setEnabled(z);
        this.z.setFocusable(z);
        this.z.setFocusableInTouchMode(z);
        this.p.setEnabled(z);
        this.s.setEnabled(z);
        this.t.setEnabled(z);
        this.u.setEnabled(z);
        this.J.setEnabled(z);
        this.q.setEnabled(z);
        this.v.setEnabled(z);
        if (z) {
            this.x.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.A.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.y.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.z.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.s.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.t.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.u.setTextColor(getResources().getColor(R.color.reg_font_color));
            return;
        }
        this.x.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.A.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.y.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.z.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.s.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.t.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.u.setTextColor(getResources().getColor(R.color.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData t() {
        RegistData registData = new RegistData();
        registData.setName(this.x.getText().toString());
        registData.setPsw(this.y.getText().toString());
        registData.setPhone(this.z.getText().toString());
        if (this.M) {
            registData.setVcode(this.A.getText().toString());
        }
        if (this.S != null) {
            registData.setVcodeMd5(this.S.b().getVcode_md5());
            registData.setSmsCodeTime(this.S.d());
        }
        return registData;
    }

    private void u() {
        String string;
        int length = getString(R.string.reg_info).length();
        String str = String.valueOf(string) + getString(R.string.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new aw(this, this), length, length2, 33);
        if (this.i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
        }
        this.v.setMovementMethod(LinkMovementMethod.getInstance());
        this.v.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == e && i2 == -1) {
            com.baidu.tieba.util.aq.a("Register2Activity", "onActivityResult", "onActivityResult");
            setResult(-1);
            finish();
        }
    }

    public void b() {
        this.D.setVisibility(8);
        this.r.clearCheck();
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList arrayList) {
        int size;
        b();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.D.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.s.setText((CharSequence) arrayList.get(0));
                this.s.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.t.setText((CharSequence) arrayList.get(1));
                this.t.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.u.setText((CharSequence) arrayList.get(2));
                this.u.setVisibility(0);
            }
        }
    }
}
