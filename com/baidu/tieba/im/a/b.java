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
    private static b hEV;
    private List<GroupUpdateMessage> hFd;
    private boolean hFj;
    private int hEW = 900000;
    private int hEX = 360000;
    private int hEY = this.hEX;
    private final int hEZ = 0;
    private final int hFa = 1;
    private final int hFb = 2;
    private int hFc = 0;
    private int hFe = 0;
    private long hFf = 0;
    private int hFg = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> hFh = null;
    private LongSparseArray<Long> hFi = null;
    private final com.baidu.adp.framework.client.socket.link.a nS = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c hpz = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bVJ();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.hFd = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bVf().isInit()) {
                            b.this.bVC();
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
                    b.this.bVI();
                } else {
                    b.this.bVH();
                }
            }
        }
    };
    private final CustomMessageListener hFk = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.hFh != null) {
                    b.this.hFh.clear();
                }
                if (b.this.hFi != null) {
                    b.this.hFi.clear();
                }
                b.this.hFd = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.aKW().setInterval();
                    b.bVF().bVG();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bVF().bVC();
                }
            }
        });
        hEV = null;
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
                    b.bVF().mHandler.removeMessages(2);
                    b.bVF().bVK();
                    return;
                case 3:
                    b.bVF().mHandler.removeMessages(3);
                    if (b.bVF().hFg == 3) {
                        b.bVF().bVL();
                    } else {
                        b.bVF().bVK();
                    }
                    b.bVF().mHandler.sendMessageDelayed(b.bVF().mHandler.obtainMessage(3), b.bVF().hEY);
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
            wI(i);
            return;
        }
        bVN();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bVf().bVr());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.hFh != null) {
                this.hFh.clear();
            }
            if (this.hFi != null) {
                this.hFi.clear();
            }
        }
    }

    public void bVC() {
        boolean z;
        if (this.hFd != null) {
            LongSparseArray<Long> bVq = com.baidu.tieba.im.memorycache.b.bVf().bVq();
            if (bVq == null) {
                this.hFd = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.hFd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bVq.get(next.getGroupId()) != null) {
                    if (bVq.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.hFg = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bVF().mHandler.sendMessageDelayed(bVF().mHandler.obtainMessage(3), bVF().hEY);
            }
            this.hFd = null;
        }
    }

    private void bVD() {
        if (this.hFc != 0) {
            if (this.hFc == 1) {
                d(0L, 0L, 0L);
            } else {
                bVK();
            }
        }
    }

    private void bVE() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bVF() {
        b bVar;
        synchronized (b.class) {
            if (hEV == null) {
                hEV = new b();
            }
            bVar = hEV;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.hFk);
        h.aLf().a(this.nS);
        MessageManager.getInstance().registerListener(1003, this.hpz);
        MessageManager.getInstance().registerListener(1001, this.hpz);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.hpz);
        bVG();
    }

    public void bVG() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            wF(socketGetMsgStratgy[0] * 1000);
            wG(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bVN();
    }

    public void stop() {
        bVN();
        bVE();
    }

    public void bVH() {
        this.hEY = this.hEX;
    }

    public void bVI() {
        bVF().hEY = bVF().hEW;
    }

    public void wF(int i) {
        if (i > 0) {
            this.hEX = i;
        }
    }

    public void wG(int i) {
        if (i > 0) {
            this.hEW = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bVJ() {
        if (System.currentTimeMillis() - this.hFf >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.hFe);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hM().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hM().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.hFf = System.currentTimeMillis();
            this.hFe = 0;
            com.baidu.adp.lib.webSocket.h.hM().hQ();
            com.baidu.adp.lib.webSocket.h.hM().hP();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bVf().bVq());
        }
        messageSyncMessage.setForTimer(this.hFj);
        LocalViewSize.ImageSize aDT = LocalViewSize.aDR().aDT();
        if (aDT != null) {
            messageSyncMessage.setWidth(aDT.width);
            messageSyncMessage.setHeight(aDT.height);
        }
        LocalViewSize.ImageSize aDS = LocalViewSize.aDR().aDS();
        if (aDS != null) {
            messageSyncMessage.setSmallHeight(aDS.height);
            messageSyncMessage.setSmallWidth(aDS.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.hFe++;
        this.hFj = false;
        this.hFg = 1;
        this.mHandler.removeMessages(3);
        bVF().mHandler.sendMessageDelayed(bVF().mHandler.obtainMessage(3), bVF().hEY);
        if (this.hFh == null) {
            this.hFh = new LongSparseArray<>();
            this.hFh.clear();
        }
        if (this.hFi == null) {
            this.hFi = new LongSparseArray<>();
        }
        LongSparseArray<Long> bVq = com.baidu.tieba.im.memorycache.b.bVf().bVq();
        if (0 != j) {
            Long l = bVq.get(j);
            Long l2 = this.hFh.get(j);
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
                this.hFh.put(j, Long.valueOf(longValue));
            }
        }
        if (this.hFh != null && this.hFh.size() > 0) {
            for (int i = 0; i < this.hFh.size(); i++) {
                long keyAt = this.hFh.keyAt(i);
                Long l3 = bVq.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.hFh.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.hFi.get(j) == null) {
                    this.hFi.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.hFi.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.hFi.put(j, Long.valueOf(j2));
                }
            }
            int size = this.hFh.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.hFh.keyAt(i2);
                long longValue3 = this.hFh.valueAt(i2).longValue();
                long j4 = 0;
                if (this.hFi.get(keyAt2) != null) {
                    j4 = this.hFi.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.hFh.remove(((Long) it.next()).longValue());
            }
        }
        if (this.hFh.size() == 0) {
            bVN();
            this.hFi.clear();
        } else {
            a(this.hFh, 1);
        }
    }

    public synchronized void bVK() {
        wH(2);
    }

    public synchronized void bVL() {
        wH(3);
    }

    public void bVM() {
        bVD();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.hFj = false;
                this.hFg = 4;
                this.mHandler.removeMessages(3);
                bVF().mHandler.sendMessageDelayed(bVF().mHandler.obtainMessage(3), bVF().hEY);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void wH(int i) {
        this.hFj = true;
        this.hFg = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void wI(int i) {
        if (i == 1) {
            if (this.hFc != 2) {
                this.hFc = 1;
            }
        } else if (i == 3 || i == 2) {
            this.hFc = 2;
        }
    }

    private void bVN() {
        this.hFc = 0;
    }
}
