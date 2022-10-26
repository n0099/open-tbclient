package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fx0 extends dr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gx0 O;
    public hx0 P;
    public boolean Q;
    public int R;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ fx0 b;

        public a(fx0 fx0Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fx0Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i == -2 || i == -1) {
                    this.b.f0(2);
                    this.b.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx0(uu0 uu0Var, Context context) {
        super(uu0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uu0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((uu0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Q = false;
        this.R = 22;
    }

    @Override // com.baidu.tieba.br0
    public pw0 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.A();
        }
        return (pw0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr0, com.baidu.tieba.br0
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.R;
        }
        return invokeV.intValue;
    }

    public final boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdVideoSeries bdVideoSeries = this.I;
            if (bdVideoSeries != null && !TextUtils.isEmpty(bdVideoSeries.getVid()) && this.I.getVid().contains(LaunchStatsUtils.AD)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.u = 0;
        }
    }

    @Override // com.baidu.tieba.cr0, com.baidu.tieba.br0
    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            pw0 pw0Var = this.b;
            if (pw0Var != null && pw0Var.getContentView() != null) {
                this.b.getContentView().setVisibility(0);
            }
            if (TextUtils.isEmpty(this.a.b)) {
                return;
            }
            l();
        }
    }

    @Override // com.baidu.tieba.cr0, com.baidu.tieba.or0, com.baidu.tieba.br0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.P();
        }
    }

    @Override // com.baidu.tieba.br0
    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (hz0.c(m()) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.br0
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.a();
        }
    }

    @Override // com.baidu.tieba.br0
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.k0();
        }
    }

    @Override // com.baidu.tieba.cr0, com.baidu.tieba.br0
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.l0();
        }
    }

    @Override // com.baidu.tieba.cr0
    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.J;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.br0, com.baidu.tieba.dw0
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrepared();
            ez0.b("AdMiniVideoPlayer", "onPrepared position:" + this.a.d);
        }
    }

    @Override // com.baidu.tieba.br0
    public int r() {
        InterceptResult invokeV;
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int r = super.r();
            if (r == 0 && (o1 = o1()) != null) {
                String selectedVideoTotalLength = o1.getSelectedVideoTotalLength();
                if (!TextUtils.isEmpty(selectedVideoTotalLength)) {
                    return az0.c(selectedVideoTotalLength);
                }
                return r;
            }
            return r;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cr0
    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.Q;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cr0
    public void A1(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
            this.P.L(8);
            J1();
            this.O.M(true);
            this.O.N(8);
            super.B1(bdVideoSeries, true);
        }
    }

    @Override // com.baidu.tieba.cr0, com.baidu.tieba.br0
    public void I0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            d(zm0.b());
            d(new dy0(context));
        }
    }

    @Override // com.baidu.tieba.br0
    public void d0(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (activity = getActivity()) != null && !X()) {
            activity.runOnUiThread(new a(this, i));
        }
    }

    @Override // com.baidu.tieba.or0, com.baidu.tieba.br0
    public void G0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            gx0 gx0Var = new gx0();
            this.O = gx0Var;
            b(gx0Var);
            hx0 hx0Var = new hx0();
            this.P = hx0Var;
            b(hx0Var);
            b(new ix0());
            v().setClickable(false);
        }
    }

    @Override // com.baidu.tieba.cr0, com.baidu.tieba.br0
    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            w1();
            gx0 gx0Var = this.O;
            if (gx0Var != null) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                gx0Var.M(z);
            }
            if (I1()) {
                if (!W() && !a0()) {
                    super.f0(i);
                    return;
                }
                return;
            }
            super.f0(i);
        }
    }

    @Override // com.baidu.tieba.cr0, com.baidu.tieba.br0
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            w1();
            if (this.b != null) {
                R0().stop(w());
                q().i();
                H().j(w());
                this.b.t0();
                ku0.a(getActivity(), false);
            }
            cu0 cu0Var = this.A;
            if (cu0Var != null) {
                cu0Var.cancel();
            }
            gx0 gx0Var = this.O;
            if (gx0Var != null) {
                gx0Var.L();
            }
        }
    }

    @Override // com.baidu.tieba.cr0, com.baidu.tieba.br0, com.baidu.tieba.dw0
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            z().g();
            R0().end(w());
            y().p(C(), p(), r());
            cu0 cu0Var = this.A;
            if (cu0Var != null) {
                cu0Var.cancel();
            }
        }
    }

    @Override // com.baidu.tieba.cr0, com.baidu.tieba.br0, com.baidu.tieba.dw0
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i, i2, obj)) == null) {
            super.onError(i, i2, obj);
            return true;
        }
        return invokeIIL.booleanValue;
    }
}
