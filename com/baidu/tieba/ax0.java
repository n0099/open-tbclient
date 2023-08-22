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
public final class ax0 implements sx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mz0 a;
    public mz0 b;

    public ax0() {
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

    @Override // com.baidu.tieba.sx0
    public void a(zt0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            mz0 k = player.k();
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

    @Override // com.baidu.tieba.sx0
    public mz0 b(zt0 player, mz0 mz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, mz0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                mz0Var = h(player, player.u());
            }
            if (mz0Var == null) {
                mz0Var = f(player.o());
            }
            this.a = mz0Var;
            return mz0Var;
        }
        return (mz0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sx0
    public void c(zt0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            mz0 mz0Var = this.a;
            if (mz0Var != null) {
                e(player, mz0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(zt0 zt0Var, mz0 mz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, zt0Var, mz0Var) == null) && mz0Var != null) {
            zt0Var.e(mz0Var);
        }
    }

    @Override // com.baidu.tieba.sx0
    public boolean d(zt0 player, mz0 mz0Var) {
        InterceptResult invokeLL;
        String vid;
        mz0 mz0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, mz0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(mz0Var instanceof tz0)) {
                mz0Var2 = null;
            } else {
                mz0Var2 = mz0Var;
            }
            tz0 tz0Var = (tz0) mz0Var2;
            if (tz0Var != null) {
                str = tz0Var.A0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (mz0Var != null) {
                playerStatus = mz0Var.S();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(yt0 player, String str) {
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
            mz0 k = player.k();
            b21.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.a0();
                qu0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public mz0 h(yt0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        sy0 U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            mz0 b = qu0.a().b(str);
            if (b != null && (U = b.U()) != null) {
                bool = Boolean.valueOf(U.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                qu0.a().d(str);
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
        return (mz0) invokeLL.objValue;
    }

    public final tz0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new tz0(str);
        }
        return (tz0) invokeL.objValue;
    }

    public final void j(mz0 mz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, mz0Var) == null) && mz0Var != null) {
            mz0Var.a0();
            mz0Var.v0();
            mz0Var.c0();
        }
    }

    public void i(zt0 player, String str) {
        Activity activity;
        yt0 yt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                b21.a("performAutoDetachCache begin");
                mz0 A = player.A();
                mz0 mz0Var = this.a;
                if (mz0Var != null) {
                    yt0Var = mz0Var.u();
                } else {
                    yt0Var = null;
                }
                if (Intrinsics.areEqual(yt0Var, player)) {
                    b21.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    b21.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    mz0 mz0Var2 = this.a;
                    if (mz0Var2 != null) {
                        mz0Var2.a0();
                    }
                    qu0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
