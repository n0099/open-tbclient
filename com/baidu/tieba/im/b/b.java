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
    private static b dBw;
    private List<GroupUpdateMessage> dBE;
    private boolean dBK;
    private int dBx = 900000;
    private int dBy = 360000;
    private int dBz = this.dBy;
    private final int dBA = 0;
    private final int dBB = 1;
    private final int dBC = 2;
    private int dBD = 0;
    private int dBF = 0;
    private long dBG = 0;
    private int dBH = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dBI = null;
    private SparseArray<Long> dBJ = null;
    private final com.baidu.adp.framework.client.socket.link.a om = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.b.b.3
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
    private final com.baidu.adp.framework.listener.c dlQ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.ayn();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dBE = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.axH().axG()) {
                            b.this.ayg();
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
                    b.this.aym();
                } else {
                    b.this.ayl();
                }
            }
        }
    };
    private final CustomMessageListener dBL = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dBI != null) {
                    b.this.dBI.clear();
                }
                if (b.this.dBJ != null) {
                    b.this.dBJ.clear();
                }
                b.this.dBE = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Bv().Bw();
                    b.ayj().ayk();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.ayj().ayg();
                }
            }
        });
        dBw = null;
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
                    b.ayj().mHandler.removeMessages(2);
                    b.ayj().ayo();
                    return;
                case 3:
                    b.ayj().mHandler.removeMessages(3);
                    if (b.ayj().dBH == 3) {
                        b.ayj().ayp();
                    } else {
                        b.ayj().ayo();
                    }
                    b.ayj().mHandler.sendMessageDelayed(b.ayj().mHandler.obtainMessage(3), b.ayj().dBz);
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
            mW(i);
            return;
        }
        ayr();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.axH().axS());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dBI != null) {
                this.dBI.clear();
            }
            if (this.dBJ != null) {
                this.dBJ.clear();
            }
        }
    }

    public void ayg() {
        boolean z;
        if (this.dBE != null) {
            SparseArray<Long> axR = com.baidu.tieba.im.memorycache.b.axH().axR();
            if (axR == null) {
                this.dBE = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dBE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && axR.get(next.getGroupId()) != null) {
                    if (axR.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dBH = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                ayj().mHandler.sendMessageDelayed(ayj().mHandler.obtainMessage(3), ayj().dBz);
            }
            this.dBE = null;
        }
    }

    private void ayh() {
        if (this.dBD != 0) {
            if (this.dBD == 1) {
                a(0L, 0L, 0L);
            } else {
                ayo();
            }
        }
    }

    private void ayi() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b ayj() {
        b bVar;
        synchronized (b.class) {
            if (dBw == null) {
                dBw = new b();
            }
            bVar = dBw;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dBL);
        g.BD().a(this.om);
        MessageManager.getInstance().registerListener(1003, this.dlQ);
        MessageManager.getInstance().registerListener(1001, this.dlQ);
        MessageManager.getInstance().registerListener(202101, this.dlQ);
        ayk();
    }

    public void ayk() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            mT(socketGetMsgStratgy[0] * 1000);
            mU(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        ayr();
    }

    public void stop() {
        ayr();
        ayi();
    }

    public void ayl() {
        this.dBz = this.dBy;
    }

    public void aym() {
        ayj().dBz = ayj().dBx;
    }

    public void mT(int i) {
        if (i > 0) {
            this.dBy = i;
        }
    }

    public void mU(int i) {
        if (i > 0) {
            this.dBx = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ayn() {
        if (System.currentTimeMillis() - this.dBG >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dBF);
            pushCountMessage.setUpFlowSize(h.hU().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hU().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dBG = System.currentTimeMillis();
            this.dBF = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.axH().axR());
        }
        messageSyncMessage.setForTimer(this.dBK);
        LocalViewSize.ImageSize uC = LocalViewSize.uz().uC();
        if (uC != null) {
            messageSyncMessage.setWidth(uC.width);
            messageSyncMessage.setHeight(uC.height);
        }
        LocalViewSize.ImageSize uB = LocalViewSize.uz().uB();
        if (uB != null) {
            messageSyncMessage.setSmallHeight(uB.height);
            messageSyncMessage.setSmallWidth(uB.width);
        }
        String axn = com.baidu.tieba.im.a.c.axq().axn();
        if (axn == null) {
            axn = "0";
        }
        messageSyncMessage.setNotifyMaxTime(axn);
        String axo = com.baidu.tieba.im.a.c.axq().axo();
        if (axo == null) {
            axo = "0";
        }
        messageSyncMessage.setNotifyMinTime(axo);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.axq().axv()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dBF++;
        this.dBK = false;
        this.dBH = 1;
        this.mHandler.removeMessages(3);
        ayj().mHandler.sendMessageDelayed(ayj().mHandler.obtainMessage(3), ayj().dBz);
        if (this.dBI == null) {
            this.dBI = new SparseArray<>();
            this.dBI.clear();
        }
        if (this.dBJ == null) {
            this.dBJ = new SparseArray<>();
        }
        SparseArray<Long> axR = com.baidu.tieba.im.memorycache.b.axH().axR();
        if (0 != j) {
            Long l = axR.get((int) j);
            Long l2 = this.dBI.get((int) j);
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
                this.dBI.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dBI != null && this.dBI.size() > 0) {
            for (int i = 0; i < this.dBI.size(); i++) {
                int keyAt = this.dBI.keyAt(i);
                Long l3 = axR.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dBI.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dBJ.get((int) j) == null) {
                    this.dBJ.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dBJ.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dBJ.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dBI.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dBI.keyAt(i2);
                long longValue3 = this.dBI.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dBJ.get(keyAt2) != null) {
                    j4 = this.dBJ.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dBI.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dBI.size() == 0) {
            ayr();
            this.dBJ.clear();
        } else {
            a(this.dBI, 1);
        }
    }

    public synchronized void ayo() {
        mV(2);
    }

    public synchronized void ayp() {
        mV(3);
    }

    public void ayq() {
        ayh();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dBK = false;
                this.dBH = 4;
                this.mHandler.removeMessages(3);
                ayj().mHandler.sendMessageDelayed(ayj().mHandler.obtainMessage(3), ayj().dBz);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void mV(int i) {
        this.dBK = true;
        this.dBH = i;
        a((SparseArray<Long>) null, i);
    }

    private void mW(int i) {
        if (i == 1) {
            if (this.dBD != 2) {
                this.dBD = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dBD = 2;
        }
    }

    private void ayr() {
        this.dBD = 0;
    }
}
