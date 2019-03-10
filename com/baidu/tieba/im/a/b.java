package com.baidu.tieba.im.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.PointerIconCompat;
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
import com.baidu.tbadk.o.j;
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
    private static b gqh;
    private List<GroupUpdateMessage> gqp;
    private boolean gqv;
    private int gqi = 900000;
    private int gqj = 360000;
    private int gqk = this.gqj;
    private final int gql = 0;
    private final int gqm = 1;
    private final int gqn = 2;
    private int gqo = 0;
    private int gqq = 0;
    private long gqr = 0;
    private int gqs = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gqt = null;
    private LongSparseArray<Long> gqu = null;
    private final com.baidu.adp.framework.client.socket.link.a wC = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void i(Map<String, String> map) {
            b.this.start();
            f.gJ().h(map);
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
    private final com.baidu.adp.framework.listener.c gaG = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bvn();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gqp = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.buG().buF()) {
                            b.this.bvg();
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
                    b.this.bvm();
                } else {
                    b.this.bvl();
                }
            }
        }
    };
    private final CustomMessageListener gqw = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gqt != null) {
                    b.this.gqt.clear();
                }
                if (b.this.gqu != null) {
                    b.this.gqu.clear();
                }
                b.this.gqp = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.akY().akZ();
                    b.bvj().bvk();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bvj().bvg();
                }
            }
        });
        gqh = null;
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
                    b.bvj().mHandler.removeMessages(2);
                    b.bvj().bvo();
                    return;
                case 3:
                    b.bvj().mHandler.removeMessages(3);
                    if (b.bvj().gqs == 3) {
                        b.bvj().bvp();
                    } else {
                        b.bvj().bvo();
                    }
                    b.bvj().mHandler.sendMessageDelayed(b.bvj().mHandler.obtainMessage(3), b.bvj().gqk);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().gO() > 10) {
            j.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int P = MessageManager.getInstance().getSocketClient().P(202003);
        if (a2 || P > 0) {
            j.d(false, false, true);
            um(i);
            return;
        }
        bvr();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.buG().buS());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gqt != null) {
                this.gqt.clear();
            }
            if (this.gqu != null) {
                this.gqu.clear();
            }
        }
    }

    public void bvg() {
        boolean z;
        if (this.gqp != null) {
            LongSparseArray<Long> buR = com.baidu.tieba.im.memorycache.b.buG().buR();
            if (buR == null) {
                this.gqp = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gqp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && buR.get(next.getGroupId()) != null) {
                    if (buR.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gqs = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bvj().mHandler.sendMessageDelayed(bvj().mHandler.obtainMessage(3), bvj().gqk);
            }
            this.gqp = null;
        }
    }

    private void bvh() {
        if (this.gqo != 0) {
            if (this.gqo == 1) {
                e(0L, 0L, 0L);
            } else {
                bvo();
            }
        }
    }

    private void bvi() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bvj() {
        b bVar;
        synchronized (b.class) {
            if (gqh == null) {
                gqh = new b();
            }
            bVar = gqh;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gqw);
        h.alg().a(this.wC);
        MessageManager.getInstance().registerListener(PointerIconCompat.TYPE_HELP, this.gaG);
        MessageManager.getInstance().registerListener(1001, this.gaG);
        MessageManager.getInstance().registerListener(202101, this.gaG);
        bvk();
    }

    public void bvk() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            uj(socketGetMsgStratgy[0] * 1000);
            uk(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bvr();
    }

    public void stop() {
        bvr();
        bvi();
    }

    public void bvl() {
        this.gqk = this.gqj;
    }

    public void bvm() {
        bvj().gqk = bvj().gqi;
    }

    public void uj(int i) {
        if (i > 0) {
            this.gqj = i;
        }
    }

    public void uk(int i) {
        if (i > 0) {
            this.gqi = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bvn() {
        if (System.currentTimeMillis() - this.gqr >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gqq);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.lJ().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.lJ().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gqr = System.currentTimeMillis();
            this.gqq = 0;
            com.baidu.adp.lib.webSocket.h.lJ().lO();
            com.baidu.adp.lib.webSocket.h.lJ().lN();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.buG().buR());
        }
        messageSyncMessage.setForTimer(this.gqv);
        LocalViewSize.ImageSize acD = LocalViewSize.acA().acD();
        if (acD != null) {
            messageSyncMessage.setWidth(acD.width);
            messageSyncMessage.setHeight(acD.height);
        }
        LocalViewSize.ImageSize acC = LocalViewSize.acA().acC();
        if (acC != null) {
            messageSyncMessage.setSmallHeight(acC.height);
            messageSyncMessage.setSmallWidth(acC.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void e(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.gqq++;
        this.gqv = false;
        this.gqs = 1;
        this.mHandler.removeMessages(3);
        bvj().mHandler.sendMessageDelayed(bvj().mHandler.obtainMessage(3), bvj().gqk);
        if (this.gqt == null) {
            this.gqt = new LongSparseArray<>();
            this.gqt.clear();
        }
        if (this.gqu == null) {
            this.gqu = new LongSparseArray<>();
        }
        LongSparseArray<Long> buR = com.baidu.tieba.im.memorycache.b.buG().buR();
        if (0 != j) {
            Long l = buR.get(j);
            Long l2 = this.gqt.get(j);
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
                this.gqt.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gqt != null && this.gqt.size() > 0) {
            for (int i = 0; i < this.gqt.size(); i++) {
                long keyAt = this.gqt.keyAt(i);
                Long l3 = buR.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gqt.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gqu.get(j) == null) {
                    this.gqu.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gqu.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gqu.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gqt.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gqt.keyAt(i2);
                long longValue3 = this.gqt.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gqu.get(keyAt2) != null) {
                    j4 = this.gqu.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gqt.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gqt.size() == 0) {
            bvr();
            this.gqu.clear();
        } else {
            a(this.gqt, 1);
        }
    }

    public synchronized void bvo() {
        ul(2);
    }

    public synchronized void bvp() {
        ul(3);
    }

    public void bvq() {
        bvh();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gqv = false;
                this.gqs = 4;
                this.mHandler.removeMessages(3);
                bvj().mHandler.sendMessageDelayed(bvj().mHandler.obtainMessage(3), bvj().gqk);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void ul(int i) {
        this.gqv = true;
        this.gqs = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void um(int i) {
        if (i == 1) {
            if (this.gqo != 2) {
                this.gqo = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gqo = 2;
        }
    }

    private void bvr() {
        this.gqo = 0;
    }
}
