package com.baidu.tieba.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenu;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout iFo;
    public NavigationBar mNavigationBar;
    private TextView iFe = null;
    private TextView iFf = null;
    private EditText iFg = null;
    private EditText iFh = null;
    private RelativeLayout iFi = null;
    private FrameLayout iFj = null;
    private ImageView fnA = null;
    private ProgressBar mProgress = null;
    private ProgressBar iFk = null;
    private a iFl = null;
    private b iFm = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String iFn = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView iFp = null;
    private String iFq = null;
    private boolean iFr = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cvR();
        adjustResizeForSoftInput();
    }

    private void cvR() {
        if (this.iFm == null) {
            this.iFm = new b();
            this.iFm.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iFl != null) {
            this.iFl.cancel();
        }
        if (this.iFm != null) {
            this.iFm.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.iFq = intent.getStringExtra("barname");
        this.iFr = intent.getBooleanExtra("isvalid", false);
        if (this.iFq == null) {
            this.iFq = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvS() {
        if (this.iFm == null && this.iFl == null) {
            this.iFm = new b();
            this.iFm.setPriority(3);
            this.iFm.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvT() {
        if (this.iFl == null) {
            this.iFl = new a(this.iFg.getText().toString().trim(), this.iFh.getText().toString().trim());
            this.iFl.setPriority(3);
            this.iFl.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.iFi) {
                    CreateBarActivity.this.cvT();
                } else if (view == CreateBarActivity.this.iFj) {
                    CreateBarActivity.this.cvS();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.home.CreateBarActivity.2
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = CreateBarActivity.this.iFg.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.iFh.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.iFi.setEnabled(false);
                } else {
                    CreateBarActivity.this.iFi.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_long));
                    CreateBarActivity.this.mErrorView.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_rule));
                CreateBarActivity.this.mErrorView.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.iFp = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.iFe = (TextView) findViewById(R.id.info);
        this.iFi = (RelativeLayout) findViewById(R.id.create);
        this.iFi.setOnClickListener(this.mOnClickListener);
        this.iFf = (TextView) findViewById(R.id.info2);
        this.iFg = (EditText) findViewById(R.id.edit_name);
        this.iFg.addTextChangedListener(this.mTextWatcher);
        this.iFh = (EditText) findViewById(R.id.edit_vcode);
        this.iFh.addTextChangedListener(this.mTextWatcher);
        if (this.iFr) {
            this.iFf.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.iFg.setText(this.iFq);
        } else {
            this.iFf.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.iFo = (RelativeLayout) findViewById(R.id.create);
        this.iFj = (FrameLayout) findViewById(R.id.image_button);
        this.iFj.setOnClickListener(this.mOnClickListener);
        this.fnA = (ImageView) findViewById(R.id.image);
        this.iFi.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.iFk = (ProgressBar) findViewById(R.id.progress_image);
        if (this.iFr) {
            this.iFh.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.iFg.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iFg);
                    }
                    if (CreateBarActivity.this.iFh.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iFh);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mContainer);
        ap.setButtonTextColor(this.iFp, i);
        ap.setTextColor(this.iFf, i);
        String str = this.iFq + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10252)), 0, this.iFq.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.iFq.length(), str.length(), 33);
        ap.setBackgroundResource(this.iFo, R.drawable.btn_general_start_selector);
        this.iFe.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String iFq;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.iFl = null;
        }

        public a(String str, String str2) {
            this.iFq = null;
            this.mVcode = null;
            this.iFq = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.biQ().bjv().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.iFq);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.iFn);
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.postNetData();
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.iFl = null;
            if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                CreateBarSuccessActivity.aH(CreateBarActivity.this.getPageContext().getPageActivity(), this.iFq);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cvS();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.mProgress.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BdAsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        private aa mNetwork;

        private b() {
            this.mNetwork = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.mCanceled = true;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.iFk.setVisibility(8);
            CreateBarActivity.this.iFm = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                    ag agVar = new ag();
                    agVar.parserJson(postNetData);
                    if (agVar.getVcode_pic_url() == null || agVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.iFn = agVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new aa(agVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.getNetData());
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            CreateBarActivity.this.iFk.setVisibility(8);
            CreateBarActivity.this.iFm = null;
            if (bitmap != null) {
                CreateBarActivity.this.fnA.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.iFn = null;
            CreateBarActivity.this.iFk.setVisibility(0);
            CreateBarActivity.this.fnA.setImageDrawable(null);
        }
    }
}
