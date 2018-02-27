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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout eeI;
    public NavigationBar mNavigationBar;
    private TextView eey = null;
    private TextView eez = null;
    private EditText eeA = null;
    private EditText eeB = null;
    private RelativeLayout eeC = null;
    private FrameLayout eeD = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar eeE = null;
    private a eeF = null;
    private b eeG = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String eeH = null;
    private TextView rK = null;
    private RelativeLayout bRR = null;
    private TextView eeJ = null;
    private String eeK = null;
    private boolean eeL = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.create_bar_activity);
        initData();
        initUI();
        aBV();
        adjustResizeForSoftInput();
    }

    private void aBV() {
        if (this.eeG == null) {
            this.eeG = new b();
            this.eeG.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eeF != null) {
            this.eeF.cancel();
        }
        if (this.eeG != null) {
            this.eeG.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.eeK = intent.getStringExtra("barname");
        this.eeL = intent.getBooleanExtra("isvalid", false);
        if (this.eeK == null) {
            this.eeK = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBW() {
        if (this.eeG == null && this.eeF == null) {
            this.eeG = new b();
            this.eeG.setPriority(3);
            this.eeG.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBX() {
        if (this.eeF == null) {
            this.eeF = new a(this.eeA.getText().toString().trim(), this.eeB.getText().toString().trim());
            this.eeF.setPriority(3);
            this.eeF.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.eeC) {
                    CreateBarActivity.this.aBX();
                } else if (view == CreateBarActivity.this.eeD) {
                    CreateBarActivity.this.aBW();
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
                int length = CreateBarActivity.this.eeA.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.eeB.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.eeC.setEnabled(false);
                } else {
                    CreateBarActivity.this.eeC.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.rK.setText(CreateBarActivity.this.getPageContext().getString(d.j.bar_name_long));
                    CreateBarActivity.this.rK.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.rK.setText(CreateBarActivity.this.getPageContext().getString(d.j.bar_name_rule));
                CreateBarActivity.this.rK.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.create_bar));
        this.bRR = (RelativeLayout) findViewById(d.g.container);
        this.eeJ = (TextView) findViewById(d.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(d.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.rK = (TextView) findViewById(d.g.error);
        this.eey = (TextView) findViewById(d.g.info);
        this.eeC = (RelativeLayout) findViewById(d.g.create);
        this.eeC.setOnClickListener(this.mOnClickListener);
        this.eez = (TextView) findViewById(d.g.info2);
        this.eeA = (EditText) findViewById(d.g.edit_name);
        this.eeA.addTextChangedListener(this.mTextWatcher);
        this.eeB = (EditText) findViewById(d.g.edit_vcode);
        this.eeB.addTextChangedListener(this.mTextWatcher);
        if (this.eeL) {
            this.eez.setText(getPageContext().getString(d.j.noforum_create_form_tip));
            this.eeA.setText(this.eeK);
        } else {
            this.eez.setText(getPageContext().getString(d.j.bar_name_invalid));
        }
        this.eeI = (RelativeLayout) findViewById(d.g.create);
        this.eeD = (FrameLayout) findViewById(d.g.image_button);
        this.eeD.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.eeC.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.eeE = (ProgressBar) findViewById(d.g.progress_image);
        if (this.eeL) {
            this.eeB.requestFocus();
        }
        findViewById(d.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.eeA.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.eeA);
                    }
                    if (CreateBarActivity.this.eeB.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.eeB);
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
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.bRR);
        aj.b(this.eeJ, i);
        aj.c(this.eez, i);
        String str = this.eeK + getPageContext().getString(d.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.common_color_10252)), 0, this.eeK.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.C0141d.common_color_10004)), this.eeK.length(), str.length(), 33);
        aj.s(this.eeI, d.f.btn_general_start_selector);
        this.eey.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String eeK;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.eeF = null;
        }

        public a(String str, String str2) {
            this.eeK = null;
            this.mVcode = null;
            this.eeK = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.Cy().Dv().mIsNeedTbs = true;
                this.mNetwork.n("kw", this.eeK);
                this.mNetwork.n("vcode", this.mVcode);
                this.mNetwork.n("vcode_md5", CreateBarActivity.this.eeH);
                this.mNetwork.Ca();
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
            CreateBarActivity.this.eeF = null;
            if (this.mNetwork.Cy().Dw().isRequestSuccess()) {
                CreateBarSuccessActivity.ah(CreateBarActivity.this.getPageContext().getPageActivity(), this.eeK);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.CB()) {
                CreateBarActivity.this.aBW();
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
                this.mNetwork.mS();
            }
            CreateBarActivity.this.eeE.setVisibility(8);
            CreateBarActivity.this.eeG = null;
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
                String Ca = this.mNetwork.Ca();
                if (this.mNetwork.Cy().Dw().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(Ca);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.eeH = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.Cb());
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
            CreateBarActivity.this.eeE.setVisibility(8);
            CreateBarActivity.this.eeG = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.eeH = null;
            CreateBarActivity.this.eeE.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
