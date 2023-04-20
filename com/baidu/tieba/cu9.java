package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater;
import com.baidu.ugc.editvideo.subtitle.ninepatchchunk.NinePatchChunk;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class cu9 {
    public static /* synthetic */ Interceptable $ic;
    public static cu9 k;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Context c;
    public TextWordsEntity.TextStyleEntity d;
    public TextWordsEntity.TextFontEntity e;
    public final TextPaint f;
    public final TextPaint g;
    public final TextPaint h;
    public int i;
    public List<String> j;

    public cu9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 5;
        this.j = new ArrayList();
        this.f = new TextPaint(1);
        this.g = new TextPaint(1);
        this.h = new TextPaint(1);
        this.a = cia.j(R.dimen.tbds72);
    }

    public static cu9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (k == null) {
                synchronized (cu9.class) {
                    if (k == null) {
                        k = new cu9();
                    }
                }
            }
            return k;
        }
        return (cu9) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.setTypeface(Typeface.DEFAULT);
            this.g.setTypeface(Typeface.DEFAULT);
            this.h.setTypeface(Typeface.DEFAULT);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.setShader(null);
            this.f.setColor(-1);
            this.f.clearShadowLayer();
            this.g.clearShadowLayer();
            this.h.clearShadowLayer();
            this.j.clear();
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (int) (eia.e() * 0.85d);
        }
        return invokeV.intValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (Context) invokeV.objValue;
    }

    public final void a(String str, Canvas canvas, int i, int i2, int i3, TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, canvas, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), textPaint}) == null) {
            j(textPaint);
            canvas.drawText(str, i, i2, textPaint);
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str.contains("\n")) {
                String[] split = str.split("\n");
                if (split.length > 1) {
                    int i = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < split.length; i3++) {
                        int length = split[i3].length();
                        if (length > i2) {
                            i = i3;
                            i2 = length;
                        }
                    }
                    return split[i];
                }
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void j(TextPaint textPaint) {
        TextWordsEntity.TextFontEntity textFontEntity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, textPaint) != null) || (textFontEntity = this.e) == null) {
            return;
        }
        try {
            if (textFontEntity.isDefault()) {
                b();
                return;
            }
            this.e.setFontRootDir(new File(FileHelper.getVideoTmpDir()));
            textPaint.setTypeface(Typeface.createFromFile(this.e.getSourceFile()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int[] g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new int[]{0, 0};
            }
            String e = e(str);
            int[] iArr = new int[2];
            TextPaint textPaint = new TextPaint(1);
            j(textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextSize(this.a);
            float measureText = textPaint.measureText(e) + 2.0f + 40.0f;
            if (measureText > f()) {
                measureText = f() + 2.0f;
            }
            float f = 0.0f;
            if (measureText > 0.0f) {
                StaticLayout measuredStaticLayout = NewSubTitleCreater.getMeasuredStaticLayout(str, textPaint, (int) measureText, this.b, Layout.Alignment.ALIGN_CENTER, 0);
                this.i = measuredStaticLayout.getLineCount();
                int i = 0;
                for (int i2 = 0; i2 < this.i; i2++) {
                    int lineEnd = measuredStaticLayout.getLineEnd(i2);
                    if (lineEnd != 0) {
                        this.j.add(str.substring(i, lineEnd));
                        i = lineEnd;
                    }
                }
                f = measuredStaticLayout.getHeight() + 2.0f + 40.0f;
            }
            iArr[0] = (int) measureText;
            iArr[1] = (int) f;
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public Bitmap h(Context context, String str, TextWordsEntity.TextStyleEntity textStyleEntity, TextWordsEntity.TextFontEntity textFontEntity) {
        InterceptResult invokeLLLL;
        int i;
        int i2;
        int i3;
        Canvas canvas;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, str, textStyleEntity, textFontEntity)) == null) {
            c();
            this.c = context;
            this.d = textStyleEntity;
            this.e = textFontEntity;
            this.f.setTextSize(this.a);
            int[] g = g(str);
            if (g[0] >= 1 && g[1] >= 1) {
                Bitmap a = oha.a(this.d);
                NinePatchChunk f = oha.f(a, this.d);
                if (f != null) {
                    Rect rect = f.padding;
                    i = rect.left;
                    int i4 = rect.top;
                    g[0] = g[0] + i;
                    g[1] = g[1] + i4;
                    g[0] = g[0] + rect.right;
                    g[1] = g[1] + rect.bottom;
                    if (a != null && g[0] < a.getWidth()) {
                        g[0] = a.getWidth();
                    }
                    i2 = i4;
                } else {
                    i = 0;
                    i2 = 0;
                }
                Bitmap createBitmap = Bitmap.createBitmap(g[0], g[1], Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                canvas2.save();
                int i5 = 20;
                oha.b(a, f, canvas2, 20);
                int g2 = oha.g(this.f);
                int i6 = i + 20;
                int abs = (g2 / 2) + ((int) (Math.abs(this.f.ascent() + this.f.descent()) / 2.0f)) + 20 + i2;
                int i7 = 0;
                while (i7 < this.i) {
                    int i8 = i7 + 1;
                    oha.c(this.f, this.d, null);
                    int[] d = oha.d(this.f, this.g, this.h, this.d, null);
                    oha.e(canvas2, this.f, i6, (g2 * i7) + i5 + i2, (g2 * i8) + i5 + i2, this.d, null);
                    if (d[0] != 0) {
                        i3 = i7;
                        canvas = canvas2;
                        a(this.j.get(i7), canvas2, i6, abs, i3, this.g);
                    } else {
                        i3 = i7;
                        canvas = canvas2;
                    }
                    if (d[1] != 0) {
                        a(this.j.get(i3), canvas, i6, abs, i3, this.h);
                    }
                    a(this.j.get(i3), canvas, i6, abs, i3, this.f);
                    abs += g2;
                    canvas2 = canvas;
                    i7 = i8;
                    i5 = 20;
                }
                canvas2.restore();
                return createBitmap;
            }
            return Bitmap.createBitmap(10, this.a, Bitmap.Config.ARGB_8888);
        }
        return (Bitmap) invokeLLLL.objValue;
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.c = context;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.a = i;
        }
    }
}
