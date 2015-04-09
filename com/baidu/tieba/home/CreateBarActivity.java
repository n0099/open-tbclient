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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout aWd;
    public NavigationBar mNavigationBar;
    private TextView awZ = null;
    private TextView aVU = null;
    private EditText aVV = null;
    private EditText avS = null;
    private RelativeLayout aVW = null;
    private FrameLayout aVX = null;
    private ImageView atD = null;
    private ProgressBar mProgress = null;
    private ProgressBar aVY = null;
    private c aVZ = null;
    private d aWa = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher avs = null;
    private String aWb = null;
    private TextView aWc = null;
    private RelativeLayout aux = null;
    private TextView aWe = null;
    private String aWf = null;
    private boolean aWg = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.create_bar_activity);
        initData();
        initUI();
        Nv();
    }

    private void Nv() {
        if (this.aWa == null) {
            this.aWa = new d(this, null);
            this.aWa.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aVZ != null) {
            this.aVZ.cancel();
        }
        if (this.aWa != null) {
            this.aWa.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.aWf = intent.getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
        this.aWg = intent.getBooleanExtra(CreateBarActivityConfig.BAR_NAME_ISVALID, false);
        if (this.aWf == null) {
            this.aWf = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nw() {
        if (this.aWa == null && this.aVZ == null) {
            this.aWa = new d(this, null);
            this.aWa.setPriority(3);
            this.aWa.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nx() {
        if (this.aVZ == null) {
            this.aVZ = new c(this, this.aVV.getText().toString().trim(), this.avS.getText().toString().trim());
            this.aVZ.setPriority(3);
            this.aVZ.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new a(this);
        this.avs = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(y.create_bar));
        this.aux = (RelativeLayout) findViewById(v.container);
        this.aWe = (TextView) findViewById(v.text);
        this.aWc = (TextView) findViewById(v.error);
        this.awZ = (TextView) findViewById(v.info);
        this.aVW = (RelativeLayout) findViewById(v.create);
        this.aVW.setOnClickListener(this.mOnClickListener);
        this.aVU = (TextView) findViewById(v.info2);
        this.aVV = (EditText) findViewById(v.edit_name);
        this.aVV.addTextChangedListener(this.avs);
        this.avS = (EditText) findViewById(v.edit_vcode);
        this.avS.addTextChangedListener(this.avs);
        if (this.aWg) {
            this.aVU.setText(getPageContext().getString(y.bar_name_valid));
            this.aVV.setText(this.aWf);
        } else {
            this.aVU.setText(getPageContext().getString(y.bar_name_invalid));
        }
        this.aWd = (RelativeLayout) findViewById(v.create);
        this.aVX = (FrameLayout) findViewById(v.image_button);
        this.aVX.setOnClickListener(this.mOnClickListener);
        this.atD = (ImageView) findViewById(v.image);
        this.aVW.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(v.progress);
        this.aVY = (ProgressBar) findViewById(v.progress_image);
        if (this.aWg) {
            this.avS.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aux);
        ba.b(this.aWe, i);
        ba.c(this.aVU, i);
        String str = String.valueOf(this.aWf) + getPageContext().getString(y.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.noexit_create_bar_name_text)), 0, this.aWf.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(s.skin_1_common_color)), this.aWf.length(), str.length(), 33);
        ba.i(this.aWd, u.btn_general_start_selector);
        this.awZ.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
