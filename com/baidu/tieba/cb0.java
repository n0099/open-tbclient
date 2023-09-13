package com.baidu.tieba;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
/* loaded from: classes5.dex */
public class cb0 extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context A;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Paint e;
    public final RectF f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final int k;
    public int l;
    public int m;
    public final int n;
    public final float o;
    public final Paint p;
    public final int q;
    public final Paint r;
    public final float s;
    public final b t;
    public final boolean u;
    public int v;
    public int w;
    public float x;
    public bb0 y;
    public SmartTabLayout.g z;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b implements SmartTabLayout.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;
        public int[] b;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.g
        public final int a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                int[] iArr = this.a;
                return iArr[i % iArr.length];
            }
            return invokeI.intValue;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.g
        public final int b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                int[] iArr = this.b;
                return iArr[i % iArr.length];
            }
            return invokeI.intValue;
        }

        public void c(int... iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr) == null) {
                this.b = iArr;
            }
        }

        public void d(int... iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) {
                this.a = iArr;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb0(Context context, AttributeSet attributeSet) {
        super(context);
        int i;
        int[] intArray;
        int[] intArray2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new RectF();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.A = context;
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i4 = typedValue.data;
        float f2 = 0.0f * f;
        int k = k(i4, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS);
        int i5 = (int) f2;
        int k2 = k(i4, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS);
        int k3 = k(i4, (byte) 32);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, eb0.LiveFeedPage_live_feed_page_SmartTabLayout);
        boolean z = obtainStyledAttributes.getBoolean(19, false);
        boolean z2 = obtainStyledAttributes.getBoolean(20, false);
        boolean z3 = obtainStyledAttributes.getBoolean(30, false);
        boolean z4 = obtainStyledAttributes.getBoolean(25, false);
        int i6 = obtainStyledAttributes.getInt(26, 0);
        int i7 = obtainStyledAttributes.getInt(24, 0);
        int color = obtainStyledAttributes.getColor(21, -13388315);
        int resourceId = obtainStyledAttributes.getResourceId(22, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(28, (int) (8.0f * f));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(27, (int) (6.0f * f));
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(29, -1);
        float dimension = obtainStyledAttributes.getDimension(23, f2);
        int color2 = obtainStyledAttributes.getColor(31, k);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(32, i5);
        int color3 = obtainStyledAttributes.getColor(38, k2);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(39, (int) (2.0f * f));
        int color4 = obtainStyledAttributes.getColor(15, k3);
        int resourceId2 = obtainStyledAttributes.getResourceId(16, -1);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(17, (int) (f * 1.0f));
        boolean z5 = obtainStyledAttributes.getBoolean(18, false);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            i = 1;
            intArray = new int[]{color};
        } else {
            i = 1;
            intArray = getResources().getIntArray(resourceId);
        }
        if (resourceId2 == -1) {
            intArray2 = new int[i];
            intArray2[0] = color4;
        } else {
            intArray2 = getResources().getIntArray(resourceId2);
        }
        b bVar = new b(null);
        this.t = bVar;
        bVar.d(intArray);
        this.t.c(intArray2);
        this.a = dimensionPixelSize3;
        this.b = color2;
        this.c = dimensionPixelSize4;
        this.d = color3;
        this.e = new Paint(1);
        this.h = z;
        this.i = z2;
        this.g = z3;
        this.j = z4;
        this.k = dimensionPixelSize;
        this.l = dimensionPixelSize2;
        this.m = layoutDimension;
        this.p = new Paint(1);
        this.o = dimension;
        this.n = i7;
        this.s = 0.5f;
        Paint paint = new Paint(1);
        this.r = paint;
        paint.setStrokeWidth(dimensionPixelSize5);
        this.q = dimensionPixelSize5;
        this.u = z5;
        this.y = bb0.d(i6);
    }

    public static int a(int i, int i2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)})) == null) {
            float f2 = 1.0f - f;
            return Color.rgb((int) ((Color.red(i) * f) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f) + (Color.green(i2) * f2)), (int) ((Color.blue(i) * f) + (Color.blue(i2) * f2)));
        }
        return invokeCommon.intValue;
    }

    public static int k(int i, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Byte.valueOf(b2)})) == null) {
            return Color.argb((int) b2, Color.red(i), Color.green(i), Color.blue(i));
        }
        return invokeCommon.intValue;
    }

    public void j(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            this.w = i;
            this.x = f;
            if (f == 0.0f && this.v != i) {
                this.v = i;
            }
            invalidate();
        }
    }

    public final void b(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int height = getHeight();
            int width = getWidth();
            int childCount = getChildCount();
            SmartTabLayout.g g = g();
            boolean n = db0.n(this);
            if (this.j) {
                d(canvas, 0, width);
                f(canvas, 0, width, height);
            }
            if (childCount > 0) {
                View childAt = getChildAt(this.w);
                int k = db0.k(childAt, this.g);
                int b2 = db0.b(childAt, this.g);
                if (n) {
                    k = b2;
                    b2 = k;
                }
                int a2 = g.a(this.w);
                float f = this.k;
                if (this.x > 0.0f && this.w < getChildCount() - 1) {
                    int a3 = g.a(this.w + 1);
                    if (a2 != a3) {
                        a2 = a(a3, a2, this.x);
                    }
                    float a4 = this.y.a(this.x);
                    float b3 = this.y.b(this.x);
                    this.y.c(this.x);
                    View childAt2 = getChildAt(this.w + 1);
                    int k2 = db0.k(childAt2, this.g);
                    int b4 = db0.b(childAt2, this.g);
                    if (n) {
                        i2 = (int) ((k2 * a4) + ((1.0f - a4) * b2));
                        i3 = (int) ((b4 * b3) + ((1.0f - b3) * k));
                    } else {
                        i3 = (int) ((k2 * a4) + ((1.0f - a4) * k));
                        i2 = (int) ((b4 * b3) + ((1.0f - b3) * b2));
                    }
                    i = a2;
                } else {
                    i = a2;
                    int i4 = k;
                    i2 = b2;
                    i3 = i4;
                }
                c(canvas, i3, i2, height, f, i);
            }
            if (!this.j) {
                d(canvas, 0, width);
                f(canvas, 0, getWidth(), height);
            }
            e(canvas, height, childCount);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(Canvas canvas, int i, int i2, int i3, float f, int i4) {
        int i5;
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Integer.valueOf(i4)}) == null) && (i5 = this.k) > 0 && this.m != 0) {
            int i6 = this.n;
            if (i6 != 1) {
                if (i6 != 2) {
                    float f6 = (i3 - i5) - this.l;
                    f4 = f6 - (i5 / 2.0f);
                    f3 = f6 + (i5 / 2.0f);
                    this.p.setColor(i4);
                    if (this.m != -1) {
                        this.f.set(i + sa0.b(this.A, 16.0f), f4, i2 - sa0.b(this.A, 16.0f), f3);
                    } else {
                        float abs = (Math.abs(i - i2) - this.m) / 2.0f;
                        this.f.set(i + abs, f4, i2 - abs, f3);
                    }
                    f5 = this.o;
                    if (f5 <= 0.0f) {
                        float i7 = sa0.i(this.A, f5);
                        canvas.drawRoundRect(this.f, i7, i7, this.p);
                        return;
                    }
                    canvas.drawRect(this.f, this.p);
                    return;
                }
                f2 = i3 / 2.0f;
            } else {
                f2 = i5 * 2;
            }
            float f7 = f / 2.0f;
            float f8 = f2 - f7;
            f3 = f2 + f7;
            f4 = f8;
            this.p.setColor(i4);
            if (this.m != -1) {
            }
            f5 = this.o;
            if (f5 <= 0.0f) {
            }
        }
    }

    public final void d(Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, canvas, i, i2) != null) || this.a <= 0) {
            return;
        }
        this.e.setColor(this.b);
        canvas.drawRect(i, 0.0f, i2, this.a, this.e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.u) {
                b(canvas);
            }
        }
    }

    public void l(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iArr) == null) {
            this.z = null;
            this.t.d(iArr);
            invalidate();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) && !this.u) {
            b(canvas);
        }
    }

    public final void e(Canvas canvas, int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048580, this, canvas, i, i2) != null) || this.q <= 0) {
            return;
        }
        int min = (int) (Math.min(Math.max(0.0f, this.s), 1.0f) * i);
        SmartTabLayout.g g = g();
        int i4 = (i - min) / 2;
        int i5 = min + i4;
        boolean n = db0.n(this);
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            View childAt = getChildAt(i6);
            int a2 = db0.a(childAt);
            int c = db0.c(childAt);
            if (n) {
                i3 = a2 - c;
            } else {
                i3 = a2 + c;
            }
            this.r.setColor(g.b(i6));
            float f = i3;
            canvas.drawLine(f, i4, f, i5, this.r);
        }
    }

    public final void f(Canvas canvas, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048581, this, canvas, i, i2, i3) != null) || this.c <= 0) {
            return;
        }
        this.e.setColor(this.d);
        canvas.drawRect(i, i3 - this.c, i2, i3, this.e);
    }

    public SmartTabLayout.g g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SmartTabLayout.g gVar = this.z;
            if (gVar == null) {
                return this.t;
            }
            return gVar;
        }
        return (SmartTabLayout.g) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }
}
