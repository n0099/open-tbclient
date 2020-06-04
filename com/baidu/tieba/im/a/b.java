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
    private static b iHX;
    private List<GroupUpdateMessage> iIf;
    private boolean iIl;
    private int iHY = 900000;
    private int iHZ = 360000;
    private int iIa = this.iHZ;
    private final int iIb = 0;
    private final int iIc = 1;
    private final int iId = 2;
    private int iIe = 0;
    private int iIg = 0;
    private long iIh = 0;
    private int iIi = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> iIj = null;
    private LongSparseArray<Long> iIk = null;
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
    private final com.baidu.adp.framework.listener.c isB = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.coL();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.iIf = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.coh().isInit()) {
                            b.this.coE();
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
                    b.this.coK();
                } else {
                    b.this.coJ();
                }
            }
        }
    };
    private final CustomMessageListener iIm = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.iIj != null) {
                    b.this.iIj.clear();
                }
                if (b.this.iIk != null) {
                    b.this.iIk.clear();
                }
                b.this.iIf = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bce().setInterval();
                    b.coH().coI();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.coH().coE();
                }
            }
        });
        iHX = null;
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
                    b.coH().mHandler.removeMessages(2);
                    b.coH().coM();
                    return;
                case 3:
                    b.coH().mHandler.removeMessages(3);
                    if (b.coH().iIi == 3) {
                        b.coH().coN();
                    } else {
                        b.coH().coM();
                    }
                    b.coH().mHandler.sendMessageDelayed(b.coH().mHandler.obtainMessage(3), b.coH().iIa);
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
            yc(i);
            return;
        }
        coP();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.coh().cot());
        }
        MessageManager.getInstance().sendMessage(b);
        j.e(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.iIj != null) {
                this.iIj.clear();
            }
            if (this.iIk != null) {
                this.iIk.clear();
            }
        }
    }

    public void coE() {
        boolean z;
        if (this.iIf != null) {
            LongSparseArray<Long> cos = com.baidu.tieba.im.memorycache.b.coh().cos();
            if (cos == null) {
                this.iIf = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.iIf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cos.get(next.getGroupId()) != null) {
                    if (cos.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.iIi = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                coH().mHandler.sendMessageDelayed(coH().mHandler.obtainMessage(3), coH().iIa);
            }
            this.iIf = null;
        }
    }

    private void coF() {
        if (this.iIe != 0) {
            if (this.iIe == 1) {
                d(0L, 0L, 0L);
            } else {
                coM();
            }
        }
    }

    private void coG() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b coH() {
        b bVar;
        synchronized (b.class) {
            if (iHX == null) {
                iHX = new b();
            }
            bVar = iHX;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.iIm);
        h.bcn().a(this.Hj);
        MessageManager.getInstance().registerListener(1003, this.isB);
        MessageManager.getInstance().registerListener(1001, this.isB);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.isB);
        coI();
    }

    public void coI() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            xZ(socketGetMsgStratgy[0] * 1000);
            ya(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        coP();
    }

    public void stop() {
        coP();
        coG();
    }

    public void coJ() {
        this.iIa = this.iHZ;
    }

    public void coK() {
        coH().iIa = coH().iHY;
    }

    public void xZ(int i) {
        if (i > 0) {
            this.iHZ = i;
        }
    }

    public void ya(int i) {
        if (i > 0) {
            this.iHY = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void coL() {
        if (System.currentTimeMillis() - this.iIh >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.iIg);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.mH().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.mH().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.iIh = System.currentTimeMillis();
            this.iIg = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.coh().cos());
        }
        messageSyncMessage.setForTimer(this.iIl);
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
        this.iIg++;
        this.iIl = false;
        this.iIi = 1;
        this.mHandler.removeMessages(3);
        coH().mHandler.sendMessageDelayed(coH().mHandler.obtainMessage(3), coH().iIa);
        if (this.iIj == null) {
            this.iIj = new LongSparseArray<>();
            this.iIj.clear();
        }
        if (this.iIk == null) {
            this.iIk = new LongSparseArray<>();
        }
        LongSparseArray<Long> cos = com.baidu.tieba.im.memorycache.b.coh().cos();
        if (0 != j) {
            Long l = cos.get(j);
            Long l2 = this.iIj.get(j);
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
                this.iIj.put(j, Long.valueOf(longValue));
            }
        }
        if (this.iIj != null && this.iIj.size() > 0) {
            for (int i = 0; i < this.iIj.size(); i++) {
                long keyAt = this.iIj.keyAt(i);
                Long l3 = cos.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.iIj.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.iIk.get(j) == null) {
                    this.iIk.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.iIk.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.iIk.put(j, Long.valueOf(j2));
                }
            }
            int size = this.iIj.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.iIj.keyAt(i2);
                long longValue3 = this.iIj.valueAt(i2).longValue();
                long j4 = 0;
                if (this.iIk.get(keyAt2) != null) {
                    j4 = this.iIk.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.iIj.remove(((Long) it.next()).longValue());
            }
        }
        if (this.iIj.size() == 0) {
            coP();
            this.iIk.clear();
        } else {
            a(this.iIj, 1);
        }
    }

    public synchronized void coM() {
        yb(2);
    }

    public synchronized void coN() {
        yb(3);
    }

    public void coO() {
        coF();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.iIl = false;
                this.iIi = 4;
                this.mHandler.removeMessages(3);
                coH().mHandler.sendMessageDelayed(coH().mHandler.obtainMessage(3), coH().iIa);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void yb(int i) {
        this.iIl = true;
        this.iIi = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void yc(int i) {
        if (i == 1) {
            if (this.iIe != 2) {
                this.iIe = 1;
            }
        } else if (i == 3 || i == 2) {
            this.iIe = 2;
        }
    }

    private void coP() {
        this.iIe = 0;
    }
}
