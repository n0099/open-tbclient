package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.websocketBase.v;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b bie;
    private List<GroupUpdateMessage> bik;
    private boolean bio;
    private int bif = 900000;
    private int bih = 360000;
    private int bii = this.bih;
    private boolean bij = false;
    private int bil = 0;
    private long bim = 0;
    private int bin = 0;
    private final BdUniqueId mTag = BdUniqueId.gen();
    private final Handler mHandler = new i(null);
    private final com.baidu.adp.framework.client.socket.link.g dt = new e(this);
    private final com.baidu.tieba.im.g<com.baidu.tieba.im.memorycache.a> bip = new f(this);
    private final com.baidu.adp.framework.listener.e mListener = new g(this, 0);
    private final CustomMessageListener mCustomListener = new h(this, 2001011);

    static {
        MessageManager.getInstance().registerListener(new c(2008017));
        MessageManager.getInstance().registerListener(new d(2016001));
        bie = null;
    }

    public void QU() {
        SparseArray<Long> QC;
        boolean z;
        if (this.bik != null && (QC = com.baidu.tieba.im.memorycache.c.Qs().QC()) != null) {
            Iterator<GroupUpdateMessage> it = this.bik.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                GroupUpdateMessage next = it.next();
                long lastMsgId = next.getLastMsgId();
                if (QC.get(next.getGroupId()) != null) {
                    if (QC.get(next.getGroupId()).longValue() < lastMsgId) {
                        z = true;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            this.bin = 3;
            if (z) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
            } else {
                QX().mHandler.sendMessageDelayed(QX().mHandler.obtainMessage(3), QX().bii);
            }
            this.bik = null;
        }
    }

    private void QV() {
        if (this.bij) {
            Rd();
            this.bij = false;
        }
    }

    private void QW() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(2);
    }

    public static synchronized b QX() {
        b bVar;
        synchronized (b.class) {
            if (bie == null) {
                bie = new b();
            }
            bVar = bie;
        }
        return bVar;
    }

    public void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        MessageManager.getInstance().registerListener(this.mCustomListener);
        v.uf().a(this.dt);
        MessageManager.getInstance().registerListener(1003, this.mListener);
        MessageManager.getInstance().registerListener(1001, this.mListener);
        MessageManager.getInstance().registerListener(202101, this.mListener);
        QY();
    }

    public void QY() {
        int[] socketGetMsgStratgy = TbadkCoreApplication.m255getInst().getSocketGetMsgStratgy();
        if (socketGetMsgStratgy.length == 2) {
            gh(socketGetMsgStratgy[0] * 1000);
            gi(socketGetMsgStratgy[1] * 1000);
        }
    }

    public void start() {
        this.bij = false;
    }

    public void stop() {
        this.bij = false;
        QW();
    }

    public void QZ() {
        this.bii = this.bih;
    }

    public void Ra() {
        QX().bii = QX().bif;
    }

    public void gh(int i) {
        if (i > 0) {
            this.bih = i;
        }
    }

    public void gi(int i) {
        if (i > 0) {
            this.bif = i;
        }
    }

    public synchronized void Rb() {
        if (System.currentTimeMillis() - this.bim >= 180000) {
            PushCountMessage pushCountMessage = new PushCountMessage();
            pushCountMessage.setPusherCount(this.bil);
            pushCountMessage.setUpFlowSize(m.fV().getUpFlowSize());
            pushCountMessage.setDownFlowSize(m.fV().getDownFlowSize());
            pushCountMessage.setEnterForeCount(TbadkCoreApplication.m255getInst().getEnterForeCount());
            MessageManager.getInstance().sendMessage(pushCountMessage);
            this.bim = System.currentTimeMillis();
            this.bil = 0;
            m.fV().gd();
            m.fV().gb();
            TbadkCoreApplication.m255getInst().clearEnterForeCount();
        }
    }

    public MessageSyncMessage Rc() {
        MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
        messageSyncMessage.setGroupMids(com.baidu.tieba.im.memorycache.c.Qs().QC());
        messageSyncMessage.setForTimer(this.bio);
        LocalViewSize.ImageSize oS = LocalViewSize.oQ().oS();
        if (oS != null) {
            messageSyncMessage.setWidth(oS.width);
            messageSyncMessage.setHeight(oS.height);
        }
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.oQ().getMsgSPicMaxSize();
        if (msgSPicMaxSize != null) {
            messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
            messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
        }
        String PZ = com.baidu.tieba.im.a.c.Qc().PZ();
        if (PZ == null) {
            PZ = "0";
        }
        messageSyncMessage.setNotifyMaxTime(PZ);
        String Qa = com.baidu.tieba.im.a.c.Qc().Qa();
        if (Qa == null) {
            Qa = "0";
        }
        messageSyncMessage.setNotifyMinTime(Qa);
        messageSyncMessage.setSyncTypeString(String.valueOf(this.bin));
        messageSyncMessage.setProcessType(String.valueOf(com.baidu.tieba.im.a.c.Qc().Qh()));
        return messageSyncMessage;
    }

    public synchronized void a(long j, long j2, long j3) {
        this.bil++;
        a(j, j2, j3, false, 1);
    }

    public synchronized void Rd() {
        a(0L, 0L, 0L, true, 2);
    }

    public synchronized void Re() {
        a(0L, 0L, 0L, true, 3);
    }

    public void Rf() {
        QV();
    }

    private synchronized void a(long j, long j2, long j3, boolean z, int i) {
        this.bio = z;
        this.bin = i;
        if (!z) {
            this.mHandler.removeMessages(3);
            QX().mHandler.sendMessageDelayed(QX().mHandler.obtainMessage(3), QX().bii);
        }
        this.bip.onReturnDataInUI(null);
    }
}
