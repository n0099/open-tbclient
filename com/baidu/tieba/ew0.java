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
public class ew0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yv0 a;
    public sv0 b;

    public ew0() {
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

    public yv0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (yv0) invokeV.objValue;
    }

    public void d() {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (yv0Var = this.a) != null) {
            yv0Var.onBufferEnd();
        }
    }

    public void e() {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (yv0Var = this.a) != null) {
            yv0Var.onBufferStart();
        }
    }

    public void k() {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (yv0Var = this.a) != null) {
            yv0Var.onPause();
        }
    }

    public void l() {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (yv0Var = this.a) != null) {
            yv0Var.onPrepared();
        }
    }

    public void m() {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (yv0Var = this.a) != null) {
            yv0Var.onResume();
        }
    }

    public void n() {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (yv0Var = this.a) != null) {
            yv0Var.onSeekEnd();
        }
    }

    public void o() {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (yv0Var = this.a) != null) {
            yv0Var.onStart();
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
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (yv0Var = this.a) != null) {
            yv0Var.onEnd(i);
        }
    }

    public void i(m01 m01Var) {
        sv0 sv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, m01Var) == null) && (sv0Var = this.b) != null) {
            sv0Var.a(m01Var);
        }
    }

    public void j(m01 m01Var) {
        sv0 sv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, m01Var) == null) && (sv0Var = this.b) != null) {
            sv0Var.b(m01Var);
        }
    }

    public void s(yv0 yv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, yv0Var) == null) {
            this.a = yv0Var;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.PlayerEvent.ACTION_SEEK_COMPLETE) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx0Var) == null) {
            char c = 4;
            if (mx0Var.getType() == 4 || mx0Var.getType() == 2) {
                String c2 = mx0Var.c();
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
                        int g = mx0Var.g(1);
                        h(g, mx0Var.g(2), mx0Var.f(3));
                        a(g);
                        return;
                    case 1:
                        g(mx0Var.g(1), mx0Var.g(2), mx0Var.f(3));
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
                        q(mx0Var.g(5), mx0Var.g(6));
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
        yv0 yv0Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, obj) == null) && (yv0Var = this.a) != null) {
            if (obj != null) {
                str = obj.toString();
            } else {
                str = "";
            }
            yv0Var.onError(i, i2, str);
        }
    }

    public void h(int i, int i2, Object obj) {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, obj) == null) && (yv0Var = this.a) != null) {
            yv0Var.onInfo(i, i2);
        }
    }

    public void p(int i, int i2, int i3) {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) && (yv0Var = this.a) != null) {
            yv0Var.onUpdateProgress(i, i2, i3);
        }
    }

    public void q(int i, int i2) {
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) && (yv0Var = this.a) != null) {
            yv0Var.onVideoSizeChanged(i, i2);
        }
    }
}
