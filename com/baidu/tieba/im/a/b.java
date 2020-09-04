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
    private static b jwB;
    private List<GroupUpdateMessage> jwJ;
    private boolean jwP;
    private int jwC = 900000;
    private int jwD = 360000;
    private int jwE = this.jwD;
    private final int jwF = 0;
    private final int jwG = 1;
    private final int jwH = 2;
    private int jwI = 0;
    private int jwK = 0;
    private long jwL = 0;
    private int jwM = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> jwN = null;
    private LongSparseArray<Long> jwO = null;
    private final com.baidu.adp.framework.client.socket.link.a Io = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.lq().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c jeR = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cHv();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.jwJ = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cGN().isInit()) {
                            b.this.cHo();
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
                    b.this.cHu();
                } else {
                    b.this.cHt();
                }
            }
        }
    };
    private final CustomMessageListener jwQ = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.jwN != null) {
                    b.this.jwN.clear();
                }
                if (b.this.jwO != null) {
                    b.this.jwO.clear();
                }
                b.this.jwJ = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bqC().setInterval();
                    b.cHr().cHs();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cHr().cHo();
                }
            }
        });
        jwB = null;
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
                    b.cHr().mHandler.removeMessages(2);
                    b.cHr().cHw();
                    return;
                case 3:
                    b.cHr().mHandler.removeMessages(3);
                    if (b.cHr().jwM == 3) {
                        b.cHr().cHx();
                    } else {
                        b.cHr().cHw();
                    }
                    b.cHr().mHandler.sendMessageDelayed(b.cHr().mHandler.obtainMessage(3), b.cHr().jwE);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 10) {
            j.f(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(CmdConfigSocket.CMD_MESSAGE_SYNC, this.mTag);
        int processingResponsedMessageNum = MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum(CmdConfigSocket.CMD_MESSAGE_SYNC);
        if (a2 || processingResponsedMessageNum > 0) {
            j.f(false, false, true);
            BE(i);
            return;
        }
        cHz();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cGN().cGZ());
        }
        MessageManager.getInstance().sendMessage(b);
        j.f(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.jwN != null) {
                this.jwN.clear();
            }
            if (this.jwO != null) {
                this.jwO.clear();
            }
        }
    }

    public void cHo() {
        boolean z;
        if (this.jwJ != null) {
            LongSparseArray<Long> cGY = com.baidu.tieba.im.memorycache.b.cGN().cGY();
            if (cGY == null) {
                this.jwJ = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.jwJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cGY.get(next.getGroupId()) != null) {
                    if (cGY.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.jwM = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cHr().mHandler.sendMessageDelayed(cHr().mHandler.obtainMessage(3), cHr().jwE);
            }
            this.jwJ = null;
        }
    }

    private void cHp() {
        if (this.jwI != 0) {
            if (this.jwI == 1) {
                g(0L, 0L, 0L);
            } else {
                cHw();
            }
        }
    }

    private void cHq() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cHr() {
        b bVar;
        synchronized (b.class) {
            if (jwB == null) {
                jwB = new b();
            }
            bVar = jwB;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.jwQ);
        h.bqL().a(this.Io);
        MessageManager.getInstance().registerListener(1003, this.jeR);
        MessageManager.getInstance().registerListener(1001, this.jeR);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.jeR);
        cHs();
    }

    public void cHs() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            BB(socketGetMsgStratgy[0] * 1000);
            BC(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cHz();
    }

    public void stop() {
        cHz();
        cHq();
    }

    public void cHt() {
        this.jwE = this.jwD;
    }

    public void cHu() {
        cHr().jwE = cHr().jwC;
    }

    public void BB(int i) {
        if (i > 0) {
            this.jwD = i;
        }
    }

    public void BC(int i) {
        if (i > 0) {
            this.jwC = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cHv() {
        if (System.currentTimeMillis() - this.jwL >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.jwK);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.oy().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.oy().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.jwL = System.currentTimeMillis();
            this.jwK = 0;
            com.baidu.adp.lib.webSocket.h.oy().oC();
            com.baidu.adp.lib.webSocket.h.oy().oB();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cGN().cGY());
        }
        messageSyncMessage.setForTimer(this.jwP);
        LocalViewSize.ImageSize biP = LocalViewSize.biN().biP();
        if (biP != null) {
            messageSyncMessage.setWidth(biP.width);
            messageSyncMessage.setHeight(biP.height);
        }
        LocalViewSize.ImageSize biO = LocalViewSize.biN().biO();
        if (biO != null) {
            messageSyncMessage.setSmallHeight(biO.height);
            messageSyncMessage.setSmallWidth(biO.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.jwK++;
        this.jwP = false;
        this.jwM = 1;
        this.mHandler.removeMessages(3);
        cHr().mHandler.sendMessageDelayed(cHr().mHandler.obtainMessage(3), cHr().jwE);
        if (this.jwN == null) {
            this.jwN = new LongSparseArray<>();
            this.jwN.clear();
        }
        if (this.jwO == null) {
            this.jwO = new LongSparseArray<>();
        }
        LongSparseArray<Long> cGY = com.baidu.tieba.im.memorycache.b.cGN().cGY();
        if (0 != j) {
            Long l = cGY.get(j);
            Long l2 = this.jwN.get(j);
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
                this.jwN.put(j, Long.valueOf(longValue));
            }
        }
        if (this.jwN != null && this.jwN.size() > 0) {
            for (int i = 0; i < this.jwN.size(); i++) {
                long keyAt = this.jwN.keyAt(i);
                Long l3 = cGY.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.jwN.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.jwO.get(j) == null) {
                    this.jwO.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.jwO.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.jwO.put(j, Long.valueOf(j2));
                }
            }
            int size = this.jwN.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.jwN.keyAt(i2);
                long longValue3 = this.jwN.valueAt(i2).longValue();
                long j4 = 0;
                if (this.jwO.get(keyAt2) != null) {
                    j4 = this.jwO.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.jwN.remove(((Long) it.next()).longValue());
            }
        }
        if (this.jwN.size() == 0) {
            cHz();
            this.jwO.clear();
        } else {
            a(this.jwN, 1);
        }
    }

    public synchronized void cHw() {
        BD(2);
    }

    public synchronized void cHx() {
        BD(3);
    }

    public void cHy() {
        cHp();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.jwP = false;
                this.jwM = 4;
                this.mHandler.removeMessages(3);
                cHr().mHandler.sendMessageDelayed(cHr().mHandler.obtainMessage(3), cHr().jwE);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void BD(int i) {
        this.jwP = true;
        this.jwM = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void BE(int i) {
        if (i == 1) {
            if (this.jwI != 2) {
                this.jwI = 1;
            }
        } else if (i == 3 || i == 2) {
            this.jwI = 2;
        }
    }

    private void cHz() {
        this.jwI = 0;
    }
}
