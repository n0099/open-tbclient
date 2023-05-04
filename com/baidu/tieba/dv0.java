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
/* loaded from: classes4.dex */
public final class dv0 implements vv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public px0 a;
    public px0 b;

    public dv0() {
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

    @Override // com.baidu.tieba.vv0
    public void a(cs0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            px0 k = player.k();
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

    @Override // com.baidu.tieba.vv0
    public px0 b(cs0 player, px0 px0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, px0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                px0Var = h(player, player.u());
            }
            if (px0Var == null) {
                px0Var = f(player.o());
            }
            this.a = px0Var;
            return px0Var;
        }
        return (px0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.vv0
    public void c(cs0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            px0 px0Var = this.a;
            if (px0Var != null) {
                e(player, px0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(cs0 cs0Var, px0 px0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, cs0Var, px0Var) == null) && px0Var != null) {
            cs0Var.e(px0Var);
        }
    }

    @Override // com.baidu.tieba.vv0
    public boolean d(cs0 player, px0 px0Var) {
        InterceptResult invokeLL;
        String vid;
        px0 px0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, px0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(px0Var instanceof wx0)) {
                px0Var2 = null;
            } else {
                px0Var2 = px0Var;
            }
            wx0 wx0Var = (wx0) px0Var2;
            if (wx0Var != null) {
                str = wx0Var.A0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (px0Var != null) {
                playerStatus = px0Var.T();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(bs0 player, String str) {
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
            px0 k = player.k();
            f01.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.a0();
                ts0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public px0 h(bs0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        vw0 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            px0 b = ts0.a().b(str);
            if (b != null && (V = b.V()) != null) {
                bool = Boolean.valueOf(V.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                ts0.a().d(str);
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
        return (px0) invokeLL.objValue;
    }

    public final wx0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new wx0(str);
        }
        return (wx0) invokeL.objValue;
    }

    public final void j(px0 px0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, px0Var) == null) && px0Var != null) {
            px0Var.a0();
            px0Var.v0();
            px0Var.c0();
        }
    }

    public void i(cs0 player, String str) {
        Activity activity;
        bs0 bs0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                f01.a("performAutoDetachCache begin");
                px0 A = player.A();
                px0 px0Var = this.a;
                if (px0Var != null) {
                    bs0Var = px0Var.u();
                } else {
                    bs0Var = null;
                }
                if (Intrinsics.areEqual(bs0Var, player)) {
                    f01.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    f01.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    px0 px0Var2 = this.a;
                    if (px0Var2 != null) {
                        px0Var2.a0();
                    }
                    ts0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
