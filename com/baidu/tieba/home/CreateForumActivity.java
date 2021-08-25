package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.t.c.k0;
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
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CreateForumActivity f51853e;

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
            this.f51853e = createForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f51853e.mCreate) {
                    this.f51853e.startCreateTask();
                    TiebaStatic.log("c11223");
                    return;
                }
                this.f51853e.startImageTask();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CreateForumActivity f51854e;

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
            this.f51854e = createForumActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    if (this.f51854e.mEditName.hasFocus()) {
                        l.x(this.f51854e.getPageContext().getPageActivity(), this.f51854e.mEditName);
                    }
                    if (this.f51854e.mEditVcode.hasFocus()) {
                        l.x(this.f51854e.getPageContext().getPageActivity(), this.f51854e.mEditVcode);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f51855a;

        /* renamed from: b  reason: collision with root package name */
        public String f51856b;

        /* renamed from: c  reason: collision with root package name */
        public NetWork f51857c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CreateForumActivity f51858d;

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
            this.f51858d = createForumActivity;
            this.f51855a = null;
            this.f51856b = null;
            this.f51857c = null;
            this.f51855a = str;
            this.f51856b = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f51857c;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f51858d.mCreateTask = null;
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
                    this.f51857c = netWork;
                    netWork.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f51857c.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f51855a);
                    this.f51857c.addPostData("vcode", this.f51856b);
                    this.f51857c.addPostData("vcode_md5", this.f51858d.mVcode_md5);
                    this.f51857c.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                    this.f51857c.postNetData();
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
                this.f51858d.mCreateTask = null;
                if (this.f51857c.getNetContext().getResponse().isRequestSuccess()) {
                    CreateForumSuccessActivity.startActivity(this.f51858d.getPageContext().getPageActivity(), this.f51855a);
                    this.f51858d.finish();
                    return;
                }
                this.f51858d.showToast(this.f51857c.getErrorString());
                if (this.f51857c.isNetSuccess()) {
                    this.f51858d.startImageTask();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f51859a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f51860b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CreateForumActivity f51861c;

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
            this.f51861c = createForumActivity;
            this.f51859a = null;
            this.f51860b = false;
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
                    this.f51859a = netWork;
                    netWork.addPostData("fid", "0");
                    this.f51859a.addPostData("pub_type", "0");
                    this.f51859a.addPostData("fname", "");
                    this.f51859a.addPostData("tid", "0");
                    String postNetData = this.f51859a.postNetData();
                    if (this.f51859a.getNetContext().getResponse().isRequestSuccess()) {
                        k0 k0Var = new k0();
                        k0Var.e(postNetData);
                        if (k0Var.c() != null && k0Var.c().length() > 0) {
                            this.f51861c.mVcode_md5 = k0Var.b();
                            if (this.f51860b) {
                                return null;
                            }
                            NetWork netWork2 = new NetWork(k0Var.c());
                            this.f51859a = netWork2;
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
                this.f51860b = true;
                NetWork netWork = this.f51859a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f51861c.mGetImageTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.f51861c.mVcode_md5 = null;
                this.f51861c.mImage.setImageDrawable(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((d) bitmap);
                this.f51861c.mGetImageTask = null;
                if (bitmap != null) {
                    this.f51861c.mImage.setImageBitmap(bitmap);
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
            c.a.p0.u0.a.a(getPageContext(), this.mRootView);
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i2);
            }
            NoNetworkView noNetworkView = this.mNoNetView;
            if (noNetworkView == null || noNetworkView.getVisibility() != 0) {
                return;
            }
            this.mNoNetView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
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
