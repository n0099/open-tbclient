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
import com.baidu.adp.lib.webSocket.h;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.coreExtra.websocketBase.g;
import com.baidu.tbadk.k.j;
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
    private static b evy;
    private List<GroupUpdateMessage> evG;
    private boolean evM;
    private int evz = 900000;
    private int evA = 360000;
    private int evB = this.evA;
    private final int evC = 0;
    private final int evD = 1;
    private final int evE = 2;
    private int evF = 0;
    private int evH = 0;
    private long evI = 0;
    private int evJ = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> evK = null;
    private LongSparseArray<Long> evL = null;
    private final com.baidu.adp.framework.client.socket.link.a tB = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void h(Map<String, String> map) {
            b.this.start();
            f.fm().g(map);
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
    private final com.baidu.adp.framework.listener.c efV = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aLE();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.evG = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aKX().aKW()) {
                            b.this.aLx();
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
                    b.this.aLD();
                } else {
                    b.this.aLC();
                }
            }
        }
    };
    private final CustomMessageListener evN = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.evK != null) {
                    b.this.evK.clear();
                }
                if (b.this.evL != null) {
                    b.this.evL.clear();
                }
                b.this.evG = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.GF().GG();
                    b.aLA().aLB();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aLA().aLx();
                }
            }
        });
        evy = null;
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
                    b.aLA().mHandler.removeMessages(2);
                    b.aLA().aLF();
                    return;
                case 3:
                    b.aLA().mHandler.removeMessages(3);
                    if (b.aLA().evJ == 3) {
                        b.aLA().aLG();
                    } else {
                        b.aLA().aLF();
                    }
                    b.aLA().mHandler.sendMessageDelayed(b.aLA().mHandler.obtainMessage(3), b.aLA().evB);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().fs() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int H = MessageManager.getInstance().getSocketClient().H(202003);
        if (a2 || H > 0) {
            j.d(false, false, true);
            ol(i);
            return;
        }
        aLI();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aKX().aLj());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.evK != null) {
                this.evK.clear();
            }
            if (this.evL != null) {
                this.evL.clear();
            }
        }
    }

    public void aLx() {
        boolean z;
        if (this.evG != null) {
            LongSparseArray<Long> aLi = com.baidu.tieba.im.memorycache.b.aKX().aLi();
            if (aLi == null) {
                this.evG = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.evG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aLi.get(next.getGroupId()) != null) {
                    if (aLi.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.evJ = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aLA().mHandler.sendMessageDelayed(aLA().mHandler.obtainMessage(3), aLA().evB);
            }
            this.evG = null;
        }
    }

    private void aLy() {
        if (this.evF != 0) {
            if (this.evF == 1) {
                d(0L, 0L, 0L);
            } else {
                aLF();
            }
        }
    }

    private void aLz() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aLA() {
        b bVar;
        synchronized (b.class) {
            if (evy == null) {
                evy = new b();
            }
            bVar = evy;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.evN);
        g.GN().a(this.tB);
        MessageManager.getInstance().registerListener(1003, this.efV);
        MessageManager.getInstance().registerListener(1001, this.efV);
        MessageManager.getInstance().registerListener(202101, this.efV);
        aLB();
    }

    public void aLB() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            oi(socketGetMsgStratgy[0] * 1000);
            oj(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aLI();
    }

    public void stop() {
        aLI();
        aLz();
    }

    public void aLC() {
        this.evB = this.evA;
    }

    public void aLD() {
        aLA().evB = aLA().evz;
    }

    public void oi(int i) {
        if (i > 0) {
            this.evA = i;
        }
    }

    public void oj(int i) {
        if (i > 0) {
            this.evz = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aLE() {
        if (System.currentTimeMillis() - this.evI >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.evH);
            pushCountMessage.setUpFlowSize(h.kp().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.kp().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.evI = System.currentTimeMillis();
            this.evH = 0;
            h.kp().ku();
            h.kp().kt();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aKX().aLi());
        }
        messageSyncMessage.setForTimer(this.evM);
        LocalViewSize.ImageSize yT = LocalViewSize.yQ().yT();
        if (yT != null) {
            messageSyncMessage.setWidth(yT.width);
            messageSyncMessage.setHeight(yT.height);
        }
        LocalViewSize.ImageSize yS = LocalViewSize.yQ().yS();
        if (yS != null) {
            messageSyncMessage.setSmallHeight(yS.height);
            messageSyncMessage.setSmallWidth(yS.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.evH++;
        this.evM = false;
        this.evJ = 1;
        this.mHandler.removeMessages(3);
        aLA().mHandler.sendMessageDelayed(aLA().mHandler.obtainMessage(3), aLA().evB);
        if (this.evK == null) {
            this.evK = new LongSparseArray<>();
            this.evK.clear();
        }
        if (this.evL == null) {
            this.evL = new LongSparseArray<>();
        }
        LongSparseArray<Long> aLi = com.baidu.tieba.im.memorycache.b.aKX().aLi();
        if (0 != j) {
            Long l = aLi.get(j);
            Long l2 = this.evK.get(j);
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
                this.evK.put(j, Long.valueOf(longValue));
            }
        }
        if (this.evK != null && this.evK.size() > 0) {
            for (int i = 0; i < this.evK.size(); i++) {
                long keyAt = this.evK.keyAt(i);
                Long l3 = aLi.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.evK.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.evL.get(j) == null) {
                    this.evL.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.evL.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.evL.put(j, Long.valueOf(j2));
                }
            }
            int size = this.evK.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.evK.keyAt(i2);
                long longValue3 = this.evK.valueAt(i2).longValue();
                long j4 = 0;
                if (this.evL.get(keyAt2) != null) {
                    j4 = this.evL.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.evK.remove(((Long) it.next()).longValue());
            }
        }
        if (this.evK.size() == 0) {
            aLI();
            this.evL.clear();
        } else {
            a(this.evK, 1);
        }
    }

    public synchronized void aLF() {
        ok(2);
    }

    public synchronized void aLG() {
        ok(3);
    }

    public void aLH() {
        aLy();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.evM = false;
                this.evJ = 4;
                this.mHandler.removeMessages(3);
                aLA().mHandler.sendMessageDelayed(aLA().mHandler.obtainMessage(3), aLA().evB);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void ok(int i) {
        this.evM = true;
        this.evJ = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void ol(int i) {
        if (i == 1) {
            if (this.evF != 2) {
                this.evF = 1;
            }
        } else if (i == 3 || i == 2) {
            this.evF = 2;
        }
    }

    private void aLI() {
        this.evF = 0;
    }
}
