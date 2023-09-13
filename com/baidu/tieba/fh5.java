package com.baidu.tieba;

import androidx.annotation.CallSuper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public abstract class fh5 implements IInvokeCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fh5() {
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

    /* renamed from: onResult$lambda-0  reason: not valid java name */
    public static final void m134onResult$lambda0(String toastText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, toastText) == null) {
            Intrinsics.checkNotNullParameter(toastText, "$toastText");
            BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), toastText);
        }
    }

    @Override // com.baidu.nps.main.invoke.IInvokeCallback
    @CallSuper
    public void onResult(int i, final String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, obj) == null) && i == -1400) {
            if (str == null) {
                str = "插件修复中...";
            }
            mg.g(new Runnable() { // from class: com.baidu.tieba.bh5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fh5.m134onResult$lambda0(str);
                    }
                }
            });
        }
    }
}
