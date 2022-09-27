package com.baidu.tieba;

import android.view.LayoutInflater;
import com.baidu.tieba.bi4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ci4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, di4 di4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, di4Var) == null) {
            layoutInflater.setFactory2(di4Var != null ? new bi4.a(di4Var) : null);
        }
    }
}
