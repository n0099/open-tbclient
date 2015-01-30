package com.baidu.tieba.im.a;

import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestUploadClientLogMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import protobuf.UploadClientLog.ClientLog;
/* loaded from: classes.dex */
public class c {
    private static c bhF;
    private static final HashMap<String, Long> bhx = new HashMap<>();
    private static final HashMap<String, Integer> bhy = new HashMap<>();
    private static final HashMap<String, Long> bhz = new HashMap<>();
    private List<b> bhA;
    private List<a> bhB;
    private String bhC = null;
    private String bhD = null;
    private long mLastUploadTime = -1;
    private boolean bhE = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bhG = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bhH = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bhI = new g(this, 202003);
    private final CustomMessageListener bhJ = new h(this, 2001011);

    static {
        bhx.put("2g", 60L);
        bhx.put("3g", 40L);
        bhx.put("4g", 40L);
        bhx.put("wifi", 10L);
        bhy.put("2g", 10);
        bhy.put("3g", 10);
        bhy.put("4g", 10);
        bhy.put("wifi", 10);
        bhz.put("2g", 300L);
        bhz.put("3g", 60L);
        bhz.put("4g", 60L);
        bhz.put("wifi", 5L);
        bhF = null;
    }

    public String Qv() {
        return this.bhD;
    }

    public String Qw() {
        return this.bhC;
    }

    public void Qx() {
        this.bhC = null;
        this.bhD = null;
    }

    public static synchronized c Qy() {
        c cVar;
        synchronized (c.class) {
            if (bhF == null) {
                bhF = new c();
            }
            cVar = bhF;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), QM());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), QK());
    }

    public c() {
        this.bhA = null;
        this.bhB = null;
        Qz();
        i iVar = new i(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BdBaseApplication.getInst().getApp().registerReceiver(iVar, intentFilter);
        this.bhB = new ArrayList();
        this.bhA = new ArrayList();
    }

    private void Qz() {
        MessageManager.getInstance().registerListener(this.bhG);
        MessageManager.getInstance().registerListener(this.bhH);
        MessageManager.getInstance().registerListener(this.bhI);
        MessageManager.getInstance().registerListener(this.bhJ);
    }

    public void QA() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void gV(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (QI() && System.currentTimeMillis() - this.mLastUploadTime > QK()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String QB() {
        return String.valueOf(com.baidu.adp.lib.util.i.fk());
    }

    public String QC() {
        switch (com.baidu.adp.lib.util.i.fk()) {
            case 1:
                return "wifi";
            case 2:
                return "2g";
            case 3:
                return "3g";
            case 4:
                return "4g";
            default:
                return "2g";
        }
    }

    public int QD() {
        return TbadkCoreApplication.m255getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QE() {
        if (!this.bhE) {
            if (this.bhA != null && this.bhA.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bhA.size()) {
                        break;
                    }
                    b bVar = this.bhA.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bhv = bVar.bhv;
                        aVar.bhw = bVar.bhw;
                        aVar.bhu = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bhA.size(); i3++) {
                            b bVar2 = this.bhA.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bhv != null && aVar.bhv != null && bVar2.bhv.equals(aVar.bhv) && bVar2.bhw == aVar.bhw) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.c.a(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.c.a(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bhu++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bhB.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bhA.clear();
            if (this.bhB.size() > QL() && QH() && com.baidu.adp.lib.util.i.ff()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bhB.size() > 100 && !QI() && !QH()) {
                this.bhB.clear();
            }
        }
    }

    public void QF() {
        if (this.bhB.size() > 0) {
            this.bhE = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bhB) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bhv;
                builder.pushcnt = Integer.valueOf(aVar.bhu);
                builder.process_type = Integer.valueOf(aVar.bhw);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QG() {
        String str;
        com.baidu.tbadk.data.c QJ = QJ();
        return (QJ == null || (str = QJ.WS) == null || !str.equals("1")) ? false : true;
    }

    private boolean QH() {
        String str;
        com.baidu.tbadk.data.c QJ = QJ();
        return QJ == null || (str = QJ.WQ.get(QC())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QI() {
        String str;
        com.baidu.tbadk.data.c QJ = QJ();
        return QJ == null || (str = QJ.WP.get(QC())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c QJ() {
        return com.baidu.tbadk.data.c.uF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long QK() {
        String str;
        com.baidu.tbadk.data.c QJ = QJ();
        if (QJ != null && (str = QJ.WP.get(QC())) != null && str.length() > 0) {
            long a = com.baidu.adp.lib.g.c.a(str, 0L);
            if (a > 2) {
                return a * 1000;
            }
        }
        return bhx.get(QC()).longValue() * 1000;
    }

    private int QL() {
        String str;
        int i;
        com.baidu.tbadk.data.c QJ = QJ();
        return (QJ == null || (str = QJ.WQ.get(QC())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? bhy.get(QC()).intValue() : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long QM() {
        String str;
        int i;
        com.baidu.tbadk.data.c QJ = QJ();
        return (QJ == null || (str = QJ.WR.get(QC())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? bhz.get(QC()).longValue() * 1000 : i * 1000;
    }
}
