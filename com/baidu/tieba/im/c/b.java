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
    private static b beM;
    private List<GroupUpdateMessage> beR;
    private boolean beV;
    private int beN = 900000;
    private int beO = 360000;
    private int beP = this.beO;
    private boolean beQ = false;
    private int beS = 0;
    private long beT = 0;
    private int beU = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new i(null);
    private final com.baidu.adp.framework.client.socket.link.g bn = new e(this);
    private final com.baidu.tieba.im.a<com.baidu.tieba.im.memorycache.a> beW = new f(this);
    private final com.baidu.adp.framework.listener.e ayS = new g(this, 0);
    private final CustomMessageListener mCustomListener = new h(this, 2001011);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016001));
        beM = null;
    }

    public void Qv() {
        SparseArray<Long> PX;
        boolean z;
        if (this.beR != null && (PX = com.baidu.tieba.im.memorycache.c.PN().PX()) != null) {
            Iterator<GroupUpdateMessage> it = this.beR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                long lastMsgId = next.getLastMsgId();
                if (PX.get(next.getGroupId()) != null) {
                    if (PX.get(next.getGroupId()).longValue() < lastMsgId) {
                        z = true;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            this.beU = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                Qy().mHandler.sendMessageDelayed(Qy().mHandler.obtainMessage(3), Qy().beP);
            }
            this.beR = null;
        }
    }

    private void Qw() {
        if (this.beQ) {
            QE();
            this.beQ = false;
        }
    }

    private void Qx() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b Qy() {
        b bVar;
        synchronized (b.class) {
            if (beM == null) {
                beM = new b();
            }
            bVar = beM;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        v.qN().a(this.bn);
        MessageManager.getInstance().registerListener(1003, this.ayS);
        MessageManager.getInstance().registerListener(1001, this.ayS);
        MessageManager.getInstance().registerListener(202101, this.ayS);
        Qz();
    }

    public void Qz() {
        int[] socketGetMsgStratgy = TbadkApplication.m251getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            fY(socketGetMsgStratgy[0] * 1000);
            fZ(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        this.beQ = false;
    }

    public void stop() {
        this.beQ = false;
        Qx();
    }

    public void QA() {
        this.beP = this.beO;
    }

    public void QB() {
        Qy().beP = Qy().beN;
    }

    public void fY(int i) {
        if (i > 0) {
            this.beO = i;
        }
    }

    public void fZ(int i) {
        if (i > 0) {
            this.beN = i;
        }
    }

    public synchronized void QC() {
        if (System.currentTimeMillis() - this.beT >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.beS);
            pushCountMessage.setUpFlowSize(m.fT().getUpFlowSize());
            pushCountMessage.setDownFlowSize(m.fT().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkApplication.m251getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.beT = System.currentTimeMillis();
            this.beS = 0;
            m.fT().ga();
            m.fT().fZ();
            TbadkApplication.m251getInst().clearEnterForeCount();
        }
    }

    public MessageSyncMessage QD() {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.PN().PX());
        messageSyncMessage.setForTimer(this.beV);
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
        String Pu = com.baidu.tieba.im.b.c.Px().Pu();
        if (Pu == null) {
            Pu = "0";
        }
        messageSyncMessage.setNotifyMaxTime(Pu);
        String Pv = com.baidu.tieba.im.b.c.Px().Pv();
        if (Pv == null) {
            Pv = "0";
        }
        messageSyncMessage.setNotifyMinTime(Pv);
        messageSyncMessage.setSyncTypeString(String.valueOf(this.beU));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.b.c.Px().PB()));
        return messageSyncMessage;
    }

    public synchronized void b(long j, long j2, long j3) {
        this.beS++;
        a(j, j2, j3, false, 1);
    }

    public synchronized void QE() {
        a(0L, 0L, 0L, true, 2);
    }

    public synchronized void QF() {
        a(0L, 0L, 0L, true, 3);
    }

    public void QG() {
        Qw();
    }

    private synchronized void a(long j, long j2, long j3, boolean z, int i) {
        this.beV = z;
        this.beU = i;
        if (!z) {
            this.mHandler.removeMessages(3);
            Qy().mHandler.sendMessageDelayed(Qy().mHandler.obtainMessage(3), Qy().beP);
        }
        this.beW.onReturnDataInUI(null);
    }
}
