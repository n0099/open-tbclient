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
    private static b dEA;
    private List<GroupUpdateMessage> dEI;
    private boolean dEO;
    private int dEB = 900000;
    private int dEC = 360000;
    private int dED = this.dEC;
    private final int dEE = 0;
    private final int dEF = 1;
    private final int dEG = 2;
    private int dEH = 0;
    private int dEJ = 0;
    private long dEK = 0;
    private int dEL = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dEM = null;
    private SparseArray<Long> dEN = null;
    private final com.baidu.adp.framework.client.socket.link.a oj = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.b.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void d(Map<String, String> map) {
            b.this.start();
            f.cQ().c(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void C(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c doT = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.azv();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dEI = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.ayP().ayO()) {
                            b.this.azo();
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
                    b.this.azu();
                } else {
                    b.this.azt();
                }
            }
        }
    };
    private final CustomMessageListener dEP = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dEM != null) {
                    b.this.dEM.clear();
                }
                if (b.this.dEN != null) {
                    b.this.dEN.clear();
                }
                b.this.dEI = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY) { // from class: com.baidu.tieba.im.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.BY().BZ();
                    b.azr().azs();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.azr().azo();
                }
            }
        });
        dEA = null;
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
                    b.azr().mHandler.removeMessages(2);
                    b.azr().azw();
                    return;
                case 3:
                    b.azr().mHandler.removeMessages(3);
                    if (b.azr().dEL == 3) {
                        b.azr().azx();
                    } else {
                        b.azr().azw();
                    }
                    b.azr().mHandler.sendMessageDelayed(b.azr().mHandler.obtainMessage(3), b.azr().dED);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().cV() > 10) {
            n.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int N = MessageManager.getInstance().getSocketClient().N(202003);
        if (a2 || N > 0) {
            n.d(false, false, true);
            mZ(i);
            return;
        }
        azz();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.ayP().aza());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dEM != null) {
                this.dEM.clear();
            }
            if (this.dEN != null) {
                this.dEN.clear();
            }
        }
    }

    public void azo() {
        boolean z;
        if (this.dEI != null) {
            SparseArray<Long> ayZ = com.baidu.tieba.im.memorycache.b.ayP().ayZ();
            if (ayZ == null) {
                this.dEI = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dEI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && ayZ.get(next.getGroupId()) != null) {
                    if (ayZ.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dEL = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                azr().mHandler.sendMessageDelayed(azr().mHandler.obtainMessage(3), azr().dED);
            }
            this.dEI = null;
        }
    }

    private void azp() {
        if (this.dEH != 0) {
            if (this.dEH == 1) {
                a(0L, 0L, 0L);
            } else {
                azw();
            }
        }
    }

    private void azq() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b azr() {
        b bVar;
        synchronized (b.class) {
            if (dEA == null) {
                dEA = new b();
            }
            bVar = dEA;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dEP);
        g.Cg().a(this.oj);
        MessageManager.getInstance().registerListener(1003, this.doT);
        MessageManager.getInstance().registerListener(1001, this.doT);
        MessageManager.getInstance().registerListener(202101, this.doT);
        azs();
    }

    public void azs() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            mW(socketGetMsgStratgy[0] * 1000);
            mX(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        azz();
    }

    public void stop() {
        azz();
        azq();
    }

    public void azt() {
        this.dED = this.dEC;
    }

    public void azu() {
        azr().dED = azr().dEB;
    }

    public void mW(int i) {
        if (i > 0) {
            this.dEC = i;
        }
    }

    public void mX(int i) {
        if (i > 0) {
            this.dEB = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void azv() {
        if (System.currentTimeMillis() - this.dEK >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dEJ);
            pushCountMessage.setUpFlowSize(h.hV().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hV().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dEK = System.currentTimeMillis();
            this.dEJ = 0;
            h.hV().ic();
            h.hV().ib();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.ayP().ayZ());
        }
        messageSyncMessage.setForTimer(this.dEO);
        LocalViewSize.ImageSize vf = LocalViewSize.vc().vf();
        if (vf != null) {
            messageSyncMessage.setWidth(vf.width);
            messageSyncMessage.setHeight(vf.height);
        }
        LocalViewSize.ImageSize ve = LocalViewSize.vc().ve();
        if (ve != null) {
            messageSyncMessage.setSmallHeight(ve.height);
            messageSyncMessage.setSmallWidth(ve.width);
        }
        String ayv = com.baidu.tieba.im.a.c.ayy().ayv();
        if (ayv == null) {
            ayv = "0";
        }
        messageSyncMessage.setNotifyMaxTime(ayv);
        String ayw = com.baidu.tieba.im.a.c.ayy().ayw();
        if (ayw == null) {
            ayw = "0";
        }
        messageSyncMessage.setNotifyMinTime(ayw);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.ayy().ayD()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dEJ++;
        this.dEO = false;
        this.dEL = 1;
        this.mHandler.removeMessages(3);
        azr().mHandler.sendMessageDelayed(azr().mHandler.obtainMessage(3), azr().dED);
        if (this.dEM == null) {
            this.dEM = new SparseArray<>();
            this.dEM.clear();
        }
        if (this.dEN == null) {
            this.dEN = new SparseArray<>();
        }
        SparseArray<Long> ayZ = com.baidu.tieba.im.memorycache.b.ayP().ayZ();
        if (0 != j) {
            Long l = ayZ.get((int) j);
            Long l2 = this.dEM.get((int) j);
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
                this.dEM.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dEM != null && this.dEM.size() > 0) {
            for (int i = 0; i < this.dEM.size(); i++) {
                int keyAt = this.dEM.keyAt(i);
                Long l3 = ayZ.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dEM.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dEN.get((int) j) == null) {
                    this.dEN.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dEN.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dEN.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dEM.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dEM.keyAt(i2);
                long longValue3 = this.dEM.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dEN.get(keyAt2) != null) {
                    j4 = this.dEN.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dEM.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dEM.size() == 0) {
            azz();
            this.dEN.clear();
        } else {
            a(this.dEM, 1);
        }
    }

    public synchronized void azw() {
        mY(2);
    }

    public synchronized void azx() {
        mY(3);
    }

    public void azy() {
        azp();
    }

    public synchronized void b(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dEO = false;
                this.dEL = 4;
                this.mHandler.removeMessages(3);
                azr().mHandler.sendMessageDelayed(azr().mHandler.obtainMessage(3), azr().dED);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void mY(int i) {
        this.dEO = true;
        this.dEL = i;
        a((SparseArray<Long>) null, i);
    }

    private void mZ(int i) {
        if (i == 1) {
            if (this.dEH != 2) {
                this.dEH = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dEH = 2;
        }
    }

    private void azz() {
        this.dEH = 0;
    }
}
