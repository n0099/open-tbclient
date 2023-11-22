package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ho5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        ca<String> o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if ((!TbadkCoreApplication.isLogin() && StringUtils.isNull(str)) || !TextUtils.equals(a(), str2) || (o = yz4.o("tb.novel_thread_read_record", a(), str)) == null || StringUtils.isNull(o.get(str))) {
                return null;
            }
            return o.get(str);
        }
        return (String) invokeLL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921697, Boolean.TRUE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
        }
    }

    public static void d(String str, ReadRecordsData readRecordsData) {
        ca<String> o;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, readRecordsData) == null) {
            if ((TbadkCoreApplication.isLogin() || !StringUtils.isNull(str)) && (o = yz4.o("tb.novel_thread_read_record", a(), str)) != null && readRecordsData != null) {
                o.g(str, OrmObject.jsonStrWithObject(readRecordsData));
            }
        }
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return CommonUrlParamManager.getInstance().processUrl(str) + "&ctv=2&cen=ua_ut_uid";
        }
        return (String) invokeL.objValue;
    }
}
