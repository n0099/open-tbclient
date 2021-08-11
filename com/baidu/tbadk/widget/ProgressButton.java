package com.baidu.tbadk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes6.dex */
public class ProgressButton extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILL_COLOR = 1;
    public static final int STORKE_COLOR = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48317e;

    /* renamed from: f  reason: collision with root package name */
    public int f48318f;

    /* renamed from: g  reason: collision with root package name */
    public int f48319g;

    /* renamed from: h  reason: collision with root package name */
    public int f48320h;

    /* renamed from: i  reason: collision with root package name */
    public int f48321i;

    /* renamed from: j  reason: collision with root package name */
    public int f48322j;
    public int k;
    public Paint l;
    public TextPaint m;
    public float n;
    public String o;
    public int p;
    public float q;
    public boolean r;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressButton(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48318f = SkinManager.getColor(this.f48319g);
            this.f48320h = SkinManager.getColor(this.f48321i);
            this.f48322j = SkinManager.getColor(this.k);
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.l.setColor(this.f48318f);
            this.l.setAlpha((int) (this.r ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.l.setStyle(this.f48317e == 0 ? Paint.Style.STROKE : Paint.Style.FILL_AND_STROKE);
            this.l.setStrokeWidth(this.q);
            float f2 = this.q;
            canvas.drawRoundRect(f2 / 2.0f, f2 / 2.0f, getWidth() - (this.q / 2.0f), getHeight() - (this.q / 2.0f), getHeight(), getHeight(), this.l);
            this.m.setColor(this.f48320h);
            this.m.setAlpha(this.r ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.m.setStyle(Paint.Style.FILL);
            this.m.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.m.getFontMetrics();
            int height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            String str = this.o;
            if (str != null) {
                canvas.drawText(str, getWidth() >> 1, height, this.m);
            }
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            int width = (int) (getWidth() * (this.p / 100.0f));
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.l.setColor(this.f48318f);
            this.l.setAlpha((int) ((this.r ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.2f));
            this.l.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.l);
            this.m.setColor(this.f48318f);
            this.m.setAlpha(this.r ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.m.setStyle(Paint.Style.FILL);
            this.m.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.m.getFontMetrics();
            int height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            String str = this.o;
            if (str != null) {
                canvas.drawText(str, getWidth() >> 1, height, this.m);
            }
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.l.setColor(this.f48318f);
            this.l.setAlpha((int) (this.r ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.l.setStyle(Paint.Style.FILL_AND_STROKE);
            float f2 = this.q;
            canvas.drawRoundRect(f2 / 2.0f, f2 / 2.0f, getWidth() - (this.q / 2.0f), getHeight() - (this.q / 2.0f), getHeight(), getHeight(), this.l);
            this.m.setColor(this.f48322j);
            this.m.setAlpha(this.r ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.m.setStyle(Paint.Style.FILL);
            this.m.setTextAlign(Paint.Align.CENTER);
            String str2 = this.o;
            if (str2 != null) {
                canvas.drawText(str2, getWidth() >> 1, height, this.m);
            }
            canvas.restore();
        }
    }

    public int getColorStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48317e : invokeV.intValue;
    }

    @SuppressLint({"CustomViewStyleable"})
    public void initView(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TBProgressButton);
            this.n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TBProgressButton_btnTextSize, R.dimen.T_X08);
            this.o = obtainStyledAttributes.getString(R$styleable.TBProgressButton_btnText);
            int i2 = obtainStyledAttributes.getInt(R$styleable.TBProgressButton_btnColorStyle, 0);
            this.f48317e = i2;
            this.f48319g = R.color.CAM_X0304;
            int i3 = R.color.CAM_X0101;
            this.k = i3;
            if (i2 == 0) {
                i3 = R.color.CAM_X0304;
            }
            this.f48321i = i3;
            this.f48318f = obtainStyledAttributes.getColor(R$styleable.TBProgressButton_btnBackgroundColor, SkinManager.getColor(this.f48319g));
            this.f48320h = obtainStyledAttributes.getColor(R$styleable.TBProgressButton_textColorInit, SkinManager.getColor(this.f48321i));
            this.f48322j = obtainStyledAttributes.getColor(R$styleable.TBProgressButton_textColorProgress, SkinManager.getColor(this.k));
            obtainStyledAttributes.recycle();
            this.q = l.g(getContext(), R.dimen.L_X02);
            Paint paint = new Paint(1);
            this.l = paint;
            paint.setColor(this.f48318f);
            this.l.setStrokeWidth(this.q);
            TextPaint textPaint = new TextPaint();
            this.m = textPaint;
            textPaint.setAntiAlias(true);
            this.m.setTextSize(this.n);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (this.p < 0) {
                b(canvas);
            } else {
                c(canvas);
            }
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            postInvalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.r = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.r = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setCurProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 < 0) {
                this.p = -1;
            } else {
                this.p = Math.min(i2, 100);
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.o = str;
            postInvalidate();
        }
    }

    public void updateProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 < 0) {
                this.p = -1;
            } else {
                this.p = Math.min(i2, 100);
            }
            this.o = String.format(Locale.CHINA, "%d%%", Integer.valueOf(Math.max(this.p, 0)));
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressButton(Context context, AttributeSet attributeSet) {
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
    public ProgressButton(Context context, AttributeSet attributeSet, int i2) {
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
        this.p = -1;
        this.q = 0.0f;
        initView(context, attributeSet);
    }
}
