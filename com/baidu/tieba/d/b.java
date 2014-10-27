package com.baidu.tieba.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.d.a.c;
import com.baidu.tieba.y;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static final void a(Context context, c cVar, int i) {
        if (context != null && cVar != null) {
            if (!(!TextUtils.isEmpty(cVar.abk()))) {
                m.showToast(context, y.pb_app_error);
            } else if (j.fh()) {
                cVar.hf(1);
                TiebaStatic.eventStat(context, "pb_dl_app", null, 1, "app_name", cVar.abk());
                com.baidu.tbadk.download.b.rh().a(cVar.abk(), cVar.getDownloadUrl(), cVar.getAppName(), i);
            } else {
                m.showToast(context, y.neterror);
            }
        }
    }

    public static final void a(Context context, c cVar) {
        if (context != null && cVar != null) {
            String abk = cVar.abk();
            if (TextUtils.isEmpty(abk)) {
                m.showToast(context, y.pb_app_error);
                return;
            }
            File br = s.br(String.valueOf(abk.replace(".", "_")) + ".apk");
            if (br != null) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(br), "application/vnd.android.package-archive");
                context.startActivity(intent);
            }
        }
    }

    public static boolean E(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }
}
