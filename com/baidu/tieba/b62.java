package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class b62 implements a62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a62> a;

    public b62() {
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

    @Override // com.baidu.tieba.a62
    public void a() {
        List<a62> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (a62 a62Var : this.a) {
                a62Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.a62
    public void b() {
        List<a62> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (a62 a62Var : this.a) {
                a62Var.b();
            }
        }
    }

    @Override // com.baidu.tieba.a62
    public void c() {
        List<a62> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (a62 a62Var : this.a) {
                a62Var.c();
            }
        }
    }

    public void d(@NonNull a62 a62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, a62Var) == null) {
            this.a.add(a62Var);
        }
    }

    public void e(@NonNull a62 a62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a62Var) == null) {
            this.a.remove(a62Var);
        }
    }
}
