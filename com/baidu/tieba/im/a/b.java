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
    private static b jht;
    private List<GroupUpdateMessage> jhB;
    private boolean jhH;
    private int jhu = 900000;
    private int jhv = 360000;
    private int jhw = this.jhv;
    private final int jhx = 0;
    private final int jhy = 1;
    private final int jhz = 2;
    private int jhA = 0;
    private int jhC = 0;
    private long jhD = 0;
    private int jhE = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> jhF = null;
    private LongSparseArray<Long> jhG = null;
    private final com.baidu.adp.framework.client.socket.link.a HJ = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.jR().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c iPM = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cwD();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.jhB = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cvV().isInit()) {
                            b.this.cww();
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
                    b.this.cwC();
                } else {
                    b.this.cwB();
                }
            }
        }
    };
    private final CustomMessageListener jhI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.jhF != null) {
                    b.this.jhF.clear();
                }
                if (b.this.jhG != null) {
                    b.this.jhG.clear();
                }
                b.this.jhB = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bhP().setInterval();
                    b.cwz().cwA();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cwz().cww();
                }
            }
        });
        jht = null;
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
                    b.cwz().mHandler.removeMessages(2);
                    b.cwz().cwE();
                    return;
                case 3:
                    b.cwz().mHandler.removeMessages(3);
                    if (b.cwz().jhE == 3) {
                        b.cwz().cwF();
                    } else {
                        b.cwz().cwE();
                    }
                    b.cwz().mHandler.sendMessageDelayed(b.cwz().mHandler.obtainMessage(3), b.cwz().jhw);
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
            zl(i);
            return;
        }
        cwH();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cvV().cwh());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.jhF != null) {
                this.jhF.clear();
            }
            if (this.jhG != null) {
                this.jhG.clear();
            }
        }
    }

    public void cww() {
        boolean z;
        if (this.jhB != null) {
            LongSparseArray<Long> cwg = com.baidu.tieba.im.memorycache.b.cvV().cwg();
            if (cwg == null) {
                this.jhB = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.jhB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cwg.get(next.getGroupId()) != null) {
                    if (cwg.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.jhE = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cwz().mHandler.sendMessageDelayed(cwz().mHandler.obtainMessage(3), cwz().jhw);
            }
            this.jhB = null;
        }
    }

    private void cwx() {
        if (this.jhA != 0) {
            if (this.jhA == 1) {
                g(0L, 0L, 0L);
            } else {
                cwE();
            }
        }
    }

    private void cwy() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cwz() {
        b bVar;
        synchronized (b.class) {
            if (jht == null) {
                jht = new b();
            }
            bVar = jht;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.jhI);
        h.bhY().a(this.HJ);
        MessageManager.getInstance().registerListener(1003, this.iPM);
        MessageManager.getInstance().registerListener(1001, this.iPM);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.iPM);
        cwA();
    }

    public void cwA() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            zi(socketGetMsgStratgy[0] * 1000);
            zj(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cwH();
    }

    public void stop() {
        cwH();
        cwy();
    }

    public void cwB() {
        this.jhw = this.jhv;
    }

    public void cwC() {
        cwz().jhw = cwz().jhu;
    }

    public void zi(int i) {
        if (i > 0) {
            this.jhv = i;
        }
    }

    public void zj(int i) {
        if (i > 0) {
            this.jhu = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cwD() {
        if (System.currentTimeMillis() - this.jhD >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.jhC);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.mY().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.mY().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.jhD = System.currentTimeMillis();
            this.jhC = 0;
            com.baidu.adp.lib.webSocket.h.mY().nc();
            com.baidu.adp.lib.webSocket.h.mY().nb();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cvV().cwg());
        }
        messageSyncMessage.setForTimer(this.jhH);
        LocalViewSize.ImageSize bau = LocalViewSize.bas().bau();
        if (bau != null) {
            messageSyncMessage.setWidth(bau.width);
            messageSyncMessage.setHeight(bau.height);
        }
        LocalViewSize.ImageSize bat = LocalViewSize.bas().bat();
        if (bat != null) {
            messageSyncMessage.setSmallHeight(bat.height);
            messageSyncMessage.setSmallWidth(bat.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.jhC++;
        this.jhH = false;
        this.jhE = 1;
        this.mHandler.removeMessages(3);
        cwz().mHandler.sendMessageDelayed(cwz().mHandler.obtainMessage(3), cwz().jhw);
        if (this.jhF == null) {
            this.jhF = new LongSparseArray<>();
            this.jhF.clear();
        }
        if (this.jhG == null) {
            this.jhG = new LongSparseArray<>();
        }
        LongSparseArray<Long> cwg = com.baidu.tieba.im.memorycache.b.cvV().cwg();
        if (0 != j) {
            Long l = cwg.get(j);
            Long l2 = this.jhF.get(j);
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
                this.jhF.put(j, Long.valueOf(longValue));
            }
        }
        if (this.jhF != null && this.jhF.size() > 0) {
            for (int i = 0; i < this.jhF.size(); i++) {
                long keyAt = this.jhF.keyAt(i);
                Long l3 = cwg.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.jhF.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.jhG.get(j) == null) {
                    this.jhG.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.jhG.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.jhG.put(j, Long.valueOf(j2));
                }
            }
            int size = this.jhF.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.jhF.keyAt(i2);
                long longValue3 = this.jhF.valueAt(i2).longValue();
                long j4 = 0;
                if (this.jhG.get(keyAt2) != null) {
                    j4 = this.jhG.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.jhF.remove(((Long) it.next()).longValue());
            }
        }
        if (this.jhF.size() == 0) {
            cwH();
            this.jhG.clear();
        } else {
            a(this.jhF, 1);
        }
    }

    public synchronized void cwE() {
        zk(2);
    }

    public synchronized void cwF() {
        zk(3);
    }

    public void cwG() {
        cwx();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.jhH = false;
                this.jhE = 4;
                this.mHandler.removeMessages(3);
                cwz().mHandler.sendMessageDelayed(cwz().mHandler.obtainMessage(3), cwz().jhw);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void zk(int i) {
        this.jhH = true;
        this.jhE = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void zl(int i) {
        if (i == 1) {
            if (this.jhA != 2) {
                this.jhA = 1;
            }
        } else if (i == 3 || i == 2) {
            this.jhA = 2;
        }
    }

    private void cwH() {
        this.jhA = 0;
    }
}
