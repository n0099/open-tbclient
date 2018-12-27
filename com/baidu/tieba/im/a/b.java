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
    private static b eZm;
    private boolean eZA;
    private List<GroupUpdateMessage> eZu;
    private int eZn = 900000;
    private int eZo = 360000;
    private int eZp = this.eZo;
    private final int eZq = 0;
    private final int eZr = 1;
    private final int eZs = 2;
    private int eZt = 0;
    private int eZv = 0;
    private long eZw = 0;
    private int eZx = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> eZy = null;
    private LongSparseArray<Long> eZz = null;
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
    private final com.baidu.adp.framework.listener.c eJR = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aUh();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.eZu = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aTA().qo()) {
                            b.this.aUa();
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
                    b.this.aUg();
                } else {
                    b.this.aUf();
                }
            }
        }
    };
    private final CustomMessageListener eZB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.eZy != null) {
                    b.this.eZy.clear();
                }
                if (b.this.eZz != null) {
                    b.this.eZz.clear();
                }
                b.this.eZu = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Lh().Li();
                    b.aUd().aUe();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aUd().aUa();
                }
            }
        });
        eZm = null;
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
                    b.aUd().mHandler.removeMessages(2);
                    b.aUd().aUi();
                    return;
                case 3:
                    b.aUd().mHandler.removeMessages(3);
                    if (b.aUd().eZx == 3) {
                        b.aUd().aUj();
                    } else {
                        b.aUd().aUi();
                    }
                    b.aUd().mHandler.sendMessageDelayed(b.aUd().mHandler.obtainMessage(3), b.aUd().eZp);
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
            qB(i);
            return;
        }
        aUl();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aTA().aTM());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.eZy != null) {
                this.eZy.clear();
            }
            if (this.eZz != null) {
                this.eZz.clear();
            }
        }
    }

    public void aUa() {
        boolean z;
        if (this.eZu != null) {
            LongSparseArray<Long> aTL = com.baidu.tieba.im.memorycache.b.aTA().aTL();
            if (aTL == null) {
                this.eZu = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.eZu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aTL.get(next.getGroupId()) != null) {
                    if (aTL.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.eZx = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aUd().mHandler.sendMessageDelayed(aUd().mHandler.obtainMessage(3), aUd().eZp);
            }
            this.eZu = null;
        }
    }

    private void aUb() {
        if (this.eZt != 0) {
            if (this.eZt == 1) {
                d(0L, 0L, 0L);
            } else {
                aUi();
            }
        }
    }

    private void aUc() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aUd() {
        b bVar;
        synchronized (b.class) {
            if (eZm == null) {
                eZm = new b();
            }
            bVar = eZm;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.eZB);
        g.Lp().a(this.wF);
        MessageManager.getInstance().registerListener(1003, this.eJR);
        MessageManager.getInstance().registerListener(1001, this.eJR);
        MessageManager.getInstance().registerListener(202101, this.eJR);
        aUe();
    }

    public void aUe() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            qy(socketGetMsgStratgy[0] * 1000);
            qz(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aUl();
    }

    public void stop() {
        aUl();
        aUc();
    }

    public void aUf() {
        this.eZp = this.eZo;
    }

    public void aUg() {
        aUd().eZp = aUd().eZn;
    }

    public void qy(int i) {
        if (i > 0) {
            this.eZo = i;
        }
    }

    public void qz(int i) {
        if (i > 0) {
            this.eZn = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aUh() {
        if (System.currentTimeMillis() - this.eZw >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eZv);
            pushCountMessage.setUpFlowSize(h.lE().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.lE().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.eZw = System.currentTimeMillis();
            this.eZv = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aTA().aTL());
        }
        messageSyncMessage.setForTimer(this.eZA);
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
        this.eZv++;
        this.eZA = false;
        this.eZx = 1;
        this.mHandler.removeMessages(3);
        aUd().mHandler.sendMessageDelayed(aUd().mHandler.obtainMessage(3), aUd().eZp);
        if (this.eZy == null) {
            this.eZy = new LongSparseArray<>();
            this.eZy.clear();
        }
        if (this.eZz == null) {
            this.eZz = new LongSparseArray<>();
        }
        LongSparseArray<Long> aTL = com.baidu.tieba.im.memorycache.b.aTA().aTL();
        if (0 != j) {
            Long l = aTL.get(j);
            Long l2 = this.eZy.get(j);
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
                this.eZy.put(j, Long.valueOf(longValue));
            }
        }
        if (this.eZy != null && this.eZy.size() > 0) {
            for (int i = 0; i < this.eZy.size(); i++) {
                long keyAt = this.eZy.keyAt(i);
                Long l3 = aTL.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.eZy.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.eZz.get(j) == null) {
                    this.eZz.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.eZz.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.eZz.put(j, Long.valueOf(j2));
                }
            }
            int size = this.eZy.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.eZy.keyAt(i2);
                long longValue3 = this.eZy.valueAt(i2).longValue();
                long j4 = 0;
                if (this.eZz.get(keyAt2) != null) {
                    j4 = this.eZz.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.eZy.remove(((Long) it.next()).longValue());
            }
        }
        if (this.eZy.size() == 0) {
            aUl();
            this.eZz.clear();
        } else {
            a(this.eZy, 1);
        }
    }

    public synchronized void aUi() {
        qA(2);
    }

    public synchronized void aUj() {
        qA(3);
    }

    public void aUk() {
        aUb();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.eZA = false;
                this.eZx = 4;
                this.mHandler.removeMessages(3);
                aUd().mHandler.sendMessageDelayed(aUd().mHandler.obtainMessage(3), aUd().eZp);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void qA(int i) {
        this.eZA = true;
        this.eZx = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void qB(int i) {
        if (i == 1) {
            if (this.eZt != 2) {
                this.eZt = 1;
            }
        } else if (i == 3 || i == 2) {
            this.eZt = 2;
        }
    }

    private void aUl() {
        this.eZt = 0;
    }
}
