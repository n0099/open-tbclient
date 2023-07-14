package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hs4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hs4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final gs4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public hs4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        gs4<String> gs4Var = new gs4<>();
        this.a = gs4Var;
        if (context == null) {
            return;
        }
        gs4Var.a(new ks4(context));
        this.a.a(new ms4(context));
        this.a.a(new ls4(context));
        this.a.a(new os4(context));
        this.a.a(new is4(context));
        this.a.a(new ns4(context));
    }

    public static hs4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (hs4.class) {
                    if (c == null) {
                        c = new hs4(context);
                    }
                }
            }
            return c;
        }
        return (hs4) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                synchronized (this) {
                    if (TextUtils.isEmpty(this.b)) {
                        String b = this.a.b();
                        this.b = b;
                        this.a.d(b);
                    }
                }
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }
}
