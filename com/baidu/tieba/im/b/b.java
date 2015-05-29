package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.webSocket.l;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.websocketBase.v;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.performanceLog.ab;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b bnD;
    private List<GroupUpdateMessage> bnL;
    private boolean bnR;
    private int bnE = 900000;
    private int bnF = 360000;
    private int bnG = this.bnF;
    private final int bnH = 0;
    private final int bnI = 1;
    private final int bnJ = 2;
    private int bnK = 0;
    private int bnM = 0;
    private long bnN = 0;
    private int bnO = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new i(null);
    private SparseArray<Long> bnP = null;
    private SparseArray<Long> bnQ = null;
    private final com.baidu.adp.framework.client.socket.link.g oN = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, 2001011);
    private final CustomMessageListener bnS = new h(this, 2005016);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016002));
        bnD = null;
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().ey() > 10) {
            ab.a(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int x = MessageManager.getInstance().getSocketClient().x(202003);
        if (a || x > 0) {
            ab.a(false, false, true);
            gz(i);
            return;
        }
        Un();
        SparseArray<Long> sparseArray2 = null;
        if (sparseArray != null && sparseArray.size() > 0) {
            SparseArray<Long> sparseArray3 = new SparseArray<>();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                sparseArray3.put(keyAt, sparseArray.get(keyAt));
            }
            sparseArray2 = sparseArray3;
        }
        MessageManager.getInstance().sendMessage(b(sparseArray2, i));
        ab.a(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.bnP != null) {
                this.bnP.clear();
            }
            if (this.bnQ != null) {
                this.bnQ.clear();
            }
        }
    }

    public void Uc() {
        boolean z;
        if (this.bnL != null) {
            SparseArray<Long> TN = com.baidu.tieba.im.memorycache.c.TD().TN();
            if (TN == null) {
                this.bnL = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bnL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && TN.get(next.getGroupId()) != null) {
                    if (TN.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bnO = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                Uf().mHandler.sendMessageDelayed(Uf().mHandler.obtainMessage(3), Uf().bnG);
            }
            this.bnL = null;
        }
    }

    private void Ud() {
        if (this.bnK != 0) {
            if (this.bnK == 1) {
                a(0L, 0L, 0L, 0);
            } else {
                Uk();
            }
        }
    }

    private void Ue() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b Uf() {
        b bVar;
        synchronized (b.class) {
            if (bnD == null) {
                bnD = new b();
            }
            bVar = bnD;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bnS);
        v.yA().a(this.oN);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        Ug();
    }

    public void Ug() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            gw(socketGetMsgStratgy[0] * 1000);
            gx(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        Un();
    }

    public void stop() {
        Un();
        Ue();
    }

    public void Uh() {
        this.bnG = this.bnF;
    }

    public void Ui() {
        Uf().bnG = Uf().bnE;
    }

    public void gw(int i) {
        if (i > 0) {
            this.bnF = i;
        }
    }

    public void gx(int i) {
        if (i > 0) {
            this.bnE = i;
        }
    }

    public synchronized void Uj() {
        if (System.currentTimeMillis() - this.bnN >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bnM);
            pushCountMessage.setUpFlowSize(l.jI().getUpFlowSize());
            pushCountMessage.setDownFlowSize(l.jI().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bnN = System.currentTimeMillis();
            this.bnM = 0;
            l.jI().jP();
            l.jI().jO();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(SparseArray<Long> sparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.TD().TN());
        }
        messageSyncMessage.setForTimer(this.bnR);
        LocalViewSize.ImageSize sT = LocalViewSize.sR().sT();
        if (sT != null) {
            messageSyncMessage.setWidth(sT.width);
            messageSyncMessage.setHeight(sT.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.sR().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String Tk = com.baidu.tieba.im.a.c.Tn().Tk();
        if (Tk == null) {
            Tk = GameInfoData.NOT_FROM_DETAIL;
        }
        messageSyncMessage.setNotifyMaxTime(Tk);
        String Tl = com.baidu.tieba.im.a.c.Tn().Tl();
        if (Tl == null) {
            Tl = GameInfoData.NOT_FROM_DETAIL;
        }
        messageSyncMessage.setNotifyMinTime(Tl);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.Tn().Ts()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3, int i) {
        a(j, j2, j3, false, i);
    }

    public synchronized void a(long j, long j2, long j3, boolean z, int i) {
        int i2;
        Long l;
        long longValue;
        this.bnM++;
        this.bnR = false;
        this.bnO = 1;
        this.mHandler.removeMessages(3);
        Uf().mHandler.sendMessageDelayed(Uf().mHandler.obtainMessage(3), Uf().bnG);
        if (this.bnP == null) {
            this.bnP = new SparseArray<>();
            this.bnP.clear();
        }
        if (this.bnQ == null) {
            this.bnQ = new SparseArray<>();
        }
        SparseArray<Long> TN = com.baidu.tieba.im.memorycache.c.TD().TN();
        if (0 != j) {
            Long l2 = TN.get((int) j);
            Long l3 = this.bnP.get((int) j);
            if (l2 == null) {
                if (l3 == null) {
                    longValue = j2;
                } else {
                    longValue = l3.longValue() < j2 ? l3.longValue() : j2;
                }
            } else {
                longValue = l2.longValue();
            }
            if (longValue > 0) {
                this.bnP.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.bnP != null && this.bnP.size() > 0) {
            for (int i3 = 0; i3 < this.bnP.size(); i3++) {
                int keyAt = this.bnP.keyAt(i3);
                Long l4 = TN.get(keyAt);
                if (l4 != null && l4.longValue() > 0) {
                    this.bnP.put(keyAt, l4);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.bnQ.get((int) j) == null) {
                    this.bnQ.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.bnQ.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.bnQ.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.bnP.size();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt2 = this.bnP.keyAt(i4);
                long longValue3 = this.bnP.valueAt(i4).longValue();
                long j4 = 0;
                if (this.bnQ.get(keyAt2) != null) {
                    j4 = this.bnQ.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.bnP.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.bnP.size() == 0) {
            Un();
            this.bnQ.clear();
        } else {
            if ((i == 0 || i == 9) && (i2 = com.baidu.adp.lib.g.c.toInt(com.baidu.tieba.im.pushNotify.d.Uy().UA(), 0)) != 0 && (l = TN.get(i2)) != null) {
                this.bnP.put(i2, l);
            }
            a(this.bnP, 1);
        }
    }

    public synchronized void Uk() {
        gy(2);
    }

    public synchronized void Ul() {
        gy(3);
    }

    public void Um() {
        Ud();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bnR = false;
                this.bnO = 4;
                this.mHandler.removeMessages(3);
                Uf().mHandler.sendMessageDelayed(Uf().mHandler.obtainMessage(3), Uf().bnG);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void gy(int i) {
        this.bnR = true;
        this.bnO = i;
        a((SparseArray<Long>) null, i);
    }

    private void gz(int i) {
        if (i == 1) {
            if (this.bnK != 2) {
                this.bnK = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bnK = 2;
        }
    }

    private void Un() {
        this.bnK = 0;
    }
}
