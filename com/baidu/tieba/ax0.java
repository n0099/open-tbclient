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
/* loaded from: classes4.dex */
public class ax0 extends sw0 implements AdVideoTailFrameView.b {
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
    public ax0(cy0 cy0Var, Object obj) {
        super(cy0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cy0Var, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((cy0) newInitContext.callArgs[0]);
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
            boolean z = this.c instanceof qq0;
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
            if (adVideoTailFrameView != null && adVideoTailFrameView.q()) {
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
            adVideoTailFrameView.y();
        }
    }

    public void m() {
        AdVideoTailFrameView adVideoTailFrameView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (adVideoTailFrameView = this.b) != null) {
            adVideoTailFrameView.t();
        }
    }

    @Override // com.baidu.nadcore.player.tail.AdVideoTailFrameView.b
    public void b() {
        cy0 cy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Object obj = this.c;
            if (obj instanceof qq0) {
                if ("ad_full_video".equals(((qq0) obj).s)) {
                    if (this.a != null && h() && this.a.O()) {
                        if (this.a.u().V0()) {
                            this.a.H(cv0.w(PlayerEvent.ACTION_ON_COMPLETE));
                        } else {
                            this.a.u().y().G(0);
                        }
                    }
                } else if ("ad_append_video".equals(((qq0) this.c).s) && (cy0Var = this.a) != null && cy0Var.O()) {
                    this.b.u(ClogBuilder.LogType.CLOSE.type, "", "");
                    this.a.R(8);
                    this.a.P();
                    this.a.H(bv0.w("layer_event_ad_finish"));
                    if (!this.a.u().a0()) {
                        this.a.H(cv0.w(PlayerEvent.ACTION_ON_COMPLETE));
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
            this.a.N(adVideoTailFrameView);
        }
        this.b.n(d());
        this.b.setCallBack(this);
        Object obj = this.c;
        if (obj != null) {
            this.b.setData(obj);
            this.b.x();
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            cy0 cy0Var = this.a;
            if (cy0Var != null && cy0Var.u().o1() != null && this.a.u().o1().getVideoAd() != null && this.a.u().o1().getVideoAd().fullItemAdData != null) {
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
            adVideoTailFrameView.s(z);
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
