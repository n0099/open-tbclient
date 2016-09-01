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
    private static b dir;
    private boolean diF;
    private List<GroupUpdateMessage> diz;
    private int dis = 900000;
    private int dit = 360000;
    private int diu = this.dit;
    private final int div = 0;
    private final int diw = 1;
    private final int dix = 2;
    private int diy = 0;
    private int diA = 0;
    private long diB = 0;
    private int diC = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> diD = null;
    private SparseArray<Long> diE = null;
    private final com.baidu.adp.framework.client.socket.link.e hz = new e(this);
    private final com.baidu.adp.framework.listener.e cjp = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener diG = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        dir = null;
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
                    b.avp().mHandler.removeMessages(2);
                    b.avp().avu();
                    return;
                case 3:
                    b.avp().mHandler.removeMessages(3);
                    if (b.avp().diC == 3) {
                        b.avp().avv();
                    } else {
                        b.avp().avu();
                    }
                    b.avp().mHandler.sendMessageDelayed(b.avp().mHandler.obtainMessage(3), b.avp().diu);
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
            lL(i);
            return;
        }
        avx();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.auN().auY());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.diD != null) {
                this.diD.clear();
            }
            if (this.diE != null) {
                this.diE.clear();
            }
        }
    }

    public void avm() {
        boolean z;
        if (this.diz != null) {
            SparseArray<Long> auX = com.baidu.tieba.im.memorycache.b.auN().auX();
            if (auX == null) {
                this.diz = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.diz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && auX.get(next.getGroupId()) != null) {
                    if (auX.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.diC = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                avp().mHandler.sendMessageDelayed(avp().mHandler.obtainMessage(3), avp().diu);
            }
            this.diz = null;
        }
    }

    private void avn() {
        if (this.diy != 0) {
            if (this.diy == 1) {
                a(0L, 0L, 0L);
            } else {
                avu();
            }
        }
    }

    private void avo() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b avp() {
        b bVar;
        synchronized (b.class) {
            if (dir == null) {
                dir = new b();
            }
            bVar = dir;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.diG);
        n.BJ().a(this.hz);
        MessageManager.getInstance().registerListener(1003, this.cjp);
        MessageManager.getInstance().registerListener(1001, this.cjp);
        MessageManager.getInstance().registerListener(202101, this.cjp);
        avq();
    }

    public void avq() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lI(socketGetMsgStratgy[0] * 1000);
            lJ(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        avx();
    }

    public void stop() {
        avx();
        avo();
    }

    public void avr() {
        this.diu = this.dit;
    }

    public void avs() {
        avp().diu = avp().dis;
    }

    public void lI(int i) {
        if (i > 0) {
            this.dit = i;
        }
    }

    public void lJ(int i) {
        if (i > 0) {
            this.dis = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void avt() {
        if (System.currentTimeMillis() - this.diB >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.diA);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ha().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ha().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.diB = System.currentTimeMillis();
            this.diA = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.auN().auX());
        }
        messageSyncMessage.setForTimer(this.diF);
        LocalViewSize.ImageSize uz = LocalViewSize.uw().uz();
        if (uz != null) {
            messageSyncMessage.setWidth(uz.width);
            messageSyncMessage.setHeight(uz.height);
        }
        LocalViewSize.ImageSize uy = LocalViewSize.uw().uy();
        if (uy != null) {
            messageSyncMessage.setSmallHeight(uy.height);
            messageSyncMessage.setSmallWidth(uy.width);
        }
        String aut = com.baidu.tieba.im.a.c.auw().aut();
        if (aut == null) {
            aut = "0";
        }
        messageSyncMessage.setNotifyMaxTime(aut);
        String auu = com.baidu.tieba.im.a.c.auw().auu();
        if (auu == null) {
            auu = "0";
        }
        messageSyncMessage.setNotifyMinTime(auu);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.auw().auB()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.diA++;
        this.diF = false;
        this.diC = 1;
        this.mHandler.removeMessages(3);
        avp().mHandler.sendMessageDelayed(avp().mHandler.obtainMessage(3), avp().diu);
        if (this.diD == null) {
            this.diD = new SparseArray<>();
            this.diD.clear();
        }
        if (this.diE == null) {
            this.diE = new SparseArray<>();
        }
        SparseArray<Long> auX = com.baidu.tieba.im.memorycache.b.auN().auX();
        if (0 != j) {
            Long l = auX.get((int) j);
            Long l2 = this.diD.get((int) j);
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
                this.diD.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.diD != null && this.diD.size() > 0) {
            for (int i = 0; i < this.diD.size(); i++) {
                int keyAt = this.diD.keyAt(i);
                Long l3 = auX.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.diD.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.diE.get((int) j) == null) {
                    this.diE.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.diE.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.diE.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.diD.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.diD.keyAt(i2);
                long longValue3 = this.diD.valueAt(i2).longValue();
                long j4 = 0;
                if (this.diE.get(keyAt2) != null) {
                    j4 = this.diE.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.diD.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.diD.size() == 0) {
            avx();
            this.diE.clear();
        } else {
            a(this.diD, 1);
        }
    }

    public synchronized void avu() {
        lK(2);
    }

    public synchronized void avv() {
        lK(3);
    }

    public void avw() {
        avn();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.diF = false;
                this.diC = 4;
                this.mHandler.removeMessages(3);
                avp().mHandler.sendMessageDelayed(avp().mHandler.obtainMessage(3), avp().diu);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lK(int i) {
        this.diF = true;
        this.diC = i;
        a((SparseArray<Long>) null, i);
    }

    private void lL(int i) {
        if (i == 1) {
            if (this.diy != 2) {
                this.diy = 1;
            }
        } else if (i == 3 || i == 2) {
            this.diy = 2;
        }
    }

    private void avx() {
        this.diy = 0;
    }
}
