package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bb5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947639220, "Lcom/baidu/tieba/bb5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947639220, "Lcom/baidu/tieba/bb5;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (qd.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return 3;
            }
            return SharedPrefHelper.getInstance().getInt("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), 3);
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().b()) {
                int a2 = a();
                if (a2 != 2) {
                    if (a2 == 3) {
                        return R.drawable.icon_mask_share_wechat40_svg;
                    }
                    if (a2 != 4) {
                        if (a2 != 6) {
                            if (a2 != 8) {
                                return R.drawable.icon_mask_share_wechat40_svg;
                            }
                            return R.drawable.icon_mask_share_qq40_svg;
                        }
                        return R.drawable.icon_mask_share_weibo40_svg;
                    }
                    return R.drawable.icon_mask_share_qqzone40_svg;
                }
                return R.drawable.icon_mask_share_circle40_svg;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            long j = a;
            if (j >= 0) {
                return j;
            }
            if (!qd.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                a = SharedPrefHelper.getInstance().getLong("key_shared_to_tb_friend_prefix_" + TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            return a;
        }
        return invokeV.longValue;
    }

    public static void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) && i > 0 && !qd.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            SharedPrefHelper.getInstance().putInt("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), i);
            SharedPrefHelper.getInstance().remove("key_shared_to_tb_friend_prefix_" + TbadkCoreApplication.getCurrentAccount());
            a = 0L;
        }
    }

    public static void e(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65541, null, j) == null) && !qd.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            SharedPrefHelper.getInstance().putLong("key_shared_to_tb_friend_prefix_" + TbadkCoreApplication.getCurrentAccount(), j);
            a = j;
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            a = -1L;
        }
    }
}
