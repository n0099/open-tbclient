package com.baidu.tieba;

import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class af0 implements Cloneable, Comparable<af0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EGLContext a;
    public xe0 b;
    public we0 c;
    public ue0 d;
    public ye0 e;
    public boolean f;
    public te0 g;
    public ze0 h;
    public int i;
    public boolean j;

    public af0(EGLContext eGLContext, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eGLContext;
        this.i = i;
        this.j = z;
        this.b = new xe0();
        this.c = new we0();
        this.d = new ve0();
        this.e = new ye0();
        this.f = false;
        this.g = null;
        this.h = new ze0();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public af0 clone() {
        af0 af0Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                af0Var = (af0) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                af0Var = null;
            }
            if (af0Var != null) {
                af0Var.m(this.e.clone());
                af0Var.q(this.h.clone());
            }
            return af0Var;
        }
        return (af0) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(af0 af0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, af0Var)) == null) {
            if (this.i < af0Var.d()) {
                return -1;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public void m(ye0 ye0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ye0Var) == null) {
            this.e = ye0Var;
        }
    }

    public void n(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eGLContext) == null) {
            this.a = eGLContext;
        }
    }

    public void p(te0 te0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, te0Var) == null) {
            this.g = te0Var;
        }
    }

    public void q(ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ze0Var) == null) {
            this.h = ze0Var;
        }
    }

    public void r(xe0 xe0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, xe0Var) == null) {
            this.b = xe0Var;
        }
    }

    public ye0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (ye0) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public ue0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (ue0) invokeV.objValue;
    }

    public EGLContext f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (EGLContext) invokeV.objValue;
    }

    public te0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (te0) invokeV.objValue;
    }

    public ze0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return (ze0) invokeV.objValue;
    }

    public we0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (we0) invokeV.objValue;
    }

    public xe0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (xe0) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }
}
