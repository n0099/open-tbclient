package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateBarActivity extends BaseActivity {
    RelativeLayout b;
    public NavigationBar e;
    private TextView f = null;
    private TextView g = null;
    private EditText h = null;
    private EditText i = null;
    private RelativeLayout j = null;
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
    View c = null;
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
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.create_bar_activity);
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
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
            this.o = new c(this, this.h.getText().toString().trim(), this.i.getText().toString().trim());
            this.o.setPriority(3);
            this.o.execute(new String[0]);
        }
    }

    private void e() {
        this.q = new a(this);
        this.r = new b(this);
        this.e = (NavigationBar) findViewById(v.view_navigation_bar);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.a(getString(y.create_bar));
        this.a = (RelativeLayout) findViewById(v.container);
        this.c = findViewById(v.title);
        this.d = (TextView) findViewById(v.text);
        this.t = (TextView) findViewById(v.error);
        this.f = (TextView) findViewById(v.info);
        this.j = (RelativeLayout) findViewById(v.create);
        this.j.setOnClickListener(this.q);
        this.g = (TextView) findViewById(v.info2);
        this.h = (EditText) findViewById(v.edit_name);
        this.h.addTextChangedListener(this.r);
        this.i = (EditText) findViewById(v.edit_vcode);
        this.i.addTextChangedListener(this.r);
        if (this.v) {
            this.g.setText(getString(y.bar_name_valid));
            this.h.setText(this.u);
        } else {
            this.g.setText(getString(y.bar_name_invalid));
        }
        this.b = (RelativeLayout) findViewById(v.create);
        this.k = (FrameLayout) findViewById(v.image_button);
        this.k.setOnClickListener(this.q);
        this.l = (ImageView) findViewById(v.image);
        this.j.setEnabled(false);
        this.m = (ProgressBar) findViewById(v.progress);
        this.n = (ProgressBar) findViewById(v.progress_image);
        if (this.v) {
            this.i.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a((View) this.a);
        bk.a(this.d, i);
        bk.b(this.g, i);
        String str = String.valueOf(this.u) + getString(y.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.s.noexit_create_bar_name_text_1)), 0, this.u.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.s.skin_1_common_color)), this.u.length(), str.length(), 33);
            this.b.setBackgroundResource(com.baidu.tieba.u.btn_general_start_selector_1);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.s.noexit_create_bar_name_text)), 0, this.u.length(), 33);
            this.b.setBackgroundResource(com.baidu.tieba.u.btn_general_start_selector);
        }
        this.f.setText(spannableString);
        this.e.c(i);
    }
}
