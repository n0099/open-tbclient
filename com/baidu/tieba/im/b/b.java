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
    private static b cUs;
    private List<GroupUpdateMessage> cUA;
    private boolean cUG;
    private int cUt = 900000;
    private int cUu = 360000;
    private int cUv = this.cUu;
    private final int cUw = 0;
    private final int cUx = 1;
    private final int cUy = 2;
    private int cUz = 0;
    private int cUB = 0;
    private long cUC = 0;
    private int cUD = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> cUE = null;
    private SparseArray<Long> cUF = null;
    private final com.baidu.adp.framework.client.socket.link.e hA = new e(this);
    private final com.baidu.adp.framework.listener.e bUf = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener cUH = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        cUs = null;
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
                    b.ask().mHandler.removeMessages(2);
                    b.ask().asp();
                    return;
                case 3:
                    b.ask().mHandler.removeMessages(3);
                    if (b.ask().cUD == 3) {
                        b.ask().asq();
                    } else {
                        b.ask().asp();
                    }
                    b.ask().mHandler.sendMessageDelayed(b.ask().mHandler.obtainMessage(3), b.ask().cUv);
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
            ll(i);
            return;
        }
        ass();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.arI().arT());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.cUE != null) {
                this.cUE.clear();
            }
            if (this.cUF != null) {
                this.cUF.clear();
            }
        }
    }

    public void ash() {
        boolean z;
        if (this.cUA != null) {
            SparseArray<Long> arS = com.baidu.tieba.im.memorycache.b.arI().arS();
            if (arS == null) {
                this.cUA = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.cUA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && arS.get(next.getGroupId()) != null) {
                    if (arS.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.cUD = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                ask().mHandler.sendMessageDelayed(ask().mHandler.obtainMessage(3), ask().cUv);
            }
            this.cUA = null;
        }
    }

    private void asi() {
        if (this.cUz != 0) {
            if (this.cUz == 1) {
                a(0L, 0L, 0L);
            } else {
                asp();
            }
        }
    }

    private void asj() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b ask() {
        b bVar;
        synchronized (b.class) {
            if (cUs == null) {
                cUs = new b();
            }
            bVar = cUs;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.cUH);
        n.BH().a(this.hA);
        MessageManager.getInstance().registerListener(1003, this.bUf);
        MessageManager.getInstance().registerListener(1001, this.bUf);
        MessageManager.getInstance().registerListener(202101, this.bUf);
        asl();
    }

    public void asl() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            li(socketGetMsgStratgy[0] * 1000);
            lj(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        ass();
    }

    public void stop() {
        ass();
        asj();
    }

    public void asm() {
        this.cUv = this.cUu;
    }

    public void asn() {
        ask().cUv = ask().cUt;
    }

    public void li(int i) {
        if (i > 0) {
            this.cUu = i;
        }
    }

    public void lj(int i) {
        if (i > 0) {
            this.cUt = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aso() {
        if (System.currentTimeMillis() - this.cUC >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.cUB);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ha().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ha().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.cUC = System.currentTimeMillis();
            this.cUB = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.arI().arS());
        }
        messageSyncMessage.setForTimer(this.cUG);
        LocalViewSize.ImageSize uE = LocalViewSize.uB().uE();
        if (uE != null) {
            messageSyncMessage.setWidth(uE.width);
            messageSyncMessage.setHeight(uE.height);
        }
        LocalViewSize.ImageSize uD = LocalViewSize.uB().uD();
        if (uD != null) {
            messageSyncMessage.setSmallHeight(uD.height);
            messageSyncMessage.setSmallWidth(uD.width);
        }
        String aro = com.baidu.tieba.im.a.c.arr().aro();
        if (aro == null) {
            aro = "0";
        }
        messageSyncMessage.setNotifyMaxTime(aro);
        String arp = com.baidu.tieba.im.a.c.arr().arp();
        if (arp == null) {
            arp = "0";
        }
        messageSyncMessage.setNotifyMinTime(arp);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.arr().arw()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.cUB++;
        this.cUG = false;
        this.cUD = 1;
        this.mHandler.removeMessages(3);
        ask().mHandler.sendMessageDelayed(ask().mHandler.obtainMessage(3), ask().cUv);
        if (this.cUE == null) {
            this.cUE = new SparseArray<>();
            this.cUE.clear();
        }
        if (this.cUF == null) {
            this.cUF = new SparseArray<>();
        }
        SparseArray<Long> arS = com.baidu.tieba.im.memorycache.b.arI().arS();
        if (0 != j) {
            Long l = arS.get((int) j);
            Long l2 = this.cUE.get((int) j);
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
                this.cUE.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.cUE != null && this.cUE.size() > 0) {
            for (int i = 0; i < this.cUE.size(); i++) {
                int keyAt = this.cUE.keyAt(i);
                Long l3 = arS.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.cUE.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.cUF.get((int) j) == null) {
                    this.cUF.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.cUF.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.cUF.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.cUE.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.cUE.keyAt(i2);
                long longValue3 = this.cUE.valueAt(i2).longValue();
                long j4 = 0;
                if (this.cUF.get(keyAt2) != null) {
                    j4 = this.cUF.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.cUE.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.cUE.size() == 0) {
            ass();
            this.cUF.clear();
        } else {
            a(this.cUE, 1);
        }
    }

    public synchronized void asp() {
        lk(2);
    }

    public synchronized void asq() {
        lk(3);
    }

    public void asr() {
        asi();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.cUG = false;
                this.cUD = 4;
                this.mHandler.removeMessages(3);
                ask().mHandler.sendMessageDelayed(ask().mHandler.obtainMessage(3), ask().cUv);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lk(int i) {
        this.cUG = true;
        this.cUD = i;
        a((SparseArray<Long>) null, i);
    }

    private void ll(int i) {
        if (i == 1) {
            if (this.cUz != 2) {
                this.cUz = 1;
            }
        } else if (i == 3 || i == 2) {
            this.cUz = 2;
        }
    }

    private void ass() {
        this.cUz = 0;
    }
}
