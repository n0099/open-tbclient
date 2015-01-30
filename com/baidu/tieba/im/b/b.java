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
    private static b bjy;
    private List<GroupUpdateMessage> bjG;
    private boolean bjL;
    private int bjz = 900000;
    private int bjA = 360000;
    private int bjB = this.bjA;
    private final int bjC = 0;
    private final int bjD = 1;
    private final int bjE = 2;
    private int bjF = 0;
    private int bjH = 0;
    private long bjI = 0;
    private int bjJ = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new i(null);
    private SparseArray<Long> bjK = null;
    private final com.baidu.adp.framework.client.socket.link.g du = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, 2001011);
    private final CustomMessageListener bjM = new h(this, 2005016);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016001));
        bjy = null;
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().aY() > 10) {
            x.a(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
        } else if (!com.baidu.tieba.im.memorycache.c.QO().isInit()) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
        } else {
            boolean a = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
            int v = MessageManager.getInstance().getSocketClient().v(202003);
            if (a || v > 0) {
                x.a(false, false, true);
                gr(i);
                return;
            }
            RB();
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
            if ((i == 3 || i == 1 || i == 2) && this.bjK != null) {
                this.bjK.clear();
            }
        }
    }

    public void Rq() {
        boolean z;
        if (this.bjG != null) {
            SparseArray<Long> QY = com.baidu.tieba.im.memorycache.c.QO().QY();
            if (QY == null) {
                this.bjG = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bjG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && QY.get(next.getGroupId()) != null) {
                    if (QY.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bjJ = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                Rt().mHandler.sendMessageDelayed(Rt().mHandler.obtainMessage(3), Rt().bjB);
            }
            this.bjG = null;
        }
    }

    private void Rr() {
        if (this.bjF != 0) {
            if (this.bjF == 1) {
                a(0L, 0L, 0L, 0);
            } else {
                Ry();
            }
        }
    }

    private void Rs() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b Rt() {
        b bVar;
        synchronized (b.class) {
            if (bjy == null) {
                bjy = new b();
            }
            bVar = bjy;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bjM);
        v.uw().a(this.du);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(1001, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        Ru();
    }

    public void Ru() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m255getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            go(socketGetMsgStratgy[0] * 1000);
            gp(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        RB();
    }

    public void stop() {
        RB();
        Rs();
    }

    public void Rv() {
        this.bjB = this.bjA;
    }

    public void Rw() {
        Rt().bjB = Rt().bjz;
    }

    public void go(int i) {
        if (i > 0) {
            this.bjA = i;
        }
    }

    public void gp(int i) {
        if (i > 0) {
            this.bjz = i;
        }
    }

    public synchronized void Rx() {
        if (System.currentTimeMillis() - this.bjI >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bjH);
            pushCountMessage.setUpFlowSize(m.fU().getUpFlowSize());
            pushCountMessage.setDownFlowSize(m.fU().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m255getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bjI = System.currentTimeMillis();
            this.bjH = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.QO().QY());
        }
        messageSyncMessage.setForTimer(this.bjL);
        LocalViewSize.ImageSize oV = LocalViewSize.oT().oV();
        if (oV != null) {
            messageSyncMessage.setWidth(oV.width);
            messageSyncMessage.setHeight(oV.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.oT().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String Qv = com.baidu.tieba.im.a.c.Qy().Qv();
        if (Qv == null) {
            Qv = "0";
        }
        messageSyncMessage.setNotifyMaxTime(Qv);
        String Qw = com.baidu.tieba.im.a.c.Qy().Qw();
        if (Qw == null) {
            Qw = "0";
        }
        messageSyncMessage.setNotifyMinTime(Qw);
        messageSyncMessage.setSyncTypeString(String.valueOf(this.bjJ));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.Qy().QD()));
        return messageSyncMessage;
    }

    public synchronized void a(long j, long j2, long j3, int i) {
        int i2;
        Long l;
        this.bjH++;
        this.bjL = false;
        this.bjJ = 1;
        if (this.bjK == null) {
            this.bjK = new SparseArray<>();
            this.bjK.clear();
        }
        SparseArray<Long> QY = com.baidu.tieba.im.memorycache.c.QO().QY();
        if (0 != j) {
            Long l2 = QY.get((int) j);
            Long l3 = this.bjK.get((int) j);
            if (l2 == null) {
                if (l3 != null && l3.longValue() < j2) {
                    j2 = l3.longValue();
                }
            } else {
                j2 = l2.longValue();
            }
            if (j2 > 0) {
                this.bjK.put((int) j, Long.valueOf(j2));
            }
        }
        if (this.bjK != null && this.bjK.size() > 0) {
            for (int i3 = 0; i3 < this.bjK.size(); i3++) {
                int keyAt = this.bjK.keyAt(i3);
                Long l4 = QY.get(keyAt);
                if (l4 != null && l4.longValue() > 0) {
                    this.bjK.put(keyAt, l4);
                }
            }
        }
        if ((i == 0 || i == 9) && (i2 = com.baidu.adp.lib.g.c.toInt(com.baidu.tieba.im.pushNotify.d.Sg().Si(), 0)) != 0 && (l = QY.get(i2)) != null) {
            this.bjK.put(i2, l);
        }
        a(this.bjK, 1);
    }

    public synchronized void Ry() {
        gq(2);
    }

    public synchronized void Rz() {
        gq(3);
    }

    public void RA() {
        Rr();
    }

    public synchronized void d(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bjL = false;
                this.bjJ = 4;
                this.mHandler.removeMessages(3);
                Rt().mHandler.sendMessageDelayed(Rt().mHandler.obtainMessage(3), Rt().bjB);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void gq(int i) {
        this.bjL = true;
        this.bjJ = i;
        a((SparseArray<Long>) null, i);
    }

    private void gr(int i) {
        if (i == 1) {
            if (this.bjF != 2) {
                this.bjF = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bjF = 2;
        }
    }

    private void RB() {
        this.bjF = 0;
    }
}
