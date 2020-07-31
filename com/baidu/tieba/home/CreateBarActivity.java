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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout iqX;
    public NavigationBar mNavigationBar;
    private TextView iqN = null;
    private TextView iqO = null;
    private EditText iqP = null;
    private EditText iqQ = null;
    private RelativeLayout iqR = null;
    private FrameLayout iqS = null;
    private ImageView fcg = null;
    private ProgressBar mProgress = null;
    private ProgressBar iqT = null;
    private a iqU = null;
    private b iqV = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String iqW = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView iqY = null;
    private String iqZ = null;
    private boolean ira = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cli();
        adjustResizeForSoftInput();
    }

    private void cli() {
        if (this.iqV == null) {
            this.iqV = new b();
            this.iqV.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iqU != null) {
            this.iqU.cancel();
        }
        if (this.iqV != null) {
            this.iqV.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.iqZ = intent.getStringExtra("barname");
        this.ira = intent.getBooleanExtra("isvalid", false);
        if (this.iqZ == null) {
            this.iqZ = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clj() {
        if (this.iqV == null && this.iqU == null) {
            this.iqV = new b();
            this.iqV.setPriority(3);
            this.iqV.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clk() {
        if (this.iqU == null) {
            this.iqU = new a(this.iqP.getText().toString().trim(), this.iqQ.getText().toString().trim());
            this.iqU.setPriority(3);
            this.iqU.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.iqR) {
                    CreateBarActivity.this.clk();
                } else if (view == CreateBarActivity.this.iqS) {
                    CreateBarActivity.this.clj();
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
                int length = CreateBarActivity.this.iqP.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.iqQ.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.iqR.setEnabled(false);
                } else {
                    CreateBarActivity.this.iqR.setEnabled(true);
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
        this.iqY = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.iqN = (TextView) findViewById(R.id.info);
        this.iqR = (RelativeLayout) findViewById(R.id.create);
        this.iqR.setOnClickListener(this.mOnClickListener);
        this.iqO = (TextView) findViewById(R.id.info2);
        this.iqP = (EditText) findViewById(R.id.edit_name);
        this.iqP.addTextChangedListener(this.mTextWatcher);
        this.iqQ = (EditText) findViewById(R.id.edit_vcode);
        this.iqQ.addTextChangedListener(this.mTextWatcher);
        if (this.ira) {
            this.iqO.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.iqP.setText(this.iqZ);
        } else {
            this.iqO.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.iqX = (RelativeLayout) findViewById(R.id.create);
        this.iqS = (FrameLayout) findViewById(R.id.image_button);
        this.iqS.setOnClickListener(this.mOnClickListener);
        this.fcg = (ImageView) findViewById(R.id.image);
        this.iqR.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.iqT = (ProgressBar) findViewById(R.id.progress_image);
        if (this.ira) {
            this.iqQ.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.iqP.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iqP);
                    }
                    if (CreateBarActivity.this.iqQ.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iqQ);
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
        ao.setButtonTextColor(this.iqY, i);
        ao.setTextColor(this.iqO, i);
        String str = this.iqZ + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.common_color_10252)), 0, this.iqZ.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.iqZ.length(), str.length(), 33);
        ao.setBackgroundResource(this.iqX, R.drawable.btn_general_start_selector);
        this.iqN.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String iqZ;
        private z mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.iqU = null;
        }

        public a(String str, String str2) {
            this.iqZ = null;
            this.mVcode = null;
            this.iqZ = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.bav().baW().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.iqZ);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.iqW);
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
            CreateBarActivity.this.iqU = null;
            if (this.mNetwork.bav().baX().isRequestSuccess()) {
                CreateBarSuccessActivity.aD(CreateBarActivity.this.getPageContext().getPageActivity(), this.iqZ);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.clj();
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
        private z mNetwork;

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
            CreateBarActivity.this.iqT.setVisibility(8);
            CreateBarActivity.this.iqV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bav().baX().isRequestSuccess()) {
                    ad adVar = new ad();
                    adVar.parserJson(postNetData);
                    if (adVar.getVcode_pic_url() == null || adVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.iqW = adVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new z(adVar.getVcode_pic_url());
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
            CreateBarActivity.this.iqT.setVisibility(8);
            CreateBarActivity.this.iqV = null;
            if (bitmap != null) {
                CreateBarActivity.this.fcg.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.iqW = null;
            CreateBarActivity.this.iqT.setVisibility(0);
            CreateBarActivity.this.fcg.setImageDrawable(null);
        }
    }
}
