package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
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

    /* renamed from: b  reason: collision with root package name */
    public int f32999b;

    /* renamed from: c  reason: collision with root package name */
    public float f33000c;

    /* renamed from: d  reason: collision with root package name */
    public int f33001d;

    /* renamed from: e  reason: collision with root package name */
    public int f33002e;

    /* renamed from: f  reason: collision with root package name */
    public int f33003f;

    /* renamed from: g  reason: collision with root package name */
    public int f33004g;

    /* renamed from: h  reason: collision with root package name */
    public int f33005h;
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
        t = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
        u = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
        v = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
        w = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        x = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
        y = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        z = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33000c = 0.0f;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f33002e = t;
            this.f33001d = u;
            this.n = v;
            this.o = w;
            this.p = x;
            this.s = y;
            d();
            this.l = new RectF();
            this.m = new Paint(1);
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
            this.j = SvgManager.getInstance().getPureDrawable(this.f33004g, this.f33005h, null);
            this.k = SvgManager.getInstance().getPureDrawable(this.f33004g, this.i, null);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.j == null || this.k == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int i2 = 0;
            while (true) {
                i = this.a;
                if (i2 >= i) {
                    break;
                }
                Drawable drawable = this.j;
                int paddingTop = getPaddingTop();
                int i3 = this.f33002e;
                drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i3, i3 + getPaddingTop());
                this.j.draw(canvas);
                paddingLeft += this.f33001d + this.f33002e;
                i2++;
            }
            while (i < this.f32999b) {
                Drawable drawable2 = this.k;
                int paddingTop2 = getPaddingTop();
                int i4 = this.f33002e;
                drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i4, i4 + getPaddingTop());
                this.k.draw(canvas);
                paddingLeft += this.f33001d + this.f33002e;
                i++;
            }
            int i5 = (paddingLeft - this.f33001d) + this.s;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.o) / 2;
            float f2 = i5;
            this.l.set(f2, measuredHeight, getMeasuredWidth(), this.o + measuredHeight);
            this.m.setColor(SkinManager.getColor(this.q));
            RectF rectF = this.l;
            int i6 = this.p;
            canvas.drawRoundRect(rectF, i6, i6, this.m);
            this.m.setColor(SkinManager.getColor(this.r));
            this.l.set(f2, measuredHeight, ((getMeasuredWidth() - i5) * this.f33000c) + f2, this.o + measuredHeight);
            RectF rectF2 = this.l;
            int i7 = this.p;
            canvas.drawRoundRect(rectF2, i7, i7, this.m);
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
                this.f33002e = paddingBottom;
                this.o = Math.max(0, paddingBottom - z);
            } else {
                size2 = this.f33002e + getPaddingBottom() + getPaddingTop();
            }
            int i3 = this.f33002e;
            int i4 = this.f32999b;
            int i5 = (i3 * i4) + (this.f33001d * (i4 - 1));
            this.f33003f = i5;
            if (mode != 1073741824) {
                size = this.s + i5 + getPaddingLeft() + getPaddingRight() + this.n;
            } else if (size < i5) {
                this.n = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.f33003f) - this.s);
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setData(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.f33000c = f2;
        }
    }

    public void setEmptyStartCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
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
        this.f32999b = 5;
        this.f33004g = R.drawable.icon_pure_evaluation_star24_n;
        this.f33005h = 17170445;
        this.i = R.color.CAM_X0109;
        this.q = R.color.CAM_X0210;
        this.r = R.color.CAM_X0305;
        b();
    }
}
