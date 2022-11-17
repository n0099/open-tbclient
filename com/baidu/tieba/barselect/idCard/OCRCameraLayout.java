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
import com.baidu.tieba.aq5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class OCRCameraLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int l = 0;
    public static int m = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public View c;
    public View d;
    public View e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Rect j;
    public Paint k;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = l;
        setWillNotDraw(false);
        this.j = new Rect();
        Paint paint = new Paint();
        this.k = paint;
        paint.setStyle(Paint.Style.FILL);
        this.k.setColor(Color.argb(83, 0, 0, 0));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = l;
        setWillNotDraw(false);
        this.j = new Rect();
        Paint paint = new Paint();
        this.k = paint;
        paint.setStyle(Paint.Style.FILL);
        this.k.setColor(Color.argb(83, 0, 0, 0));
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.a = l;
        setWillNotDraw(false);
        this.j = new Rect();
        Paint paint = new Paint();
        this.k = paint;
        paint.setStyle(Paint.Style.FILL);
        this.k.setColor(Color.argb(83, 0, 0, 0));
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, aq5.OCRCameraLayout, 0, 0);
            try {
                this.f = obtainStyledAttributes.getResourceId(1, -1);
                this.g = obtainStyledAttributes.getResourceId(0, -1);
                this.h = obtainStyledAttributes.getResourceId(2, -1);
                this.i = obtainStyledAttributes.getResourceId(3, -1);
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
            this.b = findViewById(this.f);
            int i = this.g;
            if (i != -1) {
                this.c = findViewById(i);
            }
            this.d = findViewById(this.h);
            this.e = findViewById(this.i);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.drawRect(this.j, this.k);
        }
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int width = getWidth();
            int height = getHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            if (i3 < i4) {
                int i5 = (width * 4) / 3;
                int i6 = height - i5;
                this.b.layout(i, i2, i3, i5);
                Rect rect = this.j;
                rect.left = 0;
                rect.top = i5;
                rect.right = width;
                rect.bottom = height;
                View view2 = this.c;
                if (view2 != null) {
                    int measuredWidth = (width - view2.getMeasuredWidth()) / 2;
                    int measuredHeight = ((i6 - this.c.getMeasuredHeight()) / 2) + i5;
                    View view3 = this.c;
                    view3.layout(measuredWidth, measuredHeight, view3.getMeasuredWidth() + measuredWidth, this.c.getMeasuredHeight() + measuredHeight);
                }
                int i7 = marginLayoutParams.leftMargin;
                int measuredHeight2 = ((i6 - this.d.getMeasuredHeight()) / 2) + i5;
                View view4 = this.d;
                view4.layout(i7, measuredHeight2, view4.getMeasuredWidth() + i7, this.d.getMeasuredHeight() + measuredHeight2);
                int measuredWidth2 = (width - this.e.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
                int measuredHeight3 = i5 + ((i6 - this.e.getMeasuredHeight()) / 2);
                View view5 = this.e;
                view5.layout(measuredWidth2, measuredHeight3, view5.getMeasuredWidth() + measuredWidth2, this.e.getMeasuredHeight() + measuredHeight3);
                return;
            }
            int i8 = (height * 4) / 3;
            int i9 = width - i8;
            this.b.layout(i, i2, i8, height);
            Rect rect2 = this.j;
            rect2.left = i8;
            rect2.top = 0;
            rect2.right = width;
            rect2.bottom = height;
            View view6 = this.c;
            if (view6 != null) {
                int measuredWidth3 = ((i9 - view6.getMeasuredWidth()) / 2) + i8;
                int measuredHeight4 = (height - this.c.getMeasuredHeight()) / 2;
                View view7 = this.c;
                view7.layout(measuredWidth3, measuredHeight4, view7.getMeasuredWidth() + measuredWidth3, this.c.getMeasuredHeight() + measuredHeight4);
            }
            int measuredWidth4 = ((i9 - this.d.getMeasuredWidth()) / 2) + i8;
            int measuredHeight5 = (height - this.d.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
            View view8 = this.d;
            view8.layout(measuredWidth4, measuredHeight5, view8.getMeasuredWidth() + measuredWidth4, this.d.getMeasuredHeight() + measuredHeight5);
            int measuredWidth5 = i8 + ((i9 - this.e.getMeasuredWidth()) / 2);
            int i10 = marginLayoutParams2.topMargin;
            View view9 = this.e;
            view9.layout(measuredWidth5, i10, view9.getMeasuredWidth() + measuredWidth5, this.e.getMeasuredHeight() + i10);
        }
    }
}
