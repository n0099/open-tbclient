package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class c78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ThirdStatisticHelper.ThirdStatisticCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                new StatisticItem("c12885").addParam("obj_param1", 1).eventStat();
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                new StatisticItem("c12885").addParam("obj_param1", 0).eventStat();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements ThirdStatisticHelper.ThirdStatisticCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                new StatisticItem("c12884").addParam("obj_param1", 1).eventStat();
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                new StatisticItem("c12884").addParam("obj_param1", 0).eventStat();
            }
        }
    }

    public static void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, list) == null) {
            if (ListUtils.isEmpty(list)) {
                new StatisticItem("c12885").addParam("obj_param1", 2).eventStat();
                return;
            }
            for (String str : list) {
                ThirdStatisticHelper.sendReq(str, new a());
            }
        }
    }

    public static void b(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, list) == null) {
            if (ListUtils.isEmpty(list)) {
                new StatisticItem("c12884").addParam("obj_param1", 2).eventStat();
                return;
            }
            for (String str : list) {
                ThirdStatisticHelper.sendReq(str, new b());
            }
        }
    }
}
