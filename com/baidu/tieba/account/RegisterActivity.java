package com.baidu.tieba.account;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.VcodeInfoData;
import com.baidu.tieba.model.LoginModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkErr;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class RegisterActivity extends BaseActivity {
    public static int REGIST_SEX_MALE = 1;
    public static int REGIST_SEX_FEMALE = 2;
    private EditText mEditAccount = null;
    private EditText mEditPassword = null;
    private EditText mEditAPassword = null;
    private Button mButtonSexMale = null;
    private Button mButtonSexFemale = null;
    private View.OnClickListener mSexBtListener = null;
    private RelativeLayout mLayoutProtocol = null;
    private Button mButtonProtocol = null;
    private Button mButtonBack = null;
    private Button mButtonSubmit = null;
    private String mAccount = null;
    private String mPassword = null;
    private String mAPassword = null;
    private int mSex = REGIST_SEX_MALE;
    private boolean mAcceptPro = true;
    private RegistAsyncTask mTask = null;
    private LoginModel mModel = null;
    InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;

    public static void startActivityForResult(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_register_activity);
        initUI();
        showSoftInput();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case NetWorkErr.NETWORK_ERR /* -1 */:
                retToLogin();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            cancelAsyncTask();
            System.gc();
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.mEditAccount = (EditText) findViewById(R.id.regist_edit_account);
        this.mEditPassword = (EditText) findViewById(R.id.regist_edit_password);
        this.mEditAPassword = (EditText) findViewById(R.id.regist_edit_apassword);
        this.mButtonSexMale = (Button) findViewById(R.id.regist_sex_male);
        this.mButtonSexFemale = (Button) findViewById(R.id.regist_sex_female);
        this.mSexBtListener = new View.OnClickListener() { // from class: com.baidu.tieba.account.RegisterActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RegisterActivity.this.mSex == RegisterActivity.REGIST_SEX_MALE) {
                    RegisterActivity.this.mSex = RegisterActivity.REGIST_SEX_FEMALE;
                    RegisterActivity.this.mButtonSexMale.setClickable(true);
                    RegisterActivity.this.mButtonSexMale.setBackgroundDrawable(null);
                    RegisterActivity.this.mButtonSexMale.setTextColor(RegisterActivity.this.getResources().getColor(R.color.white));
                    RegisterActivity.this.mButtonSexFemale.setClickable(false);
                    RegisterActivity.this.mButtonSexFemale.setBackgroundResource(R.drawable.account_sex);
                    RegisterActivity.this.mButtonSexFemale.setTextColor(RegisterActivity.this.getResources().getColor(R.color.black));
                    return;
                }
                RegisterActivity.this.mSex = RegisterActivity.REGIST_SEX_MALE;
                RegisterActivity.this.mButtonSexMale.setClickable(false);
                RegisterActivity.this.mButtonSexMale.setBackgroundResource(R.drawable.account_sex);
                RegisterActivity.this.mButtonSexMale.setTextColor(RegisterActivity.this.getResources().getColor(R.color.black));
                RegisterActivity.this.mButtonSexFemale.setClickable(true);
                RegisterActivity.this.mButtonSexFemale.setBackgroundDrawable(null);
                RegisterActivity.this.mButtonSexFemale.setTextColor(RegisterActivity.this.getResources().getColor(R.color.white));
            }
        };
        this.mButtonSexMale.setOnClickListener(this.mSexBtListener);
        this.mButtonSexFemale.setOnClickListener(this.mSexBtListener);
        this.mLayoutProtocol = (RelativeLayout) findViewById(R.id.regist_protocol);
        this.mLayoutProtocol.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.RegisterActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, ProtocolActivity.class);
                RegisterActivity.this.startActivity(intent);
            }
        });
        this.mButtonProtocol = (Button) findViewById(R.id.regist_protocol_icon);
        this.mButtonProtocol.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.RegisterActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RegisterActivity.this.mAcceptPro) {
                    RegisterActivity.this.mAcceptPro = false;
                    RegisterActivity.this.mButtonProtocol.setBackgroundResource(R.drawable.account_check_pro);
                    return;
                }
                RegisterActivity.this.mAcceptPro = true;
                RegisterActivity.this.mButtonProtocol.setBackgroundResource(R.drawable.account_check_pro_on);
            }
        });
        this.mButtonBack = (Button) findViewById(R.id.back);
        this.mButtonBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.RegisterActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RegisterActivity.this.finish();
            }
        });
        this.mButtonSubmit = (Button) findViewById(R.id.regist_submit);
        this.mButtonSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.RegisterActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RegisterActivity.this.regist();
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.RegisterActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                RegisterActivity.this.DeinitWaitingDialog();
                RegisterActivity.this.cancelAsyncTask();
            }
        };
    }

    private void showSoftInput() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.tieba.account.RegisterActivity.7
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                InputMethodManager imm = (InputMethodManager) RegisterActivity.this.getSystemService("input_method");
                imm.showSoftInput(RegisterActivity.this.mEditAccount, 0);
            }
        }, 200L);
    }

    private void retToLogin() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void regist() {
        this.mAccount = this.mEditAccount.getText().toString();
        String password = this.mEditPassword.getText().toString();
        this.mPassword = StringHelper.base64Encode(password.getBytes());
        String apassword = this.mEditAPassword.getText().toString();
        this.mAPassword = StringHelper.base64Encode(apassword.getBytes());
        if (!StringHelper.isAccount(this.mAccount)) {
            showToast(getText(R.string.account_err_account).toString());
        } else if (!StringHelper.isPassword(password)) {
            showToast(getText(R.string.account_err_passwd).toString());
        } else if (!this.mPassword.equals(this.mAPassword)) {
            showToast(getText(R.string.account_err_apasswd).toString());
        } else if (!this.mAcceptPro) {
            showToast(getText(R.string.account_err_protocol).toString());
        } else {
            StringBuffer address = new StringBuffer(30);
            address.append(Config.SERVER_ADDRESS);
            address.append(Config.REGISTER_ADDRESS);
            ArrayList<BasicNameValuePair> param = new ArrayList<>();
            BasicNameValuePair tmp = new BasicNameValuePair("un", this.mAccount);
            param.add(tmp);
            BasicNameValuePair tmp2 = new BasicNameValuePair("passwd", this.mPassword);
            param.add(tmp2);
            BasicNameValuePair tmp3 = new BasicNameValuePair("sex", String.valueOf(this.mSex));
            param.add(tmp3);
            cancelAsyncTask();
            this.mTask = new RegistAsyncTask(address.toString(), param);
            this.mTask.execute(address.toString(), param);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registSucc() {
        AccountData account = new AccountData();
        account.setAccount(this.mModel.getUser().getName());
        account.setPassword(this.mPassword);
        account.setID(this.mModel.getUser().getId());
        account.setBDUSS(this.mModel.getUser().getBDUSS());
        account.setIsActive(1);
        if (this.mModel.getAnti() != null) {
            account.setTbs(this.mModel.getAnti().getTbs());
        }
        DatabaseService.saveAccountData(account);
        TiebaApplication.setCurrentAccountObj(account);
        retToLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registFail() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAsyncTask() {
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class RegistAsyncTask extends AsyncTask<Object, Integer, LoginModel> {
        ArrayList<BasicNameValuePair> mParams;
        private String mUrl;
        private NetWork mNetwork = null;
        private String mRetData = null;

        public RegistAsyncTask(String url, ArrayList<BasicNameValuePair> param) {
            this.mUrl = null;
            this.mParams = null;
            this.mUrl = url;
            this.mParams = param;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            RegisterActivity.this.HidenSoftKeyPad(RegisterActivity.this.mInputManager, RegisterActivity.this.mEditAccount);
            RegisterActivity.this.HidenSoftKeyPad(RegisterActivity.this.mInputManager, RegisterActivity.this.mEditPassword);
            RegisterActivity.this.HidenSoftKeyPad(RegisterActivity.this.mInputManager, RegisterActivity.this.mEditAPassword);
            RegisterActivity.this.showLoadingDialog(RegisterActivity.this.getString(R.string.sending), RegisterActivity.this.mDialogCancelListener);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public LoginModel doInBackground(Object... params) {
            Exception ex;
            LoginModel loginData = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParams);
                this.mRetData = this.mNetwork.postNetData();
                if (this.mRetData != null) {
                    TiebaLog.i("LoginAsyncTask", "doInBackground", "data: " + this.mRetData);
                }
                if (!this.mNetwork.isRequestSuccess() || this.mRetData == null) {
                    return null;
                }
                LoginModel loginData2 = new LoginModel();
                try {
                    loginData2.parserJson(this.mRetData);
                    return loginData2;
                } catch (Exception e) {
                    ex = e;
                    loginData = loginData2;
                    TiebaLog.e(getClass().getName(), "", "doInBackground error = " + ex.getMessage());
                    return loginData;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(LoginModel data) {
            RegisterActivity.this.closeLoadingDialog();
            if (data != null) {
                RegisterActivity.this.mModel = data;
                RegisterActivity.this.registSucc();
            } else if (this.mNetwork != null) {
                if ((this.mNetwork.isNetSuccess() && this.mNetwork.getErrorCode() == 5) || this.mNetwork.getErrorCode() == 6) {
                    VcodeInfoData info = new VcodeInfoData();
                    info.parserJson(this.mRetData);
                    if (info.getVcode_pic_url() != null) {
                        AccountVcodeActivity.startActivityForResultRegist(RegisterActivity.this, RegisterActivity.this.mAccount, RegisterActivity.this.mPassword, RegisterActivity.this.mSex, info.getVcode_md5(), info.getVcode_pic_url());
                    } else {
                        RegisterActivity.this.showToast(this.mNetwork.getErrorString());
                        RegisterActivity.this.registFail();
                    }
                } else {
                    RegisterActivity.this.showToast(this.mNetwork.getErrorString());
                    RegisterActivity.this.registFail();
                }
            }
            RegisterActivity.this.mTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.onCancelled();
        }
    }
}
