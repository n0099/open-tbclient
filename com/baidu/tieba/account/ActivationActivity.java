package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ActivationActivity extends com.baidu.tieba.g {
    private static int a = 60;
    private ImageView b = null;
    private LinearLayout c = null;
    private ImageView d = null;
    private ProgressBar e = null;
    private ProgressBar f = null;
    private TextView g = null;
    private TextView j = null;
    private EditText k = null;
    private RelativeLayout l = null;
    private RelativeLayout m = null;
    private i n = null;
    private h o = null;
    private boolean p = false;
    private int q = a;
    private RegistData r = null;
    private Handler s = new Handler();
    private RelativeLayout t = null;
    private TextView u = null;
    private View v = null;
    private TextView w = null;
    private TextView x = null;
    private int y = 0;
    private int z = 0;
    private int A = 0;
    private Runnable B = new d(this);
    private View.OnClickListener C = new e(this);
    private TextWatcher D = new f(this);
    private View.OnFocusChangeListener E = new g(this);

    public static void a(Activity activity, RegistData registData, int i) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", registData);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_register_activation);
        a(bundle);
        c();
        b();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.r = (RegistData) bundle.getSerializable("data");
        } else {
            this.r = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.r == null) {
            setResult(0);
            finish();
        } else if (this.r.getSmsCodeTime() > 0) {
            a = this.r.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.r = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        this.s.removeCallbacks(this.B);
        if (this.n != null) {
            this.n.cancel();
        }
        if (this.o != null) {
            this.o.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.p = false;
        this.m.setEnabled(false);
        this.q = a;
        this.g.setText(String.format(getString(R.string.resend_code_second), Integer.valueOf(this.q)));
        this.s.postDelayed(this.B, 1000L);
    }

    private void c() {
        this.t = (RelativeLayout) findViewById(R.id.container);
        this.v = findViewById(R.id.title);
        this.u = (TextView) findViewById(R.id.title_text);
        this.w = (TextView) findViewById(R.id.done_text);
        this.b = (ImageView) findViewById(R.id.back);
        this.l = (RelativeLayout) findViewById(R.id.done);
        this.l.setEnabled(false);
        this.m = (RelativeLayout) findViewById(R.id.resend);
        this.b.setOnClickListener(this.C);
        this.l.setOnClickListener(this.C);
        this.m.setOnClickListener(this.C);
        this.g = (TextView) findViewById(R.id.resend_text);
        this.k = (EditText) findViewById(R.id.edit_code);
        this.k.addTextChangedListener(this.D);
        this.k.setOnFocusChangeListener(this.E);
        this.e = (ProgressBar) findViewById(R.id.progress_resend);
        this.f = (ProgressBar) findViewById(R.id.progress_done);
        this.d = (ImageView) findViewById(R.id.del_code);
        this.d.setOnClickListener(this.C);
        this.j = (TextView) findViewById(R.id.text_error);
        this.c = (LinearLayout) findViewById(R.id.sms_code_input_bg);
        this.y = this.c.getPaddingLeft();
        this.z = this.c.getPaddingRight();
        this.c.setBackgroundResource(R.drawable.pass_input);
        this.c.setPadding(this.y, 0, this.z, 0);
        this.x = (TextView) findViewById(R.id.no_receive_code);
        a(this.k, WebChromeClient.STRING_DLG_BTN_SET);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.a(this.t, i);
        com.baidu.tieba.util.x.d(this.v, i);
        com.baidu.tieba.util.x.a(this.b, i);
        com.baidu.tieba.util.x.f(this.u, i);
        com.baidu.tieba.util.x.a(this.w, i);
        com.baidu.tieba.util.x.a(this.g, i);
        com.baidu.tieba.util.x.b(this.x, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.k.setEnabled(z);
        this.k.setFocusable(z);
        this.k.setFocusableInTouchMode(z);
        this.d.setEnabled(z);
        if (z) {
            this.k.setTextColor(getResources().getColor(R.color.reg_font_color));
        } else {
            this.k.setTextColor(getResources().getColor(R.color.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.al alVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(alVar.a().getName());
        if (alVar.a().getPassword() != null) {
            accountData.setPassword(alVar.a().getPassword());
        } else {
            accountData.setPassword(this.r.getPsw());
        }
        accountData.setID(alVar.a().getId());
        accountData.setBDUSS(alVar.a().getBDUSS());
        accountData.setIsActive(1);
        if (alVar.b() != null) {
            accountData.setTbs(alVar.b().getTbs());
        }
        DatabaseService.a(accountData);
        TiebaApplication.b(accountData);
        setResult(-1);
        finish();
    }
}
