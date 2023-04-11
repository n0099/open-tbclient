package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public class hh5 implements gh5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final gh5 c;

    @Override // com.baidu.tieba.gh5
    public void c(@NonNull Context context, @NonNull List<Long> list, @NonNull qh5 qh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, qh5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.gh5
    public void e(@NonNull rh5 rh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rh5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947823732, "Lcom/baidu/tieba/hh5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947823732, "Lcom/baidu/tieba/hh5;");
                return;
            }
        }
        d = new TreeSet<>(gh5.b);
    }

    public hh5(@NonNull gh5 gh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gh5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = gh5Var;
    }

    @Override // com.baidu.tieba.gh5
    public void g(@NonNull rh5 rh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rh5Var) == null) {
            this.c.g(rh5Var);
        }
    }

    @Override // com.baidu.tieba.gh5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull qh5 qh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, qh5Var) == null) {
            this.c.a(context, list, qh5Var);
        }
    }

    @Override // com.baidu.tieba.gh5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.gh5
    public void b(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable th5 th5Var, @NonNull sh5 sh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), th5Var, sh5Var}) == null) {
            sh5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.gh5
    public void d(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull nh5 nh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, list, nh5Var) == null) {
            for (Long l : list) {
                nh5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.gh5
    public void f(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull oh5 oh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, list, oh5Var) == null) {
            this.c.f(context, str, list, oh5Var);
        }
    }

    @Override // com.baidu.tieba.gh5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull uh5 uh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, uh5Var}) == null) {
            uh5Var.onSendMessageResult(-1003, null);
        }
    }
}
