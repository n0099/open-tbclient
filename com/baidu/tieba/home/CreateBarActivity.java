package com.baidu.tieba.home;

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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    RelativeLayout aOk;
    public NavigationBar mNavigationBar;
    private TextView PW = null;
    private TextView aOb = null;
    private EditText aOc = null;
    private EditText PE = null;
    private RelativeLayout aOd = null;
    private FrameLayout aOe = null;
    private ImageView akv = null;
    private ProgressBar mProgress = null;
    private ProgressBar aOf = null;
    private c aOg = null;
    private d aOh = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher amu = null;
    private String aOi = null;
    private TextView aOj = null;
    RelativeLayout Qa = null;
    View amo = null;
    TextView aOl = null;
    private String aOm = null;
    private boolean aOn = false;

    static {
        TbadkApplication.getInst().RegisterIntent(CreateBarActivityConfig.class, CreateBarActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.create_bar_activity);
        initData();
        initUI();
        IZ();
    }

    private void IZ() {
        if (this.aOh == null) {
            this.aOh = new d(this, null);
            this.aOh.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aOg != null) {
            this.aOg.cancel();
        }
        if (this.aOh != null) {
            this.aOh.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.aOm = intent.getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
        this.aOn = intent.getBooleanExtra(CreateBarActivityConfig.BAR_NAME_ISVALID, false);
        if (this.aOm == null) {
            this.aOm = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ja() {
        if (this.aOh == null && this.aOg == null) {
            this.aOh = new d(this, null);
            this.aOh.setPriority(3);
            this.aOh.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jb() {
        if (this.aOg == null) {
            this.aOg = new c(this, this.aOc.getText().toString().trim(), this.PE.getText().toString().trim());
            this.aOg.setPriority(3);
            this.aOg.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new a(this);
        this.amu = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(z.create_bar));
        this.Qa = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.amo = findViewById(com.baidu.tieba.w.title);
        this.aOl = (TextView) findViewById(com.baidu.tieba.w.text);
        this.aOj = (TextView) findViewById(com.baidu.tieba.w.error);
        this.PW = (TextView) findViewById(com.baidu.tieba.w.info);
        this.aOd = (RelativeLayout) findViewById(com.baidu.tieba.w.create);
        this.aOd.setOnClickListener(this.mOnClickListener);
        this.aOb = (TextView) findViewById(com.baidu.tieba.w.info2);
        this.aOc = (EditText) findViewById(com.baidu.tieba.w.edit_name);
        this.aOc.addTextChangedListener(this.amu);
        this.PE = (EditText) findViewById(com.baidu.tieba.w.edit_vcode);
        this.PE.addTextChangedListener(this.amu);
        if (this.aOn) {
            this.aOb.setText(getPageContext().getString(z.bar_name_valid));
            this.aOc.setText(this.aOm);
        } else {
            this.aOb.setText(getPageContext().getString(z.bar_name_invalid));
        }
        this.aOk = (RelativeLayout) findViewById(com.baidu.tieba.w.create);
        this.aOe = (FrameLayout) findViewById(com.baidu.tieba.w.image_button);
        this.aOe.setOnClickListener(this.mOnClickListener);
        this.akv = (ImageView) findViewById(com.baidu.tieba.w.image);
        this.aOd.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.aOf = (ProgressBar) findViewById(com.baidu.tieba.w.progress_image);
        if (this.aOn) {
            this.PE.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.Qa);
        ax.b(this.aOl, i);
        ax.c(this.aOb, i);
        String str = String.valueOf(this.aOm) + getPageContext().getString(z.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ax.getColor(com.baidu.tieba.t.noexit_create_bar_name_text)), 0, this.aOm.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.t.skin_1_common_color)), this.aOm.length(), str.length(), 33);
        ax.i(this.aOk, com.baidu.tieba.v.btn_general_start_selector);
        this.PW.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
