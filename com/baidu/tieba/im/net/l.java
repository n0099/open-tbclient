package com.baidu.tieba.im.net;

import android.os.Handler;
import android.os.Looper;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.cb;
/* loaded from: classes.dex */
public final class l {
    private boolean a = false;
    private int b = 0;
    private int[] c = new int[0];
    private Handler d = new m(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        if (!this.a) {
            this.a = true;
            this.d.removeMessages(1);
            if (com.baidu.adp.lib.webSocket.l.a().d()) {
                com.baidu.adp.lib.util.e.e("启动重连策略失败，  WebSocketClient opened");
                b("in Opened");
                return;
            }
            int[] aM = TiebaApplication.g().aM();
            if (aM == null || aM.length == 0) {
                aM = com.baidu.tieba.im.f.b;
            }
            this.c = aM;
            com.baidu.adp.lib.util.e.e("启动重连策略");
            this.b = 0;
            if (this.c != null && this.c.length > 0) {
                com.baidu.adp.lib.util.e.d("start reconnStrategy... the first will be delay" + this.c[0]);
                this.d.sendMessageDelayed(this.d.obtainMessage(1), this.c[0] * LocationClientOption.MIN_SCAN_SPAN);
                return;
            }
            com.baidu.adp.lib.util.e.d("don't have reconnStrategy!");
            return;
        }
        com.baidu.adp.lib.util.e.e("重连策略正在运行中， 再次启动无效");
        cb.b(str, "ReConnStrategy:start", "in Running,so failed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(String str) {
        if (this.a) {
            cb.b(str, "ReConnStrategy:stop", "succ");
            this.a = false;
            this.b = 0;
            com.baidu.adp.lib.util.e.d("stop reconnStrategy");
            this.d.removeMessages(1);
        }
    }
}
