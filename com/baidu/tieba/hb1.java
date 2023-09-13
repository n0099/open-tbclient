package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
@Service
/* loaded from: classes6.dex */
public final class hb1 extends dj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    @Override // com.baidu.tieba.dj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "prerender" : (String) invokeV.objValue;
    }

    public hb1() {
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
        this.a = "PreRenderAction";
    }

    @Override // com.baidu.tieba.dj0
    public boolean b(Context context, hj0 schemeModel, Map<String, Object> map, lj0 lj0Var) {
        InterceptResult invokeLLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, schemeModel, map, lj0Var)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(schemeModel, "schemeModel");
            super.b(context, schemeModel, map, lj0Var);
            if (un0.b().a().a("ad_do_prerender", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                db1 d = bb1.d();
                if (d != null) {
                    d.c();
                }
                return false;
            }
            HashMap<String, String> d2 = schemeModel.d();
            Intrinsics.checkNotNullExpressionValue(d2, "schemeModel.params");
            String str = d2.get("url");
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                jb1.a("PreRender_" + this.a, "URL 为空，协议错误，无法预渲染");
                return false;
            }
            d2.get("web_type");
            String str2 = d2.get("refer");
            db1 d3 = bb1.d();
            if (d3 != null) {
                d3.b(str, null, str2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
