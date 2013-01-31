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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CreateBarActivity extends com.baidu.tieba.e {
    private TextView g = null;
    private TextView h = null;
    private EditText i = null;
    private EditText j = null;
    private RelativeLayout k = null;
    private Button l = null;
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
    RelativeLayout c = null;
    LinearLayout d = null;
    TextView e = null;
    TextView f = null;
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
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        j();
        m();
        i();
    }

    private void i() {
        if (this.r == null) {
            this.r = new d(this, null);
            this.r.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != null) {
            this.q.a();
        }
        if (this.r != null) {
            this.r.a();
        }
    }

    private void j() {
        Intent intent = getIntent();
        this.w = intent.getStringExtra("barname");
        this.x = intent.getBooleanExtra("isvalid", false);
        if (this.w == null) {
            this.w = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.r == null && this.q == null) {
            this.r = new d(this, null);
            this.r.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.q == null) {
            this.q = new c(this, this.i.getText().toString().trim(), this.j.getText().toString().trim());
            this.q.execute(new String[0]);
        }
    }

    private void m() {
        this.s = new a(this);
        this.t = new b(this);
        this.c = (RelativeLayout) findViewById(R.id.container);
        this.d = (LinearLayout) findViewById(R.id.title);
        this.e = (TextView) findViewById(R.id.title_text);
        this.f = (TextView) findViewById(R.id.text);
        this.v = (TextView) findViewById(R.id.error);
        this.g = (TextView) findViewById(R.id.info);
        this.k = (RelativeLayout) findViewById(R.id.create);
        this.k.setOnClickListener(this.s);
        this.h = (TextView) findViewById(R.id.info2);
        this.i = (EditText) findViewById(R.id.edit_name);
        this.i.addTextChangedListener(this.t);
        this.j = (EditText) findViewById(R.id.edit_vcode);
        this.j.addTextChangedListener(this.t);
        if (this.x) {
            this.h.setText(getString(R.string.bar_name_valid));
            this.i.setText(this.w);
        } else {
            this.h.setText(getString(R.string.bar_name_invalid));
        }
        this.l = (Button) findViewById(R.id.back);
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
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ad.c(this.e, i);
        com.baidu.tieba.c.ad.c((TextView) this.l, i);
        com.baidu.tieba.c.ad.e((TextView) this.l, i);
        com.baidu.tieba.c.ad.a(this.c, i);
        com.baidu.tieba.c.ad.c(this.d, i);
        com.baidu.tieba.c.ad.a(this.f, i);
        com.baidu.tieba.c.ad.b(this.h, i);
        String str = String.valueOf(this.w) + getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, this.w.length(), 33);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), this.w.length(), str.length(), 33);
        }
        this.g.setText(spannableString);
    }
}
