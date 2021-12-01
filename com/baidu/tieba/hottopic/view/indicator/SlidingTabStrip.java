package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import c.a.r0.p1.b;
import c.a.r0.p1.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SlidingTabStrip extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f45758e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f45759f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f45760g;

    /* renamed from: h  reason: collision with root package name */
    public int f45761h;

    /* renamed from: i  reason: collision with root package name */
    public int f45762i;

    /* renamed from: j  reason: collision with root package name */
    public int f45763j;

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
            int dimensionPixelSize = getResources().getDimensionPixelSize(c.ds64);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.ds14);
            if (i2 == 0) {
                this.f45762i = childAt.getLeft();
            } else {
                this.f45762i = childAt.getLeft() + dimensionPixelSize2;
            }
            this.f45763j = this.f45762i + dimensionPixelSize;
            if (f2 < 0.0f || i2 >= getChildCount() - 1) {
                return;
            }
            View childAt2 = getChildAt(i2 + 1);
            float f3 = 1.0f - f2;
            this.f45762i = (int) (((childAt2.getLeft() + dimensionPixelSize2) * f2) + (this.f45762i * f3));
            this.f45763j = (int) ((f2 * (childAt2.getLeft() + dimensionPixelSize2 + dimensionPixelSize)) + (f3 * this.f45763j));
        }
    }

    public final void b(Canvas canvas, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, i2) == null) {
            if (this.f45763j <= 0 && (i3 = this.f45761h) >= 0 && i3 < getChildCount()) {
                this.f45763j = getChildAt(this.f45761h).getRight() - getResources().getDimensionPixelSize(c.ds14);
            }
            canvas.drawRoundRect(new RectF(this.f45762i, i2 - this.f45758e, this.f45763j, i2), 10.0f, 10.0f, this.f45759f);
        }
    }

    public void drawScrollRect(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            a(i2, f2);
            invalidate();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f45759f.setColor(SkinManager.getSkinColor(null, b.CAM_X0105));
            this.f45760g.setColor(SkinManager.getColor(b.CAM_X0204));
            invalidate();
            int childCount = getChildCount();
            if (childCount <= 0) {
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    tabItemView.onChangeSkinType();
                    if (i3 == this.f45761h) {
                        SkinManager.setViewTextColor(tabItemView.getTextView(), b.CAM_X0105, 1);
                    } else {
                        SkinManager.setViewTextColor(tabItemView.getTextView(), b.CAM_X0107, 1);
                    }
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            int childCount = getChildCount();
            if (canvas == null || childCount <= 0) {
                return;
            }
            b(canvas, getHeight());
        }
    }

    public void performTranslate(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(c.ds14);
            View childAt = getChildAt(i2);
            View childAt2 = getChildAt(this.f45761h);
            int left = childAt.getLeft();
            float left2 = (childAt2.getLeft() - left) * f2;
            if (this.f45761h == 0) {
                this.f45762i = (int) (left + left2);
            } else {
                this.f45762i = (int) (left + left2 + dimensionPixelSize);
            }
            this.f45763j = this.f45762i + getResources().getDimensionPixelSize(c.ds64);
            invalidate();
        }
    }

    public void setDrawBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            invalidate();
        }
    }

    public void updateTextViewColor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) || i2 == i3) {
            return;
        }
        this.f45761h = i2;
        int childCount = getChildCount();
        if (i2 >= 0 && i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TabItemView) {
                SkinManager.setViewTextColor(((TabItemView) childAt).getTextView(), b.CAM_X0105, 1);
            }
        }
        if (i3 < 0 || i3 >= childCount) {
            return;
        }
        View childAt2 = getChildAt(i3);
        if (childAt2 instanceof TabItemView) {
            SkinManager.setViewTextColor(((TabItemView) childAt2).getTextView(), b.CAM_X0107, 1);
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
        this.f45758e = getResources().getDimensionPixelSize(c.ds5);
        Paint paint = new Paint();
        this.f45759f = paint;
        paint.setColor(SkinManager.getSkinColor(null, b.CAM_X0105));
        Paint paint2 = new Paint();
        this.f45760g = paint2;
        paint2.setColor(SkinManager.getColor(b.CAM_X0204));
    }
}
