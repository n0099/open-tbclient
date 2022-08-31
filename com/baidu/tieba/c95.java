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
public abstract class c95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a95> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

    public c95() {
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

    public void addEventDelegate(a95 a95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a95Var) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(a95Var)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(a95Var);
        }
    }

    public boolean dispatchMvcEvent(b95 b95Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b95Var)) == null) {
            if (b95Var == null) {
                return false;
            }
            if (b95Var.e() == null) {
                b95Var.i(this.uniqueId);
            }
            if (this.eventDelegates != null) {
                try {
                    this.isDispatchMvcEventing = true;
                    onBeforeDispatchMvcEvent(b95Var);
                    int size = this.eventDelegates.size();
                    z = false;
                    for (int i = 0; i < size; i++) {
                        try {
                            a95 a95Var = this.eventDelegates.get(i);
                            if (a95Var != null && ((!a95Var.S0() || (a95Var.S0() && b95Var.e() == a95Var.getUniqueId())) && (z = a95Var.s0(b95Var)) && b95Var.f())) {
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

    public void onBeforeDispatchMvcEvent(b95 b95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b95Var) == null) {
        }
    }

    public void removeEventDelegate(a95 a95Var) {
        List<a95> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, a95Var) == null) && (list = this.eventDelegates) != null && list.contains(a95Var)) {
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.remove(a95Var);
        }
    }
}
