package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import b.a.r0.y.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VoteStatusView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int activeEndColor;
    public int activeStartColor;

    /* renamed from: e  reason: collision with root package name */
    public int f47386e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47387f;
    public int frozenColor;

    /* renamed from: g  reason: collision with root package name */
    public Paint f47388g;

    /* renamed from: h  reason: collision with root package name */
    public Shader f47389h;

    /* renamed from: i  reason: collision with root package name */
    public Path f47390i;
    public Path j;
    public Path k;
    public Path l;
    public Path m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoteStatusView(Context context) {
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
            this.frozenColor = SkinManager.getColor(R.color.CAM_X0204);
            this.activeStartColor = SkinManager.getColor(R.color.CAM_X0303);
            this.activeEndColor = SkinManager.getColor(R.color.CAM_X0302);
            Paint paint = new Paint();
            this.f47388g = paint;
            paint.setAntiAlias(true);
            this.f47388g.setStyle(Paint.Style.FILL);
            this.f47388g.setColor(this.frozenColor);
            this.f47390i = new Path();
            this.j = new Path();
            this.k = new Path();
            this.l = new Path();
            this.m = new Path();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int height = (canvas.getHeight() - getPaddingBottom()) - getPaddingTop();
            int width = (canvas.getWidth() - getPaddingLeft()) - getPaddingRight();
            if (height * 6 >= width) {
                height = width / 6;
            }
            int i2 = height / 2;
            float f2 = i2;
            this.f47390i.addCircle(f2, f2, f2, Path.Direction.CW);
            float f3 = width / 2;
            this.j.addCircle(f3, f2, f2, Path.Direction.CW);
            float f4 = width - i2;
            this.k.addCircle(f4, f2, f2, Path.Direction.CW);
            float f5 = (height * 9) / 26;
            float f6 = (height * 17) / 26;
            this.l.addRect(f2, f5, f3, f6, Path.Direction.CW);
            this.m.addRect(f3, f5, f4, f6, Path.Direction.CW);
            this.f47388g.setColor(this.frozenColor);
            this.f47388g.setShader(null);
            if (this.f47389h == null || this.f47387f) {
                this.f47389h = new LinearGradient(f2, 0.0f, f4, 0.0f, this.activeStartColor, this.activeEndColor, Shader.TileMode.CLAMP);
                this.f47387f = false;
            }
            if (this.f47386e == c.f27226c) {
                this.f47388g.setShader(this.f47389h);
            }
            canvas.drawPath(this.m, this.f47388g);
            canvas.drawPath(this.k, this.f47388g);
            if (this.f47386e == c.f27225b) {
                this.f47388g.setShader(this.f47389h);
            }
            canvas.drawPath(this.l, this.f47388g);
            canvas.drawPath(this.j, this.f47388g);
            if (this.f47386e == c.f27224a) {
                this.f47388g.setShader(this.f47389h);
            }
            canvas.drawPath(this.f47390i, this.f47388g);
        }
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.activeStartColor = SkinManager.getColor(i2, R.color.CAM_X0303);
            this.activeEndColor = SkinManager.getColor(i2, R.color.CAM_X0302);
            this.frozenColor = SkinManager.getColor(i2, R.color.CAM_X0204);
            this.f47387f = true;
            invalidate();
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f47386e = i2;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47386e = -1;
        this.f47387f = true;
        a();
    }
}
