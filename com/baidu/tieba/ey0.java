package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ey0 extends nx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView e;
    public AdImageView f;

    public ey0() {
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
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tv0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new int[]{4, 2, 5, 3};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fx0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AdImageView adImageView = new AdImageView(this.c);
            this.e = adImageView;
            adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.e.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
            AdImageView adImageView2 = new AdImageView(this.c);
            this.f = adImageView2;
            adImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f.setVisibility(i);
            this.e.setVisibility(i);
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.e.getVisibility() == 8) {
            this.e.setVisibility(0);
            this.e.p(str, false);
        }
    }

    @Override // com.baidu.tieba.fx0, com.baidu.tieba.tv0
    public void d(@NonNull su0 su0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, su0Var) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(su0Var.c())) {
                int intValue = ((Integer) su0Var.f(1)).intValue();
                if (intValue == 904 || 956 == intValue) {
                    this.e.setVisibility(8);
                    this.f.setVisibility(8);
                }
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(su0Var.c())) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            } else if ((PlayerEvent.ACTION_SET_DATA_SOURCE.equals(su0Var.c()) || PlayerEvent.ACTION_PLAYER_ATTACH.equals(su0Var.c())) && u() != null && u().o1() != null) {
                O(u().o1().getPoster());
            }
        }
    }

    @Override // com.baidu.tieba.fx0, com.baidu.tieba.tv0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                N(8);
            } else if (playerStatus == PlayerStatus.PREPARING) {
                this.e.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.fx0, com.baidu.tieba.tv0
    public void k(@NonNull su0 su0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, su0Var) == null) {
            String c2 = su0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != 1554330967) {
                if (hashCode == 2062901052 && c2.equals(LayerEvent.ACTION_SHOW_POSTER)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (c2.equals(LayerEvent.ACTION_HIDE_POSTER)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c == 1) {
                    N(8);
                    return;
                }
                return;
            }
            this.e.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.fx0, com.baidu.tieba.tv0
    public void q(@NonNull su0 su0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, su0Var) == null) {
            if (ControlEvent.ACTION_RESUME.equals(su0Var.c()) || ControlEvent.ACTION_SHOW_TIP.equals(su0Var.c())) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            }
        }
    }
}
