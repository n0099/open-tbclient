package com.baidu.tieba;

import android.os.Message;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ev0 extends wu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean h;
    public or0 i;
    public ir0 j;
    public mr0 k;
    @Nullable
    public qr0 l;
    public sr0 m;
    public pr0 n;

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public ev0() {
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
        this.h = false;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            jr0 jr0Var = new jr0();
            this.j = jr0Var;
            N(jr0Var);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            mr0 mr0Var = new mr0();
            this.k = mr0Var;
            N(mr0Var);
        }
    }

    public void e0() {
        ir0 ir0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ir0Var = this.j) != null) {
            ir0Var.z();
        }
    }

    @Override // com.baidu.tieba.fv0, com.baidu.tieba.jt0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return new int[]{4, 2, 3, 5, 1, 8};
        }
        return (int[]) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.removeMessages(0);
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            rx0.k(this);
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.d.removeMessages(0);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((kr0) it.next()).x();
            }
            this.h = false;
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((kr0) it.next()).y();
            }
        }
    }

    @Override // com.baidu.tieba.fv0, com.baidu.tieba.vu0, com.baidu.tieba.iv0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.baidu.tieba.wu0, com.baidu.tieba.fv0, com.baidu.tieba.vu0
    public void D(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.D(message);
            if (message.what == 0) {
                n0();
                Z(false);
            }
        }
    }

    @Override // com.baidu.tieba.fv0, com.baidu.tieba.vu0, com.baidu.tieba.jt0
    public void k(@NonNull js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, js0Var) == null) {
            super.k(js0Var);
            if (InteractiveEvent.ACTION_SWITCH_INTERACTIVE_KERNEL.equals(js0Var.c())) {
                if (js0Var.d(9)) {
                    l0();
                } else {
                    m0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.fv0
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            or0 or0Var = new or0();
            this.i = or0Var;
            N(or0Var);
            qr0 qr0Var = new qr0();
            this.l = qr0Var;
            N(qr0Var);
            pr0 pr0Var = new pr0();
            this.n = pr0Var;
            N(pr0Var);
            N(new rr0());
            sr0 sr0Var = new sr0();
            this.m = sr0Var;
            N(sr0Var);
            b0();
            c0();
            N(new tr0());
            N(new nr0());
            d0();
        }
    }

    @Override // com.baidu.tieba.wu0, com.baidu.tieba.vu0, com.baidu.tieba.jt0
    public void d(@NonNull js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, js0Var) == null) {
            super.d(js0Var);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(js0Var.c())) {
                Z(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(js0Var.c())) {
                Z(false);
            }
        }
    }

    public final void i0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && rx0.f()) {
            if (z) {
                i = ex0.a(this.e, 20.0f);
            } else {
                i = 0;
            }
            T t = this.e;
            ((FrameLayout) t).setPadding(((FrameLayout) t).getPaddingLeft(), ((FrameLayout) this.e).getPaddingTop(), ((FrameLayout) this.e).getPaddingRight(), i);
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                if (!y().Q0()) {
                    y().X0(1);
                }
            } else if (y().Q0()) {
                y().Y0(1);
            }
        }
    }

    @Override // com.baidu.tieba.wu0, com.baidu.tieba.vu0, com.baidu.tieba.jt0
    public void l(@NonNull js0 js0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, js0Var) == null) {
            super.l(js0Var);
            String c2 = js0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != -552621273) {
                if (hashCode != -552580917) {
                    if (hashCode == -21461611 && c2.equals(LayerEvent.ACTION_TOUCH_DOWN)) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 0;
                    }
                    c = 65535;
                }
            } else {
                if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        this.d.removeMessages(0);
                        this.h = false;
                        return;
                    }
                    return;
                }
                y().a1();
                j0();
                Z(g0());
                e0();
                f0();
                i0(true);
                return;
            }
            rx0.i(this);
            Z(false);
            js0 x = zr0.x(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
            x.o(16, Boolean.FALSE);
            J(x);
            if (this.h) {
                o0();
                this.d.removeMessages(0);
                this.d.sendEmptyMessageDelayed(0, 2000L);
            }
            i0(false);
        }
    }

    @Override // com.baidu.tieba.wu0, com.baidu.tieba.vu0, com.baidu.tieba.jt0
    public void r(@NonNull js0 js0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, js0Var) == null) {
            super.r(js0Var);
            String c2 = js0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != 720027695) {
                if (hashCode != 723345051) {
                    if (hashCode == 906917140 && c2.equals(ControlEvent.ACTION_RESUME)) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (c2.equals(ControlEvent.ACTION_START)) {
                        c = 0;
                    }
                    c = 65535;
                }
            } else {
                if (c2.equals(ControlEvent.ACTION_PAUSE)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        X(3000);
                        return;
                    }
                    return;
                } else if (js0Var.g(11) == 2 && !y().l1()) {
                    h0();
                    Z(true);
                    W();
                    return;
                } else {
                    return;
                }
            }
            Z(false);
            BdVideoSeries j1 = y().j1();
            if (j1 != null && j1.getSelectedVideo().getShowTitle()) {
                this.d.removeMessages(0);
                if (!y().Q0()) {
                    o0();
                }
                this.d.sendEmptyMessageDelayed(0, 2000L);
                this.h = true;
            }
        }
    }
}
