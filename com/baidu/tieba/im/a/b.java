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
    private static b eKI;
    private List<GroupUpdateMessage> eKQ;
    private boolean eKW;
    private int eKJ = 900000;
    private int eKK = 360000;
    private int eKL = this.eKK;
    private final int eKM = 0;
    private final int eKN = 1;
    private final int eKO = 2;
    private int eKP = 0;
    private int eKR = 0;
    private long eKS = 0;
    private int eKT = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> eKU = null;
    private SparseArray<Long> eKV = null;
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
    private final com.baidu.adp.framework.listener.c evf = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aLi();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.eKQ = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aKB().aKA()) {
                            b.this.aLb();
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
                    b.this.aLh();
                } else {
                    b.this.aLg();
                }
            }
        }
    };
    private final CustomMessageListener eKX = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.eKU != null) {
                    b.this.eKU.clear();
                }
                if (b.this.eKV != null) {
                    b.this.eKV.clear();
                }
                b.this.eKQ = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Kg().Kh();
                    b.aLe().aLf();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aLe().aLb();
                }
            }
        });
        eKI = null;
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
                    b.aLe().mHandler.removeMessages(2);
                    b.aLe().aLj();
                    return;
                case 3:
                    b.aLe().mHandler.removeMessages(3);
                    if (b.aLe().eKT == 3) {
                        b.aLe().aLk();
                    } else {
                        b.aLe().aLj();
                    }
                    b.aLe().mHandler.sendMessageDelayed(b.aLe().mHandler.obtainMessage(3), b.aLe().eKL);
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
            qw(i);
            return;
        }
        aLm();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aKB().aKN());
        }
        MessageManager.getInstance().sendMessage(b);
        m.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.eKU != null) {
                this.eKU.clear();
            }
            if (this.eKV != null) {
                this.eKV.clear();
            }
        }
    }

    public void aLb() {
        boolean z;
        if (this.eKQ != null) {
            SparseArray<Long> aKM = com.baidu.tieba.im.memorycache.b.aKB().aKM();
            if (aKM == null) {
                this.eKQ = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.eKQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aKM.get(next.getGroupId()) != null) {
                    if (aKM.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.eKT = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aLe().mHandler.sendMessageDelayed(aLe().mHandler.obtainMessage(3), aLe().eKL);
            }
            this.eKQ = null;
        }
    }

    private void aLc() {
        if (this.eKP != 0) {
            if (this.eKP == 1) {
                c(0L, 0L, 0L);
            } else {
                aLj();
            }
        }
    }

    private void aLd() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aLe() {
        b bVar;
        synchronized (b.class) {
            if (eKI == null) {
                eKI = new b();
            }
            bVar = eKI;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.eKX);
        g.Ko().a(this.acN);
        MessageManager.getInstance().registerListener(1003, this.evf);
        MessageManager.getInstance().registerListener(1001, this.evf);
        MessageManager.getInstance().registerListener(202101, this.evf);
        aLf();
    }

    public void aLf() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            qt(socketGetMsgStratgy[0] * 1000);
            qu(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aLm();
    }

    public void stop() {
        aLm();
        aLd();
    }

    public void aLg() {
        this.eKL = this.eKK;
    }

    public void aLh() {
        aLe().eKL = aLe().eKJ;
    }

    public void qt(int i) {
        if (i > 0) {
            this.eKK = i;
        }
    }

    public void qu(int i) {
        if (i > 0) {
            this.eKJ = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aLi() {
        if (System.currentTimeMillis() - this.eKS >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eKR);
            pushCountMessage.setUpFlowSize(h.pv().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.pv().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.eKS = System.currentTimeMillis();
            this.eKR = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aKB().aKM());
        }
        messageSyncMessage.setForTimer(this.eKW);
        LocalViewSize.ImageSize Cv = LocalViewSize.Cs().Cv();
        if (Cv != null) {
            messageSyncMessage.setWidth(Cv.width);
            messageSyncMessage.setHeight(Cv.height);
        }
        LocalViewSize.ImageSize Cu = LocalViewSize.Cs().Cu();
        if (Cu != null) {
            messageSyncMessage.setSmallHeight(Cu.height);
            messageSyncMessage.setSmallWidth(Cu.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void c(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.eKR++;
        this.eKW = false;
        this.eKT = 1;
        this.mHandler.removeMessages(3);
        aLe().mHandler.sendMessageDelayed(aLe().mHandler.obtainMessage(3), aLe().eKL);
        if (this.eKU == null) {
            this.eKU = new SparseArray<>();
            this.eKU.clear();
        }
        if (this.eKV == null) {
            this.eKV = new SparseArray<>();
        }
        SparseArray<Long> aKM = com.baidu.tieba.im.memorycache.b.aKB().aKM();
        if (0 != j) {
            Long l = aKM.get((int) j);
            Long l2 = this.eKU.get((int) j);
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
                this.eKU.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.eKU != null && this.eKU.size() > 0) {
            for (int i = 0; i < this.eKU.size(); i++) {
                int keyAt = this.eKU.keyAt(i);
                Long l3 = aKM.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.eKU.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.eKV.get((int) j) == null) {
                    this.eKV.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.eKV.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.eKV.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.eKU.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.eKU.keyAt(i2);
                long longValue3 = this.eKU.valueAt(i2).longValue();
                long j4 = 0;
                if (this.eKV.get(keyAt2) != null) {
                    j4 = this.eKV.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.eKU.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.eKU.size() == 0) {
            aLm();
            this.eKV.clear();
        } else {
            a(this.eKU, 1);
        }
    }

    public synchronized void aLj() {
        qv(2);
    }

    public synchronized void aLk() {
        qv(3);
    }

    public void aLl() {
        aLc();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.eKW = false;
                this.eKT = 4;
                this.mHandler.removeMessages(3);
                aLe().mHandler.sendMessageDelayed(aLe().mHandler.obtainMessage(3), aLe().eKL);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void qv(int i) {
        this.eKW = true;
        this.eKT = i;
        a((SparseArray<Long>) null, i);
    }

    private void qw(int i) {
        if (i == 1) {
            if (this.eKP != 2) {
                this.eKP = 1;
            }
        } else if (i == 3 || i == 2) {
            this.eKP = 2;
        }
    }

    private void aLm() {
        this.eKP = 0;
    }
}
