package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FRSRefreshButton extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Paint c;
    public int d;
    public PorterDuffXfermode e;
    public PorterDuffXfermode f;
    public Drawable g;
    public int h;
    public boolean i;
    public AlphaAnimation j;
    public AlphaAnimation k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FRSRefreshButton(Context context) {
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

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.c.setXfermode(this.e);
            canvas.drawPaint(this.c);
            this.c.setXfermode(this.f);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.i) {
            AlphaAnimation alphaAnimation = this.j;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.j = alphaAnimation2;
            alphaAnimation2.setDuration(300L);
            this.j.setFillAfter(true);
            startAnimation(this.j);
            setClickable(false);
            this.i = false;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Paint paint = new Paint();
            this.c = paint;
            paint.setAntiAlias(true);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
            this.g = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f0809d9, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
            setLayerType(1, null);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.h == i) {
            return;
        }
        this.h = i;
        this.g = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f0809d9, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
        invalidate();
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) || this.g == null) {
            return;
        }
        canvas.save();
        canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
        int width = (getWidth() / 2) - (this.g.getIntrinsicWidth() / 2);
        int height = (getHeight() / 2) - (this.g.getIntrinsicHeight() / 2);
        int height2 = (getHeight() / 2) + (this.g.getIntrinsicHeight() / 2);
        this.g.setBounds(width + 3, height + 3, ((getWidth() / 2) + (this.g.getIntrinsicWidth() / 2)) - 3, height2 - 3);
        this.g.draw(canvas);
        canvas.restore();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.i) {
            return;
        }
        setVisibility(0);
        AlphaAnimation alphaAnimation = this.k;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.k = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.k.setFillAfter(true);
        startAnimation(this.k);
        setClickable(true);
        this.i = true;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) || this.a <= 0 || this.b <= 0) {
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        a(canvas);
        canvas.rotate(45.0f, this.a / 2, this.b / 2);
        this.c.setShadowLayer(16.0f, 5.0f, 5.0f, SkinManager.getColor(R.color.CAM_X0804));
        this.c.setColor(SkinManager.getColor(this.d));
        int i = this.a;
        canvas.drawCircle(i / 2, this.b / 2, (i / 2) - 20, this.c);
        e(canvas);
        if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.a = getMeasuredWidth();
            this.b = getMeasuredHeight();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FRSRefreshButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
    public FRSRefreshButton(Context context, AttributeSet attributeSet, int i) {
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
        this.d = R.color.CAM_X0211;
        this.e = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.h = 3;
        this.i = false;
        this.j = null;
        this.k = null;
        c();
    }
}
