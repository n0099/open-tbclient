package com.baidu.tieba;

import android.content.Context;
import android.graphics.Color;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class gc0 extends bc0 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String[]> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947788981, "Lcom/baidu/tieba/gc0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947788981, "Lcom/baidu/tieba/gc0;");
                return;
            }
        }
        b = new HashMap<>();
    }

    public gc0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b.put("color_1F1F1F", new String[]{"#141414", "#BFFFFFFF", "#E6FFFFFF", ""});
        b.put("color_white1", new String[]{"#FFFFFF", "#141414", "#000000", ""});
        b.put("color_white2", new String[]{"#F5F5F5", "#272729", "#141414", ""});
        b.put("color_white3", new String[]{"#FFFFFF", "#D9FFFFFF", "#FFFFFF", ""});
        b.put("color_F5F5F51", new String[]{"#F2F2F5", "#141414", "#000000", ""});
        b.put("color_F5F5F52", new String[]{"#F7F7FA", "#1E1D1F", "#1AFFFFFF", ""});
        b.put("color_F5F5F53", new String[]{"#0D000000", "#0DFFFFFF", "#1AFFFFFF", ""});
        b.put("color_FF33551", new String[]{"#FF3355", "#D42A46", "#FF3355", ""});
        b.put("color_FF33552", new String[]{"#1AFF3355", "#1AD42A46", "#1AFF3355", ""});
        b.put("color_858585", new String[]{"#858585", "#59FFFFFF", "#80FFFFFF", ""});
        b.put("color_525252", new String[]{"#525252", "#555555", "#99FFFFFF", ""});
        b.put("color_FF3333", new String[]{"#FF3333", "#FF3333", "#FF3333", ""});
        b.put("color_768CAE", new String[]{"#768CAE", "#768CAE", "#768CAE", ""});
        b.put("color_4E6EF2", new String[]{"#4E6EF2", "#4E6EF2", "#4E6EF2", ""});
        b.put("color_8585852", new String[]{"#858585", "#444444", "#80FFFFFF", ""});
        b.put("color_5252522", new String[]{"#525252", "#555555", "#99FFFFFF", ""});
        b.put("color_btn_stroke", new String[]{"#00000000", "#00000000", "#00000000", ""});
        b.put("color_btn_fill", new String[]{"#F7F7FA", "#1E1D1F", "#000000", ""});
        b.put("color_sub_tab_normal", new String[]{"#141414", "#BFFFFFFF", "#E6FFFFFF", ""});
        b.put("color_main_bg", new String[]{"#FFFFFF", "#141414", "#000000", ""});
        b.put("color_white4", new String[]{"#1F1F1F", "#666666", "", "#FFFFFF"});
        b.put("color_gradient_1", new String[]{"#FFFFFF", "#141414", "#000000", ""});
        b.put("color_gradient_2", new String[]{"#00FFFFFF", "#00141414", "#00000000", ""});
        b.put("color_E0E0E0", new String[]{"#E0E0E0", "", "", ""});
        b.put("color_EEEEEE", new String[]{"#eeeeee", "", "", ""});
    }

    @Override // com.baidu.tieba.bc0
    public int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, str2)) == null) {
            if (b.containsKey(str2)) {
                String str3 = b.get(str2)[0];
                if ("recommend".equals(str)) {
                    return fc0.c().a(context, str, str2);
                }
                if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                    str3 = b.get(str2)[3];
                } else {
                    String str4 = this.a;
                    if ("night" == str4) {
                        str3 = b.get(str2)[1];
                    } else if ("dark" == str4) {
                        str3 = b.get(str2)[2];
                    }
                }
                if (vb0.a(str3)) {
                    return -16777216;
                }
                try {
                    return Color.parseColor(str3);
                } catch (Exception e) {
                    e.printStackTrace();
                    return -16777216;
                }
            }
            return -16777216;
        }
        return invokeLLL.intValue;
    }
}
