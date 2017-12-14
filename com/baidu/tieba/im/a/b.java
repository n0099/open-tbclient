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
    private static b dSi;
    private List<GroupUpdateMessage> dSq;
    private boolean dSw;
    private int dSj = 900000;
    private int dSk = 360000;
    private int dSl = this.dSk;
    private final int dSm = 0;
    private final int dSn = 1;
    private final int dSo = 2;
    private int dSp = 0;
    private int dSr = 0;
    private long dSs = 0;
    private int dSt = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dSu = null;
    private SparseArray<Long> dSv = null;
    private final com.baidu.adp.framework.client.socket.link.a ol = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c dCR = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aCv();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dSq = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aBP().aBO()) {
                            b.this.aCo();
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
                    b.this.aCu();
                } else {
                    b.this.aCt();
                }
            }
        }
    };
    private final CustomMessageListener dSx = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dSu != null) {
                    b.this.dSu.clear();
                }
                if (b.this.dSv != null) {
                    b.this.dSv.clear();
                }
                b.this.dSq = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Cg().Ch();
                    b.aCr().aCs();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aCr().aCo();
                }
            }
        });
        dSi = null;
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
                    b.aCr().mHandler.removeMessages(2);
                    b.aCr().aCw();
                    return;
                case 3:
                    b.aCr().mHandler.removeMessages(3);
                    if (b.aCr().dSt == 3) {
                        b.aCr().aCx();
                    } else {
                        b.aCr().aCw();
                    }
                    b.aCr().mHandler.sendMessageDelayed(b.aCr().mHandler.obtainMessage(3), b.aCr().dSl);
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
        int M = MessageManager.getInstance().getSocketClient().M(202003);
        if (a2 || M > 0) {
            n.d(false, false, true);
            nJ(i);
            return;
        }
        aCz();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aBP().aCa());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dSu != null) {
                this.dSu.clear();
            }
            if (this.dSv != null) {
                this.dSv.clear();
            }
        }
    }

    public void aCo() {
        boolean z;
        if (this.dSq != null) {
            SparseArray<Long> aBZ = com.baidu.tieba.im.memorycache.b.aBP().aBZ();
            if (aBZ == null) {
                this.dSq = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dSq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aBZ.get(next.getGroupId()) != null) {
                    if (aBZ.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dSt = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aCr().mHandler.sendMessageDelayed(aCr().mHandler.obtainMessage(3), aCr().dSl);
            }
            this.dSq = null;
        }
    }

    private void aCp() {
        if (this.dSp != 0) {
            if (this.dSp == 1) {
                b(0L, 0L, 0L);
            } else {
                aCw();
            }
        }
    }

    private void aCq() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aCr() {
        b bVar;
        synchronized (b.class) {
            if (dSi == null) {
                dSi = new b();
            }
            bVar = dSi;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dSx);
        g.Co().a(this.ol);
        MessageManager.getInstance().registerListener(1003, this.dCR);
        MessageManager.getInstance().registerListener(1001, this.dCR);
        MessageManager.getInstance().registerListener(202101, this.dCR);
        aCs();
    }

    public void aCs() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            nG(socketGetMsgStratgy[0] * 1000);
            nH(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aCz();
    }

    public void stop() {
        aCz();
        aCq();
    }

    public void aCt() {
        this.dSl = this.dSk;
    }

    public void aCu() {
        aCr().dSl = aCr().dSj;
    }

    public void nG(int i) {
        if (i > 0) {
            this.dSk = i;
        }
    }

    public void nH(int i) {
        if (i > 0) {
            this.dSj = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aCv() {
        if (System.currentTimeMillis() - this.dSs >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dSr);
            pushCountMessage.setUpFlowSize(h.hU().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hU().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dSs = System.currentTimeMillis();
            this.dSr = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aBP().aBZ());
        }
        messageSyncMessage.setForTimer(this.dSw);
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
        this.dSr++;
        this.dSw = false;
        this.dSt = 1;
        this.mHandler.removeMessages(3);
        aCr().mHandler.sendMessageDelayed(aCr().mHandler.obtainMessage(3), aCr().dSl);
        if (this.dSu == null) {
            this.dSu = new SparseArray<>();
            this.dSu.clear();
        }
        if (this.dSv == null) {
            this.dSv = new SparseArray<>();
        }
        SparseArray<Long> aBZ = com.baidu.tieba.im.memorycache.b.aBP().aBZ();
        if (0 != j) {
            Long l = aBZ.get((int) j);
            Long l2 = this.dSu.get((int) j);
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
                this.dSu.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dSu != null && this.dSu.size() > 0) {
            for (int i = 0; i < this.dSu.size(); i++) {
                int keyAt = this.dSu.keyAt(i);
                Long l3 = aBZ.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dSu.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dSv.get((int) j) == null) {
                    this.dSv.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dSv.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dSv.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dSu.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dSu.keyAt(i2);
                long longValue3 = this.dSu.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dSv.get(keyAt2) != null) {
                    j4 = this.dSv.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dSu.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dSu.size() == 0) {
            aCz();
            this.dSv.clear();
        } else {
            a(this.dSu, 1);
        }
    }

    public synchronized void aCw() {
        nI(2);
    }

    public synchronized void aCx() {
        nI(3);
    }

    public void aCy() {
        aCp();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dSw = false;
                this.dSt = 4;
                this.mHandler.removeMessages(3);
                aCr().mHandler.sendMessageDelayed(aCr().mHandler.obtainMessage(3), aCr().dSl);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void nI(int i) {
        this.dSw = true;
        this.dSt = i;
        a((SparseArray<Long>) null, i);
    }

    private void nJ(int i) {
        if (i == 1) {
            if (this.dSp != 2) {
                this.dSp = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dSp = 2;
        }
    }

    private void aCz() {
        this.dSp = 0;
    }
}
