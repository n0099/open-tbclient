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
    private static final HashMap<String, Long> bcP = new HashMap<>();
    private static final HashMap<String, Integer> bcQ = new HashMap<>();
    private static final HashMap<String, Long> bcR = new HashMap<>();
    private static c bcW;
    private List<b> bcS;
    private List<a> bcT;
    private String bcU = null;
    private String bcV = null;
    private long mLastUploadTime = -1;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bcX = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bcY = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bcZ = new g(this, 202003);

    static {
        bcP.put("2g", 60L);
        bcP.put("3g", 40L);
        bcP.put("4g", 40L);
        bcP.put("wifi", 10L);
        bcQ.put("2g", 10);
        bcQ.put("3g", 10);
        bcQ.put("4g", 10);
        bcQ.put("wifi", 10);
        bcR.put("2g", 300L);
        bcR.put("3g", 60L);
        bcR.put("4g", 60L);
        bcR.put("wifi", 5L);
        bcW = null;
    }

    public String Pu() {
        return this.bcV;
    }

    public String Pv() {
        return this.bcU;
    }

    public void Pw() {
        this.bcU = null;
        this.bcV = null;
    }

    public static synchronized c Px() {
        c cVar;
        synchronized (c.class) {
            if (bcW == null) {
                bcW = new c();
            }
            cVar = bcW;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), PK());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), PI());
    }

    public c() {
        this.bcS = null;
        this.bcT = null;
        Py();
        h hVar = new h(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BdBaseApplication.getInst().getApp().registerReceiver(hVar, intentFilter);
        this.bcT = new ArrayList();
        this.bcS = new ArrayList();
    }

    private void Py() {
        MessageManager.getInstance().registerListener(this.bcX);
        MessageManager.getInstance().registerListener(this.bcY);
        MessageManager.getInstance().registerListener(this.bcZ);
    }

    public void gp(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (PG() && System.currentTimeMillis() - this.mLastUploadTime > PI()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Pz() {
        return String.valueOf(j.fm());
    }

    public String PA() {
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

    public int PB() {
        return TbadkApplication.m251getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PC() {
        if (this.bcS != null && this.bcS.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bcS.size()) {
                    break;
                }
                b bVar = this.bcS.get(i2);
                if (bVar != null && !arrayList.contains(bVar)) {
                    a aVar = new a();
                    aVar.emitTime = bVar.emitTime;
                    aVar.ang = bVar.ang;
                    aVar.bcO = bVar.bcO;
                    aVar.bcN = 1;
                    arrayList.add(bVar);
                    for (int i3 = i2; i3 < this.bcS.size(); i3++) {
                        b bVar2 = this.bcS.get(i3);
                        if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.ang != null && aVar.ang != null && bVar2.ang.equals(aVar.ang) && bVar2.bcO == aVar.bcO) {
                            if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.c.a(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.c.a(aVar.emitTime, 0L)) {
                                aVar.emitTime = bVar2.emitTime;
                            }
                            aVar.bcN++;
                            arrayList.add(bVar2);
                        }
                    }
                    this.bcT.add(aVar);
                }
                i = i2 + 1;
            }
        }
        this.bcS.clear();
        if (this.bcT.size() > PJ() && PF() && j.fh()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
        if (this.bcT.size() > 100 && !PG() && !PF()) {
            this.bcT.clear();
        }
    }

    public void PD() {
        if (this.bcT.size() > 0) {
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bcT) {
                builder.et = aVar.emitTime;
                builder.net = aVar.ang;
                builder.pushcnt = Integer.valueOf(aVar.bcN);
                builder.process_type = Integer.valueOf(aVar.bcO);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PE() {
        String str;
        com.baidu.tbadk.data.a PH = PH();
        return (PH == null || (str = PH.Qt) == null || !str.equals("1")) ? false : true;
    }

    private boolean PF() {
        String str;
        com.baidu.tbadk.data.a PH = PH();
        return PH == null || (str = PH.Qr.get(PA())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PG() {
        String str;
        com.baidu.tbadk.data.a PH = PH();
        return PH == null || (str = PH.Qq.get(PA())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.a PH() {
        return com.baidu.tbadk.data.a.qS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long PI() {
        String str;
        com.baidu.tbadk.data.a PH = PH();
        if (PH != null && (str = PH.Qq.get(PA())) != null && str.length() > 0) {
            long a = com.baidu.adp.lib.g.c.a(str, 0L);
            if (a > 2) {
                return a * 1000;
            }
        }
        return bcP.get(PA()).longValue() * 1000;
    }

    private int PJ() {
        String str;
        int f;
        com.baidu.tbadk.data.a PH = PH();
        return (PH == null || (str = PH.Qr.get(PA())) == null || str.length() <= 0 || (f = com.baidu.adp.lib.g.c.f(str, 0)) < 2) ? bcQ.get(PA()).intValue() : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long PK() {
        String str;
        int f;
        com.baidu.tbadk.data.a PH = PH();
        return (PH == null || (str = PH.Qs.get(PA())) == null || str.length() <= 0 || (f = com.baidu.adp.lib.g.c.f(str, 0)) < 2) ? bcR.get(PA()).longValue() * 1000 : f * 1000;
    }
}
