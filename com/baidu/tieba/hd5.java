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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
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
public class hd5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947819888, "Lcom/baidu/tieba/hd5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947819888, "Lcom/baidu/tieba/hd5;");
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
            layoutParams.rightMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X006);
            frameLayout.setLayoutParams(layoutParams);
            EMManager.from(frameLayout).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0209);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(context, R.dimen.tbds138), BdUtilHelper.getDimens(context, R.dimen.tbds31));
            layoutParams2.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X004), BdUtilHelper.getDimens(context, R.dimen.M_H_X002), BdUtilHelper.getDimens(context, R.dimen.M_W_X004), BdUtilHelper.getDimens(context, R.dimen.M_H_X002));
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
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, frameLayout) == null) && qk5.c("key_ai_write_button_first_show_red_dot", true)) {
            if (qk5.g("key_ai_write_button_first_show_red_dot_time", 0L) == 0) {
                qk5.o("key_ai_write_button_first_show_red_dot_time", System.currentTimeMillis());
            }
            if (System.currentTimeMillis() - qk5.g("key_ai_write_button_first_show_red_dot_time", System.currentTimeMillis()) < 1209600000) {
                ImageView imageView = new ImageView(context);
                imageView.setId(R.id.ai_write_button_red_dot);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(context, R.dimen.tbds18), BdUtilHelper.getDimens(context, R.dimen.tbds18));
                layoutParams.setMargins((BdUtilHelper.getDimens(context, R.dimen.tbds138) + (BdUtilHelper.getDimens(context, R.dimen.M_W_X004) * 2)) - BdUtilHelper.getDimens(context, R.dimen.tbds18), 0, 0, 0);
                SkinManager.setImageResource(imageView, R.drawable.icon_news_red_dot);
                frameLayout.addView(imageView, layoutParams);
            }
        }
    }

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
            tt4 j = tt4.j(TbadkCoreApplication.getInst().getCurrentActivity(), c("reply", str2));
            j.f(hashMap);
            j.p();
        }
    }

    public static void d(@NonNull View view2) {
        View findViewById;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2) == null) && (findViewById = view2.findViewById(R.id.ai_write_button_red_dot)) != null) {
            findViewById.setVisibility(8);
            qk5.m("key_ai_write_button_first_show_red_dot", false);
        }
    }
}
