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
    private static b gHk;
    private List<GroupUpdateMessage> gHs;
    private boolean gHy;
    private int gHl = 900000;
    private int gHm = 360000;
    private int gHn = this.gHm;
    private final int gHo = 0;
    private final int gHp = 1;
    private final int gHq = 2;
    private int gHr = 0;
    private int gHt = 0;
    private long gHu = 0;
    private int gHv = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gHw = null;
    private LongSparseArray<Long> gHx = null;
    private final com.baidu.adp.framework.client.socket.link.a ui = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c grM = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bCW();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gHs = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bCs().bCr()) {
                            b.this.bCP();
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
                    b.this.bCV();
                } else {
                    b.this.bCU();
                }
            }
        }
    };
    private final CustomMessageListener gHz = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gHw != null) {
                    b.this.gHw.clear();
                }
                if (b.this.gHx != null) {
                    b.this.gHx.clear();
                }
                b.this.gHs = null;
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
                    b.bCS().bCT();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bCS().bCP();
                }
            }
        });
        gHk = null;
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
                    b.bCS().mHandler.removeMessages(2);
                    b.bCS().bCX();
                    return;
                case 3:
                    b.bCS().mHandler.removeMessages(3);
                    if (b.bCS().gHv == 3) {
                        b.bCS().bCY();
                    } else {
                        b.bCS().bCX();
                    }
                    b.bCS().mHandler.sendMessageDelayed(b.bCS().mHandler.obtainMessage(3), b.bCS().gHn);
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
        bDa();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bCs().bCE());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gHw != null) {
                this.gHw.clear();
            }
            if (this.gHx != null) {
                this.gHx.clear();
            }
        }
    }

    public void bCP() {
        boolean z;
        if (this.gHs != null) {
            LongSparseArray<Long> bCD = com.baidu.tieba.im.memorycache.b.bCs().bCD();
            if (bCD == null) {
                this.gHs = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gHs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bCD.get(next.getGroupId()) != null) {
                    if (bCD.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gHv = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bCS().mHandler.sendMessageDelayed(bCS().mHandler.obtainMessage(3), bCS().gHn);
            }
            this.gHs = null;
        }
    }

    private void bCQ() {
        if (this.gHr != 0) {
            if (this.gHr == 1) {
                e(0L, 0L, 0L);
            } else {
                bCX();
            }
        }
    }

    private void bCR() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bCS() {
        b bVar;
        synchronized (b.class) {
            if (gHk == null) {
                gHk = new b();
            }
            bVar = gHk;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gHz);
        h.aqf().a(this.ui);
        MessageManager.getInstance().registerListener(1003, this.grM);
        MessageManager.getInstance().registerListener(1001, this.grM);
        MessageManager.getInstance().registerListener(202101, this.grM);
        bCT();
    }

    public void bCT() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            vm(socketGetMsgStratgy[0] * 1000);
            vn(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bDa();
    }

    public void stop() {
        bDa();
        bCR();
    }

    public void bCU() {
        this.gHn = this.gHm;
    }

    public void bCV() {
        bCS().gHn = bCS().gHl;
    }

    public void vm(int i) {
        if (i > 0) {
            this.gHm = i;
        }
    }

    public void vn(int i) {
        if (i > 0) {
            this.gHl = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bCW() {
        if (System.currentTimeMillis() - this.gHu >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gHt);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.kD().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.kD().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gHu = System.currentTimeMillis();
            this.gHt = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bCs().bCD());
        }
        messageSyncMessage.setForTimer(this.gHy);
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
        this.gHt++;
        this.gHy = false;
        this.gHv = 1;
        this.mHandler.removeMessages(3);
        bCS().mHandler.sendMessageDelayed(bCS().mHandler.obtainMessage(3), bCS().gHn);
        if (this.gHw == null) {
            this.gHw = new LongSparseArray<>();
            this.gHw.clear();
        }
        if (this.gHx == null) {
            this.gHx = new LongSparseArray<>();
        }
        LongSparseArray<Long> bCD = com.baidu.tieba.im.memorycache.b.bCs().bCD();
        if (0 != j) {
            Long l = bCD.get(j);
            Long l2 = this.gHw.get(j);
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
                this.gHw.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gHw != null && this.gHw.size() > 0) {
            for (int i = 0; i < this.gHw.size(); i++) {
                long keyAt = this.gHw.keyAt(i);
                Long l3 = bCD.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gHw.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gHx.get(j) == null) {
                    this.gHx.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gHx.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gHx.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gHw.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gHw.keyAt(i2);
                long longValue3 = this.gHw.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gHx.get(keyAt2) != null) {
                    j4 = this.gHx.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gHw.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gHw.size() == 0) {
            bDa();
            this.gHx.clear();
        } else {
            a(this.gHw, 1);
        }
    }

    public synchronized void bCX() {
        vo(2);
    }

    public synchronized void bCY() {
        vo(3);
    }

    public void bCZ() {
        bCQ();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gHy = false;
                this.gHv = 4;
                this.mHandler.removeMessages(3);
                bCS().mHandler.sendMessageDelayed(bCS().mHandler.obtainMessage(3), bCS().gHn);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void vo(int i) {
        this.gHy = true;
        this.gHv = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void vp(int i) {
        if (i == 1) {
            if (this.gHr != 2) {
                this.gHr = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gHr = 2;
        }
    }

    private void bDa() {
        this.gHr = 0;
    }
}
