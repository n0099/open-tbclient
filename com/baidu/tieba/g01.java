package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g01 extends eu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h01 O;
    public i01 P;
    public boolean Q;
    public int R;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ g01 b;

        public a(g01 g01Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g01Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g01Var;
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
    public g01(@NonNull vx0 vx0Var, @Nullable Context context) {
        super(vx0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vx0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((vx0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Q = false;
        this.R = 22;
    }

    @Override // com.baidu.tieba.cu0
    @Nullable
    public qz0 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.A();
        }
        return (qz0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.du0, com.baidu.tieba.cu0
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
            if (bdVideoSeries != null && !TextUtils.isEmpty(bdVideoSeries.getVid()) && this.I.getVid().contains("ad")) {
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

    @Override // com.baidu.tieba.du0, com.baidu.tieba.cu0
    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var != null && qz0Var.getContentView() != null) {
                this.b.getContentView().setVisibility(0);
            }
            if (TextUtils.isEmpty(this.a.b)) {
                return;
            }
            l();
        }
    }

    @Override // com.baidu.tieba.du0, com.baidu.tieba.pu0, com.baidu.tieba.cu0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.P();
        }
    }

    @Override // com.baidu.tieba.cu0
    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (i21.c(m()) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cu0
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.a();
        }
    }

    @Override // com.baidu.tieba.cu0
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.k0();
        }
    }

    @Override // com.baidu.tieba.du0, com.baidu.tieba.cu0
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.l0();
        }
    }

    @Override // com.baidu.tieba.du0
    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.J;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cu0, com.baidu.tieba.ez0
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrepared();
            f21.b("AdMiniVideoPlayer", "onPrepared position:" + this.a.d);
        }
    }

    @Override // com.baidu.tieba.cu0
    public int r() {
        InterceptResult invokeV;
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int r = super.r();
            if (r == 0 && (o1 = o1()) != null) {
                String selectedVideoTotalLength = o1.getSelectedVideoTotalLength();
                if (!TextUtils.isEmpty(selectedVideoTotalLength)) {
                    return b21.c(selectedVideoTotalLength);
                }
                return r;
            }
            return r;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.du0
    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.Q;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.du0
    public void A1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
            this.P.M(8);
            J1();
            this.O.N(true);
            this.O.O(8);
            super.B1(bdVideoSeries, true);
        }
    }

    @Override // com.baidu.tieba.du0, com.baidu.tieba.cu0
    public void I0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            d(co0.b());
            d(new e11(context));
        }
    }

    @Override // com.baidu.tieba.cu0
    public void d0(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (activity = getActivity()) != null && !X()) {
            activity.runOnUiThread(new a(this, i));
        }
    }

    @Override // com.baidu.tieba.pu0, com.baidu.tieba.cu0
    public void G0(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            h01 h01Var = new h01();
            this.O = h01Var;
            b(h01Var);
            i01 i01Var = new i01();
            this.P = i01Var;
            b(i01Var);
            b(new j01());
            v().setClickable(false);
        }
    }

    @Override // com.baidu.tieba.du0, com.baidu.tieba.cu0
    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            w1();
            h01 h01Var = this.O;
            if (h01Var != null) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                h01Var.N(z);
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

    @Override // com.baidu.tieba.du0, com.baidu.tieba.cu0
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            w1();
            if (this.b != null) {
                R0().stop(w());
                q().i();
                H().j(w());
                this.b.v0();
                lx0.a(getActivity(), false);
            }
            dx0 dx0Var = this.A;
            if (dx0Var != null) {
                dx0Var.cancel();
            }
            h01 h01Var = this.O;
            if (h01Var != null) {
                h01Var.M();
            }
        }
    }

    @Override // com.baidu.tieba.du0, com.baidu.tieba.cu0, com.baidu.tieba.ez0
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            z().g();
            R0().end(w());
            y().p(C(), p(), r());
            dx0 dx0Var = this.A;
            if (dx0Var != null) {
                dx0Var.cancel();
            }
        }
    }

    @Override // com.baidu.tieba.du0, com.baidu.tieba.cu0, com.baidu.tieba.ez0
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
