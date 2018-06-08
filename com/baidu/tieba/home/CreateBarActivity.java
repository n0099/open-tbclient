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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout dLS;
    public NavigationBar mNavigationBar;
    private TextView dLI = null;
    private TextView dLJ = null;
    private EditText dLK = null;
    private EditText dLL = null;
    private RelativeLayout dLM = null;
    private FrameLayout dLN = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar dLO = null;
    private a dLP = null;
    private b dLQ = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String dLR = null;
    private TextView mErrorView = null;
    private RelativeLayout bkk = null;
    private TextView dLT = null;
    private String dLU = null;
    private boolean dLV = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.create_bar_activity);
        initData();
        initUI();
        aBJ();
        adjustResizeForSoftInput();
    }

    private void aBJ() {
        if (this.dLQ == null) {
            this.dLQ = new b();
            this.dLQ.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dLP != null) {
            this.dLP.cancel();
        }
        if (this.dLQ != null) {
            this.dLQ.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.dLU = intent.getStringExtra("barname");
        this.dLV = intent.getBooleanExtra("isvalid", false);
        if (this.dLU == null) {
            this.dLU = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBK() {
        if (this.dLQ == null && this.dLP == null) {
            this.dLQ = new b();
            this.dLQ.setPriority(3);
            this.dLQ.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBL() {
        if (this.dLP == null) {
            this.dLP = new a(this.dLK.getText().toString().trim(), this.dLL.getText().toString().trim());
            this.dLP.setPriority(3);
            this.dLP.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.dLM) {
                    CreateBarActivity.this.aBL();
                } else if (view == CreateBarActivity.this.dLN) {
                    CreateBarActivity.this.aBK();
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
                int length = CreateBarActivity.this.dLK.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.dLL.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.dLM.setEnabled(false);
                } else {
                    CreateBarActivity.this.dLM.setEnabled(true);
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
        this.bkk = (RelativeLayout) findViewById(d.g.container);
        this.dLT = (TextView) findViewById(d.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(d.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(d.g.error);
        this.dLI = (TextView) findViewById(d.g.info);
        this.dLM = (RelativeLayout) findViewById(d.g.create);
        this.dLM.setOnClickListener(this.mOnClickListener);
        this.dLJ = (TextView) findViewById(d.g.info2);
        this.dLK = (EditText) findViewById(d.g.edit_name);
        this.dLK.addTextChangedListener(this.mTextWatcher);
        this.dLL = (EditText) findViewById(d.g.edit_vcode);
        this.dLL.addTextChangedListener(this.mTextWatcher);
        if (this.dLV) {
            this.dLJ.setText(getPageContext().getString(d.k.noforum_create_form_tip));
            this.dLK.setText(this.dLU);
        } else {
            this.dLJ.setText(getPageContext().getString(d.k.bar_name_invalid));
        }
        this.dLS = (RelativeLayout) findViewById(d.g.create);
        this.dLN = (FrameLayout) findViewById(d.g.image_button);
        this.dLN.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.dLM.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dLO = (ProgressBar) findViewById(d.g.progress_image);
        if (this.dLV) {
            this.dLL.requestFocus();
        }
        findViewById(d.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.dLK.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dLK);
                    }
                    if (CreateBarActivity.this.dLL.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dLL);
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
        getLayoutMode().onModeChanged(this.bkk);
        al.a(this.dLT, i);
        al.b(this.dLJ, i);
        String str = this.dLU + getPageContext().getString(d.k.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(d.C0141d.common_color_10252)), 0, this.dLU.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.C0141d.common_color_10004)), this.dLU.length(), str.length(), 33);
        al.i(this.dLS, d.f.btn_general_start_selector);
        this.dLI.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dLU;
        private y mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.dLP = null;
        }

        public a(String str, String str2) {
            this.dLU = null;
            this.mVcode = null;
            this.dLU = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.yJ().zI().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.dLU);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateBarActivity.this.dLR);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.yl();
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
            CreateBarActivity.this.dLP = null;
            if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                CreateBarSuccessActivity.ae(CreateBarActivity.this.getPageContext().getPageActivity(), this.dLU);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.yM()) {
                CreateBarActivity.this.aBK();
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
            CreateBarActivity.this.dLO.setVisibility(8);
            CreateBarActivity.this.dLQ = null;
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
                String yl = this.mNetwork.yl();
                if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(yl);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.dLR = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new y(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.ym());
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
            CreateBarActivity.this.dLO.setVisibility(8);
            CreateBarActivity.this.dLQ = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.dLR = null;
            CreateBarActivity.this.dLO.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
