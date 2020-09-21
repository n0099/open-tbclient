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
    private static b jFd;
    private List<GroupUpdateMessage> jFl;
    private boolean jFr;
    private int jFe = 900000;
    private int jFf = 360000;
    private int jFg = this.jFf;
    private final int jFh = 0;
    private final int jFi = 1;
    private final int jFj = 2;
    private int jFk = 0;
    private int jFm = 0;
    private long jFn = 0;
    private int jFo = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> jFp = null;
    private LongSparseArray<Long> jFq = null;
    private final com.baidu.adp.framework.client.socket.link.a Iw = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.lu().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c jnx = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cLb();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.jFl = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cKt().isInit()) {
                            b.this.cKU();
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
                    b.this.cLa();
                } else {
                    b.this.cKZ();
                }
            }
        }
    };
    private final CustomMessageListener jFs = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.jFp != null) {
                    b.this.jFp.clear();
                }
                if (b.this.jFq != null) {
                    b.this.jFq.clear();
                }
                b.this.jFl = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.brw().setInterval();
                    b.cKX().cKY();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cKX().cKU();
                }
            }
        });
        jFd = null;
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
                    b.cKX().mHandler.removeMessages(2);
                    b.cKX().cLc();
                    return;
                case 3:
                    b.cKX().mHandler.removeMessages(3);
                    if (b.cKX().jFo == 3) {
                        b.cKX().cLd();
                    } else {
                        b.cKX().cLc();
                    }
                    b.cKX().mHandler.sendMessageDelayed(b.cKX().mHandler.obtainMessage(3), b.cKX().jFg);
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
            Cf(i);
            return;
        }
        cLf();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cKt().cKF());
        }
        MessageManager.getInstance().sendMessage(b);
        j.g(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.jFp != null) {
                this.jFp.clear();
            }
            if (this.jFq != null) {
                this.jFq.clear();
            }
        }
    }

    public void cKU() {
        boolean z;
        if (this.jFl != null) {
            LongSparseArray<Long> cKE = com.baidu.tieba.im.memorycache.b.cKt().cKE();
            if (cKE == null) {
                this.jFl = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.jFl.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cKE.get(next.getGroupId()) != null) {
                    if (cKE.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.jFo = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cKX().mHandler.sendMessageDelayed(cKX().mHandler.obtainMessage(3), cKX().jFg);
            }
            this.jFl = null;
        }
    }

    private void cKV() {
        if (this.jFk != 0) {
            if (this.jFk == 1) {
                g(0L, 0L, 0L);
            } else {
                cLc();
            }
        }
    }

    private void cKW() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cKX() {
        b bVar;
        synchronized (b.class) {
            if (jFd == null) {
                jFd = new b();
            }
            bVar = jFd;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.jFs);
        h.brF().a(this.Iw);
        MessageManager.getInstance().registerListener(1003, this.jnx);
        MessageManager.getInstance().registerListener(1001, this.jnx);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.jnx);
        cKY();
    }

    public void cKY() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            Cc(socketGetMsgStratgy[0] * 1000);
            Cd(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cLf();
    }

    public void stop() {
        cLf();
        cKW();
    }

    public void cKZ() {
        this.jFg = this.jFf;
    }

    public void cLa() {
        cKX().jFg = cKX().jFe;
    }

    public void Cc(int i) {
        if (i > 0) {
            this.jFf = i;
        }
    }

    public void Cd(int i) {
        if (i > 0) {
            this.jFe = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cLb() {
        if (System.currentTimeMillis() - this.jFn >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.jFm);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.oD().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.oD().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.jFn = System.currentTimeMillis();
            this.jFm = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cKt().cKE());
        }
        messageSyncMessage.setForTimer(this.jFr);
        LocalViewSize.ImageSize bjK = LocalViewSize.bjI().bjK();
        if (bjK != null) {
            messageSyncMessage.setWidth(bjK.width);
            messageSyncMessage.setHeight(bjK.height);
        }
        LocalViewSize.ImageSize bjJ = LocalViewSize.bjI().bjJ();
        if (bjJ != null) {
            messageSyncMessage.setSmallHeight(bjJ.height);
            messageSyncMessage.setSmallWidth(bjJ.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.jFm++;
        this.jFr = false;
        this.jFo = 1;
        this.mHandler.removeMessages(3);
        cKX().mHandler.sendMessageDelayed(cKX().mHandler.obtainMessage(3), cKX().jFg);
        if (this.jFp == null) {
            this.jFp = new LongSparseArray<>();
            this.jFp.clear();
        }
        if (this.jFq == null) {
            this.jFq = new LongSparseArray<>();
        }
        LongSparseArray<Long> cKE = com.baidu.tieba.im.memorycache.b.cKt().cKE();
        if (0 != j) {
            Long l = cKE.get(j);
            Long l2 = this.jFp.get(j);
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
                this.jFp.put(j, Long.valueOf(longValue));
            }
        }
        if (this.jFp != null && this.jFp.size() > 0) {
            for (int i = 0; i < this.jFp.size(); i++) {
                long keyAt = this.jFp.keyAt(i);
                Long l3 = cKE.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.jFp.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.jFq.get(j) == null) {
                    this.jFq.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.jFq.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.jFq.put(j, Long.valueOf(j2));
                }
            }
            int size = this.jFp.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.jFp.keyAt(i2);
                long longValue3 = this.jFp.valueAt(i2).longValue();
                long j4 = 0;
                if (this.jFq.get(keyAt2) != null) {
                    j4 = this.jFq.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.jFp.remove(((Long) it.next()).longValue());
            }
        }
        if (this.jFp.size() == 0) {
            cLf();
            this.jFq.clear();
        } else {
            a(this.jFp, 1);
        }
    }

    public synchronized void cLc() {
        Ce(2);
    }

    public synchronized void cLd() {
        Ce(3);
    }

    public void cLe() {
        cKV();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.jFr = false;
                this.jFo = 4;
                this.mHandler.removeMessages(3);
                cKX().mHandler.sendMessageDelayed(cKX().mHandler.obtainMessage(3), cKX().jFg);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void Ce(int i) {
        this.jFr = true;
        this.jFo = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void Cf(int i) {
        if (i == 1) {
            if (this.jFk != 2) {
                this.jFk = 1;
            }
        } else if (i == 3 || i == 2) {
            this.jFk = 2;
        }
    }

    private void cLf() {
        this.jFk = 0;
    }
}
