package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Serializable;
import java.util.HashMap;
@ModifyClass
/* loaded from: classes6.dex */
public class hi5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947824693, "Lcom/baidu/tieba/hi5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947824693, "Lcom/baidu/tieba/hi5;");
                return;
            }
        }
        a = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-main-service/creativeToolsList";
    }

    public static FrameLayout a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = xi.g(context, R.dimen.M_W_X006);
            frameLayout.setLayoutParams(layoutParams);
            s75 d = s75.d(frameLayout);
            d.m(R.dimen.L_X02);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0209);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(xi.g(context, R.dimen.tbds138), xi.g(context, R.dimen.tbds31));
            layoutParams2.setMargins(xi.g(context, R.dimen.M_W_X004), xi.g(context, R.dimen.M_H_X002), xi.g(context, R.dimen.M_W_X004), xi.g(context, R.dimen.M_H_X002));
            imageView.setLayoutParams(layoutParams2);
            SkinManager.setImageResource(imageView, R.drawable.icon_ai_write_rukou);
            frameLayout.addView(imageView);
            b(context, frameLayout);
            return frameLayout;
        }
        return (FrameLayout) invokeL.objValue;
    }

    public static void b(Context context, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, frameLayout) == null) && rp5.a("key_ai_write_button_first_show_red_dot", true)) {
            if (rp5.e("key_ai_write_button_first_show_red_dot_time", 0L) == 0) {
                rp5.m("key_ai_write_button_first_show_red_dot_time", System.currentTimeMillis());
            }
            if (System.currentTimeMillis() - rp5.e("key_ai_write_button_first_show_red_dot_time", System.currentTimeMillis()) < 1209600000) {
                ImageView imageView = new ImageView(context);
                imageView.setId(R.id.ai_write_button_red_dot);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(xi.g(context, R.dimen.tbds18), xi.g(context, R.dimen.tbds18));
                layoutParams.setMargins((xi.g(context, R.dimen.tbds138) + (xi.g(context, R.dimen.M_W_X004) * 2)) - xi.g(context, R.dimen.tbds18), 0, 0, 0);
                SkinManager.setImageResource(imageView, R.drawable.icon_news_red_dot);
                frameLayout.addView(imageView, layoutParams);
            }
        }
    }

    @Modify(description = "设置AI发帖入口url")
    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            return a + "?customfullscreen=1&nonavigationbar=1&type=" + str + "&fid=" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void e(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            HashMap<String, Serializable> hashMap = new HashMap<>();
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("pbReply", str);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            pz4 j = pz4.j(TbadkCoreApplication.getInst().getCurrentActivity(), c("reply", str2));
            j.f(hashMap);
            j.o();
        }
    }

    public static void d(@NonNull View view2) {
        View findViewById;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2) == null) && (findViewById = view2.findViewById(R.id.ai_write_button_red_dot)) != null) {
            findViewById.setVisibility(8);
            rp5.k("key_ai_write_button_first_show_red_dot", false);
        }
    }
}
