package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
    private static b cTM;
    private List<GroupUpdateMessage> cTU;
    private boolean cUa;
    private int cTN = 900000;
    private int cTO = 360000;
    private int cTP = this.cTO;
    private final int cTQ = 0;
    private final int cTR = 1;
    private final int cTS = 2;
    private int cTT = 0;
    private int cTV = 0;
    private long cTW = 0;
    private int cTX = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> cTY = null;
    private SparseArray<Long> cTZ = null;
    private final com.baidu.adp.framework.client.socket.link.e eK = new e(this);
    private final com.baidu.adp.framework.listener.e bBq = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener cUb = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        cTM = null;
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
                    b.apP().mHandler.removeMessages(2);
                    b.apP().apU();
                    return;
                case 3:
                    b.apP().mHandler.removeMessages(3);
                    if (b.apP().cTX == 3) {
                        b.apP().apV();
                    } else {
                        b.apP().apU();
                    }
                    b.apP().mHandler.sendMessageDelayed(b.apP().mHandler.obtainMessage(3), b.apP().cTP);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().aS() > 10) {
            w.b(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int y = MessageManager.getInstance().getSocketClient().y(202003);
        if (a2 || y > 0) {
            w.b(false, false, true);
            lc(i);
            return;
        }
        apX();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.apn().apy());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.cTY != null) {
                this.cTY.clear();
            }
            if (this.cTZ != null) {
                this.cTZ.clear();
            }
        }
    }

    public void apM() {
        boolean z;
        if (this.cTU != null) {
            SparseArray<Long> apx = com.baidu.tieba.im.memorycache.b.apn().apx();
            if (apx == null) {
                this.cTU = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.cTU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && apx.get(next.getGroupId()) != null) {
                    if (apx.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.cTX = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                apP().mHandler.sendMessageDelayed(apP().mHandler.obtainMessage(3), apP().cTP);
            }
            this.cTU = null;
        }
    }

    private void apN() {
        if (this.cTT != 0) {
            if (this.cTT == 1) {
                a(0L, 0L, 0L);
            } else {
                apU();
            }
        }
    }

    private void apO() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b apP() {
        b bVar;
        synchronized (b.class) {
            if (cTM == null) {
                cTM = new b();
            }
            bVar = cTM;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.cUb);
        n.Au().a(this.eK);
        MessageManager.getInstance().registerListener(1003, this.bBq);
        MessageManager.getInstance().registerListener(1001, this.bBq);
        MessageManager.getInstance().registerListener(202101, this.bBq);
        apQ();
    }

    public void apQ() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            kZ(socketGetMsgStratgy[0] * 1000);
            la(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        apX();
    }

    public void stop() {
        apX();
        apO();
    }

    public void apR() {
        this.cTP = this.cTO;
    }

    public void apS() {
        apP().cTP = apP().cTN;
    }

    public void kZ(int i) {
        if (i > 0) {
            this.cTO = i;
        }
    }

    public void la(int i) {
        if (i > 0) {
            this.cTN = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void apT() {
        if (System.currentTimeMillis() - this.cTW >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.cTV);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.gg().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.gg().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.cTW = System.currentTimeMillis();
            this.cTV = 0;
            com.baidu.adp.lib.webSocket.h.gg().gn();
            com.baidu.adp.lib.webSocket.h.gg().gm();
            TbadkCoreApplication.m9getInst().clearEnterForeCount();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.apn().apx());
        }
        messageSyncMessage.setForTimer(this.cUa);
        LocalViewSize.ImageSize tu = LocalViewSize.tr().tu();
        if (tu != null) {
            messageSyncMessage.setWidth(tu.width);
            messageSyncMessage.setHeight(tu.height);
        }
        LocalViewSize.ImageSize tt = LocalViewSize.tr().tt();
        if (tt != null) {
            messageSyncMessage.setSmallHeight(tt.height);
            messageSyncMessage.setSmallWidth(tt.width);
        }
        String aoT = com.baidu.tieba.im.a.c.aoW().aoT();
        if (aoT == null) {
            aoT = "0";
        }
        messageSyncMessage.setNotifyMaxTime(aoT);
        String aoU = com.baidu.tieba.im.a.c.aoW().aoU();
        if (aoU == null) {
            aoU = "0";
        }
        messageSyncMessage.setNotifyMinTime(aoU);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.aoW().apb()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.cTV++;
        this.cUa = false;
        this.cTX = 1;
        this.mHandler.removeMessages(3);
        apP().mHandler.sendMessageDelayed(apP().mHandler.obtainMessage(3), apP().cTP);
        if (this.cTY == null) {
            this.cTY = new SparseArray<>();
            this.cTY.clear();
        }
        if (this.cTZ == null) {
            this.cTZ = new SparseArray<>();
        }
        SparseArray<Long> apx = com.baidu.tieba.im.memorycache.b.apn().apx();
        if (0 != j) {
            Long l = apx.get((int) j);
            Long l2 = this.cTY.get((int) j);
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
                this.cTY.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.cTY != null && this.cTY.size() > 0) {
            for (int i = 0; i < this.cTY.size(); i++) {
                int keyAt = this.cTY.keyAt(i);
                Long l3 = apx.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.cTY.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.cTZ.get((int) j) == null) {
                    this.cTZ.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.cTZ.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.cTZ.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.cTY.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.cTY.keyAt(i2);
                long longValue3 = this.cTY.valueAt(i2).longValue();
                long j4 = 0;
                if (this.cTZ.get(keyAt2) != null) {
                    j4 = this.cTZ.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.cTY.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.cTY.size() == 0) {
            apX();
            this.cTZ.clear();
        } else {
            a(this.cTY, 1);
        }
    }

    public synchronized void apU() {
        lb(2);
    }

    public synchronized void apV() {
        lb(3);
    }

    public void apW() {
        apN();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.cUa = false;
                this.cTX = 4;
                this.mHandler.removeMessages(3);
                apP().mHandler.sendMessageDelayed(apP().mHandler.obtainMessage(3), apP().cTP);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lb(int i) {
        this.cUa = true;
        this.cTX = i;
        a((SparseArray<Long>) null, i);
    }

    private void lc(int i) {
        if (i == 1) {
            if (this.cTT != 2) {
                this.cTT = 1;
            }
        } else if (i == 3 || i == 2) {
            this.cTT = 2;
        }
    }

    private void apX() {
        this.cTT = 0;
    }
}
