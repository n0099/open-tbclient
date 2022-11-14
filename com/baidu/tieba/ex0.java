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
import com.baidu.tieba.hv0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ex0 extends zw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

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

    @Override // com.baidu.tieba.ax0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            S();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) {
                R();
            }
        }
    }

    public void S() {
        fv0 fv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (fv0Var = this.f) != null) {
            fv0Var.onDestroy();
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.ov0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 2, 3, 1};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zw0, com.baidu.tieba.ix0, com.baidu.tieba.ax0, com.baidu.tieba.nx0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            S();
        }
    }

    public ex0(String str) {
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

    @Override // com.baidu.tieba.zw0
    public void O(fv0 fv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fv0Var) == null) {
            super.O(fv0Var);
            fv0 fv0Var2 = this.f;
            if (fv0Var2 != null) {
                fv0Var2.d(this);
            }
        }
    }

    @Override // com.baidu.tieba.zw0, com.baidu.tieba.pv0
    public boolean e(@NonNull nu0 nu0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, nu0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(nu0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ax0, com.baidu.tieba.ov0
    public void n(@NonNull nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nu0Var) == null) {
            super.n(nu0Var);
            fv0 fv0Var = this.f;
            if (fv0Var != null) {
                fv0Var.c(nu0Var);
            }
        }
    }

    @Override // com.baidu.tieba.ax0, com.baidu.tieba.ov0
    public void q(@NonNull nu0 nu0Var) {
        fv0 fv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, nu0Var) == null) && (fv0Var = this.f) != null) {
            fv0Var.c(nu0Var);
        }
    }

    public final void R() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            ur0 u = u();
            if (o1 != null && u != null && (videoAd = o1.getVideoAd()) != null && videoAd.suffixAdEnable) {
                jv0 a = hv0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
                a.a(u.V0());
                O(a);
            }
        }
    }

    public final void T() {
        BdVideoSeries o1;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if ((!"ad_video_tail_frame_layer".equals(this.g) && !"ad_video_detail_tail_frame_layer".equals(this.g)) || !(this.f instanceof jv0) || (o1 = u().o1()) == null) {
                return;
            }
            BdVideoAd videoAd = o1.getVideoAd();
            jv0 jv0Var = (jv0) this.f;
            if (videoAd == null) {
                obj = null;
            } else {
                obj = videoAd.mAdVideoTailFrameData;
            }
            jv0Var.e(obj);
        }
    }

    @Override // com.baidu.tieba.ax0, com.baidu.tieba.ov0
    public void d(@NonNull nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nu0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(nu0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    T();
                } else {
                    Q();
                }
            }
            fv0 fv0Var = this.f;
            if (fv0Var != null) {
                fv0Var.c(nu0Var);
            }
        }
    }

    @Override // com.baidu.tieba.ax0, com.baidu.tieba.ov0
    public void k(@NonNull nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nu0Var) == null) {
            super.k(nu0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(nu0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(nu0Var.c())) {
                xj0.a("AdLayer", "screen mode: " + nu0Var.c());
            }
            fv0 fv0Var = this.f;
            if (fv0Var != null) {
                fv0Var.c(nu0Var);
            }
        }
    }
}
