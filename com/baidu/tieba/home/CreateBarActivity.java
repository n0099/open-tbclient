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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout ikU;
    public NavigationBar mNavigationBar;
    private TextView ikK = null;
    private TextView ikL = null;
    private EditText ikM = null;
    private EditText ikN = null;
    private RelativeLayout ikO = null;
    private FrameLayout ikP = null;
    private ImageView eXF = null;
    private ProgressBar mProgress = null;
    private ProgressBar ikQ = null;
    private a ikR = null;
    private b ikS = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String ikT = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView ikV = null;
    private String ikW = null;
    private boolean ikX = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        chJ();
        adjustResizeForSoftInput();
    }

    private void chJ() {
        if (this.ikS == null) {
            this.ikS = new b();
            this.ikS.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ikR != null) {
            this.ikR.cancel();
        }
        if (this.ikS != null) {
            this.ikS.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.ikW = intent.getStringExtra("barname");
        this.ikX = intent.getBooleanExtra("isvalid", false);
        if (this.ikW == null) {
            this.ikW = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chK() {
        if (this.ikS == null && this.ikR == null) {
            this.ikS = new b();
            this.ikS.setPriority(3);
            this.ikS.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chL() {
        if (this.ikR == null) {
            this.ikR = new a(this.ikM.getText().toString().trim(), this.ikN.getText().toString().trim());
            this.ikR.setPriority(3);
            this.ikR.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.ikO) {
                    CreateBarActivity.this.chL();
                } else if (view == CreateBarActivity.this.ikP) {
                    CreateBarActivity.this.chK();
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
                int length = CreateBarActivity.this.ikM.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.ikN.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.ikO.setEnabled(false);
                } else {
                    CreateBarActivity.this.ikO.setEnabled(true);
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
        this.ikV = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.ikK = (TextView) findViewById(R.id.info);
        this.ikO = (RelativeLayout) findViewById(R.id.create);
        this.ikO.setOnClickListener(this.mOnClickListener);
        this.ikL = (TextView) findViewById(R.id.info2);
        this.ikM = (EditText) findViewById(R.id.edit_name);
        this.ikM.addTextChangedListener(this.mTextWatcher);
        this.ikN = (EditText) findViewById(R.id.edit_vcode);
        this.ikN.addTextChangedListener(this.mTextWatcher);
        if (this.ikX) {
            this.ikL.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.ikM.setText(this.ikW);
        } else {
            this.ikL.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.ikU = (RelativeLayout) findViewById(R.id.create);
        this.ikP = (FrameLayout) findViewById(R.id.image_button);
        this.ikP.setOnClickListener(this.mOnClickListener);
        this.eXF = (ImageView) findViewById(R.id.image);
        this.ikO.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.ikQ = (ProgressBar) findViewById(R.id.progress_image);
        if (this.ikX) {
            this.ikN.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.ikM.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.ikM);
                    }
                    if (CreateBarActivity.this.ikN.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.ikN);
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
        an.setButtonTextColor(this.ikV, i);
        an.setTextColor(this.ikL, i);
        String str = this.ikW + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(an.getColor(R.color.common_color_10252)), 0, this.ikW.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.ikW.length(), str.length(), 33);
        an.setBackgroundResource(this.ikU, R.drawable.btn_general_start_selector);
        this.ikK.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String ikW;
        private y mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.ikR = null;
        }

        public a(String str, String str2) {
            this.ikW = null;
            this.mVcode = null;
            this.ikW = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aWu().aWV().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.ikW);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.ikT);
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
            CreateBarActivity.this.ikR = null;
            if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
                CreateBarSuccessActivity.aE(CreateBarActivity.this.getPageContext().getPageActivity(), this.ikW);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.chK();
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
        private y mNetwork;

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
            CreateBarActivity.this.ikQ.setVisibility(8);
            CreateBarActivity.this.ikS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
                    ad adVar = new ad();
                    adVar.parserJson(postNetData);
                    if (adVar.getVcode_pic_url() == null || adVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.ikT = adVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new y(adVar.getVcode_pic_url());
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
            CreateBarActivity.this.ikQ.setVisibility(8);
            CreateBarActivity.this.ikS = null;
            if (bitmap != null) {
                CreateBarActivity.this.eXF.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.ikT = null;
            CreateBarActivity.this.ikQ.setVisibility(0);
            CreateBarActivity.this.eXF.setImageDrawable(null);
        }
    }
}
