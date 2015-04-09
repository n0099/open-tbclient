package com.baidu.tieba.im.a;

import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestUploadClientLogMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import protobuf.UploadClientLog.ClientLog;
/* loaded from: classes.dex */
public class c {
    private static final HashMap<String, Long> bjc = new HashMap<>();
    private static final HashMap<String, Integer> bjd = new HashMap<>();
    private static final HashMap<String, Long> bje = new HashMap<>();
    private static c bjk;
    private List<b> bjf;
    private List<a> bjg;
    private String bjh = null;
    private String bji = null;
    private long mLastUploadTime = -1;
    private boolean bjj = false;
    private final Handler mHandler = new d(this);
    private com.baidu.adp.framework.listener.e bjl = new e(this, 202006);
    private final com.baidu.adp.framework.listener.e bjm = new f(this, 202005);
    private final com.baidu.adp.framework.listener.e bjn = new g(this, 202003);
    private final CustomMessageListener bjo = new h(this, 2001011);

    static {
        bjc.put("2g", 60L);
        bjc.put("3g", 40L);
        bjc.put("4g", 40L);
        bjc.put("wifi", 10L);
        bjd.put("2g", 10);
        bjd.put("3g", 10);
        bjd.put("4g", 10);
        bjd.put("wifi", 10);
        bje.put("2g", 300L);
        bje.put("3g", 60L);
        bje.put("4g", 60L);
        bje.put("wifi", 5L);
        bjk = null;
    }

    public String RX() {
        return this.bji;
    }

    public String RY() {
        return this.bjh;
    }

    public void RZ() {
        this.bjh = null;
        this.bji = null;
    }

    public static synchronized c Sa() {
        c cVar;
        synchronized (c.class) {
            if (bjk == null) {
                bjk = new c();
            }
            cVar = bjk;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), So());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), Sm());
    }

    public c() {
        this.bjf = null;
        this.bjg = null;
        Sb();
        i iVar = new i(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BdBaseApplication.getInst().getApp().registerReceiver(iVar, intentFilter);
        this.bjg = new ArrayList();
        this.bjf = new ArrayList();
    }

    private void Sb() {
        MessageManager.getInstance().registerListener(this.bjl);
        MessageManager.getInstance().registerListener(this.bjm);
        MessageManager.getInstance().registerListener(this.bjn);
        MessageManager.getInstance().registerListener(this.bjo);
    }

    public void Sc() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void gL(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (Sk() && System.currentTimeMillis() - this.mLastUploadTime > Sm()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String Sd() {
        return String.valueOf(k.iM());
    }

    public String Se() {
        switch (k.iM()) {
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

    public int Sf() {
        return TbadkCoreApplication.m411getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sg() {
        if (!this.bjj) {
            if (this.bjf != null && this.bjf.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.bjf.size()) {
                        break;
                    }
                    b bVar = this.bjf.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.bja = bVar.bja;
                        aVar.bjb = bVar.bjb;
                        aVar.biZ = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.bjf.size(); i3++) {
                            b bVar2 = this.bjf.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.bja != null && aVar.bja != null && bVar2.bja.equals(aVar.bja) && bVar2.bjb == aVar.bjb) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.c.a(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.c.a(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.biZ++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.bjg.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bjf.clear();
            if (this.bjg.size() > Sn() && Sj() && k.iH()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.bjg.size() > 100 && !Sk() && !Sj()) {
                this.bjg.clear();
            }
        }
    }

    public void Sh() {
        if (this.bjg.size() > 0) {
            this.bjj = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.bjg) {
                builder.et = aVar.emitTime;
                builder.net = aVar.bja;
                builder.pushcnt = Integer.valueOf(aVar.biZ);
                builder.process_type = Integer.valueOf(aVar.bjb);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Si() {
        String str;
        com.baidu.tbadk.data.c Sl = Sl();
        return (Sl == null || (str = Sl.ahd) == null || !str.equals("1")) ? false : true;
    }

    private boolean Sj() {
        String str;
        com.baidu.tbadk.data.c Sl = Sl();
        return Sl == null || (str = Sl.ahb.get(Se())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sk() {
        String str;
        com.baidu.tbadk.data.c Sl = Sl();
        return Sl == null || (str = Sl.aha.get(Se())) == null || !str.equals("-1");
    }

    private com.baidu.tbadk.data.c Sl() {
        return com.baidu.tbadk.data.c.xV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long Sm() {
        String str;
        com.baidu.tbadk.data.c Sl = Sl();
        if (Sl != null && (str = Sl.aha.get(Se())) != null && str.length() > 0) {
            long a = com.baidu.adp.lib.g.c.a(str, 0L);
            if (a > 2) {
                return a * 1000;
            }
        }
        return bjc.get(Se()).longValue() * 1000;
    }

    private int Sn() {
        String str;
        int i;
        com.baidu.tbadk.data.c Sl = Sl();
        return (Sl == null || (str = Sl.ahb.get(Se())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? bjd.get(Se()).intValue() : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long So() {
        String str;
        int i;
        com.baidu.tbadk.data.c Sl = Sl();
        return (Sl == null || (str = Sl.ahc.get(Se())) == null || str.length() <= 0 || (i = com.baidu.adp.lib.g.c.toInt(str, 0)) < 2) ? bje.get(Se()).longValue() * 1000 : i * 1000;
    }
}
