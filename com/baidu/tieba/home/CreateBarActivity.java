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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout jbH;
    public NavigationBar mNavigationBar;
    private TextView jbx = null;
    private TextView jby = null;
    private EditText jbz = null;
    private EditText jbA = null;
    private RelativeLayout jbB = null;
    private FrameLayout jbC = null;
    private ImageView fCW = null;
    private ProgressBar mProgress = null;
    private ProgressBar jbD = null;
    private a jbE = null;
    private b jbF = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String jbG = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView jbI = null;
    private String jbJ = null;
    private boolean jbK = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cCI();
        adjustResizeForSoftInput();
    }

    private void cCI() {
        if (this.jbF == null) {
            this.jbF = new b();
            this.jbF.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jbE != null) {
            this.jbE.cancel();
        }
        if (this.jbF != null) {
            this.jbF.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.jbJ = intent.getStringExtra("barname");
        this.jbK = intent.getBooleanExtra("isvalid", false);
        if (this.jbJ == null) {
            this.jbJ = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCJ() {
        if (this.jbF == null && this.jbE == null) {
            this.jbF = new b();
            this.jbF.setPriority(3);
            this.jbF.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCK() {
        if (this.jbE == null) {
            this.jbE = new a(this.jbz.getText().toString().trim(), this.jbA.getText().toString().trim());
            this.jbE.setPriority(3);
            this.jbE.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.jbB) {
                    CreateBarActivity.this.cCK();
                } else if (view == CreateBarActivity.this.jbC) {
                    CreateBarActivity.this.cCJ();
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
                int length = CreateBarActivity.this.jbz.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.jbA.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.jbB.setEnabled(false);
                } else {
                    CreateBarActivity.this.jbB.setEnabled(true);
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
        this.jbI = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.jbx = (TextView) findViewById(R.id.info);
        this.jbB = (RelativeLayout) findViewById(R.id.create);
        this.jbB.setOnClickListener(this.mOnClickListener);
        this.jby = (TextView) findViewById(R.id.info2);
        this.jbz = (EditText) findViewById(R.id.edit_name);
        this.jbz.addTextChangedListener(this.mTextWatcher);
        this.jbA = (EditText) findViewById(R.id.edit_vcode);
        this.jbA.addTextChangedListener(this.mTextWatcher);
        if (this.jbK) {
            this.jby.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.jbz.setText(this.jbJ);
        } else {
            this.jby.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.jbH = (RelativeLayout) findViewById(R.id.create);
        this.jbC = (FrameLayout) findViewById(R.id.image_button);
        this.jbC.setOnClickListener(this.mOnClickListener);
        this.fCW = (ImageView) findViewById(R.id.image);
        this.jbB.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jbD = (ProgressBar) findViewById(R.id.progress_image);
        if (this.jbK) {
            this.jbA.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.jbz.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jbz);
                    }
                    if (CreateBarActivity.this.jbA.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jbA);
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
        ap.setButtonTextColor(this.jbI, i);
        ap.setTextColor(this.jby, i);
        String str = this.jbJ + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10252)), 0, this.jbJ.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.jbJ.length(), str.length(), 33);
        ap.setBackgroundResource(this.jbH, R.drawable.btn_general_start_selector);
        this.jbx.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String jbJ;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.jbE = null;
        }

        public a(String str, String str2) {
            this.jbJ = null;
            this.mVcode = null;
            this.jbJ = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.bmu().bna().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.jbJ);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.jbG);
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
            CreateBarActivity.this.jbE = null;
            if (this.mNetwork.bmu().bnb().isRequestSuccess()) {
                CreateBarSuccessActivity.aM(CreateBarActivity.this.getPageContext().getPageActivity(), this.jbJ);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cCJ();
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
    /* loaded from: classes24.dex */
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
            CreateBarActivity.this.jbD.setVisibility(8);
            CreateBarActivity.this.jbF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bmu().bnb().isRequestSuccess()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(postNetData);
                    if (ahVar.getVcode_pic_url() == null || ahVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.jbG = ahVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new aa(ahVar.getVcode_pic_url());
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
            CreateBarActivity.this.jbD.setVisibility(8);
            CreateBarActivity.this.jbF = null;
            if (bitmap != null) {
                CreateBarActivity.this.fCW.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.jbG = null;
            CreateBarActivity.this.jbD.setVisibility(0);
            CreateBarActivity.this.fCW.setImageDrawable(null);
        }
    }
}
