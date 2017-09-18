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
    private static b dFv;
    private List<GroupUpdateMessage> dFD;
    private boolean dFJ;
    private int dFw = 900000;
    private int dFx = 360000;
    private int dFy = this.dFx;
    private final int dFz = 0;
    private final int dFA = 1;
    private final int dFB = 2;
    private int dFC = 0;
    private int dFE = 0;
    private long dFF = 0;
    private int dFG = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dFH = null;
    private SparseArray<Long> dFI = null;
    private final com.baidu.adp.framework.client.socket.link.a oj = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.b.b.3
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
    private final com.baidu.adp.framework.listener.c dpO = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.azG();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dFD = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aza().ayZ()) {
                            b.this.azz();
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
                    b.this.azF();
                } else {
                    b.this.azE();
                }
            }
        }
    };
    private final CustomMessageListener dFK = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dFH != null) {
                    b.this.dFH.clear();
                }
                if (b.this.dFI != null) {
                    b.this.dFI.clear();
                }
                b.this.dFD = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.BY().BZ();
                    b.azC().azD();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.azC().azz();
                }
            }
        });
        dFv = null;
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
                    b.azC().mHandler.removeMessages(2);
                    b.azC().azH();
                    return;
                case 3:
                    b.azC().mHandler.removeMessages(3);
                    if (b.azC().dFG == 3) {
                        b.azC().azI();
                    } else {
                        b.azC().azH();
                    }
                    b.azC().mHandler.sendMessageDelayed(b.azC().mHandler.obtainMessage(3), b.azC().dFy);
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
            nb(i);
            return;
        }
        azK();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aza().azl());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dFH != null) {
                this.dFH.clear();
            }
            if (this.dFI != null) {
                this.dFI.clear();
            }
        }
    }

    public void azz() {
        boolean z;
        if (this.dFD != null) {
            SparseArray<Long> azk = com.baidu.tieba.im.memorycache.b.aza().azk();
            if (azk == null) {
                this.dFD = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dFD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && azk.get(next.getGroupId()) != null) {
                    if (azk.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dFG = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                azC().mHandler.sendMessageDelayed(azC().mHandler.obtainMessage(3), azC().dFy);
            }
            this.dFD = null;
        }
    }

    private void azA() {
        if (this.dFC != 0) {
            if (this.dFC == 1) {
                a(0L, 0L, 0L);
            } else {
                azH();
            }
        }
    }

    private void azB() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b azC() {
        b bVar;
        synchronized (b.class) {
            if (dFv == null) {
                dFv = new b();
            }
            bVar = dFv;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dFK);
        g.Cg().a(this.oj);
        MessageManager.getInstance().registerListener(1003, this.dpO);
        MessageManager.getInstance().registerListener(1001, this.dpO);
        MessageManager.getInstance().registerListener(202101, this.dpO);
        azD();
    }

    public void azD() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            mY(socketGetMsgStratgy[0] * 1000);
            mZ(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        azK();
    }

    public void stop() {
        azK();
        azB();
    }

    public void azE() {
        this.dFy = this.dFx;
    }

    public void azF() {
        azC().dFy = azC().dFw;
    }

    public void mY(int i) {
        if (i > 0) {
            this.dFx = i;
        }
    }

    public void mZ(int i) {
        if (i > 0) {
            this.dFw = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void azG() {
        if (System.currentTimeMillis() - this.dFF >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dFE);
            pushCountMessage.setUpFlowSize(h.hV().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hV().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dFF = System.currentTimeMillis();
            this.dFE = 0;
            h.hV().ic();
            h.hV().ib();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aza().azk());
        }
        messageSyncMessage.setForTimer(this.dFJ);
        LocalViewSize.ImageSize vf = LocalViewSize.vc().vf();
        if (vf != null) {
            messageSyncMessage.setWidth(vf.width);
            messageSyncMessage.setHeight(vf.height);
        }
        LocalViewSize.ImageSize ve = LocalViewSize.vc().ve();
        if (ve != null) {
            messageSyncMessage.setSmallHeight(ve.height);
            messageSyncMessage.setSmallWidth(ve.width);
        }
        String ayG = com.baidu.tieba.im.a.c.ayJ().ayG();
        if (ayG == null) {
            ayG = "0";
        }
        messageSyncMessage.setNotifyMaxTime(ayG);
        String ayH = com.baidu.tieba.im.a.c.ayJ().ayH();
        if (ayH == null) {
            ayH = "0";
        }
        messageSyncMessage.setNotifyMinTime(ayH);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.ayJ().ayO()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dFE++;
        this.dFJ = false;
        this.dFG = 1;
        this.mHandler.removeMessages(3);
        azC().mHandler.sendMessageDelayed(azC().mHandler.obtainMessage(3), azC().dFy);
        if (this.dFH == null) {
            this.dFH = new SparseArray<>();
            this.dFH.clear();
        }
        if (this.dFI == null) {
            this.dFI = new SparseArray<>();
        }
        SparseArray<Long> azk = com.baidu.tieba.im.memorycache.b.aza().azk();
        if (0 != j) {
            Long l = azk.get((int) j);
            Long l2 = this.dFH.get((int) j);
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
                this.dFH.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dFH != null && this.dFH.size() > 0) {
            for (int i = 0; i < this.dFH.size(); i++) {
                int keyAt = this.dFH.keyAt(i);
                Long l3 = azk.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dFH.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dFI.get((int) j) == null) {
                    this.dFI.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dFI.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dFI.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dFH.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dFH.keyAt(i2);
                long longValue3 = this.dFH.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dFI.get(keyAt2) != null) {
                    j4 = this.dFI.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dFH.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dFH.size() == 0) {
            azK();
            this.dFI.clear();
        } else {
            a(this.dFH, 1);
        }
    }

    public synchronized void azH() {
        na(2);
    }

    public synchronized void azI() {
        na(3);
    }

    public void azJ() {
        azA();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dFJ = false;
                this.dFG = 4;
                this.mHandler.removeMessages(3);
                azC().mHandler.sendMessageDelayed(azC().mHandler.obtainMessage(3), azC().dFy);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void na(int i) {
        this.dFJ = true;
        this.dFG = i;
        a((SparseArray<Long>) null, i);
    }

    private void nb(int i) {
        if (i == 1) {
            if (this.dFC != 2) {
                this.dFC = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dFC = 2;
        }
    }

    private void azK() {
        this.dFC = 0;
    }
}
