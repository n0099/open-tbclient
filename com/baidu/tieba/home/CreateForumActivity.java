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
import d.b.b.e.p.l;
import d.b.h0.s.c.f0;
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
                    l.w(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.mEditName);
                }
                if (CreateForumActivity.this.mEditVcode.hasFocus()) {
                    l.w(CreateForumActivity.this.getPageContext().getPageActivity(), CreateForumActivity.this.mEditVcode);
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
        public String f16963a;

        /* renamed from: b  reason: collision with root package name */
        public String f16964b;

        /* renamed from: c  reason: collision with root package name */
        public NetWork f16965c = null;

        public c(String str, String str2) {
            this.f16963a = null;
            this.f16964b = null;
            this.f16963a = str;
            this.f16964b = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            NetWork netWork = this.f16965c;
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
                this.f16965c = netWork;
                netWork.getNetContext().getRequest().mIsNeedTbs = true;
                this.f16965c.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f16963a);
                this.f16965c.addPostData("vcode", this.f16964b);
                this.f16965c.addPostData("vcode_md5", CreateForumActivity.this.mVcode_md5);
                this.f16965c.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                this.f16965c.postNetData();
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
            if (this.f16965c.getNetContext().getResponse().isRequestSuccess()) {
                CreateForumSuccessActivity.startActivity(CreateForumActivity.this.getPageContext().getPageActivity(), this.f16963a);
                CreateForumActivity.this.finish();
                return;
            }
            CreateForumActivity.this.showToast(this.f16965c.getErrorString());
            if (this.f16965c.isNetSuccess()) {
                CreateForumActivity.this.startImageTask();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<String, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f16967a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f16968b;

        public d() {
            this.f16967a = null;
            this.f16968b = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                this.f16967a = netWork;
                netWork.addPostData("fid", "0");
                this.f16967a.addPostData("pub_type", "0");
                this.f16967a.addPostData("fname", "");
                this.f16967a.addPostData("tid", "0");
                String postNetData = this.f16967a.postNetData();
                if (this.f16967a.getNetContext().getResponse().isRequestSuccess()) {
                    f0 f0Var = new f0();
                    f0Var.e(postNetData);
                    if (f0Var.c() != null && f0Var.c().length() > 0) {
                        CreateForumActivity.this.mVcode_md5 = f0Var.b();
                        if (this.f16968b) {
                            return null;
                        }
                        NetWork netWork2 = new NetWork(f0Var.c());
                        this.f16967a = netWork2;
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
            this.f16968b = true;
            NetWork netWork = this.f16967a;
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
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        getLayoutMode().j(this.mRootView);
        d.b.h0.s0.a.a(getPageContext(), this.mRootView);
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i);
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
