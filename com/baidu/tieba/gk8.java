package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.inputtool.GroupInputViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class gk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, xk8> a;
    public GroupInputViewController b;

    public final void c(xk8 xk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xk8Var) == null) {
        }
    }

    public gk8(GroupInputViewController groupInputViewController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupInputViewController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = groupInputViewController;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(@NonNull String str, @NonNull xk8 xk8Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, xk8Var) == null) {
            switch (str.hashCode()) {
                case -1885552185:
                    if (str.equals("key_keyboard")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1209909286:
                    if (str.equals("key_input_view")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -711264803:
                    if (str.equals("key_emotion_desk")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -710778660:
                    if (str.equals("key_emotion_tool")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 183469669:
                    if (str.equals("key_voice_tool")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        d(xk8Var);
                        return;
                    }
                    return;
                }
                e(xk8Var);
                return;
            }
            c(xk8Var);
        }
    }

    public void b(@NonNull String str, @NonNull xk8 xk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, xk8Var) == null) {
            if (this.a.containsKey(str)) {
                this.a.put(str, xk8Var);
            }
            a(str, xk8Var);
        }
    }

    public final void d(xk8 xk8Var) {
        GroupInputViewController groupInputViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xk8Var) == null) && (groupInputViewController = this.b) != null && groupInputViewController.J0() != null && !xk8Var.a()) {
            this.b.J0().l();
        }
    }

    public final void e(xk8 xk8Var) {
        GroupInputViewController groupInputViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, xk8Var) == null) && (groupInputViewController = this.b) != null && groupInputViewController.P0() != null && !xk8Var.a()) {
            this.b.P0().Y();
        }
    }
}
