package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private NoNetworkView fEG;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;
    private View.OnClickListener mOnClickListener = null;
    private a jIA = null;
    private b jIB = null;
    private String jIh = null;
    private EditText jIa = null;
    private EditText jIb = null;
    private ImageView fZa = null;
    private TextView mRefreshButton = null;
    private TextView jIC = null;
    private String jIk = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_forum_activity);
        initData();
        initUI();
        cNk();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.jIk = getIntent().getStringExtra("barname");
        if (this.jIk == null) {
            this.jIk = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.jIC) {
                    CreateForumActivity.this.cNm();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.cNl();
            }
        };
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.fEG = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.jIa = (EditText) findViewById(R.id.edit_forum_name);
        this.jIa.setText(this.jIk);
        this.jIb = (EditText) findViewById(R.id.edit_vcode);
        this.jIb.setFocusable(true);
        this.mRefreshButton = (TextView) findViewById(R.id.refresh_vcode);
        this.mRefreshButton.setOnClickListener(this.mOnClickListener);
        this.fZa = (ImageView) findViewById(R.id.image);
        this.fZa.setOnClickListener(this.mOnClickListener);
        this.jIC = (TextView) findViewById(R.id.text_create);
        this.jIC.setOnClickListener(this.mOnClickListener);
        findViewById(R.id.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.jIa.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.jIa);
                    }
                    if (CreateForumActivity.this.jIb.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.jIb);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void cNk() {
        if (this.jIB == null) {
            this.jIB = new b();
            this.jIB.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNl() {
        if (this.jIB == null && this.jIA == null) {
            this.jIB = new b();
            this.jIB.setPriority(3);
            this.jIB.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNm() {
        if (this.jIA == null) {
            this.jIA = new a(this.jIa.getText().toString().trim(), this.jIb.getText().toString().trim());
            this.jIA.setPriority(3);
            this.jIA.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jIA != null) {
            this.jIA.cancel();
        }
        if (this.jIB != null) {
            this.jIB.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.mRootView);
        com.baidu.tbadk.r.a.a(getPageContext(), this.mRootView);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.fEG != null && this.fEG.getVisibility() == 0) {
            this.fEG.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String jIk;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateForumActivity.this.jIA = null;
        }

        public a(String str, String str2) {
            this.jIk = null;
            this.mVcode = null;
            this.jIk = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.btv().bue().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.jIk);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateForumActivity.this.jIh);
                this.mNetwork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.postNetData();
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
            CreateForumActivity.this.jIA = null;
            if (this.mNetwork.btv().buf().isRequestSuccess()) {
                CreateForumSuccessActivity.aP(CreateForumActivity.this.getPageContext().getPageActivity(), this.jIk);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateForumActivity.this.cNl();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        private aa mNetwork;

        private b() {
            this.mNetwork = null;
            this.mCanceled = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.mCanceled = true;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateForumActivity.this.jIB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.btv().buf().isRequestSuccess()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(postNetData);
                    if (ahVar.getVcode_pic_url() == null || ahVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.jIh = ahVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new aa(ahVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.getNetData());
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
            CreateForumActivity.this.jIB = null;
            if (bitmap != null) {
                CreateForumActivity.this.fZa.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.jIh = null;
            CreateForumActivity.this.fZa.setImageDrawable(null);
        }
    }
}
