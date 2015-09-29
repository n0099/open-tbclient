package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.websocketBase.n;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b bFc;
    private List<GroupUpdateMessage> bFk;
    private boolean bFq;
    private int bFd = 900000;
    private int bFe = 360000;
    private int bFf = this.bFe;
    private final int bFg = 0;
    private final int bFh = 1;
    private final int bFi = 2;
    private int bFj = 0;
    private int bFl = 0;
    private long bFm = 0;
    private int bFn = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> bFo = null;
    private SparseArray<Long> bFp = null;
    private final com.baidu.adp.framework.client.socket.link.e oN = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener bFr = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        bFc = null;
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
                    b.Wx().mHandler.removeMessages(2);
                    b.Wx().WC();
                    return;
                case 3:
                    b.Wx().mHandler.removeMessages(3);
                    if (b.Wx().bFn == 3) {
                        b.Wx().WD();
                    } else {
                        b.Wx().WC();
                    }
                    b.Wx().mHandler.sendMessageDelayed(b.Wx().mHandler.obtainMessage(3), b.Wx().bFf);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().ey() > 10) {
            u.a(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int z = MessageManager.getInstance().getSocketClient().z(202003);
        if (a2 || z > 0) {
            u.a(false, false, true);
            ht(i);
            return;
        }
        WF();
        SparseArray<Long> sparseArray2 = null;
        if (sparseArray != null && sparseArray.size() > 0) {
            SparseArray<Long> sparseArray3 = new SparseArray<>();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                sparseArray3.put(keyAt, sparseArray.get(keyAt));
            }
            sparseArray2 = sparseArray3;
        }
        MessageManager.getInstance().sendMessage(b(sparseArray2, i));
        u.a(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.bFo != null) {
                this.bFo.clear();
            }
            if (this.bFp != null) {
                this.bFp.clear();
            }
        }
    }

    public void Wu() {
        boolean z;
        if (this.bFk != null) {
            SparseArray<Long> Wg = com.baidu.tieba.im.memorycache.b.VW().Wg();
            if (Wg == null) {
                this.bFk = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bFk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && Wg.get(next.getGroupId()) != null) {
                    if (Wg.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bFn = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                Wx().mHandler.sendMessageDelayed(Wx().mHandler.obtainMessage(3), Wx().bFf);
            }
            this.bFk = null;
        }
    }

    private void Wv() {
        if (this.bFj != 0) {
            if (this.bFj == 1) {
                b(0L, 0L, 0L);
            } else {
                WC();
            }
        }
    }

    private void Ww() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b Wx() {
        b bVar;
        synchronized (b.class) {
            if (bFc == null) {
                bFc = new b();
            }
            bVar = bFc;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bFr);
        n.zN().a(this.oN);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        Wy();
    }

    public void Wy() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            hq(socketGetMsgStratgy[0] * 1000);
            hr(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        WF();
    }

    public void stop() {
        WF();
        Ww();
    }

    public void Wz() {
        this.bFf = this.bFe;
    }

    public void WA() {
        Wx().bFf = Wx().bFd;
    }

    public void hq(int i) {
        if (i > 0) {
            this.bFe = i;
        }
    }

    public void hr(int i) {
        if (i > 0) {
            this.bFd = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void WB() {
        if (System.currentTimeMillis() - this.bFm >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bFl);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.jz().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.jz().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bFm = System.currentTimeMillis();
            this.bFl = 0;
            com.baidu.adp.lib.webSocket.h.jz().jF();
            com.baidu.adp.lib.webSocket.h.jz().jE();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(SparseArray<Long> sparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.VW().Wg());
        }
        messageSyncMessage.setForTimer(this.bFq);
        LocalViewSize.ImageSize ud = LocalViewSize.ub().ud();
        if (ud != null) {
            messageSyncMessage.setWidth(ud.width);
            messageSyncMessage.setHeight(ud.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.ub().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String VD = com.baidu.tieba.im.a.c.VG().VD();
        if (VD == null) {
            VD = "0";
        }
        messageSyncMessage.setNotifyMaxTime(VD);
        String VE = com.baidu.tieba.im.a.c.VG().VE();
        if (VE == null) {
            VE = "0";
        }
        messageSyncMessage.setNotifyMinTime(VE);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.VG().VL()));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.bFl++;
        this.bFq = false;
        this.bFn = 1;
        this.mHandler.removeMessages(3);
        Wx().mHandler.sendMessageDelayed(Wx().mHandler.obtainMessage(3), Wx().bFf);
        if (this.bFo == null) {
            this.bFo = new SparseArray<>();
            this.bFo.clear();
        }
        if (this.bFp == null) {
            this.bFp = new SparseArray<>();
        }
        SparseArray<Long> Wg = com.baidu.tieba.im.memorycache.b.VW().Wg();
        if (0 != j) {
            Long l = Wg.get((int) j);
            Long l2 = this.bFo.get((int) j);
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
                this.bFo.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.bFo != null && this.bFo.size() > 0) {
            for (int i = 0; i < this.bFo.size(); i++) {
                int keyAt = this.bFo.keyAt(i);
                Long l3 = Wg.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.bFo.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.bFp.get((int) j) == null) {
                    this.bFp.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.bFp.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.bFp.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.bFo.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.bFo.keyAt(i2);
                long longValue3 = this.bFo.valueAt(i2).longValue();
                long j4 = 0;
                if (this.bFp.get(keyAt2) != null) {
                    j4 = this.bFp.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.bFo.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.bFo.size() == 0) {
            WF();
            this.bFp.clear();
        } else {
            a(this.bFo, 1);
        }
    }

    public synchronized void WC() {
        hs(2);
    }

    public synchronized void WD() {
        hs(3);
    }

    public void WE() {
        Wv();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bFq = false;
                this.bFn = 4;
                this.mHandler.removeMessages(3);
                Wx().mHandler.sendMessageDelayed(Wx().mHandler.obtainMessage(3), Wx().bFf);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void hs(int i) {
        this.bFq = true;
        this.bFn = i;
        a((SparseArray<Long>) null, i);
    }

    private void ht(int i) {
        if (i == 1) {
            if (this.bFj != 2) {
                this.bFj = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bFj = 2;
        }
    }

    private void WF() {
        this.bFj = 0;
    }
}
