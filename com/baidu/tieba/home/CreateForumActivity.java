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
    private LinearLayout bCE;
    private NoNetworkView dAX;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a efm = null;
    private b efn = null;
    private String eeT = null;
    private EditText eeM = null;
    private EditText eeN = null;
    private ImageView mImage = null;
    private TextView efo = null;
    private TextView efp = null;
    private String eeW = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.create_forum_activity);
        initData();
        initUI();
        aBW();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.eeW = getIntent().getStringExtra("barname");
        if (this.eeW == null) {
            this.eeW = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.efp) {
                    CreateForumActivity.this.aBY();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aBX();
            }
        };
        this.bCE = (LinearLayout) findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.create_bar);
        this.dAX = (NoNetworkView) this.bCE.findViewById(d.g.view_no_network);
        this.eeM = (EditText) findViewById(d.g.edit_forum_name);
        this.eeM.setText(this.eeW);
        this.eeN = (EditText) findViewById(d.g.edit_vcode);
        this.eeN.setFocusable(true);
        this.efo = (TextView) findViewById(d.g.refresh_vcode);
        this.efo.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.efp = (TextView) findViewById(d.g.text_create);
        this.efp.setOnClickListener(this.mOnClickListener);
        findViewById(d.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.eeM.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.eeM);
                    }
                    if (CreateForumActivity.this.eeN.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.eeN);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aBW() {
        if (this.efn == null) {
            this.efn = new b();
            this.efn.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBX() {
        if (this.efn == null && this.efm == null) {
            this.efn = new b();
            this.efn.setPriority(3);
            this.efn.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBY() {
        if (this.efm == null) {
            this.efm = new a(this.eeM.getText().toString().trim(), this.eeN.getText().toString().trim());
            this.efm.setPriority(3);
            this.efm.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.efm != null) {
            this.efm.cancel();
        }
        if (this.efn != null) {
            this.efn.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().aM(this.bCE);
        com.baidu.tbadk.n.a.a(getPageContext(), this.bCE);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.dAX != null && this.dAX.getVisibility() == 0) {
            this.dAX.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String eeW;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            CreateForumActivity.this.efm = null;
        }

        public a(String str, String str2) {
            this.eeW = null;
            this.mVcode = null;
            this.eeW = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.Cz().Dw().mIsNeedTbs = true;
                this.mNetwork.n("kw", this.eeW);
                this.mNetwork.n("vcode", this.mVcode);
                this.mNetwork.n("vcode_md5", CreateForumActivity.this.eeT);
                this.mNetwork.Cb();
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
            CreateForumActivity.this.efm = null;
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                CreateForumSuccessActivity.ah(CreateForumActivity.this.getPageContext().getPageActivity(), this.eeW);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.CC()) {
                CreateForumActivity.this.aBX();
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
                this.mNetwork.mS();
            }
            CreateForumActivity.this.efn = null;
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
                String Cb = this.mNetwork.Cb();
                if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(Cb);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.eeT = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.Cc());
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
            CreateForumActivity.this.efn = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.eeT = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
