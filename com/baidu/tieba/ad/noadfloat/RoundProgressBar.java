package com.baidu.tieba.ad.noadfloat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class RoundProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public static int e;
    public static int f;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public int b;
    public int c;
    public RectF d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1257666862, "Lcom/baidu/tieba/ad/noadfloat/RoundProgressBar;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1257666862, "Lcom/baidu/tieba/ad/noadfloat/RoundProgressBar;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundProgressBar(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundProgressBar(Context context, AttributeSet attributeSet) {
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
    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
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
        this.a = new Paint();
        this.d = new RectF();
        this.b = 100;
        e = getResources().getDimensionPixelSize(R.dimen.L_X04);
        f = getResources().getDimensionPixelSize(R.dimen.tbds62);
    }

    public synchronized int getMax() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i = this.b;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int getProgress() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i = this.c;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            int width = getWidth() / 2;
            this.a.reset();
            this.a.setAntiAlias(true);
            this.a.setColor(SkinManager.getColor(R.color.CAM_X0211));
            float f2 = width;
            canvas.drawCircle(f2, f2, f, this.a);
            this.a.setColor(SkinManager.getColor(R.color.CAM_X0905));
            canvas.drawCircle(f2, f2, f, this.a);
            this.a.reset();
            this.a.setAntiAlias(true);
            this.a.setStrokeCap(Paint.Cap.ROUND);
            this.a.setStrokeWidth(e);
            this.a.setColor(SkinManager.getColor(R.color.CAM_X0302));
            RectF rectF = this.d;
            int i = f;
            rectF.set(width - i, width - i, width + i, width + i);
            this.a.setStyle(Paint.Style.STROKE);
            canvas.drawArc(this.d, -90.0f, (this.c * (-360)) / this.b, false, this.a);
        }
    }

    public synchronized void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                if (i >= 0) {
                    this.b = i;
                } else {
                    throw new IllegalArgumentException("max not less than 0");
                }
            }
        }
    }

    public synchronized void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            synchronized (this) {
                if (i >= 0) {
                    if (i > this.b) {
                        i = this.b;
                    }
                    if (i <= this.b) {
                        this.c = i;
                        postInvalidate();
                    }
                } else {
                    throw new IllegalArgumentException("progress not less than 0");
                }
            }
        }
    }
}
