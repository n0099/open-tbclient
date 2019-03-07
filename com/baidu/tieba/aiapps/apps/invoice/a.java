package com.baidu.tieba.aiapps.apps.invoice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a {
    public static void m(Context context, String str, String str2) {
        if (context != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(d.j.invoice_error_operation_failed);
            }
            com.baidu.swan.apps.console.c.e("chooseInvoiceTitle", "网络请求错误：" + str2);
            com.baidu.swan.apps.res.widget.b.d.a(context, str2).IK();
        }
    }

    public static void dH(Context context) {
    }
}
