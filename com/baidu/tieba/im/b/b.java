package com.baidu.tieba.im.b;

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
    private static b duI;
    private List<GroupUpdateMessage> duQ;
    private boolean duW;
    private int duJ = 900000;
    private int duK = 360000;
    private int duL = this.duK;
    private final int duM = 0;
    private final int duN = 1;
    private final int duO = 2;
    private int duP = 0;
    private int duR = 0;
    private long duS = 0;
    private int duT = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> duU = null;
    private SparseArray<Long> duV = null;
    private final com.baidu.adp.framework.client.socket.link.a oR = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.b.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void d(Map<String, String> map) {
            b.this.start();
            f.cP().c(map);
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
    private final com.baidu.adp.framework.listener.c dfa = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.awT();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.duQ = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.awn().awm()) {
                            b.this.awM();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.b.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    b.this.awS();
                } else {
                    b.this.awR();
                }
            }
        }
    };
    private final CustomMessageListener duX = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.duU != null) {
                    b.this.duU.clear();
                }
                if (b.this.duV != null) {
                    b.this.duV.clear();
                }
                b.this.duQ = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.BV().BW();
                    b.awP().awQ();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.awP().awM();
                }
            }
        });
        duI = null;
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
                    b.awP().mHandler.removeMessages(2);
                    b.awP().awU();
                    return;
                case 3:
                    b.awP().mHandler.removeMessages(3);
                    if (b.awP().duT == 3) {
                        b.awP().awV();
                    } else {
                        b.awP().awU();
                    }
                    b.awP().mHandler.sendMessageDelayed(b.awP().mHandler.obtainMessage(3), b.awP().duL);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().cU() > 10) {
            n.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int N = MessageManager.getInstance().getSocketClient().N(202003);
        if (a2 || N > 0) {
            n.d(false, false, true);
            mw(i);
            return;
        }
        awX();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.awn().awy());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.duU != null) {
                this.duU.clear();
            }
            if (this.duV != null) {
                this.duV.clear();
            }
        }
    }

    public void awM() {
        boolean z;
        if (this.duQ != null) {
            SparseArray<Long> awx = com.baidu.tieba.im.memorycache.b.awn().awx();
            if (awx == null) {
                this.duQ = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.duQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && awx.get(next.getGroupId()) != null) {
                    if (awx.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.duT = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                awP().mHandler.sendMessageDelayed(awP().mHandler.obtainMessage(3), awP().duL);
            }
            this.duQ = null;
        }
    }

    private void awN() {
        if (this.duP != 0) {
            if (this.duP == 1) {
                a(0L, 0L, 0L);
            } else {
                awU();
            }
        }
    }

    private void awO() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b awP() {
        b bVar;
        synchronized (b.class) {
            if (duI == null) {
                duI = new b();
            }
            bVar = duI;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.duX);
        g.Cd().a(this.oR);
        MessageManager.getInstance().registerListener(1003, this.dfa);
        MessageManager.getInstance().registerListener(1001, this.dfa);
        MessageManager.getInstance().registerListener(202101, this.dfa);
        awQ();
    }

    public void awQ() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            mt(socketGetMsgStratgy[0] * 1000);
            mu(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        awX();
    }

    public void stop() {
        awX();
        awO();
    }

    public void awR() {
        this.duL = this.duK;
    }

    public void awS() {
        awP().duL = awP().duJ;
    }

    public void mt(int i) {
        if (i > 0) {
            this.duK = i;
        }
    }

    public void mu(int i) {
        if (i > 0) {
            this.duJ = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void awT() {
        if (System.currentTimeMillis() - this.duS >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.duR);
            pushCountMessage.setUpFlowSize(h.hU().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hU().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.duS = System.currentTimeMillis();
            this.duR = 0;
            h.hU().ia();
            h.hU().hZ();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.awn().awx());
        }
        messageSyncMessage.setForTimer(this.duW);
        LocalViewSize.ImageSize uX = LocalViewSize.uU().uX();
        if (uX != null) {
            messageSyncMessage.setWidth(uX.width);
            messageSyncMessage.setHeight(uX.height);
        }
        LocalViewSize.ImageSize uW = LocalViewSize.uU().uW();
        if (uW != null) {
            messageSyncMessage.setSmallHeight(uW.height);
            messageSyncMessage.setSmallWidth(uW.width);
        }
        String avT = com.baidu.tieba.im.a.c.avW().avT();
        if (avT == null) {
            avT = "0";
        }
        messageSyncMessage.setNotifyMaxTime(avT);
        String avU = com.baidu.tieba.im.a.c.avW().avU();
        if (avU == null) {
            avU = "0";
        }
        messageSyncMessage.setNotifyMinTime(avU);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.avW().awb()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.duR++;
        this.duW = false;
        this.duT = 1;
        this.mHandler.removeMessages(3);
        awP().mHandler.sendMessageDelayed(awP().mHandler.obtainMessage(3), awP().duL);
        if (this.duU == null) {
            this.duU = new SparseArray<>();
            this.duU.clear();
        }
        if (this.duV == null) {
            this.duV = new SparseArray<>();
        }
        SparseArray<Long> awx = com.baidu.tieba.im.memorycache.b.awn().awx();
        if (0 != j) {
            Long l = awx.get((int) j);
            Long l2 = this.duU.get((int) j);
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
                this.duU.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.duU != null && this.duU.size() > 0) {
            for (int i = 0; i < this.duU.size(); i++) {
                int keyAt = this.duU.keyAt(i);
                Long l3 = awx.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.duU.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.duV.get((int) j) == null) {
                    this.duV.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.duV.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.duV.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.duU.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.duU.keyAt(i2);
                long longValue3 = this.duU.valueAt(i2).longValue();
                long j4 = 0;
                if (this.duV.get(keyAt2) != null) {
                    j4 = this.duV.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.duU.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.duU.size() == 0) {
            awX();
            this.duV.clear();
        } else {
            a(this.duU, 1);
        }
    }

    public synchronized void awU() {
        mv(2);
    }

    public synchronized void awV() {
        mv(3);
    }

    public void awW() {
        awN();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.duW = false;
                this.duT = 4;
                this.mHandler.removeMessages(3);
                awP().mHandler.sendMessageDelayed(awP().mHandler.obtainMessage(3), awP().duL);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void mv(int i) {
        this.duW = true;
        this.duT = i;
        a((SparseArray<Long>) null, i);
    }

    private void mw(int i) {
        if (i == 1) {
            if (this.duP != 2) {
                this.duP = 1;
            }
        } else if (i == 3 || i == 2) {
            this.duP = 2;
        }
    }

    private void awX() {
        this.duP = 0;
    }
}
