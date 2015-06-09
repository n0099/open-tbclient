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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends BaseActivity<Register2Activity> {
    private static int axe = 1000;
    private static int axf = 27;
    private static int axg = 29;
    private static int axh = 28;
    private static int axi = 6;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private View axj = null;
    private TextView axk = null;
    private Button axl = null;
    private ImageView axm = null;
    private ImageView axn = null;
    private Button axo = null;
    private RadioGroup axp = null;
    private RadioButton axq = null;
    private RadioButton axr = null;
    private RadioButton axs = null;
    private TextView axt = null;
    private TextView axu = null;
    private EditText axv = null;
    private EditText axw = null;
    private EditText axx = null;
    private EditText axy = null;
    private RelativeLayout axz = null;
    private LinearLayout axA = null;
    private LinearLayout axB = null;
    private LinearLayout axC = null;
    private LinearLayout axD = null;
    private LinearLayout axE = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar axF = null;
    private ImageView axG = null;
    private int awR = 0;
    private int awS = 0;
    private boolean axH = false;
    private boolean axI = true;
    private int axJ = -1;
    private String mErrorString = null;
    RelativeLayout awb = null;
    TextView axK = null;
    private al axL = null;
    private am axM = null;
    private com.baidu.tbadk.core.data.n axN = null;
    private final View.OnClickListener axO = new ag(this);
    private final TextWatcher awU = new ah(this);
    private final View.OnFocusChangeListener awV = new ai(this);
    private final RadioGroup.OnCheckedChangeListener axP = new aj(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(com.baidu.tieba.r.account_register2_activity);
        initUI();
        initData(bundle);
        new aw(TbConfig.ST_TYPE_REG).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj() {
        int selectionStart = this.axw.getSelectionStart();
        if (!this.axI) {
            this.axl.setText(getPageContext().getString(com.baidu.tieba.t.hide));
            this.axw.setTransformationMethod(new SingleLineTransformationMethod());
            this.axw.setSelection(selectionStart);
            this.axI = true;
            return;
        }
        this.axl.setText(getPageContext().getString(com.baidu.tieba.t.show));
        this.axw.setTransformationMethod(new PasswordTransformationMethod());
        this.axw.setSelection(selectionStart);
        this.axI = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.axM != null) {
            this.axM.cancel();
        }
        if (this.axL != null) {
            this.axL.cancel();
        }
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
        } else {
            this.mFrom = bundle.getInt("from", -1);
        }
    }

    private void initUI() {
        this.awb = (RelativeLayout) findViewById(com.baidu.tieba.q.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.axj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.axO);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.account_regedit_baidu));
        this.axk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.t.account_login), this.axO);
        this.axK = (TextView) findViewById(com.baidu.tieba.q.reg_text);
        this.axt = (TextView) findViewById(com.baidu.tieba.q.reg_info);
        this.axz = (RelativeLayout) findViewById(com.baidu.tieba.q.register);
        this.axz.setEnabled(false);
        this.axl = (Button) findViewById(com.baidu.tieba.q.show);
        this.axw = (EditText) findViewById(com.baidu.tieba.q.edit_psw);
        this.axv = (EditText) findViewById(com.baidu.tieba.q.edit_user_name);
        this.axm = (ImageView) findViewById(com.baidu.tieba.q.del_user_name);
        this.axm.setOnClickListener(this.axO);
        this.axn = (ImageView) findViewById(com.baidu.tieba.q.del_phone);
        this.axn.setOnClickListener(this.axO);
        this.axv.setOnFocusChangeListener(this.awV);
        this.axx = (EditText) findViewById(com.baidu.tieba.q.edit_phone);
        this.axx.setOnFocusChangeListener(this.awV);
        this.axl.setOnClickListener(this.axO);
        this.axv.addTextChangedListener(this.awU);
        this.axw.addTextChangedListener(this.awU);
        this.axx.addTextChangedListener(this.awU);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.q.progress_reg);
        this.axF = (ProgressBar) findViewById(com.baidu.tieba.q.image_progress);
        this.axq = (RadioButton) findViewById(com.baidu.tieba.q.choose_name1);
        this.axr = (RadioButton) findViewById(com.baidu.tieba.q.choose_name2);
        this.axs = (RadioButton) findViewById(com.baidu.tieba.q.choose_name3);
        this.axp = (RadioGroup) findViewById(com.baidu.tieba.q.name_group);
        this.axp.setOnCheckedChangeListener(this.axP);
        this.axz.setOnClickListener(this.axO);
        this.axA = (LinearLayout) findViewById(com.baidu.tieba.q.user_name_bg);
        this.awR = this.axA.getPaddingLeft();
        this.awS = this.axA.getPaddingRight();
        this.axB = (LinearLayout) findViewById(com.baidu.tieba.q.recommend_bg);
        this.axC = (LinearLayout) findViewById(com.baidu.tieba.q.input_psw_bg);
        this.axD = (LinearLayout) findViewById(com.baidu.tieba.q.input_phone_bg);
        this.axE = (LinearLayout) findViewById(com.baidu.tieba.q.input_vcode_bg);
        this.axu = (TextView) findViewById(com.baidu.tieba.q.text_error);
        this.axG = (ImageView) findViewById(com.baidu.tieba.q.image_vcode);
        this.axo = (Button) findViewById(com.baidu.tieba.q.change_vcode);
        this.axG.setOnClickListener(this.axO);
        this.axo.setOnClickListener(this.axO);
        this.axy = (EditText) findViewById(com.baidu.tieba.q.edit_vcode);
        this.axy.addTextChangedListener(this.awU);
        Fj();
        ShowSoftKeyPadDelay(this.axv, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ay.b(this.axK, i);
        ay.g(this.awb, i);
        Fp();
        Fm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fk() {
        bv(false);
    }

    private void Fl() {
        this.axA.setPadding(this.awR, 0, this.awS, 0);
        this.axB.setPadding(this.awR, 0, this.awS, 0);
        this.axC.setPadding(this.awR, 0, this.awS, 0);
        this.axD.setPadding(this.awR, 0, this.awS, 0);
        this.axE.setPadding(this.awR, 0, this.awS, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        this.axu.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.axu.setVisibility(0);
        } else {
            this.axu.setVisibility(4);
        }
        if (this.axJ == axf) {
            ay.i(this.axA, com.baidu.tieba.p.login_input_topwrong);
        } else if (this.axJ == axg) {
            ay.i(this.axC, com.baidu.tieba.p.login_input_middlewrong);
        } else if (this.axJ == axh) {
            if (this.axH) {
                ay.i(this.axD, com.baidu.tieba.p.login_input_middlewrong);
            } else {
                ay.i(this.axD, com.baidu.tieba.p.login_input_underwrong);
            }
        } else if (this.axJ == axi) {
            ay.i(this.axE, com.baidu.tieba.p.login_input_underwrong);
        } else {
            ay.i(this.axA, com.baidu.tieba.p.login_input_top);
            ay.i(this.axC, com.baidu.tieba.p.login_input_middle);
            if (this.axH) {
                ay.i(this.axD, com.baidu.tieba.p.login_input_middle);
            } else {
                ay.i(this.axD, com.baidu.tieba.p.login_input_under);
            }
            ay.i(this.axE, com.baidu.tieba.p.login_input_under);
        }
        Fl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        this.axH = z;
        if (this.axH) {
            this.axE.setVisibility(0);
            if (this.axy.length() <= 0) {
                this.axz.setEnabled(false);
            }
            if (this.axJ != axh) {
                this.axD.setBackgroundResource(com.baidu.tieba.p.login_input_middle);
            }
            if (this.axL != null) {
                this.axL.cancel();
            }
            if (this.axN != null) {
                this.axL = new al(this, this.axN.qK().getVcode_pic_url());
                this.axL.setPriority(3);
                this.axL.execute(new String[0]);
            }
        } else {
            this.axE.setVisibility(8);
            this.axy.setText((CharSequence) null);
            if (this.axJ != axh) {
                this.axD.setBackgroundResource(com.baidu.tieba.p.login_input_under);
            }
        }
        Fm();
    }

    private void bv(boolean z) {
        this.axv.setEnabled(z);
        this.axv.setFocusable(z);
        this.axv.setFocusableInTouchMode(z);
        this.axy.setEnabled(z);
        this.axy.setFocusable(z);
        this.axy.setFocusableInTouchMode(z);
        this.axw.setEnabled(z);
        this.axw.setFocusable(z);
        this.axw.setFocusableInTouchMode(z);
        this.axl.setEnabled(z);
        this.axx.setEnabled(z);
        this.axx.setFocusable(z);
        this.axx.setFocusableInTouchMode(z);
        this.axn.setEnabled(z);
        this.axq.setEnabled(z);
        this.axr.setEnabled(z);
        this.axs.setEnabled(z);
        this.axG.setEnabled(z);
        this.axo.setEnabled(z);
        this.axt.setEnabled(z);
        if (z) {
            this.axv.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axy.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axw.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axx.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axq.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axr.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axs.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            return;
        }
        this.axv.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axy.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axw.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axx.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axq.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axr.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axs.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fn() {
        bv(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData Fo() {
        RegistData registData = new RegistData();
        registData.setName(this.axv.getText().toString());
        registData.setPsw(this.axw.getText().toString());
        registData.setPhone(this.axx.getText().toString());
        if (this.axH) {
            registData.setVcode(this.axy.getText().toString());
        }
        if (this.axN != null) {
            registData.setVcodeMd5(this.axN.qK().getVcode_md5());
            registData.setSmsCodeTime(this.axN.getSmsCodeTime());
        }
        return registData;
    }

    private void Fp() {
        String string;
        int length = getPageContext().getString(com.baidu.tieba.t.reg_info).length();
        String str = String.valueOf(string) + getPageContext().getString(com.baidu.tieba.t.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ak(this, getPageContext().getPageActivity()), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.n.skin_1_common_color)), 0, length, 33);
        }
        this.axt.setMovementMethod(LinkMovementMethod.getInstance());
        this.axt.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == axe && i2 == -1) {
            setResult(-1);
            finish();
        } else if (i == 11038 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void xS() {
        this.axB.setVisibility(8);
        this.axp.clearCheck();
        this.axq.setVisibility(8);
        this.axr.setVisibility(8);
        this.axs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(ArrayList<String> arrayList) {
        int size;
        xS();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.axB.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.axq.setText(arrayList.get(0));
                this.axq.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.axr.setText(arrayList.get(1));
                this.axr.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.axs.setText(arrayList.get(2));
                this.axs.setVisibility(0);
            }
        }
    }
}
