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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class LoginActivity extends com.baidu.tieba.j {
    private NavigationBar L;
    private ao d;
    private ao e;
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
    private ImageView s = null;
    private ImageView t = null;
    private ImageView u = null;
    private ProgressBar v = null;
    private ProgressBar w = null;
    private Button x = null;
    private ImageView y = null;
    private View z = null;
    private View A = null;
    private View B = null;
    private Button C = null;
    private Button D = null;
    private Button E = null;
    private TextView F = null;
    private TextView G = null;
    private TextView H = null;
    private TextView I = null;
    private Button J = null;
    private Button K = null;
    RelativeLayout a = null;
    private aq M = null;
    private com.baidu.tieba.model.be N = null;
    private ap O = null;
    InputMethodManager b = null;
    x c = null;
    private AccountData P = null;
    private String Q = null;

    public static void a(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        context.startActivity(intent);
    }

    public static void a(Activity activity, int i, String str, int i2) {
        if (TiebaApplication.o()) {
            com.baidu.tieba.f.a(activity, i2, i, false);
            return;
        }
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        intent.putExtra("locate_type", i);
        intent.putExtra("info", str);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Activity activity, String str, boolean z, int i) {
        if (TiebaApplication.o()) {
            com.baidu.tieba.f.a(activity, i, -1, z);
            return;
        }
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("has_exit_dialog", false);
        intent.putExtra("info", str);
        intent.putExtra("close", z);
        activity.startActivityForResult(intent, i);
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("account", str);
        intent.putExtra("has_exit_dialog", false);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_login_activity);
        this.Q = getIntent().getStringExtra("info");
        b();
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
            this.y.setVisibility(4);
        } else {
            this.y.setVisibility(0);
        }
        if (this.j == 0) {
            a(R.id.normal_login);
        }
        if (this.j == 1) {
            a(R.id.mobile_login);
        }
        ShowSoftKeyPadDelay(this.o, 150);
        new av("login").start();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.j = bundle.getInt("type_login");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("type_login", this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        try {
            o();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        if (this.c != null) {
            this.c.b();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        if (this.c == null || !this.c.c()) {
            ShowSoftKeyPadDelay(this.o, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.k) {
                quitDialog();
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
                a();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        l.a().b();
        if (this.l) {
            TiebaApplication.h().A();
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TiebaApplication.E());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            MainTabActivity.b(this, intExtra != -1 ? intExtra : 1);
        }
        finish();
    }

    private void b() {
        this.b = (InputMethodManager) getSystemService("input_method");
        this.a = (RelativeLayout) findViewById(R.id.container);
        this.L = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.y = this.L.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.L.a(getString(R.string.title_login));
        this.L.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.account_regedit), new ag(this));
        this.o = (EditText) findViewById(R.id.login_edit_account);
        this.p = (EditText) findViewById(R.id.login_edit_password);
        this.q = (EditText) findViewById(R.id.edit_vcode);
        this.z = findViewById(R.id.layout_account);
        this.A = findViewById(R.id.layout_password);
        this.B = findViewById(R.id.layout_vcode);
        this.v = (ProgressBar) findViewById(R.id.image_progress);
        this.t = (ImageView) findViewById(R.id.image_vcode1);
        this.u = (ImageView) findViewById(R.id.image_vcode2);
        this.s = this.t;
        this.w = (ProgressBar) findViewById(R.id.progress_login);
        this.x = (Button) findViewById(R.id.button_vcode_refresh);
        this.C = (Button) findViewById(R.id.button_account_del);
        this.D = (Button) findViewById(R.id.button_pass_del);
        this.E = (Button) findViewById(R.id.button_vcode_del);
        this.F = (TextView) findViewById(R.id.text_title_account);
        this.G = (TextView) findViewById(R.id.text_error);
        this.H = (TextView) findViewById(R.id.text_info);
        if (this.Q != null && this.Q.length() > 0) {
            this.H.setText(this.Q);
            this.H.setVisibility(0);
        }
        this.I = (TextView) findViewById(R.id.text_login);
        this.J = (Button) findViewById(R.id.normal_login);
        this.K = (Button) findViewById(R.id.mobile_login);
        ah ahVar = new ah(this);
        this.o.setOnFocusChangeListener(ahVar);
        this.p.setOnFocusChangeListener(ahVar);
        this.q.setOnFocusChangeListener(ahVar);
        ai aiVar = new ai(this);
        this.p.setOnEditorActionListener(aiVar);
        this.q.setOnEditorActionListener(aiVar);
        this.o.addTextChangedListener(new aj(this));
        this.p.addTextChangedListener(new ak(this));
        this.q.addTextChangedListener(new al(this));
        this.r = findViewById(R.id.layout_login);
        this.r.setEnabled(false);
        this.r.setOnClickListener(new am(this));
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.L.c(i);
        com.baidu.tieba.util.bb.a(this.I, i);
        com.baidu.tieba.util.bb.c(this.a, i);
        if (i == 1) {
            this.H.setTextColor(getResources().getColor(R.color.skin_1_common_color));
        } else {
            this.H.setTextColor(-13279809);
        }
        n();
        c();
    }

    private void c() {
        if (this.j == 0) {
            if (this.mSkinType == 1) {
                this.J.setBackgroundResource(R.drawable.login_tab_pressed_1);
                this.K.setBackgroundResource(R.drawable.login_tab_normal_1);
                this.J.setTextColor(getResources().getColor(R.color.skin_1_common_color));
                this.K.setTextColor(getResources().getColor(R.color.skin_1_tab_unsel_color));
                return;
            }
            this.J.setBackgroundResource(R.drawable.login_tab_pressed);
            this.K.setBackgroundResource(R.drawable.login_tab_normal);
            this.J.setTextColor(Color.rgb(50, 137, 203));
            this.K.setTextColor(-16777216);
        } else if (this.j == 1) {
            if (this.mSkinType == 1) {
                this.K.setBackgroundResource(R.drawable.login_tab_pressed_1);
                this.J.setBackgroundResource(R.drawable.login_tab_normal_1);
                this.K.setTextColor(getResources().getColor(R.color.skin_1_common_color));
                this.J.setTextColor(getResources().getColor(R.color.skin_1_tab_unsel_color));
                return;
            }
            this.K.setBackgroundResource(R.drawable.login_tab_pressed);
            this.J.setBackgroundResource(R.drawable.login_tab_normal);
            this.K.setTextColor(Color.rgb(50, 137, 203));
            this.J.setTextColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        boolean z;
        String obj = this.o.getText().toString();
        String obj2 = this.p.getText().toString();
        String obj3 = this.q.getText().toString();
        if (this.B.getVisibility() == 8) {
            z = com.baidu.tieba.util.bc.c(obj) || com.baidu.tieba.util.bc.c(obj2);
        } else {
            z = com.baidu.tieba.util.bc.c(obj) || com.baidu.tieba.util.bc.c(obj2) || com.baidu.tieba.util.bc.c(obj3);
        }
        if (!z) {
            this.r.setEnabled(true);
        } else {
            this.r.setEnabled(false);
        }
    }

    private void a(int i) {
        switch (i) {
            case R.id.normal_login /* 2131099739 */:
                this.s = this.t;
                this.t.setVisibility(0);
                this.u.setVisibility(8);
                f();
                this.j = 0;
                e();
                this.o.setHint(R.string.account_hint_normal);
                this.F.setText(R.string.account_account);
                this.o.requestFocus();
                this.o.setInputType(1);
                c();
                return;
            case R.id.mobile_login /* 2131099740 */:
                this.s = this.u;
                this.t.setVisibility(8);
                this.u.setVisibility(0);
                f();
                this.j = 1;
                e();
                this.o.setHint(R.string.account_mobile);
                this.F.setText(R.string.account_mobile);
                this.o.requestFocus();
                this.o.setInputType(3);
                c();
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal_login /* 2131099739 */:
            case R.id.mobile_login /* 2131099740 */:
                a(view.getId());
                return;
            case R.id.button_account_del /* 2131099747 */:
                this.o.setText((CharSequence) null);
                return;
            case R.id.button_pass_del /* 2131099751 */:
                this.p.setText((CharSequence) null);
                return;
            case R.id.button_vcode_del /* 2131099754 */:
                this.q.setText((CharSequence) null);
                return;
            case R.id.image_vcode1 /* 2131099755 */:
            case R.id.image_vcode2 /* 2131099756 */:
            case R.id.button_vcode_refresh /* 2131099758 */:
                a(this.i);
                return;
            default:
                return;
        }
    }

    private void e() {
        if (this.j == 0) {
            if (this.d == null) {
                this.f = null;
                this.o.setText((CharSequence) null);
                this.p.setText((CharSequence) null);
                this.q.setText((CharSequence) null);
                this.B.setVisibility(8);
                this.G.setVisibility(4);
                this.n = true;
                this.m = false;
            } else {
                this.f = this.d.a;
                this.o.setText(this.d.a);
                this.p.setText(this.d.b);
                this.q.setText(this.d.c);
                this.G.setText(this.d.d);
                this.B.setVisibility(this.d.e);
                this.G.setVisibility(this.d.f);
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
                this.B.setVisibility(8);
                this.G.setVisibility(4);
                this.n = true;
                this.m = false;
            } else {
                this.f = this.e.a;
                this.o.setText(this.e.a);
                this.p.setText(this.e.b);
                this.q.setText(this.e.c);
                this.G.setText(this.e.d);
                this.B.setVisibility(this.e.e);
                this.G.setVisibility(this.e.f);
                this.n = this.e.g;
                this.m = this.e.e == 0;
            }
        }
        n();
        d();
    }

    private void f() {
        if (this.j == 0) {
            this.d = new ao(this, null);
            this.d.a = this.o.getText().toString();
            this.d.b = this.p.getText().toString();
            this.d.c = this.q.getText().toString();
            this.d.d = this.G.getText().toString();
            this.d.e = this.B.getVisibility();
            this.d.f = this.G.getVisibility();
            this.d.g = this.n;
        }
        if (this.j == 1) {
            this.e = new ao(this, null);
            this.e.a = this.o.getText().toString();
            this.e.b = this.p.getText().toString();
            this.e.c = this.q.getText().toString();
            this.e.d = this.G.getText().toString();
            this.e.e = this.B.getVisibility();
            this.e.f = this.G.getVisibility();
            this.e.g = this.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.M == null) {
            String obj = this.o.getText().toString();
            this.g = com.baidu.tieba.util.bc.b(this.p.getText().toString().getBytes());
            if (obj.length() > 0 && this.g.length() > 0) {
                if (!this.m || !com.baidu.tieba.util.bc.c(this.q.getText().toString())) {
                    l();
                    StringBuffer stringBuffer = new StringBuffer(30);
                    stringBuffer.append(com.baidu.tieba.data.h.a);
                    stringBuffer.append("c/s/login");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", obj));
                    arrayList.add(new BasicNameValuePair("passwd", this.g));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.j)));
                    arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.h().bc()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.h().bb()));
                    if (this.B != null && this.B.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.q.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.h));
                    }
                    o();
                    this.M = new aq(this, stringBuffer.toString(), arrayList);
                    this.M.setPriority(3);
                    this.M.execute(stringBuffer.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        AccountData accountData = new AccountData();
        accountData.setAccount(this.N.a().getName());
        if (this.N.a().getPassword() != null) {
            accountData.setPassword(this.N.a().getPassword());
        } else {
            accountData.setPassword(this.g);
        }
        accountData.setID(this.N.a().getId());
        accountData.setBDUSS(this.N.a().getBDUSS());
        accountData.setPortrait(this.N.a().getPortrait());
        accountData.setIsActive(1);
        if (this.N.b() != null) {
            accountData.setTbs(this.N.b().getTbs());
        }
        this.P = accountData;
        if (this.P.getAccount() != null) {
            DatabaseService.a(accountData);
            TiebaApplication.a(this.P, getBaseContext());
            a();
            return;
        }
        if (this.c == null) {
            this.c = new x(this);
            this.c.a(new an(this));
        }
        this.c.e();
        this.c.a(this.o.getText().toString());
        this.c.a(this.P);
        this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.n = false;
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.O != null) {
            this.O.cancel();
        }
        this.v.setVisibility(0);
        this.s.setImageBitmap(null);
        o();
        this.O = new ap(this, null);
        this.O.setPriority(3);
        this.O.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.m = true;
        this.B.setVisibility(0);
        this.q.setText((CharSequence) null);
        if (this.n) {
            if (this.mSkinType == 1) {
                this.A.setBackgroundResource(R.drawable.login_input_middle_1);
            } else {
                this.A.setBackgroundResource(R.drawable.login_input_middle);
            }
        } else if (this.mSkinType == 1) {
            this.A.setBackgroundResource(R.drawable.login_input_middlewrong_1);
        } else {
            this.A.setBackgroundResource(R.drawable.login_input_middlewrong);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.m = false;
        this.B.setVisibility(8);
        if (this.n) {
            this.A.setBackgroundResource(R.drawable.login_input_under);
        } else {
            this.A.setBackgroundResource(R.drawable.login_input_underwrong);
        }
        d();
    }

    private void l() {
        this.o.setEnabled(false);
        this.p.setEnabled(false);
        this.q.setEnabled(false);
        this.x.setEnabled(false);
        this.s.setEnabled(false);
        this.C.setEnabled(false);
        this.D.setEnabled(false);
        this.E.setEnabled(false);
        this.J.setEnabled(false);
        this.K.setEnabled(false);
        this.o.setTextColor(Color.rgb(136, 136, 136));
        this.p.setTextColor(Color.rgb(136, 136, 136));
        this.q.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.o.setEnabled(true);
        this.p.setEnabled(true);
        this.q.setEnabled(true);
        this.x.setEnabled(true);
        this.s.setEnabled(true);
        this.C.setEnabled(true);
        this.D.setEnabled(true);
        this.E.setEnabled(true);
        this.J.setEnabled(true);
        this.K.setEnabled(true);
        this.o.setTextColor(-16777216);
        this.p.setTextColor(-16777216);
        this.q.setTextColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.n) {
            if (this.mSkinType == 1) {
                this.z.setBackgroundResource(R.drawable.login_input_top_1);
                if (this.m) {
                    this.A.setBackgroundResource(R.drawable.login_input_middle_1);
                } else {
                    this.A.setBackgroundResource(R.drawable.login_input_under_1);
                }
                this.B.setBackgroundResource(R.drawable.login_input_under_1);
                return;
            }
            this.z.setBackgroundResource(R.drawable.login_input_top);
            if (this.m) {
                this.A.setBackgroundResource(R.drawable.login_input_middle);
            } else {
                this.A.setBackgroundResource(R.drawable.login_input_under);
            }
            this.B.setBackgroundResource(R.drawable.login_input_under);
        } else if (this.mSkinType == 1) {
            this.z.setBackgroundResource(R.drawable.login_input_topwrong_1);
            if (this.m) {
                this.A.setBackgroundResource(R.drawable.login_input_middlewrong_1);
            } else {
                this.A.setBackgroundResource(R.drawable.login_input_underwrong_1);
            }
            this.B.setBackgroundResource(R.drawable.login_input_underwrong_1);
        } else {
            this.z.setBackgroundResource(R.drawable.login_input_topwrong);
            if (this.m) {
                this.A.setBackgroundResource(R.drawable.login_input_middlewrong);
            } else {
                this.A.setBackgroundResource(R.drawable.login_input_underwrong);
            }
            this.B.setBackgroundResource(R.drawable.login_input_underwrong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.M != null) {
            this.M.cancel();
            this.M = null;
        }
        if (this.O != null) {
            this.O.cancel();
        }
    }
}
