package com.baidu.tieba.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.dr4;
import com.baidu.tieba.n35;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public EditText c;
    public EditText d;
    public RelativeLayout e;
    public FrameLayout f;
    public ImageView g;
    public ProgressBar h;
    public ProgressBar i;
    public d j;
    public e k;
    public View.OnClickListener l;
    public TextWatcher m;
    public String n;
    public TextView o;
    public RelativeLayout p;
    public RelativeLayout q;
    public TextView r;
    public String s;
    public boolean t;
    public NavigationBar u;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateBarActivity a;

        public a(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createBarActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != this.a.e) {
                    if (view2 != this.a.f) {
                        return;
                    }
                    this.a.O1();
                    return;
                }
                this.a.N1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateBarActivity a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public b(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createBarActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = this.a.c.getText().toString().trim().length();
                if (length > 0 && length < 32 && this.a.d.getText().toString().trim().length() > 0) {
                    this.a.e.setEnabled(true);
                } else {
                    this.a.e.setEnabled(false);
                }
                if (length >= 32) {
                    this.a.o.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f02fe));
                    this.a.o.setTextColor(-65536);
                    return;
                }
                this.a.o.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f02ff));
                this.a.o.setTextColor(-6250336);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateBarActivity a;

        public c(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createBarActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    if (this.a.c.hasFocus()) {
                        zi.z(this.a.getPageContext().getPageActivity(), this.a.c);
                    }
                    if (this.a.d.hasFocus()) {
                        zi.z(this.a.getPageContext().getPageActivity(), this.a.d);
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
    public class d extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public NetWork c;
        public final /* synthetic */ CreateBarActivity d;

        public d(CreateBarActivity createBarActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = createBarActivity;
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
                this.d.h.setVisibility(8);
                this.d.j = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.d.h.setVisibility(0);
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
                    this.c.addPostData("vcode_md5", this.d.n);
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
                super.onPostExecute((d) str);
                this.d.h.setVisibility(8);
                this.d.j = null;
                if (this.c.getNetContext().getResponse().isRequestSuccess()) {
                    CreateBarSuccessActivity.startActivity(this.d.getPageContext().getPageActivity(), this.a);
                    this.d.finish();
                    return;
                }
                this.d.showToast(this.c.getErrorString());
                if (this.c.isNetSuccess()) {
                    this.d.O1();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public volatile boolean b;
        public final /* synthetic */ CreateBarActivity c;

        public e(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = createBarActivity;
            this.a = null;
            this.b = false;
        }

        public /* synthetic */ e(CreateBarActivity createBarActivity, a aVar) {
            this(createBarActivity);
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
                        n35 n35Var = new n35();
                        n35Var.e(postNetData);
                        if (n35Var.c() != null && n35Var.c().length() > 0) {
                            this.c.n = n35Var.b();
                            if (this.b) {
                                return null;
                            }
                            NetWork netWork2 = new NetWork(n35Var.c());
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
                this.c.i.setVisibility(8);
                this.c.k = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.c.n = null;
                this.c.i.setVisibility(0);
                this.c.g.setImageDrawable(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((e) bitmap);
                this.c.i.setVisibility(8);
                this.c.k = null;
                if (bitmap != null) {
                    this.c.g.setImageBitmap(bitmap);
                }
            }
        }
    }

    public CreateBarActivity() {
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
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = null;
        this.s = null;
        this.t = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0201);
            initData();
            M1();
            L1();
            adjustResizeForSoftInput();
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.k == null) {
            e eVar = new e(this, null);
            this.k = eVar;
            eVar.execute(new String[0]);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.k == null && this.j == null) {
            e eVar = new e(this, null);
            this.k = eVar;
            eVar.setPriority(3);
            this.k.execute(new String[0]);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Intent intent = getIntent();
            this.s = intent.getStringExtra("barname");
            this.t = intent.getBooleanExtra("isvalid", false);
            if (this.s == null) {
                this.s = "";
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            d dVar = this.j;
            if (dVar != null) {
                dVar.cancel();
            }
            e eVar = this.k;
            if (eVar != null) {
                eVar.cancel();
            }
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l = new a(this);
            this.m = new b(this);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.u = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.u.setTitleText(getPageContext().getString(R.string.create_bar));
            this.p = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906fb);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f092200);
            ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.obfuscated_res_0x7f0923a0)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f09095e);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090fbe);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090757);
            this.e = relativeLayout;
            relativeLayout.setOnClickListener(this.l);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090fbf);
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0908ab);
            this.c = editText;
            editText.addTextChangedListener(this.m);
            EditText editText2 = (EditText) findViewById(R.id.obfuscated_res_0x7f0908ba);
            this.d = editText2;
            editText2.addTextChangedListener(this.m);
            if (this.t) {
                this.b.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0d22));
                this.c.setText(this.s);
            } else {
                this.b.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f02fd));
            }
            this.q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090757);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090f24);
            this.f = frameLayout;
            frameLayout.setOnClickListener(this.l);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f20);
            this.e.setEnabled(false);
            this.h = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091b80);
            this.i = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091b87);
            if (this.t) {
                this.d.requestFocus();
            }
            findViewById(R.id.obfuscated_res_0x7f091faf).setOnTouchListener(new c(this));
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.j == null) {
            d dVar = new d(this, this.c.getText().toString().trim(), this.d.getText().toString().trim());
            this.j = dVar;
            dVar.setPriority(3);
            this.j.execute(new String[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            dr4 layoutMode = getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            getLayoutMode().k(this.p);
            SkinManager.setButtonTextColor(this.r, i);
            SkinManager.setTextColor(this.b, i);
            String str = this.s + getPageContext().getString(R.string.obfuscated_res_0x7f0f0300);
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10252)), 0, this.s.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.s.length(), str.length(), 33);
            SkinManager.setBackgroundResource(this.q, R.drawable.btn_general_start_selector);
            this.a.setText(spannableString);
            this.u.onChangeSkinType(getPageContext(), i);
        }
    }
}
