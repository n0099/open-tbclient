package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class cs0 extends es0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> b;

    public cs0() {
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
        this.b = new ArrayList<>(13);
        e();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c(bs0.x(PlayerEvent.ACTION_ON_COMPLETE));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c(bs0.x(PlayerEvent.ACTION_PLAYER_ATTACH));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c(bs0.x(PlayerEvent.ACTION_PLAYER_DETACH));
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c(bs0.x(PlayerEvent.ACTION_ON_PREPARED));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c(bs0.x(PlayerEvent.ACTION_SEEK_COMPLETE));
        }
    }

    @Override // com.baidu.tieba.es0
    public void c(@NonNull ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ks0Var) == null) {
            super.c(ks0Var);
        }
    }

    public final boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.b.contains(Integer.valueOf(i));
        }
        return invokeI.booleanValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            ks0 x = bs0.x(PlayerEvent.ACTION_BUFFER_UPDATE);
            x.o(2, Integer.valueOf(i));
            x.s(1);
            c(x);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.add(904);
            this.b.add(701);
            this.b.add(702);
            this.b.add(11004);
            this.b.add(11005);
            this.b.add(946);
            this.b.add(924);
            this.b.add(5000);
            this.b.add(937);
            this.b.add(936);
            this.b.add(955);
            this.b.add(956);
            this.b.add(910);
            this.b.add(10103);
            this.b.add(12005);
            this.b.add(12006);
            this.b.add(10009);
        }
    }

    public boolean h(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i, i2, obj)) == null) {
            ks0 x = bs0.x(PlayerEvent.ACTION_ON_ERROR);
            x.o(1, Integer.valueOf(i));
            x.o(2, Integer.valueOf(i2));
            x.o(3, obj);
            c(x);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public void j(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, obj) == null) {
            ks0 x = bs0.x(PlayerEvent.ACTION_MEDIA_SOURCE_CHANGED);
            x.o(7, Integer.valueOf(i));
            x.o(8, Integer.valueOf(i2));
            x.o(3, obj);
            c(x);
        }
    }

    public boolean i(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i, i2, obj)) == null) {
            jx0.h("player trigger on info what:" + i);
            if (d(i)) {
                ks0 x = bs0.x(PlayerEvent.ACTION_ON_INFO);
                if (i == 910) {
                    x.s(1);
                }
                x.o(1, Integer.valueOf(i));
                x.o(2, Integer.valueOf(i2));
                x.o(3, obj);
                c(x);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public void o(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
            ks0 x = bs0.x(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED);
            x.o(5, Integer.valueOf(i));
            x.o(6, Integer.valueOf(i2));
            c(x);
        }
    }

    public void p(String str, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            ks0 x = bs0.x(PlayerEvent.ACTION_SET_DATA_SOURCE);
            aw0 aw0Var = new aw0();
            aw0Var.a = str;
            aw0Var.c = z;
            aw0Var.d = i;
            x.o(3, aw0Var);
            x.t(1);
            c(x);
        }
    }
}
