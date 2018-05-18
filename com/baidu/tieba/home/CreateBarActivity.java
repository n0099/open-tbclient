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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout dAI;
    public NavigationBar mNavigationBar;
    private TextView dAy = null;
    private TextView dAz = null;
    private EditText dAA = null;
    private EditText dAB = null;
    private RelativeLayout dAC = null;
    private FrameLayout dAD = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar dAE = null;
    private a dAF = null;
    private b dAG = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String dAH = null;
    private TextView mErrorView = null;
    private RelativeLayout bbZ = null;
    private TextView dAJ = null;
    private String dAK = null;
    private boolean dAL = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.create_bar_activity);
        initData();
        initUI();
        awR();
        adjustResizeForSoftInput();
    }

    private void awR() {
        if (this.dAG == null) {
            this.dAG = new b();
            this.dAG.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dAF != null) {
            this.dAF.cancel();
        }
        if (this.dAG != null) {
            this.dAG.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.dAK = intent.getStringExtra("barname");
        this.dAL = intent.getBooleanExtra("isvalid", false);
        if (this.dAK == null) {
            this.dAK = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awS() {
        if (this.dAG == null && this.dAF == null) {
            this.dAG = new b();
            this.dAG.setPriority(3);
            this.dAG.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awT() {
        if (this.dAF == null) {
            this.dAF = new a(this.dAA.getText().toString().trim(), this.dAB.getText().toString().trim());
            this.dAF.setPriority(3);
            this.dAF.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == CreateBarActivity.this.dAC) {
                    CreateBarActivity.this.awT();
                } else if (view2 == CreateBarActivity.this.dAD) {
                    CreateBarActivity.this.awS();
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
                int length = CreateBarActivity.this.dAA.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.dAB.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.dAC.setEnabled(false);
                } else {
                    CreateBarActivity.this.dAC.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(d.k.bar_name_long));
                    CreateBarActivity.this.mErrorView.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(d.k.bar_name_rule));
                CreateBarActivity.this.mErrorView.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.k.create_bar));
        this.bbZ = (RelativeLayout) findViewById(d.g.container);
        this.dAJ = (TextView) findViewById(d.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(d.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(d.g.error);
        this.dAy = (TextView) findViewById(d.g.info);
        this.dAC = (RelativeLayout) findViewById(d.g.create);
        this.dAC.setOnClickListener(this.mOnClickListener);
        this.dAz = (TextView) findViewById(d.g.info2);
        this.dAA = (EditText) findViewById(d.g.edit_name);
        this.dAA.addTextChangedListener(this.mTextWatcher);
        this.dAB = (EditText) findViewById(d.g.edit_vcode);
        this.dAB.addTextChangedListener(this.mTextWatcher);
        if (this.dAL) {
            this.dAz.setText(getPageContext().getString(d.k.noforum_create_form_tip));
            this.dAA.setText(this.dAK);
        } else {
            this.dAz.setText(getPageContext().getString(d.k.bar_name_invalid));
        }
        this.dAI = (RelativeLayout) findViewById(d.g.create);
        this.dAD = (FrameLayout) findViewById(d.g.image_button);
        this.dAD.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.dAC.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dAE = (ProgressBar) findViewById(d.g.progress_image);
        if (this.dAL) {
            this.dAB.requestFocus();
        }
        findViewById(d.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.dAA.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dAA);
                    }
                    if (CreateBarActivity.this.dAB.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dAB);
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
        getLayoutMode().u(this.bbZ);
        ak.a(this.dAJ, i);
        ak.b(this.dAz, i);
        String str = this.dAK + getPageContext().getString(d.k.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.common_color_10252)), 0, this.dAK.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.C0126d.common_color_10004)), this.dAK.length(), str.length(), 33);
        ak.i(this.dAI, d.f.btn_general_start_selector);
        this.dAy.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dAK;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.dAF = null;
        }

        public a(String str, String str2) {
            this.dAK = null;
            this.mVcode = null;
            this.dAK = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.vi().wh().mIsNeedTbs = true;
                this.mNetwork.n("kw", this.dAK);
                this.mNetwork.n("vcode", this.mVcode);
                this.mNetwork.n("vcode_md5", CreateBarActivity.this.dAH);
                this.mNetwork.uK();
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
            CreateBarActivity.this.dAF = null;
            if (this.mNetwork.vi().wi().isRequestSuccess()) {
                CreateBarSuccessActivity.ac(CreateBarActivity.this.getPageContext().getPageActivity(), this.dAK);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.vl()) {
                CreateBarActivity.this.awS();
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
                this.mNetwork.eW();
            }
            CreateBarActivity.this.dAE.setVisibility(8);
            CreateBarActivity.this.dAG = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetwork.n(ImageViewerConfig.FORUM_ID, "0");
                this.mNetwork.n("pub_type", "0");
                this.mNetwork.n(ImageViewerConfig.FORUM_NAME, "");
                this.mNetwork.n("tid", "0");
                String uK = this.mNetwork.uK();
                if (this.mNetwork.vi().wi().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(uK);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.dAH = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.uL());
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
            CreateBarActivity.this.dAE.setVisibility(8);
            CreateBarActivity.this.dAG = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.dAH = null;
            CreateBarActivity.this.dAE.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
