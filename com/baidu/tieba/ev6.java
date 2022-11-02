package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ev6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static TBAlertBuilder a(TBAlertBuilder tBAlertBuilder, @StringRes int i, @StringRes int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tBAlertBuilder, Integer.valueOf(i), Integer.valueOf(i2), onClickListener, onClickListener2})) == null) {
            if (tBAlertBuilder == null) {
                return null;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(i2, TBAlertConfig.OperateBtnStyle.SECONDARY);
            tBAlertBuilder.r(aVar2, aVar);
            tBAlertBuilder.g();
            aVar.a(onClickListener);
            aVar2.a(onClickListener2);
            return tBAlertBuilder;
        }
        return (TBAlertBuilder) invokeCommon.objValue;
    }

    public static TBAlertBuilder b(Activity activity, @StringRes int i, @StringRes int i2, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), view2})) == null) {
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(activity);
            tBAlertBuilder.t(i);
            tBAlertBuilder.k(i2);
            tBAlertBuilder.m(true);
            tBAlertBuilder.h(false);
            if (view2 != null) {
                tBAlertBuilder.i(view2);
            }
            return tBAlertBuilder;
        }
        return (TBAlertBuilder) invokeCommon.objValue;
    }

    public static View c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            final LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X013);
            linearLayout.setPadding(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds53), dimenPixelSize, 0);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            final ImageView imageView = new ImageView(activity);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f08094e, R.color.CAM_X0108, null);
            int g = xi.g(activity, R.dimen.tbds53);
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(g, g));
            TextView textView = new TextView(activity);
            textView.setText(R.string.obfuscated_res_0x7f0f0337);
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ku6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ev6.d(linearLayout, imageView, view2);
                    }
                }
            });
            return linearLayout;
        }
        return (View) invokeL.objValue;
    }

    public static /* synthetic */ void d(LinearLayout linearLayout, ImageView imageView, View view2) {
        if (wg.a(linearLayout.getTag(), false)) {
            ky4.k().u("key_vpb_booster_disconnect_alert", true);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f08094e, R.color.CAM_X0108, null);
            linearLayout.setTag(Boolean.FALSE);
            return;
        }
        ky4.k().u("key_vpb_booster_disconnect_alert", false);
        WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f08094f, R.color.CAM_X0304, null);
        linearLayout.setTag(Boolean.TRUE);
    }

    public static void e(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0333, R.string.obfuscated_res_0x7f0f0331, null), R.string.obfuscated_res_0x7f0f043f, R.string.obfuscated_res_0x7f0f0376, onClickListener, null).w();
        }
    }

    public static void f(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0333, R.string.obfuscated_res_0x7f0f0332, null), R.string.obfuscated_res_0x7f0f043f, R.string.obfuscated_res_0x7f0f0376, onClickListener, null).w();
        }
    }

    public static void i(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, activity, onClickListener) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f0341, R.string.obfuscated_res_0x7f0f0340, null), R.string.obfuscated_res_0x7f0f033f, R.string.obfuscated_res_0x7f0f0376, onClickListener, null).w();
        }
    }

    public static void g(Activity activity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, activity, onClickListener) != null) || !ky4.k().h("key_vpb_booster_disconnect_alert", true)) {
            return;
        }
        a(b(activity, R.string.obfuscated_res_0x7f0f0338, R.string.obfuscated_res_0x7f0f0336, c(activity)), R.string.obfuscated_res_0x7f0f0335, R.string.obfuscated_res_0x7f0f0334, onClickListener, null).w();
    }

    public static void h(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, activity, onClickListener, onClickListener2) == null) {
            a(b(activity, R.string.obfuscated_res_0x7f0f033c, R.string.obfuscated_res_0x7f0f0339, null), R.string.obfuscated_res_0x7f0f033b, R.string.obfuscated_res_0x7f0f033a, onClickListener, onClickListener2).w();
        }
    }
}
