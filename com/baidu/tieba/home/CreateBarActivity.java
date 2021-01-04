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
/* loaded from: classes8.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout jVs;
    public NavigationBar mNavigationBar;
    private TextView jVh = null;
    private TextView jVi = null;
    private EditText jVj = null;
    private EditText jVk = null;
    private RelativeLayout jVl = null;
    private FrameLayout jVm = null;
    private ImageView giH = null;
    private ProgressBar mProgress = null;
    private ProgressBar jVn = null;
    private a jVo = null;
    private b jVp = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String jVq = null;
    private TextView jVr = null;
    private RelativeLayout mContainer = null;
    private TextView jVt = null;
    private String jVu = null;
    private boolean jVv = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        cQq();
        adjustResizeForSoftInput();
    }

    private void cQq() {
        if (this.jVp == null) {
            this.jVp = new b();
            this.jVp.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jVo != null) {
            this.jVo.cancel();
        }
        if (this.jVp != null) {
            this.jVp.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.jVu = intent.getStringExtra("barname");
        this.jVv = intent.getBooleanExtra("isvalid", false);
        if (this.jVu == null) {
            this.jVu = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQr() {
        if (this.jVp == null && this.jVo == null) {
            this.jVp = new b();
            this.jVp.setPriority(3);
            this.jVp.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQs() {
        if (this.jVo == null) {
            this.jVo = new a(this.jVj.getText().toString().trim(), this.jVk.getText().toString().trim());
            this.jVo.setPriority(3);
            this.jVo.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.jVl) {
                    CreateBarActivity.this.cQs();
                } else if (view == CreateBarActivity.this.jVm) {
                    CreateBarActivity.this.cQr();
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
                int length = CreateBarActivity.this.jVj.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.jVk.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.jVl.setEnabled(false);
                } else {
                    CreateBarActivity.this.jVl.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.jVr.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_long));
                    CreateBarActivity.this.jVr.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.jVr.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_rule));
                CreateBarActivity.this.jVr.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.jVt = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.jVr = (TextView) findViewById(R.id.error);
        this.jVh = (TextView) findViewById(R.id.info);
        this.jVl = (RelativeLayout) findViewById(R.id.create);
        this.jVl.setOnClickListener(this.mOnClickListener);
        this.jVi = (TextView) findViewById(R.id.info2);
        this.jVj = (EditText) findViewById(R.id.edit_name);
        this.jVj.addTextChangedListener(this.mTextWatcher);
        this.jVk = (EditText) findViewById(R.id.edit_vcode);
        this.jVk.addTextChangedListener(this.mTextWatcher);
        if (this.jVv) {
            this.jVi.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.jVj.setText(this.jVu);
        } else {
            this.jVi.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.jVs = (RelativeLayout) findViewById(R.id.create);
        this.jVm = (FrameLayout) findViewById(R.id.image_button);
        this.jVm.setOnClickListener(this.mOnClickListener);
        this.giH = (ImageView) findViewById(R.id.image);
        this.jVl.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jVn = (ProgressBar) findViewById(R.id.progress_image);
        if (this.jVv) {
            this.jVk.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.jVj.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jVj);
                    }
                    if (CreateBarActivity.this.jVk.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.jVk);
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
        ao.setButtonTextColor(this.jVt, i);
        ao.setTextColor(this.jVi, i);
        String str = this.jVu + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.common_color_10252)), 0, this.jVu.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.jVu.length(), str.length(), 33);
        ao.setBackgroundResource(this.jVs, R.drawable.btn_general_start_selector);
        this.jVh.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String jVu;
        private z mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.jVo = null;
        }

        public a(String str, String str2) {
            this.jVu = null;
            this.mVcode = null;
            this.jVu = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.bvQ().bwz().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.jVu);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.jVq);
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
            CreateBarActivity.this.jVo = null;
            if (this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                CreateBarSuccessActivity.aV(CreateBarActivity.this.getPageContext().getPageActivity(), this.jVu);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.cQr();
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
            CreateBarActivity.this.jVn.setVisibility(8);
            CreateBarActivity.this.jVp = null;
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
                if (this.mNetwork.bvQ().bwA().isRequestSuccess()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(postNetData);
                    if (ahVar.getVcode_pic_url() == null || ahVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.jVq = ahVar.getVcode_md5();
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
            CreateBarActivity.this.jVn.setVisibility(8);
            CreateBarActivity.this.jVp = null;
            if (bitmap != null) {
                CreateBarActivity.this.giH.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.jVq = null;
            CreateBarActivity.this.jVn.setVisibility(0);
            CreateBarActivity.this.giH.setImageDrawable(null);
        }
    }
}
