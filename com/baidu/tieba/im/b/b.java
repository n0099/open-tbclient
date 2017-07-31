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
    private static b dwa;
    private List<GroupUpdateMessage> dwi;
    private boolean dwo;
    private int dwb = 900000;
    private int dwc = 360000;
    private int dwd = this.dwc;
    private final int dwe = 0;
    private final int dwf = 1;
    private final int dwg = 2;
    private int dwh = 0;
    private int dwj = 0;
    private long dwk = 0;
    private int dwl = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private SparseArray<Long> dwm = null;
    private SparseArray<Long> dwn = null;
    private final com.baidu.adp.framework.client.socket.link.a qz = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.b.b.3
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
    private final com.baidu.adp.framework.listener.c dgs = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.axe();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.dwi = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.awy().awx()) {
                            b.this.awX();
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
                    b.this.axd();
                } else {
                    b.this.axc();
                }
            }
        }
    };
    private final CustomMessageListener dwp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.dwm != null) {
                    b.this.dwm.clear();
                }
                if (b.this.dwn != null) {
                    b.this.dwn.clear();
                }
                b.this.dwi = null;
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
                    b.axa().axb();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MEMORY_INIT_COMPLETED) { // from class: com.baidu.tieba.im.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.axa().awX();
                }
            }
        });
        dwa = null;
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
                    b.axa().mHandler.removeMessages(2);
                    b.axa().axf();
                    return;
                case 3:
                    b.axa().mHandler.removeMessages(3);
                    if (b.axa().dwl == 3) {
                        b.axa().axg();
                    } else {
                        b.axa().axf();
                    }
                    b.axa().mHandler.sendMessageDelayed(b.axa().mHandler.obtainMessage(3), b.axa().dwd);
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
            mw(i);
            return;
        }
        axi();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.awy().awJ());
        }
        MessageManager.getInstance().sendMessage(b);
        n.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dwm != null) {
                this.dwm.clear();
            }
            if (this.dwn != null) {
                this.dwn.clear();
            }
        }
    }

    public void awX() {
        boolean z;
        if (this.dwi != null) {
            SparseArray<Long> awI = com.baidu.tieba.im.memorycache.b.awy().awI();
            if (awI == null) {
                this.dwi = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dwi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && awI.get(next.getGroupId()) != null) {
                    if (awI.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dwl = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                axa().mHandler.sendMessageDelayed(axa().mHandler.obtainMessage(3), axa().dwd);
            }
            this.dwi = null;
        }
    }

    private void awY() {
        if (this.dwh != 0) {
            if (this.dwh == 1) {
                a(0L, 0L, 0L);
            } else {
                axf();
            }
        }
    }

    private void awZ() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b axa() {
        b bVar;
        synchronized (b.class) {
            if (dwa == null) {
                dwa = new b();
            }
            bVar = dwa;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dwp);
        g.Cl().a(this.qz);
        MessageManager.getInstance().registerListener(1003, this.dgs);
        MessageManager.getInstance().registerListener(1001, this.dgs);
        MessageManager.getInstance().registerListener(202101, this.dgs);
        axb();
    }

    public void axb() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            mt(socketGetMsgStratgy[0] * 1000);
            mu(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        axi();
    }

    public void stop() {
        axi();
        awZ();
    }

    public void axc() {
        this.dwd = this.dwc;
    }

    public void axd() {
        axa().dwd = axa().dwb;
    }

    public void mt(int i) {
        if (i > 0) {
            this.dwc = i;
        }
    }

    public void mu(int i) {
        if (i > 0) {
            this.dwb = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void axe() {
        if (System.currentTimeMillis() - this.dwk >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dwj);
            pushCountMessage.setUpFlowSize(h.ie().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.ie().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dwk = System.currentTimeMillis();
            this.dwj = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.awy().awI());
        }
        messageSyncMessage.setForTimer(this.dwo);
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
        String awe = com.baidu.tieba.im.a.c.awh().awe();
        if (awe == null) {
            awe = "0";
        }
        messageSyncMessage.setNotifyMaxTime(awe);
        String awf = com.baidu.tieba.im.a.c.awh().awf();
        if (awf == null) {
            awf = "0";
        }
        messageSyncMessage.setNotifyMinTime(awf);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.awh().awm()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dwj++;
        this.dwo = false;
        this.dwl = 1;
        this.mHandler.removeMessages(3);
        axa().mHandler.sendMessageDelayed(axa().mHandler.obtainMessage(3), axa().dwd);
        if (this.dwm == null) {
            this.dwm = new SparseArray<>();
            this.dwm.clear();
        }
        if (this.dwn == null) {
            this.dwn = new SparseArray<>();
        }
        SparseArray<Long> awI = com.baidu.tieba.im.memorycache.b.awy().awI();
        if (0 != j) {
            Long l = awI.get((int) j);
            Long l2 = this.dwm.get((int) j);
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
                this.dwm.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dwm != null && this.dwm.size() > 0) {
            for (int i = 0; i < this.dwm.size(); i++) {
                int keyAt = this.dwm.keyAt(i);
                Long l3 = awI.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dwm.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dwn.get((int) j) == null) {
                    this.dwn.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dwn.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dwn.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dwm.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dwm.keyAt(i2);
                long longValue3 = this.dwm.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dwn.get(keyAt2) != null) {
                    j4 = this.dwn.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dwm.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dwm.size() == 0) {
            axi();
            this.dwn.clear();
        } else {
            a(this.dwm, 1);
        }
    }

    public synchronized void axf() {
        mv(2);
    }

    public synchronized void axg() {
        mv(3);
    }

    public void axh() {
        awY();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dwo = false;
                this.dwl = 4;
                this.mHandler.removeMessages(3);
                axa().mHandler.sendMessageDelayed(axa().mHandler.obtainMessage(3), axa().dwd);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void mv(int i) {
        this.dwo = true;
        this.dwl = i;
        a((SparseArray<Long>) null, i);
    }

    private void mw(int i) {
        if (i == 1) {
            if (this.dwh != 2) {
                this.dwh = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dwh = 2;
        }
    }

    private void axi() {
        this.dwh = 0;
    }
}
