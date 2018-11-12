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
    private LinearLayout aGg;
    private NoNetworkView dxG;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a eiN = null;
    private b eiO = null;
    private String eiv = null;
    private EditText eio = null;
    private EditText eip = null;
    private ImageView mImage = null;
    private TextView eiP = null;
    private TextView eiQ = null;
    private String eiy = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_forum_activity);
        initData();
        initUI();
        aHY();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.eiy = getIntent().getStringExtra("barname");
        if (this.eiy == null) {
            this.eiy = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.eiQ) {
                    CreateForumActivity.this.aIa();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aHZ();
            }
        };
        this.aGg = (LinearLayout) findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dxG = (NoNetworkView) this.aGg.findViewById(e.g.view_no_network);
        this.eio = (EditText) findViewById(e.g.edit_forum_name);
        this.eio.setText(this.eiy);
        this.eip = (EditText) findViewById(e.g.edit_vcode);
        this.eip.setFocusable(true);
        this.eiP = (TextView) findViewById(e.g.refresh_vcode);
        this.eiP.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(e.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.eiQ = (TextView) findViewById(e.g.text_create);
        this.eiQ.setOnClickListener(this.mOnClickListener);
        findViewById(e.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.eio.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.eio);
                    }
                    if (CreateForumActivity.this.eip.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.eip);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aHY() {
        if (this.eiO == null) {
            this.eiO = new b();
            this.eiO.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHZ() {
        if (this.eiO == null && this.eiN == null) {
            this.eiO = new b();
            this.eiO.setPriority(3);
            this.eiO.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIa() {
        if (this.eiN == null) {
            this.eiN = new a(this.eio.getText().toString().trim(), this.eip.getText().toString().trim());
            this.eiN.setPriority(3);
            this.eiN.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eiN != null) {
            this.eiN.cancel();
        }
        if (this.eiO != null) {
            this.eiO.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.aGg);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aGg);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.dxG != null && this.dxG.getVisibility() == 0) {
            this.dxG.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String eiy;
        private x mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.jg();
            }
            CreateForumActivity.this.eiN = null;
        }

        public a(String str, String str2) {
            this.eiy = null;
            this.mVcode = null;
            this.eiy = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.Cf().Dd().mIsNeedTbs = true;
                this.mNetwork.x("kw", this.eiy);
                this.mNetwork.x("vcode", this.mVcode);
                this.mNetwork.x("vcode_md5", CreateForumActivity.this.eiv);
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.BH();
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
            CreateForumActivity.this.eiN = null;
            if (this.mNetwork.Cf().De().isRequestSuccess()) {
                CreateForumSuccessActivity.av(CreateForumActivity.this.getPageContext().getPageActivity(), this.eiy);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.Ci()) {
                CreateForumActivity.this.aHZ();
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
            CreateForumActivity.this.eiO = null;
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
                String BH = this.mNetwork.BH();
                if (this.mNetwork.Cf().De().isRequestSuccess()) {
                    w wVar = new w();
                    wVar.parserJson(BH);
                    if (wVar.getVcode_pic_url() == null || wVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.eiv = wVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new x(wVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.BI());
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
            CreateForumActivity.this.eiO = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.eiv = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
