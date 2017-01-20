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
    private static b dbC;
    private List<GroupUpdateMessage> dbK;
    private boolean dbQ;
    private int dbD = 900000;
    private int dbE = 360000;
    private int dbF = this.dbE;
    private final int dbG = 0;
    private final int dbH = 1;
    private final int dbI = 2;
    private int dbJ = 0;
    private int dbL = 0;
    private long dbM = 0;
    private int dbN = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> dbO = null;
    private SparseArray<Long> dbP = null;
    private final com.baidu.adp.framework.client.socket.link.e hx = new e(this);
    private final com.baidu.adp.framework.listener.e caD = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener dbR = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        dbC = null;
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
                    b.atq().mHandler.removeMessages(2);
                    b.atq().atv();
                    return;
                case 3:
                    b.atq().mHandler.removeMessages(3);
                    if (b.atq().dbN == 3) {
                        b.atq().atw();
                    } else {
                        b.atq().atv();
                    }
                    b.atq().mHandler.sendMessageDelayed(b.atq().mHandler.obtainMessage(3), b.atq().dbF);
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
        int P = MessageManager.getInstance().getSocketClient().P(202003);
        if (a2 || P > 0) {
            w.b(false, false, true);
            lY(i);
            return;
        }
        aty();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.asO().asZ());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dbO != null) {
                this.dbO.clear();
            }
            if (this.dbP != null) {
                this.dbP.clear();
            }
        }
    }

    public void atn() {
        boolean z;
        if (this.dbK != null) {
            SparseArray<Long> asY = com.baidu.tieba.im.memorycache.b.asO().asY();
            if (asY == null) {
                this.dbK = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dbK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && asY.get(next.getGroupId()) != null) {
                    if (asY.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dbN = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                atq().mHandler.sendMessageDelayed(atq().mHandler.obtainMessage(3), atq().dbF);
            }
            this.dbK = null;
        }
    }

    private void ato() {
        if (this.dbJ != 0) {
            if (this.dbJ == 1) {
                a(0L, 0L, 0L);
            } else {
                atv();
            }
        }
    }

    private void atp() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b atq() {
        b bVar;
        synchronized (b.class) {
            if (dbC == null) {
                dbC = new b();
            }
            bVar = dbC;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dbR);
        n.BC().a(this.hx);
        MessageManager.getInstance().registerListener(1003, this.caD);
        MessageManager.getInstance().registerListener(1001, this.caD);
        MessageManager.getInstance().registerListener(202101, this.caD);
        atr();
    }

    public void atr() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lV(socketGetMsgStratgy[0] * 1000);
            lW(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aty();
    }

    public void stop() {
        aty();
        atp();
    }

    public void ats() {
        this.dbF = this.dbE;
    }

    public void att() {
        atq().dbF = atq().dbD;
    }

    public void lV(int i) {
        if (i > 0) {
            this.dbE = i;
        }
    }

    public void lW(int i) {
        if (i > 0) {
            this.dbD = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void atu() {
        if (System.currentTimeMillis() - this.dbM >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dbL);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.gY().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.gY().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dbM = System.currentTimeMillis();
            this.dbL = 0;
            com.baidu.adp.lib.webSocket.h.gY().hf();
            com.baidu.adp.lib.webSocket.h.gY().he();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.asO().asY());
        }
        messageSyncMessage.setForTimer(this.dbQ);
        LocalViewSize.ImageSize uy = LocalViewSize.uv().uy();
        if (uy != null) {
            messageSyncMessage.setWidth(uy.width);
            messageSyncMessage.setHeight(uy.height);
        }
        LocalViewSize.ImageSize ux = LocalViewSize.uv().ux();
        if (ux != null) {
            messageSyncMessage.setSmallHeight(ux.height);
            messageSyncMessage.setSmallWidth(ux.width);
        }
        String asu = com.baidu.tieba.im.a.c.asx().asu();
        if (asu == null) {
            asu = "0";
        }
        messageSyncMessage.setNotifyMaxTime(asu);
        String asv = com.baidu.tieba.im.a.c.asx().asv();
        if (asv == null) {
            asv = "0";
        }
        messageSyncMessage.setNotifyMinTime(asv);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.asx().asC()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dbL++;
        this.dbQ = false;
        this.dbN = 1;
        this.mHandler.removeMessages(3);
        atq().mHandler.sendMessageDelayed(atq().mHandler.obtainMessage(3), atq().dbF);
        if (this.dbO == null) {
            this.dbO = new SparseArray<>();
            this.dbO.clear();
        }
        if (this.dbP == null) {
            this.dbP = new SparseArray<>();
        }
        SparseArray<Long> asY = com.baidu.tieba.im.memorycache.b.asO().asY();
        if (0 != j) {
            Long l = asY.get((int) j);
            Long l2 = this.dbO.get((int) j);
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
                this.dbO.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dbO != null && this.dbO.size() > 0) {
            for (int i = 0; i < this.dbO.size(); i++) {
                int keyAt = this.dbO.keyAt(i);
                Long l3 = asY.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dbO.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dbP.get((int) j) == null) {
                    this.dbP.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dbP.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dbP.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dbO.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dbO.keyAt(i2);
                long longValue3 = this.dbO.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dbP.get(keyAt2) != null) {
                    j4 = this.dbP.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dbO.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dbO.size() == 0) {
            aty();
            this.dbP.clear();
        } else {
            a(this.dbO, 1);
        }
    }

    public synchronized void atv() {
        lX(2);
    }

    public synchronized void atw() {
        lX(3);
    }

    public void atx() {
        ato();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dbQ = false;
                this.dbN = 4;
                this.mHandler.removeMessages(3);
                atq().mHandler.sendMessageDelayed(atq().mHandler.obtainMessage(3), atq().dbF);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lX(int i) {
        this.dbQ = true;
        this.dbN = i;
        a((SparseArray<Long>) null, i);
    }

    private void lY(int i) {
        if (i == 1) {
            if (this.dbJ != 2) {
                this.dbJ = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dbJ = 2;
        }
    }

    private void aty() {
        this.dbJ = 0;
    }
}
