package com.baidu.tieba;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.container.NadBrowserContainer;
import com.baidu.nadcore.webviewx.container.base.AbsContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class er0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NadBrowserContainer a;
    public AbsContainer b;
    public int c;

    public er0(br0 frameContext, cr0 frameExtHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameContext, frameExtHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(frameContext, "frameContext");
        Intrinsics.checkNotNullParameter(frameExtHandler, "frameExtHandler");
        this.c = -1;
        if (n()) {
            this.a = new NadBrowserContainer(frameContext, frameExtHandler, null);
            this.c = 1;
            return;
        }
        this.b = gb1.a.b(frameContext, frameExtHandler, d());
        this.c = 0;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.c;
            if (i == 1) {
                NadBrowserContainer nadBrowserContainer = this.a;
                if (nadBrowserContainer != null) {
                    nadBrowserContainer.t0(false);
                }
            } else if (i == 0) {
                AbsContainer absContainer = this.b;
                if (absContainer != null) {
                    absContainer.x("1");
                }
                AbsContainer absContainer2 = this.b;
                if (absContainer2 != null) {
                    absContainer2.y(false);
                }
            }
        }
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final Integer c() {
        InterceptResult invokeV;
        int W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AbsContainer absContainer = this.b;
            if (absContainer != null) {
                W = absContainer.h();
            } else {
                NadBrowserContainer nadBrowserContainer = this.a;
                if (nadBrowserContainer != null) {
                    W = nadBrowserContainer.W();
                } else {
                    return null;
                }
            }
            return Integer.valueOf(W);
        }
        return (Integer) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return eo0.b().a().a("key_webview_core_type", 1);
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            AbsContainer absContainer = this.b;
            if (absContainer != null) {
                absContainer.o();
            }
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null) {
                nadBrowserContainer.t();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AbsContainer absContainer = this.b;
            if (absContainer != null) {
                absContainer.p();
            }
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null) {
                nadBrowserContainer.onDestroy();
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            AbsContainer absContainer = this.b;
            if (absContainer != null) {
                absContainer.q();
            }
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null) {
                nadBrowserContainer.onPause();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AbsContainer absContainer = this.b;
            if (absContainer != null) {
                absContainer.s();
            }
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null) {
                nadBrowserContainer.v();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AbsContainer absContainer = this.b;
            if (absContainer != null) {
                absContainer.t();
            }
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null) {
                nadBrowserContainer.w();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AbsContainer absContainer = this.b;
            if (absContainer != null) {
                absContainer.u();
            }
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null) {
                nadBrowserContainer.x();
            }
        }
    }

    public final View l() {
        InterceptResult invokeV;
        View e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AbsContainer absContainer = this.b;
            if (absContainer == null || (e = absContainer.e()) == null) {
                NadBrowserContainer nadBrowserContainer = this.a;
                if (nadBrowserContainer != null) {
                    return nadBrowserContainer.T();
                }
                return null;
            }
            return e;
        }
        return (View) invokeV.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (eo0.b().a().a("use_nairobi", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean g(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        AbsContainer absContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, keyEvent)) == null) {
            int i2 = this.c;
            if (i2 == 1) {
                NadBrowserContainer nadBrowserContainer = this.a;
                if (nadBrowserContainer == null) {
                    return false;
                }
                return nadBrowserContainer.onKeyDown(i, keyEvent);
            } else if (i2 != 0 || (absContainer = this.b) == null) {
                return false;
            } else {
                return absContainer.onKeyDown(i, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public final void m(JSONObject jSONObject) {
        Intent q;
        Intent q2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) && jSONObject != null) {
            NadBrowserContainer nadBrowserContainer = this.a;
            if (nadBrowserContainer != null && (q2 = nadBrowserContainer.q()) != null) {
                q2.putExtra("immersive_video_stay_time", jSONObject.optString("immersive_video_stay_time"));
            }
            NadBrowserContainer nadBrowserContainer2 = this.a;
            if (nadBrowserContainer2 != null && (q = nadBrowserContainer2.q()) != null) {
                q.putExtra("immersive_webview_first_show_time", jSONObject.optString("immersive_webview_first_show_time"));
            }
        }
    }
}
