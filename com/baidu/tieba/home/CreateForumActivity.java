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
    private LinearLayout bCu;
    private NoNetworkView dAO;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a efq = null;
    private b efr = null;
    private String eeX = null;
    private EditText eeQ = null;
    private EditText eeR = null;
    private ImageView mImage = null;
    private TextView efs = null;
    private TextView eft = null;
    private String efa = null;

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
        this.efa = getIntent().getStringExtra("barname");
        if (this.efa == null) {
            this.efa = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.eft) {
                    CreateForumActivity.this.aBY();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aBX();
            }
        };
        this.bCu = (LinearLayout) findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.create_bar);
        this.dAO = (NoNetworkView) this.bCu.findViewById(d.g.view_no_network);
        this.eeQ = (EditText) findViewById(d.g.edit_forum_name);
        this.eeQ.setText(this.efa);
        this.eeR = (EditText) findViewById(d.g.edit_vcode);
        this.eeR.setFocusable(true);
        this.efs = (TextView) findViewById(d.g.refresh_vcode);
        this.efs.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.eft = (TextView) findViewById(d.g.text_create);
        this.eft.setOnClickListener(this.mOnClickListener);
        findViewById(d.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.eeQ.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.eeQ);
                    }
                    if (CreateForumActivity.this.eeR.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.eeR);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aBW() {
        if (this.efr == null) {
            this.efr = new b();
            this.efr.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBX() {
        if (this.efr == null && this.efq == null) {
            this.efr = new b();
            this.efr.setPriority(3);
            this.efr.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBY() {
        if (this.efq == null) {
            this.efq = new a(this.eeQ.getText().toString().trim(), this.eeR.getText().toString().trim());
            this.efq.setPriority(3);
            this.efq.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.efq != null) {
            this.efq.cancel();
        }
        if (this.efr != null) {
            this.efr.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().aM(this.bCu);
        com.baidu.tbadk.n.a.a(getPageContext(), this.bCu);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.dAO != null && this.dAO.getVisibility() == 0) {
            this.dAO.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String efa;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            CreateForumActivity.this.efq = null;
        }

        public a(String str, String str2) {
            this.efa = null;
            this.mVcode = null;
            this.efa = str;
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
                this.mNetwork.n("kw", this.efa);
                this.mNetwork.n("vcode", this.mVcode);
                this.mNetwork.n("vcode_md5", CreateForumActivity.this.eeX);
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
            CreateForumActivity.this.efq = null;
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                CreateForumSuccessActivity.ah(CreateForumActivity.this.getPageContext().getPageActivity(), this.efa);
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
            CreateForumActivity.this.efr = null;
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
                    CreateForumActivity.this.eeX = tVar.getVcode_md5();
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
            CreateForumActivity.this.efr = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.eeX = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
