package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class OCRCameraLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ORIENTATION_HORIZONTAL = 1;
    public static int ORIENTATION_PORTRAIT;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47330e;

    /* renamed from: f  reason: collision with root package name */
    public View f47331f;

    /* renamed from: g  reason: collision with root package name */
    public View f47332g;

    /* renamed from: h  reason: collision with root package name */
    public View f47333h;

    /* renamed from: i  reason: collision with root package name */
    public View f47334i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Rect n;
    public Paint o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1187408252, "Lcom/baidu/tieba/barselect/idCard/OCRCameraLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1187408252, "Lcom/baidu/tieba/barselect/idCard/OCRCameraLayout;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OCRCameraLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47330e = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.n = new Rect();
        Paint paint = new Paint();
        this.o = paint;
        paint.setStyle(Paint.Style.FILL);
        this.o.setColor(Color.argb(83, 0, 0, 0));
    }

    public final void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.OCRCameraLayout, 0, 0);
            try {
                this.j = obtainStyledAttributes.getResourceId(R$styleable.OCRCameraLayout_contentView, -1);
                this.k = obtainStyledAttributes.getResourceId(R$styleable.OCRCameraLayout_centerView, -1);
                this.l = obtainStyledAttributes.getResourceId(R$styleable.OCRCameraLayout_leftDownView, -1);
                this.m = obtainStyledAttributes.getResourceId(R$styleable.OCRCameraLayout_rightUpView, -1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            this.f47331f = findViewById(this.j);
            int i2 = this.k;
            if (i2 != -1) {
                this.f47332g = findViewById(i2);
            }
            this.f47333h = findViewById(this.l);
            this.f47334i = findViewById(this.m);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.drawRect(this.n, this.o);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int width = getWidth();
            int height = getHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47333h.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f47334i.getLayoutParams();
            if (i4 < i5) {
                int i6 = (width * 4) / 3;
                int i7 = height - i6;
                this.f47331f.layout(i2, i3, i4, i6);
                Rect rect = this.n;
                rect.left = 0;
                rect.top = i6;
                rect.right = width;
                rect.bottom = height;
                View view = this.f47332g;
                if (view != null) {
                    int measuredWidth = (width - view.getMeasuredWidth()) / 2;
                    int measuredHeight = ((i7 - this.f47332g.getMeasuredHeight()) / 2) + i6;
                    View view2 = this.f47332g;
                    view2.layout(measuredWidth, measuredHeight, view2.getMeasuredWidth() + measuredWidth, this.f47332g.getMeasuredHeight() + measuredHeight);
                }
                int i8 = marginLayoutParams.leftMargin;
                int measuredHeight2 = ((i7 - this.f47333h.getMeasuredHeight()) / 2) + i6;
                View view3 = this.f47333h;
                view3.layout(i8, measuredHeight2, view3.getMeasuredWidth() + i8, this.f47333h.getMeasuredHeight() + measuredHeight2);
                int measuredWidth2 = (width - this.f47334i.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
                int measuredHeight3 = i6 + ((i7 - this.f47334i.getMeasuredHeight()) / 2);
                View view4 = this.f47334i;
                view4.layout(measuredWidth2, measuredHeight3, view4.getMeasuredWidth() + measuredWidth2, this.f47334i.getMeasuredHeight() + measuredHeight3);
                return;
            }
            int i9 = (height * 4) / 3;
            int i10 = width - i9;
            this.f47331f.layout(i2, i3, i9, height);
            Rect rect2 = this.n;
            rect2.left = i9;
            rect2.top = 0;
            rect2.right = width;
            rect2.bottom = height;
            View view5 = this.f47332g;
            if (view5 != null) {
                int measuredWidth3 = ((i10 - view5.getMeasuredWidth()) / 2) + i9;
                int measuredHeight4 = (height - this.f47332g.getMeasuredHeight()) / 2;
                View view6 = this.f47332g;
                view6.layout(measuredWidth3, measuredHeight4, view6.getMeasuredWidth() + measuredWidth3, this.f47332g.getMeasuredHeight() + measuredHeight4);
            }
            int measuredWidth4 = ((i10 - this.f47333h.getMeasuredWidth()) / 2) + i9;
            int measuredHeight5 = (height - this.f47333h.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
            View view7 = this.f47333h;
            view7.layout(measuredWidth4, measuredHeight5, view7.getMeasuredWidth() + measuredWidth4, this.f47333h.getMeasuredHeight() + measuredHeight5);
            int measuredWidth5 = i9 + ((i10 - this.f47334i.getMeasuredWidth()) / 2);
            int i11 = marginLayoutParams2.topMargin;
            View view8 = this.f47334i;
            view8.layout(measuredWidth5, i11, view8.getMeasuredWidth() + measuredWidth5, this.f47334i.getMeasuredHeight() + i11);
        }
    }

    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f47330e == i2) {
            return;
        }
        this.f47330e = i2;
        requestLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47330e = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.n = new Rect();
        Paint paint = new Paint();
        this.o = paint;
        paint.setStyle(Paint.Style.FILL);
        this.o.setColor(Color.argb(83, 0, 0, 0));
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f47330e = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.n = new Rect();
        Paint paint = new Paint();
        this.o = paint;
        paint.setStyle(Paint.Style.FILL);
        this.o.setColor(Color.argb(83, 0, 0, 0));
        a(attributeSet);
    }
}
