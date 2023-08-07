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
/* loaded from: classes5.dex */
public class bn5 implements an5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final an5 c;

    @Override // com.baidu.tieba.an5
    public void c(@NonNull Context context, long j, @Nullable sn5 sn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), sn5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public void d(@NonNull Context context, long j, @NonNull kn5 kn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), kn5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public void g(@NonNull ln5 ln5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ln5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull kn5 kn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, kn5Var}) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947650752, "Lcom/baidu/tieba/bn5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947650752, "Lcom/baidu/tieba/bn5;");
                return;
            }
        }
        d = new TreeSet<>(an5.b);
    }

    public bn5(@NonNull an5 an5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {an5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = an5Var;
    }

    @Override // com.baidu.tieba.an5
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.c.a(j);
        }
    }

    @Override // com.baidu.tieba.an5
    public void k(@NonNull ln5 ln5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ln5Var) == null) {
            this.c.k(ln5Var);
        }
    }

    @Override // com.baidu.tieba.an5
    public void b(@NonNull Context context, @NonNull String str, long j, @NonNull ChatMsg chatMsg, boolean z, @NonNull qn5 qn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Long.valueOf(j), chatMsg, Boolean.valueOf(z), qn5Var}) == null) {
            this.c.b(context, str, j, chatMsg, z, qn5Var);
        }
    }

    @Override // com.baidu.tieba.an5
    public void e(@NonNull Context context, boolean z, int i, @NonNull pn5 pn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), pn5Var}) == null) {
            this.c.e(context, z, i, pn5Var);
        }
    }

    @Override // com.baidu.tieba.an5
    public void i(@NonNull Context context, long j, @NonNull List<ChatMsg> list, @NonNull nn5 nn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), list, nn5Var}) == null) {
            this.c.i(context, j, list, nn5Var);
        }
    }

    @Override // com.baidu.tieba.an5
    public void n(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull rn5 rn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Long.valueOf(j), chatMsg, rn5Var}) == null) {
            rn5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.an5
    public void f(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull kn5 kn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, kn5Var}) == null) {
            this.c.f(context, i, j, list, kn5Var);
        }
    }

    @Override // com.baidu.tieba.an5
    public void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull jn5 jn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, jn5Var}) == null) {
            jn5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.an5
    public void q(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull jn5 jn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, jn5Var}) == null) {
            jn5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.an5
    public void h(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable w85<List<? extends ChatMsg>> w85Var, @NonNull on5 on5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), w85Var, on5Var}) == null) {
            on5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.an5
    public void l(@NonNull Context context, long j, @NonNull hn5 hn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), hn5Var}) == null) {
            hn5Var.a(j, -1003, "", null);
        }
    }

    @Override // com.baidu.tieba.an5
    public void o(@NonNull Context context, long j, @NonNull kn5 kn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Long.valueOf(j), kn5Var}) == null) {
            this.c.o(context, j, kn5Var);
        }
    }

    @Override // com.baidu.tieba.an5
    public void r(@NonNull Context context, long j, @NonNull in5 in5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Long.valueOf(j), in5Var}) == null) {
            this.c.r(context, j, in5Var);
        }
    }

    @Override // com.baidu.tieba.an5
    public void p(@NonNull Context context, long j, long j2, @NonNull String str, long j3, int i, @NonNull mn5 mn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i), mn5Var}) == null) {
            this.c.p(context, j, j2, str, j3, i, mn5Var);
        }
    }
}
