package com.baidu.tieba.im.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.f;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.e.e;
import com.baidu.tbadk.coreExtra.e.h;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.p.j;
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
    private static b gQe;
    private List<GroupUpdateMessage> gQm;
    private boolean gQs;
    private int gQf = 900000;
    private int gQg = 360000;
    private int gQh = this.gQg;
    private final int gQi = 0;
    private final int gQj = 1;
    private final int gQk = 2;
    private int gQl = 0;
    private int gQn = 0;
    private long gQo = 0;
    private int gQp = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gQq = null;
    private LongSparseArray<Long> gQr = null;
    private final com.baidu.adp.framework.client.socket.link.a ul = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void h(Map<String, String> map) {
            b.this.start();
            f.fK().g(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void S(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c gAG = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bGF();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gQm = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bGb().bGa()) {
                            b.this.bGy();
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
                    b.this.bGE();
                } else {
                    b.this.bGD();
                }
            }
        }
    };
    private final CustomMessageListener gQt = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gQq != null) {
                    b.this.gQq.clear();
                }
                if (b.this.gQr != null) {
                    b.this.gQr.clear();
                }
                b.this.gQm = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.arq().arr();
                    b.bGB().bGC();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bGB().bGy();
                }
            }
        });
        gQe = null;
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
                    b.bGB().mHandler.removeMessages(2);
                    b.bGB().bGG();
                    return;
                case 3:
                    b.bGB().mHandler.removeMessages(3);
                    if (b.bGB().gQp == 3) {
                        b.bGB().bGH();
                    } else {
                        b.bGB().bGG();
                    }
                    b.bGB().mHandler.sendMessageDelayed(b.bGB().mHandler.obtainMessage(3), b.bGB().gQh);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().fP() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int H = MessageManager.getInstance().getSocketClient().H(202003);
        if (a2 || H > 0) {
            j.d(false, false, true);
            vW(i);
            return;
        }
        bGJ();
        LongSparseArray<Long> longSparseArray2 = null;
        if (longSparseArray != null && longSparseArray.size() > 0) {
            LongSparseArray<Long> longSparseArray3 = new LongSparseArray<>();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long keyAt = longSparseArray.keyAt(i2);
                longSparseArray3.put(keyAt, Long.valueOf(longSparseArray.get(keyAt).longValue()));
            }
            longSparseArray2 = longSparseArray3;
        }
        MessageSyncMessage b = b(longSparseArray2, i);
        if (i == 3 || i == 2) {
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bGb().bGn());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gQq != null) {
                this.gQq.clear();
            }
            if (this.gQr != null) {
                this.gQr.clear();
            }
        }
    }

    public void bGy() {
        boolean z;
        if (this.gQm != null) {
            LongSparseArray<Long> bGm = com.baidu.tieba.im.memorycache.b.bGb().bGm();
            if (bGm == null) {
                this.gQm = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gQm.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bGm.get(next.getGroupId()) != null) {
                    if (bGm.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gQp = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bGB().mHandler.sendMessageDelayed(bGB().mHandler.obtainMessage(3), bGB().gQh);
            }
            this.gQm = null;
        }
    }

    private void bGz() {
        if (this.gQl != 0) {
            if (this.gQl == 1) {
                e(0L, 0L, 0L);
            } else {
                bGG();
            }
        }
    }

    private void bGA() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bGB() {
        b bVar;
        synchronized (b.class) {
            if (gQe == null) {
                gQe = new b();
            }
            bVar = gQe;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gQt);
        h.ary().a(this.ul);
        MessageManager.getInstance().registerListener(1003, this.gAG);
        MessageManager.getInstance().registerListener(1001, this.gAG);
        MessageManager.getInstance().registerListener(202101, this.gAG);
        bGC();
    }

    public void bGC() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            vT(socketGetMsgStratgy[0] * 1000);
            vU(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bGJ();
    }

    public void stop() {
        bGJ();
        bGA();
    }

    public void bGD() {
        this.gQh = this.gQg;
    }

    public void bGE() {
        bGB().gQh = bGB().gQf;
    }

    public void vT(int i) {
        if (i > 0) {
            this.gQg = i;
        }
    }

    public void vU(int i) {
        if (i > 0) {
            this.gQf = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bGF() {
        if (System.currentTimeMillis() - this.gQo >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gQn);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.kS().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.kS().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gQo = System.currentTimeMillis();
            this.gQn = 0;
            com.baidu.adp.lib.webSocket.h.kS().kX();
            com.baidu.adp.lib.webSocket.h.kS().kW();
            TbadkCoreApplication.getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(LongSparseArray<Long> longSparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (longSparseArray != null && longSparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(longSparseArray);
            NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(longSparseArray);
            if (makeNewpushRepair != null) {
                messageSyncMessage.setNewpushRepire(makeNewpushRepair);
            }
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bGb().bGm());
        }
        messageSyncMessage.setForTimer(this.gQs);
        LocalViewSize.ImageSize aiG = LocalViewSize.aiD().aiG();
        if (aiG != null) {
            messageSyncMessage.setWidth(aiG.width);
            messageSyncMessage.setHeight(aiG.height);
        }
        LocalViewSize.ImageSize aiF = LocalViewSize.aiD().aiF();
        if (aiF != null) {
            messageSyncMessage.setSmallHeight(aiF.height);
            messageSyncMessage.setSmallWidth(aiF.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void e(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.gQn++;
        this.gQs = false;
        this.gQp = 1;
        this.mHandler.removeMessages(3);
        bGB().mHandler.sendMessageDelayed(bGB().mHandler.obtainMessage(3), bGB().gQh);
        if (this.gQq == null) {
            this.gQq = new LongSparseArray<>();
            this.gQq.clear();
        }
        if (this.gQr == null) {
            this.gQr = new LongSparseArray<>();
        }
        LongSparseArray<Long> bGm = com.baidu.tieba.im.memorycache.b.bGb().bGm();
        if (0 != j) {
            Long l = bGm.get(j);
            Long l2 = this.gQq.get(j);
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
                this.gQq.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gQq != null && this.gQq.size() > 0) {
            for (int i = 0; i < this.gQq.size(); i++) {
                long keyAt = this.gQq.keyAt(i);
                Long l3 = bGm.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gQq.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gQr.get(j) == null) {
                    this.gQr.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gQr.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gQr.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gQq.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gQq.keyAt(i2);
                long longValue3 = this.gQq.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gQr.get(keyAt2) != null) {
                    j4 = this.gQr.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gQq.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gQq.size() == 0) {
            bGJ();
            this.gQr.clear();
        } else {
            a(this.gQq, 1);
        }
    }

    public synchronized void bGG() {
        vV(2);
    }

    public synchronized void bGH() {
        vV(3);
    }

    public void bGI() {
        bGz();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gQs = false;
                this.gQp = 4;
                this.mHandler.removeMessages(3);
                bGB().mHandler.sendMessageDelayed(bGB().mHandler.obtainMessage(3), bGB().gQh);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void vV(int i) {
        this.gQs = true;
        this.gQp = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void vW(int i) {
        if (i == 1) {
            if (this.gQl != 2) {
                this.gQl = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gQl = 2;
        }
    }

    private void bGJ() {
        this.gQl = 0;
    }
}
