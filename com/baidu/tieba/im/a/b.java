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
import com.baidu.tbadk.l.j;
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
    private static b ezn;
    private boolean ezB;
    private List<GroupUpdateMessage> ezv;
    private int ezo = 900000;
    private int ezp = 360000;
    private int ezq = this.ezp;
    private final int ezr = 0;
    private final int ezs = 1;
    private final int ezt = 2;
    private int ezu = 0;
    private int ezw = 0;
    private long ezx = 0;
    private int ezy = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> ezz = null;
    private LongSparseArray<Long> ezA = null;
    private final com.baidu.adp.framework.client.socket.link.a ts = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void h(Map<String, String> map) {
            b.this.start();
            f.fl().g(map);
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
    private final com.baidu.adp.framework.listener.c ejH = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aMC();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.ezv = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aLV().aLU()) {
                            b.this.aMv();
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
                    b.this.aMB();
                } else {
                    b.this.aMA();
                }
            }
        }
    };
    private final CustomMessageListener ezC = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.ezz != null) {
                    b.this.ezz.clear();
                }
                if (b.this.ezA != null) {
                    b.this.ezA.clear();
                }
                b.this.ezv = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.GB().GC();
                    b.aMy().aMz();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aMy().aMv();
                }
            }
        });
        ezn = null;
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
                    b.aMy().mHandler.removeMessages(2);
                    b.aMy().aMD();
                    return;
                case 3:
                    b.aMy().mHandler.removeMessages(3);
                    if (b.aMy().ezy == 3) {
                        b.aMy().aME();
                    } else {
                        b.aMy().aMD();
                    }
                    b.aMy().mHandler.sendMessageDelayed(b.aMy().mHandler.obtainMessage(3), b.aMy().ezq);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().fq() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int H = MessageManager.getInstance().getSocketClient().H(202003);
        if (a2 || H > 0) {
            j.d(false, false, true);
            oz(i);
            return;
        }
        aMG();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aLV().aMh());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.ezz != null) {
                this.ezz.clear();
            }
            if (this.ezA != null) {
                this.ezA.clear();
            }
        }
    }

    public void aMv() {
        boolean z;
        if (this.ezv != null) {
            LongSparseArray<Long> aMg = com.baidu.tieba.im.memorycache.b.aLV().aMg();
            if (aMg == null) {
                this.ezv = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.ezv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aMg.get(next.getGroupId()) != null) {
                    if (aMg.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.ezy = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aMy().mHandler.sendMessageDelayed(aMy().mHandler.obtainMessage(3), aMy().ezq);
            }
            this.ezv = null;
        }
    }

    private void aMw() {
        if (this.ezu != 0) {
            if (this.ezu == 1) {
                d(0L, 0L, 0L);
            } else {
                aMD();
            }
        }
    }

    private void aMx() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aMy() {
        b bVar;
        synchronized (b.class) {
            if (ezn == null) {
                ezn = new b();
            }
            bVar = ezn;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.ezC);
        g.GJ().a(this.ts);
        MessageManager.getInstance().registerListener(1003, this.ejH);
        MessageManager.getInstance().registerListener(1001, this.ejH);
        MessageManager.getInstance().registerListener(202101, this.ejH);
        aMz();
    }

    public void aMz() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            ow(socketGetMsgStratgy[0] * 1000);
            ox(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aMG();
    }

    public void stop() {
        aMG();
        aMx();
    }

    public void aMA() {
        this.ezq = this.ezp;
    }

    public void aMB() {
        aMy().ezq = aMy().ezo;
    }

    public void ow(int i) {
        if (i > 0) {
            this.ezp = i;
        }
    }

    public void ox(int i) {
        if (i > 0) {
            this.ezo = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aMC() {
        if (System.currentTimeMillis() - this.ezx >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.ezw);
            pushCountMessage.setUpFlowSize(h.kq().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.kq().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.ezx = System.currentTimeMillis();
            this.ezw = 0;
            h.kq().kw();
            h.kq().kv();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aLV().aMg());
        }
        messageSyncMessage.setForTimer(this.ezB);
        LocalViewSize.ImageSize yI = LocalViewSize.yF().yI();
        if (yI != null) {
            messageSyncMessage.setWidth(yI.width);
            messageSyncMessage.setHeight(yI.height);
        }
        LocalViewSize.ImageSize yH = LocalViewSize.yF().yH();
        if (yH != null) {
            messageSyncMessage.setSmallHeight(yH.height);
            messageSyncMessage.setSmallWidth(yH.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.ezw++;
        this.ezB = false;
        this.ezy = 1;
        this.mHandler.removeMessages(3);
        aMy().mHandler.sendMessageDelayed(aMy().mHandler.obtainMessage(3), aMy().ezq);
        if (this.ezz == null) {
            this.ezz = new LongSparseArray<>();
            this.ezz.clear();
        }
        if (this.ezA == null) {
            this.ezA = new LongSparseArray<>();
        }
        LongSparseArray<Long> aMg = com.baidu.tieba.im.memorycache.b.aLV().aMg();
        if (0 != j) {
            Long l = aMg.get(j);
            Long l2 = this.ezz.get(j);
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
                this.ezz.put(j, Long.valueOf(longValue));
            }
        }
        if (this.ezz != null && this.ezz.size() > 0) {
            for (int i = 0; i < this.ezz.size(); i++) {
                long keyAt = this.ezz.keyAt(i);
                Long l3 = aMg.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.ezz.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.ezA.get(j) == null) {
                    this.ezA.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.ezA.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.ezA.put(j, Long.valueOf(j2));
                }
            }
            int size = this.ezz.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.ezz.keyAt(i2);
                long longValue3 = this.ezz.valueAt(i2).longValue();
                long j4 = 0;
                if (this.ezA.get(keyAt2) != null) {
                    j4 = this.ezA.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.ezz.remove(((Long) it.next()).longValue());
            }
        }
        if (this.ezz.size() == 0) {
            aMG();
            this.ezA.clear();
        } else {
            a(this.ezz, 1);
        }
    }

    public synchronized void aMD() {
        oy(2);
    }

    public synchronized void aME() {
        oy(3);
    }

    public void aMF() {
        aMw();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.ezB = false;
                this.ezy = 4;
                this.mHandler.removeMessages(3);
                aMy().mHandler.sendMessageDelayed(aMy().mHandler.obtainMessage(3), aMy().ezq);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void oy(int i) {
        this.ezB = true;
        this.ezy = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void oz(int i) {
        if (i == 1) {
            if (this.ezu != 2) {
                this.ezu = 1;
            }
        } else if (i == 3 || i == 2) {
            this.ezu = 2;
        }
    }

    private void aMG() {
        this.ezu = 0;
    }
}
