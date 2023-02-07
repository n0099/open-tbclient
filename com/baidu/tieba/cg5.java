package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
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
public class cg5 implements bg5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final bg5 c;

    @Override // com.baidu.tieba.bg5
    public void b(@NonNull Context context, @NonNull List<Long> list, @NonNull gg5 gg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, gg5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.bg5
    public void d(@NonNull hg5 hg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hg5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947673816, "Lcom/baidu/tieba/cg5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947673816, "Lcom/baidu/tieba/cg5;");
                return;
            }
        }
        d = new TreeSet<>(bg5.b);
    }

    public cg5(@NonNull bg5 bg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bg5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = bg5Var;
    }

    @Override // com.baidu.tieba.bg5
    public void g(@NonNull hg5 hg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hg5Var) == null) {
            this.c.g(hg5Var);
        }
    }

    @Override // com.baidu.tieba.bg5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull gg5 gg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, gg5Var) == null) {
            this.c.a(context, list, gg5Var);
        }
    }

    @Override // com.baidu.tieba.bg5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.bg5
    public void c(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull dg5 dg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, list, dg5Var) == null) {
            for (Long l : list) {
                dg5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.bg5
    public void e(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull eg5 eg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, list, eg5Var) == null) {
            this.c.e(context, str, list, eg5Var);
        }
    }

    @Override // com.baidu.tieba.bg5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull jg5 jg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, jg5Var}) == null) {
            jg5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.bg5
    public void f(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @NonNull ig5 ig5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), ig5Var}) == null) {
            ig5Var.a(-1003, "", d);
        }
    }
}
