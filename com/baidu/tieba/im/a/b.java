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
    private static b gHh;
    private List<GroupUpdateMessage> gHp;
    private boolean gHv;
    private int gHi = 900000;
    private int gHj = 360000;
    private int gHk = this.gHj;
    private final int gHl = 0;
    private final int gHm = 1;
    private final int gHn = 2;
    private int gHo = 0;
    private int gHq = 0;
    private long gHr = 0;
    private int gHs = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gHt = null;
    private LongSparseArray<Long> gHu = null;
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
    private final com.baidu.adp.framework.listener.c grJ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bCS();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gHp = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bCo().bCn()) {
                            b.this.bCL();
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
                    b.this.bCR();
                } else {
                    b.this.bCQ();
                }
            }
        }
    };
    private final CustomMessageListener gHw = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gHt != null) {
                    b.this.gHt.clear();
                }
                if (b.this.gHu != null) {
                    b.this.gHu.clear();
                }
                b.this.gHp = null;
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
                    b.bCO().bCP();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bCO().bCL();
                }
            }
        });
        gHh = null;
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
                    b.bCO().mHandler.removeMessages(2);
                    b.bCO().bCT();
                    return;
                case 3:
                    b.bCO().mHandler.removeMessages(3);
                    if (b.bCO().gHs == 3) {
                        b.bCO().bCU();
                    } else {
                        b.bCO().bCT();
                    }
                    b.bCO().mHandler.sendMessageDelayed(b.bCO().mHandler.obtainMessage(3), b.bCO().gHk);
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
        bCW();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bCo().bCA());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gHt != null) {
                this.gHt.clear();
            }
            if (this.gHu != null) {
                this.gHu.clear();
            }
        }
    }

    public void bCL() {
        boolean z;
        if (this.gHp != null) {
            LongSparseArray<Long> bCz = com.baidu.tieba.im.memorycache.b.bCo().bCz();
            if (bCz == null) {
                this.gHp = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gHp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bCz.get(next.getGroupId()) != null) {
                    if (bCz.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gHs = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bCO().mHandler.sendMessageDelayed(bCO().mHandler.obtainMessage(3), bCO().gHk);
            }
            this.gHp = null;
        }
    }

    private void bCM() {
        if (this.gHo != 0) {
            if (this.gHo == 1) {
                e(0L, 0L, 0L);
            } else {
                bCT();
            }
        }
    }

    private void bCN() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bCO() {
        b bVar;
        synchronized (b.class) {
            if (gHh == null) {
                gHh = new b();
            }
            bVar = gHh;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gHw);
        h.aqf().a(this.uj);
        MessageManager.getInstance().registerListener(1003, this.grJ);
        MessageManager.getInstance().registerListener(1001, this.grJ);
        MessageManager.getInstance().registerListener(202101, this.grJ);
        bCP();
    }

    public void bCP() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            vm(socketGetMsgStratgy[0] * 1000);
            vn(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bCW();
    }

    public void stop() {
        bCW();
        bCN();
    }

    public void bCQ() {
        this.gHk = this.gHj;
    }

    public void bCR() {
        bCO().gHk = bCO().gHi;
    }

    public void vm(int i) {
        if (i > 0) {
            this.gHj = i;
        }
    }

    public void vn(int i) {
        if (i > 0) {
            this.gHi = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bCS() {
        if (System.currentTimeMillis() - this.gHr >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gHq);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.kD().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.kD().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gHr = System.currentTimeMillis();
            this.gHq = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bCo().bCz());
        }
        messageSyncMessage.setForTimer(this.gHv);
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
        this.gHq++;
        this.gHv = false;
        this.gHs = 1;
        this.mHandler.removeMessages(3);
        bCO().mHandler.sendMessageDelayed(bCO().mHandler.obtainMessage(3), bCO().gHk);
        if (this.gHt == null) {
            this.gHt = new LongSparseArray<>();
            this.gHt.clear();
        }
        if (this.gHu == null) {
            this.gHu = new LongSparseArray<>();
        }
        LongSparseArray<Long> bCz = com.baidu.tieba.im.memorycache.b.bCo().bCz();
        if (0 != j) {
            Long l = bCz.get(j);
            Long l2 = this.gHt.get(j);
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
                this.gHt.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gHt != null && this.gHt.size() > 0) {
            for (int i = 0; i < this.gHt.size(); i++) {
                long keyAt = this.gHt.keyAt(i);
                Long l3 = bCz.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gHt.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gHu.get(j) == null) {
                    this.gHu.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gHu.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gHu.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gHt.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gHt.keyAt(i2);
                long longValue3 = this.gHt.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gHu.get(keyAt2) != null) {
                    j4 = this.gHu.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gHt.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gHt.size() == 0) {
            bCW();
            this.gHu.clear();
        } else {
            a(this.gHt, 1);
        }
    }

    public synchronized void bCT() {
        vo(2);
    }

    public synchronized void bCU() {
        vo(3);
    }

    public void bCV() {
        bCM();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gHv = false;
                this.gHs = 4;
                this.mHandler.removeMessages(3);
                bCO().mHandler.sendMessageDelayed(bCO().mHandler.obtainMessage(3), bCO().gHk);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void vo(int i) {
        this.gHv = true;
        this.gHs = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void vp(int i) {
        if (i == 1) {
            if (this.gHo != 2) {
                this.gHo = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gHo = 2;
        }
    }

    private void bCW() {
        this.gHo = 0;
    }
}
