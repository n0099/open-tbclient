package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hd6 {
    public static /* synthetic */ Interceptable $ic;
    public static hd6 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<StatisticItem> a;

    public hd6() {
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

    public static hd6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (hd6.class) {
                    if (b == null) {
                        b = new hd6();
                    }
                }
            }
            return b;
        }
        return (hd6) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, statisticItem) != null) || statisticItem == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        List<StatisticItem> list = this.a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public final long c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData != null && threadData.getThreadAlaInfo() != null) {
                return threadData.getThreadAlaInfo().live_id;
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public StatisticItem d(int i, String str, int i2, String str2, ThreadData threadData) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, threadData})) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getThreadAlaInfo() != null && !StringUtils.isNull(threadData.getThreadAlaInfo().appId)) {
                str3 = threadData.getThreadAlaInfo().appId;
            } else {
                str3 = "";
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_id", c(threadData));
            statisticItem.param("tid", threadData.getId());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str3);
            statisticItem.param("entryid", i2);
            statisticItem.param("name", str2);
            statisticItem.param("is_small_follow", i);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || ListUtils.getCount(this.a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.a.clear();
    }
}
