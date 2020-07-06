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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private NoNetworkView eDk;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;
    private View.OnClickListener mOnClickListener = null;
    private a ilm = null;
    private b iln = null;
    private String ikT = null;
    private EditText ikM = null;
    private EditText ikN = null;
    private ImageView eXF = null;
    private TextView mRefreshButton = null;
    private TextView ilo = null;
    private String ikW = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_forum_activity);
        initData();
        initUI();
        chJ();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.ikW = getIntent().getStringExtra("barname");
        if (this.ikW == null) {
            this.ikW = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.ilo) {
                    CreateForumActivity.this.chL();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.chK();
            }
        };
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.eDk = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.ikM = (EditText) findViewById(R.id.edit_forum_name);
        this.ikM.setText(this.ikW);
        this.ikN = (EditText) findViewById(R.id.edit_vcode);
        this.ikN.setFocusable(true);
        this.mRefreshButton = (TextView) findViewById(R.id.refresh_vcode);
        this.mRefreshButton.setOnClickListener(this.mOnClickListener);
        this.eXF = (ImageView) findViewById(R.id.image);
        this.eXF.setOnClickListener(this.mOnClickListener);
        this.ilo = (TextView) findViewById(R.id.text_create);
        this.ilo.setOnClickListener(this.mOnClickListener);
        findViewById(R.id.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.ikM.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.ikM);
                    }
                    if (CreateForumActivity.this.ikN.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.ikN);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void chJ() {
        if (this.iln == null) {
            this.iln = new b();
            this.iln.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chK() {
        if (this.iln == null && this.ilm == null) {
            this.iln = new b();
            this.iln.setPriority(3);
            this.iln.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chL() {
        if (this.ilm == null) {
            this.ilm = new a(this.ikM.getText().toString().trim(), this.ikN.getText().toString().trim());
            this.ilm.setPriority(3);
            this.ilm.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ilm != null) {
            this.ilm.cancel();
        }
        if (this.iln != null) {
            this.iln.cancel();
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
        if (this.eDk != null && this.eDk.getVisibility() == 0) {
            this.eDk.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String ikW;
        private y mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateForumActivity.this.ilm = null;
        }

        public a(String str, String str2) {
            this.ikW = null;
            this.mVcode = null;
            this.ikW = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.aWu().aWV().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.ikW);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateForumActivity.this.ikT);
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
            CreateForumActivity.this.ilm = null;
            if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
                CreateForumSuccessActivity.aE(CreateForumActivity.this.getPageContext().getPageActivity(), this.ikW);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateForumActivity.this.chK();
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
                this.mNetwork.cancelNetConnect();
            }
            CreateForumActivity.this.iln = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.aWu().aWW().isRequestSuccess()) {
                    ad adVar = new ad();
                    adVar.parserJson(postNetData);
                    if (adVar.getVcode_pic_url() == null || adVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.ikT = adVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new y(adVar.getVcode_pic_url());
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
            CreateForumActivity.this.iln = null;
            if (bitmap != null) {
                CreateForumActivity.this.eXF.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.ikT = null;
            CreateForumActivity.this.eXF.setImageDrawable(null);
        }
    }
}
