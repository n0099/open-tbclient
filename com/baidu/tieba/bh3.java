package com.baidu.tieba;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bh3 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    public bh3() {
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                View view3 = this.a;
                if (view3 == null) {
                    view2.setAlpha(sm2.M().a() ? 0.5f : 0.2f);
                    return false;
                }
                view3.setAlpha(sm2.M().a() ? 0.5f : 0.2f);
                return false;
            } else if (action != 2) {
                View view4 = this.a;
                if (view4 == null) {
                    view2.setAlpha(1.0f);
                    return false;
                }
                view4.setAlpha(1.0f);
                return false;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
