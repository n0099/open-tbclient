package com.baidu.tieba.im.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.f;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.webSocket.h;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.coreExtra.websocketBase.g;
import com.baidu.tbadk.k.m;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static b eKs;
    private List<GroupUpdateMessage> eKA;
    private boolean eKG;
    private int eKt = 900000;
    private int eKu = 360000;
    private int eKv = this.eKu;
    private final int eKw = 0;
    private final int eKx = 1;
    private final int eKy = 2;
    private int eKz = 0;
    private int eKB = 0;
    private long eKC = 0;
    private int eKD = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> eKE = null;
    private SparseArray<Long> eKF = null;
    private final com.baidu.adp.framework.client.socket.link.a acN = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void d(Map<String, String> map) {
            b.this.start();
            f.ku().c(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void J(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c euP = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aLh();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.eKA = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aKA().aKz()) {
                            b.this.aLa();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.im.a.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    b.this.aLg();
                } else {
                    b.this.aLf();
                }
            }
        }
    };
    private final CustomMessageListener eKH = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.eKE != null) {
                    b.this.eKE.clear();
                }
                if (b.this.eKF != null) {
                    b.this.eKF.clear();
                }
                b.this.eKA = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Kf().Kg();
                    b.aLd().aLe();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aLd().aLa();
                }
            }
        });
        eKs = null;
    }

    /* loaded from: classes.dex */
    private static class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 2:
                    b.aLd().mHandler.removeMessages(2);
                    b.aLd().aLi();
                    return;
                case 3:
                    b.aLd().mHandler.removeMessages(3);
                    if (b.aLd().eKD == 3) {
                        b.aLd().aLj();
                    } else {
                        b.aLd().aLi();
                    }
                    b.aLd().mHandler.sendMessageDelayed(b.aLd().mHandler.obtainMessage(3), b.aLd().eKv);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().kz() > 10) {
            m.e(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int cG = MessageManager.getInstance().getSocketClient().cG(202003);
        if (a2 || cG > 0) {
            m.e(false, false, true);
            qv(i);
            return;
        }
        aLl();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aKA().aKM());
        }
        MessageManager.getInstance().sendMessage(b);
        m.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.eKE != null) {
                this.eKE.clear();
            }
            if (this.eKF != null) {
                this.eKF.clear();
            }
        }
    }

    public void aLa() {
        boolean z;
        if (this.eKA != null) {
            SparseArray<Long> aKL = com.baidu.tieba.im.memorycache.b.aKA().aKL();
            if (aKL == null) {
                this.eKA = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.eKA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aKL.get(next.getGroupId()) != null) {
                    if (aKL.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.eKD = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aLd().mHandler.sendMessageDelayed(aLd().mHandler.obtainMessage(3), aLd().eKv);
            }
            this.eKA = null;
        }
    }

    private void aLb() {
        if (this.eKz != 0) {
            if (this.eKz == 1) {
                c(0L, 0L, 0L);
            } else {
                aLi();
            }
        }
    }

    private void aLc() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aLd() {
        b bVar;
        synchronized (b.class) {
            if (eKs == null) {
                eKs = new b();
            }
            bVar = eKs;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.eKH);
        g.Kn().a(this.acN);
        MessageManager.getInstance().registerListener(1003, this.euP);
        MessageManager.getInstance().registerListener(1001, this.euP);
        MessageManager.getInstance().registerListener(202101, this.euP);
        aLe();
    }

    public void aLe() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            qs(socketGetMsgStratgy[0] * 1000);
            qt(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aLl();
    }

    public void stop() {
        aLl();
        aLc();
    }

    public void aLf() {
        this.eKv = this.eKu;
    }

    public void aLg() {
        aLd().eKv = aLd().eKt;
    }

    public void qs(int i) {
        if (i > 0) {
            this.eKu = i;
        }
    }

    public void qt(int i) {
        if (i > 0) {
            this.eKt = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aLh() {
        if (System.currentTimeMillis() - this.eKC >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eKB);
            pushCountMessage.setUpFlowSize(h.pv().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.pv().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.eKC = System.currentTimeMillis();
            this.eKB = 0;
            h.pv().pB();
            h.pv().pA();
            TbadkCoreApplication.getInst().clearEnterForeCount();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aKA().aKL());
        }
        messageSyncMessage.setForTimer(this.eKG);
        LocalViewSize.ImageSize Cu = LocalViewSize.Cr().Cu();
        if (Cu != null) {
            messageSyncMessage.setWidth(Cu.width);
            messageSyncMessage.setHeight(Cu.height);
        }
        LocalViewSize.ImageSize Ct = LocalViewSize.Cr().Ct();
        if (Ct != null) {
            messageSyncMessage.setSmallHeight(Ct.height);
            messageSyncMessage.setSmallWidth(Ct.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void c(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.eKB++;
        this.eKG = false;
        this.eKD = 1;
        this.mHandler.removeMessages(3);
        aLd().mHandler.sendMessageDelayed(aLd().mHandler.obtainMessage(3), aLd().eKv);
        if (this.eKE == null) {
            this.eKE = new SparseArray<>();
            this.eKE.clear();
        }
        if (this.eKF == null) {
            this.eKF = new SparseArray<>();
        }
        SparseArray<Long> aKL = com.baidu.tieba.im.memorycache.b.aKA().aKL();
        if (0 != j) {
            Long l = aKL.get((int) j);
            Long l2 = this.eKE.get((int) j);
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
                this.eKE.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.eKE != null && this.eKE.size() > 0) {
            for (int i = 0; i < this.eKE.size(); i++) {
                int keyAt = this.eKE.keyAt(i);
                Long l3 = aKL.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.eKE.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.eKF.get((int) j) == null) {
                    this.eKF.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.eKF.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.eKF.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.eKE.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.eKE.keyAt(i2);
                long longValue3 = this.eKE.valueAt(i2).longValue();
                long j4 = 0;
                if (this.eKF.get(keyAt2) != null) {
                    j4 = this.eKF.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.eKE.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.eKE.size() == 0) {
            aLl();
            this.eKF.clear();
        } else {
            a(this.eKE, 1);
        }
    }

    public synchronized void aLi() {
        qu(2);
    }

    public synchronized void aLj() {
        qu(3);
    }

    public void aLk() {
        aLb();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.eKG = false;
                this.eKD = 4;
                this.mHandler.removeMessages(3);
                aLd().mHandler.sendMessageDelayed(aLd().mHandler.obtainMessage(3), aLd().eKv);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void qu(int i) {
        this.eKG = true;
        this.eKD = i;
        a((SparseArray<Long>) null, i);
    }

    private void qv(int i) {
        if (i == 1) {
            if (this.eKz != 2) {
                this.eKz = 1;
            }
        } else if (i == 3 || i == 2) {
            this.eKz = 2;
        }
    }

    private void aLl() {
        this.eKz = 0;
    }
}
