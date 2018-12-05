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
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private LinearLayout aJG;
    private NoNetworkView dEf;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a epH = null;
    private b epI = null;
    private String epp = null;
    private EditText epi = null;
    private EditText epj = null;
    private ImageView mImage = null;
    private TextView epJ = null;
    private TextView epK = null;
    private String eps = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_forum_activity);
        initData();
        initUI();
        aJP();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.eps = getIntent().getStringExtra("barname");
        if (this.eps == null) {
            this.eps = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.epK) {
                    CreateForumActivity.this.aJR();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aJQ();
            }
        };
        this.aJG = (LinearLayout) findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dEf = (NoNetworkView) this.aJG.findViewById(e.g.view_no_network);
        this.epi = (EditText) findViewById(e.g.edit_forum_name);
        this.epi.setText(this.eps);
        this.epj = (EditText) findViewById(e.g.edit_vcode);
        this.epj.setFocusable(true);
        this.epJ = (TextView) findViewById(e.g.refresh_vcode);
        this.epJ.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.epK = (TextView) findViewById(e.g.text_create);
        this.epK.setOnClickListener(this.mOnClickListener);
        findViewById(e.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.epi.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.epi);
                    }
                    if (CreateForumActivity.this.epj.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.epj);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aJP() {
        if (this.epI == null) {
            this.epI = new b();
            this.epI.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJQ() {
        if (this.epI == null && this.epH == null) {
            this.epI = new b();
            this.epI.setPriority(3);
            this.epI.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJR() {
        if (this.epH == null) {
            this.epH = new a(this.epi.getText().toString().trim(), this.epj.getText().toString().trim());
            this.epH.setPriority(3);
            this.epH.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.epH != null) {
            this.epH.cancel();
        }
        if (this.epI != null) {
            this.epI.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.aJG);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aJG);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.dEf != null && this.dEf.getVisibility() == 0) {
            this.dEf.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String eps;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            CreateForumActivity.this.epH = null;
        }

        public a(String str, String str2) {
            this.eps = null;
            this.mVcode = null;
            this.eps = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.Dj().Eh().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.eps);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateForumActivity.this.epp);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.CL();
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
            CreateForumActivity.this.epH = null;
            if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                CreateForumSuccessActivity.ay(CreateForumActivity.this.getPageContext().getPageActivity(), this.eps);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.Dm()) {
                CreateForumActivity.this.aJQ();
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
                this.mNetwork.jg();
            }
            CreateForumActivity.this.epI = null;
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
                String CL = this.mNetwork.CL();
                if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                    w wVar = new w();
                    wVar.parserJson(CL);
                    if (wVar.getVcode_pic_url() == null || wVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.epp = wVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(wVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.CM());
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
            CreateForumActivity.this.epI = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.epp = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
