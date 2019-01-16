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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout esN;
    public NavigationBar mNavigationBar;
    private TextView esD = null;
    private TextView esE = null;
    private EditText esF = null;
    private EditText esG = null;
    private RelativeLayout esH = null;
    private FrameLayout esI = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar esJ = null;
    private a esK = null;
    private b esL = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String esM = null;
    private TextView mErrorView = null;
    private RelativeLayout bBm = null;
    private TextView esO = null;
    private String esP = null;
    private boolean esQ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_bar_activity);
        initData();
        initUI();
        aLc();
        adjustResizeForSoftInput();
    }

    private void aLc() {
        if (this.esL == null) {
            this.esL = new b();
            this.esL.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.esK != null) {
            this.esK.cancel();
        }
        if (this.esL != null) {
            this.esL.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.esP = intent.getStringExtra("barname");
        this.esQ = intent.getBooleanExtra("isvalid", false);
        if (this.esP == null) {
            this.esP = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLd() {
        if (this.esL == null && this.esK == null) {
            this.esL = new b();
            this.esL.setPriority(3);
            this.esL.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLe() {
        if (this.esK == null) {
            this.esK = new a(this.esF.getText().toString().trim(), this.esG.getText().toString().trim());
            this.esK.setPriority(3);
            this.esK.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.esH) {
                    CreateBarActivity.this.aLe();
                } else if (view == CreateBarActivity.this.esI) {
                    CreateBarActivity.this.aLd();
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
                int length = CreateBarActivity.this.esF.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.esG.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.esH.setEnabled(false);
                } else {
                    CreateBarActivity.this.esH.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(e.j.bar_name_long));
                    CreateBarActivity.this.mErrorView.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(e.j.bar_name_rule));
                CreateBarActivity.this.mErrorView.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(e.j.create_bar));
        this.bBm = (RelativeLayout) findViewById(e.g.container);
        this.esO = (TextView) findViewById(e.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(e.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(e.g.error);
        this.esD = (TextView) findViewById(e.g.info);
        this.esH = (RelativeLayout) findViewById(e.g.create);
        this.esH.setOnClickListener(this.mOnClickListener);
        this.esE = (TextView) findViewById(e.g.info2);
        this.esF = (EditText) findViewById(e.g.edit_name);
        this.esF.addTextChangedListener(this.mTextWatcher);
        this.esG = (EditText) findViewById(e.g.edit_vcode);
        this.esG.addTextChangedListener(this.mTextWatcher);
        if (this.esQ) {
            this.esE.setText(getPageContext().getString(e.j.noforum_create_form_tip));
            this.esF.setText(this.esP);
        } else {
            this.esE.setText(getPageContext().getString(e.j.bar_name_invalid));
        }
        this.esN = (RelativeLayout) findViewById(e.g.create);
        this.esI = (FrameLayout) findViewById(e.g.image_button);
        this.esI.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.esH.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.esJ = (ProgressBar) findViewById(e.g.progress_image);
        if (this.esQ) {
            this.esG.requestFocus();
        }
        findViewById(e.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.esF.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.esF);
                    }
                    if (CreateBarActivity.this.esG.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.esG);
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
        getLayoutMode().onModeChanged(this.bBm);
        al.a(this.esO, i);
        al.b(this.esE, i);
        String str = this.esP + getPageContext().getString(e.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(e.d.common_color_10252)), 0, this.esP.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(e.d.common_color_10004)), this.esP.length(), str.length(), 33);
        al.i(this.esN, e.f.btn_general_start_selector);
        this.esD.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String esP;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.esK = null;
        }

        public a(String str, String str2) {
            this.esP = null;
            this.mVcode = null;
            this.esP = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.Dw().Eu().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.esP);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateBarActivity.this.esM);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.CY();
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
            CreateBarActivity.this.esK = null;
            if (this.mNetwork.Dw().Ev().isRequestSuccess()) {
                CreateBarSuccessActivity.aw(CreateBarActivity.this.getPageContext().getPageActivity(), this.esP);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.Dz()) {
                CreateBarActivity.this.aLd();
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
    /* loaded from: classes3.dex */
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
                this.mNetwork.jg();
            }
            CreateBarActivity.this.esJ.setVisibility(8);
            CreateBarActivity.this.esL = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetwork.x(ImageViewerConfig.FORUM_ID, "0");
                this.mNetwork.x("pub_type", "0");
                this.mNetwork.x(ImageViewerConfig.FORUM_NAME, "");
                this.mNetwork.x("tid", "0");
                String CY = this.mNetwork.CY();
                if (this.mNetwork.Dw().Ev().isRequestSuccess()) {
                    com.baidu.tbadk.coreExtra.data.x xVar = new com.baidu.tbadk.coreExtra.data.x();
                    xVar.parserJson(CY);
                    if (xVar.getVcode_pic_url() == null || xVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.esM = xVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(xVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.CZ());
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
            CreateBarActivity.this.esJ.setVisibility(8);
            CreateBarActivity.this.esL = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.esM = null;
            CreateBarActivity.this.esJ.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
