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
    private RelativeLayout fFl;
    public NavigationBar mNavigationBar;
    private TextView fFb = null;
    private TextView fFc = null;
    private EditText fFd = null;
    private EditText fFe = null;
    private RelativeLayout fFf = null;
    private FrameLayout fFg = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar fFh = null;
    private a fFi = null;
    private b fFj = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String fFk = null;
    private TextView mErrorView = null;
    private RelativeLayout cMr = null;
    private TextView fFm = null;
    private String fFn = null;
    private boolean fFo = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.create_bar_activity);
        initData();
        initUI();
        blj();
        adjustResizeForSoftInput();
    }

    private void blj() {
        if (this.fFj == null) {
            this.fFj = new b();
            this.fFj.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fFi != null) {
            this.fFi.cancel();
        }
        if (this.fFj != null) {
            this.fFj.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.fFn = intent.getStringExtra("barname");
        this.fFo = intent.getBooleanExtra("isvalid", false);
        if (this.fFn == null) {
            this.fFn = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blk() {
        if (this.fFj == null && this.fFi == null) {
            this.fFj = new b();
            this.fFj.setPriority(3);
            this.fFj.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bll() {
        if (this.fFi == null) {
            this.fFi = new a(this.fFd.getText().toString().trim(), this.fFe.getText().toString().trim());
            this.fFi.setPriority(3);
            this.fFi.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.fFf) {
                    CreateBarActivity.this.bll();
                } else if (view == CreateBarActivity.this.fFg) {
                    CreateBarActivity.this.blk();
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
                int length = CreateBarActivity.this.fFd.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.fFe.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.fFf.setEnabled(false);
                } else {
                    CreateBarActivity.this.fFf.setEnabled(true);
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
        this.cMr = (RelativeLayout) findViewById(d.g.container);
        this.fFm = (TextView) findViewById(d.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(d.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(d.g.error);
        this.fFb = (TextView) findViewById(d.g.info);
        this.fFf = (RelativeLayout) findViewById(d.g.create);
        this.fFf.setOnClickListener(this.mOnClickListener);
        this.fFc = (TextView) findViewById(d.g.info2);
        this.fFd = (EditText) findViewById(d.g.edit_name);
        this.fFd.addTextChangedListener(this.mTextWatcher);
        this.fFe = (EditText) findViewById(d.g.edit_vcode);
        this.fFe.addTextChangedListener(this.mTextWatcher);
        if (this.fFo) {
            this.fFc.setText(getPageContext().getString(d.j.noforum_create_form_tip));
            this.fFd.setText(this.fFn);
        } else {
            this.fFc.setText(getPageContext().getString(d.j.bar_name_invalid));
        }
        this.fFl = (RelativeLayout) findViewById(d.g.create);
        this.fFg = (FrameLayout) findViewById(d.g.image_button);
        this.fFg.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.fFf.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.fFh = (ProgressBar) findViewById(d.g.progress_image);
        if (this.fFo) {
            this.fFe.requestFocus();
        }
        findViewById(d.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.fFd.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.fFd);
                    }
                    if (CreateBarActivity.this.fFe.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.fFe);
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
        getLayoutMode().onModeChanged(this.cMr);
        al.a(this.fFm, i);
        al.b(this.fFc, i);
        String str = this.fFn + getPageContext().getString(d.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.common_color_10252)), 0, this.fFn.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.C0277d.common_color_10004)), this.fFn.length(), str.length(), 33);
        al.k(this.fFl, d.f.btn_general_start_selector);
        this.fFb.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String fFn;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.fFi = null;
        }

        public a(String str, String str2) {
            this.fFn = null;
            this.mVcode = null;
            this.fFn = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.acH().adF().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.fFn);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateBarActivity.this.fFk);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.acj();
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
            CreateBarActivity.this.fFi = null;
            if (this.mNetwork.acH().adG().isRequestSuccess()) {
                CreateBarSuccessActivity.aJ(CreateBarActivity.this.getPageContext().getPageActivity(), this.fFn);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.acK()) {
                CreateBarActivity.this.blk();
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
            CreateBarActivity.this.fFh.setVisibility(8);
            CreateBarActivity.this.fFj = null;
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
                String acj = this.mNetwork.acj();
                if (this.mNetwork.acH().adG().isRequestSuccess()) {
                    com.baidu.tbadk.coreExtra.data.x xVar = new com.baidu.tbadk.coreExtra.data.x();
                    xVar.parserJson(acj);
                    if (xVar.getVcode_pic_url() == null || xVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.fFk = xVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(xVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.ack());
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
            CreateBarActivity.this.fFh.setVisibility(8);
            CreateBarActivity.this.fFj = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.fFk = null;
            CreateBarActivity.this.fFh.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
