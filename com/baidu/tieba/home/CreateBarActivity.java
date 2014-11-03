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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateBarActivity extends BaseActivity {
    RelativeLayout aMk;
    public NavigationBar mNavigationBar;
    private TextView KL = null;
    private TextView aMb = null;
    private EditText aMc = null;
    private EditText Kv = null;
    private RelativeLayout aMd = null;
    private FrameLayout aMe = null;
    private ImageView acK = null;
    private ProgressBar mProgress = null;
    private ProgressBar aMf = null;
    private c aMg = null;
    private d aMh = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher afe = null;
    private String aMi = null;
    private TextView aMj = null;
    RelativeLayout KP = null;
    View aeY = null;
    TextView aMl = null;
    private String aMm = null;
    private boolean aMn = false;

    public static void b(Context context, String str, boolean z) {
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
        setContentView(com.baidu.tieba.w.create_bar_activity);
        initData();
        initUI();
        IG();
    }

    private void IG() {
        if (this.aMh == null) {
            this.aMh = new d(this, null);
            this.aMh.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aMg != null) {
            this.aMg.cancel();
        }
        if (this.aMh != null) {
            this.aMh.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.aMm = intent.getStringExtra("barname");
        this.aMn = intent.getBooleanExtra("isvalid", false);
        if (this.aMm == null) {
            this.aMm = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IH() {
        if (this.aMh == null && this.aMg == null) {
            this.aMh = new d(this, null);
            this.aMh.setPriority(3);
            this.aMh.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II() {
        if (this.aMg == null) {
            this.aMg = new c(this, this.aMc.getText().toString().trim(), this.Kv.getText().toString().trim());
            this.aMg.setPriority(3);
            this.aMg.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new a(this);
        this.afe = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getString(y.create_bar));
        this.KP = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.aeY = findViewById(com.baidu.tieba.v.title);
        this.aMl = (TextView) findViewById(com.baidu.tieba.v.text);
        this.aMj = (TextView) findViewById(com.baidu.tieba.v.error);
        this.KL = (TextView) findViewById(com.baidu.tieba.v.info);
        this.aMd = (RelativeLayout) findViewById(com.baidu.tieba.v.create);
        this.aMd.setOnClickListener(this.mOnClickListener);
        this.aMb = (TextView) findViewById(com.baidu.tieba.v.info2);
        this.aMc = (EditText) findViewById(com.baidu.tieba.v.edit_name);
        this.aMc.addTextChangedListener(this.afe);
        this.Kv = (EditText) findViewById(com.baidu.tieba.v.edit_vcode);
        this.Kv.addTextChangedListener(this.afe);
        if (this.aMn) {
            this.aMb.setText(getString(y.bar_name_valid));
            this.aMc.setText(this.aMm);
        } else {
            this.aMb.setText(getString(y.bar_name_invalid));
        }
        this.aMk = (RelativeLayout) findViewById(com.baidu.tieba.v.create);
        this.aMe = (FrameLayout) findViewById(com.baidu.tieba.v.image_button);
        this.aMe.setOnClickListener(this.mOnClickListener);
        this.acK = (ImageView) findViewById(com.baidu.tieba.v.image);
        this.aMd.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.aMf = (ProgressBar) findViewById(com.baidu.tieba.v.progress_image);
        if (this.aMn) {
            this.Kv.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.KP);
        aw.a(this.aMl, i);
        aw.b(this.aMb, i);
        String str = String.valueOf(this.aMm) + getString(y.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(com.baidu.tieba.s.noexit_create_bar_name_text)), 0, this.aMm.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.s.skin_1_common_color)), this.aMm.length(), str.length(), 33);
        aw.h(this.aMk, com.baidu.tieba.u.btn_general_start_selector);
        this.KL.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(i);
    }
}
