package com.baidu.tieba;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class cp2 implements ap2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ap2> a;

    public cp2() {
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
        this.a = new CopyOnWriteArrayList();
    }

    @Override // com.baidu.tieba.ap2
    public void b() {
        List<ap2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ap2 ap2Var : this.a) {
                ap2Var.b();
            }
        }
    }

    @Override // com.baidu.tieba.ap2
    public void c() {
        List<ap2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ap2 ap2Var : this.a) {
                ap2Var.c();
            }
        }
    }

    @Override // com.baidu.tieba.ap2
    public void d() {
        List<ap2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ap2 ap2Var : this.a) {
                ap2Var.d();
            }
        }
    }

    @Override // com.baidu.tieba.ap2
    public void e() {
        List<ap2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ap2 ap2Var : this.a) {
                ap2Var.e();
            }
        }
    }

    @Override // com.baidu.tieba.ap2
    public void f() {
        List<ap2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ap2 ap2Var : this.a) {
                ap2Var.f();
            }
        }
    }

    @Override // com.baidu.tieba.ap2
    public void g() {
        List<ap2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ap2 ap2Var : this.a) {
                ap2Var.g();
            }
        }
    }

    @Override // com.baidu.tieba.ap2
    public void a() {
        List<ap2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ap2 ap2Var : this.a) {
                if (ap2Var != null) {
                    ap2Var.a();
                }
            }
        }
    }

    public void h(@NonNull ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ap2Var) == null) {
            this.a.add(ap2Var);
        }
    }

    public void i(@NonNull ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ap2Var) == null) {
            this.a.remove(ap2Var);
        }
    }

    @Override // com.baidu.tieba.ap2
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            List<ap2> list = this.a;
            if (list == null || list.size() <= 0) {
                return false;
            }
            while (true) {
                boolean z = false;
                for (ap2 ap2Var : this.a) {
                    boolean onKeyDown = ap2Var.onKeyDown(i, keyEvent);
                    if (z || onKeyDown) {
                        z = true;
                    }
                }
                return z;
            }
        }
        return invokeIL.booleanValue;
    }
}
