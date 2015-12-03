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
    private static b bUP;
    private List<GroupUpdateMessage> bUX;
    private boolean bVd;
    private int bUQ = 900000;
    private int bUR = 360000;
    private int bUS = this.bUR;
    private final int bUT = 0;
    private final int bUU = 1;
    private final int bUV = 2;
    private int bUW = 0;
    private int bUY = 0;
    private long bUZ = 0;
    private int bVa = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> bVb = null;
    private SparseArray<Long> bVc = null;
    private final com.baidu.adp.framework.client.socket.link.e oO = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener bVe = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        bUP = null;
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
                    b.ZU().mHandler.removeMessages(2);
                    b.ZU().ZZ();
                    return;
                case 3:
                    b.ZU().mHandler.removeMessages(3);
                    if (b.ZU().bVa == 3) {
                        b.ZU().aaa();
                    } else {
                        b.ZU().ZZ();
                    }
                    b.ZU().mHandler.sendMessageDelayed(b.ZU().mHandler.obtainMessage(3), b.ZU().bUS);
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
            iu(i);
            return;
        }
        aac();
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
            if (this.bVb != null) {
                this.bVb.clear();
            }
            if (this.bVc != null) {
                this.bVc.clear();
            }
        }
    }

    public void ZR() {
        boolean z;
        if (this.bUX != null) {
            SparseArray<Long> ZD = com.baidu.tieba.im.memorycache.b.Zt().ZD();
            if (ZD == null) {
                this.bUX = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bUX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && ZD.get(next.getGroupId()) != null) {
                    if (ZD.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bVa = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                ZU().mHandler.sendMessageDelayed(ZU().mHandler.obtainMessage(3), ZU().bUS);
            }
            this.bUX = null;
        }
    }

    private void ZS() {
        if (this.bUW != 0) {
            if (this.bUW == 1) {
                b(0L, 0L, 0L);
            } else {
                ZZ();
            }
        }
    }

    private void ZT() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b ZU() {
        b bVar;
        synchronized (b.class) {
            if (bUP == null) {
                bUP = new b();
            }
            bVar = bUP;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bVe);
        n.AL().a(this.oO);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        ZV();
    }

    public void ZV() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            ir(socketGetMsgStratgy[0] * 1000);
            is(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aac();
    }

    public void stop() {
        aac();
        ZT();
    }

    public void ZW() {
        this.bUS = this.bUR;
    }

    public void ZX() {
        ZU().bUS = ZU().bUQ;
    }

    public void ir(int i) {
        if (i > 0) {
            this.bUR = i;
        }
    }

    public void is(int i) {
        if (i > 0) {
            this.bUQ = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ZY() {
        if (System.currentTimeMillis() - this.bUZ >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bUY);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.jB().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.jB().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bUZ = System.currentTimeMillis();
            this.bUY = 0;
            com.baidu.adp.lib.webSocket.h.jB().jH();
            com.baidu.adp.lib.webSocket.h.jB().jG();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(SparseArray<Long> sparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.Zt().ZD());
        }
        messageSyncMessage.setForTimer(this.bVd);
        LocalViewSize.ImageSize uI = LocalViewSize.uG().uI();
        if (uI != null) {
            messageSyncMessage.setWidth(uI.width);
            messageSyncMessage.setHeight(uI.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.uG().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String Za = com.baidu.tieba.im.a.c.Zd().Za();
        if (Za == null) {
            Za = "0";
        }
        messageSyncMessage.setNotifyMaxTime(Za);
        String Zb = com.baidu.tieba.im.a.c.Zd().Zb();
        if (Zb == null) {
            Zb = "0";
        }
        messageSyncMessage.setNotifyMinTime(Zb);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.Zd().Zi()));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.bUY++;
        this.bVd = false;
        this.bVa = 1;
        this.mHandler.removeMessages(3);
        ZU().mHandler.sendMessageDelayed(ZU().mHandler.obtainMessage(3), ZU().bUS);
        if (this.bVb == null) {
            this.bVb = new SparseArray<>();
            this.bVb.clear();
        }
        if (this.bVc == null) {
            this.bVc = new SparseArray<>();
        }
        SparseArray<Long> ZD = com.baidu.tieba.im.memorycache.b.Zt().ZD();
        if (0 != j) {
            Long l = ZD.get((int) j);
            Long l2 = this.bVb.get((int) j);
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
                this.bVb.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.bVb != null && this.bVb.size() > 0) {
            for (int i = 0; i < this.bVb.size(); i++) {
                int keyAt = this.bVb.keyAt(i);
                Long l3 = ZD.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.bVb.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.bVc.get((int) j) == null) {
                    this.bVc.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.bVc.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.bVc.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.bVb.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.bVb.keyAt(i2);
                long longValue3 = this.bVb.valueAt(i2).longValue();
                long j4 = 0;
                if (this.bVc.get(keyAt2) != null) {
                    j4 = this.bVc.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.bVb.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.bVb.size() == 0) {
            aac();
            this.bVc.clear();
        } else {
            a(this.bVb, 1);
        }
    }

    public synchronized void ZZ() {
        it(2);
    }

    public synchronized void aaa() {
        it(3);
    }

    public void aab() {
        ZS();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bVd = false;
                this.bVa = 4;
                this.mHandler.removeMessages(3);
                ZU().mHandler.sendMessageDelayed(ZU().mHandler.obtainMessage(3), ZU().bUS);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void it(int i) {
        this.bVd = true;
        this.bVa = i;
        a((SparseArray<Long>) null, i);
    }

    private void iu(int i) {
        if (i == 1) {
            if (this.bUW != 2) {
                this.bUW = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bUW = 2;
        }
    }

    private void aac() {
        this.bUW = 0;
    }
}
