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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout gdb;
    public NavigationBar mNavigationBar;
    private TextView gcR = null;
    private TextView gcS = null;
    private EditText gcT = null;
    private EditText gcU = null;
    private RelativeLayout gcV = null;
    private FrameLayout gcW = null;
    private ImageView dgU = null;
    private ProgressBar mProgress = null;
    private ProgressBar gcX = null;
    private a gcY = null;
    private b gcZ = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String gda = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView gdc = null;
    private String gdd = null;
    private boolean gde = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        bsM();
        adjustResizeForSoftInput();
    }

    private void bsM() {
        if (this.gcZ == null) {
            this.gcZ = new b();
            this.gcZ.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gcY != null) {
            this.gcY.cancel();
        }
        if (this.gcZ != null) {
            this.gcZ.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.gdd = intent.getStringExtra("barname");
        this.gde = intent.getBooleanExtra("isvalid", false);
        if (this.gdd == null) {
            this.gdd = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsN() {
        if (this.gcZ == null && this.gcY == null) {
            this.gcZ = new b();
            this.gcZ.setPriority(3);
            this.gcZ.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsO() {
        if (this.gcY == null) {
            this.gcY = new a(this.gcT.getText().toString().trim(), this.gcU.getText().toString().trim());
            this.gcY.setPriority(3);
            this.gcY.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.gcV) {
                    CreateBarActivity.this.bsO();
                } else if (view == CreateBarActivity.this.gcW) {
                    CreateBarActivity.this.bsN();
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
                int length = CreateBarActivity.this.gcT.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.gcU.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.gcV.setEnabled(false);
                } else {
                    CreateBarActivity.this.gcV.setEnabled(true);
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
        this.gdc = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.gcR = (TextView) findViewById(R.id.info);
        this.gcV = (RelativeLayout) findViewById(R.id.create);
        this.gcV.setOnClickListener(this.mOnClickListener);
        this.gcS = (TextView) findViewById(R.id.info2);
        this.gcT = (EditText) findViewById(R.id.edit_name);
        this.gcT.addTextChangedListener(this.mTextWatcher);
        this.gcU = (EditText) findViewById(R.id.edit_vcode);
        this.gcU.addTextChangedListener(this.mTextWatcher);
        if (this.gde) {
            this.gcS.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.gcT.setText(this.gdd);
        } else {
            this.gcS.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.gdb = (RelativeLayout) findViewById(R.id.create);
        this.gcW = (FrameLayout) findViewById(R.id.image_button);
        this.gcW.setOnClickListener(this.mOnClickListener);
        this.dgU = (ImageView) findViewById(R.id.image);
        this.gcV.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gcX = (ProgressBar) findViewById(R.id.progress_image);
        if (this.gde) {
            this.gcU.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.gcT.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gcT);
                    }
                    if (CreateBarActivity.this.gcU.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gcU);
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
        am.setButtonTextColor(this.gdc, i);
        am.setTextColor(this.gcS, i);
        String str = this.gdd + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.gdd.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.gdd.length(), str.length(), 33);
        am.setBackgroundResource(this.gdb, R.drawable.btn_general_start_selector);
        this.gcR.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String gdd;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.gcY = null;
        }

        public a(String str, String str2) {
            this.gdd = null;
            this.mVcode = null;
            this.gdd = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.amr().amR().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.gdd);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.gda);
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
            CreateBarActivity.this.gcY = null;
            if (this.mNetwork.amr().amS().isRequestSuccess()) {
                CreateBarSuccessActivity.aC(CreateBarActivity.this.getPageContext().getPageActivity(), this.gdd);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.bsN();
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
    /* loaded from: classes6.dex */
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
            CreateBarActivity.this.gcX.setVisibility(8);
            CreateBarActivity.this.gcZ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.amr().amS().isRequestSuccess()) {
                    y yVar = new y();
                    yVar.parserJson(postNetData);
                    if (yVar.getVcode_pic_url() == null || yVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.gda = yVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(yVar.getVcode_pic_url());
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
            CreateBarActivity.this.gcX.setVisibility(8);
            CreateBarActivity.this.gcZ = null;
            if (bitmap != null) {
                CreateBarActivity.this.dgU.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.gda = null;
            CreateBarActivity.this.gcX.setVisibility(0);
            CreateBarActivity.this.dgU.setImageDrawable(null);
        }
    }
}
