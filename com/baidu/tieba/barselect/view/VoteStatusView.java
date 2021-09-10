package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import c.a.r0.x.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VoteStatusView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int activeEndColor;
    public int activeStartColor;

    /* renamed from: e  reason: collision with root package name */
    public int f49934e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49935f;
    public int frozenColor;

    /* renamed from: g  reason: collision with root package name */
    public Paint f49936g;

    /* renamed from: h  reason: collision with root package name */
    public Shader f49937h;

    /* renamed from: i  reason: collision with root package name */
    public Path f49938i;

    /* renamed from: j  reason: collision with root package name */
    public Path f49939j;
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
            this.f49936g = paint;
            paint.setAntiAlias(true);
            this.f49936g.setStyle(Paint.Style.FILL);
            this.f49936g.setColor(this.frozenColor);
            this.f49938i = new Path();
            this.f49939j = new Path();
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
            this.f49938i.addCircle(f2, f2, f2, Path.Direction.CW);
            float f3 = width / 2;
            this.f49939j.addCircle(f3, f2, f2, Path.Direction.CW);
            float f4 = width - i2;
            this.k.addCircle(f4, f2, f2, Path.Direction.CW);
            float f5 = (height * 9) / 26;
            float f6 = (height * 17) / 26;
            this.l.addRect(f2, f5, f3, f6, Path.Direction.CW);
            this.m.addRect(f3, f5, f4, f6, Path.Direction.CW);
            this.f49936g.setColor(this.frozenColor);
            this.f49936g.setShader(null);
            if (this.f49937h == null || this.f49935f) {
                this.f49937h = new LinearGradient(f2, 0.0f, f4, 0.0f, this.activeStartColor, this.activeEndColor, Shader.TileMode.CLAMP);
                this.f49935f = false;
            }
            if (this.f49934e == c.f28300c) {
                this.f49936g.setShader(this.f49937h);
            }
            canvas.drawPath(this.m, this.f49936g);
            canvas.drawPath(this.k, this.f49936g);
            if (this.f49934e == c.f28299b) {
                this.f49936g.setShader(this.f49937h);
            }
            canvas.drawPath(this.l, this.f49936g);
            canvas.drawPath(this.f49939j, this.f49936g);
            if (this.f49934e == c.f28298a) {
                this.f49936g.setShader(this.f49937h);
            }
            canvas.drawPath(this.f49938i, this.f49936g);
        }
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.activeStartColor = SkinManager.getColor(i2, R.color.CAM_X0303);
            this.activeEndColor = SkinManager.getColor(i2, R.color.CAM_X0302);
            this.frozenColor = SkinManager.getColor(i2, R.color.CAM_X0204);
            this.f49935f = true;
            invalidate();
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f49934e = i2;
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
        this.f49934e = -1;
        this.f49935f = true;
        a();
    }
}
