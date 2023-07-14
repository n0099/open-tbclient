package com.baidu.tieba;

import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h16 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Scroller a;
    public final e16 b;
    public int c;
    public int d;

    public h16(e16 e16Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e16Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = e16Var;
        this.a = new Scroller(e16Var.getContext(), new LinearInterpolator());
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !this.a.isFinished();
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.abortAnimation();
        }
    }

    public void b(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
            c(0, 0, i, i2, i3);
        }
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.a.startScroll(i, i2, i3, i4, i5);
            this.b.removeCallbacks(this);
            this.b.post(this);
            this.c = i;
            this.d = i2;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.a.computeScrollOffset()) {
                int currX = this.a.getCurrX();
                int currY = this.a.getCurrY();
                this.b.b(this.c, this.d, currX, currY);
                this.b.post(this);
                this.c = currX;
                this.d = currY;
                return;
            }
            this.b.removeCallbacks(this);
            this.b.a();
        }
    }
}
