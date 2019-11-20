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
import com.baidu.tbadk.coreExtra.e.e;
import com.baidu.tbadk.coreExtra.e.h;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.p.j;
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
    private static b gNo;
    private boolean gNC;
    private List<GroupUpdateMessage> gNw;
    private int gNp = 900000;
    private int gNq = 360000;
    private int gNr = this.gNq;
    private final int gNs = 0;
    private final int gNt = 1;
    private final int gNu = 2;
    private int gNv = 0;
    private int gNx = 0;
    private long gNy = 0;
    private int gNz = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gNA = null;
    private LongSparseArray<Long> gNB = null;
    private final com.baidu.adp.framework.client.socket.link.a lB = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.eB().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c gxN = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bDo();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gNw = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bCK().bCJ()) {
                            b.this.bDh();
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
                    b.this.bDn();
                } else {
                    b.this.bDm();
                }
            }
        }
    };
    private final CustomMessageListener gND = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gNA != null) {
                    b.this.gNA.clear();
                }
                if (b.this.gNB != null) {
                    b.this.gNB.clear();
                }
                b.this.gNw = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.atf().setInterval();
                    b.bDk().bDl();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bDk().bDh();
                }
            }
        });
        gNo = null;
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
                    b.bDk().mHandler.removeMessages(2);
                    b.bDk().bDp();
                    return;
                case 3:
                    b.bDk().mHandler.removeMessages(3);
                    if (b.bDk().gNz == 3) {
                        b.bDk().bDq();
                    } else {
                        b.bDk().bDp();
                    }
                    b.bDk().mHandler.sendMessageDelayed(b.bDk().mHandler.obtainMessage(3), b.bDk().gNr);
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
            uB(i);
            return;
        }
        bDs();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bCK().bCW());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gNA != null) {
                this.gNA.clear();
            }
            if (this.gNB != null) {
                this.gNB.clear();
            }
        }
    }

    public void bDh() {
        boolean z;
        if (this.gNw != null) {
            LongSparseArray<Long> bCV = com.baidu.tieba.im.memorycache.b.bCK().bCV();
            if (bCV == null) {
                this.gNw = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gNw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bCV.get(next.getGroupId()) != null) {
                    if (bCV.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gNz = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bDk().mHandler.sendMessageDelayed(bDk().mHandler.obtainMessage(3), bDk().gNr);
            }
            this.gNw = null;
        }
    }

    private void bDi() {
        if (this.gNv != 0) {
            if (this.gNv == 1) {
                d(0L, 0L, 0L);
            } else {
                bDp();
            }
        }
    }

    private void bDj() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bDk() {
        b bVar;
        synchronized (b.class) {
            if (gNo == null) {
                gNo = new b();
            }
            bVar = gNo;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gND);
        h.atl().a(this.lB);
        MessageManager.getInstance().registerListener(1003, this.gxN);
        MessageManager.getInstance().registerListener(1001, this.gxN);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.gxN);
        bDl();
    }

    public void bDl() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            uy(socketGetMsgStratgy[0] * 1000);
            uz(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bDs();
    }

    public void stop() {
        bDs();
        bDj();
    }

    public void bDm() {
        this.gNr = this.gNq;
    }

    public void bDn() {
        bDk().gNr = bDk().gNp;
    }

    public void uy(int i) {
        if (i > 0) {
            this.gNq = i;
        }
    }

    public void uz(int i) {
        if (i > 0) {
            this.gNp = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bDo() {
        if (System.currentTimeMillis() - this.gNy >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gNx);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hr().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hr().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gNy = System.currentTimeMillis();
            this.gNx = 0;
            com.baidu.adp.lib.webSocket.h.hr().hw();
            com.baidu.adp.lib.webSocket.h.hr().hv();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bCK().bCV());
        }
        messageSyncMessage.setForTimer(this.gNC);
        LocalViewSize.ImageSize amo = LocalViewSize.amm().amo();
        if (amo != null) {
            messageSyncMessage.setWidth(amo.width);
            messageSyncMessage.setHeight(amo.height);
        }
        LocalViewSize.ImageSize amn = LocalViewSize.amm().amn();
        if (amn != null) {
            messageSyncMessage.setSmallHeight(amn.height);
            messageSyncMessage.setSmallWidth(amn.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.gNx++;
        this.gNC = false;
        this.gNz = 1;
        this.mHandler.removeMessages(3);
        bDk().mHandler.sendMessageDelayed(bDk().mHandler.obtainMessage(3), bDk().gNr);
        if (this.gNA == null) {
            this.gNA = new LongSparseArray<>();
            this.gNA.clear();
        }
        if (this.gNB == null) {
            this.gNB = new LongSparseArray<>();
        }
        LongSparseArray<Long> bCV = com.baidu.tieba.im.memorycache.b.bCK().bCV();
        if (0 != j) {
            Long l = bCV.get(j);
            Long l2 = this.gNA.get(j);
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
                this.gNA.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gNA != null && this.gNA.size() > 0) {
            for (int i = 0; i < this.gNA.size(); i++) {
                long keyAt = this.gNA.keyAt(i);
                Long l3 = bCV.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gNA.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gNB.get(j) == null) {
                    this.gNB.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gNB.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gNB.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gNA.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gNA.keyAt(i2);
                long longValue3 = this.gNA.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gNB.get(keyAt2) != null) {
                    j4 = this.gNB.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gNA.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gNA.size() == 0) {
            bDs();
            this.gNB.clear();
        } else {
            a(this.gNA, 1);
        }
    }

    public synchronized void bDp() {
        uA(2);
    }

    public synchronized void bDq() {
        uA(3);
    }

    public void bDr() {
        bDi();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gNC = false;
                this.gNz = 4;
                this.mHandler.removeMessages(3);
                bDk().mHandler.sendMessageDelayed(bDk().mHandler.obtainMessage(3), bDk().gNr);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void uA(int i) {
        this.gNC = true;
        this.gNz = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void uB(int i) {
        if (i == 1) {
            if (this.gNv != 2) {
                this.gNv = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gNv = 2;
        }
    }

    private void bDs() {
        this.gNv = 0;
    }
}
