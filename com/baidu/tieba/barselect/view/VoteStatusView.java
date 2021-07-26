package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.x.e.c;
/* loaded from: classes4.dex */
public class VoteStatusView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14523e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14524f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f14525g;

    /* renamed from: h  reason: collision with root package name */
    public Shader f14526h;

    /* renamed from: i  reason: collision with root package name */
    public int f14527i;
    public int j;
    public int k;
    public Path l;
    public Path m;
    public Path n;
    public Path o;
    public Path p;

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
            this.k = SkinManager.getColor(R.color.CAM_X0204);
            this.f14527i = SkinManager.getColor(R.color.CAM_X0303);
            this.j = SkinManager.getColor(R.color.CAM_X0302);
            Paint paint = new Paint();
            this.f14525g = paint;
            paint.setAntiAlias(true);
            this.f14525g.setStyle(Paint.Style.FILL);
            this.f14525g.setColor(this.k);
            this.l = new Path();
            this.m = new Path();
            this.n = new Path();
            this.o = new Path();
            this.p = new Path();
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f14527i = SkinManager.getColor(i2, R.color.CAM_X0303);
            this.j = SkinManager.getColor(i2, R.color.CAM_X0302);
            this.k = SkinManager.getColor(i2, R.color.CAM_X0204);
            this.f14524f = true;
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            int height = (canvas.getHeight() - getPaddingBottom()) - getPaddingTop();
            int width = (canvas.getWidth() - getPaddingLeft()) - getPaddingRight();
            if (height * 6 >= width) {
                height = width / 6;
            }
            int i2 = height / 2;
            float f2 = i2;
            this.l.addCircle(f2, f2, f2, Path.Direction.CW);
            float f3 = width / 2;
            this.m.addCircle(f3, f2, f2, Path.Direction.CW);
            float f4 = width - i2;
            this.n.addCircle(f4, f2, f2, Path.Direction.CW);
            float f5 = (height * 9) / 26;
            float f6 = (height * 17) / 26;
            this.o.addRect(f2, f5, f3, f6, Path.Direction.CW);
            this.p.addRect(f3, f5, f4, f6, Path.Direction.CW);
            this.f14525g.setColor(this.k);
            this.f14525g.setShader(null);
            if (this.f14526h == null || this.f14524f) {
                this.f14526h = new LinearGradient(f2, 0.0f, f4, 0.0f, this.f14527i, this.j, Shader.TileMode.CLAMP);
                this.f14524f = false;
            }
            if (this.f14523e == c.f66852c) {
                this.f14525g.setShader(this.f14526h);
            }
            canvas.drawPath(this.p, this.f14525g);
            canvas.drawPath(this.n, this.f14525g);
            if (this.f14523e == c.f66851b) {
                this.f14525g.setShader(this.f14526h);
            }
            canvas.drawPath(this.o, this.f14525g);
            canvas.drawPath(this.m, this.f14525g);
            if (this.f14523e == c.f66850a) {
                this.f14525g.setShader(this.f14526h);
            }
            canvas.drawPath(this.l, this.f14525g);
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f14523e = i2;
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
        this.f14523e = -1;
        this.f14524f = true;
        a();
    }
}
