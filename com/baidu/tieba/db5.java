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
public class db5 implements cb5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final cb5 c;

    @Override // com.baidu.tieba.cb5
    public void b(@NonNull Context context, @NonNull List<Long> list, @NonNull hb5 hb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, hb5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.cb5
    public void d(@NonNull ib5 ib5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ib5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947698802, "Lcom/baidu/tieba/db5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947698802, "Lcom/baidu/tieba/db5;");
                return;
            }
        }
        d = new TreeSet<>(cb5.b);
    }

    public db5(@NonNull cb5 cb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cb5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = cb5Var;
    }

    @Override // com.baidu.tieba.cb5
    public void g(@NonNull ib5 ib5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ib5Var) == null) {
            this.c.g(ib5Var);
        }
    }

    @Override // com.baidu.tieba.cb5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull hb5 hb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, hb5Var) == null) {
            this.c.a(context, list, hb5Var);
        }
    }

    @Override // com.baidu.tieba.cb5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.cb5
    public void c(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull eb5 eb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, list, eb5Var) == null) {
            for (Long l : list) {
                eb5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.cb5
    public void e(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull fb5 fb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, list, fb5Var) == null) {
            this.c.e(context, str, list, fb5Var);
        }
    }

    @Override // com.baidu.tieba.cb5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull kb5 kb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, kb5Var}) == null) {
            kb5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.cb5
    public void f(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @NonNull jb5 jb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), jb5Var}) == null) {
            jb5Var.a(-1003, "", d);
        }
    }
}
