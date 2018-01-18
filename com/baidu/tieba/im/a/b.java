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
    private static b eFU;
    private List<GroupUpdateMessage> eGc;
    private boolean eGi;
    private int eFV = 900000;
    private int eFW = 360000;
    private int eFX = this.eFW;
    private final int eFY = 0;
    private final int eFZ = 1;
    private final int eGa = 2;
    private int eGb = 0;
    private int eGd = 0;
    private long eGe = 0;
    private int eGf = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> eGg = null;
    private SparseArray<Long> eGh = null;
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
    private final com.baidu.adp.framework.listener.c eqv = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aJB();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.eGc = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aIV().aIU()) {
                            b.this.aJu();
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
                    b.this.aJA();
                } else {
                    b.this.aJz();
                }
            }
        }
    };
    private final CustomMessageListener eGj = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.eGg != null) {
                    b.this.eGg.clear();
                }
                if (b.this.eGh != null) {
                    b.this.eGh.clear();
                }
                b.this.eGc = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Jx().Jy();
                    b.aJx().aJy();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aJx().aJu();
                }
            }
        });
        eFU = null;
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
                    b.aJx().mHandler.removeMessages(2);
                    b.aJx().aJC();
                    return;
                case 3:
                    b.aJx().mHandler.removeMessages(3);
                    if (b.aJx().eGf == 3) {
                        b.aJx().aJD();
                    } else {
                        b.aJx().aJC();
                    }
                    b.aJx().mHandler.sendMessageDelayed(b.aJx().mHandler.obtainMessage(3), b.aJx().eFX);
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
        aJF();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aIV().aJg());
        }
        MessageManager.getInstance().sendMessage(b);
        n.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.eGg != null) {
                this.eGg.clear();
            }
            if (this.eGh != null) {
                this.eGh.clear();
            }
        }
    }

    public void aJu() {
        boolean z;
        if (this.eGc != null) {
            SparseArray<Long> aJf = com.baidu.tieba.im.memorycache.b.aIV().aJf();
            if (aJf == null) {
                this.eGc = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.eGc.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aJf.get(next.getGroupId()) != null) {
                    if (aJf.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.eGf = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aJx().mHandler.sendMessageDelayed(aJx().mHandler.obtainMessage(3), aJx().eFX);
            }
            this.eGc = null;
        }
    }

    private void aJv() {
        if (this.eGb != 0) {
            if (this.eGb == 1) {
                c(0L, 0L, 0L);
            } else {
                aJC();
            }
        }
    }

    private void aJw() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aJx() {
        b bVar;
        synchronized (b.class) {
            if (eFU == null) {
                eFU = new b();
            }
            bVar = eFU;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.eGj);
        g.JF().a(this.acV);
        MessageManager.getInstance().registerListener(PointerIconCompat.TYPE_HELP, this.eqv);
        MessageManager.getInstance().registerListener(1001, this.eqv);
        MessageManager.getInstance().registerListener(202101, this.eqv);
        aJy();
    }

    public void aJy() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            qr(socketGetMsgStratgy[0] * 1000);
            qs(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aJF();
    }

    public void stop() {
        aJF();
        aJw();
    }

    public void aJz() {
        this.eFX = this.eFW;
    }

    public void aJA() {
        aJx().eFX = aJx().eFV;
    }

    public void qr(int i) {
        if (i > 0) {
            this.eFW = i;
        }
    }

    public void qs(int i) {
        if (i > 0) {
            this.eFV = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aJB() {
        if (System.currentTimeMillis() - this.eGe >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eGd);
            pushCountMessage.setUpFlowSize(h.pu().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.pu().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.eGe = System.currentTimeMillis();
            this.eGd = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aIV().aJf());
        }
        messageSyncMessage.setForTimer(this.eGi);
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

    public void c(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.eGd++;
        this.eGi = false;
        this.eGf = 1;
        this.mHandler.removeMessages(3);
        aJx().mHandler.sendMessageDelayed(aJx().mHandler.obtainMessage(3), aJx().eFX);
        if (this.eGg == null) {
            this.eGg = new SparseArray<>();
            this.eGg.clear();
        }
        if (this.eGh == null) {
            this.eGh = new SparseArray<>();
        }
        SparseArray<Long> aJf = com.baidu.tieba.im.memorycache.b.aIV().aJf();
        if (0 != j) {
            Long l = aJf.get((int) j);
            Long l2 = this.eGg.get((int) j);
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
                this.eGg.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.eGg != null && this.eGg.size() > 0) {
            for (int i = 0; i < this.eGg.size(); i++) {
                int keyAt = this.eGg.keyAt(i);
                Long l3 = aJf.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.eGg.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.eGh.get((int) j) == null) {
                    this.eGh.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.eGh.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.eGh.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.eGg.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.eGg.keyAt(i2);
                long longValue3 = this.eGg.valueAt(i2).longValue();
                long j4 = 0;
                if (this.eGh.get(keyAt2) != null) {
                    j4 = this.eGh.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.eGg.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.eGg.size() == 0) {
            aJF();
            this.eGh.clear();
        } else {
            a(this.eGg, 1);
        }
    }

    public synchronized void aJC() {
        qt(2);
    }

    public synchronized void aJD() {
        qt(3);
    }

    public void aJE() {
        aJv();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.eGi = false;
                this.eGf = 4;
                this.mHandler.removeMessages(3);
                aJx().mHandler.sendMessageDelayed(aJx().mHandler.obtainMessage(3), aJx().eFX);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void qt(int i) {
        this.eGi = true;
        this.eGf = i;
        a((SparseArray<Long>) null, i);
    }

    private void qu(int i) {
        if (i == 1) {
            if (this.eGb != 2) {
                this.eGb = 1;
            }
        } else if (i == 3 || i == 2) {
            this.eGb = 2;
        }
    }

    private void aJF() {
        this.eGb = 0;
    }
}
