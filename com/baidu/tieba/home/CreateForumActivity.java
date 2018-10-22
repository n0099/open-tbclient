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
    private LinearLayout aFq;
    private NoNetworkView dwo;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a eht = null;
    private b ehu = null;
    private String ehb = null;
    private EditText egU = null;
    private EditText egV = null;
    private ImageView mImage = null;
    private TextView ehv = null;
    private TextView ehw = null;
    private String ehe = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_forum_activity);
        initData();
        initUI();
        aIA();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.ehe = getIntent().getStringExtra("barname");
        if (this.ehe == null) {
            this.ehe = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.ehw) {
                    CreateForumActivity.this.aIC();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aIB();
            }
        };
        this.aFq = (LinearLayout) findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dwo = (NoNetworkView) this.aFq.findViewById(e.g.view_no_network);
        this.egU = (EditText) findViewById(e.g.edit_forum_name);
        this.egU.setText(this.ehe);
        this.egV = (EditText) findViewById(e.g.edit_vcode);
        this.egV.setFocusable(true);
        this.ehv = (TextView) findViewById(e.g.refresh_vcode);
        this.ehv.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.ehw = (TextView) findViewById(e.g.text_create);
        this.ehw.setOnClickListener(this.mOnClickListener);
        findViewById(e.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.egU.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.egU);
                    }
                    if (CreateForumActivity.this.egV.hasFocus()) {
                        l.a(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.egV);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aIA() {
        if (this.ehu == null) {
            this.ehu = new b();
            this.ehu.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIB() {
        if (this.ehu == null && this.eht == null) {
            this.ehu = new b();
            this.ehu.setPriority(3);
            this.ehu.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIC() {
        if (this.eht == null) {
            this.eht = new a(this.egU.getText().toString().trim(), this.egV.getText().toString().trim());
            this.eht.setPriority(3);
            this.eht.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eht != null) {
            this.eht.cancel();
        }
        if (this.ehu != null) {
            this.ehu.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.aFq);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aFq);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.dwo != null && this.dwo.getVisibility() == 0) {
            this.dwo.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String ehe;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            CreateForumActivity.this.eht = null;
        }

        public a(String str, String str2) {
            this.ehe = null;
            this.mVcode = null;
            this.ehe = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.BY().CW().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.ehe);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateForumActivity.this.ehb);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.BA();
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
            CreateForumActivity.this.eht = null;
            if (this.mNetwork.BY().CX().isRequestSuccess()) {
                CreateForumSuccessActivity.ax(CreateForumActivity.this.getPageContext().getPageActivity(), this.ehe);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.Cb()) {
                CreateForumActivity.this.aIB();
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
                this.mNetwork.ji();
            }
            CreateForumActivity.this.ehu = null;
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
                String BA = this.mNetwork.BA();
                if (this.mNetwork.BY().CX().isRequestSuccess()) {
                    v vVar = new v();
                    vVar.parserJson(BA);
                    if (vVar.getVcode_pic_url() == null || vVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.ehb = vVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(vVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.BB());
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
            CreateForumActivity.this.ehu = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.ehb = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
