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
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private LinearLayout aAJ;
    private NoNetworkView dom;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a dZz = null;
    private b dZA = null;
    private String dZh = null;
    private EditText dZa = null;
    private EditText dZb = null;
    private ImageView mImage = null;
    private TextView dZB = null;
    private TextView dZC = null;
    private String dZk = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_forum_activity);
        initData();
        initUI();
        aFi();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.dZk = getIntent().getStringExtra("barname");
        if (this.dZk == null) {
            this.dZk = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.dZC) {
                    CreateForumActivity.this.aFk();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aFj();
            }
        };
        this.aAJ = (LinearLayout) findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dom = (NoNetworkView) this.aAJ.findViewById(e.g.view_no_network);
        this.dZa = (EditText) findViewById(e.g.edit_forum_name);
        this.dZa.setText(this.dZk);
        this.dZb = (EditText) findViewById(e.g.edit_vcode);
        this.dZb.setFocusable(true);
        this.dZB = (TextView) findViewById(e.g.refresh_vcode);
        this.dZB.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.dZC = (TextView) findViewById(e.g.text_create);
        this.dZC.setOnClickListener(this.mOnClickListener);
        findViewById(e.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.dZa.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dZa);
                    }
                    if (CreateForumActivity.this.dZb.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dZb);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aFi() {
        if (this.dZA == null) {
            this.dZA = new b();
            this.dZA.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFj() {
        if (this.dZA == null && this.dZz == null) {
            this.dZA = new b();
            this.dZA.setPriority(3);
            this.dZA.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFk() {
        if (this.dZz == null) {
            this.dZz = new a(this.dZa.getText().toString().trim(), this.dZb.getText().toString().trim());
            this.dZz.setPriority(3);
            this.dZz.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dZz != null) {
            this.dZz.cancel();
        }
        if (this.dZA != null) {
            this.dZA.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.aAJ);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aAJ);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.dom != null && this.dom.getVisibility() == 0) {
            this.dom.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dZk;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.iT();
            }
            CreateForumActivity.this.dZz = null;
        }

        public a(String str, String str2) {
            this.dZk = null;
            this.mVcode = null;
            this.dZk = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.zR().AP().mIsNeedTbs = true;
                this.mNetwork.u("kw", this.dZk);
                this.mNetwork.u("vcode", this.mVcode);
                this.mNetwork.u("vcode_md5", CreateForumActivity.this.dZh);
                this.mNetwork.u("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.zt();
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
            CreateForumActivity.this.dZz = null;
            if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                CreateForumSuccessActivity.av(CreateForumActivity.this.getPageContext().getPageActivity(), this.dZk);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.zU()) {
                CreateForumActivity.this.aFj();
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
                this.mNetwork.iT();
            }
            CreateForumActivity.this.dZA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetwork.u(ImageViewerConfig.FORUM_ID, "0");
                this.mNetwork.u("pub_type", "0");
                this.mNetwork.u(ImageViewerConfig.FORUM_NAME, "");
                this.mNetwork.u("tid", "0");
                String zt = this.mNetwork.zt();
                if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                    v vVar = new v();
                    vVar.parserJson(zt);
                    if (vVar.getVcode_pic_url() == null || vVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.dZh = vVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(vVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.zu());
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
            CreateForumActivity.this.dZA = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.dZh = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
