package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.uu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ForeDrawableImageView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable a;
    public String b;
    public int c;
    public Paint d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForeDrawableImageView(Context context) {
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
        this.d = new Paint();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
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
        this.d = new Paint();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
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
        this.d = new Paint();
    }

    public final void c(Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048576, this, canvas, i, i2) == null) && !StringUtils.isNull(this.b) && !uu4.c().g()) {
            canvas.drawText(this.b, (int) (i - (this.d.measureText(this.b) / 2.0f)), i2 + this.c, this.d);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.a;
            if (drawable != null && drawable.isStateful() && this.a.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.a != null) {
                canvas.save();
                ViewParent parent = getParent();
                int i = 0;
                if (parent instanceof View) {
                    i = ((View) parent).getMeasuredWidth();
                }
                int width = getWidth();
                if (width <= i) {
                    i = width;
                }
                int intrinsicWidth = this.a.getIntrinsicWidth();
                int intrinsicHeight = this.a.getIntrinsicHeight();
                int i2 = intrinsicWidth / 2;
                int i3 = (i / 2) - i2;
                int height = (getHeight() / 2) - (intrinsicHeight / 2);
                canvas.translate(i3, height);
                this.a.draw(canvas);
                canvas.restore();
                c(canvas, i3 + i2, height + intrinsicHeight);
            }
        }
    }

    public void setForegroundDrawable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            setForegroundDrawable(SkinManager.getDrawable(i));
        }
    }

    public void setNoImageBottomText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.b = str;
        }
    }

    public void setNoImageBottomTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d.setColor(SkinManager.getColor(i));
        }
    }

    public void setNoImageBottomTextPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c = i;
        }
    }

    public void setNoImageBottomTextSize(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) && f > 0.0f) {
            this.d.setTextSize(f);
        }
    }

    public void setForegroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            this.a = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicHeight(), this.a.getMinimumWidth());
            }
            invalidate();
        }
    }
}
