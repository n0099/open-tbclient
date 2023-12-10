package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.database.FrsVisitedInfoManager;
import com.baidu.tieba.ra8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class av6 extends fg1<pa8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements pa8 {
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

        @Override // com.baidu.tieba.pa8
        public ra8 a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                List<String> k = FrsVisitedInfoManager.d.a().k(i);
                if (k == null) {
                    return null;
                }
                return b(k, FrsVisitedInfoManager.d.a().j(k));
            }
            return (ra8) invokeI.objValue;
        }

        public final ra8 b(List<String> list, Map<String, Map<String, lsa>> map) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, map)) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str : list) {
                    linkedHashMap.put(str, c(map.get(str)));
                }
                return new ra8(linkedHashMap);
            }
            return (ra8) invokeLL.objValue;
        }

        public final ra8.a c(Map<String, lsa> map) {
            InterceptResult invokeL;
            lsa lsaVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
                StringBuilder sb = new StringBuilder();
                long j = 0;
                for (int i = 0; i < 15; i++) {
                    String format = FrsVisitedInfoManager.d.b().format(TimeHelper.getNDaysAgoDate(-i));
                    if (map != null) {
                        lsaVar = map.get(format);
                    } else {
                        lsaVar = null;
                    }
                    if (lsaVar != null) {
                        sb.append(lsaVar.c());
                        if (lsaVar.d() > j) {
                            j = lsaVar.d();
                        }
                    } else {
                        sb.append(0);
                    }
                    sb.append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "frsCustomCounts.toString()");
                return new ra8.a(sb2, j / 1000);
            }
            return (ra8.a) invokeL.objValue;
        }
    }

    public av6() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fg1
    /* renamed from: a */
    public pa8 createService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (pa8) invokeV.objValue;
    }
}
