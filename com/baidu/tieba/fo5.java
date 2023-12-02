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
public abstract class fo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<do5> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

    public void onBeforeDispatchMvcEvent(eo5 eo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eo5Var) == null) {
        }
    }

    public fo5() {
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

    public void addEventDelegate(do5 do5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, do5Var) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(do5Var)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(do5Var);
        }
    }

    public void removeEventDelegate(do5 do5Var) {
        List<do5> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, do5Var) != null) || (list = this.eventDelegates) == null || !list.contains(do5Var)) {
            return;
        }
        if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("can not add event delegate on dispatch mvcevent");
        }
        this.eventDelegates.remove(do5Var);
    }

    public boolean dispatchMvcEvent(eo5 eo5Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eo5Var)) == null) {
            if (eo5Var == null) {
                return false;
            }
            if (eo5Var.e() == null) {
                eo5Var.i(this.uniqueId);
            }
            if (this.eventDelegates == null) {
                return false;
            }
            try {
                this.isDispatchMvcEventing = true;
                onBeforeDispatchMvcEvent(eo5Var);
                int size = this.eventDelegates.size();
                z = false;
                for (int i = 0; i < size; i++) {
                    try {
                        do5 do5Var = this.eventDelegates.get(i);
                        if (do5Var != null && ((!do5Var.n() || (do5Var.n() && eo5Var.e() == do5Var.getUniqueId())) && (z = do5Var.i(eo5Var)) && eo5Var.f())) {
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
