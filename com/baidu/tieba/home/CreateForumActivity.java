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
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    private LinearLayout axG;
    private NoNetworkView div;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a dSn = null;
    private b dSo = null;
    private String dRV = null;
    private EditText dRO = null;
    private EditText dRP = null;
    private ImageView mImage = null;
    private TextView dSp = null;
    private TextView dSq = null;
    private String dRY = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.create_forum_activity);
        initData();
        initUI();
        aCY();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.dRY = getIntent().getStringExtra("barname");
        if (this.dRY == null) {
            this.dRY = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.dSq) {
                    CreateForumActivity.this.aDa();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aCZ();
            }
        };
        this.axG = (LinearLayout) findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.create_bar);
        this.div = (NoNetworkView) this.axG.findViewById(d.g.view_no_network);
        this.dRO = (EditText) findViewById(d.g.edit_forum_name);
        this.dRO.setText(this.dRY);
        this.dRP = (EditText) findViewById(d.g.edit_vcode);
        this.dRP.setFocusable(true);
        this.dSp = (TextView) findViewById(d.g.refresh_vcode);
        this.dSp.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.dSq = (TextView) findViewById(d.g.text_create);
        this.dSq.setOnClickListener(this.mOnClickListener);
        findViewById(d.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.dRO.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dRO);
                    }
                    if (CreateForumActivity.this.dRP.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dRP);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aCY() {
        if (this.dSo == null) {
            this.dSo = new b();
            this.dSo.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCZ() {
        if (this.dSo == null && this.dSn == null) {
            this.dSo = new b();
            this.dSo.setPriority(3);
            this.dSo.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDa() {
        if (this.dSn == null) {
            this.dSn = new a(this.dRO.getText().toString().trim(), this.dRP.getText().toString().trim());
            this.dSn.setPriority(3);
            this.dSn.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dSn != null) {
            this.dSn.cancel();
        }
        if (this.dSo != null) {
            this.dSo.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.axG);
        com.baidu.tbadk.o.a.a(getPageContext(), this.axG);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.div != null && this.div.getVisibility() == 0) {
            this.div.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dRY;
        private y mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            CreateForumActivity.this.dSn = null;
        }

        public a(String str, String str2) {
            this.dRY = null;
            this.mVcode = null;
            this.dRY = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.yO().zM().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.dRY);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateForumActivity.this.dRV);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.yq();
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
            CreateForumActivity.this.dSn = null;
            if (this.mNetwork.yO().zN().isRequestSuccess()) {
                CreateForumSuccessActivity.ag(CreateForumActivity.this.getPageContext().getPageActivity(), this.dRY);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.yR()) {
                CreateForumActivity.this.aCZ();
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
            CreateForumActivity.this.dSo = null;
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
                String yq = this.mNetwork.yq();
                if (this.mNetwork.yO().zN().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(yq);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.dRV = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new y(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.yr());
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
            CreateForumActivity.this.dSo = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.dRV = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
