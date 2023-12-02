package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.tail.AdVideoTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class au0 extends st0 implements AdVideoTailFrameView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdVideoTailFrameView b;
    public Object c;

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au0(cv0 cv0Var, Object obj) {
        super(cv0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cv0Var, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((cv0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = obj;
    }

    @Override // com.baidu.nadcore.player.tail.AdVideoTailFrameView.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = this.c instanceof nn0;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a != null && this.c != null) {
            g();
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdVideoTailFrameView adVideoTailFrameView = this.b;
            if (adVideoTailFrameView != null && adVideoTailFrameView.r()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (adVideoTailFrameView = this.b) != null) {
            adVideoTailFrameView.z();
        }
    }

    public void m() {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (adVideoTailFrameView = this.b) != null) {
            adVideoTailFrameView.u();
        }
    }

    @Override // com.baidu.nadcore.player.tail.AdVideoTailFrameView.b
    public void b() {
        cv0 cv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Object obj = this.c;
            if (obj instanceof nn0) {
                if ("ad_full_video".equals(((nn0) obj).t)) {
                    if (this.a != null && h() && this.a.P()) {
                        if (this.a.y().Q0()) {
                            this.a.J(ds0.x(PlayerEvent.ACTION_ON_COMPLETE));
                        } else {
                            this.a.y().z().G(0);
                        }
                    }
                } else if ("ad_append_video".equals(((nn0) this.c).t) && (cv0Var = this.a) != null && cv0Var.P()) {
                    this.b.x(ClogBuilder.LogType.CLOSE.type, "", "");
                    this.a.S(8);
                    this.a.Q();
                    this.a.J(cs0.x("layer_event_ad_finish"));
                    if (!this.a.y().Y()) {
                        this.a.J(ds0.x(PlayerEvent.ACTION_ON_COMPLETE));
                    }
                }
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a == null) {
            return;
        }
        if (this.b == null) {
            AdVideoTailFrameView adVideoTailFrameView = new AdVideoTailFrameView(this.a.getContentView().getContext(), this.a, d());
            this.b = adVideoTailFrameView;
            this.a.O(adVideoTailFrameView);
        }
        this.b.n(d());
        this.b.setCallBack(this);
        Object obj = this.c;
        if (obj != null) {
            this.b.setData(obj);
            this.b.y();
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            cv0 cv0Var = this.a;
            if (cv0Var != null && cv0Var.y().j1() != null && this.a.y().j1().getVideoAd() != null && this.a.y().j1().getVideoAd().fullItemAdData != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j(boolean z) {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (adVideoTailFrameView = this.b) != null) {
            adVideoTailFrameView.t(z);
        }
    }

    public void k(boolean z) {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (adVideoTailFrameView = this.b) != null) {
            adVideoTailFrameView.n(z);
        }
    }
}
