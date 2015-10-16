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
    private static b bFn;
    private boolean bFB;
    private List<GroupUpdateMessage> bFv;
    private int bFo = 900000;
    private int bFp = 360000;
    private int bFq = this.bFp;
    private final int bFr = 0;
    private final int bFs = 1;
    private final int bFt = 2;
    private int bFu = 0;
    private int bFw = 0;
    private long bFx = 0;
    private int bFy = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> bFz = null;
    private SparseArray<Long> bFA = null;
    private final com.baidu.adp.framework.client.socket.link.e oN = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener bFC = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        bFn = null;
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
                    if (b.Wx().bFy == 3) {
                        b.Wx().WD();
                    } else {
                        b.Wx().WC();
                    }
                    b.Wx().mHandler.sendMessageDelayed(b.Wx().mHandler.obtainMessage(3), b.Wx().bFq);
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
            if (this.bFz != null) {
                this.bFz.clear();
            }
            if (this.bFA != null) {
                this.bFA.clear();
            }
        }
    }

    public void Wu() {
        boolean z;
        if (this.bFv != null) {
            SparseArray<Long> Wg = com.baidu.tieba.im.memorycache.b.VW().Wg();
            if (Wg == null) {
                this.bFv = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bFv.iterator();
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
            this.bFy = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                Wx().mHandler.sendMessageDelayed(Wx().mHandler.obtainMessage(3), Wx().bFq);
            }
            this.bFv = null;
        }
    }

    private void Wv() {
        if (this.bFu != 0) {
            if (this.bFu == 1) {
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
            if (bFn == null) {
                bFn = new b();
            }
            bVar = bFn;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bFC);
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
        this.bFq = this.bFp;
    }

    public void WA() {
        Wx().bFq = Wx().bFo;
    }

    public void hq(int i) {
        if (i > 0) {
            this.bFp = i;
        }
    }

    public void hr(int i) {
        if (i > 0) {
            this.bFo = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void WB() {
        if (System.currentTimeMillis() - this.bFx >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bFw);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.jz().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.jz().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bFx = System.currentTimeMillis();
            this.bFw = 0;
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
        messageSyncMessage.setForTimer(this.bFB);
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
        this.bFw++;
        this.bFB = false;
        this.bFy = 1;
        this.mHandler.removeMessages(3);
        Wx().mHandler.sendMessageDelayed(Wx().mHandler.obtainMessage(3), Wx().bFq);
        if (this.bFz == null) {
            this.bFz = new SparseArray<>();
            this.bFz.clear();
        }
        if (this.bFA == null) {
            this.bFA = new SparseArray<>();
        }
        SparseArray<Long> Wg = com.baidu.tieba.im.memorycache.b.VW().Wg();
        if (0 != j) {
            Long l = Wg.get((int) j);
            Long l2 = this.bFz.get((int) j);
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
                this.bFz.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.bFz != null && this.bFz.size() > 0) {
            for (int i = 0; i < this.bFz.size(); i++) {
                int keyAt = this.bFz.keyAt(i);
                Long l3 = Wg.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.bFz.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.bFA.get((int) j) == null) {
                    this.bFA.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.bFA.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.bFA.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.bFz.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.bFz.keyAt(i2);
                long longValue3 = this.bFz.valueAt(i2).longValue();
                long j4 = 0;
                if (this.bFA.get(keyAt2) != null) {
                    j4 = this.bFA.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.bFz.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.bFz.size() == 0) {
            WF();
            this.bFA.clear();
        } else {
            a(this.bFz, 1);
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
                this.bFB = false;
                this.bFy = 4;
                this.mHandler.removeMessages(3);
                Wx().mHandler.sendMessageDelayed(Wx().mHandler.obtainMessage(3), Wx().bFq);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void hs(int i) {
        this.bFB = true;
        this.bFy = i;
        a((SparseArray<Long>) null, i);
    }

    private void ht(int i) {
        if (i == 1) {
            if (this.bFu != 2) {
                this.bFu = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bFu = 2;
        }
    }

    private void WF() {
        this.bFu = 0;
    }
}
