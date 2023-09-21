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
/* loaded from: classes5.dex */
public final class dx0 implements vx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pz0 a;
    public pz0 b;

    public dx0() {
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

    @Override // com.baidu.tieba.vx0
    public void a(cu0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            pz0 k = player.k();
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

    @Override // com.baidu.tieba.vx0
    public pz0 b(cu0 player, pz0 pz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, pz0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                pz0Var = h(player, player.u());
            }
            if (pz0Var == null) {
                pz0Var = f(player.o());
            }
            this.a = pz0Var;
            return pz0Var;
        }
        return (pz0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.vx0
    public void c(cu0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            pz0 pz0Var = this.a;
            if (pz0Var != null) {
                e(player, pz0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(cu0 cu0Var, pz0 pz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, cu0Var, pz0Var) == null) && pz0Var != null) {
            cu0Var.e(pz0Var);
        }
    }

    @Override // com.baidu.tieba.vx0
    public boolean d(cu0 player, pz0 pz0Var) {
        InterceptResult invokeLL;
        String vid;
        pz0 pz0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, pz0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(pz0Var instanceof wz0)) {
                pz0Var2 = null;
            } else {
                pz0Var2 = pz0Var;
            }
            wz0 wz0Var = (wz0) pz0Var2;
            if (wz0Var != null) {
                str = wz0Var.A0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (pz0Var != null) {
                playerStatus = pz0Var.S();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(bu0 player, String str) {
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
            pz0 k = player.k();
            e21.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Z();
                tu0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public pz0 h(bu0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        vy0 U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            pz0 b = tu0.a().b(str);
            if (b != null && (U = b.U()) != null) {
                bool = Boolean.valueOf(U.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                tu0.a().d(str);
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
        return (pz0) invokeLL.objValue;
    }

    public final wz0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new wz0(str);
        }
        return (wz0) invokeL.objValue;
    }

    public final void j(pz0 pz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pz0Var) == null) && pz0Var != null) {
            pz0Var.Z();
            pz0Var.v0();
            pz0Var.c0();
        }
    }

    public void i(cu0 player, String str) {
        Activity activity;
        bu0 bu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                e21.a("performAutoDetachCache begin");
                pz0 A = player.A();
                pz0 pz0Var = this.a;
                if (pz0Var != null) {
                    bu0Var = pz0Var.u();
                } else {
                    bu0Var = null;
                }
                if (Intrinsics.areEqual(bu0Var, player)) {
                    e21.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    e21.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    pz0 pz0Var2 = this.a;
                    if (pz0Var2 != null) {
                        pz0Var2.Z();
                    }
                    tu0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
