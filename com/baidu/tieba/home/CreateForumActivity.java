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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private LinearLayout aKk;
    private NoNetworkView dHC;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a etf = null;
    private b etg = null;
    private String esM = null;
    private EditText esF = null;
    private EditText esG = null;
    private ImageView mImage = null;
    private TextView eth = null;
    private TextView eti = null;
    private String esP = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_forum_activity);
        initData();
        initUI();
        aLc();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.esP = getIntent().getStringExtra("barname");
        if (this.esP == null) {
            this.esP = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.eti) {
                    CreateForumActivity.this.aLe();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aLd();
            }
        };
        this.aKk = (LinearLayout) findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dHC = (NoNetworkView) this.aKk.findViewById(e.g.view_no_network);
        this.esF = (EditText) findViewById(e.g.edit_forum_name);
        this.esF.setText(this.esP);
        this.esG = (EditText) findViewById(e.g.edit_vcode);
        this.esG.setFocusable(true);
        this.eth = (TextView) findViewById(e.g.refresh_vcode);
        this.eth.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.eti = (TextView) findViewById(e.g.text_create);
        this.eti.setOnClickListener(this.mOnClickListener);
        findViewById(e.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.esF.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.esF);
                    }
                    if (CreateForumActivity.this.esG.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.esG);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aLc() {
        if (this.etg == null) {
            this.etg = new b();
            this.etg.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLd() {
        if (this.etg == null && this.etf == null) {
            this.etg = new b();
            this.etg.setPriority(3);
            this.etg.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLe() {
        if (this.etf == null) {
            this.etf = new a(this.esF.getText().toString().trim(), this.esG.getText().toString().trim());
            this.etf.setPriority(3);
            this.etf.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.etf != null) {
            this.etf.cancel();
        }
        if (this.etg != null) {
            this.etg.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.aKk);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aKk);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.dHC != null && this.dHC.getVisibility() == 0) {
            this.dHC.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String esP;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            CreateForumActivity.this.etf = null;
        }

        public a(String str, String str2) {
            this.esP = null;
            this.mVcode = null;
            this.esP = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.Dw().Eu().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.esP);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateForumActivity.this.esM);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.CY();
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
            CreateForumActivity.this.etf = null;
            if (this.mNetwork.Dw().Ev().isRequestSuccess()) {
                CreateForumSuccessActivity.aw(CreateForumActivity.this.getPageContext().getPageActivity(), this.esP);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.Dz()) {
                CreateForumActivity.this.aLd();
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
            CreateForumActivity.this.etg = null;
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
                String CY = this.mNetwork.CY();
                if (this.mNetwork.Dw().Ev().isRequestSuccess()) {
                    com.baidu.tbadk.coreExtra.data.x xVar = new com.baidu.tbadk.coreExtra.data.x();
                    xVar.parserJson(CY);
                    if (xVar.getVcode_pic_url() == null || xVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.esM = xVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(xVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.CZ());
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
            CreateForumActivity.this.etg = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.esM = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
