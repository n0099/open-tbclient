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
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout gTI;
    public NavigationBar mNavigationBar;
    private TextView gTy = null;
    private TextView gTz = null;
    private EditText gTA = null;
    private EditText gTB = null;
    private RelativeLayout gTC = null;
    private FrameLayout gTD = null;
    private ImageView dTY = null;
    private ProgressBar mProgress = null;
    private ProgressBar gTE = null;
    private a gTF = null;
    private b gTG = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String gTH = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView gTJ = null;
    private String gTK = null;
    private boolean gTL = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        bLl();
        adjustResizeForSoftInput();
    }

    private void bLl() {
        if (this.gTG == null) {
            this.gTG = new b();
            this.gTG.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gTF != null) {
            this.gTF.cancel();
        }
        if (this.gTG != null) {
            this.gTG.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.gTK = intent.getStringExtra("barname");
        this.gTL = intent.getBooleanExtra("isvalid", false);
        if (this.gTK == null) {
            this.gTK = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLm() {
        if (this.gTG == null && this.gTF == null) {
            this.gTG = new b();
            this.gTG.setPriority(3);
            this.gTG.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLn() {
        if (this.gTF == null) {
            this.gTF = new a(this.gTA.getText().toString().trim(), this.gTB.getText().toString().trim());
            this.gTF.setPriority(3);
            this.gTF.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.gTC) {
                    CreateBarActivity.this.bLn();
                } else if (view == CreateBarActivity.this.gTD) {
                    CreateBarActivity.this.bLm();
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
                int length = CreateBarActivity.this.gTA.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.gTB.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.gTC.setEnabled(false);
                } else {
                    CreateBarActivity.this.gTC.setEnabled(true);
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
        this.gTJ = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.gTy = (TextView) findViewById(R.id.info);
        this.gTC = (RelativeLayout) findViewById(R.id.create);
        this.gTC.setOnClickListener(this.mOnClickListener);
        this.gTz = (TextView) findViewById(R.id.info2);
        this.gTA = (EditText) findViewById(R.id.edit_name);
        this.gTA.addTextChangedListener(this.mTextWatcher);
        this.gTB = (EditText) findViewById(R.id.edit_vcode);
        this.gTB.addTextChangedListener(this.mTextWatcher);
        if (this.gTL) {
            this.gTz.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.gTA.setText(this.gTK);
        } else {
            this.gTz.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.gTI = (RelativeLayout) findViewById(R.id.create);
        this.gTD = (FrameLayout) findViewById(R.id.image_button);
        this.gTD.setOnClickListener(this.mOnClickListener);
        this.dTY = (ImageView) findViewById(R.id.image);
        this.gTC.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gTE = (ProgressBar) findViewById(R.id.progress_image);
        if (this.gTL) {
            this.gTB.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.gTA.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gTA);
                    }
                    if (CreateBarActivity.this.gTB.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gTB);
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
        am.setButtonTextColor(this.gTJ, i);
        am.setTextColor(this.gTz, i);
        String str = this.gTK + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.gTK.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.gTK.length(), str.length(), 33);
        am.setBackgroundResource(this.gTI, R.drawable.btn_general_start_selector);
        this.gTy.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String gTK;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.gTF = null;
        }

        public a(String str, String str2) {
            this.gTK = null;
            this.mVcode = null;
            this.gTK = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aDU().aEu().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.gTK);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.gTH);
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
            CreateBarActivity.this.gTF = null;
            if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                CreateBarSuccessActivity.aU(CreateBarActivity.this.getPageContext().getPageActivity(), this.gTK);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.bLm();
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
    /* loaded from: classes9.dex */
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
            CreateBarActivity.this.gTE.setVisibility(8);
            CreateBarActivity.this.gTG = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aDU().aEv().isRequestSuccess()) {
                    z zVar = new z();
                    zVar.parserJson(postNetData);
                    if (zVar.getVcode_pic_url() == null || zVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.gTH = zVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(zVar.getVcode_pic_url());
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
            CreateBarActivity.this.gTE.setVisibility(8);
            CreateBarActivity.this.gTG = null;
            if (bitmap != null) {
                CreateBarActivity.this.dTY.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.gTH = null;
            CreateBarActivity.this.gTE.setVisibility(0);
            CreateBarActivity.this.dTY.setImageDrawable(null);
        }
    }
}
