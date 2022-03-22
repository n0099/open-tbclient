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
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RankStarView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public float f30705b;

    /* renamed from: c  reason: collision with root package name */
    public int f30706c;

    /* renamed from: d  reason: collision with root package name */
    public int f30707d;

    /* renamed from: e  reason: collision with root package name */
    public int f30708e;

    /* renamed from: f  reason: collision with root package name */
    public int f30709f;

    /* renamed from: g  reason: collision with root package name */
    public int f30710g;

    /* renamed from: h  reason: collision with root package name */
    public int f30711h;
    public int i;
    public Drawable j;
    public Drawable k;
    public Rect l;
    public Rect m;
    public boolean n;
    public int o;
    public a p;

    /* loaded from: classes5.dex */
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
        this.f30709f = R.drawable.icon_pure_evaluation_star24_n;
        this.f30710g = R.color.CAM_X0112;
        this.f30711h = R.drawable.icon_pure_evaluation_star24_n;
        this.i = R.color.CAM_X0305;
        this.o = 3;
        d(context);
    }

    public final void a(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.j == null || this.k == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int i = 0;
        while (true) {
            f2 = this.f30705b;
            if (i >= f2) {
                break;
            }
            Drawable drawable = this.k;
            int paddingTop = getPaddingTop();
            int i2 = this.f30707d;
            drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i2, i2 + getPaddingTop());
            this.k.draw(canvas);
            paddingLeft += this.f30706c + this.f30707d;
            i++;
        }
        if (f2 - ((int) f2) <= 0.0f) {
            for (int i3 = (int) f2; i3 < this.a; i3++) {
                Drawable drawable2 = this.j;
                int paddingTop2 = getPaddingTop();
                int i4 = this.f30707d;
                drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i4, i4 + getPaddingTop());
                this.j.draw(canvas);
                paddingLeft += this.f30706c + this.f30707d;
            }
            return;
        }
        int i5 = (int) f2;
        while (true) {
            i5++;
            if (i5 >= this.a) {
                return;
            }
            Drawable drawable3 = this.j;
            int paddingTop3 = getPaddingTop();
            int i6 = this.f30707d;
            drawable3.setBounds(paddingLeft, paddingTop3, paddingLeft + i6, i6 + getPaddingTop());
            this.j.draw(canvas);
            paddingLeft += this.f30706c + this.f30707d;
        }
    }

    public final void b(Canvas canvas) {
        float f2;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) != null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int i3 = 0;
        while (true) {
            f2 = this.f30705b;
            if (i3 >= ((int) f2)) {
                break;
            }
            Drawable drawable = this.k;
            int paddingTop = getPaddingTop();
            int i4 = this.f30707d;
            drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i4, i4 + getPaddingTop());
            this.k.draw(canvas);
            paddingLeft += this.f30706c + this.f30707d;
            i3++;
        }
        if (f2 - ((int) f2) >= 0.5d) {
            Drawable drawable2 = this.k;
            int paddingTop2 = getPaddingTop();
            int i5 = this.f30707d;
            drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i5, i5 + getPaddingTop());
            this.k.draw(canvas);
            i = this.f30706c;
            i2 = this.f30707d;
        } else if (f2 - ((int) f2) > 0.0f) {
            Drawable drawable3 = this.k;
            int paddingTop3 = getPaddingTop();
            int i6 = this.f30707d;
            drawable3.setBounds(paddingLeft, paddingTop3, paddingLeft + i6, i6 + getPaddingTop());
            canvas.save();
            Rect rect = this.l;
            int paddingTop4 = getPaddingTop();
            int i7 = this.f30707d;
            rect.set(paddingLeft, paddingTop4, (i7 / 2) + paddingLeft, i7 + getPaddingTop());
            canvas.clipRect(this.l);
            this.k.draw(canvas);
            canvas.restore();
            Drawable drawable4 = this.j;
            int paddingTop5 = getPaddingTop();
            int i8 = this.f30707d;
            drawable4.setBounds(paddingLeft, paddingTop5, paddingLeft + i8, i8 + getPaddingTop());
            canvas.save();
            int paddingTop6 = getPaddingTop();
            int i9 = this.f30707d;
            this.m.set((this.f30707d / 2) + paddingLeft, paddingTop6, paddingLeft + i9, i9 + getPaddingTop());
            canvas.clipRect(this.m);
            this.j.draw(canvas);
            canvas.restore();
            i = this.f30706c;
            i2 = this.f30707d;
        } else {
            Drawable drawable5 = this.j;
            int paddingTop7 = getPaddingTop();
            int i10 = this.f30707d;
            drawable5.setBounds(paddingLeft, paddingTop7, paddingLeft + i10, i10 + getPaddingTop());
            this.j.draw(canvas);
            i = this.f30706c;
            i2 = this.f30707d;
        }
        int i11 = paddingLeft + i + i2;
        int i12 = (int) this.f30705b;
        while (true) {
            i12++;
            if (i12 >= this.a) {
                return;
            }
            Drawable drawable6 = this.j;
            int paddingTop8 = getPaddingTop();
            int i13 = this.f30707d;
            drawable6.setBounds(i11, paddingTop8, i11 + i13, i13 + getPaddingTop());
            this.j.draw(canvas);
            i11 += this.f30706c + this.f30707d;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30705b != 0.0f : invokeV.booleanValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f30707d = n.f(context, R.dimen.tbds63);
            this.l = new Rect(0, 0, 0, 0);
            this.m = new Rect(0, 0, 0, 0);
            f();
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || this.o == i) {
            return;
        }
        this.o = i;
        f();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j = SvgManager.getInstance().getPureDrawable(this.f30709f, this.f30710g, null);
            this.k = SvgManager.getInstance().getPureDrawable(this.f30711h, this.i, null);
        }
    }

    public int getStarCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f2 = this.f30705b;
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) || this.j == null || this.k == null) {
            return;
        }
        if (this.n) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode2 == 1073741824) {
                this.f30707d = (size2 - getPaddingBottom()) - getPaddingTop();
            } else {
                size2 = this.f30707d + getPaddingBottom() + getPaddingTop();
            }
            int i3 = this.f30707d;
            int i4 = this.a;
            int i5 = (i3 * i4) + (this.f30706c * (i4 - 1));
            this.f30708e = i5;
            if (mode != 1073741824) {
                size = getPaddingRight() + i5 + getPaddingLeft();
            } else if (size < i5) {
                this.f30708e = (size - getPaddingLeft()) - getPaddingRight();
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
                if (x < getPaddingLeft() - 10 || x > this.f30708e + getPaddingLeft() + 10) {
                    return true;
                }
                setStarCount((((x - getPaddingLeft()) * 1.0f) / this.f30708e) * this.a);
            }
            return onTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public void setIsHalfStar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.n = z;
        }
    }

    public void setStarChangListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void setStarCount(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            int i = this.a;
            if (f2 > i) {
                f2 = i;
            }
            if (this.f30705b != f2) {
                this.f30705b = f2;
                invalidate();
            }
            a aVar = this.p;
            if (aVar != null) {
                aVar.a(f2);
            }
        }
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i, i2, i3, i4) == null) {
            this.f30709f = i;
            this.f30710g = i2;
            this.f30711h = i3;
            this.i = i4;
            f();
        }
    }

    public void setStarSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f30706c = i;
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
        this.f30709f = R.drawable.icon_pure_evaluation_star24_n;
        this.f30710g = R.color.CAM_X0112;
        this.f30711h = R.drawable.icon_pure_evaluation_star24_n;
        this.i = R.color.CAM_X0305;
        this.o = 3;
        d(context);
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
        this.f30709f = R.drawable.icon_pure_evaluation_star24_n;
        this.f30710g = R.color.CAM_X0112;
        this.f30711h = R.drawable.icon_pure_evaluation_star24_n;
        this.i = R.color.CAM_X0305;
        this.o = 3;
        d(context);
    }
}
