package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(j25 j25Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, j25Var, str)) == null) {
            long n = ry4.l().n("key_card_interest_close_click_time_" + str, 0L);
            if (n != 0) {
                int currentTimeMillis = (int) (((((System.currentTimeMillis() - n) / 1000) / 60) / 60) / 24);
                if (j25Var.a() != -1 && currentTimeMillis >= j25Var.a()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            if (!f()) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j25 homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
            if (homepageInterestConfig == null || i2 <= 0) {
                return false;
            }
            if (b(homepageInterestConfig)) {
                return true;
            }
            if (ry4.l().m("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
                if (a(homepageInterestConfig, currentAccount) && i == 0) {
                    return true;
                }
            } else if (e(homepageInterestConfig) && i == 0) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static boolean b(j25 j25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, j25Var)) == null) {
            if (j25Var.c() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(j25 j25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, j25Var)) == null) {
            if (j25Var.d() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!UbsABTestHelper.isRecommendCardInterestABTestA() || !f()) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j25 homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
            if (homepageInterestConfig == null) {
                return false;
            }
            if (b(homepageInterestConfig)) {
                return true;
            }
            if (ry4.l().m("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
                if (a(homepageInterestConfig, currentAccount)) {
                    return true;
                }
            } else if (e(homepageInterestConfig)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j25 homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
            if (homepageInterestConfig == null) {
                return false;
            }
            if (ry4.l().m("key_card_interest_close_click_num_" + currentAccount, 0) >= homepageInterestConfig.b()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
