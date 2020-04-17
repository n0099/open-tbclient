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
    private static b isy;
    private List<GroupUpdateMessage> isG;
    private boolean isM;
    private int isz = 900000;
    private int isA = 360000;
    private int isB = this.isA;
    private final int isC = 0;
    private final int isD = 1;
    private final int isE = 2;
    private int isF = 0;
    private int isH = 0;
    private long isI = 0;
    private int isJ = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> isK = null;
    private LongSparseArray<Long> isL = null;
    private final com.baidu.adp.framework.client.socket.link.a Hf = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c icV = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cig();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.isG = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.chC().isInit()) {
                            b.this.chZ();
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
                    b.this.cif();
                } else {
                    b.this.cie();
                }
            }
        }
    };
    private final CustomMessageListener isN = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.isK != null) {
                    b.this.isK.clear();
                }
                if (b.this.isL != null) {
                    b.this.isL.clear();
                }
                b.this.isG = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.aVW().setInterval();
                    b.cic().cid();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cic().chZ();
                }
            }
        });
        isy = null;
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
                    b.cic().mHandler.removeMessages(2);
                    b.cic().cih();
                    return;
                case 3:
                    b.cic().mHandler.removeMessages(3);
                    if (b.cic().isJ == 3) {
                        b.cic().cii();
                    } else {
                        b.cic().cih();
                    }
                    b.cic().mHandler.sendMessageDelayed(b.cic().mHandler.obtainMessage(3), b.cic().isB);
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
        cik();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.chC().chO());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.isK != null) {
                this.isK.clear();
            }
            if (this.isL != null) {
                this.isL.clear();
            }
        }
    }

    public void chZ() {
        boolean z;
        if (this.isG != null) {
            LongSparseArray<Long> chN = com.baidu.tieba.im.memorycache.b.chC().chN();
            if (chN == null) {
                this.isG = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.isG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && chN.get(next.getGroupId()) != null) {
                    if (chN.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.isJ = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cic().mHandler.sendMessageDelayed(cic().mHandler.obtainMessage(3), cic().isB);
            }
            this.isG = null;
        }
    }

    private void cia() {
        if (this.isF != 0) {
            if (this.isF == 1) {
                d(0L, 0L, 0L);
            } else {
                cih();
            }
        }
    }

    private void cib() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cic() {
        b bVar;
        synchronized (b.class) {
            if (isy == null) {
                isy = new b();
            }
            bVar = isy;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.isN);
        h.aWf().a(this.Hf);
        MessageManager.getInstance().registerListener(1003, this.icV);
        MessageManager.getInstance().registerListener(1001, this.icV);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.icV);
        cid();
    }

    public void cid() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            xr(socketGetMsgStratgy[0] * 1000);
            xs(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cik();
    }

    public void stop() {
        cik();
        cib();
    }

    public void cie() {
        this.isB = this.isA;
    }

    public void cif() {
        cic().isB = cic().isz;
    }

    public void xr(int i) {
        if (i > 0) {
            this.isA = i;
        }
    }

    public void xs(int i) {
        if (i > 0) {
            this.isz = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cig() {
        if (System.currentTimeMillis() - this.isI >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.isH);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.mF().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.mF().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.isI = System.currentTimeMillis();
            this.isH = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.chC().chN());
        }
        messageSyncMessage.setForTimer(this.isM);
        LocalViewSize.ImageSize aOx = LocalViewSize.aOv().aOx();
        if (aOx != null) {
            messageSyncMessage.setWidth(aOx.width);
            messageSyncMessage.setHeight(aOx.height);
        }
        LocalViewSize.ImageSize aOw = LocalViewSize.aOv().aOw();
        if (aOw != null) {
            messageSyncMessage.setSmallHeight(aOw.height);
            messageSyncMessage.setSmallWidth(aOw.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.isH++;
        this.isM = false;
        this.isJ = 1;
        this.mHandler.removeMessages(3);
        cic().mHandler.sendMessageDelayed(cic().mHandler.obtainMessage(3), cic().isB);
        if (this.isK == null) {
            this.isK = new LongSparseArray<>();
            this.isK.clear();
        }
        if (this.isL == null) {
            this.isL = new LongSparseArray<>();
        }
        LongSparseArray<Long> chN = com.baidu.tieba.im.memorycache.b.chC().chN();
        if (0 != j) {
            Long l = chN.get(j);
            Long l2 = this.isK.get(j);
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
                this.isK.put(j, Long.valueOf(longValue));
            }
        }
        if (this.isK != null && this.isK.size() > 0) {
            for (int i = 0; i < this.isK.size(); i++) {
                long keyAt = this.isK.keyAt(i);
                Long l3 = chN.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.isK.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.isL.get(j) == null) {
                    this.isL.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.isL.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.isL.put(j, Long.valueOf(j2));
                }
            }
            int size = this.isK.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.isK.keyAt(i2);
                long longValue3 = this.isK.valueAt(i2).longValue();
                long j4 = 0;
                if (this.isL.get(keyAt2) != null) {
                    j4 = this.isL.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.isK.remove(((Long) it.next()).longValue());
            }
        }
        if (this.isK.size() == 0) {
            cik();
            this.isL.clear();
        } else {
            a(this.isK, 1);
        }
    }

    public synchronized void cih() {
        xt(2);
    }

    public synchronized void cii() {
        xt(3);
    }

    public void cij() {
        cia();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.isM = false;
                this.isJ = 4;
                this.mHandler.removeMessages(3);
                cic().mHandler.sendMessageDelayed(cic().mHandler.obtainMessage(3), cic().isB);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void xt(int i) {
        this.isM = true;
        this.isJ = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void xu(int i) {
        if (i == 1) {
            if (this.isF != 2) {
                this.isF = 1;
            }
        } else if (i == 3 || i == 2) {
            this.isF = 2;
        }
    }

    private void cik() {
        this.isF = 0;
    }
}
