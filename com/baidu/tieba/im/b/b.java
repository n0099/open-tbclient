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
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static b bYB;
    private List<GroupUpdateMessage> bYJ;
    private boolean bYP;
    private int bYC = 900000;
    private int bYD = 360000;
    private int bYE = this.bYD;
    private final int bYF = 0;
    private final int bYG = 1;
    private final int bYH = 2;
    private int bYI = 0;
    private int bYK = 0;
    private long bYL = 0;
    private int bYM = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> bYN = null;
    private SparseArray<Long> bYO = null;
    private final com.baidu.adp.framework.client.socket.link.e oO = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener bYQ = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        bYB = null;
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
                    b.aba().mHandler.removeMessages(2);
                    b.aba().abf();
                    return;
                case 3:
                    b.aba().mHandler.removeMessages(3);
                    if (b.aba().bYM == 3) {
                        b.aba().abg();
                    } else {
                        b.aba().abf();
                    }
                    b.aba().mHandler.sendMessageDelayed(b.aba().mHandler.obtainMessage(3), b.aba().bYE);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().ey() > 10) {
            u.a(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int A = MessageManager.getInstance().getSocketClient().A(202003);
        if (a2 || A > 0) {
            u.a(false, false, true);
            iT(i);
            return;
        }
        abi();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aay().aaJ());
        }
        MessageManager.getInstance().sendMessage(b);
        u.a(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.bYN != null) {
                this.bYN.clear();
            }
            if (this.bYO != null) {
                this.bYO.clear();
            }
        }
    }

    public void aaX() {
        boolean z;
        if (this.bYJ != null) {
            SparseArray<Long> aaI = com.baidu.tieba.im.memorycache.b.aay().aaI();
            if (aaI == null) {
                this.bYJ = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bYJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aaI.get(next.getGroupId()) != null) {
                    if (aaI.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bYM = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aba().mHandler.sendMessageDelayed(aba().mHandler.obtainMessage(3), aba().bYE);
            }
            this.bYJ = null;
        }
    }

    private void aaY() {
        if (this.bYI != 0) {
            if (this.bYI == 1) {
                b(0L, 0L, 0L);
            } else {
                abf();
            }
        }
    }

    private void aaZ() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aba() {
        b bVar;
        synchronized (b.class) {
            if (bYB == null) {
                bYB = new b();
            }
            bVar = bYB;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bYQ);
        n.AB().a(this.oO);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        abb();
    }

    public void abb() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            iQ(socketGetMsgStratgy[0] * 1000);
            iR(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        abi();
    }

    public void stop() {
        abi();
        aaZ();
    }

    public void abc() {
        this.bYE = this.bYD;
    }

    public void abd() {
        aba().bYE = aba().bYC;
    }

    public void iQ(int i) {
        if (i > 0) {
            this.bYD = i;
        }
    }

    public void iR(int i) {
        if (i > 0) {
            this.bYC = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void abe() {
        if (System.currentTimeMillis() - this.bYL >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bYK);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.jC().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.jC().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bYL = System.currentTimeMillis();
            this.bYK = 0;
            com.baidu.adp.lib.webSocket.h.jC().jI();
            com.baidu.adp.lib.webSocket.h.jC().jH();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aay().aaI());
        }
        messageSyncMessage.setForTimer(this.bYP);
        LocalViewSize.ImageSize us = LocalViewSize.uq().us();
        if (us != null) {
            messageSyncMessage.setWidth(us.width);
            messageSyncMessage.setHeight(us.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.uq().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String aaf = com.baidu.tieba.im.a.c.aai().aaf();
        if (aaf == null) {
            aaf = "0";
        }
        messageSyncMessage.setNotifyMaxTime(aaf);
        String aag = com.baidu.tieba.im.a.c.aai().aag();
        if (aag == null) {
            aag = "0";
        }
        messageSyncMessage.setNotifyMinTime(aag);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.aai().aan()));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.bYK++;
        this.bYP = false;
        this.bYM = 1;
        this.mHandler.removeMessages(3);
        aba().mHandler.sendMessageDelayed(aba().mHandler.obtainMessage(3), aba().bYE);
        if (this.bYN == null) {
            this.bYN = new SparseArray<>();
            this.bYN.clear();
        }
        if (this.bYO == null) {
            this.bYO = new SparseArray<>();
        }
        SparseArray<Long> aaI = com.baidu.tieba.im.memorycache.b.aay().aaI();
        if (0 != j) {
            Long l = aaI.get((int) j);
            Long l2 = this.bYN.get((int) j);
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
                this.bYN.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.bYN != null && this.bYN.size() > 0) {
            for (int i = 0; i < this.bYN.size(); i++) {
                int keyAt = this.bYN.keyAt(i);
                Long l3 = aaI.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.bYN.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.bYO.get((int) j) == null) {
                    this.bYO.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.bYO.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.bYO.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.bYN.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.bYN.keyAt(i2);
                long longValue3 = this.bYN.valueAt(i2).longValue();
                long j4 = 0;
                if (this.bYO.get(keyAt2) != null) {
                    j4 = this.bYO.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.bYN.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.bYN.size() == 0) {
            abi();
            this.bYO.clear();
        } else {
            a(this.bYN, 1);
        }
    }

    public synchronized void abf() {
        iS(2);
    }

    public synchronized void abg() {
        iS(3);
    }

    public void abh() {
        aaY();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bYP = false;
                this.bYM = 4;
                this.mHandler.removeMessages(3);
                aba().mHandler.sendMessageDelayed(aba().mHandler.obtainMessage(3), aba().bYE);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void iS(int i) {
        this.bYP = true;
        this.bYM = i;
        a((SparseArray<Long>) null, i);
    }

    private void iT(int i) {
        if (i == 1) {
            if (this.bYI != 2) {
                this.bYI = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bYI = 2;
        }
    }

    private void abi() {
        this.bYI = 0;
    }
}
