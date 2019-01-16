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
    private static b eZZ;
    private List<GroupUpdateMessage> fah;
    private boolean fan;
    private int faa = 900000;
    private int fab = 360000;
    private int fac = this.fab;
    private final int fad = 0;
    private final int fae = 1;
    private final int faf = 2;
    private int fag = 0;
    private int fai = 0;
    private long faj = 0;
    private int fak = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> fal = null;
    private LongSparseArray<Long> fam = null;
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
    private final com.baidu.adp.framework.listener.c eKD = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aUH();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.fah = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aUa().qs()) {
                            b.this.aUA();
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
                    b.this.aUG();
                } else {
                    b.this.aUF();
                }
            }
        }
    };
    private final CustomMessageListener fao = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.fal != null) {
                    b.this.fal.clear();
                }
                if (b.this.fam != null) {
                    b.this.fam.clear();
                }
                b.this.fah = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Lw().Lx();
                    b.aUD().aUE();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aUD().aUA();
                }
            }
        });
        eZZ = null;
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
                    b.aUD().mHandler.removeMessages(2);
                    b.aUD().aUI();
                    return;
                case 3:
                    b.aUD().mHandler.removeMessages(3);
                    if (b.aUD().fak == 3) {
                        b.aUD().aUJ();
                    } else {
                        b.aUD().aUI();
                    }
                    b.aUD().mHandler.sendMessageDelayed(b.aUD().mHandler.obtainMessage(3), b.aUD().fac);
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
            qC(i);
            return;
        }
        aUL();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aUa().aUm());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.fal != null) {
                this.fal.clear();
            }
            if (this.fam != null) {
                this.fam.clear();
            }
        }
    }

    public void aUA() {
        boolean z;
        if (this.fah != null) {
            LongSparseArray<Long> aUl = com.baidu.tieba.im.memorycache.b.aUa().aUl();
            if (aUl == null) {
                this.fah = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.fah.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aUl.get(next.getGroupId()) != null) {
                    if (aUl.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.fak = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aUD().mHandler.sendMessageDelayed(aUD().mHandler.obtainMessage(3), aUD().fac);
            }
            this.fah = null;
        }
    }

    private void aUB() {
        if (this.fag != 0) {
            if (this.fag == 1) {
                d(0L, 0L, 0L);
            } else {
                aUI();
            }
        }
    }

    private void aUC() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aUD() {
        b bVar;
        synchronized (b.class) {
            if (eZZ == null) {
                eZZ = new b();
            }
            bVar = eZZ;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.fao);
        g.LE().a(this.wF);
        MessageManager.getInstance().registerListener(1003, this.eKD);
        MessageManager.getInstance().registerListener(1001, this.eKD);
        MessageManager.getInstance().registerListener(202101, this.eKD);
        aUE();
    }

    public void aUE() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            qz(socketGetMsgStratgy[0] * 1000);
            qA(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aUL();
    }

    public void stop() {
        aUL();
        aUC();
    }

    public void aUF() {
        this.fac = this.fab;
    }

    public void aUG() {
        aUD().fac = aUD().faa;
    }

    public void qz(int i) {
        if (i > 0) {
            this.fab = i;
        }
    }

    public void qA(int i) {
        if (i > 0) {
            this.faa = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aUH() {
        if (System.currentTimeMillis() - this.faj >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.fai);
            pushCountMessage.setUpFlowSize(h.lE().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.lE().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.faj = System.currentTimeMillis();
            this.fai = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aUa().aUl());
        }
        messageSyncMessage.setForTimer(this.fan);
        LocalViewSize.ImageSize Ds = LocalViewSize.Dp().Ds();
        if (Ds != null) {
            messageSyncMessage.setWidth(Ds.width);
            messageSyncMessage.setHeight(Ds.height);
        }
        LocalViewSize.ImageSize Dr = LocalViewSize.Dp().Dr();
        if (Dr != null) {
            messageSyncMessage.setSmallHeight(Dr.height);
            messageSyncMessage.setSmallWidth(Dr.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.fai++;
        this.fan = false;
        this.fak = 1;
        this.mHandler.removeMessages(3);
        aUD().mHandler.sendMessageDelayed(aUD().mHandler.obtainMessage(3), aUD().fac);
        if (this.fal == null) {
            this.fal = new LongSparseArray<>();
            this.fal.clear();
        }
        if (this.fam == null) {
            this.fam = new LongSparseArray<>();
        }
        LongSparseArray<Long> aUl = com.baidu.tieba.im.memorycache.b.aUa().aUl();
        if (0 != j) {
            Long l = aUl.get(j);
            Long l2 = this.fal.get(j);
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
                this.fal.put(j, Long.valueOf(longValue));
            }
        }
        if (this.fal != null && this.fal.size() > 0) {
            for (int i = 0; i < this.fal.size(); i++) {
                long keyAt = this.fal.keyAt(i);
                Long l3 = aUl.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.fal.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.fam.get(j) == null) {
                    this.fam.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.fam.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.fam.put(j, Long.valueOf(j2));
                }
            }
            int size = this.fal.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.fal.keyAt(i2);
                long longValue3 = this.fal.valueAt(i2).longValue();
                long j4 = 0;
                if (this.fam.get(keyAt2) != null) {
                    j4 = this.fam.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.fal.remove(((Long) it.next()).longValue());
            }
        }
        if (this.fal.size() == 0) {
            aUL();
            this.fam.clear();
        } else {
            a(this.fal, 1);
        }
    }

    public synchronized void aUI() {
        qB(2);
    }

    public synchronized void aUJ() {
        qB(3);
    }

    public void aUK() {
        aUB();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.fan = false;
                this.fak = 4;
                this.mHandler.removeMessages(3);
                aUD().mHandler.sendMessageDelayed(aUD().mHandler.obtainMessage(3), aUD().fac);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void qB(int i) {
        this.fan = true;
        this.fak = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void qC(int i) {
        if (i == 1) {
            if (this.fag != 2) {
                this.fag = 1;
            }
        } else if (i == 3 || i == 2) {
            this.fag = 2;
        }
    }

    private void aUL() {
        this.fag = 0;
    }
}
