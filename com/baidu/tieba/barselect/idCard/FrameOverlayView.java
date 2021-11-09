package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FrameOverlayView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f47314e;

    /* renamed from: f  reason: collision with root package name */
    public int f47315f;

    /* renamed from: g  reason: collision with root package name */
    public int f47316g;

    /* renamed from: h  reason: collision with root package name */
    public int f47317h;

    /* renamed from: i  reason: collision with root package name */
    public int f47318i;
    public int j;
    public Paint k;
    public Paint l;
    public GestureDetector m;
    public RectF n;
    public RectF o;
    public int p;

    /* loaded from: classes9.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrameOverlayView f47319e;

        public a(FrameOverlayView frameOverlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frameOverlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47319e = frameOverlayView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f47319e.i(f2, f3);
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameOverlayView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f47314e = new a(this);
        this.f47315f = -1;
        this.f47316g = 20;
        this.f47317h = 100;
        this.f47318i = 6;
        this.j = Color.argb(180, 0, 0, 0);
        this.k = new Paint(1);
        this.l = new Paint(1);
        this.n = new RectF();
        this.o = new RectF();
        setLayerType(1, null);
        this.k.setColor(-1);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(6.0f);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.p = 0;
        f();
    }

    private float getMinimumFrameHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f47317h * 2.4f : invokeV.floatValue;
    }

    private float getMinimumFrameWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.f47317h * 2.4f : invokeV.floatValue;
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.k.setStrokeWidth(this.f47318i);
            RectF rectF = this.o;
            c(canvas, rectF.left - (this.f47318i / 2), rectF.top, this.f47317h, 0);
            RectF rectF2 = this.o;
            c(canvas, rectF2.left, rectF2.top, 0, this.f47317h);
            RectF rectF3 = this.o;
            c(canvas, rectF3.right + (this.f47318i / 2), rectF3.top, -this.f47317h, 0);
            RectF rectF4 = this.o;
            c(canvas, rectF4.right, rectF4.top, 0, this.f47317h);
            RectF rectF5 = this.o;
            c(canvas, rectF5.right, rectF5.bottom, 0, -this.f47317h);
            RectF rectF6 = this.o;
            c(canvas, rectF6.right + (this.f47318i / 2), rectF6.bottom, -this.f47317h, 0);
            RectF rectF7 = this.o;
            c(canvas, rectF7.left - (this.f47318i / 2), rectF7.bottom, this.f47317h, 0);
            RectF rectF8 = this.o;
            c(canvas, rectF8.left, rectF8.bottom, 0, -this.f47317h);
        }
    }

    public final void c(Canvas canvas, float f2, float f3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            canvas.drawLine(f2, f3, f2 + i2, f3 + i3, this.k);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != 3) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        return e(motionEvent);
                    }
                }
                this.f47315f = -1;
                return false;
            }
            float f2 = this.f47317h;
            this.n.set(motionEvent.getX() - f2, motionEvent.getY() - f2, motionEvent.getX() + f2, motionEvent.getY() + f2);
            RectF rectF = this.n;
            RectF rectF2 = this.o;
            if (rectF.contains(rectF2.left, rectF2.top)) {
                this.f47315f = 1;
                return true;
            }
            RectF rectF3 = this.n;
            RectF rectF4 = this.o;
            if (rectF3.contains(rectF4.right, rectF4.top)) {
                this.f47315f = 2;
                return true;
            }
            RectF rectF5 = this.n;
            RectF rectF6 = this.o;
            if (rectF5.contains(rectF6.right, rectF6.bottom)) {
                this.f47315f = 3;
                return true;
            }
            RectF rectF7 = this.n;
            RectF rectF8 = this.o;
            if (rectF7.contains(rectF8.left, rectF8.bottom)) {
                this.f47315f = 4;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            int i2 = this.f47315f;
            if (i2 == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                RectF rectF = this.o;
                h(x, y, rectF.right, rectF.bottom);
                return true;
            } else if (i2 == 2) {
                h(this.o.left, motionEvent.getY(), motionEvent.getX(), this.o.bottom);
                return true;
            } else if (i2 == 3) {
                RectF rectF2 = this.o;
                h(rectF2.left, rectF2.top, motionEvent.getX(), motionEvent.getY());
                return true;
            } else if (i2 != 4) {
                return false;
            } else {
                float x2 = motionEvent.getX();
                RectF rectF3 = this.o;
                h(x2, rectF3.top, rectF3.right, motionEvent.getY());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m = new GestureDetector(getContext(), this.f47314e);
            this.f47317h = b.a.r0.y.e.b.a(18);
            this.f47318i = b.a.r0.y.e.b.a(3);
        }
    }

    public final void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (this.p == 1) {
                RectF rectF = this.o;
                rectF.left = (int) (i2 * 0.05d);
                rectF.top = (int) (i3 * 0.25d);
            } else {
                RectF rectF2 = this.o;
                rectF2.left = (int) (i2 * 0.2d);
                rectF2.top = (int) (i3 * 0.2d);
            }
            RectF rectF3 = this.o;
            rectF3.right = i2 - rectF3.left;
            rectF3.bottom = i3 - rectF3.top;
        }
    }

    public Rect getFrameRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Rect rect = new Rect();
            RectF rectF = this.o;
            rect.left = (int) rectF.left;
            rect.top = (int) rectF.top;
            rect.right = (int) rectF.right;
            rect.bottom = (int) rectF.bottom;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final void h(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            if (f5 - f3 < getMinimumFrameHeight()) {
                RectF rectF = this.o;
                float f6 = rectF.top;
                f5 = rectF.bottom;
                f3 = f6;
            }
            if (f4 - f2 < getMinimumFrameWidth()) {
                RectF rectF2 = this.o;
                float f7 = rectF2.left;
                f4 = rectF2.right;
                f2 = f7;
            }
            this.o.set(Math.max(this.f47316g, f2), Math.max(this.f47316g, f3), Math.min(getWidth() - this.f47316g, f4), Math.min(getHeight() - this.f47316g, f5));
            invalidate();
        }
    }

    public final void i(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (f2 > 0.0f) {
                float f4 = this.o.left;
                int i2 = this.f47316g;
                if (f4 - f2 < i2) {
                    f2 = f4 - i2;
                }
            } else if (this.o.right - f2 > getWidth() - this.f47316g) {
                f2 = (this.o.right - getWidth()) + this.f47316g;
            }
            if (f3 > 0.0f) {
                float f5 = this.o.top;
                int i3 = this.f47316g;
                if (f5 - f3 < i3) {
                    f3 = f5 - i3;
                }
            } else if (this.o.bottom - f3 > getHeight() - this.f47316g) {
                f3 = (this.o.bottom - getHeight()) + this.f47316g;
            }
            this.o.offset(-f2, -f3);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.drawColor(this.j);
            this.k.setStrokeWidth(b.a.r0.y.e.b.a(1));
            canvas.drawRect(this.o, this.k);
            canvas.drawRect(this.o, this.l);
            b(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            g(i2, i3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            boolean d2 = d(motionEvent);
            RectF rectF = this.o;
            RectF rectF2 = new RectF(rectF.left - 60.0f, rectF.top - 60.0f, rectF.right + 60.0f, rectF.bottom + 60.0f);
            if (d2 || !rectF2.contains(motionEvent.getX(), motionEvent.getY())) {
                return d2;
            }
            this.m.onTouchEvent(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setOnFrameChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
        }
    }

    public void setTypeWide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.p = 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameOverlayView(Context context, AttributeSet attributeSet) {
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
        this.f47314e = new a(this);
        this.f47315f = -1;
        this.f47316g = 20;
        this.f47317h = 100;
        this.f47318i = 6;
        this.j = Color.argb(180, 0, 0, 0);
        this.k = new Paint(1);
        this.l = new Paint(1);
        this.n = new RectF();
        this.o = new RectF();
        setLayerType(1, null);
        this.k.setColor(-1);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(6.0f);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.p = 0;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameOverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47314e = new a(this);
        this.f47315f = -1;
        this.f47316g = 20;
        this.f47317h = 100;
        this.f47318i = 6;
        this.j = Color.argb(180, 0, 0, 0);
        this.k = new Paint(1);
        this.l = new Paint(1);
        this.n = new RectF();
        this.o = new RectF();
        setLayerType(1, null);
        this.k.setColor(-1);
        this.k.setStyle(Paint.Style.STROKE);
        this.k.setStrokeWidth(6.0f);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.p = 0;
        f();
    }
}
