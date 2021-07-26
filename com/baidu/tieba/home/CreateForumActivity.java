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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.t.c.k0;
/* loaded from: classes4.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mBarName;
    public TextView mCreate;
    public c mCreateTask;
    public EditText mEditName;
    public EditText mEditVcode;
    public d mGetImageTask;
    public ImageView mImage;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetView;
    public View.OnClickListener mOnClickListener;
    public TextView mRefreshButton;
    public LinearLayout mRootView;
    public String mVcode_md5;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CreateForumActivity f16485e;

        public a(CreateForumActivity createForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16485e = createForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f16485e.mCreate) {
                    this.f16485e.startCreateTask();
                    TiebaStatic.log("c11223");
                    return;
                }
                this.f16485e.startImageTask();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CreateForumActivity f16486e;

        public b(CreateForumActivity createForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16486e = createForumActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    if (this.f16486e.mEditName.hasFocus()) {
                        l.x(this.f16486e.getPageContext().getPageActivity(), this.f16486e.mEditName);
                    }
                    if (this.f16486e.mEditVcode.hasFocus()) {
                        l.x(this.f16486e.getPageContext().getPageActivity(), this.f16486e.mEditVcode);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f16487a;

        /* renamed from: b  reason: collision with root package name */
        public String f16488b;

        /* renamed from: c  reason: collision with root package name */
        public NetWork f16489c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CreateForumActivity f16490d;

        public c(CreateForumActivity createForumActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16490d = createForumActivity;
            this.f16487a = null;
            this.f16488b = null;
            this.f16489c = null;
            this.f16487a = str;
            this.f16488b = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f16489c;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f16490d.mCreateTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                    this.f16489c = netWork;
                    netWork.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f16489c.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f16487a);
                    this.f16489c.addPostData("vcode", this.f16488b);
                    this.f16489c.addPostData("vcode_md5", this.f16490d.mVcode_md5);
                    this.f16489c.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                    this.f16489c.postNetData();
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((c) str);
                this.f16490d.mCreateTask = null;
                if (this.f16489c.getNetContext().getResponse().isRequestSuccess()) {
                    CreateForumSuccessActivity.startActivity(this.f16490d.getPageContext().getPageActivity(), this.f16487a);
                    this.f16490d.finish();
                    return;
                }
                this.f16490d.showToast(this.f16489c.getErrorString());
                if (this.f16489c.isNetSuccess()) {
                    this.f16490d.startImageTask();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f16491a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f16492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CreateForumActivity f16493c;

        public d(CreateForumActivity createForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16493c = createForumActivity;
            this.f16491a = null;
            this.f16492b = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                    this.f16491a = netWork;
                    netWork.addPostData("fid", "0");
                    this.f16491a.addPostData("pub_type", "0");
                    this.f16491a.addPostData("fname", "");
                    this.f16491a.addPostData("tid", "0");
                    String postNetData = this.f16491a.postNetData();
                    if (this.f16491a.getNetContext().getResponse().isRequestSuccess()) {
                        k0 k0Var = new k0();
                        k0Var.e(postNetData);
                        if (k0Var.c() != null && k0Var.c().length() > 0) {
                            this.f16493c.mVcode_md5 = k0Var.b();
                            if (this.f16492b) {
                                return null;
                            }
                            NetWork netWork2 = new NetWork(k0Var.c());
                            this.f16491a = netWork2;
                            return BitmapHelper.Bytes2Bitmap(netWork2.getNetData());
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel(true);
                this.f16492b = true;
                NetWork netWork = this.f16491a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f16493c.mGetImageTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.f16493c.mVcode_md5 = null;
                this.f16493c.mImage.setImageDrawable(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((d) bitmap);
                this.f16493c.mGetImageTask = null;
                if (bitmap != null) {
                    this.f16493c.mImage.setImageBitmap(bitmap);
                }
            }
        }

        public /* synthetic */ d(CreateForumActivity createForumActivity, a aVar) {
            this(createForumActivity);
        }
    }

    public CreateForumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnClickListener = null;
        this.mCreateTask = null;
        this.mGetImageTask = null;
        this.mVcode_md5 = null;
        this.mEditName = null;
        this.mEditVcode = null;
        this.mImage = null;
        this.mRefreshButton = null;
        this.mCreate = null;
        this.mBarName = null;
    }

    private void getImage() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.mGetImageTask == null) {
            d dVar = new d(this, null);
            this.mGetImageTask = dVar;
            dVar.execute(new String[0]);
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            String stringExtra = getIntent().getStringExtra("barname");
            this.mBarName = stringExtra;
            if (stringExtra == null) {
                this.mBarName = "";
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mOnClickListener = new a(this);
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
            findViewById(R.id.body_view).setOnTouchListener(new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCreateTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, this) == null) && this.mCreateTask == null) {
            c cVar = new c(this, this.mEditName.getText().toString().trim(), this.mEditVcode.getText().toString().trim());
            this.mCreateTask = cVar;
            cVar.setPriority(3);
            this.mCreateTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startImageTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && this.mGetImageTask == null && this.mCreateTask == null) {
            d dVar = new d(this, null);
            this.mGetImageTask = dVar;
            dVar.setPriority(3);
            this.mGetImageTask.execute(new String[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.changeSkinType(i2);
            getLayoutMode().j(this.mRootView);
            d.a.p0.u0.a.a(getPageContext(), this.mRootView);
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.create_forum_activity);
            initData();
            initUI();
            getImage();
            TiebaStatic.log("c11223");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
}
