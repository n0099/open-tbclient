package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wxb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class dyb extends xxb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context c;
    public final String d;
    public yxb e;
    public volatile eyb f;
    public final Object g;
    public rxb h;
    public final Map<String, String> i;
    public volatile fyb j;

    public dyb(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new Object();
        this.h = rxb.b;
        this.i = new HashMap();
        this.c = context;
        this.d = str;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int i = 0;
            if (str.length() > 0) {
                while (str.charAt(i) == '/') {
                    i++;
                }
            }
            return WebvttCueParser.CHAR_SLASH + str.substring(i);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uxb
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? i(str, null) : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uxb
    public rxb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.h == null) {
                this.h = rxb.b;
            }
            if (this.h == rxb.b && this.f == null) {
                f();
            }
            rxb rxbVar = this.h;
            return rxbVar == null ? rxb.b : rxbVar;
        }
        return (rxb) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f == null) {
            synchronized (this.g) {
                if (this.f == null) {
                    if (this.e != null) {
                        this.f = new iyb(this.e.b());
                        this.e.a();
                        throw null;
                    }
                    this.f = new lyb(this.c, this.d);
                    this.j = new fyb(this.f);
                }
                h();
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        wxb.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Map<String, wxb.a> a = wxb.a();
            if (a.containsKey(str) && (aVar = a.get(str)) != null) {
                return aVar.a(this);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xxb, com.baidu.tieba.uxb
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xxb, com.baidu.tieba.uxb
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "DEFAULT_INSTANCE" : (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.h == rxb.b) {
            if (this.f != null) {
                this.h = ayb.f(this.f.a("/region", null), this.f.a("/agcgw/url", null));
            } else {
                Log.w("AGConnectServiceConfig", "get route fail , config not ready");
            }
        }
    }

    public String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            if (str != null) {
                if (this.f == null) {
                    f();
                }
                String e = e(str);
                String str3 = this.i.get(e);
                if (str3 != null) {
                    return str3;
                }
                String g = g(e);
                if (g != null) {
                    return g;
                }
                String a = this.f.a(e, str2);
                return fyb.c(a) ? this.j.a(a, str2) : a;
            }
            throw new NullPointerException("path must not be null.");
        }
        return (String) invokeLL.objValue;
    }
}
