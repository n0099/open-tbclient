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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout gQo;
    public NavigationBar mNavigationBar;
    private TextView gQe = null;
    private TextView gQf = null;
    private EditText gQg = null;
    private EditText gQh = null;
    private RelativeLayout gQi = null;
    private FrameLayout gQj = null;
    private ImageView dTP = null;
    private ProgressBar mProgress = null;
    private ProgressBar gQk = null;
    private a gQl = null;
    private b gQm = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String gQn = null;
    private TextView mErrorView = null;
    private RelativeLayout mContainer = null;
    private TextView gQp = null;
    private String gQq = null;
    private boolean gQr = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        bKg();
        adjustResizeForSoftInput();
    }

    private void bKg() {
        if (this.gQm == null) {
            this.gQm = new b();
            this.gQm.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gQl != null) {
            this.gQl.cancel();
        }
        if (this.gQm != null) {
            this.gQm.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.gQq = intent.getStringExtra("barname");
        this.gQr = intent.getBooleanExtra("isvalid", false);
        if (this.gQq == null) {
            this.gQq = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKh() {
        if (this.gQm == null && this.gQl == null) {
            this.gQm = new b();
            this.gQm.setPriority(3);
            this.gQm.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKi() {
        if (this.gQl == null) {
            this.gQl = new a(this.gQg.getText().toString().trim(), this.gQh.getText().toString().trim());
            this.gQl.setPriority(3);
            this.gQl.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.gQi) {
                    CreateBarActivity.this.bKi();
                } else if (view == CreateBarActivity.this.gQj) {
                    CreateBarActivity.this.bKh();
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
                int length = CreateBarActivity.this.gQg.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.gQh.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.gQi.setEnabled(false);
                } else {
                    CreateBarActivity.this.gQi.setEnabled(true);
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
        this.gQp = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.gQe = (TextView) findViewById(R.id.info);
        this.gQi = (RelativeLayout) findViewById(R.id.create);
        this.gQi.setOnClickListener(this.mOnClickListener);
        this.gQf = (TextView) findViewById(R.id.info2);
        this.gQg = (EditText) findViewById(R.id.edit_name);
        this.gQg.addTextChangedListener(this.mTextWatcher);
        this.gQh = (EditText) findViewById(R.id.edit_vcode);
        this.gQh.addTextChangedListener(this.mTextWatcher);
        if (this.gQr) {
            this.gQf.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.gQg.setText(this.gQq);
        } else {
            this.gQf.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.gQo = (RelativeLayout) findViewById(R.id.create);
        this.gQj = (FrameLayout) findViewById(R.id.image_button);
        this.gQj.setOnClickListener(this.mOnClickListener);
        this.dTP = (ImageView) findViewById(R.id.image);
        this.gQi.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gQk = (ProgressBar) findViewById(R.id.progress_image);
        if (this.gQr) {
            this.gQh.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.gQg.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gQg);
                    }
                    if (CreateBarActivity.this.gQh.hasFocus()) {
                        l.hideSoftKeyPad(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gQh);
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
        am.setButtonTextColor(this.gQp, i);
        am.setTextColor(this.gQf, i);
        String str = this.gQq + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.gQq.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.gQq.length(), str.length(), 33);
        am.setBackgroundResource(this.gQo, R.drawable.btn_general_start_selector);
        this.gQe.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String gQq;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.gQl = null;
        }

        public a(String str, String str2) {
            this.gQq = null;
            this.mVcode = null;
            this.gQq = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aDB().aEb().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.gQq);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateBarActivity.this.gQn);
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
            CreateBarActivity.this.gQl = null;
            if (this.mNetwork.aDB().aEc().isRequestSuccess()) {
                CreateBarSuccessActivity.aT(CreateBarActivity.this.getPageContext().getPageActivity(), this.gQq);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateBarActivity.this.bKh();
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
            CreateBarActivity.this.gQk.setVisibility(8);
            CreateBarActivity.this.gQm = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aDB().aEc().isRequestSuccess()) {
                    y yVar = new y();
                    yVar.parserJson(postNetData);
                    if (yVar.getVcode_pic_url() == null || yVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.gQn = yVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(yVar.getVcode_pic_url());
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
            CreateBarActivity.this.gQk.setVisibility(8);
            CreateBarActivity.this.gQm = null;
            if (bitmap != null) {
                CreateBarActivity.this.dTP.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.gQn = null;
            CreateBarActivity.this.gQk.setVisibility(0);
            CreateBarActivity.this.dTP.setImageDrawable(null);
        }
    }
}
