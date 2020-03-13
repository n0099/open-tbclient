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
    private static b hHi;
    private List<GroupUpdateMessage> hHq;
    private boolean hHw;
    private int hHj = 900000;
    private int hHk = 360000;
    private int hHl = this.hHk;
    private final int hHm = 0;
    private final int hHn = 1;
    private final int hHo = 2;
    private int hHp = 0;
    private int hHr = 0;
    private long hHs = 0;
    private int hHt = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> hHu = null;
    private LongSparseArray<Long> hHv = null;
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
    private final com.baidu.adp.framework.listener.c hrM = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bXn();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.hHq = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bWJ().isInit()) {
                            b.this.bXg();
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
                    b.this.bXm();
                } else {
                    b.this.bXl();
                }
            }
        }
    };
    private final CustomMessageListener hHx = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.hHu != null) {
                    b.this.hHu.clear();
                }
                if (b.this.hHv != null) {
                    b.this.hHv.clear();
                }
                b.this.hHq = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.aNv().setInterval();
                    b.bXj().bXk();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bXj().bXg();
                }
            }
        });
        hHi = null;
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
                    b.bXj().mHandler.removeMessages(2);
                    b.bXj().bXo();
                    return;
                case 3:
                    b.bXj().mHandler.removeMessages(3);
                    if (b.bXj().hHt == 3) {
                        b.bXj().bXp();
                    } else {
                        b.bXj().bXo();
                    }
                    b.bXj().mHandler.sendMessageDelayed(b.bXj().mHandler.obtainMessage(3), b.bXj().hHl);
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
        bXr();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bWJ().bWV());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.hHu != null) {
                this.hHu.clear();
            }
            if (this.hHv != null) {
                this.hHv.clear();
            }
        }
    }

    public void bXg() {
        boolean z;
        if (this.hHq != null) {
            LongSparseArray<Long> bWU = com.baidu.tieba.im.memorycache.b.bWJ().bWU();
            if (bWU == null) {
                this.hHq = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.hHq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bWU.get(next.getGroupId()) != null) {
                    if (bWU.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.hHt = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bXj().mHandler.sendMessageDelayed(bXj().mHandler.obtainMessage(3), bXj().hHl);
            }
            this.hHq = null;
        }
    }

    private void bXh() {
        if (this.hHp != 0) {
            if (this.hHp == 1) {
                d(0L, 0L, 0L);
            } else {
                bXo();
            }
        }
    }

    private void bXi() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bXj() {
        b bVar;
        synchronized (b.class) {
            if (hHi == null) {
                hHi = new b();
            }
            bVar = hHi;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.hHx);
        h.aNE().a(this.nW);
        MessageManager.getInstance().registerListener(1003, this.hrM);
        MessageManager.getInstance().registerListener(1001, this.hrM);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.hrM);
        bXk();
    }

    public void bXk() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            wL(socketGetMsgStratgy[0] * 1000);
            wM(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bXr();
    }

    public void stop() {
        bXr();
        bXi();
    }

    public void bXl() {
        this.hHl = this.hHk;
    }

    public void bXm() {
        bXj().hHl = bXj().hHj;
    }

    public void wL(int i) {
        if (i > 0) {
            this.hHk = i;
        }
    }

    public void wM(int i) {
        if (i > 0) {
            this.hHj = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bXn() {
        if (System.currentTimeMillis() - this.hHs >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.hHr);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ia().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ia().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.hHs = System.currentTimeMillis();
            this.hHr = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bWJ().bWU());
        }
        messageSyncMessage.setForTimer(this.hHw);
        LocalViewSize.ImageSize aGf = LocalViewSize.aGd().aGf();
        if (aGf != null) {
            messageSyncMessage.setWidth(aGf.width);
            messageSyncMessage.setHeight(aGf.height);
        }
        LocalViewSize.ImageSize aGe = LocalViewSize.aGd().aGe();
        if (aGe != null) {
            messageSyncMessage.setSmallHeight(aGe.height);
            messageSyncMessage.setSmallWidth(aGe.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.hHr++;
        this.hHw = false;
        this.hHt = 1;
        this.mHandler.removeMessages(3);
        bXj().mHandler.sendMessageDelayed(bXj().mHandler.obtainMessage(3), bXj().hHl);
        if (this.hHu == null) {
            this.hHu = new LongSparseArray<>();
            this.hHu.clear();
        }
        if (this.hHv == null) {
            this.hHv = new LongSparseArray<>();
        }
        LongSparseArray<Long> bWU = com.baidu.tieba.im.memorycache.b.bWJ().bWU();
        if (0 != j) {
            Long l = bWU.get(j);
            Long l2 = this.hHu.get(j);
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
                this.hHu.put(j, Long.valueOf(longValue));
            }
        }
        if (this.hHu != null && this.hHu.size() > 0) {
            for (int i = 0; i < this.hHu.size(); i++) {
                long keyAt = this.hHu.keyAt(i);
                Long l3 = bWU.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.hHu.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.hHv.get(j) == null) {
                    this.hHv.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.hHv.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.hHv.put(j, Long.valueOf(j2));
                }
            }
            int size = this.hHu.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.hHu.keyAt(i2);
                long longValue3 = this.hHu.valueAt(i2).longValue();
                long j4 = 0;
                if (this.hHv.get(keyAt2) != null) {
                    j4 = this.hHv.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.hHu.remove(((Long) it.next()).longValue());
            }
        }
        if (this.hHu.size() == 0) {
            bXr();
            this.hHv.clear();
        } else {
            a(this.hHu, 1);
        }
    }

    public synchronized void bXo() {
        wN(2);
    }

    public synchronized void bXp() {
        wN(3);
    }

    public void bXq() {
        bXh();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.hHw = false;
                this.hHt = 4;
                this.mHandler.removeMessages(3);
                bXj().mHandler.sendMessageDelayed(bXj().mHandler.obtainMessage(3), bXj().hHl);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void wN(int i) {
        this.hHw = true;
        this.hHt = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void wO(int i) {
        if (i == 1) {
            if (this.hHp != 2) {
                this.hHp = 1;
            }
        } else if (i == 3 || i == 2) {
            this.hHp = 2;
        }
    }

    private void bXr() {
        this.hHp = 0;
    }
}
