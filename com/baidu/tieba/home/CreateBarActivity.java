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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout hWz;
    public NavigationBar mNavigationBar;
    private TextView hWp = null;
    private TextView hWq = null;
    private EditText hWr = null;
    private EditText hWs = null;
    private RelativeLayout hWt = null;
    private FrameLayout hWu = null;
    private ImageView eNu = null;
    private ProgressBar mProgress = null;
    private ProgressBar hWv = null;
    private a hWw = null;
    private b hWx = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String hWy = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView hWA = null;
    private String hWB = null;
    private boolean hWC = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cel();
        adjustResizeForSoftInput();
    }

    private void cel() {
        if (this.hWx == null) {
            this.hWx = new b();
            this.hWx.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hWw != null) {
            this.hWw.cancel();
        }
        if (this.hWx != null) {
            this.hWx.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.hWB = intent.getStringExtra("barname");
        this.hWC = intent.getBooleanExtra("isvalid", false);
        if (this.hWB == null) {
            this.hWB = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cem() {
        if (this.hWx == null && this.hWw == null) {
            this.hWx = new b();
            this.hWx.setPriority(3);
            this.hWx.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cen() {
        if (this.hWw == null) {
            this.hWw = new a(this.hWr.getText().toString().trim(), this.hWs.getText().toString().trim());
            this.hWw.setPriority(3);
            this.hWw.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.hWt) {
                    CreateBarActivity.this.cen();
                } else if (view == CreateBarActivity.this.hWu) {
                    CreateBarActivity.this.cem();
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
                int length = CreateBarActivity.this.hWr.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.hWs.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.hWt.setEnabled(false);
                } else {
                    CreateBarActivity.this.hWt.setEnabled(true);
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
        this.hWA = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.hWp = (TextView) findViewById(R.id.info);
        this.hWt = (RelativeLayout) findViewById(R.id.create);
        this.hWt.setOnClickListener(this.mOnClickListener);
        this.hWq = (TextView) findViewById(R.id.info2);
        this.hWr = (EditText) findViewById(R.id.edit_name);
        this.hWr.addTextChangedListener(this.mTextWatcher);
        this.hWs = (EditText) findViewById(R.id.edit_vcode);
        this.hWs.addTextChangedListener(this.mTextWatcher);
        if (this.hWC) {
            this.hWq.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.hWr.setText(this.hWB);
        } else {
            this.hWq.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.hWz = (RelativeLayout) findViewById(R.id.create);
        this.hWu = (FrameLayout) findViewById(R.id.image_button);
        this.hWu.setOnClickListener(this.mOnClickListener);
        this.eNu = (ImageView) findViewById(R.id.image);
        this.hWt.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.hWv = (ProgressBar) findViewById(R.id.progress_image);
        if (this.hWC) {
            this.hWs.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.hWr.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.hWr);
                    }
                    if (CreateBarActivity.this.hWs.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.hWs);
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
        am.setButtonTextColor(this.hWA, i);
        am.setTextColor(this.hWq, i);
        String str = this.hWB + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.hWB.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.hWB.length(), str.length(), 33);
        am.setBackgroundResource(this.hWz, R.drawable.btn_general_start_selector);
        this.hWp.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String hWB;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.hWw = null;
        }

        public a(String str, String str2) {
            this.hWB = null;
            this.mVcode = null;
            this.hWB = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aUA().aVb().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.hWB);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.hWy);
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
            CreateBarActivity.this.hWw = null;
            if (this.mNetwork.aUA().aVc().isRequestSuccess()) {
                CreateBarSuccessActivity.aE(CreateBarActivity.this.getPageContext().getPageActivity(), this.hWB);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cem();
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
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        private x mNetwork;

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
            CreateBarActivity.this.hWv.setVisibility(8);
            CreateBarActivity.this.hWx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aUA().aVc().isRequestSuccess()) {
                    ab abVar = new ab();
                    abVar.parserJson(postNetData);
                    if (abVar.getVcode_pic_url() == null || abVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.hWy = abVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(abVar.getVcode_pic_url());
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
            CreateBarActivity.this.hWv.setVisibility(8);
            CreateBarActivity.this.hWx = null;
            if (bitmap != null) {
                CreateBarActivity.this.eNu.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.hWy = null;
            CreateBarActivity.this.hWv.setVisibility(0);
            CreateBarActivity.this.eNu.setImageDrawable(null);
        }
    }
}
