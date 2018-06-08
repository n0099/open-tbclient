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
    private static b erH;
    private List<GroupUpdateMessage> erP;
    private boolean erV;
    private int erI = 900000;
    private int erJ = 360000;
    private int erK = this.erJ;
    private final int erL = 0;
    private final int erM = 1;
    private final int erN = 2;
    private int erO = 0;
    private int erQ = 0;
    private long erR = 0;
    private int erS = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> erT = null;
    private LongSparseArray<Long> erU = null;
    private final com.baidu.adp.framework.client.socket.link.a tD = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c ecb = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aKY();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.erP = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aKr().aKq()) {
                            b.this.aKR();
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
                    b.this.aKX();
                } else {
                    b.this.aKW();
                }
            }
        }
    };
    private final CustomMessageListener erW = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.erT != null) {
                    b.this.erT.clear();
                }
                if (b.this.erU != null) {
                    b.this.erU.clear();
                }
                b.this.erP = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Gn().Go();
                    b.aKU().aKV();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aKU().aKR();
                }
            }
        });
        erH = null;
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
                    b.aKU().mHandler.removeMessages(2);
                    b.aKU().aKZ();
                    return;
                case 3:
                    b.aKU().mHandler.removeMessages(3);
                    if (b.aKU().erS == 3) {
                        b.aKU().aLa();
                    } else {
                        b.aKU().aKZ();
                    }
                    b.aKU().mHandler.sendMessageDelayed(b.aKU().mHandler.obtainMessage(3), b.aKU().erK);
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
            oe(i);
            return;
        }
        aLc();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aKr().aKD());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.erT != null) {
                this.erT.clear();
            }
            if (this.erU != null) {
                this.erU.clear();
            }
        }
    }

    public void aKR() {
        boolean z;
        if (this.erP != null) {
            LongSparseArray<Long> aKC = com.baidu.tieba.im.memorycache.b.aKr().aKC();
            if (aKC == null) {
                this.erP = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.erP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aKC.get(next.getGroupId()) != null) {
                    if (aKC.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.erS = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aKU().mHandler.sendMessageDelayed(aKU().mHandler.obtainMessage(3), aKU().erK);
            }
            this.erP = null;
        }
    }

    private void aKS() {
        if (this.erO != 0) {
            if (this.erO == 1) {
                d(0L, 0L, 0L);
            } else {
                aKZ();
            }
        }
    }

    private void aKT() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aKU() {
        b bVar;
        synchronized (b.class) {
            if (erH == null) {
                erH = new b();
            }
            bVar = erH;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.erW);
        g.Gv().a(this.tD);
        MessageManager.getInstance().registerListener(1003, this.ecb);
        MessageManager.getInstance().registerListener(1001, this.ecb);
        MessageManager.getInstance().registerListener(202101, this.ecb);
        aKV();
    }

    public void aKV() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            ob(socketGetMsgStratgy[0] * 1000);
            oc(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aLc();
    }

    public void stop() {
        aLc();
        aKT();
    }

    public void aKW() {
        this.erK = this.erJ;
    }

    public void aKX() {
        aKU().erK = aKU().erI;
    }

    public void ob(int i) {
        if (i > 0) {
            this.erJ = i;
        }
    }

    public void oc(int i) {
        if (i > 0) {
            this.erI = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aKY() {
        if (System.currentTimeMillis() - this.erR >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.erQ);
            pushCountMessage.setUpFlowSize(h.kp().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.kp().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.erR = System.currentTimeMillis();
            this.erQ = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aKr().aKC());
        }
        messageSyncMessage.setForTimer(this.erV);
        LocalViewSize.ImageSize yF = LocalViewSize.yC().yF();
        if (yF != null) {
            messageSyncMessage.setWidth(yF.width);
            messageSyncMessage.setHeight(yF.height);
        }
        LocalViewSize.ImageSize yE = LocalViewSize.yC().yE();
        if (yE != null) {
            messageSyncMessage.setSmallHeight(yE.height);
            messageSyncMessage.setSmallWidth(yE.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.erQ++;
        this.erV = false;
        this.erS = 1;
        this.mHandler.removeMessages(3);
        aKU().mHandler.sendMessageDelayed(aKU().mHandler.obtainMessage(3), aKU().erK);
        if (this.erT == null) {
            this.erT = new LongSparseArray<>();
            this.erT.clear();
        }
        if (this.erU == null) {
            this.erU = new LongSparseArray<>();
        }
        LongSparseArray<Long> aKC = com.baidu.tieba.im.memorycache.b.aKr().aKC();
        if (0 != j) {
            Long l = aKC.get(j);
            Long l2 = this.erT.get(j);
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
                this.erT.put(j, Long.valueOf(longValue));
            }
        }
        if (this.erT != null && this.erT.size() > 0) {
            for (int i = 0; i < this.erT.size(); i++) {
                long keyAt = this.erT.keyAt(i);
                Long l3 = aKC.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.erT.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.erU.get(j) == null) {
                    this.erU.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.erU.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.erU.put(j, Long.valueOf(j2));
                }
            }
            int size = this.erT.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.erT.keyAt(i2);
                long longValue3 = this.erT.valueAt(i2).longValue();
                long j4 = 0;
                if (this.erU.get(keyAt2) != null) {
                    j4 = this.erU.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.erT.remove(((Long) it.next()).longValue());
            }
        }
        if (this.erT.size() == 0) {
            aLc();
            this.erU.clear();
        } else {
            a(this.erT, 1);
        }
    }

    public synchronized void aKZ() {
        od(2);
    }

    public synchronized void aLa() {
        od(3);
    }

    public void aLb() {
        aKS();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.erV = false;
                this.erS = 4;
                this.mHandler.removeMessages(3);
                aKU().mHandler.sendMessageDelayed(aKU().mHandler.obtainMessage(3), aKU().erK);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void od(int i) {
        this.erV = true;
        this.erS = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void oe(int i) {
        if (i == 1) {
            if (this.erO != 2) {
                this.erO = 1;
            }
        } else if (i == 3 || i == 2) {
            this.erO = 2;
        }
    }

    private void aLc() {
        this.erO = 0;
    }
}
