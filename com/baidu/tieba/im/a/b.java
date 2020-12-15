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
    private static b kAF;
    private List<GroupUpdateMessage> kAN;
    private boolean kAT;
    private int kAG = 900000;
    private int kAH = 360000;
    private int kAI = this.kAH;
    private final int kAJ = 0;
    private final int kAK = 1;
    private final int kAL = 2;
    private int kAM = 0;
    private int kAO = 0;
    private long kAP = 0;
    private int kAQ = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> kAR = null;
    private LongSparseArray<Long> kAS = null;
    private final com.baidu.adp.framework.client.socket.link.a JK = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c kjh = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cZl();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.kAN = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cYD().isInit()) {
                            b.this.cZe();
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
                    b.this.cZk();
                } else {
                    b.this.cZj();
                }
            }
        }
    };
    private final CustomMessageListener kAU = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.kAR != null) {
                    b.this.kAR.clear();
                }
                if (b.this.kAS != null) {
                    b.this.kAS.clear();
                }
                b.this.kAN = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bBo().setInterval();
                    b.cZh().cZi();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cZh().cZe();
                }
            }
        });
        kAF = null;
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
                    b.cZh().mHandler.removeMessages(2);
                    b.cZh().cZm();
                    return;
                case 3:
                    b.cZh().mHandler.removeMessages(3);
                    if (b.cZh().kAQ == 3) {
                        b.cZh().cZn();
                    } else {
                        b.cZh().cZm();
                    }
                    b.cZh().mHandler.sendMessageDelayed(b.cZh().mHandler.obtainMessage(3), b.cZh().kAI);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 10) {
            i.g(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(CmdConfigSocket.CMD_MESSAGE_SYNC, this.mTag);
        int processingResponsedMessageNum = MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum(CmdConfigSocket.CMD_MESSAGE_SYNC);
        if (a2 || processingResponsedMessageNum > 0) {
            i.g(false, false, true);
            EE(i);
            return;
        }
        cZp();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cYD().cYP());
        }
        MessageManager.getInstance().sendMessage(b);
        i.g(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.kAR != null) {
                this.kAR.clear();
            }
            if (this.kAS != null) {
                this.kAS.clear();
            }
        }
    }

    public void cZe() {
        boolean z;
        if (this.kAN != null) {
            LongSparseArray<Long> cYO = com.baidu.tieba.im.memorycache.b.cYD().cYO();
            if (cYO == null) {
                this.kAN = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.kAN.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cYO.get(next.getGroupId()) != null) {
                    if (cYO.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.kAQ = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cZh().mHandler.sendMessageDelayed(cZh().mHandler.obtainMessage(3), cZh().kAI);
            }
            this.kAN = null;
        }
    }

    private void cZf() {
        if (this.kAM != 0) {
            if (this.kAM == 1) {
                g(0L, 0L, 0L);
            } else {
                cZm();
            }
        }
    }

    private void cZg() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cZh() {
        b bVar;
        synchronized (b.class) {
            if (kAF == null) {
                kAF = new b();
            }
            bVar = kAF;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.kAU);
        h.bBx().a(this.JK);
        MessageManager.getInstance().registerListener(1003, this.kjh);
        MessageManager.getInstance().registerListener(1001, this.kjh);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.kjh);
        cZi();
    }

    public void cZi() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            EB(socketGetMsgStratgy[0] * 1000);
            EC(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cZp();
    }

    public void stop() {
        cZp();
        cZg();
    }

    public void cZj() {
        this.kAI = this.kAH;
    }

    public void cZk() {
        cZh().kAI = cZh().kAG;
    }

    public void EB(int i) {
        if (i > 0) {
            this.kAH = i;
        }
    }

    public void EC(int i) {
        if (i > 0) {
            this.kAG = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cZl() {
        if (System.currentTimeMillis() - this.kAP >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.kAO);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.oC().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.oC().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.kAP = System.currentTimeMillis();
            this.kAO = 0;
            com.baidu.adp.lib.webSocket.h.oC().oH();
            com.baidu.adp.lib.webSocket.h.oC().oG();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cYD().cYO());
        }
        messageSyncMessage.setForTimer(this.kAT);
        LocalViewSize.ImageSize btu = LocalViewSize.bts().btu();
        if (btu != null) {
            messageSyncMessage.setWidth(btu.width);
            messageSyncMessage.setHeight(btu.height);
        }
        LocalViewSize.ImageSize btt = LocalViewSize.bts().btt();
        if (btt != null) {
            messageSyncMessage.setSmallHeight(btt.height);
            messageSyncMessage.setSmallWidth(btt.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.kAO++;
        this.kAT = false;
        this.kAQ = 1;
        this.mHandler.removeMessages(3);
        cZh().mHandler.sendMessageDelayed(cZh().mHandler.obtainMessage(3), cZh().kAI);
        if (this.kAR == null) {
            this.kAR = new LongSparseArray<>();
            this.kAR.clear();
        }
        if (this.kAS == null) {
            this.kAS = new LongSparseArray<>();
        }
        LongSparseArray<Long> cYO = com.baidu.tieba.im.memorycache.b.cYD().cYO();
        if (0 != j) {
            Long l = cYO.get(j);
            Long l2 = this.kAR.get(j);
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
                this.kAR.put(j, Long.valueOf(longValue));
            }
        }
        if (this.kAR != null && this.kAR.size() > 0) {
            for (int i = 0; i < this.kAR.size(); i++) {
                long keyAt = this.kAR.keyAt(i);
                Long l3 = cYO.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.kAR.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.kAS.get(j) == null) {
                    this.kAS.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.kAS.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.kAS.put(j, Long.valueOf(j2));
                }
            }
            int size = this.kAR.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.kAR.keyAt(i2);
                long longValue3 = this.kAR.valueAt(i2).longValue();
                long j4 = 0;
                if (this.kAS.get(keyAt2) != null) {
                    j4 = this.kAS.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.kAR.remove(((Long) it.next()).longValue());
            }
        }
        if (this.kAR.size() == 0) {
            cZp();
            this.kAS.clear();
        } else {
            a(this.kAR, 1);
        }
    }

    public synchronized void cZm() {
        ED(2);
    }

    public synchronized void cZn() {
        ED(3);
    }

    public void cZo() {
        cZf();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.kAT = false;
                this.kAQ = 4;
                this.mHandler.removeMessages(3);
                cZh().mHandler.sendMessageDelayed(cZh().mHandler.obtainMessage(3), cZh().kAI);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void ED(int i) {
        this.kAT = true;
        this.kAQ = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void EE(int i) {
        if (i == 1) {
            if (this.kAM != 2) {
                this.kAM = 1;
            }
        } else if (i == 3 || i == 2) {
            this.kAM = 2;
        }
    }

    private void cZp() {
        this.kAM = 0;
    }
}
