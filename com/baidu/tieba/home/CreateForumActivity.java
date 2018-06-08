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
    private LinearLayout aUT;
    private NoNetworkView ddN;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = null;
    private a dMk = null;
    private b dMl = null;
    private String dLR = null;
    private EditText dLK = null;
    private EditText dLL = null;
    private ImageView mImage = null;
    private TextView dMm = null;
    private TextView dMn = null;
    private String dLU = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.create_forum_activity);
        initData();
        initUI();
        aBJ();
        TiebaStatic.log("c11223");
    }

    private void initData() {
        this.dLU = getIntent().getStringExtra("barname");
        if (this.dLU == null) {
            this.dLU = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == CreateForumActivity.this.dMn) {
                    CreateForumActivity.this.aBL();
                    TiebaStatic.log("c11223");
                    return;
                }
                CreateForumActivity.this.aBK();
            }
        };
        this.aUT = (LinearLayout) findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.create_bar);
        this.ddN = (NoNetworkView) this.aUT.findViewById(d.g.view_no_network);
        this.dLK = (EditText) findViewById(d.g.edit_forum_name);
        this.dLK.setText(this.dLU);
        this.dLL = (EditText) findViewById(d.g.edit_vcode);
        this.dLL.setFocusable(true);
        this.dMm = (TextView) findViewById(d.g.refresh_vcode);
        this.dMm.setOnClickListener(this.mOnClickListener);
        this.mImage = (ImageView) findViewById(d.g.image);
        this.mImage.setOnClickListener(this.mOnClickListener);
        this.dMn = (TextView) findViewById(d.g.text_create);
        this.dMn.setOnClickListener(this.mOnClickListener);
        findViewById(d.g.body_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.CreateForumActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (CreateForumActivity.this.dLK.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dLK);
                    }
                    if (CreateForumActivity.this.dLL.hasFocus()) {
                        l.b(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.dLL);
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void aBJ() {
        if (this.dMl == null) {
            this.dMl = new b();
            this.dMl.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBK() {
        if (this.dMl == null && this.dMk == null) {
            this.dMl = new b();
            this.dMl.setPriority(3);
            this.dMl.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBL() {
        if (this.dMk == null) {
            this.dMk = new a(this.dLK.getText().toString().trim(), this.dLL.getText().toString().trim());
            this.dMk.setPriority(3);
            this.dMk.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dMk != null) {
            this.dMk.cancel();
        }
        if (this.dMl != null) {
            this.dMl.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.aUT);
        com.baidu.tbadk.n.a.a(getPageContext(), this.aUT);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        if (this.ddN != null && this.ddN.getVisibility() == 0) {
            this.ddN.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        private String dLU;
        private y mNetwork = null;
        private String mVcode;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.mNetwork != null) {
                this.mNetwork.hN();
            }
            CreateForumActivity.this.dMk = null;
        }

        public a(String str, String str2) {
            this.dLU = null;
            this.mVcode = null;
            this.dLU = str;
            this.mVcode = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.mNetwork.yJ().zI().mIsNeedTbs = true;
                this.mNetwork.o("kw", this.dLU);
                this.mNetwork.o("vcode", this.mVcode);
                this.mNetwork.o("vcode_md5", CreateForumActivity.this.dLR);
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.mNetwork.yl();
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
            CreateForumActivity.this.dMk = null;
            if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                CreateForumSuccessActivity.ae(CreateForumActivity.this.getPageContext().getPageActivity(), this.dLU);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.mNetwork.getErrorString());
            if (this.mNetwork.yM()) {
                CreateForumActivity.this.aBK();
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
            CreateForumActivity.this.dMl = null;
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
                String yl = this.mNetwork.yl();
                if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
                    t tVar = new t();
                    tVar.parserJson(yl);
                    if (tVar.getVcode_pic_url() == null || tVar.getVcode_pic_url().length() <= 0) {
                        return null;
                    }
                    CreateForumActivity.this.dLR = tVar.getVcode_md5();
                    if (this.mCanceled) {
                        return null;
                    }
                    this.mNetwork = new y(tVar.getVcode_pic_url());
                    return BitmapHelper.Bytes2Bitmap(this.mNetwork.ym());
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
            CreateForumActivity.this.dMl = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.dLR = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }
    }
}
