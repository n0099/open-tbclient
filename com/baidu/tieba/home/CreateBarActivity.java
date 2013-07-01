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
public class CreateBarActivity extends com.baidu.tieba.g {
    private TextView e = null;
    private TextView f = null;
    private EditText g = null;
    private EditText j = null;
    private RelativeLayout k = null;
    private ImageView l = null;
    private FrameLayout m = null;
    private ImageView n = null;
    private ProgressBar o = null;
    private ProgressBar p = null;
    private c q = null;
    private d r = null;
    private View.OnClickListener s = null;
    private TextWatcher t = null;
    private String u = null;
    private TextView v = null;

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f881a = null;
    View b = null;
    TextView c = null;
    TextView d = null;
    private String w = null;
    private boolean x = false;

    public static void a(Context context, String str, boolean z) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarActivity.class);
            intent.putExtra("barname", str);
            intent.putExtra("isvalid", z);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        c();
        n();
        b();
    }

    private void b() {
        if (this.r == null) {
            this.r = new d(this, null);
            this.r.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != null) {
            this.q.cancel();
        }
        if (this.r != null) {
            this.r.cancel();
        }
    }

    private void c() {
        Intent intent = getIntent();
        this.w = intent.getStringExtra("barname");
        this.x = intent.getBooleanExtra("isvalid", false);
        if (this.w == null) {
            this.w = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.r == null && this.q == null) {
            this.r = new d(this, null);
            this.r.setPriority(3);
            this.r.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.q == null) {
            this.q = new c(this, this.g.getText().toString().trim(), this.j.getText().toString().trim());
            this.q.setPriority(3);
            this.q.execute(new String[0]);
        }
    }

    private void n() {
        this.s = new a(this);
        this.t = new b(this);
        this.f881a = (RelativeLayout) findViewById(R.id.container);
        this.b = findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.d = (TextView) findViewById(R.id.text);
        this.v = (TextView) findViewById(R.id.error);
        this.e = (TextView) findViewById(R.id.info);
        this.k = (RelativeLayout) findViewById(R.id.create);
        this.k.setOnClickListener(this.s);
        this.f = (TextView) findViewById(R.id.info2);
        this.g = (EditText) findViewById(R.id.edit_name);
        this.g.addTextChangedListener(this.t);
        this.j = (EditText) findViewById(R.id.edit_vcode);
        this.j.addTextChangedListener(this.t);
        if (this.x) {
            this.f.setText(getString(R.string.bar_name_valid));
            this.g.setText(this.w);
        } else {
            this.f.setText(getString(R.string.bar_name_invalid));
        }
        this.l = (ImageView) findViewById(R.id.back);
        this.l.setOnClickListener(this.s);
        this.m = (FrameLayout) findViewById(R.id.image_button);
        this.m.setOnClickListener(this.s);
        this.n = (ImageView) findViewById(R.id.image);
        this.k.setEnabled(false);
        this.o = (ProgressBar) findViewById(R.id.progress);
        this.p = (ProgressBar) findViewById(R.id.progress_image);
        if (this.x) {
            this.j.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.f(this.c, i);
        com.baidu.tieba.util.x.a(this.l, i);
        com.baidu.tieba.util.x.a(this.f881a, i);
        com.baidu.tieba.util.x.d(this.b, i);
        com.baidu.tieba.util.x.a(this.d, i);
        com.baidu.tieba.util.x.b(this.f, i);
        String str = String.valueOf(this.w) + getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, this.w.length(), 33);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), this.w.length(), str.length(), 33);
        }
        this.e.setText(spannableString);
    }
}
