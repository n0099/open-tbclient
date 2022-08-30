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
/* loaded from: classes3.dex */
public class ae2 implements yd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yd2> a;

    public ae2() {
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

    @Override // com.baidu.tieba.yd2
    public void a() {
        List<yd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (yd2 yd2Var : this.a) {
            if (yd2Var != null) {
                yd2Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.yd2
    public void b() {
        List<yd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (yd2 yd2Var : this.a) {
            yd2Var.b();
        }
    }

    @Override // com.baidu.tieba.yd2
    public void c() {
        List<yd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (yd2 yd2Var : this.a) {
            yd2Var.c();
        }
    }

    @Override // com.baidu.tieba.yd2
    public void d() {
        List<yd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (yd2 yd2Var : this.a) {
            yd2Var.d();
        }
    }

    @Override // com.baidu.tieba.yd2
    public void e() {
        List<yd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (yd2 yd2Var : this.a) {
            yd2Var.e();
        }
    }

    @Override // com.baidu.tieba.yd2
    public void f() {
        List<yd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (yd2 yd2Var : this.a) {
            yd2Var.f();
        }
    }

    @Override // com.baidu.tieba.yd2
    public void g() {
        List<yd2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (yd2 yd2Var : this.a) {
            yd2Var.g();
        }
    }

    public void h(@NonNull yd2 yd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, yd2Var) == null) {
            this.a.add(yd2Var);
        }
    }

    public void i(@NonNull yd2 yd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yd2Var) == null) {
            this.a.remove(yd2Var);
        }
    }

    @Override // com.baidu.tieba.yd2
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            List<yd2> list = this.a;
            if (list == null || list.size() <= 0) {
                return false;
            }
            while (true) {
                for (yd2 yd2Var : this.a) {
                    z = z || yd2Var.onKeyDown(i, keyEvent);
                }
                return z;
            }
        }
        return invokeIL.booleanValue;
    }
}
