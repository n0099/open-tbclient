package com.baidu.tieba.im.net.link;

import android.os.Handler;
import com.baidu.adp.lib.webSocket.l;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.j;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.o;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1680a = false;
    private int b = 0;
    private int[] c = new int[0];
    private Handler d = new c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(b bVar) {
        int i = bVar.b;
        bVar.b = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        if (!this.f1680a) {
            this.f1680a = true;
            this.d.removeMessages(1);
            if (l.a().e()) {
                com.baidu.adp.lib.h.d.d("启动重连策略失败，  WebSocketClient opened");
                b("in Opened");
                return;
            }
            a();
            com.baidu.adp.lib.h.d.d("启动重连策略");
            this.b = 0;
            if (this.c != null && this.c.length >= 1) {
                be.b("start reconnStrategy... the first will be delay" + this.c[0]);
                this.d.sendMessageDelayed(this.d.obtainMessage(1), this.c[0] * LocationClientOption.MIN_SCAN_SPAN);
                return;
            }
            be.b("don't have reconnStrategy!");
            return;
        }
        com.baidu.adp.lib.h.d.d("重连策略正在运行中， 再次启动无效");
        o.a(str, "ReConnStrategy:start", "in Running,so failed");
    }

    private void a() {
        int[] aZ = TiebaApplication.g().aZ();
        if (aZ == null || aZ.length == 0) {
            aZ = j.c;
        }
        this.c = aZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        o.a(str, "ReConnStrategy:stop", "succ");
        this.f1680a = false;
        this.b = 0;
        be.b("stop reconnStrategy");
        this.d.removeMessages(1);
    }
}
