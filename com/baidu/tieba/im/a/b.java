package com.baidu.tieba.im.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.coreExtra.websocketBase.g;
import com.baidu.tbadk.l.n;
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
    private static b dJp;
    private boolean dJD;
    private List<GroupUpdateMessage> dJx;
    private int dJq = 900000;
    private int dJr = 360000;
    private int dJs = this.dJr;
    private final int dJt = 0;
    private final int dJu = 1;
    private final int dJv = 2;
    private int dJw = 0;
    private int dJy = 0;
    private long dJz = 0;
    private int dJA = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dJB = null;
    private SparseArray<Long> dJC = null;
    private final com.baidu.adp.framework.client.socket.link.a om = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void d(Map<String, String> map) {
            b.this.start();
            f.cQ().c(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void C(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c dua = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aAM();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dJx = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aAg().aAf()) {
                            b.this.aAF();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.a.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    b.this.aAL();
                } else {
                    b.this.aAK();
                }
            }
        }
    };
    private final CustomMessageListener dJE = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dJB != null) {
                    b.this.dJB.clear();
                }
                if (b.this.dJC != null) {
                    b.this.dJC.clear();
                }
                b.this.dJx = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.BV().BW();
                    b.aAI().aAJ();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aAI().aAF();
                }
            }
        });
        dJp = null;
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
                    b.aAI().mHandler.removeMessages(2);
                    b.aAI().aAN();
                    return;
                case 3:
                    b.aAI().mHandler.removeMessages(3);
                    if (b.aAI().dJA == 3) {
                        b.aAI().aAO();
                    } else {
                        b.aAI().aAN();
                    }
                    b.aAI().mHandler.sendMessageDelayed(b.aAI().mHandler.obtainMessage(3), b.aAI().dJs);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().cV() > 10) {
            n.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int N = MessageManager.getInstance().getSocketClient().N(202003);
        if (a2 || N > 0) {
            n.d(false, false, true);
            no(i);
            return;
        }
        aAQ();
        SparseArray<Long> sparseArray2 = null;
        if (sparseArray != null && sparseArray.size() > 0) {
            SparseArray<Long> sparseArray3 = new SparseArray<>();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                sparseArray3.put(keyAt, sparseArray.get(keyAt));
            }
            sparseArray2 = sparseArray3;
        }
        MessageSyncMessage b = b(sparseArray2, i);
        if (i == 3 || i == 2) {
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aAg().aAr());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dJB != null) {
                this.dJB.clear();
            }
            if (this.dJC != null) {
                this.dJC.clear();
            }
        }
    }

    public void aAF() {
        boolean z;
        if (this.dJx != null) {
            SparseArray<Long> aAq = com.baidu.tieba.im.memorycache.b.aAg().aAq();
            if (aAq == null) {
                this.dJx = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dJx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aAq.get(next.getGroupId()) != null) {
                    if (aAq.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dJA = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aAI().mHandler.sendMessageDelayed(aAI().mHandler.obtainMessage(3), aAI().dJs);
            }
            this.dJx = null;
        }
    }

    private void aAG() {
        if (this.dJw != 0) {
            if (this.dJw == 1) {
                b(0L, 0L, 0L);
            } else {
                aAN();
            }
        }
    }

    private void aAH() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aAI() {
        b bVar;
        synchronized (b.class) {
            if (dJp == null) {
                dJp = new b();
            }
            bVar = dJp;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dJE);
        g.Cd().a(this.om);
        MessageManager.getInstance().registerListener(1003, this.dua);
        MessageManager.getInstance().registerListener(1001, this.dua);
        MessageManager.getInstance().registerListener(202101, this.dua);
        aAJ();
    }

    public void aAJ() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            nl(socketGetMsgStratgy[0] * 1000);
            nm(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aAQ();
    }

    public void stop() {
        aAQ();
        aAH();
    }

    public void aAK() {
        this.dJs = this.dJr;
    }

    public void aAL() {
        aAI().dJs = aAI().dJq;
    }

    public void nl(int i) {
        if (i > 0) {
            this.dJr = i;
        }
    }

    public void nm(int i) {
        if (i > 0) {
            this.dJq = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aAM() {
        if (System.currentTimeMillis() - this.dJz >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dJy);
            pushCountMessage.setUpFlowSize(h.hU().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hU().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dJz = System.currentTimeMillis();
            this.dJy = 0;
            h.hU().ib();
            h.hU().ia();
            TbadkCoreApplication.getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(SparseArray<Long> sparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
            NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(sparseArray);
            if (makeNewpushRepair != null) {
                messageSyncMessage.setNewpushRepire(makeNewpushRepair);
            }
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aAg().aAq());
        }
        messageSyncMessage.setForTimer(this.dJD);
        LocalViewSize.ImageSize uJ = LocalViewSize.uG().uJ();
        if (uJ != null) {
            messageSyncMessage.setWidth(uJ.width);
            messageSyncMessage.setHeight(uJ.height);
        }
        LocalViewSize.ImageSize uI = LocalViewSize.uG().uI();
        if (uI != null) {
            messageSyncMessage.setSmallHeight(uI.height);
            messageSyncMessage.setSmallWidth(uI.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dJy++;
        this.dJD = false;
        this.dJA = 1;
        this.mHandler.removeMessages(3);
        aAI().mHandler.sendMessageDelayed(aAI().mHandler.obtainMessage(3), aAI().dJs);
        if (this.dJB == null) {
            this.dJB = new SparseArray<>();
            this.dJB.clear();
        }
        if (this.dJC == null) {
            this.dJC = new SparseArray<>();
        }
        SparseArray<Long> aAq = com.baidu.tieba.im.memorycache.b.aAg().aAq();
        if (0 != j) {
            Long l = aAq.get((int) j);
            Long l2 = this.dJB.get((int) j);
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
                this.dJB.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dJB != null && this.dJB.size() > 0) {
            for (int i = 0; i < this.dJB.size(); i++) {
                int keyAt = this.dJB.keyAt(i);
                Long l3 = aAq.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dJB.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dJC.get((int) j) == null) {
                    this.dJC.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dJC.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dJC.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dJB.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dJB.keyAt(i2);
                long longValue3 = this.dJB.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dJC.get(keyAt2) != null) {
                    j4 = this.dJC.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dJB.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dJB.size() == 0) {
            aAQ();
            this.dJC.clear();
        } else {
            a(this.dJB, 1);
        }
    }

    public synchronized void aAN() {
        nn(2);
    }

    public synchronized void aAO() {
        nn(3);
    }

    public void aAP() {
        aAG();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dJD = false;
                this.dJA = 4;
                this.mHandler.removeMessages(3);
                aAI().mHandler.sendMessageDelayed(aAI().mHandler.obtainMessage(3), aAI().dJs);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void nn(int i) {
        this.dJD = true;
        this.dJA = i;
        a((SparseArray<Long>) null, i);
    }

    private void no(int i) {
        if (i == 1) {
            if (this.dJw != 2) {
                this.dJw = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dJw = 2;
        }
    }

    private void aAQ() {
        this.dJw = 0;
    }
}
