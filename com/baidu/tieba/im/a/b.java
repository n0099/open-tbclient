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
/* loaded from: classes2.dex */
public class b {
    private static b jwv;
    private List<GroupUpdateMessage> jwD;
    private boolean jwJ;
    private int jww = 900000;
    private int jwx = 360000;
    private int jwy = this.jwx;
    private final int jwz = 0;
    private final int jwA = 1;
    private final int jwB = 2;
    private int jwC = 0;
    private int jwE = 0;
    private long jwF = 0;
    private int jwG = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> jwH = null;
    private LongSparseArray<Long> jwI = null;
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
    private final com.baidu.adp.framework.listener.c jeL = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cHu();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.jwD = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cGM().isInit()) {
                            b.this.cHn();
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
                    b.this.cHt();
                } else {
                    b.this.cHs();
                }
            }
        }
    };
    private final CustomMessageListener jwK = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.jwH != null) {
                    b.this.jwH.clear();
                }
                if (b.this.jwI != null) {
                    b.this.jwI.clear();
                }
                b.this.jwD = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bqB().setInterval();
                    b.cHq().cHr();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cHq().cHn();
                }
            }
        });
        jwv = null;
    }

    /* loaded from: classes2.dex */
    private static class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 2:
                    b.cHq().mHandler.removeMessages(2);
                    b.cHq().cHv();
                    return;
                case 3:
                    b.cHq().mHandler.removeMessages(3);
                    if (b.cHq().jwG == 3) {
                        b.cHq().cHw();
                    } else {
                        b.cHq().cHv();
                    }
                    b.cHq().mHandler.sendMessageDelayed(b.cHq().mHandler.obtainMessage(3), b.cHq().jwy);
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
        cHy();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cGM().cGY());
        }
        MessageManager.getInstance().sendMessage(b);
        j.f(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.jwH != null) {
                this.jwH.clear();
            }
            if (this.jwI != null) {
                this.jwI.clear();
            }
        }
    }

    public void cHn() {
        boolean z;
        if (this.jwD != null) {
            LongSparseArray<Long> cGX = com.baidu.tieba.im.memorycache.b.cGM().cGX();
            if (cGX == null) {
                this.jwD = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.jwD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cGX.get(next.getGroupId()) != null) {
                    if (cGX.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.jwG = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cHq().mHandler.sendMessageDelayed(cHq().mHandler.obtainMessage(3), cHq().jwy);
            }
            this.jwD = null;
        }
    }

    private void cHo() {
        if (this.jwC != 0) {
            if (this.jwC == 1) {
                g(0L, 0L, 0L);
            } else {
                cHv();
            }
        }
    }

    private void cHp() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cHq() {
        b bVar;
        synchronized (b.class) {
            if (jwv == null) {
                jwv = new b();
            }
            bVar = jwv;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.jwK);
        h.bqK().a(this.Io);
        MessageManager.getInstance().registerListener(1003, this.jeL);
        MessageManager.getInstance().registerListener(1001, this.jeL);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.jeL);
        cHr();
    }

    public void cHr() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            BB(socketGetMsgStratgy[0] * 1000);
            BC(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cHy();
    }

    public void stop() {
        cHy();
        cHp();
    }

    public void cHs() {
        this.jwy = this.jwx;
    }

    public void cHt() {
        cHq().jwy = cHq().jww;
    }

    public void BB(int i) {
        if (i > 0) {
            this.jwx = i;
        }
    }

    public void BC(int i) {
        if (i > 0) {
            this.jww = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cHu() {
        if (System.currentTimeMillis() - this.jwF >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.jwE);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.oy().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.oy().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.jwF = System.currentTimeMillis();
            this.jwE = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cGM().cGX());
        }
        messageSyncMessage.setForTimer(this.jwJ);
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
        this.jwE++;
        this.jwJ = false;
        this.jwG = 1;
        this.mHandler.removeMessages(3);
        cHq().mHandler.sendMessageDelayed(cHq().mHandler.obtainMessage(3), cHq().jwy);
        if (this.jwH == null) {
            this.jwH = new LongSparseArray<>();
            this.jwH.clear();
        }
        if (this.jwI == null) {
            this.jwI = new LongSparseArray<>();
        }
        LongSparseArray<Long> cGX = com.baidu.tieba.im.memorycache.b.cGM().cGX();
        if (0 != j) {
            Long l = cGX.get(j);
            Long l2 = this.jwH.get(j);
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
                this.jwH.put(j, Long.valueOf(longValue));
            }
        }
        if (this.jwH != null && this.jwH.size() > 0) {
            for (int i = 0; i < this.jwH.size(); i++) {
                long keyAt = this.jwH.keyAt(i);
                Long l3 = cGX.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.jwH.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.jwI.get(j) == null) {
                    this.jwI.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.jwI.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.jwI.put(j, Long.valueOf(j2));
                }
            }
            int size = this.jwH.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.jwH.keyAt(i2);
                long longValue3 = this.jwH.valueAt(i2).longValue();
                long j4 = 0;
                if (this.jwI.get(keyAt2) != null) {
                    j4 = this.jwI.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.jwH.remove(((Long) it.next()).longValue());
            }
        }
        if (this.jwH.size() == 0) {
            cHy();
            this.jwI.clear();
        } else {
            a(this.jwH, 1);
        }
    }

    public synchronized void cHv() {
        BD(2);
    }

    public synchronized void cHw() {
        BD(3);
    }

    public void cHx() {
        cHo();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.jwJ = false;
                this.jwG = 4;
                this.mHandler.removeMessages(3);
                cHq().mHandler.sendMessageDelayed(cHq().mHandler.obtainMessage(3), cHq().jwy);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void BD(int i) {
        this.jwJ = true;
        this.jwG = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void BE(int i) {
        if (i == 1) {
            if (this.jwC != 2) {
                this.jwC = 1;
            }
        } else if (i == 3 || i == 2) {
            this.jwC = 2;
        }
    }

    private void cHy() {
        this.jwC = 0;
    }
}
