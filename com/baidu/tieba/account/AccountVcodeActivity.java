package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.VcodeInfoData;
import com.baidu.tieba.model.LoginModel;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class AccountVcodeActivity extends BaseActivity {
    private static final String PASSWD_KEY = "passwd";
    public static final int REQUEST_TYPE_INVALID = 0;
    public static final int REQUEST_TYPE_LOGIN = 1;
    public static final int REQUEST_TYPE_REGIST = 2;
    private static final String SEX_KEY = "sex";
    private static final String TYPE_KEY = "type";
    private static final String UN_KEY = "un";
    private static final String VCODE_MD5_KEY = "vcode_md5";
    private static final String VCODE_PIC_URL_KEY = "vcode_pic_url";
    private int mType = 1;
    private String mAccount = null;
    private String mPassword = null;
    private String mVcodeMd5 = null;
    private String mVcodeUrl = null;
    private int mSex = RegisterActivity.REGIST_SEX_MALE;
    private LoginAsyncTask mLoginTask = null;
    private LoginModel mModel = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar mLoginProgressBar = null;
    private Button mBack = null;
    private Button mSubmit = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private GetImageTask mGetImageTask = null;
    private InputMethodManager mInputManager = null;

    public static void startActivityForResultLogin(Activity activity, String un, String passwd, String vcodeMd5, String vcodeUrl) {
        Intent intent = new Intent(activity, AccountVcodeActivity.class);
        intent.putExtra("un", un);
        intent.putExtra(PASSWD_KEY, passwd);
        intent.putExtra(VCODE_MD5_KEY, vcodeMd5);
        intent.putExtra(VCODE_PIC_URL_KEY, vcodeUrl);
        intent.putExtra("type", 1);
        intent.setFlags(524288);
        activity.startActivityForResult(intent, 1);
    }

    public static void startActivityForResultRegist(Activity activity, String un, String passwd, int sex, String vcodeMd5, String vcodeUrl) {
        Intent intent = new Intent(activity, AccountVcodeActivity.class);
        intent.putExtra("un", un);
        intent.putExtra(PASSWD_KEY, passwd);
        intent.putExtra(VCODE_MD5_KEY, vcodeMd5);
        intent.putExtra(VCODE_PIC_URL_KEY, vcodeUrl);
        intent.putExtra(SEX_KEY, sex);
        intent.putExtra("type", 2);
        intent.setFlags(524288);
        activity.startActivityForResult(intent, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.mType = savedInstanceState.getInt("type", 0);
            this.mAccount = savedInstanceState.getString("un");
            this.mPassword = savedInstanceState.getString(PASSWD_KEY);
            this.mVcodeMd5 = savedInstanceState.getString(VCODE_MD5_KEY);
            this.mVcodeUrl = savedInstanceState.getString(VCODE_PIC_URL_KEY);
            this.mSex = savedInstanceState.getInt(SEX_KEY, RegisterActivity.REGIST_SEX_MALE);
        } else {
            Intent intent = getIntent();
            this.mType = intent.getIntExtra("type", 0);
            this.mAccount = intent.getStringExtra("un");
            this.mPassword = intent.getStringExtra(PASSWD_KEY);
            this.mVcodeMd5 = intent.getStringExtra(VCODE_MD5_KEY);
            this.mVcodeUrl = intent.getStringExtra(VCODE_PIC_URL_KEY);
            this.mSex = intent.getIntExtra(SEX_KEY, RegisterActivity.REGIST_SEX_MALE);
        }
        setContentView(R.layout.account_vcode_activity);
        initUI();
        refreshImage(this.mVcodeUrl);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("type", this.mType);
        outState.putString("un", this.mAccount);
        outState.putString(PASSWD_KEY, this.mPassword);
        outState.putString(VCODE_MD5_KEY, this.mVcodeMd5);
        outState.putString(VCODE_PIC_URL_KEY, this.mVcodeUrl);
        outState.putInt(SEX_KEY, this.mSex);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            cancelAsyncTask();
            this.mProgressBar.setVisibility(8);
            this.mLoginProgressBar.setVisibility(8);
            System.gc();
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountVcodeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AccountVcodeActivity.this.finish();
            }
        });
        this.mSubmit = (Button) findViewById(R.id.submit);
        this.mSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountVcodeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AccountVcodeActivity.this.HidenSoftKeyPad(AccountVcodeActivity.this.mInputManager, AccountVcodeActivity.this.mEdit);
                AccountVcodeActivity.this.login();
            }
        });
        if (this.mType == 1) {
            this.mSubmit.setText(R.string.account_login);
        } else if (this.mType == 2) {
            this.mSubmit.setText(R.string.account_regedit);
        }
        this.mEdit = (EditText) findViewById(R.id.input);
        this.mImage = (ImageView) findViewById(R.id.vcode_image);
        this.mImage.setImageBitmap(null);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.AccountVcodeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AccountVcodeActivity.this.refreshImage(AccountVcodeActivity.this.mVcodeUrl);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
        this.mLoginProgressBar = (ProgressBar) findViewById(R.id.login_progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        String vcode = this.mEdit.getText().toString();
        StringBuffer address = new StringBuffer(30);
        address.append(Config.SERVER_ADDRESS);
        if (this.mType == 1) {
            address.append(Config.LOGIN_ADDRESS);
        } else if (this.mType == 2) {
            address.append(Config.REGISTER_ADDRESS);
        } else {
            return;
        }
        ArrayList<BasicNameValuePair> param = new ArrayList<>();
        BasicNameValuePair tmp = new BasicNameValuePair("un", this.mAccount);
        param.add(tmp);
        BasicNameValuePair tmp2 = new BasicNameValuePair(PASSWD_KEY, this.mPassword);
        param.add(tmp2);
        BasicNameValuePair tmp3 = new BasicNameValuePair("vcode", vcode);
        param.add(tmp3);
        BasicNameValuePair tmp4 = new BasicNameValuePair(VCODE_MD5_KEY, this.mVcodeMd5);
        param.add(tmp4);
        if (this.mType == 2) {
            BasicNameValuePair tmp5 = new BasicNameValuePair(SEX_KEY, String.valueOf(this.mSex));
            param.add(tmp5);
        }
        cancelAsyncTask();
        this.mLoginTask = new LoginAsyncTask(address.toString(), param);
        this.mLoginTask.execute(address.toString(), param);
    }

    private void cancelAsyncTask() {
        if (this.mLoginTask != null) {
            this.mLoginTask.cancel();
            this.mLoginTask = null;
        }
        if (this.mGetImageTask != null) {
            this.mGetImageTask.cancel();
            this.mGetImageTask = null;
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
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImage(String str) {
        cancelAsyncTask();
        this.mGetImageTask = new GetImageTask(this, null);
        this.mGetImageTask.execute(str);
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
            AccountVcodeActivity.this.mLoginProgressBar.setVisibility(0);
            TiebaLog.i("LoginAsyncTask", "doInBackground", "url: " + this.mUrl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public LoginModel doInBackground(Object... params) {
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
            AccountVcodeActivity.this.mLoginProgressBar.setVisibility(8);
            if (data != null) {
                AccountVcodeActivity.this.mModel = data;
                AccountVcodeActivity.this.loginSucc();
            } else if (this.mNetwork != null) {
                AccountVcodeActivity.this.showToast(this.mNetwork.getErrorString());
                if (this.mNetwork.isNetSuccess() && this.mRetData != null) {
                    if (this.mNetwork.getErrorCode() == 2 || this.mNetwork.getErrorCode() == 16 || this.mNetwork.getErrorCode() == 17 || this.mNetwork.getErrorCode() == 18 || this.mNetwork.getErrorCode() == 19 || this.mNetwork.getErrorCode() == 20) {
                        AccountVcodeActivity.this.setResult(0);
                        AccountVcodeActivity.this.finish();
                    } else if (this.mNetwork.getErrorCode() == 6 || this.mNetwork.getErrorCode() == 5) {
                        VcodeInfoData info = new VcodeInfoData();
                        info.parserJson(this.mRetData);
                        AccountVcodeActivity.this.mVcodeMd5 = info.getVcode_md5();
                        AccountVcodeActivity.this.mVcodeUrl = info.getVcode_pic_url();
                        AccountVcodeActivity.this.refreshImage(AccountVcodeActivity.this.mVcodeUrl);
                    }
                }
            }
            AccountVcodeActivity.this.mLoginTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            AccountVcodeActivity.this.mLoginProgressBar.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GetImageTask extends AsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        NetWork mNetWork;

        private GetImageTask() {
            this.mNetWork = null;
            this.mCanceled = false;
        }

        /* synthetic */ GetImageTask(AccountVcodeActivity accountVcodeActivity, GetImageTask getImageTask) {
            this();
        }

        public void cancel() {
            AccountVcodeActivity.this.mGetImageTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
                this.mNetWork = null;
            }
            this.mCanceled = true;
            AccountVcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            AccountVcodeActivity.this.mProgressBar.setVisibility(0);
            AccountVcodeActivity.this.mImage.setImageBitmap(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... params) {
            String url = params[0];
            if (url == null || url.length() <= 0 || this.mCanceled) {
                return null;
            }
            this.mNetWork = new NetWork(url);
            byte[] data = this.mNetWork.getNetData();
            return BitmapHelper.Bytes2Bitmap(data);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap result) {
            AccountVcodeActivity.this.mGetImageTask = null;
            if (result != null) {
                AccountVcodeActivity.this.mImage.setImageBitmap(result);
            } else {
                AccountVcodeActivity.this.mImage.setImageResource(R.drawable.background);
            }
            AccountVcodeActivity.this.mProgressBar.setVisibility(8);
            super.onPostExecute((GetImageTask) result);
        }
    }
}
