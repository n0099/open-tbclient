package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.websocketBase.n;
import com.baidu.tbadk.performanceLog.w;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static b cWH;
    private List<GroupUpdateMessage> cWP;
    private boolean cWV;
    private int cWI = 900000;
    private int cWJ = 360000;
    private int cWK = this.cWJ;
    private final int cWL = 0;
    private final int cWM = 1;
    private final int cWN = 2;
    private int cWO = 0;
    private int cWQ = 0;
    private long cWR = 0;
    private int cWS = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> cWT = null;
    private SparseArray<Long> cWU = null;
    private final com.baidu.adp.framework.client.socket.link.e fm = new e(this);
    private final com.baidu.adp.framework.listener.e bYf = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener cWW = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        cWH = null;
    }

    /* loaded from: classes.dex */
    private static class a extends Handler {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 2:
                    b.aqB().mHandler.removeMessages(2);
                    b.aqB().aqG();
                    return;
                case 3:
                    b.aqB().mHandler.removeMessages(3);
                    if (b.aqB().cWS == 3) {
                        b.aqB().aqH();
                    } else {
                        b.aqB().aqG();
                    }
                    b.aqB().mHandler.sendMessageDelayed(b.aqB().mHandler.obtainMessage(3), b.aqB().cWK);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().aR() > 10) {
            w.b(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int B = MessageManager.getInstance().getSocketClient().B(202003);
        if (a2 || B > 0) {
            w.b(false, false, true);
            li(i);
            return;
        }
        aqJ();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.apZ().aqk());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.cWT != null) {
                this.cWT.clear();
            }
            if (this.cWU != null) {
                this.cWU.clear();
            }
        }
    }

    public void aqy() {
        boolean z;
        if (this.cWP != null) {
            SparseArray<Long> aqj = com.baidu.tieba.im.memorycache.b.apZ().aqj();
            if (aqj == null) {
                this.cWP = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.cWP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aqj.get(next.getGroupId()) != null) {
                    if (aqj.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.cWS = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aqB().mHandler.sendMessageDelayed(aqB().mHandler.obtainMessage(3), aqB().cWK);
            }
            this.cWP = null;
        }
    }

    private void aqz() {
        if (this.cWO != 0) {
            if (this.cWO == 1) {
                a(0L, 0L, 0L);
            } else {
                aqG();
            }
        }
    }

    private void aqA() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aqB() {
        b bVar;
        synchronized (b.class) {
            if (cWH == null) {
                cWH = new b();
            }
            bVar = cWH;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.cWW);
        n.Au().a(this.fm);
        MessageManager.getInstance().registerListener(1003, this.bYf);
        MessageManager.getInstance().registerListener(1001, this.bYf);
        MessageManager.getInstance().registerListener(202101, this.bYf);
        aqC();
    }

    public void aqC() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m10getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lf(socketGetMsgStratgy[0] * 1000);
            lg(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aqJ();
    }

    public void stop() {
        aqJ();
        aqA();
    }

    public void aqD() {
        this.cWK = this.cWJ;
    }

    public void aqE() {
        aqB().cWK = aqB().cWI;
    }

    public void lf(int i) {
        if (i > 0) {
            this.cWJ = i;
        }
    }

    public void lg(int i) {
        if (i > 0) {
            this.cWI = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aqF() {
        if (System.currentTimeMillis() - this.cWR >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.cWQ);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.gf().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.gf().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m10getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.cWR = System.currentTimeMillis();
            this.cWQ = 0;
            com.baidu.adp.lib.webSocket.h.gf().gm();
            com.baidu.adp.lib.webSocket.h.gf().gl();
            TbadkCoreApplication.m10getInst().clearEnterForeCount();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.apZ().aqj());
        }
        messageSyncMessage.setForTimer(this.cWV);
        LocalViewSize.ImageSize tt = LocalViewSize.tq().tt();
        if (tt != null) {
            messageSyncMessage.setWidth(tt.width);
            messageSyncMessage.setHeight(tt.height);
        }
        LocalViewSize.ImageSize ts = LocalViewSize.tq().ts();
        if (ts != null) {
            messageSyncMessage.setSmallHeight(ts.height);
            messageSyncMessage.setSmallWidth(ts.width);
        }
        String apF = com.baidu.tieba.im.a.c.apI().apF();
        if (apF == null) {
            apF = "0";
        }
        messageSyncMessage.setNotifyMaxTime(apF);
        String apG = com.baidu.tieba.im.a.c.apI().apG();
        if (apG == null) {
            apG = "0";
        }
        messageSyncMessage.setNotifyMinTime(apG);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.apI().apN()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.cWQ++;
        this.cWV = false;
        this.cWS = 1;
        this.mHandler.removeMessages(3);
        aqB().mHandler.sendMessageDelayed(aqB().mHandler.obtainMessage(3), aqB().cWK);
        if (this.cWT == null) {
            this.cWT = new SparseArray<>();
            this.cWT.clear();
        }
        if (this.cWU == null) {
            this.cWU = new SparseArray<>();
        }
        SparseArray<Long> aqj = com.baidu.tieba.im.memorycache.b.apZ().aqj();
        if (0 != j) {
            Long l = aqj.get((int) j);
            Long l2 = this.cWT.get((int) j);
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
                this.cWT.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.cWT != null && this.cWT.size() > 0) {
            for (int i = 0; i < this.cWT.size(); i++) {
                int keyAt = this.cWT.keyAt(i);
                Long l3 = aqj.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.cWT.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.cWU.get((int) j) == null) {
                    this.cWU.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.cWU.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.cWU.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.cWT.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.cWT.keyAt(i2);
                long longValue3 = this.cWT.valueAt(i2).longValue();
                long j4 = 0;
                if (this.cWU.get(keyAt2) != null) {
                    j4 = this.cWU.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.cWT.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.cWT.size() == 0) {
            aqJ();
            this.cWU.clear();
        } else {
            a(this.cWT, 1);
        }
    }

    public synchronized void aqG() {
        lh(2);
    }

    public synchronized void aqH() {
        lh(3);
    }

    public void aqI() {
        aqz();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.cWV = false;
                this.cWS = 4;
                this.mHandler.removeMessages(3);
                aqB().mHandler.sendMessageDelayed(aqB().mHandler.obtainMessage(3), aqB().cWK);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lh(int i) {
        this.cWV = true;
        this.cWS = i;
        a((SparseArray<Long>) null, i);
    }

    private void li(int i) {
        if (i == 1) {
            if (this.cWO != 2) {
                this.cWO = 1;
            }
        } else if (i == 3 || i == 2) {
            this.cWO = 2;
        }
    }

    private void aqJ() {
        this.cWO = 0;
    }
}
