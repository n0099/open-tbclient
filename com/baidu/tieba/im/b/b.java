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
    private static b bnE;
    private List<GroupUpdateMessage> bnM;
    private boolean bnS;
    private int bnF = 900000;
    private int bnG = 360000;
    private int bnH = this.bnG;
    private final int bnI = 0;
    private final int bnJ = 1;
    private final int bnK = 2;
    private int bnL = 0;
    private int bnN = 0;
    private long bnO = 0;
    private int bnP = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new i(null);
    private SparseArray<Long> bnQ = null;
    private SparseArray<Long> bnR = null;
    private final com.baidu.adp.framework.client.socket.link.g oN = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, 2001011);
    private final CustomMessageListener bnT = new h(this, 2005016);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016002));
        bnE = null;
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
        Uo();
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
            if (this.bnQ != null) {
                this.bnQ.clear();
            }
            if (this.bnR != null) {
                this.bnR.clear();
            }
        }
    }

    public void Ud() {
        boolean z;
        if (this.bnM != null) {
            SparseArray<Long> TO = com.baidu.tieba.im.memorycache.c.TE().TO();
            if (TO == null) {
                this.bnM = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bnM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && TO.get(next.getGroupId()) != null) {
                    if (TO.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bnP = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                Ug().mHandler.sendMessageDelayed(Ug().mHandler.obtainMessage(3), Ug().bnH);
            }
            this.bnM = null;
        }
    }

    private void Ue() {
        if (this.bnL != 0) {
            if (this.bnL == 1) {
                a(0L, 0L, 0L, 0);
            } else {
                Ul();
            }
        }
    }

    private void Uf() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b Ug() {
        b bVar;
        synchronized (b.class) {
            if (bnE == null) {
                bnE = new b();
            }
            bVar = bnE;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bnT);
        v.yB().a(this.oN);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        Uh();
    }

    public void Uh() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            gw(socketGetMsgStratgy[0] * 1000);
            gx(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        Uo();
    }

    public void stop() {
        Uo();
        Uf();
    }

    public void Ui() {
        this.bnH = this.bnG;
    }

    public void Uj() {
        Ug().bnH = Ug().bnF;
    }

    public void gw(int i) {
        if (i > 0) {
            this.bnG = i;
        }
    }

    public void gx(int i) {
        if (i > 0) {
            this.bnF = i;
        }
    }

    public synchronized void Uk() {
        if (System.currentTimeMillis() - this.bnO >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bnN);
            pushCountMessage.setUpFlowSize(l.jI().getUpFlowSize());
            pushCountMessage.setDownFlowSize(l.jI().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bnO = System.currentTimeMillis();
            this.bnN = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.TE().TO());
        }
        messageSyncMessage.setForTimer(this.bnS);
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
        String Tl = com.baidu.tieba.im.a.c.To().Tl();
        if (Tl == null) {
            Tl = GameInfoData.NOT_FROM_DETAIL;
        }
        messageSyncMessage.setNotifyMaxTime(Tl);
        String Tm = com.baidu.tieba.im.a.c.To().Tm();
        if (Tm == null) {
            Tm = GameInfoData.NOT_FROM_DETAIL;
        }
        messageSyncMessage.setNotifyMinTime(Tm);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.To().Tt()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3, int i) {
        a(j, j2, j3, false, i);
    }

    public synchronized void a(long j, long j2, long j3, boolean z, int i) {
        int i2;
        Long l;
        long longValue;
        this.bnN++;
        this.bnS = false;
        this.bnP = 1;
        this.mHandler.removeMessages(3);
        Ug().mHandler.sendMessageDelayed(Ug().mHandler.obtainMessage(3), Ug().bnH);
        if (this.bnQ == null) {
            this.bnQ = new SparseArray<>();
            this.bnQ.clear();
        }
        if (this.bnR == null) {
            this.bnR = new SparseArray<>();
        }
        SparseArray<Long> TO = com.baidu.tieba.im.memorycache.c.TE().TO();
        if (0 != j) {
            Long l2 = TO.get((int) j);
            Long l3 = this.bnQ.get((int) j);
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
                this.bnQ.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.bnQ != null && this.bnQ.size() > 0) {
            for (int i3 = 0; i3 < this.bnQ.size(); i3++) {
                int keyAt = this.bnQ.keyAt(i3);
                Long l4 = TO.get(keyAt);
                if (l4 != null && l4.longValue() > 0) {
                    this.bnQ.put(keyAt, l4);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.bnR.get((int) j) == null) {
                    this.bnR.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.bnR.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.bnR.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.bnQ.size();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt2 = this.bnQ.keyAt(i4);
                long longValue3 = this.bnQ.valueAt(i4).longValue();
                long j4 = 0;
                if (this.bnR.get(keyAt2) != null) {
                    j4 = this.bnR.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.bnQ.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.bnQ.size() == 0) {
            Uo();
            this.bnR.clear();
        } else {
            if ((i == 0 || i == 9) && (i2 = com.baidu.adp.lib.g.c.toInt(com.baidu.tieba.im.pushNotify.d.Uz().UB(), 0)) != 0 && (l = TO.get(i2)) != null) {
                this.bnQ.put(i2, l);
            }
            a(this.bnQ, 1);
        }
    }

    public synchronized void Ul() {
        gy(2);
    }

    public synchronized void Um() {
        gy(3);
    }

    public void Un() {
        Ue();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bnS = false;
                this.bnP = 4;
                this.mHandler.removeMessages(3);
                Ug().mHandler.sendMessageDelayed(Ug().mHandler.obtainMessage(3), Ug().bnH);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void gy(int i) {
        this.bnS = true;
        this.bnP = i;
        a((SparseArray<Long>) null, i);
    }

    private void gz(int i) {
        if (i == 1) {
            if (this.bnL != 2) {
                this.bnL = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bnL = 2;
        }
    }

    private void Uo() {
        this.bnL = 0;
    }
}
