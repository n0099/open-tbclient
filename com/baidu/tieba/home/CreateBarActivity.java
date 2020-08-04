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
    private RelativeLayout iqZ;
    public NavigationBar mNavigationBar;
    private TextView iqP = null;
    private TextView iqQ = null;
    private EditText iqR = null;
    private EditText iqS = null;
    private RelativeLayout iqT = null;
    private FrameLayout iqU = null;
    private ImageView fcg = null;
    private ProgressBar mProgress = null;
    private ProgressBar iqV = null;
    private a iqW = null;
    private b iqX = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String iqY = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView ira = null;
    private String irb = null;
    private boolean irc = false;

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
        if (this.iqX == null) {
            this.iqX = new b();
            this.iqX.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iqW != null) {
            this.iqW.cancel();
        }
        if (this.iqX != null) {
            this.iqX.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.irb = intent.getStringExtra("barname");
        this.irc = intent.getBooleanExtra("isvalid", false);
        if (this.irb == null) {
            this.irb = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clj() {
        if (this.iqX == null && this.iqW == null) {
            this.iqX = new b();
            this.iqX.setPriority(3);
            this.iqX.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clk() {
        if (this.iqW == null) {
            this.iqW = new a(this.iqR.getText().toString().trim(), this.iqS.getText().toString().trim());
            this.iqW.setPriority(3);
            this.iqW.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.iqT) {
                    CreateBarActivity.this.clk();
                } else if (view == CreateBarActivity.this.iqU) {
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
                int length = CreateBarActivity.this.iqR.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.iqS.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.iqT.setEnabled(false);
                } else {
                    CreateBarActivity.this.iqT.setEnabled(true);
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
        this.ira = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.iqP = (TextView) findViewById(R.id.info);
        this.iqT = (RelativeLayout) findViewById(R.id.create);
        this.iqT.setOnClickListener(this.mOnClickListener);
        this.iqQ = (TextView) findViewById(R.id.info2);
        this.iqR = (EditText) findViewById(R.id.edit_name);
        this.iqR.addTextChangedListener(this.mTextWatcher);
        this.iqS = (EditText) findViewById(R.id.edit_vcode);
        this.iqS.addTextChangedListener(this.mTextWatcher);
        if (this.irc) {
            this.iqQ.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.iqR.setText(this.irb);
        } else {
            this.iqQ.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.iqZ = (RelativeLayout) findViewById(R.id.create);
        this.iqU = (FrameLayout) findViewById(R.id.image_button);
        this.iqU.setOnClickListener(this.mOnClickListener);
        this.fcg = (ImageView) findViewById(R.id.image);
        this.iqT.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.iqV = (ProgressBar) findViewById(R.id.progress_image);
        if (this.irc) {
            this.iqS.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.iqR.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iqR);
                    }
                    if (CreateBarActivity.this.iqS.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iqS);
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
        ao.setButtonTextColor(this.ira, i);
        ao.setTextColor(this.iqQ, i);
        String str = this.irb + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.common_color_10252)), 0, this.irb.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.irb.length(), str.length(), 33);
        ao.setBackgroundResource(this.iqZ, R.drawable.btn_general_start_selector);
        this.iqP.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String irb;
        private z mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.iqW = null;
        }

        public a(String str, String str2) {
            this.irb = null;
            this.mVcode = null;
            this.irb = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.bav().baW().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.irb);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.iqY);
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
            CreateBarActivity.this.iqW = null;
            if (this.mNetwork.bav().baX().isRequestSuccess()) {
                CreateBarSuccessActivity.aD(CreateBarActivity.this.getPageContext().getPageActivity(), this.irb);
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
            CreateBarActivity.this.iqV.setVisibility(8);
            CreateBarActivity.this.iqX = null;
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
                    CreateBarActivity.this.iqY = adVar.getVcode_md5();
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
            CreateBarActivity.this.iqV.setVisibility(8);
            CreateBarActivity.this.iqX = null;
            if (bitmap != null) {
                CreateBarActivity.this.fcg.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.iqY = null;
            CreateBarActivity.this.iqV.setVisibility(0);
            CreateBarActivity.this.fcg.setImageDrawable(null);
        }
    }
}
