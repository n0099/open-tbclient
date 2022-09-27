package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class c32 implements b32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b32> a;

    public c32() {
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

    @Override // com.baidu.tieba.b32
    public void a() {
        List<b32> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b32 b32Var : this.a) {
            b32Var.a();
        }
    }

    @Override // com.baidu.tieba.b32
    public void b() {
        List<b32> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b32 b32Var : this.a) {
            b32Var.b();
        }
    }

    @Override // com.baidu.tieba.b32
    public void c() {
        List<b32> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (b32 b32Var : this.a) {
            b32Var.c();
        }
    }

    public void d(@NonNull b32 b32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b32Var) == null) {
            this.a.add(b32Var);
        }
    }

    public void e(@NonNull b32 b32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b32Var) == null) {
            this.a.remove(b32Var);
        }
    }
}
