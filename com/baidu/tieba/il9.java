package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class il9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947857491, "Lcom/baidu/tieba/il9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947857491, "Lcom/baidu/tieba/il9;");
        }
    }

    public static String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            return TbConfig.SERVER_ADDRESS + str + "?cmd=" + i;
        }
        return (String) invokeLI.objValue;
    }

    public static fn5 b(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, cls)) == null) {
            try {
                fn5 fn5Var = new fn5(i, cls.newInstance());
                MessageManager.getInstance().registerTask(fn5Var);
                return fn5Var;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (fn5) invokeIL.objValue;
    }

    public static TbHttpMessageTask c(int i, int i2, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, cls, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i2, a(str, i));
            tbHttpMessageTask.setIsNeedLogin(z);
            tbHttpMessageTask.setIsNeedTbs(z2);
            tbHttpMessageTask.setIsNeedAddCommenParam(z3);
            tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
            tbHttpMessageTask.setResponsedClass(cls);
            MessageManager.getInstance().unRegisterTask(i2);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            return tbHttpMessageTask;
        }
        return (TbHttpMessageTask) invokeCommon.objValue;
    }

    public static void d(int i, int i2, String str, Class<? extends HttpResponsedMessage> cls, Class<? extends SocketResponsedMessage> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, cls, cls2}) == null) {
            h(i2, cls2, false, false);
            c(i2, i, str, cls, false, true, true, false);
        }
    }

    public static TbHttpMessageTask e(int i, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), str, cls, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, TbConfig.SERVER_ADDRESS + str);
            tbHttpMessageTask.setIsNeedLogin(z);
            tbHttpMessageTask.setIsNeedTbs(z2);
            tbHttpMessageTask.setIsNeedAddCommenParam(z3);
            tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
            tbHttpMessageTask.setResponsedClass(cls);
            MessageManager.getInstance().unRegisterTask(i);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            return tbHttpMessageTask;
        }
        return (TbHttpMessageTask) invokeCommon.objValue;
    }

    public static gn5 f(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            return g(i, cls, z, SocketMessageTask.DupLicateMode.NONE, true);
        }
        return (gn5) invokeCommon.objValue;
    }

    public static gn5 g(int i, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z), dupLicateMode, Boolean.valueOf(z2)})) == null) {
            gn5 gn5Var = new gn5(i);
            gn5Var.setResponsedClass(cls);
            gn5Var.h(z);
            gn5Var.f(dupLicateMode);
            gn5Var.setRetry(a);
            MessageManager.getInstance().unRegisterTask(i);
            MessageManager.getInstance().registerTask(gn5Var);
            gn5Var.setNeedEncrypt(z2);
            return gn5Var;
        }
        return (gn5) invokeCommon.objValue;
    }

    public static gn5 h(int i, Class<? extends SocketResponsedMessage> cls, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return g(i, cls, z, SocketMessageTask.DupLicateMode.NONE, z2);
        }
        return (gn5) invokeCommon.objValue;
    }
}
