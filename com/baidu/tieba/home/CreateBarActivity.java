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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout gVK;
    public NavigationBar mNavigationBar;
    private TextView gVA = null;
    private TextView gVB = null;
    private EditText gVC = null;
    private EditText gVD = null;
    private RelativeLayout gVE = null;
    private FrameLayout gVF = null;
    private ImageView dYe = null;
    private ProgressBar mProgress = null;
    private ProgressBar gVG = null;
    private a gVH = null;
    private b gVI = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String gVJ = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView gVL = null;
    private String gVM = null;
    private boolean gVN = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        bMQ();
        adjustResizeForSoftInput();
    }

    private void bMQ() {
        if (this.gVI == null) {
            this.gVI = new b();
            this.gVI.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gVH != null) {
            this.gVH.cancel();
        }
        if (this.gVI != null) {
            this.gVI.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.gVM = intent.getStringExtra("barname");
        this.gVN = intent.getBooleanExtra("isvalid", false);
        if (this.gVM == null) {
            this.gVM = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMR() {
        if (this.gVI == null && this.gVH == null) {
            this.gVI = new b();
            this.gVI.setPriority(3);
            this.gVI.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMS() {
        if (this.gVH == null) {
            this.gVH = new a(this.gVC.getText().toString().trim(), this.gVD.getText().toString().trim());
            this.gVH.setPriority(3);
            this.gVH.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.gVE) {
                    CreateBarActivity.this.bMS();
                } else if (view == CreateBarActivity.this.gVF) {
                    CreateBarActivity.this.bMR();
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
                int length = CreateBarActivity.this.gVC.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.gVD.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.gVE.setEnabled(false);
                } else {
                    CreateBarActivity.this.gVE.setEnabled(true);
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
        this.gVL = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.gVA = (TextView) findViewById(R.id.info);
        this.gVE = (RelativeLayout) findViewById(R.id.create);
        this.gVE.setOnClickListener(this.mOnClickListener);
        this.gVB = (TextView) findViewById(R.id.info2);
        this.gVC = (EditText) findViewById(R.id.edit_name);
        this.gVC.addTextChangedListener(this.mTextWatcher);
        this.gVD = (EditText) findViewById(R.id.edit_vcode);
        this.gVD.addTextChangedListener(this.mTextWatcher);
        if (this.gVN) {
            this.gVB.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.gVC.setText(this.gVM);
        } else {
            this.gVB.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.gVK = (RelativeLayout) findViewById(R.id.create);
        this.gVF = (FrameLayout) findViewById(R.id.image_button);
        this.gVF.setOnClickListener(this.mOnClickListener);
        this.dYe = (ImageView) findViewById(R.id.image);
        this.gVE.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gVG = (ProgressBar) findViewById(R.id.progress_image);
        if (this.gVN) {
            this.gVD.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.gVC.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gVC);
                    }
                    if (CreateBarActivity.this.gVD.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gVD);
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
        am.setButtonTextColor(this.gVL, i);
        am.setTextColor(this.gVB, i);
        String str = this.gVM + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.gVM.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.gVM.length(), str.length(), 33);
        am.setBackgroundResource(this.gVK, R.drawable.btn_general_start_selector);
        this.gVA.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String gVM;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.gVH = null;
        }

        public a(String str, String str2) {
            this.gVM = null;
            this.mVcode = null;
            this.gVM = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aGg().aGH().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.gVM);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.gVJ);
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
            CreateBarActivity.this.gVH = null;
            if (this.mNetwork.aGg().aGI().isRequestSuccess()) {
                CreateBarSuccessActivity.aU(CreateBarActivity.this.getPageContext().getPageActivity(), this.gVM);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.bMR();
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
            CreateBarActivity.this.gVG.setVisibility(8);
            CreateBarActivity.this.gVI = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aGg().aGI().isRequestSuccess()) {
                    aa aaVar = new aa();
                    aaVar.parserJson(postNetData);
                    if (aaVar.getVcode_pic_url() == null || aaVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.gVJ = aaVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(aaVar.getVcode_pic_url());
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
            CreateBarActivity.this.gVG.setVisibility(8);
            CreateBarActivity.this.gVI = null;
            if (bitmap != null) {
                CreateBarActivity.this.dYe.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.gVJ = null;
            CreateBarActivity.this.gVG.setVisibility(0);
            CreateBarActivity.this.dYe.setImageDrawable(null);
        }
    }
}
