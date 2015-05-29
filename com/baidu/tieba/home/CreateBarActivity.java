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
    private RelativeLayout aYI;
    public NavigationBar mNavigationBar;
    private TextView ayF = null;
    private TextView aYz = null;
    private EditText aYA = null;
    private EditText axx = null;
    private RelativeLayout aYB = null;
    private FrameLayout aYC = null;
    private ImageView avb = null;
    private ProgressBar mProgress = null;
    private ProgressBar aYD = null;
    private d aYE = null;
    private e aYF = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher awT = null;
    private String aYG = null;
    private TextView aYH = null;
    private RelativeLayout awa = null;
    private TextView aYJ = null;
    private String aYK = null;
    private boolean aYL = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.create_bar_activity);
        initData();
        initUI();
        OK();
    }

    private void OK() {
        if (this.aYF == null) {
            this.aYF = new e(this, null);
            this.aYF.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aYE != null) {
            this.aYE.cancel();
        }
        if (this.aYF != null) {
            this.aYF.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.aYK = intent.getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
        this.aYL = intent.getBooleanExtra(CreateBarActivityConfig.BAR_NAME_ISVALID, false);
        if (this.aYK == null) {
            this.aYK = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OL() {
        if (this.aYF == null && this.aYE == null) {
            this.aYF = new e(this, null);
            this.aYF.setPriority(3);
            this.aYF.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OM() {
        if (this.aYE == null) {
            this.aYE = new d(this, this.aYA.getText().toString().trim(), this.axx.getText().toString().trim());
            this.aYE.setPriority(3);
            this.aYE.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new a(this);
        this.awT = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.create_bar));
        this.awa = (RelativeLayout) findViewById(q.container);
        this.aYJ = (TextView) findViewById(q.text);
        this.aYH = (TextView) findViewById(q.error);
        this.ayF = (TextView) findViewById(q.info);
        this.aYB = (RelativeLayout) findViewById(q.create);
        this.aYB.setOnClickListener(this.mOnClickListener);
        this.aYz = (TextView) findViewById(q.info2);
        this.aYA = (EditText) findViewById(q.edit_name);
        this.aYA.addTextChangedListener(this.awT);
        this.axx = (EditText) findViewById(q.edit_vcode);
        this.axx.addTextChangedListener(this.awT);
        if (this.aYL) {
            this.aYz.setText(getPageContext().getString(t.bar_name_valid));
            this.aYA.setText(this.aYK);
        } else {
            this.aYz.setText(getPageContext().getString(t.bar_name_invalid));
        }
        this.aYI = (RelativeLayout) findViewById(q.create);
        this.aYC = (FrameLayout) findViewById(q.image_button);
        this.aYC.setOnClickListener(this.mOnClickListener);
        this.avb = (ImageView) findViewById(q.image);
        this.aYB.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(q.progress);
        this.aYD = (ProgressBar) findViewById(q.progress_image);
        if (this.aYL) {
            this.axx.requestFocus();
        }
        findViewById(q.show_message_container).setOnTouchListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.awa);
        ay.b(this.aYJ, i);
        ay.c(this.aYz, i);
        String str = String.valueOf(this.aYK) + getPageContext().getString(t.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(n.noexit_create_bar_name_text)), 0, this.aYK.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(n.skin_1_common_color)), this.aYK.length(), str.length(), 33);
        ay.i(this.aYI, p.btn_general_start_selector);
        this.ayF.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
