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
    private static b kJH;
    private List<GroupUpdateMessage> kJP;
    private boolean kJV;
    private int kJI = 900000;
    private int kJJ = 360000;
    private int kJK = this.kJJ;
    private final int kJL = 0;
    private final int kJM = 1;
    private final int kJN = 2;
    private int kJO = 0;
    private int kJQ = 0;
    private long kJR = 0;
    private int kJS = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> kJT = null;
    private LongSparseArray<Long> kJU = null;
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
    private final com.baidu.adp.framework.listener.c kAh = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cXl();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.kJP = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cWL().isInit()) {
                            b.this.cXe();
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
                    b.this.cXk();
                } else {
                    b.this.cXj();
                }
            }
        }
    };
    private final CustomMessageListener kJW = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.kJT != null) {
                    b.this.kJT.clear();
                }
                if (b.this.kJU != null) {
                    b.this.kJU.clear();
                }
                b.this.kJP = null;
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
                    b.cXh().cXi();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cXh().cXe();
                }
            }
        });
        kJH = null;
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
                    b.cXh().mHandler.removeMessages(2);
                    b.cXh().cXm();
                    return;
                case 3:
                    b.cXh().mHandler.removeMessages(3);
                    if (b.cXh().kJS == 3) {
                        b.cXh().cXn();
                    } else {
                        b.cXh().cXm();
                    }
                    b.cXh().mHandler.sendMessageDelayed(b.cXh().mHandler.obtainMessage(3), b.cXh().kJK);
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
        cXp();
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
            b2.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cWL().cWX());
        }
        MessageManager.getInstance().sendMessage(b2);
        i.h(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.kJT != null) {
                this.kJT.clear();
            }
            if (this.kJU != null) {
                this.kJU.clear();
            }
        }
    }

    public void cXe() {
        boolean z;
        if (this.kJP != null) {
            LongSparseArray<Long> cWW = com.baidu.tieba.im.memorycache.b.cWL().cWW();
            if (cWW == null) {
                this.kJP = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.kJP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cWW.get(next.getGroupId()) != null) {
                    if (cWW.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.kJS = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cXh().mHandler.sendMessageDelayed(cXh().mHandler.obtainMessage(3), cXh().kJK);
            }
            this.kJP = null;
        }
    }

    private void cXf() {
        if (this.kJO != 0) {
            if (this.kJO == 1) {
                g(0L, 0L, 0L);
            } else {
                cXm();
            }
        }
    }

    private void cXg() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cXh() {
        b bVar;
        synchronized (b.class) {
            if (kJH == null) {
                kJH = new b();
            }
            bVar = kJH;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.kJW);
        h.bAr().a(this.Jh);
        MessageManager.getInstance().registerListener(1003, this.kAh);
        MessageManager.getInstance().registerListener(1001, this.kAh);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.kAh);
        cXi();
    }

    public void cXi() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            Df(socketGetMsgStratgy[0] * 1000);
            Dg(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cXp();
    }

    public void stop() {
        cXp();
        cXg();
    }

    public void cXj() {
        this.kJK = this.kJJ;
    }

    public void cXk() {
        cXh().kJK = cXh().kJI;
    }

    public void Df(int i) {
        if (i > 0) {
            this.kJJ = i;
        }
    }

    public void Dg(int i) {
        if (i > 0) {
            this.kJI = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cXl() {
        if (System.currentTimeMillis() - this.kJR >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.kJQ);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.ob().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.ob().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.kJR = System.currentTimeMillis();
            this.kJQ = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cWL().cWW());
        }
        messageSyncMessage.setForTimer(this.kJV);
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
        this.kJQ++;
        this.kJV = false;
        this.kJS = 1;
        this.mHandler.removeMessages(3);
        cXh().mHandler.sendMessageDelayed(cXh().mHandler.obtainMessage(3), cXh().kJK);
        if (this.kJT == null) {
            this.kJT = new LongSparseArray<>();
            this.kJT.clear();
        }
        if (this.kJU == null) {
            this.kJU = new LongSparseArray<>();
        }
        LongSparseArray<Long> cWW = com.baidu.tieba.im.memorycache.b.cWL().cWW();
        if (0 != j) {
            Long l = cWW.get(j);
            Long l2 = this.kJT.get(j);
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
                this.kJT.put(j, Long.valueOf(longValue));
            }
        }
        if (this.kJT != null && this.kJT.size() > 0) {
            for (int i = 0; i < this.kJT.size(); i++) {
                long keyAt = this.kJT.keyAt(i);
                Long l3 = cWW.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.kJT.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.kJU.get(j) == null) {
                    this.kJU.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.kJU.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.kJU.put(j, Long.valueOf(j2));
                }
            }
            int size = this.kJT.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.kJT.keyAt(i2);
                long longValue3 = this.kJT.valueAt(i2).longValue();
                long j4 = 0;
                if (this.kJU.get(keyAt2) != null) {
                    j4 = this.kJU.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.kJT.remove(((Long) it.next()).longValue());
            }
        }
        if (this.kJT.size() == 0) {
            cXp();
            this.kJU.clear();
        } else {
            a(this.kJT, 1);
        }
    }

    public synchronized void cXm() {
        Dh(2);
    }

    public synchronized void cXn() {
        Dh(3);
    }

    public void cXo() {
        cXf();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.kJV = false;
                this.kJS = 4;
                this.mHandler.removeMessages(3);
                cXh().mHandler.sendMessageDelayed(cXh().mHandler.obtainMessage(3), cXh().kJK);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void Dh(int i) {
        this.kJV = true;
        this.kJS = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void Di(int i) {
        if (i == 1) {
            if (this.kJO != 2) {
                this.kJO = 1;
            }
        } else if (i == 3 || i == 2) {
            this.kJO = 2;
        }
    }

    private void cXp() {
        this.kJO = 0;
    }
}
