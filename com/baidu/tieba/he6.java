package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class he6 extends ImageSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Drawable> a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public he6(@NonNull Drawable drawable, int i) {
        super(drawable, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Drawable) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public he6(@NonNull Drawable drawable, int i, int i2) {
        super(drawable, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Drawable) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = i2;
    }

    public final Drawable a() {
        InterceptResult invokeV;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Drawable> weakReference = this.a;
            if (weakReference != null) {
                drawable = weakReference.get();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                Drawable drawable2 = getDrawable();
                this.a = new WeakReference<>(drawable2);
                return drawable2;
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            Drawable a = a();
            canvas.save();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i6 = fontMetricsInt.descent;
            canvas.translate(f, ((i4 + i6) - ((i6 - fontMetricsInt.ascent) / 2)) - ((a.getBounds().bottom - a.getBounds().top) / 2));
            a.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i3 = fontMetricsInt2.descent;
                int i4 = fontMetricsInt2.ascent;
                int i5 = i4 + ((i3 - i4) / 2);
                int i6 = (bounds.bottom - bounds.top) / 2;
                int i7 = i5 - i6;
                fontMetricsInt.ascent = i7;
                fontMetricsInt.top = i7;
                int i8 = i5 + i6;
                fontMetricsInt.bottom = i8;
                fontMetricsInt.descent = i8;
            }
            return bounds.right + this.b;
        }
        return invokeCommon.intValue;
    }
}
