package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public final class fwb<TResult> extends xvb<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public volatile boolean c;
    public TResult d;
    public Exception e;
    public List<tvb<TResult>> f;

    public fwb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.f = new ArrayList();
    }

    @Override // com.baidu.tieba.xvb
    public final xvb<TResult> a(uvb<TResult> uvbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uvbVar)) == null) {
            m(zvb.c(), uvbVar);
            return this;
        }
        return (xvb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xvb
    public final xvb<TResult> b(vvb vvbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vvbVar)) == null) {
            n(zvb.c(), vvbVar);
            return this;
        }
        return (xvb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xvb
    public final xvb<TResult> c(wvb<TResult> wvbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wvbVar)) == null) {
            o(zvb.c(), wvbVar);
            return this;
        }
        return (xvb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xvb
    public final Exception d() {
        InterceptResult invokeV;
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.a) {
                exc = this.e;
            }
            return exc;
        }
        return (Exception) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xvb
    public final TResult e() {
        InterceptResult invokeV;
        TResult tresult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.a) {
                if (this.e != null) {
                    throw new RuntimeException(this.e);
                }
                tresult = this.d;
            }
            return tresult;
        }
        return (TResult) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xvb
    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xvb
    public final boolean g() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.a) {
                z = this.b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xvb
    public final boolean h() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.a) {
                z = this.b && !f() && this.e == null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final xvb<TResult> i(tvb<TResult> tvbVar) {
        InterceptResult invokeL;
        boolean g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tvbVar)) == null) {
            synchronized (this.a) {
                g = g();
                if (!g) {
                    this.f.add(tvbVar);
                }
            }
            if (g) {
                tvbVar.onComplete(this);
            }
            return this;
        }
        return (xvb) invokeL.objValue;
    }

    public final void j(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return;
                }
                this.b = true;
                this.e = exc;
                this.a.notifyAll();
                p();
            }
        }
    }

    public final void k(TResult tresult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tresult) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return;
                }
                this.b = true;
                this.d = tresult;
                this.a.notifyAll();
                p();
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return false;
                }
                this.b = true;
                this.c = true;
                this.a.notifyAll();
                p();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final xvb<TResult> m(Executor executor, uvb<TResult> uvbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, executor, uvbVar)) == null) {
            i(new cwb(executor, uvbVar));
            return this;
        }
        return (xvb) invokeLL.objValue;
    }

    public final xvb<TResult> n(Executor executor, vvb vvbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, executor, vvbVar)) == null) {
            i(new dwb(executor, vvbVar));
            return this;
        }
        return (xvb) invokeLL.objValue;
    }

    public final xvb<TResult> o(Executor executor, wvb<TResult> wvbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, executor, wvbVar)) == null) {
            i(new ewb(executor, wvbVar));
            return this;
        }
        return (xvb) invokeLL.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this.a) {
                for (tvb<TResult> tvbVar : this.f) {
                    try {
                        tvbVar.onComplete(this);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
                this.f = null;
            }
        }
    }
}
