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
import com.baidu.adp.lib.webSocket.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.d.e;
import com.baidu.tbadk.coreExtra.d.h;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.n.j;
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
    private static b hBs;
    private List<GroupUpdateMessage> hBA;
    private boolean hBG;
    private int hBt = 900000;
    private int hBu = 360000;
    private int hBv = this.hBu;
    private final int hBw = 0;
    private final int hBx = 1;
    private final int hBy = 2;
    private int hBz = 0;
    private int hBB = 0;
    private long hBC = 0;
    private int hBD = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> hBE = null;
    private LongSparseArray<Long> hBF = null;
    private final com.baidu.adp.framework.client.socket.link.a nV = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.eV().setSequenceId(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onTextMessage(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c hlW = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bUA();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.hBA = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bTW().isInit()) {
                            b.this.bUt();
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
                    b.this.bUz();
                } else {
                    b.this.bUy();
                }
            }
        }
    };
    private final CustomMessageListener hBH = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.hBE != null) {
                    b.this.hBE.clear();
                }
                if (b.this.hBF != null) {
                    b.this.hBF.clear();
                }
                b.this.hBA = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.aKD().setInterval();
                    b.bUw().bUx();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bUw().bUt();
                }
            }
        });
        hBs = null;
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
                    b.bUw().mHandler.removeMessages(2);
                    b.bUw().bUB();
                    return;
                case 3:
                    b.bUw().mHandler.removeMessages(3);
                    if (b.bUw().hBD == 3) {
                        b.bUw().bUC();
                    } else {
                        b.bUw().bUB();
                    }
                    b.bUw().mHandler.sendMessageDelayed(b.bUw().mHandler.obtainMessage(3), b.bUw().hBv);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 10) {
            j.e(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(CmdConfigSocket.CMD_MESSAGE_SYNC, this.mTag);
        int processingResponsedMessageNum = MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum(CmdConfigSocket.CMD_MESSAGE_SYNC);
        if (a2 || processingResponsedMessageNum > 0) {
            j.e(false, false, true);
            wD(i);
            return;
        }
        bUE();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bTW().bUi());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.hBE != null) {
                this.hBE.clear();
            }
            if (this.hBF != null) {
                this.hBF.clear();
            }
        }
    }

    public void bUt() {
        boolean z;
        if (this.hBA != null) {
            LongSparseArray<Long> bUh = com.baidu.tieba.im.memorycache.b.bTW().bUh();
            if (bUh == null) {
                this.hBA = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.hBA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bUh.get(next.getGroupId()) != null) {
                    if (bUh.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.hBD = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bUw().mHandler.sendMessageDelayed(bUw().mHandler.obtainMessage(3), bUw().hBv);
            }
            this.hBA = null;
        }
    }

    private void bUu() {
        if (this.hBz != 0) {
            if (this.hBz == 1) {
                d(0L, 0L, 0L);
            } else {
                bUB();
            }
        }
    }

    private void bUv() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bUw() {
        b bVar;
        synchronized (b.class) {
            if (hBs == null) {
                hBs = new b();
            }
            bVar = hBs;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.hBH);
        h.aKM().a(this.nV);
        MessageManager.getInstance().registerListener(1003, this.hlW);
        MessageManager.getInstance().registerListener(1001, this.hlW);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.hlW);
        bUx();
    }

    public void bUx() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            wA(socketGetMsgStratgy[0] * 1000);
            wB(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bUE();
    }

    public void stop() {
        bUE();
        bUv();
    }

    public void bUy() {
        this.hBv = this.hBu;
    }

    public void bUz() {
        bUw().hBv = bUw().hBt;
    }

    public void wA(int i) {
        if (i > 0) {
            this.hBu = i;
        }
    }

    public void wB(int i) {
        if (i > 0) {
            this.hBt = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bUA() {
        if (System.currentTimeMillis() - this.hBC >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.hBB);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hN().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hN().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.hBC = System.currentTimeMillis();
            this.hBB = 0;
            com.baidu.adp.lib.webSocket.h.hN().hR();
            com.baidu.adp.lib.webSocket.h.hN().hQ();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bTW().bUh());
        }
        messageSyncMessage.setForTimer(this.hBG);
        LocalViewSize.ImageSize aDA = LocalViewSize.aDy().aDA();
        if (aDA != null) {
            messageSyncMessage.setWidth(aDA.width);
            messageSyncMessage.setHeight(aDA.height);
        }
        LocalViewSize.ImageSize aDz = LocalViewSize.aDy().aDz();
        if (aDz != null) {
            messageSyncMessage.setSmallHeight(aDz.height);
            messageSyncMessage.setSmallWidth(aDz.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.hBB++;
        this.hBG = false;
        this.hBD = 1;
        this.mHandler.removeMessages(3);
        bUw().mHandler.sendMessageDelayed(bUw().mHandler.obtainMessage(3), bUw().hBv);
        if (this.hBE == null) {
            this.hBE = new LongSparseArray<>();
            this.hBE.clear();
        }
        if (this.hBF == null) {
            this.hBF = new LongSparseArray<>();
        }
        LongSparseArray<Long> bUh = com.baidu.tieba.im.memorycache.b.bTW().bUh();
        if (0 != j) {
            Long l = bUh.get(j);
            Long l2 = this.hBE.get(j);
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
                this.hBE.put(j, Long.valueOf(longValue));
            }
        }
        if (this.hBE != null && this.hBE.size() > 0) {
            for (int i = 0; i < this.hBE.size(); i++) {
                long keyAt = this.hBE.keyAt(i);
                Long l3 = bUh.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.hBE.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.hBF.get(j) == null) {
                    this.hBF.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.hBF.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.hBF.put(j, Long.valueOf(j2));
                }
            }
            int size = this.hBE.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.hBE.keyAt(i2);
                long longValue3 = this.hBE.valueAt(i2).longValue();
                long j4 = 0;
                if (this.hBF.get(keyAt2) != null) {
                    j4 = this.hBF.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.hBE.remove(((Long) it.next()).longValue());
            }
        }
        if (this.hBE.size() == 0) {
            bUE();
            this.hBF.clear();
        } else {
            a(this.hBE, 1);
        }
    }

    public synchronized void bUB() {
        wC(2);
    }

    public synchronized void bUC() {
        wC(3);
    }

    public void bUD() {
        bUu();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.hBG = false;
                this.hBD = 4;
                this.mHandler.removeMessages(3);
                bUw().mHandler.sendMessageDelayed(bUw().mHandler.obtainMessage(3), bUw().hBv);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void wC(int i) {
        this.hBG = true;
        this.hBD = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void wD(int i) {
        if (i == 1) {
            if (this.hBz != 2) {
                this.hBz = 1;
            }
        } else if (i == 3 || i == 2) {
            this.hBz = 2;
        }
    }

    private void bUE() {
        this.hBz = 0;
    }
}
