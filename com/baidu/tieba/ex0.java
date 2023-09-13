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
public final class ex0 implements wx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qz0 a;
    public qz0 b;

    public ex0() {
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

    @Override // com.baidu.tieba.wx0
    public void a(du0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            qz0 k = player.k();
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

    @Override // com.baidu.tieba.wx0
    public qz0 b(du0 player, qz0 qz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, qz0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                qz0Var = h(player, player.u());
            }
            if (qz0Var == null) {
                qz0Var = f(player.o());
            }
            this.a = qz0Var;
            return qz0Var;
        }
        return (qz0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.wx0
    public void c(du0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            qz0 qz0Var = this.a;
            if (qz0Var != null) {
                e(player, qz0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(du0 du0Var, qz0 qz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, du0Var, qz0Var) == null) && qz0Var != null) {
            du0Var.e(qz0Var);
        }
    }

    @Override // com.baidu.tieba.wx0
    public boolean d(du0 player, qz0 qz0Var) {
        InterceptResult invokeLL;
        String vid;
        qz0 qz0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, qz0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(qz0Var instanceof xz0)) {
                qz0Var2 = null;
            } else {
                qz0Var2 = qz0Var;
            }
            xz0 xz0Var = (xz0) qz0Var2;
            if (xz0Var != null) {
                str = xz0Var.A0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (qz0Var != null) {
                playerStatus = qz0Var.S();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(cu0 player, String str) {
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
            qz0 k = player.k();
            f21.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.a0();
                uu0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public qz0 h(cu0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        wy0 U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            qz0 b = uu0.a().b(str);
            if (b != null && (U = b.U()) != null) {
                bool = Boolean.valueOf(U.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                uu0.a().d(str);
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
        return (qz0) invokeLL.objValue;
    }

    public final xz0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new xz0(str);
        }
        return (xz0) invokeL.objValue;
    }

    public final void j(qz0 qz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, qz0Var) == null) && qz0Var != null) {
            qz0Var.a0();
            qz0Var.v0();
            qz0Var.c0();
        }
    }

    public void i(du0 player, String str) {
        Activity activity;
        cu0 cu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                f21.a("performAutoDetachCache begin");
                qz0 A = player.A();
                qz0 qz0Var = this.a;
                if (qz0Var != null) {
                    cu0Var = qz0Var.u();
                } else {
                    cu0Var = null;
                }
                if (Intrinsics.areEqual(cu0Var, player)) {
                    f21.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    f21.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    qz0 qz0Var2 = this.a;
                    if (qz0Var2 != null) {
                        qz0Var2.a0();
                    }
                    uu0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
