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
import com.baidu.tieba.c35;
import com.baidu.tieba.qf5;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CreateForumActivity extends BaseActivity<CreateForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener a;
    public c b;
    public d c;
    public String d;
    public LinearLayout e;
    public NavigationBar f;
    public NoNetworkView g;
    public EditText h;
    public EditText i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public String m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateForumActivity a;

        public a(CreateForumActivity createForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.l) {
                    this.a.J1();
                    TiebaStatic.log("c11223");
                    return;
                }
                this.a.K1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateForumActivity a;

        public b(CreateForumActivity createForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createForumActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    if (this.a.h.hasFocus()) {
                        yi.z(this.a.getPageContext().getPageActivity(), this.a.h);
                    }
                    if (this.a.i.hasFocus()) {
                        yi.z(this.a.getPageContext().getPageActivity(), this.a.i);
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
        public String a;
        public String b;
        public NetWork c;
        public final /* synthetic */ CreateForumActivity d;

        public c(CreateForumActivity createForumActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = createForumActivity;
            this.a = null;
            this.b = null;
            this.c = null;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                NetWork netWork = this.c;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.d.b = null;
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
                    this.c = netWork;
                    netWork.getNetContext().getRequest().mIsNeedTbs = true;
                    this.c.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.a);
                    this.c.addPostData("vcode", this.b);
                    this.c.addPostData("vcode_md5", this.d.d);
                    this.c.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                    this.c.postNetData();
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
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
                this.d.b = null;
                if (this.c.getNetContext().getResponse().isRequestSuccess()) {
                    CreateForumSuccessActivity.startActivity(this.d.getPageContext().getPageActivity(), this.a);
                    this.d.finish();
                    return;
                }
                this.d.showToast(this.c.getErrorString());
                if (this.c.isNetSuccess()) {
                    this.d.K1();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public volatile boolean b;
        public final /* synthetic */ CreateForumActivity c;

        public d(CreateForumActivity createForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = createForumActivity;
            this.a = null;
            this.b = false;
        }

        public /* synthetic */ d(CreateForumActivity createForumActivity, a aVar) {
            this(createForumActivity);
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
                    this.a = netWork;
                    netWork.addPostData("fid", "0");
                    this.a.addPostData("pub_type", "0");
                    this.a.addPostData("fname", "");
                    this.a.addPostData("tid", "0");
                    String postNetData = this.a.postNetData();
                    if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                        c35 c35Var = new c35();
                        c35Var.e(postNetData);
                        if (c35Var.c() != null && c35Var.c().length() > 0) {
                            this.c.d = c35Var.b();
                            if (this.b) {
                                return null;
                            }
                            NetWork netWork2 = new NetWork(c35Var.c());
                            this.a = netWork2;
                            return BitmapHelper.Bytes2Bitmap(netWork2.getNetData());
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
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
                this.b = true;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.c.c = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.c.d = null;
                this.c.j.setImageDrawable(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((d) bitmap);
                this.c.c = null;
                if (bitmap != null) {
                    this.c.j.setImageBitmap(bitmap);
                }
            }
        }
    }

    public CreateForumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b == null) {
            c cVar = new c(this, this.h.getText().toString().trim(), this.i.getText().toString().trim());
            this.b = cVar;
            cVar.setPriority(3);
            this.b.execute(new String[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0204);
            initData();
            I1();
            H1();
            TiebaStatic.log("c11223");
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c == null) {
            d dVar = new d(this, null);
            this.c = dVar;
            dVar.execute(new String[0]);
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.c == null && this.b == null) {
            d dVar = new d(this, null);
            this.c = dVar;
            dVar.setPriority(3);
            this.c.execute(new String[0]);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String stringExtra = getIntent().getStringExtra("barname");
            this.m = stringExtra;
            if (stringExtra == null) {
                this.m = "";
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            c cVar = this.b;
            if (cVar != null) {
                cVar.cancel();
            }
            d dVar = this.c;
            if (dVar != null) {
                dVar.cancel();
            }
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new a(this);
            this.e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091cd4);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092613);
            this.f = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f.setTitleText(R.string.obfuscated_res_0x7f0f0478);
            this.g = (NoNetworkView) this.e.findViewById(R.id.obfuscated_res_0x7f092615);
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f09088d);
            this.h = editText;
            editText.setText(this.m);
            EditText editText2 = (EditText) findViewById(R.id.obfuscated_res_0x7f09089e);
            this.i = editText2;
            editText2.setFocusable(true);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091c12);
            this.k = textView;
            textView.setOnClickListener(this.a);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eba);
            this.j = imageView;
            imageView.setOnClickListener(this.a);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f092174);
            this.l = textView2;
            textView2.setOnClickListener(this.a);
            findViewById(R.id.obfuscated_res_0x7f0903cc).setOnTouchListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.changeSkinType(i);
            getLayoutMode().k(this.e);
            qf5.a(getPageContext(), this.e);
            NavigationBar navigationBar = this.f;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
            }
            NoNetworkView noNetworkView = this.g;
            if (noNetworkView != null && noNetworkView.getVisibility() == 0) {
                this.g.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
