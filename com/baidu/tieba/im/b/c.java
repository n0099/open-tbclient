package com.baidu.tieba.im.b;

import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestUploadClientLogMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import protobuf.UploadClientLog.ClientLog;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<String, Long> bcB = new HashMap<>();
    private static final HashMap<String, Integer> bcC = new HashMap<>();
    private static final HashMap<String, Long> bcD = new HashMap<>();
    private static c bcI;
    private List<b> bcE;
    private List<a> bcF;
    private String bcG = null;
    private String bcH = null;
    private long mLastUploadTime = -1;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bcJ = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bcK = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bcL = new g(this, 202003);

    static {
        bcB.put("2g", 60L);
        bcB.put("3g", 40L);
        bcB.put("4g", 40L);
        bcB.put("wifi", 10L);
        bcC.put("2g", 10);
        bcC.put("3g", 10);
        bcC.put("4g", 10);
        bcC.put("wifi", 10);
        bcD.put("2g", 300L);
        bcD.put("3g", 60L);
        bcD.put("4g", 60L);
        bcD.put("wifi", 5L);
        bcI = null;
    }

    public String Pr() {
        return this.bcH;
    }

    public String Ps() {
        return this.bcG;
    }

    public void Pt() {
        this.bcG = null;
        this.bcH = null;
    }

    public static synchronized c Pu() {
        c cVar;
        synchronized (c.class) {
            if (bcI == null) {
                bcI = new c();
            }
            cVar = bcI;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), PH());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), PF());
    }

    public c() {
        this.bcE = null;
        this.bcF = null;
        Pv();
        h hVar = new h(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BdBaseApplication.getInst().getApp().registerReceiver(hVar, intentFilter);
        this.bcF = new ArrayList();
        this.bcE = new ArrayList();
    }

    private void Pv() {
        MessageManager.getInstance().registerListener(this.bcJ);
        MessageManager.getInstance().registerListener(this.bcK);
        MessageManager.getInstance().registerListener(this.bcL);
    }

    public void gp(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (PD() && System.currentTimeMillis() - this.mLastUploadTime > PF()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Pw() {
        return String.valueOf(j.fn());
    }

    public String Px() {
        switch (j.fm()) {
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

    public int Py() {
        return TbadkApplication.m251getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pz() {
        if (this.bcE != null && this.bcE.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bcE.size()) {
                    break;
                }
                b bVar = this.bcE.get(i2);
                if (bVar != null && !arrayList.contains(bVar)) {
                    a aVar = new a();
                    aVar.emitTime = bVar.emitTime;
                    aVar.amX = bVar.amX;
                    aVar.bcA = bVar.bcA;
                    aVar.bcz = 1;
                    arrayList.add(bVar);
                    for (int i3 = i2; i3 < this.bcE.size(); i3++) {
                        b bVar2 = this.bcE.get(i3);
                        if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.amX != null && aVar.amX != null && bVar2.amX.equals(aVar.amX) && bVar2.bcA == aVar.bcA) {
                            if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.c.a(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.c.a(aVar.emitTime, 0L)) {
                                aVar.emitTime = bVar2.emitTime;
                            }
                            aVar.bcz++;
                            arrayList.add(bVar2);
                        }
                    }
                    this.bcF.add(aVar);
                }
                i = i2 + 1;
            }
        }
        this.bcE.clear();
        if (this.bcF.size() > PG() && PC() && j.fh()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
        if (this.bcF.size() > 100 && !PD() && !PC()) {
            this.bcF.clear();
        }
    }

    public void PA() {
        if (this.bcF.size() > 0) {
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bcF) {
                builder.et = aVar.emitTime;
                builder.net = aVar.amX;
                builder.pushcnt = Integer.valueOf(aVar.bcz);
                builder.process_type = Integer.valueOf(aVar.bcA);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PB() {
        String str;
        com.baidu.tbadk.data.a PE = PE();
        return (PE == null || (str = PE.Qp) == null || !str.equals("1")) ? false : true;
    }

    private boolean PC() {
        String str;
        com.baidu.tbadk.data.a PE = PE();
        return PE == null || (str = PE.Qn.get(Px())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PD() {
        String str;
        com.baidu.tbadk.data.a PE = PE();
        return PE == null || (str = PE.Qm.get(Px())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.a PE() {
        return com.baidu.tbadk.data.a.qQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long PF() {
        String str;
        com.baidu.tbadk.data.a PE = PE();
        if (PE != null && (str = PE.Qm.get(Px())) != null && str.length() > 0) {
            long a = com.baidu.adp.lib.g.c.a(str, 0L);
            if (a > 5) {
                return a * 1000;
            }
        }
        return bcB.get(Px()).longValue() * 1000;
    }

    private int PG() {
        String str;
        int f;
        com.baidu.tbadk.data.a PE = PE();
        return (PE == null || (str = PE.Qn.get(Px())) == null || str.length() <= 0 || (f = com.baidu.adp.lib.g.c.f(str, 0)) < 5) ? bcC.get(Px()).intValue() : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long PH() {
        String str;
        int f;
        com.baidu.tbadk.data.a PE = PE();
        return (PE == null || (str = PE.Qo.get(Px())) == null || str.length() <= 0 || (f = com.baidu.adp.lib.g.c.f(str, 0)) < 5) ? bcD.get(Px()).longValue() * 1000 : f * 1000;
    }
}
