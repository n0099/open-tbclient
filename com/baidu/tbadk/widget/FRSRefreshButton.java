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

    /* renamed from: e  reason: collision with root package name */
    public int f13225e;

    /* renamed from: f  reason: collision with root package name */
    public int f13226f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f13227g;

    /* renamed from: h  reason: collision with root package name */
    public int f13228h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffXfermode f13229i;
    public PorterDuffXfermode j;
    public Drawable k;
    public int l;
    public boolean m;
    public AlphaAnimation n;
    public AlphaAnimation o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FRSRefreshButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.f13227g.setXfermode(this.f13229i);
            canvas.drawPaint(this.f13227g);
            this.f13227g.setXfermode(this.j);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m) {
            AlphaAnimation alphaAnimation = this.n;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.n = alphaAnimation2;
            alphaAnimation2.setDuration(300L);
            this.n.setFillAfter(true);
            startAnimation(this.n);
            setClickable(false);
            this.m = false;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Paint paint = new Paint();
            this.f13227g = paint;
            paint.setAntiAlias(true);
            this.f13227g.setStyle(Paint.Style.FILL);
            this.f13227g.setAntiAlias(true);
            this.k = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_refresh24_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
            setLayerType(1, null);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.l == i2) {
            return;
        }
        this.l = i2;
        this.k = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_refresh24_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
        invalidate();
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) || this.k == null) {
            return;
        }
        canvas.save();
        canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
        int width = (getWidth() / 2) - (this.k.getIntrinsicWidth() / 2);
        int height = (getHeight() / 2) - (this.k.getIntrinsicHeight() / 2);
        int height2 = (getHeight() / 2) + (this.k.getIntrinsicHeight() / 2);
        this.k.setBounds(width + 3, height + 3, ((getWidth() / 2) + (this.k.getIntrinsicWidth() / 2)) - 3, height2 - 3);
        this.k.draw(canvas);
        canvas.restore();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.m) {
            return;
        }
        setVisibility(0);
        AlphaAnimation alphaAnimation = this.o;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.o = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.o.setFillAfter(true);
        startAnimation(this.o);
        setClickable(true);
        this.m = true;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) || this.f13225e <= 0 || this.f13226f <= 0) {
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        a(canvas);
        canvas.rotate(45.0f, this.f13225e / 2, this.f13226f / 2);
        this.f13227g.setShadowLayer(16.0f, 5.0f, 5.0f, SkinManager.getColor(R.color.CAM_X0804));
        this.f13227g.setColor(SkinManager.getColor(this.f13228h));
        int i2 = this.f13225e;
        canvas.drawCircle(i2 / 2, this.f13226f / 2, (i2 / 2) - 20, this.f13227g);
        e(canvas);
        if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f13225e = getMeasuredWidth();
            this.f13226f = getMeasuredHeight();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FRSRefreshButton(Context context, AttributeSet attributeSet, int i2) {
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
        this.f13228h = R.color.CAM_X0211;
        this.f13229i = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.j = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.l = 3;
        this.m = false;
        this.n = null;
        this.o = null;
        c();
    }
}
