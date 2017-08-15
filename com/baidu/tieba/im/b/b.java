package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.f;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.webSocket.h;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.coreExtra.websocketBase.g;
import com.baidu.tbadk.l.n;
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
    private static b dxX;
    private List<GroupUpdateMessage> dyf;
    private boolean dyl;
    private int dxY = 900000;
    private int dxZ = 360000;
    private int dya = this.dxZ;
    private final int dyb = 0;
    private final int dyc = 1;
    private final int dyd = 2;
    private int dye = 0;
    private int dyg = 0;
    private long dyh = 0;
    private int dyi = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dyj = null;
    private SparseArray<Long> dyk = null;
    private final com.baidu.adp.framework.client.socket.link.a qB = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.b.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void e(Map<String, String> map) {
            b.this.start();
            f.da().d(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void I(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c dip = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.axL();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dyf = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.axf().axe()) {
                            b.this.axE();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.b.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    b.this.axK();
                } else {
                    b.this.axJ();
                }
            }
        }
    };
    private final CustomMessageListener dym = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dyj != null) {
                    b.this.dyj.clear();
                }
                if (b.this.dyk != null) {
                    b.this.dyk.clear();
                }
                b.this.dyf = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.Cd().Ce();
                    b.axH().axI();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.axH().axE();
                }
            }
        });
        dxX = null;
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
                    b.axH().mHandler.removeMessages(2);
                    b.axH().axM();
                    return;
                case 3:
                    b.axH().mHandler.removeMessages(3);
                    if (b.axH().dyi == 3) {
                        b.axH().axN();
                    } else {
                        b.axH().axM();
                    }
                    b.axH().mHandler.sendMessageDelayed(b.axH().mHandler.obtainMessage(3), b.axH().dya);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().df() > 10) {
            n.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int Q = MessageManager.getInstance().getSocketClient().Q(202003);
        if (a2 || Q > 0) {
            n.d(false, false, true);
            mG(i);
            return;
        }
        axP();
        SparseArray<Long> sparseArray2 = null;
        if (sparseArray != null && sparseArray.size() > 0) {
            SparseArray<Long> sparseArray3 = new SparseArray<>();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                sparseArray3.put(keyAt, sparseArray.get(keyAt));
            }
            sparseArray2 = sparseArray3;
        }
        MessageSyncMessage b = b(sparseArray2, i);
        if (i == 3 || i == 2) {
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.axf().axq());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dyj != null) {
                this.dyj.clear();
            }
            if (this.dyk != null) {
                this.dyk.clear();
            }
        }
    }

    public void axE() {
        boolean z;
        if (this.dyf != null) {
            SparseArray<Long> axp = com.baidu.tieba.im.memorycache.b.axf().axp();
            if (axp == null) {
                this.dyf = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dyf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && axp.get(next.getGroupId()) != null) {
                    if (axp.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dyi = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                axH().mHandler.sendMessageDelayed(axH().mHandler.obtainMessage(3), axH().dya);
            }
            this.dyf = null;
        }
    }

    private void axF() {
        if (this.dye != 0) {
            if (this.dye == 1) {
                a(0L, 0L, 0L);
            } else {
                axM();
            }
        }
    }

    private void axG() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b axH() {
        b bVar;
        synchronized (b.class) {
            if (dxX == null) {
                dxX = new b();
            }
            bVar = dxX;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dym);
        g.Cl().a(this.qB);
        MessageManager.getInstance().registerListener(1003, this.dip);
        MessageManager.getInstance().registerListener(1001, this.dip);
        MessageManager.getInstance().registerListener(202101, this.dip);
        axI();
    }

    public void axI() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            mD(socketGetMsgStratgy[0] * 1000);
            mE(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        axP();
    }

    public void stop() {
        axP();
        axG();
    }

    public void axJ() {
        this.dya = this.dxZ;
    }

    public void axK() {
        axH().dya = axH().dxY;
    }

    public void mD(int i) {
        if (i > 0) {
            this.dxZ = i;
        }
    }

    public void mE(int i) {
        if (i > 0) {
            this.dxY = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void axL() {
        if (System.currentTimeMillis() - this.dyh >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dyg);
            pushCountMessage.setUpFlowSize(h.ie().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.ie().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dyh = System.currentTimeMillis();
            this.dyg = 0;
            h.ie().ik();
            h.ie().ij();
            TbadkCoreApplication.getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(SparseArray<Long> sparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
            NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(sparseArray);
            if (makeNewpushRepair != null) {
                messageSyncMessage.setNewpushRepire(makeNewpushRepair);
            }
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.axf().axp());
        }
        messageSyncMessage.setForTimer(this.dyl);
        LocalViewSize.ImageSize vh = LocalViewSize.ve().vh();
        if (vh != null) {
            messageSyncMessage.setWidth(vh.width);
            messageSyncMessage.setHeight(vh.height);
        }
        LocalViewSize.ImageSize vg = LocalViewSize.ve().vg();
        if (vg != null) {
            messageSyncMessage.setSmallHeight(vg.height);
            messageSyncMessage.setSmallWidth(vg.width);
        }
        String awL = com.baidu.tieba.im.a.c.awO().awL();
        if (awL == null) {
            awL = "0";
        }
        messageSyncMessage.setNotifyMaxTime(awL);
        String awM = com.baidu.tieba.im.a.c.awO().awM();
        if (awM == null) {
            awM = "0";
        }
        messageSyncMessage.setNotifyMinTime(awM);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.awO().awT()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dyg++;
        this.dyl = false;
        this.dyi = 1;
        this.mHandler.removeMessages(3);
        axH().mHandler.sendMessageDelayed(axH().mHandler.obtainMessage(3), axH().dya);
        if (this.dyj == null) {
            this.dyj = new SparseArray<>();
            this.dyj.clear();
        }
        if (this.dyk == null) {
            this.dyk = new SparseArray<>();
        }
        SparseArray<Long> axp = com.baidu.tieba.im.memorycache.b.axf().axp();
        if (0 != j) {
            Long l = axp.get((int) j);
            Long l2 = this.dyj.get((int) j);
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
                this.dyj.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dyj != null && this.dyj.size() > 0) {
            for (int i = 0; i < this.dyj.size(); i++) {
                int keyAt = this.dyj.keyAt(i);
                Long l3 = axp.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dyj.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dyk.get((int) j) == null) {
                    this.dyk.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dyk.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dyk.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dyj.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dyj.keyAt(i2);
                long longValue3 = this.dyj.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dyk.get(keyAt2) != null) {
                    j4 = this.dyk.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dyj.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dyj.size() == 0) {
            axP();
            this.dyk.clear();
        } else {
            a(this.dyj, 1);
        }
    }

    public synchronized void axM() {
        mF(2);
    }

    public synchronized void axN() {
        mF(3);
    }

    public void axO() {
        axF();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dyl = false;
                this.dyi = 4;
                this.mHandler.removeMessages(3);
                axH().mHandler.sendMessageDelayed(axH().mHandler.obtainMessage(3), axH().dya);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void mF(int i) {
        this.dyl = true;
        this.dyi = i;
        a((SparseArray<Long>) null, i);
    }

    private void mG(int i) {
        if (i == 1) {
            if (this.dye != 2) {
                this.dye = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dye = 2;
        }
    }

    private void axP() {
        this.dye = 0;
    }
}
