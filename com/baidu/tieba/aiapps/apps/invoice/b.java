package com.baidu.tieba.aiapps.apps.invoice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.invoice.ChooseInvoiceAction;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class b {
    public static void j(Context context, String str, String str2) {
        if (context != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(e.j.invoice_error_operation_failed);
            }
            AiAppsLog.e(ChooseInvoiceAction.MODULE_TAG, "网络请求错误：" + str2);
            UniversalToast.makeText(context, str2).showToast();
        }
    }

    public static void cj(Context context) {
    }
}
