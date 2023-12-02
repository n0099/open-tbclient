package com.baidu.tieba;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes5.dex */
public class cja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) ? (int) ((i * 9.0d) / 16.0d) : invokeI.intValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? (int) ((i * 16.0d) / 9.0d) : invokeI.intValue;
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? (int) ((i * 9.0d) / 16.0d) : invokeI.intValue;
    }

    public static wg0 d(@NonNull AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adCard)) == null) {
            if (ng0.b().d(adCard.getDownloadKey()) != null) {
                return ng0.b().d(adCard.getDownloadKey());
            }
            wg0 wg0Var = new wg0();
            wg0Var.h(adCard.getDownloadKey());
            if (adCard.downloadInfo != null) {
                if (TextUtils.isEmpty(wg0Var.e())) {
                    wg0Var.h(adCard.downloadInfo.b);
                }
                uia uiaVar = adCard.downloadInfo;
                wg0Var.g = uiaVar.b;
                wg0Var.d = uiaVar.a;
            }
            if (TextUtils.isEmpty(wg0Var.e())) {
                wg0Var.h(adCard.adId);
            }
            ah0 ah0Var = new ah0();
            ah0Var.d = adCard.getButtonText();
            ah0Var.j = adCard.adId;
            ah0Var.a = adCard.getExtInfo();
            hw4 hw4Var = adCard.appInfoModel;
            if (hw4Var != null) {
                ah0Var.g = hw4Var.b;
                ah0Var.h = hw4Var.c;
            }
            if (ef0.n(adCard.cmdScheme)) {
                ah0Var.c = adCard.cmdScheme;
            }
            wg0Var.p = ah0Var;
            xg0 xg0Var = new xg0();
            xg0Var.a = adCard.getAdvertAppInfo().j;
            xg0Var.t = e06.a().b();
            xg0Var.s = e06.a().h();
            wg0Var.q = xg0Var;
            return wg0Var;
        }
        return (wg0) invokeL.objValue;
    }

    public static String e(String str, String str2, float f, TextPaint textPaint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Float.valueOf(f), textPaint})) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f - textPaint.measureText(GlideException.IndentedAppendable.INDENT + str2), TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize.toString() + GlideException.IndentedAppendable.INDENT + str2;
            }
            return str2;
        }
        return (String) invokeCommon.objValue;
    }

    public static Drawable f(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65541, null, i, i2, i3, i4)) == null) {
            return x25.G(x25.n(y25.y(), i), i2, i3, i4);
        }
        return (Drawable) invokeIIII.objValue;
    }

    public static int g(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i == i2) {
                return i;
            }
            if (f <= 0.0f) {
                return i;
            }
            if (f >= 1.0f) {
                return i2;
            }
            int red = Color.red(i);
            int green = Color.green(i);
            int blue = Color.blue(i);
            int alpha = Color.alpha(i);
            return Color.argb((int) (alpha + (f * (Color.alpha(i2) - alpha))), (int) (red + ((Color.red(i2) - red) * f)), (int) (green + ((Color.green(i2) - green) * f)), (int) (blue + ((Color.blue(i2) - blue) * f)));
        }
        return invokeCommon.intValue;
    }

    public static int h(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) {
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
        return invokeLI.intValue;
    }
}
