package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class al9 implements zq9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ al9 a = new al9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ al9() {
    }

    @Override // com.baidu.tieba.zq9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? dm9.c(objectInput) : invokeL.objValue;
    }
}
