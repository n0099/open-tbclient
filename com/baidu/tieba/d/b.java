package com.baidu.tieba.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.d.a.c;
import com.baidu.tieba.x;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static final void a(Context context, c cVar, int i) {
        if (context != null && cVar != null) {
            if (!(!TextUtils.isEmpty(cVar.a()))) {
                j.a(context, x.pb_app_error);
            } else if (UtilHelper.isNetOk()) {
                cVar.a(1);
                TiebaStatic.eventStat(context, "pb_dl_app", null, 1, "app_name", cVar.a());
                com.baidu.tieba.frs.b.a().a(cVar.a(), cVar.h_(), cVar.i_(), i);
            } else {
                j.a(context, x.neterror);
            }
        }
    }

    public static final void a(Context context, c cVar) {
        if (context != null && cVar != null) {
            String a = cVar.a();
            if (TextUtils.isEmpty(a)) {
                j.a(context, x.pb_app_error);
                return;
            }
            File d = s.d(String.valueOf(a.replace(".", "_")) + ".apk");
            if (d != null) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(d), "application/vnd.android.package-archive");
                context.startActivity(intent);
            }
        }
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }
}
