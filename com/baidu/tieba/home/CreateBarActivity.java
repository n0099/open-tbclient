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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class CreateBarActivity extends com.baidu.tbadk.a {
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
        this.u = intent.getStringExtra("barname");
        this.v = intent.getBooleanExtra("isvalid", false);
        if (this.u == null) {
            this.u = "";
        }
        this.q = new a(this);
        this.r = new b(this);
        this.e = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.a(getString(com.baidu.tieba.a.k.create_bar));
        this.a = (RelativeLayout) findViewById(com.baidu.tieba.a.h.container);
        this.c = findViewById(com.baidu.tieba.a.h.title);
        this.d = (TextView) findViewById(com.baidu.tieba.a.h.text);
        this.t = (TextView) findViewById(com.baidu.tieba.a.h.error);
        this.f = (TextView) findViewById(com.baidu.tieba.a.h.info);
        this.j = (RelativeLayout) findViewById(com.baidu.tieba.a.h.create);
        this.j.setOnClickListener(this.q);
        this.g = (TextView) findViewById(com.baidu.tieba.a.h.info2);
        this.h = (EditText) findViewById(com.baidu.tieba.a.h.edit_name);
        this.h.addTextChangedListener(this.r);
        this.i = (EditText) findViewById(com.baidu.tieba.a.h.edit_vcode);
        this.i.addTextChangedListener(this.r);
        if (this.v) {
            this.g.setText(getString(com.baidu.tieba.a.k.bar_name_valid));
            this.h.setText(this.u);
        } else {
            this.g.setText(getString(com.baidu.tieba.a.k.bar_name_invalid));
        }
        this.b = (RelativeLayout) findViewById(com.baidu.tieba.a.h.create);
        this.k = (FrameLayout) findViewById(com.baidu.tieba.a.h.image_button);
        this.k.setOnClickListener(this.q);
        this.l = (ImageView) findViewById(com.baidu.tieba.a.h.image);
        this.j.setEnabled(false);
        this.m = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.n = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress_image);
        if (this.v) {
            this.i.requestFocus();
        }
        if (this.p == null) {
            this.p = new d(this, (byte) 0);
            this.p.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.o != null) {
            this.o.cancel();
        }
        if (this.p != null) {
            this.p.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(CreateBarActivity createBarActivity) {
        if (createBarActivity.p == null && createBarActivity.o == null) {
            createBarActivity.p = new d(createBarActivity, (byte) 0);
            createBarActivity.p.setPriority(3);
            createBarActivity.p.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(CreateBarActivity createBarActivity) {
        if (createBarActivity.o == null) {
            createBarActivity.o = new c(createBarActivity, createBarActivity.h.getText().toString().trim(), createBarActivity.i.getText().toString().trim());
            createBarActivity.o.setPriority(3);
            createBarActivity.o.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.a);
        ba.a(this.d, i);
        ba.b(this.g, i);
        String str = String.valueOf(this.u) + getString(com.baidu.tieba.a.k.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.noexit_create_bar_name_text_1)), 0, this.u.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.skin_1_common_color)), this.u.length(), str.length(), 33);
            this.b.setBackgroundResource(com.baidu.tieba.a.g.btn_general_start_selector_1);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.noexit_create_bar_name_text)), 0, this.u.length(), 33);
            this.b.setBackgroundResource(com.baidu.tieba.a.g.btn_general_start_selector);
        }
        this.f.setText(spannableString);
        this.e.b(i);
    }
}
