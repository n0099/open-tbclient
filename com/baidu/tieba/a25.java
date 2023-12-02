package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes5.dex */
public class a25 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends m15>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947563301, "Lcom/baidu/tieba/a25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947563301, "Lcom/baidu/tieba/a25;");
                return;
            }
        }
        a = new ArrayMap();
        if (r25.a.a()) {
            a.put("WebViewYunDialog", z15.class);
        } else {
            a.put("WebViewYunDialog", y15.class);
        }
        a.put("userIcon", x15.class);
        a.put("userGrowth", w15.class);
        a.put("newGod", s15.class);
        a.put("operateNew", t15.class);
        a.put("homeLiveRemind", r15.class);
        a.put("topNotify", u15.class);
        a.put("updateDialog", v15.class);
        a.put("lcUpdateDialog", q15.class);
        n15 n15Var = new n15();
        tf1<o15> tf1Var = n15Var.a;
        if (tf1Var != null && !ListUtils.isEmpty(tf1Var.getList())) {
            for (o15 o15Var : n15Var.a.getList()) {
                a.put(o15Var.name(), o15Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            a15 b = a15.b(str, str2);
            try {
                String a2 = b.a("yun_dialogClass");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                a.get(a2).getConstructor(new Class[0]).newInstance(new Object[0]).a(context, b);
            } catch (Exception e) {
                TbLog yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.e(YunDialogManager.LOG_KEY, "云弹窗 " + str + " 渲染失败：" + e.getMessage());
                YunDialogManager.unMarkShowingDialogName(str);
                e.printStackTrace();
            }
        }
    }
}
