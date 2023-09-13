package com.baidu.tieba;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.pa1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ca1 extends ba1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Handler b;
    public final fa1 c;

    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca1 a;
        public final /* synthetic */ pa1.b b;

        public a(ca1 ca1Var, pa1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ca1Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ca1Var;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.q(this.b.a());
        }
    }

    public ca1(fa1 container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(container, "container");
        this.c = container;
    }

    public final void o(pa1.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) && !this.a && bVar != null && bVar.d()) {
            if (this.b == null) {
                this.b = new Handler();
            }
            Handler handler = this.b;
            if (handler != null) {
                handler.postDelayed(new a(this, bVar), (long) (bVar.b() * 1000));
            }
        }
    }

    @Override // com.baidu.tieba.ba1
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ba1
    public void c() {
        pa1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            pa1.d l = this.c.l();
            if (l != null) {
                bVar = l.d();
            } else {
                bVar = null;
            }
            o(bVar);
            super.c();
        }
    }

    @Override // com.baidu.tieba.ba1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.b = null;
            this.a = false;
            super.d();
        }
    }

    @Override // com.baidu.tieba.ba1
    public void e(Intent intent) {
        pa1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            pa1.d l = this.c.l();
            if (l != null) {
                bVar = l.d();
            } else {
                bVar = null;
            }
            o(bVar);
            super.e(intent);
        }
    }

    public final void p(pa1.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && !this.a && bVar != null && bVar.e()) {
            q(bVar.a());
        }
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || this.a || TextUtils.isEmpty(str)) {
            return;
        }
        y31.b(str);
        this.a = true;
    }

    @Override // com.baidu.tieba.ba1
    public void g(AbsNadBrowserView webView, String str) {
        pa1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            AbsNadBrowserView m = this.c.m();
            if (m != null && !m.w() && !this.a) {
                pa1.d l = this.c.l();
                if (l != null) {
                    bVar = l.d();
                } else {
                    bVar = null;
                }
                p(bVar);
            }
            super.g(webView, str);
        }
    }
}
