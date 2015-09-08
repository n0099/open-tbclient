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
    private static b bBY;
    private List<GroupUpdateMessage> bCg;
    private boolean bCm;
    private int bBZ = 900000;
    private int bCa = 360000;
    private int bCb = this.bCa;
    private final int bCc = 0;
    private final int bCd = 1;
    private final int bCe = 2;
    private int bCf = 0;
    private int bCh = 0;
    private long bCi = 0;
    private int bCj = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> bCk = null;
    private SparseArray<Long> bCl = null;
    private final com.baidu.adp.framework.client.socket.link.e oN = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener bCn = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        bBY = null;
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
                    b.VO().mHandler.removeMessages(2);
                    b.VO().VT();
                    return;
                case 3:
                    b.VO().mHandler.removeMessages(3);
                    if (b.VO().bCj == 3) {
                        b.VO().VU();
                    } else {
                        b.VO().VT();
                    }
                    b.VO().mHandler.sendMessageDelayed(b.VO().mHandler.obtainMessage(3), b.VO().bCb);
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
            hn(i);
            return;
        }
        VW();
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
            if (this.bCk != null) {
                this.bCk.clear();
            }
            if (this.bCl != null) {
                this.bCl.clear();
            }
        }
    }

    public void VL() {
        boolean z;
        if (this.bCg != null) {
            SparseArray<Long> Vx = com.baidu.tieba.im.memorycache.b.Vn().Vx();
            if (Vx == null) {
                this.bCg = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bCg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && Vx.get(next.getGroupId()) != null) {
                    if (Vx.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bCj = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                VO().mHandler.sendMessageDelayed(VO().mHandler.obtainMessage(3), VO().bCb);
            }
            this.bCg = null;
        }
    }

    private void VM() {
        if (this.bCf != 0) {
            if (this.bCf == 1) {
                b(0L, 0L, 0L);
            } else {
                VT();
            }
        }
    }

    private void VN() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b VO() {
        b bVar;
        synchronized (b.class) {
            if (bBY == null) {
                bBY = new b();
            }
            bVar = bBY;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bCn);
        n.zY().a(this.oN);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        VP();
    }

    public void VP() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            hk(socketGetMsgStratgy[0] * 1000);
            hl(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        VW();
    }

    public void stop() {
        VW();
        VN();
    }

    public void VQ() {
        this.bCb = this.bCa;
    }

    public void VR() {
        VO().bCb = VO().bBZ;
    }

    public void hk(int i) {
        if (i > 0) {
            this.bCa = i;
        }
    }

    public void hl(int i) {
        if (i > 0) {
            this.bBZ = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void VS() {
        if (System.currentTimeMillis() - this.bCi >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bCh);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.jy().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.jy().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bCi = System.currentTimeMillis();
            this.bCh = 0;
            com.baidu.adp.lib.webSocket.h.jy().jE();
            com.baidu.adp.lib.webSocket.h.jy().jD();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(SparseArray<Long> sparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.Vn().Vx());
        }
        messageSyncMessage.setForTimer(this.bCm);
        LocalViewSize.ImageSize uf = LocalViewSize.ud().uf();
        if (uf != null) {
            messageSyncMessage.setWidth(uf.width);
            messageSyncMessage.setHeight(uf.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.ud().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String UU = com.baidu.tieba.im.a.c.UX().UU();
        if (UU == null) {
            UU = "0";
        }
        messageSyncMessage.setNotifyMaxTime(UU);
        String UV = com.baidu.tieba.im.a.c.UX().UV();
        if (UV == null) {
            UV = "0";
        }
        messageSyncMessage.setNotifyMinTime(UV);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.UX().Vc()));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.bCh++;
        this.bCm = false;
        this.bCj = 1;
        this.mHandler.removeMessages(3);
        VO().mHandler.sendMessageDelayed(VO().mHandler.obtainMessage(3), VO().bCb);
        if (this.bCk == null) {
            this.bCk = new SparseArray<>();
            this.bCk.clear();
        }
        if (this.bCl == null) {
            this.bCl = new SparseArray<>();
        }
        SparseArray<Long> Vx = com.baidu.tieba.im.memorycache.b.Vn().Vx();
        if (0 != j) {
            Long l = Vx.get((int) j);
            Long l2 = this.bCk.get((int) j);
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
                this.bCk.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.bCk != null && this.bCk.size() > 0) {
            for (int i = 0; i < this.bCk.size(); i++) {
                int keyAt = this.bCk.keyAt(i);
                Long l3 = Vx.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.bCk.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.bCl.get((int) j) == null) {
                    this.bCl.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.bCl.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.bCl.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.bCk.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.bCk.keyAt(i2);
                long longValue3 = this.bCk.valueAt(i2).longValue();
                long j4 = 0;
                if (this.bCl.get(keyAt2) != null) {
                    j4 = this.bCl.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.bCk.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.bCk.size() == 0) {
            VW();
            this.bCl.clear();
        } else {
            a(this.bCk, 1);
        }
    }

    public synchronized void VT() {
        hm(2);
    }

    public synchronized void VU() {
        hm(3);
    }

    public void VV() {
        VM();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bCm = false;
                this.bCj = 4;
                this.mHandler.removeMessages(3);
                VO().mHandler.sendMessageDelayed(VO().mHandler.obtainMessage(3), VO().bCb);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void hm(int i) {
        this.bCm = true;
        this.bCj = i;
        a((SparseArray<Long>) null, i);
    }

    private void hn(int i) {
        if (i == 1) {
            if (this.bCf != 2) {
                this.bCf = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bCf = 2;
        }
    }

    private void VW() {
        this.bCf = 0;
    }
}
