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
/* loaded from: classes7.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout kaF;
    public NavigationBar mNavigationBar;
    private TextView kau = null;
    private TextView kav = null;
    private EditText kaw = null;
    private EditText kax = null;
    private RelativeLayout kay = null;
    private FrameLayout kaz = null;
    private ImageView ghV = null;
    private ProgressBar mProgress = null;
    private ProgressBar kaA = null;
    private a kaB = null;
    private b kaC = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String kaD = null;
    private TextView kaE = null;
    private RelativeLayout mContainer = null;
    private TextView kaG = null;
    private String kaH = null;
    private boolean kaI = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cOK();
        adjustResizeForSoftInput();
    }

    private void cOK() {
        if (this.kaC == null) {
            this.kaC = new b();
            this.kaC.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kaB != null) {
            this.kaB.cancel();
        }
        if (this.kaC != null) {
            this.kaC.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.kaH = intent.getStringExtra("barname");
        this.kaI = intent.getBooleanExtra("isvalid", false);
        if (this.kaH == null) {
            this.kaH = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOL() {
        if (this.kaC == null && this.kaB == null) {
            this.kaC = new b();
            this.kaC.setPriority(3);
            this.kaC.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOM() {
        if (this.kaB == null) {
            this.kaB = new a(this.kaw.getText().toString().trim(), this.kax.getText().toString().trim());
            this.kaB.setPriority(3);
            this.kaB.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.kay) {
                    CreateBarActivity.this.cOM();
                } else if (view == CreateBarActivity.this.kaz) {
                    CreateBarActivity.this.cOL();
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
                int length = CreateBarActivity.this.kaw.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.kax.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.kay.setEnabled(false);
                } else {
                    CreateBarActivity.this.kay.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.kaE.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_long));
                    CreateBarActivity.this.kaE.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.kaE.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_rule));
                CreateBarActivity.this.kaE.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.kaG = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.kaE = (TextView) findViewById(R.id.error);
        this.kau = (TextView) findViewById(R.id.info);
        this.kay = (RelativeLayout) findViewById(R.id.create);
        this.kay.setOnClickListener(this.mOnClickListener);
        this.kav = (TextView) findViewById(R.id.info2);
        this.kaw = (EditText) findViewById(R.id.edit_name);
        this.kaw.addTextChangedListener(this.mTextWatcher);
        this.kax = (EditText) findViewById(R.id.edit_vcode);
        this.kax.addTextChangedListener(this.mTextWatcher);
        if (this.kaI) {
            this.kav.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.kaw.setText(this.kaH);
        } else {
            this.kav.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.kaF = (RelativeLayout) findViewById(R.id.create);
        this.kaz = (FrameLayout) findViewById(R.id.image_button);
        this.kaz.setOnClickListener(this.mOnClickListener);
        this.ghV = (ImageView) findViewById(R.id.image);
        this.kay.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.kaA = (ProgressBar) findViewById(R.id.progress_image);
        if (this.kaI) {
            this.kax.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.kaw.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.kaw);
                    }
                    if (CreateBarActivity.this.kax.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.kax);
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
        ap.setButtonTextColor(this.kaG, i);
        ap.setTextColor(this.kav, i);
        String str = this.kaH + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10252)), 0, this.kaH.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.kaH.length(), str.length(), 33);
        ap.setBackgroundResource(this.kaF, R.drawable.btn_general_start_selector);
        this.kau.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String kaH;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.kaB = null;
        }

        public a(String str, String str2) {
            this.kaH = null;
            this.mVcode = null;
            this.kaH = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.bsu().btd().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.kaH);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.kaD);
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
            CreateBarActivity.this.kaB = null;
            if (this.mNetwork.bsu().bte().isRequestSuccess()) {
                CreateBarSuccessActivity.aS(CreateBarActivity.this.getPageContext().getPageActivity(), this.kaH);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cOL();
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
            CreateBarActivity.this.kaA.setVisibility(8);
            CreateBarActivity.this.kaC = null;
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
                if (this.mNetwork.bsu().bte().isRequestSuccess()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(postNetData);
                    if (ahVar.getVcode_pic_url() == null || ahVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.kaD = ahVar.getVcode_md5();
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
            CreateBarActivity.this.kaA.setVisibility(8);
            CreateBarActivity.this.kaC = null;
            if (bitmap != null) {
                CreateBarActivity.this.ghV.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.kaD = null;
            CreateBarActivity.this.kaA.setVisibility(0);
            CreateBarActivity.this.ghV.setImageDrawable(null);
        }
    }
}
