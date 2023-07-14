package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class RankStarView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public float b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final Drawable[] j;
    public Drawable k;
    public Drawable l;
    public Rect m;
    public Rect n;
    public boolean o;
    public int p;
    public a q;

    /* loaded from: classes4.dex */
    public interface a {
        void a(float f);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 5;
        this.f = R.drawable.icon_pure_evaluation_star24_n;
        this.g = R.color.CAM_X0112;
        this.h = R.drawable.icon_pure_evaluation_star24_n;
        this.i = R.color.CAM_X0305;
        this.j = new Drawable[5];
        this.p = 3;
        e(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (motionEvent != null && onTouchEvent) {
                int x = (int) motionEvent.getX();
                if (x >= getPaddingLeft() - 10 && x <= this.e + getPaddingLeft() + 10) {
                    setStarCount((((x - getPaddingLeft()) * 1.0f) / this.e) * this.a);
                } else {
                    return true;
                }
            }
            return onTouchEvent;
        }
        return invokeL.booleanValue;
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
        this.a = 5;
        this.f = R.drawable.icon_pure_evaluation_star24_n;
        this.g = R.color.CAM_X0112;
        this.h = R.drawable.icon_pure_evaluation_star24_n;
        this.i = R.color.CAM_X0305;
        this.j = new Drawable[5];
        this.p = 3;
        e(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 5;
        this.f = R.drawable.icon_pure_evaluation_star24_n;
        this.g = R.color.CAM_X0112;
        this.h = R.drawable.icon_pure_evaluation_star24_n;
        this.i = R.color.CAM_X0305;
        this.j = new Drawable[5];
        this.p = 3;
        e(context);
    }

    public final void a(Canvas canvas) {
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && this.k != null && this.l != null) {
            int paddingLeft = getPaddingLeft();
            int i = 0;
            while (true) {
                f = this.b;
                if (i >= f) {
                    break;
                }
                Drawable c = c(i);
                int paddingTop = getPaddingTop();
                int i2 = this.d;
                c.setBounds(paddingLeft, paddingTop, paddingLeft + i2, i2 + getPaddingTop());
                c(i).draw(canvas);
                paddingLeft += this.c + this.d;
                i++;
            }
            if (f - ((int) f) > 0.0f) {
                int i3 = (int) f;
                while (true) {
                    i3++;
                    if (i3 < this.a) {
                        Drawable drawable = this.k;
                        int paddingTop2 = getPaddingTop();
                        int i4 = this.d;
                        drawable.setBounds(paddingLeft, paddingTop2, paddingLeft + i4, i4 + getPaddingTop());
                        this.k.draw(canvas);
                        paddingLeft += this.c + this.d;
                    } else {
                        return;
                    }
                }
            } else {
                for (int i5 = (int) f; i5 < this.a; i5++) {
                    Drawable drawable2 = this.k;
                    int paddingTop3 = getPaddingTop();
                    int i6 = this.d;
                    drawable2.setBounds(paddingLeft, paddingTop3, paddingLeft + i6, i6 + getPaddingTop());
                    this.k.draw(canvas);
                    paddingLeft += this.c + this.d;
                }
            }
        }
    }

    public final void b(Canvas canvas) {
        float f;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int paddingLeft = getPaddingLeft();
            int i3 = 0;
            while (true) {
                f = this.b;
                if (i3 >= ((int) f)) {
                    break;
                }
                Drawable c = c(i3);
                int paddingTop = getPaddingTop();
                int i4 = this.d;
                c.setBounds(paddingLeft, paddingTop, paddingLeft + i4, i4 + getPaddingTop());
                c(i3).draw(canvas);
                paddingLeft += this.c + this.d;
                i3++;
            }
            if (f - ((int) f) >= 0.5d) {
                Drawable c2 = c((int) f);
                int paddingTop2 = getPaddingTop();
                int i5 = this.d;
                c2.setBounds(paddingLeft, paddingTop2, paddingLeft + i5, i5 + getPaddingTop());
                c((int) this.b).draw(canvas);
                i = this.c;
                i2 = this.d;
            } else if (f - ((int) f) > 0.0f) {
                Drawable c3 = c((int) f);
                int paddingTop3 = getPaddingTop();
                int i6 = this.d;
                c3.setBounds(paddingLeft, paddingTop3, paddingLeft + i6, i6 + getPaddingTop());
                canvas.save();
                Rect rect = this.m;
                int paddingTop4 = getPaddingTop();
                int i7 = this.d;
                rect.set(paddingLeft, paddingTop4, (i7 / 2) + paddingLeft, i7 + getPaddingTop());
                canvas.clipRect(this.m);
                c((int) this.b).draw(canvas);
                canvas.restore();
                Drawable drawable = this.k;
                int paddingTop5 = getPaddingTop();
                int i8 = this.d;
                drawable.setBounds(paddingLeft, paddingTop5, paddingLeft + i8, i8 + getPaddingTop());
                canvas.save();
                int paddingTop6 = getPaddingTop();
                int i9 = this.d;
                this.n.set((this.d / 2) + paddingLeft, paddingTop6, paddingLeft + i9, i9 + getPaddingTop());
                canvas.clipRect(this.n);
                this.k.draw(canvas);
                canvas.restore();
                i = this.c;
                i2 = this.d;
            } else {
                Drawable drawable2 = this.k;
                int paddingTop7 = getPaddingTop();
                int i10 = this.d;
                drawable2.setBounds(paddingLeft, paddingTop7, paddingLeft + i10, i10 + getPaddingTop());
                this.k.draw(canvas);
                i = this.c;
                i2 = this.d;
            }
            int i11 = paddingLeft + i + i2;
            int i12 = (int) this.b;
            while (true) {
                i12++;
                if (i12 < this.a) {
                    Drawable drawable3 = this.k;
                    int paddingTop8 = getPaddingTop();
                    int i13 = this.d;
                    drawable3.setBounds(i11, paddingTop8, i11 + i13, i13 + getPaddingTop());
                    this.k.draw(canvas);
                    i11 += this.c + this.d;
                } else {
                    return;
                }
            }
        }
    }

    public final Drawable c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Drawable drawable = this.l;
            Drawable[] drawableArr = this.j;
            if (drawableArr[i] != null) {
                return drawableArr[i];
            }
            return drawable;
        }
        return (Drawable) invokeI.objValue;
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.d = yi.g(context, R.dimen.tbds63);
            this.m = new Rect(0, 0, 0, 0);
            this.n = new Rect(0, 0, 0, 0);
            g();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.p != i) {
            this.p = i;
            g();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) && this.k != null && this.l != null) {
            if (this.o) {
                b(canvas);
            } else {
                a(canvas);
            }
        }
    }

    public void setIsHalfStar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
    }

    public void setStarChangListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public void setStarCount(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            int i = this.a;
            if (f > i) {
                f = i;
            }
            if (this.b != f) {
                this.b = f;
                invalidate();
            }
            a aVar = this.q;
            if (aVar != null) {
                aVar.a(f);
            }
        }
    }

    public void setStarSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.c = i;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b != 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k = SvgManager.getInstance().getPureDrawable(this.f, this.g, null);
            this.l = SvgManager.getInstance().getPureDrawable(this.h, this.i, null);
        }
    }

    public int getStarCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            float f = this.b;
            if (f == 0.0f) {
                return 0;
            }
            if (f % 1.0d == 0.0d) {
                return (int) f;
            }
            return ((int) f) + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode2 == 1073741824) {
                this.d = (size2 - getPaddingBottom()) - getPaddingTop();
            } else {
                size2 = this.d + getPaddingBottom() + getPaddingTop();
            }
            int i3 = this.d;
            int i4 = this.a;
            int i5 = (i3 * i4) + (this.c * (i4 - 1));
            this.e = i5;
            if (mode != 1073741824) {
                size = getPaddingRight() + i5 + getPaddingLeft();
            } else if (size < i5) {
                this.e = (size - getPaddingLeft()) - getPaddingRight();
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setFullStarColorListIndex(int i, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) && i >= 0 && i < 5) {
            this.j[i] = SvgManager.getInstance().getPureDrawableWithColorInt(this.h, i2, null);
        }
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i, i2, i3, i4) == null) {
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = i4;
            g();
        }
    }
}
