package com.baidu.tieba;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b08 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ b08 a = new b08();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ b08() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            c08.c(view2);
        }
    }
}
