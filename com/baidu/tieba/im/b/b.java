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
    private final com.baidu.adp.framework.client.socket.link.a qC = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.b.b.3
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
        public void J(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c dip = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.axG();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dyf = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.axa().awZ()) {
                            b.this.axz();
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
                    b.this.axF();
                } else {
                    b.this.axE();
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
                    b.axC().axD();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.axC().axz();
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
                    b.axC().mHandler.removeMessages(2);
                    b.axC().axH();
                    return;
                case 3:
                    b.axC().mHandler.removeMessages(3);
                    if (b.axC().dyi == 3) {
                        b.axC().axI();
                    } else {
                        b.axC().axH();
                    }
                    b.axC().mHandler.sendMessageDelayed(b.axC().mHandler.obtainMessage(3), b.axC().dya);
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
        axK();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.axa().axl());
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

    public void axz() {
        boolean z;
        if (this.dyf != null) {
            SparseArray<Long> axk = com.baidu.tieba.im.memorycache.b.axa().axk();
            if (axk == null) {
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
                if (next != null && axk.get(next.getGroupId()) != null) {
                    if (axk.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dyi = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                axC().mHandler.sendMessageDelayed(axC().mHandler.obtainMessage(3), axC().dya);
            }
            this.dyf = null;
        }
    }

    private void axA() {
        if (this.dye != 0) {
            if (this.dye == 1) {
                a(0L, 0L, 0L);
            } else {
                axH();
            }
        }
    }

    private void axB() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b axC() {
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
        g.Cl().a(this.qC);
        MessageManager.getInstance().registerListener(1003, this.dip);
        MessageManager.getInstance().registerListener(1001, this.dip);
        MessageManager.getInstance().registerListener(202101, this.dip);
        axD();
    }

    public void axD() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            mD(socketGetMsgStratgy[0] * 1000);
            mE(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        axK();
    }

    public void stop() {
        axK();
        axB();
    }

    public void axE() {
        this.dya = this.dxZ;
    }

    public void axF() {
        axC().dya = axC().dxY;
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
    public synchronized void axG() {
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.axa().axk());
        }
        messageSyncMessage.setForTimer(this.dyl);
        LocalViewSize.ImageSize vi = LocalViewSize.vf().vi();
        if (vi != null) {
            messageSyncMessage.setWidth(vi.width);
            messageSyncMessage.setHeight(vi.height);
        }
        LocalViewSize.ImageSize vh = LocalViewSize.vf().vh();
        if (vh != null) {
            messageSyncMessage.setSmallHeight(vh.height);
            messageSyncMessage.setSmallWidth(vh.width);
        }
        String awG = com.baidu.tieba.im.a.c.awJ().awG();
        if (awG == null) {
            awG = "0";
        }
        messageSyncMessage.setNotifyMaxTime(awG);
        String awH = com.baidu.tieba.im.a.c.awJ().awH();
        if (awH == null) {
            awH = "0";
        }
        messageSyncMessage.setNotifyMinTime(awH);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.awJ().awO()));
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
        axC().mHandler.sendMessageDelayed(axC().mHandler.obtainMessage(3), axC().dya);
        if (this.dyj == null) {
            this.dyj = new SparseArray<>();
            this.dyj.clear();
        }
        if (this.dyk == null) {
            this.dyk = new SparseArray<>();
        }
        SparseArray<Long> axk = com.baidu.tieba.im.memorycache.b.axa().axk();
        if (0 != j) {
            Long l = axk.get((int) j);
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
                Long l3 = axk.get(keyAt);
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
            axK();
            this.dyk.clear();
        } else {
            a(this.dyj, 1);
        }
    }

    public synchronized void axH() {
        mF(2);
    }

    public synchronized void axI() {
        mF(3);
    }

    public void axJ() {
        axA();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dyl = false;
                this.dyi = 4;
                this.mHandler.removeMessages(3);
                axC().mHandler.sendMessageDelayed(axC().mHandler.obtainMessage(3), axC().dya);
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

    private void axK() {
        this.dye = 0;
    }
}
