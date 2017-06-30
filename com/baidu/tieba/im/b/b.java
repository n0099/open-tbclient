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
    private static b dmf;
    private List<GroupUpdateMessage> dmn;
    private boolean dmt;
    private int dmg = 900000;
    private int dmh = 360000;
    private int dmi = this.dmh;
    private final int dmj = 0;
    private final int dmk = 1;
    private final int dml = 2;
    private int dmm = 0;
    private int dmo = 0;
    private long dmp = 0;
    private int dmq = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> dmr = null;
    private SparseArray<Long> dms = null;
    private final com.baidu.adp.framework.client.socket.link.e oR = new e(this);
    private final com.baidu.adp.framework.listener.e cWs = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener dmu = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        dmf = null;
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
                    b.avk().mHandler.removeMessages(2);
                    b.avk().avp();
                    return;
                case 3:
                    b.avk().mHandler.removeMessages(3);
                    if (b.avk().dmq == 3) {
                        b.avk().avq();
                    } else {
                        b.avk().avp();
                    }
                    b.avk().mHandler.sendMessageDelayed(b.avk().mHandler.obtainMessage(3), b.avk().dmi);
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
            mn(i);
            return;
        }
        avs();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.auI().auT());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dmr != null) {
                this.dmr.clear();
            }
            if (this.dms != null) {
                this.dms.clear();
            }
        }
    }

    public void avh() {
        boolean z;
        if (this.dmn != null) {
            SparseArray<Long> auS = com.baidu.tieba.im.memorycache.b.auI().auS();
            if (auS == null) {
                this.dmn = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.dmn.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && auS.get(next.getGroupId()) != null) {
                    if (auS.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dmq = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                avk().mHandler.sendMessageDelayed(avk().mHandler.obtainMessage(3), avk().dmi);
            }
            this.dmn = null;
        }
    }

    private void avi() {
        if (this.dmm != 0) {
            if (this.dmm == 1) {
                a(0L, 0L, 0L);
            } else {
                avp();
            }
        }
    }

    private void avj() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b avk() {
        b bVar;
        synchronized (b.class) {
            if (dmf == null) {
                dmf = new b();
            }
            bVar = dmf;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dmu);
        n.BS().a(this.oR);
        MessageManager.getInstance().registerListener(1003, this.cWs);
        MessageManager.getInstance().registerListener(1001, this.cWs);
        MessageManager.getInstance().registerListener(202101, this.cWs);
        avl();
    }

    public void avl() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            mk(socketGetMsgStratgy[0] * 1000);
            ml(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        avs();
    }

    public void stop() {
        avs();
        avj();
    }

    public void avm() {
        this.dmi = this.dmh;
    }

    public void avn() {
        avk().dmi = avk().dmg;
    }

    public void mk(int i) {
        if (i > 0) {
            this.dmh = i;
        }
    }

    public void ml(int i) {
        if (i > 0) {
            this.dmg = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void avo() {
        if (System.currentTimeMillis() - this.dmp >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dmo);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hW().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hW().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.dmp = System.currentTimeMillis();
            this.dmo = 0;
            com.baidu.adp.lib.webSocket.h.hW().ic();
            com.baidu.adp.lib.webSocket.h.hW().ib();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.auI().auS());
        }
        messageSyncMessage.setForTimer(this.dmt);
        LocalViewSize.ImageSize uR = LocalViewSize.uO().uR();
        if (uR != null) {
            messageSyncMessage.setWidth(uR.width);
            messageSyncMessage.setHeight(uR.height);
        }
        LocalViewSize.ImageSize uQ = LocalViewSize.uO().uQ();
        if (uQ != null) {
            messageSyncMessage.setSmallHeight(uQ.height);
            messageSyncMessage.setSmallWidth(uQ.width);
        }
        String auo = com.baidu.tieba.im.a.c.aur().auo();
        if (auo == null) {
            auo = "0";
        }
        messageSyncMessage.setNotifyMaxTime(auo);
        String aup = com.baidu.tieba.im.a.c.aur().aup();
        if (aup == null) {
            aup = "0";
        }
        messageSyncMessage.setNotifyMinTime(aup);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.aur().auw()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dmo++;
        this.dmt = false;
        this.dmq = 1;
        this.mHandler.removeMessages(3);
        avk().mHandler.sendMessageDelayed(avk().mHandler.obtainMessage(3), avk().dmi);
        if (this.dmr == null) {
            this.dmr = new SparseArray<>();
            this.dmr.clear();
        }
        if (this.dms == null) {
            this.dms = new SparseArray<>();
        }
        SparseArray<Long> auS = com.baidu.tieba.im.memorycache.b.auI().auS();
        if (0 != j) {
            Long l = auS.get((int) j);
            Long l2 = this.dmr.get((int) j);
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
                this.dmr.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dmr != null && this.dmr.size() > 0) {
            for (int i = 0; i < this.dmr.size(); i++) {
                int keyAt = this.dmr.keyAt(i);
                Long l3 = auS.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dmr.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dms.get((int) j) == null) {
                    this.dms.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dms.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dms.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dmr.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dmr.keyAt(i2);
                long longValue3 = this.dmr.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dms.get(keyAt2) != null) {
                    j4 = this.dms.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dmr.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dmr.size() == 0) {
            avs();
            this.dms.clear();
        } else {
            a(this.dmr, 1);
        }
    }

    public synchronized void avp() {
        mm(2);
    }

    public synchronized void avq() {
        mm(3);
    }

    public void avr() {
        avi();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dmt = false;
                this.dmq = 4;
                this.mHandler.removeMessages(3);
                avk().mHandler.sendMessageDelayed(avk().mHandler.obtainMessage(3), avk().dmi);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void mm(int i) {
        this.dmt = true;
        this.dmq = i;
        a((SparseArray<Long>) null, i);
    }

    private void mn(int i) {
        if (i == 1) {
            if (this.dmm != 2) {
                this.dmm = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dmm = 2;
        }
    }

    private void avs() {
        this.dmm = 0;
    }
}
