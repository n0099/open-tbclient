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
    private static int afb = 1000;
    private static int afc = 27;
    private static int afd = 29;
    private static int afe = 28;
    private static int aff = 6;
    private NavigationBar mNavigationBar;
    private View KB = null;
    private TextView afg = null;
    private Button afh = null;
    private ImageView afi = null;
    private ImageView afj = null;
    private Button afk = null;
    private RadioGroup afl = null;
    private RadioButton afm = null;
    private RadioButton afn = null;
    private RadioButton afo = null;
    private TextView afp = null;
    private TextView KJ = null;
    private EditText afq = null;
    private EditText afr = null;
    private EditText afs = null;
    private EditText Ku = null;
    private RelativeLayout aft = null;
    private LinearLayout afu = null;
    private LinearLayout afv = null;
    private LinearLayout afw = null;
    private LinearLayout afx = null;
    private LinearLayout afy = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar afz = null;
    private ImageView Kw = null;
    private int aeT = 0;
    private int aeU = 0;
    private boolean afA = false;
    private boolean afB = true;
    private int afC = -1;
    private String mErrorString = null;
    RelativeLayout KO = null;
    TextView afD = null;
    private y afE = null;
    private z afF = null;
    private com.baidu.tbadk.core.data.j afG = null;
    private final View.OnClickListener afH = new t(this);
    private final TextWatcher aeW = new u(this);
    private final View.OnFocusChangeListener aeX = new v(this);
    private final RadioGroup.OnCheckedChangeListener afI = new w(this);

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
    public void xg() {
        int selectionStart = this.afr.getSelectionStart();
        if (!this.afB) {
            this.afh.setText(getString(com.baidu.tieba.y.hide));
            this.afr.setTransformationMethod(new SingleLineTransformationMethod());
            this.afr.setSelection(selectionStart);
            this.afB = true;
            return;
        }
        this.afh.setText(getString(com.baidu.tieba.y.show));
        this.afr.setTransformationMethod(new PasswordTransformationMethod());
        this.afr.setSelection(selectionStart);
        this.afB = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.afF != null) {
            this.afF.cancel();
        }
        if (this.afE != null) {
            this.afE.cancel();
        }
    }

    private void initUI() {
        this.KO = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.KB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.afH);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.account_regedit_baidu));
        this.afg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.account_login), this.afH);
        this.afD = (TextView) findViewById(com.baidu.tieba.v.reg_text);
        this.afp = (TextView) findViewById(com.baidu.tieba.v.reg_info);
        this.aft = (RelativeLayout) findViewById(com.baidu.tieba.v.register);
        this.aft.setEnabled(false);
        this.afh = (Button) findViewById(com.baidu.tieba.v.show);
        this.afr = (EditText) findViewById(com.baidu.tieba.v.edit_psw);
        this.afq = (EditText) findViewById(com.baidu.tieba.v.edit_user_name);
        this.afi = (ImageView) findViewById(com.baidu.tieba.v.del_user_name);
        this.afi.setOnClickListener(this.afH);
        this.afj = (ImageView) findViewById(com.baidu.tieba.v.del_phone);
        this.afj.setOnClickListener(this.afH);
        this.afq.setOnFocusChangeListener(this.aeX);
        this.afs = (EditText) findViewById(com.baidu.tieba.v.edit_phone);
        this.afs.setOnFocusChangeListener(this.aeX);
        this.afh.setOnClickListener(this.afH);
        this.afq.addTextChangedListener(this.aeW);
        this.afr.addTextChangedListener(this.aeW);
        this.afs.addTextChangedListener(this.aeW);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.progress_reg);
        this.afz = (ProgressBar) findViewById(com.baidu.tieba.v.image_progress);
        this.afm = (RadioButton) findViewById(com.baidu.tieba.v.choose_name1);
        this.afn = (RadioButton) findViewById(com.baidu.tieba.v.choose_name2);
        this.afo = (RadioButton) findViewById(com.baidu.tieba.v.choose_name3);
        this.afl = (RadioGroup) findViewById(com.baidu.tieba.v.name_group);
        this.afl.setOnCheckedChangeListener(this.afI);
        this.aft.setOnClickListener(this.afH);
        this.afu = (LinearLayout) findViewById(com.baidu.tieba.v.user_name_bg);
        this.aeT = this.afu.getPaddingLeft();
        this.aeU = this.afu.getPaddingRight();
        this.afv = (LinearLayout) findViewById(com.baidu.tieba.v.recommend_bg);
        this.afw = (LinearLayout) findViewById(com.baidu.tieba.v.input_psw_bg);
        this.afx = (LinearLayout) findViewById(com.baidu.tieba.v.input_phone_bg);
        this.afy = (LinearLayout) findViewById(com.baidu.tieba.v.input_vcode_bg);
        this.KJ = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.Kw = (ImageView) findViewById(com.baidu.tieba.v.image_vcode);
        this.afk = (Button) findViewById(com.baidu.tieba.v.change_vcode);
        this.Kw.setOnClickListener(this.afH);
        this.afk.setOnClickListener(this.afH);
        this.Ku = (EditText) findViewById(com.baidu.tieba.v.edit_vcode);
        this.Ku.addTextChangedListener(this.aeW);
        xg();
        ShowSoftKeyPadDelay(this.afq, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        aw.a(this.afD, i);
        aw.f(this.KO, i);
        xm();
        xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh() {
        bh(false);
    }

    private void xi() {
        this.afu.setPadding(this.aeT, 0, this.aeU, 0);
        this.afv.setPadding(this.aeT, 0, this.aeU, 0);
        this.afw.setPadding(this.aeT, 0, this.aeU, 0);
        this.afx.setPadding(this.aeT, 0, this.aeU, 0);
        this.afy.setPadding(this.aeT, 0, this.aeU, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        this.KJ.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.KJ.setVisibility(0);
        } else {
            this.KJ.setVisibility(4);
        }
        if (this.afC == afc) {
            aw.h(this.afu, com.baidu.tieba.u.login_input_topwrong);
        } else if (this.afC == afd) {
            aw.h(this.afw, com.baidu.tieba.u.login_input_middlewrong);
        } else if (this.afC == afe) {
            if (this.afA) {
                aw.h(this.afx, com.baidu.tieba.u.login_input_middlewrong);
            } else {
                aw.h(this.afx, com.baidu.tieba.u.login_input_underwrong);
            }
        } else if (this.afC == aff) {
            aw.h(this.afy, com.baidu.tieba.u.login_input_underwrong);
        } else {
            aw.h(this.afu, com.baidu.tieba.u.login_input_top);
            aw.h(this.afw, com.baidu.tieba.u.login_input_middle);
            if (this.afA) {
                aw.h(this.afx, com.baidu.tieba.u.login_input_middle);
            } else {
                aw.h(this.afx, com.baidu.tieba.u.login_input_under);
            }
            aw.h(this.afy, com.baidu.tieba.u.login_input_under);
        }
        xi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        this.afA = z;
        if (this.afA) {
            this.afy.setVisibility(0);
            if (this.Ku.length() <= 0) {
                this.aft.setEnabled(false);
            }
            if (this.afC != afe) {
                this.afx.setBackgroundResource(com.baidu.tieba.u.login_input_middle);
            }
            if (this.afE != null) {
                this.afE.cancel();
            }
            if (this.afG != null) {
                this.afE = new y(this, this.afG.jZ().getVcode_pic_url());
                this.afE.setPriority(3);
                this.afE.execute(new String[0]);
            }
        } else {
            this.afy.setVisibility(8);
            this.Ku.setText((CharSequence) null);
            if (this.afC != afe) {
                this.afx.setBackgroundResource(com.baidu.tieba.u.login_input_under);
            }
        }
        xj();
    }

    private void bh(boolean z) {
        this.afq.setEnabled(z);
        this.afq.setFocusable(z);
        this.afq.setFocusableInTouchMode(z);
        this.Ku.setEnabled(z);
        this.Ku.setFocusable(z);
        this.Ku.setFocusableInTouchMode(z);
        this.afr.setEnabled(z);
        this.afr.setFocusable(z);
        this.afr.setFocusableInTouchMode(z);
        this.afh.setEnabled(z);
        this.afs.setEnabled(z);
        this.afs.setFocusable(z);
        this.afs.setFocusableInTouchMode(z);
        this.afj.setEnabled(z);
        this.afm.setEnabled(z);
        this.afn.setEnabled(z);
        this.afo.setEnabled(z);
        this.Kw.setEnabled(z);
        this.afk.setEnabled(z);
        this.afp.setEnabled(z);
        if (z) {
            this.afq.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.Ku.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afr.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afs.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afm.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afn.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            this.afo.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
            return;
        }
        this.afq.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.Ku.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afr.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afs.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afm.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afn.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        this.afo.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xk() {
        bh(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData xl() {
        RegistData registData = new RegistData();
        registData.setName(this.afq.getText().toString());
        registData.setPsw(this.afr.getText().toString());
        registData.setPhone(this.afs.getText().toString());
        if (this.afA) {
            registData.setVcode(this.Ku.getText().toString());
        }
        if (this.afG != null) {
            registData.setVcodeMd5(this.afG.jZ().getVcode_md5());
            registData.setSmsCodeTime(this.afG.getSmsCodeTime());
        }
        return registData;
    }

    private void xm() {
        String string;
        int length = getString(com.baidu.tieba.y.reg_info).length();
        String str = String.valueOf(string) + getString(com.baidu.tieba.y.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new x(this, this), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.s.skin_1_common_color)), 0, length, 33);
        }
        this.afp.setMovementMethod(LinkMovementMethod.getInstance());
        this.afp.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == afb && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void pZ() {
        this.afv.setVisibility(8);
        this.afl.clearCheck();
        this.afm.setVisibility(8);
        this.afn.setVisibility(8);
        this.afo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ArrayList<String> arrayList) {
        int size;
        pZ();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.afv.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.afm.setText(arrayList.get(0));
                this.afm.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.afn.setText(arrayList.get(1));
                this.afn.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.afo.setText(arrayList.get(2));
                this.afo.setVisibility(0);
            }
        }
    }
}
