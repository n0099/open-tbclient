package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CustomGrid;
/* loaded from: classes4.dex */
public class e29 {
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

    public e29() {
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

    public n29 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            n29 n29Var = new n29();
            n29Var.e = this.a;
            n29Var.n = true;
            n29Var.l = this.d;
            n29Var.g = this.b;
            n29Var.a = this.e;
            n29Var.m = this.c;
            p29 p29Var = new p29();
            p29Var.b = this.g;
            p29Var.i = this.h;
            n29Var.i = p29Var;
            return n29Var;
        }
        return (n29) invokeV.objValue;
    }
}
