package com.baidu.tbadk.widget.timepicker.wheel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.f1.p.b.c.b;
import c.a.q0.f1.p.b.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class WheelView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public float B;
    public boolean C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public long R;
    public int S;
    public int T;
    public int U;
    public int V;
    public float W;

    /* renamed from: e  reason: collision with root package name */
    public DividerType f49080e;

    /* renamed from: f  reason: collision with root package name */
    public Context f49081f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f49082g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector f49083h;

    /* renamed from: i  reason: collision with root package name */
    public b f49084i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49085j;
    public boolean k;
    public ScheduledExecutorService l;
    public ScheduledFuture<?> m;
    public Paint n;
    public Paint o;
    public Paint p;
    public c.a.q0.f1.p.b.a.a q;
    public String r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public Typeface x;
    public int y;
    public int z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class ACTION {
        public static final /* synthetic */ ACTION[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ACTION CLICK;
        public static final ACTION DAGGLE;
        public static final ACTION FLING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(858333015, "Lcom/baidu/tbadk/widget/timepicker/wheel/view/WheelView$ACTION;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(858333015, "Lcom/baidu/tbadk/widget/timepicker/wheel/view/WheelView$ACTION;");
                    return;
                }
            }
            CLICK = new ACTION("CLICK", 0);
            FLING = new ACTION("FLING", 1);
            ACTION action = new ACTION("DAGGLE", 2);
            DAGGLE = action;
            $VALUES = new ACTION[]{CLICK, FLING, action};
        }

        public ACTION(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ACTION valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ACTION) Enum.valueOf(ACTION.class, str) : (ACTION) invokeL.objValue;
        }

        public static ACTION[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ACTION[]) $VALUES.clone() : (ACTION[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class DividerType {
        public static final /* synthetic */ DividerType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DividerType FILL;
        public static final DividerType WRAP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1386663562, "Lcom/baidu/tbadk/widget/timepicker/wheel/view/WheelView$DividerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1386663562, "Lcom/baidu/tbadk/widget/timepicker/wheel/view/WheelView$DividerType;");
                    return;
                }
            }
            FILL = new DividerType("FILL", 0);
            DividerType dividerType = new DividerType("WRAP", 1);
            WRAP = dividerType;
            $VALUES = new DividerType[]{FILL, dividerType};
        }

        public DividerType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DividerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DividerType) Enum.valueOf(DividerType.class, str) : (DividerType) invokeL.objValue;
        }

        public static DividerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DividerType[]) $VALUES.clone() : (DividerType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WheelView f49086e;

        public a(WheelView wheelView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wheelView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49086e = wheelView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49086e.f49084i.a(this.f49086e.getCurrentItem());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WheelView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return "";
            }
            if (obj instanceof c.a.q0.f1.p.b.b.a) {
                return ((c.a.q0.f1.p.b.b.a) obj).a();
            }
            return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < 0) {
                return c(i2 + this.q.a());
            }
            return i2 > this.q.a() + (-1) ? c(i2 - this.q.a()) : i2;
        }
        return invokeI.intValue;
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (scheduledFuture = this.m) == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.m.cancel(true);
        this.m = null;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f49081f = context;
            this.f49082g = new c.a.q0.f1.p.b.d.b(this);
            GestureDetector gestureDetector = new GestureDetector(context, new c.a.q0.f1.p.b.c.a(this));
            this.f49083h = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
            this.C = true;
            this.G = 0.0f;
            this.H = -1;
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Paint paint = new Paint();
            this.n = paint;
            paint.setColor(this.y);
            this.n.setAntiAlias(true);
            this.n.setTypeface(this.x);
            this.n.setTextSize(this.s);
            Paint paint2 = new Paint();
            this.o = paint2;
            paint2.setColor(this.z);
            this.o.setAntiAlias(true);
            this.o.setTextScaleX(1.1f);
            this.o.setTypeface(this.x);
            this.o.setTextSize(this.s);
            Paint paint3 = new Paint();
            this.p = paint3;
            paint3.setColor(this.A);
            this.p.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            float f2 = this.B;
            if (f2 < 1.0f) {
                this.B = 1.0f;
            } else if (f2 > 4.0f) {
                this.B = 4.0f;
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Rect rect = new Rect();
            for (int i2 = 0; i2 < this.q.a(); i2++) {
                String b2 = b(this.q.getItem(i2));
                this.o.getTextBounds(b2, 0, b2.length(), rect);
                int width = rect.width();
                if (width > this.t) {
                    this.t = width;
                }
                this.o.getTextBounds("星期", 0, 2, rect);
                this.u = rect.height() + 2;
            }
            this.w = this.B * this.u;
        }
    }

    public final c.a.q0.f1.p.b.a.a getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q : (c.a.q0.f1.p.b.a.a) invokeV.objValue;
    }

    public final int getCurrentItem() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.q0.f1.p.b.a.a aVar = this.q;
            if (aVar == null) {
                return 0;
            }
            if (this.C && ((i2 = this.I) < 0 || i2 >= aVar.a())) {
                return Math.max(0, Math.min(Math.abs(Math.abs(this.I) - this.q.a()), this.q.a() - 1));
            }
            return Math.max(0, Math.min(this.I, this.q.a() - 1));
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f49082g : (Handler) invokeV.objValue;
    }

    public int getInitPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.H : invokeV.intValue;
    }

    public float getItemHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : invokeV.floatValue;
    }

    public int getItemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.q0.f1.p.b.a.a aVar = this.q;
            if (aVar != null) {
                return aVar.a();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getTextWidth(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, paint, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 += (int) Math.ceil(fArr[i3]);
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public float getTotalScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.G : invokeV.floatValue;
    }

    public final void h(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            Rect rect = new Rect();
            this.o.getTextBounds(str, 0, str.length(), rect);
            int i2 = this.T;
            if (i2 == 3) {
                this.U = 0;
            } else if (i2 == 5) {
                this.U = (this.N - rect.width()) - ((int) this.W);
            } else if (i2 != 17) {
            } else {
                if (!this.f49085j && (str2 = this.r) != null && !str2.equals("") && this.k) {
                    this.U = (int) ((this.N - rect.width()) * 0.25d);
                } else {
                    this.U = (int) ((this.N - rect.width()) * 0.5d);
                }
            }
        }
    }

    public final void i(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            Rect rect = new Rect();
            this.n.getTextBounds(str, 0, str.length(), rect);
            int i2 = this.T;
            if (i2 == 3) {
                this.V = 0;
            } else if (i2 == 5) {
                this.V = (this.N - rect.width()) - ((int) this.W);
            } else if (i2 != 17) {
            } else {
                if (!this.f49085j && (str2 = this.r) != null && !str2.equals("") && this.k) {
                    this.V = (int) ((this.N - rect.width()) * 0.25d);
                } else {
                    this.V = (int) ((this.N - rect.width()) * 0.5d);
                }
            }
        }
    }

    public void isCenterLabel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.k = z;
        }
    }

    public boolean isLoop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Rect rect = new Rect();
            this.o.getTextBounds(str, 0, str.length(), rect);
            int i2 = this.s;
            for (int width = rect.width(); width > this.N; width = rect.width()) {
                i2--;
                this.o.setTextSize(i2);
                this.o.getTextBounds(str, 0, str.length(), rect);
            }
            this.n.setTextSize(i2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.q == null) {
            return;
        }
        g();
        int i2 = (int) (this.w * (this.L - 1));
        this.M = (int) ((i2 * 2) / 3.141592653589793d);
        this.O = (int) (i2 / 3.141592653589793d);
        this.N = View.MeasureSpec.getSize(this.S);
        int i3 = this.M;
        float f2 = this.w;
        this.D = (i3 - f2) / 2.0f;
        float f3 = (i3 + f2) / 2.0f;
        this.E = f3;
        this.F = (f3 - ((f2 - this.u) / 2.0f)) - this.W;
        if (this.H == -1) {
            if (this.C) {
                this.H = (this.q.a() + 1) / 2;
            } else {
                this.H = 0;
            }
        }
        this.J = this.H;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, canvas) == null) || this.q == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.H), this.q.a() - 1);
        this.H = min;
        Object[] objArr = new Object[this.L];
        int i3 = (int) (this.G / this.w);
        this.K = i3;
        try {
            this.J = min + (i3 % this.q.a());
        } catch (ArithmeticException unused) {
        }
        if (!this.C) {
            if (this.J < 0) {
                this.J = 0;
            }
            if (this.J > this.q.a() - 1) {
                this.J = this.q.a() - 1;
            }
        } else {
            if (this.J < 0) {
                this.J = this.q.a() + this.J;
            }
            if (this.J > this.q.a() - 1) {
                this.J -= this.q.a();
            }
        }
        float f2 = this.G % this.w;
        int i4 = 0;
        while (true) {
            int i5 = this.L;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.J - ((i5 / 2) - i4);
            if (this.C) {
                objArr[i4] = this.q.getItem(c(i6));
            } else if (i6 < 0) {
                objArr[i4] = "";
            } else if (i6 > this.q.a() - 1) {
                objArr[i4] = "";
            } else {
                objArr[i4] = this.q.getItem(i6);
            }
            i4++;
        }
        if (this.f49080e == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.r)) {
                i2 = (this.N - this.t) / 2;
            } else {
                i2 = (this.N - this.t) / 4;
            }
            float f3 = i2 - 12;
            float f4 = f3 <= 0.0f ? 10.0f : f3;
            float f5 = this.N - f4;
            float f6 = this.D;
            float f7 = f4;
            canvas.drawLine(f7, f6, f5, f6, this.p);
            float f8 = this.E;
            canvas.drawLine(f7, f8, f5, f8, this.p);
        } else {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
            float f9 = this.D;
            float f10 = dimenPixelSize;
            canvas.drawRect(0.0f, f9, this.N, f9 + f10, this.p);
            float f11 = this.E;
            canvas.drawRect(0.0f, f11 - f10, this.N, f11, this.p);
        }
        if (!TextUtils.isEmpty(this.r) && this.k) {
            canvas.drawText(this.r, (this.N - getTextWidth(this.o, this.r)) - this.W, this.F, this.o);
        }
        for (int i7 = 0; i7 < this.L; i7++) {
            canvas.save();
            double d2 = ((this.w * i7) - f2) / this.O;
            float f12 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f12 < 90.0f && f12 > -90.0f) {
                float pow = (float) Math.pow(Math.abs(f12) / 90.0f, 2.2d);
                String b2 = (!this.k && !TextUtils.isEmpty(this.r) && !TextUtils.isEmpty(b(objArr[i7]))) ? b(objArr[i7]) + this.r : b(objArr[i7]);
                j(b2);
                h(b2);
                i(b2);
                float cos = (float) ((this.O - (Math.cos(d2) * this.O)) - ((Math.sin(d2) * this.u) / 2.0d));
                canvas.translate(0.0f, cos);
                float f13 = this.D;
                if (cos <= f13 && this.u + cos >= f13) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.N, this.D - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(b2, this.V, this.u, this.n);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.D - cos, this.N, (int) this.w);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(b2, this.U, this.u - this.W, this.o);
                    canvas.restore();
                } else {
                    float f14 = this.E;
                    if (cos <= f14 && this.u + cos >= f14) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.N, this.E - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        canvas.drawText(b2, this.U, this.u - this.W, this.o);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.E - cos, this.N, (int) this.w);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        canvas.drawText(b2, this.V, this.u, this.n);
                        canvas.restore();
                    } else {
                        if (cos >= this.D) {
                            int i8 = this.u;
                            if (i8 + cos <= this.E) {
                                canvas.drawText(b2, this.U, i8 - this.W, this.o);
                                this.I = this.J - ((this.L / 2) - i7);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.N, (int) this.w);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        Paint paint = this.n;
                        int i9 = this.v;
                        paint.setTextSkewX((i9 == 0 ? 0 : i9 > 0 ? 1 : -1) * (f12 <= 0.0f ? 1 : -1) * 0.5f * pow);
                        this.n.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(b2, this.V + (this.v * pow), this.u, this.n);
                        canvas.restore();
                        canvas.restore();
                        this.o.setTextSize(this.s);
                    }
                }
                canvas.restore();
                this.o.setTextSize(this.s);
            } else {
                canvas.restore();
            }
        }
    }

    public final void onItemSelected() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.f49084i == null) {
            return;
        }
        postDelayed(new a(this), 200L);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            this.S = i2;
            k();
            setMeasuredDimension(this.N, this.M);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            boolean onTouchEvent = this.f49083h.onTouchEvent(motionEvent);
            float f2 = (-this.H) * this.w;
            float a2 = ((this.q.a() - 1) - this.H) * this.w;
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.R = System.currentTimeMillis();
                cancelFuture();
                this.Q = motionEvent.getRawY();
            } else if (action == 2) {
                float rawY = this.Q - motionEvent.getRawY();
                this.Q = motionEvent.getRawY();
                float f3 = this.G + rawY;
                this.G = f3;
                if (!this.C && ((f3 - (this.w * 0.25f) < f2 && rawY < 0.0f) || (this.G + (this.w * 0.25f) > a2 && rawY > 0.0f))) {
                    this.G -= rawY;
                    z = true;
                }
            } else if (!onTouchEvent) {
                float y = motionEvent.getY();
                int i2 = this.O;
                float f4 = this.w;
                this.P = (int) (((((int) (((Math.acos((i2 - y) / i2) * this.O) + (f4 / 2.0f)) / f4)) - (this.L / 2)) * f4) - (((this.G % f4) + f4) % f4));
                if (System.currentTimeMillis() - this.R > 120) {
                    smoothScroll(ACTION.DAGGLE);
                } else {
                    smoothScroll(ACTION.CLICK);
                }
            }
            if (!z && motionEvent.getAction() != 0) {
                invalidate();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void scrollBy(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f2) == null) {
            cancelFuture();
            this.m = this.l.scheduleWithFixedDelay(new c.a.q0.f1.p.b.d.a(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
        }
    }

    public final void setAdapter(c.a.q0.f1.p.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            this.q = aVar;
            k();
            invalidate();
        }
    }

    public final void setCenterTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, typeface) == null) {
            this.o.setTypeface(typeface);
        }
    }

    public final void setCurrentItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.I = i2;
            this.H = i2;
            this.G = 0.0f;
            invalidate();
        }
    }

    public final void setCyclic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.C = z;
        }
    }

    public void setDividerColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.A = i2;
            this.p.setColor(i2);
        }
    }

    public void setDividerType(DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, dividerType) == null) {
            this.f49080e = dividerType;
        }
    }

    public void setGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.T = i2;
        }
    }

    public void setIsOptions(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f49085j = z;
        }
    }

    public void setItemsVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.L = i2;
        }
    }

    public void setLabel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.r = str;
        }
    }

    public void setLineSpacingMultiplier(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048612, this, f2) == null) || f2 == 0.0f) {
            return;
        }
        this.B = f2;
        f();
    }

    public final void setOnItemSelectedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bVar) == null) {
            this.f49084i = bVar;
        }
    }

    public void setTextColorCenter(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.z = i2;
            this.o.setColor(i2);
        }
    }

    public void setTextColorOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.y = i2;
            this.n.setColor(i2);
        }
    }

    public final void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048616, this, f2) == null) || f2 <= 0.0f) {
            return;
        }
        int i2 = (int) (this.f49081f.getResources().getDisplayMetrics().density * f2);
        this.s = i2;
        this.n.setTextSize(i2);
        this.o.setTextSize(this.s);
    }

    public void setTextXOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.v = i2;
            if (i2 != 0) {
                this.o.setTextScaleX(1.0f);
            }
        }
    }

    public void setTotalScrollY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            this.G = f2;
        }
    }

    public final void setTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, typeface) == null) {
            this.x = typeface;
            this.n.setTypeface(typeface);
            this.o.setTypeface(this.x);
        }
    }

    public void smoothScroll(ACTION action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, action) == null) {
            cancelFuture();
            if (action == ACTION.FLING || action == ACTION.DAGGLE) {
                float f2 = this.G;
                float f3 = this.w;
                int i2 = (int) (((f2 % f3) + f3) % f3);
                this.P = i2;
                if (i2 > f3 / 2.0f) {
                    this.P = (int) (f3 - i2);
                } else {
                    this.P = -i2;
                }
            }
            this.m = this.l.scheduleWithFixedDelay(new c(this, this.P), 0L, 10L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49085j = false;
        this.k = true;
        this.l = Executors.newSingleThreadScheduledExecutor();
        this.x = Typeface.MONOSPACE;
        this.B = 1.6f;
        this.L = 7;
        this.P = 0;
        this.Q = 0.0f;
        this.R = 0L;
        this.T = 17;
        this.U = 0;
        this.V = 0;
        this.s = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.W = 2.4f;
        } else {
            int i4 = (1.0f > f2 ? 1 : (1.0f == f2 ? 0 : -1));
            if (i4 <= 0 && f2 < 2.0f) {
                this.W = 3.6f;
            } else if (i4 <= 0 && f2 < 2.0f) {
                this.W = 4.5f;
            } else if (2.0f <= f2 && f2 < 3.0f) {
                this.W = 6.0f;
            } else if (f2 >= 3.0f) {
                this.W = f2 * 2.5f;
            }
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.pickerview, 0, 0);
            this.T = obtainStyledAttributes.getInt(R$styleable.pickerview_wheelview_gravity, 17);
            this.y = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorOut, -5723992);
            this.z = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.A = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_dividerColor, -2763307);
            this.s = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.pickerview_wheelview_textSize, this.s);
            this.B = obtainStyledAttributes.getFloat(R$styleable.pickerview_wheelview_lineSpacingMultiplier, this.B);
            obtainStyledAttributes.recycle();
        }
        f();
        d(context);
    }
}
