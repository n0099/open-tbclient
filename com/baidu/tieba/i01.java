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
/* loaded from: classes6.dex */
public class i01 extends a01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean h;
    public rw0 i;
    public lw0 j;
    public pw0 k;
    @Nullable
    public tw0 l;
    public vw0 m;
    public sw0 n;

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public i01() {
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

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mw0 mw0Var = new mw0();
            this.j = mw0Var;
            M(mw0Var);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            pw0 pw0Var = new pw0();
            this.k = pw0Var;
            M(pw0Var);
        }
    }

    public void d0() {
        lw0 lw0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (lw0Var = this.j) != null) {
            lw0Var.x();
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.removeMessages(0);
        }
    }

    @Override // com.baidu.tieba.j01, com.baidu.tieba.ny0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new int[]{4, 2, 3, 5, 1, 8};
        }
        return (int[]) invokeV.objValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e31.k(this);
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.d.removeMessages(0);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((nw0) it.next()).t();
            }
            this.h = false;
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((nw0) it.next()).u();
            }
        }
    }

    @Override // com.baidu.tieba.j01, com.baidu.tieba.zz0, com.baidu.tieba.m01
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.baidu.tieba.a01, com.baidu.tieba.j01, com.baidu.tieba.zz0
    public void B(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.B(message);
            if (message.what == 0) {
                m0();
                Y(false);
            }
        }
    }

    @Override // com.baidu.tieba.j01, com.baidu.tieba.zz0, com.baidu.tieba.ny0
    public void j(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mx0Var) == null) {
            super.j(mx0Var);
            if (InteractiveEvent.ACTION_SWITCH_INTERACTIVE_KERNEL.equals(mx0Var.c())) {
                if (mx0Var.d(9)) {
                    k0();
                } else {
                    l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.j01
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            rw0 rw0Var = new rw0();
            this.i = rw0Var;
            M(rw0Var);
            tw0 tw0Var = new tw0();
            this.l = tw0Var;
            M(tw0Var);
            sw0 sw0Var = new sw0();
            this.n = sw0Var;
            M(sw0Var);
            M(new uw0());
            vw0 vw0Var = new vw0();
            this.m = vw0Var;
            M(vw0Var);
            a0();
            b0();
            M(new ww0());
            M(new qw0());
            c0();
        }
    }

    @Override // com.baidu.tieba.a01, com.baidu.tieba.j01, com.baidu.tieba.zz0, com.baidu.tieba.ny0
    public void d(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mx0Var) == null) {
            super.d(mx0Var);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(mx0Var.c())) {
                Y(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(mx0Var.c())) {
                Y(false);
            }
        }
    }

    public final void h0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && e31.f()) {
            if (z) {
                i = r21.a(this.e, 20.0f);
            } else {
                i = 0;
            }
            T t = this.e;
            ((FrameLayout) t).setPadding(((FrameLayout) t).getPaddingLeft(), ((FrameLayout) this.e).getPaddingTop(), ((FrameLayout) this.e).getPaddingRight(), i);
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                if (!u().V0()) {
                    u().c1(1);
                }
            } else if (u().V0()) {
                u().d1(1);
            }
        }
    }

    @Override // com.baidu.tieba.a01, com.baidu.tieba.j01, com.baidu.tieba.zz0, com.baidu.tieba.ny0
    public void k(@NonNull mx0 mx0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mx0Var) == null) {
            super.k(mx0Var);
            String c2 = mx0Var.c();
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
                u().f1();
                i0();
                Y(f0());
                d0();
                e0();
                h0(true);
                return;
            }
            e31.i(this);
            Y(false);
            mx0 w = cx0.w(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
            w.n(16, Boolean.FALSE);
            H(w);
            if (this.h) {
                n0();
                this.d.removeMessages(0);
                this.d.sendEmptyMessageDelayed(0, 2000L);
            }
            h0(false);
        }
    }

    @Override // com.baidu.tieba.a01, com.baidu.tieba.j01, com.baidu.tieba.zz0, com.baidu.tieba.ny0
    public void q(@NonNull mx0 mx0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, mx0Var) == null) {
            super.q(mx0Var);
            String c2 = mx0Var.c();
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
                        W(3000);
                        return;
                    }
                    return;
                } else if (mx0Var.g(11) == 2 && !u().p1()) {
                    g0();
                    Y(true);
                    V();
                    return;
                } else {
                    return;
                }
            }
            Y(false);
            BdVideoSeries o1 = u().o1();
            if (o1 != null && o1.getSelectedVideo().getShowTitle()) {
                this.d.removeMessages(0);
                if (!u().V0()) {
                    n0();
                }
                this.d.sendEmptyMessageDelayed(0, 2000L);
                this.h = true;
            }
        }
    }
}
