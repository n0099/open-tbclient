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
    private static b gNu;
    private List<GroupUpdateMessage> gNC;
    private boolean gNI;
    private int gNv = 900000;
    private int gNw = 360000;
    private int gNx = this.gNw;
    private final int gNy = 0;
    private final int gNz = 1;
    private final int gNA = 2;
    private int gNB = 0;
    private int gND = 0;
    private long gNE = 0;
    private int gNF = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gNG = null;
    private LongSparseArray<Long> gNH = null;
    private final com.baidu.adp.framework.client.socket.link.a ul = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void h(Map<String, String> map) {
            b.this.start();
            f.fK().g(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void S(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c gxX = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bFD();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gNC = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bEZ().bEY()) {
                            b.this.bFw();
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
                    b.this.bFC();
                } else {
                    b.this.bFB();
                }
            }
        }
    };
    private final CustomMessageListener gNJ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gNG != null) {
                    b.this.gNG.clear();
                }
                if (b.this.gNH != null) {
                    b.this.gNH.clear();
                }
                b.this.gNC = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.arc().ard();
                    b.bFz().bFA();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bFz().bFw();
                }
            }
        });
        gNu = null;
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
                    b.bFz().mHandler.removeMessages(2);
                    b.bFz().bFE();
                    return;
                case 3:
                    b.bFz().mHandler.removeMessages(3);
                    if (b.bFz().gNF == 3) {
                        b.bFz().bFF();
                    } else {
                        b.bFz().bFE();
                    }
                    b.bFz().mHandler.sendMessageDelayed(b.bFz().mHandler.obtainMessage(3), b.bFz().gNx);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().fP() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int H = MessageManager.getInstance().getSocketClient().H(202003);
        if (a2 || H > 0) {
            j.d(false, false, true);
            vQ(i);
            return;
        }
        bFH();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bEZ().bFl());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gNG != null) {
                this.gNG.clear();
            }
            if (this.gNH != null) {
                this.gNH.clear();
            }
        }
    }

    public void bFw() {
        boolean z;
        if (this.gNC != null) {
            LongSparseArray<Long> bFk = com.baidu.tieba.im.memorycache.b.bEZ().bFk();
            if (bFk == null) {
                this.gNC = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gNC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bFk.get(next.getGroupId()) != null) {
                    if (bFk.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gNF = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bFz().mHandler.sendMessageDelayed(bFz().mHandler.obtainMessage(3), bFz().gNx);
            }
            this.gNC = null;
        }
    }

    private void bFx() {
        if (this.gNB != 0) {
            if (this.gNB == 1) {
                e(0L, 0L, 0L);
            } else {
                bFE();
            }
        }
    }

    private void bFy() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bFz() {
        b bVar;
        synchronized (b.class) {
            if (gNu == null) {
                gNu = new b();
            }
            bVar = gNu;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gNJ);
        h.ark().a(this.ul);
        MessageManager.getInstance().registerListener(1003, this.gxX);
        MessageManager.getInstance().registerListener(1001, this.gxX);
        MessageManager.getInstance().registerListener(202101, this.gxX);
        bFA();
    }

    public void bFA() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            vN(socketGetMsgStratgy[0] * 1000);
            vO(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bFH();
    }

    public void stop() {
        bFH();
        bFy();
    }

    public void bFB() {
        this.gNx = this.gNw;
    }

    public void bFC() {
        bFz().gNx = bFz().gNv;
    }

    public void vN(int i) {
        if (i > 0) {
            this.gNw = i;
        }
    }

    public void vO(int i) {
        if (i > 0) {
            this.gNv = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bFD() {
        if (System.currentTimeMillis() - this.gNE >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gND);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.kS().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.kS().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gNE = System.currentTimeMillis();
            this.gND = 0;
            com.baidu.adp.lib.webSocket.h.kS().kX();
            com.baidu.adp.lib.webSocket.h.kS().kW();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bEZ().bFk());
        }
        messageSyncMessage.setForTimer(this.gNI);
        LocalViewSize.ImageSize aiA = LocalViewSize.aix().aiA();
        if (aiA != null) {
            messageSyncMessage.setWidth(aiA.width);
            messageSyncMessage.setHeight(aiA.height);
        }
        LocalViewSize.ImageSize aiz = LocalViewSize.aix().aiz();
        if (aiz != null) {
            messageSyncMessage.setSmallHeight(aiz.height);
            messageSyncMessage.setSmallWidth(aiz.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void e(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.gND++;
        this.gNI = false;
        this.gNF = 1;
        this.mHandler.removeMessages(3);
        bFz().mHandler.sendMessageDelayed(bFz().mHandler.obtainMessage(3), bFz().gNx);
        if (this.gNG == null) {
            this.gNG = new LongSparseArray<>();
            this.gNG.clear();
        }
        if (this.gNH == null) {
            this.gNH = new LongSparseArray<>();
        }
        LongSparseArray<Long> bFk = com.baidu.tieba.im.memorycache.b.bEZ().bFk();
        if (0 != j) {
            Long l = bFk.get(j);
            Long l2 = this.gNG.get(j);
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
                this.gNG.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gNG != null && this.gNG.size() > 0) {
            for (int i = 0; i < this.gNG.size(); i++) {
                long keyAt = this.gNG.keyAt(i);
                Long l3 = bFk.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gNG.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gNH.get(j) == null) {
                    this.gNH.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gNH.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gNH.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gNG.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gNG.keyAt(i2);
                long longValue3 = this.gNG.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gNH.get(keyAt2) != null) {
                    j4 = this.gNH.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gNG.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gNG.size() == 0) {
            bFH();
            this.gNH.clear();
        } else {
            a(this.gNG, 1);
        }
    }

    public synchronized void bFE() {
        vP(2);
    }

    public synchronized void bFF() {
        vP(3);
    }

    public void bFG() {
        bFx();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gNI = false;
                this.gNF = 4;
                this.mHandler.removeMessages(3);
                bFz().mHandler.sendMessageDelayed(bFz().mHandler.obtainMessage(3), bFz().gNx);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void vP(int i) {
        this.gNI = true;
        this.gNF = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void vQ(int i) {
        if (i == 1) {
            if (this.gNB != 2) {
                this.gNB = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gNB = 2;
        }
    }

    private void bFH() {
        this.gNB = 0;
    }
}
