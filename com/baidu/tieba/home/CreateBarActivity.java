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
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout fVX;
    public NavigationBar mNavigationBar;
    private TextView fVN = null;
    private TextView fVO = null;
    private EditText fVP = null;
    private EditText fVQ = null;
    private RelativeLayout fVR = null;
    private FrameLayout fVS = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar fVT = null;
    private a fVU = null;
    private b fVV = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String fVW = null;
    private TextView mErrorView = null;
    private RelativeLayout cUG = null;
    private TextView fVY = null;
    private String fVZ = null;
    private boolean fWa = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        bsD();
        adjustResizeForSoftInput();
    }

    private void bsD() {
        if (this.fVV == null) {
            this.fVV = new b();
            this.fVV.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fVU != null) {
            this.fVU.cancel();
        }
        if (this.fVV != null) {
            this.fVV.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.fVZ = intent.getStringExtra("barname");
        this.fWa = intent.getBooleanExtra("isvalid", false);
        if (this.fVZ == null) {
            this.fVZ = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsE() {
        if (this.fVV == null && this.fVU == null) {
            this.fVV = new b();
            this.fVV.setPriority(3);
            this.fVV.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsF() {
        if (this.fVU == null) {
            this.fVU = new a(this.fVP.getText().toString().trim(), this.fVQ.getText().toString().trim());
            this.fVU.setPriority(3);
            this.fVU.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.fVR) {
                    CreateBarActivity.this.bsF();
                } else if (view == CreateBarActivity.this.fVS) {
                    CreateBarActivity.this.bsE();
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
                int length = CreateBarActivity.this.fVP.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.fVQ.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.fVR.setEnabled(false);
                } else {
                    CreateBarActivity.this.fVR.setEnabled(true);
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
        this.cUG = (RelativeLayout) findViewById(R.id.container);
        this.fVY = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.fVN = (TextView) findViewById(R.id.info);
        this.fVR = (RelativeLayout) findViewById(R.id.create);
        this.fVR.setOnClickListener(this.mOnClickListener);
        this.fVO = (TextView) findViewById(R.id.info2);
        this.fVP = (EditText) findViewById(R.id.edit_name);
        this.fVP.addTextChangedListener(this.mTextWatcher);
        this.fVQ = (EditText) findViewById(R.id.edit_vcode);
        this.fVQ.addTextChangedListener(this.mTextWatcher);
        if (this.fWa) {
            this.fVO.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.fVP.setText(this.fVZ);
        } else {
            this.fVO.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.fVX = (RelativeLayout) findViewById(R.id.create);
        this.fVS = (FrameLayout) findViewById(R.id.image_button);
        this.fVS.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.fVR.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.fVT = (ProgressBar) findViewById(R.id.progress_image);
        if (this.fWa) {
            this.fVQ.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.fVP.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.fVP);
                    }
                    if (CreateBarActivity.this.fVQ.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.fVQ);
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
        getLayoutMode().onModeChanged(this.cUG);
        al.a(this.fVY, i);
        al.b(this.fVO, i);
        String str = this.fVZ + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(R.color.common_color_10252)), 0, this.fVZ.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.fVZ.length(), str.length(), 33);
        al.k(this.fVX, R.drawable.btn_general_start_selector);
        this.fVN.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String fVZ;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ia();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.fVU = null;
        }

        public a(String str, String str2) {
            this.fVZ = null;
            this.mVcode = null;
            this.fVZ = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.ahC().aiB().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.fVZ);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateBarActivity.this.fVW);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.ahe();
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
            CreateBarActivity.this.fVU = null;
            if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                CreateBarSuccessActivity.ax(CreateBarActivity.this.getPageContext().getPageActivity(), this.fVZ);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.ahF()) {
                CreateBarActivity.this.bsE();
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
                this.mNetwork.ia();
            }
            CreateBarActivity.this.fVT.setVisibility(8);
            CreateBarActivity.this.fVV = null;
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
                String ahe = this.mNetwork.ahe();
                if (this.mNetwork.ahC().aiC().isRequestSuccess()) {
                    com.baidu.tbadk.coreExtra.data.x xVar = new com.baidu.tbadk.coreExtra.data.x();
                    xVar.parserJson(ahe);
                    if (xVar.getVcode_pic_url() == null || xVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.fVW = xVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(xVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.ahf());
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
            CreateBarActivity.this.fVT.setVisibility(8);
            CreateBarActivity.this.fVV = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.fVW = null;
            CreateBarActivity.this.fVT.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
