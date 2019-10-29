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
import com.baidu.tbadk.coreExtra.e.e;
import com.baidu.tbadk.coreExtra.e.h;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.p.j;
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
    private static b gOf;
    private List<GroupUpdateMessage> gOn;
    private boolean gOt;
    private int gOg = 900000;
    private int gOh = 360000;
    private int gOi = this.gOh;
    private final int gOj = 0;
    private final int gOk = 1;
    private final int gOl = 2;
    private int gOm = 0;
    private int gOo = 0;
    private long gOp = 0;
    private int gOq = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> gOr = null;
    private LongSparseArray<Long> gOs = null;
    private final com.baidu.adp.framework.client.socket.link.a ma = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.eB().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c gyE = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.bDq();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.gOn = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.bCM().bCL()) {
                            b.this.bDj();
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
                    b.this.bDp();
                } else {
                    b.this.bDo();
                }
            }
        }
    };
    private final CustomMessageListener gOu = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.gOr != null) {
                    b.this.gOr.clear();
                }
                if (b.this.gOs != null) {
                    b.this.gOs.clear();
                }
                b.this.gOn = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.ath().setInterval();
                    b.bDm().bDn();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.bDm().bDj();
                }
            }
        });
        gOf = null;
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
                    b.bDm().mHandler.removeMessages(2);
                    b.bDm().bDr();
                    return;
                case 3:
                    b.bDm().mHandler.removeMessages(3);
                    if (b.bDm().gOq == 3) {
                        b.bDm().bDs();
                    } else {
                        b.bDm().bDr();
                    }
                    b.bDm().mHandler.sendMessageDelayed(b.bDm().mHandler.obtainMessage(3), b.bDm().gOi);
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
            uC(i);
            return;
        }
        bDu();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.bCM().bCY());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.gOr != null) {
                this.gOr.clear();
            }
            if (this.gOs != null) {
                this.gOs.clear();
            }
        }
    }

    public void bDj() {
        boolean z;
        if (this.gOn != null) {
            LongSparseArray<Long> bCX = com.baidu.tieba.im.memorycache.b.bCM().bCX();
            if (bCX == null) {
                this.gOn = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.gOn.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && bCX.get(next.getGroupId()) != null) {
                    if (bCX.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.gOq = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                bDm().mHandler.sendMessageDelayed(bDm().mHandler.obtainMessage(3), bDm().gOi);
            }
            this.gOn = null;
        }
    }

    private void bDk() {
        if (this.gOm != 0) {
            if (this.gOm == 1) {
                d(0L, 0L, 0L);
            } else {
                bDr();
            }
        }
    }

    private void bDl() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b bDm() {
        b bVar;
        synchronized (b.class) {
            if (gOf == null) {
                gOf = new b();
            }
            bVar = gOf;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.gOu);
        h.atn().a(this.ma);
        MessageManager.getInstance().registerListener(1003, this.gyE);
        MessageManager.getInstance().registerListener(1001, this.gyE);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.gyE);
        bDn();
    }

    public void bDn() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            uz(socketGetMsgStratgy[0] * 1000);
            uA(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        bDu();
    }

    public void stop() {
        bDu();
        bDl();
    }

    public void bDo() {
        this.gOi = this.gOh;
    }

    public void bDp() {
        bDm().gOi = bDm().gOg;
    }

    public void uz(int i) {
        if (i > 0) {
            this.gOh = i;
        }
    }

    public void uA(int i) {
        if (i > 0) {
            this.gOg = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bDq() {
        if (System.currentTimeMillis() - this.gOp >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.gOo);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hr().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hr().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.gOp = System.currentTimeMillis();
            this.gOo = 0;
            com.baidu.adp.lib.webSocket.h.hr().hw();
            com.baidu.adp.lib.webSocket.h.hr().hv();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.bCM().bCX());
        }
        messageSyncMessage.setForTimer(this.gOt);
        LocalViewSize.ImageSize amq = LocalViewSize.amo().amq();
        if (amq != null) {
            messageSyncMessage.setWidth(amq.width);
            messageSyncMessage.setHeight(amq.height);
        }
        LocalViewSize.ImageSize amp = LocalViewSize.amo().amp();
        if (amp != null) {
            messageSyncMessage.setSmallHeight(amp.height);
            messageSyncMessage.setSmallWidth(amp.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.gOo++;
        this.gOt = false;
        this.gOq = 1;
        this.mHandler.removeMessages(3);
        bDm().mHandler.sendMessageDelayed(bDm().mHandler.obtainMessage(3), bDm().gOi);
        if (this.gOr == null) {
            this.gOr = new LongSparseArray<>();
            this.gOr.clear();
        }
        if (this.gOs == null) {
            this.gOs = new LongSparseArray<>();
        }
        LongSparseArray<Long> bCX = com.baidu.tieba.im.memorycache.b.bCM().bCX();
        if (0 != j) {
            Long l = bCX.get(j);
            Long l2 = this.gOr.get(j);
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
                this.gOr.put(j, Long.valueOf(longValue));
            }
        }
        if (this.gOr != null && this.gOr.size() > 0) {
            for (int i = 0; i < this.gOr.size(); i++) {
                long keyAt = this.gOr.keyAt(i);
                Long l3 = bCX.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.gOr.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.gOs.get(j) == null) {
                    this.gOs.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.gOs.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.gOs.put(j, Long.valueOf(j2));
                }
            }
            int size = this.gOr.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.gOr.keyAt(i2);
                long longValue3 = this.gOr.valueAt(i2).longValue();
                long j4 = 0;
                if (this.gOs.get(keyAt2) != null) {
                    j4 = this.gOs.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.gOr.remove(((Long) it.next()).longValue());
            }
        }
        if (this.gOr.size() == 0) {
            bDu();
            this.gOs.clear();
        } else {
            a(this.gOr, 1);
        }
    }

    public synchronized void bDr() {
        uB(2);
    }

    public synchronized void bDs() {
        uB(3);
    }

    public void bDt() {
        bDk();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.gOt = false;
                this.gOq = 4;
                this.mHandler.removeMessages(3);
                bDm().mHandler.sendMessageDelayed(bDm().mHandler.obtainMessage(3), bDm().gOi);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void uB(int i) {
        this.gOt = true;
        this.gOq = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void uC(int i) {
        if (i == 1) {
            if (this.gOm != 2) {
                this.gOm = 1;
            }
        } else if (i == 3 || i == 2) {
            this.gOm = 2;
        }
    }

    private void bDu() {
        this.gOm = 0;
    }
}
