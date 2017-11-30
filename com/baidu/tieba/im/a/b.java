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
    private static b dRd;
    private List<GroupUpdateMessage> dRl;
    private boolean dRr;
    private int dRe = 900000;
    private int dRf = 360000;
    private int dRg = this.dRf;
    private final int dRh = 0;
    private final int dRi = 1;
    private final int dRj = 2;
    private int dRk = 0;
    private int dRm = 0;
    private long dRn = 0;
    private int dRo = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dRp = null;
    private SparseArray<Long> dRq = null;
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
    private final com.baidu.adp.framework.listener.c dBN = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aCm();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dRl = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aBG().aBF()) {
                            b.this.aCf();
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
                    b.this.aCl();
                } else {
                    b.this.aCk();
                }
            }
        }
    };
    private final CustomMessageListener dRs = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dRp != null) {
                    b.this.dRp.clear();
                }
                if (b.this.dRq != null) {
                    b.this.dRq.clear();
                }
                b.this.dRl = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Cf().Cg();
                    b.aCi().aCj();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aCi().aCf();
                }
            }
        });
        dRd = null;
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
                    b.aCi().mHandler.removeMessages(2);
                    b.aCi().aCn();
                    return;
                case 3:
                    b.aCi().mHandler.removeMessages(3);
                    if (b.aCi().dRo == 3) {
                        b.aCi().aCo();
                    } else {
                        b.aCi().aCn();
                    }
                    b.aCi().mHandler.sendMessageDelayed(b.aCi().mHandler.obtainMessage(3), b.aCi().dRg);
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
            nC(i);
            return;
        }
        aCq();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aBG().aBR());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dRp != null) {
                this.dRp.clear();
            }
            if (this.dRq != null) {
                this.dRq.clear();
            }
        }
    }

    public void aCf() {
        boolean z;
        if (this.dRl != null) {
            SparseArray<Long> aBQ = com.baidu.tieba.im.memorycache.b.aBG().aBQ();
            if (aBQ == null) {
                this.dRl = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dRl.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aBQ.get(next.getGroupId()) != null) {
                    if (aBQ.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dRo = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aCi().mHandler.sendMessageDelayed(aCi().mHandler.obtainMessage(3), aCi().dRg);
            }
            this.dRl = null;
        }
    }

    private void aCg() {
        if (this.dRk != 0) {
            if (this.dRk == 1) {
                b(0L, 0L, 0L);
            } else {
                aCn();
            }
        }
    }

    private void aCh() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aCi() {
        b bVar;
        synchronized (b.class) {
            if (dRd == null) {
                dRd = new b();
            }
            bVar = dRd;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dRs);
        g.Cn().a(this.om);
        MessageManager.getInstance().registerListener(1003, this.dBN);
        MessageManager.getInstance().registerListener(1001, this.dBN);
        MessageManager.getInstance().registerListener(202101, this.dBN);
        aCj();
    }

    public void aCj() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            nz(socketGetMsgStratgy[0] * 1000);
            nA(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aCq();
    }

    public void stop() {
        aCq();
        aCh();
    }

    public void aCk() {
        this.dRg = this.dRf;
    }

    public void aCl() {
        aCi().dRg = aCi().dRe;
    }

    public void nz(int i) {
        if (i > 0) {
            this.dRf = i;
        }
    }

    public void nA(int i) {
        if (i > 0) {
            this.dRe = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aCm() {
        if (System.currentTimeMillis() - this.dRn >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dRm);
            pushCountMessage.setUpFlowSize(h.hU().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hU().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dRn = System.currentTimeMillis();
            this.dRm = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aBG().aBQ());
        }
        messageSyncMessage.setForTimer(this.dRr);
        LocalViewSize.ImageSize uM = LocalViewSize.uJ().uM();
        if (uM != null) {
            messageSyncMessage.setWidth(uM.width);
            messageSyncMessage.setHeight(uM.height);
        }
        LocalViewSize.ImageSize uL = LocalViewSize.uJ().uL();
        if (uL != null) {
            messageSyncMessage.setSmallHeight(uL.height);
            messageSyncMessage.setSmallWidth(uL.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dRm++;
        this.dRr = false;
        this.dRo = 1;
        this.mHandler.removeMessages(3);
        aCi().mHandler.sendMessageDelayed(aCi().mHandler.obtainMessage(3), aCi().dRg);
        if (this.dRp == null) {
            this.dRp = new SparseArray<>();
            this.dRp.clear();
        }
        if (this.dRq == null) {
            this.dRq = new SparseArray<>();
        }
        SparseArray<Long> aBQ = com.baidu.tieba.im.memorycache.b.aBG().aBQ();
        if (0 != j) {
            Long l = aBQ.get((int) j);
            Long l2 = this.dRp.get((int) j);
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
                this.dRp.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dRp != null && this.dRp.size() > 0) {
            for (int i = 0; i < this.dRp.size(); i++) {
                int keyAt = this.dRp.keyAt(i);
                Long l3 = aBQ.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dRp.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dRq.get((int) j) == null) {
                    this.dRq.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dRq.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dRq.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dRp.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dRp.keyAt(i2);
                long longValue3 = this.dRp.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dRq.get(keyAt2) != null) {
                    j4 = this.dRq.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dRp.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dRp.size() == 0) {
            aCq();
            this.dRq.clear();
        } else {
            a(this.dRp, 1);
        }
    }

    public synchronized void aCn() {
        nB(2);
    }

    public synchronized void aCo() {
        nB(3);
    }

    public void aCp() {
        aCg();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dRr = false;
                this.dRo = 4;
                this.mHandler.removeMessages(3);
                aCi().mHandler.sendMessageDelayed(aCi().mHandler.obtainMessage(3), aCi().dRg);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void nB(int i) {
        this.dRr = true;
        this.dRo = i;
        a((SparseArray<Long>) null, i);
    }

    private void nC(int i) {
        if (i == 1) {
            if (this.dRk != 2) {
                this.dRk = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dRk = 2;
        }
    }

    private void aCq() {
        this.dRk = 0;
    }
}
