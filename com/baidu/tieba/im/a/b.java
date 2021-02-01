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
    private static b kJt;
    private List<GroupUpdateMessage> kJB;
    private boolean kJH;
    private int kJu = 900000;
    private int kJv = 360000;
    private int kJw = this.kJv;
    private final int kJx = 0;
    private final int kJy = 1;
    private final int kJz = 2;
    private int kJA = 0;
    private int kJC = 0;
    private long kJD = 0;
    private int kJE = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> kJF = null;
    private LongSparseArray<Long> kJG = null;
    private final com.baidu.adp.framework.client.socket.link.a Jh = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
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
    private final com.baidu.adp.framework.listener.c kzT = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cXe();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.kJB = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cWE().isInit()) {
                            b.this.cWX();
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
                    b.this.cXd();
                } else {
                    b.this.cXc();
                }
            }
        }
    };
    private final CustomMessageListener kJI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.kJF != null) {
                    b.this.kJF.clear();
                }
                if (b.this.kJG != null) {
                    b.this.kJG.clear();
                }
                b.this.kJB = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bAi().setInterval();
                    b.cXa().cXb();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cXa().cWX();
                }
            }
        });
        kJt = null;
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
                    b.cXa().mHandler.removeMessages(2);
                    b.cXa().cXf();
                    return;
                case 3:
                    b.cXa().mHandler.removeMessages(3);
                    if (b.cXa().kJE == 3) {
                        b.cXa().cXg();
                    } else {
                        b.cXa().cXf();
                    }
                    b.cXa().mHandler.sendMessageDelayed(b.cXa().mHandler.obtainMessage(3), b.cXa().kJw);
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
            Di(i);
            return;
        }
        cXi();
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
            b2.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cWE().cWQ());
        }
        MessageManager.getInstance().sendMessage(b2);
        i.h(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.kJF != null) {
                this.kJF.clear();
            }
            if (this.kJG != null) {
                this.kJG.clear();
            }
        }
    }

    public void cWX() {
        boolean z;
        if (this.kJB != null) {
            LongSparseArray<Long> cWP = com.baidu.tieba.im.memorycache.b.cWE().cWP();
            if (cWP == null) {
                this.kJB = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.kJB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cWP.get(next.getGroupId()) != null) {
                    if (cWP.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.kJE = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cXa().mHandler.sendMessageDelayed(cXa().mHandler.obtainMessage(3), cXa().kJw);
            }
            this.kJB = null;
        }
    }

    private void cWY() {
        if (this.kJA != 0) {
            if (this.kJA == 1) {
                g(0L, 0L, 0L);
            } else {
                cXf();
            }
        }
    }

    private void cWZ() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cXa() {
        b bVar;
        synchronized (b.class) {
            if (kJt == null) {
                kJt = new b();
            }
            bVar = kJt;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.kJI);
        h.bAr().a(this.Jh);
        MessageManager.getInstance().registerListener(1003, this.kzT);
        MessageManager.getInstance().registerListener(1001, this.kzT);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.kzT);
        cXb();
    }

    public void cXb() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            Df(socketGetMsgStratgy[0] * 1000);
            Dg(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cXi();
    }

    public void stop() {
        cXi();
        cWZ();
    }

    public void cXc() {
        this.kJw = this.kJv;
    }

    public void cXd() {
        cXa().kJw = cXa().kJu;
    }

    public void Df(int i) {
        if (i > 0) {
            this.kJv = i;
        }
    }

    public void Dg(int i) {
        if (i > 0) {
            this.kJu = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cXe() {
        if (System.currentTimeMillis() - this.kJD >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.kJC);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ob().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ob().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.kJD = System.currentTimeMillis();
            this.kJC = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cWE().cWP());
        }
        messageSyncMessage.setForTimer(this.kJH);
        LocalViewSize.ImageSize bsq = LocalViewSize.bso().bsq();
        if (bsq != null) {
            messageSyncMessage.setWidth(bsq.width);
            messageSyncMessage.setHeight(bsq.height);
        }
        LocalViewSize.ImageSize bsp = LocalViewSize.bso().bsp();
        if (bsp != null) {
            messageSyncMessage.setSmallHeight(bsp.height);
            messageSyncMessage.setSmallWidth(bsp.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.kJC++;
        this.kJH = false;
        this.kJE = 1;
        this.mHandler.removeMessages(3);
        cXa().mHandler.sendMessageDelayed(cXa().mHandler.obtainMessage(3), cXa().kJw);
        if (this.kJF == null) {
            this.kJF = new LongSparseArray<>();
            this.kJF.clear();
        }
        if (this.kJG == null) {
            this.kJG = new LongSparseArray<>();
        }
        LongSparseArray<Long> cWP = com.baidu.tieba.im.memorycache.b.cWE().cWP();
        if (0 != j) {
            Long l = cWP.get(j);
            Long l2 = this.kJF.get(j);
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
                this.kJF.put(j, Long.valueOf(longValue));
            }
        }
        if (this.kJF != null && this.kJF.size() > 0) {
            for (int i = 0; i < this.kJF.size(); i++) {
                long keyAt = this.kJF.keyAt(i);
                Long l3 = cWP.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.kJF.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.kJG.get(j) == null) {
                    this.kJG.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.kJG.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.kJG.put(j, Long.valueOf(j2));
                }
            }
            int size = this.kJF.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.kJF.keyAt(i2);
                long longValue3 = this.kJF.valueAt(i2).longValue();
                long j4 = 0;
                if (this.kJG.get(keyAt2) != null) {
                    j4 = this.kJG.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.kJF.remove(((Long) it.next()).longValue());
            }
        }
        if (this.kJF.size() == 0) {
            cXi();
            this.kJG.clear();
        } else {
            a(this.kJF, 1);
        }
    }

    public synchronized void cXf() {
        Dh(2);
    }

    public synchronized void cXg() {
        Dh(3);
    }

    public void cXh() {
        cWY();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.kJH = false;
                this.kJE = 4;
                this.mHandler.removeMessages(3);
                cXa().mHandler.sendMessageDelayed(cXa().mHandler.obtainMessage(3), cXa().kJw);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void Dh(int i) {
        this.kJH = true;
        this.kJE = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void Di(int i) {
        if (i == 1) {
            if (this.kJA != 2) {
                this.kJA = 1;
            }
        } else if (i == 3 || i == 2) {
            this.kJA = 2;
        }
    }

    private void cXi() {
        this.kJA = 0;
    }
}
