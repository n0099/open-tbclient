package com.baidu.tieba.im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.im.net.link.TiebaSocketLinkService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.o;
/* loaded from: classes.dex */
public class TiebaIMReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            o.a(UtilHelper.i(context));
            if (UtilHelper.b()) {
                o.a("net change", "TiebaIMReceiver", "succ");
                TiebaSocketLinkService.a(false, "net succ");
                return;
            }
            o.a("net change", "TiebaIMReceiver", "failed");
            return;
        }
        TiebaSocketLinkService.a(false, "calling or boot ");
    }
}
