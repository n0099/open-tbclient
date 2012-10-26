package com.baidu.tieba.account;

import android.app.Dialog;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.CheckUserNameData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class InputUserNameDialog {
    private BaseActivity mContext;
    private View mInputUserNameView = null;
    private Dialog mInputUserNameDialog = null;
    private EditText mUserNameEditor = null;
    private RadioGroup mRadioGroup = null;
    private CompoundButton.OnCheckedChangeListener mRadioButtonCheckedListener = null;
    private RadioButton mRadioButton1 = null;
    private RadioButton mRadioButton2 = null;
    private RadioButton mRadioButton3 = null;
    private Button mBack = null;
    private Button mCheckUserName = null;
    private InputUserNameAsyncTask mUserNameTask = null;
    private CheckUserNameAsyncTask mCheckUserNameTask = null;
    private TextView mErrorInfo = null;
    private Button mConfirm = null;
    private ProgressBar mCheckProgress = null;
    private ProgressBar mConfirmProgress = null;
    private TextView mPhoneText = null;
    private String mPhoneNum = null;
    private AccountData mAccountData = null;
    private CallBackListener mOkListener = null;
    private CallBackListener mCancelListener = null;

    /* loaded from: classes.dex */
    public interface CallBackListener {
        void callback(AccountData accountData);
    }

    public InputUserNameDialog(BaseActivity context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setPhone(String phone) {
        this.mPhoneNum = phone;
    }

    public void setAccountData(AccountData accountData) {
        this.mAccountData = accountData;
    }

    public void setCallBackListener(CallBackListener listener) {
        this.mOkListener = listener;
    }

    public void setCallBackCancelListener(CallBackListener listener) {
        this.mCancelListener = listener;
    }

    public void showInputUserNameDialog() {
        if (this.mInputUserNameDialog == null) {
            LayoutInflater mInflater = this.mContext.getLayoutInflater();
            this.mInputUserNameView = mInflater.inflate(R.layout.main_input_username, (ViewGroup) null);
            this.mUserNameEditor = (EditText) this.mInputUserNameView.findViewById(R.id.account);
            this.mUserNameEditor.setHint(String.valueOf(this.mContext.getString(R.string.input_name)) + ":");
            this.mBack = (Button) this.mInputUserNameView.findViewById(R.id.back);
            this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.InputUserNameDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    InputUserNameDialog.this.closeInputUserNameDialog();
                    InputUserNameDialog.this.onDialogClose();
                }
            });
            this.mCheckUserName = (Button) this.mInputUserNameView.findViewById(R.id.check_username);
            this.mCheckUserName.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.InputUserNameDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    String account = InputUserNameDialog.this.mUserNameEditor.getText().toString();
                    if (account != null && account.length() > 0) {
                        if (InputUserNameDialog.this.mUserNameTask == null && InputUserNameDialog.this.mCheckUserNameTask == null) {
                            InputUserNameDialog.this.mCheckUserNameTask = new CheckUserNameAsyncTask("http://c.tieba.baidu.com/c/s/detectuname", account);
                            InputUserNameDialog.this.mCheckUserNameTask.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    InputUserNameDialog.this.showInputUserNameError(InputUserNameDialog.this.mContext.getString(R.string.input_name));
                }
            });
            this.mCheckProgress = (ProgressBar) this.mInputUserNameView.findViewById(R.id.check_progress);
            this.mConfirm = (Button) this.mInputUserNameView.findViewById(R.id.confirm);
            this.mConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.InputUserNameDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    String account = InputUserNameDialog.this.mUserNameEditor.getText().toString();
                    if (account != null && account.length() > 0) {
                        if (InputUserNameDialog.this.mCheckUserNameTask != null) {
                            InputUserNameDialog.this.mCheckUserNameTask.cancel();
                        }
                        if (InputUserNameDialog.this.mUserNameTask == null) {
                            InputUserNameDialog.this.mUserNameTask = new InputUserNameAsyncTask("http://c.tieba.baidu.com/c/s/filluname", account);
                            InputUserNameDialog.this.mUserNameTask.execute(new String[0]);
                            return;
                        }
                        return;
                    }
                    InputUserNameDialog.this.showInputUserNameError(InputUserNameDialog.this.mContext.getString(R.string.input_name));
                }
            });
            this.mConfirmProgress = (ProgressBar) this.mInputUserNameView.findViewById(R.id.confirm_progress);
            this.mErrorInfo = (TextView) this.mInputUserNameView.findViewById(R.id.error_info);
            this.mRadioGroup = (RadioGroup) this.mInputUserNameView.findViewById(R.id.names_group);
            this.mRadioButton1 = (RadioButton) this.mInputUserNameView.findViewById(R.id.name1);
            this.mRadioButton2 = (RadioButton) this.mInputUserNameView.findViewById(R.id.name2);
            this.mRadioButton3 = (RadioButton) this.mInputUserNameView.findViewById(R.id.name3);
            this.mRadioButtonCheckedListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.account.InputUserNameDialog.4
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        InputUserNameDialog.this.mUserNameEditor.setText(buttonView.getText());
                    }
                }
            };
            this.mRadioButton1.setOnCheckedChangeListener(this.mRadioButtonCheckedListener);
            this.mRadioButton2.setOnCheckedChangeListener(this.mRadioButtonCheckedListener);
            this.mRadioButton3.setOnCheckedChangeListener(this.mRadioButtonCheckedListener);
            this.mPhoneText = (TextView) this.mInputUserNameView.findViewById(R.id.phone_info);
            initSuggestNames();
            this.mInputUserNameDialog = new Dialog(this.mContext, R.style.input_username_dialog);
            this.mInputUserNameDialog.setCanceledOnTouchOutside(false);
            this.mInputUserNameDialog.getWindow().setSoftInputMode(20);
            this.mInputUserNameDialog.setCancelable(false);
            this.mInputUserNameDialog.setCanceledOnTouchOutside(false);
        }
        if (!this.mInputUserNameDialog.isShowing()) {
            this.mUserNameEditor.setText((CharSequence) null);
            initSuggestNames();
            showInputUserNameError(null);
            if (this.mPhoneNum == null || this.mPhoneNum.length() <= 0) {
                this.mPhoneText.setText("Hi," + this.mContext.getString(R.string.bar_friend));
            } else {
                this.mPhoneText.setText("Hi," + this.mPhoneNum);
            }
            this.mInputUserNameDialog.show();
            this.mInputUserNameDialog.setContentView(this.mInputUserNameView);
            WindowManager.LayoutParams wmParams = this.mInputUserNameDialog.getWindow().getAttributes();
            wmParams.gravity = 51;
            wmParams.x = 0;
            wmParams.y = 0;
            wmParams.width = -1;
            wmParams.height = -1;
            this.mInputUserNameDialog.getWindow().setAttributes(wmParams);
            this.mContext.ShowSoftKeyPadDelay(this.mUserNameEditor, 150);
            this.mUserNameEditor.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDialogClose() {
        if (this.mCancelListener != null) {
            this.mCancelListener.callback(null);
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

    public void onDestroy() {
        if (this.mUserNameTask != null) {
            this.mUserNameTask.cancel();
            this.mUserNameTask = null;
        }
        if (this.mCheckUserNameTask != null) {
            this.mCheckUserNameTask.cancel();
            this.mCheckUserNameTask = null;
        }
        closeInputUserNameDialog();
    }

    public boolean isShowing() {
        return this.mInputUserNameDialog != null && this.mInputUserNameDialog.isShowing();
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

    public void closeInputUserNameDialog() {
        if (this.mInputUserNameDialog != null && this.mInputUserNameDialog.isShowing()) {
            this.mInputUserNameDialog.dismiss();
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class InputUserNameAsyncTask extends AsyncTask<String, Integer, CheckUserNameData> {
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
            InputUserNameDialog.this.mUserNameTask = null;
            InputUserNameDialog.this.mConfirmProgress.setVisibility(8);
            InputUserNameDialog.this.mConfirm.setEnabled(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(CheckUserNameData result) {
            super.onPostExecute((InputUserNameAsyncTask) result);
            InputUserNameDialog.this.mUserNameTask = null;
            InputUserNameDialog.this.mConfirmProgress.setVisibility(8);
            InputUserNameDialog.this.mConfirm.setEnabled(true);
            if (result == null) {
                InputUserNameDialog.this.showInputUserNameError(this.mNetwork.getErrorString());
            } else if (result.getUser().getName() == null) {
                InputUserNameDialog.this.showInputUserNameError(this.mNetwork.getErrorString());
                InputUserNameDialog.this.setSuggestNames(result.getSuggnames());
            } else {
                InputUserNameDialog.this.closeInputUserNameDialog();
                TiebaApplication.setCurrentAccountObj(InputUserNameDialog.this.mAccountData);
                AccountShareHelper.getInstance().valid();
                if (InputUserNameDialog.this.mOkListener != null) {
                    InputUserNameDialog.this.mOkListener.callback(InputUserNameDialog.this.mAccountData);
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            InputUserNameDialog.this.mConfirmProgress.setVisibility(0);
            InputUserNameDialog.this.mConfirm.setEnabled(false);
            InputUserNameDialog.this.showInputUserNameError(null);
            InputUserNameDialog.this.initSuggestNames();
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
                this.mNetwork.addPostData(NetWork.BDUSS, InputUserNameDialog.this.mAccountData.getBDUSS());
                this.mNetwork.setNeedBackgroundLogin(false);
                String ret = this.mNetwork.postNetData();
                if (this.mNetwork.isNetSuccess()) {
                    try {
                        if (this.mNetwork.getErrorCode() == 0) {
                            data = new CheckUserNameData();
                            data.parserJson(ret);
                            String account = data.getUser().getName();
                            String bduss = data.getUser().getBDUSS();
                            if (account == null || bduss == null || InputUserNameDialog.this.mAccountData == null) {
                                data2 = data;
                            } else {
                                InputUserNameDialog.this.mAccountData.setAccount(account);
                                InputUserNameDialog.this.mAccountData.setBDUSS(bduss);
                                DatabaseService.saveAccountData(InputUserNameDialog.this.mAccountData);
                                data2 = data;
                            }
                        } else if (this.mNetwork.getErrorCode() == 36) {
                            data = new CheckUserNameData();
                            data.parserJson(ret);
                            data2 = data;
                        } else if (this.mNetwork.getErrorCode() == 1) {
                            InputUserNameDialog.this.closeInputUserNameDialog();
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CheckUserNameAsyncTask extends AsyncTask<String, Integer, CheckUserNameData> {
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
            InputUserNameDialog.this.mCheckProgress.setVisibility(8);
            InputUserNameDialog.this.mCheckUserName.setEnabled(true);
            InputUserNameDialog.this.mCheckUserNameTask = null;
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
            InputUserNameDialog.this.mCheckUserNameTask = null;
            InputUserNameDialog.this.mCheckProgress.setVisibility(8);
            InputUserNameDialog.this.mCheckUserName.setEnabled(true);
            if (!this.mNetwork.isNetSuccess()) {
                InputUserNameDialog.this.showInputUserNameError(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getErrorCode() == 0) {
                InputUserNameDialog.this.showInputUserNameError(InputUserNameDialog.this.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getErrorCode() == 36) {
                InputUserNameDialog.this.showInputUserNameError(this.mNetwork.getErrorString());
                if (result != null) {
                    InputUserNameDialog.this.setSuggestNames(result.getSuggnames());
                }
            } else {
                InputUserNameDialog.this.showInputUserNameError(this.mNetwork.getErrorString());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            InputUserNameDialog.this.mCheckProgress.setVisibility(0);
            InputUserNameDialog.this.mCheckUserName.setEnabled(false);
            InputUserNameDialog.this.showInputUserNameError(null);
            InputUserNameDialog.this.initSuggestNames();
            super.onPreExecute();
        }
    }
}
