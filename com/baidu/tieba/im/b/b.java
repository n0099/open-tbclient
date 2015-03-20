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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b bkI;
    private List<GroupUpdateMessage> bkQ;
    private boolean bkV;
    private int bkJ = 900000;
    private int bkK = 360000;
    private int bkL = this.bkK;
    private final int bkM = 0;
    private final int bkN = 1;
    private final int bkO = 2;
    private int bkP = 0;
    private int bkR = 0;
    private long bkS = 0;
    private int bkT = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new i(null);
    private SparseArray<Long> bkU = null;
    private final com.baidu.adp.framework.client.socket.link.g oI = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, 2001011);
    private final CustomMessageListener bkW = new h(this, 2005016);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016001));
        bkI = null;
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().ev() > 10) {
            ab.a(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int w = MessageManager.getInstance().getSocketClient().w(202003);
        if (a || w > 0) {
            ab.a(false, false, true);
            gg(i);
            return;
        }
        SN();
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
        ab.a(true, false, false);
        if ((i == 3 || i == 1 || i == 2) && this.bkU != null) {
            this.bkU.clear();
        }
    }

    public void SC() {
        boolean z;
        if (this.bkQ != null) {
            SparseArray<Long> Sn = com.baidu.tieba.im.memorycache.c.Sd().Sn();
            if (Sn == null) {
                this.bkQ = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bkQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && Sn.get(next.getGroupId()) != null) {
                    if (Sn.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bkT = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                SF().mHandler.sendMessageDelayed(SF().mHandler.obtainMessage(3), SF().bkL);
            }
            this.bkQ = null;
        }
    }

    private void SD() {
        if (this.bkP != 0) {
            if (this.bkP == 1) {
                a(0L, 0L, 0L, 0);
            } else {
                SK();
            }
        }
    }

    private void SE() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b SF() {
        b bVar;
        synchronized (b.class) {
            if (bkI == null) {
                bkI = new b();
            }
            bVar = bkI;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bkW);
        v.xH().a(this.oI);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        SG();
    }

    public void SG() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            gd(socketGetMsgStratgy[0] * 1000);
            ge(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        SN();
    }

    public void stop() {
        SN();
        SE();
    }

    public void SH() {
        this.bkL = this.bkK;
    }

    public void SI() {
        SF().bkL = SF().bkJ;
    }

    public void gd(int i) {
        if (i > 0) {
            this.bkK = i;
        }
    }

    public void ge(int i) {
        if (i > 0) {
            this.bkJ = i;
        }
    }

    public synchronized void SJ() {
        if (System.currentTimeMillis() - this.bkS >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bkR);
            pushCountMessage.setUpFlowSize(l.jr().getUpFlowSize());
            pushCountMessage.setDownFlowSize(l.jr().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bkS = System.currentTimeMillis();
            this.bkR = 0;
            l.jr().jy();
            l.jr().jx();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage c(SparseArray<Long> sparseArray) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.Sd().Sn());
        }
        messageSyncMessage.setForTimer(this.bkV);
        LocalViewSize.ImageSize sl = LocalViewSize.sj().sl();
        if (sl != null) {
            messageSyncMessage.setWidth(sl.width);
            messageSyncMessage.setHeight(sl.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.sj().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String RK = com.baidu.tieba.im.a.c.RN().RK();
        if (RK == null) {
            RK = GameInfoData.NOT_FROM_DETAIL;
        }
        messageSyncMessage.setNotifyMaxTime(RK);
        String RL = com.baidu.tieba.im.a.c.RN().RL();
        if (RL == null) {
            RL = GameInfoData.NOT_FROM_DETAIL;
        }
        messageSyncMessage.setNotifyMinTime(RL);
        messageSyncMessage.setSyncTypeString(String.valueOf(this.bkT));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.RN().RS()));
        return messageSyncMessage;
    }

    public synchronized void a(long j, long j2, long j3, int i) {
        int i2;
        Long l;
        this.bkR++;
        this.bkV = false;
        this.bkT = 1;
        this.mHandler.removeMessages(3);
        SF().mHandler.sendMessageDelayed(SF().mHandler.obtainMessage(3), SF().bkL);
        if (this.bkU == null) {
            this.bkU = new SparseArray<>();
            this.bkU.clear();
        }
        SparseArray<Long> Sn = com.baidu.tieba.im.memorycache.c.Sd().Sn();
        if (0 != j) {
            Long l2 = Sn.get((int) j);
            Long l3 = this.bkU.get((int) j);
            if (l2 == null) {
                if (l3 != null && l3.longValue() < j2) {
                    j2 = l3.longValue();
                }
            } else {
                j2 = l2.longValue();
            }
            if (j2 > 0) {
                this.bkU.put((int) j, Long.valueOf(j2));
            }
        }
        if (this.bkU != null && this.bkU.size() > 0) {
            for (int i3 = 0; i3 < this.bkU.size(); i3++) {
                int keyAt = this.bkU.keyAt(i3);
                Long l4 = Sn.get(keyAt);
                if (l4 != null && l4.longValue() > 0) {
                    this.bkU.put(keyAt, l4);
                }
            }
        }
        if ((i == 0 || i == 9) && (i2 = com.baidu.adp.lib.g.c.toInt(com.baidu.tieba.im.pushNotify.d.SY().Ta(), 0)) != 0 && (l = Sn.get(i2)) != null) {
            this.bkU.put(i2, l);
        }
        a(this.bkU, 1);
    }

    public synchronized void SK() {
        gf(2);
    }

    public synchronized void SL() {
        gf(3);
    }

    public void SM() {
        SD();
    }

    public synchronized void d(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bkV = false;
                this.bkT = 4;
                this.mHandler.removeMessages(3);
                SF().mHandler.sendMessageDelayed(SF().mHandler.obtainMessage(3), SF().bkL);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void gf(int i) {
        this.bkV = true;
        this.bkT = i;
        a((SparseArray<Long>) null, i);
    }

    private void gg(int i) {
        if (i == 1) {
            if (this.bkP != 2) {
                this.bkP = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bkP = 2;
        }
    }

    private void SN() {
        this.bkP = 0;
    }
}
