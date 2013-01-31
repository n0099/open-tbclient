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
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.recommend.NewHomeActivity;
import com.baidu.zeus.WebChromeClient;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class LoginActivity extends com.baidu.tieba.e {
    private af h;
    private af i;
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
    private Button D = null;
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
    RelativeLayout c = null;
    LinearLayout d = null;
    TextView e = null;
    private ah Q = null;
    private com.baidu.tieba.b.g R = null;
    private ag S = null;
    InputMethodManager f = null;
    o g = null;
    private com.baidu.tieba.a.a T = null;
    private String U = null;

    public static void a(Context context) {
        if (TiebaApplication.g()) {
            if (context instanceof NewHomeActivity) {
                com.baidu.tieba.a.a((Activity) context, 0, "goto_recommend", false);
                return;
            }
            return;
        }
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        context.startActivity(intent);
    }

    public static void a(Activity activity, String str, String str2, int i) {
        if (TiebaApplication.g()) {
            com.baidu.tieba.a.a(activity, i, str, false);
            return;
        }
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        intent.putExtra("goto_view", str);
        intent.putExtra("info", str2);
        activity.startActivityForResult(intent, i);
    }

    public static void a(Activity activity, String str, boolean z, int i) {
        if (TiebaApplication.g()) {
            com.baidu.tieba.a.a(activity, i, null, z);
            return;
        }
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        intent.putExtra("info", str);
        intent.putExtra("close", z);
        activity.startActivityForResult(intent, i);
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_login_activity);
        this.U = getIntent().getStringExtra("info");
        j();
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
            c(R.id.normal_login);
        }
        if (this.n == 1) {
            c(R.id.mobile_login);
        }
        a(this.s, WebChromeClient.STRING_DLG_BTN_SET);
        new ak("login").start();
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

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        try {
            w();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        if (this.g != null) {
            this.g.b();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.g == null || !this.g.c()) {
            a(this.s, WebChromeClient.STRING_DLG_BTN_SET);
        }
        super.onResume();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.o) {
                h();
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
                i();
                return;
            default:
                return;
        }
    }

    public void i() {
        a.a().b();
        if (this.p) {
            TiebaApplication.b().r();
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TiebaApplication.x());
            setResult(-1, intent);
        } else {
            MainTabActivity.b(this, getIntent().getStringExtra("goto_view"));
        }
        finish();
    }

    private void j() {
        this.f = (InputMethodManager) getSystemService("input_method");
        this.c = (RelativeLayout) findViewById(R.id.container);
        this.d = (LinearLayout) findViewById(R.id.title);
        this.e = (TextView) findViewById(R.id.title_text);
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
        w wVar = new w(this);
        this.s.setOnFocusChangeListener(wVar);
        this.t.setOnFocusChangeListener(wVar);
        this.u.setOnFocusChangeListener(wVar);
        x xVar = new x(this);
        this.t.setOnEditorActionListener(xVar);
        this.u.setOnEditorActionListener(xVar);
        this.s.addTextChangedListener(new y(this));
        this.t.addTextChangedListener(new z(this));
        this.u.addTextChangedListener(new aa(this));
        this.v = findViewById(R.id.layout_login);
        this.v.setEnabled(false);
        this.w = (Button) findViewById(R.id.login_bt_reg);
        this.v.setOnClickListener(new ab(this));
        this.w.setOnClickListener(new ac(this));
        this.D = (Button) findViewById(R.id.back);
        this.D.setOnClickListener(new ad(this));
        s();
    }

    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ad.c(this.e, i);
        com.baidu.tieba.c.ad.c((TextView) this.w, i);
        com.baidu.tieba.c.ad.c((TextView) this.D, i);
        com.baidu.tieba.c.ad.a(this.N, i);
        com.baidu.tieba.c.ad.b(this.c, i);
        com.baidu.tieba.c.ad.c(this.d, i);
        com.baidu.tieba.c.ad.d((TextView) this.w, i);
        com.baidu.tieba.c.ad.e((TextView) this.D, i);
        if (i == 1) {
            this.M.setTextColor(getResources().getColor(R.color.skin_1_common_color));
        } else {
            this.M.setTextColor(-13279809);
        }
        v();
        k();
    }

    private void k() {
        if (this.n == 0) {
            if (this.b == 1) {
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
            if (this.b == 1) {
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

    public void l() {
        boolean z;
        String editable = this.s.getText().toString();
        String editable2 = this.t.getText().toString();
        String editable3 = this.u.getText().toString();
        if (this.G.getVisibility() == 8) {
            z = com.baidu.tieba.c.ae.e(editable) || com.baidu.tieba.c.ae.e(editable2);
        } else {
            z = com.baidu.tieba.c.ae.e(editable) || com.baidu.tieba.c.ae.e(editable2) || com.baidu.tieba.c.ae.e(editable3);
        }
        if (!z) {
            this.v.setEnabled(true);
        } else {
            this.v.setEnabled(false);
        }
    }

    private void c(int i) {
        switch (i) {
            case R.id.normal_login /* 2131230746 */:
                this.x = this.y;
                this.y.setVisibility(0);
                this.z.setVisibility(8);
                n();
                this.n = 0;
                m();
                this.s.setHint(R.string.account_hint_normal);
                this.K.setText(R.string.account_account);
                this.s.requestFocus();
                this.s.setInputType(1);
                k();
                return;
            case R.id.mobile_login /* 2131230747 */:
                this.x = this.z;
                this.y.setVisibility(8);
                this.z.setVisibility(0);
                n();
                this.n = 1;
                m();
                this.s.setHint(R.string.account_mobile);
                this.K.setText(R.string.account_mobile);
                this.s.requestFocus();
                this.s.setInputType(3);
                k();
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal_login /* 2131230746 */:
            case R.id.mobile_login /* 2131230747 */:
                c(view.getId());
                return;
            case R.id.button_account_del /* 2131230754 */:
                this.s.setText((CharSequence) null);
                return;
            case R.id.button_pass_del /* 2131230758 */:
                this.t.setText((CharSequence) null);
                return;
            case R.id.button_vcode_del /* 2131230761 */:
                this.u.setText((CharSequence) null);
                return;
            case R.id.image_vcode1 /* 2131230762 */:
            case R.id.image_vcode2 /* 2131230763 */:
            case R.id.button_vcode_refresh /* 2131230765 */:
                c(this.m);
                return;
            default:
                return;
        }
    }

    private void m() {
        if (this.n == 0) {
            if (this.h == null) {
                this.j = null;
                this.s.setText((CharSequence) null);
                this.t.setText((CharSequence) null);
                this.u.setText((CharSequence) null);
                this.G.setVisibility(8);
                this.L.setVisibility(4);
                this.r = true;
                this.q = false;
            } else {
                this.j = this.h.a;
                this.s.setText(this.h.a);
                this.t.setText(this.h.b);
                this.u.setText(this.h.c);
                this.L.setText(this.h.d);
                this.G.setVisibility(this.h.e);
                this.L.setVisibility(this.h.f);
                this.r = this.h.g;
                this.q = this.h.e == 0;
            }
        }
        if (this.n == 1) {
            if (this.i == null) {
                this.j = null;
                this.s.setText((CharSequence) null);
                this.t.setText((CharSequence) null);
                this.u.setText((CharSequence) null);
                this.G.setVisibility(8);
                this.L.setVisibility(4);
                this.r = true;
                this.q = false;
            } else {
                this.j = this.i.a;
                this.s.setText(this.i.a);
                this.t.setText(this.i.b);
                this.u.setText(this.i.c);
                this.L.setText(this.i.d);
                this.G.setVisibility(this.i.e);
                this.L.setVisibility(this.i.f);
                this.r = this.i.g;
                this.q = this.i.e == 0;
            }
        }
        v();
        l();
    }

    private void n() {
        if (this.n == 0) {
            this.h = new af(this, null);
            this.h.a = this.s.getText().toString();
            this.h.b = this.t.getText().toString();
            this.h.c = this.u.getText().toString();
            this.h.d = this.L.getText().toString();
            this.h.e = this.G.getVisibility();
            this.h.f = this.L.getVisibility();
            this.h.g = this.r;
        }
        if (this.n == 1) {
            this.i = new af(this, null);
            this.i.a = this.s.getText().toString();
            this.i.b = this.t.getText().toString();
            this.i.c = this.u.getText().toString();
            this.i.d = this.L.getText().toString();
            this.i.e = this.G.getVisibility();
            this.i.f = this.L.getVisibility();
            this.i.g = this.r;
        }
    }

    public void o() {
        if (this.Q == null) {
            String editable = this.s.getText().toString();
            this.k = com.baidu.tieba.c.ae.b(this.t.getText().toString().getBytes());
            if (editable.length() > 0 && this.k.length() > 0) {
                if (!this.q || !com.baidu.tieba.c.ae.e(this.u.getText().toString())) {
                    t();
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append("http://c.tieba.baidu.com/");
                    stringBuffer.append("c/s/login");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.k));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.n)));
                    if (this.G != null && this.G.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.u.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.l));
                    }
                    w();
                    this.Q = new ah(this, stringBuffer.toString(), arrayList);
                    this.Q.execute(stringBuffer.toString(), arrayList);
                }
            }
        }
    }

    public void p() {
        com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
        aVar.b(this.R.a().b());
        if (this.R.a().e() != null) {
            aVar.c(this.R.a().e());
        } else {
            aVar.c(this.k);
        }
        aVar.a(this.R.a().a());
        aVar.d(this.R.a().j());
        aVar.a(1);
        if (this.R.b() != null) {
            aVar.e(this.R.b().b());
        }
        this.T = aVar;
        if (this.T.b() != null) {
            com.baidu.tieba.c.k.a(aVar);
            TiebaApplication.b(this.T);
            i();
            return;
        }
        if (this.g == null) {
            this.g = new o(this);
            this.g.a(new ae(this));
        }
        this.g.e();
        this.g.a(this.s.getText().toString());
        this.g.a(this.T);
        this.g.a();
    }

    public void q() {
        this.r = false;
        v();
    }

    public void c(String str) {
        if (this.S != null) {
            this.S.a();
        }
        this.A.setVisibility(0);
        this.x.setImageBitmap(null);
        w();
        this.S = new ag(this, null);
        this.S.execute(str);
    }

    public void r() {
        this.q = true;
        this.G.setVisibility(0);
        this.u.setText((CharSequence) null);
        if (this.r) {
            if (this.b == 1) {
                this.F.setBackgroundResource(R.drawable.login_input_middle_1);
            } else {
                this.F.setBackgroundResource(R.drawable.login_input_middle);
            }
        } else if (this.b == 1) {
            this.F.setBackgroundResource(R.drawable.login_input_middlewrong_1);
        } else {
            this.F.setBackgroundResource(R.drawable.login_input_middlewrong);
        }
        l();
    }

    public void s() {
        this.q = false;
        this.G.setVisibility(8);
        if (this.r) {
            this.F.setBackgroundResource(R.drawable.login_input_under);
        } else {
            this.F.setBackgroundResource(R.drawable.login_input_underwrong);
        }
        l();
    }

    private void t() {
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

    public void u() {
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

    public void v() {
        if (this.r) {
            if (this.b == 1) {
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
        } else if (this.b == 1) {
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

    public void w() {
        if (this.Q != null) {
            this.Q.a();
            this.Q = null;
        }
        if (this.S != null) {
            this.S.a();
        }
    }
}
