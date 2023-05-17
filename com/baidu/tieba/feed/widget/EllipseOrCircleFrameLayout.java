package com.baidu.tieba.feed.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0016J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0014J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/baidu/tieba/feed/widget/EllipseOrCircleFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "enableEllipse", "", "mCirclePath", "Landroid/graphics/Path;", "mEllipsePath", "mOriginRectF", "Landroid/graphics/RectF;", "mPaint", "Landroid/graphics/Paint;", "mPath", "mRectF", "mStrokeCirclePath", "mStrokeColor", "", "mStrokeEllipsePath", "mStrokePath", "mStrokeRectF", "mStrokeWidth", "", "mTempPath", "mXfermode", "Landroid/graphics/Xfermode;", "buildCirclePath", "", "isStrokePath", "buildEllipsePath", "buildPath", "buildRectF", "draw", "canvas", "Landroid/graphics/Canvas;", "setStrokeColor", "strokeColor", "setStrokeWidth", "strokeWidth", "showEllipse", "show", "lib-components_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EllipseOrCircleFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Paint b;
    public final Xfermode c;
    public final Path d;
    public final Path e;
    public final Path f;
    public final Path g;
    public final Path h;
    public final Path i;
    public final RectF j;
    public final RectF k;
    public final RectF l;
    public int m;
    public float n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EllipseOrCircleFrameLayout(Context context) {
        this(context, null, 2, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EllipseOrCircleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PorterDuff.Mode mode;
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = true;
        setWillNotDraw(false);
        this.b = new Paint();
        this.d = new Path();
        this.e = new Path();
        this.f = new Path();
        this.g = new Path();
        this.h = new Path();
        this.i = new Path();
        new Path();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new RectF();
        if (Build.VERSION.SDK_INT >= 23) {
            mode = PorterDuff.Mode.DST_OUT;
        } else {
            mode = PorterDuff.Mode.DST_IN;
        }
        this.c = new PorterDuffXfermode(mode);
    }

    public /* synthetic */ EllipseOrCircleFrameLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void a(boolean z) {
        RectF rectF;
        Path path;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                rectF = this.k;
            } else {
                rectF = this.j;
            }
            if (z) {
                path = this.g;
            } else {
                path = this.f;
            }
            path.reset();
            path.addRoundRect(rectF, getWidth(), getWidth(), Path.Direction.CCW);
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.a = z;
            invalidate();
        }
    }

    public final void setStrokeColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m = i;
            invalidate();
        }
    }

    public final void setStrokeWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.n = f;
            invalidate();
        }
    }

    public final void b(boolean z) {
        Path path;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            float f = this.n;
            if (z) {
                f /= 2;
            }
            if (z) {
                path = this.e;
            } else {
                path = this.d;
            }
            float f2 = 2;
            float width = ((getWidth() - (f * f2)) * 14) / 130;
            float width2 = getWidth() - f;
            float f3 = (f + width2) / f2;
            float height = getHeight() - f;
            float f4 = (f + height) / f2;
            path.reset();
            path.moveTo(f3, f);
            float f5 = width + f;
            path.cubicTo((getWidth() - f) - width, f, getWidth() - f, f5, width2, f4);
            path.cubicTo(getWidth() - f, (getWidth() - width) - f, (getWidth() - width) - f, getWidth() - f, f3, height);
            Path path2 = path;
            path2.cubicTo(f5, getWidth() - f, f, (getWidth() - width) - f, f, f4);
            path2.cubicTo(f, f5, f5, f, f3, f);
            path.close();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b(true);
            b(false);
            a(true);
            a(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RectF rectF = this.j;
            float f = this.n;
            rectF.set(f, f, getWidth() - this.n, getHeight() - this.n);
            RectF rectF2 = this.k;
            float f2 = this.n;
            float f3 = 2;
            rectF2.set(f2 / f3, f2 / f3, getWidth() - (this.n / f3), getHeight() - (this.n / f3));
            this.l.set(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r2 == false) goto L39;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            boolean z4 = false;
            if (this.l.width() == getWidth()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.l.height() == getHeight()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (this.k.width() == getWidth() - this.n) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if (this.k.height() == getHeight() - this.n) {
                            z4 = true;
                        }
                    }
                }
            }
            d();
            c();
            canvas.saveLayer(this.j, null, 31);
            super.draw(canvas);
            this.b.reset();
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.FILL);
            this.b.setXfermode(this.c);
            this.h.reset();
            if (this.a) {
                this.h.addPath(this.d);
            } else {
                this.h.addPath(this.f);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                this.i.reset();
                this.i.addRect(this.l, Path.Direction.CCW);
                this.i.op(this.h, Path.Op.DIFFERENCE);
                canvas.drawPath(this.i, this.b);
            } else {
                canvas.drawPath(this.h, this.b);
            }
            this.b.setXfermode(null);
            canvas.restore();
            if (this.n > 0.0f) {
                this.b.setStyle(Paint.Style.STROKE);
                this.b.setStrokeWidth(this.n);
                this.b.setColor(this.m);
                this.h.reset();
                if (this.a) {
                    this.h.addPath(this.e);
                } else {
                    this.h.addPath(this.g);
                }
                canvas.drawPath(this.h, this.b);
            }
        }
    }
}
