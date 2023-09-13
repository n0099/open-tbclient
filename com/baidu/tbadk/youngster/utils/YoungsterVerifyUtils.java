package com.baidu.tbadk.youngster.utils;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.m36;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class YoungsterVerifyUtils {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isNight;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-808196033, "Lcom/baidu/tbadk/youngster/utils/YoungsterVerifyUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-808196033, "Lcom/baidu/tbadk/youngster/utils/YoungsterVerifyUtils;");
        }
    }

    public static boolean isYoungsterOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public YoungsterVerifyUtils() {
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

    public static void clearYoungsterVerify() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            SharedPrefHelper.getInstance().remove("key_youngster_verify");
        }
    }

    public static String getVerifyByYoungsterPasswordData(m36 m36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, m36Var)) == null) {
            if (m36Var != null && !StringUtils.isNull(m36Var.c()) && !StringUtils.isNull(m36Var.b()) && !StringUtils.isNull(m36Var.a())) {
                return m36Var.c() + "," + m36Var.b() + "," + m36Var.a();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void showYoungsterRejectToast(Context context) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null) {
                activity = TbadkApplication.getInst().getCurrentActivity();
            }
            if (activity != null && !activity.isDestroyed()) {
                new BdTopToast(activity).setIcon(false).setContent(activity.getString(R.string.youngster_reject_toast)).show((ViewGroup) activity.findViewById(16908290));
            }
        }
    }

    public static m36 getYoungsterPasswordDataByVerify(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            String[] split = str.split(",");
            if (split.length <= 2) {
                return null;
            }
            return new m36(split[0], split[1], split[2]);
        }
        return (m36) invokeL.objValue;
    }

    public static boolean passwordVerified(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("key_youngster_verify", "");
            if (StringUtils.isNull(string)) {
                clearYoungsterVerify();
                return false;
            }
            m36 youngsterPasswordDataByVerify = getYoungsterPasswordDataByVerify(string);
            if (youngsterPasswordDataByVerify == null) {
                return false;
            }
            return str.equals(youngsterPasswordDataByVerify.a());
        }
        return invokeL.booleanValue;
    }

    public static void saveYoungsterVerify(String str) {
        AccountData currentAccountInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, str) == null) && !StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            SharedPrefHelper.getInstance().putString("key_youngster_verify", getVerifyByYoungsterPasswordData(new m36(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }
}
