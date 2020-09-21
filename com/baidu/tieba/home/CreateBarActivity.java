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
/* loaded from: classes23.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout iMP;
    public NavigationBar mNavigationBar;
    private TextView iMF = null;
    private TextView iMG = null;
    private EditText iMH = null;
    private EditText iMI = null;
    private RelativeLayout iMJ = null;
    private FrameLayout iMK = null;
    private ImageView fqJ = null;
    private ProgressBar mProgress = null;
    private ProgressBar iML = null;
    private a iMM = null;
    private b iMN = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String iMO = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView iMQ = null;
    private String iMR = null;
    private boolean iMS = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        czl();
        adjustResizeForSoftInput();
    }

    private void czl() {
        if (this.iMN == null) {
            this.iMN = new b();
            this.iMN.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iMM != null) {
            this.iMM.cancel();
        }
        if (this.iMN != null) {
            this.iMN.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.iMR = intent.getStringExtra("barname");
        this.iMS = intent.getBooleanExtra("isvalid", false);
        if (this.iMR == null) {
            this.iMR = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czm() {
        if (this.iMN == null && this.iMM == null) {
            this.iMN = new b();
            this.iMN.setPriority(3);
            this.iMN.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czn() {
        if (this.iMM == null) {
            this.iMM = new a(this.iMH.getText().toString().trim(), this.iMI.getText().toString().trim());
            this.iMM.setPriority(3);
            this.iMM.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.iMJ) {
                    CreateBarActivity.this.czn();
                } else if (view == CreateBarActivity.this.iMK) {
                    CreateBarActivity.this.czm();
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
                int length = CreateBarActivity.this.iMH.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.iMI.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.iMJ.setEnabled(false);
                } else {
                    CreateBarActivity.this.iMJ.setEnabled(true);
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
        this.iMQ = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.iMF = (TextView) findViewById(R.id.info);
        this.iMJ = (RelativeLayout) findViewById(R.id.create);
        this.iMJ.setOnClickListener(this.mOnClickListener);
        this.iMG = (TextView) findViewById(R.id.info2);
        this.iMH = (EditText) findViewById(R.id.edit_name);
        this.iMH.addTextChangedListener(this.mTextWatcher);
        this.iMI = (EditText) findViewById(R.id.edit_vcode);
        this.iMI.addTextChangedListener(this.mTextWatcher);
        if (this.iMS) {
            this.iMG.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.iMH.setText(this.iMR);
        } else {
            this.iMG.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.iMP = (RelativeLayout) findViewById(R.id.create);
        this.iMK = (FrameLayout) findViewById(R.id.image_button);
        this.iMK.setOnClickListener(this.mOnClickListener);
        this.fqJ = (ImageView) findViewById(R.id.image);
        this.iMJ.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.iML = (ProgressBar) findViewById(R.id.progress_image);
        if (this.iMS) {
            this.iMI.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.iMH.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iMH);
                    }
                    if (CreateBarActivity.this.iMI.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.iMI);
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
        ap.setButtonTextColor(this.iMQ, i);
        ap.setTextColor(this.iMG, i);
        String str = this.iMR + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10252)), 0, this.iMR.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.iMR.length(), str.length(), 33);
        ap.setBackgroundResource(this.iMP, R.drawable.btn_general_start_selector);
        this.iMF.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String iMR;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.iMM = null;
        }

        public a(String str, String str2) {
            this.iMR = null;
            this.mVcode = null;
            this.iMR = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.bjL().bkq().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.iMR);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.iMO);
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
            CreateBarActivity.this.iMM = null;
            if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
                CreateBarSuccessActivity.aK(CreateBarActivity.this.getPageContext().getPageActivity(), this.iMR);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.czm();
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
    /* loaded from: classes23.dex */
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
            CreateBarActivity.this.iML.setVisibility(8);
            CreateBarActivity.this.iMN = null;
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
                if (this.mNetwork.bjL().bkr().isRequestSuccess()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(postNetData);
                    if (ahVar.getVcode_pic_url() == null || ahVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.iMO = ahVar.getVcode_md5();
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
            CreateBarActivity.this.iML.setVisibility(8);
            CreateBarActivity.this.iMN = null;
            if (bitmap != null) {
                CreateBarActivity.this.fqJ.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.iMO = null;
            CreateBarActivity.this.iML.setVisibility(0);
            CreateBarActivity.this.fqJ.setImageDrawable(null);
        }
    }
}
