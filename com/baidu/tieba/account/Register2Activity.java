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
    private static int axd = 1000;
    private static int axe = 27;
    private static int axf = 29;
    private static int axg = 28;
    private static int axh = 6;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private View axi = null;
    private TextView axj = null;
    private Button axk = null;
    private ImageView axl = null;
    private ImageView axm = null;
    private Button axn = null;
    private RadioGroup axo = null;
    private RadioButton axp = null;
    private RadioButton axq = null;
    private RadioButton axr = null;
    private TextView axs = null;
    private TextView axt = null;
    private EditText axu = null;
    private EditText axv = null;
    private EditText axw = null;
    private EditText axx = null;
    private RelativeLayout axy = null;
    private LinearLayout axz = null;
    private LinearLayout axA = null;
    private LinearLayout axB = null;
    private LinearLayout axC = null;
    private LinearLayout axD = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar axE = null;
    private ImageView axF = null;
    private int awQ = 0;
    private int awR = 0;
    private boolean axG = false;
    private boolean axH = true;
    private int axI = -1;
    private String mErrorString = null;
    RelativeLayout awa = null;
    TextView axJ = null;
    private al axK = null;
    private am axL = null;
    private com.baidu.tbadk.core.data.n axM = null;
    private final View.OnClickListener axN = new ag(this);
    private final TextWatcher awT = new ah(this);
    private final View.OnFocusChangeListener awU = new ai(this);
    private final RadioGroup.OnCheckedChangeListener axO = new aj(this);

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
    public void Fi() {
        int selectionStart = this.axv.getSelectionStart();
        if (!this.axH) {
            this.axk.setText(getPageContext().getString(com.baidu.tieba.t.hide));
            this.axv.setTransformationMethod(new SingleLineTransformationMethod());
            this.axv.setSelection(selectionStart);
            this.axH = true;
            return;
        }
        this.axk.setText(getPageContext().getString(com.baidu.tieba.t.show));
        this.axv.setTransformationMethod(new PasswordTransformationMethod());
        this.axv.setSelection(selectionStart);
        this.axH = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.axL != null) {
            this.axL.cancel();
        }
        if (this.axK != null) {
            this.axK.cancel();
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
        this.awa = (RelativeLayout) findViewById(com.baidu.tieba.q.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.axi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.axN);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.account_regedit_baidu));
        this.axj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.t.account_login), this.axN);
        this.axJ = (TextView) findViewById(com.baidu.tieba.q.reg_text);
        this.axs = (TextView) findViewById(com.baidu.tieba.q.reg_info);
        this.axy = (RelativeLayout) findViewById(com.baidu.tieba.q.register);
        this.axy.setEnabled(false);
        this.axk = (Button) findViewById(com.baidu.tieba.q.show);
        this.axv = (EditText) findViewById(com.baidu.tieba.q.edit_psw);
        this.axu = (EditText) findViewById(com.baidu.tieba.q.edit_user_name);
        this.axl = (ImageView) findViewById(com.baidu.tieba.q.del_user_name);
        this.axl.setOnClickListener(this.axN);
        this.axm = (ImageView) findViewById(com.baidu.tieba.q.del_phone);
        this.axm.setOnClickListener(this.axN);
        this.axu.setOnFocusChangeListener(this.awU);
        this.axw = (EditText) findViewById(com.baidu.tieba.q.edit_phone);
        this.axw.setOnFocusChangeListener(this.awU);
        this.axk.setOnClickListener(this.axN);
        this.axu.addTextChangedListener(this.awT);
        this.axv.addTextChangedListener(this.awT);
        this.axw.addTextChangedListener(this.awT);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.q.progress_reg);
        this.axE = (ProgressBar) findViewById(com.baidu.tieba.q.image_progress);
        this.axp = (RadioButton) findViewById(com.baidu.tieba.q.choose_name1);
        this.axq = (RadioButton) findViewById(com.baidu.tieba.q.choose_name2);
        this.axr = (RadioButton) findViewById(com.baidu.tieba.q.choose_name3);
        this.axo = (RadioGroup) findViewById(com.baidu.tieba.q.name_group);
        this.axo.setOnCheckedChangeListener(this.axO);
        this.axy.setOnClickListener(this.axN);
        this.axz = (LinearLayout) findViewById(com.baidu.tieba.q.user_name_bg);
        this.awQ = this.axz.getPaddingLeft();
        this.awR = this.axz.getPaddingRight();
        this.axA = (LinearLayout) findViewById(com.baidu.tieba.q.recommend_bg);
        this.axB = (LinearLayout) findViewById(com.baidu.tieba.q.input_psw_bg);
        this.axC = (LinearLayout) findViewById(com.baidu.tieba.q.input_phone_bg);
        this.axD = (LinearLayout) findViewById(com.baidu.tieba.q.input_vcode_bg);
        this.axt = (TextView) findViewById(com.baidu.tieba.q.text_error);
        this.axF = (ImageView) findViewById(com.baidu.tieba.q.image_vcode);
        this.axn = (Button) findViewById(com.baidu.tieba.q.change_vcode);
        this.axF.setOnClickListener(this.axN);
        this.axn.setOnClickListener(this.axN);
        this.axx = (EditText) findViewById(com.baidu.tieba.q.edit_vcode);
        this.axx.addTextChangedListener(this.awT);
        Fi();
        ShowSoftKeyPadDelay(this.axu, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ay.b(this.axJ, i);
        ay.g(this.awa, i);
        Fo();
        Fl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj() {
        bv(false);
    }

    private void Fk() {
        this.axz.setPadding(this.awQ, 0, this.awR, 0);
        this.axA.setPadding(this.awQ, 0, this.awR, 0);
        this.axB.setPadding(this.awQ, 0, this.awR, 0);
        this.axC.setPadding(this.awQ, 0, this.awR, 0);
        this.axD.setPadding(this.awQ, 0, this.awR, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fl() {
        this.axt.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.axt.setVisibility(0);
        } else {
            this.axt.setVisibility(4);
        }
        if (this.axI == axe) {
            ay.i(this.axz, com.baidu.tieba.p.login_input_topwrong);
        } else if (this.axI == axf) {
            ay.i(this.axB, com.baidu.tieba.p.login_input_middlewrong);
        } else if (this.axI == axg) {
            if (this.axG) {
                ay.i(this.axC, com.baidu.tieba.p.login_input_middlewrong);
            } else {
                ay.i(this.axC, com.baidu.tieba.p.login_input_underwrong);
            }
        } else if (this.axI == axh) {
            ay.i(this.axD, com.baidu.tieba.p.login_input_underwrong);
        } else {
            ay.i(this.axz, com.baidu.tieba.p.login_input_top);
            ay.i(this.axB, com.baidu.tieba.p.login_input_middle);
            if (this.axG) {
                ay.i(this.axC, com.baidu.tieba.p.login_input_middle);
            } else {
                ay.i(this.axC, com.baidu.tieba.p.login_input_under);
            }
            ay.i(this.axD, com.baidu.tieba.p.login_input_under);
        }
        Fk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        this.axG = z;
        if (this.axG) {
            this.axD.setVisibility(0);
            if (this.axx.length() <= 0) {
                this.axy.setEnabled(false);
            }
            if (this.axI != axg) {
                this.axC.setBackgroundResource(com.baidu.tieba.p.login_input_middle);
            }
            if (this.axK != null) {
                this.axK.cancel();
            }
            if (this.axM != null) {
                this.axK = new al(this, this.axM.qK().getVcode_pic_url());
                this.axK.setPriority(3);
                this.axK.execute(new String[0]);
            }
        } else {
            this.axD.setVisibility(8);
            this.axx.setText((CharSequence) null);
            if (this.axI != axg) {
                this.axC.setBackgroundResource(com.baidu.tieba.p.login_input_under);
            }
        }
        Fl();
    }

    private void bv(boolean z) {
        this.axu.setEnabled(z);
        this.axu.setFocusable(z);
        this.axu.setFocusableInTouchMode(z);
        this.axx.setEnabled(z);
        this.axx.setFocusable(z);
        this.axx.setFocusableInTouchMode(z);
        this.axv.setEnabled(z);
        this.axv.setFocusable(z);
        this.axv.setFocusableInTouchMode(z);
        this.axk.setEnabled(z);
        this.axw.setEnabled(z);
        this.axw.setFocusable(z);
        this.axw.setFocusableInTouchMode(z);
        this.axm.setEnabled(z);
        this.axp.setEnabled(z);
        this.axq.setEnabled(z);
        this.axr.setEnabled(z);
        this.axF.setEnabled(z);
        this.axn.setEnabled(z);
        this.axs.setEnabled(z);
        if (z) {
            this.axu.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axx.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axv.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axw.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axp.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axq.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            this.axr.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
            return;
        }
        this.axu.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axx.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axv.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axw.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axp.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axq.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        this.axr.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        bv(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData Fn() {
        RegistData registData = new RegistData();
        registData.setName(this.axu.getText().toString());
        registData.setPsw(this.axv.getText().toString());
        registData.setPhone(this.axw.getText().toString());
        if (this.axG) {
            registData.setVcode(this.axx.getText().toString());
        }
        if (this.axM != null) {
            registData.setVcodeMd5(this.axM.qK().getVcode_md5());
            registData.setSmsCodeTime(this.axM.getSmsCodeTime());
        }
        return registData;
    }

    private void Fo() {
        String string;
        int length = getPageContext().getString(com.baidu.tieba.t.reg_info).length();
        String str = String.valueOf(string) + getPageContext().getString(com.baidu.tieba.t.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ak(this, getPageContext().getPageActivity()), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.n.skin_1_common_color)), 0, length, 33);
        }
        this.axs.setMovementMethod(LinkMovementMethod.getInstance());
        this.axs.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == axd && i2 == -1) {
            setResult(-1);
            finish();
        } else if (i == 11038 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void xR() {
        this.axA.setVisibility(8);
        this.axo.clearCheck();
        this.axp.setVisibility(8);
        this.axq.setVisibility(8);
        this.axr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(ArrayList<String> arrayList) {
        int size;
        xR();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.axA.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.axp.setText(arrayList.get(0));
                this.axp.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.axq.setText(arrayList.get(1));
                this.axq.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.axr.setText(arrayList.get(2));
                this.axr.setVisibility(0);
            }
        }
    }
}
