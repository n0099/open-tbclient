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
    private static b eGp;
    private boolean eGD;
    private List<GroupUpdateMessage> eGx;
    private int eGq = 900000;
    private int eGr = 360000;
    private int eGs = this.eGr;
    private final int eGt = 0;
    private final int eGu = 1;
    private final int eGv = 2;
    private int eGw = 0;
    private int eGy = 0;
    private long eGz = 0;
    private int eGA = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> eGB = null;
    private SparseArray<Long> eGC = null;
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
    private final com.baidu.adp.framework.listener.c eqQ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aJG();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.eGx = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aJa().aIZ()) {
                            b.this.aJz();
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
                    b.this.aJF();
                } else {
                    b.this.aJE();
                }
            }
        }
    };
    private final CustomMessageListener eGE = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.eGB != null) {
                    b.this.eGB.clear();
                }
                if (b.this.eGC != null) {
                    b.this.eGC.clear();
                }
                b.this.eGx = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Jz().JA();
                    b.aJC().aJD();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aJC().aJz();
                }
            }
        });
        eGp = null;
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
                    b.aJC().mHandler.removeMessages(2);
                    b.aJC().aJH();
                    return;
                case 3:
                    b.aJC().mHandler.removeMessages(3);
                    if (b.aJC().eGA == 3) {
                        b.aJC().aJI();
                    } else {
                        b.aJC().aJH();
                    }
                    b.aJC().mHandler.sendMessageDelayed(b.aJC().mHandler.obtainMessage(3), b.aJC().eGs);
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
            qu(i);
            return;
        }
        aJK();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aJa().aJl());
        }
        MessageManager.getInstance().sendMessage(b);
        n.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.eGB != null) {
                this.eGB.clear();
            }
            if (this.eGC != null) {
                this.eGC.clear();
            }
        }
    }

    public void aJz() {
        boolean z;
        if (this.eGx != null) {
            SparseArray<Long> aJk = com.baidu.tieba.im.memorycache.b.aJa().aJk();
            if (aJk == null) {
                this.eGx = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.eGx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aJk.get(next.getGroupId()) != null) {
                    if (aJk.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.eGA = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aJC().mHandler.sendMessageDelayed(aJC().mHandler.obtainMessage(3), aJC().eGs);
            }
            this.eGx = null;
        }
    }

    private void aJA() {
        if (this.eGw != 0) {
            if (this.eGw == 1) {
                c(0L, 0L, 0L);
            } else {
                aJH();
            }
        }
    }

    private void aJB() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aJC() {
        b bVar;
        synchronized (b.class) {
            if (eGp == null) {
                eGp = new b();
            }
            bVar = eGp;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.eGE);
        g.JH().a(this.acV);
        MessageManager.getInstance().registerListener(PointerIconCompat.TYPE_HELP, this.eqQ);
        MessageManager.getInstance().registerListener(1001, this.eqQ);
        MessageManager.getInstance().registerListener(202101, this.eqQ);
        aJD();
    }

    public void aJD() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            qr(socketGetMsgStratgy[0] * 1000);
            qs(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aJK();
    }

    public void stop() {
        aJK();
        aJB();
    }

    public void aJE() {
        this.eGs = this.eGr;
    }

    public void aJF() {
        aJC().eGs = aJC().eGq;
    }

    public void qr(int i) {
        if (i > 0) {
            this.eGr = i;
        }
    }

    public void qs(int i) {
        if (i > 0) {
            this.eGq = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aJG() {
        if (System.currentTimeMillis() - this.eGz >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eGy);
            pushCountMessage.setUpFlowSize(h.pv().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.pv().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.eGz = System.currentTimeMillis();
            this.eGy = 0;
            h.pv().pB();
            h.pv().pA();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aJa().aJk());
        }
        messageSyncMessage.setForTimer(this.eGD);
        LocalViewSize.ImageSize Cc = LocalViewSize.BZ().Cc();
        if (Cc != null) {
            messageSyncMessage.setWidth(Cc.width);
            messageSyncMessage.setHeight(Cc.height);
        }
        LocalViewSize.ImageSize Cb = LocalViewSize.BZ().Cb();
        if (Cb != null) {
            messageSyncMessage.setSmallHeight(Cb.height);
            messageSyncMessage.setSmallWidth(Cb.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void c(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.eGy++;
        this.eGD = false;
        this.eGA = 1;
        this.mHandler.removeMessages(3);
        aJC().mHandler.sendMessageDelayed(aJC().mHandler.obtainMessage(3), aJC().eGs);
        if (this.eGB == null) {
            this.eGB = new SparseArray<>();
            this.eGB.clear();
        }
        if (this.eGC == null) {
            this.eGC = new SparseArray<>();
        }
        SparseArray<Long> aJk = com.baidu.tieba.im.memorycache.b.aJa().aJk();
        if (0 != j) {
            Long l = aJk.get((int) j);
            Long l2 = this.eGB.get((int) j);
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
                this.eGB.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.eGB != null && this.eGB.size() > 0) {
            for (int i = 0; i < this.eGB.size(); i++) {
                int keyAt = this.eGB.keyAt(i);
                Long l3 = aJk.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.eGB.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.eGC.get((int) j) == null) {
                    this.eGC.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.eGC.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.eGC.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.eGB.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.eGB.keyAt(i2);
                long longValue3 = this.eGB.valueAt(i2).longValue();
                long j4 = 0;
                if (this.eGC.get(keyAt2) != null) {
                    j4 = this.eGC.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.eGB.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.eGB.size() == 0) {
            aJK();
            this.eGC.clear();
        } else {
            a(this.eGB, 1);
        }
    }

    public synchronized void aJH() {
        qt(2);
    }

    public synchronized void aJI() {
        qt(3);
    }

    public void aJJ() {
        aJA();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.eGD = false;
                this.eGA = 4;
                this.mHandler.removeMessages(3);
                aJC().mHandler.sendMessageDelayed(aJC().mHandler.obtainMessage(3), aJC().eGs);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void qt(int i) {
        this.eGD = true;
        this.eGA = i;
        a((SparseArray<Long>) null, i);
    }

    private void qu(int i) {
        if (i == 1) {
            if (this.eGw != 2) {
                this.eGw = 1;
            }
        } else if (i == 3 || i == 2) {
            this.eGw = 2;
        }
    }

    private void aJK() {
        this.eGw = 0;
    }
}
