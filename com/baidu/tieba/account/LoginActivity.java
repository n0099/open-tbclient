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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.recommend.NewHomeActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class LoginActivity extends com.baidu.tieba.e {
    private af d;
    private af e;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private int j = 0;
    private boolean k = true;
    private boolean l = false;
    private boolean m = false;
    private boolean n = true;
    private EditText o = null;
    private EditText p = null;
    private EditText q = null;
    private View r = null;
    private Button s = null;
    private ImageView t = null;
    private ImageView u = null;
    private ImageView v = null;
    private ProgressBar w = null;
    private ProgressBar x = null;
    private Button y = null;
    private Button z = null;
    private View A = null;
    private View B = null;
    private View C = null;
    private Button D = null;
    private Button E = null;
    private Button F = null;
    private TextView G = null;
    private TextView H = null;
    private TextView I = null;
    private TextView J = null;
    private Button K = null;
    private Button L = null;
    private ah M = null;
    private com.baidu.tieba.b.g N = null;
    private ag O = null;
    InputMethodManager b = null;
    o c = null;
    private com.baidu.tieba.a.a P = null;
    private String Q = null;

    private void a(int i) {
        View findViewById = findViewById(R.id.normal_login);
        View findViewById2 = findViewById(R.id.mobile_login);
        switch (i) {
            case R.id.normal_login /* 2131230736 */:
                this.t = this.u;
                this.u.setVisibility(0);
                this.v.setVisibility(8);
                k();
                this.j = 0;
                j();
                this.o.setHint(R.string.account_hint_normal);
                findViewById.setBackgroundResource(R.drawable.login_tab_pressed);
                findViewById2.setBackgroundResource(R.drawable.login_tab_normal);
                this.G.setText(R.string.account_account);
                this.o.requestFocus();
                this.K.setTextColor(Color.rgb(50, 137, 203));
                this.L.setTextColor(-16777216);
                this.o.setInputType(1);
                return;
            case R.id.mobile_login /* 2131230737 */:
                this.t = this.v;
                this.u.setVisibility(8);
                this.v.setVisibility(0);
                k();
                this.j = 1;
                j();
                this.o.setHint(R.string.account_mobile);
                findViewById2.setBackgroundResource(R.drawable.login_tab_pressed);
                findViewById.setBackgroundResource(R.drawable.login_tab_normal);
                this.G.setText(R.string.account_mobile);
                this.o.requestFocus();
                this.L.setTextColor(Color.rgb(50, 137, 203));
                this.K.setTextColor(-16777216);
                this.o.setInputType(3);
                return;
            default:
                return;
        }
    }

    public static void a(Activity activity, String str, String str2, int i) {
        if (TiebaApplication.f()) {
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
        if (TiebaApplication.f()) {
            com.baidu.tieba.a.a(activity, i, null, z);
            return;
        }
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        intent.putExtra("info", str);
        intent.putExtra("close", z);
        activity.startActivityForResult(intent, i);
    }

    public static void a(Context context) {
        if (TiebaApplication.f()) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.O != null) {
            this.O.a();
        }
        this.w.setVisibility(0);
        this.t.setImageBitmap(null);
        t();
        this.O = new ag(this, null);
        this.O.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        a.a().b();
        if (this.l) {
            TiebaApplication.a().p();
            setResult(-1);
        } else {
            MainTabActivity.b(this, getIntent().getStringExtra("goto_view"));
        }
        finish();
    }

    private void h() {
        this.b = (InputMethodManager) getSystemService("input_method");
        this.o = (EditText) findViewById(R.id.login_edit_account);
        this.p = (EditText) findViewById(R.id.login_edit_password);
        this.q = (EditText) findViewById(R.id.edit_vcode);
        this.A = findViewById(R.id.layout_account);
        this.B = findViewById(R.id.layout_password);
        this.C = findViewById(R.id.layout_vcode);
        this.w = (ProgressBar) findViewById(R.id.image_progress);
        this.u = (ImageView) findViewById(R.id.image_vcode1);
        this.v = (ImageView) findViewById(R.id.image_vcode2);
        this.t = this.u;
        this.x = (ProgressBar) findViewById(R.id.progress_login);
        this.y = (Button) findViewById(R.id.button_vcode_refresh);
        this.D = (Button) findViewById(R.id.button_account_del);
        this.E = (Button) findViewById(R.id.button_pass_del);
        this.F = (Button) findViewById(R.id.button_vcode_del);
        this.G = (TextView) findViewById(R.id.text_title_account);
        this.H = (TextView) findViewById(R.id.text_error);
        this.I = (TextView) findViewById(R.id.text_info);
        if (this.Q != null && this.Q.length() > 0) {
            this.I.setText(this.Q);
            this.I.setVisibility(0);
        }
        this.J = (TextView) findViewById(R.id.text_login);
        this.K = (Button) findViewById(R.id.normal_login);
        this.L = (Button) findViewById(R.id.mobile_login);
        w wVar = new w(this);
        this.o.setOnFocusChangeListener(wVar);
        this.p.setOnFocusChangeListener(wVar);
        this.q.setOnFocusChangeListener(wVar);
        x xVar = new x(this);
        this.p.setOnEditorActionListener(xVar);
        this.q.setOnEditorActionListener(xVar);
        this.o.addTextChangedListener(new y(this));
        this.p.addTextChangedListener(new z(this));
        this.q.addTextChangedListener(new aa(this));
        this.r = findViewById(R.id.layout_login);
        this.r.setEnabled(false);
        this.s = (Button) findViewById(R.id.login_bt_reg);
        this.r.setOnClickListener(new ab(this));
        this.s.setOnClickListener(new ac(this));
        this.z = (Button) findViewById(R.id.back);
        this.z.setOnClickListener(new ad(this));
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String editable = this.o.getText().toString();
        String editable2 = this.p.getText().toString();
        if (this.C.getVisibility() == 8 ? com.baidu.tieba.c.ad.e(editable) || com.baidu.tieba.c.ad.e(editable2) : com.baidu.tieba.c.ad.e(editable) || com.baidu.tieba.c.ad.e(editable2) || com.baidu.tieba.c.ad.e(this.q.getText().toString())) {
            this.r.setEnabled(false);
        } else {
            this.r.setEnabled(true);
        }
    }

    private void j() {
        if (this.j == 0) {
            if (this.d == null) {
                this.f = null;
                this.o.setText((CharSequence) null);
                this.p.setText((CharSequence) null);
                this.q.setText((CharSequence) null);
                this.C.setVisibility(8);
                this.H.setVisibility(4);
                this.n = true;
                this.m = false;
            } else {
                this.f = this.d.a;
                this.o.setText(this.d.a);
                this.p.setText(this.d.b);
                this.q.setText(this.d.c);
                this.H.setText(this.d.d);
                this.C.setVisibility(this.d.e);
                this.H.setVisibility(this.d.f);
                this.n = this.d.g;
                this.m = this.d.e == 0;
            }
        }
        if (this.j == 1) {
            if (this.e == null) {
                this.f = null;
                this.o.setText((CharSequence) null);
                this.p.setText((CharSequence) null);
                this.q.setText((CharSequence) null);
                this.C.setVisibility(8);
                this.H.setVisibility(4);
                this.n = true;
                this.m = false;
            } else {
                this.f = this.e.a;
                this.o.setText(this.e.a);
                this.p.setText(this.e.b);
                this.q.setText(this.e.c);
                this.H.setText(this.e.d);
                this.C.setVisibility(this.e.e);
                this.H.setVisibility(this.e.f);
                this.n = this.e.g;
                this.m = this.e.e == 0;
            }
        }
        s();
        i();
    }

    private void k() {
        if (this.j == 0) {
            this.d = new af(this, null);
            this.d.a = this.o.getText().toString();
            this.d.b = this.p.getText().toString();
            this.d.c = this.q.getText().toString();
            this.d.d = this.H.getText().toString();
            this.d.e = this.C.getVisibility();
            this.d.f = this.H.getVisibility();
            this.d.g = this.n;
        }
        if (this.j == 1) {
            this.e = new af(this, null);
            this.e.a = this.o.getText().toString();
            this.e.b = this.p.getText().toString();
            this.e.c = this.q.getText().toString();
            this.e.d = this.H.getText().toString();
            this.e.e = this.C.getVisibility();
            this.e.f = this.H.getVisibility();
            this.e.g = this.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.M != null) {
            return;
        }
        String editable = this.o.getText().toString();
        this.g = com.baidu.tieba.c.ad.b(this.p.getText().toString().getBytes());
        if (editable.length() <= 0 || this.g.length() <= 0) {
            return;
        }
        if (this.m && com.baidu.tieba.c.ad.e(this.q.getText().toString())) {
            return;
        }
        q();
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        stringBuffer.append("c/s/login");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("un", editable));
        arrayList.add(new BasicNameValuePair("passwd", this.g));
        arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.j)));
        if (this.C != null && this.C.getVisibility() == 0) {
            arrayList.add(new BasicNameValuePair("vcode", this.q.getText().toString()));
            arrayList.add(new BasicNameValuePair("vcode_md5", this.h));
        }
        t();
        this.M = new ah(this, stringBuffer.toString(), arrayList);
        this.M.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
        aVar.b(this.N.a().b());
        if (this.N.a().e() != null) {
            aVar.c(this.N.a().e());
        } else {
            aVar.c(this.g);
        }
        aVar.a(this.N.a().a());
        aVar.d(this.N.a().j());
        aVar.a(1);
        if (this.N.b() != null) {
            aVar.e(this.N.b().b());
        }
        this.P = aVar;
        if (this.P.b() != null) {
            com.baidu.tieba.c.k.a(aVar);
            TiebaApplication.b(this.P);
            g();
            return;
        }
        if (this.c == null) {
            this.c = new o(this);
            this.c.a(new ae(this));
        }
        this.c.e();
        this.c.a(this.o.getText().toString());
        this.c.a(this.P);
        this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.n = false;
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.m = true;
        this.C.setVisibility(0);
        this.q.setText((CharSequence) null);
        if (this.n) {
            this.B.setBackgroundResource(R.drawable.login_input_middle);
        } else {
            this.B.setBackgroundResource(R.drawable.login_input_middlewrong);
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.m = false;
        this.C.setVisibility(8);
        if (this.n) {
            this.B.setBackgroundResource(R.drawable.login_input_under);
        } else {
            this.B.setBackgroundResource(R.drawable.login_input_underwrong);
        }
        i();
    }

    private void q() {
        this.o.setEnabled(false);
        this.p.setEnabled(false);
        this.q.setEnabled(false);
        this.y.setEnabled(false);
        this.t.setEnabled(false);
        this.D.setEnabled(false);
        this.E.setEnabled(false);
        this.F.setEnabled(false);
        this.K.setEnabled(false);
        this.L.setEnabled(false);
        this.o.setTextColor(Color.rgb(136, 136, 136));
        this.p.setTextColor(Color.rgb(136, 136, 136));
        this.q.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.o.setEnabled(true);
        this.p.setEnabled(true);
        this.q.setEnabled(true);
        this.y.setEnabled(true);
        this.t.setEnabled(true);
        this.D.setEnabled(true);
        this.E.setEnabled(true);
        this.F.setEnabled(true);
        this.K.setEnabled(true);
        this.L.setEnabled(true);
        this.o.setTextColor(-16777216);
        this.p.setTextColor(-16777216);
        this.q.setTextColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.n) {
            this.A.setBackgroundResource(R.drawable.login_input_top);
            if (this.m) {
                this.B.setBackgroundResource(R.drawable.login_input_middle);
            } else {
                this.B.setBackgroundResource(R.drawable.login_input_under);
            }
            this.C.setBackgroundResource(R.drawable.login_input_under);
            return;
        }
        this.A.setBackgroundResource(R.drawable.login_input_topwrong);
        if (this.m) {
            this.B.setBackgroundResource(R.drawable.login_input_middlewrong);
        } else {
            this.B.setBackgroundResource(R.drawable.login_input_underwrong);
        }
        this.C.setBackgroundResource(R.drawable.login_input_underwrong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.M != null) {
            this.M.a();
            this.M = null;
        }
        if (this.O != null) {
            this.O.a();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case -1:
                g();
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal_login /* 2131230736 */:
            case R.id.mobile_login /* 2131230737 */:
                a(view.getId());
                return;
            case R.id.button_account_del /* 2131230744 */:
                this.o.setText((CharSequence) null);
                return;
            case R.id.button_pass_del /* 2131230748 */:
                this.p.setText((CharSequence) null);
                return;
            case R.id.button_vcode_del /* 2131230751 */:
                this.q.setText((CharSequence) null);
                return;
            case R.id.image_vcode1 /* 2131230752 */:
            case R.id.image_vcode2 /* 2131230753 */:
            case R.id.button_vcode_refresh /* 2131230755 */:
                c(this.i);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_login_activity);
        this.Q = getIntent().getStringExtra("info");
        h();
        if (bundle != null) {
            this.j = bundle.getInt("type_login");
        } else {
            this.j = 0;
        }
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("account");
        this.k = intent.getBooleanExtra("has_exit_dialog", true);
        this.l = intent.getBooleanExtra("close", false);
        if (stringExtra != null) {
            this.o.setText(stringExtra);
        }
        this.o.requestFocus();
        if (this.k) {
            this.z.setVisibility(4);
        } else {
            this.z.setVisibility(0);
        }
        if (this.j == 0) {
            a(R.id.normal_login);
        }
        if (this.j == 1) {
            a(R.id.mobile_login);
        }
        a(this.o, 150);
        new ak("login").start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        try {
            t();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        if (this.c != null) {
            this.c.b();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.k) {
                f();
            } else {
                finish();
            }
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.j = bundle.getInt("type_login");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.c == null || !this.c.c()) {
            a(this.o, 150);
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("type_login", this.j);
    }
}
