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
/* loaded from: classes6.dex */
public final class gx0 implements yx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sz0 a;
    public sz0 b;

    public gx0() {
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

    @Override // com.baidu.tieba.yx0
    public void a(fu0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            sz0 k = player.k();
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

    @Override // com.baidu.tieba.yx0
    public sz0 b(fu0 player, sz0 sz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, sz0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                sz0Var = h(player, player.u());
            }
            if (sz0Var == null) {
                sz0Var = f(player.o());
            }
            this.a = sz0Var;
            return sz0Var;
        }
        return (sz0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.yx0
    public void c(fu0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            sz0 sz0Var = this.a;
            if (sz0Var != null) {
                e(player, sz0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(fu0 fu0Var, sz0 sz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, fu0Var, sz0Var) == null) && sz0Var != null) {
            fu0Var.e(sz0Var);
        }
    }

    @Override // com.baidu.tieba.yx0
    public boolean d(fu0 player, sz0 sz0Var) {
        InterceptResult invokeLL;
        String vid;
        sz0 sz0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, sz0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(sz0Var instanceof zz0)) {
                sz0Var2 = null;
            } else {
                sz0Var2 = sz0Var;
            }
            zz0 zz0Var = (zz0) sz0Var2;
            if (zz0Var != null) {
                str = zz0Var.A0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (sz0Var != null) {
                playerStatus = sz0Var.T();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(eu0 player, String str) {
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
            sz0 k = player.k();
            i21.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.a0();
                wu0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public sz0 h(eu0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        yy0 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            sz0 b = wu0.a().b(str);
            if (b != null && (V = b.V()) != null) {
                bool = Boolean.valueOf(V.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                wu0.a().d(str);
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
        return (sz0) invokeLL.objValue;
    }

    public final zz0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new zz0(str);
        }
        return (zz0) invokeL.objValue;
    }

    public final void j(sz0 sz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, sz0Var) == null) && sz0Var != null) {
            sz0Var.a0();
            sz0Var.v0();
            sz0Var.c0();
        }
    }

    public void i(fu0 player, String str) {
        Activity activity;
        eu0 eu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                i21.a("performAutoDetachCache begin");
                sz0 A = player.A();
                sz0 sz0Var = this.a;
                if (sz0Var != null) {
                    eu0Var = sz0Var.u();
                } else {
                    eu0Var = null;
                }
                if (Intrinsics.areEqual(eu0Var, player)) {
                    i21.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    i21.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    sz0 sz0Var2 = this.a;
                    if (sz0Var2 != null) {
                        sz0Var2.a0();
                    }
                    wu0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
