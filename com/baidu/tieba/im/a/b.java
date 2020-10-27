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
    private static b kgA;
    private List<GroupUpdateMessage> kgI;
    private boolean kgO;
    private int kgB = 900000;
    private int kgC = 360000;
    private int kgD = this.kgC;
    private final int kgE = 0;
    private final int kgF = 1;
    private final int kgG = 2;
    private int kgH = 0;
    private int kgJ = 0;
    private long kgK = 0;
    private int kgL = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> kgM = null;
    private LongSparseArray<Long> kgN = null;
    private final com.baidu.adp.framework.client.socket.link.a IR = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.lv().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c jOT = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cRR();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.kgI = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cRj().isInit()) {
                            b.this.cRK();
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
                    b.this.cRQ();
                } else {
                    b.this.cRP();
                }
            }
        }
    };
    private final CustomMessageListener kgP = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.kgM != null) {
                    b.this.kgM.clear();
                }
                if (b.this.kgN != null) {
                    b.this.kgN.clear();
                }
                b.this.kgI = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bvZ().setInterval();
                    b.cRN().cRO();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cRN().cRK();
                }
            }
        });
        kgA = null;
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
                    b.cRN().mHandler.removeMessages(2);
                    b.cRN().cRS();
                    return;
                case 3:
                    b.cRN().mHandler.removeMessages(3);
                    if (b.cRN().kgL == 3) {
                        b.cRN().cRT();
                    } else {
                        b.cRN().cRS();
                    }
                    b.cRN().mHandler.sendMessageDelayed(b.cRN().mHandler.obtainMessage(3), b.cRN().kgD);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 10) {
            j.g(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(CmdConfigSocket.CMD_MESSAGE_SYNC, this.mTag);
        int processingResponsedMessageNum = MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum(CmdConfigSocket.CMD_MESSAGE_SYNC);
        if (a2 || processingResponsedMessageNum > 0) {
            j.g(false, false, true);
            De(i);
            return;
        }
        cRV();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cRj().cRv());
        }
        MessageManager.getInstance().sendMessage(b);
        j.g(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.kgM != null) {
                this.kgM.clear();
            }
            if (this.kgN != null) {
                this.kgN.clear();
            }
        }
    }

    public void cRK() {
        boolean z;
        if (this.kgI != null) {
            LongSparseArray<Long> cRu = com.baidu.tieba.im.memorycache.b.cRj().cRu();
            if (cRu == null) {
                this.kgI = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.kgI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cRu.get(next.getGroupId()) != null) {
                    if (cRu.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.kgL = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cRN().mHandler.sendMessageDelayed(cRN().mHandler.obtainMessage(3), cRN().kgD);
            }
            this.kgI = null;
        }
    }

    private void cRL() {
        if (this.kgH != 0) {
            if (this.kgH == 1) {
                g(0L, 0L, 0L);
            } else {
                cRS();
            }
        }
    }

    private void cRM() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cRN() {
        b bVar;
        synchronized (b.class) {
            if (kgA == null) {
                kgA = new b();
            }
            bVar = kgA;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.kgP);
        h.bwi().a(this.IR);
        MessageManager.getInstance().registerListener(1003, this.jOT);
        MessageManager.getInstance().registerListener(1001, this.jOT);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.jOT);
        cRO();
    }

    public void cRO() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            Db(socketGetMsgStratgy[0] * 1000);
            Dc(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cRV();
    }

    public void stop() {
        cRV();
        cRM();
    }

    public void cRP() {
        this.kgD = this.kgC;
    }

    public void cRQ() {
        cRN().kgD = cRN().kgB;
    }

    public void Db(int i) {
        if (i > 0) {
            this.kgC = i;
        }
    }

    public void Dc(int i) {
        if (i > 0) {
            this.kgB = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cRR() {
        if (System.currentTimeMillis() - this.kgK >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.kgJ);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.oD().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.oD().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.kgK = System.currentTimeMillis();
            this.kgJ = 0;
            com.baidu.adp.lib.webSocket.h.oD().oH();
            com.baidu.adp.lib.webSocket.h.oD().oG();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cRj().cRu());
        }
        messageSyncMessage.setForTimer(this.kgO);
        LocalViewSize.ImageSize bom = LocalViewSize.bok().bom();
        if (bom != null) {
            messageSyncMessage.setWidth(bom.width);
            messageSyncMessage.setHeight(bom.height);
        }
        LocalViewSize.ImageSize bol = LocalViewSize.bok().bol();
        if (bol != null) {
            messageSyncMessage.setSmallHeight(bol.height);
            messageSyncMessage.setSmallWidth(bol.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.kgJ++;
        this.kgO = false;
        this.kgL = 1;
        this.mHandler.removeMessages(3);
        cRN().mHandler.sendMessageDelayed(cRN().mHandler.obtainMessage(3), cRN().kgD);
        if (this.kgM == null) {
            this.kgM = new LongSparseArray<>();
            this.kgM.clear();
        }
        if (this.kgN == null) {
            this.kgN = new LongSparseArray<>();
        }
        LongSparseArray<Long> cRu = com.baidu.tieba.im.memorycache.b.cRj().cRu();
        if (0 != j) {
            Long l = cRu.get(j);
            Long l2 = this.kgM.get(j);
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
                this.kgM.put(j, Long.valueOf(longValue));
            }
        }
        if (this.kgM != null && this.kgM.size() > 0) {
            for (int i = 0; i < this.kgM.size(); i++) {
                long keyAt = this.kgM.keyAt(i);
                Long l3 = cRu.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.kgM.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.kgN.get(j) == null) {
                    this.kgN.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.kgN.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.kgN.put(j, Long.valueOf(j2));
                }
            }
            int size = this.kgM.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.kgM.keyAt(i2);
                long longValue3 = this.kgM.valueAt(i2).longValue();
                long j4 = 0;
                if (this.kgN.get(keyAt2) != null) {
                    j4 = this.kgN.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.kgM.remove(((Long) it.next()).longValue());
            }
        }
        if (this.kgM.size() == 0) {
            cRV();
            this.kgN.clear();
        } else {
            a(this.kgM, 1);
        }
    }

    public synchronized void cRS() {
        Dd(2);
    }

    public synchronized void cRT() {
        Dd(3);
    }

    public void cRU() {
        cRL();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.kgO = false;
                this.kgL = 4;
                this.mHandler.removeMessages(3);
                cRN().mHandler.sendMessageDelayed(cRN().mHandler.obtainMessage(3), cRN().kgD);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void Dd(int i) {
        this.kgO = true;
        this.kgL = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void De(int i) {
        if (i == 1) {
            if (this.kgH != 2) {
                this.kgH = 1;
            }
        } else if (i == 3 || i == 2) {
            this.kgH = 2;
        }
    }

    private void cRV() {
        this.kgH = 0;
    }
}
