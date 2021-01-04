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
    private static b kFT;
    private List<GroupUpdateMessage> kGb;
    private boolean kGh;
    private int kFU = 900000;
    private int kFV = 360000;
    private int kFW = this.kFV;
    private final int kFX = 0;
    private final int kFY = 1;
    private final int kFZ = 2;
    private int kGa = 0;
    private int kGc = 0;
    private long kGd = 0;
    private int kGe = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> kGf = null;
    private LongSparseArray<Long> kGg = null;
    private final com.baidu.adp.framework.client.socket.link.a Jk = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c kwr = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cYX();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.kGb = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cYx().isInit()) {
                            b.this.cYQ();
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
                    b.this.cYW();
                } else {
                    b.this.cYV();
                }
            }
        }
    };
    private final CustomMessageListener kGi = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.kGf != null) {
                    b.this.kGf.clear();
                }
                if (b.this.kGg != null) {
                    b.this.kGg.clear();
                }
                b.this.kGb = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bDJ().setInterval();
                    b.cYT().cYU();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cYT().cYQ();
                }
            }
        });
        kFT = null;
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
                    b.cYT().mHandler.removeMessages(2);
                    b.cYT().cYY();
                    return;
                case 3:
                    b.cYT().mHandler.removeMessages(3);
                    if (b.cYT().kGe == 3) {
                        b.cYT().cYZ();
                    } else {
                        b.cYT().cYY();
                    }
                    b.cYT().mHandler.sendMessageDelayed(b.cYT().mHandler.obtainMessage(3), b.cYT().kFW);
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
            Ex(i);
            return;
        }
        cZb();
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
            b2.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cYx().cYJ());
        }
        MessageManager.getInstance().sendMessage(b2);
        i.h(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.kGf != null) {
                this.kGf.clear();
            }
            if (this.kGg != null) {
                this.kGg.clear();
            }
        }
    }

    public void cYQ() {
        boolean z;
        if (this.kGb != null) {
            LongSparseArray<Long> cYI = com.baidu.tieba.im.memorycache.b.cYx().cYI();
            if (cYI == null) {
                this.kGb = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.kGb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cYI.get(next.getGroupId()) != null) {
                    if (cYI.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.kGe = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cYT().mHandler.sendMessageDelayed(cYT().mHandler.obtainMessage(3), cYT().kFW);
            }
            this.kGb = null;
        }
    }

    private void cYR() {
        if (this.kGa != 0) {
            if (this.kGa == 1) {
                g(0L, 0L, 0L);
            } else {
                cYY();
            }
        }
    }

    private void cYS() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cYT() {
        b bVar;
        synchronized (b.class) {
            if (kFT == null) {
                kFT = new b();
            }
            bVar = kFT;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.kGi);
        h.bDS().a(this.Jk);
        MessageManager.getInstance().registerListener(1003, this.kwr);
        MessageManager.getInstance().registerListener(1001, this.kwr);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.kwr);
        cYU();
    }

    public void cYU() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            Eu(socketGetMsgStratgy[0] * 1000);
            Ev(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cZb();
    }

    public void stop() {
        cZb();
        cYS();
    }

    public void cYV() {
        this.kFW = this.kFV;
    }

    public void cYW() {
        cYT().kFW = cYT().kFU;
    }

    public void Eu(int i) {
        if (i > 0) {
            this.kFV = i;
        }
    }

    public void Ev(int i) {
        if (i > 0) {
            this.kFU = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cYX() {
        if (System.currentTimeMillis() - this.kGd >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.kGc);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.od().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.od().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.kGd = System.currentTimeMillis();
            this.kGc = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cYx().cYI());
        }
        messageSyncMessage.setForTimer(this.kGh);
        LocalViewSize.ImageSize bvP = LocalViewSize.bvN().bvP();
        if (bvP != null) {
            messageSyncMessage.setWidth(bvP.width);
            messageSyncMessage.setHeight(bvP.height);
        }
        LocalViewSize.ImageSize bvO = LocalViewSize.bvN().bvO();
        if (bvO != null) {
            messageSyncMessage.setSmallHeight(bvO.height);
            messageSyncMessage.setSmallWidth(bvO.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.kGc++;
        this.kGh = false;
        this.kGe = 1;
        this.mHandler.removeMessages(3);
        cYT().mHandler.sendMessageDelayed(cYT().mHandler.obtainMessage(3), cYT().kFW);
        if (this.kGf == null) {
            this.kGf = new LongSparseArray<>();
            this.kGf.clear();
        }
        if (this.kGg == null) {
            this.kGg = new LongSparseArray<>();
        }
        LongSparseArray<Long> cYI = com.baidu.tieba.im.memorycache.b.cYx().cYI();
        if (0 != j) {
            Long l = cYI.get(j);
            Long l2 = this.kGf.get(j);
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
                this.kGf.put(j, Long.valueOf(longValue));
            }
        }
        if (this.kGf != null && this.kGf.size() > 0) {
            for (int i = 0; i < this.kGf.size(); i++) {
                long keyAt = this.kGf.keyAt(i);
                Long l3 = cYI.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.kGf.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.kGg.get(j) == null) {
                    this.kGg.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.kGg.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.kGg.put(j, Long.valueOf(j2));
                }
            }
            int size = this.kGf.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.kGf.keyAt(i2);
                long longValue3 = this.kGf.valueAt(i2).longValue();
                long j4 = 0;
                if (this.kGg.get(keyAt2) != null) {
                    j4 = this.kGg.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.kGf.remove(((Long) it.next()).longValue());
            }
        }
        if (this.kGf.size() == 0) {
            cZb();
            this.kGg.clear();
        } else {
            a(this.kGf, 1);
        }
    }

    public synchronized void cYY() {
        Ew(2);
    }

    public synchronized void cYZ() {
        Ew(3);
    }

    public void cZa() {
        cYR();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.kGh = false;
                this.kGe = 4;
                this.mHandler.removeMessages(3);
                cYT().mHandler.sendMessageDelayed(cYT().mHandler.obtainMessage(3), cYT().kFW);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void Ew(int i) {
        this.kGh = true;
        this.kGe = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void Ex(int i) {
        if (i == 1) {
            if (this.kGa != 2) {
                this.kGa = 1;
            }
        } else if (i == 3 || i == 2) {
            this.kGa = 2;
        }
    }

    private void cZb() {
        this.kGa = 0;
    }
}
