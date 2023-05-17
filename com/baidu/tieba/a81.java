package com.baidu.tieba;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.n81;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a81 extends z71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Handler b;
    public final d81 c;

    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a81 a;
        public final /* synthetic */ n81.b b;

        public a(a81 a81Var, n81.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a81Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a81Var;
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

    public a81(d81 container) {
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

    public final void o(n81.b bVar) {
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

    @Override // com.baidu.tieba.z71
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z71
    public void c() {
        n81.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n81.d l = this.c.l();
            if (l != null) {
                bVar = l.d();
            } else {
                bVar = null;
            }
            o(bVar);
            super.c();
        }
    }

    @Override // com.baidu.tieba.z71
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

    @Override // com.baidu.tieba.z71
    public void e(Intent intent) {
        n81.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            n81.d l = this.c.l();
            if (l != null) {
                bVar = l.d();
            } else {
                bVar = null;
            }
            o(bVar);
            super.e(intent);
        }
    }

    public final void p(n81.b bVar) {
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
        f21.b(str);
        this.a = true;
    }

    @Override // com.baidu.tieba.z71
    public void g(AbsNadBrowserView webView, String str) {
        n81.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            AbsNadBrowserView m = this.c.m();
            if (m != null && !m.v() && !this.a) {
                n81.d l = this.c.l();
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
