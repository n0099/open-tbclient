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
    private static b ddV;
    private List<GroupUpdateMessage> ded;
    private boolean dej;
    private int ddW = 900000;
    private int ddX = 360000;
    private int ddY = this.ddX;
    private final int ddZ = 0;
    private final int dea = 1;
    private final int deb = 2;
    private int dec = 0;
    private int dee = 0;
    private long def = 0;
    private int deg = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a(null);
    private SparseArray<Long> deh = null;
    private SparseArray<Long> dei = null;
    private final com.baidu.adp.framework.client.socket.link.e px = new e(this);
    private final com.baidu.adp.framework.listener.e cOh = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH);
    private final CustomMessageListener dek = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);

    static {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.MEMORY_INIT_COMPLETED));
        ddV = null;
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
                    b.asL().mHandler.removeMessages(2);
                    b.asL().asQ();
                    return;
                case 3:
                    b.asL().mHandler.removeMessages(3);
                    if (b.asL().deg == 3) {
                        b.asL().asR();
                    } else {
                        b.asL().asQ();
                    }
                    b.asL().mHandler.sendMessageDelayed(b.asL().mHandler.obtainMessage(3), b.asL().ddY);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().cV() > 10) {
            w.b(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int P = MessageManager.getInstance().getSocketClient().P(202003);
        if (a2 || P > 0) {
            w.b(false, false, true);
            lO(i);
            return;
        }
        asT();
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
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.asj().asu());
        }
        MessageManager.getInstance().sendMessage(b);
        w.b(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.deh != null) {
                this.deh.clear();
            }
            if (this.dei != null) {
                this.dei.clear();
            }
        }
    }

    public void asI() {
        boolean z;
        if (this.ded != null) {
            SparseArray<Long> ast = com.baidu.tieba.im.memorycache.b.asj().ast();
            if (ast == null) {
                this.ded = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.ded.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && ast.get(next.getGroupId()) != null) {
                    if (ast.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.deg = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                asL().mHandler.sendMessageDelayed(asL().mHandler.obtainMessage(3), asL().ddY);
            }
            this.ded = null;
        }
    }

    private void asJ() {
        if (this.dec != 0) {
            if (this.dec == 1) {
                a(0L, 0L, 0L);
            } else {
                asQ();
            }
        }
    }

    private void asK() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b asL() {
        b bVar;
        synchronized (b.class) {
            if (ddV == null) {
                ddV = new b();
            }
            bVar = ddV;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.dek);
        n.BV().a(this.px);
        MessageManager.getInstance().registerListener(1003, this.cOh);
        MessageManager.getInstance().registerListener(1001, this.cOh);
        MessageManager.getInstance().registerListener(202101, this.cOh);
        asM();
    }

    public void asM() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m9getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            lL(socketGetMsgStratgy[0] * 1000);
            lM(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        asT();
    }

    public void stop() {
        asT();
        asK();
    }

    public void asN() {
        this.ddY = this.ddX;
    }

    public void asO() {
        asL().ddY = asL().ddW;
    }

    public void lL(int i) {
        if (i > 0) {
            this.ddX = i;
        }
    }

    public void lM(int i) {
        if (i > 0) {
            this.ddW = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void asP() {
        if (System.currentTimeMillis() - this.def >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.dee);
            pushCountMessage.setUpFlowSize(com.baidu.adp.lib.webSocket.h.hS().getUpFlowSize());
            pushCountMessage.setDownFlowSize(com.baidu.adp.lib.webSocket.h.hS().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m9getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.def = System.currentTimeMillis();
            this.dee = 0;
            com.baidu.adp.lib.webSocket.h.hS().hZ();
            com.baidu.adp.lib.webSocket.h.hS().hY();
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
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.asj().ast());
        }
        messageSyncMessage.setForTimer(this.dej);
        LocalViewSize.ImageSize uV = LocalViewSize.uS().uV();
        if (uV != null) {
            messageSyncMessage.setWidth(uV.width);
            messageSyncMessage.setHeight(uV.height);
        }
        LocalViewSize.ImageSize uU = LocalViewSize.uS().uU();
        if (uU != null) {
            messageSyncMessage.setSmallHeight(uU.height);
            messageSyncMessage.setSmallWidth(uU.width);
        }
        String arP = com.baidu.tieba.im.a.c.arS().arP();
        if (arP == null) {
            arP = "0";
        }
        messageSyncMessage.setNotifyMaxTime(arP);
        String arQ = com.baidu.tieba.im.a.c.arS().arQ();
        if (arQ == null) {
            arQ = "0";
        }
        messageSyncMessage.setNotifyMinTime(arQ);
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.arS().arX()));
        return messageSyncMessage;
    }

    public void a(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.dee++;
        this.dej = false;
        this.deg = 1;
        this.mHandler.removeMessages(3);
        asL().mHandler.sendMessageDelayed(asL().mHandler.obtainMessage(3), asL().ddY);
        if (this.deh == null) {
            this.deh = new SparseArray<>();
            this.deh.clear();
        }
        if (this.dei == null) {
            this.dei = new SparseArray<>();
        }
        SparseArray<Long> ast = com.baidu.tieba.im.memorycache.b.asj().ast();
        if (0 != j) {
            Long l = ast.get((int) j);
            Long l2 = this.deh.get((int) j);
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
                this.deh.put((int) j, Long.valueOf(longValue));
            }
        }
        if (this.deh != null && this.deh.size() > 0) {
            for (int i = 0; i < this.deh.size(); i++) {
                int keyAt = this.deh.keyAt(i);
                Long l3 = ast.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.deh.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.dei.get((int) j) == null) {
                    this.dei.put((int) j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.dei.get((int) j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.dei.put((int) j, Long.valueOf(j2));
                }
            }
            int size = this.deh.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt2 = this.deh.keyAt(i2);
                long longValue3 = this.deh.valueAt(i2).longValue();
                long j4 = 0;
                if (this.dei.get(keyAt2) != null) {
                    j4 = this.dei.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Integer.valueOf((int) j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.deh.remove(((Integer) it.next()).intValue());
            }
        }
        if (this.deh.size() == 0) {
            asT();
            this.dei.clear();
        } else {
            a(this.deh, 1);
        }
    }

    public synchronized void asQ() {
        lN(2);
    }

    public synchronized void asR() {
        lN(3);
    }

    public void asS() {
        asJ();
    }

    public synchronized void c(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.dej = false;
                this.deg = 4;
                this.mHandler.removeMessages(3);
                asL().mHandler.sendMessageDelayed(asL().mHandler.obtainMessage(3), asL().ddY);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void lN(int i) {
        this.dej = true;
        this.deg = i;
        a((SparseArray<Long>) null, i);
    }

    private void lO(int i) {
        if (i == 1) {
            if (this.dec != 2) {
                this.dec = 1;
            }
        } else if (i == 3 || i == 2) {
            this.dec = 2;
        }
    }

    private void asT() {
        this.dec = 0;
    }
}
