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
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    private RelativeLayout eiw;
    public NavigationBar mNavigationBar;
    private TextView eim = null;
    private TextView ein = null;
    private EditText eio = null;
    private EditText eip = null;
    private RelativeLayout eiq = null;
    private FrameLayout eir = null;
    private ImageView mImage = null;
    private ProgressBar mProgress = null;
    private ProgressBar eis = null;
    private a eit = null;
    private b eiu = null;
    private View.OnClickListener mOnClickListener = null;
    private TextWatcher mTextWatcher = null;
    private String eiv = null;
    private TextView mErrorView = null;
    private RelativeLayout bwZ = null;
    private TextView eix = null;
    private String eiy = null;
    private boolean eiz = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_bar_activity);
        initData();
        initUI();
        aHY();
        adjustResizeForSoftInput();
    }

    private void aHY() {
        if (this.eiu == null) {
            this.eiu = new b();
            this.eiu.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eit != null) {
            this.eit.cancel();
        }
        if (this.eiu != null) {
            this.eiu.cancel();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.eiy = intent.getStringExtra("barname");
        this.eiz = intent.getBooleanExtra("isvalid", false);
        if (this.eiy == null) {
            this.eiy = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHZ() {
        if (this.eiu == null && this.eit == null) {
            this.eiu = new b();
            this.eiu.setPriority(3);
            this.eiu.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIa() {
        if (this.eit == null) {
            this.eit = new a(this.eio.getText().toString().trim(), this.eip.getText().toString().trim());
            this.eit.setPriority(3);
            this.eit.execute(new String[0]);
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateBarActivity.this.eiq) {
                    CreateBarActivity.this.aIa();
                } else if (view == CreateBarActivity.this.eir) {
                    CreateBarActivity.this.aHZ();
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
                int length = CreateBarActivity.this.eio.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || CreateBarActivity.this.eip.getText().toString().trim().length() <= 0) {
                    CreateBarActivity.this.eiq.setEnabled(false);
                } else {
                    CreateBarActivity.this.eiq.setEnabled(true);
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
        this.bwZ = (RelativeLayout) findViewById(e.g.container);
        this.eix = (TextView) findViewById(e.g.text);
        ((LinearLayout.LayoutParams) ((TextView) findViewById(e.g.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mErrorView = (TextView) findViewById(e.g.error);
        this.eim = (TextView) findViewById(e.g.info);
        this.eiq = (RelativeLayout) findViewById(e.g.create);
        this.eiq.setOnClickListener(this.mOnClickListener);
        this.ein = (TextView) findViewById(e.g.info2);
        this.eio = (EditText) findViewById(e.g.edit_name);
        this.eio.addTextChangedListener(this.mTextWatcher);
        this.eip = (EditText) findViewById(e.g.edit_vcode);
        this.eip.addTextChangedListener(this.mTextWatcher);
        if (this.eiz) {
            this.ein.setText(getPageContext().getString(e.j.noforum_create_form_tip));
            this.eio.setText(this.eiy);
        } else {
            this.ein.setText(getPageContext().getString(e.j.bar_name_invalid));
        }
        this.eiw = (RelativeLayout) findViewById(e.g.create);
        this.eir = (FrameLayout) findViewById(e.g.image_button);
        this.eir.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.eiq.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.eis = (ProgressBar) findViewById(e.g.progress_image);
        if (this.eiz) {
            this.eip.requestFocus();
        }
        findViewById(e.g.show_message_container).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateBarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateBarActivity.this.eio.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.eio);
                    }
                    if (CreateBarActivity.this.eip.hasFocus()) {
                        l.b(CreateBarActivity.this.getPageContext().getPageActivity(), CreateBarActivity.this.eip);
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
        getLayoutMode().onModeChanged(this.bwZ);
        al.a(this.eix, i);
        al.b(this.ein, i);
        String str = this.eiy + getPageContext().getString(e.j.bar_not_create);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
        }
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(e.d.common_color_10252)), 0, this.eiy.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(e.d.common_color_10004)), this.eiy.length(), str.length(), 33);
        al.i(this.eiw, e.f.btn_general_start_selector);
        this.eim.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String eiy;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            CreateBarActivity.this.mProgress.setVisibility(8);
            CreateBarActivity.this.eit = null;
        }

        public a(String str, String str2) {
            this.eiy = null;
            this.mVcode = null;
            this.eiy = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.Cf().Dd().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.eiy);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateBarActivity.this.eiv);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.BH();
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
            CreateBarActivity.this.eit = null;
            if (this.mNetwork.Cf().De().isRequestSuccess()) {
                CreateBarSuccessActivity.av(CreateBarActivity.this.getPageContext().getPageActivity(), this.eiy);
                CreateBarActivity.this.finish();
                return;
            }
            CreateBarActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.Ci()) {
                CreateBarActivity.this.aHZ();
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
                this.mNetwork.jg();
            }
            CreateBarActivity.this.eis.setVisibility(8);
            CreateBarActivity.this.eiu = null;
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
                String BH = this.mNetwork.BH();
                if (this.mNetwork.Cf().De().isRequestSuccess()) {
                    w wVar = new w();
                    wVar.parserJson(BH);
                    if (wVar.getVcode_pic_url() == null || wVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateBarActivity.this.eiv = wVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(wVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.BI());
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
            CreateBarActivity.this.eis.setVisibility(8);
            CreateBarActivity.this.eiu = null;
            if (bitmap != null) {
                CreateBarActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateBarActivity.this.eiv = null;
            CreateBarActivity.this.eis.setVisibility(0);
            CreateBarActivity.this.mImage.setImageDrawable(null);
        }
    }
}
