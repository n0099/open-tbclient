package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ema implements zb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zb7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "c10709" : (String) invokeV.objValue;
    }

    public ema() {
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

    @Override // com.baidu.tieba.zb7
    public Map<String, String> a(v57 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            HashMap hashMap = new HashMap();
            Map<String, String> a = businessInfo.a();
            hashMap.putAll(ula.a.a(businessInfo));
            String str = a.get("has_concerned");
            String str2 = "0";
            if (str == null) {
                str = "0";
            }
            hashMap.put(TiebaStatic.Params.AB_TYPE, str);
            String str3 = a.get("author_is_living");
            if (str3 == null) {
                str3 = "1";
            }
            hashMap.put(TiebaStatic.Params.OBJ_PARAM7, str3);
            String str4 = a.get("live_type");
            if (str4 == null) {
                str4 = "5";
            }
            hashMap.put(TiebaStatic.Params.OBJ_PARAM8, str4);
            String str5 = a.get("is_vertical_video");
            if (str5 != null) {
                str2 = str5;
            }
            hashMap.put(TiebaStatic.Params.IS_VERTICAL, str2);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
