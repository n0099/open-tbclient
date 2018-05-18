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
    private static b egr;
    private boolean egF;
    private List<GroupUpdateMessage> egz;
    private int egs = 900000;
    private int egt = 360000;
    private int egu = this.egt;
    private final int egv = 0;
    private final int egw = 1;
    private final int egx = 2;
    private int egy = 0;
    private int egA = 0;
    private long egB = 0;
    private int egC = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> egD = null;
    private LongSparseArray<Long> egE = null;
    private final com.baidu.adp.framework.client.socket.link.a ng = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void d(Map<String, String> map) {
            b.this.start();
            f.cy().c(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void G(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c dQP = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aGd();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.egz = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aFw().aFv()) {
                            b.this.aFW();
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
                    b.this.aGc();
                } else {
                    b.this.aGb();
                }
            }
        }
    };
    private final CustomMessageListener egG = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.egD != null) {
                    b.this.egD.clear();
                }
                if (b.this.egE != null) {
                    b.this.egE.clear();
                }
                b.this.egz = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.CK().CL();
                    b.aFZ().aGa();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aFZ().aFW();
                }
            }
        });
        egr = null;
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
                    b.aFZ().mHandler.removeMessages(2);
                    b.aFZ().aGe();
                    return;
                case 3:
                    b.aFZ().mHandler.removeMessages(3);
                    if (b.aFZ().egC == 3) {
                        b.aFZ().aGf();
                    } else {
                        b.aFZ().aGe();
                    }
                    b.aFZ().mHandler.sendMessageDelayed(b.aFZ().mHandler.obtainMessage(3), b.aFZ().egu);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().cD() > 10) {
            m.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int G = MessageManager.getInstance().getSocketClient().G(202003);
        if (a2 || G > 0) {
            m.d(false, false, true);
            nS(i);
            return;
        }
        aGh();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aFw().aFI());
        }
        MessageManager.getInstance().sendMessage(b);
        m.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.egD != null) {
                this.egD.clear();
            }
            if (this.egE != null) {
                this.egE.clear();
            }
        }
    }

    public void aFW() {
        boolean z;
        if (this.egz != null) {
            LongSparseArray<Long> aFH = com.baidu.tieba.im.memorycache.b.aFw().aFH();
            if (aFH == null) {
                this.egz = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.egz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aFH.get(next.getGroupId()) != null) {
                    if (aFH.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.egC = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aFZ().mHandler.sendMessageDelayed(aFZ().mHandler.obtainMessage(3), aFZ().egu);
            }
            this.egz = null;
        }
    }

    private void aFX() {
        if (this.egy != 0) {
            if (this.egy == 1) {
                d(0L, 0L, 0L);
            } else {
                aGe();
            }
        }
    }

    private void aFY() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aFZ() {
        b bVar;
        synchronized (b.class) {
            if (egr == null) {
                egr = new b();
            }
            bVar = egr;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.egG);
        g.CS().a(this.ng);
        MessageManager.getInstance().registerListener(1003, this.dQP);
        MessageManager.getInstance().registerListener(1001, this.dQP);
        MessageManager.getInstance().registerListener(202101, this.dQP);
        aGa();
    }

    public void aGa() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            nP(socketGetMsgStratgy[0] * 1000);
            nQ(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aGh();
    }

    public void stop() {
        aGh();
        aFY();
    }

    public void aGb() {
        this.egu = this.egt;
    }

    public void aGc() {
        aFZ().egu = aFZ().egs;
    }

    public void nP(int i) {
        if (i > 0) {
            this.egt = i;
        }
    }

    public void nQ(int i) {
        if (i > 0) {
            this.egs = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aGd() {
        if (System.currentTimeMillis() - this.egB >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.egA);
            pushCountMessage.setUpFlowSize(h.hB().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hB().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.egB = System.currentTimeMillis();
            this.egA = 0;
            h.hB().hG();
            h.hB().hF();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aFw().aFH());
        }
        messageSyncMessage.setForTimer(this.egF);
        LocalViewSize.ImageSize ve = LocalViewSize.vb().ve();
        if (ve != null) {
            messageSyncMessage.setWidth(ve.width);
            messageSyncMessage.setHeight(ve.height);
        }
        LocalViewSize.ImageSize vd = LocalViewSize.vb().vd();
        if (vd != null) {
            messageSyncMessage.setSmallHeight(vd.height);
            messageSyncMessage.setSmallWidth(vd.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.egA++;
        this.egF = false;
        this.egC = 1;
        this.mHandler.removeMessages(3);
        aFZ().mHandler.sendMessageDelayed(aFZ().mHandler.obtainMessage(3), aFZ().egu);
        if (this.egD == null) {
            this.egD = new LongSparseArray<>();
            this.egD.clear();
        }
        if (this.egE == null) {
            this.egE = new LongSparseArray<>();
        }
        LongSparseArray<Long> aFH = com.baidu.tieba.im.memorycache.b.aFw().aFH();
        if (0 != j) {
            Long l = aFH.get(j);
            Long l2 = this.egD.get(j);
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
                this.egD.put(j, Long.valueOf(longValue));
            }
        }
        if (this.egD != null && this.egD.size() > 0) {
            for (int i = 0; i < this.egD.size(); i++) {
                long keyAt = this.egD.keyAt(i);
                Long l3 = aFH.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.egD.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.egE.get(j) == null) {
                    this.egE.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.egE.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.egE.put(j, Long.valueOf(j2));
                }
            }
            int size = this.egD.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.egD.keyAt(i2);
                long longValue3 = this.egD.valueAt(i2).longValue();
                long j4 = 0;
                if (this.egE.get(keyAt2) != null) {
                    j4 = this.egE.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.egD.remove(((Long) it.next()).longValue());
            }
        }
        if (this.egD.size() == 0) {
            aGh();
            this.egE.clear();
        } else {
            a(this.egD, 1);
        }
    }

    public synchronized void aGe() {
        nR(2);
    }

    public synchronized void aGf() {
        nR(3);
    }

    public void aGg() {
        aFX();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.egF = false;
                this.egC = 4;
                this.mHandler.removeMessages(3);
                aFZ().mHandler.sendMessageDelayed(aFZ().mHandler.obtainMessage(3), aFZ().egu);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void nR(int i) {
        this.egF = true;
        this.egC = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void nS(int i) {
        if (i == 1) {
            if (this.egy != 2) {
                this.egy = 1;
            }
        } else if (i == 3 || i == 2) {
            this.egy = 2;
        }
    }

    private void aGh() {
        this.egy = 0;
    }
}
