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
import com.baidu.tieba.ze6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrameOverlayView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GestureDetector.SimpleOnGestureListener a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Paint g;
    public Paint h;
    public GestureDetector i;
    public RectF j;
    public RectF k;
    public int l;

    /* loaded from: classes5.dex */
    public interface b {
    }

    public void setOnFrameChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrameOverlayView a;

        public a(FrameOverlayView frameOverlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frameOverlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frameOverlayView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) != null) {
                return invokeCommon.booleanValue;
            }
            this.a.i(f, f2);
            return true;
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
        this.b = -1;
        this.c = 20;
        this.d = 100;
        this.e = 6;
        this.f = Color.argb(180, 0, 0, 0);
        this.g = new Paint(1);
        this.h = new Paint(1);
        this.j = new RectF();
        this.k = new RectF();
        setLayerType(1, null);
        this.g.setColor(-1);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(6.0f);
        this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.l = 0;
        f();
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.g.setStrokeWidth(this.e);
            RectF rectF = this.k;
            c(canvas, rectF.left - (this.e / 2), rectF.top, this.d, 0);
            RectF rectF2 = this.k;
            c(canvas, rectF2.left, rectF2.top, 0, this.d);
            RectF rectF3 = this.k;
            c(canvas, rectF3.right + (this.e / 2), rectF3.top, -this.d, 0);
            RectF rectF4 = this.k;
            c(canvas, rectF4.right, rectF4.top, 0, this.d);
            RectF rectF5 = this.k;
            c(canvas, rectF5.right, rectF5.bottom, 0, -this.d);
            RectF rectF6 = this.k;
            c(canvas, rectF6.right + (this.e / 2), rectF6.bottom, -this.d, 0);
            RectF rectF7 = this.k;
            c(canvas, rectF7.left - (this.e / 2), rectF7.bottom, this.d, 0);
            RectF rectF8 = this.k;
            c(canvas, rectF8.left, rectF8.bottom, 0, -this.d);
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
        this.a = new a(this);
        this.b = -1;
        this.c = 20;
        this.d = 100;
        this.e = 6;
        this.f = Color.argb(180, 0, 0, 0);
        this.g = new Paint(1);
        this.h = new Paint(1);
        this.j = new RectF();
        this.k = new RectF();
        setLayerType(1, null);
        this.g.setColor(-1);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(6.0f);
        this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.l = 0;
        f();
    }

    public final void i(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (f > 0.0f) {
                float f3 = this.k.left;
                int i = this.c;
                if (f3 - f < i) {
                    f = f3 - i;
                }
            } else if (this.k.right - f > getWidth() - this.c) {
                f = (this.k.right - getWidth()) + this.c;
            }
            if (f2 > 0.0f) {
                float f4 = this.k.top;
                int i2 = this.c;
                if (f4 - f2 < i2) {
                    f2 = f4 - i2;
                }
            } else if (this.k.bottom - f2 > getHeight() - this.c) {
                f2 = (this.k.bottom - getHeight()) + this.c;
            }
            this.k.offset(-f, -f2);
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new a(this);
        this.b = -1;
        this.c = 20;
        this.d = 100;
        this.e = 6;
        this.f = Color.argb(180, 0, 0, 0);
        this.g = new Paint(1);
        this.h = new Paint(1);
        this.j = new RectF();
        this.k = new RectF();
        setLayerType(1, null);
        this.g.setColor(-1);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(6.0f);
        this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.l = 0;
        f();
    }

    private float getMinimumFrameHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return this.d * 2.4f;
        }
        return invokeV.floatValue;
    }

    private float getMinimumFrameWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return this.d * 2.4f;
        }
        return invokeV.floatValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = new GestureDetector(getContext(), this.a);
            this.d = ze6.a(18);
            this.e = ze6.a(3);
        }
    }

    public Rect getFrameRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Rect rect = new Rect();
            RectF rectF = this.k;
            rect.left = (int) rectF.left;
            rect.top = (int) rectF.top;
            rect.right = (int) rectF.right;
            rect.bottom = (int) rectF.bottom;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public void setTypeWide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.l = 1;
        }
    }

    public final void c(Canvas canvas, float f, float f2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            canvas.drawLine(f, f2, f + i, f2 + i2, this.g);
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
                this.b = -1;
                return false;
            }
            float f = this.d;
            this.j.set(motionEvent.getX() - f, motionEvent.getY() - f, motionEvent.getX() + f, motionEvent.getY() + f);
            RectF rectF = this.j;
            RectF rectF2 = this.k;
            if (rectF.contains(rectF2.left, rectF2.top)) {
                this.b = 1;
                return true;
            }
            RectF rectF3 = this.j;
            RectF rectF4 = this.k;
            if (rectF3.contains(rectF4.right, rectF4.top)) {
                this.b = 2;
                return true;
            }
            RectF rectF5 = this.j;
            RectF rectF6 = this.k;
            if (rectF5.contains(rectF6.right, rectF6.bottom)) {
                this.b = 3;
                return true;
            }
            RectF rectF7 = this.j;
            RectF rectF8 = this.k;
            if (!rectF7.contains(rectF8.left, rectF8.bottom)) {
                return false;
            }
            this.b = 4;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            int i = this.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        float x = motionEvent.getX();
                        RectF rectF = this.k;
                        h(x, rectF.top, rectF.right, motionEvent.getY());
                        return true;
                    }
                    RectF rectF2 = this.k;
                    h(rectF2.left, rectF2.top, motionEvent.getX(), motionEvent.getY());
                    return true;
                }
                h(this.k.left, motionEvent.getY(), motionEvent.getX(), this.k.bottom);
                return true;
            }
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            RectF rectF3 = this.k;
            h(x2, y, rectF3.right, rectF3.bottom);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            if (this.l == 1) {
                RectF rectF = this.k;
                rectF.left = (int) (i * 0.05d);
                rectF.top = (int) (i2 * 0.25d);
            } else {
                RectF rectF2 = this.k;
                rectF2.left = (int) (i * 0.2d);
                rectF2.top = (int) (i2 * 0.2d);
            }
            RectF rectF3 = this.k;
            rectF3.right = i - rectF3.left;
            rectF3.bottom = i2 - rectF3.top;
        }
    }

    public final void h(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            if (f4 - f2 < getMinimumFrameHeight()) {
                RectF rectF = this.k;
                float f5 = rectF.top;
                f4 = rectF.bottom;
                f2 = f5;
            }
            if (f3 - f < getMinimumFrameWidth()) {
                RectF rectF2 = this.k;
                float f6 = rectF2.left;
                f3 = rectF2.right;
                f = f6;
            }
            this.k.set(Math.max(this.c, f), Math.max(this.c, f2), Math.min(getWidth() - this.c, f3), Math.min(getHeight() - this.c, f4));
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.drawColor(this.f);
            this.g.setStrokeWidth(ze6.a(1));
            canvas.drawRect(this.k, this.g);
            canvas.drawRect(this.k, this.h);
            b(canvas);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            boolean d = d(motionEvent);
            RectF rectF = this.k;
            RectF rectF2 = new RectF(rectF.left - 60.0f, rectF.top - 60.0f, rectF.right + 60.0f, rectF.bottom + 60.0f);
            if (!d && rectF2.contains(motionEvent.getX(), motionEvent.getY())) {
                this.i.onTouchEvent(motionEvent);
                return true;
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048586, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            g(i, i2);
        }
    }
}
