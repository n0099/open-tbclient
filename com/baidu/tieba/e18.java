package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.CountDownTimer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.ejection.value.Direction;
import com.baidu.tieba.pb.ejection.value.LifeCycleState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e18 extends d18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final PorterDuffColorFilter B;
    public Bitmap z;

    /* loaded from: classes4.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e18 e18Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e18Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e18Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e18 e18Var = this.a;
                e18Var.v = LifeCycleState.DEAD;
                e18Var.w.cancel();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                if (j <= 2000) {
                    e18 e18Var = this.a;
                    e18Var.g = (int) (e18Var.g - e18Var.h);
                }
                e18 e18Var2 = this.a;
                int i = e18Var2.t + 10;
                e18Var2.t = i;
                if (i > 360) {
                    e18Var2.t = 0;
                }
            }
        }
    }

    public e18(Bitmap bitmap, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = false;
        this.z = bitmap;
        this.b = i;
        this.c = i2;
        this.d = i;
        this.e = i2;
        int nextInt = this.x.nextInt(91) + 45;
        this.a = nextInt;
        if (nextInt < 90) {
            this.o = Direction.RIGHT;
        } else {
            this.o = Direction.LEFT;
            this.a = 180 - nextInt;
        }
        int sqrt = (int) (Math.sqrt(Math.pow(bitmap.getWidth(), 2.0d) + Math.pow(bitmap.getHeight(), 2.0d)) / 2.0d);
        this.f = sqrt;
        this.p = sqrt;
        this.q = i3 - sqrt;
        this.r = sqrt;
        this.s = i4 - sqrt;
        this.B = new PorterDuffColorFilter(SkinManager.getColor(R.color.CAM_X0501), PorterDuff.Mode.SRC_ATOP);
        a aVar = new a(this, 3000L, 10L);
        this.w = aVar;
        aVar.start();
    }

    @Override // com.baidu.tieba.d18
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.A) {
                this.A = true;
                return;
            }
            int i = this.l + 1;
            this.l = i;
            this.i = (int) ((this.k * i) + ((this.m * Math.pow(i, 2.0d)) / 2.0d));
            double radians = Math.toRadians(this.a);
            if (this.n == Direction.TOP) {
                if (this.o == Direction.RIGHT) {
                    f(radians);
                } else {
                    d(radians);
                }
            } else if (this.o == Direction.RIGHT) {
                e(radians);
            } else {
                c(radians);
            }
        }
    }

    @Override // com.baidu.tieba.d18
    public void b(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) && (bitmap = this.z) != null && !bitmap.isRecycled()) {
            if (this.g < 0) {
                this.g = 0;
            }
            this.u.setAlpha(this.g);
            int i = this.y;
            if (i == 4 || i == 1) {
                this.u.setColorFilter(this.B);
            }
            canvas.save();
            canvas.rotate(this.t, this.d, this.e);
            Bitmap bitmap2 = this.z;
            canvas.drawBitmap(bitmap2, this.d - (bitmap2.getWidth() / 2.0f), this.e - (this.z.getHeight() / 2.0f), this.u);
            canvas.restore();
        }
    }

    public final void c(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d)}) == null) {
            this.d = this.b - ((int) ((this.i - this.j) * Math.cos(d)));
            this.e = this.c + ((int) ((this.i - this.j) * Math.sin(d)));
            int i = this.d;
            int i2 = this.p;
            if (i <= i2) {
                int tan = this.c + ((int) ((this.b - i2) * Math.tan(d)));
                this.e = tan;
                this.o = Direction.RIGHT;
                int i3 = this.p;
                this.b = i3;
                this.c = tan;
                this.d = i3;
                this.j = this.i;
            }
            int i4 = this.e;
            int i5 = this.s;
            if (i4 >= i5) {
                int tan2 = this.b - ((int) ((i5 - this.c) / Math.tan(d)));
                this.d = tan2;
                this.n = Direction.TOP;
                int i6 = this.s;
                this.c = i6;
                this.b = tan2;
                this.e = i6;
                this.j = this.i;
            }
        }
    }

    public final void d(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d)}) == null) {
            this.d = this.b - ((int) ((this.i - this.j) * Math.cos(d)));
            this.e = this.c - ((int) ((this.i - this.j) * Math.sin(d)));
            int i = this.d;
            int i2 = this.p;
            if (i <= i2) {
                int tan = this.c - ((int) ((this.b - i2) * Math.tan(d)));
                this.e = tan;
                this.o = Direction.RIGHT;
                int i3 = this.p;
                this.b = i3;
                this.c = tan;
                this.d = i3;
                this.j = this.i;
            }
            int i4 = this.e;
            int i5 = this.r;
            if (i4 <= i5) {
                int tan2 = this.b - ((int) ((this.c - i5) / Math.tan(d)));
                this.d = tan2;
                this.n = Direction.BOTTOM;
                int i6 = this.r;
                this.c = i6;
                this.b = tan2;
                this.e = i6;
                this.j = this.i;
            }
        }
    }

    public final void e(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d)}) == null) {
            this.d = ((int) ((this.i - this.j) * Math.cos(d))) + this.b;
            this.e = this.c + ((int) ((this.i - this.j) * Math.sin(d)));
            int i = this.d;
            int i2 = this.q;
            if (i >= i2) {
                int tan = this.c + ((int) ((i2 - this.b) * Math.tan(d)));
                this.e = tan;
                this.o = Direction.LEFT;
                int i3 = this.q;
                this.b = i3;
                this.c = tan;
                this.d = i3;
                this.j = this.i;
            }
            int i4 = this.e;
            int i5 = this.s;
            if (i4 >= i5) {
                int tan2 = this.b + ((int) ((i5 - this.c) / Math.tan(d)));
                this.d = tan2;
                this.n = Direction.TOP;
                int i6 = this.s;
                this.c = i6;
                this.b = tan2;
                this.e = i6;
                this.j = this.i;
            }
        }
    }

    public final void f(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d)}) == null) {
            this.d = ((int) ((this.i - this.j) * Math.cos(d))) + this.b;
            this.e = this.c - ((int) ((this.i - this.j) * Math.sin(d)));
            int i = this.d;
            int i2 = this.q;
            if (i >= i2) {
                int tan = this.c - ((int) ((i2 - this.b) * Math.tan(d)));
                this.e = tan;
                this.j = this.i;
                this.o = Direction.LEFT;
                int i3 = this.q;
                this.b = i3;
                this.c = tan;
                this.d = i3;
            }
            int i4 = this.e;
            int i5 = this.r;
            if (i4 <= i5) {
                int tan2 = this.b + ((int) ((this.c - i5) / Math.tan(d)));
                this.d = tan2;
                this.n = Direction.BOTTOM;
                this.b = tan2;
                int i6 = this.r;
                this.c = i6;
                this.e = i6;
                this.j = this.i;
            }
        }
    }
}
