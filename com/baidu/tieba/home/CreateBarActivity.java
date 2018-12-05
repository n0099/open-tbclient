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
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout epq;
    public NavigationBar mNavigationBar;
    private TextView epg = null;
    private TextView eph = null;
    private EditText epi = null;
    private EditText epj = null;
    private RelativeLayout epk = null;
    private FrameLayout epl = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar epm = null;
    private a epn = null;
    private b epo = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String epp = null;
    private TextView mErrorView = null;
    private RelativeLayout bAw = null;
    private TextView epr = null;
    private String eps = null;
    private boolean ept = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_bar_activity);
        initData();
        initUI();
        aJP();
        adjustResizeForSoftInput();
    }

    private void aJP() {
        if (this.epo == null) {
            this.epo = new b();
            this.epo.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.epn != null) {
            this.epn.cancel();
        }
        if (this.epo != null) {
            this.epo.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.eps = intent.getStringExtra("barname");
        this.ept = intent.getBooleanExtra("isvalid", false);
        if (this.eps == null) {
            this.eps = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJQ() {
        if (this.epo == null && this.epn == null) {
            this.epo = new b();
            this.epo.setPriority(3);
            this.epo.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJR() {
        if (this.epn == null) {
            this.epn = new a(this.epi.getText().toString().trim(), this.epj.getText().toString().trim());
            this.epn.setPriority(3);
            this.epn.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.epk) {
                    CreateBarActivity.this.aJR();
                } else if (view == CreateBarActivity.this.epl) {
                    CreateBarActivity.this.aJQ();
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
                int length = CreateBarActivity.this.epi.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.epj.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.epk.setEnabled(false);
                } else {
                    CreateBarActivity.this.epk.setEnabled(true);
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
        this.bAw = (RelativeLayout) findViewById(e.g.container);
        this.epr = (TextView) findViewById(e.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(e.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(e.g.error);
        this.epg = (TextView) findViewById(e.g.info);
        this.epk = (RelativeLayout) findViewById(e.g.create);
        this.epk.setOnClickListener(this.mOnClickListener);
        this.eph = (TextView) findViewById(e.g.info2);
        this.epi = (EditText) findViewById(e.g.edit_name);
        this.epi.addTextChangedListener(this.mTextWatcher);
        this.epj = (EditText) findViewById(e.g.edit_vcode);
        this.epj.addTextChangedListener(this.mTextWatcher);
        if (this.ept) {
            this.eph.setText(getPageContext().getString(e.j.noforum_create_form_tip));
            this.epi.setText(this.eps);
        } else {
            this.eph.setText(getPageContext().getString(e.j.bar_name_invalid));
        }
        this.epq = (RelativeLayout) findViewById(e.g.create);
        this.epl = (FrameLayout) findViewById(e.g.image_button);
        this.epl.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.epk.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.epm = (ProgressBar) findViewById(e.g.progress_image);
        if (this.ept) {
            this.epj.requestFocus();
        }
        findViewById(e.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.epi.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.epi);
                    }
                    if (CreateBarActivity.this.epj.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.epj);
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
        getLayoutMode().onModeChanged(this.bAw);
        al.a(this.epr, i);
        al.b(this.eph, i);
        String str = this.eps + getPageContext().getString(e.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(e.d.common_color_10252)), 0, this.eps.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(e.d.common_color_10004)), this.eps.length(), str.length(), 33);
        al.i(this.epq, e.f.btn_general_start_selector);
        this.epg.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String eps;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.epn = null;
        }

        public a(String str, String str2) {
            this.eps = null;
            this.mVcode = null;
            this.eps = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.Dj().Eh().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.eps);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateBarActivity.this.epp);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.CL();
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
            CreateBarActivity.this.epn = null;
            if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                CreateBarSuccessActivity.ay(CreateBarActivity.this.getPageContext().getPageActivity(), this.eps);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.Dm()) {
                CreateBarActivity.this.aJQ();
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
            CreateBarActivity.this.epm.setVisibility(8);
            CreateBarActivity.this.epo = null;
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
                String CL = this.mNetwork.CL();
                if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                    w wVar = new w();
                    wVar.parserJson(CL);
                    if (wVar.getVcode_pic_url() == null || wVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.epp = wVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(wVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.CM());
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
            CreateBarActivity.this.epm.setVisibility(8);
            CreateBarActivity.this.epo = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.epp = null;
            CreateBarActivity.this.epm.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
