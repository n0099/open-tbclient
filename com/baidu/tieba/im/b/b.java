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
    private static b djO;
    private List<GroupUpdateMessage> djW;
    private boolean dkc;
    private int djP = 900000;
    private int djQ = 360000;
    private int djR = this.djQ;
    private final int djS = 0;
    private final int djT = 1;
    private final int djU = 2;
    private int djV = 0;
    private int djX = 0;
    private long djY = 0;
    private int djZ = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> dka = null;
    private SparseArray<Long> dkb = null;
    private final com.baidu.adp.framework.client.socket.link.e hz = new e(this);
    private final com.baidu.adp.framework.listener.e cjN = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener dkd = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        djO = null;
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
                    b.avO().mHandler.removeMessages(2);
                    b.avO().avT();
                    return;
                case 3:
                    b.avO().mHandler.removeMessages(3);
                    if (b.avO().djZ == 3) {
                        b.avO().avU();
                    } else {
                        b.avO().avT();
                    }
                    b.avO().mHandler.sendMessageDelayed(b.avO().mHandler.obtainMessage(3), b.avO().djR);
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
            lT(i);
            return;
        }
        avW();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.avm().avx());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dka != null) {
                this.dka.clear();
            }
            if (this.dkb != null) {
                this.dkb.clear();
            }
        }
    }

    public void avL() {
        boolean z;
        if (this.djW != null) {
            SparseArray<Long> avw = com.baidu.tieba.im.memorycache.b.avm().avw();
            if (avw == null) {
                this.djW = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.djW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && avw.get(next.getGroupId()) != null) {
                    if (avw.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.djZ = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                avO().mHandler.sendMessageDelayed(avO().mHandler.obtainMessage(3), avO().djR);
            }
            this.djW = null;
        }
    }

    private void avM() {
        if (this.djV != 0) {
            if (this.djV == 1) {
                a(0L, 0L, 0L);
            } else {
                avT();
            }
        }
    }

    private void avN() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b avO() {
        b bVar;
        synchronized (b.class) {
            if (djO == null) {
                djO = new b();
            }
            bVar = djO;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dkd);
        n.BN().a(this.hz);
        MessageManager.getInstance().registerListener(1003, this.cjN);
        MessageManager.getInstance().registerListener(1001, this.cjN);
        MessageManager.getInstance().registerListener(202101, this.cjN);
        avP();
    }

    public void avP() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lQ(socketGetMsgStratgy[0] * 1000);
            lR(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        avW();
    }

    public void stop() {
        avW();
        avN();
    }

    public void avQ() {
        this.djR = this.djQ;
    }

    public void avR() {
        avO().djR = avO().djP;
    }

    public void lQ(int i) {
        if (i > 0) {
            this.djQ = i;
        }
    }

    public void lR(int i) {
        if (i > 0) {
            this.djP = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void avS() {
        if (System.currentTimeMillis() - this.djY >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.djX);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ha().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ha().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.djY = System.currentTimeMillis();
            this.djX = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.avm().avw());
        }
        messageSyncMessage.setForTimer(this.dkc);
        LocalViewSize.ImageSize uO = LocalViewSize.uL().uO();
        if (uO != null) {
            messageSyncMessage.setWidth(uO.width);
            messageSyncMessage.setHeight(uO.height);
        }
        LocalViewSize.ImageSize uN = LocalViewSize.uL().uN();
        if (uN != null) {
            messageSyncMessage.setSmallHeight(uN.height);
            messageSyncMessage.setSmallWidth(uN.width);
        }
        String auS = com.baidu.tieba.im.a.c.auV().auS();
        if (auS == null) {
            auS = "0";
        }
        messageSyncMessage.setNotifyMaxTime(auS);
        String auT = com.baidu.tieba.im.a.c.auV().auT();
        if (auT == null) {
            auT = "0";
        }
        messageSyncMessage.setNotifyMinTime(auT);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.auV().ava()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.djX++;
        this.dkc = false;
        this.djZ = 1;
        this.mHandler.removeMessages(3);
        avO().mHandler.sendMessageDelayed(avO().mHandler.obtainMessage(3), avO().djR);
        if (this.dka == null) {
            this.dka = new SparseArray<>();
            this.dka.clear();
        }
        if (this.dkb == null) {
            this.dkb = new SparseArray<>();
        }
        SparseArray<Long> avw = com.baidu.tieba.im.memorycache.b.avm().avw();
        if (0 != j) {
            Long l = avw.get((int) j);
            Long l2 = this.dka.get((int) j);
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
                this.dka.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dka != null && this.dka.size() > 0) {
            for (int i = 0; i < this.dka.size(); i++) {
                int keyAt = this.dka.keyAt(i);
                Long l3 = avw.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dka.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dkb.get((int) j) == null) {
                    this.dkb.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dkb.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dkb.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dka.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dka.keyAt(i2);
                long longValue3 = this.dka.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dkb.get(keyAt2) != null) {
                    j4 = this.dkb.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dka.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dka.size() == 0) {
            avW();
            this.dkb.clear();
        } else {
            a(this.dka, 1);
        }
    }

    public synchronized void avT() {
        lS(2);
    }

    public synchronized void avU() {
        lS(3);
    }

    public void avV() {
        avM();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dkc = false;
                this.djZ = 4;
                this.mHandler.removeMessages(3);
                avO().mHandler.sendMessageDelayed(avO().mHandler.obtainMessage(3), avO().djR);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lS(int i) {
        this.dkc = true;
        this.djZ = i;
        a((SparseArray<Long>) null, i);
    }

    private void lT(int i) {
        if (i == 1) {
            if (this.djV != 2) {
                this.djV = 1;
            }
        } else if (i == 3 || i == 2) {
            this.djV = 2;
        }
    }

    private void avW() {
        this.djV = 0;
    }
}
