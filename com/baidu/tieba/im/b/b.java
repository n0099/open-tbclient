package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.websocketBase.v;
import com.baidu.tbadk.performanceLog.x;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b bjx;
    private List<GroupUpdateMessage> bjF;
    private boolean bjK;
    private int bjy = 900000;
    private int bjz = 360000;
    private int bjA = this.bjz;
    private final int bjB = 0;
    private final int bjC = 1;
    private final int bjD = 2;
    private int bjE = 0;
    private int bjG = 0;
    private long bjH = 0;
    private int bjI = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new i(null);
    private SparseArray<Long> bjJ = null;
    private final com.baidu.adp.framework.client.socket.link.g du = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, 2001011);
    private final CustomMessageListener bjL = new h(this, 2005016);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016001));
        bjx = null;
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().aY() > 10) {
            x.a(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
        } else if (!com.baidu.tieba.im.memorycache.c.QJ().isInit()) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
        } else {
            boolean a = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
            int v = MessageManager.getInstance().getSocketClient().v(202003);
            if (a || v > 0) {
                x.a(false, false, true);
                gr(i);
                return;
            }
            Rw();
            SparseArray<Long> sparseArray2 = null;
            if (sparseArray != null && sparseArray.size() > 0) {
                SparseArray<Long> sparseArray3 = new SparseArray<>();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int keyAt = sparseArray.keyAt(i2);
                    sparseArray3.put(keyAt, sparseArray.get(keyAt));
                }
                sparseArray2 = sparseArray3;
            }
            MessageManager.getInstance().sendMessage(c(sparseArray2));
            x.a(true, false, false);
            if ((i == 3 || i == 1 || i == 2) && this.bjJ != null) {
                this.bjJ.clear();
            }
        }
    }

    public void Rl() {
        boolean z;
        if (this.bjF != null) {
            SparseArray<Long> QT = com.baidu.tieba.im.memorycache.c.QJ().QT();
            if (QT == null) {
                this.bjF = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bjF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && QT.get(next.getGroupId()) != null) {
                    if (QT.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bjI = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                Ro().mHandler.sendMessageDelayed(Ro().mHandler.obtainMessage(3), Ro().bjA);
            }
            this.bjF = null;
        }
    }

    private void Rm() {
        if (this.bjE != 0) {
            if (this.bjE == 1) {
                a(0L, 0L, 0L, 0);
            } else {
                Rt();
            }
        }
    }

    private void Rn() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b Ro() {
        b bVar;
        synchronized (b.class) {
            if (bjx == null) {
                bjx = new b();
            }
            bVar = bjx;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bjL);
        v.uq().a(this.du);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(1001, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        Rp();
    }

    public void Rp() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m255getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            go(socketGetMsgStratgy[0] * 1000);
            gp(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        Rw();
    }

    public void stop() {
        Rw();
        Rn();
    }

    public void Rq() {
        this.bjA = this.bjz;
    }

    public void Rr() {
        Ro().bjA = Ro().bjy;
    }

    public void go(int i) {
        if (i > 0) {
            this.bjz = i;
        }
    }

    public void gp(int i) {
        if (i > 0) {
            this.bjy = i;
        }
    }

    public synchronized void Rs() {
        if (System.currentTimeMillis() - this.bjH >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bjG);
            pushCountMessage.setUpFlowSize(m.fU().getUpFlowSize());
            pushCountMessage.setDownFlowSize(m.fU().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m255getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bjH = System.currentTimeMillis();
            this.bjG = 0;
            m.fU().gb();
            m.fU().ga();
            TbadkCoreApplication.m255getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage c(SparseArray<Long> sparseArray) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.QJ().QT());
        }
        messageSyncMessage.setForTimer(this.bjK);
        LocalViewSize.ImageSize oO = LocalViewSize.oM().oO();
        if (oO != null) {
            messageSyncMessage.setWidth(oO.width);
            messageSyncMessage.setHeight(oO.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.oM().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String Qq = com.baidu.tieba.im.a.c.Qt().Qq();
        if (Qq == null) {
            Qq = "0";
        }
        messageSyncMessage.setNotifyMaxTime(Qq);
        String Qr = com.baidu.tieba.im.a.c.Qt().Qr();
        if (Qr == null) {
            Qr = "0";
        }
        messageSyncMessage.setNotifyMinTime(Qr);
        messageSyncMessage.setSyncTypeString(String.valueOf(this.bjI));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.Qt().Qy()));
        return messageSyncMessage;
    }

    public synchronized void a(long j, long j2, long j3, int i) {
        int i2;
        Long l;
        this.bjG++;
        this.bjK = false;
        this.bjI = 1;
        if (this.bjJ == null) {
            this.bjJ = new SparseArray<>();
            this.bjJ.clear();
        }
        SparseArray<Long> QT = com.baidu.tieba.im.memorycache.c.QJ().QT();
        if (0 != j) {
            Long l2 = QT.get((int) j);
            Long l3 = this.bjJ.get((int) j);
            if (l2 == null) {
                if (l3 != null && l3.longValue() < j2) {
                    j2 = l3.longValue();
                }
            } else {
                j2 = l2.longValue();
            }
            if (j2 > 0) {
                this.bjJ.put((int) j, Long.valueOf(j2));
            }
        }
        if (this.bjJ != null && this.bjJ.size() > 0) {
            for (int i3 = 0; i3 < this.bjJ.size(); i3++) {
                int keyAt = this.bjJ.keyAt(i3);
                Long l4 = QT.get(keyAt);
                if (l4 != null && l4.longValue() > 0) {
                    this.bjJ.put(keyAt, l4);
                }
            }
        }
        if ((i == 0 || i == 9) && (i2 = com.baidu.adp.lib.g.c.toInt(com.baidu.tieba.im.pushNotify.d.Sb().Sd(), 0)) != 0 && (l = QT.get(i2)) != null) {
            this.bjJ.put(i2, l);
        }
        a(this.bjJ, 1);
    }

    public synchronized void Rt() {
        gq(2);
    }

    public synchronized void Ru() {
        gq(3);
    }

    public void Rv() {
        Rm();
    }

    public synchronized void d(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bjK = false;
                this.bjI = 4;
                this.mHandler.removeMessages(3);
                Ro().mHandler.sendMessageDelayed(Ro().mHandler.obtainMessage(3), Ro().bjA);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void gq(int i) {
        this.bjK = true;
        this.bjI = i;
        a((SparseArray<Long>) null, i);
    }

    private void gr(int i) {
        if (i == 1) {
            if (this.bjE != 2) {
                this.bjE = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bjE = 2;
        }
    }

    private void Rw() {
        this.bjE = 0;
    }
}
