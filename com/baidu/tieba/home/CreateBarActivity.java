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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class CreateBarActivity extends com.baidu.tbadk.a {
    public NavigationBar d;
    private TextView e = null;
    private TextView f = null;
    private EditText g = null;
    private EditText h = null;
    private RelativeLayout i = null;
    private FrameLayout j = null;
    private ImageView k = null;
    private ProgressBar l = null;
    private ProgressBar m = null;
    private c n = null;
    private d o = null;
    private View.OnClickListener p = null;
    private TextWatcher q = null;
    private String r = null;
    private TextView s = null;
    RelativeLayout a = null;
    View b = null;
    TextView c = null;
    private String t = null;
    private boolean u = false;

    public static void a(Context context, String str, boolean z) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarActivity.class);
            intent.putExtra("barname", str);
            intent.putExtra("isvalid", true);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.create_bar_activity);
        Intent intent = getIntent();
        this.t = intent.getStringExtra("barname");
        this.u = intent.getBooleanExtra("isvalid", false);
        if (this.t == null) {
            this.t = "";
        }
        this.p = new a(this);
        this.q = new b(this);
        this.d = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(getString(com.baidu.tieba.a.k.create_bar));
        this.a = (RelativeLayout) findViewById(com.baidu.tieba.a.h.container);
        this.b = findViewById(com.baidu.tieba.a.h.title);
        this.c = (TextView) findViewById(com.baidu.tieba.a.h.text);
        this.s = (TextView) findViewById(com.baidu.tieba.a.h.error);
        this.e = (TextView) findViewById(com.baidu.tieba.a.h.info);
        this.i = (RelativeLayout) findViewById(com.baidu.tieba.a.h.create);
        this.i.setOnClickListener(this.p);
        this.f = (TextView) findViewById(com.baidu.tieba.a.h.info2);
        this.g = (EditText) findViewById(com.baidu.tieba.a.h.edit_name);
        this.g.addTextChangedListener(this.q);
        this.h = (EditText) findViewById(com.baidu.tieba.a.h.edit_vcode);
        this.h.addTextChangedListener(this.q);
        if (this.u) {
            this.f.setText(getString(com.baidu.tieba.a.k.bar_name_valid));
            this.g.setText(this.t);
        } else {
            this.f.setText(getString(com.baidu.tieba.a.k.bar_name_invalid));
        }
        this.j = (FrameLayout) findViewById(com.baidu.tieba.a.h.image_button);
        this.j.setOnClickListener(this.p);
        this.k = (ImageView) findViewById(com.baidu.tieba.a.h.image);
        this.i.setEnabled(false);
        this.l = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.m = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress_image);
        if (this.u) {
            this.h.requestFocus();
        }
        if (this.o == null) {
            this.o = new d(this, (byte) 0);
            this.o.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.n != null) {
            this.n.cancel();
        }
        if (this.o != null) {
            this.o.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(CreateBarActivity createBarActivity) {
        if (createBarActivity.o == null && createBarActivity.n == null) {
            createBarActivity.o = new d(createBarActivity, (byte) 0);
            createBarActivity.o.setPriority(3);
            createBarActivity.o.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(CreateBarActivity createBarActivity) {
        if (createBarActivity.n == null) {
            createBarActivity.n = new c(createBarActivity, createBarActivity.g.getText().toString().trim(), createBarActivity.h.getText().toString().trim());
            createBarActivity.n.setPriority(3);
            createBarActivity.n.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.a(this.a, i);
        ba.d(this.b, i);
        ba.a(this.c, i);
        ba.b(this.f, i);
        String str = String.valueOf(this.t) + getString(com.baidu.tieba.a.k.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, this.t.length(), 33);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.skin_1_common_color)), this.t.length(), str.length(), 33);
        }
        this.e.setText(spannableString);
        this.d.b(i);
    }
}
