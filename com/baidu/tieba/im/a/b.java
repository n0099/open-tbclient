package com.baidu.tieba.im.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
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
    private static b eEu;
    private List<GroupUpdateMessage> eEC;
    private boolean eEI;
    private int eEv = 900000;
    private int eEw = 360000;
    private int eEx = this.eEw;
    private final int eEy = 0;
    private final int eEz = 1;
    private final int eEA = 2;
    private int eEB = 0;
    private int eED = 0;
    private long eEE = 0;
    private int eEF = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> eEG = null;
    private SparseArray<Long> eEH = null;
    private final com.baidu.adp.framework.client.socket.link.a acV = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void d(Map<String, String> map) {
            b.this.start();
            f.ku().c(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void J(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c eoY = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aJw();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.eEC = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aIQ().aIP()) {
                            b.this.aJp();
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
                    b.this.aJv();
                } else {
                    b.this.aJu();
                }
            }
        }
    };
    private final CustomMessageListener eEJ = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.eEG != null) {
                    b.this.eEG.clear();
                }
                if (b.this.eEH != null) {
                    b.this.eEH.clear();
                }
                b.this.eEC = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.JI().JJ();
                    b.aJs().aJt();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aJs().aJp();
                }
            }
        });
        eEu = null;
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
                    b.aJs().mHandler.removeMessages(2);
                    b.aJs().aJx();
                    return;
                case 3:
                    b.aJs().mHandler.removeMessages(3);
                    if (b.aJs().eEF == 3) {
                        b.aJs().aJy();
                    } else {
                        b.aJs().aJx();
                    }
                    b.aJs().mHandler.sendMessageDelayed(b.aJs().mHandler.obtainMessage(3), b.aJs().eEx);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().kz() > 10) {
            n.e(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int cG = MessageManager.getInstance().getSocketClient().cG(202003);
        if (a2 || cG > 0) {
            n.e(false, false, true);
            qB(i);
            return;
        }
        aJA();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aIQ().aJb());
        }
        MessageManager.getInstance().sendMessage(b);
        n.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.eEG != null) {
                this.eEG.clear();
            }
            if (this.eEH != null) {
                this.eEH.clear();
            }
        }
    }

    public void aJp() {
        boolean z;
        if (this.eEC != null) {
            SparseArray<Long> aJa = com.baidu.tieba.im.memorycache.b.aIQ().aJa();
            if (aJa == null) {
                this.eEC = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.eEC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aJa.get(next.getGroupId()) != null) {
                    if (aJa.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.eEF = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aJs().mHandler.sendMessageDelayed(aJs().mHandler.obtainMessage(3), aJs().eEx);
            }
            this.eEC = null;
        }
    }

    private void aJq() {
        if (this.eEB != 0) {
            if (this.eEB == 1) {
                c(0L, 0L, 0L);
            } else {
                aJx();
            }
        }
    }

    private void aJr() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aJs() {
        b bVar;
        synchronized (b.class) {
            if (eEu == null) {
                eEu = new b();
            }
            bVar = eEu;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.eEJ);
        g.JQ().a(this.acV);
        MessageManager.getInstance().registerListener(PointerIconCompat.TYPE_HELP, this.eoY);
        MessageManager.getInstance().registerListener(1001, this.eoY);
        MessageManager.getInstance().registerListener(202101, this.eoY);
        aJt();
    }

    public void aJt() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            qy(socketGetMsgStratgy[0] * 1000);
            qz(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aJA();
    }

    public void stop() {
        aJA();
        aJr();
    }

    public void aJu() {
        this.eEx = this.eEw;
    }

    public void aJv() {
        aJs().eEx = aJs().eEv;
    }

    public void qy(int i) {
        if (i > 0) {
            this.eEw = i;
        }
    }

    public void qz(int i) {
        if (i > 0) {
            this.eEv = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aJw() {
        if (System.currentTimeMillis() - this.eEE >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eED);
            pushCountMessage.setUpFlowSize(h.pu().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.pu().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.eEE = System.currentTimeMillis();
            this.eED = 0;
            h.pu().pA();
            h.pu().pz();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aIQ().aJa());
        }
        messageSyncMessage.setForTimer(this.eEI);
        LocalViewSize.ImageSize Cj = LocalViewSize.Cg().Cj();
        if (Cj != null) {
            messageSyncMessage.setWidth(Cj.width);
            messageSyncMessage.setHeight(Cj.height);
        }
        LocalViewSize.ImageSize Ci = LocalViewSize.Cg().Ci();
        if (Ci != null) {
            messageSyncMessage.setSmallHeight(Ci.height);
            messageSyncMessage.setSmallWidth(Ci.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void c(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.eED++;
        this.eEI = false;
        this.eEF = 1;
        this.mHandler.removeMessages(3);
        aJs().mHandler.sendMessageDelayed(aJs().mHandler.obtainMessage(3), aJs().eEx);
        if (this.eEG == null) {
            this.eEG = new SparseArray<>();
            this.eEG.clear();
        }
        if (this.eEH == null) {
            this.eEH = new SparseArray<>();
        }
        SparseArray<Long> aJa = com.baidu.tieba.im.memorycache.b.aIQ().aJa();
        if (0 != j) {
            Long l = aJa.get((int) j);
            Long l2 = this.eEG.get((int) j);
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
                this.eEG.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.eEG != null && this.eEG.size() > 0) {
            for (int i = 0; i < this.eEG.size(); i++) {
                int keyAt = this.eEG.keyAt(i);
                Long l3 = aJa.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.eEG.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.eEH.get((int) j) == null) {
                    this.eEH.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.eEH.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.eEH.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.eEG.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.eEG.keyAt(i2);
                long longValue3 = this.eEG.valueAt(i2).longValue();
                long j4 = 0;
                if (this.eEH.get(keyAt2) != null) {
                    j4 = this.eEH.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.eEG.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.eEG.size() == 0) {
            aJA();
            this.eEH.clear();
        } else {
            a(this.eEG, 1);
        }
    }

    public synchronized void aJx() {
        qA(2);
    }

    public synchronized void aJy() {
        qA(3);
    }

    public void aJz() {
        aJq();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.eEI = false;
                this.eEF = 4;
                this.mHandler.removeMessages(3);
                aJs().mHandler.sendMessageDelayed(aJs().mHandler.obtainMessage(3), aJs().eEx);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void qA(int i) {
        this.eEI = true;
        this.eEF = i;
        a((SparseArray<Long>) null, i);
    }

    private void qB(int i) {
        if (i == 1) {
            if (this.eEB != 2) {
                this.eEB = 1;
            }
        } else if (i == 3 || i == 2) {
            this.eEB = 2;
        }
    }

    private void aJA() {
        this.eEB = 0;
    }
}
