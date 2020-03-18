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
    private static b hII;
    private List<GroupUpdateMessage> hIQ;
    private boolean hIW;
    private int hIJ = 900000;
    private int hIK = 360000;
    private int hIL = this.hIK;
    private final int hIM = 0;
    private final int hIN = 1;
    private final int hIO = 2;
    private int hIP = 0;
    private int hIR = 0;
    private long hIS = 0;
    private int hIT = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> hIU = null;
    private LongSparseArray<Long> hIV = null;
    private final com.baidu.adp.framework.client.socket.link.a nV = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.eW().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c htm = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bXF();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.hIQ = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bXb().isInit()) {
                            b.this.bXy();
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
                    b.this.bXE();
                } else {
                    b.this.bXD();
                }
            }
        }
    };
    private final CustomMessageListener hIX = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.hIU != null) {
                    b.this.hIU.clear();
                }
                if (b.this.hIV != null) {
                    b.this.hIV.clear();
                }
                b.this.hIQ = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.aNz().setInterval();
                    b.bXB().bXC();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bXB().bXy();
                }
            }
        });
        hII = null;
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
                    b.bXB().mHandler.removeMessages(2);
                    b.bXB().bXG();
                    return;
                case 3:
                    b.bXB().mHandler.removeMessages(3);
                    if (b.bXB().hIT == 3) {
                        b.bXB().bXH();
                    } else {
                        b.bXB().bXG();
                    }
                    b.bXB().mHandler.sendMessageDelayed(b.bXB().mHandler.obtainMessage(3), b.bXB().hIL);
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
            wW(i);
            return;
        }
        bXJ();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bXb().bXn());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.hIU != null) {
                this.hIU.clear();
            }
            if (this.hIV != null) {
                this.hIV.clear();
            }
        }
    }

    public void bXy() {
        boolean z;
        if (this.hIQ != null) {
            LongSparseArray<Long> bXm = com.baidu.tieba.im.memorycache.b.bXb().bXm();
            if (bXm == null) {
                this.hIQ = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.hIQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bXm.get(next.getGroupId()) != null) {
                    if (bXm.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.hIT = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bXB().mHandler.sendMessageDelayed(bXB().mHandler.obtainMessage(3), bXB().hIL);
            }
            this.hIQ = null;
        }
    }

    private void bXz() {
        if (this.hIP != 0) {
            if (this.hIP == 1) {
                d(0L, 0L, 0L);
            } else {
                bXG();
            }
        }
    }

    private void bXA() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bXB() {
        b bVar;
        synchronized (b.class) {
            if (hII == null) {
                hII = new b();
            }
            bVar = hII;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.hIX);
        h.aNI().a(this.nV);
        MessageManager.getInstance().registerListener(1003, this.htm);
        MessageManager.getInstance().registerListener(1001, this.htm);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.htm);
        bXC();
    }

    public void bXC() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            wT(socketGetMsgStratgy[0] * 1000);
            wU(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bXJ();
    }

    public void stop() {
        bXJ();
        bXA();
    }

    public void bXD() {
        this.hIL = this.hIK;
    }

    public void bXE() {
        bXB().hIL = bXB().hIJ;
    }

    public void wT(int i) {
        if (i > 0) {
            this.hIK = i;
        }
    }

    public void wU(int i) {
        if (i > 0) {
            this.hIJ = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bXF() {
        if (System.currentTimeMillis() - this.hIS >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.hIR);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ia().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ia().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.hIS = System.currentTimeMillis();
            this.hIR = 0;
            com.baidu.adp.lib.webSocket.h.ia().m12if();
            com.baidu.adp.lib.webSocket.h.ia().ie();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bXb().bXm());
        }
        messageSyncMessage.setForTimer(this.hIW);
        LocalViewSize.ImageSize aGj = LocalViewSize.aGh().aGj();
        if (aGj != null) {
            messageSyncMessage.setWidth(aGj.width);
            messageSyncMessage.setHeight(aGj.height);
        }
        LocalViewSize.ImageSize aGi = LocalViewSize.aGh().aGi();
        if (aGi != null) {
            messageSyncMessage.setSmallHeight(aGi.height);
            messageSyncMessage.setSmallWidth(aGi.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.hIR++;
        this.hIW = false;
        this.hIT = 1;
        this.mHandler.removeMessages(3);
        bXB().mHandler.sendMessageDelayed(bXB().mHandler.obtainMessage(3), bXB().hIL);
        if (this.hIU == null) {
            this.hIU = new LongSparseArray<>();
            this.hIU.clear();
        }
        if (this.hIV == null) {
            this.hIV = new LongSparseArray<>();
        }
        LongSparseArray<Long> bXm = com.baidu.tieba.im.memorycache.b.bXb().bXm();
        if (0 != j) {
            Long l = bXm.get(j);
            Long l2 = this.hIU.get(j);
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
                this.hIU.put(j, Long.valueOf(longValue));
            }
        }
        if (this.hIU != null && this.hIU.size() > 0) {
            for (int i = 0; i < this.hIU.size(); i++) {
                long keyAt = this.hIU.keyAt(i);
                Long l3 = bXm.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.hIU.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.hIV.get(j) == null) {
                    this.hIV.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.hIV.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.hIV.put(j, Long.valueOf(j2));
                }
            }
            int size = this.hIU.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.hIU.keyAt(i2);
                long longValue3 = this.hIU.valueAt(i2).longValue();
                long j4 = 0;
                if (this.hIV.get(keyAt2) != null) {
                    j4 = this.hIV.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.hIU.remove(((Long) it.next()).longValue());
            }
        }
        if (this.hIU.size() == 0) {
            bXJ();
            this.hIV.clear();
        } else {
            a(this.hIU, 1);
        }
    }

    public synchronized void bXG() {
        wV(2);
    }

    public synchronized void bXH() {
        wV(3);
    }

    public void bXI() {
        bXz();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.hIW = false;
                this.hIT = 4;
                this.mHandler.removeMessages(3);
                bXB().mHandler.sendMessageDelayed(bXB().mHandler.obtainMessage(3), bXB().hIL);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void wV(int i) {
        this.hIW = true;
        this.hIT = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void wW(int i) {
        if (i == 1) {
            if (this.hIP != 2) {
                this.hIP = 1;
            }
        } else if (i == 3 || i == 2) {
            this.hIP = 2;
        }
    }

    private void bXJ() {
        this.hIP = 0;
    }
}
