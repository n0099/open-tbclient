package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AdapterLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class RoundAdapterLinearLayout extends AdapterLinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public float f16293g;

    /* renamed from: h  reason: collision with root package name */
    public Shape f16294h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f16295i;
    public Paint j;
    public RectF k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1109393353, "Lcom/baidu/tieba/frs/view/RoundAdapterLinearLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1109393353, "Lcom/baidu/tieba/frs/view/RoundAdapterLinearLayout;");
                return;
            }
        }
        l = R.color.black_alpha4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAdapterLinearLayout(Context context) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            super.dispatchDraw(canvas);
            Shape shape = this.f16294h;
            if (shape != null) {
                shape.draw(canvas, this.f16295i);
            }
            RectF rectF = this.k;
            float f2 = this.f16293g;
            canvas.drawRoundRect(rectF, f2, f2, this.j);
            if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                if (this.f16294h == null) {
                    float[] fArr = new float[8];
                    Arrays.fill(fArr, 0.0f);
                    float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingLeft();
                    float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingRight();
                    float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                    float paddingBottom = getPaddingBottom() > 0 ? getPaddingBottom() : 1.0f;
                    RectF rectF = new RectF(dimension, paddingTop, dimension2, paddingBottom);
                    float[] fArr2 = new float[8];
                    Arrays.fill(fArr2, this.f16293g);
                    this.f16294h = new RoundRectShape(fArr, rectF, fArr2);
                    this.k.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - paddingBottom);
                }
                this.f16294h.resize(getWidth(), getHeight());
            }
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.f16293g = f2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAdapterLinearLayout(Context context, AttributeSet attributeSet) {
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
    public RoundAdapterLinearLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f16293g = 0.0f;
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f16295i = paint;
        paint.setAntiAlias(true);
        this.f16295i.setColor(-7829368);
        this.f16295i.setStyle(Paint.Style.FILL);
        this.f16295i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setAntiAlias(true);
        this.j.setColor(getResources().getColor(l));
        this.j.setStyle(Paint.Style.FILL);
        this.j.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds4), getResources().getColor(l));
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.k = new RectF();
    }
}
