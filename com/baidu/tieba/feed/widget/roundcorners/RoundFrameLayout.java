package com.baidu.tieba.feed.widget.roundcorners;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.md7;
import com.baidu.tieba.nd7;
import com.baidu.tieba.od7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RoundFrameLayout extends FrameLayout implements od7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final md7 a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundFrameLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
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
        nd7 nd7Var = new nd7();
        this.a = nd7Var;
        nd7Var.j(context, attributeSet, this);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.a.i(canvas);
            super.draw(canvas);
            this.a.g(canvas);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            this.a.setRadius(f);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadiusBottom(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.a.setRadiusBottom(f);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadiusBottomLeft(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.a.setRadiusBottomLeft(f);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadiusBottomRight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.a.setRadiusBottomRight(f);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadiusLeft(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.a.setRadiusLeft(f);
        }
    }

    public void setRadiusPx(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a.setRadiusPx(i);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadiusRight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            this.a.setRadiusRight(f);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadiusTop(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f) == null) {
            this.a.setRadiusTop(f);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadiusTopLeft(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f) == null) {
            this.a.setRadiusTopLeft(f);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadiusTopRight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
            this.a.setRadiusTopRight(f);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setStrokeColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.a.setStrokeColor(i);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setStrokeWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
            this.a.setStrokeWidth(f);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.a.d(i, i2);
        }
    }

    public void setRadiusPx(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) {
            this.a.setRadiusPx(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setRadius(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.a.setRadius(f, f2, f3, f4);
        }
    }

    @Override // com.baidu.tieba.od7
    public void setStrokeWidthColor(float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
            this.a.setStrokeWidthColor(f, i);
        }
    }
}
