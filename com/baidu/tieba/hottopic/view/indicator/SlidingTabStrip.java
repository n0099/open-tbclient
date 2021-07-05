package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SlidingTabStrip extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f17208e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f17209f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f17210g;

    /* renamed from: h  reason: collision with root package name */
    public int f17211h;

    /* renamed from: i  reason: collision with root package name */
    public int f17212i;
    public int j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingTabStrip(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            View childAt = getChildAt(i2);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
            if (i2 == 0) {
                this.f17212i = childAt.getLeft();
            } else {
                this.f17212i = childAt.getLeft() + dimensionPixelSize2;
            }
            this.j = this.f17212i + dimensionPixelSize;
            if (f2 < 0.0f || i2 >= getChildCount() - 1) {
                return;
            }
            View childAt2 = getChildAt(i2 + 1);
            float f3 = 1.0f - f2;
            this.f17212i = (int) (((childAt2.getLeft() + dimensionPixelSize2) * f2) + (this.f17212i * f3));
            this.j = (int) ((f2 * (childAt2.getLeft() + dimensionPixelSize2 + dimensionPixelSize)) + (f3 * this.j));
        }
    }

    public void b(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            a(i2, f2);
            invalidate();
        }
    }

    public final void c(Canvas canvas, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, canvas, i2) == null) {
            if (this.j <= 0 && (i3 = this.f17211h) >= 0 && i3 < getChildCount()) {
                this.j = getChildAt(this.f17211h).getRight() - getResources().getDimensionPixelSize(R.dimen.ds14);
            }
            canvas.drawRoundRect(new RectF(this.f17212i, i2 - this.f17208e, this.j, i2), 10.0f, 10.0f, this.f17209f);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f17209f.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0105));
            this.f17210g.setColor(SkinManager.getColor(R.color.CAM_X0204));
            invalidate();
            int childCount = getChildCount();
            if (childCount <= 0) {
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    tabItemView.a();
                    if (i3 == this.f17211h) {
                        SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0105, 1);
                    } else {
                        SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0107, 1);
                    }
                }
            }
        }
    }

    public void e(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds14);
            View childAt = getChildAt(i2);
            View childAt2 = getChildAt(this.f17211h);
            int left = childAt.getLeft();
            float left2 = (childAt2.getLeft() - left) * f2;
            if (this.f17211h == 0) {
                this.f17212i = (int) (left + left2);
            } else {
                this.f17212i = (int) (left + left2 + dimensionPixelSize);
            }
            this.j = this.f17212i + getResources().getDimensionPixelSize(R.dimen.ds64);
            invalidate();
        }
    }

    public void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) || i2 == i3) {
            return;
        }
        this.f17211h = i2;
        int childCount = getChildCount();
        if (i2 >= 0 && i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TabItemView) {
                SkinManager.setViewTextColor(((TabItemView) childAt).getTextView(), R.color.CAM_X0105, 1);
            }
        }
        if (i3 < 0 || i3 >= childCount) {
            return;
        }
        View childAt2 = getChildAt(i3);
        if (childAt2 instanceof TabItemView) {
            SkinManager.setViewTextColor(((TabItemView) childAt2).getTextView(), R.color.CAM_X0107, 1);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            int childCount = getChildCount();
            if (canvas == null || childCount <= 0) {
                return;
            }
            c(canvas, getHeight());
        }
    }

    public void setDrawBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingTabStrip(Context context, AttributeSet attributeSet) {
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
        setWillNotDraw(false);
        this.f17208e = getResources().getDimensionPixelSize(R.dimen.ds5);
        Paint paint = new Paint();
        this.f17209f = paint;
        paint.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0105));
        Paint paint2 = new Paint();
        this.f17210g = paint2;
        paint2.setColor(SkinManager.getColor(R.color.CAM_X0204));
    }
}
