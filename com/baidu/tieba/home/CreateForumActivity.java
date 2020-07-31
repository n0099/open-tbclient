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
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private NoNetworkView eJz;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;
    private View.OnClickListener mOnClickListener = null;
    private a irp = null;
    private b irq = null;
    private String iqW = null;
    private EditText iqP = null;
    private EditText iqQ = null;
    private ImageView fcg = null;
    private TextView mRefreshButton = null;
    private TextView irr = null;
    private String iqZ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_forum_activity);
        initData();
        initUI();
        cli();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.iqZ = getIntent().getStringExtra("barname");
        if (this.iqZ == null) {
            this.iqZ = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.irr) {
                    CreateForumActivity.this.clk();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.clj();
            }
        };
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.eJz = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.iqP = (EditText) findViewById(R.id.edit_forum_name);
        this.iqP.setText(this.iqZ);
        this.iqQ = (EditText) findViewById(R.id.edit_vcode);
        this.iqQ.setFocusable(true);
        this.mRefreshButton = (TextView) findViewById(R.id.refresh_vcode);
        this.mRefreshButton.setOnClickListener(this.mOnClickListener);
        this.fcg = (ImageView) findViewById(R.id.image);
        this.fcg.setOnClickListener(this.mOnClickListener);
        this.irr = (TextView) findViewById(R.id.text_create);
        this.irr.setOnClickListener(this.mOnClickListener);
        findViewById(R.id.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.iqP.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.iqP);
                    }
                    if (CreateForumActivity.this.iqQ.hasFocus()) {
                        l.hideSoftKeyPad(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.iqQ);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void cli() {
        if (this.irq == null) {
            this.irq = new b();
            this.irq.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clj() {
        if (this.irq == null && this.irp == null) {
            this.irq = new b();
            this.irq.setPriority(3);
            this.irq.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clk() {
        if (this.irp == null) {
            this.irp = new a(this.iqP.getText().toString().trim(), this.iqQ.getText().toString().trim());
            this.irp.setPriority(3);
            this.irp.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.irp != null) {
            this.irp.cancel();
        }
        if (this.irq != null) {
            this.irq.cancel();
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
        if (this.eJz != null && this.eJz.getVisibility() == 0) {
            this.eJz.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String iqZ;
        private z mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            CreateForumActivity.this.irp = null;
        }

        public a(String str, String str2) {
            this.iqZ = null;
            this.mVcode = null;
            this.iqZ = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.CREATE_BAR_ADDRESS);
                this.mNetwork.bav().baW().mIsNeedTbs = true;
                this.mNetwork.addPostData("kw", this.iqZ);
                this.mNetwork.addPostData("vcode", this.mVcode);
                this.mNetwork.addPostData("vcode_md5", CreateForumActivity.this.iqW);
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
            CreateForumActivity.this.irp = null;
            if (this.mNetwork.bav().baX().isRequestSuccess()) {
                CreateForumSuccessActivity.aD(CreateForumActivity.this.getPageContext().getPageActivity(), this.iqZ);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.isNetSuccess()) {
                CreateForumActivity.this.clj();
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
        private z mNetwork;

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
            CreateForumActivity.this.irq = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new z(TbConfig.SERVER_ADDRESS + Config.GET_VCODE_ADDRESS);
                this.mNetwork.addPostData("fid", "0");
                this.mNetwork.addPostData("pub_type", "0");
                this.mNetwork.addPostData("fname", "");
                this.mNetwork.addPostData("tid", "0");
                String postNetData = this.mNetwork.postNetData();
                if (this.mNetwork.bav().baX().isRequestSuccess()) {
                    ad adVar = new ad();
                    adVar.parserJson(postNetData);
                    if (adVar.getVcode_pic_url() == null || adVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.iqW = adVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new z(adVar.getVcode_pic_url());
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
            CreateForumActivity.this.irq = null;
            if (bitmap != null) {
                CreateForumActivity.this.fcg.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.iqW = null;
            CreateForumActivity.this.fcg.setImageDrawable(null);
        }
    }
}
