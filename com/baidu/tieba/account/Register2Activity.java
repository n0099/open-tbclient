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
    private static int ans = 1000;
    private static int ant = 27;
    private static int anu = 29;
    private static int anv = 28;
    private static int anw = 6;
    private NavigationBar mNavigationBar;
    private View Qk = null;
    private TextView anx = null;
    private Button any = null;
    private ImageView anz = null;
    private ImageView anA = null;
    private Button anB = null;
    private RadioGroup anC = null;
    private RadioButton anD = null;
    private RadioButton anE = null;
    private RadioButton anF = null;
    private TextView anG = null;
    private TextView Qs = null;
    private EditText anH = null;
    private EditText anI = null;
    private EditText anJ = null;
    private EditText Qd = null;
    private RelativeLayout anK = null;
    private LinearLayout anL = null;
    private LinearLayout anM = null;
    private LinearLayout anN = null;
    private LinearLayout anO = null;
    private LinearLayout anP = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar anQ = null;
    private ImageView Qf = null;
    private int ani = 0;
    private int anj = 0;
    private boolean anR = false;
    private boolean anS = true;
    private int anT = -1;
    private String mErrorString = null;
    RelativeLayout Qx = null;
    TextView anU = null;
    private aa anV = null;
    private ab anW = null;
    private com.baidu.tbadk.core.data.n anX = null;
    private final View.OnClickListener anY = new v(this);
    private final TextWatcher anl = new w(this);
    private final View.OnFocusChangeListener anm = new x(this);
    private final RadioGroup.OnCheckedChangeListener anZ = new y(this);

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
    public void AV() {
        int selectionStart = this.anI.getSelectionStart();
        if (!this.anS) {
            this.any.setText(getPageContext().getString(com.baidu.tieba.z.hide));
            this.anI.setTransformationMethod(new SingleLineTransformationMethod());
            this.anI.setSelection(selectionStart);
            this.anS = true;
            return;
        }
        this.any.setText(getPageContext().getString(com.baidu.tieba.z.show));
        this.anI.setTransformationMethod(new PasswordTransformationMethod());
        this.anI.setSelection(selectionStart);
        this.anS = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.anW != null) {
            this.anW.cancel();
        }
        if (this.anV != null) {
            this.anV.cancel();
        }
    }

    private void initUI() {
        this.Qx = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.Qk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.anY);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.account_regedit_baidu));
        this.anx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.account_login), this.anY);
        this.anU = (TextView) findViewById(com.baidu.tieba.w.reg_text);
        this.anG = (TextView) findViewById(com.baidu.tieba.w.reg_info);
        this.anK = (RelativeLayout) findViewById(com.baidu.tieba.w.register);
        this.anK.setEnabled(false);
        this.any = (Button) findViewById(com.baidu.tieba.w.show);
        this.anI = (EditText) findViewById(com.baidu.tieba.w.edit_psw);
        this.anH = (EditText) findViewById(com.baidu.tieba.w.edit_user_name);
        this.anz = (ImageView) findViewById(com.baidu.tieba.w.del_user_name);
        this.anz.setOnClickListener(this.anY);
        this.anA = (ImageView) findViewById(com.baidu.tieba.w.del_phone);
        this.anA.setOnClickListener(this.anY);
        this.anH.setOnFocusChangeListener(this.anm);
        this.anJ = (EditText) findViewById(com.baidu.tieba.w.edit_phone);
        this.anJ.setOnFocusChangeListener(this.anm);
        this.any.setOnClickListener(this.anY);
        this.anH.addTextChangedListener(this.anl);
        this.anI.addTextChangedListener(this.anl);
        this.anJ.addTextChangedListener(this.anl);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.progress_reg);
        this.anQ = (ProgressBar) findViewById(com.baidu.tieba.w.image_progress);
        this.anD = (RadioButton) findViewById(com.baidu.tieba.w.choose_name1);
        this.anE = (RadioButton) findViewById(com.baidu.tieba.w.choose_name2);
        this.anF = (RadioButton) findViewById(com.baidu.tieba.w.choose_name3);
        this.anC = (RadioGroup) findViewById(com.baidu.tieba.w.name_group);
        this.anC.setOnCheckedChangeListener(this.anZ);
        this.anK.setOnClickListener(this.anY);
        this.anL = (LinearLayout) findViewById(com.baidu.tieba.w.user_name_bg);
        this.ani = this.anL.getPaddingLeft();
        this.anj = this.anL.getPaddingRight();
        this.anM = (LinearLayout) findViewById(com.baidu.tieba.w.recommend_bg);
        this.anN = (LinearLayout) findViewById(com.baidu.tieba.w.input_psw_bg);
        this.anO = (LinearLayout) findViewById(com.baidu.tieba.w.input_phone_bg);
        this.anP = (LinearLayout) findViewById(com.baidu.tieba.w.input_vcode_bg);
        this.Qs = (TextView) findViewById(com.baidu.tieba.w.text_error);
        this.Qf = (ImageView) findViewById(com.baidu.tieba.w.image_vcode);
        this.anB = (Button) findViewById(com.baidu.tieba.w.change_vcode);
        this.Qf.setOnClickListener(this.anY);
        this.anB.setOnClickListener(this.anY);
        this.Qd = (EditText) findViewById(com.baidu.tieba.w.edit_vcode);
        this.Qd.addTextChangedListener(this.anl);
        AV();
        ShowSoftKeyPadDelay(this.anH, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        bc.b(this.anU, i);
        bc.g(this.Qx, i);
        Bb();
        AY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW() {
        bi(false);
    }

    private void AX() {
        this.anL.setPadding(this.ani, 0, this.anj, 0);
        this.anM.setPadding(this.ani, 0, this.anj, 0);
        this.anN.setPadding(this.ani, 0, this.anj, 0);
        this.anO.setPadding(this.ani, 0, this.anj, 0);
        this.anP.setPadding(this.ani, 0, this.anj, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY() {
        this.Qs.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.Qs.setVisibility(0);
        } else {
            this.Qs.setVisibility(4);
        }
        if (this.anT == ant) {
            bc.i(this.anL, com.baidu.tieba.v.login_input_topwrong);
        } else if (this.anT == anu) {
            bc.i(this.anN, com.baidu.tieba.v.login_input_middlewrong);
        } else if (this.anT == anv) {
            if (this.anR) {
                bc.i(this.anO, com.baidu.tieba.v.login_input_middlewrong);
            } else {
                bc.i(this.anO, com.baidu.tieba.v.login_input_underwrong);
            }
        } else if (this.anT == anw) {
            bc.i(this.anP, com.baidu.tieba.v.login_input_underwrong);
        } else {
            bc.i(this.anL, com.baidu.tieba.v.login_input_top);
            bc.i(this.anN, com.baidu.tieba.v.login_input_middle);
            if (this.anR) {
                bc.i(this.anO, com.baidu.tieba.v.login_input_middle);
            } else {
                bc.i(this.anO, com.baidu.tieba.v.login_input_under);
            }
            bc.i(this.anP, com.baidu.tieba.v.login_input_under);
        }
        AX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(boolean z) {
        this.anR = z;
        if (this.anR) {
            this.anP.setVisibility(0);
            if (this.Qd.length() <= 0) {
                this.anK.setEnabled(false);
            }
            if (this.anT != anv) {
                this.anO.setBackgroundResource(com.baidu.tieba.v.login_input_middle);
            }
            if (this.anV != null) {
                this.anV.cancel();
            }
            if (this.anX != null) {
                this.anV = new aa(this, this.anX.mK().getVcode_pic_url());
                this.anV.setPriority(3);
                this.anV.execute(new String[0]);
            }
        } else {
            this.anP.setVisibility(8);
            this.Qd.setText((CharSequence) null);
            if (this.anT != anv) {
                this.anO.setBackgroundResource(com.baidu.tieba.v.login_input_under);
            }
        }
        AY();
    }

    private void bi(boolean z) {
        this.anH.setEnabled(z);
        this.anH.setFocusable(z);
        this.anH.setFocusableInTouchMode(z);
        this.Qd.setEnabled(z);
        this.Qd.setFocusable(z);
        this.Qd.setFocusableInTouchMode(z);
        this.anI.setEnabled(z);
        this.anI.setFocusable(z);
        this.anI.setFocusableInTouchMode(z);
        this.any.setEnabled(z);
        this.anJ.setEnabled(z);
        this.anJ.setFocusable(z);
        this.anJ.setFocusableInTouchMode(z);
        this.anA.setEnabled(z);
        this.anD.setEnabled(z);
        this.anE.setEnabled(z);
        this.anF.setEnabled(z);
        this.Qf.setEnabled(z);
        this.anB.setEnabled(z);
        this.anG.setEnabled(z);
        if (z) {
            this.anH.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.Qd.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anI.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anJ.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anD.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anE.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.anF.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            return;
        }
        this.anH.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.Qd.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anI.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anJ.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anD.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anE.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.anF.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ() {
        bi(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData Ba() {
        RegistData registData = new RegistData();
        registData.setName(this.anH.getText().toString());
        registData.setPsw(this.anI.getText().toString());
        registData.setPhone(this.anJ.getText().toString());
        if (this.anR) {
            registData.setVcode(this.Qd.getText().toString());
        }
        if (this.anX != null) {
            registData.setVcodeMd5(this.anX.mK().getVcode_md5());
            registData.setSmsCodeTime(this.anX.getSmsCodeTime());
        }
        return registData;
    }

    private void Bb() {
        String string;
        int length = getPageContext().getString(com.baidu.tieba.z.reg_info).length();
        String str = String.valueOf(string) + getPageContext().getString(com.baidu.tieba.z.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new z(this, getPageContext().getPageActivity()), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.t.skin_1_common_color)), 0, length, 33);
        }
        this.anG.setMovementMethod(LinkMovementMethod.getInstance());
        this.anG.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == ans && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void tF() {
        this.anM.setVisibility(8);
        this.anC.clearCheck();
        this.anD.setVisibility(8);
        this.anE.setVisibility(8);
        this.anF.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(ArrayList<String> arrayList) {
        int size;
        tF();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.anM.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.anD.setText(arrayList.get(0));
                this.anD.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.anE.setText(arrayList.get(1));
                this.anE.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.anF.setText(arrayList.get(2));
                this.anF.setVisibility(0);
            }
        }
    }
}
