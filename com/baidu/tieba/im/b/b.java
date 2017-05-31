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
    private static b dej;
    private List<GroupUpdateMessage> der;
    private boolean dey;
    private int dek = 900000;
    private int del = 360000;
    private int dem = this.del;
    private final int den = 0;
    private final int deo = 1;
    private final int dep = 2;
    private int deq = 0;
    private int det = 0;
    private long deu = 0;
    private int dev = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> dew = null;
    private SparseArray<Long> dex = null;
    private final com.baidu.adp.framework.client.socket.link.e oR = new e(this);
    private final com.baidu.adp.framework.listener.e cOw = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener dez = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        dej = null;
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
                    b.arz().mHandler.removeMessages(2);
                    b.arz().arE();
                    return;
                case 3:
                    b.arz().mHandler.removeMessages(3);
                    if (b.arz().dev == 3) {
                        b.arz().arF();
                    } else {
                        b.arz().arE();
                    }
                    b.arz().mHandler.sendMessageDelayed(b.arz().mHandler.obtainMessage(3), b.arz().dem);
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
            mc(i);
            return;
        }
        arH();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aqX().ari());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.dew != null) {
                this.dew.clear();
            }
            if (this.dex != null) {
                this.dex.clear();
            }
        }
    }

    public void arw() {
        boolean z;
        if (this.der != null) {
            SparseArray<Long> arh = com.baidu.tieba.im.memorycache.b.aqX().arh();
            if (arh == null) {
                this.der = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.der.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && arh.get(next.getGroupId()) != null) {
                    if (arh.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.dev = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                arz().mHandler.sendMessageDelayed(arz().mHandler.obtainMessage(3), arz().dem);
            }
            this.der = null;
        }
    }

    private void arx() {
        if (this.deq != 0) {
            if (this.deq == 1) {
                a(0L, 0L, 0L);
            } else {
                arE();
            }
        }
    }

    private void ary() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b arz() {
        b bVar;
        synchronized (b.class) {
            if (dej == null) {
                dej = new b();
            }
            bVar = dej;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dez);
        n.Bx().a(this.oR);
        MessageManager.getInstance().registerListener(1003, this.cOw);
        MessageManager.getInstance().registerListener(1001, this.cOw);
        MessageManager.getInstance().registerListener(202101, this.cOw);
        arA();
    }

    public void arA() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lZ(socketGetMsgStratgy[0] * 1000);
            ma(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        arH();
    }

    public void stop() {
        arH();
        ary();
    }

    public void arB() {
        this.dem = this.del;
    }

    public void arC() {
        arz().dem = arz().dek;
    }

    public void lZ(int i) {
        if (i > 0) {
            this.del = i;
        }
    }

    public void ma(int i) {
        if (i > 0) {
            this.dek = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void arD() {
        if (System.currentTimeMillis() - this.deu >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.det);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hX().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hX().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.deu = System.currentTimeMillis();
            this.det = 0;
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aqX().arh());
        }
        messageSyncMessage.setForTimer(this.dey);
        LocalViewSize.ImageSize uB = LocalViewSize.uy().uB();
        if (uB != null) {
            messageSyncMessage.setWidth(uB.width);
            messageSyncMessage.setHeight(uB.height);
        }
        LocalViewSize.ImageSize uA = LocalViewSize.uy().uA();
        if (uA != null) {
            messageSyncMessage.setSmallHeight(uA.height);
            messageSyncMessage.setSmallWidth(uA.width);
        }
        String aqD = com.baidu.tieba.im.a.c.aqG().aqD();
        if (aqD == null) {
            aqD = "0";
        }
        messageSyncMessage.setNotifyMaxTime(aqD);
        String aqE = com.baidu.tieba.im.a.c.aqG().aqE();
        if (aqE == null) {
            aqE = "0";
        }
        messageSyncMessage.setNotifyMinTime(aqE);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.aqG().aqL()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.det++;
        this.dey = false;
        this.dev = 1;
        this.mHandler.removeMessages(3);
        arz().mHandler.sendMessageDelayed(arz().mHandler.obtainMessage(3), arz().dem);
        if (this.dew == null) {
            this.dew = new SparseArray<>();
            this.dew.clear();
        }
        if (this.dex == null) {
            this.dex = new SparseArray<>();
        }
        SparseArray<Long> arh = com.baidu.tieba.im.memorycache.b.aqX().arh();
        if (0 != j) {
            Long l = arh.get((int) j);
            Long l2 = this.dew.get((int) j);
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
                this.dew.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.dew != null && this.dew.size() > 0) {
            for (int i = 0; i < this.dew.size(); i++) {
                int keyAt = this.dew.keyAt(i);
                Long l3 = arh.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.dew.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dex.get((int) j) == null) {
                    this.dex.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dex.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dex.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.dew.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.dew.keyAt(i2);
                long longValue3 = this.dew.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dex.get(keyAt2) != null) {
                    j4 = this.dex.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.dew.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.dew.size() == 0) {
            arH();
            this.dex.clear();
        } else {
            a(this.dew, 1);
        }
    }

    public synchronized void arE() {
        mb(2);
    }

    public synchronized void arF() {
        mb(3);
    }

    public void arG() {
        arx();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dey = false;
                this.dev = 4;
                this.mHandler.removeMessages(3);
                arz().mHandler.sendMessageDelayed(arz().mHandler.obtainMessage(3), arz().dem);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void mb(int i) {
        this.dey = true;
        this.dev = i;
        a((SparseArray<Long>) null, i);
    }

    private void mc(int i) {
        if (i == 1) {
            if (this.deq != 2) {
                this.deq = 1;
            }
        } else if (i == 3 || i == 2) {
            this.deq = 2;
        }
    }

    private void arH() {
        this.deq = 0;
    }
}
