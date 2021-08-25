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
/* loaded from: classes7.dex */
public class RoundCornerLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final int f51487j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f51488e;

    /* renamed from: f  reason: collision with root package name */
    public Shape f51489f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f51490g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f51491h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f51492i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(107794293, "Lcom/baidu/tieba/frs/vc/RoundCornerLinearLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(107794293, "Lcom/baidu/tieba/frs/vc/RoundCornerLinearLayout;");
                return;
            }
        }
        f51487j = R.color.white_alpha100;
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
            setLayerType(1, null);
            Paint paint = new Paint();
            this.f51490g = paint;
            paint.setAntiAlias(true);
            this.f51490g.setColor(-7829368);
            this.f51490g.setStyle(Paint.Style.FILL);
            this.f51490g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Paint paint2 = new Paint();
            this.f51491h = paint2;
            paint2.setAntiAlias(true);
            this.f51491h.setColor(getResources().getColor(f51487j));
            this.f51491h.setStyle(Paint.Style.FILL);
            this.f51491h.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds4), getResources().getColor(f51487j));
            this.f51491h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
            this.f51492i = new RectF();
            this.f51488e = getResources().getDimension(R.dimen.tbds20);
            setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.tbds1));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            super.dispatchDraw(canvas);
            Shape shape = this.f51489f;
            if (shape != null) {
                shape.draw(canvas, this.f51490g);
            }
            RectF rectF = this.f51492i;
            float f2 = this.f51488e;
            canvas.drawRoundRect(rectF, f2, f2, this.f51491h);
            if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                if (this.f51489f == null) {
                    float[] fArr = new float[8];
                    Arrays.fill(fArr, 0.0f);
                    float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingLeft();
                    float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingRight();
                    float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                    float paddingBottom = getPaddingBottom() > 0 ? getPaddingBottom() : 1.0f;
                    RectF rectF = new RectF(dimension, paddingTop, dimension2, paddingBottom);
                    float[] fArr2 = new float[8];
                    Arrays.fill(fArr2, this.f51488e);
                    this.f51489f = new RoundRectShape(fArr, rectF, fArr2);
                    this.f51492i.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - paddingBottom);
                }
                this.f51489f.resize(getWidth(), getHeight());
            }
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.f51488e = f2;
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
    public RoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a();
    }
}
