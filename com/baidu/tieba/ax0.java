package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class ax0 extends sw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CyberPlayer g;

    @Override // com.baidu.tieba.rw0
    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.rw0
    @Nullable
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

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

    @Override // com.baidu.tieba.rw0
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setDataSource(wr0.b(), Uri.parse(this.b), this.d);
            this.g.prepareAsync();
        }
    }

    @Override // com.baidu.tieba.rw0
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.Q();
            this.g.start();
            if (n(PlayerStatus.COMPLETE)) {
                p(PlayerStatus.PLAYING);
            }
        }
    }

    @Override // com.baidu.tieba.rw0
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.R();
            S();
        }
    }

    @Override // com.baidu.tieba.rw0
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.S();
            this.g.stop();
        }
    }

    @Override // com.baidu.tieba.rw0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw0
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g.getDuration() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.g.getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.g.getVideoHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw0
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.g.getVideoWidth();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw0, com.baidu.tieba.hz0
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onInit();
            this.g = new CyberPlayer();
        }
    }

    @Override // com.baidu.tieba.rw0, com.baidu.tieba.hz0
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onRelease();
            this.d.clear();
            S();
            this.g.release();
            this.g = null;
        }
    }

    @Override // com.baidu.tieba.rw0
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            w("prepare");
            if (!PlayerStatus.isActiveStatus(i())) {
                p(PlayerStatus.PREPARING);
                this.g.prepareAsync();
            }
        }
    }

    @Override // com.baidu.tieba.rw0
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.y();
            if (n(PlayerStatus.PAUSE, PlayerStatus.COMPLETE)) {
                p(PlayerStatus.PLAYING);
                this.g.start();
            }
        }
    }

    @Override // com.baidu.tieba.rw0
    public void A(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            this.g.seekTo(i, i2);
        }
    }

    @Override // com.baidu.tieba.rw0
    public void D(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) {
            this.g.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.tieba.rw0
    public void H(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.g.setOption(str, str2);
        }
    }

    @Override // com.baidu.tieba.rw0
    public void B(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.g.setClarityInfo(str);
        }
    }

    @Override // com.baidu.tieba.rw0
    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.g.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.rw0
    public void I(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.g.setPlayJson(str);
        }
    }

    @Override // com.baidu.tieba.rw0
    public void L(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            this.g.setSpeed(f);
        }
    }

    @Override // com.baidu.tieba.rw0
    public void U(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (str != null) {
                this.g.changeProxyDynamic(str, true);
            } else {
                this.g.changeProxyDynamic(null, false);
            }
        }
    }

    @Override // com.baidu.tieba.rw0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.g.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.tieba.rw0, com.baidu.tieba.hz0
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            return "InlineVideoKernel".equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rw0
    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.g.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.rw0
    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.g.setOption(CyberPlayerManager.OPT_HTTP_PROXY, str);
                this.g.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
                return;
            }
            this.g.setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
            this.g.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
        }
    }

    @Override // com.baidu.tieba.sw0
    public void V(uw0 uw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, uw0Var) == null) {
            this.g.setOnCompletionListener(uw0Var);
            this.g.setOnErrorListener(uw0Var);
            this.g.setOnInfoListener(uw0Var);
            this.g.setOnSeekCompleteListener(uw0Var);
            this.g.setOnPreparedListener(uw0Var);
            this.g.setOnBufferingUpdateListener(uw0Var);
            this.g.setOnVideoSizeChangedListener(uw0Var);
            this.g.setOnMediaSourceChangedListener(uw0Var);
        }
    }

    @Override // com.baidu.tieba.rw0
    public void N(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, hashMap) == null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.g.setOption(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.baidu.tieba.rw0
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (n(PlayerStatus.IDLE)) {
                int e = e() / 1000;
                if (e - (this.g.getCurrentPosition() / 1000) <= 2) {
                    return e;
                }
            }
            return this.g.getCurrentPosition() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw0
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (n(PlayerStatus.IDLE) && e() - this.g.getCurrentPosition() <= 2) {
                return f();
            }
            return this.g.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw0
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.u();
            if (n(PlayerStatus.PLAYING, PlayerStatus.PREPARED, PlayerStatus.PREPARING)) {
                p(PlayerStatus.PAUSE);
                this.g.pause();
            }
        }
    }
}
