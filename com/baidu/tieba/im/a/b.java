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
    private static b hGU;
    private List<GroupUpdateMessage> hHc;
    private boolean hHi;
    private int hGV = 900000;
    private int hGW = 360000;
    private int hGX = this.hGW;
    private final int hGY = 0;
    private final int hGZ = 1;
    private final int hHa = 2;
    private int hHb = 0;
    private int hHd = 0;
    private long hHe = 0;
    private int hHf = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> hHg = null;
    private LongSparseArray<Long> hHh = null;
    private final com.baidu.adp.framework.client.socket.link.a nW = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c hry = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bXk();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.hHc = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bWG().isInit()) {
                            b.this.bXd();
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
                    b.this.bXj();
                } else {
                    b.this.bXi();
                }
            }
        }
    };
    private final CustomMessageListener hHj = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.hHg != null) {
                    b.this.hHg.clear();
                }
                if (b.this.hHh != null) {
                    b.this.hHh.clear();
                }
                b.this.hHc = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.aNs().setInterval();
                    b.bXg().bXh();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bXg().bXd();
                }
            }
        });
        hGU = null;
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
                    b.bXg().mHandler.removeMessages(2);
                    b.bXg().bXl();
                    return;
                case 3:
                    b.bXg().mHandler.removeMessages(3);
                    if (b.bXg().hHf == 3) {
                        b.bXg().bXm();
                    } else {
                        b.bXg().bXl();
                    }
                    b.bXg().mHandler.sendMessageDelayed(b.bXg().mHandler.obtainMessage(3), b.bXg().hGX);
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
            wO(i);
            return;
        }
        bXo();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bWG().bWS());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.hHg != null) {
                this.hHg.clear();
            }
            if (this.hHh != null) {
                this.hHh.clear();
            }
        }
    }

    public void bXd() {
        boolean z;
        if (this.hHc != null) {
            LongSparseArray<Long> bWR = com.baidu.tieba.im.memorycache.b.bWG().bWR();
            if (bWR == null) {
                this.hHc = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.hHc.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bWR.get(next.getGroupId()) != null) {
                    if (bWR.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.hHf = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bXg().mHandler.sendMessageDelayed(bXg().mHandler.obtainMessage(3), bXg().hGX);
            }
            this.hHc = null;
        }
    }

    private void bXe() {
        if (this.hHb != 0) {
            if (this.hHb == 1) {
                d(0L, 0L, 0L);
            } else {
                bXl();
            }
        }
    }

    private void bXf() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bXg() {
        b bVar;
        synchronized (b.class) {
            if (hGU == null) {
                hGU = new b();
            }
            bVar = hGU;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.hHj);
        h.aNB().a(this.nW);
        MessageManager.getInstance().registerListener(1003, this.hry);
        MessageManager.getInstance().registerListener(1001, this.hry);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.hry);
        bXh();
    }

    public void bXh() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            wL(socketGetMsgStratgy[0] * 1000);
            wM(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bXo();
    }

    public void stop() {
        bXo();
        bXf();
    }

    public void bXi() {
        this.hGX = this.hGW;
    }

    public void bXj() {
        bXg().hGX = bXg().hGV;
    }

    public void wL(int i) {
        if (i > 0) {
            this.hGW = i;
        }
    }

    public void wM(int i) {
        if (i > 0) {
            this.hGV = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bXk() {
        if (System.currentTimeMillis() - this.hHe >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.hHd);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ia().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ia().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.hHe = System.currentTimeMillis();
            this.hHd = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bWG().bWR());
        }
        messageSyncMessage.setForTimer(this.hHi);
        LocalViewSize.ImageSize aGd = LocalViewSize.aGb().aGd();
        if (aGd != null) {
            messageSyncMessage.setWidth(aGd.width);
            messageSyncMessage.setHeight(aGd.height);
        }
        LocalViewSize.ImageSize aGc = LocalViewSize.aGb().aGc();
        if (aGc != null) {
            messageSyncMessage.setSmallHeight(aGc.height);
            messageSyncMessage.setSmallWidth(aGc.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.hHd++;
        this.hHi = false;
        this.hHf = 1;
        this.mHandler.removeMessages(3);
        bXg().mHandler.sendMessageDelayed(bXg().mHandler.obtainMessage(3), bXg().hGX);
        if (this.hHg == null) {
            this.hHg = new LongSparseArray<>();
            this.hHg.clear();
        }
        if (this.hHh == null) {
            this.hHh = new LongSparseArray<>();
        }
        LongSparseArray<Long> bWR = com.baidu.tieba.im.memorycache.b.bWG().bWR();
        if (0 != j) {
            Long l = bWR.get(j);
            Long l2 = this.hHg.get(j);
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
                this.hHg.put(j, Long.valueOf(longValue));
            }
        }
        if (this.hHg != null && this.hHg.size() > 0) {
            for (int i = 0; i < this.hHg.size(); i++) {
                long keyAt = this.hHg.keyAt(i);
                Long l3 = bWR.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.hHg.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.hHh.get(j) == null) {
                    this.hHh.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.hHh.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.hHh.put(j, Long.valueOf(j2));
                }
            }
            int size = this.hHg.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.hHg.keyAt(i2);
                long longValue3 = this.hHg.valueAt(i2).longValue();
                long j4 = 0;
                if (this.hHh.get(keyAt2) != null) {
                    j4 = this.hHh.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.hHg.remove(((Long) it.next()).longValue());
            }
        }
        if (this.hHg.size() == 0) {
            bXo();
            this.hHh.clear();
        } else {
            a(this.hHg, 1);
        }
    }

    public synchronized void bXl() {
        wN(2);
    }

    public synchronized void bXm() {
        wN(3);
    }

    public void bXn() {
        bXe();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.hHi = false;
                this.hHf = 4;
                this.mHandler.removeMessages(3);
                bXg().mHandler.sendMessageDelayed(bXg().mHandler.obtainMessage(3), bXg().hGX);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void wN(int i) {
        this.hHi = true;
        this.hHf = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void wO(int i) {
        if (i == 1) {
            if (this.hHb != 2) {
                this.hHb = 1;
            }
        } else if (i == 3 || i == 2) {
            this.hHb = 2;
        }
    }

    private void bXo() {
        this.hHb = 0;
    }
}
