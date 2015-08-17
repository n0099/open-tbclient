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
    private static b bBr;
    private boolean bBF;
    private List<GroupUpdateMessage> bBz;
    private int bBs = 900000;
    private int bBt = 360000;
    private int bBu = this.bBt;
    private final int bBv = 0;
    private final int bBw = 1;
    private final int bBx = 2;
    private int bBy = 0;
    private int bBA = 0;
    private long bBB = 0;
    private int bBC = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> bBD = null;
    private SparseArray<Long> bBE = null;
    private final com.baidu.adp.framework.client.socket.link.e oN = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener bBG = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        bBr = null;
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
                    b.VM().mHandler.removeMessages(2);
                    b.VM().VR();
                    return;
                case 3:
                    b.VM().mHandler.removeMessages(3);
                    if (b.VM().bBC == 3) {
                        b.VM().VS();
                    } else {
                        b.VM().VR();
                    }
                    b.VM().mHandler.sendMessageDelayed(b.VM().mHandler.obtainMessage(3), b.VM().bBu);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().ez() > 10) {
            u.a(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int z = MessageManager.getInstance().getSocketClient().z(202003);
        if (a2 || z > 0) {
            u.a(false, false, true);
            hd(i);
            return;
        }
        VU();
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
            if (this.bBD != null) {
                this.bBD.clear();
            }
            if (this.bBE != null) {
                this.bBE.clear();
            }
        }
    }

    public void VJ() {
        boolean z;
        if (this.bBz != null) {
            SparseArray<Long> Vv = com.baidu.tieba.im.memorycache.b.Vl().Vv();
            if (Vv == null) {
                this.bBz = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.bBz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && Vv.get(next.getGroupId()) != null) {
                    if (Vv.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.bBC = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                VM().mHandler.sendMessageDelayed(VM().mHandler.obtainMessage(3), VM().bBu);
            }
            this.bBz = null;
        }
    }

    private void VK() {
        if (this.bBy != 0) {
            if (this.bBy == 1) {
                b(0L, 0L, 0L);
            } else {
                VR();
            }
        }
    }

    private void VL() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b VM() {
        b bVar;
        synchronized (b.class) {
            if (bBr == null) {
                bBr = new b();
            }
            bVar = bBr;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.bBG);
        n.zL().a(this.oN);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        VN();
    }

    public void VN() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            ha(socketGetMsgStratgy[0] * 1000);
            hb(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        VU();
    }

    public void stop() {
        VU();
        VL();
    }

    public void VO() {
        this.bBu = this.bBt;
    }

    public void VP() {
        VM().bBu = VM().bBs;
    }

    public void ha(int i) {
        if (i > 0) {
            this.bBt = i;
        }
    }

    public void hb(int i) {
        if (i > 0) {
            this.bBs = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void VQ() {
        if (System.currentTimeMillis() - this.bBB >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bBA);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.jB().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.jB().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bBB = System.currentTimeMillis();
            this.bBA = 0;
            com.baidu.adp.lib.webSocket.h.jB().jH();
            com.baidu.adp.lib.webSocket.h.jB().jG();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(SparseArray<Long> sparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.Vl().Vv());
        }
        messageSyncMessage.setForTimer(this.bBF);
        LocalViewSize.ImageSize ua = LocalViewSize.tY().ua();
        if (ua != null) {
            messageSyncMessage.setWidth(ua.width);
            messageSyncMessage.setHeight(ua.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.tY().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String US = com.baidu.tieba.im.a.c.UV().US();
        if (US == null) {
            US = "0";
        }
        messageSyncMessage.setNotifyMaxTime(US);
        String UT = com.baidu.tieba.im.a.c.UV().UT();
        if (UT == null) {
            UT = "0";
        }
        messageSyncMessage.setNotifyMinTime(UT);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.UV().Va()));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.bBA++;
        this.bBF = false;
        this.bBC = 1;
        this.mHandler.removeMessages(3);
        VM().mHandler.sendMessageDelayed(VM().mHandler.obtainMessage(3), VM().bBu);
        if (this.bBD == null) {
            this.bBD = new SparseArray<>();
            this.bBD.clear();
        }
        if (this.bBE == null) {
            this.bBE = new SparseArray<>();
        }
        SparseArray<Long> Vv = com.baidu.tieba.im.memorycache.b.Vl().Vv();
        if (0 != j) {
            Long l = Vv.get((int) j);
            Long l2 = this.bBD.get((int) j);
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
                this.bBD.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.bBD != null && this.bBD.size() > 0) {
            for (int i = 0; i < this.bBD.size(); i++) {
                int keyAt = this.bBD.keyAt(i);
                Long l3 = Vv.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.bBD.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.bBE.get((int) j) == null) {
                    this.bBE.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.bBE.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.bBE.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.bBD.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.bBD.keyAt(i2);
                long longValue3 = this.bBD.valueAt(i2).longValue();
                long j4 = 0;
                if (this.bBE.get(keyAt2) != null) {
                    j4 = this.bBE.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.bBD.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.bBD.size() == 0) {
            VU();
            this.bBE.clear();
        } else {
            a(this.bBD, 1);
        }
    }

    public synchronized void VR() {
        hc(2);
    }

    public synchronized void VS() {
        hc(3);
    }

    public void VT() {
        VK();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bBF = false;
                this.bBC = 4;
                this.mHandler.removeMessages(3);
                VM().mHandler.sendMessageDelayed(VM().mHandler.obtainMessage(3), VM().bBu);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void hc(int i) {
        this.bBF = true;
        this.bBC = i;
        a((SparseArray<Long>) null, i);
    }

    private void hd(int i) {
        if (i == 1) {
            if (this.bBy != 2) {
                this.bBy = 1;
            }
        } else if (i == 3 || i == 2) {
            this.bBy = 2;
        }
    }

    private void VU() {
        this.bBy = 0;
    }
}
