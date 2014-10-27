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
    RelativeLayout aLW;
    public NavigationBar mNavigationBar;
    private TextView KK = null;
    private TextView aLN = null;
    private EditText aLO = null;
    private EditText Ku = null;
    private RelativeLayout aLP = null;
    private FrameLayout aLQ = null;
    private ImageView acF = null;
    private ProgressBar mProgress = null;
    private ProgressBar aLR = null;
    private c aLS = null;
    private d aLT = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher aeW = null;
    private String aLU = null;
    private TextView aLV = null;
    RelativeLayout KO = null;
    View aeQ = null;
    TextView aLX = null;
    private String aLY = null;
    private boolean aLZ = false;

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
        IC();
    }

    private void IC() {
        if (this.aLT == null) {
            this.aLT = new d(this, null);
            this.aLT.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aLS != null) {
            this.aLS.cancel();
        }
        if (this.aLT != null) {
            this.aLT.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.aLY = intent.getStringExtra("barname");
        this.aLZ = intent.getBooleanExtra("isvalid", false);
        if (this.aLY == null) {
            this.aLY = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        if (this.aLT == null && this.aLS == null) {
            this.aLT = new d(this, null);
            this.aLT.setPriority(3);
            this.aLT.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IE() {
        if (this.aLS == null) {
            this.aLS = new c(this, this.aLO.getText().toString().trim(), this.Ku.getText().toString().trim());
            this.aLS.setPriority(3);
            this.aLS.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new a(this);
        this.aeW = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getString(y.create_bar));
        this.KO = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.aeQ = findViewById(com.baidu.tieba.v.title);
        this.aLX = (TextView) findViewById(com.baidu.tieba.v.text);
        this.aLV = (TextView) findViewById(com.baidu.tieba.v.error);
        this.KK = (TextView) findViewById(com.baidu.tieba.v.info);
        this.aLP = (RelativeLayout) findViewById(com.baidu.tieba.v.create);
        this.aLP.setOnClickListener(this.mOnClickListener);
        this.aLN = (TextView) findViewById(com.baidu.tieba.v.info2);
        this.aLO = (EditText) findViewById(com.baidu.tieba.v.edit_name);
        this.aLO.addTextChangedListener(this.aeW);
        this.Ku = (EditText) findViewById(com.baidu.tieba.v.edit_vcode);
        this.Ku.addTextChangedListener(this.aeW);
        if (this.aLZ) {
            this.aLN.setText(getString(y.bar_name_valid));
            this.aLO.setText(this.aLY);
        } else {
            this.aLN.setText(getString(y.bar_name_invalid));
        }
        this.aLW = (RelativeLayout) findViewById(com.baidu.tieba.v.create);
        this.aLQ = (FrameLayout) findViewById(com.baidu.tieba.v.image_button);
        this.aLQ.setOnClickListener(this.mOnClickListener);
        this.acF = (ImageView) findViewById(com.baidu.tieba.v.image);
        this.aLP.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.aLR = (ProgressBar) findViewById(com.baidu.tieba.v.progress_image);
        if (this.aLZ) {
            this.Ku.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.KO);
        aw.a(this.aLX, i);
        aw.b(this.aLN, i);
        String str = String.valueOf(this.aLY) + getString(y.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(com.baidu.tieba.s.noexit_create_bar_name_text)), 0, this.aLY.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.s.skin_1_common_color)), this.aLY.length(), str.length(), 33);
        aw.h(this.aLW, com.baidu.tieba.u.btn_general_start_selector);
        this.KK.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(i);
    }
}
