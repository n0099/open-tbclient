package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.dt0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class av0 extends vu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public av0() {
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

    @Override // com.baidu.tieba.wu0
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            V();
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) {
                U();
            }
        }
    }

    public void V() {
        bt0 bt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bt0Var = this.f) != null) {
            bt0Var.onDestroy();
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.kt0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vu0, com.baidu.tieba.ev0, com.baidu.tieba.wu0, com.baidu.tieba.jv0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            V();
        }
    }

    public av0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = str;
    }

    @Override // com.baidu.tieba.vu0
    public void R(bt0 bt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bt0Var) == null) {
            super.R(bt0Var);
            bt0 bt0Var2 = this.f;
            if (bt0Var2 != null) {
                bt0Var2.d(this);
            }
        }
    }

    @Override // com.baidu.tieba.vu0, com.baidu.tieba.lt0
    public boolean e(@NonNull ks0 ks0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ks0Var)) == null) {
            if (y().P0()) {
                return false;
            }
            return super.e(ks0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wu0, com.baidu.tieba.kt0
    public void o(@NonNull ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ks0Var) == null) {
            super.o(ks0Var);
            bt0 bt0Var = this.f;
            if (bt0Var != null) {
                bt0Var.c(ks0Var);
            }
        }
    }

    @Override // com.baidu.tieba.wu0, com.baidu.tieba.kt0
    public void r(@NonNull ks0 ks0Var) {
        bt0 bt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, ks0Var) == null) && (bt0Var = this.f) != null) {
            bt0Var.c(ks0Var);
        }
    }

    public final void U() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries j1 = y().j1();
            rp0 y = y();
            if (j1 != null && y != null && (videoAd = j1.getVideoAd()) != null && videoAd.suffixAdEnable) {
                ft0 a = dt0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
                a.a(y.Q0());
                R(a);
            }
        }
    }

    public final void W() {
        BdVideoSeries j1;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if ((!"ad_video_tail_frame_layer".equals(this.g) && !"ad_video_detail_tail_frame_layer".equals(this.g)) || !(this.f instanceof ft0) || (j1 = y().j1()) == null) {
                return;
            }
            BdVideoAd videoAd = j1.getVideoAd();
            ft0 ft0Var = (ft0) this.f;
            if (videoAd == null) {
                obj = null;
            } else {
                obj = videoAd.mAdVideoTailFrameData;
            }
            ft0Var.e(obj);
        }
    }

    @Override // com.baidu.tieba.wu0, com.baidu.tieba.kt0
    public void d(@NonNull ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ks0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(ks0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    W();
                } else {
                    T();
                }
            }
            bt0 bt0Var = this.f;
            if (bt0Var != null) {
                bt0Var.c(ks0Var);
            }
        }
    }

    @Override // com.baidu.tieba.wu0, com.baidu.tieba.kt0
    public void k(@NonNull ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ks0Var) == null) {
            super.k(ks0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(ks0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(ks0Var.c())) {
                hg0.a("AdLayer", "screen mode: " + ks0Var.c());
            }
            bt0 bt0Var = this.f;
            if (bt0Var != null) {
                bt0Var.c(ks0Var);
            }
        }
    }
}
