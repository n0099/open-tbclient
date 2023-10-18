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
public class c15 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Class<? extends o05>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947621922, "Lcom/baidu/tieba/c15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947621922, "Lcom/baidu/tieba/c15;");
                return;
            }
        }
        a = new ArrayMap();
        if (r15.a.a()) {
            a.put("WebViewYunDialog", b15.class);
        } else {
            a.put("WebViewYunDialog", a15.class);
        }
        a.put("userIcon", z05.class);
        a.put("userGrowth", y05.class);
        a.put("newGod", u05.class);
        a.put("operateNew", v05.class);
        a.put("homeLiveRemind", t05.class);
        a.put("topNotify", w05.class);
        a.put("updateDialog", x05.class);
        a.put("lcUpdateDialog", s05.class);
        p05 p05Var = new p05();
        ye1<q05> ye1Var = p05Var.a;
        if (ye1Var != null && !ListUtils.isEmpty(ye1Var.getList())) {
            for (q05 q05Var : p05Var.a.getList()) {
                a.put(q05Var.name(), q05Var.a());
            }
        }
    }

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            c05 b = c05.b(str, str2);
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
