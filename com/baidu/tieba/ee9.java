package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.impersonal.data.BehaviorExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes5.dex */
public final class ee9 {
    public static /* synthetic */ Interceptable $ic;
    public static final ee9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731600, "Lcom/baidu/tieba/ee9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731600, "Lcom/baidu/tieba/ee9;");
                return;
            }
        }
        a = new ee9();
    }

    public ee9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final void a(String key, String uid, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, key, uid, str) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(uid, "uid");
            StatisticItem.make(key).param("uid", uid).param("content", str).eventStat();
        }
    }

    @JvmStatic
    public static final void b(String str, String objType, BehaviorExt behaviorExt) {
        boolean z;
        String str2;
        String sceneFrom;
        String sceneFrom2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, objType, behaviorExt) == null) {
            Intrinsics.checkNotNullParameter(objType, "objType");
            StatisticItem statisticItem = new StatisticItem("c15273");
            statisticItem.param("uid", str);
            statisticItem.param("obj_type", objType);
            boolean z2 = true;
            if (behaviorExt != null && (sceneFrom2 = behaviorExt.getSceneFrom()) != null && StringsKt__StringsJVMKt.startsWith$default(sceneFrom2, "catchphrase", false, 2, null)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str2 = "1";
            } else {
                if ((behaviorExt == null || (sceneFrom = behaviorExt.getSceneFrom()) == null || !StringsKt__StringsJVMKt.startsWith$default(sceneFrom, "search_summary", false, 2, null)) ? false : false) {
                    str2 = "2";
                } else {
                    str2 = "";
                }
            }
            if (StringUtils.isNotNull(str2)) {
                statisticItem.param("obj_source", str2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @JvmStatic
    public static final void c(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            StatisticItem param = new StatisticItem("c15227").param("uid", TbadkCoreApplication.getCurrentAccount());
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            param.param("obj_type", i).eventStat();
        }
    }
}
