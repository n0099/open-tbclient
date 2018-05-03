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
    private RelativeLayout dzB;
    public NavigationBar mNavigationBar;
    private TextView dzr = null;
    private TextView dzs = null;
    private EditText dzt = null;
    private EditText dzu = null;
    private RelativeLayout dzv = null;
    private FrameLayout dzw = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar dzx = null;
    private a dzy = null;
    private b dzz = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String dzA = null;
    private TextView mErrorView = null;
    private RelativeLayout bbY = null;
    private TextView dzC = null;
    private String dzD = null;
    private boolean dzE = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.create_bar_activity);
        initData();
        initUI();
        awS();
        adjustResizeForSoftInput();
    }

    private void awS() {
        if (this.dzz == null) {
            this.dzz = new b();
            this.dzz.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dzy != null) {
            this.dzy.cancel();
        }
        if (this.dzz != null) {
            this.dzz.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.dzD = intent.getStringExtra("barname");
        this.dzE = intent.getBooleanExtra("isvalid", false);
        if (this.dzD == null) {
            this.dzD = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awT() {
        if (this.dzz == null && this.dzy == null) {
            this.dzz = new b();
            this.dzz.setPriority(3);
            this.dzz.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awU() {
        if (this.dzy == null) {
            this.dzy = new a(this.dzt.getText().toString().trim(), this.dzu.getText().toString().trim());
            this.dzy.setPriority(3);
            this.dzy.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == CreateBarActivity.this.dzv) {
                    CreateBarActivity.this.awU();
                } else if (view2 == CreateBarActivity.this.dzw) {
                    CreateBarActivity.this.awT();
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
                int length = CreateBarActivity.this.dzt.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.dzu.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.dzv.setEnabled(false);
                } else {
                    CreateBarActivity.this.dzv.setEnabled(true);
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
        this.bbY = (RelativeLayout) findViewById(d.g.container);
        this.dzC = (TextView) findViewById(d.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(d.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(d.g.error);
        this.dzr = (TextView) findViewById(d.g.info);
        this.dzv = (RelativeLayout) findViewById(d.g.create);
        this.dzv.setOnClickListener(this.mOnClickListener);
        this.dzs = (TextView) findViewById(d.g.info2);
        this.dzt = (EditText) findViewById(d.g.edit_name);
        this.dzt.addTextChangedListener(this.mTextWatcher);
        this.dzu = (EditText) findViewById(d.g.edit_vcode);
        this.dzu.addTextChangedListener(this.mTextWatcher);
        if (this.dzE) {
            this.dzs.setText(getPageContext().getString(d.k.noforum_create_form_tip));
            this.dzt.setText(this.dzD);
        } else {
            this.dzs.setText(getPageContext().getString(d.k.bar_name_invalid));
        }
        this.dzB = (RelativeLayout) findViewById(d.g.create);
        this.dzw = (FrameLayout) findViewById(d.g.image_button);
        this.dzw.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.dzv.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dzx = (ProgressBar) findViewById(d.g.progress_image);
        if (this.dzE) {
            this.dzu.requestFocus();
        }
        findViewById(d.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.dzt.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dzt);
                    }
                    if (CreateBarActivity.this.dzu.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dzu);
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
        getLayoutMode().u(this.bbY);
        ak.a(this.dzC, i);
        ak.b(this.dzs, i);
        String str = this.dzD + getPageContext().getString(d.k.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.common_color_10252)), 0, this.dzD.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.C0126d.common_color_10004)), this.dzD.length(), str.length(), 33);
        ak.i(this.dzB, d.f.btn_general_start_selector);
        this.dzr.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dzD;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.dzy = null;
        }

        public a(String str, String str2) {
            this.dzD = null;
            this.mVcode = null;
            this.dzD = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.vj().wi().mIsNeedTbs = true;
                this.mNetwork.n("kw", this.dzD);
                this.mNetwork.n("vcode", this.mVcode);
                this.mNetwork.n("vcode_md5", CreateBarActivity.this.dzA);
                this.mNetwork.uL();
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
            CreateBarActivity.this.dzy = null;
            if (this.mNetwork.vj().wj().isRequestSuccess()) {
                CreateBarSuccessActivity.ac(CreateBarActivity.this.getPageContext().getPageActivity(), this.dzD);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.vm()) {
                CreateBarActivity.this.awT();
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
            CreateBarActivity.this.dzx.setVisibility(8);
            CreateBarActivity.this.dzz = null;
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
                String uL = this.mNetwork.uL();
                if (this.mNetwork.vj().wj().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(uL);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.dzA = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.uM());
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
            CreateBarActivity.this.dzx.setVisibility(8);
            CreateBarActivity.this.dzz = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.dzA = null;
            CreateBarActivity.this.dzx.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
