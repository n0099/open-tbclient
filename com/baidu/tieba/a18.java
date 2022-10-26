package com.baidu.tieba;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a18 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ a18 a = new a18();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ a18() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            b18.c(view2);
        }
    }
}
