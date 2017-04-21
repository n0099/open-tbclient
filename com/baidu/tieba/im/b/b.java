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
    private static b deK;
    private List<GroupUpdateMessage> deS;
    private boolean deY;
    private int deL = 900000;
    private int deM = 360000;
    private int deN = this.deM;
    private final int deO = 0;
    private final int deP = 1;
    private final int deQ = 2;
    private int deR = 0;
    private int deT = 0;
    private long deU = 0;
    private int deV = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> deW = null;
    private SparseArray<Long> deX = null;
    private final com.baidu.adp.framework.client.socket.link.e oQ = new e(this);
    private final com.baidu.adp.framework.listener.e cOV = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener deZ = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        deK = null;
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
                    b.atF().mHandler.removeMessages(2);
                    b.atF().atK();
                    return;
                case 3:
                    b.atF().mHandler.removeMessages(3);
                    if (b.atF().deV == 3) {
                        b.atF().atL();
                    } else {
                        b.atF().atK();
                    }
                    b.atF().mHandler.sendMessageDelayed(b.atF().mHandler.obtainMessage(3), b.atF().deN);
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
            lV(i);
            return;
        }
        atN();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.atd().ato());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.deW != null) {
                this.deW.clear();
            }
            if (this.deX != null) {
                this.deX.clear();
            }
        }
    }

    public void atC() {
        boolean z;
        if (this.deS != null) {
            SparseArray<Long> atn = com.baidu.tieba.im.memorycache.b.atd().atn();
            if (atn == null) {
                this.deS = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.deS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && atn.get(next.getGroupId()) != null) {
                    if (atn.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.deV = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                atF().mHandler.sendMessageDelayed(atF().mHandler.obtainMessage(3), atF().deN);
            }
            this.deS = null;
        }
    }

    private void atD() {
        if (this.deR != 0) {
            if (this.deR == 1) {
                a(0L, 0L, 0L);
            } else {
                atK();
            }
        }
    }

    private void atE() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b atF() {
        b bVar;
        synchronized (b.class) {
            if (deK == null) {
                deK = new b();
            }
            bVar = deK;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.deZ);
        n.Ct().a(this.oQ);
        MessageManager.getInstance().registerListener(1003, this.cOV);
        MessageManager.getInstance().registerListener(1001, this.cOV);
        MessageManager.getInstance().registerListener(202101, this.cOV);
        atG();
    }

    public void atG() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lS(socketGetMsgStratgy[0] * 1000);
            lT(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        atN();
    }

    public void stop() {
        atN();
        atE();
    }

    public void atH() {
        this.deN = this.deM;
    }

    public void atI() {
        atF().deN = atF().deL;
    }

    public void lS(int i) {
        if (i > 0) {
            this.deM = i;
        }
    }

    public void lT(int i) {
        if (i > 0) {
            this.deL = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void atJ() {
        if (System.currentTimeMillis() - this.deU >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.deT);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hY().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hY().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.deU = System.currentTimeMillis();
            this.deT = 0;
            com.baidu.adp.lib.webSocket.h.hY().ie();
            com.baidu.adp.lib.webSocket.h.hY().id();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.atd().atn());
        }
        messageSyncMessage.setForTimer(this.deY);
        LocalViewSize.ImageSize vs = LocalViewSize.vp().vs();
        if (vs != null) {
            messageSyncMessage.setWidth(vs.width);
            messageSyncMessage.setHeight(vs.height);
        }
        LocalViewSize.ImageSize vr = LocalViewSize.vp().vr();
        if (vr != null) {
            messageSyncMessage.setSmallHeight(vr.height);
            messageSyncMessage.setSmallWidth(vr.width);
        }
        String asJ = com.baidu.tieba.im.a.c.asM().asJ();
        if (asJ == null) {
            asJ = "0";
        }
        messageSyncMessage.setNotifyMaxTime(asJ);
        String asK = com.baidu.tieba.im.a.c.asM().asK();
        if (asK == null) {
            asK = "0";
        }
        messageSyncMessage.setNotifyMinTime(asK);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.asM().asR()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.deT++;
        this.deY = false;
        this.deV = 1;
        this.mHandler.removeMessages(3);
        atF().mHandler.sendMessageDelayed(atF().mHandler.obtainMessage(3), atF().deN);
        if (this.deW == null) {
            this.deW = new SparseArray<>();
            this.deW.clear();
        }
        if (this.deX == null) {
            this.deX = new SparseArray<>();
        }
        SparseArray<Long> atn = com.baidu.tieba.im.memorycache.b.atd().atn();
        if (0 != j) {
            Long l = atn.get((int) j);
            Long l2 = this.deW.get((int) j);
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
                this.deW.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.deW != null && this.deW.size() > 0) {
            for (int i = 0; i < this.deW.size(); i++) {
                int keyAt = this.deW.keyAt(i);
                Long l3 = atn.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.deW.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.deX.get((int) j) == null) {
                    this.deX.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.deX.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.deX.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.deW.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.deW.keyAt(i2);
                long longValue3 = this.deW.valueAt(i2).longValue();
                long j4 = 0;
                if (this.deX.get(keyAt2) != null) {
                    j4 = this.deX.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.deW.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.deW.size() == 0) {
            atN();
            this.deX.clear();
        } else {
            a(this.deW, 1);
        }
    }

    public synchronized void atK() {
        lU(2);
    }

    public synchronized void atL() {
        lU(3);
    }

    public void atM() {
        atD();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.deY = false;
                this.deV = 4;
                this.mHandler.removeMessages(3);
                atF().mHandler.sendMessageDelayed(atF().mHandler.obtainMessage(3), atF().deN);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lU(int i) {
        this.deY = true;
        this.deV = i;
        a((SparseArray<Long>) null, i);
    }

    private void lV(int i) {
        if (i == 1) {
            if (this.deR != 2) {
                this.deR = 1;
            }
        } else if (i == 3 || i == 2) {
            this.deR = 2;
        }
    }

    private void atN() {
        this.deR = 0;
    }
}
