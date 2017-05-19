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
import com.baidu.tbadk.j.w;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static b cYJ;
    private List<GroupUpdateMessage> cYR;
    private boolean cYX;
    private int cYK = 900000;
    private int cYL = 360000;
    private int cYM = this.cYL;
    private final int cYN = 0;
    private final int cYO = 1;
    private final int cYP = 2;
    private int cYQ = 0;
    private int cYS = 0;
    private long cYT = 0;
    private int cYU = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> cYV = null;
    private SparseArray<Long> cYW = null;
    private final com.baidu.adp.framework.client.socket.link.e oR = new e(this);
    private final com.baidu.adp.framework.listener.e cIY = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener cYY = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        cYJ = null;
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
                    b.aqz().mHandler.removeMessages(2);
                    b.aqz().aqE();
                    return;
                case 3:
                    b.aqz().mHandler.removeMessages(3);
                    if (b.aqz().cYU == 3) {
                        b.aqz().aqF();
                    } else {
                        b.aqz().aqE();
                    }
                    b.aqz().mHandler.sendMessageDelayed(b.aqz().mHandler.obtainMessage(3), b.aqz().cYM);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().cU() > 10) {
            w.b(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int N = MessageManager.getInstance().getSocketClient().N(202003);
        if (a2 || N > 0) {
            w.b(false, false, true);
            lI(i);
            return;
        }
        aqH();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.apX().aqi());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.cYV != null) {
                this.cYV.clear();
            }
            if (this.cYW != null) {
                this.cYW.clear();
            }
        }
    }

    public void aqw() {
        boolean z;
        if (this.cYR != null) {
            SparseArray<Long> aqh = com.baidu.tieba.im.memorycache.b.apX().aqh();
            if (aqh == null) {
                this.cYR = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.cYR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aqh.get(next.getGroupId()) != null) {
                    if (aqh.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.cYU = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aqz().mHandler.sendMessageDelayed(aqz().mHandler.obtainMessage(3), aqz().cYM);
            }
            this.cYR = null;
        }
    }

    private void aqx() {
        if (this.cYQ != 0) {
            if (this.cYQ == 1) {
                a(0L, 0L, 0L);
            } else {
                aqE();
            }
        }
    }

    private void aqy() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aqz() {
        b bVar;
        synchronized (b.class) {
            if (cYJ == null) {
                cYJ = new b();
            }
            bVar = cYJ;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.cYY);
        n.BE().a(this.oR);
        MessageManager.getInstance().registerListener(1003, this.cIY);
        MessageManager.getInstance().registerListener(1001, this.cIY);
        MessageManager.getInstance().registerListener(202101, this.cIY);
        aqA();
    }

    public void aqA() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lF(socketGetMsgStratgy[0] * 1000);
            lG(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aqH();
    }

    public void stop() {
        aqH();
        aqy();
    }

    public void aqB() {
        this.cYM = this.cYL;
    }

    public void aqC() {
        aqz().cYM = aqz().cYK;
    }

    public void lF(int i) {
        if (i > 0) {
            this.cYL = i;
        }
    }

    public void lG(int i) {
        if (i > 0) {
            this.cYK = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aqD() {
        if (System.currentTimeMillis() - this.cYT >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.cYS);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hX().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hX().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.cYT = System.currentTimeMillis();
            this.cYS = 0;
            com.baidu.adp.lib.webSocket.h.hX().id();
            com.baidu.adp.lib.webSocket.h.hX().ic();
            TbadkCoreApplication.m9getInst().clearEnterForeCount();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.apX().aqh());
        }
        messageSyncMessage.setForTimer(this.cYX);
        LocalViewSize.ImageSize uF = LocalViewSize.uC().uF();
        if (uF != null) {
            messageSyncMessage.setWidth(uF.width);
            messageSyncMessage.setHeight(uF.height);
        }
        LocalViewSize.ImageSize uE = LocalViewSize.uC().uE();
        if (uE != null) {
            messageSyncMessage.setSmallHeight(uE.height);
            messageSyncMessage.setSmallWidth(uE.width);
        }
        String apD = com.baidu.tieba.im.a.c.apG().apD();
        if (apD == null) {
            apD = "0";
        }
        messageSyncMessage.setNotifyMaxTime(apD);
        String apE = com.baidu.tieba.im.a.c.apG().apE();
        if (apE == null) {
            apE = "0";
        }
        messageSyncMessage.setNotifyMinTime(apE);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.apG().apL()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.cYS++;
        this.cYX = false;
        this.cYU = 1;
        this.mHandler.removeMessages(3);
        aqz().mHandler.sendMessageDelayed(aqz().mHandler.obtainMessage(3), aqz().cYM);
        if (this.cYV == null) {
            this.cYV = new SparseArray<>();
            this.cYV.clear();
        }
        if (this.cYW == null) {
            this.cYW = new SparseArray<>();
        }
        SparseArray<Long> aqh = com.baidu.tieba.im.memorycache.b.apX().aqh();
        if (0 != j) {
            Long l = aqh.get((int) j);
            Long l2 = this.cYV.get((int) j);
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
                this.cYV.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.cYV != null && this.cYV.size() > 0) {
            for (int i = 0; i < this.cYV.size(); i++) {
                int keyAt = this.cYV.keyAt(i);
                Long l3 = aqh.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.cYV.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.cYW.get((int) j) == null) {
                    this.cYW.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.cYW.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.cYW.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.cYV.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.cYV.keyAt(i2);
                long longValue3 = this.cYV.valueAt(i2).longValue();
                long j4 = 0;
                if (this.cYW.get(keyAt2) != null) {
                    j4 = this.cYW.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.cYV.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.cYV.size() == 0) {
            aqH();
            this.cYW.clear();
        } else {
            a(this.cYV, 1);
        }
    }

    public synchronized void aqE() {
        lH(2);
    }

    public synchronized void aqF() {
        lH(3);
    }

    public void aqG() {
        aqx();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.cYX = false;
                this.cYU = 4;
                this.mHandler.removeMessages(3);
                aqz().mHandler.sendMessageDelayed(aqz().mHandler.obtainMessage(3), aqz().cYM);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lH(int i) {
        this.cYX = true;
        this.cYU = i;
        a((SparseArray<Long>) null, i);
    }

    private void lI(int i) {
        if (i == 1) {
            if (this.cYQ != 2) {
                this.cYQ = 1;
            }
        } else if (i == 3 || i == 2) {
            this.cYQ = 2;
        }
    }

    private void aqH() {
        this.cYQ = 0;
    }
}
