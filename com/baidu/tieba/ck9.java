package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class ck9 implements hq9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ ck9 a = new ck9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ ck9() {
    }

    @Override // com.baidu.tieba.hq9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? ll9.h(objectInput) : invokeL.objValue;
    }
}
