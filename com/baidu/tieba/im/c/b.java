package com.baidu.tieba.im.c;

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
    private static b bey;
    private List<GroupUpdateMessage> beD;
    private boolean beH;
    private int bez = 900000;
    private int beA = 360000;
    private int beB = this.beA;
    private boolean beC = false;
    private int beE = 0;
    private long beF = 0;
    private int beG = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new i(null);
    private final com.baidu.adp.framework.client.socket.link.g bn = new e(this);
    private final com.baidu.tieba.im.a<com.baidu.tieba.im.memorycache.a> beI = new f(this);
    private final com.baidu.adp.framework.listener.e ayJ = new g(this, 0);
    private final CustomMessageListener mCustomListener = new h(this, 2001011);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016001));
        bey = null;
    }

    public void Qs() {
        SparseArray<Long> PU;
        boolean z;
        if (this.beD != null && (PU = com.baidu.tieba.im.memorycache.c.PK().PU()) != null) {
            Iterator<GroupUpdateMessage> it = this.beD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                long lastMsgId = next.getLastMsgId();
                if (PU.get(next.getGroupId()) != null) {
                    if (PU.get(next.getGroupId()).longValue() < lastMsgId) {
                        z = true;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            this.beG = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                Qv().mHandler.sendMessageDelayed(Qv().mHandler.obtainMessage(3), Qv().beB);
            }
            this.beD = null;
        }
    }

    private void Qt() {
        if (this.beC) {
            QB();
            this.beC = false;
        }
    }

    private void Qu() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b Qv() {
        b bVar;
        synchronized (b.class) {
            if (bey == null) {
                bey = new b();
            }
            bVar = bey;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        v.qL().a(this.bn);
        MessageManager.getInstance().registerListener(1003, this.ayJ);
        MessageManager.getInstance().registerListener(1001, this.ayJ);
        MessageManager.getInstance().registerListener(202101, this.ayJ);
        Qw();
    }

    public void Qw() {
        int[] socketGetMsgStratgy = TbadkApplication.m251getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            fY(socketGetMsgStratgy[0] * 1000);
            fZ(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        this.beC = false;
    }

    public void stop() {
        this.beC = false;
        Qu();
    }

    public void Qx() {
        this.beB = this.beA;
    }

    public void Qy() {
        Qv().beB = Qv().bez;
    }

    public void fY(int i) {
        if (i > 0) {
            this.beA = i;
        }
    }

    public void fZ(int i) {
        if (i > 0) {
            this.bez = i;
        }
    }

    public synchronized void Qz() {
        if (System.currentTimeMillis() - this.beF >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.beE);
            pushCountMessage.setUpFlowSize(m.fT().getUpFlowSize());
            pushCountMessage.setDownFlowSize(m.fT().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkApplication.m251getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.beF = System.currentTimeMillis();
            this.beE = 0;
            m.fT().ga();
            m.fT().fZ();
            TbadkApplication.m251getInst().clearEnterForeCount();
        }
    }

    public MessageSyncMessage QA() {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.PK().PU());
        messageSyncMessage.setForTimer(this.beH);
        LocalViewSize.ImageSize lY = LocalViewSize.lV().lY();
        if (lY != null) {
            messageSyncMessage.setWidth(lY.width);
            messageSyncMessage.setHeight(lY.height);
        }
        LocalViewSize.ImageSize lX = LocalViewSize.lV().lX();
        if (lX != null) {
            messageSyncMessage.setSmallHeight(lX.height);
            messageSyncMessage.setSmallWidth(lX.width);
        }
        String Pr = com.baidu.tieba.im.b.c.Pu().Pr();
        if (Pr == null) {
            Pr = "0";
        }
        messageSyncMessage.setNotifyMaxTime(Pr);
        String Ps = com.baidu.tieba.im.b.c.Pu().Ps();
        if (Ps == null) {
            Ps = "0";
        }
        messageSyncMessage.setNotifyMinTime(Ps);
        messageSyncMessage.setSyncTypeString(String.valueOf(this.beG));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.b.c.Pu().Py()));
        return messageSyncMessage;
    }

    public synchronized void b(long j, long j2, long j3) {
        this.beE++;
        a(j, j2, j3, false, 1);
    }

    public synchronized void QB() {
        a(0L, 0L, 0L, true, 2);
    }

    public synchronized void QC() {
        a(0L, 0L, 0L, true, 3);
    }

    public void QD() {
        Qt();
    }

    private synchronized void a(long j, long j2, long j3, boolean z, int i) {
        this.beH = z;
        this.beG = i;
        if (!z) {
            this.mHandler.removeMessages(3);
            Qv().mHandler.sendMessageDelayed(Qv().mHandler.obtainMessage(3), Qv().beB);
        }
        this.beI.onReturnDataInUI(null);
    }
}
