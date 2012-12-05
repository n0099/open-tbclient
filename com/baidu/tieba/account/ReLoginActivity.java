package com.baidu.tieba.account;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.BaiduAccountProxy;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.InputUserNameDialog;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class ReLoginActivity extends BaseActivity {
    public static final String BDUSS = "bduss";
    public static final String CLOSE = "close";
    public static final String GOTO_VIEW = "goto_view";
    private static final int RELOADFAIL = 1;
    private static final int RELOADING = 0;
    public static final String REQUESTCODE = "request_code";
    public static final String UNAME = "uname";
    private ReLoginAsyncTask mReloginTask = null;
    private Button mRetryButton = null;
    private Button mCancelButton = null;
    private Button mBackButton = null;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private boolean mClose = false;
    private boolean isPuttingInUserName = false;
    private AccountData mAccountData = null;
    private InputUserNameDialog mInputUserNameDialog = null;
    private long startTime = 0;
    private String error = null;
    private Handler mHandler = null;
    private Runnable afterLoginRunnable = new Runnable() { // from class: com.baidu.tieba.account.ReLoginActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ReLoginActivity.this.mAccountData != null) {
                if (ReLoginActivity.this.mAccountData.getAccount() != null && !ReLoginActivity.this.mAccountData.getAccount().equals("BaiduUser")) {
                    ReLoginActivity.this.loginSucc(ReLoginActivity.this.mAccountData);
                    return;
                } else {
                    ReLoginActivity.this.fillUserName();
                    return;
                }
            }
            ReLoginActivity.this.switchLayout(1, ReLoginActivity.this.error);
        }
    };
    private View.OnClickListener backOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.account.ReLoginActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            ReLoginActivity.this.finish();
        }
    };

    public static void startActivityBaiduYi(Activity context, String goto_view, int requestCode, boolean close, AccountData accountData) {
        Intent intent = new Intent(context, ReLoginActivity.class);
        intent.putExtra("goto_view", goto_view);
        intent.putExtra("close", close);
        intent.putExtra(UNAME, accountData.getAccount());
        intent.putExtra("bduss", accountData.getBDUSS());
        context.startActivityForResult(intent, requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relogin_activity);
        this.mClose = getIntent().getBooleanExtra("close", false);
        this.mHandler = new Handler();
        initUI();
        getUid();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isPuttingInUserName) {
            BaiduAccount baiduAccount = BaiduAccount.get(this);
            String accountName = baiduAccount.getCurrentAccount();
            TiebaLog.d(getClass().getName(), "onResume", "account=" + accountName);
            if (accountName == null || accountName.equals("BaiduUser")) {
                finish();
            } else {
                this.mAccountData.setAccount(accountName);
                afterFillUName();
            }
        }
        this.isPuttingInUserName = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mReloginTask != null) {
            this.mReloginTask.cancel();
        }
        if (this.mInputUserNameDialog != null) {
            this.mInputUserNameDialog.onDestroy();
        }
        super.onDestroy();
    }

    private void afterFillUName() {
        AccountProxy proxy = new AccountProxy(this);
        proxy.getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new AccountProxy.TokenCallback() { // from class: com.baidu.tieba.account.ReLoginActivity.3
            @Override // com.baidu.account.AccountProxy.TokenCallback
            public void callBack(String token) {
                TiebaLog.d("BaiduAccountProxy", "getAccountData", "token = " + token);
                if (token != null) {
                    BaiduAccount baiduAccount = BaiduAccount.get(ReLoginActivity.this);
                    ReLoginActivity.this.BaiduReLogin(baiduAccount.getCurrentAccount(), token);
                    return;
                }
                ReLoginActivity.this.finish();
            }
        });
    }

    private void initUI() {
        this.mRetryButton = (Button) findViewById(R.id.relogin_retry_button);
        this.mRetryButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.ReLoginActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ReLoginActivity.this.getUid();
            }
        });
        this.mCancelButton = (Button) findViewById(R.id.relogin_cacel_button);
        this.mCancelButton.setOnClickListener(this.backOnClickListener);
        this.mBackButton = (Button) findViewById(R.id.relogin_bt_back);
        this.mBackButton.setOnClickListener(this.backOnClickListener);
        this.mProgressBar = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.mTextView = (TextView) findViewById(R.id.relogin_textview);
        switchLayout(0, getIntent().getStringExtra(UNAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUid() {
        if (TiebaApplication.isBaiduAccountManager()) {
            String user_id = TiebaApplication.getCurrentAccount();
            if (user_id == null || user_id.length() <= 0) {
                BaiduReLogin(getIntent().getStringExtra(UNAME), getIntent().getStringExtra("bduss"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BaiduReLogin(String uname, String bduss) {
        if (this.mReloginTask == null) {
            this.mReloginTask = new ReLoginAsyncTask(uname, bduss);
            this.mReloginTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ReLoginAsyncTask extends AsyncTask<String, Integer, AccountData> {
        private String bduss;
        private volatile NetWork mNetwork = null;
        private String uname;

        public ReLoginAsyncTask(String uname, String bduss) {
            this.uname = null;
            this.bduss = null;
            this.uname = uname;
            this.bduss = bduss;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            ReLoginActivity.this.mAccountData = null;
            ReLoginActivity.this.error = null;
            ReLoginActivity.this.startTime = System.currentTimeMillis();
            ReLoginActivity.this.switchLayout(0, ReLoginActivity.this.getIntent().getStringExtra(ReLoginActivity.UNAME));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public AccountData doInBackground(String... arg0) {
            this.mNetwork = new NetWork();
            if (this.bduss != null) {
                return BaiduAccountProxy.getAccountDataByToken(this.mNetwork, this.uname, String.valueOf(this.bduss) + '|' + ReLoginActivity.this.getBaiduAccountPtoken());
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(AccountData result) {
            super.onPostExecute((ReLoginAsyncTask) result);
            ReLoginActivity.this.mAccountData = result;
            if (this.mNetwork != null) {
                ReLoginActivity.this.error = this.mNetwork.getErrorString();
            }
            if (ReLoginActivity.this.error == null) {
                ReLoginActivity.this.error = ReLoginActivity.this.getString(R.string.data_load_error);
            }
            this.mNetwork = null;
            ReLoginActivity.this.mReloginTask = null;
            long delay = (1000 - System.currentTimeMillis()) + ReLoginActivity.this.startTime;
            if (delay <= 0) {
                delay = 0;
            }
            ReLoginActivity.this.mHandler.removeCallbacks(ReLoginActivity.this.afterLoginRunnable);
            ReLoginActivity.this.mHandler.postDelayed(ReLoginActivity.this.afterLoginRunnable, delay);
        }

        public boolean cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            ReLoginActivity.this.mReloginTask = null;
            return super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSucc(AccountData result) {
        AccountData data = TiebaApplication.getCurrentAccountObj();
        if (data == null) {
            TiebaApplication.setCurrentAccount(result);
            TiebaApplication.app.initSetting();
        } else {
            data.setID(result.getID());
            data.setTbs(result.getTbs());
            data.setBDUSS(result.getBDUSS());
        }
        DatabaseService.saveAccountData(TiebaApplication.getCurrentAccountObj());
        Handler handler = TiebaApplication.app.handler;
        if (TiebaApplication.app.getMsgFrequency() > 0) {
            handler.sendMessage(handler.obtainMessage(2));
        } else {
            handler.sendMessage(handler.obtainMessage(3));
        }
        goToMainTag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchLayout(int layoutId, String info) {
        String reLoging;
        info = (info == null || info.equals("BaiduUser")) ? "" : "";
        switch (layoutId) {
            case 0:
                this.mRetryButton.setVisibility(8);
                this.mProgressBar.setVisibility(0);
                if (TiebaApplication.isBaiduAccountManager()) {
                    reLoging = getString(R.string.relogin_yi_statement);
                } else {
                    reLoging = getString(R.string.relogin_statement);
                }
                int start = reLoging.indexOf(63);
                SpannableString loging = new SpannableString(reLoging.replace("?", info));
                loging.setSpan(new ForegroundColorSpan(Color.rgb((int) MotionEventCompat.ACTION_MASK, 47, 47)), start, info.length() + start, 33);
                this.mTextView.setTextSize(2, 16.0f);
                this.mTextView.setText(loging);
                return;
            case 1:
                this.mRetryButton.setVisibility(0);
                this.mProgressBar.setVisibility(8);
                String reloginFail = String.valueOf(getString(R.string.relogin_fail)) + "\n";
                SpannableString fail = new SpannableString(String.valueOf(reloginFail) + info);
                fail.setSpan(new ForegroundColorSpan(Color.rgb((int) MotionEventCompat.ACTION_MASK, 47, 47)), reloginFail.length(), reloginFail.length() + info.length(), 33);
                this.mTextView.setTextSize(2, 14.0f);
                this.mTextView.setText(fail);
                return;
            default:
                return;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void goToMainTag() {
        if (this.mClose) {
            TiebaApplication.app.onUserChanged();
            setResult(-1);
        } else {
            String tab = getIntent().getStringExtra("goto_view");
            MainTabActivity.startActivityOnUserChanged(this, tab);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillUserName() {
        try {
            AccountProxy mAccountProxy = new AccountProxy(this);
            mAccountProxy.startFillNameActivity(false);
            this.isPuttingInUserName = true;
        } catch (ActivityNotFoundException e) {
            TiebaLog.i(getClass().getName(), "fillUserName", e.toString());
            if (this.mInputUserNameDialog == null) {
                this.mInputUserNameDialog = new InputUserNameDialog(this);
                this.mInputUserNameDialog.setCallBackListener(new InputUserNameDialog.CallBackListener() { // from class: com.baidu.tieba.account.ReLoginActivity.5
                    @Override // com.baidu.tieba.account.InputUserNameDialog.CallBackListener
                    public void callback(AccountData account) {
                        ReLoginActivity.this.loginSucc(account);
                    }
                });
                this.mInputUserNameDialog.setCallBackCancelListener(new InputUserNameDialog.CallBackListener() { // from class: com.baidu.tieba.account.ReLoginActivity.6
                    @Override // com.baidu.tieba.account.InputUserNameDialog.CallBackListener
                    public void callback(AccountData account) {
                        ReLoginActivity.this.finish();
                    }
                });
            }
            this.mInputUserNameDialog.closeInputUserNameDialog();
            this.mInputUserNameDialog.setPhone(getString(R.string.default_username));
            this.mInputUserNameDialog.setAccountData(this.mAccountData);
            this.mInputUserNameDialog.showInputUserNameDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getBaiduAccountPtoken() {
        String[] columns = {ReLoginShareActivity.PTOKEN};
        Uri myUri = Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo");
        Cursor cur = getContentResolver().query(myUri, columns, null, null, null);
        if (cur == null || !cur.moveToFirst()) {
            return "";
        }
        String ptoken = cur.getString(cur.getColumnIndex(ReLoginShareActivity.PTOKEN));
        return ptoken;
    }
}
