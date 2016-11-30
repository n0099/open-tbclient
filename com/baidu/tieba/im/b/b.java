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
    private static b dpy;
    private List<GroupUpdateMessage> dpG;
    private boolean dpM;
    private int dpz = 900000;
    private int dpA = 360000;
    private int dpB = this.dpA;
    private final int dpC = 0;
    private final int dpD = 1;
    private final int dpE = 2;
    private int dpF = 0;
    private int dpH = 0;
    private long dpI = 0;
    private int dpJ = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> dpK = null;
    private SparseArray<Long> dpL = null;
    private final com.baidu.adp.framework.client.socket.link.e hA = new e(this);
    private final com.baidu.adp.framework.listener.e coV = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener dpN = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        dpy = null;
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
                    b.axL().mHandler.removeMessages(2);
                    b.axL().axQ();
                    return;
                case 3:
                    b.axL().mHandler.removeMessages(3);
                    if (b.axL().dpJ == 3) {
                        b.axL().axR();
                    } else {
                        b.axL().axQ();
                    }
                    b.axL().mHandler.sendMessageDelayed(b.axL().mHandler.obtainMessage(3), b.axL().dpB);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().bM() > 10) {
            w.b(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int O = MessageManager.getInstance().getSocketClient().O(202003);
        if (a2 || O > 0) {
            w.b(false, false, true);
            mb(i);
            return;
        }
        axT();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.axj().axu());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dpK != null) {
                this.dpK.clear();
            }
            if (this.dpL != null) {
                this.dpL.clear();
            }
        }
    }

    public void axI() {
        boolean z;
        if (this.dpG != null) {
            SparseArray<Long> axt = com.baidu.tieba.im.memorycache.b.axj().axt();
            if (axt == null) {
                this.dpG = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dpG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && axt.get(next.getGroupId()) != null) {
                    if (axt.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dpJ = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                axL().mHandler.sendMessageDelayed(axL().mHandler.obtainMessage(3), axL().dpB);
            }
            this.dpG = null;
        }
    }

    private void axJ() {
        if (this.dpF != 0) {
            if (this.dpF == 1) {
                a(0L, 0L, 0L);
            } else {
                axQ();
            }
        }
    }

    private void axK() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b axL() {
        b bVar;
        synchronized (b.class) {
            if (dpy == null) {
                dpy = new b();
            }
            bVar = dpy;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dpN);
        n.BU().a(this.hA);
        MessageManager.getInstance().registerListener(1003, this.coV);
        MessageManager.getInstance().registerListener(1001, this.coV);
        MessageManager.getInstance().registerListener(202101, this.coV);
        axM();
    }

    public void axM() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lY(socketGetMsgStratgy[0] * 1000);
            lZ(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        axT();
    }

    public void stop() {
        axT();
        axK();
    }

    public void axN() {
        this.dpB = this.dpA;
    }

    public void axO() {
        axL().dpB = axL().dpz;
    }

    public void lY(int i) {
        if (i > 0) {
            this.dpA = i;
        }
    }

    public void lZ(int i) {
        if (i > 0) {
            this.dpz = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void axP() {
        if (System.currentTimeMillis() - this.dpI >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dpH);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ha().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ha().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dpI = System.currentTimeMillis();
            this.dpH = 0;
            com.baidu.adp.lib.webSocket.h.ha().hh();
            com.baidu.adp.lib.webSocket.h.ha().hg();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.axj().axt());
        }
        messageSyncMessage.setForTimer(this.dpM);
        LocalViewSize.ImageSize uS = LocalViewSize.uP().uS();
        if (uS != null) {
            messageSyncMessage.setWidth(uS.width);
            messageSyncMessage.setHeight(uS.height);
        }
        LocalViewSize.ImageSize uR = LocalViewSize.uP().uR();
        if (uR != null) {
            messageSyncMessage.setSmallHeight(uR.height);
            messageSyncMessage.setSmallWidth(uR.width);
        }
        String awP = com.baidu.tieba.im.a.c.awS().awP();
        if (awP == null) {
            awP = "0";
        }
        messageSyncMessage.setNotifyMaxTime(awP);
        String awQ = com.baidu.tieba.im.a.c.awS().awQ();
        if (awQ == null) {
            awQ = "0";
        }
        messageSyncMessage.setNotifyMinTime(awQ);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.awS().awX()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dpH++;
        this.dpM = false;
        this.dpJ = 1;
        this.mHandler.removeMessages(3);
        axL().mHandler.sendMessageDelayed(axL().mHandler.obtainMessage(3), axL().dpB);
        if (this.dpK == null) {
            this.dpK = new SparseArray<>();
            this.dpK.clear();
        }
        if (this.dpL == null) {
            this.dpL = new SparseArray<>();
        }
        SparseArray<Long> axt = com.baidu.tieba.im.memorycache.b.axj().axt();
        if (0 != j) {
            Long l = axt.get((int) j);
            Long l2 = this.dpK.get((int) j);
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
                this.dpK.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dpK != null && this.dpK.size() > 0) {
            for (int i = 0; i < this.dpK.size(); i++) {
                int keyAt = this.dpK.keyAt(i);
                Long l3 = axt.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dpK.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dpL.get((int) j) == null) {
                    this.dpL.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dpL.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dpL.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dpK.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dpK.keyAt(i2);
                long longValue3 = this.dpK.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dpL.get(keyAt2) != null) {
                    j4 = this.dpL.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dpK.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dpK.size() == 0) {
            axT();
            this.dpL.clear();
        } else {
            a(this.dpK, 1);
        }
    }

    public synchronized void axQ() {
        ma(2);
    }

    public synchronized void axR() {
        ma(3);
    }

    public void axS() {
        axJ();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dpM = false;
                this.dpJ = 4;
                this.mHandler.removeMessages(3);
                axL().mHandler.sendMessageDelayed(axL().mHandler.obtainMessage(3), axL().dpB);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void ma(int i) {
        this.dpM = true;
        this.dpJ = i;
        a((SparseArray<Long>) null, i);
    }

    private void mb(int i) {
        if (i == 1) {
            if (this.dpF != 2) {
                this.dpF = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dpF = 2;
        }
    }

    private void axT() {
        this.dpF = 0;
    }
}
