package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import c.a.p0.e0.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VoteStatusView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31614b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f31615c;

    /* renamed from: d  reason: collision with root package name */
    public Shader f31616d;

    /* renamed from: e  reason: collision with root package name */
    public int f31617e;

    /* renamed from: f  reason: collision with root package name */
    public int f31618f;

    /* renamed from: g  reason: collision with root package name */
    public int f31619g;

    /* renamed from: h  reason: collision with root package name */
    public Path f31620h;
    public Path i;
    public Path j;
    public Path k;
    public Path l;

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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31619g = SkinManager.getColor(R.color.CAM_X0204);
            this.f31617e = SkinManager.getColor(R.color.CAM_X0303);
            this.f31618f = SkinManager.getColor(R.color.CAM_X0302);
            Paint paint = new Paint();
            this.f31615c = paint;
            paint.setAntiAlias(true);
            this.f31615c.setStyle(Paint.Style.FILL);
            this.f31615c.setColor(this.f31619g);
            this.f31620h = new Path();
            this.i = new Path();
            this.j = new Path();
            this.k = new Path();
            this.l = new Path();
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f31617e = SkinManager.getColor(i, (int) R.color.CAM_X0303);
            this.f31618f = SkinManager.getColor(i, (int) R.color.CAM_X0302);
            this.f31619g = SkinManager.getColor(i, (int) R.color.CAM_X0204);
            this.f31614b = true;
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
            int i = height / 2;
            float f2 = i;
            this.f31620h.addCircle(f2, f2, f2, Path.Direction.CW);
            float f3 = width / 2;
            this.i.addCircle(f3, f2, f2, Path.Direction.CW);
            float f4 = width - i;
            this.j.addCircle(f4, f2, f2, Path.Direction.CW);
            float f5 = (height * 9) / 26;
            float f6 = (height * 17) / 26;
            this.k.addRect(f2, f5, f3, f6, Path.Direction.CW);
            this.l.addRect(f3, f5, f4, f6, Path.Direction.CW);
            this.f31615c.setColor(this.f31619g);
            this.f31615c.setShader(null);
            if (this.f31616d == null || this.f31614b) {
                this.f31616d = new LinearGradient(f2, 0.0f, f4, 0.0f, this.f31617e, this.f31618f, Shader.TileMode.CLAMP);
                this.f31614b = false;
            }
            if (this.a == c.f13761c) {
                this.f31615c.setShader(this.f31616d);
            }
            canvas.drawPath(this.l, this.f31615c);
            canvas.drawPath(this.j, this.f31615c);
            if (this.a == c.f13760b) {
                this.f31615c.setShader(this.f31616d);
            }
            canvas.drawPath(this.k, this.f31615c);
            canvas.drawPath(this.i, this.f31615c);
            if (this.a == c.a) {
                this.f31615c.setShader(this.f31616d);
            }
            canvas.drawPath(this.f31620h, this.f31615c);
        }
    }

    public void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a = i;
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
        this.f31614b = true;
        a();
    }
}
