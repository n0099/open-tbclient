package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CustomGrid;
/* loaded from: classes5.dex */
public class bj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public String d;
    public int e;
    public long f;
    public String g;
    public String h;

    public bj9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(CustomGrid customGrid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, customGrid) == null) {
            this.a = customGrid.title;
            this.b = customGrid.action_uri;
            this.c = customGrid.action_type.intValue();
            this.d = customGrid.icon;
            this.e = customGrid.type.intValue();
            this.g = customGrid.desc;
            this.h = customGrid.mark_text;
            this.f = customGrid.red_point_version.longValue();
        }
    }

    public kj9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            kj9 kj9Var = new kj9();
            kj9Var.e = this.a;
            kj9Var.m = true;
            kj9Var.k = this.d;
            kj9Var.f = this.b;
            kj9Var.a = this.e;
            kj9Var.l = this.c;
            mj9 mj9Var = new mj9();
            mj9Var.b = this.g;
            mj9Var.i = this.h;
            kj9Var.h = mj9Var;
            return kj9Var;
        }
        return (kj9) invokeV.objValue;
    }
}
