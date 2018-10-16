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
    private RelativeLayout ehb;
    public NavigationBar mNavigationBar;
    private TextView egR = null;
    private TextView egS = null;
    private EditText egT = null;
    private EditText egU = null;
    private RelativeLayout egV = null;
    private FrameLayout egW = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar egX = null;
    private a egY = null;
    private b egZ = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String eha = null;
    private TextView mErrorView = null;
    private RelativeLayout bwo = null;
    private TextView ehc = null;
    private String ehd = null;
    private boolean ehe = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_bar_activity);
        initData();
        initUI();
        aIA();
        adjustResizeForSoftInput();
    }

    private void aIA() {
        if (this.egZ == null) {
            this.egZ = new b();
            this.egZ.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.egY != null) {
            this.egY.cancel();
        }
        if (this.egZ != null) {
            this.egZ.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.ehd = intent.getStringExtra("barname");
        this.ehe = intent.getBooleanExtra("isvalid", false);
        if (this.ehd == null) {
            this.ehd = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIB() {
        if (this.egZ == null && this.egY == null) {
            this.egZ = new b();
            this.egZ.setPriority(3);
            this.egZ.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIC() {
        if (this.egY == null) {
            this.egY = new a(this.egT.getText().toString().trim(), this.egU.getText().toString().trim());
            this.egY.setPriority(3);
            this.egY.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.egV) {
                    CreateBarActivity.this.aIC();
                } else if (view == CreateBarActivity.this.egW) {
                    CreateBarActivity.this.aIB();
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
                int length = CreateBarActivity.this.egT.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.egU.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.egV.setEnabled(false);
                } else {
                    CreateBarActivity.this.egV.setEnabled(true);
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
        this.bwo = (RelativeLayout) findViewById(e.g.container);
        this.ehc = (TextView) findViewById(e.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(e.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(e.g.error);
        this.egR = (TextView) findViewById(e.g.info);
        this.egV = (RelativeLayout) findViewById(e.g.create);
        this.egV.setOnClickListener(this.mOnClickListener);
        this.egS = (TextView) findViewById(e.g.info2);
        this.egT = (EditText) findViewById(e.g.edit_name);
        this.egT.addTextChangedListener(this.mTextWatcher);
        this.egU = (EditText) findViewById(e.g.edit_vcode);
        this.egU.addTextChangedListener(this.mTextWatcher);
        if (this.ehe) {
            this.egS.setText(getPageContext().getString(e.j.noforum_create_form_tip));
            this.egT.setText(this.ehd);
        } else {
            this.egS.setText(getPageContext().getString(e.j.bar_name_invalid));
        }
        this.ehb = (RelativeLayout) findViewById(e.g.create);
        this.egW = (FrameLayout) findViewById(e.g.image_button);
        this.egW.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.egV.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.egX = (ProgressBar) findViewById(e.g.progress_image);
        if (this.ehe) {
            this.egU.requestFocus();
        }
        findViewById(e.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.egT.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.egT);
                    }
                    if (CreateBarActivity.this.egU.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.egU);
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
        getLayoutMode().onModeChanged(this.bwo);
        al.a(this.ehc, i);
        al.b(this.egS, i);
        String str = this.ehd + getPageContext().getString(e.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(e.d.common_color_10252)), 0, this.ehd.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(e.d.common_color_10004)), this.ehd.length(), str.length(), 33);
        al.i(this.ehb, e.f.btn_general_start_selector);
        this.egR.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String ehd;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.egY = null;
        }

        public a(String str, String str2) {
            this.ehd = null;
            this.mVcode = null;
            this.ehd = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.BY().CW().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.ehd);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateBarActivity.this.eha);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.BA();
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
            CreateBarActivity.this.egY = null;
            if (this.mNetwork.BY().CX().isRequestSuccess()) {
                CreateBarSuccessActivity.ax(CreateBarActivity.this.getPageContext().getPageActivity(), this.ehd);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.Cb()) {
                CreateBarActivity.this.aIB();
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
                this.mNetwork.ji();
            }
            CreateBarActivity.this.egX.setVisibility(8);
            CreateBarActivity.this.egZ = null;
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
                String BA = this.mNetwork.BA();
                if (this.mNetwork.BY().CX().isRequestSuccess()) {
                    v vVar = new v();
                    vVar.parserJson(BA);
                    if (vVar.getVcode_pic_url() == null || vVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.eha = vVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(vVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.BB());
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
            CreateBarActivity.this.egX.setVisibility(8);
            CreateBarActivity.this.egZ = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.eha = null;
            CreateBarActivity.this.egX.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
