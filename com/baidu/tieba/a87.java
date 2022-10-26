package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static re5 a(int i, Class cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, cls)) == null) {
            try {
                re5 re5Var = new re5(i, (CustomMessageTask.CustomRunnable) cls.newInstance());
                MessageManager.getInstance().registerTask(re5Var);
                return re5Var;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (re5) invokeIL.objValue;
    }

    public static se5 b(int i, Class cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            se5 se5Var = new se5(i);
            se5Var.setResponsedClass(cls);
            se5Var.h(z);
            se5Var.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(se5Var);
            return se5Var;
        }
        return (se5) invokeCommon.objValue;
    }
}
