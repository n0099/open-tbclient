package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.data.VcodeInfoData;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class CreateBarActivity extends BaseActivity {
    private static final String BAR_NAME_ISVALID = "isvalid";
    private static final String BAR_NAME_STRING = "barname";
    private TextView mTextInfo = null;
    private TextView mTextInfo2 = null;
    private EditText mEditName = null;
    private EditText mEditVcode = null;
    private RelativeLayout mCreate = null;
    private Button mBack = null;
    private FrameLayout mImageButton = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar mProgressImage = null;
    private CreateTask mCreateTask = null;
    private GetImageTask mGetImageTask = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String mVcode_md5 = null;
    private TextView mErrorView = null;
    private String mBarName = null;
    private boolean mBarNameIsValid = false;

    public static void startActivity(Context context, String bar_name, boolean is_valid) {
        if (bar_name != null && bar_name.length() > 0) {
            Intent intent = new Intent(context, CreateBarActivity.class);
            intent.putExtra(BAR_NAME_STRING, bar_name);
            intent.putExtra(BAR_NAME_ISVALID, is_valid);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        getImage();
    }

    private void getImage() {
        if (this.mGetImageTask == null) {
            this.mGetImageTask = new GetImageTask(this, null);
            this.mGetImageTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mCreateTask != null) {
            this.mCreateTask.cancel();
        }
        if (this.mGetImageTask != null) {
            this.mGetImageTask.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.mBarName = intent.getStringExtra(BAR_NAME_STRING);
        this.mBarNameIsValid = intent.getBooleanExtra(BAR_NAME_ISVALID, false);
        if (this.mBarName == null) {
            this.mBarName = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startImageTask() {
        if (this.mGetImageTask == null && this.mCreateTask == null) {
            this.mGetImageTask = new GetImageTask(this, null);
            this.mGetImageTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCreateTask() {
        if (this.mCreateTask == null) {
            this.mCreateTask = new CreateTask(this.mEditName.getText().toString().trim(), this.mEditVcode.getText().toString().trim());
            this.mCreateTask.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v != CreateBarActivity.this.mCreate) {
                    if (v != CreateBarActivity.this.mImageButton) {
                        if (v == CreateBarActivity.this.mBack) {
                            CreateBarActivity.this.finish();
                            return;
                        }
                        return;
                    }
                    CreateBarActivity.this.startImageTask();
                    return;
                }
                CreateBarActivity.this.startCreateTask();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.home.CreateBarActivity.2
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                int name_length = CreateBarActivity.this.mEditName.getText().toString().trim().length();
                if (name_length <= 0 || name_length >= 32 || CreateBarActivity.this.mEditVcode.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.mCreate.setEnabled(false);
                } else {
                    CreateBarActivity.this.mCreate.setEnabled(true);
                }
                if (name_length >= 32) {
                    CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getString(R.string.bar_name_long));
                    CreateBarActivity.this.mErrorView.setTextColor(-65536);
                    return;
                }
                CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getString(R.string.bar_name_rule));
                CreateBarActivity.this.mErrorView.setTextColor(-6250336);
            }
        };
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.mTextInfo = (TextView) findViewById(R.id.info);
        String info = String.valueOf(this.mBarName) + getString(R.string.bar_not_create);
        SpannableString bar_name = new SpannableString(info);
        bar_name.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, this.mBarName.length(), 33);
        this.mTextInfo.setText(bar_name);
        this.mCreate = (RelativeLayout) findViewById(R.id.create);
        this.mCreate.setOnClickListener(this.mOnClickListener);
        this.mTextInfo2 = (TextView) findViewById(R.id.info2);
        this.mEditName = (EditText) findViewById(R.id.edit_name);
        this.mEditName.addTextChangedListener(this.mTextWatcher);
        this.mEditVcode = (EditText) findViewById(R.id.edit_vcode);
        this.mEditVcode.addTextChangedListener(this.mTextWatcher);
        if (this.mBarNameIsValid) {
            this.mTextInfo2.setText(getString(R.string.bar_name_valid));
            this.mEditName.setText(this.mBarName);
        } else {
            this.mTextInfo2.setText(getString(R.string.bar_name_invalid));
        }
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mImageButton = (FrameLayout) findViewById(R.id.image_button);
        this.mImageButton.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.mCreate.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgressImage = (ProgressBar) findViewById(R.id.progress_image);
        if (this.mBarNameIsValid) {
            this.mEditVcode.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CreateTask extends AsyncTask<String, Integer, String> {
        private String mBarName;
        private NetWork mNetwork = null;
        private String mVcode;

        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.mCreateTask = null;
        }

        public CreateTask(String name, String code) {
            this.mBarName = null;
            this.mVcode = null;
            this.mBarName = name;
            this.mVcode = code;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            try {
                this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/forum/create");
                this.mNetwork.setIsNeedTbs(true);
                this.mNetwork.addPostData("kw", this.mBarName);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.mVcode_md5);
                this.mNetwork.postNetData();
                return null;
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((CreateTask) result);
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.mCreateTask = null;
            if (this.mNetwork.isRequestSuccess()) {
                CreateBarSuccessActivity.startActivity(CreateBarActivity.this, this.mBarName);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.startImageTask();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.mProgress.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GetImageTask extends AsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        private NetWork mNetwork;

        private GetImageTask() {
            this.mNetwork = null;
            this.mCanceled = false;
        }

        /* synthetic */ GetImageTask(CreateBarActivity createBarActivity, GetImageTask getImageTask) {
            this();
        }

        public void cancel() {
            super.cancel(true);
            this.mCanceled = true;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgressImage.setVisibility(8);
            CreateBarActivity.this.mGetImageTask = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... params) {
            try {
                this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/f/anti/vcode");
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String ret = this.mNetwork.postNetData();
                if (this.mNetwork.isRequestSuccess()) {
                    VcodeInfoData data = new VcodeInfoData();
                    try {
                        data.parserJson(ret);
                        if (data.getVcode_pic_url() == null || data.getVcode_pic_url().length() <= 0) {
                            return null;
                        }
                        CreateBarActivity.this.mVcode_md5 = data.getVcode_md5();
                        if (this.mCanceled) {
                            return null;
                        }
                        this.mNetwork = new NetWork(data.getVcode_pic_url());
                        byte[] bt = this.mNetwork.getNetData();
                        return BitmapHelper.Bytes2Bitmap(bt);
                    } catch (Exception e) {
                        ex = e;
                        TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                        return null;
                    }
                }
                return null;
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap result) {
            super.onPostExecute((GetImageTask) result);
            CreateBarActivity.this.mProgressImage.setVisibility(8);
            CreateBarActivity.this.mGetImageTask = null;
            if (result != null) {
                CreateBarActivity.this.mImage.setImageBitmap(result);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.mVcode_md5 = null;
            CreateBarActivity.this.mProgressImage.setVisibility(0);
            CreateBarActivity.this.mImage.setImageBitmap(null);
        }
    }
}
