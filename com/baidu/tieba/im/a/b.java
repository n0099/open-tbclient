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
    private static b isE;
    private List<GroupUpdateMessage> isM;
    private boolean isS;
    private int isF = 900000;
    private int isG = 360000;
    private int isH = this.isG;
    private final int isI = 0;
    private final int isJ = 1;
    private final int isK = 2;
    private int isL = 0;
    private int isN = 0;
    private long isO = 0;
    private int isP = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> isQ = null;
    private LongSparseArray<Long> isR = null;
    private final com.baidu.adp.framework.client.socket.link.a Hi = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.jB().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c idb = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cif();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.isM = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.chB().isInit()) {
                            b.this.chY();
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
                    b.this.cie();
                } else {
                    b.this.cid();
                }
            }
        }
    };
    private final CustomMessageListener isT = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.isQ != null) {
                    b.this.isQ.clear();
                }
                if (b.this.isR != null) {
                    b.this.isR.clear();
                }
                b.this.isM = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.aVU().setInterval();
                    b.cib().cic();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cib().chY();
                }
            }
        });
        isE = null;
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
                    b.cib().mHandler.removeMessages(2);
                    b.cib().cig();
                    return;
                case 3:
                    b.cib().mHandler.removeMessages(3);
                    if (b.cib().isP == 3) {
                        b.cib().cih();
                    } else {
                        b.cib().cig();
                    }
                    b.cib().mHandler.sendMessageDelayed(b.cib().mHandler.obtainMessage(3), b.cib().isH);
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
            xu(i);
            return;
        }
        cij();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.chB().chN());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.isQ != null) {
                this.isQ.clear();
            }
            if (this.isR != null) {
                this.isR.clear();
            }
        }
    }

    public void chY() {
        boolean z;
        if (this.isM != null) {
            LongSparseArray<Long> chM = com.baidu.tieba.im.memorycache.b.chB().chM();
            if (chM == null) {
                this.isM = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.isM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && chM.get(next.getGroupId()) != null) {
                    if (chM.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.isP = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cib().mHandler.sendMessageDelayed(cib().mHandler.obtainMessage(3), cib().isH);
            }
            this.isM = null;
        }
    }

    private void chZ() {
        if (this.isL != 0) {
            if (this.isL == 1) {
                d(0L, 0L, 0L);
            } else {
                cig();
            }
        }
    }

    private void cia() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cib() {
        b bVar;
        synchronized (b.class) {
            if (isE == null) {
                isE = new b();
            }
            bVar = isE;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.isT);
        h.aWd().a(this.Hi);
        MessageManager.getInstance().registerListener(1003, this.idb);
        MessageManager.getInstance().registerListener(1001, this.idb);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.idb);
        cic();
    }

    public void cic() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            xr(socketGetMsgStratgy[0] * 1000);
            xs(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cij();
    }

    public void stop() {
        cij();
        cia();
    }

    public void cid() {
        this.isH = this.isG;
    }

    public void cie() {
        cib().isH = cib().isF;
    }

    public void xr(int i) {
        if (i > 0) {
            this.isG = i;
        }
    }

    public void xs(int i) {
        if (i > 0) {
            this.isF = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cif() {
        if (System.currentTimeMillis() - this.isO >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.isN);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.mF().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.mF().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.isO = System.currentTimeMillis();
            this.isN = 0;
            com.baidu.adp.lib.webSocket.h.mF().mJ();
            com.baidu.adp.lib.webSocket.h.mF().mI();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.chB().chM());
        }
        messageSyncMessage.setForTimer(this.isS);
        LocalViewSize.ImageSize aOv = LocalViewSize.aOt().aOv();
        if (aOv != null) {
            messageSyncMessage.setWidth(aOv.width);
            messageSyncMessage.setHeight(aOv.height);
        }
        LocalViewSize.ImageSize aOu = LocalViewSize.aOt().aOu();
        if (aOu != null) {
            messageSyncMessage.setSmallHeight(aOu.height);
            messageSyncMessage.setSmallWidth(aOu.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.isN++;
        this.isS = false;
        this.isP = 1;
        this.mHandler.removeMessages(3);
        cib().mHandler.sendMessageDelayed(cib().mHandler.obtainMessage(3), cib().isH);
        if (this.isQ == null) {
            this.isQ = new LongSparseArray<>();
            this.isQ.clear();
        }
        if (this.isR == null) {
            this.isR = new LongSparseArray<>();
        }
        LongSparseArray<Long> chM = com.baidu.tieba.im.memorycache.b.chB().chM();
        if (0 != j) {
            Long l = chM.get(j);
            Long l2 = this.isQ.get(j);
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
                this.isQ.put(j, Long.valueOf(longValue));
            }
        }
        if (this.isQ != null && this.isQ.size() > 0) {
            for (int i = 0; i < this.isQ.size(); i++) {
                long keyAt = this.isQ.keyAt(i);
                Long l3 = chM.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.isQ.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.isR.get(j) == null) {
                    this.isR.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.isR.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.isR.put(j, Long.valueOf(j2));
                }
            }
            int size = this.isQ.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.isQ.keyAt(i2);
                long longValue3 = this.isQ.valueAt(i2).longValue();
                long j4 = 0;
                if (this.isR.get(keyAt2) != null) {
                    j4 = this.isR.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.isQ.remove(((Long) it.next()).longValue());
            }
        }
        if (this.isQ.size() == 0) {
            cij();
            this.isR.clear();
        } else {
            a(this.isQ, 1);
        }
    }

    public synchronized void cig() {
        xt(2);
    }

    public synchronized void cih() {
        xt(3);
    }

    public void cii() {
        chZ();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.isS = false;
                this.isP = 4;
                this.mHandler.removeMessages(3);
                cib().mHandler.sendMessageDelayed(cib().mHandler.obtainMessage(3), cib().isH);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void xt(int i) {
        this.isS = true;
        this.isP = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void xu(int i) {
        if (i == 1) {
            if (this.isL != 2) {
                this.isL = 1;
            }
        } else if (i == 3 || i == 2) {
            this.isL = 2;
        }
    }

    private void cij() {
        this.isL = 0;
    }
}
