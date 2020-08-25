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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private NoNetworkView eUf;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;
    private View.OnClickListener mOnClickListener = null;
    private a iFG = null;
    private b iFH = null;
    private String iFn = null;
    private EditText iFg = null;
    private EditText iFh = null;
    private ImageView fnA = null;
    private TextView mRefreshButton = null;
    private TextView iFI = null;
    private String iFq = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_forum_activity);
        initData();
        initUI();
        cvR();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.iFq = getIntent().getStringExtra("barname");
        if (this.iFq == null) {
            this.iFq = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.iFI) {
                    CreateForumActivity.this.cvT();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.cvS();
            }
        };
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.eUf = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.iFg = (EditText) findViewById(R.id.edit_forum_name);
        this.iFg.setText(this.iFq);
        this.iFh = (EditText) findViewById(R.id.edit_vcode);
        this.iFh.setFocusable(true);
        this.mRefreshButton = (TextView) findViewById(R.id.refresh_vcode);
        this.mRefreshButton.setOnClickListener(this.mOnClickListener);
        this.fnA = (ImageView) findViewById(R.id.image);
        this.fnA.setOnClickListener(this.mOnClickListener);
        this.iFI = (TextView) findViewById(R.id.text_create);
        this.iFI.setOnClickListener(this.mOnClickListener);
        findViewById(R.id.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.iFg.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.iFg);
                    }
                    if (CreateForumActivity.this.iFh.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.iFh);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void cvR() {
        if (this.iFH == null) {
            this.iFH = new b();
            this.iFH.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvS() {
        if (this.iFH == null && this.iFG == null) {
            this.iFH = new b();
            this.iFH.setPriority(3);
            this.iFH.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvT() {
        if (this.iFG == null) {
            this.iFG = new a(this.iFg.getText().toString().trim(), this.iFh.getText().toString().trim());
            this.iFG.setPriority(3);
            this.iFG.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iFG != null) {
            this.iFG.cancel();
        }
        if (this.iFH != null) {
            this.iFH.cancel();
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
        if (this.eUf != null && this.eUf.getVisibility() == 0) {
            this.eUf.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String iFq;
        private aa mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateForumActivity.this.iFG = null;
        }

        public a(String str, String str2) {
            this.iFq = null;
            this.mVcode = null;
            this.iFq = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.biQ().bjv().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.iFq);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateForumActivity.this.iFn);
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
            CreateForumActivity.this.iFG = null;
            if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                CreateForumSuccessActivity.aH(CreateForumActivity.this.getPageContext().getPageActivity(), this.iFq);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateForumActivity.this.cvS();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
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
            CreateForumActivity.this.iFH = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                    ag agVar = new ag();
                    agVar.parserJson(postNetData);
                    if (agVar.getVcode_pic_url() == null || agVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.iFn = agVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new aa(agVar.getVcode_pic_url());
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
            CreateForumActivity.this.iFH = null;
            if (bitmap != null) {
                CreateForumActivity.this.fnA.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.iFn = null;
            CreateForumActivity.this.fnA.setImageDrawable(null);
        }
    }
}
