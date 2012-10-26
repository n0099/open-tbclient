package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.model.LoginModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity {
    private static int RESEND_SECOND = 60;
    private Button mBack = null;
    private LinearLayout mInputSmsBg = null;
    private ImageView mButtonDelCode = null;
    private ProgressBar mProgerssBarResend = null;
    private ProgressBar mProgerssBarDone = null;
    private TextView mResendText = null;
    private TextView mErrorInfo = null;
    private EditText mEditActivation = null;
    private RelativeLayout mDone = null;
    private RelativeLayout mResend = null;
    private ResendAsyncTask mResendTask = null;
    private RegistAsyncTask mRegistTask = null;
    private boolean mIsCanResend = false;
    private int mSecond = RESEND_SECOND;
    private RegistData mData = null;
    private Handler mHandler = new Handler();
    private int mBgPaddingLeft = 0;
    private int mBgPaddingRight = 0;
    private int mErrNo = 0;
    private Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.account.ActivationActivity.1
        @Override // java.lang.Runnable
        public void run() {
            ActivationActivity activationActivity = ActivationActivity.this;
            activationActivity.mSecond--;
            if (ActivationActivity.this.mSecond <= 0) {
                ActivationActivity.this.mIsCanResend = true;
                ActivationActivity.this.mResendText.setText(ActivationActivity.this.getString(R.string.resend_code));
                if (ActivationActivity.this.mRegistTask == null) {
                    ActivationActivity.this.mResend.setEnabled(true);
                    return;
                }
                return;
            }
            String s = String.format(ActivationActivity.this.getString(R.string.resend_code_second), Integer.valueOf(ActivationActivity.this.mSecond));
            ActivationActivity.this.mResendText.setText(s);
            ActivationActivity.this.mHandler.postDelayed(ActivationActivity.this.mRunnable, 1000L);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.account.ActivationActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != ActivationActivity.this.mBack) {
                if (view != ActivationActivity.this.mDone) {
                    if (view != ActivationActivity.this.mResend) {
                        if (view == ActivationActivity.this.mButtonDelCode) {
                            ActivationActivity.this.mEditActivation.setText((CharSequence) null);
                            return;
                        }
                        return;
                    } else if (ActivationActivity.this.mIsCanResend && ActivationActivity.this.mResendTask == null && ActivationActivity.this.mRegistTask == null) {
                        ActivationActivity.this.mResendTask = new ResendAsyncTask(ActivationActivity.this, null);
                        ActivationActivity.this.mResendTask.execute(new String[0]);
                        return;
                    } else {
                        return;
                    }
                } else if (ActivationActivity.this.mRegistTask == null && ActivationActivity.this.mResendTask == null) {
                    ActivationActivity.this.mRegistTask = new RegistAsyncTask(ActivationActivity.this, null);
                    ActivationActivity.this.mRegistTask.execute(new String[0]);
                    return;
                } else {
                    return;
                }
            }
            ActivationActivity.this.setResult(0);
            ActivationActivity.this.finish();
            TiebaLog.i("ActivationActivity", "mBack", "onClick");
        }
    };
    private TextWatcher mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.account.ActivationActivity.3
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            if (s.length() == 6) {
                ActivationActivity.this.mDone.setEnabled(true);
            } else {
                ActivationActivity.this.mDone.setEnabled(false);
            }
            if (ActivationActivity.this.mErrNo != 0) {
                ActivationActivity.this.mErrNo = 0;
                ActivationActivity.this.mInputSmsBg.setBackgroundResource(R.drawable.pass_input);
                ActivationActivity.this.mInputSmsBg.setPadding(ActivationActivity.this.mBgPaddingLeft, 0, ActivationActivity.this.mBgPaddingRight, 0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    };
    private View.OnFocusChangeListener mOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.account.ActivationActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View v, boolean hasFocus) {
            if (v == ActivationActivity.this.mEditActivation) {
                if (hasFocus) {
                    ActivationActivity.this.mButtonDelCode.setVisibility(0);
                } else {
                    ActivationActivity.this.mButtonDelCode.setVisibility(8);
                }
            }
        }
    };

    public static void startActivityForResult(Activity activity, RegistData data, int requestCode) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", data);
        activity.startActivityForResult(intent, requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_register_activation);
        initData(savedInstanceState);
        initUI();
        startCountDown();
    }

    private void initData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mData = (RegistData) savedInstanceState.getSerializable("data");
        } else {
            Intent intent = getIntent();
            this.mData = (RegistData) intent.getSerializableExtra("data");
        }
        if (this.mData == null) {
            setResult(0);
            finish();
        } else if (this.mData.getSmsCodeTime() > 0) {
            RESEND_SECOND = this.mData.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.mData = (RegistData) savedInstanceState.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("data", this.mData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.mResendTask != null) {
            this.mResendTask.cancel();
        }
        if (this.mRegistTask != null) {
            this.mRegistTask.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCountDown() {
        this.mIsCanResend = false;
        this.mResend.setEnabled(false);
        this.mSecond = RESEND_SECOND;
        String s = String.format(getString(R.string.resend_code_second), Integer.valueOf(this.mSecond));
        this.mResendText.setText(s);
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.mBack = (Button) findViewById(R.id.back);
        this.mDone = (RelativeLayout) findViewById(R.id.done);
        this.mDone.setEnabled(false);
        this.mResend = (RelativeLayout) findViewById(R.id.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mDone.setOnClickListener(this.mOnClickListener);
        this.mResend.setOnClickListener(this.mOnClickListener);
        this.mResendText = (TextView) findViewById(R.id.resend_text);
        this.mEditActivation = (EditText) findViewById(R.id.edit_code);
        this.mEditActivation.addTextChangedListener(this.mTextWatcher);
        this.mEditActivation.setOnFocusChangeListener(this.mOnFocusChangeListener);
        this.mProgerssBarResend = (ProgressBar) findViewById(R.id.progress_resend);
        this.mProgerssBarDone = (ProgressBar) findViewById(R.id.progress_done);
        this.mButtonDelCode = (ImageView) findViewById(R.id.del_code);
        this.mButtonDelCode.setOnClickListener(this.mOnClickListener);
        this.mErrorInfo = (TextView) findViewById(R.id.text_error);
        this.mInputSmsBg = (LinearLayout) findViewById(R.id.sms_code_input_bg);
        this.mBgPaddingLeft = this.mInputSmsBg.getPaddingLeft();
        this.mBgPaddingRight = this.mInputSmsBg.getPaddingRight();
        this.mInputSmsBg.setBackgroundResource(R.drawable.pass_input);
        this.mInputSmsBg.setPadding(this.mBgPaddingLeft, 0, this.mBgPaddingRight, 0);
        ShowSoftKeyPadDelay(this.mEditActivation, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableInput(boolean enabled) {
        this.mEditActivation.setEnabled(enabled);
        this.mEditActivation.setFocusable(enabled);
        this.mEditActivation.setFocusableInTouchMode(enabled);
        this.mButtonDelCode.setEnabled(enabled);
        if (enabled) {
            this.mEditActivation.setTextColor(getResources().getColor(R.color.reg_font_color));
        } else {
            this.mEditActivation.setTextColor(getResources().getColor(R.color.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registSucc(LoginModel data) {
        AccountData account = new AccountData();
        account.setAccount(data.getUser().getName());
        account.setPassword(this.mData.getPsw());
        account.setID(data.getUser().getId());
        account.setBDUSS(data.getUser().getBDUSS());
        account.setIsActive(1);
        if (data.getAnti() != null) {
            account.setTbs(data.getAnti().getTbs());
        }
        DatabaseService.saveAccountData(account);
        TiebaApplication.setCurrentAccountObj(account);
        setResult(-1);
        finish();
    }

    /* loaded from: classes.dex */
    private class RegistAsyncTask extends AsyncTask<String, Integer, LoginModel> {
        private NetWork mNetWork;

        private RegistAsyncTask() {
            this.mNetWork = null;
        }

        /* synthetic */ RegistAsyncTask(ActivationActivity activationActivity, RegistAsyncTask registAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public LoginModel doInBackground(String... params) {
            try {
                this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/s/regreal");
                this.mNetWork.addPostData("un", ActivationActivity.this.mData.getName());
                this.mNetWork.addPostData("phonenum", ActivationActivity.this.mData.getPhone());
                this.mNetWork.addPostData("passwd", ActivationActivity.this.mData.getPsw());
                if (ActivationActivity.this.mData.getVcode() != null) {
                    this.mNetWork.addPostData("vcode", ActivationActivity.this.mData.getVcode());
                }
                if (ActivationActivity.this.mData.getVcodeMd5() != null) {
                    this.mNetWork.addPostData("vcode_md5", ActivationActivity.this.mData.getVcodeMd5());
                }
                this.mNetWork.addPostData("smscode", ActivationActivity.this.mEditActivation.getText().toString());
                String ret = this.mNetWork.postNetData();
                if (!this.mNetWork.isRequestSuccess()) {
                    return null;
                }
                LoginModel result = new LoginModel();
                try {
                    result.parserJson(ret);
                    return result;
                } catch (Exception e) {
                    ex = e;
                    TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                    return null;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(LoginModel result) {
            super.onPostExecute((RegistAsyncTask) result);
            ActivationActivity.this.mProgerssBarDone.setVisibility(8);
            ActivationActivity.this.mRegistTask = null;
            ActivationActivity.this.enableInput(true);
            if (ActivationActivity.this.mIsCanResend) {
                ActivationActivity.this.mResend.setEnabled(true);
            }
            if (result != null) {
                ActivationActivity.this.registSucc(result);
                return;
            }
            String error = this.mNetWork.getErrorString();
            if (error != null && error.length() > 0) {
                ActivationActivity.this.mErrorInfo.setVisibility(0);
                ActivationActivity.this.mErrorInfo.setText(error);
            }
            if (this.mNetWork.getErrorCode() == 26) {
                ActivationActivity.this.mErrNo = 26;
                ActivationActivity.this.mInputSmsBg.setBackgroundResource(R.drawable.pass_input_wrong);
                ActivationActivity.this.mInputSmsBg.setPadding(ActivationActivity.this.mBgPaddingLeft, 0, ActivationActivity.this.mBgPaddingRight, 0);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            ActivationActivity.this.mProgerssBarDone.setVisibility(0);
            ActivationActivity.this.mResend.setEnabled(false);
            ActivationActivity.this.enableInput(false);
            ActivationActivity.this.mErrorInfo.setVisibility(4);
            ActivationActivity.this.mErrorInfo.setText((CharSequence) null);
            ActivationActivity.this.mInputSmsBg.setBackgroundResource(R.drawable.pass_input);
            ActivationActivity.this.mInputSmsBg.setPadding(ActivationActivity.this.mBgPaddingLeft, 0, ActivationActivity.this.mBgPaddingRight, 0);
            super.onPreExecute();
        }

        public void cancel() {
            ActivationActivity.this.mRegistTask = null;
            ActivationActivity.this.mProgerssBarDone.setVisibility(8);
            if (ActivationActivity.this.mIsCanResend) {
                ActivationActivity.this.mResend.setEnabled(true);
            }
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            ActivationActivity.this.enableInput(true);
            super.cancel(true);
        }
    }

    /* loaded from: classes.dex */
    private class ResendAsyncTask extends AsyncTask<String, Integer, Boolean> {
        private NetWork mNetWork;

        private ResendAsyncTask() {
            this.mNetWork = null;
        }

        /* synthetic */ ResendAsyncTask(ActivationActivity activationActivity, ResendAsyncTask resendAsyncTask) {
            this();
        }

        public void cancel() {
            ActivationActivity.this.mResendTask = null;
            ActivationActivity.this.mProgerssBarResend.setVisibility(8);
            if (ActivationActivity.this.mEditActivation.length() == 6) {
                ActivationActivity.this.mDone.setEnabled(true);
            }
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... arg0) {
            boolean ret = false;
            try {
                this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/s/getsmscode");
                this.mNetWork.addPostData("phonenum", ActivationActivity.this.mData.getPhone());
                this.mNetWork.postNetData();
                if (this.mNetWork.isRequestSuccess()) {
                    ret = true;
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
            }
            return Boolean.valueOf(ret);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            super.onPostExecute((ResendAsyncTask) result);
            ActivationActivity.this.mResendTask = null;
            ActivationActivity.this.mProgerssBarResend.setVisibility(8);
            if (ActivationActivity.this.mEditActivation.length() == 6) {
                ActivationActivity.this.mDone.setEnabled(true);
            }
            if (result.booleanValue()) {
                ActivationActivity.this.startCountDown();
                return;
            }
            String error = this.mNetWork.getErrorString();
            if (error != null && error.length() > 0) {
                ActivationActivity.this.mErrorInfo.setVisibility(0);
                ActivationActivity.this.mErrorInfo.setText(error);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            ActivationActivity.this.mProgerssBarResend.setVisibility(0);
            ActivationActivity.this.mErrorInfo.setVisibility(4);
            ActivationActivity.this.mErrorInfo.setText((CharSequence) null);
            ActivationActivity.this.mDone.setEnabled(false);
            super.onPreExecute();
        }
    }
}
