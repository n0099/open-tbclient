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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout gdD;
    public NavigationBar mNavigationBar;
    private TextView gdt = null;
    private TextView gdu = null;
    private EditText gdv = null;
    private EditText gdw = null;
    private RelativeLayout gdx = null;
    private FrameLayout gdy = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar gdz = null;
    private a gdA = null;
    private b gdB = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String gdC = null;
    private TextView mErrorView = null;
    private RelativeLayout cXd = null;
    private TextView gdE = null;
    private String gdF = null;
    private boolean gdG = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        bvH();
        adjustResizeForSoftInput();
    }

    private void bvH() {
        if (this.gdB == null) {
            this.gdB = new b();
            this.gdB.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gdA != null) {
            this.gdA.cancel();
        }
        if (this.gdB != null) {
            this.gdB.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.gdF = intent.getStringExtra("barname");
        this.gdG = intent.getBooleanExtra("isvalid", false);
        if (this.gdF == null) {
            this.gdF = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvI() {
        if (this.gdB == null && this.gdA == null) {
            this.gdB = new b();
            this.gdB.setPriority(3);
            this.gdB.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvJ() {
        if (this.gdA == null) {
            this.gdA = new a(this.gdv.getText().toString().trim(), this.gdw.getText().toString().trim());
            this.gdA.setPriority(3);
            this.gdA.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.gdx) {
                    CreateBarActivity.this.bvJ();
                } else if (view == CreateBarActivity.this.gdy) {
                    CreateBarActivity.this.bvI();
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
                int length = CreateBarActivity.this.gdv.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.gdw.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.gdx.setEnabled(false);
                } else {
                    CreateBarActivity.this.gdx.setEnabled(true);
                }
                if (length >= 32) {
                    CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_long));
                    CreateBarActivity.this.mErrorView.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_rule));
                CreateBarActivity.this.mErrorView.setTextColor(-6250336);
            }
        };
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
        this.cXd = (RelativeLayout) findViewById(R.id.container);
        this.gdE = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.gdt = (TextView) findViewById(R.id.info);
        this.gdx = (RelativeLayout) findViewById(R.id.create);
        this.gdx.setOnClickListener(this.mOnClickListener);
        this.gdu = (TextView) findViewById(R.id.info2);
        this.gdv = (EditText) findViewById(R.id.edit_name);
        this.gdv.addTextChangedListener(this.mTextWatcher);
        this.gdw = (EditText) findViewById(R.id.edit_vcode);
        this.gdw.addTextChangedListener(this.mTextWatcher);
        if (this.gdG) {
            this.gdu.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.gdv.setText(this.gdF);
        } else {
            this.gdu.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.gdD = (RelativeLayout) findViewById(R.id.create);
        this.gdy = (FrameLayout) findViewById(R.id.image_button);
        this.gdy.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.gdx.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gdz = (ProgressBar) findViewById(R.id.progress_image);
        if (this.gdG) {
            this.gdw.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.gdv.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gdv);
                    }
                    if (CreateBarActivity.this.gdw.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.gdw);
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
        getLayoutMode().onModeChanged(this.cXd);
        am.a(this.gdE, i);
        am.b(this.gdu, i);
        String str = this.gdF + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), 0, this.gdF.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.gdF.length(), str.length(), 33);
        am.k(this.gdD, R.drawable.btn_general_start_selector);
        this.gdt.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String gdF;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ik();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.gdA = null;
        }

        public a(String str, String str2) {
            this.gdF = null;
            this.mVcode = null;
            this.gdF = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.aiK().ajM().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.gdF);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateBarActivity.this.gdC);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.aim();
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
            CreateBarActivity.this.gdA = null;
            if (this.mNetwork.aiK().ajN().isRequestSuccess()) {
                CreateBarSuccessActivity.aF(CreateBarActivity.this.getPageContext().getPageActivity(), this.gdF);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.aiN()) {
                CreateBarActivity.this.bvI();
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
    /* loaded from: classes6.dex */
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
                this.mNetwork.ik();
            }
            CreateBarActivity.this.gdz.setVisibility(8);
            CreateBarActivity.this.gdB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetwork.o("fid", "0");
                this.mNetwork.o("pub_type", "0");
                this.mNetwork.o(ImageViewerConfig.FORUM_NAME, "");
                this.mNetwork.o("tid", "0");
                String aim = this.mNetwork.aim();
                if (this.mNetwork.aiK().ajN().isRequestSuccess()) {
                    y yVar = new y();
                    yVar.parserJson(aim);
                    if (yVar.getVcode_pic_url() == null || yVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.gdC = yVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(yVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.ain());
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
            CreateBarActivity.this.gdz.setVisibility(8);
            CreateBarActivity.this.gdB = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.gdC = null;
            CreateBarActivity.this.gdz.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
