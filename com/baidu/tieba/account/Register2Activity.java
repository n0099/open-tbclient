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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.Register2ActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.RegistData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends BaseActivity<Register2Activity> {
    private static int anv = 1000;
    private static int anw = 27;
    private static int anx = 29;
    private static int any = 28;
    private static int anz = 6;
    private NavigationBar mNavigationBar;
    private View Qn = null;
    private TextView anA = null;
    private Button anB = null;
    private ImageView anC = null;
    private ImageView anD = null;
    private Button anE = null;
    private RadioGroup anF = null;
    private RadioButton anG = null;
    private RadioButton anH = null;
    private RadioButton anI = null;
    private TextView anJ = null;
    private TextView Qv = null;
    private EditText anK = null;
    private EditText anL = null;
    private EditText anM = null;
    private EditText Qg = null;
    private RelativeLayout anN = null;
    private LinearLayout anO = null;
    private LinearLayout anP = null;
    private LinearLayout anQ = null;
    private LinearLayout anR = null;
    private LinearLayout anS = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar anT = null;
    private ImageView Qi = null;
    private int anl = 0;
    private int anm = 0;
    private boolean anU = false;
    private boolean anV = true;
    private int anW = -1;
    private String mErrorString = null;
    RelativeLayout QB = null;
    TextView anX = null;
    private aa anY = null;
    private ab anZ = null;
    private com.baidu.tbadk.core.data.n aoa = null;
    private final View.OnClickListener aob = new v(this);
    private final TextWatcher ano = new w(this);
    private final View.OnFocusChangeListener anp = new x(this);
    private final RadioGroup.OnCheckedChangeListener aoc = new y(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(Register2ActivityConfig.class, Register2Activity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.account_register2_activity);
        initUI();
        new ba(TbConfig.ST_TYPE_REG).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        int selectionStart = this.anL.getSelectionStart();
        if (!this.anV) {
            this.anB.setText(getPageContext().getString(com.baidu.tieba.z.hide));
            this.anL.setTransformationMethod(new SingleLineTransformationMethod());
            this.anL.setSelection(selectionStart);
            this.anV = true;
            return;
        }
        this.anB.setText(getPageContext().getString(com.baidu.tieba.z.show));
        this.anL.setTransformationMethod(new PasswordTransformationMethod());
        this.anL.setSelection(selectionStart);
        this.anV = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.anZ != null) {
            this.anZ.cancel();
        }
        if (this.anY != null) {
            this.anY.cancel();
        }
    }

    private void initUI() {
        this.QB = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.Qn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aob);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.account_regedit_baidu));
        this.anA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.account_login), this.aob);
        this.anX = (TextView) findViewById(com.baidu.tieba.w.reg_text);
        this.anJ = (TextView) findViewById(com.baidu.tieba.w.reg_info);
        this.anN = (RelativeLayout) findViewById(com.baidu.tieba.w.register);
        this.anN.setEnabled(false);
        this.anB = (Button) findViewById(com.baidu.tieba.w.show);
        this.anL = (EditText) findViewById(com.baidu.tieba.w.edit_psw);
        this.anK = (EditText) findViewById(com.baidu.tieba.w.edit_user_name);
        this.anC = (ImageView) findViewById(com.baidu.tieba.w.del_user_name);
        this.anC.setOnClickListener(this.aob);
        this.anD = (ImageView) findViewById(com.baidu.tieba.w.del_phone);
        this.anD.setOnClickListener(this.aob);
        this.anK.setOnFocusChangeListener(this.anp);
        this.anM = (EditText) findViewById(com.baidu.tieba.w.edit_phone);
        this.anM.setOnFocusChangeListener(this.anp);
        this.anB.setOnClickListener(this.aob);
        this.anK.addTextChangedListener(this.ano);
        this.anL.addTextChangedListener(this.ano);
        this.anM.addTextChangedListener(this.ano);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.progress_reg);
        this.anT = (ProgressBar) findViewById(com.baidu.tieba.w.image_progress);
        this.anG = (RadioButton) findViewById(com.baidu.tieba.w.choose_name1);
        this.anH = (RadioButton) findViewById(com.baidu.tieba.w.choose_name2);
        this.anI = (RadioButton) findViewById(com.baidu.tieba.w.choose_name3);
        this.anF = (RadioGroup) findViewById(com.baidu.tieba.w.name_group);
        this.anF.setOnCheckedChangeListener(this.aoc);
        this.anN.setOnClickListener(this.aob);
        this.anO = (LinearLayout) findViewById(com.baidu.tieba.w.user_name_bg);
        this.anl = this.anO.getPaddingLeft();
        this.anm = this.anO.getPaddingRight();
        this.anP = (LinearLayout) findViewById(com.baidu.tieba.w.recommend_bg);
        this.anQ = (LinearLayout) findViewById(com.baidu.tieba.w.input_psw_bg);
        this.anR = (LinearLayout) findViewById(com.baidu.tieba.w.input_phone_bg);
        this.anS = (LinearLayout) findViewById(com.baidu.tieba.w.input_vcode_bg);
        this.Qv = (TextView) findViewById(com.baidu.tieba.w.text_error);
        this.Qi = (ImageView) findViewById(com.baidu.tieba.w.image_vcode);
        this.anE = (Button) findViewById(com.baidu.tieba.w.change_vcode);
        this.Qi.setOnClickListener(this.aob);
        this.anE.setOnClickListener(this.aob);
        this.Qg = (EditText) findViewById(com.baidu.tieba.w.edit_vcode);
        this.Qg.addTextChangedListener(this.ano);
        Bb();
        ShowSoftKeyPadDelay(this.anK, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        bc.b(this.anX, i);
        bc.g(this.QB, i);
        Bh();
        Be();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bc() {
        bi(false);
    }

    private void Bd() {
        this.anO.setPadding(this.anl, 0, this.anm, 0);
        this.anP.setPadding(this.anl, 0, this.anm, 0);
        this.anQ.setPadding(this.anl, 0, this.anm, 0);
        this.anR.setPadding(this.anl, 0, this.anm, 0);
        this.anS.setPadding(this.anl, 0, this.anm, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be() {
        this.Qv.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.Qv.setVisibility(0);
        } else {
            this.Qv.setVisibility(4);
        }
        if (this.anW == anw) {
            bc.i(this.anO, com.baidu.tieba.v.login_input_topwrong);
        } else if (this.anW == anx) {
            bc.i(this.anQ, com.baidu.tieba.v.login_input_middlewrong);
        } else if (this.anW == any) {
            if (this.anU) {
                bc.i(this.anR, com.baidu.tieba.v.login_input_middlewrong);
            } else {
                bc.i(this.anR, com.baidu.tieba.v.login_input_underwrong);
            }
        } else if (this.anW == anz) {
            bc.i(this.anS, com.baidu.tieba.v.login_input_underwrong);
        } else {
            bc.i(this.anO, com.baidu.tieba.v.login_input_top);
            bc.i(this.anQ, com.baidu.tieba.v.login_input_middle);
            if (this.anU) {
                bc.i(this.anR, com.baidu.tieba.v.login_input_middle);
            } else {
                bc.i(this.anR, com.baidu.tieba.v.login_input_under);
            }
            bc.i(this.anS, com.baidu.tieba.v.login_input_under);
        }
        Bd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(boolean z) {
        this.anU = z;
        if (this.anU) {
            this.anS.setVisibility(0);
            if (this.Qg.length() <= 0) {
                this.anN.setEnabled(false);
            }
            if (this.anW != any) {
                this.anR.setBackgroundResource(com.baidu.tieba.v.login_input_middle);
            }
            if (this.anY != null) {
                this.anY.cancel();
            }
            if (this.aoa != null) {
                this.anY = new aa(this, this.aoa.mR().getVcode_pic_url());
                this.anY.setPriority(3);
                this.anY.execute(new String[0]);
            }
        } else {
            this.anS.setVisibility(8);
            this.Qg.setText((CharSequence) null);
            if (this.anW != any) {
                this.anR.setBackgroundResource(com.baidu.tieba.v.login_input_under);
            }
        }
        Be();
    }

    private void bi(boolean z) {
        this.anK.setEnabled(z);
        this.anK.setFocusable(z);
        this.anK.setFocusableInTouchMode(z);
        this.Qg.setEnabled(z);
        this.Qg.setFocusable(z);
        this.Qg.setFocusableInTouchMode(z);
        this.anL.setEnabled(z);
        this.anL.setFocusable(z);
        this.anL.setFocusableInTouchMode(z);
        this.anB.setEnabled(z);
        this.anM.setEnabled(z);
        this.anM.setFocusable(z);
        this.anM.setFocusableInTouchMode(z);
        this.anD.setEnabled(z);
        this.anG.setEnabled(z);
        this.anH.setEnabled(z);
        this.anI.setEnabled(z);
        this.Qi.setEnabled(z);
        this.anE.setEnabled(z);
        this.anJ.setEnabled(z);
        if (z) {
            this.anK.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.Qg.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anL.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anM.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anG.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anH.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anI.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            return;
        }
        this.anK.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.Qg.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anL.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anM.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anG.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anH.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anI.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf() {
        bi(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData Bg() {
        RegistData registData = new RegistData();
        registData.setName(this.anK.getText().toString());
        registData.setPsw(this.anL.getText().toString());
        registData.setPhone(this.anM.getText().toString());
        if (this.anU) {
            registData.setVcode(this.Qg.getText().toString());
        }
        if (this.aoa != null) {
            registData.setVcodeMd5(this.aoa.mR().getVcode_md5());
            registData.setSmsCodeTime(this.aoa.getSmsCodeTime());
        }
        return registData;
    }

    private void Bh() {
        String string;
        int length = getPageContext().getString(com.baidu.tieba.z.reg_info).length();
        String str = String.valueOf(string) + getPageContext().getString(com.baidu.tieba.z.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new z(this, getPageContext().getPageActivity()), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.t.skin_1_common_color)), 0, length, 33);
        }
        this.anJ.setMovementMethod(LinkMovementMethod.getInstance());
        this.anJ.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == anv && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void tL() {
        this.anP.setVisibility(8);
        this.anF.clearCheck();
        this.anG.setVisibility(8);
        this.anH.setVisibility(8);
        this.anI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(ArrayList<String> arrayList) {
        int size;
        tL();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.anP.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.anG.setText(arrayList.get(0));
                this.anG.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.anH.setText(arrayList.get(1));
                this.anH.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.anI.setText(arrayList.get(2));
                this.anI.setVisibility(0);
            }
        }
    }
}
