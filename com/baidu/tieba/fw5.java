package com.baidu.tieba;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public final class fw5 extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public final float b;
    public final WheelView c;

    public fw5(WheelView wheelView, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView, Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = wheelView;
        this.b = f;
        this.a = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == 2.1474836E9f) {
                float f = 2000.0f;
                if (Math.abs(this.b) > 2000.0f) {
                    if (this.b <= 0.0f) {
                        f = -2000.0f;
                    }
                    this.a = f;
                } else {
                    this.a = this.b;
                }
            }
            if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
                this.c.b();
                this.c.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView wheelView = this.c;
            float f2 = (int) (this.a / 100.0f);
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.c.i()) {
                float itemHeight = this.c.getItemHeight();
                float f3 = (-this.c.getInitPosition()) * itemHeight;
                float itemsCount = ((this.c.getItemsCount() - 1) - this.c.getInitPosition()) * itemHeight;
                double d = itemHeight * 0.25d;
                if (this.c.getTotalScrollY() - d < f3) {
                    f3 = this.c.getTotalScrollY() + f2;
                } else if (this.c.getTotalScrollY() + d > itemsCount) {
                    itemsCount = this.c.getTotalScrollY() + f2;
                }
                if (this.c.getTotalScrollY() <= f3) {
                    this.a = 40.0f;
                    this.c.setTotalScrollY((int) f3);
                } else if (this.c.getTotalScrollY() >= itemsCount) {
                    this.c.setTotalScrollY((int) itemsCount);
                    this.a = -40.0f;
                }
            }
            float f4 = this.a;
            if (f4 < 0.0f) {
                this.a = f4 + 20.0f;
            } else {
                this.a = f4 - 20.0f;
            }
            this.c.getHandler().sendEmptyMessage(1000);
        }
    }
}
