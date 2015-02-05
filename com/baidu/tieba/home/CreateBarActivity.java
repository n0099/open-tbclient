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
    RelativeLayout aPs;
    public NavigationBar mNavigationBar;
    private TextView Qt = null;
    private TextView aPj = null;
    private EditText aPk = null;
    private EditText Qd = null;
    private RelativeLayout aPl = null;
    private FrameLayout aPm = null;
    private ImageView ano = null;
    private ProgressBar mProgress = null;
    private ProgressBar aPn = null;
    private c aPo = null;
    private d aPp = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher anl = null;
    private String aPq = null;
    private TextView aPr = null;
    RelativeLayout Qx = null;
    View anf = null;
    TextView aPt = null;
    private String aPu = null;
    private boolean aPv = false;

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
        Js();
    }

    private void Js() {
        if (this.aPp == null) {
            this.aPp = new d(this, null);
            this.aPp.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aPo != null) {
            this.aPo.cancel();
        }
        if (this.aPp != null) {
            this.aPp.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.aPu = intent.getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
        this.aPv = intent.getBooleanExtra(CreateBarActivityConfig.BAR_NAME_ISVALID, false);
        if (this.aPu == null) {
            this.aPu = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt() {
        if (this.aPp == null && this.aPo == null) {
            this.aPp = new d(this, null);
            this.aPp.setPriority(3);
            this.aPp.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ju() {
        if (this.aPo == null) {
            this.aPo = new c(this, this.aPk.getText().toString().trim(), this.Qd.getText().toString().trim());
            this.aPo.setPriority(3);
            this.aPo.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new a(this);
        this.anl = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(z.create_bar));
        this.Qx = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.anf = findViewById(com.baidu.tieba.w.title);
        this.aPt = (TextView) findViewById(com.baidu.tieba.w.text);
        this.aPr = (TextView) findViewById(com.baidu.tieba.w.error);
        this.Qt = (TextView) findViewById(com.baidu.tieba.w.info);
        this.aPl = (RelativeLayout) findViewById(com.baidu.tieba.w.create);
        this.aPl.setOnClickListener(this.mOnClickListener);
        this.aPj = (TextView) findViewById(com.baidu.tieba.w.info2);
        this.aPk = (EditText) findViewById(com.baidu.tieba.w.edit_name);
        this.aPk.addTextChangedListener(this.anl);
        this.Qd = (EditText) findViewById(com.baidu.tieba.w.edit_vcode);
        this.Qd.addTextChangedListener(this.anl);
        if (this.aPv) {
            this.aPj.setText(getPageContext().getString(z.bar_name_valid));
            this.aPk.setText(this.aPu);
        } else {
            this.aPj.setText(getPageContext().getString(z.bar_name_invalid));
        }
        this.aPs = (RelativeLayout) findViewById(com.baidu.tieba.w.create);
        this.aPm = (FrameLayout) findViewById(com.baidu.tieba.w.image_button);
        this.aPm.setOnClickListener(this.mOnClickListener);
        this.ano = (ImageView) findViewById(com.baidu.tieba.w.image);
        this.aPl.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.aPn = (ProgressBar) findViewById(com.baidu.tieba.w.progress_image);
        if (this.aPv) {
            this.Qd.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.Qx);
        bc.b(this.aPt, i);
        bc.c(this.aPj, i);
        String str = String.valueOf(this.aPu) + getPageContext().getString(z.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(com.baidu.tieba.t.noexit_create_bar_name_text)), 0, this.aPu.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.t.skin_1_common_color)), this.aPu.length(), str.length(), 33);
        bc.i(this.aPs, com.baidu.tieba.v.btn_general_start_selector);
        this.Qt.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
