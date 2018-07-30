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
    private static b ezr;
    private boolean ezF;
    private List<GroupUpdateMessage> ezz;
    private int ezs = 900000;
    private int ezt = 360000;
    private int ezu = this.ezt;
    private final int ezv = 0;
    private final int ezw = 1;
    private final int ezx = 2;
    private int ezy = 0;
    private int ezA = 0;
    private long ezB = 0;
    private int ezC = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> ezD = null;
    private LongSparseArray<Long> ezE = null;
    private final com.baidu.adp.framework.client.socket.link.a tr = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c ejL = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aMF();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.ezz = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aLY().aLX()) {
                            b.this.aMy();
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
                    b.this.aME();
                } else {
                    b.this.aMD();
                }
            }
        }
    };
    private final CustomMessageListener ezG = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.ezD != null) {
                    b.this.ezD.clear();
                }
                if (b.this.ezE != null) {
                    b.this.ezE.clear();
                }
                b.this.ezz = null;
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
                    b.aMB().aMC();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aMB().aMy();
                }
            }
        });
        ezr = null;
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
                    b.aMB().mHandler.removeMessages(2);
                    b.aMB().aMG();
                    return;
                case 3:
                    b.aMB().mHandler.removeMessages(3);
                    if (b.aMB().ezC == 3) {
                        b.aMB().aMH();
                    } else {
                        b.aMB().aMG();
                    }
                    b.aMB().mHandler.sendMessageDelayed(b.aMB().mHandler.obtainMessage(3), b.aMB().ezu);
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
        aMJ();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aLY().aMk());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.ezD != null) {
                this.ezD.clear();
            }
            if (this.ezE != null) {
                this.ezE.clear();
            }
        }
    }

    public void aMy() {
        boolean z;
        if (this.ezz != null) {
            LongSparseArray<Long> aMj = com.baidu.tieba.im.memorycache.b.aLY().aMj();
            if (aMj == null) {
                this.ezz = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.ezz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aMj.get(next.getGroupId()) != null) {
                    if (aMj.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.ezC = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aMB().mHandler.sendMessageDelayed(aMB().mHandler.obtainMessage(3), aMB().ezu);
            }
            this.ezz = null;
        }
    }

    private void aMz() {
        if (this.ezy != 0) {
            if (this.ezy == 1) {
                d(0L, 0L, 0L);
            } else {
                aMG();
            }
        }
    }

    private void aMA() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aMB() {
        b bVar;
        synchronized (b.class) {
            if (ezr == null) {
                ezr = new b();
            }
            bVar = ezr;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.ezG);
        g.GJ().a(this.tr);
        MessageManager.getInstance().registerListener(1003, this.ejL);
        MessageManager.getInstance().registerListener(1001, this.ejL);
        MessageManager.getInstance().registerListener(202101, this.ejL);
        aMC();
    }

    public void aMC() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            ow(socketGetMsgStratgy[0] * 1000);
            ox(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aMJ();
    }

    public void stop() {
        aMJ();
        aMA();
    }

    public void aMD() {
        this.ezu = this.ezt;
    }

    public void aME() {
        aMB().ezu = aMB().ezs;
    }

    public void ow(int i) {
        if (i > 0) {
            this.ezt = i;
        }
    }

    public void ox(int i) {
        if (i > 0) {
            this.ezs = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aMF() {
        if (System.currentTimeMillis() - this.ezB >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.ezA);
            pushCountMessage.setUpFlowSize(h.kq().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.kq().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.ezB = System.currentTimeMillis();
            this.ezA = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aLY().aMj());
        }
        messageSyncMessage.setForTimer(this.ezF);
        LocalViewSize.ImageSize yK = LocalViewSize.yH().yK();
        if (yK != null) {
            messageSyncMessage.setWidth(yK.width);
            messageSyncMessage.setHeight(yK.height);
        }
        LocalViewSize.ImageSize yJ = LocalViewSize.yH().yJ();
        if (yJ != null) {
            messageSyncMessage.setSmallHeight(yJ.height);
            messageSyncMessage.setSmallWidth(yJ.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.ezA++;
        this.ezF = false;
        this.ezC = 1;
        this.mHandler.removeMessages(3);
        aMB().mHandler.sendMessageDelayed(aMB().mHandler.obtainMessage(3), aMB().ezu);
        if (this.ezD == null) {
            this.ezD = new LongSparseArray<>();
            this.ezD.clear();
        }
        if (this.ezE == null) {
            this.ezE = new LongSparseArray<>();
        }
        LongSparseArray<Long> aMj = com.baidu.tieba.im.memorycache.b.aLY().aMj();
        if (0 != j) {
            Long l = aMj.get(j);
            Long l2 = this.ezD.get(j);
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
                this.ezD.put(j, Long.valueOf(longValue));
            }
        }
        if (this.ezD != null && this.ezD.size() > 0) {
            for (int i = 0; i < this.ezD.size(); i++) {
                long keyAt = this.ezD.keyAt(i);
                Long l3 = aMj.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.ezD.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.ezE.get(j) == null) {
                    this.ezE.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.ezE.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.ezE.put(j, Long.valueOf(j2));
                }
            }
            int size = this.ezD.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.ezD.keyAt(i2);
                long longValue3 = this.ezD.valueAt(i2).longValue();
                long j4 = 0;
                if (this.ezE.get(keyAt2) != null) {
                    j4 = this.ezE.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.ezD.remove(((Long) it.next()).longValue());
            }
        }
        if (this.ezD.size() == 0) {
            aMJ();
            this.ezE.clear();
        } else {
            a(this.ezD, 1);
        }
    }

    public synchronized void aMG() {
        oy(2);
    }

    public synchronized void aMH() {
        oy(3);
    }

    public void aMI() {
        aMz();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.ezF = false;
                this.ezC = 4;
                this.mHandler.removeMessages(3);
                aMB().mHandler.sendMessageDelayed(aMB().mHandler.obtainMessage(3), aMB().ezu);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void oy(int i) {
        this.ezF = true;
        this.ezC = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void oz(int i) {
        if (i == 1) {
            if (this.ezy != 2) {
                this.ezy = 1;
            }
        } else if (i == 3 || i == 2) {
            this.ezy = 2;
        }
    }

    private void aMJ() {
        this.ezy = 0;
    }
}
