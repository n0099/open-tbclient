package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CreateBarActivity extends com.baidu.tieba.j {
    private TextView e = null;
    private TextView f = null;
    private EditText g = null;
    private EditText h = null;
    private RelativeLayout i = null;
    private ImageView j = null;
    private FrameLayout k = null;
    private ImageView l = null;
    private ProgressBar m = null;
    private ProgressBar n = null;
    private c o = null;
    private d p = null;
    private View.OnClickListener q = null;
    private TextWatcher r = null;
    private String s = null;
    private TextView t = null;
    RelativeLayout a = null;
    View b = null;
    TextView c = null;
    TextView d = null;
    private String u = null;
    private boolean v = false;

    public static void a(Context context, String str, boolean z) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarActivity.class);
            intent.putExtra("barname", str);
            intent.putExtra("isvalid", z);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        b();
        e();
        a();
    }

    private void a() {
        if (this.p == null) {
            this.p = new d(this, null);
            this.p.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.o != null) {
            this.o.cancel();
        }
        if (this.p != null) {
            this.p.cancel();
        }
    }

    private void b() {
        Intent intent = getIntent();
        this.u = intent.getStringExtra("barname");
        this.v = intent.getBooleanExtra("isvalid", false);
        if (this.u == null) {
            this.u = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.p == null && this.o == null) {
            this.p = new d(this, null);
            this.p.setPriority(3);
            this.p.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.o == null) {
            this.o = new c(this, this.g.getText().toString().trim(), this.h.getText().toString().trim());
            this.o.setPriority(3);
            this.o.execute(new String[0]);
        }
    }

    private void e() {
        this.q = new a(this);
        this.r = new b(this);
        this.a = (RelativeLayout) findViewById(R.id.container);
        this.b = findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.d = (TextView) findViewById(R.id.text);
        this.t = (TextView) findViewById(R.id.error);
        this.e = (TextView) findViewById(R.id.info);
        this.i = (RelativeLayout) findViewById(R.id.create);
        this.i.setOnClickListener(this.q);
        this.f = (TextView) findViewById(R.id.info2);
        this.g = (EditText) findViewById(R.id.edit_name);
        this.g.addTextChangedListener(this.r);
        this.h = (EditText) findViewById(R.id.edit_vcode);
        this.h.addTextChangedListener(this.r);
        if (this.v) {
            this.f.setText(getString(R.string.bar_name_valid));
            this.g.setText(this.u);
        } else {
            this.f.setText(getString(R.string.bar_name_invalid));
        }
        this.j = (ImageView) findViewById(R.id.back);
        this.j.setOnClickListener(this.q);
        this.k = (FrameLayout) findViewById(R.id.image_button);
        this.k.setOnClickListener(this.q);
        this.l = (ImageView) findViewById(R.id.image);
        this.i.setEnabled(false);
        this.m = (ProgressBar) findViewById(R.id.progress);
        this.n = (ProgressBar) findViewById(R.id.progress_image);
        if (this.v) {
            this.h.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bb.e(this.c, i);
        com.baidu.tieba.util.bb.a(this.j, i);
        com.baidu.tieba.util.bb.a(this.a, i);
        com.baidu.tieba.util.bb.d(this.b, i);
        com.baidu.tieba.util.bb.a(this.d, i);
        com.baidu.tieba.util.bb.b(this.f, i);
        String str = this.u + getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, this.u.length(), 33);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), this.u.length(), str.length(), 33);
        }
        this.e.setText(spannableString);
    }
}
