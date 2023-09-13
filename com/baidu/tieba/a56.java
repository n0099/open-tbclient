package com.baidu.tieba;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public abstract class a56 extends ClickableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a56() {
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

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ds) == null) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setColor(TbadkApplication.getInst().getResources().getColor(R.color.CAM_X0303));
        }
    }
}
