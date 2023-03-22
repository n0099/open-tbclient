package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class ej6 extends mi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ej6(hi6 context) {
        super(context, r3, null, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((hi6) objArr2[0], (b0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        b0 b = b0.i(ri6.class).b();
        Intrinsics.checkNotNullExpressionValue(b, "one(ActionComponent::class.java).get()");
    }

    @Override // com.baidu.tieba.mi6
    public void l(y entity, float f) {
        ci6 a;
        ri6 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            oi6 b = mj6.b(entity);
            if (b == null || (a = b.a()) == null || (a2 = mj6.a(entity)) == null) {
                return;
            }
            if (lj6.b(this) >= a.e().l()) {
                a2.h(true);
                a2.c(lj6.b(this) - a.e().l());
                return;
            }
            a2.h(false);
        }
    }
}
