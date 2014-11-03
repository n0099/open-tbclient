package com.baidu.tieba.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.Register2ActivityConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.RegistData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends BaseActivity {
    private static int afj = 1000;
    private static int afk = 27;
    private static int afl = 29;
    private static int afm = 28;
    private static int afn = 6;
    private NavigationBar mNavigationBar;
    private View KC = null;
    private TextView afo = null;
    private Button afp = null;
    private ImageView afq = null;
    private ImageView afr = null;
    private Button afs = null;
    private RadioGroup aft = null;
    private RadioButton afu = null;
    private RadioButton afv = null;
    private RadioButton afw = null;
    private TextView afx = null;
    private TextView KK = null;
    private EditText afy = null;
    private EditText afz = null;
    private EditText afA = null;
    private EditText Kv = null;
    private RelativeLayout afB = null;
    private LinearLayout afC = null;
    private LinearLayout afD = null;
    private LinearLayout afE = null;
    private LinearLayout afF = null;
    private LinearLayout afG = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar afH = null;
    private ImageView Kx = null;
    private int afb = 0;
    private int afc = 0;
    private boolean afI = false;
    private boolean afJ = true;
    private int afK = -1;
    private String mErrorString = null;
    RelativeLayout KP = null;
    TextView afL = null;
    private y afM = null;
    private z afN = null;
    private com.baidu.tbadk.core.data.j afO = null;
    private final View.OnClickListener afP = new t(this);
    private final TextWatcher afe = new u(this);
    private final View.OnFocusChangeListener aff = new v(this);
    private final RadioGroup.OnCheckedChangeListener afQ = new w(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(Register2ActivityConfig.class, Register2Activity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.account_register2_activity);
        initUI();
        new au(TbConfig.ST_TYPE_REG).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        int selectionStart = this.afz.getSelectionStart();
        if (!this.afJ) {
            this.afp.setText(getString(com.baidu.tieba.y.hide));
            this.afz.setTransformationMethod(new SingleLineTransformationMethod());
            this.afz.setSelection(selectionStart);
            this.afJ = true;
            return;
        }
        this.afp.setText(getString(com.baidu.tieba.y.show));
        this.afz.setTransformationMethod(new PasswordTransformationMethod());
        this.afz.setSelection(selectionStart);
        this.afJ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.afN != null) {
            this.afN.cancel();
        }
        if (this.afM != null) {
            this.afM.cancel();
        }
    }

    private void initUI() {
        this.KP = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.KC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.afP);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.account_regedit_baidu));
        this.afo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.account_login), this.afP);
        this.afL = (TextView) findViewById(com.baidu.tieba.v.reg_text);
        this.afx = (TextView) findViewById(com.baidu.tieba.v.reg_info);
        this.afB = (RelativeLayout) findViewById(com.baidu.tieba.v.register);
        this.afB.setEnabled(false);
        this.afp = (Button) findViewById(com.baidu.tieba.v.show);
        this.afz = (EditText) findViewById(com.baidu.tieba.v.edit_psw);
        this.afy = (EditText) findViewById(com.baidu.tieba.v.edit_user_name);
        this.afq = (ImageView) findViewById(com.baidu.tieba.v.del_user_name);
        this.afq.setOnClickListener(this.afP);
        this.afr = (ImageView) findViewById(com.baidu.tieba.v.del_phone);
        this.afr.setOnClickListener(this.afP);
        this.afy.setOnFocusChangeListener(this.aff);
        this.afA = (EditText) findViewById(com.baidu.tieba.v.edit_phone);
        this.afA.setOnFocusChangeListener(this.aff);
        this.afp.setOnClickListener(this.afP);
        this.afy.addTextChangedListener(this.afe);
        this.afz.addTextChangedListener(this.afe);
        this.afA.addTextChangedListener(this.afe);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.progress_reg);
        this.afH = (ProgressBar) findViewById(com.baidu.tieba.v.image_progress);
        this.afu = (RadioButton) findViewById(com.baidu.tieba.v.choose_name1);
        this.afv = (RadioButton) findViewById(com.baidu.tieba.v.choose_name2);
        this.afw = (RadioButton) findViewById(com.baidu.tieba.v.choose_name3);
        this.aft = (RadioGroup) findViewById(com.baidu.tieba.v.name_group);
        this.aft.setOnCheckedChangeListener(this.afQ);
        this.afB.setOnClickListener(this.afP);
        this.afC = (LinearLayout) findViewById(com.baidu.tieba.v.user_name_bg);
        this.afb = this.afC.getPaddingLeft();
        this.afc = this.afC.getPaddingRight();
        this.afD = (LinearLayout) findViewById(com.baidu.tieba.v.recommend_bg);
        this.afE = (LinearLayout) findViewById(com.baidu.tieba.v.input_psw_bg);
        this.afF = (LinearLayout) findViewById(com.baidu.tieba.v.input_phone_bg);
        this.afG = (LinearLayout) findViewById(com.baidu.tieba.v.input_vcode_bg);
        this.KK = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.Kx = (ImageView) findViewById(com.baidu.tieba.v.image_vcode);
        this.afs = (Button) findViewById(com.baidu.tieba.v.change_vcode);
        this.Kx.setOnClickListener(this.afP);
        this.afs.setOnClickListener(this.afP);
        this.Kv = (EditText) findViewById(com.baidu.tieba.v.edit_vcode);
        this.Kv.addTextChangedListener(this.afe);
        xi();
        ShowSoftKeyPadDelay(this.afy, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        aw.a(this.afL, i);
        aw.f(this.KP, i);
        xo();
        xl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        bh(false);
    }

    private void xk() {
        this.afC.setPadding(this.afb, 0, this.afc, 0);
        this.afD.setPadding(this.afb, 0, this.afc, 0);
        this.afE.setPadding(this.afb, 0, this.afc, 0);
        this.afF.setPadding(this.afb, 0, this.afc, 0);
        this.afG.setPadding(this.afb, 0, this.afc, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl() {
        this.KK.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.KK.setVisibility(0);
        } else {
            this.KK.setVisibility(4);
        }
        if (this.afK == afk) {
            aw.h(this.afC, com.baidu.tieba.u.login_input_topwrong);
        } else if (this.afK == afl) {
            aw.h(this.afE, com.baidu.tieba.u.login_input_middlewrong);
        } else if (this.afK == afm) {
            if (this.afI) {
                aw.h(this.afF, com.baidu.tieba.u.login_input_middlewrong);
            } else {
                aw.h(this.afF, com.baidu.tieba.u.login_input_underwrong);
            }
        } else if (this.afK == afn) {
            aw.h(this.afG, com.baidu.tieba.u.login_input_underwrong);
        } else {
            aw.h(this.afC, com.baidu.tieba.u.login_input_top);
            aw.h(this.afE, com.baidu.tieba.u.login_input_middle);
            if (this.afI) {
                aw.h(this.afF, com.baidu.tieba.u.login_input_middle);
            } else {
                aw.h(this.afF, com.baidu.tieba.u.login_input_under);
            }
            aw.h(this.afG, com.baidu.tieba.u.login_input_under);
        }
        xk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        this.afI = z;
        if (this.afI) {
            this.afG.setVisibility(0);
            if (this.Kv.length() <= 0) {
                this.afB.setEnabled(false);
            }
            if (this.afK != afm) {
                this.afF.setBackgroundResource(com.baidu.tieba.u.login_input_middle);
            }
            if (this.afM != null) {
                this.afM.cancel();
            }
            if (this.afO != null) {
                this.afM = new y(this, this.afO.jZ().getVcode_pic_url());
                this.afM.setPriority(3);
                this.afM.execute(new String[0]);
            }
        } else {
            this.afG.setVisibility(8);
            this.Kv.setText((CharSequence) null);
            if (this.afK != afm) {
                this.afF.setBackgroundResource(com.baidu.tieba.u.login_input_under);
            }
        }
        xl();
    }

    private void bh(boolean z) {
        this.afy.setEnabled(z);
        this.afy.setFocusable(z);
        this.afy.setFocusableInTouchMode(z);
        this.Kv.setEnabled(z);
        this.Kv.setFocusable(z);
        this.Kv.setFocusableInTouchMode(z);
        this.afz.setEnabled(z);
        this.afz.setFocusable(z);
        this.afz.setFocusableInTouchMode(z);
        this.afp.setEnabled(z);
        this.afA.setEnabled(z);
        this.afA.setFocusable(z);
        this.afA.setFocusableInTouchMode(z);
        this.afr.setEnabled(z);
        this.afu.setEnabled(z);
        this.afv.setEnabled(z);
        this.afw.setEnabled(z);
        this.Kx.setEnabled(z);
        this.afs.setEnabled(z);
        this.afx.setEnabled(z);
        if (z) {
            this.afy.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.Kv.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afz.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afA.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afu.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afv.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afw.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            return;
        }
        this.afy.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.Kv.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afz.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afA.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afu.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afv.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afw.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm() {
        bh(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData xn() {
        RegistData registData = new RegistData();
        registData.setName(this.afy.getText().toString());
        registData.setPsw(this.afz.getText().toString());
        registData.setPhone(this.afA.getText().toString());
        if (this.afI) {
            registData.setVcode(this.Kv.getText().toString());
        }
        if (this.afO != null) {
            registData.setVcodeMd5(this.afO.jZ().getVcode_md5());
            registData.setSmsCodeTime(this.afO.getSmsCodeTime());
        }
        return registData;
    }

    private void xo() {
        String string;
        int length = getString(com.baidu.tieba.y.reg_info).length();
        String str = String.valueOf(string) + getString(com.baidu.tieba.y.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new x(this, this), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.s.skin_1_common_color)), 0, length, 33);
        }
        this.afx.setMovementMethod(LinkMovementMethod.getInstance());
        this.afx.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == afj && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void qb() {
        this.afD.setVisibility(8);
        this.aft.clearCheck();
        this.afu.setVisibility(8);
        this.afv.setVisibility(8);
        this.afw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ArrayList<String> arrayList) {
        int size;
        qb();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.afD.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.afu.setText(arrayList.get(0));
                this.afu.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.afv.setText(arrayList.get(1));
                this.afv.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.afw.setText(arrayList.get(2));
                this.afw.setVisibility(0);
            }
        }
    }
}
