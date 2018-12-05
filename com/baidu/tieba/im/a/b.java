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
    private static b eWv;
    private List<GroupUpdateMessage> eWD;
    private boolean eWJ;
    private int eWw = 900000;
    private int eWx = 360000;
    private int eWy = this.eWx;
    private final int eWz = 0;
    private final int eWA = 1;
    private final int eWB = 2;
    private int eWC = 0;
    private int eWE = 0;
    private long eWF = 0;
    private int eWG = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> eWH = null;
    private LongSparseArray<Long> eWI = null;
    private final com.baidu.adp.framework.client.socket.link.a wF = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void i(Map<String, String> map) {
            b.this.start();
            f.gM().h(map);
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
    private final com.baidu.adp.framework.listener.c eHa = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aTu();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.eWD = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aSN().qo()) {
                            b.this.aTn();
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
                    b.this.aTt();
                } else {
                    b.this.aTs();
                }
            }
        }
    };
    private final CustomMessageListener eWK = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.eWH != null) {
                    b.this.eWH.clear();
                }
                if (b.this.eWI != null) {
                    b.this.eWI.clear();
                }
                b.this.eWD = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Lg().Lh();
                    b.aTq().aTr();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aTq().aTn();
                }
            }
        });
        eWv = null;
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
                    b.aTq().mHandler.removeMessages(2);
                    b.aTq().aTv();
                    return;
                case 3:
                    b.aTq().mHandler.removeMessages(3);
                    if (b.aTq().eWG == 3) {
                        b.aTq().aTw();
                    } else {
                        b.aTq().aTv();
                    }
                    b.aTq().mHandler.sendMessageDelayed(b.aTq().mHandler.obtainMessage(3), b.aTq().eWy);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().gR() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), SystemScreenshotManager.DELAY_TIME);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int ag = MessageManager.getInstance().getSocketClient().ag(202003);
        if (a2 || ag > 0) {
            j.d(false, false, true);
            qo(i);
            return;
        }
        aTy();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aSN().aSZ());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.eWH != null) {
                this.eWH.clear();
            }
            if (this.eWI != null) {
                this.eWI.clear();
            }
        }
    }

    public void aTn() {
        boolean z;
        if (this.eWD != null) {
            LongSparseArray<Long> aSY = com.baidu.tieba.im.memorycache.b.aSN().aSY();
            if (aSY == null) {
                this.eWD = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.eWD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aSY.get(next.getGroupId()) != null) {
                    if (aSY.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.eWG = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aTq().mHandler.sendMessageDelayed(aTq().mHandler.obtainMessage(3), aTq().eWy);
            }
            this.eWD = null;
        }
    }

    private void aTo() {
        if (this.eWC != 0) {
            if (this.eWC == 1) {
                d(0L, 0L, 0L);
            } else {
                aTv();
            }
        }
    }

    private void aTp() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aTq() {
        b bVar;
        synchronized (b.class) {
            if (eWv == null) {
                eWv = new b();
            }
            bVar = eWv;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.eWK);
        g.Lo().a(this.wF);
        MessageManager.getInstance().registerListener(1003, this.eHa);
        MessageManager.getInstance().registerListener(1001, this.eHa);
        MessageManager.getInstance().registerListener(202101, this.eHa);
        aTr();
    }

    public void aTr() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            ql(socketGetMsgStratgy[0] * 1000);
            qm(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aTy();
    }

    public void stop() {
        aTy();
        aTp();
    }

    public void aTs() {
        this.eWy = this.eWx;
    }

    public void aTt() {
        aTq().eWy = aTq().eWw;
    }

    public void ql(int i) {
        if (i > 0) {
            this.eWx = i;
        }
    }

    public void qm(int i) {
        if (i > 0) {
            this.eWw = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aTu() {
        if (System.currentTimeMillis() - this.eWF >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eWE);
            pushCountMessage.setUpFlowSize(h.lE().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.lE().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.eWF = System.currentTimeMillis();
            this.eWE = 0;
            h.lE().lJ();
            h.lE().lI();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aSN().aSY());
        }
        messageSyncMessage.setForTimer(this.eWJ);
        LocalViewSize.ImageSize Df = LocalViewSize.Dc().Df();
        if (Df != null) {
            messageSyncMessage.setWidth(Df.width);
            messageSyncMessage.setHeight(Df.height);
        }
        LocalViewSize.ImageSize De = LocalViewSize.Dc().De();
        if (De != null) {
            messageSyncMessage.setSmallHeight(De.height);
            messageSyncMessage.setSmallWidth(De.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.eWE++;
        this.eWJ = false;
        this.eWG = 1;
        this.mHandler.removeMessages(3);
        aTq().mHandler.sendMessageDelayed(aTq().mHandler.obtainMessage(3), aTq().eWy);
        if (this.eWH == null) {
            this.eWH = new LongSparseArray<>();
            this.eWH.clear();
        }
        if (this.eWI == null) {
            this.eWI = new LongSparseArray<>();
        }
        LongSparseArray<Long> aSY = com.baidu.tieba.im.memorycache.b.aSN().aSY();
        if (0 != j) {
            Long l = aSY.get(j);
            Long l2 = this.eWH.get(j);
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
                this.eWH.put(j, Long.valueOf(longValue));
            }
        }
        if (this.eWH != null && this.eWH.size() > 0) {
            for (int i = 0; i < this.eWH.size(); i++) {
                long keyAt = this.eWH.keyAt(i);
                Long l3 = aSY.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.eWH.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.eWI.get(j) == null) {
                    this.eWI.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.eWI.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.eWI.put(j, Long.valueOf(j2));
                }
            }
            int size = this.eWH.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.eWH.keyAt(i2);
                long longValue3 = this.eWH.valueAt(i2).longValue();
                long j4 = 0;
                if (this.eWI.get(keyAt2) != null) {
                    j4 = this.eWI.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.eWH.remove(((Long) it.next()).longValue());
            }
        }
        if (this.eWH.size() == 0) {
            aTy();
            this.eWI.clear();
        } else {
            a(this.eWH, 1);
        }
    }

    public synchronized void aTv() {
        qn(2);
    }

    public synchronized void aTw() {
        qn(3);
    }

    public void aTx() {
        aTo();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.eWJ = false;
                this.eWG = 4;
                this.mHandler.removeMessages(3);
                aTq().mHandler.sendMessageDelayed(aTq().mHandler.obtainMessage(3), aTq().eWy);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void qn(int i) {
        this.eWJ = true;
        this.eWG = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void qo(int i) {
        if (i == 1) {
            if (this.eWC != 2) {
                this.eWC = 1;
            }
        } else if (i == 3 || i == 2) {
            this.eWC = 2;
        }
    }

    private void aTy() {
        this.eWC = 0;
    }
}
