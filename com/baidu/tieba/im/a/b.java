package com.baidu.tieba.im.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.collection.LongSparseArray;
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
import com.baidu.tbadk.n.i;
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
    private static b kBo;
    private boolean kBC;
    private List<GroupUpdateMessage> kBw;
    private int kBp = 900000;
    private int kBq = 360000;
    private int kBr = this.kBq;
    private final int kBs = 0;
    private final int kBt = 1;
    private final int kBu = 2;
    private int kBv = 0;
    private int kBx = 0;
    private long kBy = 0;
    private int kBz = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> kBA = null;
    private LongSparseArray<Long> kBB = null;
    private final com.baidu.adp.framework.client.socket.link.a Ji = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.kR().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c krM = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cVg();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.kBw = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cUG().isInit()) {
                            b.this.cUZ();
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
                    b.this.cVf();
                } else {
                    b.this.cVe();
                }
            }
        }
    };
    private final CustomMessageListener kBD = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.kBA != null) {
                    b.this.kBA.clear();
                }
                if (b.this.kBB != null) {
                    b.this.kBB.clear();
                }
                b.this.kBw = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bzQ().setInterval();
                    b.cVc().cVd();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cVc().cUZ();
                }
            }
        });
        kBo = null;
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
                    b.cVc().mHandler.removeMessages(2);
                    b.cVc().cVh();
                    return;
                case 3:
                    b.cVc().mHandler.removeMessages(3);
                    if (b.cVc().kBz == 3) {
                        b.cVc().cVi();
                    } else {
                        b.cVc().cVh();
                    }
                    b.cVc().mHandler.sendMessageDelayed(b.cVc().mHandler.obtainMessage(3), b.cVc().kBr);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 10) {
            i.h(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(CmdConfigSocket.CMD_MESSAGE_SYNC, this.mTag);
        int processingResponsedMessageNum = MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum(CmdConfigSocket.CMD_MESSAGE_SYNC);
        if (a2 || processingResponsedMessageNum > 0) {
            i.h(false, false, true);
            CR(i);
            return;
        }
        cVk();
        LongSparseArray<Long> longSparseArray2 = null;
        if (longSparseArray != null && longSparseArray.size() > 0) {
            LongSparseArray<Long> longSparseArray3 = new LongSparseArray<>();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long keyAt = longSparseArray.keyAt(i2);
                longSparseArray3.put(keyAt, Long.valueOf(longSparseArray.get(keyAt).longValue()));
            }
            longSparseArray2 = longSparseArray3;
        }
        MessageSyncMessage b2 = b(longSparseArray2, i);
        if (i == 3 || i == 2) {
            b2.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cUG().cUS());
        }
        MessageManager.getInstance().sendMessage(b2);
        i.h(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.kBA != null) {
                this.kBA.clear();
            }
            if (this.kBB != null) {
                this.kBB.clear();
            }
        }
    }

    public void cUZ() {
        boolean z;
        if (this.kBw != null) {
            LongSparseArray<Long> cUR = com.baidu.tieba.im.memorycache.b.cUG().cUR();
            if (cUR == null) {
                this.kBw = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.kBw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cUR.get(next.getGroupId()) != null) {
                    if (cUR.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.kBz = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cVc().mHandler.sendMessageDelayed(cVc().mHandler.obtainMessage(3), cVc().kBr);
            }
            this.kBw = null;
        }
    }

    private void cVa() {
        if (this.kBv != 0) {
            if (this.kBv == 1) {
                g(0L, 0L, 0L);
            } else {
                cVh();
            }
        }
    }

    private void cVb() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cVc() {
        b bVar;
        synchronized (b.class) {
            if (kBo == null) {
                kBo = new b();
            }
            bVar = kBo;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.kBD);
        h.bzZ().a(this.Ji);
        MessageManager.getInstance().registerListener(1003, this.krM);
        MessageManager.getInstance().registerListener(1001, this.krM);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.krM);
        cVd();
    }

    public void cVd() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            CO(socketGetMsgStratgy[0] * 1000);
            CP(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cVk();
    }

    public void stop() {
        cVk();
        cVb();
    }

    public void cVe() {
        this.kBr = this.kBq;
    }

    public void cVf() {
        cVc().kBr = cVc().kBp;
    }

    public void CO(int i) {
        if (i > 0) {
            this.kBq = i;
        }
    }

    public void CP(int i) {
        if (i > 0) {
            this.kBp = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cVg() {
        if (System.currentTimeMillis() - this.kBy >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.kBx);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.od().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.od().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.kBy = System.currentTimeMillis();
            this.kBx = 0;
            com.baidu.adp.lib.webSocket.h.od().oi();
            com.baidu.adp.lib.webSocket.h.od().oh();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cUG().cUR());
        }
        messageSyncMessage.setForTimer(this.kBC);
        LocalViewSize.ImageSize brW = LocalViewSize.brU().brW();
        if (brW != null) {
            messageSyncMessage.setWidth(brW.width);
            messageSyncMessage.setHeight(brW.height);
        }
        LocalViewSize.ImageSize brV = LocalViewSize.brU().brV();
        if (brV != null) {
            messageSyncMessage.setSmallHeight(brV.height);
            messageSyncMessage.setSmallWidth(brV.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.kBx++;
        this.kBC = false;
        this.kBz = 1;
        this.mHandler.removeMessages(3);
        cVc().mHandler.sendMessageDelayed(cVc().mHandler.obtainMessage(3), cVc().kBr);
        if (this.kBA == null) {
            this.kBA = new LongSparseArray<>();
            this.kBA.clear();
        }
        if (this.kBB == null) {
            this.kBB = new LongSparseArray<>();
        }
        LongSparseArray<Long> cUR = com.baidu.tieba.im.memorycache.b.cUG().cUR();
        if (0 != j) {
            Long l = cUR.get(j);
            Long l2 = this.kBA.get(j);
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
                this.kBA.put(j, Long.valueOf(longValue));
            }
        }
        if (this.kBA != null && this.kBA.size() > 0) {
            for (int i = 0; i < this.kBA.size(); i++) {
                long keyAt = this.kBA.keyAt(i);
                Long l3 = cUR.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.kBA.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.kBB.get(j) == null) {
                    this.kBB.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.kBB.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.kBB.put(j, Long.valueOf(j2));
                }
            }
            int size = this.kBA.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.kBA.keyAt(i2);
                long longValue3 = this.kBA.valueAt(i2).longValue();
                long j4 = 0;
                if (this.kBB.get(keyAt2) != null) {
                    j4 = this.kBB.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.kBA.remove(((Long) it.next()).longValue());
            }
        }
        if (this.kBA.size() == 0) {
            cVk();
            this.kBB.clear();
        } else {
            a(this.kBA, 1);
        }
    }

    public synchronized void cVh() {
        CQ(2);
    }

    public synchronized void cVi() {
        CQ(3);
    }

    public void cVj() {
        cVa();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.kBC = false;
                this.kBz = 4;
                this.mHandler.removeMessages(3);
                cVc().mHandler.sendMessageDelayed(cVc().mHandler.obtainMessage(3), cVc().kBr);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void CQ(int i) {
        this.kBC = true;
        this.kBz = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void CR(int i) {
        if (i == 1) {
            if (this.kBv != 2) {
                this.kBv = 1;
            }
        } else if (i == 3 || i == 2) {
            this.kBv = 2;
        }
    }

    private void cVk() {
        this.kBv = 0;
    }
}
