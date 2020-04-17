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
    private RelativeLayout hGU;
    public NavigationBar mNavigationBar;
    private TextView hGK = null;
    private TextView hGL = null;
    private EditText hGM = null;
    private EditText hGN = null;
    private RelativeLayout hGO = null;
    private FrameLayout hGP = null;
    private ImageView eyE = null;
    private ProgressBar mProgress = null;
    private ProgressBar hGQ = null;
    private a hGR = null;
    private b hGS = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String hGT = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView hGV = null;
    private String hGW = null;
    private boolean hGX = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        bXG();
        adjustResizeForSoftInput();
    }

    private void bXG() {
        if (this.hGS == null) {
            this.hGS = new b();
            this.hGS.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hGR != null) {
            this.hGR.cancel();
        }
        if (this.hGS != null) {
            this.hGS.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.hGW = intent.getStringExtra("barname");
        this.hGX = intent.getBooleanExtra("isvalid", false);
        if (this.hGW == null) {
            this.hGW = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXH() {
        if (this.hGS == null && this.hGR == null) {
            this.hGS = new b();
            this.hGS.setPriority(3);
            this.hGS.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXI() {
        if (this.hGR == null) {
            this.hGR = new a(this.hGM.getText().toString().trim(), this.hGN.getText().toString().trim());
            this.hGR.setPriority(3);
            this.hGR.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.hGO) {
                    CreateBarActivity.this.bXI();
                } else if (view == CreateBarActivity.this.hGP) {
                    CreateBarActivity.this.bXH();
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
                int length = CreateBarActivity.this.hGM.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.hGN.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.hGO.setEnabled(false);
                } else {
                    CreateBarActivity.this.hGO.setEnabled(true);
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
        this.hGV = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.hGK = (TextView) findViewById(R.id.info);
        this.hGO = (RelativeLayout) findViewById(R.id.create);
        this.hGO.setOnClickListener(this.mOnClickListener);
        this.hGL = (TextView) findViewById(R.id.info2);
        this.hGM = (EditText) findViewById(R.id.edit_name);
        this.hGM.addTextChangedListener(this.mTextWatcher);
        this.hGN = (EditText) findViewById(R.id.edit_vcode);
        this.hGN.addTextChangedListener(this.mTextWatcher);
        if (this.hGX) {
            this.hGL.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.hGM.setText(this.hGW);
        } else {
            this.hGL.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.hGU = (RelativeLayout) findViewById(R.id.create);
        this.hGP = (FrameLayout) findViewById(R.id.image_button);
        this.hGP.setOnClickListener(this.mOnClickListener);
        this.eyE = (ImageView) findViewById(R.id.image);
        this.hGO.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.hGQ = (ProgressBar) findViewById(R.id.progress_image);
        if (this.hGX) {
            this.hGN.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.hGM.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.hGM);
                    }
                    if (CreateBarActivity.this.hGN.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.hGN);
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
        am.setButtonTextColor(this.hGV, i);
        am.setTextColor(this.hGL, i);
        String str = this.hGW + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.hGW.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.hGW.length(), str.length(), 33);
        am.setBackgroundResource(this.hGU, R.drawable.btn_general_start_selector);
        this.hGK.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String hGW;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.hGR = null;
        }

        public a(String str, String str2) {
            this.hGW = null;
            this.mVcode = null;
            this.hGW = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aOy().aOZ().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.hGW);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.hGT);
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
            CreateBarActivity.this.hGR = null;
            if (this.mNetwork.aOy().aPa().isRequestSuccess()) {
                CreateBarSuccessActivity.aP(CreateBarActivity.this.getPageContext().getPageActivity(), this.hGW);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.bXH();
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
            CreateBarActivity.this.hGQ.setVisibility(8);
            CreateBarActivity.this.hGS = null;
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
                if (this.mNetwork.aOy().aPa().isRequestSuccess()) {
                    aa aaVar = new aa();
                    aaVar.parserJson(postNetData);
                    if (aaVar.getVcode_pic_url() == null || aaVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.hGT = aaVar.getVcode_md5();
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
            CreateBarActivity.this.hGQ.setVisibility(8);
            CreateBarActivity.this.hGS = null;
            if (bitmap != null) {
                CreateBarActivity.this.eyE.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.hGT = null;
            CreateBarActivity.this.hGQ.setVisibility(0);
            CreateBarActivity.this.eyE.setImageDrawable(null);
        }
    }
}
