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
    private RelativeLayout dRW;
    public NavigationBar mNavigationBar;
    private TextView dRM = null;
    private TextView dRN = null;
    private EditText dRO = null;
    private EditText dRP = null;
    private RelativeLayout dRQ = null;
    private FrameLayout dRR = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar dRS = null;
    private a dRT = null;
    private b dRU = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String dRV = null;
    private TextView mErrorView = null;
    private RelativeLayout bmp = null;
    private TextView dRX = null;
    private String dRY = null;
    private boolean dRZ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.create_bar_activity);
        initData();
        initUI();
        aCY();
        adjustResizeForSoftInput();
    }

    private void aCY() {
        if (this.dRU == null) {
            this.dRU = new b();
            this.dRU.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dRT != null) {
            this.dRT.cancel();
        }
        if (this.dRU != null) {
            this.dRU.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.dRY = intent.getStringExtra("barname");
        this.dRZ = intent.getBooleanExtra("isvalid", false);
        if (this.dRY == null) {
            this.dRY = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCZ() {
        if (this.dRU == null && this.dRT == null) {
            this.dRU = new b();
            this.dRU.setPriority(3);
            this.dRU.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDa() {
        if (this.dRT == null) {
            this.dRT = new a(this.dRO.getText().toString().trim(), this.dRP.getText().toString().trim());
            this.dRT.setPriority(3);
            this.dRT.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.dRQ) {
                    CreateBarActivity.this.aDa();
                } else if (view == CreateBarActivity.this.dRR) {
                    CreateBarActivity.this.aCZ();
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
                int length = CreateBarActivity.this.dRO.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.dRP.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.dRQ.setEnabled(false);
                } else {
                    CreateBarActivity.this.dRQ.setEnabled(true);
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
        this.bmp = (RelativeLayout) findViewById(d.g.container);
        this.dRX = (TextView) findViewById(d.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(d.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(d.g.error);
        this.dRM = (TextView) findViewById(d.g.info);
        this.dRQ = (RelativeLayout) findViewById(d.g.create);
        this.dRQ.setOnClickListener(this.mOnClickListener);
        this.dRN = (TextView) findViewById(d.g.info2);
        this.dRO = (EditText) findViewById(d.g.edit_name);
        this.dRO.addTextChangedListener(this.mTextWatcher);
        this.dRP = (EditText) findViewById(d.g.edit_vcode);
        this.dRP.addTextChangedListener(this.mTextWatcher);
        if (this.dRZ) {
            this.dRN.setText(getPageContext().getString(d.j.noforum_create_form_tip));
            this.dRO.setText(this.dRY);
        } else {
            this.dRN.setText(getPageContext().getString(d.j.bar_name_invalid));
        }
        this.dRW = (RelativeLayout) findViewById(d.g.create);
        this.dRR = (FrameLayout) findViewById(d.g.image_button);
        this.dRR.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.dRQ.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dRS = (ProgressBar) findViewById(d.g.progress_image);
        if (this.dRZ) {
            this.dRP.requestFocus();
        }
        findViewById(d.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.dRO.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dRO);
                    }
                    if (CreateBarActivity.this.dRP.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.dRP);
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
        getLayoutMode().onModeChanged(this.bmp);
        am.a(this.dRX, i);
        am.b(this.dRN, i);
        String str = this.dRY + getPageContext().getString(d.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.common_color_10252)), 0, this.dRY.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.C0140d.common_color_10004)), this.dRY.length(), str.length(), 33);
        am.i(this.dRW, d.f.btn_general_start_selector);
        this.dRM.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dRY;
        private y mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.dRT = null;
        }

        public a(String str, String str2) {
            this.dRY = null;
            this.mVcode = null;
            this.dRY = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.yO().zM().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.dRY);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateBarActivity.this.dRV);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.yq();
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
            CreateBarActivity.this.dRT = null;
            if (this.mNetwork.yO().zN().isRequestSuccess()) {
                CreateBarSuccessActivity.ag(CreateBarActivity.this.getPageContext().getPageActivity(), this.dRY);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.yR()) {
                CreateBarActivity.this.aCZ();
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
            CreateBarActivity.this.dRS.setVisibility(8);
            CreateBarActivity.this.dRU = null;
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
                String yq = this.mNetwork.yq();
                if (this.mNetwork.yO().zN().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(yq);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.dRV = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new y(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.yr());
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
            CreateBarActivity.this.dRS.setVisibility(8);
            CreateBarActivity.this.dRU = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.dRV = null;
            CreateBarActivity.this.dRS.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
