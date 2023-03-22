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
/* loaded from: classes4.dex */
public abstract class ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<gj5> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

    public void onBeforeDispatchMvcEvent(hj5 hj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hj5Var) == null) {
        }
    }

    public ij5() {
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

    public void addEventDelegate(gj5 gj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gj5Var) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(gj5Var)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(gj5Var);
        }
    }

    public void removeEventDelegate(gj5 gj5Var) {
        List<gj5> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, gj5Var) != null) || (list = this.eventDelegates) == null || !list.contains(gj5Var)) {
            return;
        }
        if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("can not add event delegate on dispatch mvcevent");
        }
        this.eventDelegates.remove(gj5Var);
    }

    public boolean dispatchMvcEvent(hj5 hj5Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hj5Var)) == null) {
            if (hj5Var == null) {
                return false;
            }
            if (hj5Var.e() == null) {
                hj5Var.i(this.uniqueId);
            }
            if (this.eventDelegates == null) {
                return false;
            }
            try {
                this.isDispatchMvcEventing = true;
                onBeforeDispatchMvcEvent(hj5Var);
                int size = this.eventDelegates.size();
                z = false;
                for (int i = 0; i < size; i++) {
                    try {
                        gj5 gj5Var = this.eventDelegates.get(i);
                        if (gj5Var != null && ((!gj5Var.b1() || (gj5Var.b1() && hj5Var.e() == gj5Var.getUniqueId())) && (z = gj5Var.u0(hj5Var)) && hj5Var.f())) {
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
