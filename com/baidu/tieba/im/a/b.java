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
    private static b iHk;
    private List<GroupUpdateMessage> iHs;
    private boolean iHy;
    private int iHl = 900000;
    private int iHm = 360000;
    private int iHn = this.iHm;
    private final int iHo = 0;
    private final int iHp = 1;
    private final int iHq = 2;
    private int iHr = 0;
    private int iHt = 0;
    private long iHu = 0;
    private int iHv = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> iHw = null;
    private LongSparseArray<Long> iHx = null;
    private final com.baidu.adp.framework.client.socket.link.a Hj = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.jB().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c irO = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.coC();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.iHs = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cnY().isInit()) {
                            b.this.cov();
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
                    b.this.coB();
                } else {
                    b.this.coA();
                }
            }
        }
    };
    private final CustomMessageListener iHz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.iHw != null) {
                    b.this.iHw.clear();
                }
                if (b.this.iHx != null) {
                    b.this.iHx.clear();
                }
                b.this.iHs = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bcd().setInterval();
                    b.coy().coz();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.coy().cov();
                }
            }
        });
        iHk = null;
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
                    b.coy().mHandler.removeMessages(2);
                    b.coy().coD();
                    return;
                case 3:
                    b.coy().mHandler.removeMessages(3);
                    if (b.coy().iHv == 3) {
                        b.coy().coE();
                    } else {
                        b.coy().coD();
                    }
                    b.coy().mHandler.sendMessageDelayed(b.coy().mHandler.obtainMessage(3), b.coy().iHn);
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
            ya(i);
            return;
        }
        coG();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cnY().cok());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.iHw != null) {
                this.iHw.clear();
            }
            if (this.iHx != null) {
                this.iHx.clear();
            }
        }
    }

    public void cov() {
        boolean z;
        if (this.iHs != null) {
            LongSparseArray<Long> coj = com.baidu.tieba.im.memorycache.b.cnY().coj();
            if (coj == null) {
                this.iHs = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.iHs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && coj.get(next.getGroupId()) != null) {
                    if (coj.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.iHv = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                coy().mHandler.sendMessageDelayed(coy().mHandler.obtainMessage(3), coy().iHn);
            }
            this.iHs = null;
        }
    }

    private void cow() {
        if (this.iHr != 0) {
            if (this.iHr == 1) {
                d(0L, 0L, 0L);
            } else {
                coD();
            }
        }
    }

    private void cox() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b coy() {
        b bVar;
        synchronized (b.class) {
            if (iHk == null) {
                iHk = new b();
            }
            bVar = iHk;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.iHz);
        h.bcm().a(this.Hj);
        MessageManager.getInstance().registerListener(1003, this.irO);
        MessageManager.getInstance().registerListener(1001, this.irO);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.irO);
        coz();
    }

    public void coz() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            xX(socketGetMsgStratgy[0] * 1000);
            xY(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        coG();
    }

    public void stop() {
        coG();
        cox();
    }

    public void coA() {
        this.iHn = this.iHm;
    }

    public void coB() {
        coy().iHn = coy().iHl;
    }

    public void xX(int i) {
        if (i > 0) {
            this.iHm = i;
        }
    }

    public void xY(int i) {
        if (i > 0) {
            this.iHl = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void coC() {
        if (System.currentTimeMillis() - this.iHu >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.iHt);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.mH().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.mH().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.iHu = System.currentTimeMillis();
            this.iHt = 0;
            com.baidu.adp.lib.webSocket.h.mH().mL();
            com.baidu.adp.lib.webSocket.h.mH().mK();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cnY().coj());
        }
        messageSyncMessage.setForTimer(this.iHy);
        LocalViewSize.ImageSize aUz = LocalViewSize.aUx().aUz();
        if (aUz != null) {
            messageSyncMessage.setWidth(aUz.width);
            messageSyncMessage.setHeight(aUz.height);
        }
        LocalViewSize.ImageSize aUy = LocalViewSize.aUx().aUy();
        if (aUy != null) {
            messageSyncMessage.setSmallHeight(aUy.height);
            messageSyncMessage.setSmallWidth(aUy.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.iHt++;
        this.iHy = false;
        this.iHv = 1;
        this.mHandler.removeMessages(3);
        coy().mHandler.sendMessageDelayed(coy().mHandler.obtainMessage(3), coy().iHn);
        if (this.iHw == null) {
            this.iHw = new LongSparseArray<>();
            this.iHw.clear();
        }
        if (this.iHx == null) {
            this.iHx = new LongSparseArray<>();
        }
        LongSparseArray<Long> coj = com.baidu.tieba.im.memorycache.b.cnY().coj();
        if (0 != j) {
            Long l = coj.get(j);
            Long l2 = this.iHw.get(j);
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
                this.iHw.put(j, Long.valueOf(longValue));
            }
        }
        if (this.iHw != null && this.iHw.size() > 0) {
            for (int i = 0; i < this.iHw.size(); i++) {
                long keyAt = this.iHw.keyAt(i);
                Long l3 = coj.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.iHw.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.iHx.get(j) == null) {
                    this.iHx.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.iHx.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.iHx.put(j, Long.valueOf(j2));
                }
            }
            int size = this.iHw.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.iHw.keyAt(i2);
                long longValue3 = this.iHw.valueAt(i2).longValue();
                long j4 = 0;
                if (this.iHx.get(keyAt2) != null) {
                    j4 = this.iHx.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.iHw.remove(((Long) it.next()).longValue());
            }
        }
        if (this.iHw.size() == 0) {
            coG();
            this.iHx.clear();
        } else {
            a(this.iHw, 1);
        }
    }

    public synchronized void coD() {
        xZ(2);
    }

    public synchronized void coE() {
        xZ(3);
    }

    public void coF() {
        cow();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.iHy = false;
                this.iHv = 4;
                this.mHandler.removeMessages(3);
                coy().mHandler.sendMessageDelayed(coy().mHandler.obtainMessage(3), coy().iHn);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void xZ(int i) {
        this.iHy = true;
        this.iHv = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void ya(int i) {
        if (i == 1) {
            if (this.iHr != 2) {
                this.iHr = 1;
            }
        } else if (i == 3 || i == 2) {
            this.iHr = 2;
        }
    }

    private void coG() {
        this.iHr = 0;
    }
}
