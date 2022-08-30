package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ey5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class gy5 extends ey5<gy5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hy5 t;
    public float u;
    public boolean v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <K> gy5(K k, fy5<K> fy5Var) {
        super(k, fy5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k, fy5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(objArr2[0], (fy5) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = Float.MAX_VALUE;
        this.v = false;
    }

    @Override // com.baidu.tieba.ey5
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l();
            this.t.g(e());
            super.h();
        }
    }

    @Override // com.baidu.tieba.ey5
    public boolean j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (this.v) {
                float f = this.u;
                if (f != Float.MAX_VALUE) {
                    this.t.e(f);
                    this.u = Float.MAX_VALUE;
                }
                this.b = this.t.a();
                this.a = 0.0f;
                this.v = false;
                return true;
            }
            if (this.u != Float.MAX_VALUE) {
                this.t.a();
                long j2 = j / 2;
                ey5.i h = this.t.h(this.b, this.a, j2);
                this.t.e(this.u);
                this.u = Float.MAX_VALUE;
                ey5.i h2 = this.t.h(h.a, h.b, j2);
                this.b = h2.a;
                this.a = h2.b;
            } else {
                ey5.i h3 = this.t.h(this.b, this.a, j);
                this.b = h3.a;
                this.a = h3.b;
            }
            float max = Math.max(this.b, this.h);
            this.b = max;
            float min = Math.min(max, this.g);
            this.b = min;
            if (k(min, this.a)) {
                this.b = this.t.a();
                this.a = 0.0f;
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public boolean k(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? this.t.c(f, f2) : invokeCommon.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hy5 hy5Var = this.t;
            if (hy5Var != null) {
                double a = hy5Var.a();
                if (a <= this.g) {
                    if (a < this.h) {
                        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                    }
                    return;
                }
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            }
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public gy5 m(hy5 hy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hy5Var)) == null) {
            this.t = hy5Var;
            return this;
        }
        return (gy5) invokeL.objValue;
    }
}
