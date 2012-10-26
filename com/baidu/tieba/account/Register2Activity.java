package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
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
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.model.LoginModel;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.IntentSpan;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Register2Activity extends BaseActivity {
    private static int REQUEST_CODE = LocationClientOption.MIN_SCAN_SPAN;
    private static int ERROR_NAME = 27;
    private static int ERROR_PSW = 29;
    private static int ERROR_PHONE = 28;
    private static int ERROR_VCODE = 6;
    private Button mButtonBack = null;
    private Button mButtonLogin = null;
    private Button mButtonShowPsw = null;
    private ImageView mButtonDelName = null;
    private ImageView mButtonDelPhone = null;
    private Button mButtonVcodeImage = null;
    private RadioGroup mNameGroup = null;
    private RadioButton mRadioChooseName1 = null;
    private RadioButton mRadioChooseName2 = null;
    private RadioButton mRadioChooseName3 = null;
    private TextView mRegInfo = null;
    private TextView mTextError = null;
    private EditText mEditUserName = null;
    private EditText mEditPsw = null;
    private EditText mEditPhone = null;
    private EditText mEditVcode = null;
    private RelativeLayout mRegister = null;
    private LinearLayout mUserNameBg = null;
    private LinearLayout mRecommendBg = null;
    private LinearLayout mInputPwsBg = null;
    private LinearLayout mInputPhoneBg = null;
    private LinearLayout mInputVcodeBg = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar mImageProgressBar = null;
    private ImageView mImageVcode = null;
    private int mBgPaddingLeft = 0;
    private int mBgPaddingRight = 0;
    private boolean mHaveVcode = false;
    private boolean mIsShowPassword = true;
    private int mErrorNo = -1;
    private String mErrorString = null;
    private GetImageTask mGetImageTask = null;
    private RegistAsyncTask mRegistTask = null;
    private LoginModel mLoginModel = null;
    private View.OnClickListener mOnclickListener = new View.OnClickListener() { // from class: com.baidu.tieba.account.Register2Activity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != Register2Activity.this.mButtonBack && view != Register2Activity.this.mButtonLogin) {
                if (view != Register2Activity.this.mButtonShowPsw) {
                    if (view != Register2Activity.this.mButtonDelName) {
                        if (view == Register2Activity.this.mButtonDelPhone) {
                            Register2Activity.this.mEditPhone.setText((CharSequence) null);
                            return;
                        } else if (view != Register2Activity.this.mRegister) {
                            if ((view == Register2Activity.this.mImageVcode || view == Register2Activity.this.mButtonVcodeImage) && Register2Activity.this.mGetImageTask == null && Register2Activity.this.mLoginModel != null) {
                                Register2Activity.this.mGetImageTask = new GetImageTask(Register2Activity.this.mLoginModel.getAnti().getVcode_pic_url());
                                Register2Activity.this.mGetImageTask.execute(new String[0]);
                                return;
                            }
                            return;
                        } else if (Register2Activity.this.mRegistTask == null) {
                            if (Register2Activity.this.mGetImageTask != null) {
                                Register2Activity.this.mGetImageTask.cancel();
                            }
                            Register2Activity.this.mRegistTask = new RegistAsyncTask(Register2Activity.this, null);
                            Register2Activity.this.mRegistTask.execute(new String[0]);
                            return;
                        } else {
                            return;
                        }
                    }
                    Register2Activity.this.mEditUserName.setText((CharSequence) null);
                    return;
                }
                Register2Activity.this.changePswDisplay();
                return;
            }
            Register2Activity.this.setResult(0);
            Register2Activity.this.finish();
            TiebaLog.i("Register2Activity", "mButtonBack", "onClick");
        }
    };
    private TextWatcher mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.account.Register2Activity.2
        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            if (s == Register2Activity.this.mEditPhone.getEditableText()) {
                Register2Activity.this.setHaveVcode(false);
            }
            if (Register2Activity.this.mEditUserName.length() <= 0 || Register2Activity.this.mEditPsw.length() < 6 || Register2Activity.this.mEditPhone.length() <= 0) {
                Register2Activity.this.mRegister.setEnabled(false);
            } else if (!Register2Activity.this.mHaveVcode || Register2Activity.this.mEditVcode.length() > 0) {
                Register2Activity.this.mRegister.setEnabled(true);
            } else {
                Register2Activity.this.mRegister.setEnabled(false);
            }
            if ((Register2Activity.this.mErrorNo == Register2Activity.ERROR_NAME && s == Register2Activity.this.mEditUserName.getEditableText()) || ((Register2Activity.this.mErrorNo == Register2Activity.ERROR_PSW && s == Register2Activity.this.mEditPsw.getEditableText()) || ((Register2Activity.this.mErrorNo == Register2Activity.ERROR_PHONE && s == Register2Activity.this.mEditPhone.getEditableText()) || (Register2Activity.this.mErrorNo == Register2Activity.ERROR_VCODE && s == Register2Activity.this.mEditVcode.getEditableText())))) {
                Register2Activity.this.mErrorNo = -1;
                Register2Activity.this.errorControlAttr();
            }
        }
    };
    private View.OnFocusChangeListener mOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.account.Register2Activity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View v, boolean hasFocus) {
            View view = null;
            if (v == Register2Activity.this.mEditUserName) {
                view = Register2Activity.this.mButtonDelName;
            } else if (v == Register2Activity.this.mEditPhone) {
                view = Register2Activity.this.mButtonDelPhone;
            }
            if (view != null) {
                if (hasFocus) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(8);
                }
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.account.Register2Activity.4
        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId > 0) {
                RadioButton v = (RadioButton) Register2Activity.this.findViewById(checkedId);
                if (v.isChecked()) {
                    Register2Activity.this.mEditUserName.setText(v.getText());
                }
            }
        }
    };

    public static void startActivityForResult(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, Register2Activity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_register2_activity);
        initUI();
        PvThread pv = new PvThread(Config.ST_TYPE_REG);
        pv.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePswDisplay() {
        int index = this.mEditPsw.getSelectionStart();
        if (!this.mIsShowPassword) {
            this.mButtonShowPsw.setText(getString(R.string.hide));
            this.mEditPsw.setTransformationMethod(new SingleLineTransformationMethod());
            this.mEditPsw.setSelection(index);
            this.mIsShowPassword = true;
            return;
        }
        this.mButtonShowPsw.setText(getString(R.string.show));
        this.mEditPsw.setTransformationMethod(new PasswordTransformationMethod());
        this.mEditPsw.setSelection(index);
        this.mIsShowPassword = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mRegistTask != null) {
            this.mRegistTask.cancel();
        }
        if (this.mGetImageTask != null) {
            this.mGetImageTask.cancel();
        }
        TiebaLog.i("Register2Activity", "onDestroy", "onDestroy");
    }

    private void initUI() {
        initAgreement();
        this.mRegister = (RelativeLayout) findViewById(R.id.register);
        this.mRegister.setEnabled(false);
        this.mButtonBack = (Button) findViewById(R.id.back);
        this.mButtonLogin = (Button) findViewById(R.id.login);
        this.mButtonShowPsw = (Button) findViewById(R.id.show);
        this.mEditPsw = (EditText) findViewById(R.id.edit_psw);
        this.mEditUserName = (EditText) findViewById(R.id.edit_user_name);
        this.mButtonDelName = (ImageView) findViewById(R.id.del_user_name);
        this.mButtonDelName.setOnClickListener(this.mOnclickListener);
        this.mButtonDelPhone = (ImageView) findViewById(R.id.del_phone);
        this.mButtonDelPhone.setOnClickListener(this.mOnclickListener);
        this.mEditUserName.setOnFocusChangeListener(this.mOnFocusChangeListener);
        this.mEditPhone = (EditText) findViewById(R.id.edit_phone);
        this.mEditPhone.setOnFocusChangeListener(this.mOnFocusChangeListener);
        this.mButtonBack.setOnClickListener(this.mOnclickListener);
        this.mButtonLogin.setOnClickListener(this.mOnclickListener);
        this.mButtonShowPsw.setOnClickListener(this.mOnclickListener);
        this.mEditUserName.addTextChangedListener(this.mTextWatcher);
        this.mEditPsw.addTextChangedListener(this.mTextWatcher);
        this.mEditPhone.addTextChangedListener(this.mTextWatcher);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress_reg);
        this.mImageProgressBar = (ProgressBar) findViewById(R.id.image_progress);
        this.mRadioChooseName1 = (RadioButton) findViewById(R.id.choose_name1);
        this.mRadioChooseName2 = (RadioButton) findViewById(R.id.choose_name2);
        this.mRadioChooseName3 = (RadioButton) findViewById(R.id.choose_name3);
        this.mNameGroup = (RadioGroup) findViewById(R.id.name_group);
        this.mNameGroup.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.mRegister.setOnClickListener(this.mOnclickListener);
        this.mUserNameBg = (LinearLayout) findViewById(R.id.user_name_bg);
        this.mBgPaddingLeft = this.mUserNameBg.getPaddingLeft();
        this.mBgPaddingRight = this.mUserNameBg.getPaddingRight();
        this.mRecommendBg = (LinearLayout) findViewById(R.id.recommend_bg);
        this.mInputPwsBg = (LinearLayout) findViewById(R.id.input_psw_bg);
        this.mInputPhoneBg = (LinearLayout) findViewById(R.id.input_phone_bg);
        this.mInputVcodeBg = (LinearLayout) findViewById(R.id.input_vcode_bg);
        this.mTextError = (TextView) findViewById(R.id.text_error);
        this.mImageVcode = (ImageView) findViewById(R.id.image_vcode);
        this.mButtonVcodeImage = (Button) findViewById(R.id.change_vcode);
        this.mImageVcode.setOnClickListener(this.mOnclickListener);
        this.mButtonVcodeImage.setOnClickListener(this.mOnclickListener);
        this.mEditVcode = (EditText) findViewById(R.id.edit_vcode);
        this.mEditVcode.addTextChangedListener(this.mTextWatcher);
        changePswDisplay();
        errorControlAttr();
        ShowSoftKeyPadDelay(this.mEditUserName, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forbidInput() {
        setAllControlAttr(false);
    }

    private void restorePadding() {
        this.mUserNameBg.setPadding(this.mBgPaddingLeft, 0, this.mBgPaddingRight, 0);
        this.mRecommendBg.setPadding(this.mBgPaddingLeft, 0, this.mBgPaddingRight, 0);
        this.mInputPwsBg.setPadding(this.mBgPaddingLeft, 0, this.mBgPaddingRight, 0);
        this.mInputPhoneBg.setPadding(this.mBgPaddingLeft, 0, this.mBgPaddingRight, 0);
        this.mInputVcodeBg.setPadding(this.mBgPaddingLeft, 0, this.mBgPaddingRight, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorControlAttr() {
        this.mTextError.setText(this.mErrorString);
        if (this.mErrorString != null) {
            this.mTextError.setVisibility(0);
        } else {
            this.mTextError.setVisibility(4);
        }
        if (this.mErrorNo == ERROR_NAME) {
            this.mUserNameBg.setBackgroundResource(R.drawable.login_input_topwrong);
        } else if (this.mErrorNo == ERROR_PSW) {
            this.mInputPwsBg.setBackgroundResource(R.drawable.login_input_middlewrong);
        } else if (this.mErrorNo == ERROR_PHONE) {
            if (this.mHaveVcode) {
                this.mInputPhoneBg.setBackgroundResource(R.drawable.login_input_middlewrong);
            } else {
                this.mInputPhoneBg.setBackgroundResource(R.drawable.login_input_underwrong);
            }
        } else if (this.mErrorNo == ERROR_VCODE) {
            this.mInputVcodeBg.setBackgroundResource(R.drawable.login_input_underwrong);
        } else {
            this.mUserNameBg.setBackgroundResource(R.drawable.login_input_top);
            this.mInputPwsBg.setBackgroundResource(R.drawable.login_input_middle);
            if (this.mHaveVcode) {
                this.mInputPhoneBg.setBackgroundResource(R.drawable.login_input_middle);
            } else {
                this.mInputPhoneBg.setBackgroundResource(R.drawable.login_input_under);
            }
            this.mInputVcodeBg.setBackgroundResource(R.drawable.login_input_under);
        }
        restorePadding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHaveVcode(boolean haveVcode) {
        this.mHaveVcode = haveVcode;
        if (this.mHaveVcode) {
            this.mInputVcodeBg.setVisibility(0);
            if (this.mEditVcode.length() <= 0) {
                this.mRegister.setEnabled(false);
            }
            if (this.mErrorNo != ERROR_PHONE) {
                this.mInputPhoneBg.setBackgroundResource(R.drawable.login_input_middle);
            }
            if (this.mGetImageTask != null) {
                this.mGetImageTask.cancel();
            }
            if (this.mLoginModel != null) {
                this.mGetImageTask = new GetImageTask(this.mLoginModel.getAnti().getVcode_pic_url());
                this.mGetImageTask.execute(new String[0]);
            }
        } else {
            this.mInputVcodeBg.setVisibility(8);
            this.mEditVcode.setText((CharSequence) null);
            if (this.mErrorNo != ERROR_PHONE) {
                this.mInputPhoneBg.setBackgroundResource(R.drawable.login_input_under);
            }
        }
        errorControlAttr();
    }

    private void setAllControlAttr(boolean enabled) {
        this.mEditUserName.setEnabled(enabled);
        this.mEditUserName.setFocusable(enabled);
        this.mEditUserName.setFocusableInTouchMode(enabled);
        this.mEditVcode.setEnabled(enabled);
        this.mEditVcode.setFocusable(enabled);
        this.mEditVcode.setFocusableInTouchMode(enabled);
        this.mEditPsw.setEnabled(enabled);
        this.mEditPsw.setFocusable(enabled);
        this.mEditPsw.setFocusableInTouchMode(enabled);
        this.mButtonShowPsw.setEnabled(enabled);
        this.mEditPhone.setEnabled(enabled);
        this.mEditPhone.setFocusable(enabled);
        this.mEditPhone.setFocusableInTouchMode(enabled);
        this.mButtonDelPhone.setEnabled(enabled);
        this.mRadioChooseName1.setEnabled(enabled);
        this.mRadioChooseName2.setEnabled(enabled);
        this.mRadioChooseName3.setEnabled(enabled);
        this.mImageVcode.setEnabled(enabled);
        this.mButtonVcodeImage.setEnabled(enabled);
        this.mRegInfo.setEnabled(enabled);
        if (enabled) {
            this.mEditUserName.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.mEditVcode.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.mEditPsw.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.mEditPhone.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.mRadioChooseName1.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.mRadioChooseName2.setTextColor(getResources().getColor(R.color.reg_font_color));
            this.mRadioChooseName3.setTextColor(getResources().getColor(R.color.reg_font_color));
            return;
        }
        this.mEditUserName.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.mEditVcode.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.mEditPsw.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.mEditPhone.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.mRadioChooseName1.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.mRadioChooseName2.setTextColor(getResources().getColor(R.color.text_hint_color));
        this.mRadioChooseName3.setTextColor(getResources().getColor(R.color.text_hint_color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void allowInput() {
        setAllControlAttr(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RegistData getRegistData() {
        RegistData data = new RegistData();
        data.setName(this.mEditUserName.getText().toString());
        data.setPsw(this.mEditPsw.getText().toString());
        data.setPhone(this.mEditPhone.getText().toString());
        if (this.mHaveVcode) {
            data.setVcode(this.mEditVcode.getText().toString());
        }
        if (this.mLoginModel != null) {
            data.setVcodeMd5(this.mLoginModel.getAnti().getVcode_md5());
            data.setSmsCodeTime(this.mLoginModel.getSmsCodeTime());
        }
        return data;
    }

    private void initAgreement() {
        String info = getString(R.string.reg_info);
        int start = info.length();
        String tmp = getString(R.string.user_server_agreement);
        String info2 = String.valueOf(info) + tmp;
        int length = info2.length();
        SpannableString span = new SpannableString(info2);
        IntentSpan click = new IntentSpan(this) { // from class: com.baidu.tieba.account.Register2Activity.5
            @Override // com.baidu.tieba.util.IntentSpan, android.text.style.ClickableSpan
            public void onClick(View widget) {
                if (Register2Activity.this.mRegistTask == null) {
                    Intent intent = new Intent(getContext(), ProtocolActivity.class);
                    getContext().startActivity(intent);
                }
            }
        };
        span.setSpan(click, start, length, 33);
        this.mRegInfo = (TextView) findViewById(R.id.reg_info);
        this.mRegInfo.setMovementMethod(LinkMovementMethod.getInstance());
        this.mRegInfo.setText(span);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == -1) {
            TiebaLog.i("Register2Activity", "onActivityResult", "onActivityResult");
            setResult(-1);
            finish();
        }
    }

    public void initSuggestNames() {
        this.mRecommendBg.setVisibility(8);
        this.mNameGroup.clearCheck();
        this.mRadioChooseName1.setVisibility(8);
        this.mRadioChooseName2.setVisibility(8);
        this.mRadioChooseName3.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuggestNames(ArrayList<String> names) {
        int size;
        initSuggestNames();
        if (names != null && (size = names.size()) > 0) {
            this.mRecommendBg.setVisibility(0);
            if (size > 0 && names.get(0) != null) {
                this.mRadioChooseName1.setText(names.get(0));
                this.mRadioChooseName1.setVisibility(0);
            }
            if (size > 1 && names.get(1) != null) {
                this.mRadioChooseName2.setText(names.get(1));
                this.mRadioChooseName2.setVisibility(0);
            }
            if (size > 2 && names.get(2) != null) {
                this.mRadioChooseName3.setText(names.get(2));
                this.mRadioChooseName3.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GetImageTask extends AsyncTask<String, Integer, Bitmap> {
        private NetWork mNetWork = null;
        private String mUrl;

        public GetImageTask(String url) {
            this.mUrl = null;
            this.mUrl = url;
        }

        public void cancel() {
            Register2Activity.this.mGetImageTask = null;
            Register2Activity.this.mImageProgressBar.setVisibility(8);
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Register2Activity.this.mImageVcode.setImageBitmap(null);
            Register2Activity.this.mImageProgressBar.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... params) {
            this.mNetWork = new NetWork(this.mUrl);
            byte[] data = this.mNetWork.getNetData();
            Bitmap bm = BitmapHelper.Bytes2Bitmap(data);
            return bm;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap result) {
            super.onPostExecute((GetImageTask) result);
            Register2Activity.this.mGetImageTask = null;
            Register2Activity.this.mImageProgressBar.setVisibility(8);
            Register2Activity.this.mImageVcode.setImageBitmap(result);
        }
    }

    /* loaded from: classes.dex */
    private class RegistAsyncTask extends AsyncTask<String, Integer, LoginModel> {
        private NetWork mNetWork;

        private RegistAsyncTask() {
            this.mNetWork = null;
        }

        /* synthetic */ RegistAsyncTask(Register2Activity register2Activity, RegistAsyncTask registAsyncTask) {
            this();
        }

        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            Register2Activity.this.mRegistTask = null;
            Register2Activity.this.mProgressBar.setVisibility(8);
            Register2Activity.this.allowInput();
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public LoginModel doInBackground(String... params) {
            LoginModel model = new LoginModel();
            try {
                RegistData data = Register2Activity.this.getRegistData();
                this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/s/regreal");
                this.mNetWork.addPostData("un", data.getName());
                this.mNetWork.addPostData("phonenum", data.getPhone());
                this.mNetWork.addPostData("passwd", data.getPsw());
                if (data.getVcode() != null) {
                    this.mNetWork.addPostData("vcode", data.getVcode());
                }
                if (data.getVcodeMd5() != null) {
                    this.mNetWork.addPostData("vcode_md5", data.getVcodeMd5());
                }
                String ret = this.mNetWork.postNetData();
                if ((this.mNetWork.isNetSuccess() && (this.mNetWork.getErrorCode() == 0 || this.mNetWork.getErrorCode() == 36)) || this.mNetWork.getErrorCode() == 5) {
                    LoginModel model2 = new LoginModel();
                    try {
                        model2.parserJson(ret);
                        return model2;
                    } catch (Exception e) {
                        ex = e;
                        TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                        return null;
                    }
                }
                return model;
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(LoginModel result) {
            super.onPostExecute((RegistAsyncTask) result);
            Register2Activity.this.mRegistTask = null;
            Register2Activity.this.mProgressBar.setVisibility(8);
            Register2Activity.this.allowInput();
            Register2Activity.this.mLoginModel = result;
            if (!this.mNetWork.isNetSuccess()) {
                Register2Activity.this.mErrorNo = -1;
                Register2Activity.this.mErrorString = this.mNetWork.getErrorString();
                Register2Activity.this.errorControlAttr();
            } else if (this.mNetWork.getErrorCode() == 36) {
                Register2Activity.this.setSuggestNames(result.getSuggnames());
                Register2Activity.this.mErrorNo = Register2Activity.ERROR_NAME;
                Register2Activity.this.mErrorString = this.mNetWork.getErrorString();
                Register2Activity.this.errorControlAttr();
            } else if (this.mNetWork.getErrorCode() == 5) {
                Register2Activity.this.mErrorNo = Register2Activity.ERROR_VCODE;
                Register2Activity.this.setHaveVcode(true);
            } else if (this.mNetWork.getErrorCode() == 0) {
                RegistData data = Register2Activity.this.getRegistData();
                ActivationActivity.startActivityForResult(Register2Activity.this, data, Register2Activity.REQUEST_CODE);
                Register2Activity.this.setHaveVcode(false);
            } else {
                Register2Activity.this.mErrorNo = this.mNetWork.getErrorCode();
                Register2Activity.this.mErrorString = this.mNetWork.getErrorString();
                Register2Activity.this.errorControlAttr();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Register2Activity.this.mProgressBar.setVisibility(0);
            Register2Activity.this.forbidInput();
            Register2Activity.this.mErrorNo = -1;
            Register2Activity.this.mErrorString = null;
            Register2Activity.this.errorControlAttr();
            Register2Activity.this.mRecommendBg.setVisibility(8);
            Register2Activity.this.mTextError.setVisibility(4);
            Register2Activity.this.mTextError.setText((CharSequence) null);
            super.onPreExecute();
        }
    }
}
