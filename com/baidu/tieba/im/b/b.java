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
import com.baidu.tbadk.k.n;
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
    private static b dBK;
    private List<GroupUpdateMessage> dBS;
    private boolean dBY;
    private int dBL = 900000;
    private int dBM = 360000;
    private int dBN = this.dBM;
    private final int dBO = 0;
    private final int dBP = 1;
    private final int dBQ = 2;
    private int dBR = 0;
    private int dBT = 0;
    private long dBU = 0;
    private int dBV = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dBW = null;
    private SparseArray<Long> dBX = null;
    private final com.baidu.adp.framework.client.socket.link.a ol = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.b.b.3
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
    private final com.baidu.adp.framework.listener.c dmd = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.ays();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dBS = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.axM().axL()) {
                            b.this.ayl();
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
                    b.this.ayr();
                } else {
                    b.this.ayq();
                }
            }
        }
    };
    private final CustomMessageListener dBZ = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dBW != null) {
                    b.this.dBW.clear();
                }
                if (b.this.dBX != null) {
                    b.this.dBX.clear();
                }
                b.this.dBS = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.BB().BC();
                    b.ayo().ayp();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.ayo().ayl();
                }
            }
        });
        dBK = null;
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
                    b.ayo().mHandler.removeMessages(2);
                    b.ayo().ayt();
                    return;
                case 3:
                    b.ayo().mHandler.removeMessages(3);
                    if (b.ayo().dBV == 3) {
                        b.ayo().ayu();
                    } else {
                        b.ayo().ayt();
                    }
                    b.ayo().mHandler.sendMessageDelayed(b.ayo().mHandler.obtainMessage(3), b.ayo().dBN);
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
            mX(i);
            return;
        }
        ayw();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.axM().axX());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dBW != null) {
                this.dBW.clear();
            }
            if (this.dBX != null) {
                this.dBX.clear();
            }
        }
    }

    public void ayl() {
        boolean z;
        if (this.dBS != null) {
            SparseArray<Long> axW = com.baidu.tieba.im.memorycache.b.axM().axW();
            if (axW == null) {
                this.dBS = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dBS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && axW.get(next.getGroupId()) != null) {
                    if (axW.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dBV = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                ayo().mHandler.sendMessageDelayed(ayo().mHandler.obtainMessage(3), ayo().dBN);
            }
            this.dBS = null;
        }
    }

    private void aym() {
        if (this.dBR != 0) {
            if (this.dBR == 1) {
                a(0L, 0L, 0L);
            } else {
                ayt();
            }
        }
    }

    private void ayn() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b ayo() {
        b bVar;
        synchronized (b.class) {
            if (dBK == null) {
                dBK = new b();
            }
            bVar = dBK;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dBZ);
        g.BJ().a(this.ol);
        MessageManager.getInstance().registerListener(1003, this.dmd);
        MessageManager.getInstance().registerListener(1001, this.dmd);
        MessageManager.getInstance().registerListener(202101, this.dmd);
        ayp();
    }

    public void ayp() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            mU(socketGetMsgStratgy[0] * 1000);
            mV(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        ayw();
    }

    public void stop() {
        ayw();
        ayn();
    }

    public void ayq() {
        this.dBN = this.dBM;
    }

    public void ayr() {
        ayo().dBN = ayo().dBL;
    }

    public void mU(int i) {
        if (i > 0) {
            this.dBM = i;
        }
    }

    public void mV(int i) {
        if (i > 0) {
            this.dBL = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ays() {
        if (System.currentTimeMillis() - this.dBU >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dBT);
            pushCountMessage.setUpFlowSize(h.hU().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hU().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dBU = System.currentTimeMillis();
            this.dBT = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.axM().axW());
        }
        messageSyncMessage.setForTimer(this.dBY);
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
        String axs = com.baidu.tieba.im.a.c.axv().axs();
        if (axs == null) {
            axs = "0";
        }
        messageSyncMessage.setNotifyMaxTime(axs);
        String axt = com.baidu.tieba.im.a.c.axv().axt();
        if (axt == null) {
            axt = "0";
        }
        messageSyncMessage.setNotifyMinTime(axt);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.axv().axA()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dBT++;
        this.dBY = false;
        this.dBV = 1;
        this.mHandler.removeMessages(3);
        ayo().mHandler.sendMessageDelayed(ayo().mHandler.obtainMessage(3), ayo().dBN);
        if (this.dBW == null) {
            this.dBW = new SparseArray<>();
            this.dBW.clear();
        }
        if (this.dBX == null) {
            this.dBX = new SparseArray<>();
        }
        SparseArray<Long> axW = com.baidu.tieba.im.memorycache.b.axM().axW();
        if (0 != j) {
            Long l = axW.get((int) j);
            Long l2 = this.dBW.get((int) j);
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
                this.dBW.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dBW != null && this.dBW.size() > 0) {
            for (int i = 0; i < this.dBW.size(); i++) {
                int keyAt = this.dBW.keyAt(i);
                Long l3 = axW.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dBW.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dBX.get((int) j) == null) {
                    this.dBX.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dBX.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dBX.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dBW.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dBW.keyAt(i2);
                long longValue3 = this.dBW.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dBX.get(keyAt2) != null) {
                    j4 = this.dBX.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dBW.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dBW.size() == 0) {
            ayw();
            this.dBX.clear();
        } else {
            a(this.dBW, 1);
        }
    }

    public synchronized void ayt() {
        mW(2);
    }

    public synchronized void ayu() {
        mW(3);
    }

    public void ayv() {
        aym();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dBY = false;
                this.dBV = 4;
                this.mHandler.removeMessages(3);
                ayo().mHandler.sendMessageDelayed(ayo().mHandler.obtainMessage(3), ayo().dBN);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void mW(int i) {
        this.dBY = true;
        this.dBV = i;
        a((SparseArray<Long>) null, i);
    }

    private void mX(int i) {
        if (i == 1) {
            if (this.dBR != 2) {
                this.dBR = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dBR = 2;
        }
    }

    private void ayw() {
        this.dBR = 0;
    }
}
