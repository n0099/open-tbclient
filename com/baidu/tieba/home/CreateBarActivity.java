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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout gaW;
    public NavigationBar mNavigationBar;
    private TextView gaM = null;
    private TextView gaN = null;
    private EditText gaO = null;
    private EditText gaP = null;
    private RelativeLayout gaQ = null;
    private FrameLayout gaR = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar gaS = null;
    private a gaT = null;
    private b gaU = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String gaV = null;
    private TextView mErrorView = null;
    private RelativeLayout cWd = null;
    private TextView gaX = null;
    private String gaY = null;
    private boolean gaZ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        buG();
        adjustResizeForSoftInput();
    }

    private void buG() {
        if (this.gaU == null) {
            this.gaU = new b();
            this.gaU.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gaT != null) {
            this.gaT.cancel();
        }
        if (this.gaU != null) {
            this.gaU.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.gaY = intent.getStringExtra("barname");
        this.gaZ = intent.getBooleanExtra("isvalid", false);
        if (this.gaY == null) {
            this.gaY = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buH() {
        if (this.gaU == null && this.gaT == null) {
            this.gaU = new b();
            this.gaU.setPriority(3);
            this.gaU.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buI() {
        if (this.gaT == null) {
            this.gaT = new a(this.gaO.getText().toString().trim(), this.gaP.getText().toString().trim());
            this.gaT.setPriority(3);
            this.gaT.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.gaQ) {
                    CreateBarActivity.this.buI();
                } else if (view == CreateBarActivity.this.gaR) {
                    CreateBarActivity.this.buH();
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
                int length = CreateBarActivity.this.gaO.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.gaP.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.gaQ.setEnabled(false);
                } else {
                    CreateBarActivity.this.gaQ.setEnabled(true);
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
        this.cWd = (RelativeLayout) findViewById(R.id.container);
        this.gaX = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.gaM = (TextView) findViewById(R.id.info);
        this.gaQ = (RelativeLayout) findViewById(R.id.create);
        this.gaQ.setOnClickListener(this.mOnClickListener);
        this.gaN = (TextView) findViewById(R.id.info2);
        this.gaO = (EditText) findViewById(R.id.edit_name);
        this.gaO.addTextChangedListener(this.mTextWatcher);
        this.gaP = (EditText) findViewById(R.id.edit_vcode);
        this.gaP.addTextChangedListener(this.mTextWatcher);
        if (this.gaZ) {
            this.gaN.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.gaO.setText(this.gaY);
        } else {
            this.gaN.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.gaW = (RelativeLayout) findViewById(R.id.create);
        this.gaR = (FrameLayout) findViewById(R.id.image_button);
        this.gaR.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.gaQ.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gaS = (ProgressBar) findViewById(R.id.progress_image);
        if (this.gaZ) {
            this.gaP.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.gaO.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gaO);
                    }
                    if (CreateBarActivity.this.gaP.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gaP);
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
        getLayoutMode().onModeChanged(this.cWd);
        am.a(this.gaX, i);
        am.b(this.gaN, i);
        String str = this.gaY + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.gaY.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.gaY.length(), str.length(), 33);
        am.k(this.gaW, R.drawable.btn_general_start_selector);
        this.gaM.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String gaY;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ik();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.gaT = null;
        }

        public a(String str, String str2) {
            this.gaY = null;
            this.mVcode = null;
            this.gaY = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.aiE().ajE().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.gaY);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateBarActivity.this.gaV);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.aig();
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
            CreateBarActivity.this.gaT = null;
            if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                CreateBarSuccessActivity.ay(CreateBarActivity.this.getPageContext().getPageActivity(), this.gaY);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.aiH()) {
                CreateBarActivity.this.buH();
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
                this.mNetwork.ik();
            }
            CreateBarActivity.this.gaS.setVisibility(8);
            CreateBarActivity.this.gaU = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetwork.o("fid", "0");
                this.mNetwork.o("pub_type", "0");
                this.mNetwork.o(ImageViewerConfig.FORUM_NAME, "");
                this.mNetwork.o("tid", "0");
                String aig = this.mNetwork.aig();
                if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                    com.baidu.tbadk.coreExtra.data.x xVar = new com.baidu.tbadk.coreExtra.data.x();
                    xVar.parserJson(aig);
                    if (xVar.getVcode_pic_url() == null || xVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.gaV = xVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(xVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.aih());
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
            CreateBarActivity.this.gaS.setVisibility(8);
            CreateBarActivity.this.gaU = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.gaV = null;
            CreateBarActivity.this.gaS.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
