package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.websocketBase.n;
import com.baidu.tbadk.performanceLog.w;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static b cnA;
    private List<GroupUpdateMessage> cnI;
    private boolean cnO;
    private int cnB = 900000;
    private int cnC = 360000;
    private int cnD = this.cnC;
    private final int cnE = 0;
    private final int cnF = 1;
    private final int cnG = 2;
    private int cnH = 0;
    private int cnJ = 0;
    private long cnK = 0;
    private int cnL = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> cnM = null;
    private SparseArray<Long> cnN = null;
    private final com.baidu.adp.framework.client.socket.link.e oT = new e(this);
    private final com.baidu.adp.framework.listener.e bje = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener cnP = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        cnA = null;
    }

    /* loaded from: classes.dex */
    private static class a extends Handler {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 2:
                    b.aht().mHandler.removeMessages(2);
                    b.aht().ahy();
                    return;
                case 3:
                    b.aht().mHandler.removeMessages(3);
                    if (b.aht().cnL == 3) {
                        b.aht().ahz();
                    } else {
                        b.aht().ahy();
                    }
                    b.aht().mHandler.sendMessageDelayed(b.aht().mHandler.obtainMessage(3), b.aht().cnD);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().eC() > 10) {
            w.b(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int J = MessageManager.getInstance().getSocketClient().J(202003);
        if (a2 || J > 0) {
            w.b(false, false, true);
            jW(i);
            return;
        }
        ahB();
        SparseArray<Long> sparseArray2 = null;
        if (sparseArray != null && sparseArray.size() > 0) {
            SparseArray<Long> sparseArray3 = new SparseArray<>();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                sparseArray3.put(keyAt, sparseArray.get(keyAt));
            }
            sparseArray2 = sparseArray3;
        }
        MessageSyncMessage b = b(sparseArray2, i);
        if (i == 3 || i == 2) {
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.agR().ahc());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.cnM != null) {
                this.cnM.clear();
            }
            if (this.cnN != null) {
                this.cnN.clear();
            }
        }
    }

    public void ahq() {
        boolean z;
        if (this.cnI != null) {
            SparseArray<Long> ahb = com.baidu.tieba.im.memorycache.b.agR().ahb();
            if (ahb == null) {
                this.cnI = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.cnI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && ahb.get(next.getGroupId()) != null) {
                    if (ahb.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.cnL = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aht().mHandler.sendMessageDelayed(aht().mHandler.obtainMessage(3), aht().cnD);
            }
            this.cnI = null;
        }
    }

    private void ahr() {
        if (this.cnH != 0) {
            if (this.cnH == 1) {
                a(0L, 0L, 0L);
            } else {
                ahy();
            }
        }
    }

    private void ahs() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aht() {
        b bVar;
        synchronized (b.class) {
            if (cnA == null) {
                cnA = new b();
            }
            bVar = cnA;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.cnP);
        n.Cu().a(this.oT);
        MessageManager.getInstance().registerListener(1003, this.bje);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.bje);
        MessageManager.getInstance().registerListener(202101, this.bje);
        ahu();
    }

    public void ahu() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            jT(socketGetMsgStratgy[0] * 1000);
            jU(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        ahB();
    }

    public void stop() {
        ahB();
        ahs();
    }

    public void ahv() {
        this.cnD = this.cnC;
    }

    public void ahw() {
        aht().cnD = aht().cnB;
    }

    public void jT(int i) {
        if (i > 0) {
            this.cnC = i;
        }
    }

    public void jU(int i) {
        if (i > 0) {
            this.cnB = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ahx() {
        if (System.currentTimeMillis() - this.cnK >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.cnJ);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.jR().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.jR().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.cnK = System.currentTimeMillis();
            this.cnJ = 0;
            com.baidu.adp.lib.webSocket.h.jR().jX();
            com.baidu.adp.lib.webSocket.h.jR().jW();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(SparseArray<Long> sparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
            NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(sparseArray);
            if (makeNewpushRepair != null) {
                messageSyncMessage.setNewpushRepire(makeNewpushRepair);
            }
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.agR().ahb());
        }
        messageSyncMessage.setForTimer(this.cnO);
        LocalViewSize.ImageSize vQ = LocalViewSize.vN().vQ();
        if (vQ != null) {
            messageSyncMessage.setWidth(vQ.width);
            messageSyncMessage.setHeight(vQ.height);
        }
        LocalViewSize.ImageSize vP = LocalViewSize.vN().vP();
        if (vP != null) {
            messageSyncMessage.setSmallHeight(vP.height);
            messageSyncMessage.setSmallWidth(vP.width);
        }
        String agx = com.baidu.tieba.im.a.c.agA().agx();
        if (agx == null) {
            agx = "0";
        }
        messageSyncMessage.setNotifyMaxTime(agx);
        String agy = com.baidu.tieba.im.a.c.agA().agy();
        if (agy == null) {
            agy = "0";
        }
        messageSyncMessage.setNotifyMinTime(agy);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.agA().agF()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.cnJ++;
        this.cnO = false;
        this.cnL = 1;
        this.mHandler.removeMessages(3);
        aht().mHandler.sendMessageDelayed(aht().mHandler.obtainMessage(3), aht().cnD);
        if (this.cnM == null) {
            this.cnM = new SparseArray<>();
            this.cnM.clear();
        }
        if (this.cnN == null) {
            this.cnN = new SparseArray<>();
        }
        SparseArray<Long> ahb = com.baidu.tieba.im.memorycache.b.agR().ahb();
        if (0 != j) {
            Long l = ahb.get((int) j);
            Long l2 = this.cnM.get((int) j);
            if (l == null) {
                if (l2 == null) {
                    longValue = j2;
                } else {
                    longValue = l2.longValue() < j2 ? l2.longValue() : j2;
                }
            } else {
                longValue = l.longValue();
            }
            if (longValue > 0) {
                this.cnM.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.cnM != null && this.cnM.size() > 0) {
            for (int i = 0; i < this.cnM.size(); i++) {
                int keyAt = this.cnM.keyAt(i);
                Long l3 = ahb.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.cnM.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.cnN.get((int) j) == null) {
                    this.cnN.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.cnN.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.cnN.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.cnM.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.cnM.keyAt(i2);
                long longValue3 = this.cnM.valueAt(i2).longValue();
                long j4 = 0;
                if (this.cnN.get(keyAt2) != null) {
                    j4 = this.cnN.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.cnM.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.cnM.size() == 0) {
            ahB();
            this.cnN.clear();
        } else {
            a(this.cnM, 1);
        }
    }

    public synchronized void ahy() {
        jV(2);
    }

    public synchronized void ahz() {
        jV(3);
    }

    public void ahA() {
        ahr();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.cnO = false;
                this.cnL = 4;
                this.mHandler.removeMessages(3);
                aht().mHandler.sendMessageDelayed(aht().mHandler.obtainMessage(3), aht().cnD);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void jV(int i) {
        this.cnO = true;
        this.cnL = i;
        a((SparseArray<Long>) null, i);
    }

    private void jW(int i) {
        if (i == 1) {
            if (this.cnH != 2) {
                this.cnH = 1;
            }
        } else if (i == 3 || i == 2) {
            this.cnH = 2;
        }
    }

    private void ahB() {
        this.cnH = 0;
    }
}
