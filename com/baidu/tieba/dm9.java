package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class dm9 implements is9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ dm9 a = new dm9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ dm9() {
    }

    @Override // com.baidu.tieba.is9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? mn9.h(objectInput) : invokeL.objValue;
    }
}
