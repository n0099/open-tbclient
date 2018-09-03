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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout dRR;
    public NavigationBar mNavigationBar;
    private TextView dRH = null;
    private TextView dRI = null;
    private EditText dRJ = null;
    private EditText dRK = null;
    private RelativeLayout dRL = null;
    private FrameLayout dRM = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar dRN = null;
    private a dRO = null;
    private b dRP = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String dRQ = null;
    private TextView mErrorView = null;
    private RelativeLayout bmt = null;
    private TextView dRS = null;
    private String dRT = null;
    private boolean dRU = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.create_bar_activity);
        initData();
        initUI();
        aCV();
        adjustResizeForSoftInput();
    }

    private void aCV() {
        if (this.dRP == null) {
            this.dRP = new b();
            this.dRP.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dRO != null) {
            this.dRO.cancel();
        }
        if (this.dRP != null) {
            this.dRP.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.dRT = intent.getStringExtra("barname");
        this.dRU = intent.getBooleanExtra("isvalid", false);
        if (this.dRT == null) {
            this.dRT = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCW() {
        if (this.dRP == null && this.dRO == null) {
            this.dRP = new b();
            this.dRP.setPriority(3);
            this.dRP.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCX() {
        if (this.dRO == null) {
            this.dRO = new a(this.dRJ.getText().toString().trim(), this.dRK.getText().toString().trim());
            this.dRO.setPriority(3);
            this.dRO.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.dRL) {
                    CreateBarActivity.this.aCX();
                } else if (view == CreateBarActivity.this.dRM) {
                    CreateBarActivity.this.aCW();
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
                int length = CreateBarActivity.this.dRJ.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.dRK.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.dRL.setEnabled(false);
                } else {
                    CreateBarActivity.this.dRL.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(f.j.bar_name_long));
                    CreateBarActivity.this.mErrorView.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(f.j.bar_name_rule));
                CreateBarActivity.this.mErrorView.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(f.j.create_bar));
        this.bmt = (RelativeLayout) findViewById(f.g.container);
        this.dRS = (TextView) findViewById(f.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(f.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(f.g.error);
        this.dRH = (TextView) findViewById(f.g.info);
        this.dRL = (RelativeLayout) findViewById(f.g.create);
        this.dRL.setOnClickListener(this.mOnClickListener);
        this.dRI = (TextView) findViewById(f.g.info2);
        this.dRJ = (EditText) findViewById(f.g.edit_name);
        this.dRJ.addTextChangedListener(this.mTextWatcher);
        this.dRK = (EditText) findViewById(f.g.edit_vcode);
        this.dRK.addTextChangedListener(this.mTextWatcher);
        if (this.dRU) {
            this.dRI.setText(getPageContext().getString(f.j.noforum_create_form_tip));
            this.dRJ.setText(this.dRT);
        } else {
            this.dRI.setText(getPageContext().getString(f.j.bar_name_invalid));
        }
        this.dRR = (RelativeLayout) findViewById(f.g.create);
        this.dRM = (FrameLayout) findViewById(f.g.image_button);
        this.dRM.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(f.g.image);
        this.dRL.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(f.g.progress);
        this.dRN = (ProgressBar) findViewById(f.g.progress_image);
        if (this.dRU) {
            this.dRK.requestFocus();
        }
        findViewById(f.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.dRJ.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dRJ);
                    }
                    if (CreateBarActivity.this.dRK.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dRK);
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
        getLayoutMode().onModeChanged(this.bmt);
        am.a(this.dRS, i);
        am.b(this.dRI, i);
        String str = this.dRT + getPageContext().getString(f.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(f.d.common_color_10252)), 0, this.dRT.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(f.d.common_color_10004)), this.dRT.length(), str.length(), 33);
        am.i(this.dRR, f.C0146f.btn_general_start_selector);
        this.dRH.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dRT;
        private y mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.dRO = null;
        }

        public a(String str, String str2) {
            this.dRT = null;
            this.mVcode = null;
            this.dRT = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.yM().zK().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.dRT);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateBarActivity.this.dRQ);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.yo();
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
            CreateBarActivity.this.dRO = null;
            if (this.mNetwork.yM().zL().isRequestSuccess()) {
                CreateBarSuccessActivity.ag(CreateBarActivity.this.getPageContext().getPageActivity(), this.dRT);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.yP()) {
                CreateBarActivity.this.aCW();
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
            CreateBarActivity.this.dRN.setVisibility(8);
            CreateBarActivity.this.dRP = null;
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
                String yo = this.mNetwork.yo();
                if (this.mNetwork.yM().zL().isRequestSuccess()) {
                    u uVar = new u();
                    uVar.parserJson(yo);
                    if (uVar.getVcode_pic_url() == null || uVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.dRQ = uVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new y(uVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.yp());
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
            CreateBarActivity.this.dRN.setVisibility(8);
            CreateBarActivity.this.dRP = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.dRQ = null;
            CreateBarActivity.this.dRN.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
