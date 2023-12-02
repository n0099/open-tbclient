package com.baidu.tieba;

import android.view.LayoutInflater;
import com.baidu.tieba.zk4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class al4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, bl4 bl4Var) {
        zk4.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, bl4Var) == null) {
            if (bl4Var != null) {
                aVar = new zk4.a(bl4Var);
            } else {
                aVar = null;
            }
            layoutInflater.setFactory2(aVar);
        }
    }
}
