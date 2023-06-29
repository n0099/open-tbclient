package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Set;
/* loaded from: classes5.dex */
public class d7a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947658843, "Lcom/baidu/tieba/d7a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947658843, "Lcom/baidu/tieba/d7a;");
        }
    }

    public static void a(MainTabActivity mainTabActivity, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, mainTabActivity, intent) != null) || a || mainTabActivity == null || !mainTabActivity.isTaskRoot() || intent == null) {
            return;
        }
        String action = intent.getAction();
        Set<String> categories = intent.getCategories();
        if (action != null && categories != null && TextUtils.equals(action, "android.intent.action.MAIN") && categories.contains("android.intent.category.LAUNCHER")) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOST_START).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, TbadkCoreApplication.getInst().getCanShowSplash()));
            a = true;
        }
    }
}
