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
public class ih5 implements hh5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final hh5 c;

    @Override // com.baidu.tieba.hh5
    public void c(@NonNull Context context, @NonNull List<Long> list, @NonNull rh5 rh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, rh5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.hh5
    public void e(@NonNull sh5 sh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sh5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947853523, "Lcom/baidu/tieba/ih5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947853523, "Lcom/baidu/tieba/ih5;");
                return;
            }
        }
        d = new TreeSet<>(hh5.b);
    }

    public ih5(@NonNull hh5 hh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hh5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = hh5Var;
    }

    @Override // com.baidu.tieba.hh5
    public void g(@NonNull sh5 sh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sh5Var) == null) {
            this.c.g(sh5Var);
        }
    }

    @Override // com.baidu.tieba.hh5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull rh5 rh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, rh5Var) == null) {
            this.c.a(context, list, rh5Var);
        }
    }

    @Override // com.baidu.tieba.hh5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.hh5
    public void b(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable uh5 uh5Var, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), uh5Var, th5Var}) == null) {
            th5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.hh5
    public void d(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull oh5 oh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, list, oh5Var) == null) {
            for (Long l : list) {
                oh5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.hh5
    public void f(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull ph5 ph5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, list, ph5Var) == null) {
            this.c.f(context, str, list, ph5Var);
        }
    }

    @Override // com.baidu.tieba.hh5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, vh5Var}) == null) {
            vh5Var.onSendMessageResult(-1003, null);
        }
    }
}
