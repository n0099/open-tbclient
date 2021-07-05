package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.f.a.h;
import d.a.c.f.a.k;
import d.a.c.f.a.n;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class ChatClipImageItemView extends TbImageView implements k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A0;
    public a B0;
    public boolean x0;
    public k y0;
    public final Path z0;

    /* loaded from: classes5.dex */
    public interface a {
        void a(Canvas canvas);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChatClipImageItemView(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void S(Context context, AttributeSet attributeSet, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, attributeSet, i2) == null) {
            String trim = Build.MODEL.trim();
            if (trim != null) {
                String[] strArr = {"M040", "M045"};
                for (int i3 = 0; i3 < 2; i3++) {
                    if (strArr[i3].equalsIgnoreCase(trim)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (Build.VERSION.SDK_INT >= 11) {
                CompatibleUtile.getInstance().closeViewGpu(this);
                try {
                    Method method = getClass().getMethod("setLayerType", Integer.TYPE, Paint.class);
                    if (method != null) {
                        method.invoke(this, 1, null);
                    }
                } catch (Exception unused) {
                }
            }
            if (!z) {
                this.y0 = new n();
            } else {
                this.y0 = new h();
            }
            this.f2201h.n = true;
            this.y0.t(this);
            k kVar = this.y0;
            this.f2202i = kVar;
            kVar.p(this.f2201h);
        }
    }

    public final Path T(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            int e2 = l.e(getContext(), 4.0f);
            int e3 = l.e(getContext(), 12.0f);
            int e4 = l.e(getContext(), 6.0f);
            int e5 = l.e(getContext(), 10.0f);
            float f5 = e4;
            float f6 = 2.0f * f4;
            float f7 = (f2 - f5) - f6;
            float f8 = f3 - f6;
            Path path = new Path();
            path.offset(0.0f, 0.0f);
            if (this.x0) {
                float f9 = f5 + f4;
                float f10 = e2;
                float f11 = f4 + f10;
                path.moveTo(f9, f11);
                float f12 = f9 + f10;
                path.quadTo(f9, f4, f12, f4);
                float f13 = f7 + f9;
                float f14 = f13 - f10;
                path.lineTo(f14, f4);
                path.quadTo(f13, f4, f13, f11);
                float f15 = f8 + f4;
                float f16 = f15 - f10;
                path.lineTo(f13, f16);
                path.quadTo(f13, f15, f14, f15);
                path.lineTo(f12, f15);
                path.quadTo(f9, f15, f9, f16);
                float f17 = e5;
                path.lineTo(f9, e3 + f4 + f17);
                float f18 = 1 + f4;
                int i2 = e5 + (e3 / 2);
                path.lineTo(f18, i2 + 1);
                path.lineTo(f18, i2 - 1);
                path.lineTo(f9, f4 + f17);
                path.lineTo(f9, f11);
            } else {
                float f19 = e2;
                float f20 = f4 + f19;
                path.moveTo(f4, f20);
                path.quadTo(f4, f4, f20, f4);
                float f21 = f7 + f4;
                float f22 = f21 - f19;
                path.lineTo(f22, f4);
                path.quadTo(f21, f4, f21, f20);
                float f23 = e5 + f4;
                path.lineTo(f21, f23);
                float f24 = 1;
                float f25 = (f5 + f21) - f24;
                float f26 = (e3 / 2) + f23;
                path.lineTo(f25, f26 - f24);
                path.lineTo(f25, f26 + f24);
                path.lineTo(f21, f23 + e3);
                float f27 = f8 + f4;
                float f28 = f27 - f19;
                path.lineTo(f21, f28);
                path.quadTo(f21, f27, f22, f27);
                path.lineTo(f20, f27);
                path.quadTo(f4, f27, f4, f28);
                path.lineTo(f4, f19);
            }
            path.close();
            return path;
        }
        return (Path) invokeCommon.objValue;
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.y0.r();
            this.y0.u(true);
        }
    }

    @Override // d.a.c.f.a.k.a
    public Path a(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rectF)) == null) {
            if (rectF == null) {
                return null;
            }
            float width = rectF.width();
            float height = rectF.height();
            this.z0.reset();
            this.z0.set(T(width, height, 1.0f));
            return this.z0;
        }
        return (Path) invokeL.objValue;
    }

    @Override // d.a.c.f.a.k.a
    public void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.c.k.d.a getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.c.k.d.a bdImage = super.getBdImage();
            boolean z = true;
            boolean z2 = (getDrawable() == null || !(getDrawable() instanceof BitmapDrawable) || ((BitmapDrawable) getDrawable()).getBitmap() == null) ? false : true;
            boolean z3 = bdImage != null && bdImage.w();
            k kVar = this.y0;
            if (!z3 && !z2) {
                z = false;
            }
            kVar.u(z);
            return bdImage;
        }
        return (d.a.c.k.d.a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.c.k.d.a getDefaultBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.y0.u(false);
            return super.getDefaultBdImage();
        }
        return (d.a.c.k.d.a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            a aVar = this.B0;
            if (aVar == null) {
                SkinManager.setBackgroundColor(this, R.color.CAM_X0204);
            } else {
                aVar.a(canvas);
            }
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStartTemporaryDetach();
            this.y0.s();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 != 0) {
                this.y0.s();
            } else if (!this.A0) {
                this.y0.r();
                invalidate();
            } else {
                this.A0 = false;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    public void setLeft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x0 = z;
        }
    }

    public void setOnDrawCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.B0 = aVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChatClipImageItemView(Context context, AttributeSet attributeSet) {
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
    public ChatClipImageItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.x0 = true;
        this.z0 = new Path();
        this.A0 = true;
        this.B0 = null;
        S(context, attributeSet, i2);
    }
}
