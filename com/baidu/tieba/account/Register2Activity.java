package com.baidu.tieba.account;

import android.content.Intent;
import android.graphics.Bitmap;
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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends BaseActivity<Register2Activity> {
    private static int REQUEST_CODE = 1000;
    private static int aEw = 27;
    private static int aEx = 29;
    private static int aEy = 28;
    private static int aEz = 6;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private View aEA = null;
    private TextView aEB = null;
    private Button aEC = null;
    private ImageView aED = null;
    private ImageView aEE = null;
    private Button aEF = null;
    private RadioGroup aEG = null;
    private RadioButton aEH = null;
    private RadioButton aEI = null;
    private RadioButton aEJ = null;
    private TextView aEK = null;
    private TextView aEL = null;
    private EditText aEM = null;
    private EditText aEN = null;
    private EditText aEO = null;
    private EditText aEP = null;
    private RelativeLayout aEQ = null;
    private LinearLayout aER = null;
    private LinearLayout aES = null;
    private LinearLayout aET = null;
    private LinearLayout aEU = null;
    private LinearLayout aEV = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar aEW = null;
    private ImageView aEX = null;
    private int aEi = 0;
    private int aEj = 0;
    private boolean aEY = false;
    private boolean aEZ = true;
    private int aFa = -1;
    private String mErrorString = null;
    RelativeLayout aDt = null;
    TextView aFb = null;
    private a aFc = null;
    private b aFd = null;
    private com.baidu.tbadk.core.data.m aFe = null;
    private final View.OnClickListener aFf = new z(this);
    private final TextWatcher aEl = new aa(this);
    private final View.OnFocusChangeListener aEm = new ab(this);
    private final RadioGroup.OnCheckedChangeListener aFg = new ac(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.account_register2_activity);
        initUI();
        initData(bundle);
        new com.baidu.tbadk.core.util.aj(TbConfig.ST_TYPE_REG).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FX() {
        int selectionStart = this.aEN.getSelectionStart();
        if (!this.aEZ) {
            this.aEC.setText(getPageContext().getString(i.C0057i.hide));
            this.aEN.setTransformationMethod(new SingleLineTransformationMethod());
            this.aEN.setSelection(selectionStart);
            this.aEZ = true;
            return;
        }
        this.aEC.setText(getPageContext().getString(i.C0057i.show));
        this.aEN.setTransformationMethod(new PasswordTransformationMethod());
        this.aEN.setSelection(selectionStart);
        this.aEZ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aFd != null) {
            this.aFd.cancel();
        }
        if (this.aFc != null) {
            this.aFc.cancel();
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
        this.aDt = (RelativeLayout) findViewById(i.f.container);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.aEA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aFf);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.account_regedit_baidu));
        this.aEB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.C0057i.account_login), this.aFf);
        this.aFb = (TextView) findViewById(i.f.reg_text);
        this.aEK = (TextView) findViewById(i.f.reg_info);
        this.aEQ = (RelativeLayout) findViewById(i.f.register);
        this.aEQ.setEnabled(false);
        this.aEC = (Button) findViewById(i.f.show);
        this.aEN = (EditText) findViewById(i.f.edit_psw);
        this.aEM = (EditText) findViewById(i.f.edit_user_name);
        this.aED = (ImageView) findViewById(i.f.del_user_name);
        this.aED.setOnClickListener(this.aFf);
        this.aEE = (ImageView) findViewById(i.f.del_phone);
        this.aEE.setOnClickListener(this.aFf);
        this.aEM.setOnFocusChangeListener(this.aEm);
        this.aEO = (EditText) findViewById(i.f.edit_phone);
        this.aEO.setOnFocusChangeListener(this.aEm);
        this.aEC.setOnClickListener(this.aFf);
        this.aEM.addTextChangedListener(this.aEl);
        this.aEN.addTextChangedListener(this.aEl);
        this.aEO.addTextChangedListener(this.aEl);
        this.mProgressBar = (ProgressBar) findViewById(i.f.progress_reg);
        this.aEW = (ProgressBar) findViewById(i.f.image_progress);
        this.aEH = (RadioButton) findViewById(i.f.choose_name1);
        this.aEI = (RadioButton) findViewById(i.f.choose_name2);
        this.aEJ = (RadioButton) findViewById(i.f.choose_name3);
        this.aEG = (RadioGroup) findViewById(i.f.name_group);
        this.aEG.setOnCheckedChangeListener(this.aFg);
        this.aEQ.setOnClickListener(this.aFf);
        this.aER = (LinearLayout) findViewById(i.f.user_name_bg);
        this.aEi = this.aER.getPaddingLeft();
        this.aEj = this.aER.getPaddingRight();
        this.aES = (LinearLayout) findViewById(i.f.recommend_bg);
        this.aET = (LinearLayout) findViewById(i.f.input_psw_bg);
        this.aEU = (LinearLayout) findViewById(i.f.input_phone_bg);
        this.aEV = (LinearLayout) findViewById(i.f.input_vcode_bg);
        this.aEL = (TextView) findViewById(i.f.text_error);
        this.aEX = (ImageView) findViewById(i.f.image_vcode);
        this.aEF = (Button) findViewById(i.f.change_vcode);
        this.aEX.setOnClickListener(this.aFf);
        this.aEF.setOnClickListener(this.aFf);
        this.aEP = (EditText) findViewById(i.f.edit_vcode);
        this.aEP.addTextChangedListener(this.aEl);
        FX();
        ShowSoftKeyPadDelay(this.aEM, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.b(this.aFb, i);
        al.g(this.aDt, i);
        Gd();
        Ga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FY() {
        bw(false);
    }

    private void FZ() {
        this.aER.setPadding(this.aEi, 0, this.aEj, 0);
        this.aES.setPadding(this.aEi, 0, this.aEj, 0);
        this.aET.setPadding(this.aEi, 0, this.aEj, 0);
        this.aEU.setPadding(this.aEi, 0, this.aEj, 0);
        this.aEV.setPadding(this.aEi, 0, this.aEj, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga() {
        this.aEL.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.aEL.setVisibility(0);
        } else {
            this.aEL.setVisibility(4);
        }
        if (this.aFa == aEw) {
            al.i(this.aER, i.e.login_input_topwrong);
        } else if (this.aFa == aEx) {
            al.i(this.aET, i.e.login_input_middlewrong);
        } else if (this.aFa == aEy) {
            if (this.aEY) {
                al.i(this.aEU, i.e.login_input_middlewrong);
            } else {
                al.i(this.aEU, i.e.login_input_underwrong);
            }
        } else if (this.aFa == aEz) {
            al.i(this.aEV, i.e.login_input_underwrong);
        } else {
            al.i(this.aER, i.e.login_input_top);
            al.i(this.aET, i.e.login_input_middle);
            if (this.aEY) {
                al.i(this.aEU, i.e.login_input_middle);
            } else {
                al.i(this.aEU, i.e.login_input_under);
            }
            al.i(this.aEV, i.e.login_input_under);
        }
        FZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        this.aEY = z;
        if (this.aEY) {
            this.aEV.setVisibility(0);
            if (this.aEP.length() <= 0) {
                this.aEQ.setEnabled(false);
            }
            if (this.aFa != aEy) {
                this.aEU.setBackgroundResource(i.e.login_input_middle);
            }
            if (this.aFc != null) {
                this.aFc.cancel();
            }
            if (this.aFe != null) {
                this.aFc = new a(this.aFe.rM().getVcode_pic_url());
                this.aFc.setPriority(3);
                this.aFc.execute(new String[0]);
            }
        } else {
            this.aEV.setVisibility(8);
            this.aEP.setText((CharSequence) null);
            if (this.aFa != aEy) {
                this.aEU.setBackgroundResource(i.e.login_input_under);
            }
        }
        Ga();
    }

    private void bw(boolean z) {
        this.aEM.setEnabled(z);
        this.aEM.setFocusable(z);
        this.aEM.setFocusableInTouchMode(z);
        this.aEP.setEnabled(z);
        this.aEP.setFocusable(z);
        this.aEP.setFocusableInTouchMode(z);
        this.aEN.setEnabled(z);
        this.aEN.setFocusable(z);
        this.aEN.setFocusableInTouchMode(z);
        this.aEC.setEnabled(z);
        this.aEO.setEnabled(z);
        this.aEO.setFocusable(z);
        this.aEO.setFocusableInTouchMode(z);
        this.aEE.setEnabled(z);
        this.aEH.setEnabled(z);
        this.aEI.setEnabled(z);
        this.aEJ.setEnabled(z);
        this.aEX.setEnabled(z);
        this.aEF.setEnabled(z);
        this.aEK.setEnabled(z);
        if (z) {
            this.aEM.setTextColor(getResources().getColor(i.c.reg_font_color));
            this.aEP.setTextColor(getResources().getColor(i.c.reg_font_color));
            this.aEN.setTextColor(getResources().getColor(i.c.reg_font_color));
            this.aEO.setTextColor(getResources().getColor(i.c.reg_font_color));
            this.aEH.setTextColor(getResources().getColor(i.c.reg_font_color));
            this.aEI.setTextColor(getResources().getColor(i.c.reg_font_color));
            this.aEJ.setTextColor(getResources().getColor(i.c.reg_font_color));
            return;
        }
        this.aEM.setTextColor(getResources().getColor(i.c.text_hint_color));
        this.aEP.setTextColor(getResources().getColor(i.c.text_hint_color));
        this.aEN.setTextColor(getResources().getColor(i.c.text_hint_color));
        this.aEO.setTextColor(getResources().getColor(i.c.text_hint_color));
        this.aEH.setTextColor(getResources().getColor(i.c.text_hint_color));
        this.aEI.setTextColor(getResources().getColor(i.c.text_hint_color));
        this.aEJ.setTextColor(getResources().getColor(i.c.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gb() {
        bw(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData Gc() {
        RegistData registData = new RegistData();
        registData.setName(this.aEM.getText().toString());
        registData.setPsw(this.aEN.getText().toString());
        registData.setPhone(this.aEO.getText().toString());
        if (this.aEY) {
            registData.setVcode(this.aEP.getText().toString());
        }
        if (this.aFe != null) {
            registData.setVcodeMd5(this.aFe.rM().getVcode_md5());
            registData.setSmsCodeTime(this.aFe.getSmsCodeTime());
        }
        return registData;
    }

    private void Gd() {
        String string;
        int length = getPageContext().getString(i.C0057i.reg_info).length();
        String str = String.valueOf(string) + getPageContext().getString(i.C0057i.user_server_agreement);
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ad(this, getPageContext().getPageActivity()), length, length2, 33);
        if (this.mSkinType == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(i.c.skin_1_common_color)), 0, length, 33);
        }
        this.aEK.setMovementMethod(LinkMovementMethod.getInstance());
        this.aEK.setText(spannableString);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == REQUEST_CODE && i2 == -1) {
            setResult(-1);
            finish();
        } else if (i == 11038 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void zb() {
        this.aES.setVisibility(8);
        this.aEG.clearCheck();
        this.aEH.setVisibility(8);
        this.aEI.setVisibility(8);
        this.aEJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(ArrayList<String> arrayList) {
        int size;
        zb();
        if (arrayList != null && (size = arrayList.size()) > 0) {
            this.aES.setVisibility(0);
            if (size > 0 && arrayList.get(0) != null) {
                this.aEH.setText(arrayList.get(0));
                this.aEH.setVisibility(0);
            }
            if (size > 1 && arrayList.get(1) != null) {
                this.aEI.setText(arrayList.get(1));
                this.aEI.setVisibility(0);
            }
            if (size > 2 && arrayList.get(2) != null) {
                this.aEJ.setText(arrayList.get(2));
                this.aEJ.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        private com.baidu.tbadk.core.util.v Tu = null;
        private String mUrl;

        public a(String str) {
            this.mUrl = null;
            this.mUrl = str;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Register2Activity.this.aFc = null;
            Register2Activity.this.aEW.setVisibility(8);
            if (this.Tu != null) {
                this.Tu.gM();
            }
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Register2Activity.this.aEX.setImageDrawable(null);
            Register2Activity.this.aEW.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(String... strArr) {
            this.Tu = new com.baidu.tbadk.core.util.v(this.mUrl);
            return com.baidu.tbadk.core.util.c.N(this.Tu.tE());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            Register2Activity.this.aFc = null;
            Register2Activity.this.aEW.setVisibility(8);
            if (bitmap != null) {
                Register2Activity.this.aEX.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.m> {
        private com.baidu.tbadk.core.util.v Tu;

        private b() {
            this.Tu = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(Register2Activity register2Activity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Tu != null) {
                this.Tu.gM();
            }
            Register2Activity.this.aFd = null;
            Register2Activity.this.mProgressBar.setVisibility(8);
            Register2Activity.this.Gb();
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public com.baidu.tbadk.core.data.m doInBackground(String... strArr) {
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            try {
                RegistData Gc = Register2Activity.this.Gc();
                this.Tu = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.Tu.o("un", Gc.getName());
                this.Tu.o("phonenum", Gc.getPhone());
                this.Tu.o("passwd", Gc.getPsw());
                if (Gc.getVcode() != null) {
                    this.Tu.o("vcode", Gc.getVcode());
                }
                if (Gc.getVcodeMd5() != null) {
                    this.Tu.o("vcode_md5", Gc.getVcodeMd5());
                }
                String tD = this.Tu.tD();
                if ((this.Tu.uh() && (this.Tu.ui() == 0 || this.Tu.ui() == 36)) || this.Tu.ui() == 5) {
                    com.baidu.tbadk.core.data.m mVar2 = new com.baidu.tbadk.core.data.m();
                    mVar2.parserJson(tD);
                    return mVar2;
                }
                return mVar;
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tbadk.core.data.m mVar) {
            super.onPostExecute(mVar);
            Register2Activity.this.aFd = null;
            Register2Activity.this.mProgressBar.setVisibility(8);
            Register2Activity.this.Gb();
            Register2Activity.this.aFe = mVar;
            if (!this.Tu.uh()) {
                Register2Activity.this.aFa = -1;
                Register2Activity.this.mErrorString = this.Tu.getErrorString();
                Register2Activity.this.Ga();
            } else if (this.Tu.ui() == 36) {
                Register2Activity.this.o(mVar.rN());
                Register2Activity.this.aFa = Register2Activity.aEw;
                Register2Activity.this.mErrorString = this.Tu.getErrorString();
                Register2Activity.this.Ga();
            } else if (this.Tu.ui() == 5) {
                Register2Activity.this.aFa = Register2Activity.aEz;
                Register2Activity.this.bv(true);
            } else if (this.Tu.ui() != 0) {
                Register2Activity.this.aFa = this.Tu.ui();
                Register2Activity.this.mErrorString = this.Tu.getErrorString();
                Register2Activity.this.Ga();
            } else {
                ActivationActivity.a(Register2Activity.this.getPageContext().getPageActivity(), Register2Activity.this.Gc(), Register2Activity.REQUEST_CODE, Register2Activity.this.mFrom == 3);
                Register2Activity.this.bv(false);
            }
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "register_local_result", this.Tu.ui(), this.Tu.getErrorString(), new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Register2Activity.this.mProgressBar.setVisibility(0);
            Register2Activity.this.FY();
            Register2Activity.this.aFa = -1;
            Register2Activity.this.mErrorString = null;
            Register2Activity.this.Ga();
            Register2Activity.this.aES.setVisibility(8);
            Register2Activity.this.aEL.setVisibility(4);
            Register2Activity.this.aEL.setText((CharSequence) null);
            super.onPreExecute();
        }
    }
}
