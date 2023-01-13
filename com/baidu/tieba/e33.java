package com.baidu.tieba;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public final class e33 extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public final WheelView3d d;

    public e33(WheelView3d wheelView3d, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = wheelView3d;
        this.c = i;
        this.a = Integer.MAX_VALUE;
        this.b = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == Integer.MAX_VALUE) {
                this.a = this.c;
            }
            int i = this.a;
            int i2 = (int) (i * 0.1f);
            this.b = i2;
            if (i2 == 0) {
                if (i < 0) {
                    this.b = -1;
                } else {
                    this.b = 1;
                }
            }
            if (Math.abs(this.a) <= 1) {
                this.d.b();
                this.d.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView3d wheelView3d = this.d;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.b);
            if (!this.d.i()) {
                float itemHeight = this.d.getItemHeight();
                float itemsCount = ((this.d.getItemsCount() - 1) - this.d.getInitPosition()) * itemHeight;
                if (this.d.getTotalScrollY() <= (-this.d.getInitPosition()) * itemHeight || this.d.getTotalScrollY() >= itemsCount) {
                    WheelView3d wheelView3d2 = this.d;
                    wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.b);
                    this.d.b();
                    this.d.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.d.getHandler().sendEmptyMessage(1000);
            this.a -= this.b;
        }
    }
}
