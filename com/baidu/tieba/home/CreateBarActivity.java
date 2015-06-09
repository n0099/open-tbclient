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
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout aYJ;
    public NavigationBar mNavigationBar;
    private TextView ayG = null;
    private TextView aYA = null;
    private EditText aYB = null;
    private EditText axy = null;
    private RelativeLayout aYC = null;
    private FrameLayout aYD = null;
    private ImageView avb = null;
    private ProgressBar mProgress = null;
    private ProgressBar aYE = null;
    private d aYF = null;
    private e aYG = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher awU = null;
    private String aYH = null;
    private TextView aYI = null;
    private RelativeLayout awb = null;
    private TextView aYK = null;
    private String aYL = null;
    private boolean aYM = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.create_bar_activity);
        initData();
        initUI();
        OL();
    }

    private void OL() {
        if (this.aYG == null) {
            this.aYG = new e(this, null);
            this.aYG.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aYF != null) {
            this.aYF.cancel();
        }
        if (this.aYG != null) {
            this.aYG.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.aYL = intent.getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
        this.aYM = intent.getBooleanExtra(CreateBarActivityConfig.BAR_NAME_ISVALID, false);
        if (this.aYL == null) {
            this.aYL = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OM() {
        if (this.aYG == null && this.aYF == null) {
            this.aYG = new e(this, null);
            this.aYG.setPriority(3);
            this.aYG.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ON() {
        if (this.aYF == null) {
            this.aYF = new d(this, this.aYB.getText().toString().trim(), this.axy.getText().toString().trim());
            this.aYF.setPriority(3);
            this.aYF.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new a(this);
        this.awU = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.create_bar));
        this.awb = (RelativeLayout) findViewById(q.container);
        this.aYK = (TextView) findViewById(q.text);
        this.aYI = (TextView) findViewById(q.error);
        this.ayG = (TextView) findViewById(q.info);
        this.aYC = (RelativeLayout) findViewById(q.create);
        this.aYC.setOnClickListener(this.mOnClickListener);
        this.aYA = (TextView) findViewById(q.info2);
        this.aYB = (EditText) findViewById(q.edit_name);
        this.aYB.addTextChangedListener(this.awU);
        this.axy = (EditText) findViewById(q.edit_vcode);
        this.axy.addTextChangedListener(this.awU);
        if (this.aYM) {
            this.aYA.setText(getPageContext().getString(t.bar_name_valid));
            this.aYB.setText(this.aYL);
        } else {
            this.aYA.setText(getPageContext().getString(t.bar_name_invalid));
        }
        this.aYJ = (RelativeLayout) findViewById(q.create);
        this.aYD = (FrameLayout) findViewById(q.image_button);
        this.aYD.setOnClickListener(this.mOnClickListener);
        this.avb = (ImageView) findViewById(q.image);
        this.aYC.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(q.progress);
        this.aYE = (ProgressBar) findViewById(q.progress_image);
        if (this.aYM) {
            this.axy.requestFocus();
        }
        findViewById(q.show_message_container).setOnTouchListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.awb);
        ay.b(this.aYK, i);
        ay.c(this.aYA, i);
        String str = String.valueOf(this.aYL) + getPageContext().getString(t.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(n.noexit_create_bar_name_text)), 0, this.aYL.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(n.skin_1_common_color)), this.aYL.length(), str.length(), 33);
        ay.i(this.aYJ, p.btn_general_start_selector);
        this.ayG.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
