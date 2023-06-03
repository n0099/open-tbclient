package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ItemTableRowView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public float c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Drawable j;
    public Drawable k;
    public RectF l;
    public Paint m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-462378173, "Lcom/baidu/tieba/frs/view/ItemTableRowView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-462378173, "Lcom/baidu/tieba/frs/view/ItemTableRowView;");
                return;
            }
        }
        t = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
        u = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
        v = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
        w = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        x = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
        y = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        z = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemTableRowView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.b = 5;
        this.g = R.drawable.icon_pure_evaluation_star24_n;
        this.h = 17170445;
        this.i = R.color.CAM_X0109;
        this.q = R.color.CAM_X0210;
        this.r = R.color.CAM_X0305;
        b();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = 0.0f;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            invalidate();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = SvgManager.getInstance().getPureDrawable(this.g, this.h, null);
            this.k = SvgManager.getInstance().getPureDrawable(this.g, this.i, null);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = t;
            this.d = u;
            this.n = v;
            this.o = w;
            this.p = x;
            this.s = y;
            d();
            this.l = new RectF();
            this.m = new Paint(1);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.j != null && this.k != null) {
                int paddingLeft = getPaddingLeft();
                int i2 = 0;
                while (true) {
                    i = this.a;
                    if (i2 >= i) {
                        break;
                    }
                    Drawable drawable = this.j;
                    int paddingTop = getPaddingTop();
                    int i3 = this.e;
                    drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i3, i3 + getPaddingTop());
                    this.j.draw(canvas);
                    paddingLeft += this.d + this.e;
                    i2++;
                }
                while (i < this.b) {
                    Drawable drawable2 = this.k;
                    int paddingTop2 = getPaddingTop();
                    int i4 = this.e;
                    drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i4, i4 + getPaddingTop());
                    this.k.draw(canvas);
                    paddingLeft += this.d + this.e;
                    i++;
                }
                int i5 = (paddingLeft - this.d) + this.s;
                float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.o) / 2;
                float f = i5;
                this.l.set(f, measuredHeight, getMeasuredWidth(), this.o + measuredHeight);
                this.m.setColor(SkinManager.getColor(this.q));
                RectF rectF = this.l;
                int i6 = this.p;
                canvas.drawRoundRect(rectF, i6, i6, this.m);
                this.m.setColor(SkinManager.getColor(this.r));
                this.l.set(f, measuredHeight, ((getMeasuredWidth() - i5) * this.c) + f, this.o + measuredHeight);
                RectF rectF2 = this.l;
                int i7 = this.p;
                canvas.drawRoundRect(rectF2, i7, i7, this.m);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode2 == 1073741824) {
                int paddingBottom = (size2 - getPaddingBottom()) - getPaddingTop();
                this.e = paddingBottom;
                this.o = Math.max(0, paddingBottom - z);
            } else {
                size2 = this.e + getPaddingBottom() + getPaddingTop();
            }
            int i3 = this.e;
            int i4 = this.b;
            int i5 = (i3 * i4) + (this.d * (i4 - 1));
            this.f = i5;
            if (mode != 1073741824) {
                size = this.s + i5 + getPaddingLeft() + getPaddingRight() + this.n;
            } else if (size < i5) {
                this.n = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.f) - this.s);
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setData(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.c = f;
        }
    }

    public void setEmptyStartCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }
}
