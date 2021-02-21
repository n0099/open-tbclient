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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout jYD;
    public NavigationBar mNavigationBar;
    private TextView jYs = null;
    private TextView jYt = null;
    private EditText jYu = null;
    private EditText jYv = null;
    private RelativeLayout jYw = null;
    private FrameLayout jYx = null;
    private ImageView ggs = null;
    private ProgressBar mProgress = null;
    private ProgressBar jYy = null;
    private a jYz = null;
    private b jYA = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String jYB = null;
    private TextView jYC = null;
    private RelativeLayout mContainer = null;
    private TextView jYE = null;
    private String jYF = null;
    private boolean jYG = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cOD();
        adjustResizeForSoftInput();
    }

    private void cOD() {
        if (this.jYA == null) {
            this.jYA = new b();
            this.jYA.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jYz != null) {
            this.jYz.cancel();
        }
        if (this.jYA != null) {
            this.jYA.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.jYF = intent.getStringExtra("barname");
        this.jYG = intent.getBooleanExtra("isvalid", false);
        if (this.jYF == null) {
            this.jYF = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOE() {
        if (this.jYA == null && this.jYz == null) {
            this.jYA = new b();
            this.jYA.setPriority(3);
            this.jYA.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOF() {
        if (this.jYz == null) {
            this.jYz = new a(this.jYu.getText().toString().trim(), this.jYv.getText().toString().trim());
            this.jYz.setPriority(3);
            this.jYz.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.jYw) {
                    CreateBarActivity.this.cOF();
                } else if (view == CreateBarActivity.this.jYx) {
                    CreateBarActivity.this.cOE();
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
                int length = CreateBarActivity.this.jYu.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.jYv.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.jYw.setEnabled(false);
                } else {
                    CreateBarActivity.this.jYw.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.jYC.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_long));
                    CreateBarActivity.this.jYC.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.jYC.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_rule));
                CreateBarActivity.this.jYC.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.jYE = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.jYC = (TextView) findViewById(R.id.error);
        this.jYs = (TextView) findViewById(R.id.info);
        this.jYw = (RelativeLayout) findViewById(R.id.create);
        this.jYw.setOnClickListener(this.mOnClickListener);
        this.jYt = (TextView) findViewById(R.id.info2);
        this.jYu = (EditText) findViewById(R.id.edit_name);
        this.jYu.addTextChangedListener(this.mTextWatcher);
        this.jYv = (EditText) findViewById(R.id.edit_vcode);
        this.jYv.addTextChangedListener(this.mTextWatcher);
        if (this.jYG) {
            this.jYt.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.jYu.setText(this.jYF);
        } else {
            this.jYt.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.jYD = (RelativeLayout) findViewById(R.id.create);
        this.jYx = (FrameLayout) findViewById(R.id.image_button);
        this.jYx.setOnClickListener(this.mOnClickListener);
        this.ggs = (ImageView) findViewById(R.id.image);
        this.jYw.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jYy = (ProgressBar) findViewById(R.id.progress_image);
        if (this.jYG) {
            this.jYv.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.jYu.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jYu);
                    }
                    if (CreateBarActivity.this.jYv.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jYv);
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
        ap.setButtonTextColor(this.jYE, i);
        ap.setTextColor(this.jYt, i);
        String str = this.jYF + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10252)), 0, this.jYF.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.jYF.length(), str.length(), 33);
        ap.setBackgroundResource(this.jYD, R.drawable.btn_general_start_selector);
        this.jYs.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String jYF;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.jYz = null;
        }

        public a(String str, String str2) {
            this.jYF = null;
            this.mVcode = null;
            this.jYF = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.bsr().bta().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.jYF);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.jYB);
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
            CreateBarActivity.this.jYz = null;
            if (this.mNetwork.bsr().btb().isRequestSuccess()) {
                CreateBarSuccessActivity.aS(CreateBarActivity.this.getPageContext().getPageActivity(), this.jYF);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cOE();
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
    /* loaded from: classes8.dex */
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
            CreateBarActivity.this.jYy.setVisibility(8);
            CreateBarActivity.this.jYA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: S */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bsr().btb().isRequestSuccess()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(postNetData);
                    if (ahVar.getVcode_pic_url() == null || ahVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.jYB = ahVar.getVcode_md5();
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
            CreateBarActivity.this.jYy.setVisibility(8);
            CreateBarActivity.this.jYA = null;
            if (bitmap != null) {
                CreateBarActivity.this.ggs.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.jYB = null;
            CreateBarActivity.this.jYy.setVisibility(0);
            CreateBarActivity.this.ggs.setImageDrawable(null);
        }
    }
}
