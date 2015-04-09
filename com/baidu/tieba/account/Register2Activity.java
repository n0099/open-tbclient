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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends BaseActivity<Register2Activity> {
    private NavigationBar mNavigationBar;
    private static int avy = 1000;
    private static int avz = 27;
    private static int avA = 29;
    private static int avB = 28;
    private static int avC = 6;
    private View avD = null;
    private TextView avE = null;
    private Button avF = null;
    private ImageView avG = null;
    private ImageView avH = null;
    private Button avI = null;
    private RadioGroup avJ = null;
    private RadioButton avK = null;
    private RadioButton avL = null;
    private RadioButton avM = null;
    private TextView avN = null;
    private TextView avO = null;
    private EditText avP = null;
    private EditText avQ = null;
    private EditText avR = null;
    private EditText avS = null;
    private RelativeLayout avT = null;
    private LinearLayout avU = null;
    private LinearLayout avV = null;
    private LinearLayout avW = null;
    private LinearLayout avX = null;
    private LinearLayout avY = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar avZ = null;
    private ImageView awa = null;
    private int avp = 0;
    private int avq = 0;
    private boolean awb = false;
    private boolean awc = true;
    private int awd = -1;
    private String mErrorString = null;
    RelativeLayout aux = null;
    TextView awe = null;
    private ag awf = null;
    private ah awg = null;
    private com.baidu.tbadk.core.data.n awh = null;
    private final View.OnClickListener awi = new ab(this);
    private final TextWatcher avs = new ac(this);
    private final View.OnFocusChangeListener avt = new ad(this);
    private final RadioGroup.OnCheckedChangeListener awj = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(com.baidu.tieba.w.account_register2_activity);
        initUI();
        new ay(TbConfig.ST_TYPE_REG).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Er() {
        int selectionStart = this.avQ.getSelectionStart();
        if (!this.awc) {
            this.avF.setText(getPageContext().getString(com.baidu.tieba.y.hide));
            this.avQ.setTransformationMethod(new SingleLineTransformationMethod());
            this.avQ.setSelection(selectionStart);
            this.awc = true;
            return;
        }
        this.avF.setText(getPageContext().getString(com.baidu.tieba.y.show));
        this.avQ.setTransformationMethod(new PasswordTransformationMethod());
        this.avQ.setSelection(selectionStart);
        this.awc = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.awg != null) {
            this.awg.cancel();
        }
        if (this.awf != null) {
            this.awf.cancel();
        }
    }

    private void initUI() {
        this.aux = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.avD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.awi);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.account_regedit_baidu));
        this.avE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.y.account_login), this.awi);
        this.awe = (TextView) findViewById(com.baidu.tieba.v.reg_text);
        this.avN = (TextView) findViewById(com.baidu.tieba.v.reg_info);
        this.avT = (RelativeLayout) findViewById(com.baidu.tieba.v.register);
        this.avT.setEnabled(false);
        this.avF = (Button) findViewById(com.baidu.tieba.v.show);
        this.avQ = (EditText) findViewById(com.baidu.tieba.v.edit_psw);
        this.avP = (EditText) findViewById(com.baidu.tieba.v.edit_user_name);
        this.avG = (ImageView) findViewById(com.baidu.tieba.v.del_user_name);
        this.avG.setOnClickListener(this.awi);
        this.avH = (ImageView) findViewById(com.baidu.tieba.v.del_phone);
        this.avH.setOnClickListener(this.awi);
        this.avP.setOnFocusChangeListener(this.avt);
        this.avR = (EditText) findViewById(com.baidu.tieba.v.edit_phone);
        this.avR.setOnFocusChangeListener(this.avt);
        this.avF.setOnClickListener(this.awi);
        this.avP.addTextChangedListener(this.avs);
        this.avQ.addTextChangedListener(this.avs);
        this.avR.addTextChangedListener(this.avs);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.progress_reg);
        this.avZ = (ProgressBar) findViewById(com.baidu.tieba.v.image_progress);
        this.avK = (RadioButton) findViewById(com.baidu.tieba.v.choose_name1);
        this.avL = (RadioButton) findViewById(com.baidu.tieba.v.choose_name2);
        this.avM = (RadioButton) findViewById(com.baidu.tieba.v.choose_name3);
        this.avJ = (RadioGroup) findViewById(com.baidu.tieba.v.name_group);
        this.avJ.setOnCheckedChangeListener(this.awj);
        this.avT.setOnClickListener(this.awi);
        this.avU = (LinearLayout) findViewById(com.baidu.tieba.v.user_name_bg);
        this.avp = this.avU.getPaddingLeft();
        this.avq = this.avU.getPaddingRight();
        this.avV = (LinearLayout) findViewById(com.baidu.tieba.v.recommend_bg);
        this.avW = (LinearLayout) findViewById(com.baidu.tieba.v.input_psw_bg);
        this.avX = (LinearLayout) findViewById(com.baidu.tieba.v.input_phone_bg);
        this.avY = (LinearLayout) findViewById(com.baidu.tieba.v.input_vcode_bg);
        this.avO = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.awa = (ImageView) findViewById(com.baidu.tieba.v.image_vcode);
        this.avI = (Button) findViewById(com.baidu.tieba.v.change_vcode);
        this.awa.setOnClickListener(this.awi);
        this.avI.setOnClickListener(this.awi);
        this.avS = (EditText) findViewById(com.baidu.tieba.v.edit_vcode);
        this.avS.addTextChangedListener(this.avs);
        Er();
        ShowSoftKeyPadDelay(this.avP, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ba.b(this.awe, i);
        ba.g(this.aux, i);
        Ex();
        Eu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Es() {
        bm(false);
    }

    private void Et() {
        this.avU.setPadding(this.avp, 0, this.avq, 0);
        this.avV.setPadding(this.avp, 0, this.avq, 0);
        this.avW.setPadding(this.avp, 0, this.avq, 0);
        this.avX.setPadding(this.avp, 0, this.avq, 0);
        this.avY.setPadding(this.avp, 0, this.avq, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu() {
        this.avO.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.avO.setVisibility(0);
        } else {
            this.avO.setVisibility(4);
        }
        if (this.awd == avz) {
            ba.i(this.avU, com.baidu.tieba.u.login_input_topwrong);
        } else if (this.awd == avA) {
            ba.i(this.avW, com.baidu.tieba.u.login_input_middlewrong);
        } else if (this.awd == avB) {
            if (this.awb) {
                ba.i(this.avX, com.baidu.tieba.u.login_input_middlewrong);
            } else {
                ba.i(this.avX, com.baidu.tieba.u.login_input_underwrong);
            }
        } else if (this.awd == avC) {
            ba.i(this.avY, com.baidu.tieba.u.login_input_underwrong);
        } else {
            ba.i(this.avU, com.baidu.tieba.u.login_input_top);
            ba.i(this.avW, com.baidu.tieba.u.login_input_middle);
            if (this.awb) {
                ba.i(this.avX, com.baidu.tieba.u.login_input_middle);
            } else {
                ba.i(this.avX, com.baidu.tieba.u.login_input_under);
            }
            ba.i(this.avY, com.baidu.tieba.u.login_input_under);
        }
        Et();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(boolean z) {
        this.awb = z;
        if (this.awb) {
            this.avY.setVisibility(0);
            if (this.avS.length() <= 0) {
                this.avT.setEnabled(false);
            }
            if (this.awd != avB) {
                this.avX.setBackgroundResource(com.baidu.tieba.u.login_input_middle);
            }
            if (this.awf != null) {
                this.awf.cancel();
            }
            if (this.awh != null) {
                this.awf = new ag(this, this.awh.qe().getVcode_pic_url());
                this.awf.setPriority(3);
                this.awf.execute(new String[0]);
            }
        } else {
            this.avY.setVisibility(8);
            this.avS.setText((CharSequence) null);
            if (this.awd != avB) {
                this.avX.setBackgroundResource(com.baidu.tieba.u.login_input_under);
            }
        }
        Eu();
    }

    private void bm(boolean z) {
        this.avP.setEnabled(z);
        this.avP.setFocusable(z);
        this.avP.setFocusableInTouchMode(z);
        this.avS.setEnabled(z);
        this.avS.setFocusable(z);
        this.avS.setFocusableInTouchMode(z);
        this.avQ.setEnabled(z);
        this.avQ.setFocusable(z);
        this.avQ.setFocusableInTouchMode(z);
        this.avF.setEnabled(z);
        this.avR.setEnabled(z);
        this.avR.setFocusable(z);
        this.avR.setFocusableInTouchMode(z);
        this.avH.setEnabled(z);
        this.avK.setEnabled(z);
        this.avL.setEnabled(z);
        this.avM.setEnabled(z);
        this.awa.setEnabled(z);
        this.avI.setEnabled(z);
        this.avN.setEnabled(z);
        if (z) {
            this.avP.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avS.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avQ.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avR.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avK.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avL.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avM.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            return;
        }
        this.avP.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avS.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avQ.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avR.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avK.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avL.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avM.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ev() {
        bm(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData Ew() {
        RegistData registData = new RegistData();
        registData.setName(this.avP.getText().toString());
        registData.setPsw(this.avQ.getText().toString());
        registData.setPhone(this.avR.getText().toString());
        if (this.awb) {
            registData.setVcode(this.avS.getText().toString());
        }
        if (this.awh != null) {
            registData.setVcodeMd5(this.awh.qe().getVcode_md5());
            registData.setSmsCodeTime(this.awh.getSmsCodeTime());
        }
        return registData;
    }

    private void Ex() {
        String string;
        int length = getPageContext().getString(com.baidu.tieba.y.reg_info).length();
        String str = String.valueOf(string) + getPageContext().getString(com.baidu.tieba.y.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new af(this, getPageContext().getPageActivity()), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.s.skin_1_common_color)), 0, length, 33);
        }
        this.avN.setMovementMethod(LinkMovementMethod.getInstance());
        this.avN.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == avy && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void xf() {
        this.avV.setVisibility(8);
        this.avJ.clearCheck();
        this.avK.setVisibility(8);
        this.avL.setVisibility(8);
        this.avM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<String> arrayList) {
        int size;
        xf();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.avV.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.avK.setText(arrayList.get(0));
                this.avK.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.avL.setText(arrayList.get(1));
                this.avL.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.avM.setText(arrayList.get(2));
                this.avM.setVisibility(0);
            }
        }
    }
}
