package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
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
public final class b0a implements z97, x97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.x97
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "obj_locate" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z97
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "c10731" : (String) invokeV.objValue;
    }

    public b0a() {
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

    @Override // com.baidu.tieba.z97
    public Map<String, String> a(m57 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            HashMap hashMap = new HashMap();
            String str = businessInfo.a().get("weight");
            String str2 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("obj_param1", str);
            hashMap.put(TiebaStatic.Params.OBJ_PARAM2, "1");
            String str3 = businessInfo.a().get("source");
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put("obj_source", str3);
            String str4 = businessInfo.a().get("abtest_tag");
            if (str4 == null) {
                str4 = "";
            }
            hashMap.put("obj_name", str4);
            String e = om6.e();
            Intrinsics.checkNotNullExpressionValue(e, "getCurrentTimeStamp()");
            hashMap.put(TiebaStatic.Params.OBJ_PARAM3, e);
            int i = 0;
            if (JavaTypesHelper.toInt(businessInfo.a().get("is_live_card"), 0) != 0) {
                i = 2;
            } else if (JavaTypesHelper.toInt(businessInfo.a().get("is_video_card"), 0) != 0) {
                i = 1;
            }
            if (i == 0) {
                String str5 = businessInfo.a().get("pic_count");
                if (str5 == null) {
                    str5 = "0";
                }
                hashMap.put("obj_type", str5);
            } else {
                hashMap.put("obj_type", String.valueOf(i));
            }
            String str6 = businessInfo.a().get("abtest_tag");
            if (str6 == null) {
                str6 = "";
            }
            hashMap.put("ab_tag", str6);
            String str7 = businessInfo.a().get("nid");
            if (str7 != null) {
                str2 = str7;
            }
            hashMap.put(TiebaStatic.Params.OBJ_PARAM4, str2);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
