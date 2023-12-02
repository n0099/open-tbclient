package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class er0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yq0 a;
    public sq0 b;

    public er0() {
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

    public yq0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (yq0) invokeV.objValue;
    }

    public void d() {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (yq0Var = this.a) != null) {
            yq0Var.onBufferEnd();
        }
    }

    public void e() {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (yq0Var = this.a) != null) {
            yq0Var.onBufferStart();
        }
    }

    public void k() {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (yq0Var = this.a) != null) {
            yq0Var.onPause();
        }
    }

    public void l() {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (yq0Var = this.a) != null) {
            yq0Var.onPrepared();
        }
    }

    public void m() {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (yq0Var = this.a) != null) {
            yq0Var.onResume();
        }
    }

    public void n() {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (yq0Var = this.a) != null) {
            yq0Var.onSeekEnd();
        }
    }

    public void o() {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (yq0Var = this.a) != null) {
            yq0Var.onStart();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a = null;
            this.b = null;
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (701 == i) {
                e();
            } else if (702 == i) {
                d();
            }
        }
    }

    public void f(int i) {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (yq0Var = this.a) != null) {
            yq0Var.onEnd(i);
        }
    }

    public void i(lv0 lv0Var) {
        sq0 sq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lv0Var) == null) && (sq0Var = this.b) != null) {
            sq0Var.a(lv0Var);
        }
    }

    public void j(lv0 lv0Var) {
        sq0 sq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, lv0Var) == null) && (sq0Var = this.b) != null) {
            sq0Var.b(lv0Var);
        }
    }

    public void s(yq0 yq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, yq0Var) == null) {
            this.a = yq0Var;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.PlayerEvent.ACTION_SEEK_COMPLETE) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ms0Var) == null) {
            char c = 4;
            if (ms0Var.m() == 4 || ms0Var.m() == 2) {
                String c2 = ms0Var.c();
                switch (c2.hashCode()) {
                    case -1502879971:
                        if (c2.equals(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1244137507:
                        break;
                    case -525235558:
                        if (c2.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -461848373:
                        if (c2.equals(PlayerEvent.ACTION_ON_ERROR)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 154871702:
                        if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 720027695:
                        if (c2.equals(ControlEvent.ACTION_PAUSE)) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 723345051:
                        if (c2.equals(ControlEvent.ACTION_START)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 906917140:
                        if (c2.equals(ControlEvent.ACTION_RESUME)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1370689931:
                        if (c2.equals(PlayerEvent.ACTION_ON_INFO)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1547354793:
                        if (c2.equals(ControlEvent.ACTION_STOP)) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        int g = ms0Var.g(1);
                        h(g, ms0Var.g(2), ms0Var.f(3));
                        a(g);
                        return;
                    case 1:
                        g(ms0Var.g(1), ms0Var.g(2), ms0Var.f(3));
                        return;
                    case 2:
                        l();
                        return;
                    case 3:
                        f(307);
                        return;
                    case 4:
                        n();
                        return;
                    case 5:
                        q(ms0Var.g(5), ms0Var.g(6));
                        return;
                    case 6:
                        o();
                        return;
                    case 7:
                        m();
                        return;
                    case '\b':
                        k();
                        return;
                    case '\t':
                        f(0);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void g(int i, int i2, Object obj) {
        yq0 yq0Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, obj) == null) && (yq0Var = this.a) != null) {
            if (obj != null) {
                str = obj.toString();
            } else {
                str = "";
            }
            yq0Var.onError(i, i2, str);
        }
    }

    public void h(int i, int i2, Object obj) {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, obj) == null) && (yq0Var = this.a) != null) {
            yq0Var.onInfo(i, i2);
        }
    }

    public void p(int i, int i2, int i3) {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) && (yq0Var = this.a) != null) {
            yq0Var.onUpdateProgress(i, i2, i3);
        }
    }

    public void q(int i, int i2) {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) && (yq0Var = this.a) != null) {
            yq0Var.onVideoSizeChanged(i, i2);
        }
    }
}
