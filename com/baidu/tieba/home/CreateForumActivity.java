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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.s.c.i0;
/* loaded from: classes4.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetView;
    public LinearLayout mRootView;
    public View.OnClickListener mOnClickListener = null;
    public c mCreateTask = null;
    public d mGetImageTask = null;
    public String mVcode_md5 = null;
    public EditText mEditName = null;
    public EditText mEditVcode = null;
    public ImageView mImage = null;
    public TextView mRefreshButton = null;
    public TextView mCreate = null;
    public String mBarName = null;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == CreateForumActivity.this.mCreate) {
                CreateForumActivity.this.startCreateTask();
                TiebaStatic.log("c11223");
                return;
            }
            CreateForumActivity.this.startImageTask();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                if (CreateForumActivity.this.mEditName.hasFocus()) {
                    l.x(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.mEditName);
                }
                if (CreateForumActivity.this.mEditVcode.hasFocus()) {
                    l.x(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.mEditVcode);
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f16112a;

        /* renamed from: b  reason: collision with root package name */
        public String f16113b;

        /* renamed from: c  reason: collision with root package name */
        public NetWork f16114c = null;

        public c(String str, String str2) {
            this.f16112a = null;
            this.f16113b = null;
            this.f16112a = str;
            this.f16113b = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f16114c;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            CreateForumActivity.this.mCreateTask = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                this.f16114c = netWork;
                netWork.getNetContext().getRequest().mIsNeedTbs = true;
                this.f16114c.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f16112a);
                this.f16114c.addPostData("vcode", this.f16113b);
                this.f16114c.addPostData("vcode_md5", CreateForumActivity.this.mVcode_md5);
                this.f16114c.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.f16114c.postNetData();
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            CreateForumActivity.this.mCreateTask = null;
            if (this.f16114c.getNetContext().getResponse().isRequestSuccess()) {
                CreateForumSuccessActivity.startActivity(CreateForumActivity.this.getPageContext().getPageActivity(), this.f16112a);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.f16114c.getErrorString());
            if (this.f16114c.isNetSuccess()) {
                CreateForumActivity.this.startImageTask();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<String, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f16116a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f16117b;

        public d() {
            this.f16116a = null;
            this.f16117b = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.f16116a = netWork;
                netWork.addPostData("fid", "0");
                this.f16116a.addPostData("pub_type", "0");
                this.f16116a.addPostData("fname", "");
                this.f16116a.addPostData("tid", "0");
                String postNetData = this.f16116a.postNetData();
                if (this.f16116a.getNetContext().getResponse().isRequestSuccess()) {
                    i0 i0Var = new i0();
                    i0Var.e(postNetData);
                    if (i0Var.c() != null && i0Var.c().length() > 0) {
                        CreateForumActivity.this.mVcode_md5 = i0Var.b();
                        if (this.f16117b) {
                            return null;
                        }
                        NetWork netWork2 = new NetWork(i0Var.c());
                        this.f16116a = netWork2;
                        return BitmapHelper.Bytes2Bitmap(netWork2.getNetData());
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.f16117b = true;
            NetWork netWork = this.f16116a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            CreateForumActivity.this.mGetImageTask = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            CreateForumActivity.this.mVcode_md5 = null;
            CreateForumActivity.this.mImage.setImageDrawable(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((d) bitmap);
            CreateForumActivity.this.mGetImageTask = null;
            if (bitmap != null) {
                CreateForumActivity.this.mImage.setImageBitmap(bitmap);
            }
        }

        public /* synthetic */ d(CreateForumActivity createForumActivity, a aVar) {
            this();
        }
    }

    private void getImage() {
        if (this.mGetImageTask == null) {
            d dVar = new d(this, null);
            this.mGetImageTask = dVar;
            dVar.execute(new String[0]);
        }
    }

    private void initData() {
        String stringExtra = getIntent().getStringExtra("barname");
        this.mBarName = stringExtra;
        if (stringExtra == null) {
            this.mBarName = "";
        }
    }

    private void initUI() {
        this.mOnClickListener = new a();
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.mNoNetView = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        EditText editText = (EditText) findViewById(R.id.edit_forum_name);
        this.mEditName = editText;
        editText.setText(this.mBarName);
        EditText editText2 = (EditText) findViewById(R.id.edit_vcode);
        this.mEditVcode = editText2;
        editText2.setFocusable(true);
        TextView textView = (TextView) findViewById(R.id.refresh_vcode);
        this.mRefreshButton = textView;
        textView.setOnClickListener(this.mOnClickListener);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        this.mImage = imageView;
        imageView.setOnClickListener(this.mOnClickListener);
        TextView textView2 = (TextView) findViewById(R.id.text_create);
        this.mCreate = textView2;
        textView2.setOnClickListener(this.mOnClickListener);
        findViewById(R.id.body_view).setOnTouchListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCreateTask() {
        if (this.mCreateTask == null) {
            c cVar = new c(this.mEditName.getText().toString().trim(), this.mEditVcode.getText().toString().trim());
            this.mCreateTask = cVar;
            cVar.setPriority(3);
            this.mCreateTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startImageTask() {
        if (this.mGetImageTask == null && this.mCreateTask == null) {
            d dVar = new d(this, null);
            this.mGetImageTask = dVar;
            dVar.setPriority(3);
            this.mGetImageTask.execute(new String[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i2) {
        super.changeSkinType(i2);
        getLayoutMode().j(this.mRootView);
        d.a.m0.s0.a.a(getPageContext(), this.mRootView);
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i2);
        }
        NoNetworkView noNetworkView = this.mNoNetView;
        if (noNetworkView == null || noNetworkView.getVisibility() != 0) {
            return;
        }
        this.mNoNetView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_forum_activity);
        initData();
        initUI();
        getImage();
        TiebaStatic.log("c11223");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.mCreateTask;
        if (cVar != null) {
            cVar.cancel();
        }
        d dVar = this.mGetImageTask;
        if (dVar != null) {
            dVar.cancel();
        }
    }
}
