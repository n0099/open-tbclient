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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.topRec.TopRecActivity;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ActivationActivity extends com.baidu.tieba.f {
    private static int a = 60;
    private ImageView b = null;
    private LinearLayout c = null;
    private ImageView d = null;
    private ProgressBar e = null;
    private ProgressBar f = null;
    private TextView g = null;
    private TextView h = null;
    private EditText i = null;
    private RelativeLayout j = null;
    private RelativeLayout k = null;
    private u l = null;
    private t m = null;
    private boolean n = false;
    private int o = a;
    private RegistData p = null;
    private Handler q = new Handler();
    private RelativeLayout r = null;
    private TextView s = null;
    private View t = null;
    private TextView u = null;
    private TextView v = null;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private Runnable z = new p(this);
    private View.OnClickListener A = new q(this);
    private TextWatcher B = new r(this);
    private View.OnFocusChangeListener C = new s(this);

    public static void a(Activity activity, RegistData registData, int i) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", registData);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_register_activation);
        if (bundle != null) {
            this.p = (RegistData) bundle.getSerializable("data");
        } else {
            this.p = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.p == null) {
            setResult(0);
            finish();
        } else if (this.p.getSmsCodeTime() > 0) {
            a = this.p.getSmsCodeTime();
        }
        this.r = (RelativeLayout) findViewById(R.id.container);
        this.t = findViewById(R.id.title);
        this.s = (TextView) findViewById(R.id.title_text);
        this.u = (TextView) findViewById(R.id.done_text);
        this.b = (ImageView) findViewById(R.id.back);
        this.j = (RelativeLayout) findViewById(R.id.done);
        this.j.setEnabled(false);
        this.k = (RelativeLayout) findViewById(R.id.resend);
        this.b.setOnClickListener(this.A);
        this.j.setOnClickListener(this.A);
        this.k.setOnClickListener(this.A);
        this.g = (TextView) findViewById(R.id.resend_text);
        this.i = (EditText) findViewById(R.id.edit_code);
        this.i.addTextChangedListener(this.B);
        this.i.setOnFocusChangeListener(this.C);
        this.e = (ProgressBar) findViewById(R.id.progress_resend);
        this.f = (ProgressBar) findViewById(R.id.progress_done);
        this.d = (ImageView) findViewById(R.id.del_code);
        this.d.setOnClickListener(this.A);
        this.h = (TextView) findViewById(R.id.text_error);
        this.c = (LinearLayout) findViewById(R.id.sms_code_input_bg);
        this.w = this.c.getPaddingLeft();
        this.x = this.c.getPaddingRight();
        this.c.setBackgroundResource(R.drawable.pass_input);
        this.c.setPadding(this.w, 0, this.x, 0);
        this.v = (TextView) findViewById(R.id.no_receive_code);
        ShowSoftKeyPadDelay(this.i, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        a();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.p = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        this.q.removeCallbacks(this.z);
        if (this.l != null) {
            this.l.cancel();
        }
        if (this.m != null) {
            this.m.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.n = false;
        this.k.setEnabled(false);
        this.o = a;
        this.g.setText(String.format(getString(R.string.resend_code_second), Integer.valueOf(this.o)));
        this.q.postDelayed(this.z, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bq.a(this.r, i);
        com.baidu.tieba.util.bq.d(this.t, i);
        com.baidu.tieba.util.bq.a(this.b, i);
        com.baidu.tieba.util.bq.e(this.s, i);
        com.baidu.tieba.util.bq.a(this.u, i);
        com.baidu.tieba.util.bq.a(this.g, i);
        com.baidu.tieba.util.bq.b(this.v, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(ActivationActivity activationActivity, boolean z) {
        activationActivity.i.setEnabled(z);
        activationActivity.i.setFocusable(z);
        activationActivity.i.setFocusableInTouchMode(z);
        activationActivity.d.setEnabled(z);
        if (z) {
            activationActivity.i.setTextColor(activationActivity.getResources().getColor(R.color.reg_font_color));
        } else {
            activationActivity.i.setTextColor(activationActivity.getResources().getColor(R.color.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ActivationActivity activationActivity, com.baidu.tieba.model.at atVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(atVar.a().getUserName());
        if (atVar.a().getPassword() != null) {
            accountData.setPassword(atVar.a().getPassword());
        } else {
            accountData.setPassword(activationActivity.p.getPsw());
        }
        accountData.setID(atVar.a().getUserId());
        accountData.setBDUSS(atVar.a().getBDUSS());
        accountData.setPortrait(atVar.a().getPortrait());
        accountData.setIsActive(1);
        if (atVar.b() != null) {
            accountData.setTbs(atVar.b().getTbs());
        }
        DatabaseService.a(accountData);
        TiebaApplication.a(accountData, activationActivity.getBaseContext());
        activationActivity.setResult(-1);
        activationActivity.finish();
        TopRecActivity.a(activationActivity);
    }
}
