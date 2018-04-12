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
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private LinearLayout aMU;
    private NoNetworkView cTA;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a dzW = null;
    private b dzX = null;
    private String dzD = null;
    private EditText dzw = null;
    private EditText dzx = null;
    private ImageView mImage = null;
    private TextView dzY = null;
    private TextView dzZ = null;
    private String dzG = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.create_forum_activity);
        initData();
        initUI();
        awS();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.dzG = getIntent().getStringExtra("barname");
        if (this.dzG == null) {
            this.dzG = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == CreateForumActivity.this.dzZ) {
                    CreateForumActivity.this.awU();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.awT();
            }
        };
        this.aMU = (LinearLayout) findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.create_bar);
        this.cTA = (NoNetworkView) this.aMU.findViewById(d.g.view_no_network);
        this.dzw = (EditText) findViewById(d.g.edit_forum_name);
        this.dzw.setText(this.dzG);
        this.dzx = (EditText) findViewById(d.g.edit_vcode);
        this.dzx.setFocusable(true);
        this.dzY = (TextView) findViewById(d.g.refresh_vcode);
        this.dzY.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.dzZ = (TextView) findViewById(d.g.text_create);
        this.dzZ.setOnClickListener(this.mOnClickListener);
        findViewById(d.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.dzw.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dzw);
                    }
                    if (CreateForumActivity.this.dzx.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dzx);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void awS() {
        if (this.dzX == null) {
            this.dzX = new b();
            this.dzX.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awT() {
        if (this.dzX == null && this.dzW == null) {
            this.dzX = new b();
            this.dzX.setPriority(3);
            this.dzX.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awU() {
        if (this.dzW == null) {
            this.dzW = new a(this.dzw.getText().toString().trim(), this.dzx.getText().toString().trim());
            this.dzW.setPriority(3);
            this.dzW.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dzW != null) {
            this.dzW.cancel();
        }
        if (this.dzX != null) {
            this.dzX.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().u(this.aMU);
        com.baidu.tbadk.n.a.a(getPageContext(), this.aMU);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.cTA != null && this.cTA.getVisibility() == 0) {
            this.cTA.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dzG;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.eW();
            }
            CreateForumActivity.this.dzW = null;
        }

        public a(String str, String str2) {
            this.dzG = null;
            this.mVcode = null;
            this.dzG = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.vj().wi().mIsNeedTbs = true;
                this.mNetwork.n("kw", this.dzG);
                this.mNetwork.n("vcode", this.mVcode);
                this.mNetwork.n("vcode_md5", CreateForumActivity.this.dzD);
                this.mNetwork.uL();
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
            CreateForumActivity.this.dzW = null;
            if (this.mNetwork.vj().wj().isRequestSuccess()) {
                CreateForumSuccessActivity.ac(CreateForumActivity.this.getPageContext().getPageActivity(), this.dzG);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.vm()) {
                CreateForumActivity.this.awT();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
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
                this.mNetwork.eW();
            }
            CreateForumActivity.this.dzX = null;
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
                String uL = this.mNetwork.uL();
                if (this.mNetwork.vj().wj().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(uL);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.dzD = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.uM());
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
            CreateForumActivity.this.dzX = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.dzD = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
