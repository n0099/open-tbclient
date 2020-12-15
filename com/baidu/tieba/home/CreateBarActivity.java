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
    private RelativeLayout jIi;
    public NavigationBar mNavigationBar;
    private TextView jHY = null;
    private TextView jHZ = null;
    private EditText jIa = null;
    private EditText jIb = null;
    private RelativeLayout jIc = null;
    private FrameLayout jId = null;
    private ImageView fZa = null;
    private ProgressBar mProgress = null;
    private ProgressBar jIe = null;
    private a jIf = null;
    private b jIg = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String jIh = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView jIj = null;
    private String jIk = null;
    private boolean jIl = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cNk();
        adjustResizeForSoftInput();
    }

    private void cNk() {
        if (this.jIg == null) {
            this.jIg = new b();
            this.jIg.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jIf != null) {
            this.jIf.cancel();
        }
        if (this.jIg != null) {
            this.jIg.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.jIk = intent.getStringExtra("barname");
        this.jIl = intent.getBooleanExtra("isvalid", false);
        if (this.jIk == null) {
            this.jIk = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNl() {
        if (this.jIg == null && this.jIf == null) {
            this.jIg = new b();
            this.jIg.setPriority(3);
            this.jIg.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNm() {
        if (this.jIf == null) {
            this.jIf = new a(this.jIa.getText().toString().trim(), this.jIb.getText().toString().trim());
            this.jIf.setPriority(3);
            this.jIf.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.jIc) {
                    CreateBarActivity.this.cNm();
                } else if (view == CreateBarActivity.this.jId) {
                    CreateBarActivity.this.cNl();
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
                int length = CreateBarActivity.this.jIa.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.jIb.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.jIc.setEnabled(false);
                } else {
                    CreateBarActivity.this.jIc.setEnabled(true);
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
        this.jIj = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.jHY = (TextView) findViewById(R.id.info);
        this.jIc = (RelativeLayout) findViewById(R.id.create);
        this.jIc.setOnClickListener(this.mOnClickListener);
        this.jHZ = (TextView) findViewById(R.id.info2);
        this.jIa = (EditText) findViewById(R.id.edit_name);
        this.jIa.addTextChangedListener(this.mTextWatcher);
        this.jIb = (EditText) findViewById(R.id.edit_vcode);
        this.jIb.addTextChangedListener(this.mTextWatcher);
        if (this.jIl) {
            this.jHZ.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.jIa.setText(this.jIk);
        } else {
            this.jHZ.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.jIi = (RelativeLayout) findViewById(R.id.create);
        this.jId = (FrameLayout) findViewById(R.id.image_button);
        this.jId.setOnClickListener(this.mOnClickListener);
        this.fZa = (ImageView) findViewById(R.id.image);
        this.jIc.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jIe = (ProgressBar) findViewById(R.id.progress_image);
        if (this.jIl) {
            this.jIb.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.jIa.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jIa);
                    }
                    if (CreateBarActivity.this.jIb.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jIb);
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
        ap.setButtonTextColor(this.jIj, i);
        ap.setTextColor(this.jHZ, i);
        String str = this.jIk + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10252)), 0, this.jIk.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.jIk.length(), str.length(), 33);
        ap.setBackgroundResource(this.jIi, R.drawable.btn_general_start_selector);
        this.jHY.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String jIk;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.jIf = null;
        }

        public a(String str, String str2) {
            this.jIk = null;
            this.mVcode = null;
            this.jIk = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.btv().bue().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.jIk);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.jIh);
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
            CreateBarActivity.this.jIf = null;
            if (this.mNetwork.btv().buf().isRequestSuccess()) {
                CreateBarSuccessActivity.aP(CreateBarActivity.this.getPageContext().getPageActivity(), this.jIk);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cNl();
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
            CreateBarActivity.this.jIe.setVisibility(8);
            CreateBarActivity.this.jIg = null;
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
                    CreateBarActivity.this.jIh = ahVar.getVcode_md5();
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
            CreateBarActivity.this.jIe.setVisibility(8);
            CreateBarActivity.this.jIg = null;
            if (bitmap != null) {
                CreateBarActivity.this.fZa.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.jIh = null;
            CreateBarActivity.this.jIe.setVisibility(0);
            CreateBarActivity.this.fZa.setImageDrawable(null);
        }
    }
}
