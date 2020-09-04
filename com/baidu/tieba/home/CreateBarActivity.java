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
    private RelativeLayout iFu;
    public NavigationBar mNavigationBar;
    private TextView iFk = null;
    private TextView iFl = null;
    private EditText iFm = null;
    private EditText iFn = null;
    private RelativeLayout iFo = null;
    private FrameLayout iFp = null;
    private ImageView fnE = null;
    private ProgressBar mProgress = null;
    private ProgressBar iFq = null;
    private a iFr = null;
    private b iFs = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String iFt = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView iFv = null;
    private String iFw = null;
    private boolean iFx = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cvS();
        adjustResizeForSoftInput();
    }

    private void cvS() {
        if (this.iFs == null) {
            this.iFs = new b();
            this.iFs.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iFr != null) {
            this.iFr.cancel();
        }
        if (this.iFs != null) {
            this.iFs.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.iFw = intent.getStringExtra("barname");
        this.iFx = intent.getBooleanExtra("isvalid", false);
        if (this.iFw == null) {
            this.iFw = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvT() {
        if (this.iFs == null && this.iFr == null) {
            this.iFs = new b();
            this.iFs.setPriority(3);
            this.iFs.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvU() {
        if (this.iFr == null) {
            this.iFr = new a(this.iFm.getText().toString().trim(), this.iFn.getText().toString().trim());
            this.iFr.setPriority(3);
            this.iFr.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.iFo) {
                    CreateBarActivity.this.cvU();
                } else if (view == CreateBarActivity.this.iFp) {
                    CreateBarActivity.this.cvT();
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
                int length = CreateBarActivity.this.iFm.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.iFn.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.iFo.setEnabled(false);
                } else {
                    CreateBarActivity.this.iFo.setEnabled(true);
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
        this.iFv = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.iFk = (TextView) findViewById(R.id.info);
        this.iFo = (RelativeLayout) findViewById(R.id.create);
        this.iFo.setOnClickListener(this.mOnClickListener);
        this.iFl = (TextView) findViewById(R.id.info2);
        this.iFm = (EditText) findViewById(R.id.edit_name);
        this.iFm.addTextChangedListener(this.mTextWatcher);
        this.iFn = (EditText) findViewById(R.id.edit_vcode);
        this.iFn.addTextChangedListener(this.mTextWatcher);
        if (this.iFx) {
            this.iFl.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.iFm.setText(this.iFw);
        } else {
            this.iFl.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.iFu = (RelativeLayout) findViewById(R.id.create);
        this.iFp = (FrameLayout) findViewById(R.id.image_button);
        this.iFp.setOnClickListener(this.mOnClickListener);
        this.fnE = (ImageView) findViewById(R.id.image);
        this.iFo.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.iFq = (ProgressBar) findViewById(R.id.progress_image);
        if (this.iFx) {
            this.iFn.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.iFm.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iFm);
                    }
                    if (CreateBarActivity.this.iFn.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iFn);
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
        ap.setButtonTextColor(this.iFv, i);
        ap.setTextColor(this.iFl, i);
        String str = this.iFw + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10252)), 0, this.iFw.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.iFw.length(), str.length(), 33);
        ap.setBackgroundResource(this.iFu, R.drawable.btn_general_start_selector);
        this.iFk.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String iFw;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.iFr = null;
        }

        public a(String str, String str2) {
            this.iFw = null;
            this.mVcode = null;
            this.iFw = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.biQ().bjv().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.iFw);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.iFt);
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
            CreateBarActivity.this.iFr = null;
            if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                CreateBarSuccessActivity.aH(CreateBarActivity.this.getPageContext().getPageActivity(), this.iFw);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cvT();
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
            CreateBarActivity.this.iFq.setVisibility(8);
            CreateBarActivity.this.iFs = null;
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
                    CreateBarActivity.this.iFt = agVar.getVcode_md5();
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
            CreateBarActivity.this.iFq.setVisibility(8);
            CreateBarActivity.this.iFs = null;
            if (bitmap != null) {
                CreateBarActivity.this.fnE.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.iFt = null;
            CreateBarActivity.this.iFq.setVisibility(0);
            CreateBarActivity.this.fnE.setImageDrawable(null);
        }
    }
}
