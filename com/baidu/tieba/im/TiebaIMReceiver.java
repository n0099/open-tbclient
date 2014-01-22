package com.baidu.tieba.im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
/* loaded from: classes.dex */
public class TiebaIMReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            com.baidu.tieba.log.a.a(UtilHelper.g(context));
            if (UtilHelper.b()) {
                by.b("net change", "TiebaIMReceiver", "succ");
                TiebaSocketLinkService.a(false, "net succ");
                return;
            }
            by.b("net change", "TiebaIMReceiver", "failed");
            return;
        }
        TiebaSocketLinkService.a(false, "calling or boot ");
    }
}
