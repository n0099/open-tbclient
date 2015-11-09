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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b bFI;
    private List<GroupUpdateMessage> bFQ;
    private boolean bFW;
    private int bFJ = 900000;
    private int bFK = 360000;
    private int bFL = this.bFK;
    private final int bFM = 0;
    private final int bFN = 1;
    private final int bFO = 2;
    private int bFP = 0;
    private int bFR = 0;
    private long bFS = 0;
    private int bFT = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> bFU = null;
    private SparseArray<Long> bFV = null;
    private final com.baidu.adp.framework.client.socket.link.e oN = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener bFX = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        bFI = null;
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
                    b.WO().mHandler.removeMessages(2);
                    b.WO().WT();
                    return;
                case 3:
                    b.WO().mHandler.removeMessages(3);
                    if (b.WO().bFT == 3) {
                        b.WO().WU();
                    } else {
                        b.WO().WT();
                    }
                    b.WO().mHandler.sendMessageDelayed(b.WO().mHandler.obtainMessage(3), b.WO().bFL);
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
        int z = MessageManager.getInstance().getSocketClient().z(202003);
        if (a2 || z > 0) {
            u.a(false, false, true);
            hG(i);
            return;
        }
        WW();
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
        u.a(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.bFU != null) {
                this.bFU.clear();
            }
            if (this.bFV != null) {
                this.bFV.clear();
            }
        }
    }

    public void WL() {
        boolean z;
        if (this.bFQ != null) {
            SparseArray<Long> Wx = com.baidu.tieba.im.memorycache.b.Wn().Wx();
            if (Wx == null) {
                this.bFQ = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bFQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && Wx.get(next.getGroupId()) != null) {
                    if (Wx.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bFT = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                WO().mHandler.sendMessageDelayed(WO().mHandler.obtainMessage(3), WO().bFL);
            }
            this.bFQ = null;
        }
    }

    private void WM() {
        if (this.bFP != 0) {
            if (this.bFP == 1) {
                b(0L, 0L, 0L);
            } else {
                WT();
            }
        }
    }

    private void WN() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b WO() {
        b bVar;
        synchronized (b.class) {
            if (bFI == null) {
                bFI = new b();
            }
            bVar = bFI;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bFX);
        n.zP().a(this.oN);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        WP();
    }

    public void WP() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            hD(socketGetMsgStratgy[0] * 1000);
            hE(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        WW();
    }

    public void stop() {
        WW();
        WN();
    }

    public void WQ() {
        this.bFL = this.bFK;
    }

    public void WR() {
        WO().bFL = WO().bFJ;
    }

    public void hD(int i) {
        if (i > 0) {
            this.bFK = i;
        }
    }

    public void hE(int i) {
        if (i > 0) {
            this.bFJ = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void WS() {
        if (System.currentTimeMillis() - this.bFS >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bFR);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.jA().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.jA().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bFS = System.currentTimeMillis();
            this.bFR = 0;
            com.baidu.adp.lib.webSocket.h.jA().jG();
            com.baidu.adp.lib.webSocket.h.jA().jF();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(SparseArray<Long> sparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.Wn().Wx());
        }
        messageSyncMessage.setForTimer(this.bFW);
        LocalViewSize.ImageSize ud = LocalViewSize.ub().ud();
        if (ud != null) {
            messageSyncMessage.setWidth(ud.width);
            messageSyncMessage.setHeight(ud.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.ub().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String VU = com.baidu.tieba.im.a.c.VX().VU();
        if (VU == null) {
            VU = "0";
        }
        messageSyncMessage.setNotifyMaxTime(VU);
        String VV = com.baidu.tieba.im.a.c.VX().VV();
        if (VV == null) {
            VV = "0";
        }
        messageSyncMessage.setNotifyMinTime(VV);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.VX().Wc()));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.bFR++;
        this.bFW = false;
        this.bFT = 1;
        this.mHandler.removeMessages(3);
        WO().mHandler.sendMessageDelayed(WO().mHandler.obtainMessage(3), WO().bFL);
        if (this.bFU == null) {
            this.bFU = new SparseArray<>();
            this.bFU.clear();
        }
        if (this.bFV == null) {
            this.bFV = new SparseArray<>();
        }
        SparseArray<Long> Wx = com.baidu.tieba.im.memorycache.b.Wn().Wx();
        if (0 != j) {
            Long l = Wx.get((int) j);
            Long l2 = this.bFU.get((int) j);
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
                this.bFU.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.bFU != null && this.bFU.size() > 0) {
            for (int i = 0; i < this.bFU.size(); i++) {
                int keyAt = this.bFU.keyAt(i);
                Long l3 = Wx.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.bFU.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.bFV.get((int) j) == null) {
                    this.bFV.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.bFV.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.bFV.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.bFU.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.bFU.keyAt(i2);
                long longValue3 = this.bFU.valueAt(i2).longValue();
                long j4 = 0;
                if (this.bFV.get(keyAt2) != null) {
                    j4 = this.bFV.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.bFU.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.bFU.size() == 0) {
            WW();
            this.bFV.clear();
        } else {
            a(this.bFU, 1);
        }
    }

    public synchronized void WT() {
        hF(2);
    }

    public synchronized void WU() {
        hF(3);
    }

    public void WV() {
        WM();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bFW = false;
                this.bFT = 4;
                this.mHandler.removeMessages(3);
                WO().mHandler.sendMessageDelayed(WO().mHandler.obtainMessage(3), WO().bFL);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void hF(int i) {
        this.bFW = true;
        this.bFT = i;
        a((SparseArray<Long>) null, i);
    }

    private void hG(int i) {
        if (i == 1) {
            if (this.bFP != 2) {
                this.bFP = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bFP = 2;
        }
    }

    private void WW() {
        this.bFP = 0;
    }
}
