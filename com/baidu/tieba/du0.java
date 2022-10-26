package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class du0 implements vu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pw0 a;
    public pw0 b;

    public du0() {
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

    @Override // com.baidu.tieba.vu0
    public void a(cr0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            pw0 k = player.k();
            if (k != null) {
                if (!Intrinsics.areEqual(k, this.b)) {
                    j(this.b);
                    this.b = null;
                } else if (!Intrinsics.areEqual(k, this.a)) {
                    j(this.a);
                    this.a = null;
                }
                j(k);
            }
        }
    }

    @Override // com.baidu.tieba.vu0
    public pw0 b(cr0 player, pw0 pw0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, pw0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                pw0Var = h(player, player.u());
            }
            if (pw0Var == null) {
                pw0Var = f(player.o());
            }
            this.a = pw0Var;
            return pw0Var;
        }
        return (pw0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.vu0
    public void c(cr0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            pw0 pw0Var = this.a;
            if (pw0Var != null) {
                e(player, pw0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(cr0 cr0Var, pw0 pw0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, cr0Var, pw0Var) == null) && pw0Var != null) {
            cr0Var.e(pw0Var);
        }
    }

    @Override // com.baidu.tieba.vu0
    public boolean d(cr0 player, pw0 pw0Var) {
        InterceptResult invokeLL;
        String vid;
        pw0 pw0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, pw0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(pw0Var instanceof ww0)) {
                pw0Var2 = null;
            } else {
                pw0Var2 = pw0Var;
            }
            ww0 ww0Var = (ww0) pw0Var2;
            if (ww0Var != null) {
                str = ww0Var.y0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (pw0Var != null) {
                playerStatus = pw0Var.R();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(br0 player, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            pw0 k = player.k();
            ez0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Y();
                tr0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public pw0 h(br0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        vv0 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            pw0 b = tr0.a().b(str);
            if (b != null && (T = b.T()) != null) {
                bool = Boolean.valueOf(T.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                tr0.a().d(str);
                player.A0(true);
                if (b.u() != null) {
                    b.u().k();
                    return b;
                }
                return b;
            }
            player.A0(false);
            return null;
        }
        return (pw0) invokeLL.objValue;
    }

    public final ww0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new ww0(str);
        }
        return (ww0) invokeL.objValue;
    }

    public final void j(pw0 pw0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pw0Var) == null) && pw0Var != null) {
            pw0Var.Y();
            pw0Var.t0();
            pw0Var.a0();
        }
    }

    public void i(cr0 player, String str) {
        Activity activity;
        br0 br0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                ez0.a("performAutoDetachCache begin");
                pw0 A = player.A();
                pw0 pw0Var = this.a;
                if (pw0Var != null) {
                    br0Var = pw0Var.u();
                } else {
                    br0Var = null;
                }
                if (Intrinsics.areEqual(br0Var, player)) {
                    ez0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    ez0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    pw0 pw0Var2 = this.a;
                    if (pw0Var2 != null) {
                        pw0Var2.Y();
                    }
                    tr0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
