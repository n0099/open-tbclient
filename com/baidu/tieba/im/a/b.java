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
    private static b eGE;
    private List<GroupUpdateMessage> eGM;
    private boolean eGS;
    private int eGF = 900000;
    private int eGG = 360000;
    private int eGH = this.eGG;
    private final int eGI = 0;
    private final int eGJ = 1;
    private final int eGK = 2;
    private int eGL = 0;
    private int eGN = 0;
    private long eGO = 0;
    private int eGP = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> eGQ = null;
    private LongSparseArray<Long> eGR = null;
    private final com.baidu.adp.framework.client.socket.link.a vP = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void i(Map<String, String> map) {
            b.this.start();
            f.gu().h(map);
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
    private final com.baidu.adp.framework.listener.c era = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aOR();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.eGM = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aOk().aOj()) {
                            b.this.aOK();
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
                    b.this.aOQ();
                } else {
                    b.this.aOP();
                }
            }
        }
    };
    private final CustomMessageListener eGT = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.eGQ != null) {
                    b.this.eGQ.clear();
                }
                if (b.this.eGR != null) {
                    b.this.eGR.clear();
                }
                b.this.eGM = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.HR().HS();
                    b.aON().aOO();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aON().aOK();
                }
            }
        });
        eGE = null;
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
                    b.aON().mHandler.removeMessages(2);
                    b.aON().aOS();
                    return;
                case 3:
                    b.aON().mHandler.removeMessages(3);
                    if (b.aON().eGP == 3) {
                        b.aON().aOT();
                    } else {
                        b.aON().aOS();
                    }
                    b.aON().mHandler.sendMessageDelayed(b.aON().mHandler.obtainMessage(3), b.aON().eGH);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().gA() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int P = MessageManager.getInstance().getSocketClient().P(202003);
        if (a2 || P > 0) {
            j.d(false, false, true);
            pd(i);
            return;
        }
        aOV();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aOk().aOw());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.eGQ != null) {
                this.eGQ.clear();
            }
            if (this.eGR != null) {
                this.eGR.clear();
            }
        }
    }

    public void aOK() {
        boolean z;
        if (this.eGM != null) {
            LongSparseArray<Long> aOv = com.baidu.tieba.im.memorycache.b.aOk().aOv();
            if (aOv == null) {
                this.eGM = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.eGM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aOv.get(next.getGroupId()) != null) {
                    if (aOv.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.eGP = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aON().mHandler.sendMessageDelayed(aON().mHandler.obtainMessage(3), aON().eGH);
            }
            this.eGM = null;
        }
    }

    private void aOL() {
        if (this.eGL != 0) {
            if (this.eGL == 1) {
                d(0L, 0L, 0L);
            } else {
                aOS();
            }
        }
    }

    private void aOM() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aON() {
        b bVar;
        synchronized (b.class) {
            if (eGE == null) {
                eGE = new b();
            }
            bVar = eGE;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.eGT);
        g.HZ().a(this.vP);
        MessageManager.getInstance().registerListener(1003, this.era);
        MessageManager.getInstance().registerListener(1001, this.era);
        MessageManager.getInstance().registerListener(202101, this.era);
        aOO();
    }

    public void aOO() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            pa(socketGetMsgStratgy[0] * 1000);
            pb(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aOV();
    }

    public void stop() {
        aOV();
        aOM();
    }

    public void aOP() {
        this.eGH = this.eGG;
    }

    public void aOQ() {
        aON().eGH = aON().eGF;
    }

    public void pa(int i) {
        if (i > 0) {
            this.eGG = i;
        }
    }

    public void pb(int i) {
        if (i > 0) {
            this.eGF = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aOR() {
        if (System.currentTimeMillis() - this.eGO >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eGN);
            pushCountMessage.setUpFlowSize(h.lw().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.lw().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.eGO = System.currentTimeMillis();
            this.eGN = 0;
            h.lw().lC();
            h.lw().lB();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aOk().aOv());
        }
        messageSyncMessage.setForTimer(this.eGS);
        LocalViewSize.ImageSize zN = LocalViewSize.zK().zN();
        if (zN != null) {
            messageSyncMessage.setWidth(zN.width);
            messageSyncMessage.setHeight(zN.height);
        }
        LocalViewSize.ImageSize zM = LocalViewSize.zK().zM();
        if (zM != null) {
            messageSyncMessage.setSmallHeight(zM.height);
            messageSyncMessage.setSmallWidth(zM.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.eGN++;
        this.eGS = false;
        this.eGP = 1;
        this.mHandler.removeMessages(3);
        aON().mHandler.sendMessageDelayed(aON().mHandler.obtainMessage(3), aON().eGH);
        if (this.eGQ == null) {
            this.eGQ = new LongSparseArray<>();
            this.eGQ.clear();
        }
        if (this.eGR == null) {
            this.eGR = new LongSparseArray<>();
        }
        LongSparseArray<Long> aOv = com.baidu.tieba.im.memorycache.b.aOk().aOv();
        if (0 != j) {
            Long l = aOv.get(j);
            Long l2 = this.eGQ.get(j);
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
                this.eGQ.put(j, Long.valueOf(longValue));
            }
        }
        if (this.eGQ != null && this.eGQ.size() > 0) {
            for (int i = 0; i < this.eGQ.size(); i++) {
                long keyAt = this.eGQ.keyAt(i);
                Long l3 = aOv.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.eGQ.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.eGR.get(j) == null) {
                    this.eGR.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.eGR.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.eGR.put(j, Long.valueOf(j2));
                }
            }
            int size = this.eGQ.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.eGQ.keyAt(i2);
                long longValue3 = this.eGQ.valueAt(i2).longValue();
                long j4 = 0;
                if (this.eGR.get(keyAt2) != null) {
                    j4 = this.eGR.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.eGQ.remove(((Long) it.next()).longValue());
            }
        }
        if (this.eGQ.size() == 0) {
            aOV();
            this.eGR.clear();
        } else {
            a(this.eGQ, 1);
        }
    }

    public synchronized void aOS() {
        pc(2);
    }

    public synchronized void aOT() {
        pc(3);
    }

    public void aOU() {
        aOL();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.eGS = false;
                this.eGP = 4;
                this.mHandler.removeMessages(3);
                aON().mHandler.sendMessageDelayed(aON().mHandler.obtainMessage(3), aON().eGH);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void pc(int i) {
        this.eGS = true;
        this.eGP = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void pd(int i) {
        if (i == 1) {
            if (this.eGL != 2) {
                this.eGL = 1;
            }
        } else if (i == 3 || i == 2) {
            this.eGL = 2;
        }
    }

    private void aOV() {
        this.eGL = 0;
    }
}
