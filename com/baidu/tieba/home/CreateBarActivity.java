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
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout fEZ;
    public NavigationBar mNavigationBar;
    private TextView fEP = null;
    private TextView fEQ = null;
    private EditText fER = null;
    private EditText fES = null;
    private RelativeLayout fET = null;
    private FrameLayout fEU = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar fEV = null;
    private a fEW = null;
    private b fEX = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String fEY = null;
    private TextView mErrorView = null;
    private RelativeLayout cMt = null;
    private TextView fFa = null;
    private String fFb = null;
    private boolean fFc = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.create_bar_activity);
        initData();
        initUI();
        blg();
        adjustResizeForSoftInput();
    }

    private void blg() {
        if (this.fEX == null) {
            this.fEX = new b();
            this.fEX.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fEW != null) {
            this.fEW.cancel();
        }
        if (this.fEX != null) {
            this.fEX.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.fFb = intent.getStringExtra("barname");
        this.fFc = intent.getBooleanExtra("isvalid", false);
        if (this.fFb == null) {
            this.fFb = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blh() {
        if (this.fEX == null && this.fEW == null) {
            this.fEX = new b();
            this.fEX.setPriority(3);
            this.fEX.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bli() {
        if (this.fEW == null) {
            this.fEW = new a(this.fER.getText().toString().trim(), this.fES.getText().toString().trim());
            this.fEW.setPriority(3);
            this.fEW.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.fET) {
                    CreateBarActivity.this.bli();
                } else if (view == CreateBarActivity.this.fEU) {
                    CreateBarActivity.this.blh();
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
                int length = CreateBarActivity.this.fER.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.fES.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.fET.setEnabled(false);
                } else {
                    CreateBarActivity.this.fET.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(d.j.bar_name_long));
                    CreateBarActivity.this.mErrorView.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(d.j.bar_name_rule));
                CreateBarActivity.this.mErrorView.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.create_bar));
        this.cMt = (RelativeLayout) findViewById(d.g.container);
        this.fFa = (TextView) findViewById(d.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(d.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(d.g.error);
        this.fEP = (TextView) findViewById(d.g.info);
        this.fET = (RelativeLayout) findViewById(d.g.create);
        this.fET.setOnClickListener(this.mOnClickListener);
        this.fEQ = (TextView) findViewById(d.g.info2);
        this.fER = (EditText) findViewById(d.g.edit_name);
        this.fER.addTextChangedListener(this.mTextWatcher);
        this.fES = (EditText) findViewById(d.g.edit_vcode);
        this.fES.addTextChangedListener(this.mTextWatcher);
        if (this.fFc) {
            this.fEQ.setText(getPageContext().getString(d.j.noforum_create_form_tip));
            this.fER.setText(this.fFb);
        } else {
            this.fEQ.setText(getPageContext().getString(d.j.bar_name_invalid));
        }
        this.fEZ = (RelativeLayout) findViewById(d.g.create);
        this.fEU = (FrameLayout) findViewById(d.g.image_button);
        this.fEU.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.fET.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.fEV = (ProgressBar) findViewById(d.g.progress_image);
        if (this.fFc) {
            this.fES.requestFocus();
        }
        findViewById(d.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.fER.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.fER);
                    }
                    if (CreateBarActivity.this.fES.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.fES);
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
        getLayoutMode().onModeChanged(this.cMt);
        al.a(this.fFa, i);
        al.b(this.fEQ, i);
        String str = this.fFb + getPageContext().getString(d.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.common_color_10252)), 0, this.fFb.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.C0277d.common_color_10004)), this.fFb.length(), str.length(), 33);
        al.k(this.fEZ, d.f.btn_general_start_selector);
        this.fEP.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String fFb;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.fEW = null;
        }

        public a(String str, String str2) {
            this.fFb = null;
            this.mVcode = null;
            this.fFb = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.acE().adC().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.fFb);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateBarActivity.this.fEY);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.acg();
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
            CreateBarActivity.this.fEW = null;
            if (this.mNetwork.acE().adD().isRequestSuccess()) {
                CreateBarSuccessActivity.aJ(CreateBarActivity.this.getPageContext().getPageActivity(), this.fFb);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.acH()) {
                CreateBarActivity.this.blh();
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
                this.mNetwork.ji();
            }
            CreateBarActivity.this.fEV.setVisibility(8);
            CreateBarActivity.this.fEX = null;
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
                String acg = this.mNetwork.acg();
                if (this.mNetwork.acE().adD().isRequestSuccess()) {
                    com.baidu.tbadk.coreExtra.data.x xVar = new com.baidu.tbadk.coreExtra.data.x();
                    xVar.parserJson(acg);
                    if (xVar.getVcode_pic_url() == null || xVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.fEY = xVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(xVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.ach());
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
            CreateBarActivity.this.fEV.setVisibility(8);
            CreateBarActivity.this.fEX = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.fEY = null;
            CreateBarActivity.this.fEV.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
