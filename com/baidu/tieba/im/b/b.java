package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.websocketBase.v;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b a;
    private List<GroupUpdateMessage> i;
    private boolean o;
    private int b = 900000;
    private int c = 360000;
    private int d = this.c;
    private boolean e = false;
    private long f = 0;
    private int g = 0;
    private long h = 0;
    private int j = 0;
    private long k = 0;
    private final BdUniqueId l = BdUniqueId.gen();
    private final Handler m = new i(null);
    private final com.baidu.adp.framework.client.socket.link.c n = new e(this);
    private final com.baidu.tieba.im.a<com.baidu.tieba.im.memorycache.a> p = new f(this);
    private final com.baidu.adp.framework.listener.d q = new g(this, 0);
    private final CustomMessageListener r = new h(this, 2001011);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016001));
        a = null;
    }

    public void a() {
        SparseArray<Long> l;
        boolean z;
        if (this.i != null && (l = com.baidu.tieba.im.memorycache.c.b().l()) != null) {
            Iterator<GroupUpdateMessage> it = this.i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                long lastMsgId = next.getLastMsgId();
                if (l.get(next.getGroupId()) != null) {
                    if (l.get(next.getGroupId()).longValue() < lastMsgId) {
                        z = true;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.m.sendMessage(this.m.obtainMessage(3));
            } else {
                b().m.sendMessageDelayed(b().m.obtainMessage(3), b().d);
            }
            this.i = null;
        }
    }

    private void j() {
        if (this.e) {
            h();
            this.e = false;
        }
    }

    private void k() {
        this.m.removeMessages(3);
        this.m.removeMessages(2);
    }

    public static synchronized b b() {
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
        MessageManager.getInstance().registerListener(this.r);
        v.a().a(this.n);
        MessageManager.getInstance().registerListener(1003, this.q);
        MessageManager.getInstance().registerListener(1001, this.q);
        MessageManager.getInstance().registerListener(202101, this.q);
        c();
    }

    public void c() {
        int[] socketGetMsgStratgy = TbadkApplication.m252getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            a(socketGetMsgStratgy[0] * 1000);
            b(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void d() {
        this.e = false;
    }

    public void e() {
        this.e = false;
        k();
    }

    public void f() {
        this.d = this.c;
        if (this.g > 0) {
            h();
        }
    }

    public void g() {
        this.h = System.currentTimeMillis();
        b().d = b().b;
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

    public synchronized void l() {
        if (System.currentTimeMillis() - this.k >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.j);
            pushCountMessage.setUpFlowSize(m.a().g());
            pushCountMessage.setDownFlowSize(m.a().i());
            pushCountMessage.setEnterForeCount(TbadkApplication.m252getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.k = System.currentTimeMillis();
            this.j = 0;
            m.a().h();
            m.a().f();
            TbadkApplication.m252getInst().clearEnterForeCount();
        }
    }

    public MessageSyncMessage m() {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.b().l());
        messageSyncMessage.setForTimer(this.o);
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
        this.j++;
        a(j, j2, j3, false);
    }

    public synchronized void h() {
        a(0L, 0L, 0L, true);
    }

    public void i() {
        this.f = System.currentTimeMillis();
        j();
    }

    private synchronized void a(long j, long j2, long j3, boolean z) {
        this.o = z;
        if (!z) {
            this.m.removeMessages(3);
            b().m.sendMessageDelayed(b().m.obtainMessage(3), b().d);
        }
        this.p.a(null);
    }
}
