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
    private static b jUa;
    private List<GroupUpdateMessage> jUi;
    private boolean jUo;
    private int jUb = 900000;
    private int jUc = 360000;
    private int jUd = this.jUc;
    private final int jUe = 0;
    private final int jUf = 1;
    private final int jUg = 2;
    private int jUh = 0;
    private int jUj = 0;
    private long jUk = 0;
    private int jUl = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> jUm = null;
    private LongSparseArray<Long> jUn = null;
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
    private final com.baidu.adp.framework.listener.c jCu = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.cOK();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.jUi = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.cOc().isInit()) {
                            b.this.cOD();
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
                    b.this.cOJ();
                } else {
                    b.this.cOI();
                }
            }
        }
    };
    private final CustomMessageListener jUp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.jUm != null) {
                    b.this.jUm.clear();
                }
                if (b.this.jUn != null) {
                    b.this.jUn.clear();
                }
                b.this.jUi = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    e.bug().setInterval();
                    b.cOG().cOH();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.cOG().cOD();
                }
            }
        });
        jUa = null;
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
                    b.cOG().mHandler.removeMessages(2);
                    b.cOG().cOL();
                    return;
                case 3:
                    b.cOG().mHandler.removeMessages(3);
                    if (b.cOG().jUl == 3) {
                        b.cOG().cOM();
                    } else {
                        b.cOG().cOL();
                    }
                    b.cOG().mHandler.sendMessageDelayed(b.cOG().mHandler.obtainMessage(3), b.cOG().jUd);
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
            CL(i);
            return;
        }
        cOO();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.cOc().cOo());
        }
        MessageManager.getInstance().sendMessage(b);
        j.g(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.jUm != null) {
                this.jUm.clear();
            }
            if (this.jUn != null) {
                this.jUn.clear();
            }
        }
    }

    public void cOD() {
        boolean z;
        if (this.jUi != null) {
            LongSparseArray<Long> cOn = com.baidu.tieba.im.memorycache.b.cOc().cOn();
            if (cOn == null) {
                this.jUi = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.jUi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && cOn.get(next.getGroupId()) != null) {
                    if (cOn.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.jUl = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                cOG().mHandler.sendMessageDelayed(cOG().mHandler.obtainMessage(3), cOG().jUd);
            }
            this.jUi = null;
        }
    }

    private void cOE() {
        if (this.jUh != 0) {
            if (this.jUh == 1) {
                g(0L, 0L, 0L);
            } else {
                cOL();
            }
        }
    }

    private void cOF() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b cOG() {
        b bVar;
        synchronized (b.class) {
            if (jUa == null) {
                jUa = new b();
            }
            bVar = jUa;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.jUp);
        h.bup().a(this.IR);
        MessageManager.getInstance().registerListener(1003, this.jCu);
        MessageManager.getInstance().registerListener(1001, this.jCu);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PUSH_COUNT, this.jCu);
        cOH();
    }

    public void cOH() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            CI(socketGetMsgStratgy[0] * 1000);
            CJ(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        cOO();
    }

    public void stop() {
        cOO();
        cOF();
    }

    public void cOI() {
        this.jUd = this.jUc;
    }

    public void cOJ() {
        cOG().jUd = cOG().jUb;
    }

    public void CI(int i) {
        if (i > 0) {
            this.jUc = i;
        }
    }

    public void CJ(int i) {
        if (i > 0) {
            this.jUb = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cOK() {
        if (System.currentTimeMillis() - this.jUk >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.jUj);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.oD().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.oD().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.jUk = System.currentTimeMillis();
            this.jUj = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.cOc().cOn());
        }
        messageSyncMessage.setForTimer(this.jUo);
        LocalViewSize.ImageSize bmt = LocalViewSize.bmr().bmt();
        if (bmt != null) {
            messageSyncMessage.setWidth(bmt.width);
            messageSyncMessage.setHeight(bmt.height);
        }
        LocalViewSize.ImageSize bms = LocalViewSize.bmr().bms();
        if (bms != null) {
            messageSyncMessage.setSmallHeight(bms.height);
            messageSyncMessage.setSmallWidth(bms.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void g(long j, long j2, long j3) {
        c(j, j2, j3, false);
    }

    public synchronized void c(long j, long j2, long j3, boolean z) {
        long longValue;
        this.jUj++;
        this.jUo = false;
        this.jUl = 1;
        this.mHandler.removeMessages(3);
        cOG().mHandler.sendMessageDelayed(cOG().mHandler.obtainMessage(3), cOG().jUd);
        if (this.jUm == null) {
            this.jUm = new LongSparseArray<>();
            this.jUm.clear();
        }
        if (this.jUn == null) {
            this.jUn = new LongSparseArray<>();
        }
        LongSparseArray<Long> cOn = com.baidu.tieba.im.memorycache.b.cOc().cOn();
        if (0 != j) {
            Long l = cOn.get(j);
            Long l2 = this.jUm.get(j);
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
                this.jUm.put(j, Long.valueOf(longValue));
            }
        }
        if (this.jUm != null && this.jUm.size() > 0) {
            for (int i = 0; i < this.jUm.size(); i++) {
                long keyAt = this.jUm.keyAt(i);
                Long l3 = cOn.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.jUm.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.jUn.get(j) == null) {
                    this.jUn.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.jUn.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.jUn.put(j, Long.valueOf(j2));
                }
            }
            int size = this.jUm.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.jUm.keyAt(i2);
                long longValue3 = this.jUm.valueAt(i2).longValue();
                long j4 = 0;
                if (this.jUn.get(keyAt2) != null) {
                    j4 = this.jUn.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.jUm.remove(((Long) it.next()).longValue());
            }
        }
        if (this.jUm.size() == 0) {
            cOO();
            this.jUn.clear();
        } else {
            a(this.jUm, 1);
        }
    }

    public synchronized void cOL() {
        CK(2);
    }

    public synchronized void cOM() {
        CK(3);
    }

    public void cON() {
        cOE();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.jUo = false;
                this.jUl = 4;
                this.mHandler.removeMessages(3);
                cOG().mHandler.sendMessageDelayed(cOG().mHandler.obtainMessage(3), cOG().jUd);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void CK(int i) {
        this.jUo = true;
        this.jUl = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void CL(int i) {
        if (i == 1) {
            if (this.jUh != 2) {
                this.jUh = 1;
            }
        } else if (i == 3 || i == 2) {
            this.jUh = 2;
        }
    }

    private void cOO() {
        this.jUh = 0;
    }
}
