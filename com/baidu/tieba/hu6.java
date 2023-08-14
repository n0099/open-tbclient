package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qu6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public abstract class hu6 implements ju6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qu6 a;
    public final qu6.a b;

    public hu6(qu6 retainer, qu6.a locator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {retainer, locator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(retainer, "retainer");
        Intrinsics.checkNotNullParameter(locator, "locator");
        this.a = retainer;
        this.b = locator;
    }

    @Override // com.baidu.tieba.ju6
    public void a(vs6 item, long j, vu6 displayer, ps6 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{item, Long.valueOf(j), displayer, config}) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            this.b.a(item, j, displayer, config);
        }
    }

    @Override // com.baidu.tieba.ju6
    public void b(vs6 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.a.b(item);
        }
    }

    @Override // com.baidu.tieba.ju6
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.update(i, i2);
        }
    }

    @Override // com.baidu.tieba.ju6
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.clear();
        }
    }

    @Override // com.baidu.tieba.ju6
    public boolean d(vs6 item, long j, vu6 displayer, ps6 config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{item, Long.valueOf(j), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            item.f().B(this.a.a(item, j, displayer, config));
            return item.f().p();
        }
        return invokeCommon.booleanValue;
    }
}
