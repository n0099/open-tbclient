package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class fq9 implements ew9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ fq9 a = new fq9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ fq9() {
    }

    @Override // com.baidu.tieba.ew9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? ir9.c(objectInput) : invokeL.objValue;
    }
}
