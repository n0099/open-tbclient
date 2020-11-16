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
    private static b knh;
    private List<GroupUpdateMessage> knp;
    private boolean knv;
    private int kni = 900000;
    private int knj = 360000;
    private int knk = this.knj;
    private final int knl = 0;
    private final int knm = 1;
    private final int knn = 2;
    private int kno = 0;
    private int knq = 0;
    private long knr = 0;
    private int kns = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> knt = null;
    private LongSparseArray<Long> knu = null;
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
    private final com.baidu.adp.framework.listener.c jVA = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cTY();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.knp = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cTq().isInit()) {
                            b.this.cTR();
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
                    b.this.cTX();
                } else {
                    b.this.cTW();
                }
            }
        }
    };
    private final CustomMessageListener knw = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.knt != null) {
                    b.this.knt.clear();
                }
                if (b.this.knu != null) {
                    b.this.knu.clear();
                }
                b.this.knp = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bxO().setInterval();
                    b.cTU().cTV();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cTU().cTR();
                }
            }
        });
        knh = null;
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
                    b.cTU().mHandler.removeMessages(2);
                    b.cTU().cTZ();
                    return;
                case 3:
                    b.cTU().mHandler.removeMessages(3);
                    if (b.cTU().kns == 3) {
                        b.cTU().cUa();
                    } else {
                        b.cTU().cTZ();
                    }
                    b.cTU().mHandler.sendMessageDelayed(b.cTU().mHandler.obtainMessage(3), b.cTU().knk);
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
            DP(i);
            return;
        }
        cUc();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cTq().cTC());
        }
        MessageManager.getInstance().sendMessage(b);
        j.g(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.knt != null) {
                this.knt.clear();
            }
            if (this.knu != null) {
                this.knu.clear();
            }
        }
    }

    public void cTR() {
        boolean z;
        if (this.knp != null) {
            LongSparseArray<Long> cTB = com.baidu.tieba.im.memorycache.b.cTq().cTB();
            if (cTB == null) {
                this.knp = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.knp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cTB.get(next.getGroupId()) != null) {
                    if (cTB.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.kns = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cTU().mHandler.sendMessageDelayed(cTU().mHandler.obtainMessage(3), cTU().knk);
            }
            this.knp = null;
        }
    }

    private void cTS() {
        if (this.kno != 0) {
            if (this.kno == 1) {
                g(0L, 0L, 0L);
            } else {
                cTZ();
            }
        }
    }

    private void cTT() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cTU() {
        b bVar;
        synchronized (b.class) {
            if (knh == null) {
                knh = new b();
            }
            bVar = knh;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.knw);
        h.bxX().a(this.IR);
        MessageManager.getInstance().registerListener(1003, this.jVA);
        MessageManager.getInstance().registerListener(1001, this.jVA);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.jVA);
        cTV();
    }

    public void cTV() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            DM(socketGetMsgStratgy[0] * 1000);
            DN(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cUc();
    }

    public void stop() {
        cUc();
        cTT();
    }

    public void cTW() {
        this.knk = this.knj;
    }

    public void cTX() {
        cTU().knk = cTU().kni;
    }

    public void DM(int i) {
        if (i > 0) {
            this.knj = i;
        }
    }

    public void DN(int i) {
        if (i > 0) {
            this.kni = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cTY() {
        if (System.currentTimeMillis() - this.knr >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.knq);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.oD().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.oD().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.knr = System.currentTimeMillis();
            this.knq = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cTq().cTB());
        }
        messageSyncMessage.setForTimer(this.knv);
        LocalViewSize.ImageSize bpZ = LocalViewSize.bpX().bpZ();
        if (bpZ != null) {
            messageSyncMessage.setWidth(bpZ.width);
            messageSyncMessage.setHeight(bpZ.height);
        }
        LocalViewSize.ImageSize bpY = LocalViewSize.bpX().bpY();
        if (bpY != null) {
            messageSyncMessage.setSmallHeight(bpY.height);
            messageSyncMessage.setSmallWidth(bpY.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.knq++;
        this.knv = false;
        this.kns = 1;
        this.mHandler.removeMessages(3);
        cTU().mHandler.sendMessageDelayed(cTU().mHandler.obtainMessage(3), cTU().knk);
        if (this.knt == null) {
            this.knt = new LongSparseArray<>();
            this.knt.clear();
        }
        if (this.knu == null) {
            this.knu = new LongSparseArray<>();
        }
        LongSparseArray<Long> cTB = com.baidu.tieba.im.memorycache.b.cTq().cTB();
        if (0 != j) {
            Long l = cTB.get(j);
            Long l2 = this.knt.get(j);
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
                this.knt.put(j, Long.valueOf(longValue));
            }
        }
        if (this.knt != null && this.knt.size() > 0) {
            for (int i = 0; i < this.knt.size(); i++) {
                long keyAt = this.knt.keyAt(i);
                Long l3 = cTB.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.knt.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.knu.get(j) == null) {
                    this.knu.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.knu.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.knu.put(j, Long.valueOf(j2));
                }
            }
            int size = this.knt.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.knt.keyAt(i2);
                long longValue3 = this.knt.valueAt(i2).longValue();
                long j4 = 0;
                if (this.knu.get(keyAt2) != null) {
                    j4 = this.knu.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.knt.remove(((Long) it.next()).longValue());
            }
        }
        if (this.knt.size() == 0) {
            cUc();
            this.knu.clear();
        } else {
            a(this.knt, 1);
        }
    }

    public synchronized void cTZ() {
        DO(2);
    }

    public synchronized void cUa() {
        DO(3);
    }

    public void cUb() {
        cTS();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.knv = false;
                this.kns = 4;
                this.mHandler.removeMessages(3);
                cTU().mHandler.sendMessageDelayed(cTU().mHandler.obtainMessage(3), cTU().knk);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void DO(int i) {
        this.knv = true;
        this.kns = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void DP(int i) {
        if (i == 1) {
            if (this.kno != 2) {
                this.kno = 1;
            }
        } else if (i == 3 || i == 2) {
            this.kno = 2;
        }
    }

    private void cUc() {
        this.kno = 0;
    }
}
