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
    private static b dcq;
    private boolean dcF;
    private List<GroupUpdateMessage> dcz;
    private int dcr = 900000;
    private int dcs = 360000;
    private int dct = this.dcs;
    private final int dcv = 0;
    private final int dcw = 1;
    private final int dcx = 2;
    private int dcy = 0;
    private int dcA = 0;
    private long dcB = 0;
    private int dcC = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> dcD = null;
    private SparseArray<Long> dcE = null;
    private final com.baidu.adp.framework.client.socket.link.e oQ = new e(this);
    private final com.baidu.adp.framework.listener.e cME = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener dcG = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        dcq = null;
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
                    b.asE().mHandler.removeMessages(2);
                    b.asE().asJ();
                    return;
                case 3:
                    b.asE().mHandler.removeMessages(3);
                    if (b.asE().dcC == 3) {
                        b.asE().asK();
                    } else {
                        b.asE().asJ();
                    }
                    b.asE().mHandler.sendMessageDelayed(b.asE().mHandler.obtainMessage(3), b.asE().dct);
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
            lP(i);
            return;
        }
        asM();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.asc().asn());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dcD != null) {
                this.dcD.clear();
            }
            if (this.dcE != null) {
                this.dcE.clear();
            }
        }
    }

    public void asB() {
        boolean z;
        if (this.dcz != null) {
            SparseArray<Long> asm = com.baidu.tieba.im.memorycache.b.asc().asm();
            if (asm == null) {
                this.dcz = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dcz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && asm.get(next.getGroupId()) != null) {
                    if (asm.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dcC = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                asE().mHandler.sendMessageDelayed(asE().mHandler.obtainMessage(3), asE().dct);
            }
            this.dcz = null;
        }
    }

    private void asC() {
        if (this.dcy != 0) {
            if (this.dcy == 1) {
                a(0L, 0L, 0L);
            } else {
                asJ();
            }
        }
    }

    private void asD() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b asE() {
        b bVar;
        synchronized (b.class) {
            if (dcq == null) {
                dcq = new b();
            }
            bVar = dcq;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dcG);
        n.Ct().a(this.oQ);
        MessageManager.getInstance().registerListener(1003, this.cME);
        MessageManager.getInstance().registerListener(1001, this.cME);
        MessageManager.getInstance().registerListener(202101, this.cME);
        asF();
    }

    public void asF() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lM(socketGetMsgStratgy[0] * 1000);
            lN(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        asM();
    }

    public void stop() {
        asM();
        asD();
    }

    public void asG() {
        this.dct = this.dcs;
    }

    public void asH() {
        asE().dct = asE().dcr;
    }

    public void lM(int i) {
        if (i > 0) {
            this.dcs = i;
        }
    }

    public void lN(int i) {
        if (i > 0) {
            this.dcr = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void asI() {
        if (System.currentTimeMillis() - this.dcB >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dcA);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hX().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hX().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dcB = System.currentTimeMillis();
            this.dcA = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.asc().asm());
        }
        messageSyncMessage.setForTimer(this.dcF);
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
        String arI = com.baidu.tieba.im.a.c.arL().arI();
        if (arI == null) {
            arI = "0";
        }
        messageSyncMessage.setNotifyMaxTime(arI);
        String arJ = com.baidu.tieba.im.a.c.arL().arJ();
        if (arJ == null) {
            arJ = "0";
        }
        messageSyncMessage.setNotifyMinTime(arJ);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.arL().arQ()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dcA++;
        this.dcF = false;
        this.dcC = 1;
        this.mHandler.removeMessages(3);
        asE().mHandler.sendMessageDelayed(asE().mHandler.obtainMessage(3), asE().dct);
        if (this.dcD == null) {
            this.dcD = new SparseArray<>();
            this.dcD.clear();
        }
        if (this.dcE == null) {
            this.dcE = new SparseArray<>();
        }
        SparseArray<Long> asm = com.baidu.tieba.im.memorycache.b.asc().asm();
        if (0 != j) {
            Long l = asm.get((int) j);
            Long l2 = this.dcD.get((int) j);
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
                this.dcD.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dcD != null && this.dcD.size() > 0) {
            for (int i = 0; i < this.dcD.size(); i++) {
                int keyAt = this.dcD.keyAt(i);
                Long l3 = asm.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dcD.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dcE.get((int) j) == null) {
                    this.dcE.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dcE.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dcE.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dcD.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dcD.keyAt(i2);
                long longValue3 = this.dcD.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dcE.get(keyAt2) != null) {
                    j4 = this.dcE.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dcD.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dcD.size() == 0) {
            asM();
            this.dcE.clear();
        } else {
            a(this.dcD, 1);
        }
    }

    public synchronized void asJ() {
        lO(2);
    }

    public synchronized void asK() {
        lO(3);
    }

    public void asL() {
        asC();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dcF = false;
                this.dcC = 4;
                this.mHandler.removeMessages(3);
                asE().mHandler.sendMessageDelayed(asE().mHandler.obtainMessage(3), asE().dct);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lO(int i) {
        this.dcF = true;
        this.dcC = i;
        a((SparseArray<Long>) null, i);
    }

    private void lP(int i) {
        if (i == 1) {
            if (this.dcy != 2) {
                this.dcy = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dcy = 2;
        }
    }

    private void asM() {
        this.dcy = 0;
    }
}
