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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private LinearLayout bOF;
    private NoNetworkView frZ;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a gdU = null;
    private b gdV = null;
    private String gdC = null;
    private EditText gdv = null;
    private EditText gdw = null;
    private ImageView mImage = null;
    private TextView gdW = null;
    private TextView gdX = null;
    private String gdF = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_forum_activity);
        initData();
        initUI();
        bvH();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.gdF = getIntent().getStringExtra("barname");
        if (this.gdF == null) {
            this.gdF = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.gdX) {
                    CreateForumActivity.this.bvJ();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.bvI();
            }
        };
        this.bOF = (LinearLayout) findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.frZ = (NoNetworkView) this.bOF.findViewById(R.id.view_no_network);
        this.gdv = (EditText) findViewById(R.id.edit_forum_name);
        this.gdv.setText(this.gdF);
        this.gdw = (EditText) findViewById(R.id.edit_vcode);
        this.gdw.setFocusable(true);
        this.gdW = (TextView) findViewById(R.id.refresh_vcode);
        this.gdW.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.gdX = (TextView) findViewById(R.id.text_create);
        this.gdX.setOnClickListener(this.mOnClickListener);
        findViewById(R.id.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.gdv.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.gdv);
                    }
                    if (CreateForumActivity.this.gdw.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.gdw);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void bvH() {
        if (this.gdV == null) {
            this.gdV = new b();
            this.gdV.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvI() {
        if (this.gdV == null && this.gdU == null) {
            this.gdV = new b();
            this.gdV.setPriority(3);
            this.gdV.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvJ() {
        if (this.gdU == null) {
            this.gdU = new a(this.gdv.getText().toString().trim(), this.gdw.getText().toString().trim());
            this.gdU.setPriority(3);
            this.gdU.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gdU != null) {
            this.gdU.cancel();
        }
        if (this.gdV != null) {
            this.gdV.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.bOF);
        com.baidu.tbadk.s.a.a(getPageContext(), this.bOF);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.frZ != null && this.frZ.getVisibility() == 0) {
            this.frZ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
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
            CreateForumActivity.this.gdU = null;
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
                this.mNetwork.o("vcode_md5", CreateForumActivity.this.gdC);
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
            CreateForumActivity.this.gdU = null;
            if (this.mNetwork.aiK().ajN().isRequestSuccess()) {
                CreateForumSuccessActivity.aF(CreateForumActivity.this.getPageContext().getPageActivity(), this.gdF);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.aiN()) {
                CreateForumActivity.this.bvI();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
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
            CreateForumActivity.this.gdV = null;
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
                    CreateForumActivity.this.gdC = yVar.getVcode_md5();
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
            CreateForumActivity.this.gdV = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.gdC = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
