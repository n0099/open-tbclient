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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.d.e;
import com.baidu.tbadk.coreExtra.d.h;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.n.j;
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
    private static b iZa;
    private List<GroupUpdateMessage> iZi;
    private boolean iZo;
    private int iZb = 900000;
    private int iZc = 360000;
    private int iZd = this.iZc;
    private final int iZe = 0;
    private final int iZf = 1;
    private final int iZg = 2;
    private int iZh = 0;
    private int iZj = 0;
    private long iZk = 0;
    private int iZl = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> iZm = null;
    private LongSparseArray<Long> iZn = null;
    private final com.baidu.adp.framework.client.socket.link.a HJ = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.jR().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c iJH = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.csB();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.iZi = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.crX().isInit()) {
                            b.this.csu();
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
                    b.this.csA();
                } else {
                    b.this.csz();
                }
            }
        }
    };
    private final CustomMessageListener iZp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.iZm != null) {
                    b.this.iZm.clear();
                }
                if (b.this.iZn != null) {
                    b.this.iZn.clear();
                }
                b.this.iZi = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.beg().setInterval();
                    b.csx().csy();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.csx().csu();
                }
            }
        });
        iZa = null;
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
                    b.csx().mHandler.removeMessages(2);
                    b.csx().csC();
                    return;
                case 3:
                    b.csx().mHandler.removeMessages(3);
                    if (b.csx().iZl == 3) {
                        b.csx().csD();
                    } else {
                        b.csx().csC();
                    }
                    b.csx().mHandler.sendMessageDelayed(b.csx().mHandler.obtainMessage(3), b.csx().iZd);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 10) {
            j.e(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(CmdConfigSocket.CMD_MESSAGE_SYNC, this.mTag);
        int processingResponsedMessageNum = MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum(CmdConfigSocket.CMD_MESSAGE_SYNC);
        if (a2 || processingResponsedMessageNum > 0) {
            j.e(false, false, true);
            yM(i);
            return;
        }
        csF();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.crX().csj());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.iZm != null) {
                this.iZm.clear();
            }
            if (this.iZn != null) {
                this.iZn.clear();
            }
        }
    }

    public void csu() {
        boolean z;
        if (this.iZi != null) {
            LongSparseArray<Long> csi = com.baidu.tieba.im.memorycache.b.crX().csi();
            if (csi == null) {
                this.iZi = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.iZi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && csi.get(next.getGroupId()) != null) {
                    if (csi.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.iZl = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                csx().mHandler.sendMessageDelayed(csx().mHandler.obtainMessage(3), csx().iZd);
            }
            this.iZi = null;
        }
    }

    private void csv() {
        if (this.iZh != 0) {
            if (this.iZh == 1) {
                g(0L, 0L, 0L);
            } else {
                csC();
            }
        }
    }

    private void csw() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b csx() {
        b bVar;
        synchronized (b.class) {
            if (iZa == null) {
                iZa = new b();
            }
            bVar = iZa;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.iZp);
        h.bep().a(this.HJ);
        MessageManager.getInstance().registerListener(1003, this.iJH);
        MessageManager.getInstance().registerListener(1001, this.iJH);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.iJH);
        csy();
    }

    public void csy() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            yJ(socketGetMsgStratgy[0] * 1000);
            yK(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        csF();
    }

    public void stop() {
        csF();
        csw();
    }

    public void csz() {
        this.iZd = this.iZc;
    }

    public void csA() {
        csx().iZd = csx().iZb;
    }

    public void yJ(int i) {
        if (i > 0) {
            this.iZc = i;
        }
    }

    public void yK(int i) {
        if (i > 0) {
            this.iZb = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void csB() {
        if (System.currentTimeMillis() - this.iZk >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.iZj);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.mX().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.mX().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.iZk = System.currentTimeMillis();
            this.iZj = 0;
            com.baidu.adp.lib.webSocket.h.mX().nb();
            com.baidu.adp.lib.webSocket.h.mX().na();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.crX().csi());
        }
        messageSyncMessage.setForTimer(this.iZo);
        LocalViewSize.ImageSize aWt = LocalViewSize.aWr().aWt();
        if (aWt != null) {
            messageSyncMessage.setWidth(aWt.width);
            messageSyncMessage.setHeight(aWt.height);
        }
        LocalViewSize.ImageSize aWs = LocalViewSize.aWr().aWs();
        if (aWs != null) {
            messageSyncMessage.setSmallHeight(aWs.height);
            messageSyncMessage.setSmallWidth(aWs.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.iZj++;
        this.iZo = false;
        this.iZl = 1;
        this.mHandler.removeMessages(3);
        csx().mHandler.sendMessageDelayed(csx().mHandler.obtainMessage(3), csx().iZd);
        if (this.iZm == null) {
            this.iZm = new LongSparseArray<>();
            this.iZm.clear();
        }
        if (this.iZn == null) {
            this.iZn = new LongSparseArray<>();
        }
        LongSparseArray<Long> csi = com.baidu.tieba.im.memorycache.b.crX().csi();
        if (0 != j) {
            Long l = csi.get(j);
            Long l2 = this.iZm.get(j);
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
                this.iZm.put(j, Long.valueOf(longValue));
            }
        }
        if (this.iZm != null && this.iZm.size() > 0) {
            for (int i = 0; i < this.iZm.size(); i++) {
                long keyAt = this.iZm.keyAt(i);
                Long l3 = csi.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.iZm.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.iZn.get(j) == null) {
                    this.iZn.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.iZn.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.iZn.put(j, Long.valueOf(j2));
                }
            }
            int size = this.iZm.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.iZm.keyAt(i2);
                long longValue3 = this.iZm.valueAt(i2).longValue();
                long j4 = 0;
                if (this.iZn.get(keyAt2) != null) {
                    j4 = this.iZn.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.iZm.remove(((Long) it.next()).longValue());
            }
        }
        if (this.iZm.size() == 0) {
            csF();
            this.iZn.clear();
        } else {
            a(this.iZm, 1);
        }
    }

    public synchronized void csC() {
        yL(2);
    }

    public synchronized void csD() {
        yL(3);
    }

    public void csE() {
        csv();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.iZo = false;
                this.iZl = 4;
                this.mHandler.removeMessages(3);
                csx().mHandler.sendMessageDelayed(csx().mHandler.obtainMessage(3), csx().iZd);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void yL(int i) {
        this.iZo = true;
        this.iZl = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void yM(int i) {
        if (i == 1) {
            if (this.iZh != 2) {
                this.iZh = 1;
            }
        } else if (i == 3 || i == 2) {
            this.iZh = 2;
        }
    }

    private void csF() {
        this.iZh = 0;
    }
}
