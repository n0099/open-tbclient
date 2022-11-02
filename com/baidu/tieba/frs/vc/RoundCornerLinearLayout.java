package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class RoundCornerLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f */
    public static final int white_alpha100 = 2131101815;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public Shape b;
    public Paint c;
    public Paint d;
    public RectF e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(107794293, "Lcom/baidu/tieba/frs/vc/RoundCornerLinearLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(107794293, "Lcom/baidu/tieba/frs/vc/RoundCornerLinearLayout;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundCornerLinearLayout(Context context) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            super.dispatchDraw(canvas);
            Shape shape = this.b;
            if (shape != null) {
                shape.draw(canvas, this.c);
            }
            RectF rectF = this.e;
            float f = this.a;
            canvas.drawRoundRect(rectF, f, f, this.d);
            if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveCount);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
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
    public RoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayerType(1, null);
            Paint paint = new Paint();
            this.c = paint;
            paint.setAntiAlias(true);
            this.c.setColor(-7829368);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Paint paint2 = new Paint();
            this.d = paint2;
            paint2.setAntiAlias(true);
            this.d.setColor(getResources().getColor(white_alpha100));
            this.d.setStyle(Paint.Style.FILL);
            this.d.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds4), getResources().getColor(white_alpha100));
            this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
            this.e = new RectF();
            this.a = getResources().getDimension(R.dimen.tbds20);
            setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.tbds1));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float paddingLeft;
        float paddingRight;
        float paddingTop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                if (this.b == null) {
                    float[] fArr = new float[8];
                    Arrays.fill(fArr, 0.0f);
                    if (getPaddingLeft() <= getResources().getDimension(R.dimen.tbds5)) {
                        paddingLeft = getResources().getDimension(R.dimen.tbds5);
                    } else {
                        paddingLeft = getPaddingLeft();
                    }
                    if (getPaddingRight() <= getResources().getDimension(R.dimen.tbds5)) {
                        paddingRight = getResources().getDimension(R.dimen.tbds5);
                    } else {
                        paddingRight = getPaddingRight();
                    }
                    float f = 1.0f;
                    if (getPaddingTop() <= 0) {
                        paddingTop = 1.0f;
                    } else {
                        paddingTop = getPaddingTop();
                    }
                    if (getPaddingBottom() > 0) {
                        f = getPaddingBottom();
                    }
                    RectF rectF = new RectF(paddingLeft, paddingTop, paddingRight, f);
                    float[] fArr2 = new float[8];
                    Arrays.fill(fArr2, this.a);
                    this.b = new RoundRectShape(fArr, rectF, fArr2);
                    this.e.set(paddingLeft, paddingTop, getWidth() - paddingRight, getHeight() - f);
                }
                this.b.resize(getWidth(), getHeight());
            }
        }
    }

    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.a = f;
        }
    }
}
