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
public final class ds0 implements vs0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pu0 a;
    public pu0 b;

    public ds0() {
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

    @Override // com.baidu.tieba.vs0
    public void a(cp0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            pu0 k = player.k();
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

    @Override // com.baidu.tieba.vs0
    public pu0 b(cp0 player, pu0 pu0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, pu0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                pu0Var = h(player, player.u());
            }
            if (pu0Var == null) {
                pu0Var = f(player.o());
            }
            this.a = pu0Var;
            return pu0Var;
        }
        return (pu0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.vs0
    public void c(cp0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            pu0 pu0Var = this.a;
            if (pu0Var != null) {
                e(player, pu0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    @Override // com.baidu.tieba.vs0
    public boolean d(cp0 player, pu0 pu0Var) {
        InterceptResult invokeLL;
        String vid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, pu0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            wu0 wu0Var = (wu0) (!(pu0Var instanceof wu0) ? null : pu0Var);
            if (Intrinsics.areEqual(vid, wu0Var != null ? wu0Var.y0() : null)) {
                return PlayerStatus.isActiveStatus(pu0Var != null ? pu0Var.R() : null);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void e(cp0 cp0Var, pu0 pu0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, cp0Var, pu0Var) == null) || pu0Var == null) {
            return;
        }
        cp0Var.e(pu0Var);
    }

    public final wu0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new wu0(str);
        }
        return (wu0) invokeL.objValue;
    }

    public boolean g(bp0 player, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (str == null || str.length() == 0) {
                return false;
            }
            pu0 k = player.k();
            ex0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Y();
                tp0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public pu0 h(bp0 player, String str) {
        InterceptResult invokeLL;
        vt0 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            pu0 b = tp0.a().b(str);
            if (Intrinsics.areEqual((b == null || (T = b.T()) == null) ? null : Boolean.valueOf(T.verify(player.o())), Boolean.TRUE)) {
                tp0.a().d(str);
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
        return (pu0) invokeLL.objValue;
    }

    public void i(cp0 player, String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                ex0.a("performAutoDetachCache begin");
                pu0 A = player.A();
                pu0 pu0Var = this.a;
                if (Intrinsics.areEqual(pu0Var != null ? pu0Var.u() : null, player)) {
                    ex0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    ex0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    pu0 pu0Var2 = this.a;
                    if (pu0Var2 != null) {
                        pu0Var2.Y();
                    }
                    tp0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }

    public final void j(pu0 pu0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, pu0Var) == null) || pu0Var == null) {
            return;
        }
        pu0Var.Y();
        pu0Var.t0();
        pu0Var.a0();
    }
}
