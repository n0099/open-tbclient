package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class aj0 implements op0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<lp0> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947616962, "Lcom/baidu/tieba/aj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947616962, "Lcom/baidu/tieba/aj0;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new ni0());
        a.add(new to0());
        a.add(new zi0());
        dj0 dj0Var = new dj0();
        dl1<lp0> dl1Var = dj0Var.a;
        if (dl1Var != null && !x31.g(dl1Var.getList())) {
            a.addAll(dj0Var.a.getList());
        }
    }

    public aj0() {
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

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !a.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.op0
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle) != null) || !f()) {
            return;
        }
        for (lp0 lp0Var : a) {
            lp0Var.onActivityCreated(activity, bundle);
        }
    }

    @Override // com.baidu.tieba.op0
    public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, activity, bundle) != null) || !f()) {
            return;
        }
        for (lp0 lp0Var : a) {
            lp0Var.onActivitySaveInstanceState(activity, bundle);
        }
    }

    @Override // com.baidu.tieba.op0
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) != null) || !f()) {
            return;
        }
        for (lp0 lp0Var : a) {
            lp0Var.onActivityDestroyed(activity);
        }
    }

    @Override // com.baidu.tieba.op0
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, activity) != null) || !f()) {
            return;
        }
        for (lp0 lp0Var : a) {
            lp0Var.onActivityPaused(activity);
        }
    }

    @Override // com.baidu.tieba.op0
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, activity) != null) || !f()) {
            return;
        }
        for (lp0 lp0Var : a) {
            lp0Var.onActivityResumed(activity);
        }
    }

    @Override // com.baidu.tieba.op0
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, activity) != null) || !f()) {
            return;
        }
        for (lp0 lp0Var : a) {
            lp0Var.onActivityStarted(activity);
        }
    }

    @Override // com.baidu.tieba.op0
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, activity) != null) || !f()) {
            return;
        }
        for (lp0 lp0Var : a) {
            lp0Var.onActivityStopped(activity);
        }
    }

    @Override // com.baidu.tieba.op0
    public void onBackgroundToForeground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) != null) || !f()) {
            return;
        }
        for (lp0 lp0Var : a) {
            lp0Var.onBackgroundToForeground(activity);
        }
    }

    @Override // com.baidu.tieba.op0
    public void onForegroundToBackground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, activity) != null) || !f()) {
            return;
        }
        for (lp0 lp0Var : a) {
            lp0Var.onForegroundToBackground(activity);
        }
    }
}
