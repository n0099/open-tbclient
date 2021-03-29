package com.baidu.tieba.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.s.c.f0;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    public RelativeLayout mCreatebar;
    public NavigationBar mNavigationBar;
    public TextView mTextInfo = null;
    public TextView mTextInfo2 = null;
    public EditText mEditName = null;
    public EditText mEditVcode = null;
    public RelativeLayout mCreate = null;
    public FrameLayout mImageButton = null;
    public ImageView mImage = null;
    public ProgressBar mProgress = null;
    public ProgressBar mProgressImage = null;
    public d mCreateTask = null;
    public e mGetImageTask = null;
    public View.OnClickListener mOnClickListener = null;
    public TextWatcher mTextWatcher = null;
    public String mVcode_md5 = null;
    public TextView mErrorView = null;
    public RelativeLayout mContainer = null;
    public TextView mCreateButtonText = null;
    public String mBarName = null;
    public boolean mBarNameIsValid = false;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == CreateBarActivity.this.mCreate) {
                CreateBarActivity.this.startCreateTask();
            } else if (view == CreateBarActivity.this.mImageButton) {
                CreateBarActivity.this.startImageTask();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int length = CreateBarActivity.this.mEditName.getText().toString().trim().length();
            if (length <= 0 || length >= 32 || CreateBarActivity.this.mEditVcode.getText().toString().trim().length() <= 0) {
                CreateBarActivity.this.mCreate.setEnabled(false);
            } else {
                CreateBarActivity.this.mCreate.setEnabled(true);
            }
            if (length >= 32) {
                CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_long));
                CreateBarActivity.this.mErrorView.setTextColor(-65536);
                return;
            }
            CreateBarActivity.this.mErrorView.setText(CreateBarActivity.this.getPageContext().getString(R.string.bar_name_rule));
            CreateBarActivity.this.mErrorView.setTextColor(-6250336);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                if (CreateBarActivity.this.mEditName.hasFocus()) {
                    l.w(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.mEditName);
                }
                if (CreateBarActivity.this.mEditVcode.hasFocus()) {
                    l.w(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.mEditVcode);
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f16950a;

        /* renamed from: b  reason: collision with root package name */
        public String f16951b;

        /* renamed from: c  reason: collision with root package name */
        public NetWork f16952c = null;

        public d(String str, String str2) {
            this.f16950a = null;
            this.f16951b = null;
            this.f16950a = str;
            this.f16951b = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f16952c;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.mCreateTask = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.mProgress.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.f16952c = netWork;
                netWork.getNetContext().getRequest().mIsNeedTbs = true;
                this.f16952c.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f16950a);
                this.f16952c.addPostData("vcode", this.f16951b);
                this.f16952c.addPostData("vcode_md5", CreateBarActivity.this.mVcode_md5);
                this.f16952c.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.f16952c.postNetData();
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((d) str);
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.mCreateTask = null;
            if (this.f16952c.getNetContext().getResponse().isRequestSuccess()) {
                CreateBarSuccessActivity.startActivity(CreateBarActivity.this.getPageContext().getPageActivity(), this.f16950a);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.f16952c.getErrorString());
            if (this.f16952c.isNetSuccess()) {
                CreateBarActivity.this.startImageTask();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f16954a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f16955b;

        public e() {
            this.f16954a = null;
            this.f16955b = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.f16954a = netWork;
                netWork.addPostData("fid", "0");
                this.f16954a.addPostData("pub_type", "0");
                this.f16954a.addPostData("fname", "");
                this.f16954a.addPostData("tid", "0");
                String postNetData = this.f16954a.postNetData();
                if (this.f16954a.getNetContext().getResponse().isRequestSuccess()) {
                    f0 f0Var = new f0();
                    f0Var.e(postNetData);
                    if (f0Var.c() != null && f0Var.c().length() > 0) {
                        CreateBarActivity.this.mVcode_md5 = f0Var.b();
                        if (this.f16955b) {
                            return null;
                        }
                        NetWork netWork2 = new NetWork(f0Var.c());
                        this.f16954a = netWork2;
                        return BitmapHelper.Bytes2Bitmap(netWork2.getNetData());
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.f16955b = true;
            NetWork netWork = this.f16954a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            CreateBarActivity.this.mProgressImage.setVisibility(8);
            CreateBarActivity.this.mGetImageTask = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.mVcode_md5 = null;
            CreateBarActivity.this.mProgressImage.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((e) bitmap);
            CreateBarActivity.this.mProgressImage.setVisibility(8);
            CreateBarActivity.this.mGetImageTask = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        public /* synthetic */ e(CreateBarActivity createBarActivity, a aVar) {
            this();
        }
    }

    private void getImage() {
        if (this.mGetImageTask == null) {
            e eVar = new e(this, null);
            this.mGetImageTask = eVar;
            eVar.execute(new String[0]);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.mBarName = intent.getStringExtra("barname");
        this.mBarNameIsValid = intent.getBooleanExtra("isvalid", false);
        if (this.mBarName == null) {
            this.mBarName = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new a();
        this.mTextWatcher = new b();
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.mCreateButtonText = (TextView) findViewById(R.id.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(R.id.error);
        this.mTextInfo = (TextView) findViewById(R.id.info);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.create);
        this.mCreate = relativeLayout;
        relativeLayout.setOnClickListener(this.mOnClickListener);
        this.mTextInfo2 = (TextView) findViewById(R.id.info2);
        EditText editText = (EditText) findViewById(R.id.edit_name);
        this.mEditName = editText;
        editText.addTextChangedListener(this.mTextWatcher);
        EditText editText2 = (EditText) findViewById(R.id.edit_vcode);
        this.mEditVcode = editText2;
        editText2.addTextChangedListener(this.mTextWatcher);
        if (this.mBarNameIsValid) {
            this.mTextInfo2.setText(getPageContext().getString(R.string.noforum_create_form_tip));
            this.mEditName.setText(this.mBarName);
        } else {
            this.mTextInfo2.setText(getPageContext().getString(R.string.bar_name_invalid));
        }
        this.mCreatebar = (RelativeLayout) findViewById(R.id.create);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.image_button);
        this.mImageButton = frameLayout;
        frameLayout.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.mCreate.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgressImage = (ProgressBar) findViewById(R.id.progress_image);
        if (this.mBarNameIsValid) {
            this.mEditVcode.requestFocus();
        }
        findViewById(R.id.show_message_container).setOnTouchListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCreateTask() {
        if (this.mCreateTask == null) {
            d dVar = new d(this.mEditName.getText().toString().trim(), this.mEditVcode.getText().toString().trim());
            this.mCreateTask = dVar;
            dVar.setPriority(3);
            this.mCreateTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startImageTask() {
        if (this.mGetImageTask == null && this.mCreateTask == null) {
            e eVar = new e(this, null);
            this.mGetImageTask = eVar;
            eVar.setPriority(3);
            this.mGetImageTask.execute(new String[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().k(i == 1);
        getLayoutMode().j(this.mContainer);
        SkinManager.setButtonTextColor(this.mCreateButtonText, i);
        SkinManager.setTextColor(this.mTextInfo2, i);
        String str = this.mBarName + getPageContext().getString(R.string.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10252)), 0, this.mBarName.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.mBarName.length(), str.length(), 33);
        SkinManager.setBackgroundResource(this.mCreatebar, R.drawable.btn_general_start_selector);
        this.mTextInfo.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_activity);
        initData();
        initUI();
        getImage();
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.mCreateTask;
        if (dVar != null) {
            dVar.cancel();
        }
        e eVar = this.mGetImageTask;
        if (eVar != null) {
            eVar.cancel();
        }
    }
}
