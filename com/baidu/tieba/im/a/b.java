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
    private static b gHi;
    private List<GroupUpdateMessage> gHq;
    private boolean gHw;
    private int gHj = 900000;
    private int gHk = 360000;
    private int gHl = this.gHk;
    private final int gHm = 0;
    private final int gHn = 1;
    private final int gHo = 2;
    private int gHp = 0;
    private int gHr = 0;
    private long gHs = 0;
    private int gHt = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gHu = null;
    private LongSparseArray<Long> gHv = null;
    private final com.baidu.adp.framework.client.socket.link.a uj = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void h(Map<String, String> map) {
            b.this.start();
            f.fC().g(map);
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
    private final com.baidu.adp.framework.listener.c grK = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bCV();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gHq = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bCr().bCq()) {
                            b.this.bCO();
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
                    b.this.bCU();
                } else {
                    b.this.bCT();
                }
            }
        }
    };
    private final CustomMessageListener gHx = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gHu != null) {
                    b.this.gHu.clear();
                }
                if (b.this.gHv != null) {
                    b.this.gHv.clear();
                }
                b.this.gHq = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.apX().apY();
                    b.bCR().bCS();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bCR().bCO();
                }
            }
        });
        gHi = null;
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
                    b.bCR().mHandler.removeMessages(2);
                    b.bCR().bCW();
                    return;
                case 3:
                    b.bCR().mHandler.removeMessages(3);
                    if (b.bCR().gHt == 3) {
                        b.bCR().bCX();
                    } else {
                        b.bCR().bCW();
                    }
                    b.bCR().mHandler.sendMessageDelayed(b.bCR().mHandler.obtainMessage(3), b.bCR().gHl);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().fH() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int H = MessageManager.getInstance().getSocketClient().H(202003);
        if (a2 || H > 0) {
            j.d(false, false, true);
            vp(i);
            return;
        }
        bCZ();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bCr().bCD());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gHu != null) {
                this.gHu.clear();
            }
            if (this.gHv != null) {
                this.gHv.clear();
            }
        }
    }

    public void bCO() {
        boolean z;
        if (this.gHq != null) {
            LongSparseArray<Long> bCC = com.baidu.tieba.im.memorycache.b.bCr().bCC();
            if (bCC == null) {
                this.gHq = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gHq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bCC.get(next.getGroupId()) != null) {
                    if (bCC.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gHt = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bCR().mHandler.sendMessageDelayed(bCR().mHandler.obtainMessage(3), bCR().gHl);
            }
            this.gHq = null;
        }
    }

    private void bCP() {
        if (this.gHp != 0) {
            if (this.gHp == 1) {
                e(0L, 0L, 0L);
            } else {
                bCW();
            }
        }
    }

    private void bCQ() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bCR() {
        b bVar;
        synchronized (b.class) {
            if (gHi == null) {
                gHi = new b();
            }
            bVar = gHi;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gHx);
        h.aqf().a(this.uj);
        MessageManager.getInstance().registerListener(1003, this.grK);
        MessageManager.getInstance().registerListener(1001, this.grK);
        MessageManager.getInstance().registerListener(202101, this.grK);
        bCS();
    }

    public void bCS() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            vm(socketGetMsgStratgy[0] * 1000);
            vn(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bCZ();
    }

    public void stop() {
        bCZ();
        bCQ();
    }

    public void bCT() {
        this.gHl = this.gHk;
    }

    public void bCU() {
        bCR().gHl = bCR().gHj;
    }

    public void vm(int i) {
        if (i > 0) {
            this.gHk = i;
        }
    }

    public void vn(int i) {
        if (i > 0) {
            this.gHj = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bCV() {
        if (System.currentTimeMillis() - this.gHs >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gHr);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.kD().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.kD().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gHs = System.currentTimeMillis();
            this.gHr = 0;
            com.baidu.adp.lib.webSocket.h.kD().kI();
            com.baidu.adp.lib.webSocket.h.kD().kH();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bCr().bCC());
        }
        messageSyncMessage.setForTimer(this.gHw);
        LocalViewSize.ImageSize ahy = LocalViewSize.ahv().ahy();
        if (ahy != null) {
            messageSyncMessage.setWidth(ahy.width);
            messageSyncMessage.setHeight(ahy.height);
        }
        LocalViewSize.ImageSize ahx = LocalViewSize.ahv().ahx();
        if (ahx != null) {
            messageSyncMessage.setSmallHeight(ahx.height);
            messageSyncMessage.setSmallWidth(ahx.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void e(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.gHr++;
        this.gHw = false;
        this.gHt = 1;
        this.mHandler.removeMessages(3);
        bCR().mHandler.sendMessageDelayed(bCR().mHandler.obtainMessage(3), bCR().gHl);
        if (this.gHu == null) {
            this.gHu = new LongSparseArray<>();
            this.gHu.clear();
        }
        if (this.gHv == null) {
            this.gHv = new LongSparseArray<>();
        }
        LongSparseArray<Long> bCC = com.baidu.tieba.im.memorycache.b.bCr().bCC();
        if (0 != j) {
            Long l = bCC.get(j);
            Long l2 = this.gHu.get(j);
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
                this.gHu.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gHu != null && this.gHu.size() > 0) {
            for (int i = 0; i < this.gHu.size(); i++) {
                long keyAt = this.gHu.keyAt(i);
                Long l3 = bCC.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gHu.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gHv.get(j) == null) {
                    this.gHv.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gHv.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gHv.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gHu.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gHu.keyAt(i2);
                long longValue3 = this.gHu.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gHv.get(keyAt2) != null) {
                    j4 = this.gHv.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gHu.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gHu.size() == 0) {
            bCZ();
            this.gHv.clear();
        } else {
            a(this.gHu, 1);
        }
    }

    public synchronized void bCW() {
        vo(2);
    }

    public synchronized void bCX() {
        vo(3);
    }

    public void bCY() {
        bCP();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gHw = false;
                this.gHt = 4;
                this.mHandler.removeMessages(3);
                bCR().mHandler.sendMessageDelayed(bCR().mHandler.obtainMessage(3), bCR().gHl);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void vo(int i) {
        this.gHw = true;
        this.gHt = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void vp(int i) {
        if (i == 1) {
            if (this.gHp != 2) {
                this.gHp = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gHp = 2;
        }
    }

    private void bCZ() {
        this.gHp = 0;
    }
}
