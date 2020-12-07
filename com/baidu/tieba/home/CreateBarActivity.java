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
    private RelativeLayout jIg;
    public NavigationBar mNavigationBar;
    private TextView jHW = null;
    private TextView jHX = null;
    private EditText jHY = null;
    private EditText jHZ = null;
    private RelativeLayout jIa = null;
    private FrameLayout jIb = null;
    private ImageView fYY = null;
    private ProgressBar mProgress = null;
    private ProgressBar jIc = null;
    private a jId = null;
    private b jIe = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String jIf = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView jIh = null;
    private String jIi = null;
    private boolean jIj = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cNj();
        adjustResizeForSoftInput();
    }

    private void cNj() {
        if (this.jIe == null) {
            this.jIe = new b();
            this.jIe.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jId != null) {
            this.jId.cancel();
        }
        if (this.jIe != null) {
            this.jIe.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.jIi = intent.getStringExtra("barname");
        this.jIj = intent.getBooleanExtra("isvalid", false);
        if (this.jIi == null) {
            this.jIi = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNk() {
        if (this.jIe == null && this.jId == null) {
            this.jIe = new b();
            this.jIe.setPriority(3);
            this.jIe.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNl() {
        if (this.jId == null) {
            this.jId = new a(this.jHY.getText().toString().trim(), this.jHZ.getText().toString().trim());
            this.jId.setPriority(3);
            this.jId.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.jIa) {
                    CreateBarActivity.this.cNl();
                } else if (view == CreateBarActivity.this.jIb) {
                    CreateBarActivity.this.cNk();
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
                int length = CreateBarActivity.this.jHY.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.jHZ.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.jIa.setEnabled(false);
                } else {
                    CreateBarActivity.this.jIa.setEnabled(true);
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
        this.jIh = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.jHW = (TextView) findViewById(R.id.info);
        this.jIa = (RelativeLayout) findViewById(R.id.create);
        this.jIa.setOnClickListener(this.mOnClickListener);
        this.jHX = (TextView) findViewById(R.id.info2);
        this.jHY = (EditText) findViewById(R.id.edit_name);
        this.jHY.addTextChangedListener(this.mTextWatcher);
        this.jHZ = (EditText) findViewById(R.id.edit_vcode);
        this.jHZ.addTextChangedListener(this.mTextWatcher);
        if (this.jIj) {
            this.jHX.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.jHY.setText(this.jIi);
        } else {
            this.jHX.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.jIg = (RelativeLayout) findViewById(R.id.create);
        this.jIb = (FrameLayout) findViewById(R.id.image_button);
        this.jIb.setOnClickListener(this.mOnClickListener);
        this.fYY = (ImageView) findViewById(R.id.image);
        this.jIa.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jIc = (ProgressBar) findViewById(R.id.progress_image);
        if (this.jIj) {
            this.jHZ.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.jHY.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jHY);
                    }
                    if (CreateBarActivity.this.jHZ.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jHZ);
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
        ap.setButtonTextColor(this.jIh, i);
        ap.setTextColor(this.jHX, i);
        String str = this.jIi + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10252)), 0, this.jIi.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.jIi.length(), str.length(), 33);
        ap.setBackgroundResource(this.jIg, R.drawable.btn_general_start_selector);
        this.jHW.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String jIi;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.jId = null;
        }

        public a(String str, String str2) {
            this.jIi = null;
            this.mVcode = null;
            this.jIi = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.btv().bue().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.jIi);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.jIf);
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
            CreateBarActivity.this.jId = null;
            if (this.mNetwork.btv().buf().isRequestSuccess()) {
                CreateBarSuccessActivity.aP(CreateBarActivity.this.getPageContext().getPageActivity(), this.jIi);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cNk();
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
            CreateBarActivity.this.jIc.setVisibility(8);
            CreateBarActivity.this.jIe = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.btv().buf().isRequestSuccess()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(postNetData);
                    if (ahVar.getVcode_pic_url() == null || ahVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.jIf = ahVar.getVcode_md5();
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
            CreateBarActivity.this.jIc.setVisibility(8);
            CreateBarActivity.this.jIe = null;
            if (bitmap != null) {
                CreateBarActivity.this.fYY.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.jIf = null;
            CreateBarActivity.this.jIc.setVisibility(0);
            CreateBarActivity.this.fYY.setImageDrawable(null);
        }
    }
}
