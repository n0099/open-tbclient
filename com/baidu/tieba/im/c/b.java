package com.baidu.tieba.im.c;

import android.content.Context;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.websocketBase.v;
import com.baidu.tieba.im.chat.bw;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.pushNotify.q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
    private final int l = com.baidu.adp.framework.d.a().b();
    private final Handler m = new j(null);
    private final com.baidu.adp.framework.client.socket.link.c n = new d(this);
    private final com.baidu.tieba.im.a<com.baidu.tieba.im.db.e> p = new e(this);
    private final com.baidu.adp.framework.listener.b q = new f(this, 0);
    private final CustomMessageListener r = new g(this, 2001011);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        a = null;
    }

    public void a() {
        boolean z;
        if (this.i != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.i) {
                com.baidu.tbadk.coreExtra.messageCenter.e.a().b(groupUpdateMessage.getGroupId(), groupUpdateMessage.getLastMsgId());
            }
            LinkedList linkedList = new LinkedList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedList<ImMessageCenterPojo> linkedList2 = new LinkedList<>();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            com.baidu.tieba.im.pushNotify.a.i().a(this.i);
            for (GroupUpdateMessage groupUpdateMessage2 : this.i) {
                if (groupUpdateMessage2 != null) {
                    linkedList.add(String.valueOf(groupUpdateMessage2.getGroupId()));
                    if (groupUpdateMessage2.getGroupType() == 6) {
                        if (groupUpdateMessage2.getGroupId() != 0 && w.a != groupUpdateMessage2.getGroupId()) {
                            w.a(groupUpdateMessage2.getGroupId());
                        }
                    } else if (groupUpdateMessage2.getGroupType() == 11 || groupUpdateMessage2.getGroupType() == 12) {
                        linkedHashMap2.put(String.valueOf(groupUpdateMessage2.getGroupId()), Long.valueOf(groupUpdateMessage2.getLastMsgId()));
                    } else {
                        linkedHashMap.put(String.valueOf(groupUpdateMessage2.getGroupId()), Long.valueOf(groupUpdateMessage2.getLastMsgId()));
                    }
                    if (groupUpdateMessage2.getGroupType() == 1) {
                        q.a().a(String.valueOf(groupUpdateMessage2.getGroupId()));
                    }
                }
            }
            com.baidu.tieba.im.i.a(new h(this, linkedHashMap2, linkedHashMap), null);
            for (GroupUpdateMessage groupUpdateMessage3 : this.i) {
                if (groupUpdateMessage3 != null) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    linkedList2.add(imMessageCenterPojo);
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage3.getGroupId()));
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage3.getName());
                    imMessageCenterPojo.setCustomGroupType(a.a(groupUpdateMessage3.getGroupType()));
                    ImMessageCenterPojo a2 = com.baidu.tieba.im.b.e.a(new StringBuilder(String.valueOf(groupUpdateMessage3.getGroupId())).toString());
                    if (a2 == null || a2.getPulled_msgId() == 0 || a2.getLast_rid() == 0) {
                        long b = bw.b(groupUpdateMessage3.getLastMsgId());
                        imMessageCenterPojo.setPulled_msgId(b);
                        imMessageCenterPojo.setLast_rid(b);
                    }
                    if (a2 != null) {
                        imMessageCenterPojo.setIs_hidden(a2.getIs_hidden());
                    }
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage3.getPortrait());
                }
            }
            com.baidu.tieba.im.b.e.a(new i(this, linkedList, linkedList2));
            com.baidu.tieba.im.db.i.a().a(linkedList2);
            Iterator<GroupUpdateMessage> it = this.i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (com.baidu.tbadk.coreExtra.messageCenter.e.a().c(next.getGroupId()) < next.getLastMsgId()) {
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
        messageSyncMessage.setGroupMids(com.baidu.tbadk.coreExtra.messageCenter.e.a().c());
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
