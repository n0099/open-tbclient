package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class aq6 implements zb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zb7
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_CLICK : (String) invokeV.objValue;
    }

    public aq6() {
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
            hashMap.put("obj_type", b(businessInfo));
            String str = a.get("live_type");
            String str2 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("obj_param1", str);
            String str3 = a.get("live_app_id");
            if (str3 != null) {
                str2 = str3;
            }
            hashMap.put(TiebaStatic.Params.OBJ_PARAM2, str2);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final String b(v57 v57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v57Var)) == null) {
            Map<String, String> a = v57Var.a();
            if (Intrinsics.areEqual(a.get("thread_type"), PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK)) {
                return "3";
            }
            if (!Intrinsics.areEqual(a.get("thread_type"), PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW) && !Intrinsics.areEqual(a.get("thread_type"), PayUVEventType.PAY_AMOUNT_FULL_PAGE_CHANNEL_CLICK) && !Intrinsics.areEqual(a.get("thread_type"), PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK)) {
                return "2";
            }
            return "1";
        }
        return (String) invokeL.objValue;
    }
}
