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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    RelativeLayout aPt;
    public NavigationBar mNavigationBar;
    private TextView Qw = null;
    private TextView aPk = null;
    private EditText aPl = null;
    private EditText Qg = null;
    private RelativeLayout aPm = null;
    private FrameLayout aPn = null;
    private ImageView anr = null;
    private ProgressBar mProgress = null;
    private ProgressBar aPo = null;
    private c aPp = null;
    private d aPq = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher ano = null;
    private String aPr = null;
    private TextView aPs = null;
    RelativeLayout QB = null;
    View ani = null;
    TextView aPu = null;
    private String aPv = null;
    private boolean aPw = false;

    static {
        TbadkApplication.getInst().RegisterIntent(CreateBarActivityConfig.class, CreateBarActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.create_bar_activity);
        initData();
        initUI();
        Jx();
    }

    private void Jx() {
        if (this.aPq == null) {
            this.aPq = new d(this, null);
            this.aPq.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aPp != null) {
            this.aPp.cancel();
        }
        if (this.aPq != null) {
            this.aPq.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.aPv = intent.getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
        this.aPw = intent.getBooleanExtra(CreateBarActivityConfig.BAR_NAME_ISVALID, false);
        if (this.aPv == null) {
            this.aPv = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy() {
        if (this.aPq == null && this.aPp == null) {
            this.aPq = new d(this, null);
            this.aPq.setPriority(3);
            this.aPq.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jz() {
        if (this.aPp == null) {
            this.aPp = new c(this, this.aPl.getText().toString().trim(), this.Qg.getText().toString().trim());
            this.aPp.setPriority(3);
            this.aPp.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new a(this);
        this.ano = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(z.create_bar));
        this.QB = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.ani = findViewById(com.baidu.tieba.w.title);
        this.aPu = (TextView) findViewById(com.baidu.tieba.w.text);
        this.aPs = (TextView) findViewById(com.baidu.tieba.w.error);
        this.Qw = (TextView) findViewById(com.baidu.tieba.w.info);
        this.aPm = (RelativeLayout) findViewById(com.baidu.tieba.w.create);
        this.aPm.setOnClickListener(this.mOnClickListener);
        this.aPk = (TextView) findViewById(com.baidu.tieba.w.info2);
        this.aPl = (EditText) findViewById(com.baidu.tieba.w.edit_name);
        this.aPl.addTextChangedListener(this.ano);
        this.Qg = (EditText) findViewById(com.baidu.tieba.w.edit_vcode);
        this.Qg.addTextChangedListener(this.ano);
        if (this.aPw) {
            this.aPk.setText(getPageContext().getString(z.bar_name_valid));
            this.aPl.setText(this.aPv);
        } else {
            this.aPk.setText(getPageContext().getString(z.bar_name_invalid));
        }
        this.aPt = (RelativeLayout) findViewById(com.baidu.tieba.w.create);
        this.aPn = (FrameLayout) findViewById(com.baidu.tieba.w.image_button);
        this.aPn.setOnClickListener(this.mOnClickListener);
        this.anr = (ImageView) findViewById(com.baidu.tieba.w.image);
        this.aPm.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.aPo = (ProgressBar) findViewById(com.baidu.tieba.w.progress_image);
        if (this.aPw) {
            this.Qg.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.QB);
        bc.b(this.aPu, i);
        bc.c(this.aPk, i);
        String str = String.valueOf(this.aPv) + getPageContext().getString(z.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(com.baidu.tieba.t.noexit_create_bar_name_text)), 0, this.aPv.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.t.skin_1_common_color)), this.aPv.length(), str.length(), 33);
        bc.i(this.aPt, com.baidu.tieba.v.btn_general_start_selector);
        this.Qw.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
