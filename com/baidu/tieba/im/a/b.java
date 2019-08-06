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
    private static b gOm;
    private boolean gOA;
    private List<GroupUpdateMessage> gOu;
    private int gOn = 900000;
    private int gOo = 360000;
    private int gOp = this.gOo;
    private final int gOq = 0;
    private final int gOr = 1;
    private final int gOs = 2;
    private int gOt = 0;
    private int gOv = 0;
    private long gOw = 0;
    private int gOx = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gOy = null;
    private LongSparseArray<Long> gOz = null;
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
    private final com.baidu.adp.framework.listener.c gyP = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bFR();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gOu = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bFn().bFm()) {
                            b.this.bFK();
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
                    b.this.bFQ();
                } else {
                    b.this.bFP();
                }
            }
        }
    };
    private final CustomMessageListener gOB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gOy != null) {
                    b.this.gOy.clear();
                }
                if (b.this.gOz != null) {
                    b.this.gOz.clear();
                }
                b.this.gOu = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.are().arf();
                    b.bFN().bFO();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bFN().bFK();
                }
            }
        });
        gOm = null;
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
                    b.bFN().mHandler.removeMessages(2);
                    b.bFN().bFS();
                    return;
                case 3:
                    b.bFN().mHandler.removeMessages(3);
                    if (b.bFN().gOx == 3) {
                        b.bFN().bFT();
                    } else {
                        b.bFN().bFS();
                    }
                    b.bFN().mHandler.sendMessageDelayed(b.bFN().mHandler.obtainMessage(3), b.bFN().gOp);
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
            vS(i);
            return;
        }
        bFV();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bFn().bFz());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gOy != null) {
                this.gOy.clear();
            }
            if (this.gOz != null) {
                this.gOz.clear();
            }
        }
    }

    public void bFK() {
        boolean z;
        if (this.gOu != null) {
            LongSparseArray<Long> bFy = com.baidu.tieba.im.memorycache.b.bFn().bFy();
            if (bFy == null) {
                this.gOu = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gOu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bFy.get(next.getGroupId()) != null) {
                    if (bFy.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gOx = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bFN().mHandler.sendMessageDelayed(bFN().mHandler.obtainMessage(3), bFN().gOp);
            }
            this.gOu = null;
        }
    }

    private void bFL() {
        if (this.gOt != 0) {
            if (this.gOt == 1) {
                e(0L, 0L, 0L);
            } else {
                bFS();
            }
        }
    }

    private void bFM() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bFN() {
        b bVar;
        synchronized (b.class) {
            if (gOm == null) {
                gOm = new b();
            }
            bVar = gOm;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gOB);
        h.arm().a(this.ul);
        MessageManager.getInstance().registerListener(1003, this.gyP);
        MessageManager.getInstance().registerListener(1001, this.gyP);
        MessageManager.getInstance().registerListener(202101, this.gyP);
        bFO();
    }

    public void bFO() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            vP(socketGetMsgStratgy[0] * 1000);
            vQ(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bFV();
    }

    public void stop() {
        bFV();
        bFM();
    }

    public void bFP() {
        this.gOp = this.gOo;
    }

    public void bFQ() {
        bFN().gOp = bFN().gOn;
    }

    public void vP(int i) {
        if (i > 0) {
            this.gOo = i;
        }
    }

    public void vQ(int i) {
        if (i > 0) {
            this.gOn = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bFR() {
        if (System.currentTimeMillis() - this.gOw >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gOv);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.kS().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.kS().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gOw = System.currentTimeMillis();
            this.gOv = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bFn().bFy());
        }
        messageSyncMessage.setForTimer(this.gOA);
        LocalViewSize.ImageSize aiC = LocalViewSize.aiz().aiC();
        if (aiC != null) {
            messageSyncMessage.setWidth(aiC.width);
            messageSyncMessage.setHeight(aiC.height);
        }
        LocalViewSize.ImageSize aiB = LocalViewSize.aiz().aiB();
        if (aiB != null) {
            messageSyncMessage.setSmallHeight(aiB.height);
            messageSyncMessage.setSmallWidth(aiB.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void e(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.gOv++;
        this.gOA = false;
        this.gOx = 1;
        this.mHandler.removeMessages(3);
        bFN().mHandler.sendMessageDelayed(bFN().mHandler.obtainMessage(3), bFN().gOp);
        if (this.gOy == null) {
            this.gOy = new LongSparseArray<>();
            this.gOy.clear();
        }
        if (this.gOz == null) {
            this.gOz = new LongSparseArray<>();
        }
        LongSparseArray<Long> bFy = com.baidu.tieba.im.memorycache.b.bFn().bFy();
        if (0 != j) {
            Long l = bFy.get(j);
            Long l2 = this.gOy.get(j);
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
                this.gOy.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gOy != null && this.gOy.size() > 0) {
            for (int i = 0; i < this.gOy.size(); i++) {
                long keyAt = this.gOy.keyAt(i);
                Long l3 = bFy.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gOy.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gOz.get(j) == null) {
                    this.gOz.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gOz.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gOz.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gOy.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gOy.keyAt(i2);
                long longValue3 = this.gOy.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gOz.get(keyAt2) != null) {
                    j4 = this.gOz.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gOy.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gOy.size() == 0) {
            bFV();
            this.gOz.clear();
        } else {
            a(this.gOy, 1);
        }
    }

    public synchronized void bFS() {
        vR(2);
    }

    public synchronized void bFT() {
        vR(3);
    }

    public void bFU() {
        bFL();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gOA = false;
                this.gOx = 4;
                this.mHandler.removeMessages(3);
                bFN().mHandler.sendMessageDelayed(bFN().mHandler.obtainMessage(3), bFN().gOp);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void vR(int i) {
        this.gOA = true;
        this.gOx = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void vS(int i) {
        if (i == 1) {
            if (this.gOt != 2) {
                this.gOt = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gOt = 2;
        }
    }

    private void bFV() {
        this.gOt = 0;
    }
}
