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
    private static b dJk;
    private List<GroupUpdateMessage> dJs;
    private boolean dJy;
    private int dJl = 900000;
    private int dJm = 360000;
    private int dJn = this.dJm;
    private final int dJo = 0;
    private final int dJp = 1;
    private final int dJq = 2;
    private int dJr = 0;
    private int dJt = 0;
    private long dJu = 0;
    private int dJv = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dJw = null;
    private SparseArray<Long> dJx = null;
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
    private final com.baidu.adp.framework.listener.c dtG = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aAI();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dJs = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aAc().aAb()) {
                            b.this.aAB();
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
                    b.this.aAH();
                } else {
                    b.this.aAG();
                }
            }
        }
    };
    private final CustomMessageListener dJz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dJw != null) {
                    b.this.dJw.clear();
                }
                if (b.this.dJx != null) {
                    b.this.dJx.clear();
                }
                b.this.dJs = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.BJ().BK();
                    b.aAE().aAF();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aAE().aAB();
                }
            }
        });
        dJk = null;
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
                    b.aAE().mHandler.removeMessages(2);
                    b.aAE().aAJ();
                    return;
                case 3:
                    b.aAE().mHandler.removeMessages(3);
                    if (b.aAE().dJv == 3) {
                        b.aAE().aAK();
                    } else {
                        b.aAE().aAJ();
                    }
                    b.aAE().mHandler.sendMessageDelayed(b.aAE().mHandler.obtainMessage(3), b.aAE().dJn);
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
            nn(i);
            return;
        }
        aAM();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aAc().aAn());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dJw != null) {
                this.dJw.clear();
            }
            if (this.dJx != null) {
                this.dJx.clear();
            }
        }
    }

    public void aAB() {
        boolean z;
        if (this.dJs != null) {
            SparseArray<Long> aAm = com.baidu.tieba.im.memorycache.b.aAc().aAm();
            if (aAm == null) {
                this.dJs = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dJs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aAm.get(next.getGroupId()) != null) {
                    if (aAm.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dJv = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aAE().mHandler.sendMessageDelayed(aAE().mHandler.obtainMessage(3), aAE().dJn);
            }
            this.dJs = null;
        }
    }

    private void aAC() {
        if (this.dJr != 0) {
            if (this.dJr == 1) {
                b(0L, 0L, 0L);
            } else {
                aAJ();
            }
        }
    }

    private void aAD() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aAE() {
        b bVar;
        synchronized (b.class) {
            if (dJk == null) {
                dJk = new b();
            }
            bVar = dJk;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dJz);
        g.BR().a(this.om);
        MessageManager.getInstance().registerListener(1003, this.dtG);
        MessageManager.getInstance().registerListener(1001, this.dtG);
        MessageManager.getInstance().registerListener(202101, this.dtG);
        aAF();
    }

    public void aAF() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            nk(socketGetMsgStratgy[0] * 1000);
            nl(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aAM();
    }

    public void stop() {
        aAM();
        aAD();
    }

    public void aAG() {
        this.dJn = this.dJm;
    }

    public void aAH() {
        aAE().dJn = aAE().dJl;
    }

    public void nk(int i) {
        if (i > 0) {
            this.dJm = i;
        }
    }

    public void nl(int i) {
        if (i > 0) {
            this.dJl = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aAI() {
        if (System.currentTimeMillis() - this.dJu >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dJt);
            pushCountMessage.setUpFlowSize(h.hU().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hU().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dJu = System.currentTimeMillis();
            this.dJt = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aAc().aAm());
        }
        messageSyncMessage.setForTimer(this.dJy);
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
        String azI = com.baidu.tieba.im.a.c.azL().azI();
        if (azI == null) {
            azI = "0";
        }
        messageSyncMessage.setNotifyMaxTime(azI);
        String azJ = com.baidu.tieba.im.a.c.azL().azJ();
        if (azJ == null) {
            azJ = "0";
        }
        messageSyncMessage.setNotifyMinTime(azJ);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.azL().azQ()));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dJt++;
        this.dJy = false;
        this.dJv = 1;
        this.mHandler.removeMessages(3);
        aAE().mHandler.sendMessageDelayed(aAE().mHandler.obtainMessage(3), aAE().dJn);
        if (this.dJw == null) {
            this.dJw = new SparseArray<>();
            this.dJw.clear();
        }
        if (this.dJx == null) {
            this.dJx = new SparseArray<>();
        }
        SparseArray<Long> aAm = com.baidu.tieba.im.memorycache.b.aAc().aAm();
        if (0 != j) {
            Long l = aAm.get((int) j);
            Long l2 = this.dJw.get((int) j);
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
                this.dJw.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dJw != null && this.dJw.size() > 0) {
            for (int i = 0; i < this.dJw.size(); i++) {
                int keyAt = this.dJw.keyAt(i);
                Long l3 = aAm.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dJw.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dJx.get((int) j) == null) {
                    this.dJx.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dJx.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dJx.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dJw.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dJw.keyAt(i2);
                long longValue3 = this.dJw.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dJx.get(keyAt2) != null) {
                    j4 = this.dJx.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dJw.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dJw.size() == 0) {
            aAM();
            this.dJx.clear();
        } else {
            a(this.dJw, 1);
        }
    }

    public synchronized void aAJ() {
        nm(2);
    }

    public synchronized void aAK() {
        nm(3);
    }

    public void aAL() {
        aAC();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dJy = false;
                this.dJv = 4;
                this.mHandler.removeMessages(3);
                aAE().mHandler.sendMessageDelayed(aAE().mHandler.obtainMessage(3), aAE().dJn);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void nm(int i) {
        this.dJy = true;
        this.dJv = i;
        a((SparseArray<Long>) null, i);
    }

    private void nn(int i) {
        if (i == 1) {
            if (this.dJr != 2) {
                this.dJr = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dJr = 2;
        }
    }

    private void aAM() {
        this.dJr = 0;
    }
}
