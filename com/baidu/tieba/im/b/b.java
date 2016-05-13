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
    private static b cox;
    private List<GroupUpdateMessage> coF;
    private boolean coL;
    private int coy = 900000;
    private int coz = 360000;
    private int coA = this.coz;
    private final int coB = 0;
    private final int coC = 1;
    private final int coD = 2;
    private int coE = 0;
    private int coG = 0;
    private long coH = 0;
    private int coI = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> coJ = null;
    private SparseArray<Long> coK = null;
    private final com.baidu.adp.framework.client.socket.link.e eL = new e(this);
    private final com.baidu.adp.framework.listener.e bfe = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener coM = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        cox = null;
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
                    b.ahC().mHandler.removeMessages(2);
                    b.ahC().ahH();
                    return;
                case 3:
                    b.ahC().mHandler.removeMessages(3);
                    if (b.ahC().coI == 3) {
                        b.ahC().ahI();
                    } else {
                        b.ahC().ahH();
                    }
                    b.ahC().mHandler.sendMessageDelayed(b.ahC().mHandler.obtainMessage(3), b.ahC().coA);
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
            jA(i);
            return;
        }
        ahK();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aha().ahl());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.coJ != null) {
                this.coJ.clear();
            }
            if (this.coK != null) {
                this.coK.clear();
            }
        }
    }

    public void ahz() {
        boolean z;
        if (this.coF != null) {
            SparseArray<Long> ahk = com.baidu.tieba.im.memorycache.b.aha().ahk();
            if (ahk == null) {
                this.coF = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.coF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && ahk.get(next.getGroupId()) != null) {
                    if (ahk.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.coI = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                ahC().mHandler.sendMessageDelayed(ahC().mHandler.obtainMessage(3), ahC().coA);
            }
            this.coF = null;
        }
    }

    private void ahA() {
        if (this.coE != 0) {
            if (this.coE == 1) {
                a(0L, 0L, 0L);
            } else {
                ahH();
            }
        }
    }

    private void ahB() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b ahC() {
        b bVar;
        synchronized (b.class) {
            if (cox == null) {
                cox = new b();
            }
            bVar = cox;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.coM);
        n.Ap().a(this.eL);
        MessageManager.getInstance().registerListener(1003, this.bfe);
        MessageManager.getInstance().registerListener(1001, this.bfe);
        MessageManager.getInstance().registerListener(202101, this.bfe);
        ahD();
    }

    public void ahD() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m11getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            jx(socketGetMsgStratgy[0] * 1000);
            jy(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        ahK();
    }

    public void stop() {
        ahK();
        ahB();
    }

    public void ahE() {
        this.coA = this.coz;
    }

    public void ahF() {
        ahC().coA = ahC().coy;
    }

    public void jx(int i) {
        if (i > 0) {
            this.coz = i;
        }
    }

    public void jy(int i) {
        if (i > 0) {
            this.coy = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ahG() {
        if (System.currentTimeMillis() - this.coH >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.coG);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.gf().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.gf().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m11getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.coH = System.currentTimeMillis();
            this.coG = 0;
            com.baidu.adp.lib.webSocket.h.gf().gl();
            com.baidu.adp.lib.webSocket.h.gf().gk();
            TbadkCoreApplication.m11getInst().clearEnterForeCount();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aha().ahk());
        }
        messageSyncMessage.setForTimer(this.coL);
        LocalViewSize.ImageSize tx = LocalViewSize.tu().tx();
        if (tx != null) {
            messageSyncMessage.setWidth(tx.width);
            messageSyncMessage.setHeight(tx.height);
        }
        LocalViewSize.ImageSize tw = LocalViewSize.tu().tw();
        if (tw != null) {
            messageSyncMessage.setSmallHeight(tw.height);
            messageSyncMessage.setSmallWidth(tw.width);
        }
        String agG = com.baidu.tieba.im.a.c.agJ().agG();
        if (agG == null) {
            agG = "0";
        }
        messageSyncMessage.setNotifyMaxTime(agG);
        String agH = com.baidu.tieba.im.a.c.agJ().agH();
        if (agH == null) {
            agH = "0";
        }
        messageSyncMessage.setNotifyMinTime(agH);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.agJ().agO()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.coG++;
        this.coL = false;
        this.coI = 1;
        this.mHandler.removeMessages(3);
        ahC().mHandler.sendMessageDelayed(ahC().mHandler.obtainMessage(3), ahC().coA);
        if (this.coJ == null) {
            this.coJ = new SparseArray<>();
            this.coJ.clear();
        }
        if (this.coK == null) {
            this.coK = new SparseArray<>();
        }
        SparseArray<Long> ahk = com.baidu.tieba.im.memorycache.b.aha().ahk();
        if (0 != j) {
            Long l = ahk.get((int) j);
            Long l2 = this.coJ.get((int) j);
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
                this.coJ.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.coJ != null && this.coJ.size() > 0) {
            for (int i = 0; i < this.coJ.size(); i++) {
                int keyAt = this.coJ.keyAt(i);
                Long l3 = ahk.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.coJ.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.coK.get((int) j) == null) {
                    this.coK.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.coK.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.coK.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.coJ.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.coJ.keyAt(i2);
                long longValue3 = this.coJ.valueAt(i2).longValue();
                long j4 = 0;
                if (this.coK.get(keyAt2) != null) {
                    j4 = this.coK.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.coJ.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.coJ.size() == 0) {
            ahK();
            this.coK.clear();
        } else {
            a(this.coJ, 1);
        }
    }

    public synchronized void ahH() {
        jz(2);
    }

    public synchronized void ahI() {
        jz(3);
    }

    public void ahJ() {
        ahA();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.coL = false;
                this.coI = 4;
                this.mHandler.removeMessages(3);
                ahC().mHandler.sendMessageDelayed(ahC().mHandler.obtainMessage(3), ahC().coA);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void jz(int i) {
        this.coL = true;
        this.coI = i;
        a((SparseArray<Long>) null, i);
    }

    private void jA(int i) {
        if (i == 1) {
            if (this.coE != 2) {
                this.coE = 1;
            }
        } else if (i == 3 || i == 2) {
            this.coE = 2;
        }
    }

    private void ahK() {
        this.coE = 0;
    }
}
