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
    private static c bhE;
    private static final HashMap<String, Long> bhw = new HashMap<>();
    private static final HashMap<String, Integer> bhx = new HashMap<>();
    private static final HashMap<String, Long> bhy = new HashMap<>();
    private List<a> bhA;
    private List<b> bhz;
    private String bhB = null;
    private String bhC = null;
    private long mLastUploadTime = -1;
    private boolean bhD = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bhF = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bhG = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bhH = new g(this, 202003);
    private final CustomMessageListener bhI = new h(this, 2001011);

    static {
        bhw.put("2g", 60L);
        bhw.put("3g", 40L);
        bhw.put("4g", 40L);
        bhw.put("wifi", 10L);
        bhx.put("2g", 10);
        bhx.put("3g", 10);
        bhx.put("4g", 10);
        bhx.put("wifi", 10);
        bhy.put("2g", 300L);
        bhy.put("3g", 60L);
        bhy.put("4g", 60L);
        bhy.put("wifi", 5L);
        bhE = null;
    }

    public String Qq() {
        return this.bhC;
    }

    public String Qr() {
        return this.bhB;
    }

    public void Qs() {
        this.bhB = null;
        this.bhC = null;
    }

    public static synchronized c Qt() {
        c cVar;
        synchronized (c.class) {
            if (bhE == null) {
                bhE = new c();
            }
            cVar = bhE;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), QH());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), QF());
    }

    public c() {
        this.bhz = null;
        this.bhA = null;
        Qu();
        i iVar = new i(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            BdBaseApplication.getInst().getApp().registerReceiver(iVar, intentFilter);
        } catch (Exception e) {
        }
        this.bhA = new ArrayList();
        this.bhz = new ArrayList();
    }

    private void Qu() {
        MessageManager.getInstance().registerListener(this.bhF);
        MessageManager.getInstance().registerListener(this.bhG);
        MessageManager.getInstance().registerListener(this.bhH);
        MessageManager.getInstance().registerListener(this.bhI);
    }

    public void Qv() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void gS(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (QD() && System.currentTimeMillis() - this.mLastUploadTime > QF()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Qw() {
        return String.valueOf(com.baidu.adp.lib.util.i.fk());
    }

    public String Qx() {
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

    public int Qy() {
        return TbadkCoreApplication.m255getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qz() {
        if (!this.bhD) {
            if (this.bhz != null && this.bhz.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bhz.size()) {
                        break;
                    }
                    b bVar = this.bhz.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bhu = bVar.bhu;
                        aVar.bhv = bVar.bhv;
                        aVar.bht = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bhz.size(); i3++) {
                            b bVar2 = this.bhz.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bhu != null && aVar.bhu != null && bVar2.bhu.equals(aVar.bhu) && bVar2.bhv == aVar.bhv) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.c.a(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.c.a(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.bht++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bhA.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bhz.clear();
            if (this.bhA.size() > QG() && QC() && com.baidu.adp.lib.util.i.ff()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bhA.size() > 100 && !QD() && !QC()) {
                this.bhA.clear();
            }
        }
    }

    public void QA() {
        if (this.bhA.size() > 0) {
            this.bhD = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bhA) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bhu;
                builder.pushcnt = Integer.valueOf(aVar.bht);
                builder.process_type = Integer.valueOf(aVar.bhv);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QB() {
        String str;
        com.baidu.tbadk.data.c QE = QE();
        return (QE == null || (str = QE.WP) == null || !str.equals("1")) ? false : true;
    }

    private boolean QC() {
        String str;
        com.baidu.tbadk.data.c QE = QE();
        return QE == null || (str = QE.WN.get(Qx())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QD() {
        String str;
        com.baidu.tbadk.data.c QE = QE();
        return QE == null || (str = QE.WM.get(Qx())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c QE() {
        return com.baidu.tbadk.data.c.uz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long QF() {
        String str;
        com.baidu.tbadk.data.c QE = QE();
        if (QE != null && (str = QE.WM.get(Qx())) != null && str.length() > 0) {
            long a = com.baidu.adp.lib.g.c.a(str, 0L);
            if (a > 2) {
                return a * 1000;
            }
        }
        return bhw.get(Qx()).longValue() * 1000;
    }

    private int QG() {
        String str;
        int i;
        com.baidu.tbadk.data.c QE = QE();
        return (QE == null || (str = QE.WN.get(Qx())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? bhx.get(Qx()).intValue() : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long QH() {
        String str;
        int i;
        com.baidu.tbadk.data.c QE = QE();
        return (QE == null || (str = QE.WO.get(Qx())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? bhy.get(Qx()).longValue() * 1000 : i * 1000;
    }
}
