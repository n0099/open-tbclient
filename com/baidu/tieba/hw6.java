package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tieba.easteregg.EasterEggAdController;
import com.baidu.tieba.easteregg.data.EasterEggAdData;
import com.baidu.tieba.easteregg.data.EasterEggAdDataHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hw6 extends m15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hw6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.m15
    public void a(Context context, a15 data) {
        Unit unit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if ((context instanceof Activity) && (context instanceof j0b)) {
                EasterEggAdData b = EasterEggAdDataHolder.b.a().b();
                if (b != null) {
                    new EasterEggAdController((Activity) context).o(b);
                    YunDialogManager.markShowingDialogName("easterEgg");
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    YunDialogManager.unMarkShowingDialogName("easterEgg");
                    return;
                }
                return;
            }
            YunDialogManager.unMarkShowingDialogName("easterEgg");
        }
    }
}
