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
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bl;
import com.repackage.qi;
import com.repackage.vk;
import com.repackage.yk;
import com.repackage.zm;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class ChatClipImageItemView extends GifView implements yk.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean h1;
    public yk i1;
    public final Path j1;
    public boolean k1;
    public a l1;

    /* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void Q(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, attributeSet, i) == null) {
            String trim = Build.MODEL.trim();
            if (trim != null) {
                String[] strArr = {"M040", "M045"};
                for (int i2 = 0; i2 < 2; i2++) {
                    if (strArr[i2].equalsIgnoreCase(trim)) {
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
                this.i1 = new bl();
            } else {
                this.i1 = new vk();
            }
            this.d.n = true;
            this.i1.v(this);
            yk ykVar = this.i1;
            this.e = ykVar;
            ykVar.r(this.d);
        }
    }

    @Override // com.repackage.yk.a
    public Path a(RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rectF)) == null) {
            if (rectF == null) {
                return null;
            }
            float width = rectF.width();
            float height = rectF.height();
            this.j1.reset();
            this.j1.set(l0(width, height, 1.0f));
            return this.j1;
        }
        return (Path) invokeL.objValue;
    }

    @Override // com.repackage.yk.a
    public void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
        }
    }

    @Override // com.baidu.tbadk.gif.GifView, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public zm getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            zm bdImage = super.getBdImage();
            boolean z = true;
            boolean z2 = (getDrawable() == null || !(getDrawable() instanceof BitmapDrawable) || ((BitmapDrawable) getDrawable()).getBitmap() == null) ? false : true;
            boolean z3 = bdImage != null && bdImage.w();
            yk ykVar = this.i1;
            if (!z3 && !z2) {
                z = false;
            }
            ykVar.w(z);
            return bdImage;
        }
        return (zm) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public zm getDefaultBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.i1.w(false);
            return super.getDefaultBdImage();
        }
        return (zm) invokeV.objValue;
    }

    public final Path l0(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int d = qi.d(getContext(), 4.0f);
            int d2 = qi.d(getContext(), 12.0f);
            int d3 = qi.d(getContext(), 6.0f);
            int d4 = qi.d(getContext(), 10.0f);
            float f4 = d3;
            float f5 = 2.0f * f3;
            float f6 = (f - f4) - f5;
            float f7 = f2 - f5;
            Path path = new Path();
            path.offset(0.0f, 0.0f);
            if (this.h1) {
                float f8 = f4 + f3;
                float f9 = d;
                float f10 = f3 + f9;
                path.moveTo(f8, f10);
                float f11 = f8 + f9;
                path.quadTo(f8, f3, f11, f3);
                float f12 = f6 + f8;
                float f13 = f12 - f9;
                path.lineTo(f13, f3);
                path.quadTo(f12, f3, f12, f10);
                float f14 = f7 + f3;
                float f15 = f14 - f9;
                path.lineTo(f12, f15);
                path.quadTo(f12, f14, f13, f14);
                path.lineTo(f11, f14);
                path.quadTo(f8, f14, f8, f15);
                float f16 = d4;
                path.lineTo(f8, d2 + f3 + f16);
                float f17 = 1 + f3;
                int i = d4 + (d2 / 2);
                path.lineTo(f17, i + 1);
                path.lineTo(f17, i - 1);
                path.lineTo(f8, f3 + f16);
                path.lineTo(f8, f10);
            } else {
                float f18 = d;
                float f19 = f3 + f18;
                path.moveTo(f3, f19);
                path.quadTo(f3, f3, f19, f3);
                float f20 = f6 + f3;
                float f21 = f20 - f18;
                path.lineTo(f21, f3);
                path.quadTo(f20, f3, f20, f19);
                float f22 = d4 + f3;
                path.lineTo(f20, f22);
                float f23 = 1;
                float f24 = (f4 + f20) - f23;
                float f25 = (d2 / 2) + f22;
                path.lineTo(f24, f25 - f23);
                path.lineTo(f24, f25 + f23);
                path.lineTo(f20, f22 + d2);
                float f26 = f7 + f3;
                float f27 = f26 - f18;
                path.lineTo(f20, f27);
                path.quadTo(f20, f26, f21, f26);
                path.lineTo(f19, f26);
                path.quadTo(f3, f26, f3, f27);
                path.lineTo(f3, f18);
            }
            path.close();
            return path;
        }
        return (Path) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.gif.GifView, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            a aVar = this.l1;
            if (aVar == null) {
                SkinManager.setBackgroundColor(this, R.color.CAM_X0204);
            } else {
                aVar.a(canvas);
            }
            super.onDraw(canvas);
        }
    }

    @Override // com.baidu.tbadk.gif.GifView, com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStartTemporaryDetach();
            this.i1.u();
        }
    }

    @Override // com.baidu.tbadk.gif.GifView, com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (i != 0) {
                this.i1.u();
            } else if (!this.k1) {
                this.i1.t();
                invalidate();
            } else {
                this.k1 = false;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbClipImageView, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    public void setLeft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.h1 = z;
        }
    }

    public void setOnDrawCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.l1 = aVar;
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
    public ChatClipImageItemView(Context context, AttributeSet attributeSet, int i) {
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
        this.h1 = true;
        this.j1 = new Path();
        this.k1 = true;
        this.l1 = null;
        Q(context, attributeSet, i);
        setShowStaticDrawable(false);
    }
}
