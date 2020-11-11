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
    private static b kmx;
    private List<GroupUpdateMessage> kmF;
    private boolean kmL;
    private int kmy = 900000;
    private int kmz = 360000;
    private int kmA = this.kmz;
    private final int kmB = 0;
    private final int kmC = 1;
    private final int kmD = 2;
    private int kmE = 0;
    private int kmG = 0;
    private long kmH = 0;
    private int kmI = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> kmJ = null;
    private LongSparseArray<Long> kmK = null;
    private final com.baidu.adp.framework.client.socket.link.a IR = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            b.this.start();
            f.lv().setSequenceId(map);
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
    private final com.baidu.adp.framework.listener.c jUQ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cUs();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.kmF = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cTK().isInit()) {
                            b.this.cUl();
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
                    b.this.cUr();
                } else {
                    b.this.cUq();
                }
            }
        }
    };
    private final CustomMessageListener kmM = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.kmJ != null) {
                    b.this.kmJ.clear();
                }
                if (b.this.kmK != null) {
                    b.this.kmK.clear();
                }
                b.this.kmF = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.byy().setInterval();
                    b.cUo().cUp();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cUo().cUl();
                }
            }
        });
        kmx = null;
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
                    b.cUo().mHandler.removeMessages(2);
                    b.cUo().cUt();
                    return;
                case 3:
                    b.cUo().mHandler.removeMessages(3);
                    if (b.cUo().kmI == 3) {
                        b.cUo().cUu();
                    } else {
                        b.cUo().cUt();
                    }
                    b.cUo().mHandler.sendMessageDelayed(b.cUo().mHandler.obtainMessage(3), b.cUo().kmA);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum() > 10) {
            j.g(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(CmdConfigSocket.CMD_MESSAGE_SYNC, this.mTag);
        int processingResponsedMessageNum = MessageManager.getInstance().getSocketClient().getProcessingResponsedMessageNum(CmdConfigSocket.CMD_MESSAGE_SYNC);
        if (a2 || processingResponsedMessageNum > 0) {
            j.g(false, false, true);
            Dr(i);
            return;
        }
        cUw();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cTK().cTW());
        }
        MessageManager.getInstance().sendMessage(b);
        j.g(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.kmJ != null) {
                this.kmJ.clear();
            }
            if (this.kmK != null) {
                this.kmK.clear();
            }
        }
    }

    public void cUl() {
        boolean z;
        if (this.kmF != null) {
            LongSparseArray<Long> cTV = com.baidu.tieba.im.memorycache.b.cTK().cTV();
            if (cTV == null) {
                this.kmF = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.kmF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cTV.get(next.getGroupId()) != null) {
                    if (cTV.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.kmI = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cUo().mHandler.sendMessageDelayed(cUo().mHandler.obtainMessage(3), cUo().kmA);
            }
            this.kmF = null;
        }
    }

    private void cUm() {
        if (this.kmE != 0) {
            if (this.kmE == 1) {
                g(0L, 0L, 0L);
            } else {
                cUt();
            }
        }
    }

    private void cUn() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cUo() {
        b bVar;
        synchronized (b.class) {
            if (kmx == null) {
                kmx = new b();
            }
            bVar = kmx;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.kmM);
        h.byH().a(this.IR);
        MessageManager.getInstance().registerListener(1003, this.jUQ);
        MessageManager.getInstance().registerListener(1001, this.jUQ);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.jUQ);
        cUp();
    }

    public void cUp() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            Do(socketGetMsgStratgy[0] * 1000);
            Dp(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cUw();
    }

    public void stop() {
        cUw();
        cUn();
    }

    public void cUq() {
        this.kmA = this.kmz;
    }

    public void cUr() {
        cUo().kmA = cUo().kmy;
    }

    public void Do(int i) {
        if (i > 0) {
            this.kmz = i;
        }
    }

    public void Dp(int i) {
        if (i > 0) {
            this.kmy = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cUs() {
        if (System.currentTimeMillis() - this.kmH >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.kmG);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.oD().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.oD().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.kmH = System.currentTimeMillis();
            this.kmG = 0;
            com.baidu.adp.lib.webSocket.h.oD().oH();
            com.baidu.adp.lib.webSocket.h.oD().oG();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cTK().cTV());
        }
        messageSyncMessage.setForTimer(this.kmL);
        LocalViewSize.ImageSize bqM = LocalViewSize.bqK().bqM();
        if (bqM != null) {
            messageSyncMessage.setWidth(bqM.width);
            messageSyncMessage.setHeight(bqM.height);
        }
        LocalViewSize.ImageSize bqL = LocalViewSize.bqK().bqL();
        if (bqL != null) {
            messageSyncMessage.setSmallHeight(bqL.height);
            messageSyncMessage.setSmallWidth(bqL.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.kmG++;
        this.kmL = false;
        this.kmI = 1;
        this.mHandler.removeMessages(3);
        cUo().mHandler.sendMessageDelayed(cUo().mHandler.obtainMessage(3), cUo().kmA);
        if (this.kmJ == null) {
            this.kmJ = new LongSparseArray<>();
            this.kmJ.clear();
        }
        if (this.kmK == null) {
            this.kmK = new LongSparseArray<>();
        }
        LongSparseArray<Long> cTV = com.baidu.tieba.im.memorycache.b.cTK().cTV();
        if (0 != j) {
            Long l = cTV.get(j);
            Long l2 = this.kmJ.get(j);
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
                this.kmJ.put(j, Long.valueOf(longValue));
            }
        }
        if (this.kmJ != null && this.kmJ.size() > 0) {
            for (int i = 0; i < this.kmJ.size(); i++) {
                long keyAt = this.kmJ.keyAt(i);
                Long l3 = cTV.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.kmJ.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.kmK.get(j) == null) {
                    this.kmK.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.kmK.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.kmK.put(j, Long.valueOf(j2));
                }
            }
            int size = this.kmJ.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.kmJ.keyAt(i2);
                long longValue3 = this.kmJ.valueAt(i2).longValue();
                long j4 = 0;
                if (this.kmK.get(keyAt2) != null) {
                    j4 = this.kmK.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.kmJ.remove(((Long) it.next()).longValue());
            }
        }
        if (this.kmJ.size() == 0) {
            cUw();
            this.kmK.clear();
        } else {
            a(this.kmJ, 1);
        }
    }

    public synchronized void cUt() {
        Dq(2);
    }

    public synchronized void cUu() {
        Dq(3);
    }

    public void cUv() {
        cUm();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.kmL = false;
                this.kmI = 4;
                this.mHandler.removeMessages(3);
                cUo().mHandler.sendMessageDelayed(cUo().mHandler.obtainMessage(3), cUo().kmA);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void Dq(int i) {
        this.kmL = true;
        this.kmI = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void Dr(int i) {
        if (i == 1) {
            if (this.kmE != 2) {
                this.kmE = 1;
            }
        } else if (i == 3 || i == 2) {
            this.kmE = 2;
        }
    }

    private void cUw() {
        this.kmE = 0;
    }
}
