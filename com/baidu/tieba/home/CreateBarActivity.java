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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout dPj;
    public NavigationBar mNavigationBar;
    private TextView dOZ = null;
    private TextView dPa = null;
    private EditText dPb = null;
    private EditText dPc = null;
    private RelativeLayout dPd = null;
    private FrameLayout dPe = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar dPf = null;
    private a dPg = null;
    private b dPh = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String dPi = null;
    private TextView mErrorView = null;
    private RelativeLayout blJ = null;
    private TextView dPk = null;
    private String dPl = null;
    private boolean dPm = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.create_bar_activity);
        initData();
        initUI();
        aCp();
        adjustResizeForSoftInput();
    }

    private void aCp() {
        if (this.dPh == null) {
            this.dPh = new b();
            this.dPh.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dPg != null) {
            this.dPg.cancel();
        }
        if (this.dPh != null) {
            this.dPh.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.dPl = intent.getStringExtra("barname");
        this.dPm = intent.getBooleanExtra("isvalid", false);
        if (this.dPl == null) {
            this.dPl = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCq() {
        if (this.dPh == null && this.dPg == null) {
            this.dPh = new b();
            this.dPh.setPriority(3);
            this.dPh.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCr() {
        if (this.dPg == null) {
            this.dPg = new a(this.dPb.getText().toString().trim(), this.dPc.getText().toString().trim());
            this.dPg.setPriority(3);
            this.dPg.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.dPd) {
                    CreateBarActivity.this.aCr();
                } else if (view == CreateBarActivity.this.dPe) {
                    CreateBarActivity.this.aCq();
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
                int length = CreateBarActivity.this.dPb.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.dPc.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.dPd.setEnabled(false);
                } else {
                    CreateBarActivity.this.dPd.setEnabled(true);
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
        this.blJ = (RelativeLayout) findViewById(d.g.container);
        this.dPk = (TextView) findViewById(d.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(d.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(d.g.error);
        this.dOZ = (TextView) findViewById(d.g.info);
        this.dPd = (RelativeLayout) findViewById(d.g.create);
        this.dPd.setOnClickListener(this.mOnClickListener);
        this.dPa = (TextView) findViewById(d.g.info2);
        this.dPb = (EditText) findViewById(d.g.edit_name);
        this.dPb.addTextChangedListener(this.mTextWatcher);
        this.dPc = (EditText) findViewById(d.g.edit_vcode);
        this.dPc.addTextChangedListener(this.mTextWatcher);
        if (this.dPm) {
            this.dPa.setText(getPageContext().getString(d.k.noforum_create_form_tip));
            this.dPb.setText(this.dPl);
        } else {
            this.dPa.setText(getPageContext().getString(d.k.bar_name_invalid));
        }
        this.dPj = (RelativeLayout) findViewById(d.g.create);
        this.dPe = (FrameLayout) findViewById(d.g.image_button);
        this.dPe.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.dPd.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dPf = (ProgressBar) findViewById(d.g.progress_image);
        if (this.dPm) {
            this.dPc.requestFocus();
        }
        findViewById(d.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.dPb.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dPb);
                    }
                    if (CreateBarActivity.this.dPc.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dPc);
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
        getLayoutMode().onModeChanged(this.blJ);
        am.a(this.dPk, i);
        am.b(this.dPa, i);
        String str = this.dPl + getPageContext().getString(d.k.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.common_color_10252)), 0, this.dPl.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.C0142d.common_color_10004)), this.dPl.length(), str.length(), 33);
        am.i(this.dPj, d.f.btn_general_start_selector);
        this.dOZ.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dPl;
        private y mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.dPg = null;
        }

        public a(String str, String str2) {
            this.dPl = null;
            this.mVcode = null;
            this.dPl = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.yX().zX().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.dPl);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateBarActivity.this.dPi);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.yz();
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
            CreateBarActivity.this.dPg = null;
            if (this.mNetwork.yX().zY().isRequestSuccess()) {
                CreateBarSuccessActivity.ae(CreateBarActivity.this.getPageContext().getPageActivity(), this.dPl);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.za()) {
                CreateBarActivity.this.aCq();
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
        private y mNetwork;

        private b() {
            this.mNetwork = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.mCanceled = true;
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            CreateBarActivity.this.dPf.setVisibility(8);
            CreateBarActivity.this.dPh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetwork.o(ImageViewerConfig.FORUM_ID, "0");
                this.mNetwork.o("pub_type", "0");
                this.mNetwork.o(ImageViewerConfig.FORUM_NAME, "");
                this.mNetwork.o("tid", "0");
                String yz = this.mNetwork.yz();
                if (this.mNetwork.yX().zY().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(yz);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.dPi = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new y(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.yA());
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
            CreateBarActivity.this.dPf.setVisibility(8);
            CreateBarActivity.this.dPh = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.dPi = null;
            CreateBarActivity.this.dPf.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
