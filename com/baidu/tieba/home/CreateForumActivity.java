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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private LinearLayout axD;
    private NoNetworkView dit;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a dSi = null;
    private b dSj = null;
    private String dRQ = null;
    private EditText dRJ = null;
    private EditText dRK = null;
    private ImageView mImage = null;
    private TextView dSk = null;
    private TextView dSl = null;
    private String dRT = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.create_forum_activity);
        initData();
        initUI();
        aCV();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.dRT = getIntent().getStringExtra("barname");
        if (this.dRT == null) {
            this.dRT = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.dSl) {
                    CreateForumActivity.this.aCX();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aCW();
            }
        };
        this.axD = (LinearLayout) findViewById(f.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(f.j.create_bar);
        this.dit = (NoNetworkView) this.axD.findViewById(f.g.view_no_network);
        this.dRJ = (EditText) findViewById(f.g.edit_forum_name);
        this.dRJ.setText(this.dRT);
        this.dRK = (EditText) findViewById(f.g.edit_vcode);
        this.dRK.setFocusable(true);
        this.dSk = (TextView) findViewById(f.g.refresh_vcode);
        this.dSk.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(f.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.dSl = (TextView) findViewById(f.g.text_create);
        this.dSl.setOnClickListener(this.mOnClickListener);
        findViewById(f.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.dRJ.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dRJ);
                    }
                    if (CreateForumActivity.this.dRK.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dRK);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aCV() {
        if (this.dSj == null) {
            this.dSj = new b();
            this.dSj.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCW() {
        if (this.dSj == null && this.dSi == null) {
            this.dSj = new b();
            this.dSj.setPriority(3);
            this.dSj.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCX() {
        if (this.dSi == null) {
            this.dSi = new a(this.dRJ.getText().toString().trim(), this.dRK.getText().toString().trim());
            this.dSi.setPriority(3);
            this.dSi.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dSi != null) {
            this.dSi.cancel();
        }
        if (this.dSj != null) {
            this.dSj.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.axD);
        com.baidu.tbadk.o.a.a(getPageContext(), this.axD);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.dit != null && this.dit.getVisibility() == 0) {
            this.dit.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dRT;
        private y mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            CreateForumActivity.this.dSi = null;
        }

        public a(String str, String str2) {
            this.dRT = null;
            this.mVcode = null;
            this.dRT = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.yM().zK().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.dRT);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateForumActivity.this.dRQ);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.yo();
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
            CreateForumActivity.this.dSi = null;
            if (this.mNetwork.yM().zL().isRequestSuccess()) {
                CreateForumSuccessActivity.ag(CreateForumActivity.this.getPageContext().getPageActivity(), this.dRT);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.yP()) {
                CreateForumActivity.this.aCW();
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
                this.mNetwork.hN();
            }
            CreateForumActivity.this.dSj = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.mNetwork.o(ImageViewerConfig.FORUM_ID, "0");
                this.mNetwork.o("pub_type", "0");
                this.mNetwork.o(ImageViewerConfig.FORUM_NAME, "");
                this.mNetwork.o("tid", "0");
                String yo = this.mNetwork.yo();
                if (this.mNetwork.yM().zL().isRequestSuccess()) {
                    u uVar = new u();
                    uVar.parserJson(yo);
                    if (uVar.getVcode_pic_url() == null || uVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.dRQ = uVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new y(uVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.yp());
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
            CreateForumActivity.this.dSj = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.dRQ = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
