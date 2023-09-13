package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.minivideo.view.LineLoadingView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h01 extends rz0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup e;
    public ImageView f;
    public boolean g;
    public LineLoadingView h;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
        }
    }

    public h01() {
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
        this.g = false;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.h.g();
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.h.f();
        }
    }

    @Override // com.baidu.tieba.wz0
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new int[]{4, 2, 1, 5};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jz0
    @SuppressLint({"InflateParams"})
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.c).inflate(R.layout.nad_mini_video_control_layer, (ViewGroup) null);
            this.e = viewGroup;
            this.f = (ImageView) viewGroup.findViewById(R.id.video_pause_icon);
            this.h = (LineLoadingView) this.e.findViewById(R.id.line_loading_view);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.g = z;
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.g) {
            this.f.setVisibility(i);
            this.g = false;
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void d(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ww0Var) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(ww0Var.c())) {
                int intValue = ((Integer) ww0Var.f(1)).intValue();
                if (intValue != 904 && 956 != intValue) {
                    if (701 == intValue) {
                        P();
                        return;
                    } else if (702 == intValue) {
                        M();
                        return;
                    } else {
                        return;
                    }
                }
                this.g = false;
                this.f.setVisibility(4);
                M();
            } else if (PlayerEvent.ACTION_ON_PREPARED.equals(ww0Var.c())) {
                M();
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(ww0Var.c())) {
                M();
            }
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void q(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ww0Var) == null) {
            if (ControlEvent.ACTION_PAUSE.equals(ww0Var.c())) {
                if (this.g) {
                    this.f.setVisibility(0);
                }
            } else if (ControlEvent.ACTION_RESUME.equals(ww0Var.c())) {
                this.g = false;
                this.f.setVisibility(4);
            } else if (ControlEvent.ACTION_START.equals(ww0Var.c())) {
                if (!u().Y()) {
                    P();
                }
            } else if (ControlEvent.ACTION_STOP.equals(ww0Var.c())) {
                M();
            }
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PAUSE || playerStatus == PlayerStatus.STOP) {
                M();
            }
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void n(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, ww0Var) == null) && SystemEvent.ACTION_VOLUME_CHANGED.equals(ww0Var.c()) && !u().a0() && !u().Q() && ((Integer) ww0Var.f(5)).intValue() > 0 && u().V()) {
            u().w0(false);
        }
    }
}
