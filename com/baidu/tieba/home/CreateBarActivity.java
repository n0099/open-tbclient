package com.baidu.tieba.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import androidx.core.internal.view.SupportMenu;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout jQN;
    public NavigationBar mNavigationBar;
    private TextView jQC = null;
    private TextView jQD = null;
    private EditText jQE = null;
    private EditText jQF = null;
    private RelativeLayout jQG = null;
    private FrameLayout jQH = null;
    private ImageView gdY = null;
    private ProgressBar mProgress = null;
    private ProgressBar jQI = null;
    private a jQJ = null;
    private b jQK = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String jQL = null;
    private TextView jQM = null;
    private RelativeLayout mContainer = null;
    private TextView jQO = null;
    private String jQP = null;
    private boolean jQQ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cMz();
        adjustResizeForSoftInput();
    }

    private void cMz() {
        if (this.jQK == null) {
            this.jQK = new b();
            this.jQK.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jQJ != null) {
            this.jQJ.cancel();
        }
        if (this.jQK != null) {
            this.jQK.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.jQP = intent.getStringExtra("barname");
        this.jQQ = intent.getBooleanExtra("isvalid", false);
        if (this.jQP == null) {
            this.jQP = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMA() {
        if (this.jQK == null && this.jQJ == null) {
            this.jQK = new b();
            this.jQK.setPriority(3);
            this.jQK.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMB() {
        if (this.jQJ == null) {
            this.jQJ = new a(this.jQE.getText().toString().trim(), this.jQF.getText().toString().trim());
            this.jQJ.setPriority(3);
            this.jQJ.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.jQG) {
                    CreateBarActivity.this.cMB();
                } else if (view == CreateBarActivity.this.jQH) {
                    CreateBarActivity.this.cMA();
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
                int length = CreateBarActivity.this.jQE.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.jQF.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.jQG.setEnabled(false);
                } else {
                    CreateBarActivity.this.jQG.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.jQM.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_long));
                    CreateBarActivity.this.jQM.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.jQM.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_rule));
                CreateBarActivity.this.jQM.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.jQO = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.jQM = (TextView) findViewById(R.id.error);
        this.jQC = (TextView) findViewById(R.id.info);
        this.jQG = (RelativeLayout) findViewById(R.id.create);
        this.jQG.setOnClickListener(this.mOnClickListener);
        this.jQD = (TextView) findViewById(R.id.info2);
        this.jQE = (EditText) findViewById(R.id.edit_name);
        this.jQE.addTextChangedListener(this.mTextWatcher);
        this.jQF = (EditText) findViewById(R.id.edit_vcode);
        this.jQF.addTextChangedListener(this.mTextWatcher);
        if (this.jQQ) {
            this.jQD.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.jQE.setText(this.jQP);
        } else {
            this.jQD.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.jQN = (RelativeLayout) findViewById(R.id.create);
        this.jQH = (FrameLayout) findViewById(R.id.image_button);
        this.jQH.setOnClickListener(this.mOnClickListener);
        this.gdY = (ImageView) findViewById(R.id.image);
        this.jQG.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jQI = (ProgressBar) findViewById(R.id.progress_image);
        if (this.jQQ) {
            this.jQF.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.jQE.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jQE);
                    }
                    if (CreateBarActivity.this.jQF.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jQF);
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
        ao.setButtonTextColor(this.jQO, i);
        ao.setTextColor(this.jQD, i);
        String str = this.jQP + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.common_color_10252)), 0, this.jQP.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.jQP.length(), str.length(), 33);
        ao.setBackgroundResource(this.jQN, R.drawable.btn_general_start_selector);
        this.jQC.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String jQP;
        private z mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.jQJ = null;
        }

        public a(String str, String str2) {
            this.jQP = null;
            this.mVcode = null;
            this.jQP = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.brX().bsG().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.jQP);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.jQL);
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
            CreateBarActivity.this.jQJ = null;
            if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                CreateBarSuccessActivity.aV(CreateBarActivity.this.getPageContext().getPageActivity(), this.jQP);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cMA();
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
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        private z mNetwork;

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
            CreateBarActivity.this.jQI.setVisibility(8);
            CreateBarActivity.this.jQK = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(postNetData);
                    if (ahVar.getVcode_pic_url() == null || ahVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.jQL = ahVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new z(ahVar.getVcode_pic_url());
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
            CreateBarActivity.this.jQI.setVisibility(8);
            CreateBarActivity.this.jQK = null;
            if (bitmap != null) {
                CreateBarActivity.this.gdY.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.jQL = null;
            CreateBarActivity.this.jQI.setVisibility(0);
            CreateBarActivity.this.gdY.setImageDrawable(null);
        }
    }
}
