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
    private static int avq = 1000;
    private static int avr = 27;
    private static int avs = 29;
    private static int avt = 28;
    private static int avu = 6;
    private NavigationBar mNavigationBar;
    private View avv = null;
    private TextView avw = null;
    private Button avx = null;
    private ImageView avy = null;
    private ImageView avz = null;
    private Button avA = null;
    private RadioGroup avB = null;
    private RadioButton avC = null;
    private RadioButton avD = null;
    private RadioButton avE = null;
    private TextView avF = null;
    private TextView avG = null;
    private EditText avH = null;
    private EditText avI = null;
    private EditText avJ = null;
    private EditText avK = null;
    private RelativeLayout avL = null;
    private LinearLayout avM = null;
    private LinearLayout avN = null;
    private LinearLayout avO = null;
    private LinearLayout avP = null;
    private LinearLayout avQ = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar avR = null;
    private ImageView avS = null;
    private int avh = 0;
    private int avi = 0;
    private boolean avT = false;
    private boolean avU = true;
    private int avV = -1;
    private String mErrorString = null;
    RelativeLayout aup = null;
    TextView avW = null;
    private ag avX = null;
    private ah avY = null;
    private com.baidu.tbadk.core.data.n avZ = null;
    private final View.OnClickListener awa = new ab(this);
    private final TextWatcher avk = new ac(this);
    private final View.OnFocusChangeListener avl = new ad(this);
    private final RadioGroup.OnCheckedChangeListener awb = new ae(this);

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
    public void El() {
        int selectionStart = this.avI.getSelectionStart();
        if (!this.avU) {
            this.avx.setText(getPageContext().getString(com.baidu.tieba.y.hide));
            this.avI.setTransformationMethod(new SingleLineTransformationMethod());
            this.avI.setSelection(selectionStart);
            this.avU = true;
            return;
        }
        this.avx.setText(getPageContext().getString(com.baidu.tieba.y.show));
        this.avI.setTransformationMethod(new PasswordTransformationMethod());
        this.avI.setSelection(selectionStart);
        this.avU = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.avY != null) {
            this.avY.cancel();
        }
        if (this.avX != null) {
            this.avX.cancel();
        }
    }

    private void initUI() {
        this.aup = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.avv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.awa);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.account_regedit_baidu));
        this.avw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.y.account_login), this.awa);
        this.avW = (TextView) findViewById(com.baidu.tieba.v.reg_text);
        this.avF = (TextView) findViewById(com.baidu.tieba.v.reg_info);
        this.avL = (RelativeLayout) findViewById(com.baidu.tieba.v.register);
        this.avL.setEnabled(false);
        this.avx = (Button) findViewById(com.baidu.tieba.v.show);
        this.avI = (EditText) findViewById(com.baidu.tieba.v.edit_psw);
        this.avH = (EditText) findViewById(com.baidu.tieba.v.edit_user_name);
        this.avy = (ImageView) findViewById(com.baidu.tieba.v.del_user_name);
        this.avy.setOnClickListener(this.awa);
        this.avz = (ImageView) findViewById(com.baidu.tieba.v.del_phone);
        this.avz.setOnClickListener(this.awa);
        this.avH.setOnFocusChangeListener(this.avl);
        this.avJ = (EditText) findViewById(com.baidu.tieba.v.edit_phone);
        this.avJ.setOnFocusChangeListener(this.avl);
        this.avx.setOnClickListener(this.awa);
        this.avH.addTextChangedListener(this.avk);
        this.avI.addTextChangedListener(this.avk);
        this.avJ.addTextChangedListener(this.avk);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.progress_reg);
        this.avR = (ProgressBar) findViewById(com.baidu.tieba.v.image_progress);
        this.avC = (RadioButton) findViewById(com.baidu.tieba.v.choose_name1);
        this.avD = (RadioButton) findViewById(com.baidu.tieba.v.choose_name2);
        this.avE = (RadioButton) findViewById(com.baidu.tieba.v.choose_name3);
        this.avB = (RadioGroup) findViewById(com.baidu.tieba.v.name_group);
        this.avB.setOnCheckedChangeListener(this.awb);
        this.avL.setOnClickListener(this.awa);
        this.avM = (LinearLayout) findViewById(com.baidu.tieba.v.user_name_bg);
        this.avh = this.avM.getPaddingLeft();
        this.avi = this.avM.getPaddingRight();
        this.avN = (LinearLayout) findViewById(com.baidu.tieba.v.recommend_bg);
        this.avO = (LinearLayout) findViewById(com.baidu.tieba.v.input_psw_bg);
        this.avP = (LinearLayout) findViewById(com.baidu.tieba.v.input_phone_bg);
        this.avQ = (LinearLayout) findViewById(com.baidu.tieba.v.input_vcode_bg);
        this.avG = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.avS = (ImageView) findViewById(com.baidu.tieba.v.image_vcode);
        this.avA = (Button) findViewById(com.baidu.tieba.v.change_vcode);
        this.avS.setOnClickListener(this.awa);
        this.avA.setOnClickListener(this.awa);
        this.avK = (EditText) findViewById(com.baidu.tieba.v.edit_vcode);
        this.avK.addTextChangedListener(this.avk);
        El();
        ShowSoftKeyPadDelay(this.avH, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ba.b(this.avW, i);
        ba.g(this.aup, i);
        Er();
        Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Em() {
        bm(false);
    }

    private void En() {
        this.avM.setPadding(this.avh, 0, this.avi, 0);
        this.avN.setPadding(this.avh, 0, this.avi, 0);
        this.avO.setPadding(this.avh, 0, this.avi, 0);
        this.avP.setPadding(this.avh, 0, this.avi, 0);
        this.avQ.setPadding(this.avh, 0, this.avi, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo() {
        this.avG.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.avG.setVisibility(0);
        } else {
            this.avG.setVisibility(4);
        }
        if (this.avV == avr) {
            ba.i(this.avM, com.baidu.tieba.u.login_input_topwrong);
        } else if (this.avV == avs) {
            ba.i(this.avO, com.baidu.tieba.u.login_input_middlewrong);
        } else if (this.avV == avt) {
            if (this.avT) {
                ba.i(this.avP, com.baidu.tieba.u.login_input_middlewrong);
            } else {
                ba.i(this.avP, com.baidu.tieba.u.login_input_underwrong);
            }
        } else if (this.avV == avu) {
            ba.i(this.avQ, com.baidu.tieba.u.login_input_underwrong);
        } else {
            ba.i(this.avM, com.baidu.tieba.u.login_input_top);
            ba.i(this.avO, com.baidu.tieba.u.login_input_middle);
            if (this.avT) {
                ba.i(this.avP, com.baidu.tieba.u.login_input_middle);
            } else {
                ba.i(this.avP, com.baidu.tieba.u.login_input_under);
            }
            ba.i(this.avQ, com.baidu.tieba.u.login_input_under);
        }
        En();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(boolean z) {
        this.avT = z;
        if (this.avT) {
            this.avQ.setVisibility(0);
            if (this.avK.length() <= 0) {
                this.avL.setEnabled(false);
            }
            if (this.avV != avt) {
                this.avP.setBackgroundResource(com.baidu.tieba.u.login_input_middle);
            }
            if (this.avX != null) {
                this.avX.cancel();
            }
            if (this.avZ != null) {
                this.avX = new ag(this, this.avZ.qe().getVcode_pic_url());
                this.avX.setPriority(3);
                this.avX.execute(new String[0]);
            }
        } else {
            this.avQ.setVisibility(8);
            this.avK.setText((CharSequence) null);
            if (this.avV != avt) {
                this.avP.setBackgroundResource(com.baidu.tieba.u.login_input_under);
            }
        }
        Eo();
    }

    private void bm(boolean z) {
        this.avH.setEnabled(z);
        this.avH.setFocusable(z);
        this.avH.setFocusableInTouchMode(z);
        this.avK.setEnabled(z);
        this.avK.setFocusable(z);
        this.avK.setFocusableInTouchMode(z);
        this.avI.setEnabled(z);
        this.avI.setFocusable(z);
        this.avI.setFocusableInTouchMode(z);
        this.avx.setEnabled(z);
        this.avJ.setEnabled(z);
        this.avJ.setFocusable(z);
        this.avJ.setFocusableInTouchMode(z);
        this.avz.setEnabled(z);
        this.avC.setEnabled(z);
        this.avD.setEnabled(z);
        this.avE.setEnabled(z);
        this.avS.setEnabled(z);
        this.avA.setEnabled(z);
        this.avF.setEnabled(z);
        if (z) {
            this.avH.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avK.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avI.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avJ.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avC.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avD.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.avE.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            return;
        }
        this.avH.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avK.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avI.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avJ.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avC.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avD.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.avE.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ep() {
        bm(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData Eq() {
        RegistData registData = new RegistData();
        registData.setName(this.avH.getText().toString());
        registData.setPsw(this.avI.getText().toString());
        registData.setPhone(this.avJ.getText().toString());
        if (this.avT) {
            registData.setVcode(this.avK.getText().toString());
        }
        if (this.avZ != null) {
            registData.setVcodeMd5(this.avZ.qe().getVcode_md5());
            registData.setSmsCodeTime(this.avZ.getSmsCodeTime());
        }
        return registData;
    }

    private void Er() {
        String string;
        int length = getPageContext().getString(com.baidu.tieba.y.reg_info).length();
        String str = String.valueOf(string) + getPageContext().getString(com.baidu.tieba.y.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new af(this, getPageContext().getPageActivity()), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.s.skin_1_common_color)), 0, length, 33);
        }
        this.avF.setMovementMethod(LinkMovementMethod.getInstance());
        this.avF.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == avq && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void wZ() {
        this.avN.setVisibility(8);
        this.avB.clearCheck();
        this.avC.setVisibility(8);
        this.avD.setVisibility(8);
        this.avE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<String> arrayList) {
        int size;
        wZ();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.avN.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.avC.setText(arrayList.get(0));
                this.avC.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.avD.setText(arrayList.get(1));
                this.avD.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.avE.setText(arrayList.get(2));
                this.avE.setVisibility(0);
            }
        }
    }
}
