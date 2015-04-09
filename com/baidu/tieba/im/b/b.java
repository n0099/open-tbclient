package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.webSocket.l;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.websocketBase.v;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.performanceLog.ab;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b bkY;
    private List<GroupUpdateMessage> blg;
    private boolean bll;
    private int bkZ = 900000;
    private int bla = 360000;
    private int blb = this.bla;
    private final int blc = 0;
    private final int bld = 1;
    private final int ble = 2;
    private int blf = 0;
    private int blh = 0;
    private long bli = 0;
    private int blj = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new i(null);
    private SparseArray<Long> blk = null;
    private final com.baidu.adp.framework.client.socket.link.g oI = new e(this);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 0);
    private final CustomMessageListener mCustomListener = new g(this, 2001011);
    private final CustomMessageListener blm = new h(this, 2005016);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016001));
        bkY = null;
    }

    private final void a(SparseArray<Long> sparseArray, int i) {
        if (MessageManager.getInstance().getSocketClient().ev() > 10) {
            ab.a(false, true, false);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 2000L);
            return;
        }
        boolean a = MessageManager.getInstance().getSocketClient().a(202003, this.mTag);
        int w = MessageManager.getInstance().getSocketClient().w(202003);
        if (a || w > 0) {
            ab.a(false, false, true);
            gi(i);
            return;
        }
        Ta();
        SparseArray<Long> sparseArray2 = null;
        if (sparseArray != null && sparseArray.size() > 0) {
            SparseArray<Long> sparseArray3 = new SparseArray<>();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                sparseArray3.put(keyAt, sparseArray.get(keyAt));
            }
            sparseArray2 = sparseArray3;
        }
        MessageManager.getInstance().sendMessage(c(sparseArray2));
        ab.a(true, false, false);
        if ((i == 3 || i == 1 || i == 2) && this.blk != null) {
            this.blk.clear();
        }
    }

    public void SP() {
        boolean z;
        if (this.blg != null) {
            SparseArray<Long> SA = com.baidu.tieba.im.memorycache.c.Sq().SA();
            if (SA == null) {
                this.blg = null;
                return;
            }
            Iterator<GroupUpdateMessage> it = this.blg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                if (next != null && SA.get(next.getGroupId()) != null) {
                    if (SA.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                        z = true;
                        break;
                    }
                }
            }
            this.blj = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                SS().mHandler.sendMessageDelayed(SS().mHandler.obtainMessage(3), SS().blb);
            }
            this.blg = null;
        }
    }

    private void SQ() {
        if (this.blf != 0) {
            if (this.blf == 1) {
                a(0L, 0L, 0L, 0);
            } else {
                SX();
            }
        }
    }

    private void SR() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b SS() {
        b bVar;
        synchronized (b.class) {
            if (bkY == null) {
                bkY = new b();
            }
            bVar = bkY;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        MessageManager.getInstance().registerListener(this.blm);
        v.xN().a(this.oI);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        ST();
    }

    public void ST() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m411getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            gf(socketGetMsgStratgy[0] * 1000);
            gg(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        Ta();
    }

    public void stop() {
        Ta();
        SR();
    }

    public void SU() {
        this.blb = this.bla;
    }

    public void SV() {
        SS().blb = SS().bkZ;
    }

    public void gf(int i) {
        if (i > 0) {
            this.bla = i;
        }
    }

    public void gg(int i) {
        if (i > 0) {
            this.bkZ = i;
        }
    }

    public synchronized void SW() {
        if (System.currentTimeMillis() - this.bli >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.blh);
            pushCountMessage.setUpFlowSize(l.jr().getUpFlowSize());
            pushCountMessage.setDownFlowSize(l.jr().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m411getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bli = System.currentTimeMillis();
            this.blh = 0;
            l.jr().jy();
            l.jr().jx();
            TbadkCoreApplication.m411getInst().clearEnterForeCount();
        }
    }

    private MessageSyncMessage c(SparseArray<Long> sparseArray) {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setTag(this.mTag);
        if (sparseArray != null && sparseArray.size() > 0) {
            messageSyncMessage.setGroupMids(sparseArray);
        } else {
            messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.Sq().SA());
        }
        messageSyncMessage.setForTimer(this.bll);
        LocalViewSize.ImageSize sl = LocalViewSize.sj().sl();
        if (sl != null) {
            messageSyncMessage.setWidth(sl.width);
            messageSyncMessage.setHeight(sl.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.sj().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String RX = com.baidu.tieba.im.a.c.Sa().RX();
        if (RX == null) {
            RX = GameInfoData.NOT_FROM_DETAIL;
        }
        messageSyncMessage.setNotifyMaxTime(RX);
        String RY = com.baidu.tieba.im.a.c.Sa().RY();
        if (RY == null) {
            RY = GameInfoData.NOT_FROM_DETAIL;
        }
        messageSyncMessage.setNotifyMinTime(RY);
        messageSyncMessage.setSyncTypeString(String.valueOf(this.blj));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.Sa().Sf()));
        return messageSyncMessage;
    }

    public synchronized void a(long j, long j2, long j3, int i) {
        int i2;
        Long l;
        this.blh++;
        this.bll = false;
        this.blj = 1;
        this.mHandler.removeMessages(3);
        SS().mHandler.sendMessageDelayed(SS().mHandler.obtainMessage(3), SS().blb);
        if (this.blk == null) {
            this.blk = new SparseArray<>();
            this.blk.clear();
        }
        SparseArray<Long> SA = com.baidu.tieba.im.memorycache.c.Sq().SA();
        if (0 != j) {
            Long l2 = SA.get((int) j);
            Long l3 = this.blk.get((int) j);
            if (l2 == null) {
                if (l3 != null && l3.longValue() < j2) {
                    j2 = l3.longValue();
                }
            } else {
                j2 = l2.longValue();
            }
            if (j2 > 0) {
                this.blk.put((int) j, Long.valueOf(j2));
            }
        }
        if (this.blk != null && this.blk.size() > 0) {
            for (int i3 = 0; i3 < this.blk.size(); i3++) {
                int keyAt = this.blk.keyAt(i3);
                Long l4 = SA.get(keyAt);
                if (l4 != null && l4.longValue() > 0) {
                    this.blk.put(keyAt, l4);
                }
            }
        }
        if ((i == 0 || i == 9) && (i2 = com.baidu.adp.lib.g.c.toInt(com.baidu.tieba.im.pushNotify.d.Tl().Tn(), 0)) != 0 && (l = SA.get(i2)) != null) {
            this.blk.put(i2, l);
        }
        a(this.blk, 1);
    }

    public synchronized void SX() {
        gh(2);
    }

    public synchronized void SY() {
        gh(3);
    }

    public void SZ() {
        SQ();
    }

    public synchronized void d(SparseArray<Long> sparseArray) {
        if (sparseArray != null) {
            if (sparseArray.size() != 0) {
                this.bll = false;
                this.blj = 4;
                this.mHandler.removeMessages(3);
                SS().mHandler.sendMessageDelayed(SS().mHandler.obtainMessage(3), SS().blb);
                a(sparseArray, 4);
            }
        }
    }

    private synchronized void gh(int i) {
        this.bll = true;
        this.blj = i;
        a((SparseArray<Long>) null, i);
    }

    private void gi(int i) {
        if (i == 1) {
            if (this.blf != 2) {
                this.blf = 1;
            }
        } else if (i == 3 || i == 2) {
            this.blf = 2;
        }
    }

    private void Ta() {
        this.blf = 0;
    }
}
