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
import com.baidu.tieba.rg6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VoteStatusView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public Paint c;
    public Shader d;
    public int e;
    public int f;
    public int g;
    public Path h;
    public Path i;
    public Path j;
    public Path k;
    public Path l;
    public Path m;
    public Path n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoteStatusView(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteStatusView(Context context, AttributeSet attributeSet) {
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
        this.a = -1;
        this.b = true;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = SkinManager.getColor(R.color.CAM_X0204);
            this.e = SkinManager.getColor(R.color.CAM_X0303);
            this.f = SkinManager.getColor(R.color.CAM_X0302);
            Paint paint = new Paint();
            this.c = paint;
            paint.setAntiAlias(true);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setColor(this.g);
            this.h = new Path();
            this.i = new Path();
            this.j = new Path();
            this.k = new Path();
            this.l = new Path();
            this.m = new Path();
            this.n = new Path();
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = SkinManager.getColor(i, (int) R.color.CAM_X0303);
            this.f = SkinManager.getColor(i, (int) R.color.CAM_X0302);
            this.g = SkinManager.getColor(i, (int) R.color.CAM_X0204);
            this.b = true;
            invalidate();
        }
    }

    public void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a = i;
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            int measuredHeight = (getMeasuredHeight() - getPaddingBottom()) - getPaddingTop();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            if (measuredHeight * 6 >= measuredWidth) {
                measuredHeight = measuredWidth / 6;
            }
            int i = measuredHeight / 2;
            float f = i;
            this.h.addCircle(f, f, f, Path.Direction.CW);
            int i2 = measuredHeight / 6;
            float f2 = (measuredWidth / 3) + i2;
            this.i.addCircle(f2, f, f, Path.Direction.CW);
            float f3 = ((measuredWidth * 2) / 3) - i2;
            this.j.addCircle(f3, f, f, Path.Direction.CW);
            float f4 = measuredWidth - i;
            this.k.addCircle(f4, f, f, Path.Direction.CW);
            float f5 = (measuredHeight * 9) / 26;
            float f6 = (measuredHeight * 17) / 26;
            this.l.addRect(f, f5, f2, f6, Path.Direction.CW);
            this.m.addRect(f2, f5, f3, f6, Path.Direction.CW);
            this.n.addRect(f3, f5, f4, f6, Path.Direction.CW);
            this.c.setColor(this.g);
            this.c.setShader(null);
            if (this.d == null || this.b) {
                this.d = new LinearGradient(f, 0.0f, f4, 0.0f, this.e, this.f, Shader.TileMode.CLAMP);
                this.b = false;
            }
            if (this.a == rg6.c) {
                this.c.setShader(this.d);
            }
            canvas.drawPath(this.n, this.c);
            canvas.drawPath(this.k, this.c);
            if (this.a == rg6.b) {
                this.c.setShader(this.d);
            }
            canvas.drawPath(this.m, this.c);
            canvas.drawPath(this.j, this.c);
            canvas.drawPath(this.l, this.c);
            canvas.drawPath(this.i, this.c);
            if (this.a == rg6.a) {
                this.c.setShader(this.d);
            }
            canvas.drawPath(this.h, this.c);
        }
    }
}
