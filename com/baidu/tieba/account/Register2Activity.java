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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.RegistData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends BaseActivity<Register2Activity> {
    private static int amA = 1000;
    private static int amB = 27;
    private static int amC = 29;
    private static int amD = 28;
    private static int amE = 6;
    private NavigationBar mNavigationBar;
    private View PM = null;
    private TextView amF = null;
    private Button amG = null;
    private ImageView amH = null;
    private ImageView amI = null;
    private Button amJ = null;
    private RadioGroup amK = null;
    private RadioButton amL = null;
    private RadioButton amM = null;
    private RadioButton amN = null;
    private TextView amO = null;
    private TextView PV = null;
    private EditText amP = null;
    private EditText amQ = null;
    private EditText amR = null;
    private EditText PE = null;
    private RelativeLayout amS = null;
    private LinearLayout amT = null;
    private LinearLayout amU = null;
    private LinearLayout amV = null;
    private LinearLayout amW = null;
    private LinearLayout amX = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar amY = null;
    private ImageView PG = null;
    private int amr = 0;
    private int ams = 0;
    private boolean amZ = false;
    private boolean ana = true;
    private int anb = -1;
    private String mErrorString = null;
    RelativeLayout Qa = null;
    TextView anc = null;
    private z and = null;
    private aa ane = null;
    private com.baidu.tbadk.core.data.m anf = null;
    private final View.OnClickListener ang = new u(this);
    private final TextWatcher amu = new v(this);
    private final View.OnFocusChangeListener amv = new w(this);
    private final RadioGroup.OnCheckedChangeListener anh = new x(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(Register2ActivityConfig.class, Register2Activity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.account_register2_activity);
        initUI();
        new av(TbConfig.ST_TYPE_REG).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AB() {
        int selectionStart = this.amQ.getSelectionStart();
        if (!this.ana) {
            this.amG.setText(getPageContext().getString(com.baidu.tieba.z.hide));
            this.amQ.setTransformationMethod(new SingleLineTransformationMethod());
            this.amQ.setSelection(selectionStart);
            this.ana = true;
            return;
        }
        this.amG.setText(getPageContext().getString(com.baidu.tieba.z.show));
        this.amQ.setTransformationMethod(new PasswordTransformationMethod());
        this.amQ.setSelection(selectionStart);
        this.ana = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ane != null) {
            this.ane.cancel();
        }
        if (this.and != null) {
            this.and.cancel();
        }
    }

    private void initUI() {
        this.Qa = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.PM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ang);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.account_regedit_baidu));
        this.amF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.account_login), this.ang);
        this.anc = (TextView) findViewById(com.baidu.tieba.w.reg_text);
        this.amO = (TextView) findViewById(com.baidu.tieba.w.reg_info);
        this.amS = (RelativeLayout) findViewById(com.baidu.tieba.w.register);
        this.amS.setEnabled(false);
        this.amG = (Button) findViewById(com.baidu.tieba.w.show);
        this.amQ = (EditText) findViewById(com.baidu.tieba.w.edit_psw);
        this.amP = (EditText) findViewById(com.baidu.tieba.w.edit_user_name);
        this.amH = (ImageView) findViewById(com.baidu.tieba.w.del_user_name);
        this.amH.setOnClickListener(this.ang);
        this.amI = (ImageView) findViewById(com.baidu.tieba.w.del_phone);
        this.amI.setOnClickListener(this.ang);
        this.amP.setOnFocusChangeListener(this.amv);
        this.amR = (EditText) findViewById(com.baidu.tieba.w.edit_phone);
        this.amR.setOnFocusChangeListener(this.amv);
        this.amG.setOnClickListener(this.ang);
        this.amP.addTextChangedListener(this.amu);
        this.amQ.addTextChangedListener(this.amu);
        this.amR.addTextChangedListener(this.amu);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.progress_reg);
        this.amY = (ProgressBar) findViewById(com.baidu.tieba.w.image_progress);
        this.amL = (RadioButton) findViewById(com.baidu.tieba.w.choose_name1);
        this.amM = (RadioButton) findViewById(com.baidu.tieba.w.choose_name2);
        this.amN = (RadioButton) findViewById(com.baidu.tieba.w.choose_name3);
        this.amK = (RadioGroup) findViewById(com.baidu.tieba.w.name_group);
        this.amK.setOnCheckedChangeListener(this.anh);
        this.amS.setOnClickListener(this.ang);
        this.amT = (LinearLayout) findViewById(com.baidu.tieba.w.user_name_bg);
        this.amr = this.amT.getPaddingLeft();
        this.ams = this.amT.getPaddingRight();
        this.amU = (LinearLayout) findViewById(com.baidu.tieba.w.recommend_bg);
        this.amV = (LinearLayout) findViewById(com.baidu.tieba.w.input_psw_bg);
        this.amW = (LinearLayout) findViewById(com.baidu.tieba.w.input_phone_bg);
        this.amX = (LinearLayout) findViewById(com.baidu.tieba.w.input_vcode_bg);
        this.PV = (TextView) findViewById(com.baidu.tieba.w.text_error);
        this.PG = (ImageView) findViewById(com.baidu.tieba.w.image_vcode);
        this.amJ = (Button) findViewById(com.baidu.tieba.w.change_vcode);
        this.PG.setOnClickListener(this.ang);
        this.amJ.setOnClickListener(this.ang);
        this.PE = (EditText) findViewById(com.baidu.tieba.w.edit_vcode);
        this.PE.addTextChangedListener(this.amu);
        AB();
        ShowSoftKeyPadDelay(this.amP, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ax.b(this.anc, i);
        ax.g(this.Qa, i);
        AH();
        AE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC() {
        bg(false);
    }

    private void AD() {
        this.amT.setPadding(this.amr, 0, this.ams, 0);
        this.amU.setPadding(this.amr, 0, this.ams, 0);
        this.amV.setPadding(this.amr, 0, this.ams, 0);
        this.amW.setPadding(this.amr, 0, this.ams, 0);
        this.amX.setPadding(this.amr, 0, this.ams, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE() {
        this.PV.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.PV.setVisibility(0);
        } else {
            this.PV.setVisibility(4);
        }
        if (this.anb == amB) {
            ax.i(this.amT, com.baidu.tieba.v.login_input_topwrong);
        } else if (this.anb == amC) {
            ax.i(this.amV, com.baidu.tieba.v.login_input_middlewrong);
        } else if (this.anb == amD) {
            if (this.amZ) {
                ax.i(this.amW, com.baidu.tieba.v.login_input_middlewrong);
            } else {
                ax.i(this.amW, com.baidu.tieba.v.login_input_underwrong);
            }
        } else if (this.anb == amE) {
            ax.i(this.amX, com.baidu.tieba.v.login_input_underwrong);
        } else {
            ax.i(this.amT, com.baidu.tieba.v.login_input_top);
            ax.i(this.amV, com.baidu.tieba.v.login_input_middle);
            if (this.amZ) {
                ax.i(this.amW, com.baidu.tieba.v.login_input_middle);
            } else {
                ax.i(this.amW, com.baidu.tieba.v.login_input_under);
            }
            ax.i(this.amX, com.baidu.tieba.v.login_input_under);
        }
        AD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(boolean z) {
        this.amZ = z;
        if (this.amZ) {
            this.amX.setVisibility(0);
            if (this.PE.length() <= 0) {
                this.amS.setEnabled(false);
            }
            if (this.anb != amD) {
                this.amW.setBackgroundResource(com.baidu.tieba.v.login_input_middle);
            }
            if (this.and != null) {
                this.and.cancel();
            }
            if (this.anf != null) {
                this.and = new z(this, this.anf.mP().getVcode_pic_url());
                this.and.setPriority(3);
                this.and.execute(new String[0]);
            }
        } else {
            this.amX.setVisibility(8);
            this.PE.setText((CharSequence) null);
            if (this.anb != amD) {
                this.amW.setBackgroundResource(com.baidu.tieba.v.login_input_under);
            }
        }
        AE();
    }

    private void bg(boolean z) {
        this.amP.setEnabled(z);
        this.amP.setFocusable(z);
        this.amP.setFocusableInTouchMode(z);
        this.PE.setEnabled(z);
        this.PE.setFocusable(z);
        this.PE.setFocusableInTouchMode(z);
        this.amQ.setEnabled(z);
        this.amQ.setFocusable(z);
        this.amQ.setFocusableInTouchMode(z);
        this.amG.setEnabled(z);
        this.amR.setEnabled(z);
        this.amR.setFocusable(z);
        this.amR.setFocusableInTouchMode(z);
        this.amI.setEnabled(z);
        this.amL.setEnabled(z);
        this.amM.setEnabled(z);
        this.amN.setEnabled(z);
        this.PG.setEnabled(z);
        this.amJ.setEnabled(z);
        this.amO.setEnabled(z);
        if (z) {
            this.amP.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.PE.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.amQ.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.amR.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.amL.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.amM.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            this.amN.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
            return;
        }
        this.amP.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.PE.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.amQ.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.amR.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.amL.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.amM.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        this.amN.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF() {
        bg(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData AG() {
        RegistData registData = new RegistData();
        registData.setName(this.amP.getText().toString());
        registData.setPsw(this.amQ.getText().toString());
        registData.setPhone(this.amR.getText().toString());
        if (this.amZ) {
            registData.setVcode(this.PE.getText().toString());
        }
        if (this.anf != null) {
            registData.setVcodeMd5(this.anf.mP().getVcode_md5());
            registData.setSmsCodeTime(this.anf.getSmsCodeTime());
        }
        return registData;
    }

    private void AH() {
        String string;
        int length = getPageContext().getString(com.baidu.tieba.z.reg_info).length();
        String str = String.valueOf(string) + getPageContext().getString(com.baidu.tieba.z.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new y(this, getPageContext().getPageActivity()), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.t.skin_1_common_color)), 0, length, 33);
        }
        this.amO.setMovementMethod(LinkMovementMethod.getInstance());
        this.amO.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == amA && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void tu() {
        this.amU.setVisibility(8);
        this.amK.clearCheck();
        this.amL.setVisibility(8);
        this.amM.setVisibility(8);
        this.amN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(ArrayList<String> arrayList) {
        int size;
        tu();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.amU.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.amL.setText(arrayList.get(0));
                this.amL.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.amM.setText(arrayList.get(1));
                this.amM.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.amN.setText(arrayList.get(2));
                this.amN.setVisibility(0);
            }
        }
    }
}
