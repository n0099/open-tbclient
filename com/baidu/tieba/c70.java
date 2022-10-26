package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.support.dns.Dns;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes3.dex */
public class c70 implements Cloneable, Call.Factory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final x60 b;
    public final Proxy c;
    public final List d;
    public final List e;
    public final ProxySelector f;
    public final SSLSocketFactory g;
    public final HostnameVerifier h;
    public final Dns i;
    public final int j;
    public final int k;
    public final int l;
    public g70 m;
    public boolean n;
    public boolean o;
    public String p;

    /* loaded from: classes3.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public x60 b;
        public Proxy c;
        public final List d;
        public final List e;
        public ProxySelector f;
        public SSLSocketFactory g;
        public HostnameVerifier h;
        public boolean i;
        public boolean j;
        public Dns k;
        public int l;
        public int m;
        public int n;
        public g70 o;
        public String p;

        public a() {
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
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.b = new x60();
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f = proxySelector;
            if (proxySelector == null) {
                this.f = new a70();
            }
            SocketFactory.getDefault();
            this.h = null;
            this.k = Dns.SYSTEM;
            this.l = 10000;
            this.m = 10000;
            this.n = 10000;
            this.o = new e70();
        }

        public a(c70 c70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c70Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.b = c70Var.b;
            this.c = c70Var.c;
            this.d.addAll(c70Var.d);
            this.e.addAll(c70Var.e);
            this.f = c70Var.f;
            this.k = c70Var.i;
            this.l = c70Var.j;
            this.m = c70Var.k;
            this.n = c70Var.l;
            this.o = c70Var.m;
            this.i = c70Var.n;
            this.j = c70Var.o;
            this.p = c70Var.p;
            this.h = c70Var.h;
            this.g = c70Var.g;
        }

        public a a(y60 y60Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, y60Var)) == null) {
                if (y60Var != null) {
                    this.d.add(y60Var);
                    return this;
                }
                throw new IllegalArgumentException("interceptor == null");
            }
            return (a) invokeL.objValue;
        }

        public a c(x60 x60Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x60Var)) == null) {
                if (x60Var != null) {
                    this.b = x60Var;
                    return this;
                }
                throw new IllegalArgumentException("dispatcher == null");
            }
            return (a) invokeL.objValue;
        }

        public a d(g70 g70Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, g70Var)) == null) {
                this.o = g70Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public c70 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new c70(this);
            }
            return (c70) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947627533, "Lcom/baidu/tieba/c70;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947627533, "Lcom/baidu/tieba/c70;");
                return;
            }
        }
        new ArrayList(2);
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public x60 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (x60) invokeV.objValue;
    }

    public HostnameVerifier q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (HostnameVerifier) invokeV.objValue;
    }

    public g70 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m;
        }
        return (g70) invokeV.objValue;
    }

    public List s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public List t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new a(this);
        }
        return (a) invokeV.objValue;
    }

    public ProxySelector v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (ProxySelector) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public SSLSocketFactory x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (SSLSocketFactory) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public c70(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = false;
        this.o = false;
        this.p = null;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = Util.immutableList(aVar.d);
        this.e = Util.immutableList(aVar.e);
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.k;
        this.j = aVar.l;
        this.k = aVar.m;
        this.l = aVar.n;
        if (!this.d.contains(null)) {
            if (!this.e.contains(null)) {
                this.m = aVar.o;
                this.n = aVar.i;
                this.o = aVar.j;
                this.p = aVar.p;
                return;
            }
            throw new IllegalStateException("Null network interceptor: " + this.e);
        }
        throw new IllegalStateException("Null interceptor: " + this.d);
    }

    @Override // com.baidu.searchbox.network.outback.core.Call.Factory
    public Call newCall(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) {
            return b70.c(request, this, false);
        }
        return (Call) invokeL.objValue;
    }
}
