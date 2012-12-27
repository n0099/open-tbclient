package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ActivationActivity extends com.baidu.tieba.e {
    private static int b = 60;
    private Button c = null;
    private LinearLayout d = null;
    private ImageView e = null;
    private ProgressBar f = null;
    private ProgressBar g = null;
    private TextView h = null;
    private TextView i = null;
    private EditText j = null;
    private RelativeLayout k = null;
    private RelativeLayout l = null;
    private n m = null;
    private m n = null;
    private boolean o = false;
    private int p = b;
    private com.baidu.tieba.a.ao q = null;
    private Handler r = new Handler();
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private Runnable v = new i(this);
    private View.OnClickListener w = new j(this);
    private TextWatcher x = new k(this);
    private View.OnFocusChangeListener y = new l(this);

    public static void a(Activity activity, com.baidu.tieba.a.ao aoVar, int i) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", aoVar);
        activity.startActivityForResult(intent, i);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.q = (com.baidu.tieba.a.ao) bundle.getSerializable("data");
        } else {
            this.q = (com.baidu.tieba.a.ao) getIntent().getSerializableExtra("data");
        }
        if (this.q == null) {
            setResult(0);
            finish();
        } else if (this.q.f() > 0) {
            b = this.q.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.b.g gVar) {
        com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
        aVar.b(gVar.a().b());
        if (gVar.a().e() != null) {
            aVar.c(gVar.a().e());
        } else {
            aVar.c(this.q.b());
        }
        aVar.a(gVar.a().a());
        aVar.d(gVar.a().j());
        aVar.a(1);
        if (gVar.b() != null) {
            aVar.e(gVar.b().b());
        }
        com.baidu.tieba.c.k.a(aVar);
        TiebaApplication.b(aVar);
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.j.setEnabled(z);
        this.j.setFocusable(z);
        this.j.setFocusableInTouchMode(z);
        this.e.setEnabled(z);
        if (z) {
            this.j.setTextColor(getResources().getColor(R.color.reg_font_color));
        } else {
            this.j.setTextColor(getResources().getColor(R.color.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.o = false;
        this.l.setEnabled(false);
        this.p = b;
        this.h.setText(String.format(getString(R.string.resend_code_second), Integer.valueOf(this.p)));
        this.r.postDelayed(this.v, 1000L);
    }

    private void h() {
        this.c = (Button) findViewById(R.id.back);
        this.k = (RelativeLayout) findViewById(R.id.done);
        this.k.setEnabled(false);
        this.l = (RelativeLayout) findViewById(R.id.resend);
        this.c.setOnClickListener(this.w);
        this.k.setOnClickListener(this.w);
        this.l.setOnClickListener(this.w);
        this.h = (TextView) findViewById(R.id.resend_text);
        this.j = (EditText) findViewById(R.id.edit_code);
        this.j.addTextChangedListener(this.x);
        this.j.setOnFocusChangeListener(this.y);
        this.f = (ProgressBar) findViewById(R.id.progress_resend);
        this.g = (ProgressBar) findViewById(R.id.progress_done);
        this.e = (ImageView) findViewById(R.id.del_code);
        this.e.setOnClickListener(this.w);
        this.i = (TextView) findViewById(R.id.text_error);
        this.d = (LinearLayout) findViewById(R.id.sms_code_input_bg);
        this.s = this.d.getPaddingLeft();
        this.t = this.d.getPaddingRight();
        this.d.setBackgroundResource(R.drawable.pass_input);
        this.d.setPadding(this.s, 0, this.t, 0);
        a(this.j, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_register_activation);
        a(bundle);
        h();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        this.r.removeCallbacks(this.v);
        if (this.m != null) {
            this.m.a();
        }
        if (this.n != null) {
            this.n.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.q = (com.baidu.tieba.a.ao) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.q);
    }
}
