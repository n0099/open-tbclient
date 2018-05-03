package com.baidu.tieba.im.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.f;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.webSocket.h;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.websocketBase.PingManager;
import com.baidu.tbadk.coreExtra.websocketBase.g;
import com.baidu.tbadk.k.m;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import protobuf.NewpushRepair;
/* loaded from: classes.dex */
public class b {
    private static b efk;
    private List<GroupUpdateMessage> efs;
    private boolean efy;
    private int efl = 900000;
    private int efm = 360000;
    private int efn = this.efm;
    private final int efo = 0;
    private final int efp = 1;
    private final int efq = 2;
    private int efr = 0;
    private int eft = 0;
    private long efu = 0;
    private int efv = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new a();
    private LongSparseArray<Long> efw = null;
    private LongSparseArray<Long> efx = null;
    private final com.baidu.adp.framework.client.socket.link.a ng = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tieba.im.a.b.3
        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            b.this.stop();
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void d(Map<String, String> map) {
            b.this.start();
            f.cy().c(map);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void G(String str) {
        }
    };
    private final com.baidu.adp.framework.listener.c dPI = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                if (socketResponsedMessage.getCmd() == 1003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                        b.this.aGf();
                    }
                } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                    if (responseOnlineMessage.getError() == 0) {
                        b.this.efs = responseOnlineMessage.getGroupInfos();
                        if (com.baidu.tieba.im.memorycache.b.aFy().aFx()) {
                            b.this.aFY();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.im.a.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    b.this.aGe();
                } else {
                    b.this.aGd();
                }
            }
        }
    };
    private final CustomMessageListener efz = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (b.this.efw != null) {
                    b.this.efw.clear();
                }
                if (b.this.efx != null) {
                    b.this.efx.clear();
                }
                b.this.efs = null;
            }
        }
    };

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008017) { // from class: com.baidu.tieba.im.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                    PingManager.CM().CN();
                    b.aGb().aGc();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016002) { // from class: com.baidu.tieba.im.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                    b.aGb().aFY();
                }
            }
        });
        efk = null;
    }

    /* loaded from: classes.dex */
    private static class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 2:
                    b.aGb().mHandler.removeMessages(2);
                    b.aGb().aGg();
                    return;
                case 3:
                    b.aGb().mHandler.removeMessages(3);
                    if (b.aGb().efv == 3) {
                        b.aGb().aGh();
                    } else {
                        b.aGb().aGg();
                    }
                    b.aGb().mHandler.sendMessageDelayed(b.aGb().mHandler.obtainMessage(3), b.aGb().efn);
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(LongSparseArray<Long> longSparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().cD() > 10) {
            m.d(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a2 = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int G = MessageManager.getInstance().getSocketClient().G(202003);
        if (a2 || G > 0) {
            m.d(false, false, true);
            nT(i);
            return;
        }
        aGj();
        LongSparseArray<Long> longSparseArray2 = null;
        if (longSparseArray != null && longSparseArray.size() > 0) {
            LongSparseArray<Long> longSparseArray3 = new LongSparseArray<>();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long keyAt = longSparseArray.keyAt(i2);
                longSparseArray3.put(keyAt, Long.valueOf(longSparseArray.get(keyAt).longValue()));
            }
            longSparseArray2 = longSparseArray3;
        }
        MessageSyncMessage b = b(longSparseArray2, i);
        if (i == 3 || i == 2) {
            b.setNewpushRepire(com.baidu.tieba.im.memorycache.b.aFy().aFK());
        }
        MessageManager.getInstance().sendMessage(b);
        m.d(true, false, false);
        if (i == 3 || i == 1 || i == 2) {
            if (this.efw != null) {
                this.efw.clear();
            }
            if (this.efx != null) {
                this.efx.clear();
            }
        }
    }

    public void aFY() {
        boolean z;
        if (this.efs != null) {
            LongSparseArray<Long> aFJ = com.baidu.tieba.im.memorycache.b.aFy().aFJ();
            if (aFJ == null) {
                this.efs = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.efs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && aFJ.get(next.getGroupId()) != null) {
                    if (aFJ.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.efv = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                aGb().mHandler.sendMessageDelayed(aGb().mHandler.obtainMessage(3), aGb().efn);
            }
            this.efs = null;
        }
    }

    private void aFZ() {
        if (this.efr != 0) {
            if (this.efr == 1) {
                d(0L, 0L, 0L);
            } else {
                aGg();
            }
        }
    }

    private void aGa() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b aGb() {
        b bVar;
        synchronized (b.class) {
            if (efk == null) {
                efk = new b();
            }
            bVar = efk;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.efz);
        g.CU().a(this.ng);
        MessageManager.getInstance().registerListener(1003, this.dPI);
        MessageManager.getInstance().registerListener(1001, this.dPI);
        MessageManager.getInstance().registerListener(202101, this.dPI);
        aGc();
    }

    public void aGc() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            nQ(socketGetMsgStratgy[0] * 1000);
            nR(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        aGj();
    }

    public void stop() {
        aGj();
        aGa();
    }

    public void aGd() {
        this.efn = this.efm;
    }

    public void aGe() {
        aGb().efn = aGb().efl;
    }

    public void nQ(int i) {
        if (i > 0) {
            this.efm = i;
        }
    }

    public void nR(int i) {
        if (i > 0) {
            this.efl = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aGf() {
        if (System.currentTimeMillis() - this.efu >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.eft);
            pushCountMessage.setUpFlowSize(h.hB().getUpFlowSize());
            pushCountMessage.setDownFlowSize(h.hB().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.efu = System.currentTimeMillis();
            this.eft = 0;
            h.hB().hG();
            h.hB().hF();
            TbadkCoreApplication.getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage b(LongSparseArray<Long> longSparseArray, int i) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (longSparseArray != null && longSparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(longSparseArray);
            NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(longSparseArray);
            if (makeNewpushRepair != null) {
                messageSyncMessage.setNewpushRepire(makeNewpushRepair);
            }
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.b.aFy().aFJ());
        }
        messageSyncMessage.setForTimer(this.efy);
        LocalViewSize.ImageSize vf = LocalViewSize.vc().vf();
        if (vf != null) {
            messageSyncMessage.setWidth(vf.width);
            messageSyncMessage.setHeight(vf.height);
        }
        LocalViewSize.ImageSize ve = LocalViewSize.vc().ve();
        if (ve != null) {
            messageSyncMessage.setSmallHeight(ve.height);
            messageSyncMessage.setSmallWidth(ve.width);
        }
        messageSyncMessage.setSyncTypeString(String.valueOf(i));
        return messageSyncMessage;
    }

    public void d(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public synchronized void a(long j, long j2, long j3, boolean z) {
        long longValue;
        this.eft++;
        this.efy = false;
        this.efv = 1;
        this.mHandler.removeMessages(3);
        aGb().mHandler.sendMessageDelayed(aGb().mHandler.obtainMessage(3), aGb().efn);
        if (this.efw == null) {
            this.efw = new LongSparseArray<>();
            this.efw.clear();
        }
        if (this.efx == null) {
            this.efx = new LongSparseArray<>();
        }
        LongSparseArray<Long> aFJ = com.baidu.tieba.im.memorycache.b.aFy().aFJ();
        if (0 != j) {
            Long l = aFJ.get(j);
            Long l2 = this.efw.get(j);
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
                this.efw.put(j, Long.valueOf(longValue));
            }
        }
        if (this.efw != null && this.efw.size() > 0) {
            for (int i = 0; i < this.efw.size(); i++) {
                long keyAt = this.efw.keyAt(i);
                Long l3 = aFJ.get(keyAt);
                if (l3 != null && l3.longValue() > 0) {
                    this.efw.put(keyAt, l3);
                }
            }
        }
        if (!z) {
            if (j > 0 && j2 > 0) {
                if (this.efx.get(j) == null) {
                    this.efx.put(j, Long.valueOf(j2));
                } else {
                    long longValue2 = this.efx.get(j).longValue();
                    if (longValue2 > j2) {
                        j2 = longValue2;
                    }
                    this.efx.put(j, Long.valueOf(j2));
                }
            }
            int size = this.efw.size();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                long keyAt2 = this.efw.keyAt(i2);
                long longValue3 = this.efw.valueAt(i2).longValue();
                long j4 = 0;
                if (this.efx.get(keyAt2) != null) {
                    j4 = this.efx.get(keyAt2).longValue();
                }
                if (longValue3 >= j4) {
                    arrayList.add(Long.valueOf(j));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.efw.remove(((Long) it.next()).longValue());
            }
        }
        if (this.efw.size() == 0) {
            aGj();
            this.efx.clear();
        } else {
            a(this.efw, 1);
        }
    }

    public synchronized void aGg() {
        nS(2);
    }

    public synchronized void aGh() {
        nS(3);
    }

    public void aGi() {
        aFZ();
    }

    public synchronized void a(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null) {
            if (longSparseArray.size() != 0) {
                this.efy = false;
                this.efv = 4;
                this.mHandler.removeMessages(3);
                aGb().mHandler.sendMessageDelayed(aGb().mHandler.obtainMessage(3), aGb().efn);
                a(longSparseArray, 4);
            }
        }
    }

    private synchronized void nS(int i) {
        this.efy = true;
        this.efv = i;
        a((LongSparseArray<Long>) null, i);
    }

    private void nT(int i) {
        if (i == 1) {
            if (this.efr != 2) {
                this.efr = 1;
            }
        } else if (i == 3 || i == 2) {
            this.efr = 2;
        }
    }

    private void aGj() {
        this.efr = 0;
    }
}
