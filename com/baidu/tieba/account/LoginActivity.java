package com.baidu.tieba.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
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
public class LoginActivity extends BaseActivity {
    public static final String ACCOUNT = "account";
    public static final String HAS_EXIT_DIALOG = "has_exit_dialog";
    public static int REQUEST_VCODE = 100;
    public static int REQUEST_REGIST = 101;
    public static int RESULT_LOGIN_ERR = 500;
    private String mAccount = null;
    private String mPassword = null;
    private boolean mHasExitDialog = true;
    private EditText mEditAccount = null;
    private EditText mEditPassword = null;
    private Button mButtonLogin = null;
    private Button mButtonRegedit = null;
    private Button mButtonBack = null;
    private LoginAsyncTask mTask = null;
    private LoginModel mModel = null;
    InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public static void startActivityNoExitDialog(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(HAS_EXIT_DIALOG, false);
        context.startActivity(intent);
    }

    public static void startActivityWithAccount(Context context, String account) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(ACCOUNT, account);
        intent.putExtra(HAS_EXIT_DIALOG, true);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String account;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_login_activity);
        initUI();
        if (savedInstanceState != null) {
            account = savedInstanceState.getString(ACCOUNT);
            this.mHasExitDialog = savedInstanceState.getBoolean(HAS_EXIT_DIALOG, true);
        } else {
            Intent intent = getIntent();
            account = intent.getStringExtra(ACCOUNT);
            this.mHasExitDialog = intent.getBooleanExtra(HAS_EXIT_DIALOG, true);
        }
        if (account != null) {
            this.mEditAccount.setText(account);
        }
        this.mEditAccount.requestFocus();
        if (this.mHasExitDialog) {
            this.mButtonBack.setVisibility(4);
        } else {
            this.mButtonBack.setVisibility(0);
        }
        showSoftInput();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(HAS_EXIT_DIALOG, this.mHasExitDialog);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(HAS_EXIT_DIALOG, this.mHasExitDialog);
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

    @Override // android.app.Activity
    protected void onResume() {
        showSoftInput();
        super.onResume();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            if (this.mHasExitDialog) {
                quitDialog();
            } else {
                finish();
            }
            return true;
        }
        return false;
    }

    private void showSoftInput() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.tieba.account.LoginActivity.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LoginActivity.this.ShowSoftKeyPad(LoginActivity.this.mInputManager, LoginActivity.this.mEditAccount);
            }
        }, 200L);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case NetWorkErr.NETWORK_ERR /* -1 */:
                goToMainTag();
                return;
            default:
                return;
        }
    }

    private void goToMainTag() {
        DatabaseService.getSettingData();
        MainTabActivity.startActivityOnUserChanged(this, null);
        finish();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.mEditAccount = (EditText) findViewById(R.id.login_edit_account);
        this.mEditPassword = (EditText) findViewById(R.id.login_edit_password);
        this.mEditAccount.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.account.LoginActivity.2
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LoginActivity.this.cancelAsyncTask();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }
        });
        this.mEditPassword.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.account.LoginActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LoginActivity.this.cancelAsyncTask();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }
        });
        this.mButtonLogin = (Button) findViewById(R.id.login_bt_login);
        this.mButtonRegedit = (Button) findViewById(R.id.login_bt_reg);
        this.mButtonLogin.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.LoginActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LoginActivity.this.login();
            }
        });
        this.mButtonRegedit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.LoginActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LoginActivity.this.cancelAsyncTask();
                LoginActivity.this.HidenSoftKeyPad(LoginActivity.this.mInputManager, LoginActivity.this.mEditAccount);
                LoginActivity.this.HidenSoftKeyPad(LoginActivity.this.mInputManager, LoginActivity.this.mEditPassword);
                RegisterActivity.startActivityForResult(LoginActivity.this, LoginActivity.REQUEST_REGIST);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.LoginActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                LoginActivity.this.DeinitWaitingDialog();
                LoginActivity.this.cancelAsyncTask();
            }
        };
        this.mButtonBack = (Button) findViewById(R.id.back);
        this.mButtonBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.LoginActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        if (this.mTask == null) {
            this.mAccount = this.mEditAccount.getText().toString();
            String password = this.mEditPassword.getText().toString();
            this.mPassword = StringHelper.base64Encode(password.getBytes());
            if (this.mAccount.length() > 0 && this.mPassword.length() > 0) {
                StringBuffer address = new StringBuffer(30);
                address.append(Config.SERVER_ADDRESS);
                address.append(Config.LOGIN_ADDRESS);
                ArrayList<BasicNameValuePair> param = new ArrayList<>();
                BasicNameValuePair tmp = new BasicNameValuePair("un", this.mAccount);
                param.add(tmp);
                BasicNameValuePair tmp2 = new BasicNameValuePair("passwd", this.mPassword);
                param.add(tmp2);
                cancelAsyncTask();
                this.mTask = new LoginAsyncTask(address.toString(), param);
                this.mTask.execute(address.toString(), param);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSucc() {
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
        goToMainTag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginFail() {
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
    public class LoginAsyncTask extends AsyncTask<Object, Integer, LoginModel> {
        ArrayList<BasicNameValuePair> mParams;
        private String mUrl;
        private NetWork mNetwork = null;
        private String mRetData = null;

        public LoginAsyncTask(String url, ArrayList<BasicNameValuePair> param) {
            this.mUrl = null;
            this.mParams = null;
            this.mUrl = url;
            this.mParams = param;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            LoginActivity.this.HidenSoftKeyPad(LoginActivity.this.mInputManager, LoginActivity.this.mEditAccount);
            LoginActivity.this.HidenSoftKeyPad(LoginActivity.this.mInputManager, LoginActivity.this.mEditPassword);
            LoginActivity.this.showLoadingDialog(LoginActivity.this.getString(R.string.account_logining), LoginActivity.this.mDialogCancelListener);
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
            LoginActivity.this.closeLoadingDialog();
            if (data != null) {
                LoginActivity.this.mModel = data;
                LoginActivity.this.loginSucc();
            } else if (this.mNetwork != null) {
                if ((this.mNetwork.isNetSuccess() && this.mNetwork.getErrorCode() == 5) || this.mNetwork.getErrorCode() == 6) {
                    VcodeInfoData info = new VcodeInfoData();
                    info.parserJson(this.mRetData);
                    if (info.getVcode_pic_url() != null) {
                        AccountVcodeActivity.startActivityForResultLogin(LoginActivity.this, LoginActivity.this.mAccount, LoginActivity.this.mPassword, info.getVcode_md5(), info.getVcode_pic_url());
                    } else {
                        LoginActivity.this.showToast(this.mNetwork.getErrorString());
                        LoginActivity.this.loginFail();
                    }
                } else {
                    LoginActivity.this.showToast(this.mNetwork.getErrorString());
                    LoginActivity.this.loginFail();
                }
            }
            LoginActivity.this.mTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }
}
