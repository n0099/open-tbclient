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
/* loaded from: classes6.dex */
public class ik5 implements hk5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final hk5 c;

    @Override // com.baidu.tieba.hk5
    public void c(@NonNull Context context, long j, @Nullable zk5 zk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), zk5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.hk5
    public void d(@NonNull Context context, long j, @NonNull rk5 rk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), rk5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.hk5
    public void g(@NonNull sk5 sk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sk5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.hk5
    public void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull rk5 rk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, rk5Var}) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947856406, "Lcom/baidu/tieba/ik5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947856406, "Lcom/baidu/tieba/ik5;");
                return;
            }
        }
        d = new TreeSet<>(hk5.b);
    }

    public ik5(@NonNull hk5 hk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hk5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = hk5Var;
    }

    @Override // com.baidu.tieba.hk5
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.c.a(j);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void k(@NonNull sk5 sk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sk5Var) == null) {
            this.c.k(sk5Var);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void b(@NonNull Context context, @NonNull String str, long j, @NonNull ChatMsg chatMsg, boolean z, @NonNull xk5 xk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Long.valueOf(j), chatMsg, Boolean.valueOf(z), xk5Var}) == null) {
            this.c.b(context, str, j, chatMsg, z, xk5Var);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void e(@NonNull Context context, boolean z, int i, @NonNull wk5 wk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), wk5Var}) == null) {
            this.c.e(context, z, i, wk5Var);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void i(@NonNull Context context, long j, @NonNull List<ChatMsg> list, @NonNull uk5 uk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), list, uk5Var}) == null) {
            this.c.i(context, j, list, uk5Var);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void n(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull yk5 yk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Long.valueOf(j), chatMsg, yk5Var}) == null) {
            yk5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void f(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull rk5 rk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, rk5Var}) == null) {
            this.c.f(context, i, j, list, rk5Var);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull qk5 qk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, qk5Var}) == null) {
            qk5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.hk5
    public void q(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull qk5 qk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, qk5Var}) == null) {
            qk5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.hk5
    public void h(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable s45<List<? extends ChatMsg>> s45Var, @NonNull vk5 vk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), s45Var, vk5Var}) == null) {
            vk5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void l(@NonNull Context context, long j, @NonNull ok5 ok5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), ok5Var}) == null) {
            ok5Var.a(j, -1003, "", null);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void o(@NonNull Context context, long j, @NonNull rk5 rk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Long.valueOf(j), rk5Var}) == null) {
            this.c.o(context, j, rk5Var);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void r(@NonNull Context context, long j, @NonNull pk5 pk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Long.valueOf(j), pk5Var}) == null) {
            this.c.r(context, j, pk5Var);
        }
    }

    @Override // com.baidu.tieba.hk5
    public void p(@NonNull Context context, long j, long j2, @NonNull String str, long j3, int i, @NonNull tk5 tk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i), tk5Var}) == null) {
            this.c.p(context, j, j2, str, j3, i, tk5Var);
        }
    }
}
