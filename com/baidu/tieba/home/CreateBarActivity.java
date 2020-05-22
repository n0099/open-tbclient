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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout hVM;
    public NavigationBar mNavigationBar;
    private TextView hVC = null;
    private TextView hVD = null;
    private EditText hVE = null;
    private EditText hVF = null;
    private RelativeLayout hVG = null;
    private FrameLayout hVH = null;
    private ImageView eNj = null;
    private ProgressBar mProgress = null;
    private ProgressBar hVI = null;
    private a hVJ = null;
    private b hVK = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String hVL = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView hVN = null;
    private String hVO = null;
    private boolean hVP = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        ced();
        adjustResizeForSoftInput();
    }

    private void ced() {
        if (this.hVK == null) {
            this.hVK = new b();
            this.hVK.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hVJ != null) {
            this.hVJ.cancel();
        }
        if (this.hVK != null) {
            this.hVK.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.hVO = intent.getStringExtra("barname");
        this.hVP = intent.getBooleanExtra("isvalid", false);
        if (this.hVO == null) {
            this.hVO = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cee() {
        if (this.hVK == null && this.hVJ == null) {
            this.hVK = new b();
            this.hVK.setPriority(3);
            this.hVK.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cef() {
        if (this.hVJ == null) {
            this.hVJ = new a(this.hVE.getText().toString().trim(), this.hVF.getText().toString().trim());
            this.hVJ.setPriority(3);
            this.hVJ.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.hVG) {
                    CreateBarActivity.this.cef();
                } else if (view == CreateBarActivity.this.hVH) {
                    CreateBarActivity.this.cee();
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
                int length = CreateBarActivity.this.hVE.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.hVF.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.hVG.setEnabled(false);
                } else {
                    CreateBarActivity.this.hVG.setEnabled(true);
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
        this.hVN = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.hVC = (TextView) findViewById(R.id.info);
        this.hVG = (RelativeLayout) findViewById(R.id.create);
        this.hVG.setOnClickListener(this.mOnClickListener);
        this.hVD = (TextView) findViewById(R.id.info2);
        this.hVE = (EditText) findViewById(R.id.edit_name);
        this.hVE.addTextChangedListener(this.mTextWatcher);
        this.hVF = (EditText) findViewById(R.id.edit_vcode);
        this.hVF.addTextChangedListener(this.mTextWatcher);
        if (this.hVP) {
            this.hVD.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.hVE.setText(this.hVO);
        } else {
            this.hVD.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.hVM = (RelativeLayout) findViewById(R.id.create);
        this.hVH = (FrameLayout) findViewById(R.id.image_button);
        this.hVH.setOnClickListener(this.mOnClickListener);
        this.eNj = (ImageView) findViewById(R.id.image);
        this.hVG.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.hVI = (ProgressBar) findViewById(R.id.progress_image);
        if (this.hVP) {
            this.hVF.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.hVE.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.hVE);
                    }
                    if (CreateBarActivity.this.hVF.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.hVF);
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
        am.setButtonTextColor(this.hVN, i);
        am.setTextColor(this.hVD, i);
        String str = this.hVO + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.hVO.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.hVO.length(), str.length(), 33);
        am.setBackgroundResource(this.hVM, R.drawable.btn_general_start_selector);
        this.hVC.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String hVO;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.hVJ = null;
        }

        public a(String str, String str2) {
            this.hVO = null;
            this.mVcode = null;
            this.hVO = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aUA().aVa().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.hVO);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.hVL);
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
            CreateBarActivity.this.hVJ = null;
            if (this.mNetwork.aUA().aVb().isRequestSuccess()) {
                CreateBarSuccessActivity.aE(CreateBarActivity.this.getPageContext().getPageActivity(), this.hVO);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cee();
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
            CreateBarActivity.this.hVI.setVisibility(8);
            CreateBarActivity.this.hVK = null;
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
                if (this.mNetwork.aUA().aVb().isRequestSuccess()) {
                    aa aaVar = new aa();
                    aaVar.parserJson(postNetData);
                    if (aaVar.getVcode_pic_url() == null || aaVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.hVL = aaVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(aaVar.getVcode_pic_url());
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
            CreateBarActivity.this.hVI.setVisibility(8);
            CreateBarActivity.this.hVK = null;
            if (bitmap != null) {
                CreateBarActivity.this.eNj.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.hVL = null;
            CreateBarActivity.this.hVI.setVisibility(0);
            CreateBarActivity.this.eNj.setImageDrawable(null);
        }
    }
}
