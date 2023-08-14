package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class c1a implements z97, l67, x97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    @Override // com.baidu.tieba.x97
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "position_from_1" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z97
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a implements c77 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c1a a;

        public a(c1a c1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c1aVar;
        }

        @Override // com.baidu.tieba.c77
        public void a(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                Intrinsics.checkNotNullParameter(map, "map");
                if (!Intrinsics.areEqual(map.get("is_tie_plus_ad_thread"), "1")) {
                    return;
                }
                ThreadData threadData = new ThreadData();
                threadData.tiePlusCostUrl = map.get("tie_plus_cost_url");
                threadData.tid = map.get("thread_id");
                threadData.setFid(JavaTypesHelper.toLong(map.get("forum_id"), 0L));
                threadData.tiePlusMonitorClickUrl = map.get("tie_plus_monitor_click_url");
                int i = 1;
                threadData.isTiebaPlusAdThread = true;
                threadData.threadType = JavaTypesHelper.toInt(map.get("thread_type"), 0);
                if (Intrinsics.areEqual(map.get("is_video_work"), "1")) {
                    WorksInfoData worksInfoData = new WorksInfoData();
                    worksInfoData.isWorks = true;
                    threadData.worksInfoData = worksInfoData;
                }
                threadData.tiebaPlusOrderId = map.get("tie_plus_order_id");
                threadData.tiebaPlusToken = map.get("tie_plus_token");
                threadData.tiebaPlusExtraParam = map.get("tie_plus_extra_param");
                if (this.a.a) {
                    i = 2;
                }
                r48.c(threadData, map.get("source"), JavaTypesHelper.toInt(map.get("position_from_1"), 0), i);
            }
        }
    }

    public c1a() {
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

    @Override // com.baidu.tieba.l67
    public c77 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new a(this);
        }
        return (c77) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z97
    public Map<String, String> a(m57 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            HashMap hashMap = new HashMap();
            hashMap.putAll(businessInfo.a());
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final c1a f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.a = z;
            return this;
        }
        return (c1a) invokeZ.objValue;
    }
}
