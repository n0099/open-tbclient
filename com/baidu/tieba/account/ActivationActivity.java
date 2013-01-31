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
import com.baidu.zeus.WebChromeClient;
/* loaded from: classes.dex */
public class ActivationActivity extends com.baidu.tieba.e {
    private static int c = 60;
    private Button d = null;
    private LinearLayout e = null;
    private ImageView f = null;
    private ProgressBar g = null;
    private ProgressBar h = null;
    private TextView i = null;
    private TextView j = null;
    private EditText k = null;
    private RelativeLayout l = null;
    private RelativeLayout m = null;
    private n n = null;
    private m o = null;
    private boolean p = false;
    private int q = c;
    private com.baidu.tieba.a.ap r = null;
    private Handler s = new Handler();
    private RelativeLayout t = null;
    private TextView u = null;
    private LinearLayout v = null;
    private TextView w = null;
    private TextView x = null;
    private int y = 0;
    private int z = 0;
    private int A = 0;
    private Runnable B = new i(this);
    private View.OnClickListener C = new j(this);
    private TextWatcher D = new k(this);
    private View.OnFocusChangeListener E = new l(this);

    public static void a(Activity activity, com.baidu.tieba.a.ap apVar, int i) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", apVar);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_register_activation);
        a(bundle);
        j();
        i();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.r = (com.baidu.tieba.a.ap) bundle.getSerializable("data");
        } else {
            this.r = (com.baidu.tieba.a.ap) getIntent().getSerializableExtra("data");
        }
        if (this.r == null) {
            setResult(0);
            finish();
        } else if (this.r.f() > 0) {
            c = this.r.f();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.r = (com.baidu.tieba.a.ap) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        this.s.removeCallbacks(this.B);
        if (this.n != null) {
            this.n.a();
        }
        if (this.o != null) {
            this.o.a();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.p = false;
        this.m.setEnabled(false);
        this.q = c;
        this.i.setText(String.format(getString(R.string.resend_code_second), Integer.valueOf(this.q)));
        this.s.postDelayed(this.B, 1000L);
    }

    private void j() {
        this.t = (RelativeLayout) findViewById(R.id.container);
        this.v = (LinearLayout) findViewById(R.id.title);
        this.u = (TextView) findViewById(R.id.title_text);
        this.w = (TextView) findViewById(R.id.done_text);
        this.d = (Button) findViewById(R.id.back);
        this.l = (RelativeLayout) findViewById(R.id.done);
        this.l.setEnabled(false);
        this.m = (RelativeLayout) findViewById(R.id.resend);
        this.d.setOnClickListener(this.C);
        this.l.setOnClickListener(this.C);
        this.m.setOnClickListener(this.C);
        this.i = (TextView) findViewById(R.id.resend_text);
        this.k = (EditText) findViewById(R.id.edit_code);
        this.k.addTextChangedListener(this.D);
        this.k.setOnFocusChangeListener(this.E);
        this.g = (ProgressBar) findViewById(R.id.progress_resend);
        this.h = (ProgressBar) findViewById(R.id.progress_done);
        this.f = (ImageView) findViewById(R.id.del_code);
        this.f.setOnClickListener(this.C);
        this.j = (TextView) findViewById(R.id.text_error);
        this.e = (LinearLayout) findViewById(R.id.sms_code_input_bg);
        this.y = this.e.getPaddingLeft();
        this.z = this.e.getPaddingRight();
        this.e.setBackgroundResource(R.drawable.pass_input);
        this.e.setPadding(this.y, 0, this.z, 0);
        this.x = (TextView) findViewById(R.id.no_receive_code);
        a(this.k, WebChromeClient.STRING_DLG_BTN_SET);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ad.a(this.t, i);
        com.baidu.tieba.c.ad.c(this.v, i);
        com.baidu.tieba.c.ad.e((TextView) this.d, i);
        com.baidu.tieba.c.ad.c(this.u, i);
        com.baidu.tieba.c.ad.c((TextView) this.d, i);
        com.baidu.tieba.c.ad.a(this.w, i);
        com.baidu.tieba.c.ad.a(this.i, i);
        com.baidu.tieba.c.ad.b(this.x, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.k.setEnabled(z);
        this.k.setFocusable(z);
        this.k.setFocusableInTouchMode(z);
        this.f.setEnabled(z);
        if (z) {
            this.k.setTextColor(getResources().getColor(R.color.reg_font_color));
        } else {
            this.k.setTextColor(getResources().getColor(R.color.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.b.g gVar) {
        com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
        aVar.b(gVar.a().b());
        if (gVar.a().e() != null) {
            aVar.c(gVar.a().e());
        } else {
            aVar.c(this.r.b());
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
}
