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
    private static b gpT;
    private List<GroupUpdateMessage> gqb;
    private boolean gqh;
    private int gpU = 900000;
    private int gpV = 360000;
    private int gpW = this.gpV;
    private final int gpX = 0;
    private final int gpY = 1;
    private final int gpZ = 2;
    private int gqa = 0;
    private int gqc = 0;
    private long gqd = 0;
    private int gqe = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gqf = null;
    private LongSparseArray<Long> gqg = null;
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
    private final com.baidu.adp.framework.listener.c gat = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bvj();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gqb = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.buC().buB()) {
                            b.this.bvc();
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
                    b.this.bvi();
                } else {
                    b.this.bvh();
                }
            }
        }
    };
    private final CustomMessageListener gqi = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gqf != null) {
                    b.this.gqf.clear();
                }
                if (b.this.gqg != null) {
                    b.this.gqg.clear();
                }
                b.this.gqb = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.akU().akV();
                    b.bvf().bvg();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bvf().bvc();
                }
            }
        });
        gpT = null;
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
                    b.bvf().mHandler.removeMessages(2);
                    b.bvf().bvk();
                    return;
                case 3:
                    b.bvf().mHandler.removeMessages(3);
                    if (b.bvf().gqe == 3) {
                        b.bvf().bvl();
                    } else {
                        b.bvf().bvk();
                    }
                    b.bvf().mHandler.sendMessageDelayed(b.bvf().mHandler.obtainMessage(3), b.bvf().gpW);
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
        int O = MessageManager.getInstance().getSocketClient().O(202003);
        if (a2 || O > 0) {
            j.d(false, false, true);
            ui(i);
            return;
        }
        bvn();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.buC().buO());
        }
        MessageManager.getInstance().sendMessage(b);
        j.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gqf != null) {
                this.gqf.clear();
            }
            if (this.gqg != null) {
                this.gqg.clear();
            }
        }
    }

    public void bvc() {
        boolean z;
        if (this.gqb != null) {
            LongSparseArray<Long> buN = com.baidu.tieba.im.memorycache.b.buC().buN();
            if (buN == null) {
                this.gqb = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gqb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && buN.get(next.getGroupId()) != null) {
                    if (buN.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gqe = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bvf().mHandler.sendMessageDelayed(bvf().mHandler.obtainMessage(3), bvf().gpW);
            }
            this.gqb = null;
        }
    }

    private void bvd() {
        if (this.gqa != 0) {
            if (this.gqa == 1) {
                e(0L, 0L, 0L);
            } else {
                bvk();
            }
        }
    }

    private void bve() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bvf() {
        b bVar;
        synchronized (b.class) {
            if (gpT == null) {
                gpT = new b();
            }
            bVar = gpT;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gqi);
        h.alc().a(this.wC);
        MessageManager.getInstance().registerListener(1003, this.gat);
        MessageManager.getInstance().registerListener(1001, this.gat);
        MessageManager.getInstance().registerListener(202101, this.gat);
        bvg();
    }

    public void bvg() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            uf(socketGetMsgStratgy[0] * 1000);
            ug(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bvn();
    }

    public void stop() {
        bvn();
        bve();
    }

    public void bvh() {
        this.gpW = this.gpV;
    }

    public void bvi() {
        bvf().gpW = bvf().gpU;
    }

    public void uf(int i) {
        if (i > 0) {
            this.gpV = i;
        }
    }

    public void ug(int i) {
        if (i > 0) {
            this.gpU = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bvj() {
        if (System.currentTimeMillis() - this.gqd >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gqc);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.lJ().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.lJ().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gqd = System.currentTimeMillis();
            this.gqc = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.buC().buN());
        }
        messageSyncMessage.setForTimer(this.gqh);
        LocalViewSize.ImageSize acA = LocalViewSize.acx().acA();
        if (acA != null) {
            messageSyncMessage.setWidth(acA.width);
            messageSyncMessage.setHeight(acA.height);
        }
        LocalViewSize.ImageSize acz = LocalViewSize.acx().acz();
        if (acz != null) {
            messageSyncMessage.setSmallHeight(acz.height);
            messageSyncMessage.setSmallWidth(acz.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void e(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.gqc++;
        this.gqh = false;
        this.gqe = 1;
        this.mHandler.removeMessages(3);
        bvf().mHandler.sendMessageDelayed(bvf().mHandler.obtainMessage(3), bvf().gpW);
        if (this.gqf == null) {
            this.gqf = new LongSparseArray<>();
            this.gqf.clear();
        }
        if (this.gqg == null) {
            this.gqg = new LongSparseArray<>();
        }
        LongSparseArray<Long> buN = com.baidu.tieba.im.memorycache.b.buC().buN();
        if (0 != j) {
            Long l = buN.get(j);
            Long l2 = this.gqf.get(j);
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
                this.gqf.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gqf != null && this.gqf.size() > 0) {
            for (int i = 0; i < this.gqf.size(); i++) {
                long keyAt = this.gqf.keyAt(i);
                Long l3 = buN.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gqf.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gqg.get(j) == null) {
                    this.gqg.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gqg.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gqg.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gqf.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gqf.keyAt(i2);
                long longValue3 = this.gqf.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gqg.get(keyAt2) != null) {
                    j4 = this.gqg.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gqf.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gqf.size() == 0) {
            bvn();
            this.gqg.clear();
        } else {
            a(this.gqf, 1);
        }
    }

    public synchronized void bvk() {
        uh(2);
    }

    public synchronized void bvl() {
        uh(3);
    }

    public void bvm() {
        bvd();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gqh = false;
                this.gqe = 4;
                this.mHandler.removeMessages(3);
                bvf().mHandler.sendMessageDelayed(bvf().mHandler.obtainMessage(3), bvf().gpW);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void uh(int i) {
        this.gqh = true;
        this.gqe = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void ui(int i) {
        if (i == 1) {
            if (this.gqa != 2) {
                this.gqa = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gqa = 2;
        }
    }

    private void bvn() {
        this.gqa = 0;
    }
}
