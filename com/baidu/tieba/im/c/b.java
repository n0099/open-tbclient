package com.baidu.tieba.im.c;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.d.q;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
/* loaded from: classes.dex */
public class b {
    private static b a;
    private boolean n;
    private int b = 900000;
    private int c = 360000;
    private int d = this.c;
    private boolean e = false;
    private long f = 0;
    private int g = 0;
    private long h = 0;
    private int i = 0;
    private long j = 0;
    private final int k = com.baidu.adp.framework.d.a().b();
    private final Handler l = new j(null);
    private final com.baidu.adp.lib.network.websocket.c m = new d(this);
    private final com.baidu.tieba.im.a<com.baidu.tieba.im.db.e> o = new e(this);
    private final com.baidu.adp.framework.listener.b p = new f(this, 0);
    private final CustomMessageListener q = new i(this, MessageTypes.CMD_BACKGROUND_SWTICH);

    static {
        MessageManager.getInstance().registerListener(new c(2010017));
        a = null;
    }

    private void i() {
        if (this.e) {
            g();
            this.e = false;
        }
    }

    private void j() {
        this.l.removeMessages(3);
        this.l.removeMessages(2);
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.q);
        q.a().a(this.m);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_PING, this.p);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPDATE_CLIENT_INFO, this.p);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_PUSH_COUNT, this.p);
        b();
    }

    public void b() {
        int[] socketGetMsgStratgy = TbadkApplication.m252getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            a(socketGetMsgStratgy[0] * LocationClientOption.MIN_SCAN_SPAN);
            b(socketGetMsgStratgy[1] * LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    public void c() {
        this.e = false;
        com.baidu.adp.lib.stats.h.a().a("lc_con", (String) null, (String) null, m.a().l(), 0, (String) null, "dns", Long.valueOf(m.a().j()), "ip", m.a().k(), "net", com.baidu.adp.lib.stats.h.a().c());
    }

    public void d() {
        this.e = false;
        BdLog.i("----msg sync stop");
        j();
    }

    public void e() {
        BdLog.i("----switchToForeground");
        this.d = this.c;
        if (this.g > 0) {
            g();
        }
    }

    public void f() {
        BdLog.i("----switchToBackground");
        this.h = System.currentTimeMillis();
        a().d = a().b;
    }

    public void a(int i) {
        if (i > 0) {
            this.c = i;
        }
    }

    public void b(int i) {
        if (i > 0) {
            this.b = i;
        }
    }

    public synchronized void k() {
        if (System.currentTimeMillis() - this.j >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.i);
            pushCountMessage.setUpFlowSize(m.a().g());
            pushCountMessage.setDownFlowSize(m.a().i());
            pushCountMessage.setEnterForeCount(TbadkApplication.m252getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.j = System.currentTimeMillis();
            this.i = 0;
            m.a().h();
            m.a().f();
            TbadkApplication.m252getInst().clearEnterForeCount();
        }
    }

    public MessageSyncMessage l() {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setGroupMids(com.baidu.tbadk.coreExtra.messageCenter.e.a().c());
        messageSyncMessage.setForTimer(this.n);
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        if (d != null) {
            messageSyncMessage.setWidth(d.width);
            messageSyncMessage.setHeight(d.height);
        }
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        if (c != null) {
            messageSyncMessage.setSmallHeight(c.height);
            messageSyncMessage.setSmallWidth(c.width);
        }
        return messageSyncMessage;
    }

    public synchronized void a(long j, long j2, long j3) {
        this.i++;
        a(j, j2, j3, false);
    }

    public synchronized void g() {
        a(0L, 0L, 0L, true);
    }

    public void h() {
        this.f = System.currentTimeMillis();
        i();
    }

    private synchronized void a(long j, long j2, long j3, boolean z) {
        this.n = z;
        if (!z) {
            this.l.removeMessages(3);
            a().l.sendMessageDelayed(a().l.obtainMessage(3), a().d);
        }
        BdLog.i("----begin pullMessageForNewRemind");
        this.o.a(null);
    }
}
