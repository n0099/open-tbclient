package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.tieba.cy3;
import com.baidu.tieba.ih2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
/* loaded from: classes5.dex */
public class ey3 implements cy3.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    @Override // com.baidu.tieba.cy3.b
    public Bitmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements aq3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jh2 a;
        public final /* synthetic */ ey3 b;

        /* loaded from: classes5.dex */
        public class a implements ih2.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Boolean a;
            public final /* synthetic */ b b;

            public a(b bVar, Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bool};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = bool;
            }

            @Override // com.baidu.tieba.ih2.e
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.b;
                    bVar.b.i(this.a, bVar.a);
                }
            }
        }

        public b(ey3 ey3Var, jh2 jh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey3Var, jh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ey3Var;
            this.a = jh2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (ey3.b) {
                    Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
                }
                if (!bool.booleanValue()) {
                    this.b.i(bool, this.a);
                } else {
                    SwanAppInitHelper.doWebViewInit(gb3.K(), new a(this, bool));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jh2 a;
        public final /* synthetic */ ey3 b;

        public a(ey3 ey3Var, jh2 jh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey3Var, jh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ey3Var;
            this.a = jh2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, dialogInterface, i) != null) || -2 == i) {
                return;
            }
            this.b.j();
            this.b.l(this.a);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ey3 ey3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context appContext = AppRuntime.getAppContext();
                Intent intent = new Intent(appContext, LoadingActivity.class);
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.putExtra("so_lib_name", ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
                qn3.g(appContext, intent);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ey3 ey3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gb3.K().p("loading_hide");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947750634, "Lcom/baidu/tieba/ey3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947750634, "Lcom/baidu/tieba/ey3;");
                return;
            }
        }
        b = rr1.a;
    }

    public ey3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    @Override // com.baidu.tieba.cy3.b
    public go4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new jt4();
        }
        return (go4) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gb3.M().post(new d(this));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            gb3.M().post(new c(this));
        }
    }

    @Override // com.baidu.tieba.cy3.b
    public void b(boolean z, jh2 jh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, jh2Var) == null) {
            if (this.a) {
                if (!z) {
                    j();
                }
                l(jh2Var);
            } else if (z) {
                l(jh2Var);
            } else {
                k(new a(this, jh2Var));
            }
        }
    }

    public final void i(Boolean bool, jh2 jh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bool, jh2Var) == null) {
            this.a = false;
            h();
            if (jh2Var != null) {
                if (bool.booleanValue()) {
                    jh2Var.onSuccess();
                } else {
                    jh2Var.onFail();
                }
            }
        }
    }

    public void k(DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            BaseActivityDialog.e r = SwanAppErrorDialog.r();
            r.B(R.string.obfuscated_res_0x7f0f020d);
            r.u(R.string.obfuscated_res_0x7f0f020c);
            r.w(R.string.obfuscated_res_0x7f0f020a, onClickListener);
            r.z(R.string.obfuscated_res_0x7f0f020b, onClickListener);
            r.D();
        }
    }

    public final void l(jh2 jh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jh2Var) == null) {
            this.a = true;
            if (b) {
                Log.i("SailorSoDownloadAdapter", "startDownload: ");
            }
            wk2 wk2Var = wk2.d;
            xk2 xk2Var = new xk2();
            xk2Var.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(this, jh2Var));
            wk2Var.C(xk2Var);
        }
    }
}
