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
    private static b ccV;
    private List<GroupUpdateMessage> cdd;
    private boolean cdj;
    private int ccW = 900000;
    private int ccX = 360000;
    private int ccY = this.ccX;
    private final int ccZ = 0;
    private final int cda = 1;
    private final int cdb = 2;
    private int cdc = 0;
    private int cde = 0;
    private long cdf = 0;
    private int cdg = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> cdh = null;
    private SparseArray<Long> cdi = null;
    private final com.baidu.adp.framework.client.socket.link.e oR = new e(this);
    private final com.baidu.adp.framework.listener.e ber = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener cdk = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        ccV = null;
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
                    b.aea().mHandler.removeMessages(2);
                    b.aea().aef();
                    return;
                case 3:
                    b.aea().mHandler.removeMessages(3);
                    if (b.aea().cdg == 3) {
                        b.aea().aeg();
                    } else {
                        b.aea().aef();
                    }
                    b.aea().mHandler.sendMessageDelayed(b.aea().mHandler.obtainMessage(3), b.aea().ccY);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().eC() > 10) {
            w.b(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int K = MessageManager.getInstance().getSocketClient().K(202003);
        if (a2 || K > 0) {
            w.b(false, false, true);
            jq(i);
            return;
        }
        aei();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.ady().adJ());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.cdh != null) {
                this.cdh.clear();
            }
            if (this.cdi != null) {
                this.cdi.clear();
            }
        }
    }

    public void adX() {
        boolean z;
        if (this.cdd != null) {
            SparseArray<Long> adI = com.baidu.tieba.im.memorycache.b.ady().adI();
            if (adI == null) {
                this.cdd = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.cdd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && adI.get(next.getGroupId()) != null) {
                    if (adI.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.cdg = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aea().mHandler.sendMessageDelayed(aea().mHandler.obtainMessage(3), aea().ccY);
            }
            this.cdd = null;
        }
    }

    private void adY() {
        if (this.cdc != 0) {
            if (this.cdc == 1) {
                b(0L, 0L, 0L);
            } else {
                aef();
            }
        }
    }

    private void adZ() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aea() {
        b bVar;
        synchronized (b.class) {
            if (ccV == null) {
                ccV = new b();
            }
            bVar = ccV;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.cdk);
        n.BR().a(this.oR);
        MessageManager.getInstance().registerListener(1003, this.ber);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.ber);
        MessageManager.getInstance().registerListener(202101, this.ber);
        aeb();
    }

    public void aeb() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            jn(socketGetMsgStratgy[0] * 1000);
            jo(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aei();
    }

    public void stop() {
        aei();
        adZ();
    }

    public void aec() {
        this.ccY = this.ccX;
    }

    public void aed() {
        aea().ccY = aea().ccW;
    }

    public void jn(int i) {
        if (i > 0) {
            this.ccX = i;
        }
    }

    public void jo(int i) {
        if (i > 0) {
            this.ccW = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aee() {
        if (System.currentTimeMillis() - this.cdf >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.cde);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.jL().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.jL().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.cdf = System.currentTimeMillis();
            this.cde = 0;
            com.baidu.adp.lib.webSocket.h.jL().jR();
            com.baidu.adp.lib.webSocket.h.jL().jQ();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.ady().adI());
        }
        messageSyncMessage.setForTimer(this.cdj);
        LocalViewSize.ImageSize vx = LocalViewSize.vu().vx();
        if (vx != null) {
            messageSyncMessage.setWidth(vx.width);
            messageSyncMessage.setHeight(vx.height);
        }
        LocalViewSize.ImageSize vw = LocalViewSize.vu().vw();
        if (vw != null) {
            messageSyncMessage.setSmallHeight(vw.height);
            messageSyncMessage.setSmallWidth(vw.width);
        }
        String ade = com.baidu.tieba.im.a.c.adh().ade();
        if (ade == null) {
            ade = "0";
        }
        messageSyncMessage.setNotifyMaxTime(ade);
        String adf = com.baidu.tieba.im.a.c.adh().adf();
        if (adf == null) {
            adf = "0";
        }
        messageSyncMessage.setNotifyMinTime(adf);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.adh().adm()));
        return messageSyncMessage;
    }

    public void b(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.cde++;
        this.cdj = false;
        this.cdg = 1;
        this.mHandler.removeMessages(3);
        aea().mHandler.sendMessageDelayed(aea().mHandler.obtainMessage(3), aea().ccY);
        if (this.cdh == null) {
            this.cdh = new SparseArray<>();
            this.cdh.clear();
        }
        if (this.cdi == null) {
            this.cdi = new SparseArray<>();
        }
        SparseArray<Long> adI = com.baidu.tieba.im.memorycache.b.ady().adI();
        if (0 != j) {
            Long l = adI.get((int) j);
            Long l2 = this.cdh.get((int) j);
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
                this.cdh.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.cdh != null && this.cdh.size() > 0) {
            for (int i = 0; i < this.cdh.size(); i++) {
                int keyAt = this.cdh.keyAt(i);
                Long l3 = adI.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.cdh.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.cdi.get((int) j) == null) {
                    this.cdi.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.cdi.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.cdi.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.cdh.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.cdh.keyAt(i2);
                long longValue3 = this.cdh.valueAt(i2).longValue();
                long j4 = 0;
                if (this.cdi.get(keyAt2) != null) {
                    j4 = this.cdi.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.cdh.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.cdh.size() == 0) {
            aei();
            this.cdi.clear();
        } else {
            a(this.cdh, 1);
        }
    }

    public synchronized void aef() {
        jp(2);
    }

    public synchronized void aeg() {
        jp(3);
    }

    public void aeh() {
        adY();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.cdj = false;
                this.cdg = 4;
                this.mHandler.removeMessages(3);
                aea().mHandler.sendMessageDelayed(aea().mHandler.obtainMessage(3), aea().ccY);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void jp(int i) {
        this.cdj = true;
        this.cdg = i;
        a((SparseArray<Long>) null, i);
    }

    private void jq(int i) {
        if (i == 1) {
            if (this.cdc != 2) {
                this.cdc = 1;
            }
        } else if (i == 3 || i == 2) {
            this.cdc = 2;
        }
    }

    private void aei() {
        this.cdc = 0;
    }
}
