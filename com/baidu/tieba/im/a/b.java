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
import com.baidu.adp.lib.webSocket.h;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.coreExtra.websocketBase.g;
import com.baidu.tbadk.l.j;
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
    private static b eOo;
    private boolean eOC;
    private List<GroupUpdateMessage> eOw;
    private int eOp = 900000;
    private int eOq = 360000;
    private int eOr = this.eOq;
    private final int eOs = 0;
    private final int eOt = 1;
    private final int eOu = 2;
    private int eOv = 0;
    private int eOx = 0;
    private long eOy = 0;
    private int eOz = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> eOA = null;
    private LongSparseArray<Long> eOB = null;
    private final com.baidu.adp.framework.client.socket.link.a wC = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void i(Map<String, String> map) {
            b.this.start();
            f.gN().h(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void aj(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c eyS = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aSf();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.eOw = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aRy().qr()) {
                            b.this.aRY();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.im.a.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    b.this.aSe();
                } else {
                    b.this.aSd();
                }
            }
        }
    };
    private final CustomMessageListener eOD = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.eOA != null) {
                    b.this.eOA.clear();
                }
                if (b.this.eOB != null) {
                    b.this.eOB.clear();
                }
                b.this.eOw = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.JQ().JR();
                    b.aSb().aSc();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aSb().aRY();
                }
            }
        });
        eOo = null;
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
                    b.aSb().mHandler.removeMessages(2);
                    b.aSb().aSg();
                    return;
                case 3:
                    b.aSb().mHandler.removeMessages(3);
                    if (b.aSb().eOz == 3) {
                        b.aSb().aSh();
                    } else {
                        b.aSb().aSg();
                    }
                    b.aSb().mHandler.sendMessageDelayed(b.aSb().mHandler.obtainMessage(3), b.aSb().eOr);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().gS() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), SystemScreenshotManager.DELAY_TIME);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int P = MessageManager.getInstance().getSocketClient().P(202003);
        if (a2 || P > 0) {
            j.d(false, false, true);
            pB(i);
            return;
        }
        aSj();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aRy().aRK());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.eOA != null) {
                this.eOA.clear();
            }
            if (this.eOB != null) {
                this.eOB.clear();
            }
        }
    }

    public void aRY() {
        boolean z;
        if (this.eOw != null) {
            LongSparseArray<Long> aRJ = com.baidu.tieba.im.memorycache.b.aRy().aRJ();
            if (aRJ == null) {
                this.eOw = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.eOw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aRJ.get(next.getGroupId()) != null) {
                    if (aRJ.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.eOz = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aSb().mHandler.sendMessageDelayed(aSb().mHandler.obtainMessage(3), aSb().eOr);
            }
            this.eOw = null;
        }
    }

    private void aRZ() {
        if (this.eOv != 0) {
            if (this.eOv == 1) {
                d(0L, 0L, 0L);
            } else {
                aSg();
            }
        }
    }

    private void aSa() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aSb() {
        b bVar;
        synchronized (b.class) {
            if (eOo == null) {
                eOo = new b();
            }
            bVar = eOo;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.eOD);
        g.JY().a(this.wC);
        MessageManager.getInstance().registerListener(1003, this.eyS);
        MessageManager.getInstance().registerListener(1001, this.eyS);
        MessageManager.getInstance().registerListener(202101, this.eyS);
        aSc();
    }

    public void aSc() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            py(socketGetMsgStratgy[0] * 1000);
            pz(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aSj();
    }

    public void stop() {
        aSj();
        aSa();
    }

    public void aSd() {
        this.eOr = this.eOq;
    }

    public void aSe() {
        aSb().eOr = aSb().eOp;
    }

    public void py(int i) {
        if (i > 0) {
            this.eOq = i;
        }
    }

    public void pz(int i) {
        if (i > 0) {
            this.eOp = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aSf() {
        if (System.currentTimeMillis() - this.eOy >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eOx);
            pushCountMessage.setUpFlowSize(h.lH().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.lH().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.eOy = System.currentTimeMillis();
            this.eOx = 0;
            h.lH().lM();
            h.lH().lL();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aRy().aRJ());
        }
        messageSyncMessage.setForTimer(this.eOC);
        LocalViewSize.ImageSize BU = LocalViewSize.BR().BU();
        if (BU != null) {
            messageSyncMessage.setWidth(BU.width);
            messageSyncMessage.setHeight(BU.height);
        }
        LocalViewSize.ImageSize BT = LocalViewSize.BR().BT();
        if (BT != null) {
            messageSyncMessage.setSmallHeight(BT.height);
            messageSyncMessage.setSmallWidth(BT.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.eOx++;
        this.eOC = false;
        this.eOz = 1;
        this.mHandler.removeMessages(3);
        aSb().mHandler.sendMessageDelayed(aSb().mHandler.obtainMessage(3), aSb().eOr);
        if (this.eOA == null) {
            this.eOA = new LongSparseArray<>();
            this.eOA.clear();
        }
        if (this.eOB == null) {
            this.eOB = new LongSparseArray<>();
        }
        LongSparseArray<Long> aRJ = com.baidu.tieba.im.memorycache.b.aRy().aRJ();
        if (0 != j) {
            Long l = aRJ.get(j);
            Long l2 = this.eOA.get(j);
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
                this.eOA.put(j, Long.valueOf(longValue));
            }
        }
        if (this.eOA != null && this.eOA.size() > 0) {
            for (int i = 0; i < this.eOA.size(); i++) {
                long keyAt = this.eOA.keyAt(i);
                Long l3 = aRJ.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.eOA.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.eOB.get(j) == null) {
                    this.eOB.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.eOB.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.eOB.put(j, Long.valueOf(j2));
                }
            }
            int size = this.eOA.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.eOA.keyAt(i2);
                long longValue3 = this.eOA.valueAt(i2).longValue();
                long j4 = 0;
                if (this.eOB.get(keyAt2) != null) {
                    j4 = this.eOB.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.eOA.remove(((Long) it.next()).longValue());
            }
        }
        if (this.eOA.size() == 0) {
            aSj();
            this.eOB.clear();
        } else {
            a(this.eOA, 1);
        }
    }

    public synchronized void aSg() {
        pA(2);
    }

    public synchronized void aSh() {
        pA(3);
    }

    public void aSi() {
        aRZ();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.eOC = false;
                this.eOz = 4;
                this.mHandler.removeMessages(3);
                aSb().mHandler.sendMessageDelayed(aSb().mHandler.obtainMessage(3), aSb().eOr);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void pA(int i) {
        this.eOC = true;
        this.eOz = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void pB(int i) {
        if (i == 1) {
            if (this.eOv != 2) {
                this.eOv = 1;
            }
        } else if (i == 3 || i == 2) {
            this.eOv = 2;
        }
    }

    private void aSj() {
        this.eOv = 0;
    }
}
