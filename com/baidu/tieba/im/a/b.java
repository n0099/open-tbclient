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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.coreExtra.websocketBase.g;
import com.baidu.tbadk.l.j;
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
    private static b ePG;
    private List<GroupUpdateMessage> ePO;
    private boolean ePU;
    private int ePH = 900000;
    private int ePI = 360000;
    private int ePJ = this.ePI;
    private final int ePK = 0;
    private final int ePL = 1;
    private final int ePM = 2;
    private int ePN = 0;
    private int ePP = 0;
    private long ePQ = 0;
    private int ePR = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> ePS = null;
    private LongSparseArray<Long> ePT = null;
    private final com.baidu.adp.framework.client.socket.link.a wF = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void i(Map<String, String> map) {
            b.this.start();
            f.gM().h(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void aj(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c eAl = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aRC();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.ePO = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aQV().qp()) {
                            b.this.aRv();
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
                    b.this.aRB();
                } else {
                    b.this.aRA();
                }
            }
        }
    };
    private final CustomMessageListener ePV = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.ePS != null) {
                    b.this.ePS.clear();
                }
                if (b.this.ePT != null) {
                    b.this.ePT.clear();
                }
                b.this.ePO = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Kc().Kd();
                    b.aRy().aRz();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aRy().aRv();
                }
            }
        });
        ePG = null;
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
                    b.aRy().mHandler.removeMessages(2);
                    b.aRy().aRD();
                    return;
                case 3:
                    b.aRy().mHandler.removeMessages(3);
                    if (b.aRy().ePR == 3) {
                        b.aRy().aRE();
                    } else {
                        b.aRy().aRD();
                    }
                    b.aRy().mHandler.sendMessageDelayed(b.aRy().mHandler.obtainMessage(3), b.aRy().ePJ);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().gR() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), SystemScreenshotManager.DELAY_TIME);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int ag = MessageManager.getInstance().getSocketClient().ag(202003);
        if (a2 || ag > 0) {
            j.d(false, false, true);
            pU(i);
            return;
        }
        aRG();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aQV().aRh());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.ePS != null) {
                this.ePS.clear();
            }
            if (this.ePT != null) {
                this.ePT.clear();
            }
        }
    }

    public void aRv() {
        boolean z;
        if (this.ePO != null) {
            LongSparseArray<Long> aRg = com.baidu.tieba.im.memorycache.b.aQV().aRg();
            if (aRg == null) {
                this.ePO = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.ePO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aRg.get(next.getGroupId()) != null) {
                    if (aRg.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.ePR = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aRy().mHandler.sendMessageDelayed(aRy().mHandler.obtainMessage(3), aRy().ePJ);
            }
            this.ePO = null;
        }
    }

    private void aRw() {
        if (this.ePN != 0) {
            if (this.ePN == 1) {
                d(0L, 0L, 0L);
            } else {
                aRD();
            }
        }
    }

    private void aRx() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aRy() {
        b bVar;
        synchronized (b.class) {
            if (ePG == null) {
                ePG = new b();
            }
            bVar = ePG;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.ePV);
        g.Kk().a(this.wF);
        MessageManager.getInstance().registerListener(1003, this.eAl);
        MessageManager.getInstance().registerListener(1001, this.eAl);
        MessageManager.getInstance().registerListener(202101, this.eAl);
        aRz();
    }

    public void aRz() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            pR(socketGetMsgStratgy[0] * 1000);
            pS(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aRG();
    }

    public void stop() {
        aRG();
        aRx();
    }

    public void aRA() {
        this.ePJ = this.ePI;
    }

    public void aRB() {
        aRy().ePJ = aRy().ePH;
    }

    public void pR(int i) {
        if (i > 0) {
            this.ePI = i;
        }
    }

    public void pS(int i) {
        if (i > 0) {
            this.ePH = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aRC() {
        if (System.currentTimeMillis() - this.ePQ >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.ePP);
            pushCountMessage.setUpFlowSize(h.lF().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.lF().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.ePQ = System.currentTimeMillis();
            this.ePP = 0;
            h.lF().lK();
            h.lF().lJ();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aQV().aRg());
        }
        messageSyncMessage.setForTimer(this.ePU);
        LocalViewSize.ImageSize Cb = LocalViewSize.BY().Cb();
        if (Cb != null) {
            messageSyncMessage.setWidth(Cb.width);
            messageSyncMessage.setHeight(Cb.height);
        }
        LocalViewSize.ImageSize Ca = LocalViewSize.BY().Ca();
        if (Ca != null) {
            messageSyncMessage.setSmallHeight(Ca.height);
            messageSyncMessage.setSmallWidth(Ca.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.ePP++;
        this.ePU = false;
        this.ePR = 1;
        this.mHandler.removeMessages(3);
        aRy().mHandler.sendMessageDelayed(aRy().mHandler.obtainMessage(3), aRy().ePJ);
        if (this.ePS == null) {
            this.ePS = new LongSparseArray<>();
            this.ePS.clear();
        }
        if (this.ePT == null) {
            this.ePT = new LongSparseArray<>();
        }
        LongSparseArray<Long> aRg = com.baidu.tieba.im.memorycache.b.aQV().aRg();
        if (0 != j) {
            Long l = aRg.get(j);
            Long l2 = this.ePS.get(j);
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
                this.ePS.put(j, Long.valueOf(longValue));
            }
        }
        if (this.ePS != null && this.ePS.size() > 0) {
            for (int i = 0; i < this.ePS.size(); i++) {
                long keyAt = this.ePS.keyAt(i);
                Long l3 = aRg.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.ePS.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.ePT.get(j) == null) {
                    this.ePT.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.ePT.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.ePT.put(j, Long.valueOf(j2));
                }
            }
            int size = this.ePS.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.ePS.keyAt(i2);
                long longValue3 = this.ePS.valueAt(i2).longValue();
                long j4 = 0;
                if (this.ePT.get(keyAt2) != null) {
                    j4 = this.ePT.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.ePS.remove(((Long) it.next()).longValue());
            }
        }
        if (this.ePS.size() == 0) {
            aRG();
            this.ePT.clear();
        } else {
            a(this.ePS, 1);
        }
    }

    public synchronized void aRD() {
        pT(2);
    }

    public synchronized void aRE() {
        pT(3);
    }

    public void aRF() {
        aRw();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.ePU = false;
                this.ePR = 4;
                this.mHandler.removeMessages(3);
                aRy().mHandler.sendMessageDelayed(aRy().mHandler.obtainMessage(3), aRy().ePJ);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void pT(int i) {
        this.ePU = true;
        this.ePR = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void pU(int i) {
        if (i == 1) {
            if (this.ePN != 2) {
                this.ePN = 1;
            }
        } else if (i == 3 || i == 2) {
            this.ePN = 2;
        }
    }

    private void aRG() {
        this.ePN = 0;
    }
}
