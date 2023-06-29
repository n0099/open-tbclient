package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class az0 extends zy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CyberVideoView g;
    public wx0 h;

    /* loaded from: classes5.dex */
    public class a extends CyberVideoView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az0 N;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(az0 az0Var, Context context, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az0Var, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.N = az0Var;
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.N.h != null) {
                    return this.N.h.onTouchEvent(motionEvent);
                }
                return super.onTouchEvent(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    public az0() {
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
        this.g = new a(this, du0.b(), 1);
    }

    @Override // com.baidu.tieba.yy0
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setVideoURI(Uri.parse(this.b), this.d);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.Q();
            this.g.start();
            if (n(PlayerStatus.COMPLETE)) {
                p(PlayerStatus.PLAYING);
            }
        }
    }

    @Override // com.baidu.tieba.yy0
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.R();
            this.g.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.yy0
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.S();
            this.g.stopPlayback();
        }
    }

    @Nullable
    public wx0 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.h;
        }
        return (wx0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy0
    @NonNull
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy0
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.g.getDuration() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.g.getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.g.getVideoHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy0
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.g.getVideoWidth();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy0, com.baidu.tieba.o11
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onRelease();
            this.g.stopPlayback();
            F(null);
            Y(null);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void B(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.g.setClarityInfo(str);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.g.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void I(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.g.setPlayJson(str);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.K(z);
            this.g.setRemote(z);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void L(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.g.setSpeed(f);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.g.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void U(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.g.changeProxyDynamic(str);
        }
    }

    public void Y(@Nullable wx0 wx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, wx0Var) == null) {
            this.h = wx0Var;
        }
    }

    @Override // com.baidu.tieba.yy0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.g.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.tieba.yy0, com.baidu.tieba.o11
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            return "CyberNetPlayer".equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yy0
    public void A(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            this.g.seekTo(i, i2);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void D(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) {
            this.g.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void H(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.g.setOption(str, str2);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.g.setOption(CyberPlayerManager.OPT_HTTP_PROXY, str);
                this.g.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, YYOption.IsLive.VALUE_TRUE);
                return;
            }
            this.g.setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
            this.g.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
        }
    }

    @Override // com.baidu.tieba.zy0
    public void V(bz0 bz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bz0Var) == null) {
            this.g.setOnCompletionListener(bz0Var);
            this.g.setOnErrorListener(bz0Var);
            this.g.setOnInfoListener(bz0Var);
            this.g.setOnSeekCompleteListener(bz0Var);
            this.g.setOnPreparedListener(bz0Var);
            this.g.setOnBufferingUpdateListener(bz0Var);
            this.g.setOnVideoSizeChangedListener(bz0Var);
            this.g.setOnMediaSourceChangedListener(bz0Var);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void N(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, hashMap) == null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.g.setOption(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.baidu.tieba.yy0
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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

    @Override // com.baidu.tieba.yy0
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (i() == PlayerStatus.IDLE && e() - this.g.getCurrentPosition() <= 2) {
                return f();
            }
            return this.g.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yy0, com.baidu.tieba.o11
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onInit();
            this.g.reset();
            this.g.setVideoScalingMode(2);
            this.g.setSpeed(1.0f);
            this.g.setVideoRotation(0);
            this.g.setVisibility(0);
            this.g.setAlpha(1.0f);
            K(true);
            this.g.setBackgroundColor(-16777216);
        }
    }

    @Override // com.baidu.tieba.yy0
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.u();
            if (n(PlayerStatus.PLAYING, PlayerStatus.PREPARED, PlayerStatus.PREPARING)) {
                p(PlayerStatus.PAUSE);
                this.g.pause();
            }
        }
    }

    @Override // com.baidu.tieba.yy0
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.y();
            if (n(PlayerStatus.PREPARED, PlayerStatus.PREPARING, PlayerStatus.PAUSE, PlayerStatus.COMPLETE)) {
                p(PlayerStatus.PLAYING);
                this.g.start();
            }
        }
    }
}
