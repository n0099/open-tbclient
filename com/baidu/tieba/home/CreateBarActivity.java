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
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout dZi;
    public NavigationBar mNavigationBar;
    private TextView dYY = null;
    private TextView dYZ = null;
    private EditText dZa = null;
    private EditText dZb = null;
    private RelativeLayout dZc = null;
    private FrameLayout dZd = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar dZe = null;
    private a dZf = null;
    private b dZg = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String dZh = null;
    private TextView mErrorView = null;
    private RelativeLayout bsh = null;
    private TextView dZj = null;
    private String dZk = null;
    private boolean dZl = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_bar_activity);
        initData();
        initUI();
        aFi();
        adjustResizeForSoftInput();
    }

    private void aFi() {
        if (this.dZg == null) {
            this.dZg = new b();
            this.dZg.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dZf != null) {
            this.dZf.cancel();
        }
        if (this.dZg != null) {
            this.dZg.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.dZk = intent.getStringExtra("barname");
        this.dZl = intent.getBooleanExtra("isvalid", false);
        if (this.dZk == null) {
            this.dZk = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFj() {
        if (this.dZg == null && this.dZf == null) {
            this.dZg = new b();
            this.dZg.setPriority(3);
            this.dZg.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFk() {
        if (this.dZf == null) {
            this.dZf = new a(this.dZa.getText().toString().trim(), this.dZb.getText().toString().trim());
            this.dZf.setPriority(3);
            this.dZf.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.dZc) {
                    CreateBarActivity.this.aFk();
                } else if (view == CreateBarActivity.this.dZd) {
                    CreateBarActivity.this.aFj();
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
                int length = CreateBarActivity.this.dZa.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.dZb.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.dZc.setEnabled(false);
                } else {
                    CreateBarActivity.this.dZc.setEnabled(true);
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
        this.bsh = (RelativeLayout) findViewById(e.g.container);
        this.dZj = (TextView) findViewById(e.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(e.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(e.g.error);
        this.dYY = (TextView) findViewById(e.g.info);
        this.dZc = (RelativeLayout) findViewById(e.g.create);
        this.dZc.setOnClickListener(this.mOnClickListener);
        this.dYZ = (TextView) findViewById(e.g.info2);
        this.dZa = (EditText) findViewById(e.g.edit_name);
        this.dZa.addTextChangedListener(this.mTextWatcher);
        this.dZb = (EditText) findViewById(e.g.edit_vcode);
        this.dZb.addTextChangedListener(this.mTextWatcher);
        if (this.dZl) {
            this.dYZ.setText(getPageContext().getString(e.j.noforum_create_form_tip));
            this.dZa.setText(this.dZk);
        } else {
            this.dYZ.setText(getPageContext().getString(e.j.bar_name_invalid));
        }
        this.dZi = (RelativeLayout) findViewById(e.g.create);
        this.dZd = (FrameLayout) findViewById(e.g.image_button);
        this.dZd.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.dZc.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.dZe = (ProgressBar) findViewById(e.g.progress_image);
        if (this.dZl) {
            this.dZb.requestFocus();
        }
        findViewById(e.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.dZa.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dZa);
                    }
                    if (CreateBarActivity.this.dZb.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dZb);
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
        getLayoutMode().onModeChanged(this.bsh);
        al.a(this.dZj, i);
        al.b(this.dYZ, i);
        String str = this.dZk + getPageContext().getString(e.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(e.d.common_color_10252)), 0, this.dZk.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(e.d.common_color_10004)), this.dZk.length(), str.length(), 33);
        al.i(this.dZi, e.f.btn_general_start_selector);
        this.dYY.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dZk;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.iT();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.dZf = null;
        }

        public a(String str, String str2) {
            this.dZk = null;
            this.mVcode = null;
            this.dZk = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.zR().AP().mIsNeedTbs = true;
                this.mNetwork.u("kw", this.dZk);
                this.mNetwork.u("vcode", this.mVcode);
                this.mNetwork.u("vcode_md5", CreateBarActivity.this.dZh);
                this.mNetwork.u("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.zt();
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
            CreateBarActivity.this.dZf = null;
            if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                CreateBarSuccessActivity.av(CreateBarActivity.this.getPageContext().getPageActivity(), this.dZk);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.zU()) {
                CreateBarActivity.this.aFj();
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
                this.mNetwork.iT();
            }
            CreateBarActivity.this.dZe.setVisibility(8);
            CreateBarActivity.this.dZg = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetwork.u(ImageViewerConfig.FORUM_ID, "0");
                this.mNetwork.u("pub_type", "0");
                this.mNetwork.u(ImageViewerConfig.FORUM_NAME, "");
                this.mNetwork.u("tid", "0");
                String zt = this.mNetwork.zt();
                if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                    v vVar = new v();
                    vVar.parserJson(zt);
                    if (vVar.getVcode_pic_url() == null || vVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.dZh = vVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(vVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.zu());
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
            CreateBarActivity.this.dZe.setVisibility(8);
            CreateBarActivity.this.dZg = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.dZh = null;
            CreateBarActivity.this.dZe.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
