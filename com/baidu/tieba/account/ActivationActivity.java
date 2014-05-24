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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.topRec.TopRecActivity;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity {
    private static int b = 60;
    public NavigationBar a;
    private View c = null;
    private LinearLayout d = null;
    private ImageView e = null;
    private ProgressBar f = null;
    private ProgressBar g = null;
    private TextView h = null;
    private TextView i = null;
    private EditText j = null;
    private RelativeLayout k = null;
    private RelativeLayout l = null;
    private s m = null;
    private r n = null;
    private boolean o = false;
    private int p = b;
    private RegistData q = null;
    private final Handler r = new Handler();
    private RelativeLayout s = null;
    private View t = null;
    private TextView u = null;
    private TextView v = null;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private final Runnable z = new n(this);
    private final View.OnClickListener A = new o(this);
    private final TextWatcher B = new p(this);
    private final View.OnFocusChangeListener C = new q(this);

    public static void a(Activity activity, RegistData registData, int i) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", registData);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.account_register_activation);
        a(bundle);
        b();
        a();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.q = (RegistData) bundle.getSerializable("data");
        } else {
            this.q = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.q == null) {
            setResult(0);
            finish();
        } else if (this.q.getSmsCodeTime() > 0) {
            b = this.q.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.q = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.r.removeCallbacks(this.z);
        if (this.m != null) {
            this.m.cancel();
        }
        if (this.n != null) {
            this.n.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.o = false;
        this.l.setEnabled(false);
        this.p = b;
        this.h.setText(String.format(getString(com.baidu.tieba.y.resend_code_second), Integer.valueOf(this.p)));
        this.r.postDelayed(this.z, 1000L);
    }

    private void b() {
        this.s = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.t = findViewById(com.baidu.tieba.v.title);
        this.u = (TextView) findViewById(com.baidu.tieba.v.done_text);
        this.a = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, (View.OnClickListener) null);
        this.a.a(getString(com.baidu.tieba.y.create_bar));
        this.k = (RelativeLayout) findViewById(com.baidu.tieba.v.done);
        this.k.setEnabled(false);
        this.l = (RelativeLayout) findViewById(com.baidu.tieba.v.resend);
        this.c.setOnClickListener(this.A);
        this.k.setOnClickListener(this.A);
        this.l.setOnClickListener(this.A);
        this.h = (TextView) findViewById(com.baidu.tieba.v.resend_text);
        this.j = (EditText) findViewById(com.baidu.tieba.v.edit_code);
        this.j.addTextChangedListener(this.B);
        this.j.setOnFocusChangeListener(this.C);
        this.f = (ProgressBar) findViewById(com.baidu.tieba.v.progress_resend);
        this.g = (ProgressBar) findViewById(com.baidu.tieba.v.progress_done);
        this.e = (ImageView) findViewById(com.baidu.tieba.v.del_code);
        this.e.setOnClickListener(this.A);
        this.i = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.d = (LinearLayout) findViewById(com.baidu.tieba.v.sms_code_input_bg);
        this.w = this.d.getPaddingLeft();
        this.x = this.d.getPaddingRight();
        this.d.setBackgroundResource(com.baidu.tieba.u.pass_input);
        this.d.setPadding(this.w, 0, this.x, 0);
        this.v = (TextView) findViewById(com.baidu.tieba.v.no_receive_code);
        ShowSoftKeyPadDelay(this.j, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.a(this.s, i);
        bc.d(this.t, i);
        bc.a(this.u, i);
        bc.a(this.h, i);
        bc.b(this.v, i);
        this.a.c(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.j.setEnabled(z);
        this.j.setFocusable(z);
        this.j.setFocusableInTouchMode(z);
        this.e.setEnabled(z);
        if (z) {
            this.j.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
        } else {
            this.j.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.i iVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(iVar.a().getUserName());
        if (iVar.a().getPassword() != null) {
            accountData.setPassword(iVar.a().getPassword());
        } else {
            accountData.setPassword(this.q.getPsw());
        }
        accountData.setID(iVar.a().getUserId());
        accountData.setBDUSS(iVar.a().getBDUSS());
        accountData.setPortrait(iVar.a().getPortrait());
        accountData.setIsActive(1);
        if (iVar.b() != null) {
            accountData.setTbs(iVar.b().getTbs());
        }
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkApplication.setCurrentAccount(accountData, getBaseContext());
        setResult(-1);
        finish();
        TopRecActivity.a(this);
    }
}
