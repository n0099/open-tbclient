package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.recommend.NewHomeActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class LoginActivity extends com.baidu.tieba.g {
    private aa f;
    private aa g;
    private String j = null;
    private String k = null;
    private String l = null;
    private String m = null;
    private int n = 0;
    private boolean o = true;
    private boolean p = false;
    private boolean q = false;
    private boolean r = true;
    private EditText s = null;
    private EditText t = null;
    private EditText u = null;
    private View v = null;
    private Button w = null;
    private ImageView x = null;
    private ImageView y = null;
    private ImageView z = null;
    private ProgressBar A = null;
    private ProgressBar B = null;
    private Button C = null;
    private ImageView D = null;
    private View E = null;
    private View F = null;
    private View G = null;
    private Button H = null;
    private Button I = null;
    private Button J = null;
    private TextView K = null;
    private TextView L = null;
    private TextView M = null;
    private TextView N = null;
    private Button O = null;
    private Button P = null;

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f632a = null;
    LinearLayout b = null;
    TextView c = null;
    private ac Q = null;
    private com.baidu.tieba.model.al R = null;
    private ab S = null;
    InputMethodManager d = null;
    j e = null;
    private AccountData T = null;
    private String U = null;

    public static void a(Context context) {
        if (TiebaApplication.n()) {
            if (context instanceof NewHomeActivity) {
                com.baidu.tieba.c.a((Activity) context, 0, "goto_recommend", false);
                return;
            }
            return;
        }
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        context.startActivity(intent);
    }

    public static void a(Activity activity, String str, String str2, int i) {
        if (TiebaApplication.n()) {
            com.baidu.tieba.c.a(activity, i, str, false);
            return;
        }
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        intent.putExtra("goto_view", str);
        intent.putExtra("info", str2);
        activity.startActivityForResult(intent, i);
    }

    public static void a(Activity activity, String str, boolean z, int i) {
        if (TiebaApplication.n()) {
            com.baidu.tieba.c.a(activity, i, null, z);
            return;
        }
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        intent.putExtra("info", str);
        intent.putExtra("close", z);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_login_activity);
        this.U = getIntent().getStringExtra("info");
        c();
        if (bundle != null) {
            this.n = bundle.getInt("type_login");
        } else {
            this.n = 0;
        }
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("account");
        this.o = intent.getBooleanExtra("has_exit_dialog", true);
        this.p = intent.getBooleanExtra("close", false);
        if (stringExtra != null) {
            this.s.setText(stringExtra);
        }
        this.s.requestFocus();
        if (this.o) {
            this.D.setVisibility(4);
        } else {
            this.D.setVisibility(0);
        }
        if (this.n == 0) {
            b(R.id.normal_login);
        }
        if (this.n == 1) {
            b(R.id.mobile_login);
        }
        a(this.s, WebChromeClient.STRING_DLG_BTN_SET);
        new af("login").start();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.n = bundle.getInt("type_login");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("type_login", this.n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        try {
            x();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        if (this.e != null) {
            this.e.b();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        if (this.e == null || !this.e.c()) {
            a(this.s, WebChromeClient.STRING_DLG_BTN_SET);
        }
        super.onResume();
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.o) {
                l();
            } else {
                finish();
            }
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case -1:
                b();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a.a().b();
        if (this.p) {
            TiebaApplication.f().z();
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TiebaApplication.F());
            setResult(-1, intent);
        } else {
            MainTabActivity.b(this, getIntent().getStringExtra("goto_view"));
        }
        finish();
    }

    private void c() {
        this.d = (InputMethodManager) getSystemService("input_method");
        this.f632a = (RelativeLayout) findViewById(R.id.container);
        this.b = (LinearLayout) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.s = (EditText) findViewById(R.id.login_edit_account);
        this.t = (EditText) findViewById(R.id.login_edit_password);
        this.u = (EditText) findViewById(R.id.edit_vcode);
        this.E = findViewById(R.id.layout_account);
        this.F = findViewById(R.id.layout_password);
        this.G = findViewById(R.id.layout_vcode);
        this.A = (ProgressBar) findViewById(R.id.image_progress);
        this.y = (ImageView) findViewById(R.id.image_vcode1);
        this.z = (ImageView) findViewById(R.id.image_vcode2);
        this.x = this.y;
        this.B = (ProgressBar) findViewById(R.id.progress_login);
        this.C = (Button) findViewById(R.id.button_vcode_refresh);
        this.H = (Button) findViewById(R.id.button_account_del);
        this.I = (Button) findViewById(R.id.button_pass_del);
        this.J = (Button) findViewById(R.id.button_vcode_del);
        this.K = (TextView) findViewById(R.id.text_title_account);
        this.L = (TextView) findViewById(R.id.text_error);
        this.M = (TextView) findViewById(R.id.text_info);
        if (this.U != null && this.U.length() > 0) {
            this.M.setText(this.U);
            this.M.setVisibility(0);
        }
        this.N = (TextView) findViewById(R.id.text_login);
        this.O = (Button) findViewById(R.id.normal_login);
        this.P = (Button) findViewById(R.id.mobile_login);
        r rVar = new r(this);
        this.s.setOnFocusChangeListener(rVar);
        this.t.setOnFocusChangeListener(rVar);
        this.u.setOnFocusChangeListener(rVar);
        s sVar = new s(this);
        this.t.setOnEditorActionListener(sVar);
        this.u.setOnEditorActionListener(sVar);
        this.s.addTextChangedListener(new t(this));
        this.t.addTextChangedListener(new u(this));
        this.u.addTextChangedListener(new v(this));
        this.v = findViewById(R.id.layout_login);
        this.v.setEnabled(false);
        this.w = (Button) findViewById(R.id.login_bt_reg);
        this.v.setOnClickListener(new w(this));
        this.w.setOnClickListener(new x(this));
        this.D = (ImageView) findViewById(R.id.back);
        this.D.setOnClickListener(new y(this));
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.f(this.c, i);
        com.baidu.tieba.util.x.f((TextView) this.w, i);
        com.baidu.tieba.util.x.a(this.N, i);
        com.baidu.tieba.util.x.c(this.f632a, i);
        com.baidu.tieba.util.x.d(this.b, i);
        com.baidu.tieba.util.x.g((TextView) this.w, i);
        com.baidu.tieba.util.x.a(this.D, i);
        if (i == 1) {
            this.M.setTextColor(getResources().getColor(R.color.skin_1_common_color));
        } else {
            this.M.setTextColor(-13279809);
        }
        w();
        d();
    }

    private void d() {
        if (this.n == 0) {
            if (this.i == 1) {
                this.O.setBackgroundResource(R.drawable.login_tab_pressed_1);
                this.P.setBackgroundResource(R.drawable.login_tab_normal_1);
                this.O.setTextColor(getResources().getColor(R.color.skin_1_common_color));
                this.P.setTextColor(getResources().getColor(R.color.skin_1_tab_unsel_color));
                return;
            }
            this.O.setBackgroundResource(R.drawable.login_tab_pressed);
            this.P.setBackgroundResource(R.drawable.login_tab_normal);
            this.O.setTextColor(Color.rgb(50, 137, 203));
            this.P.setTextColor(-16777216);
        } else if (this.n == 1) {
            if (this.i == 1) {
                this.P.setBackgroundResource(R.drawable.login_tab_pressed_1);
                this.O.setBackgroundResource(R.drawable.login_tab_normal_1);
                this.P.setTextColor(getResources().getColor(R.color.skin_1_common_color));
                this.O.setTextColor(getResources().getColor(R.color.skin_1_tab_unsel_color));
                return;
            }
            this.P.setBackgroundResource(R.drawable.login_tab_pressed);
            this.O.setBackgroundResource(R.drawable.login_tab_normal);
            this.P.setTextColor(Color.rgb(50, 137, 203));
            this.O.setTextColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        boolean z;
        String editable = this.s.getText().toString();
        String editable2 = this.t.getText().toString();
        String editable3 = this.u.getText().toString();
        if (this.G.getVisibility() == 8) {
            z = com.baidu.tieba.util.y.c(editable) || com.baidu.tieba.util.y.c(editable2);
        } else {
            z = com.baidu.tieba.util.y.c(editable) || com.baidu.tieba.util.y.c(editable2) || com.baidu.tieba.util.y.c(editable3);
        }
        if (!z) {
            this.v.setEnabled(true);
        } else {
            this.v.setEnabled(false);
        }
    }

    private void b(int i) {
        switch (i) {
            case R.id.normal_login /* 2131099705 */:
                this.x = this.y;
                this.y.setVisibility(0);
                this.z.setVisibility(8);
                o();
                this.n = 0;
                n();
                this.s.setHint(R.string.account_hint_normal);
                this.K.setText(R.string.account_account);
                this.s.requestFocus();
                this.s.setInputType(1);
                d();
                return;
            case R.id.mobile_login /* 2131099706 */:
                this.x = this.z;
                this.y.setVisibility(8);
                this.z.setVisibility(0);
                o();
                this.n = 1;
                n();
                this.s.setHint(R.string.account_mobile);
                this.K.setText(R.string.account_mobile);
                this.s.requestFocus();
                this.s.setInputType(3);
                d();
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal_login /* 2131099705 */:
            case R.id.mobile_login /* 2131099706 */:
                b(view.getId());
                return;
            case R.id.button_account_del /* 2131099713 */:
                this.s.setText((CharSequence) null);
                return;
            case R.id.button_pass_del /* 2131099717 */:
                this.t.setText((CharSequence) null);
                return;
            case R.id.button_vcode_del /* 2131099720 */:
                this.u.setText((CharSequence) null);
                return;
            case R.id.image_vcode1 /* 2131099721 */:
            case R.id.image_vcode2 /* 2131099722 */:
            case R.id.button_vcode_refresh /* 2131099724 */:
                c(this.m);
                return;
            default:
                return;
        }
    }

    private void n() {
        if (this.n == 0) {
            if (this.f == null) {
                this.j = null;
                this.s.setText((CharSequence) null);
                this.t.setText((CharSequence) null);
                this.u.setText((CharSequence) null);
                this.G.setVisibility(8);
                this.L.setVisibility(4);
                this.r = true;
                this.q = false;
            } else {
                this.j = this.f.f638a;
                this.s.setText(this.f.f638a);
                this.t.setText(this.f.b);
                this.u.setText(this.f.c);
                this.L.setText(this.f.d);
                this.G.setVisibility(this.f.e);
                this.L.setVisibility(this.f.f);
                this.r = this.f.g;
                this.q = this.f.e == 0;
            }
        }
        if (this.n == 1) {
            if (this.g == null) {
                this.j = null;
                this.s.setText((CharSequence) null);
                this.t.setText((CharSequence) null);
                this.u.setText((CharSequence) null);
                this.G.setVisibility(8);
                this.L.setVisibility(4);
                this.r = true;
                this.q = false;
            } else {
                this.j = this.g.f638a;
                this.s.setText(this.g.f638a);
                this.t.setText(this.g.b);
                this.u.setText(this.g.c);
                this.L.setText(this.g.d);
                this.G.setVisibility(this.g.e);
                this.L.setVisibility(this.g.f);
                this.r = this.g.g;
                this.q = this.g.e == 0;
            }
        }
        w();
        m();
    }

    private void o() {
        if (this.n == 0) {
            this.f = new aa(this, null);
            this.f.f638a = this.s.getText().toString();
            this.f.b = this.t.getText().toString();
            this.f.c = this.u.getText().toString();
            this.f.d = this.L.getText().toString();
            this.f.e = this.G.getVisibility();
            this.f.f = this.L.getVisibility();
            this.f.g = this.r;
        }
        if (this.n == 1) {
            this.g = new aa(this, null);
            this.g.f638a = this.s.getText().toString();
            this.g.b = this.t.getText().toString();
            this.g.c = this.u.getText().toString();
            this.g.d = this.L.getText().toString();
            this.g.e = this.G.getVisibility();
            this.g.f = this.L.getVisibility();
            this.g.g = this.r;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.Q == null) {
            String editable = this.s.getText().toString();
            this.k = com.baidu.tieba.util.y.b(this.t.getText().toString().getBytes());
            if (editable.length() > 0 && this.k.length() > 0) {
                if (!this.q || !com.baidu.tieba.util.y.c(this.u.getText().toString())) {
                    u();
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.g.f787a);
                    stringBuffer.append("c/s/login");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.k));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.n)));
                    if (this.G != null && this.G.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.u.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.l));
                    }
                    x();
                    this.Q = new ac(this, stringBuffer.toString(), arrayList);
                    this.Q.setPriority(3);
                    this.Q.execute(stringBuffer.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        AccountData accountData = new AccountData();
        accountData.setAccount(this.R.a().getName());
        if (this.R.a().getPassword() != null) {
            accountData.setPassword(this.R.a().getPassword());
        } else {
            accountData.setPassword(this.k);
        }
        accountData.setID(this.R.a().getId());
        accountData.setBDUSS(this.R.a().getBDUSS());
        accountData.setIsActive(1);
        if (this.R.b() != null) {
            accountData.setTbs(this.R.b().getTbs());
        }
        this.T = accountData;
        if (this.T.getAccount() != null) {
            DatabaseService.a(accountData);
            TiebaApplication.b(this.T);
            b();
            return;
        }
        if (this.e == null) {
            this.e = new j(this);
            this.e.a(new z(this));
        }
        this.e.e();
        this.e.a(this.s.getText().toString());
        this.e.a(this.T);
        this.e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.r = false;
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.S != null) {
            this.S.cancel();
        }
        this.A.setVisibility(0);
        this.x.setImageBitmap(null);
        x();
        this.S = new ab(this, null);
        this.S.setPriority(3);
        this.S.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.q = true;
        this.G.setVisibility(0);
        this.u.setText((CharSequence) null);
        if (this.r) {
            if (this.i == 1) {
                this.F.setBackgroundResource(R.drawable.login_input_middle_1);
            } else {
                this.F.setBackgroundResource(R.drawable.login_input_middle);
            }
        } else if (this.i == 1) {
            this.F.setBackgroundResource(R.drawable.login_input_middlewrong_1);
        } else {
            this.F.setBackgroundResource(R.drawable.login_input_middlewrong);
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.q = false;
        this.G.setVisibility(8);
        if (this.r) {
            this.F.setBackgroundResource(R.drawable.login_input_under);
        } else {
            this.F.setBackgroundResource(R.drawable.login_input_underwrong);
        }
        m();
    }

    private void u() {
        this.s.setEnabled(false);
        this.t.setEnabled(false);
        this.u.setEnabled(false);
        this.C.setEnabled(false);
        this.x.setEnabled(false);
        this.H.setEnabled(false);
        this.I.setEnabled(false);
        this.J.setEnabled(false);
        this.O.setEnabled(false);
        this.P.setEnabled(false);
        this.s.setTextColor(Color.rgb(136, 136, 136));
        this.t.setTextColor(Color.rgb(136, 136, 136));
        this.u.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.s.setEnabled(true);
        this.t.setEnabled(true);
        this.u.setEnabled(true);
        this.C.setEnabled(true);
        this.x.setEnabled(true);
        this.H.setEnabled(true);
        this.I.setEnabled(true);
        this.J.setEnabled(true);
        this.O.setEnabled(true);
        this.P.setEnabled(true);
        this.s.setTextColor(-16777216);
        this.t.setTextColor(-16777216);
        this.u.setTextColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.r) {
            if (this.i == 1) {
                this.E.setBackgroundResource(R.drawable.login_input_top_1);
                if (this.q) {
                    this.F.setBackgroundResource(R.drawable.login_input_middle_1);
                } else {
                    this.F.setBackgroundResource(R.drawable.login_input_under_1);
                }
                this.G.setBackgroundResource(R.drawable.login_input_under_1);
                return;
            }
            this.E.setBackgroundResource(R.drawable.login_input_top);
            if (this.q) {
                this.F.setBackgroundResource(R.drawable.login_input_middle);
            } else {
                this.F.setBackgroundResource(R.drawable.login_input_under);
            }
            this.G.setBackgroundResource(R.drawable.login_input_under);
        } else if (this.i == 1) {
            this.E.setBackgroundResource(R.drawable.login_input_topwrong_1);
            if (this.q) {
                this.F.setBackgroundResource(R.drawable.login_input_middlewrong_1);
            } else {
                this.F.setBackgroundResource(R.drawable.login_input_underwrong_1);
            }
            this.G.setBackgroundResource(R.drawable.login_input_underwrong_1);
        } else {
            this.E.setBackgroundResource(R.drawable.login_input_topwrong);
            if (this.q) {
                this.F.setBackgroundResource(R.drawable.login_input_middlewrong);
            } else {
                this.F.setBackgroundResource(R.drawable.login_input_underwrong);
            }
            this.G.setBackgroundResource(R.drawable.login_input_underwrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.Q != null) {
            this.Q.cancel();
            this.Q = null;
        }
        if (this.S != null) {
            this.S.cancel();
        }
    }
}
