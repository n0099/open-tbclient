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
    private RelativeLayout aVN;
    public NavigationBar mNavigationBar;
    private TextView awR = null;
    private TextView aVE = null;
    private EditText aVF = null;
    private EditText avK = null;
    private RelativeLayout aVG = null;
    private FrameLayout aVH = null;
    private ImageView atv = null;
    private ProgressBar mProgress = null;
    private ProgressBar aVI = null;
    private c aVJ = null;
    private d aVK = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher avk = null;
    private String aVL = null;
    private TextView aVM = null;
    private RelativeLayout aup = null;
    private TextView aVO = null;
    private String aVP = null;
    private boolean aVQ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.create_bar_activity);
        initData();
        initUI();
        Ni();
    }

    private void Ni() {
        if (this.aVK == null) {
            this.aVK = new d(this, null);
            this.aVK.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aVJ != null) {
            this.aVJ.cancel();
        }
        if (this.aVK != null) {
            this.aVK.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.aVP = intent.getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
        this.aVQ = intent.getBooleanExtra(CreateBarActivityConfig.BAR_NAME_ISVALID, false);
        if (this.aVP == null) {
            this.aVP = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nj() {
        if (this.aVK == null && this.aVJ == null) {
            this.aVK = new d(this, null);
            this.aVK.setPriority(3);
            this.aVK.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nk() {
        if (this.aVJ == null) {
            this.aVJ = new c(this, this.aVF.getText().toString().trim(), this.avK.getText().toString().trim());
            this.aVJ.setPriority(3);
            this.aVJ.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new a(this);
        this.avk = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(y.create_bar));
        this.aup = (RelativeLayout) findViewById(v.container);
        this.aVO = (TextView) findViewById(v.text);
        this.aVM = (TextView) findViewById(v.error);
        this.awR = (TextView) findViewById(v.info);
        this.aVG = (RelativeLayout) findViewById(v.create);
        this.aVG.setOnClickListener(this.mOnClickListener);
        this.aVE = (TextView) findViewById(v.info2);
        this.aVF = (EditText) findViewById(v.edit_name);
        this.aVF.addTextChangedListener(this.avk);
        this.avK = (EditText) findViewById(v.edit_vcode);
        this.avK.addTextChangedListener(this.avk);
        if (this.aVQ) {
            this.aVE.setText(getPageContext().getString(y.bar_name_valid));
            this.aVF.setText(this.aVP);
        } else {
            this.aVE.setText(getPageContext().getString(y.bar_name_invalid));
        }
        this.aVN = (RelativeLayout) findViewById(v.create);
        this.aVH = (FrameLayout) findViewById(v.image_button);
        this.aVH.setOnClickListener(this.mOnClickListener);
        this.atv = (ImageView) findViewById(v.image);
        this.aVG.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(v.progress);
        this.aVI = (ProgressBar) findViewById(v.progress_image);
        if (this.aVQ) {
            this.avK.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aup);
        ba.b(this.aVO, i);
        ba.c(this.aVE, i);
        String str = String.valueOf(this.aVP) + getPageContext().getString(y.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.noexit_create_bar_name_text)), 0, this.aVP.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(s.skin_1_common_color)), this.aVP.length(), str.length(), 33);
        ba.i(this.aVN, u.btn_general_start_selector);
        this.awR.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
