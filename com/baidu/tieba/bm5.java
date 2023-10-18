package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class bm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<zl5> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

    public void onBeforeDispatchMvcEvent(am5 am5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, am5Var) == null) {
        }
    }

    public bm5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isDispatchMvcEventing = false;
    }

    public void addEventDelegate(zl5 zl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zl5Var) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(zl5Var)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(zl5Var);
        }
    }

    public void removeEventDelegate(zl5 zl5Var) {
        List<zl5> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, zl5Var) != null) || (list = this.eventDelegates) == null || !list.contains(zl5Var)) {
            return;
        }
        if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("can not add event delegate on dispatch mvcevent");
        }
        this.eventDelegates.remove(zl5Var);
    }

    public boolean dispatchMvcEvent(am5 am5Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, am5Var)) == null) {
            if (am5Var == null) {
                return false;
            }
            if (am5Var.e() == null) {
                am5Var.i(this.uniqueId);
            }
            if (this.eventDelegates == null) {
                return false;
            }
            try {
                this.isDispatchMvcEventing = true;
                onBeforeDispatchMvcEvent(am5Var);
                int size = this.eventDelegates.size();
                z = false;
                for (int i = 0; i < size; i++) {
                    try {
                        zl5 zl5Var = this.eventDelegates.get(i);
                        if (zl5Var != null && ((!zl5Var.o() || (zl5Var.o() && am5Var.e() == zl5Var.getUniqueId())) && (z = zl5Var.j(am5Var)) && am5Var.f())) {
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            BdLog.e(th);
                            if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException(th);
                            }
                            this.isDispatchMvcEventing = false;
                            return z;
                        } finally {
                            this.isDispatchMvcEventing = false;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
            this.isDispatchMvcEventing = false;
            return z;
        }
        return invokeL.booleanValue;
    }
}
