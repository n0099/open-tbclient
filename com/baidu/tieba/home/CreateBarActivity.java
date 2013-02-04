package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CreateBarActivity extends com.baidu.tieba.e {
    private TextView b = null;
    private TextView c = null;
    private EditText d = null;
    private EditText e = null;
    private RelativeLayout f = null;
    private Button g = null;
    private FrameLayout h = null;
    private ImageView i = null;
    private ProgressBar j = null;
    private ProgressBar k = null;
    private c l = null;
    private d m = null;
    private View.OnClickListener n = null;
    private TextWatcher o = null;
    private String p = null;
    private TextView q = null;
    private String r = null;
    private boolean s = false;

    public static void a(Context context, String str, boolean z) {
        if (str == null || str.length() <= 0) {
            return;
        }
        Intent intent = new Intent(context, CreateBarActivity.class);
        intent.putExtra("barname", str);
        intent.putExtra("isvalid", z);
        context.startActivity(intent);
    }

    private void g() {
        if (this.m == null) {
            this.m = new d(this, null);
            this.m.execute(new String[0]);
        }
    }

    private void h() {
        Intent intent = getIntent();
        this.r = intent.getStringExtra("barname");
        this.s = intent.getBooleanExtra("isvalid", false);
        if (this.r == null) {
            this.r = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.m == null && this.l == null) {
            this.m = new d(this, null);
            this.m.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.l == null) {
            this.l = new c(this, this.d.getText().toString().trim(), this.e.getText().toString().trim());
            this.l.execute(new String[0]);
        }
    }

    private void k() {
        this.n = new a(this);
        this.o = new b(this);
        this.q = (TextView) findViewById(R.id.error);
        this.b = (TextView) findViewById(R.id.info);
        SpannableString spannableString = new SpannableString(String.valueOf(this.r) + getString(R.string.bar_not_create));
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, this.r.length(), 33);
        this.b.setText(spannableString);
        this.f = (RelativeLayout) findViewById(R.id.create);
        this.f.setOnClickListener(this.n);
        this.c = (TextView) findViewById(R.id.info2);
        this.d = (EditText) findViewById(R.id.edit_name);
        this.d.addTextChangedListener(this.o);
        this.e = (EditText) findViewById(R.id.edit_vcode);
        this.e.addTextChangedListener(this.o);
        if (this.s) {
            this.c.setText(getString(R.string.bar_name_valid));
            this.d.setText(this.r);
        } else {
            this.c.setText(getString(R.string.bar_name_invalid));
        }
        this.g = (Button) findViewById(R.id.back);
        this.g.setOnClickListener(this.n);
        this.h = (FrameLayout) findViewById(R.id.image_button);
        this.h.setOnClickListener(this.n);
        this.i = (ImageView) findViewById(R.id.image);
        this.f.setEnabled(false);
        this.j = (ProgressBar) findViewById(R.id.progress);
        this.k = (ProgressBar) findViewById(R.id.progress_image);
        if (this.s) {
            this.e.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        h();
        k();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.l != null) {
            this.l.a();
        }
        if (this.m != null) {
            this.m.a();
        }
    }
}
