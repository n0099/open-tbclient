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
/* loaded from: classes7.dex */
public class HotUserRankImageOverlayView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STROCK_STYLE_CIRCLE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f50066e;

    /* renamed from: f  reason: collision with root package name */
    public int f50067f;

    /* renamed from: g  reason: collision with root package name */
    public int f50068g;

    /* renamed from: h  reason: collision with root package name */
    public int f50069h;

    /* renamed from: i  reason: collision with root package name */
    public int f50070i;

    /* renamed from: j  reason: collision with root package name */
    public int f50071j;
    public ImageOverlayView.b k;
    public int l;
    public boolean m;
    public final View.OnClickListener mPhotoOnClickListener;
    public Paint n;
    public int o;
    public int p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankImageOverlayView f50072e;

        public a(HotUserRankImageOverlayView hotUserRankImageOverlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankImageOverlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50072e = hotUserRankImageOverlayView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50072e.k == null) {
                return;
            }
            this.f50072e.k.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotUserRankImageOverlayView(Context context) {
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
        this.l = 10;
        this.m = false;
        this.p = 1;
        this.mPhotoOnClickListener = new a(this);
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i2 = 0; i2 < this.f50066e; i2++) {
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.f50067f, this.f50068g));
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.n = paint;
            paint.setAntiAlias(true);
            this.n.setStyle(Paint.Style.STROKE);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            this.n.setColor(SkinManager.getColor(this.f50070i));
            this.n.setStrokeWidth(this.f50069h);
            int i2 = this.o;
            if (i2 <= 0) {
                i2 = this.f50070i;
            }
            this.o = i2;
            float f2 = this.f50069h * 0.5f;
            float f3 = this.f50067f / 2.0f;
            float acos = ((float) ((Math.acos((((f3 * 2.0f) - this.f50071j) / 2.0f) / f3) / 3.141592653589793d) * 180.0d)) - 180.0f;
            float abs = Math.abs(2.0f * acos);
            int i3 = 0;
            int childCount = this.m ? 0 : getChildCount() - 1;
            while (i3 < getChildCount()) {
                View childAt = getChildAt(i3);
                if ((childAt instanceof HeadImageView) && childAt.getVisibility() == 0) {
                    float left = childAt.getLeft() - f2;
                    float top = childAt.getTop() - f2;
                    float right = childAt.getRight() + f2;
                    float bottom = childAt.getBottom() + f2;
                    if (i3 == childCount) {
                        this.n.setColor(SkinManager.getColor(this.o));
                    } else {
                        this.n.setColor(SkinManager.getColor(this.f50070i));
                    }
                    canvas.drawArc(left, top, right, bottom, i3 == childCount ? 0.0f : acos, i3 == childCount ? 360.0f : abs, false, this.n);
                }
                i3++;
            }
        }
    }

    public void init(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.f50066e = i2;
            this.f50067f = i3;
            this.f50068g = i4;
            this.f50069h = i5;
            this.f50070i = i6;
            this.f50071j = i7;
            b();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.n.setColor(SkinManager.getColor(this.f50070i));
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof HeadImageView) {
                    ((HeadImageView) childAt).setPlaceHolder(1);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int paddingLeft = getPaddingLeft() + ((this.f50066e - 1) * (this.f50067f - this.f50071j)) + this.f50069h;
            int paddingTop = getPaddingTop() + this.f50069h;
            for (int i6 = 0; i6 < this.f50066e && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
                childAt.layout(paddingLeft, paddingTop, this.f50067f + paddingLeft, this.f50068g + paddingTop);
                paddingLeft -= this.f50067f - this.f50071j;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            int i4 = this.f50069h;
            if (this.p == 1) {
                i4 *= 2;
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight() + i4;
            int i5 = this.f50066e;
            setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f50067f * i5)) - ((i5 - 1) * this.f50071j), i2), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f50068g + (this.f50069h * 2), i3));
        }
    }

    public void setData(List<String> list) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (int i2 = this.f50066e - 1; i2 >= 0; i2--) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i2);
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
                if (this.l == 12) {
                    headImageView.startLoad(str, 12, this.f50067f, this.f50068g, false);
                } else {
                    headImageView.startLoad(str, 10, this.f50067f, this.f50068g, false);
                }
            }
        }
    }

    public void setFirstImageStrokeColor(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setImageClickListener(ImageOverlayView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void setLoadImageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setStrokeStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.p = i2;
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
        this.l = 10;
        this.m = false;
        this.p = 1;
        this.mPhotoOnClickListener = new a(this);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet, int i2) {
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
        this.l = 10;
        this.m = false;
        this.p = 1;
        this.mPhotoOnClickListener = new a(this);
        c();
    }
}
