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
    private RelativeLayout eeY;
    public NavigationBar mNavigationBar;
    private TextView eeO = null;
    private TextView eeP = null;
    private EditText eeQ = null;
    private EditText eeR = null;
    private RelativeLayout eeS = null;
    private FrameLayout eeT = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar eeU = null;
    private a eeV = null;
    private b eeW = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String eeX = null;
    private TextView rK = null;
    private RelativeLayout bRU = null;
    private TextView eeZ = null;
    private String efa = null;
    private boolean efb = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.create_bar_activity);
        initData();
        initUI();
        aBW();
        adjustResizeForSoftInput();
    }

    private void aBW() {
        if (this.eeW == null) {
            this.eeW = new b();
            this.eeW.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eeV != null) {
            this.eeV.cancel();
        }
        if (this.eeW != null) {
            this.eeW.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.efa = intent.getStringExtra("barname");
        this.efb = intent.getBooleanExtra("isvalid", false);
        if (this.efa == null) {
            this.efa = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBX() {
        if (this.eeW == null && this.eeV == null) {
            this.eeW = new b();
            this.eeW.setPriority(3);
            this.eeW.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBY() {
        if (this.eeV == null) {
            this.eeV = new a(this.eeQ.getText().toString().trim(), this.eeR.getText().toString().trim());
            this.eeV.setPriority(3);
            this.eeV.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.eeS) {
                    CreateBarActivity.this.aBY();
                } else if (view == CreateBarActivity.this.eeT) {
                    CreateBarActivity.this.aBX();
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
                int length = CreateBarActivity.this.eeQ.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.eeR.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.eeS.setEnabled(false);
                } else {
                    CreateBarActivity.this.eeS.setEnabled(true);
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
        this.bRU = (RelativeLayout) findViewById(d.g.container);
        this.eeZ = (TextView) findViewById(d.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(d.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.rK = (TextView) findViewById(d.g.error);
        this.eeO = (TextView) findViewById(d.g.info);
        this.eeS = (RelativeLayout) findViewById(d.g.create);
        this.eeS.setOnClickListener(this.mOnClickListener);
        this.eeP = (TextView) findViewById(d.g.info2);
        this.eeQ = (EditText) findViewById(d.g.edit_name);
        this.eeQ.addTextChangedListener(this.mTextWatcher);
        this.eeR = (EditText) findViewById(d.g.edit_vcode);
        this.eeR.addTextChangedListener(this.mTextWatcher);
        if (this.efb) {
            this.eeP.setText(getPageContext().getString(d.j.noforum_create_form_tip));
            this.eeQ.setText(this.efa);
        } else {
            this.eeP.setText(getPageContext().getString(d.j.bar_name_invalid));
        }
        this.eeY = (RelativeLayout) findViewById(d.g.create);
        this.eeT = (FrameLayout) findViewById(d.g.image_button);
        this.eeT.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.eeS.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.eeU = (ProgressBar) findViewById(d.g.progress_image);
        if (this.efb) {
            this.eeR.requestFocus();
        }
        findViewById(d.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.eeQ.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.eeQ);
                    }
                    if (CreateBarActivity.this.eeR.hasFocus()) {
                        l.a(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.eeR);
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
        getLayoutMode().aM(this.bRU);
        aj.b(this.eeZ, i);
        aj.c(this.eeP, i);
        String str = this.efa + getPageContext().getString(d.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.common_color_10252)), 0, this.efa.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(d.C0141d.common_color_10004)), this.efa.length(), str.length(), 33);
        aj.s(this.eeY, d.f.btn_general_start_selector);
        this.eeO.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String efa;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.eeV = null;
        }

        public a(String str, String str2) {
            this.efa = null;
            this.mVcode = null;
            this.efa = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.Cz().Dw().mIsNeedTbs = true;
                this.mNetwork.n("kw", this.efa);
                this.mNetwork.n("vcode", this.mVcode);
                this.mNetwork.n("vcode_md5", CreateBarActivity.this.eeX);
                this.mNetwork.Cb();
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
            CreateBarActivity.this.eeV = null;
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                CreateBarSuccessActivity.ah(CreateBarActivity.this.getPageContext().getPageActivity(), this.efa);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.CC()) {
                CreateBarActivity.this.aBX();
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
            CreateBarActivity.this.eeU.setVisibility(8);
            CreateBarActivity.this.eeW = null;
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
                String Cb = this.mNetwork.Cb();
                if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(Cb);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.eeX = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.Cc());
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
            CreateBarActivity.this.eeU.setVisibility(8);
            CreateBarActivity.this.eeW = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.eeX = null;
            CreateBarActivity.this.eeU.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
