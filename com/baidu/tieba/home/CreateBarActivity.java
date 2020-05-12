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
    private RelativeLayout hHa;
    public NavigationBar mNavigationBar;
    private TextView hGQ = null;
    private TextView hGR = null;
    private EditText hGS = null;
    private EditText hGT = null;
    private RelativeLayout hGU = null;
    private FrameLayout hGV = null;
    private ImageView eyJ = null;
    private ProgressBar mProgress = null;
    private ProgressBar hGW = null;
    private a hGX = null;
    private b hGY = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String hGZ = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView hHb = null;
    private String hHc = null;
    private boolean hHd = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        bXF();
        adjustResizeForSoftInput();
    }

    private void bXF() {
        if (this.hGY == null) {
            this.hGY = new b();
            this.hGY.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hGX != null) {
            this.hGX.cancel();
        }
        if (this.hGY != null) {
            this.hGY.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.hHc = intent.getStringExtra("barname");
        this.hHd = intent.getBooleanExtra("isvalid", false);
        if (this.hHc == null) {
            this.hHc = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXG() {
        if (this.hGY == null && this.hGX == null) {
            this.hGY = new b();
            this.hGY.setPriority(3);
            this.hGY.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXH() {
        if (this.hGX == null) {
            this.hGX = new a(this.hGS.getText().toString().trim(), this.hGT.getText().toString().trim());
            this.hGX.setPriority(3);
            this.hGX.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.hGU) {
                    CreateBarActivity.this.bXH();
                } else if (view == CreateBarActivity.this.hGV) {
                    CreateBarActivity.this.bXG();
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
                int length = CreateBarActivity.this.hGS.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.hGT.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.hGU.setEnabled(false);
                } else {
                    CreateBarActivity.this.hGU.setEnabled(true);
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
        this.hHb = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.hGQ = (TextView) findViewById(R.id.info);
        this.hGU = (RelativeLayout) findViewById(R.id.create);
        this.hGU.setOnClickListener(this.mOnClickListener);
        this.hGR = (TextView) findViewById(R.id.info2);
        this.hGS = (EditText) findViewById(R.id.edit_name);
        this.hGS.addTextChangedListener(this.mTextWatcher);
        this.hGT = (EditText) findViewById(R.id.edit_vcode);
        this.hGT.addTextChangedListener(this.mTextWatcher);
        if (this.hHd) {
            this.hGR.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.hGS.setText(this.hHc);
        } else {
            this.hGR.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.hHa = (RelativeLayout) findViewById(R.id.create);
        this.hGV = (FrameLayout) findViewById(R.id.image_button);
        this.hGV.setOnClickListener(this.mOnClickListener);
        this.eyJ = (ImageView) findViewById(R.id.image);
        this.hGU.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.hGW = (ProgressBar) findViewById(R.id.progress_image);
        if (this.hHd) {
            this.hGT.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.hGS.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.hGS);
                    }
                    if (CreateBarActivity.this.hGT.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.hGT);
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
        am.setButtonTextColor(this.hHb, i);
        am.setTextColor(this.hGR, i);
        String str = this.hHc + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.hHc.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.hHc.length(), str.length(), 33);
        am.setBackgroundResource(this.hHa, R.drawable.btn_general_start_selector);
        this.hGQ.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String hHc;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.hGX = null;
        }

        public a(String str, String str2) {
            this.hHc = null;
            this.mVcode = null;
            this.hHc = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aOw().aOW().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.hHc);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.hGZ);
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
            CreateBarActivity.this.hGX = null;
            if (this.mNetwork.aOw().aOX().isRequestSuccess()) {
                CreateBarSuccessActivity.aD(CreateBarActivity.this.getPageContext().getPageActivity(), this.hHc);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.bXG();
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
            CreateBarActivity.this.hGW.setVisibility(8);
            CreateBarActivity.this.hGY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aOw().aOX().isRequestSuccess()) {
                    aa aaVar = new aa();
                    aaVar.parserJson(postNetData);
                    if (aaVar.getVcode_pic_url() == null || aaVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.hGZ = aaVar.getVcode_md5();
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
            CreateBarActivity.this.hGW.setVisibility(8);
            CreateBarActivity.this.hGY = null;
            if (bitmap != null) {
                CreateBarActivity.this.eyJ.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.hGZ = null;
            CreateBarActivity.this.hGW.setVisibility(0);
            CreateBarActivity.this.eyJ.setImageDrawable(null);
        }
    }
}
