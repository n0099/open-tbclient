package com.baidu.tieba.enterForum.tabfeed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class HotUserRankImageOverlayView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public ImageOverlayView.a g;
    public int h;
    public boolean i;
    public Paint j;
    public int k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotUserRankImageOverlayView(Context context) {
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
        this.h = 10;
        this.i = false;
        this.l = 1;
        c();
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.a; i++) {
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.b, this.c));
                headImageView.setIsRound(true);
                headImageView.setBorderSurroundContent(true);
                headImageView.setDrawBorder(true);
                headImageView.setAutoChangeStyle(true);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setPlaceHolder(1);
                addView(headImageView);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Paint paint = new Paint();
            this.j = paint;
            paint.setAntiAlias(true);
            this.j.setStyle(Paint.Style.STROKE);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.setColor(SkinManager.getColor(this.e));
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof HeadImageView) {
                    ((HeadImageView) childAt).setPlaceHolder(1);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.dispatchDraw(canvas);
            this.j.setColor(SkinManager.getColor(this.e));
            this.j.setStrokeWidth(this.d);
            int i = this.k;
            if (i <= 0) {
                i = this.e;
            }
            this.k = i;
            float f = this.d * 0.5f;
            float f2 = this.b / 2.0f;
            float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.f) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
            float abs = Math.abs(2.0f * acos);
            int i2 = 0;
            int childCount = this.i ? 0 : getChildCount() - 1;
            while (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if ((childAt instanceof HeadImageView) && childAt.getVisibility() == 0) {
                    float left = childAt.getLeft() - f;
                    float top = childAt.getTop() - f;
                    float right = childAt.getRight() + f;
                    float bottom = childAt.getBottom() + f;
                    if (i2 == childCount) {
                        this.j.setColor(SkinManager.getColor(this.k));
                    } else {
                        this.j.setColor(SkinManager.getColor(this.e));
                    }
                    canvas.drawArc(left, top, right, bottom, i2 == childCount ? 0.0f : acos, i2 == childCount ? 360.0f : abs, false, this.j);
                }
                i2++;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int paddingLeft = getPaddingLeft() + ((this.a - 1) * (this.b - this.f)) + this.d;
            int paddingTop = getPaddingTop() + this.d;
            for (int i5 = 0; i5 < this.a && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
                childAt.layout(paddingLeft, paddingTop, this.b + paddingLeft, this.c + paddingTop);
                paddingLeft -= this.b - this.f;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            int i3 = this.d;
            if (this.l == 1) {
                i3 *= 2;
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight() + i3;
            int i4 = this.a;
            setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.b * i4)) - ((i4 - 1) * this.f), i), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.c + (this.d * 2), i2));
        }
    }

    public void setData(List<String> list) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (int i = this.a - 1; i >= 0; i--) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView == null) {
                return;
            }
            if (list.size() > 0) {
                str = list.remove(0);
                z = true;
            } else {
                str = null;
                z = false;
            }
            if (!z) {
                headImageView.setVisibility(4);
            } else {
                headImageView.setVisibility(0);
                if (this.h == 12) {
                    headImageView.G(str, 12, this.b, this.c, false);
                } else {
                    headImageView.G(str, 10, this.b, this.c, false);
                }
            }
        }
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.k = i;
        }
    }

    public void setImageClickListener(ImageOverlayView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public void setLoadImageType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h = i;
        }
    }

    public void setStrokeStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.l = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet) {
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
        this.h = 10;
        this.i = false;
        this.l = 1;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet, int i) {
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
        this.h = 10;
        this.i = false;
        this.l = 1;
        c();
    }
}
