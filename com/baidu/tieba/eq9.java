package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class eq9 implements dw9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ eq9 a = new eq9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ eq9() {
    }

    @Override // com.baidu.tieba.dw9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? hr9.c(objectInput) : invokeL.objValue;
    }
}
