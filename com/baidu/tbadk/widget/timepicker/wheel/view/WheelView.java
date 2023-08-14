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
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.n16;
import com.baidu.tieba.o16;
import com.baidu.tieba.p16;
import com.baidu.tieba.p36;
import com.baidu.tieba.q16;
import com.baidu.tieba.r16;
import com.baidu.tieba.s16;
import com.baidu.tieba.t16;
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
/* loaded from: classes5.dex */
public class WheelView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public float M;
    public long N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public float S;
    public DividerType a;
    public Context b;
    public Handler c;
    public GestureDetector d;
    public q16 e;
    public boolean f;
    public boolean g;
    public ScheduledExecutorService h;
    public ScheduledFuture<?> i;
    public Paint j;
    public Paint k;
    public Paint l;
    public n16 m;
    public String n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public Typeface t;
    public int u;
    public int v;
    public int w;
    public float x;
    public boolean y;
    public float z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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

        public ACTION(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ACTION) Enum.valueOf(ACTION.class, str);
            }
            return (ACTION) invokeL.objValue;
        }

        public static ACTION[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ACTION[]) $VALUES.clone();
            }
            return (ACTION[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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

        public DividerType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (DividerType) Enum.valueOf(DividerType.class, str);
            }
            return (DividerType) invokeL.objValue;
        }

        public static DividerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (DividerType[]) $VALUES.clone();
            }
            return (DividerType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WheelView a;

        public a(WheelView wheelView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wheelView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wheelView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.onItemSelected(this.a.getCurrentItem());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i < 0) {
                return d(i + this.m.getItemsCount());
            }
            if (i > this.m.getItemsCount() - 1) {
                return d(i - this.m.getItemsCount());
            }
            return i;
        }
        return invokeI.intValue;
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.b = context;
            this.c = new s16(this);
            GestureDetector gestureDetector = new GestureDetector(context, new p16(this));
            this.d = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
            this.y = true;
            this.C = 0.0f;
            this.D = -1;
            g();
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Rect rect = new Rect();
            this.k.getTextBounds(str, 0, str.length(), rect);
            int i = this.o;
            for (int width = rect.width(); width > this.J; width = rect.width()) {
                i--;
                this.k.setTextSize(i);
                this.k.getTextBounds(str, 0, str.length(), rect);
            }
            this.j.setTextSize(i);
        }
    }

    public final void setTextSize(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048617, this, f) == null) && f > 0.0f) {
            int i = (int) (this.b.getResources().getDisplayMetrics().density * f);
            this.o = i;
            this.j.setTextSize(i);
            this.k.setTextSize(this.o);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = true;
        this.h = Executors.newSingleThreadScheduledExecutor();
        this.t = Typeface.MONOSPACE;
        this.x = 1.6f;
        this.H = 7;
        this.L = 0;
        this.M = 0.0f;
        this.N = 0L;
        this.P = 17;
        this.Q = 0;
        this.R = 0;
        this.o = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.S = 2.4f;
        } else {
            int i3 = (1.0f > f ? 1 : (1.0f == f ? 0 : -1));
            if (i3 <= 0 && f < 2.0f) {
                this.S = 3.6f;
            } else if (i3 <= 0 && f < 2.0f) {
                this.S = 4.5f;
            } else if (2.0f <= f && f < 3.0f) {
                this.S = 6.0f;
            } else if (f >= 3.0f) {
                this.S = f * 2.5f;
            }
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p36.pickerview, 0, 0);
            this.P = obtainStyledAttributes.getInt(1, 17);
            this.u = obtainStyledAttributes.getColor(4, -5723992);
            this.v = obtainStyledAttributes.getColor(3, -14013910);
            this.w = obtainStyledAttributes.getColor(0, -2763307);
            this.o = obtainStyledAttributes.getDimensionPixelOffset(5, this.o);
            this.x = obtainStyledAttributes.getFloat(2, this.x);
            obtainStyledAttributes.recycle();
        }
        j();
        f(context);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.g = z;
        }
    }

    public final void q(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f) == null) {
            b();
            this.i = this.h.scheduleWithFixedDelay(new r16(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
        }
    }

    public final void setAdapter(n16 n16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, n16Var) == null) {
            this.m = n16Var;
            p();
            invalidate();
        }
    }

    public final void setCenterTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, typeface) == null) {
            this.k.setTypeface(typeface);
        }
    }

    public final void setCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.E = i;
            this.D = i;
            this.C = 0.0f;
            invalidate();
        }
    }

    public final void setCyclic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.y = z;
        }
    }

    public void setDividerColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.w = i;
            this.l.setColor(i);
        }
    }

    public void setDividerType(DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, dividerType) == null) {
            this.a = dividerType;
        }
    }

    public void setGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.P = i;
        }
    }

    public void setIsOptions(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f = z;
        }
    }

    public void setItemsVisible(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.H = i;
        }
    }

    public void setLabel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.n = str;
        }
    }

    public void setLineSpacingMultiplier(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048613, this, f) == null) && f != 0.0f) {
            this.x = f;
            j();
        }
    }

    public final void setOnItemSelectedListener(q16 q16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, q16Var) == null) {
            this.e = q16Var;
        }
    }

    public void setTextColorCenter(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.v = i;
            this.k.setColor(i);
        }
    }

    public void setTextColorOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.u = i;
            this.j.setColor(i);
        }
    }

    public void setTextXOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.r = i;
            if (i != 0) {
                this.k.setTextScaleX(1.0f);
            }
        }
    }

    public void setTotalScrollY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f) == null) {
            this.C = f;
        }
    }

    public final void setTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, typeface) == null) {
            this.t = typeface;
            this.j.setTypeface(typeface);
            this.k.setTypeface(this.t);
        }
    }

    public void b() {
        ScheduledFuture<?> scheduledFuture;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (scheduledFuture = this.i) != null && !scheduledFuture.isCancelled()) {
            this.i.cancel(true);
            this.i = null;
        }
    }

    public final n16 getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m;
        }
        return (n16) invokeV.objValue;
    }

    @Override // android.view.View
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (Handler) invokeV.objValue;
    }

    public int getInitPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public float getItemHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.s;
        }
        return invokeV.floatValue;
    }

    public int getItemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            n16 n16Var = this.m;
            if (n16Var != null) {
                return n16Var.getItemsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public float getTotalScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.C;
        }
        return invokeV.floatValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            float f = this.x;
            if (f < 1.0f) {
                this.x = 1.0f;
            } else if (f > 4.0f) {
                this.x = 4.0f;
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.e != null) {
            postDelayed(new a(this), 200L);
        }
    }

    public final String c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null) {
                return "";
            }
            if (obj instanceof o16) {
                return ((o16) obj).getPickerViewText();
            }
            if (obj instanceof Integer) {
                return String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue()));
            }
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public void r(ACTION action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, action) == null) {
            b();
            if (action == ACTION.FLING || action == ACTION.DAGGLE) {
                float f = this.C;
                float f2 = this.s;
                int i = (int) (((f % f2) + f2) % f2);
                this.L = i;
                if (i > f2 / 2.0f) {
                    this.L = (int) (f2 - i);
                } else {
                    this.L = -i;
                }
            }
            this.i = this.h.scheduleWithFixedDelay(new t16(this, this.L), 0L, 10L, TimeUnit.MILLISECONDS);
        }
    }

    public int e(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, paint, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += (int) Math.ceil(fArr[i2]);
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Paint paint = new Paint();
            this.j = paint;
            paint.setColor(this.u);
            this.j.setAntiAlias(true);
            this.j.setTypeface(this.t);
            this.j.setTextSize(this.o);
            Paint paint2 = new Paint();
            this.k = paint2;
            paint2.setColor(this.v);
            this.k.setAntiAlias(true);
            this.k.setTextScaleX(1.1f);
            this.k.setTypeface(this.t);
            this.k.setTextSize(this.o);
            Paint paint3 = new Paint();
            this.l = paint3;
            paint3.setColor(this.w);
            this.l.setAntiAlias(true);
            setLayerType(1, null);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || this.m == null) {
            return;
        }
        k();
        int i = (int) (this.s * (this.H - 1));
        this.I = (int) ((i * 2) / 3.141592653589793d);
        this.K = (int) (i / 3.141592653589793d);
        this.J = View.MeasureSpec.getSize(this.O);
        int i2 = this.I;
        float f = this.s;
        this.z = (i2 - f) / 2.0f;
        float f2 = (i2 + f) / 2.0f;
        this.A = f2;
        this.B = (f2 - ((f - this.q) / 2.0f)) - this.S;
        if (this.D == -1) {
            if (this.y) {
                this.D = (this.m.getItemsCount() + 1) / 2;
            } else {
                this.D = 0;
            }
        }
        this.F = this.D;
    }

    public final int getCurrentItem() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            n16 n16Var = this.m;
            if (n16Var == null) {
                return 0;
            }
            if (this.y && ((i = this.E) < 0 || i >= n16Var.getItemsCount())) {
                return Math.max(0, Math.min(Math.abs(Math.abs(this.E) - this.m.getItemsCount()), this.m.getItemsCount() - 1));
            }
            return Math.max(0, Math.min(this.E, this.m.getItemsCount() - 1));
        }
        return invokeV.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Rect rect = new Rect();
            for (int i = 0; i < this.m.getItemsCount(); i++) {
                String c = c(this.m.getItem(i));
                this.k.getTextBounds(c, 0, c.length(), rect);
                int width = rect.width();
                if (width > this.p) {
                    this.p = width;
                }
                this.k.getTextBounds("星期", 0, 2, rect);
                this.q = rect.height() + 2;
            }
            this.s = this.x * this.q;
        }
    }

    public final void l(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Rect rect = new Rect();
            this.k.getTextBounds(str, 0, str.length(), rect);
            int i = this.P;
            if (i != 3) {
                if (i != 5) {
                    if (i == 17) {
                        if (!this.f && (str2 = this.n) != null && !str2.equals("") && this.g) {
                            this.Q = (int) ((this.J - rect.width()) * 0.25d);
                            return;
                        } else {
                            this.Q = (int) ((this.J - rect.width()) * 0.5d);
                            return;
                        }
                    }
                    return;
                }
                this.Q = (this.J - rect.width()) - ((int) this.S);
                return;
            }
            this.Q = 0;
        }
    }

    public final void m(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            Rect rect = new Rect();
            this.j.getTextBounds(str, 0, str.length(), rect);
            int i = this.P;
            if (i != 3) {
                if (i != 5) {
                    if (i == 17) {
                        if (!this.f && (str2 = this.n) != null && !str2.equals("") && this.g) {
                            this.R = (int) ((this.J - rect.width()) * 0.25d);
                            return;
                        } else {
                            this.R = (int) ((this.J - rect.width()) * 0.5d);
                            return;
                        }
                    }
                    return;
                }
                this.R = (this.J - rect.width()) - ((int) this.S);
                return;
            }
            this.R = 0;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        String c;
        int i;
        int i2;
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, canvas) != null) || this.m == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.D), this.m.getItemsCount() - 1);
        this.D = min;
        Object[] objArr = new Object[this.H];
        int i3 = (int) (this.C / this.s);
        this.G = i3;
        try {
            this.F = min + (i3 % this.m.getItemsCount());
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (!this.y) {
            if (this.F < 0) {
                this.F = 0;
            }
            if (this.F > this.m.getItemsCount() - 1) {
                this.F = this.m.getItemsCount() - 1;
            }
        } else {
            if (this.F < 0) {
                this.F = this.m.getItemsCount() + this.F;
            }
            if (this.F > this.m.getItemsCount() - 1) {
                this.F -= this.m.getItemsCount();
            }
        }
        float f2 = this.C % this.s;
        int i4 = 0;
        while (true) {
            int i5 = this.H;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.F - ((i5 / 2) - i4);
            if (this.y) {
                objArr[i4] = this.m.getItem(d(i6));
            } else if (i6 < 0) {
                objArr[i4] = "";
            } else if (i6 > this.m.getItemsCount() - 1) {
                objArr[i4] = "";
            } else {
                objArr[i4] = this.m.getItem(i6);
            }
            i4++;
        }
        if (this.a == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.n)) {
                i2 = (this.J - this.p) / 2;
            } else {
                i2 = (this.J - this.p) / 4;
            }
            float f3 = i2 - 12;
            if (f3 <= 0.0f) {
                f = 10.0f;
            } else {
                f = f3;
            }
            float f4 = this.J - f;
            float f5 = this.z;
            float f6 = f;
            canvas.drawLine(f6, f5, f4, f5, this.l);
            float f7 = this.A;
            canvas.drawLine(f6, f7, f4, f7, this.l);
        } else {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
            float f8 = this.z;
            float f9 = dimenPixelSize;
            canvas.drawRect(0.0f, f8, this.J, f8 + f9, this.l);
            float f10 = this.A;
            canvas.drawRect(0.0f, f10 - f9, this.J, f10, this.l);
        }
        if (!TextUtils.isEmpty(this.n) && this.g) {
            canvas.drawText(this.n, (this.J - e(this.k, this.n)) - this.S, this.B, this.k);
        }
        for (int i7 = 0; i7 < this.H; i7++) {
            canvas.save();
            double d = ((this.s * i7) - f2) / this.K;
            float f11 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f11 < 90.0f && f11 > -90.0f) {
                float pow = (float) Math.pow(Math.abs(f11) / 90.0f, 2.2d);
                if (!this.g && !TextUtils.isEmpty(this.n) && !TextUtils.isEmpty(c(objArr[i7]))) {
                    c = c(objArr[i7]) + this.n;
                } else {
                    c = c(objArr[i7]);
                }
                o(c);
                l(c);
                m(c);
                float cos = (float) ((this.K - (Math.cos(d) * this.K)) - ((Math.sin(d) * this.q) / 2.0d));
                canvas.translate(0.0f, cos);
                float f12 = this.z;
                if (cos <= f12 && this.q + cos >= f12) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.J, this.z - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(c, this.R, this.q, this.j);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.z - cos, this.J, (int) this.s);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(c, this.Q, this.q - this.S, this.k);
                    canvas.restore();
                } else {
                    float f13 = this.A;
                    if (cos <= f13 && this.q + cos >= f13) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.J, this.A - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(c, this.Q, this.q - this.S, this.k);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.A - cos, this.J, (int) this.s);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(c, this.R, this.q, this.j);
                        canvas.restore();
                    } else {
                        if (cos >= this.z) {
                            int i8 = this.q;
                            if (i8 + cos <= this.A) {
                                canvas.drawText(c, this.Q, i8 - this.S, this.k);
                                this.E = this.F - ((this.H / 2) - i7);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.J, (int) this.s);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        Paint paint = this.j;
                        int i9 = this.r;
                        int i10 = -1;
                        if (i9 == 0) {
                            i = 0;
                        } else if (i9 > 0) {
                            i = 1;
                        } else {
                            i = -1;
                        }
                        if (f11 <= 0.0f) {
                            i10 = 1;
                        }
                        paint.setTextSkewX(i * i10 * 0.5f * pow);
                        this.j.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(c, this.R + (this.r * pow), this.q, this.j);
                        canvas.restore();
                        canvas.restore();
                        this.k.setTextSize(this.o);
                    }
                }
                canvas.restore();
                this.k.setTextSize(this.o);
            } else {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i, i2) == null) {
            this.O = i;
            p();
            setMeasuredDimension(this.J, this.I);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) {
            boolean onTouchEvent = this.d.onTouchEvent(motionEvent);
            float f = (-this.D) * this.s;
            float itemsCount = ((this.m.getItemsCount() - 1) - this.D) * this.s;
            int action = motionEvent.getAction();
            boolean z = false;
            if (action != 0) {
                if (action != 2) {
                    if (!onTouchEvent) {
                        float y = motionEvent.getY();
                        int i = this.K;
                        float f2 = this.s;
                        this.L = (int) (((((int) (((Math.acos((i - y) / i) * this.K) + (f2 / 2.0f)) / f2)) - (this.H / 2)) * f2) - (((this.C % f2) + f2) % f2));
                        if (System.currentTimeMillis() - this.N > 120) {
                            r(ACTION.DAGGLE);
                        } else {
                            r(ACTION.CLICK);
                        }
                    }
                } else {
                    float rawY = this.M - motionEvent.getRawY();
                    this.M = motionEvent.getRawY();
                    float f3 = this.C + rawY;
                    this.C = f3;
                    if (!this.y && ((f3 - (this.s * 0.25f) < f && rawY < 0.0f) || (this.C + (this.s * 0.25f) > itemsCount && rawY > 0.0f))) {
                        this.C -= rawY;
                        z = true;
                    }
                }
            } else {
                this.N = System.currentTimeMillis();
                b();
                this.M = motionEvent.getRawY();
            }
            if (!z && motionEvent.getAction() != 0) {
                invalidate();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
