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
    private static b kLJ;
    private List<GroupUpdateMessage> kLR;
    private boolean kLX;
    private int kLK = 900000;
    private int kLL = 360000;
    private int kLM = this.kLL;
    private final int kLN = 0;
    private final int kLO = 1;
    private final int kLP = 2;
    private int kLQ = 0;
    private int kLS = 0;
    private long kLT = 0;
    private int kLU = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> kLV = null;
    private LongSparseArray<Long> kLW = null;
    private final com.baidu.adp.framework.client.socket.link.a Kz = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.kQ().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c kCj = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cXs();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.kLR = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cWS().isInit()) {
                            b.this.cXl();
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
                    b.this.cXr();
                } else {
                    b.this.cXq();
                }
            }
        }
    };
    private final CustomMessageListener kLY = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.kLV != null) {
                    b.this.kLV.clear();
                }
                if (b.this.kLW != null) {
                    b.this.kLW.clear();
                }
                b.this.kLR = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bAl().setInterval();
                    b.cXo().cXp();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cXo().cXl();
                }
            }
        });
        kLJ = null;
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
                    b.cXo().mHandler.removeMessages(2);
                    b.cXo().cXt();
                    return;
                case 3:
                    b.cXo().mHandler.removeMessages(3);
                    if (b.cXo().kLU == 3) {
                        b.cXo().cXu();
                    } else {
                        b.cXo().cXt();
                    }
                    b.cXo().mHandler.sendMessageDelayed(b.cXo().mHandler.obtainMessage(3), b.cXo().kLM);
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
            Dl(i);
            return;
        }
        cXw();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cWS().cXe());
        }
        MessageManager.getInstance().sendMessage(b);
        i.h(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.kLV != null) {
                this.kLV.clear();
            }
            if (this.kLW != null) {
                this.kLW.clear();
            }
        }
    }

    public void cXl() {
        boolean z;
        if (this.kLR != null) {
            LongSparseArray<Long> cXd = com.baidu.tieba.im.memorycache.b.cWS().cXd();
            if (cXd == null) {
                this.kLR = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.kLR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cXd.get(next.getGroupId()) != null) {
                    if (cXd.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.kLU = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cXo().mHandler.sendMessageDelayed(cXo().mHandler.obtainMessage(3), cXo().kLM);
            }
            this.kLR = null;
        }
    }

    private void cXm() {
        if (this.kLQ != 0) {
            if (this.kLQ == 1) {
                h(0L, 0L, 0L);
            } else {
                cXt();
            }
        }
    }

    private void cXn() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cXo() {
        b bVar;
        synchronized (b.class) {
            if (kLJ == null) {
                kLJ = new b();
            }
            bVar = kLJ;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.kLY);
        h.bAu().a(this.Kz);
        MessageManager.getInstance().registerListener(1003, this.kCj);
        MessageManager.getInstance().registerListener(1001, this.kCj);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.kCj);
        cXp();
    }

    public void cXp() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            Di(socketGetMsgStratgy[0] * 1000);
            Dj(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cXw();
    }

    public void stop() {
        cXw();
        cXn();
    }

    public void cXq() {
        this.kLM = this.kLL;
    }

    public void cXr() {
        cXo().kLM = cXo().kLK;
    }

    public void Di(int i) {
        if (i > 0) {
            this.kLL = i;
        }
    }

    public void Dj(int i) {
        if (i > 0) {
            this.kLK = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cXs() {
        if (System.currentTimeMillis() - this.kLT >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.kLS);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ob().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ob().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.kLT = System.currentTimeMillis();
            this.kLS = 0;
            com.baidu.adp.lib.webSocket.h.ob().og();
            com.baidu.adp.lib.webSocket.h.ob().oe();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cWS().cXd());
        }
        messageSyncMessage.setForTimer(this.kLX);
        LocalViewSize.ImageSize bst = LocalViewSize.bsr().bst();
        if (bst != null) {
            messageSyncMessage.setWidth(bst.width);
            messageSyncMessage.setHeight(bst.height);
        }
        LocalViewSize.ImageSize bss = LocalViewSize.bsr().bss();
        if (bss != null) {
            messageSyncMessage.setSmallHeight(bss.height);
            messageSyncMessage.setSmallWidth(bss.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void h(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.kLS++;
        this.kLX = false;
        this.kLU = 1;
        this.mHandler.removeMessages(3);
        cXo().mHandler.sendMessageDelayed(cXo().mHandler.obtainMessage(3), cXo().kLM);
        if (this.kLV == null) {
            this.kLV = new LongSparseArray<>();
            this.kLV.clear();
        }
        if (this.kLW == null) {
            this.kLW = new LongSparseArray<>();
        }
        LongSparseArray<Long> cXd = com.baidu.tieba.im.memorycache.b.cWS().cXd();
        if (0 != j) {
            Long l = cXd.get(j);
            Long l2 = this.kLV.get(j);
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
                this.kLV.put(j, Long.valueOf(longValue));
            }
        }
        if (this.kLV != null && this.kLV.size() > 0) {
            for (int i = 0; i < this.kLV.size(); i++) {
                long keyAt = this.kLV.keyAt(i);
                Long l3 = cXd.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.kLV.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.kLW.get(j) == null) {
                    this.kLW.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.kLW.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.kLW.put(j, Long.valueOf(j2));
                }
            }
            int size = this.kLV.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.kLV.keyAt(i2);
                long longValue3 = this.kLV.valueAt(i2).longValue();
                long j4 = 0;
                if (this.kLW.get(keyAt2) != null) {
                    j4 = this.kLW.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.kLV.remove(((Long) it.next()).longValue());
            }
        }
        if (this.kLV.size() == 0) {
            cXw();
            this.kLW.clear();
        } else {
            a(this.kLV, 1);
        }
    }

    public synchronized void cXt() {
        Dk(2);
    }

    public synchronized void cXu() {
        Dk(3);
    }

    public void cXv() {
        cXm();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.kLX = false;
                this.kLU = 4;
                this.mHandler.removeMessages(3);
                cXo().mHandler.sendMessageDelayed(cXo().mHandler.obtainMessage(3), cXo().kLM);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void Dk(int i) {
        this.kLX = true;
        this.kLU = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void Dl(int i) {
        if (i == 1) {
            if (this.kLQ != 2) {
                this.kLQ = 1;
            }
        } else if (i == 3 || i == 2) {
            this.kLQ = 2;
        }
    }

    private void cXw() {
        this.kLQ = 0;
    }
}
