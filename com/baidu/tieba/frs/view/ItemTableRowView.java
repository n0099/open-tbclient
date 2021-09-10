package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import c.a.e.e.p.l;
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
/* loaded from: classes7.dex */
public class ItemTableRowView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51795e;

    /* renamed from: f  reason: collision with root package name */
    public int f51796f;

    /* renamed from: g  reason: collision with root package name */
    public float f51797g;

    /* renamed from: h  reason: collision with root package name */
    public int f51798h;

    /* renamed from: i  reason: collision with root package name */
    public int f51799i;

    /* renamed from: j  reason: collision with root package name */
    public int f51800j;
    public int k;
    public int l;
    public int m;
    public Drawable n;
    public Drawable o;
    public RectF p;
    public Paint q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;

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
        x = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
        y = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
        z = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
        A = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        B = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
        C = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
        D = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f51799i = x;
            this.f51798h = y;
            this.r = z;
            this.s = A;
            this.t = B;
            this.w = C;
            updateStarDrawable();
            this.p = new RectF();
            this.q = new Paint(1);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f51797g = 0.0f;
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            updateStarDrawable();
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.n == null || this.o == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int i3 = 0;
            while (true) {
                i2 = this.f51795e;
                if (i3 >= i2) {
                    break;
                }
                Drawable drawable = this.n;
                int paddingTop = getPaddingTop();
                int i4 = this.f51799i;
                drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i4, i4 + getPaddingTop());
                this.n.draw(canvas);
                paddingLeft += this.f51798h + this.f51799i;
                i3++;
            }
            while (i2 < this.f51796f) {
                Drawable drawable2 = this.o;
                int paddingTop2 = getPaddingTop();
                int i5 = this.f51799i;
                drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i5, i5 + getPaddingTop());
                this.o.draw(canvas);
                paddingLeft += this.f51798h + this.f51799i;
                i2++;
            }
            int i6 = (paddingLeft - this.f51798h) + this.w;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.s) / 2;
            float f2 = i6;
            this.p.set(f2, measuredHeight, getMeasuredWidth(), this.s + measuredHeight);
            this.q.setColor(SkinManager.getColor(this.u));
            RectF rectF = this.p;
            int i7 = this.t;
            canvas.drawRoundRect(rectF, i7, i7, this.q);
            this.q.setColor(SkinManager.getColor(this.v));
            this.p.set(f2, measuredHeight, ((getMeasuredWidth() - i6) * this.f51797g) + f2, this.s + measuredHeight);
            RectF rectF2 = this.p;
            int i8 = this.t;
            canvas.drawRoundRect(rectF2, i8, i8, this.q);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode2 == 1073741824) {
                int paddingBottom = (size2 - getPaddingBottom()) - getPaddingTop();
                this.f51799i = paddingBottom;
                this.s = Math.max(0, paddingBottom - D);
            } else {
                size2 = this.f51799i + getPaddingBottom() + getPaddingTop();
            }
            int i4 = this.f51799i;
            int i5 = this.f51796f;
            int i6 = (i4 * i5) + (this.f51798h * (i5 - 1));
            this.f51800j = i6;
            if (mode != 1073741824) {
                size = this.w + i6 + getPaddingLeft() + getPaddingRight() + this.r;
            } else if (size < i6) {
                this.r = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.f51800j) - this.w);
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setData(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.f51797g = f2;
        }
    }

    public void setEmptyStartCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f51795e = i2;
        }
    }

    public void updateStarDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.n = SvgManager.getInstance().getPureDrawable(this.k, this.l, null);
            this.o = SvgManager.getInstance().getPureDrawable(this.k, this.m, null);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f51796f = 5;
        this.k = R.drawable.icon_pure_evaluation_star24_n;
        this.l = 17170445;
        this.m = R.color.CAM_X0109;
        this.u = R.color.CAM_X0210;
        this.v = R.color.CAM_X0305;
        a();
    }
}
