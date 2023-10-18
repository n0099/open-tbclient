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
public final class as0 implements rs0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lu0 a;
    public lu0 b;

    public as0() {
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

    @Override // com.baidu.tieba.rs0
    public void a(zo0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.v());
            lu0 k = player.k();
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

    @Override // com.baidu.tieba.rs0
    public lu0 b(zo0 player, lu0 lu0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, lu0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.q1()) {
                lu0Var = h(player, player.v());
            }
            if (lu0Var == null) {
                lu0Var = f(player.p());
            }
            this.a = lu0Var;
            return lu0Var;
        }
        return (lu0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.rs0
    public void c(zo0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            lu0 lu0Var = this.a;
            if (lu0Var != null) {
                e(player, lu0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.p());
            }
            e(player, this.b);
        }
    }

    public final void e(zo0 zo0Var, lu0 lu0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, zo0Var, lu0Var) == null) && lu0Var != null) {
            zo0Var.e(lu0Var);
        }
    }

    @Override // com.baidu.tieba.rs0
    public boolean d(zo0 player, lu0 lu0Var) {
        InterceptResult invokeLL;
        String vid;
        lu0 lu0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, lu0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries j1 = player.j1();
            if (j1 == null || (vid = j1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(lu0Var instanceof su0)) {
                lu0Var2 = null;
            } else {
                lu0Var2 = lu0Var;
            }
            su0 su0Var = (su0) lu0Var2;
            if (su0Var != null) {
                str = su0Var.z0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (lu0Var != null) {
                playerStatus = lu0Var.T();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(yo0 player, String str) {
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
            lu0 k = player.k();
            rw0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Z();
                qp0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public lu0 h(yo0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        rt0 U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            lu0 b = qp0.a().b(str);
            if (b != null && (U = b.U()) != null) {
                bool = Boolean.valueOf(U.verify(player.p()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                qp0.a().d(str);
                player.y0(true);
                if (b.x() != null) {
                    b.x().k();
                    return b;
                }
                return b;
            }
            player.y0(false);
            return null;
        }
        return (lu0) invokeLL.objValue;
    }

    public final su0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new su0(str);
        }
        return (su0) invokeL.objValue;
    }

    public final void j(lu0 lu0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, lu0Var) == null) && lu0Var != null) {
            lu0Var.Z();
            lu0Var.u0();
            lu0Var.b0();
        }
    }

    public void i(zo0 player, String str) {
        Activity m;
        yo0 yo0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.q1() && player.Z() && !player.R() && (m = player.m()) != null && m.isFinishing()) {
                rw0.a("performAutoDetachCache begin");
                lu0 B = player.B();
                lu0 lu0Var = this.a;
                if (lu0Var != null) {
                    yo0Var = lu0Var.x();
                } else {
                    yo0Var = null;
                }
                if (Intrinsics.areEqual(yo0Var, player)) {
                    rw0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + B);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    rw0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + B);
                    lu0 lu0Var2 = this.a;
                    if (lu0Var2 != null) {
                        lu0Var2.Z();
                    }
                    qp0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
