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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private NoNetworkView hji;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;
    private View.OnClickListener mOnClickListener = null;
    private a hWR = null;
    private b hWS = null;
    private String hWy = null;
    private EditText hWr = null;
    private EditText hWs = null;
    private ImageView eNu = null;
    private TextView mRefreshButton = null;
    private TextView hWT = null;
    private String hWB = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_forum_activity);
        initData();
        initUI();
        cel();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.hWB = getIntent().getStringExtra("barname");
        if (this.hWB == null) {
            this.hWB = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.hWT) {
                    CreateForumActivity.this.cen();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.cem();
            }
        };
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.hji = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.hWr = (EditText) findViewById(R.id.edit_forum_name);
        this.hWr.setText(this.hWB);
        this.hWs = (EditText) findViewById(R.id.edit_vcode);
        this.hWs.setFocusable(true);
        this.mRefreshButton = (TextView) findViewById(R.id.refresh_vcode);
        this.mRefreshButton.setOnClickListener(this.mOnClickListener);
        this.eNu = (ImageView) findViewById(R.id.image);
        this.eNu.setOnClickListener(this.mOnClickListener);
        this.hWT = (TextView) findViewById(R.id.text_create);
        this.hWT.setOnClickListener(this.mOnClickListener);
        findViewById(R.id.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.hWr.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.hWr);
                    }
                    if (CreateForumActivity.this.hWs.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.hWs);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void cel() {
        if (this.hWS == null) {
            this.hWS = new b();
            this.hWS.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cem() {
        if (this.hWS == null && this.hWR == null) {
            this.hWS = new b();
            this.hWS.setPriority(3);
            this.hWS.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cen() {
        if (this.hWR == null) {
            this.hWR = new a(this.hWr.getText().toString().trim(), this.hWs.getText().toString().trim());
            this.hWR.setPriority(3);
            this.hWR.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hWR != null) {
            this.hWR.cancel();
        }
        if (this.hWS != null) {
            this.hWS.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.mRootView);
        com.baidu.tbadk.q.a.a(getPageContext(), this.mRootView);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.hji != null && this.hji.getVisibility() == 0) {
            this.hji.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String hWB;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateForumActivity.this.hWR = null;
        }

        public a(String str, String str2) {
            this.hWB = null;
            this.mVcode = null;
            this.hWB = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aUA().aVb().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.hWB);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateForumActivity.this.hWy);
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
            CreateForumActivity.this.hWR = null;
            if (this.mNetwork.aUA().aVc().isRequestSuccess()) {
                CreateForumSuccessActivity.aE(CreateForumActivity.this.getPageContext().getPageActivity(), this.hWB);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateForumActivity.this.cem();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
                this.mNetwork.cancelNetConnect();
            }
            CreateForumActivity.this.hWS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aUA().aVc().isRequestSuccess()) {
                    ab abVar = new ab();
                    abVar.parserJson(postNetData);
                    if (abVar.getVcode_pic_url() == null || abVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.hWy = abVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(abVar.getVcode_pic_url());
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
            CreateForumActivity.this.hWS = null;
            if (bitmap != null) {
                CreateForumActivity.this.eNu.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.hWy = null;
            CreateForumActivity.this.eNu.setImageDrawable(null);
        }
    }
}
