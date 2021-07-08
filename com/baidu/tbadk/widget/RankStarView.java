package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class RankStarView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13245e;

    /* renamed from: f  reason: collision with root package name */
    public float f13246f;

    /* renamed from: g  reason: collision with root package name */
    public int f13247g;

    /* renamed from: h  reason: collision with root package name */
    public int f13248h;

    /* renamed from: i  reason: collision with root package name */
    public int f13249i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Drawable n;
    public Drawable o;
    public Rect p;
    public Rect q;
    public boolean r;
    public int s;
    public a t;

    /* loaded from: classes3.dex */
    public interface a {
        void a(float f2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankStarView(Context context) {
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
        this.f13245e = 5;
        this.j = R.drawable.icon_pure_evaluation_star24_n;
        this.k = R.color.CAM_X0112;
        this.l = R.drawable.icon_pure_evaluation_star24_n;
        this.m = R.color.CAM_X0305;
        this.s = 3;
        d(context);
    }

    public final void a(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.n == null || this.o == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int i2 = 0;
        while (true) {
            f2 = this.f13246f;
            if (i2 >= f2) {
                break;
            }
            Drawable drawable = this.o;
            int paddingTop = getPaddingTop();
            int i3 = this.f13248h;
            drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i3, i3 + getPaddingTop());
            this.o.draw(canvas);
            paddingLeft += this.f13247g + this.f13248h;
            i2++;
        }
        if (f2 - ((int) f2) <= 0.0f) {
            for (int i4 = (int) f2; i4 < this.f13245e; i4++) {
                Drawable drawable2 = this.n;
                int paddingTop2 = getPaddingTop();
                int i5 = this.f13248h;
                drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i5, i5 + getPaddingTop());
                this.n.draw(canvas);
                paddingLeft += this.f13247g + this.f13248h;
            }
            return;
        }
        int i6 = (int) f2;
        while (true) {
            i6++;
            if (i6 >= this.f13245e) {
                return;
            }
            Drawable drawable3 = this.n;
            int paddingTop3 = getPaddingTop();
            int i7 = this.f13248h;
            drawable3.setBounds(paddingLeft, paddingTop3, paddingLeft + i7, i7 + getPaddingTop());
            this.n.draw(canvas);
            paddingLeft += this.f13247g + this.f13248h;
        }
    }

    public final void b(Canvas canvas) {
        float f2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) != null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int i4 = 0;
        while (true) {
            f2 = this.f13246f;
            if (i4 >= ((int) f2)) {
                break;
            }
            Drawable drawable = this.o;
            int paddingTop = getPaddingTop();
            int i5 = this.f13248h;
            drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i5, i5 + getPaddingTop());
            this.o.draw(canvas);
            paddingLeft += this.f13247g + this.f13248h;
            i4++;
        }
        if (f2 - ((int) f2) >= 0.5d) {
            Drawable drawable2 = this.o;
            int paddingTop2 = getPaddingTop();
            int i6 = this.f13248h;
            drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i6, i6 + getPaddingTop());
            this.o.draw(canvas);
            i2 = this.f13247g;
            i3 = this.f13248h;
        } else if (f2 - ((int) f2) > 0.0f) {
            Drawable drawable3 = this.o;
            int paddingTop3 = getPaddingTop();
            int i7 = this.f13248h;
            drawable3.setBounds(paddingLeft, paddingTop3, paddingLeft + i7, i7 + getPaddingTop());
            canvas.save();
            Rect rect = this.p;
            int paddingTop4 = getPaddingTop();
            int i8 = this.f13248h;
            rect.set(paddingLeft, paddingTop4, (i8 / 2) + paddingLeft, i8 + getPaddingTop());
            canvas.clipRect(this.p);
            this.o.draw(canvas);
            canvas.restore();
            Drawable drawable4 = this.n;
            int paddingTop5 = getPaddingTop();
            int i9 = this.f13248h;
            drawable4.setBounds(paddingLeft, paddingTop5, paddingLeft + i9, i9 + getPaddingTop());
            canvas.save();
            int paddingTop6 = getPaddingTop();
            int i10 = this.f13248h;
            this.q.set((this.f13248h / 2) + paddingLeft, paddingTop6, paddingLeft + i10, i10 + getPaddingTop());
            canvas.clipRect(this.q);
            this.n.draw(canvas);
            canvas.restore();
            i2 = this.f13247g;
            i3 = this.f13248h;
        } else {
            Drawable drawable5 = this.n;
            int paddingTop7 = getPaddingTop();
            int i11 = this.f13248h;
            drawable5.setBounds(paddingLeft, paddingTop7, paddingLeft + i11, i11 + getPaddingTop());
            this.n.draw(canvas);
            i2 = this.f13247g;
            i3 = this.f13248h;
        }
        int i12 = paddingLeft + i2 + i3;
        int i13 = (int) this.f13246f;
        while (true) {
            i13++;
            if (i13 >= this.f13245e) {
                return;
            }
            Drawable drawable6 = this.n;
            int paddingTop8 = getPaddingTop();
            int i14 = this.f13248h;
            drawable6.setBounds(i12, paddingTop8, i12 + i14, i14 + getPaddingTop());
            this.n.draw(canvas);
            i12 += this.f13247g + this.f13248h;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13246f != 0.0f : invokeV.booleanValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f13248h = l.g(context, R.dimen.tbds63);
            this.p = new Rect(0, 0, 0, 0);
            this.q = new Rect(0, 0, 0, 0);
            f();
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.s == i2) {
            return;
        }
        this.s = i2;
        f();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n = SvgManager.getInstance().getPureDrawable(this.j, this.k, null);
            this.o = SvgManager.getInstance().getPureDrawable(this.l, this.m, null);
        }
    }

    public int getStarCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f2 = this.f13246f;
            if (f2 == 0.0f) {
                return 0;
            }
            return ((double) f2) % 1.0d == 0.0d ? (int) f2 : ((int) f2) + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) || this.n == null || this.o == null) {
            return;
        }
        if (this.r) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode2 == 1073741824) {
                this.f13248h = (size2 - getPaddingBottom()) - getPaddingTop();
            } else {
                size2 = this.f13248h + getPaddingBottom() + getPaddingTop();
            }
            int i4 = this.f13248h;
            int i5 = this.f13245e;
            int i6 = (i4 * i5) + (this.f13247g * (i5 - 1));
            this.f13249i = i6;
            if (mode != 1073741824) {
                size = getPaddingRight() + i6 + getPaddingLeft();
            } else if (size < i6) {
                this.f13249i = (size - getPaddingLeft()) - getPaddingRight();
            }
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (motionEvent != null && onTouchEvent) {
                int x = (int) motionEvent.getX();
                if (x < getPaddingLeft() - 10 || x > this.f13249i + getPaddingLeft() + 10) {
                    return true;
                }
                setStarCount((((x - getPaddingLeft()) * 1.0f) / this.f13249i) * this.f13245e);
            }
            return onTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public void setIsHalfStar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.r = z;
        }
    }

    public void setStarChangListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.t = aVar;
        }
    }

    public void setStarCount(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            int i2 = this.f13245e;
            if (f2 > i2) {
                f2 = i2;
            }
            if (this.f13246f != f2) {
                this.f13246f = f2;
                invalidate();
            }
            a aVar = this.t;
            if (aVar != null) {
                aVar.a(f2);
            }
        }
    }

    public void setStarResource(@DrawableRes int i2, @ColorRes int i3, @DrawableRes int i4, @ColorRes int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.j = i2;
            this.k = i3;
            this.l = i4;
            this.m = i5;
            f();
        }
    }

    public void setStarSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f13247g = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f13245e = 5;
        this.j = R.drawable.icon_pure_evaluation_star24_n;
        this.k = R.color.CAM_X0112;
        this.l = R.drawable.icon_pure_evaluation_star24_n;
        this.m = R.color.CAM_X0305;
        this.s = 3;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f13245e = 5;
        this.j = R.drawable.icon_pure_evaluation_star24_n;
        this.k = R.color.CAM_X0112;
        this.l = R.drawable.icon_pure_evaluation_star24_n;
        this.m = R.color.CAM_X0305;
        this.s = 3;
        d(context);
    }
}
