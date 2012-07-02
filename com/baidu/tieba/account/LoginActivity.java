package com.baidu.tieba.account;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.CheckUserNameData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.VcodeInfoData;
import com.baidu.tieba.model.LoginModel;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkErr;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity {
    public static final String ACCOUNT = "account";
    public static final String HAS_EXIT_DIALOG = "has_exit_dialog";
    public static final String TYPE_LOGIN = "type_login";
    private static final int TYPE_LOGIN_MOBILE = 1;
    private static final int TYPE_LOGIN_NORMAL = 0;
    private Account mMobileAccount;
    private Account mNormalAccount;
    public static int REQUEST_VCODE = 100;
    public static int REQUEST_REGIST = 101;
    public static int RESULT_LOGIN_ERR = 500;
    private String mAccount = null;
    private String mPassword = null;
    private String mVcodeMd5 = null;
    private String mVcodeUrl = null;
    private int mLoginType = 0;
    private boolean mHasExitDialog = true;
    private boolean mIsVcodeShown = false;
    private boolean mIsInputCorrect = true;
    private EditText mEditAccount = null;
    private EditText mEditPassword = null;
    private EditText mEditVcode = null;
    private View mLayoutLogin = null;
    private Button mButtonRegedit = null;
    private ImageView mImageVcode = null;
    private ImageView mImageVcode1 = null;
    private ImageView mImageVcode2 = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar mLoginProgressBar = null;
    private Button mButtonRefreshVcode = null;
    private Button mButtonBack = null;
    private View mLayoutAccount = null;
    private View mLayoutPassword = null;
    private View mLayoutVcode = null;
    private Button mButtonAccountDel = null;
    private Button mButtonPassDel = null;
    private Button mButtonVcodeDel = null;
    private TextView mTextAccountTitle = null;
    private TextView mTextError = null;
    private TextView mTextLogin = null;
    private Button mButtonNormal = null;
    private Button mButtonMobile = null;
    private LoginAsyncTask mTask = null;
    private LoginModel mModel = null;
    private GetImageTask mGetImageTask = null;
    InputMethodManager mInputManager = null;
    private InputUserNameAsyncTask mUserNameTask = null;
    private CheckUserNameAsyncTask mCheckUserNameTask = null;
    private Button mCheckUserName = null;
    private Button mConfirm = null;
    private Button mBack = null;
    private ProgressBar mCheckProgress = null;
    private ProgressBar mConfirmProgress = null;
    private TextView mErrorInfo = null;
    private EditText mUserNameEditor = null;
    private RadioGroup mRadioGroup = null;
    private CompoundButton.OnCheckedChangeListener mRadioButtonCheckedListener = null;
    private RadioButton mRadioButton1 = null;
    private RadioButton mRadioButton2 = null;
    private RadioButton mRadioButton3 = null;
    private TextView mPhoneText = null;
    private View mInputUserNameView = null;
    private Dialog mInputUserNameDialog = null;
    private AccountData mAccountData = null;

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
            this.mLoginType = savedInstanceState.getInt(TYPE_LOGIN);
        } else {
            Intent intent = getIntent();
            account = intent.getStringExtra(ACCOUNT);
            this.mHasExitDialog = intent.getBooleanExtra(HAS_EXIT_DIALOG, true);
            this.mLoginType = 0;
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
        if (this.mLoginType == 0) {
            switchTab(R.id.normal_login);
        }
        if (this.mLoginType == 1) {
            switchTab(R.id.mobile_login);
        }
        ShowSoftKeyPadDelay(this.mEditAccount, Config.PB_IMAGE_MAX_WIDTH);
        PvThread pv = new PvThread(Config.ST_TYPE_LOGIN);
        pv.start();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(HAS_EXIT_DIALOG, this.mHasExitDialog);
        savedInstanceState.putInt(TYPE_LOGIN, this.mLoginType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(HAS_EXIT_DIALOG, this.mHasExitDialog);
        outState.putInt(TYPE_LOGIN, this.mLoginType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            cancelAsyncTask();
            System.gc();
        } catch (Exception e) {
        }
        if (this.mUserNameTask != null) {
            this.mUserNameTask.cancel();
            this.mUserNameTask = null;
        }
        if (this.mCheckUserNameTask != null) {
            this.mCheckUserNameTask.cancel();
            this.mCheckUserNameTask = null;
        }
        closeInputUserNameDialog();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (this.mInputUserNameDialog == null || !this.mInputUserNameDialog.isShowing()) {
            ShowSoftKeyPadDelay(this.mEditAccount, Config.PB_IMAGE_MAX_WIDTH);
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMainTag() {
        MainTabActivity.startActivityOnUserChanged(this, null);
        finish();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.mEditAccount = (EditText) findViewById(R.id.login_edit_account);
        this.mEditPassword = (EditText) findViewById(R.id.login_edit_password);
        this.mEditVcode = (EditText) findViewById(R.id.edit_vcode);
        this.mLayoutAccount = findViewById(R.id.layout_account);
        this.mLayoutPassword = findViewById(R.id.layout_password);
        this.mLayoutVcode = findViewById(R.id.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(R.id.image_progress);
        this.mImageVcode1 = (ImageView) findViewById(R.id.image_vcode1);
        this.mImageVcode2 = (ImageView) findViewById(R.id.image_vcode2);
        this.mImageVcode = this.mImageVcode1;
        this.mLoginProgressBar = (ProgressBar) findViewById(R.id.progress_login);
        this.mButtonRefreshVcode = (Button) findViewById(R.id.button_vcode_refresh);
        this.mButtonAccountDel = (Button) findViewById(R.id.button_account_del);
        this.mButtonPassDel = (Button) findViewById(R.id.button_pass_del);
        this.mButtonVcodeDel = (Button) findViewById(R.id.button_vcode_del);
        this.mTextAccountTitle = (TextView) findViewById(R.id.text_title_account);
        this.mTextError = (TextView) findViewById(R.id.text_error);
        this.mTextLogin = (TextView) findViewById(R.id.text_login);
        this.mButtonNormal = (Button) findViewById(R.id.normal_login);
        this.mButtonMobile = (Button) findViewById(R.id.mobile_login);
        View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.account.LoginActivity.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    switch (v.getId()) {
                        case R.id.login_edit_account /* 2131361811 */:
                            LoginActivity.this.mButtonPassDel.setVisibility(8);
                            LoginActivity.this.mButtonAccountDel.setVisibility(0);
                            LoginActivity.this.mButtonVcodeDel.setVisibility(8);
                            return;
                        case R.id.login_edit_password /* 2131361815 */:
                            LoginActivity.this.mButtonPassDel.setVisibility(0);
                            LoginActivity.this.mButtonAccountDel.setVisibility(8);
                            LoginActivity.this.mButtonVcodeDel.setVisibility(8);
                            return;
                        case R.id.edit_vcode /* 2131361818 */:
                            LoginActivity.this.mButtonPassDel.setVisibility(8);
                            LoginActivity.this.mButtonAccountDel.setVisibility(8);
                            LoginActivity.this.mButtonVcodeDel.setVisibility(0);
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        this.mEditAccount.setOnFocusChangeListener(focusChangeListener);
        this.mEditPassword.setOnFocusChangeListener(focusChangeListener);
        this.mEditVcode.setOnFocusChangeListener(focusChangeListener);
        TextView.OnEditorActionListener actionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.account.LoginActivity.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((LoginActivity.this.mLayoutVcode.getVisibility() == 8 && actionId == 4) || (LoginActivity.this.mLayoutVcode.getVisibility() == 0 && actionId == 6)) {
                    LoginActivity.this.login();
                    return true;
                }
                return false;
            }
        };
        this.mEditPassword.setOnEditorActionListener(actionListener);
        this.mEditVcode.setOnEditorActionListener(actionListener);
        this.mEditAccount.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.account.LoginActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (LoginActivity.this.mIsVcodeShown) {
                    LoginActivity.this.hideVcode();
                }
                LoginActivity.this.mIsInputCorrect = true;
                LoginActivity.this.setEditBg();
                LoginActivity.this.cancelAsyncTask();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                LoginActivity.this.validateLogin();
                if (StringHelper.isEmpty(LoginActivity.this.mAccount) || !s.toString().equals(LoginActivity.this.mAccount)) {
                    return;
                }
                LoginActivity.this.showVcode();
            }
        });
        this.mEditPassword.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.account.LoginActivity.4
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LoginActivity.this.mIsInputCorrect = true;
                LoginActivity.this.setEditBg();
                LoginActivity.this.cancelAsyncTask();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                LoginActivity.this.validateLogin();
            }
        });
        this.mEditVcode.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.account.LoginActivity.5
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LoginActivity.this.mIsInputCorrect = true;
                LoginActivity.this.setEditBg();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                LoginActivity.this.validateLogin();
            }
        });
        this.mLayoutLogin = findViewById(R.id.layout_login);
        this.mLayoutLogin.setEnabled(false);
        this.mButtonRegedit = (Button) findViewById(R.id.login_bt_reg);
        this.mLayoutLogin.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.LoginActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LoginActivity.this.login();
            }
        });
        this.mButtonRegedit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.LoginActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LoginActivity.this.cancelAsyncTask();
                LoginActivity.this.HidenSoftKeyPad(LoginActivity.this.mInputManager, LoginActivity.this.mEditAccount);
                LoginActivity.this.HidenSoftKeyPad(LoginActivity.this.mInputManager, LoginActivity.this.mEditPassword);
                Register2Activity.startActivityForResult(LoginActivity.this, LoginActivity.REQUEST_REGIST);
            }
        });
        this.mButtonBack = (Button) findViewById(R.id.back);
        this.mButtonBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.LoginActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
        hideVcode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateLogin() {
        boolean isEmpty;
        String account = this.mEditAccount.getText().toString();
        String pass = this.mEditPassword.getText().toString();
        String vcode = this.mEditVcode.getText().toString();
        if (this.mLayoutVcode.getVisibility() == 8) {
            isEmpty = StringHelper.isEmpty(account) || StringHelper.isEmpty(pass);
        } else {
            isEmpty = StringHelper.isEmpty(account) || StringHelper.isEmpty(pass) || StringHelper.isEmpty(vcode);
        }
        if (!isEmpty) {
            this.mLayoutLogin.setEnabled(true);
        } else {
            this.mLayoutLogin.setEnabled(false);
        }
    }

    private void switchTab(int id) {
        View normal = findViewById(R.id.normal_login);
        View mobile = findViewById(R.id.mobile_login);
        switch (id) {
            case R.id.normal_login /* 2131361805 */:
                this.mImageVcode = this.mImageVcode1;
                this.mImageVcode1.setVisibility(0);
                this.mImageVcode2.setVisibility(8);
                saveAccount();
                this.mLoginType = 0;
                restoreAccount();
                this.mEditAccount.setHint(R.string.account_hint_normal);
                normal.setBackgroundResource(R.drawable.login_tab_pressed);
                mobile.setBackgroundResource(R.drawable.login_tab_normal);
                this.mTextAccountTitle.setText(R.string.account_account);
                this.mEditAccount.requestFocus();
                this.mButtonNormal.setTextColor(Color.rgb(50, 137, 203));
                this.mButtonMobile.setTextColor(-16777216);
                this.mEditAccount.setInputType(1);
                return;
            case R.id.mobile_login /* 2131361806 */:
                this.mImageVcode = this.mImageVcode2;
                this.mImageVcode1.setVisibility(8);
                this.mImageVcode2.setVisibility(0);
                saveAccount();
                this.mLoginType = 1;
                restoreAccount();
                this.mEditAccount.setHint(R.string.account_mobile);
                mobile.setBackgroundResource(R.drawable.login_tab_pressed);
                normal.setBackgroundResource(R.drawable.login_tab_normal);
                this.mTextAccountTitle.setText(R.string.account_mobile);
                this.mEditAccount.requestFocus();
                this.mButtonMobile.setTextColor(Color.rgb(50, 137, 203));
                this.mButtonNormal.setTextColor(-16777216);
                this.mEditAccount.setInputType(3);
                return;
            default:
                return;
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.normal_login /* 2131361805 */:
            case R.id.mobile_login /* 2131361806 */:
                switchTab(v.getId());
                return;
            case R.id.text_error /* 2131361807 */:
            case R.id.layout_account /* 2131361808 */:
            case R.id.text_title_account /* 2131361809 */:
            case R.id.text_title_vcode /* 2131361810 */:
            case R.id.login_edit_account /* 2131361811 */:
            case R.id.layout_password /* 2131361813 */:
            case R.id.text_title_password /* 2131361814 */:
            case R.id.login_edit_password /* 2131361815 */:
            case R.id.layout_vcode /* 2131361817 */:
            case R.id.edit_vcode /* 2131361818 */:
            case R.id.image_progress /* 2131361822 */:
            default:
                return;
            case R.id.button_account_del /* 2131361812 */:
                this.mEditAccount.setText((CharSequence) null);
                return;
            case R.id.button_pass_del /* 2131361816 */:
                this.mEditPassword.setText((CharSequence) null);
                return;
            case R.id.button_vcode_del /* 2131361819 */:
                this.mEditVcode.setText((CharSequence) null);
                return;
            case R.id.image_vcode1 /* 2131361820 */:
            case R.id.image_vcode2 /* 2131361821 */:
            case R.id.button_vcode_refresh /* 2131361823 */:
                refreshImage(this.mVcodeUrl);
                return;
        }
    }

    private void restoreAccount() {
        if (this.mLoginType == 0) {
            if (this.mNormalAccount == null) {
                this.mAccount = null;
                this.mEditAccount.setText((CharSequence) null);
                this.mEditPassword.setText((CharSequence) null);
                this.mEditVcode.setText((CharSequence) null);
                this.mLayoutVcode.setVisibility(8);
                this.mTextError.setVisibility(4);
                this.mIsInputCorrect = true;
                this.mIsVcodeShown = false;
            } else {
                this.mAccount = this.mNormalAccount.mAccount;
                this.mEditAccount.setText(this.mNormalAccount.mAccount);
                this.mEditPassword.setText(this.mNormalAccount.mPassword);
                this.mEditVcode.setText(this.mNormalAccount.mVcode);
                this.mTextError.setText(this.mNormalAccount.mError);
                this.mLayoutVcode.setVisibility(this.mNormalAccount.mVcodeVisibility);
                this.mTextError.setVisibility(this.mNormalAccount.mErrorVisibility);
                this.mIsInputCorrect = this.mNormalAccount.mIsInputCorrect;
                this.mIsVcodeShown = this.mNormalAccount.mVcodeVisibility == 0;
            }
        }
        if (this.mLoginType == 1) {
            if (this.mMobileAccount == null) {
                this.mAccount = null;
                this.mEditAccount.setText((CharSequence) null);
                this.mEditPassword.setText((CharSequence) null);
                this.mEditVcode.setText((CharSequence) null);
                this.mLayoutVcode.setVisibility(8);
                this.mTextError.setVisibility(4);
                this.mIsInputCorrect = true;
                this.mIsVcodeShown = false;
            } else {
                this.mAccount = this.mMobileAccount.mAccount;
                this.mEditAccount.setText(this.mMobileAccount.mAccount);
                this.mEditPassword.setText(this.mMobileAccount.mPassword);
                this.mEditVcode.setText(this.mMobileAccount.mVcode);
                this.mTextError.setText(this.mMobileAccount.mError);
                this.mLayoutVcode.setVisibility(this.mMobileAccount.mVcodeVisibility);
                this.mTextError.setVisibility(this.mMobileAccount.mErrorVisibility);
                this.mIsInputCorrect = this.mMobileAccount.mIsInputCorrect;
                this.mIsVcodeShown = this.mMobileAccount.mVcodeVisibility == 0;
            }
        }
        setEditBg();
        validateLogin();
    }

    private void saveAccount() {
        if (this.mLoginType == 0) {
            this.mNormalAccount = new Account(this, null);
            this.mNormalAccount.mAccount = this.mEditAccount.getText().toString();
            this.mNormalAccount.mPassword = this.mEditPassword.getText().toString();
            this.mNormalAccount.mVcode = this.mEditVcode.getText().toString();
            this.mNormalAccount.mError = this.mTextError.getText().toString();
            this.mNormalAccount.mVcodeVisibility = this.mLayoutVcode.getVisibility();
            this.mNormalAccount.mErrorVisibility = this.mTextError.getVisibility();
            this.mNormalAccount.mIsInputCorrect = this.mIsInputCorrect;
        }
        if (this.mLoginType == 1) {
            this.mMobileAccount = new Account(this, null);
            this.mMobileAccount.mAccount = this.mEditAccount.getText().toString();
            this.mMobileAccount.mPassword = this.mEditPassword.getText().toString();
            this.mMobileAccount.mVcode = this.mEditVcode.getText().toString();
            this.mMobileAccount.mError = this.mTextError.getText().toString();
            this.mMobileAccount.mVcodeVisibility = this.mLayoutVcode.getVisibility();
            this.mMobileAccount.mErrorVisibility = this.mTextError.getVisibility();
            this.mMobileAccount.mIsInputCorrect = this.mIsInputCorrect;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        if (this.mTask == null) {
            String account = this.mEditAccount.getText().toString();
            String password = this.mEditPassword.getText().toString();
            this.mPassword = StringHelper.base64Encode(password.getBytes());
            if (account.length() > 0 && this.mPassword.length() > 0) {
                if (this.mIsVcodeShown) {
                    String vcode = this.mEditVcode.getText().toString();
                    if (StringHelper.isEmpty(vcode)) {
                        return;
                    }
                }
                disableViews();
                StringBuffer address = new StringBuffer(30);
                address.append(Config.SERVER_ADDRESS);
                address.append(Config.LOGIN_ADDRESS);
                ArrayList<BasicNameValuePair> param = new ArrayList<>();
                BasicNameValuePair tmp = new BasicNameValuePair("un", account);
                param.add(tmp);
                BasicNameValuePair tmp2 = new BasicNameValuePair("passwd", this.mPassword);
                param.add(tmp2);
                BasicNameValuePair tmp3 = new BasicNameValuePair("isphone", String.valueOf(this.mLoginType));
                param.add(tmp3);
                if (this.mLayoutVcode != null && this.mLayoutVcode.getVisibility() == 0) {
                    BasicNameValuePair tmp4 = new BasicNameValuePair("vcode", this.mEditVcode.getText().toString());
                    param.add(tmp4);
                    BasicNameValuePair tmp5 = new BasicNameValuePair("vcode_md5", this.mVcodeMd5);
                    param.add(tmp5);
                }
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
        this.mAccountData = account;
        if (this.mAccountData.getAccount() != null) {
            DatabaseService.saveAccountData(account);
            TiebaApplication.setCurrentAccountObj(this.mAccountData);
            goToMainTag();
            return;
        }
        showInputUserNameDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginFail() {
        this.mIsInputCorrect = false;
        setEditBg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImage(String url) {
        if (this.mGetImageTask != null) {
            this.mGetImageTask.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImageVcode.setImageBitmap(null);
        cancelAsyncTask();
        this.mGetImageTask = new GetImageTask(this, null);
        this.mGetImageTask.execute(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showVcode() {
        this.mIsVcodeShown = true;
        this.mLayoutVcode.setVisibility(0);
        this.mEditVcode.setText((CharSequence) null);
        if (this.mIsInputCorrect) {
            this.mLayoutPassword.setBackgroundResource(R.drawable.login_input_middle);
        } else {
            this.mLayoutPassword.setBackgroundResource(R.drawable.login_input_middlewrong);
        }
        validateLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideVcode() {
        this.mIsVcodeShown = false;
        this.mLayoutVcode.setVisibility(8);
        if (this.mIsInputCorrect) {
            this.mLayoutPassword.setBackgroundResource(R.drawable.login_input_under);
        } else {
            this.mLayoutPassword.setBackgroundResource(R.drawable.login_input_underwrong);
        }
        validateLogin();
    }

    private void disableViews() {
        this.mEditAccount.setEnabled(false);
        this.mEditPassword.setEnabled(false);
        this.mEditVcode.setEnabled(false);
        this.mButtonRefreshVcode.setEnabled(false);
        this.mImageVcode.setEnabled(false);
        this.mButtonAccountDel.setEnabled(false);
        this.mButtonPassDel.setEnabled(false);
        this.mButtonVcodeDel.setEnabled(false);
        this.mButtonNormal.setEnabled(false);
        this.mButtonMobile.setEnabled(false);
        this.mEditAccount.setTextColor(Color.rgb(136, 136, 136));
        this.mEditPassword.setTextColor(Color.rgb(136, 136, 136));
        this.mEditVcode.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableViews() {
        this.mEditAccount.setEnabled(true);
        this.mEditPassword.setEnabled(true);
        this.mEditVcode.setEnabled(true);
        this.mButtonRefreshVcode.setEnabled(true);
        this.mImageVcode.setEnabled(true);
        this.mButtonAccountDel.setEnabled(true);
        this.mButtonPassDel.setEnabled(true);
        this.mButtonVcodeDel.setEnabled(true);
        this.mButtonNormal.setEnabled(true);
        this.mButtonMobile.setEnabled(true);
        this.mEditAccount.setTextColor(-16777216);
        this.mEditPassword.setTextColor(-16777216);
        this.mEditVcode.setTextColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEditBg() {
        if (this.mIsInputCorrect) {
            this.mLayoutAccount.setBackgroundResource(R.drawable.login_input_top);
            if (this.mIsVcodeShown) {
                this.mLayoutPassword.setBackgroundResource(R.drawable.login_input_middle);
            } else {
                this.mLayoutPassword.setBackgroundResource(R.drawable.login_input_under);
            }
            this.mLayoutVcode.setBackgroundResource(R.drawable.login_input_under);
            return;
        }
        this.mLayoutAccount.setBackgroundResource(R.drawable.login_input_topwrong);
        if (this.mIsVcodeShown) {
            this.mLayoutPassword.setBackgroundResource(R.drawable.login_input_middlewrong);
        } else {
            this.mLayoutPassword.setBackgroundResource(R.drawable.login_input_underwrong);
        }
        this.mLayoutVcode.setBackgroundResource(R.drawable.login_input_underwrong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAsyncTask() {
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
        if (this.mGetImageTask != null) {
            this.mGetImageTask.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInputUserNameError(String str) {
        if (str == null) {
            this.mErrorInfo.setVisibility(8);
            this.mErrorInfo.setText((CharSequence) null);
            return;
        }
        this.mErrorInfo.setVisibility(0);
        this.mErrorInfo.setText(str);
    }

    private void showInputUserNameDialog() {
        if (this.mInputUserNameDialog == null) {
            LayoutInflater mInflater = getLayoutInflater();
            this.mInputUserNameView = mInflater.inflate(R.layout.main_input_username, (ViewGroup) null);
            this.mUserNameEditor = (EditText) this.mInputUserNameView.findViewById(R.id.account);
            this.mUserNameEditor.setHint(String.valueOf(getString(R.string.input_name)) + ":");
            this.mBack = (Button) this.mInputUserNameView.findViewById(R.id.back);
            this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.LoginActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    LoginActivity.this.closeInputUserNameDialog();
                }
            });
            this.mCheckUserName = (Button) this.mInputUserNameView.findViewById(R.id.check_username);
            this.mCheckUserName.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.LoginActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    String account = LoginActivity.this.mUserNameEditor.getText().toString();
                    if (account != null && account.length() > 0) {
                        if (LoginActivity.this.mUserNameTask == null && LoginActivity.this.mCheckUserNameTask == null) {
                            LoginActivity.this.mCheckUserNameTask = new CheckUserNameAsyncTask("http://c.tieba.baidu.com/c/s/detectuname", account);
                            LoginActivity.this.mCheckUserNameTask.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    LoginActivity.this.showInputUserNameError(LoginActivity.this.getString(R.string.input_name));
                }
            });
            this.mCheckProgress = (ProgressBar) this.mInputUserNameView.findViewById(R.id.check_progress);
            this.mConfirm = (Button) this.mInputUserNameView.findViewById(R.id.confirm);
            this.mConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.LoginActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    String account = LoginActivity.this.mUserNameEditor.getText().toString();
                    if (account != null && account.length() > 0) {
                        if (LoginActivity.this.mCheckUserNameTask != null) {
                            LoginActivity.this.mCheckUserNameTask.cancel();
                        }
                        if (LoginActivity.this.mUserNameTask == null) {
                            LoginActivity.this.mUserNameTask = new InputUserNameAsyncTask("http://c.tieba.baidu.com/c/s/filluname", account);
                            LoginActivity.this.mUserNameTask.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    LoginActivity.this.showInputUserNameError(LoginActivity.this.getString(R.string.input_name));
                }
            });
            this.mConfirmProgress = (ProgressBar) this.mInputUserNameView.findViewById(R.id.confirm_progress);
            this.mErrorInfo = (TextView) this.mInputUserNameView.findViewById(R.id.error_info);
            this.mRadioGroup = (RadioGroup) this.mInputUserNameView.findViewById(R.id.names_group);
            this.mRadioButton1 = (RadioButton) this.mInputUserNameView.findViewById(R.id.name1);
            this.mRadioButton2 = (RadioButton) this.mInputUserNameView.findViewById(R.id.name2);
            this.mRadioButton3 = (RadioButton) this.mInputUserNameView.findViewById(R.id.name3);
            this.mRadioButtonCheckedListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.account.LoginActivity.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        LoginActivity.this.mUserNameEditor.setText(buttonView.getText());
                    }
                }
            };
            this.mRadioButton1.setOnCheckedChangeListener(this.mRadioButtonCheckedListener);
            this.mRadioButton2.setOnCheckedChangeListener(this.mRadioButtonCheckedListener);
            this.mRadioButton3.setOnCheckedChangeListener(this.mRadioButtonCheckedListener);
            this.mPhoneText = (TextView) this.mInputUserNameView.findViewById(R.id.phone_info);
            initSuggestNames();
            this.mInputUserNameDialog = new Dialog(this, R.style.input_username_dialog);
            this.mInputUserNameDialog.setCanceledOnTouchOutside(false);
            this.mInputUserNameDialog.getWindow().setSoftInputMode(20);
        }
        if (!this.mInputUserNameDialog.isShowing()) {
            this.mUserNameEditor.setText((CharSequence) null);
            initSuggestNames();
            showInputUserNameError(null);
            this.mPhoneText.setText("Hi," + this.mEditAccount.getText().toString());
            this.mInputUserNameDialog.show();
            this.mInputUserNameDialog.setContentView(this.mInputUserNameView);
            WindowManager.LayoutParams wmParams = this.mInputUserNameDialog.getWindow().getAttributes();
            wmParams.gravity = 51;
            wmParams.x = 0;
            wmParams.y = 0;
            wmParams.width = -1;
            wmParams.height = -1;
            this.mInputUserNameDialog.getWindow().setAttributes(wmParams);
            ShowSoftKeyPadDelay(this.mUserNameEditor, Config.PB_IMAGE_MAX_WIDTH);
            this.mUserNameEditor.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInputUserNameDialog() {
        if (this.mInputUserNameDialog != null && this.mInputUserNameDialog.isShowing()) {
            this.mInputUserNameDialog.dismiss();
        }
    }

    public void setSuggestNames(ArrayList<String> names) {
        int size;
        if (names != null && (size = names.size()) > 0) {
            this.mRadioGroup.setVisibility(0);
            if (size > 0 && names.get(0) != null) {
                this.mRadioButton1.setText(names.get(0));
                this.mRadioButton1.setVisibility(0);
            }
            if (size > 1 && names.get(1) != null) {
                this.mRadioButton2.setText(names.get(1));
                this.mRadioButton2.setVisibility(0);
            }
            if (size > 2 && names.get(2) != null) {
                this.mRadioButton3.setText(names.get(2));
                this.mRadioButton3.setVisibility(0);
            }
        }
    }

    public void initSuggestNames() {
        this.mRadioGroup.setVisibility(8);
        this.mRadioGroup.clearCheck();
        this.mRadioButton1.setVisibility(8);
        this.mRadioButton2.setVisibility(8);
        this.mRadioButton3.setVisibility(8);
        this.mRadioButton1.setChecked(false);
        this.mRadioButton2.setChecked(false);
        this.mRadioButton3.setChecked(false);
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
            LoginActivity.this.mLoginProgressBar.setVisibility(0);
            LoginActivity.this.mTextError.setVisibility(4);
            LoginActivity.this.mTextLogin.setText(R.string.account_login_loading);
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
            LoginActivity.this.mLoginProgressBar.setVisibility(8);
            LoginActivity.this.mTextLogin.setText(R.string.account_login);
            LoginActivity.this.enableViews();
            if (data != null) {
                LoginActivity.this.mModel = data;
                LoginActivity.this.loginSucc();
            } else if (this.mNetwork != null) {
                if ((!this.mNetwork.isNetSuccess() || this.mNetwork.getErrorCode() != 5) && this.mNetwork.getErrorCode() != 6) {
                    LoginActivity.this.mTextError.setVisibility(0);
                    LoginActivity.this.mTextError.setText(this.mNetwork.getErrorString());
                    LoginActivity.this.loginFail();
                } else {
                    VcodeInfoData info = new VcodeInfoData();
                    info.parserJson(this.mRetData);
                    if (info.getVcode_pic_url() == null) {
                        LoginActivity.this.mTextError.setVisibility(0);
                        LoginActivity.this.mTextError.setText(this.mNetwork.getErrorString());
                        LoginActivity.this.loginFail();
                    } else {
                        LoginActivity.this.mVcodeMd5 = info.getVcode_md5();
                        LoginActivity.this.mVcodeUrl = info.getVcode_pic_url();
                        LoginActivity.this.refreshImage(LoginActivity.this.mVcodeUrl);
                        LoginActivity.this.showVcode();
                        LoginActivity.this.mAccount = LoginActivity.this.mEditAccount.getText().toString();
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GetImageTask extends AsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        NetWork mNetWork;

        private GetImageTask() {
            this.mNetWork = null;
            this.mCanceled = false;
        }

        /* synthetic */ GetImageTask(LoginActivity loginActivity, GetImageTask getImageTask) {
            this();
        }

        public void cancel() {
            LoginActivity.this.mGetImageTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
                this.mNetWork = null;
            }
            this.mCanceled = true;
            super.cancel(true);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            LoginActivity.this.mImageVcode.setImageBitmap(null);
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
            LoginActivity.this.mGetImageTask = null;
            if (result != null) {
                LoginActivity.this.mImageVcode.setImageBitmap(result);
            } else {
                LoginActivity.this.mImageVcode.setImageResource(R.drawable.background);
            }
            LoginActivity.this.mProgressBar.setVisibility(8);
            super.onPostExecute((GetImageTask) result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Account {
        String mAccount;
        String mError;
        int mErrorVisibility;
        boolean mIsInputCorrect;
        String mPassword;
        String mVcode;
        int mVcodeVisibility;

        private Account() {
        }

        /* synthetic */ Account(LoginActivity loginActivity, Account account) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class InputUserNameAsyncTask extends AsyncTask<String, Integer, CheckUserNameData> {
        private String mAccount;
        private NetWork mNetwork = null;
        private String mUrl;

        public InputUserNameAsyncTask(String url, String account) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = url;
            this.mAccount = account;
        }

        public void cancel() {
            LoginActivity.this.mUserNameTask = null;
            LoginActivity.this.mConfirmProgress.setVisibility(8);
            LoginActivity.this.mConfirm.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(CheckUserNameData result) {
            super.onPostExecute((InputUserNameAsyncTask) result);
            LoginActivity.this.mUserNameTask = null;
            LoginActivity.this.mConfirmProgress.setVisibility(8);
            LoginActivity.this.mConfirm.setEnabled(true);
            if (result == null) {
                LoginActivity.this.showInputUserNameError(this.mNetwork.getErrorString());
            } else if (result.getUser().getName() == null) {
                LoginActivity.this.showInputUserNameError(this.mNetwork.getErrorString());
                LoginActivity.this.setSuggestNames(result.getSuggnames());
            } else {
                LoginActivity.this.closeInputUserNameDialog();
                TiebaApplication.setCurrentAccountObj(LoginActivity.this.mAccountData);
                LoginActivity.this.goToMainTag();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            LoginActivity.this.mConfirmProgress.setVisibility(0);
            LoginActivity.this.mConfirm.setEnabled(false);
            LoginActivity.this.showInputUserNameError(null);
            LoginActivity.this.initSuggestNames();
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public CheckUserNameData doInBackground(String... params) {
            CheckUserNameData data;
            CheckUserNameData data2 = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.addPostData("un", this.mAccount);
                this.mNetwork.addPostData(NetWork.BDUSS, LoginActivity.this.mAccountData.getBDUSS());
                this.mNetwork.setNeedBackgroundLogin(false);
                String ret = this.mNetwork.postNetData();
                if (this.mNetwork.isNetSuccess()) {
                    try {
                        if (this.mNetwork.getErrorCode() == 0) {
                            data = new CheckUserNameData();
                            data.parserJson(ret);
                            String account = data.getUser().getName();
                            String bduss = data.getUser().getBDUSS();
                            if (account == null || bduss == null || LoginActivity.this.mAccountData == null) {
                                data2 = data;
                            } else {
                                LoginActivity.this.mAccountData.setAccount(account);
                                DatabaseService.saveAccountData(LoginActivity.this.mAccountData);
                                data2 = data;
                            }
                        } else if (this.mNetwork.getErrorCode() == 36) {
                            data = new CheckUserNameData();
                            data.parserJson(ret);
                            data2 = data;
                        } else if (this.mNetwork.getErrorCode() == 1) {
                            LoginActivity.this.closeInputUserNameDialog();
                        }
                    } catch (Exception e) {
                        ex = e;
                        data2 = data;
                        TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                        return data2;
                    }
                }
            } catch (Exception e2) {
                ex = e2;
            }
            return data2;
        }
    }

    /* loaded from: classes.dex */
    private class CheckUserNameAsyncTask extends AsyncTask<String, Integer, CheckUserNameData> {
        private String mAccount;
        private NetWork mNetwork = null;
        private String mUrl;

        public CheckUserNameAsyncTask(String url, String account) {
            this.mUrl = null;
            this.mAccount = null;
            this.mUrl = url;
            this.mAccount = account;
        }

        public void cancel() {
            super.cancel(true);
            LoginActivity.this.mCheckProgress.setVisibility(8);
            LoginActivity.this.mCheckUserName.setEnabled(true);
            LoginActivity.this.mCheckUserNameTask = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public CheckUserNameData doInBackground(String... params) {
            this.mNetwork = new NetWork(this.mUrl);
            this.mNetwork.addPostData("un", this.mAccount);
            String ret = this.mNetwork.postNetData();
            if (!this.mNetwork.isNetSuccess() || this.mNetwork.getErrorCode() != 36) {
                return null;
            }
            CheckUserNameData data = new CheckUserNameData();
            data.parserJson(ret);
            return data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(CheckUserNameData result) {
            super.onPostExecute((CheckUserNameAsyncTask) result);
            LoginActivity.this.mCheckUserNameTask = null;
            LoginActivity.this.mCheckProgress.setVisibility(8);
            LoginActivity.this.mCheckUserName.setEnabled(true);
            if (!this.mNetwork.isNetSuccess()) {
                LoginActivity.this.showInputUserNameError(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getErrorCode() == 0) {
                LoginActivity.this.showInputUserNameError(LoginActivity.this.getString(R.string.name_not_use));
            } else if (this.mNetwork.getErrorCode() == 36) {
                LoginActivity.this.showInputUserNameError(this.mNetwork.getErrorString());
                if (result != null) {
                    LoginActivity.this.setSuggestNames(result.getSuggnames());
                }
            } else {
                LoginActivity.this.showInputUserNameError(this.mNetwork.getErrorString());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            LoginActivity.this.mCheckProgress.setVisibility(0);
            LoginActivity.this.mCheckUserName.setEnabled(false);
            LoginActivity.this.showInputUserNameError(null);
            LoginActivity.this.initSuggestNames();
            super.onPreExecute();
        }
    }
}
