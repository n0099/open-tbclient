package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.InputUserNameDialog;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.model.LoginModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class ReLoginShareActivity extends BaseActivity {
    public static final String BDUSS = "bduss";
    public static final String PTOKEN = "ptoken";
    private static final int RELOADFAIL = 1;
    private static final int RELOADING = 0;
    public static final String UNAME = "user_name";
    private ReLoginAsyncTask mReloginTask = null;
    private Button mRetryButton = null;
    private Button mCancelButton = null;
    private Button mBackButton = null;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private String mName = null;
    private String mBDUSS = null;
    private String mPtoken = null;
    private AccountData mAccount = null;
    private InputUserNameDialog mInputUserNameDialog = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.account.ReLoginShareActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != ReLoginShareActivity.this.mCancelButton && view != ReLoginShareActivity.this.mBackButton) {
                if (view != ReLoginShareActivity.this.mRetryButton) {
                    return;
                }
                ReLoginShareActivity.this.reLogin();
                return;
            }
            ReLoginShareActivity.this.finishActivity();
        }
    };

    public static void startActivity(Activity context, String name, String bduss, String ptoken) {
        Intent intent = new Intent(context, ReLoginShareActivity.class);
        intent.putExtra(UNAME, name);
        intent.putExtra("bduss", bduss);
        intent.putExtra(PTOKEN, ptoken);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relogin_activity);
        initData();
        initUI();
        reLogin();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mName = intent.getStringExtra(UNAME);
        this.mBDUSS = intent.getStringExtra("bduss");
        this.mPtoken = intent.getStringExtra(PTOKEN);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.mName = savedInstanceState.getString(UNAME);
        this.mBDUSS = savedInstanceState.getString("bduss");
        this.mPtoken = savedInstanceState.getString(PTOKEN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(UNAME, this.mName);
        outState.putString("bduss", this.mBDUSS);
        outState.putString(PTOKEN, this.mPtoken);
    }

    private void initUI() {
        this.mRetryButton = (Button) findViewById(R.id.relogin_retry_button);
        this.mRetryButton.setOnClickListener(this.mOnClickListener);
        this.mCancelButton = (Button) findViewById(R.id.relogin_cacel_button);
        this.mCancelButton.setOnClickListener(this.mOnClickListener);
        this.mBackButton = (Button) findViewById(R.id.relogin_bt_back);
        this.mBackButton.setOnClickListener(this.mOnClickListener);
        this.mProgressBar = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.mTextView = (TextView) findViewById(R.id.relogin_textview);
        switchLayout(0, this.mName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchLayout(int layoutId, String info) {
        String reloginFail;
        if (info == null) {
            info = "";
        }
        switch (layoutId) {
            case 0:
                this.mRetryButton.setVisibility(8);
                this.mProgressBar.setVisibility(0);
                String reLoging = getString(R.string.relogin_statement);
                int start = reLoging.indexOf(63);
                String reLoging2 = reLoging.replace("?", info);
                this.mTextView.setTextSize(2, 16.0f);
                if (info.length() <= 0) {
                    this.mTextView.setText(reLoging2);
                    return;
                }
                SpannableString loging = new SpannableString(reLoging2);
                loging.setSpan(new ForegroundColorSpan(Color.rgb((int) MotionEventCompat.ACTION_MASK, 47, 47)), start, info.length() + start, 33);
                this.mTextView.setText(loging);
                return;
            case 1:
                this.mRetryButton.setVisibility(0);
                this.mProgressBar.setVisibility(8);
                String reloginFail2 = getString(R.string.relogin_fail);
                this.mTextView.setTextSize(2, 16.0f);
                if (info.length() <= 0) {
                    this.mTextView.setText(reloginFail2);
                    return;
                }
                SpannableString fail = new SpannableString(String.valueOf(reloginFail) + info);
                int start2 = (String.valueOf(reloginFail2) + "\n\n").length();
                fail.setSpan(new ForegroundColorSpan(Color.rgb((int) MotionEventCompat.ACTION_MASK, 47, 47)), start2, info.length() + start2, 33);
                fail.setSpan(new RelativeSizeSpan(0.9f), start2, info.length() + start2, 33);
                this.mTextView.setText(fail);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            MainTabActivity.startActivity(this, MainTabActivity.GOTO_RECOMMEND);
            return;
        }
        DatabaseService.clearActiveAccount();
        TiebaApplication.setCurrentAccountObj(null);
        MainTabActivity.startActivityOnUserChanged(this, MainTabActivity.GOTO_RECOMMEND);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mReloginTask != null) {
            this.mReloginTask.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reLogin() {
        if (this.mReloginTask == null && this.mBDUSS != null && this.mPtoken != null) {
            this.mReloginTask = new ReLoginAsyncTask(this, null);
            this.mReloginTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoMain() {
        DatabaseService.saveAccountData(this.mAccount);
        TiebaApplication.setCurrentAccountObj(this.mAccount);
        MainTabActivity.startActivityOnUserChanged(this, MainTabActivity.GOTO_HOME);
        AccountShareHelper.getInstance().remove();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ReLoginAsyncTask extends AsyncTask<String, Integer, LoginModel> {
        private volatile NetWork mNetwork;

        private ReLoginAsyncTask() {
            this.mNetwork = null;
        }

        /* synthetic */ ReLoginAsyncTask(ReLoginShareActivity reLoginShareActivity, ReLoginAsyncTask reLoginAsyncTask) {
            this();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            ReLoginShareActivity.this.switchLayout(0, ReLoginShareActivity.this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public LoginModel doInBackground(String... arg0) {
            LoginModel loginData = null;
            long start = System.nanoTime();
            this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/s/login");
            this.mNetwork.addPostData("bdusstoken", String.valueOf(ReLoginShareActivity.this.mBDUSS) + "|" + ReLoginShareActivity.this.mPtoken);
            this.mNetwork.setNeedBackgroundLogin(false);
            TiebaLog.d("", "mBDUSS = ", ReLoginShareActivity.this.mBDUSS);
            TiebaLog.d("", "mPtoken = ", ReLoginShareActivity.this.mPtoken);
            String ret = this.mNetwork.postNetData();
            if (this.mNetwork.isRequestSuccess()) {
                loginData = new LoginModel();
                loginData.parserJson(ret);
            } else {
                TiebaLog.d(getClass().getName(), "doInBackground", "relogin fail");
            }
            long time = 2000 - ((System.nanoTime() - start) / 1000000);
            if (time > 0 && time < 2000) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                }
            }
            return loginData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(LoginModel result) {
            super.onPostExecute((ReLoginAsyncTask) result);
            ReLoginShareActivity.this.mReloginTask = null;
            if (result != null) {
                ReLoginShareActivity.this.mAccount = new AccountData();
                ReLoginShareActivity.this.mAccount.setAccount(result.getUser().getName());
                ReLoginShareActivity.this.mAccount.setPassword("");
                ReLoginShareActivity.this.mAccount.setID(result.getUser().getId());
                String bduss = null;
                if (result.getUser().getBDUSS() != null) {
                    bduss = String.valueOf(result.getUser().getBDUSS()) + "|" + ReLoginShareActivity.this.mPtoken;
                }
                ReLoginShareActivity.this.mAccount.setBDUSS(bduss);
                ReLoginShareActivity.this.mAccount.setIsActive(1);
                if (result.getAnti() != null) {
                    ReLoginShareActivity.this.mAccount.setTbs(result.getAnti().getTbs());
                }
                if (ReLoginShareActivity.this.mAccount.getAccount() == null) {
                    if (ReLoginShareActivity.this.mInputUserNameDialog == null) {
                        ReLoginShareActivity.this.mInputUserNameDialog = new InputUserNameDialog(ReLoginShareActivity.this);
                        ReLoginShareActivity.this.mInputUserNameDialog.setCallBackListener(new InputUserNameDialog.CallBackListener() { // from class: com.baidu.tieba.account.ReLoginShareActivity.ReLoginAsyncTask.1
                            @Override // com.baidu.tieba.account.InputUserNameDialog.CallBackListener
                            public void callback(AccountData account) {
                                ReLoginShareActivity.this.mAccount = account;
                                ReLoginShareActivity.this.gotoMain();
                            }
                        });
                        ReLoginShareActivity.this.mInputUserNameDialog.setCallBackCancelListener(new InputUserNameDialog.CallBackListener() { // from class: com.baidu.tieba.account.ReLoginShareActivity.ReLoginAsyncTask.2
                            @Override // com.baidu.tieba.account.InputUserNameDialog.CallBackListener
                            public void callback(AccountData account) {
                                ReLoginShareActivity.this.finishActivity();
                            }
                        });
                    }
                    ReLoginShareActivity.this.mInputUserNameDialog.closeInputUserNameDialog();
                    ReLoginShareActivity.this.mInputUserNameDialog.setPhone("");
                    ReLoginShareActivity.this.mInputUserNameDialog.setAccountData(ReLoginShareActivity.this.mAccount);
                    ReLoginShareActivity.this.mInputUserNameDialog.showInputUserNameDialog();
                    ReLoginShareActivity.this.mProgressBar.setVisibility(4);
                    return;
                }
                ReLoginShareActivity.this.gotoMain();
                return;
            }
            String error = null;
            if (this.mNetwork != null) {
                error = this.mNetwork.getErrorString();
            }
            if (error == null) {
                error = ReLoginShareActivity.this.getString(R.string.data_load_error);
            }
            ReLoginShareActivity.this.switchLayout(1, error);
        }

        public boolean cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ReLoginShareActivity.this.mReloginTask = null;
            return super.cancel(true);
        }
    }
}
