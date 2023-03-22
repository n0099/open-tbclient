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
public class dg5 implements cg5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final cg5 c;

    @Override // com.baidu.tieba.cg5
    public void c(@NonNull Context context, @NonNull List<Long> list, @NonNull mg5 mg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, mg5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.cg5
    public void e(@NonNull ng5 ng5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ng5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947703607, "Lcom/baidu/tieba/dg5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947703607, "Lcom/baidu/tieba/dg5;");
                return;
            }
        }
        d = new TreeSet<>(cg5.b);
    }

    public dg5(@NonNull cg5 cg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cg5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = cg5Var;
    }

    @Override // com.baidu.tieba.cg5
    public void g(@NonNull ng5 ng5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ng5Var) == null) {
            this.c.g(ng5Var);
        }
    }

    @Override // com.baidu.tieba.cg5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull mg5 mg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, mg5Var) == null) {
            this.c.a(context, list, mg5Var);
        }
    }

    @Override // com.baidu.tieba.cg5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.cg5
    public void b(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable pg5 pg5Var, @NonNull og5 og5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), pg5Var, og5Var}) == null) {
            og5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.cg5
    public void d(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull jg5 jg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, list, jg5Var) == null) {
            for (Long l : list) {
                jg5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.cg5
    public void f(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull kg5 kg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, list, kg5Var) == null) {
            this.c.f(context, str, list, kg5Var);
        }
    }

    @Override // com.baidu.tieba.cg5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull qg5 qg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, qg5Var}) == null) {
            qg5Var.onSendMessageResult(-1003, null);
        }
    }
}
