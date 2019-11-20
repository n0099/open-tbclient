package com.baidu.tieba.aiapps.apps.invoice;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    public static void q(Context context, String str, String str2) {
        if (context != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(R.string.invoice_error_operation_failed);
            }
            com.baidu.swan.apps.console.c.e("chooseInvoiceTitle", "网络请求错误：" + str2);
            com.baidu.swan.apps.res.widget.b.d.a(context, str2).QO();
        }
    }

    public static void a(Activity activity, com.baidu.swan.apps.a.a aVar) {
        com.baidu.swan.apps.console.c.e("chooseInvoiceTitle", "登录状态异常");
        com.baidu.tieba.aiapps.apps.a.c.a(activity, false, null, aVar);
    }
}
