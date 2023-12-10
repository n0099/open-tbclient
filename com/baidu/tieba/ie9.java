package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.p05;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ie9 {
    public static /* synthetic */ Interceptable $ic;
    public static final ie9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947850764, "Lcom/baidu/tieba/ie9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947850764, "Lcom/baidu/tieba/ie9;");
                return;
            }
        }
        a = new ie9();
    }

    public ie9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final void b(Function1 switchVoiceMode, n05 builder, p05 p05Var, int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{switchVoiceMode, builder, p05Var, Integer.valueOf(i), view2}) == null) {
            Intrinsics.checkNotNullParameter(switchVoiceMode, "$switchVoiceMode");
            Intrinsics.checkNotNullParameter(builder, "$builder");
            switchVoiceMode.invoke(Integer.valueOf(i));
            builder.dismiss();
        }
    }

    public final void a(TbPageContext<?> context, final Function1<? super Integer, Unit> switchVoiceMode) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, switchVoiceMode) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(switchVoiceMode, "switchVoiceMode");
            ArrayList arrayList = new ArrayList();
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                string = TbadkCoreApplication.getInst().getString(R.string.group_close_receiver);
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.group_open_receiver);
            }
            arrayList.add(string);
            final n05 n05Var = new n05(context);
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                n05Var.i(null, (String[]) array, new p05.f() { // from class: com.baidu.tieba.ee9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.p05.f
                    public final void E0(p05 p05Var, int i, View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                            ie9.b(Function1.this, n05Var, p05Var, i, view2);
                        }
                    }
                });
                n05Var.l();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }
}
