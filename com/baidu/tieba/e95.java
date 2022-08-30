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
/* loaded from: classes3.dex */
public abstract class e95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c95> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

    public e95() {
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

    public void addEventDelegate(c95 c95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c95Var) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(c95Var)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(c95Var);
        }
    }

    public boolean dispatchMvcEvent(d95 d95Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d95Var)) == null) {
            if (d95Var == null) {
                return false;
            }
            if (d95Var.e() == null) {
                d95Var.i(this.uniqueId);
            }
            if (this.eventDelegates != null) {
                try {
                    this.isDispatchMvcEventing = true;
                    onBeforeDispatchMvcEvent(d95Var);
                    int size = this.eventDelegates.size();
                    z = false;
                    for (int i = 0; i < size; i++) {
                        try {
                            c95 c95Var = this.eventDelegates.get(i);
                            if (c95Var != null && ((!c95Var.S0() || (c95Var.S0() && d95Var.e() == c95Var.getUniqueId())) && (z = c95Var.s0(d95Var)) && d95Var.f())) {
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
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onBeforeDispatchMvcEvent(d95 d95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d95Var) == null) {
        }
    }

    public void removeEventDelegate(c95 c95Var) {
        List<c95> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, c95Var) == null) && (list = this.eventDelegates) != null && list.contains(c95Var)) {
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.remove(c95Var);
        }
    }
}
