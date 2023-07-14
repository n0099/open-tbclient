package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes6.dex */
public class i75 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends w65>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947806434, "Lcom/baidu/tieba/i75;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947806434, "Lcom/baidu/tieba/i75;");
                return;
            }
        }
        ArrayMap arrayMap = new ArrayMap();
        a = arrayMap;
        arrayMap.put("WebViewYunDialog", h75.class);
        a.put("userIcon", g75.class);
        a.put("userGrowth", f75.class);
        a.put("newGod", c75.class);
        a.put("operateNew", d75.class);
        a.put("homeLiveRemind", b75.class);
        a.put("updateDialog", e75.class);
        a.put("lcUpdateDialog", a75.class);
        x65 x65Var = new x65();
        dl1<y65> dl1Var = x65Var.a;
        if (dl1Var != null && !ListUtils.isEmpty(dl1Var.getList())) {
            for (y65 y65Var : x65Var.a.getList()) {
                a.put(y65Var.name(), y65Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            o65 b = o65.b(str, str2);
            try {
                String a2 = b.a("yun_dialogClass");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                a.get(a2).getConstructor(new Class[0]).newInstance(new Object[0]).a(context, b);
            } catch (Exception e) {
                h29 yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.b("YunDialogManager", "云弹窗 " + str + " 渲染失败：" + e.getMessage());
                m65.u(str);
                e.printStackTrace();
            }
        }
    }
}
