package com.baidu.tieba;

import android.content.res.Resources;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ex5 {
    public static /* synthetic */ Interceptable $ic;
    public static final ex5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947749735, "Lcom/baidu/tieba/ex5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947749735, "Lcom/baidu/tieba/ex5;");
                return;
            }
        }
        a = new ex5();
    }

    public ex5() {
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

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Resources resources = TbadkCoreApplication.getInst().getResources();
            return resources.getIdentifier("icon_forum_level_full_" + i, ResourceManager.DRAWABLE, TbadkCoreApplication.getInst().getPackageName());
        }
        return invokeI.intValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            Resources resources = TbadkCoreApplication.getInst().getResources();
            return resources.getIdentifier("icon_forum_level_" + i, ResourceManager.DRAWABLE, TbadkCoreApplication.getInst().getPackageName());
        }
        return invokeI.intValue;
    }

    public final int b(int i, Boolean bool) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bool)) == null) {
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                return a(i);
            }
            return d(i);
        }
        return invokeIL.intValue;
    }

    public final int c(int i) {
        InterceptResult invokeI;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            boolean z4 = true;
            if (1 <= i && i < 4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return R.color.CAM_X0309;
            }
            if (4 <= i && i < 10) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return R.color.CAM_X0306;
            }
            if (10 <= i && i < 16) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                return R.color.CAM_X0305;
            }
            if ((16 > i || i >= 19) ? false : false) {
                return R.color.CAM_X0319;
            }
            if (!TbadkCoreApplication.getInst().isDebugMode()) {
                return 0;
            }
            throw new IllegalArgumentException("unsupported simple level " + i + ", check and replace!");
        }
        return invokeI.intValue;
    }
}
