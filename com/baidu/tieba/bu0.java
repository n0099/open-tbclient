package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class bu0 extends tt0 implements ht0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public au0 b;
    public Object c;

    @Override // com.baidu.tieba.tt0
    public void f(ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ms0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.tt0
    public void i(ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ms0Var) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu0(Map<String, String> map, Object obj) {
        super(map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Map) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = obj;
    }

    @Override // com.baidu.tieba.dt0
    public void a(boolean z) {
        au0 au0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (au0Var = this.b) != null) {
            au0Var.k(z);
        }
    }

    @Override // com.baidu.tieba.ht0
    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            this.c = obj;
        }
    }

    public void l(boolean z) {
        au0 au0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (au0Var = this.b) != null) {
            au0Var.j(z);
        }
    }

    @Override // com.baidu.tieba.et0
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && this.a != null && PlayerEvent.ACTION_ON_COMPLETE.equals(str)) {
                this.a.S(0);
                au0 au0Var = new au0(this.a, this.c);
                this.b = au0Var;
                au0Var.e();
                if (k()) {
                    if (this.b.i()) {
                        this.a.S(0);
                        this.a.y().z().y(true);
                        return true;
                    }
                    this.a.S(8);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.tt0
    public void g(ms0 ms0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ms0Var) == null) {
            String c2 = ms0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != -552621273) {
                if (hashCode != -552580917) {
                    if (hashCode == 851534116 && c2.equals(LayerEvent.ACTION_NIGHT_MODEL_CHANGED)) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        l(ms0Var.d(17));
                        return;
                    }
                    return;
                }
                a(true);
                return;
            }
            a(false);
        }
    }

    @Override // com.baidu.tieba.tt0
    public void h(ms0 ms0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ms0Var) == null) {
            String c2 = ms0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != -1759675333) {
                if (hashCode == -882902390 && c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (c2.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c == 1 && this.a.P() && this.b != null) {
                    if (!ms0Var.d(4)) {
                        this.b.m();
                        return;
                    } else {
                        this.b.l();
                        return;
                    }
                }
                return;
            }
            this.a.S(8);
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        BdVideoSeries j1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            cv0 cv0Var = this.a;
            if (cv0Var == null || (j1 = cv0Var.y().j1()) == null || j1.getVideoAd() == null || j1.getVideoAd().fullItemAdData == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.b == null) {
            return;
        }
        this.b = null;
    }

    @Override // com.baidu.tieba.dt0
    public void onDestroy() {
        cv0 cv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.b != null && (cv0Var = this.a) != null && cv0Var.P()) {
                this.b.f();
            }
            au0 au0Var = this.b;
            if (au0Var != null) {
                au0Var.c();
                m();
            }
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.dt0
    public void onLayerRelease() {
        au0 au0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (au0Var = this.b) != null) {
            au0Var.f();
        }
    }
}
