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
import com.baidu.tieba.model.bd;
import com.baidu.tieba.topRec.TopRecActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ActivationActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private static int f1006a = 60;
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
    private j n = null;
    private i o = null;
    private boolean p = false;
    private int q = f1006a;
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
    private Runnable B = new e(this);
    private View.OnClickListener C = new f(this);
    private TextWatcher D = new g(this);
    private View.OnFocusChangeListener E = new h(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(ActivationActivity activationActivity) {
        int i = activationActivity.q;
        activationActivity.q = i - 1;
        return i;
    }

    public static void a(Activity activity, RegistData registData, int i) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", registData);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
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
            f1006a = this.r.getSmsCodeTime();
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
    @Override // com.baidu.tieba.j, android.app.Activity
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
        this.q = f1006a;
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
        a(this.k, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        bb.a(this.t, i);
        bb.d(this.v, i);
        bb.a(this.b, i);
        bb.f(this.u, i);
        bb.a(this.w, i);
        bb.a(this.g, i);
        bb.b(this.x, i);
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
    public void a(bd bdVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(bdVar.a().getName());
        if (bdVar.a().getPassword() != null) {
            accountData.setPassword(bdVar.a().getPassword());
        } else {
            accountData.setPassword(this.r.getPsw());
        }
        accountData.setID(bdVar.a().getId());
        accountData.setBDUSS(bdVar.a().getBDUSS());
        accountData.setPortrait(bdVar.a().getPortrait());
        accountData.setIsActive(1);
        if (bdVar.b() != null) {
            accountData.setTbs(bdVar.b().getTbs());
        }
        DatabaseService.a(accountData);
        TiebaApplication.a(accountData, getBaseContext());
        setResult(-1);
        finish();
        TopRecActivity.a(this);
    }
}
